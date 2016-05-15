package hes_so.visualisationdeflux;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        ListView listView = (ListView) findViewById(R.id.listView);
        // Create and populate a List of planet names.
        String[] zone_messages = new String[] { "Manifistation Prof"};

        ArrayList<String> messages_List = new ArrayList<String>();
        messages_List.addAll(Arrays.asList(zone_messages));

        // Create ArrayAdapter using the planet list.
        ArrayAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.zone_messages, messages_List);
        listAdapter.add("Manifistation Etudiants");


        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(Accueil.this, Details_Alerte.class);
                startActivity(intent);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Click action
                Intent intent = new Intent(Accueil.this, Nouveau_message.class);
                startActivity(intent);
            }
        });


        //setTitle("Gare");

        if(false) {
            listView.setVisibility(View.GONE);
            fab.setVisibility(View.GONE);
            ImageView warning = (ImageView) findViewById(R.id.imageView);
            warning.setImageResource(R.drawable.warning_1);
            setTitle("Aucune Zone");
        }else
        {
            listView.setVisibility(View.VISIBLE);
            TextView warningText = (TextView) findViewById(R.id.textView6);
            warningText.setVisibility(View.GONE);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_login:
                logIn();
                return true;
            case R.id.action_settings:
                setting();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Launching new activity
     * */
    private void logIn() {
        Intent i = new Intent(Accueil.this, LogIn.class);
        startActivity(i);
    }

    private void setting(){
        Intent i = new Intent(Accueil.this, Info.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
