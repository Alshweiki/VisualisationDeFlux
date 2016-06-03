
package hes_so.visualisationdeflux;

        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.text.InputType;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.Toast;

        import com.google.android.gms.common.GoogleApiAvailability;
        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.BitmapDescriptorFactory;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;

public class Add_Zone_Map extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;
    int intVar = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_zone_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.addmap);
        mapFragment.getMapAsync(this);
        GoogleMap map = mapFragment.getMap();
        map.getUiSettings().setRotateGesturesEnabled(false);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(this);
        mMap.setOnMapLongClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main8, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     switch (item.getItemId()) {
            case R.id.maptypeHYBRID:
                if(mMap != null){
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    return true;
                }
            case R.id.maptypeNONE:
                if(mMap != null){
                    mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                    return true;
                }
            case R.id.maptypeNORMAL:
                if(mMap != null){
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    return true;
                }
            case R.id.maptypeSATELLITE:
                if(mMap != null){
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    return true;
                }
            case R.id.maptypeTERRAIN:
                if(mMap != null){
                    mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                    return true;
                }


        }

        return super.onOptionsItemSelected(item);
    }

    private void addMarker(){
        if(mMap != null){

            //create custom LinearLayout programmatically
            LinearLayout layout = new LinearLayout(Add_Zone_Map.this);
            layout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            layout.setOrientation(LinearLayout.VERTICAL);

            final EditText titleField = new EditText(Add_Zone_Map.this);
            titleField.setHint("Title");

            final EditText latField = new EditText(Add_Zone_Map.this);
            latField.setHint("Latitude");
            latField.setInputType(InputType.TYPE_CLASS_NUMBER
                    | InputType.TYPE_NUMBER_FLAG_DECIMAL
                    | InputType.TYPE_NUMBER_FLAG_SIGNED);


            final EditText lonField = new EditText(Add_Zone_Map.this);
            lonField.setHint("Longitude");
            lonField.setInputType(InputType.TYPE_CLASS_NUMBER
                    | InputType.TYPE_NUMBER_FLAG_DECIMAL
                    | InputType.TYPE_NUMBER_FLAG_SIGNED);

            layout.addView(titleField);
            layout.addView(latField);
            layout.addView(lonField);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Add Marker");
            builder.setView(layout);
            AlertDialog alertDialog = builder.create();

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    boolean parsable = true;
                    Double lat = null, lon = null;

                    String strLat = latField.getText().toString();
                    String strLon = lonField.getText().toString();
                    String strTitle = titleField.getText().toString();

                    try{
                        lat = Double.parseDouble(strLat);
                    }catch (NumberFormatException ex){
                        parsable = false;
                        Toast.makeText(Add_Zone_Map.this,
                                "Latitude does not contain a parsable double",
                                Toast.LENGTH_LONG).show();
                    }

                    try{
                        lon = Double.parseDouble(strLon);
                    }catch (NumberFormatException ex){
                        parsable = false;
                        Toast.makeText(Add_Zone_Map.this,
                                "Longitude does not contain a parsable double",
                                Toast.LENGTH_LONG).show();
                    }

                    if(parsable){

                        LatLng targetLatLng = new LatLng(lat, lon);
                        MarkerOptions markerOptions =
                                new MarkerOptions().position(targetLatLng).title(strTitle);

                        mMap.addMarker(markerOptions);
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(targetLatLng));

                    }
                }
            });
            builder.setNegativeButton("Cancel", null);

            builder.show();
        }else{
            Toast.makeText(Add_Zone_Map.this, "Map not ready", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        Toast.makeText(Add_Zone_Map.this,
                "onMapClick:\n" + latLng.latitude + " : " + latLng.longitude,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMapClick(LatLng latLng) {

        Toast.makeText(Add_Zone_Map.this,
                "onMapLongClick:\n" + latLng.latitude + " : " + latLng.longitude,
                Toast.LENGTH_LONG).show();
        //Add marker on LongClick position
        if (intVar  == 1) {
            mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(latLng.toString())
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        }else{
            mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(latLng.toString())
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        }
    }
}