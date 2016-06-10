
package hes_so.visualisationdeflux;

        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.graphics.Color;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v7.app.AppCompatActivity;
        import android.text.InputType;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
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
        import com.google.android.gms.maps.model.Polygon;
        import com.google.android.gms.maps.model.PolygonOptions;

        import java.util.ArrayList;
        import java.util.List;

public class Add_Zone_Map extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    private boolean typeZoneDynamique = true;
    private GoogleMap mMap;
    int intVar = 1;
    FloatingActionButton fab;
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

          ourMarker = new ArrayList<OurMarker>();
        fab = (FloatingActionButton) Add_Zone_Map.this.findViewById(R.id.fab);
        fab.setEnabled(false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Click action
                Intent intent = new Intent(Add_Zone_Map.this, Admin_Map.class);
                startActivity(intent);
            }
        });


        FloatingActionButton fab2 = (FloatingActionButton) Add_Zone_Map.this.findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ourMarker = new ArrayList<OurMarker>();
                mMap.clear();
                numberOfClick= 0;
                fab.setEnabled(false);
            }
        });

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


    //our class
    public  class OurMarker{
        public double latitude;
        public double longitude;
        public String title;
        OurMarker(){}

    }
    int numberOfClick = 0;


    List<OurMarker> ourMarker;
    @Override
    public void onMapClick(LatLng latLng) {

        numberOfClick++;
        if (numberOfClick <= 2) {
            OurMarker m = new OurMarker();
            m.latitude = latLng.latitude;
            m.longitude = latLng.longitude;
            m.title = latLng.toString();
            ourMarker.add(m);


            Toast.makeText(Add_Zone_Map.this,
                    "onMapLongClick:\n" + latLng.latitude + " : " + latLng.longitude + "numberofclick: " + numberOfClick,
                    Toast.LENGTH_LONG).show();
            //Add marker on LongClick position
            if (typeZoneDynamique) {
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(latLng.toString())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            } else
            if(!typeZoneDynamique) {
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(latLng.toString())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
            }
        }
        else
        {
            fab.setEnabled(true);
            if(typeZoneDynamique){
            PolygonOptions rectOptions = new PolygonOptions()
                    .add(new LatLng(ourMarker.get(0).latitude,ourMarker.get(0).longitude),
                            new LatLng(ourMarker.get(0).latitude,ourMarker.get(1).longitude),
                            new LatLng(ourMarker.get(1).latitude,ourMarker.get(1).longitude),
                            new LatLng(ourMarker.get(1).latitude,ourMarker.get(0).longitude))
                    .strokeColor(Color.YELLOW)
                    .fillColor(0x7F00FF00);
            Polygon polygon = mMap.addPolygon(rectOptions);

            Toast.makeText(Add_Zone_Map.this,
                    "you have clicked: " + numberOfClick,
                    Toast.LENGTH_LONG).show();
            }
            else
            if(!typeZoneDynamique){
                PolygonOptions rectOptions = new PolygonOptions()
                        .add(new LatLng(ourMarker.get(0).latitude,ourMarker.get(0).longitude),
                                new LatLng(ourMarker.get(0).latitude,ourMarker.get(1).longitude),
                                new LatLng(ourMarker.get(1).latitude,ourMarker.get(1).longitude),
                                new LatLng(ourMarker.get(1).latitude,ourMarker.get(0).longitude))
                        .strokeColor(Color.GREEN)
                        .fillColor(0x7F00FF00);
                Polygon polygon = mMap.addPolygon(rectOptions);

                Toast.makeText(Add_Zone_Map.this,
                        "you have clicked: " + numberOfClick,
                        Toast.LENGTH_LONG).show();
            }
        }
    }

}