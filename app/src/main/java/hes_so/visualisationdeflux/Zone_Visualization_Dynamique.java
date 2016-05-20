package hes_so.visualisationdeflux;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


// In this case, the fragment displays simple text based on the page
public class Zone_Visualization_Dynamique extends android.support.v4.app.Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;


    public static Zone_Visualization_Dynamique newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Zone_Visualization_Dynamique fragment = new Zone_Visualization_Dynamique();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPage = getArguments().getInt(ARG_PAGE);






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zone__visualization__dynamique, container, false);
        //TextView textView = (TextView) view;
        //textView.setText("Fragment #" + mPage);




        return view;
    }


}