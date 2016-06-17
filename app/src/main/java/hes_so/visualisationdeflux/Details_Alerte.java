package hes_so.visualisationdeflux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Details_Alerte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_alert);
        TextView tv1 = (TextView)findViewById(R.id.textView4);
        TextView tv2 = (TextView)findViewById(R.id.textView5);
        tv1.setText(getIntent().getStringExtra("subject"));
        tv2.setText(getIntent().getStringExtra("content"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main3, menu);
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
        Intent i = new Intent(Details_Alerte.this, LogIn.class);
        startActivity(i);
    }

    private void setting(){
        Intent i = new Intent(Details_Alerte.this, Info.class);
        startActivity(i);
    }
}
