package com.medicitadocter.doctor.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.medicitadocter.doctor.fragment.WaitingRoom_AttachmentsFragment;
import com.medicitadocter.doctor.fragment.WaitingRoom_HistoryFragment;
import com.medicitadocter.doctor.fragment.WaitingRoom_MedicitaDetailsFragment;
import com.medicitadocter.doctor.fragment.WaitingRoom_MyHealthFragment;

/**
 * Created by br on 29/8/17.
 */

public class WaitingRoomPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public WaitingRoomPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

        //Overriding method getItem
        @Override
        public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position)
        {
            case 0:

                WaitingRoom_MedicitaDetailsFragment tab1 = new WaitingRoom_MedicitaDetailsFragment();
                return tab1.newInstance();
            case 1:
                WaitingRoom_MyHealthFragment tab2 = new WaitingRoom_MyHealthFragment();
                return tab2.newInstance();
            case 2:
                WaitingRoom_AttachmentsFragment tab3 = new WaitingRoom_AttachmentsFragment();
                return tab3.newInstance();
            case 3:
                WaitingRoom_HistoryFragment tab4 = new WaitingRoom_HistoryFragment();
                return tab4.newInstance();
        }
        return null;
    }


        @Override
        public int getCount() {
        return tabCount;
    }

}
