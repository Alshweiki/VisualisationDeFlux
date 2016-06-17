package hes_so.visualisationdeflux;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import Classes.Zone;


// In this case, the fragment displays simple text based on the page
public class Zone_Map extends android.support.v4.app.Fragment implements OnMapReadyCallback  {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private GoogleMap googleMap;
    RequestQueue queue;
    GoogleMap map;

    public static Zone_Map newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Zone_Map fragment = new Zone_Map();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_zone__map, container, false);
        queue = Volley.newRequestQueue(view.getContext());

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Click action
                Intent intent = new Intent(getContext(), Add_Zone_Description.class);
                startActivity(intent);
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.zonemap);
        mapFragment.getMapAsync(this);
        map = mapFragment.getMap();
        map.getUiSettings().setRotateGesturesEnabled(false);


        String url ="http://iuam.tk/api/zones";
        final StringRequest zonepos = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        List<Zone> zones = gson.fromJson(response,new TypeToken<List<Zone>>(){}.getType());

                        //  Toast.makeText(getContext(),
                        //        zones.size(),
                        //        Toast.LENGTH_LONG).show();

                        for(int i = 0;i<zones.size();i++) {
                            if(zones.get(i).getType().toString().equals("dynamic"))
                            {PolygonOptions rectOptions = new PolygonOptions()
                                    .add(new LatLng(zones.get(i).getLat1(),zones.get(i).getLng1()),
                                            new LatLng(zones.get(i).getLat1(),zones.get(i).getLng2()),
                                            new LatLng(zones.get(i).getLat2(),zones.get(i).getLng2()),
                                            new LatLng(zones.get(i).getLat2(),zones.get(i).getLng1()))
                                    .strokeColor(Color.BLUE)
                                    .fillColor(0x7F0000FF);
                            Polygon polygon = map.addPolygon(rectOptions);}
                            else
                            {
                                PolygonOptions rectOptions = new PolygonOptions()
                                        .add(new LatLng(zones.get(i).getLat1(),zones.get(i).getLng1()),
                                                new LatLng(zones.get(i).getLat1(),zones.get(i).getLng2()),
                                                new LatLng(zones.get(i).getLat2(),zones.get(i).getLng2()),
                                                new LatLng(zones.get(i).getLat2(),zones.get(i).getLng1()))
                                        .strokeColor(Color.GREEN)
                                        .fillColor(0x7F00FF00);
                                Polygon polygon = map.addPolygon(rectOptions);
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),
                        error.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });

        queue.add(zonepos);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap map) {

       // LatLng sydney = new LatLng(-34, 151);
      //  map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
       // map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(46.99225448705687, 6.9419696554541), 8.0f));
    }
}

