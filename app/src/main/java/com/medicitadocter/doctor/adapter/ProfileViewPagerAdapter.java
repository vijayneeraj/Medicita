package com.medicitadocter.doctor.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.medicitadocter.doctor.fragment.PatientReviewsTabFragment;
import com.medicitadocter.doctor.fragment.ProfileTabFragment;

/**
 * Created by br on 14/8/17.
 */

public class ProfileViewPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public ProfileViewPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                ProfileTabFragment tab1 = new ProfileTabFragment();
                return tab1.newInstance();
            case 1:
                PatientReviewsTabFragment tab2 = new PatientReviewsTabFragment();
                return tab2.newInstance();
        }
        return null;
    }


    @Override
    public int getCount() {
        return tabCount;
    }
}
