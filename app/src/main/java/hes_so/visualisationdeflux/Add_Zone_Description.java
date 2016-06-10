package hes_so.visualisationdeflux;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Add_Zone_Description extends AppCompatActivity {

    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_zone_description);

        name = (EditText) findViewById(R.id.name);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Click action
                if(name.getText().length() != 0) {
                    Intent intent = new Intent(Add_Zone_Description.this, Add_Zone_Map.class);
                    startActivity(intent);
                }
            }
        });



        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
       // spinner.setOnItemSelectedListener(this);


    // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Minute");
        categories.add("Heures");
        categories.add("Jours");
        categories.add("Semaines");
        categories.add("Mois");
        categories.add("Année");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main7, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_logOut:
                logout();
                return true;



            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /**
     * Launching new activity
     * */
    private void logout() {
        Intent i = new Intent(Add_Zone_Description.this, Accuiel.class);
        startActivity(i);
    }
}
