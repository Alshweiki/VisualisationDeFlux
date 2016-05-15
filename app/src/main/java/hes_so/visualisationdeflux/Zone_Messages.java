package hes_so.visualisationdeflux;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


// In this case, the fragment displays simple text based on the page
public class Zone_Messages extends android.support.v4.app.Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

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



        ListView listView = (ListView) view.findViewById(R.id.listView2);
        // Create and populate a List of planet names.
        String[] zone_messages = new String[] { "Barrière cassée"};
        ArrayList<String> messages_List = new ArrayList<String>();
        messages_List.addAll(Arrays.asList(zone_messages));


        // Create ArrayAdapter using the planet list.
        ArrayAdapter listAdapter = new ArrayAdapter<String>(view.getContext(), R.layout.zone_messages, messages_List);
        listAdapter.add("Barrière cassée");


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

        return view;
    }


}