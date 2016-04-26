package hes_so.visualisationdeflux;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


// In this case, the fragment displays simple text based on the page
public class zone_flow extends android.support.v4.app.Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage1;

    public static zone_flow newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        zone_flow fragment = new zone_flow();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage1 = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zone_flow, container, false);
        TextView textView = (TextView) view;
        textView.setText("Map #" + mPage1);
        return view;
    }
}