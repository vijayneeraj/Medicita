package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.doctor.adapter.WaitingRoomPagerAdapter2;
import com.medicitadocter.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by br on 11/8/17.
 */

public class DashboardWaitingRoomFragment extends BaseFragment implements TabLayout.OnTabSelectedListener {

    private ImageView imvBackArrowPatient;
    private ImageView ivWaitingProfilePic;
    private ImageView ivWaitingProfilePicNotification;
    private TextView tvTitlePatient;
    private LinearLayout llStartVisit;
    private LinearLayout llNote;
    private LinearLayout llMedicine;
    private TextView tvStartVisit;
    private TabLayout tabLayoutWaitingRoom;
    private ViewPager viewPagerWaitingRoom;

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public static DashboardWaitingRoomFragment newInstance()
    {
        Bundle args=new Bundle();
        DashboardWaitingRoomFragment dashboardWaitingRoomFragment = new DashboardWaitingRoomFragment();
        dashboardWaitingRoomFragment.setArguments(args);
        return dashboardWaitingRoomFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_fragment_waiting_room;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        Utils.customBackPressForFragment(getFragmentView(),getHandler(),getActivity());
        imvBackArrowPatient = (ImageView) findViewByIds(R.id.imvBackArrowPatient);
        ivWaitingProfilePic = (ImageView) findViewByIds(R.id.ivWaitingProfilePic);
        ivWaitingProfilePicNotification = (ImageView) findViewByIds(R.id.ivWaitingProfilePicNotification);
        tvTitlePatient = (TextView) findViewByIds(R.id.tvTitlePatient);
        llNote = (LinearLayout) findViewByIds(R.id.llNote);
        llMedicine = (LinearLayout) findViewByIds(R.id.llMedicine);
        llStartVisit = (LinearLayout) findViewByIds(R.id.llStartVisit);
        tvStartVisit = (TextView) findViewByIds(R.id.tvStartVisit);
        tabLayoutWaitingRoom = (TabLayout) findViewByIds(R.id.tabLayoutWaitingRoom);
        viewPagerWaitingRoom = (ViewPager) findViewByIds(R.id.viewPagerWaitingRoom);
        imvBackArrowPatient.setOnClickListener(this);
        llNote.setOnClickListener(this);
        llMedicine.setOnClickListener(this);
        llStartVisit.setOnClickListener(this);

    }

    @Override
    protected void init() {
        setUpTabLayoutAndViewPager();
    }


    @Override
    public void onClick(View v) {
        int vId = v.getId();
        switch (vId)
        {
            case R.id.imvBackArrowPatient:
            {
                Log.d("ivBack", "ivBack");
                getHandler().toolbarVisibility(false);
                getActivity().onBackPressed();
                break;
            }
            case R.id.llNote:
            {
                break;
            }
            case R.id.llMedicine:
            {
                break;
            }
            case R.id.llStartVisit:
            {
                break;
            }
        }
    }


    private void setUpTabLayoutAndViewPager() {
        //TabLayout Titles
        mFragmentTitleList.add("Medicita Details");
        mFragmentTitleList.add("My Health");
        mFragmentTitleList.add("Attachments");
        mFragmentTitleList.add("History");

        //TabLayout Fragments
        WaitingRoom_MedicitaDetailsFragment tab1 = new WaitingRoom_MedicitaDetailsFragment();
        WaitingRoom_MyHealthFragment tab2 = new WaitingRoom_MyHealthFragment();
        WaitingRoom_AttachmentsFragment tab3 = new WaitingRoom_AttachmentsFragment();
        WaitingRoom_HistoryFragment tab4 = new WaitingRoom_HistoryFragment();

        //Fagment Instances
        mFragmentList.add(tab1.newInstance());
        mFragmentList.add(tab2.newInstance());
        mFragmentList.add(tab3.newInstance());
        mFragmentList.add(tab4.newInstance());

        //Add Fragment Instances and Titles in waitingRoomPagerAdapter2
        WaitingRoomPagerAdapter2 waitingRoomPagerAdapter2 = new WaitingRoomPagerAdapter2(getChildFragmentManager());
        waitingRoomPagerAdapter2.addFragment(mFragmentList.get(0),mFragmentTitleList.get(0));
        waitingRoomPagerAdapter2.addFragment(mFragmentList.get(1),mFragmentTitleList.get(1));
        waitingRoomPagerAdapter2.addFragment(mFragmentList.get(2),mFragmentTitleList.get(2));
        waitingRoomPagerAdapter2.addFragment(mFragmentList.get(3),mFragmentTitleList.get(3));

        //setAdapter with View Pager and setupViewPager with TabLayout
        viewPagerWaitingRoom.setAdapter(waitingRoomPagerAdapter2);
        tabLayoutWaitingRoom.setupWithViewPager(viewPagerWaitingRoom);

        //setTabLayout Tab TextColor
        tabLayoutWaitingRoom.setTabTextColors(getActivity().getResources().getColor(R.color.black_color),
                getActivity().getResources().getColor(R.color.black_color));

        //setTabLayout Tab Gravity
        tabLayoutWaitingRoom.setTabGravity(TabLayout.GRAVITY_FILL);

        //setTabLayout TabSelectedListener
        tabLayoutWaitingRoom.addOnTabSelectedListener(this);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPagerWaitingRoom.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

}
