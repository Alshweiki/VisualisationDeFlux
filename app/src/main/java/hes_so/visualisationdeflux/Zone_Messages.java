package hes_so.visualisationdeflux;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Classes.Message;
import Classes.Zone;


// In this case, the fragment displays simple text based on the page
public class Zone_Messages extends android.support.v4.app.Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    RequestQueue queue;
    ArrayAdapter listAdapter;

    private int mPage;


    public static Zone_Messages newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Zone_Messages fragment = new Zone_Messages();
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
        View view = inflater.inflate(R.layout.fragment_zone__messages, container, false);
        //TextView textView = (TextView) view;
        //textView.setText("Fragment #" + mPage);

        queue = Volley.newRequestQueue(view.getContext());

        ListView listView = (ListView) view.findViewById(R.id.listView2);
        // Create and populate a List of planet names.
        String[] zone_messages = new String[] {};
        ArrayList<String> messages_List = new ArrayList<String>();
        messages_List.addAll(Arrays.asList(zone_messages));


        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(view.getContext(), R.layout.zone_messages, messages_List);
       // listAdapter.add("Barrière cassée");


        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getContext(), New_Alerte_Admin.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Click action
                Intent intent = new Intent(getContext(), Push_alerte.class);
                startActivity(intent);
            }
        });



        String url ="http://iuam.tk/api/messages/22";
        final StringRequest zonepos = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        List<Message> messages = gson.fromJson(response,new TypeToken<List<Message>>(){}.getType());

                        //  Toast.makeText(getContext(),
                        //        zones.size(),
                        //        Toast.LENGTH_LONG).show();

                        for(int i=0;i<messages.size();i++)

                        listAdapter.add(messages.get(i).getSubject());


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),
                        error.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });

        queue.add(zonepos);
        return view;
    }


}