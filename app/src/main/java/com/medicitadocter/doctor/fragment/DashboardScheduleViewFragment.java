package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.doctor.adapter.ScheduleDatesRecyclerAdapter;
import com.medicitadocter.doctor.adapter.ScheduleDatesViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by br on 18/8/17.
 */

public class DashboardScheduleViewFragment extends BaseFragment implements TabLayout.OnTabSelectedListener {

    private RecyclerView rvTimeSlots;
    private TabLayout tabLayoutDateSlot;
    private ViewPager viewPagerSchedule;

    private List<String> timeSlot = new ArrayList<>();
    private List<String> dateSlot = new ArrayList<>();
    private List<String> status = new ArrayList<>();
    private List<String> four = new ArrayList<>();
    private List<String> five = new ArrayList<>();
    private List<String> six = new ArrayList<>();
    private List<String> seven = new ArrayList<>();
    private List<String> eight = new ArrayList<>();
    private List<String> nine = new ArrayList<>();
    private List<String> ten = new ArrayList<>();

    public static DashboardScheduleViewFragment newInstance()
    {
        Bundle args=new Bundle();
        DashboardScheduleViewFragment dashboardScheduleViewFragment = new DashboardScheduleViewFragment();
        dashboardScheduleViewFragment.setArguments(args);
        return dashboardScheduleViewFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_schedule_view_fregment;
    }

    @Override
    protected void findView() {
        rvTimeSlots = (RecyclerView) findViewByIds(R.id.rvTimeSlots);
        tabLayoutDateSlot = (TabLayout) findViewByIds(R.id.tabLayoutDateSlot);
        viewPagerSchedule = (ViewPager) findViewByIds(R.id.ViewPagerSchedule);

        status.add("");
        status.add("NEW");
        status.add("BUSY");

        dateSlot.add("04 Thrus");
        dateSlot.add("05 Fri");
        dateSlot.add("06 Sat");
        dateSlot.add("07 Sun");
        dateSlot.add("08 Mon");
        dateSlot.add("09 Tues");
        dateSlot.add("10 Wed");

        timeSlot.add("All Days");
        for(int i=0;i<20;i++)
        {
            int hour = 8;
            int minute = 00;
            int gap = 30;
            if(i%2==0)
            {
                timeSlot.add(String.valueOf(hour + i + ":" + minute));
            }
            else
            {
                timeSlot.add(String.valueOf(hour + i + ":" + minute+gap));
            }
            four.add(status.get(0));
            five.add(status.get(1));
            six.add(status.get(2));
            seven.add(status.get(0));
            eight.add(status.get(1));
            nine.add(status.get(2));
            ten.add(status.get(0));
        }
    }

    @Override
    protected void init() {
        //Adding the tabs using addTab() method
        for(String var : dateSlot)
        {
            tabLayoutDateSlot.addTab(tabLayoutDateSlot.newTab().setText(var));
        }
        tabLayoutDateSlot.setTabGravity(TabLayout.GRAVITY_FILL);

        //Creating our pager adapter
        ScheduleDatesViewPagerAdapter scheduleDatesViewPagerAdapter = new ScheduleDatesViewPagerAdapter(getChildFragmentManager(),getContext(), tabLayoutDateSlot.getTabCount());

        //Adding adapter to pager
        viewPagerSchedule.setAdapter(scheduleDatesViewPagerAdapter);
        tabLayoutDateSlot.setupWithViewPager(viewPagerSchedule);

        rvTimeSlots.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        ScheduleDatesRecyclerAdapter mAdapter=new ScheduleDatesRecyclerAdapter(getActivity(),timeSlot);
        rvTimeSlots.setAdapter(mAdapter);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPagerSchedule.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        viewPagerSchedule.setCurrentItem(tab.getPosition());
    }
}
