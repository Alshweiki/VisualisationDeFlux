package hes_so.visualisationdeflux;

//import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

// In this case, the fragment displays simple text based on the page
public class Zone_Lists extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

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
        //TextView textView = (TextView) view;
        //textView.setText("Fragment #" + mPage);

        ListView listViewDynamique = (ListView) view.findViewById(R.id.listViewDinamique);
        String[] zone_Dynamique = new String[] { "Gare"};

        ArrayList<String> Zone_Dynamiqeu_List = new ArrayList<String>();
        Zone_Dynamiqeu_List.addAll(Arrays.asList(zone_Dynamique));

        // Create ArrayAdapter using the planet list.
        ArrayAdapter listAdapter = new ArrayAdapter<String>(view.getContext(), R.layout.zone_list, Zone_Dynamiqeu_List);
        listAdapter.add("Coop");
        listAdapter.add("Coop");
        listAdapter.add("Coop");listAdapter.add("Coop");
        listAdapter.add("Coop");
        listAdapter.add("Coop");listAdapter.add("Coop");
        listAdapter.add("Coop");
        listAdapter.add("Coop");



        listViewDynamique.setAdapter(listAdapter);

        listViewDynamique.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getContext(), Flow_details.class);
                startActivity(intent);
            }
        });


        ListView listViewStatique = (ListView) view.findViewById(R.id.listViewStatique);
        String[] zone_Statique = new String[] { "Quartier Vert"};

        ArrayList<String> Zone_Statique_List = new ArrayList<String>();
        Zone_Statique_List.addAll(Arrays.asList(zone_Statique));

        // Create ArrayAdapter using the planet list.
        ArrayAdapter listAdapter2 = new ArrayAdapter<String>(view.getContext(), R.layout.zone_messages, Zone_Statique_List);


        listViewStatique.setAdapter(listAdapter2);

        listViewStatique.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                 Intent intent = new Intent(getContext(), Flow_details.class);
                startActivity(intent);
            }
        });



        return view;
    }


}


