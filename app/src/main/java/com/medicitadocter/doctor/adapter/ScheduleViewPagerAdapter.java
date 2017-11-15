package com.medicitadocter.doctor.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.medicitadocter.doctor.fragment.DashboardScheduleProfileViewFragment;
import com.medicitadocter.doctor.fragment.DashboardScheduleViewFragment;

/**
 * Created by br on 18/8/17.
 */

public class ScheduleViewPagerAdapter  extends FragmentStatePagerAdapter {

    private int tabCount;

    public ScheduleViewPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                DashboardScheduleViewFragment tab1 = new DashboardScheduleViewFragment();
                return tab1.newInstance();
            case 1:
                DashboardScheduleProfileViewFragment tab2 = new DashboardScheduleProfileViewFragment();
                return tab2.newInstance();
        }
        return null;
    }


    @Override
    public int getCount() {
        return tabCount;
    }
}
