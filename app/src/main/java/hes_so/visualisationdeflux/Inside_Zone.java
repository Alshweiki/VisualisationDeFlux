package hes_so.visualisationdeflux;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import Classes.Zone;


public class Inside_Zone extends Fragment {
    Zone zone;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        int zoneId = savedInstanceState.getInt("zoneid");
        // Inflate the layout for this fragment
        View view =
         inflater.inflate(
                R.layout.fragment_inside__zone, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);
        // Create and populate a List of planet names.
        String[] zone_messages = new String[] { "Manifistation Prof"};

        ArrayList<String> messages_List = new ArrayList<String>();
        messages_List.addAll(Arrays.asList(zone_messages));

        // Create ArrayAdapter using the planet list.
        ArrayAdapter listAdapter = new ArrayAdapter<String>(view.getContext(), R.layout.zone_messages, messages_List);
        listAdapter.add("Manifistation Etudiants");


        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(view.getContext(), Details_Alerte.class);
                startActivity(intent);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Click action
                Intent intent = new Intent(view.getContext(), Nouveau_message.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
