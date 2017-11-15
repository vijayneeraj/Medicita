package com.medicitadocter.doctor.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by br on 30/8/17.
 */

public class ScheduleDatesViewPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;
    private FragmentManager fm;
    private Context context;
//    private ScrollView sv;
//    private View rootView;
//    private RecyclerView recyclerView;
//    private LinearLayout linearLayout;
//    private LinearLayout.LayoutParams matchParent;
//    private LinearLayout.LayoutParams wrapContent;

    public ScheduleDatesViewPagerAdapter(FragmentManager fm, Context context, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
        this.fm = fm;
        this.context = context;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
            {

//                createRecyclerView();
//                scrollView();
//                linearLayout();
//                matchParent();
//                wrapContent();
//                rootView();
                break;
            }
            case 1:
            {
                break;
            }
            case 2:
            {
                break;
            }
            case 3:
            {
                break;
            }
            case 4:
            {
                break;
            }
            case 5:
            {
                break;
            }
            case 6:
            {
                break;
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }

//    private void scrollView() {
//        sv = new ScrollView(context);
//        sv.setLayoutParams(new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.MATCH_PARENT));
//    }
//
//    private void linearLayout() {
//        linearLayout = new LinearLayout(context);
//        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
//    }
//
//    private void wrapContent() {
//        wrapContent = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//    }
//
//    private void matchParent() {
//        matchParent = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//    }
//
//    private void createRecyclerView() {
//        recyclerView = new RecyclerView(context);
//    }
}
