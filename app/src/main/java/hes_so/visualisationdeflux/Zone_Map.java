package hes_so.visualisationdeflux;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


// In this case, the fragment displays simple text based on the page
public class Zone_Map extends android.support.v4.app.Fragment implements OnMapReadyCallback  {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private GoogleMap googleMap;

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

        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.zonemap);
        mapFragment.getMapAsync(this);
        GoogleMap map = mapFragment.getMap();
        map.getUiSettings().setRotateGesturesEnabled(false);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap map) {

        LatLng sydney = new LatLng(-34, 151);
        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10));
    }
}

