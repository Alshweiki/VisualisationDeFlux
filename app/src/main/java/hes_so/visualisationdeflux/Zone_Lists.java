package hes_so.visualisationdeflux;

//import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Classes.Zone;
import Classes.Zones;

// In this case, the fragment displays simple text based on the page
public class Zone_Lists extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    ArrayAdapter listAdapter;
    ListView listViewStatique;
    ArrayAdapter listAdapter2;
    String[] zone_Statique;
    RequestQueue queue;
    private int mPage;


    public static Zone_Lists newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Zone_Lists fragment = new Zone_Lists();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zone__lists, container, false);
        queue = Volley.newRequestQueue(view.getContext());

        //TextView textView = (TextView) view;
        //textView.setText("Fragment #" + mPage);

        ListView listViewDynamique = (ListView) view.findViewById(R.id.listViewDinamique);
        String[] zone_Dynamique = new String[]{};

        ArrayList<String> Zone_Dynamiqeu_List = new ArrayList<String>();
        Zone_Dynamiqeu_List.addAll(Arrays.asList(zone_Dynamique));

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(view.getContext(), R.layout.zone_list, Zone_Dynamiqeu_List);
       /* listAdapter.add("Coop");
        listAdapter.add("Coop");
        listAdapter.add("Coop");listAdapter.add("Coop");
        listAdapter.add("Coop");
        listAdapter.add("Coop");listAdapter.add("Coop");
        listAdapter.add("Coop");
        listAdapter.add("Coop");
*/
        Toast.makeText(getContext(),
                "test",
                Toast.LENGTH_LONG).show();

        String url ="http://iuam.tk/api/zones";
        final StringRequest zonepos = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        List<Zone> zones = gson.fromJson(response,new TypeToken<List<Zone>>(){}.getType());

                      //  Toast.makeText(getContext(),
                        //        zones.size(),
                        //        Toast.LENGTH_LONG).show();

                        for(int i = 0;i<zones.size();i++) {
                            if(zones.get(i).getType().toString().equals("dynamic"))
                                listAdapter.add(zones.get(i).getName());
                            else
                                listAdapter2.add(zones.get(i).getName());
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),
                        error.toString() ,
                        Toast.LENGTH_LONG).show();
            }
        });

        listViewDynamique.setAdapter(listAdapter);

        listViewDynamique.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getContext(), Flow_details.class);
                intent.putExtra("TypeOfZone", "dynamique");
                startActivity(intent);
            }
        });


        listViewStatique = (ListView) view.findViewById(R.id.listViewStatique);
       zone_Statique = new String[] { };

        ArrayList<String> Zone_Statique_List = new ArrayList<String>();
        Zone_Statique_List.addAll(Arrays.asList(zone_Statique));

        // Create ArrayAdapter using the planet list.
        listAdapter2 = new ArrayAdapter<String>(view.getContext(), R.layout.zone_messages, Zone_Statique_List);


        listViewStatique.setAdapter(listAdapter2);

        listViewStatique.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getContext(), Flow_details.class);
                intent.putExtra("TypeOfZone", "statique");
                startActivity(intent);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Click action
                Intent intent = new Intent(getContext(), Add_Zone_Description.class);
                startActivity(intent);
            }
        });

        queue.add(zonepos);
        return view;
    }


}


