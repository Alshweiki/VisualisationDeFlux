package hes_so.visualisationdeflux;

/**
 * Created by Ali on 25.04.16.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Ali on 25.04.16.
 */
public class Zone_details_Tab extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Flux", "Messages", "Statistiques" };
    private Context context;


    public Zone_details_Tab(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return zone_flow.newInstance(position + 1);
        else
        if(position ==1)
            return Zone_Messages.newInstance(position + 1);
        else
        if(position == 2)
            return Zone_Visualisation_Statique.newInstance(position + 1);



        return zone_flow.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }


}