package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.doctor.adapter.ScheduleViewPagerAdapter;
import com.medicitadocter.doctor.dialogs.SchedulingCalenderDialog;
import com.medicitadocter.utils.Utils;

/**
 * Created by br on 11/8/17.
 */

public class DashboardScheduleFragment extends BaseFragment implements TabLayout.OnTabSelectedListener {

    private ImageView ivClock,ivDot,ivCalender,ivPrev,ivNext;
    private LinearLayout llBack;
    private TextView tvDateHeading;
    private TabLayout TabLayoutSchedule;
    private ViewPager ViewPagerSchedule;

    public static DashboardScheduleFragment newInstance()
    {
        Bundle args=new Bundle();
        DashboardScheduleFragment dashboardScheduleFragment = new DashboardScheduleFragment();
        dashboardScheduleFragment.setArguments(args);
        return dashboardScheduleFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_scheduling_fragment;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        ivClock = (ImageView) findViewByIds(R.id.ivClock);
        ivDot = (ImageView) findViewByIds(R.id.ivDot);
        ivCalender = (ImageView) findViewByIds(R.id.ivCalender);
        ivPrev = (ImageView) findViewByIds(R.id.ivPrev);
        ivNext = (ImageView) findViewByIds(R.id.ivPrev);
        llBack = (LinearLayout) findViewByIds(R.id.llBack);
        tvDateHeading = (TextView) findViewByIds(R.id.tvDateHeading);
        TabLayoutSchedule = (TabLayout) findViewByIds(R.id.TabLayoutSchedule);
        ViewPagerSchedule = (ViewPager) findViewByIds(R.id.ViewPagerSchedule);
        Utils.customBackPressForFragment(getFragmentView(),getHandler(),getActivity());

        ivCalender.setOnClickListener(this);
        ivClock.setOnClickListener(this);
        ivDot.setOnClickListener(this);
        ivPrev.setOnClickListener(this);
        ivNext.setOnClickListener(this);
        llBack.setOnClickListener(this);
        TabLayoutSchedule.addOnTabSelectedListener(this);
    }

    @Override
    protected void init() {
        //Adding the tabs using addTab() method
        TabLayoutSchedule.addTab(TabLayoutSchedule.newTab().setText("Carlos Jurdo"));
        TabLayoutSchedule.addTab(TabLayoutSchedule.newTab().setText("View Profile"));
        TabLayoutSchedule.setTabGravity(TabLayout.GRAVITY_FILL);

        //Creating our pager adapter
        ScheduleViewPagerAdapter scheduleViewPagerAdapter = new ScheduleViewPagerAdapter(getChildFragmentManager(), TabLayoutSchedule.getTabCount());

        //Adding adapter to pager
        ViewPagerSchedule.setAdapter(scheduleViewPagerAdapter);
        //TabLayoutSchedule.setupWithViewPager(ViewPagerSchedule);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.llBack:
            {
                getHandler().toolbarVisibility(false);
                getActivity().onBackPressed();
                break;
            }
            case R.id.ivClock:
            {
                break;
            }
            case R.id.ivDot:
            {
                break;
            }
            case R.id.ivPrev:
            {
                break;
            }
            case R.id.ivNext:
            {
                break;
            }
            case R.id.ivCalender:
            {
                SchedulingCalenderDialog schedulingCalenderDialog = new SchedulingCalenderDialog(getActivity());
                schedulingCalenderDialog.show();
                break;
            }
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        ViewPagerSchedule.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        ViewPagerSchedule.setCurrentItem(tab.getPosition());
    }
}
