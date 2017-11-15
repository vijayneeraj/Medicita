package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.doctor.adapter.ProfileViewPagerAdapter;
import com.medicitadocter.utils.Utils;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by br on 14/8/17.
 */

public class DashboardProfileFragments extends BaseFragment implements TabLayout.OnTabSelectedListener {

    ImageView ivBack,ivShare;
    CircleImageView ivProfilePic;
    TextView tvDoctorDesignation;
    TextView tvDoctorName;
    RatingBar ProfileRatingMain;
    TabLayout tabLayoutProfile;
    ViewPager viewPagerProfile;

    public static DashboardProfileFragments newInstance()
    {
        Bundle args=new Bundle();
        DashboardProfileFragments dashboardProfileFragments = new DashboardProfileFragments();
        dashboardProfileFragments.setArguments(args);
        return dashboardProfileFragments;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_dashboard_profile_fragment;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        ivBack = (ImageView) findViewByIds(R.id.ivBack);
        ivShare = (ImageView) findViewByIds(R.id.ivShare);
        ivProfilePic = (CircleImageView) findViewByIds(R.id.ivProfilePic);
        tvDoctorDesignation = (TextView) findViewByIds(R.id.tvDoctorDesignation);
        ProfileRatingMain = (RatingBar) findViewByIds(R.id.ProfileRatingMain);
        tabLayoutProfile = (TabLayout) findViewByIds(R.id.tabLayoutProfile);
        viewPagerProfile = (ViewPager) findViewByIds(R.id.viewPagerProfile);
        Utils.customBackPressForFragment(getFragmentView(),getHandler(),getActivity());
        ivBack.setOnClickListener(this);
        ivShare.setOnClickListener(this);
        ivProfilePic.setOnClickListener(this);
        tvDoctorDesignation.setOnClickListener(this);
        //Adding onTabSelectedListener to swipe views
        tabLayoutProfile.addOnTabSelectedListener(this);
    }

    @Override
    protected void init() {
        //Adding the tabs using addTab() method
        tabLayoutProfile.addTab(tabLayoutProfile.newTab().setText("Profile"));
        tabLayoutProfile.addTab(tabLayoutProfile.newTab().setText("Patient Reviews"));
        tabLayoutProfile.setTabGravity(TabLayout.GRAVITY_FILL);

        //Creating our pager adapter
        ProfileViewPagerAdapter adapter = new ProfileViewPagerAdapter(getChildFragmentManager(), tabLayoutProfile.getTabCount());

        //Adding adapter to pager
        viewPagerProfile.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        switch (vId)
        {
            case R.id.ivBack:
            {
                Log.d("ivBack", "ivBack");
                getHandler().toolbarVisibility(false);
                getActivity().onBackPressed();
                break;
            }
            case R.id.ivShare:
            {
                break;
            }
            case R.id.ivProfilePic:
            {
                break;
            }
            case R.id.tvDoctorDesignation:
            {
                break;
            }
        }
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPagerProfile.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        viewPagerProfile.setCurrentItem(tab.getPosition());
    }

}
