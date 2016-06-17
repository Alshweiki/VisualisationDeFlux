package hes_so.visualisationdeflux;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

import Classes.Message;
import Classes.MessageAdapter;
import Classes.Zone;


public class Inside_Zone extends Fragment {
    RequestQueue queue;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        int zoneId = this.getArguments().getInt("zoneid");
        // Inflate the layout for this fragment
        View view =
         inflater.inflate(
                R.layout.fragment_inside__zone, container, false);
        queue = Volley.newRequestQueue(this.getContext());

        final ListView listView = (ListView) view.findViewById(R.id.listView);

        String url ="http://iuam.tk/api/messages/"+zoneId;
        final StringRequest zonepos = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        ArrayList<Message> messages=gson.fromJson(response, new TypeToken<ArrayList<Message>>(){}.getType());
                        MessageAdapter sizeArrayAdapter = new MessageAdapter(getActivity(), messages);
                        listView.setAdapter(sizeArrayAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            public void onItemClick(AdapterView<?> parent, View view,
                                                    int position, long id) {
                                Message m = (Message) listView.getAdapter().getItem(position);
                                Intent intent = new Intent(view.getContext(), Details_Alerte.class);
                                intent.putExtra("subject",m.getSubject());
                                intent.putExtra("content", m.getContent());
                                startActivity(intent);
                            }
                        });
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(zonepos);



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
