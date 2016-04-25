package hes_so.visualisationdeflux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Button login_button = (Button) findViewById(R.id.btnLogin);
        login_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if(true)
                {
                    Intent i = new Intent(Main5Activity.this, Main6Activity.class);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main5, menu);
        return true;
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
        Intent i = new Intent(Main5Activity.this, Main5Activity.class);
        startActivity(i);
    }

    private void setting(){
        Intent i = new Intent(Main5Activity.this, Main0Activity.class);
        startActivity(i);
    }
}
