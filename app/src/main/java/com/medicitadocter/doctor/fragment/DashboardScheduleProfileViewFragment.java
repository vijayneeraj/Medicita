package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;

/**
 * Created by br on 18/8/17.
 */

public class DashboardScheduleProfileViewFragment extends BaseFragment {

    public static DashboardScheduleProfileViewFragment newInstance()
    {
        Bundle args=new Bundle();
        DashboardScheduleProfileViewFragment dashboardScheduleProfileViewFragment = new DashboardScheduleProfileViewFragment();
        dashboardScheduleProfileViewFragment.setArguments(args);
        return dashboardScheduleProfileViewFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_schedule_profile_view_fregment;
    }

    @Override
    protected void findView() {

    }

    @Override
    protected void init() {

    }
}
