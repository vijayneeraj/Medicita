package com.medicitadocter.doctor.dashboard;

import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseActivity;
import com.medicitadocter.doctor.adapter.DoctorNavigationViewAdapter;
import com.medicitadocter.doctor.fragment.AlerterFragment;
import com.medicitadocter.doctor.fragment.BillingFragment;
import com.medicitadocter.doctor.fragment.ChangeMyPasswordFragment;
import com.medicitadocter.doctor.fragment.DashboardPatientsListFragment;
import com.medicitadocter.doctor.fragment.DashboardVisitHistoryFragment;
import com.medicitadocter.doctor.fragment.DashboardWaitingRoomFragment;
import com.medicitadocter.doctor.fragment.DoctorAndStaffFragment;
import com.medicitadocter.doctor.fragment.DoctorDashboardAdditionalFragment;
import com.medicitadocter.doctor.fragment.InsuranceFragment;
import com.medicitadocter.doctor.fragment.PracticeFragment;
import com.medicitadocter.doctor.fragment.WriteBlogFragment;
import com.medicitadocter.doctor.fragment.YourWebsiteFragment;
import com.medicitadocter.handler.AdapterClickHandler;
import com.medicitadocter.handler.NavigationHandler;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by br on 26/7/17.
 */

public class DoctorNavigationViewHandler implements View.OnClickListener, AdapterClickHandler, NavigationHandler {

    private BaseActivity activity;
    private ImageView imvNavBtn;
    private ImageView imvNavLogo;
    private ImageView imvNavSearch;
    private DrawerLayout drawable;
    private NavigationView nvDoctorView;
    private RecyclerView rvNavigationItemList;
    private LinearLayout ll_patient_toolbar_layout;
    private PopupWindow popupWindow;

    public DoctorNavigationViewHandler(BaseActivity activity) {
        this.activity = activity;
    }

    public void findViewIds() {
        drawable = (DrawerLayout) activity.findViewById(R.id.drawerPatient);
        nvDoctorView = (NavigationView) activity.findViewById(R.id.nvPatientView);
        imvNavLogo = (ImageView) activity.findViewById(R.id.imvNavLogo);
        imvNavSearch = (ImageView) activity.findViewById(R.id.imvNavSearch);
        imvNavSearch.setImageResource(R.mipmap.dot);
        ll_patient_toolbar_layout = (LinearLayout) activity.findViewById(R.id.ll_patient_toolbar_layout);
        imvNavSearch.setOnClickListener(this);
        imvNavBtn = (ImageView) activity.findViewById(R.id.imvNavBtn);
        imvNavBtn.setOnClickListener(this);

        rvNavigationItemList = (RecyclerView) nvDoctorView.findViewById(R.id.rvNavigationItemList);
        rvNavigationItemList.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
//      rvNavigationItemList.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.VERTICAL));
        rvNavigationItemList.setAdapter(new DoctorNavigationViewAdapter(activity, getDoctorNaviItem(), this));
    }

    @Override
    public void onClick(View v) {
        if (imvNavBtn == v) {
            setDrawableStatus();
        } else if (imvNavSearch == v) {
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(LAYOUT_INFLATER_SERVICE);

            View popupView = layoutInflater.inflate(R.layout.doc_dashboard_popup_menu, null);

            popupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            popupWindow.setOutsideTouchable(true);

            if (popupWindow.isOutsideTouchable()) {
                popupWindow.dismiss();
            }

            TextView tvPassword = (TextView) popupView.findViewById(R.id.tvPassword);
            TextView tvPractice = (TextView) popupView.findViewById(R.id.tvPractice);
            TextView tvDoctors = (TextView) popupView.findViewById(R.id.tvDoctors);
            TextView tvInsurance = (TextView) popupView.findViewById(R.id.tvInsurance);
            TextView tvBilling = (TextView) popupView.findViewById(R.id.tvBilling);
            TextView tvAlerter = (TextView) popupView.findViewById(R.id.tvAlerter);
            TextView tvYourWebsite = (TextView) popupView.findViewById(R.id.tvYourWebsite);
            TextView tvWriteBlog = (TextView) popupView.findViewById(R.id.tvWriteBlog);

            tvPassword.setOnClickListener(popupClick());
            tvPractice.setOnClickListener(popupClick());
            tvDoctors.setOnClickListener(popupClick());
            tvInsurance.setOnClickListener(popupClick());
            tvBilling.setOnClickListener(popupClick());
            tvAlerter.setOnClickListener(popupClick());
            tvYourWebsite.setOnClickListener(popupClick());
            tvWriteBlog.setOnClickListener(popupClick());

            popupWindow.showAsDropDown(imvNavSearch, 10, 10);
        }
    }

    private View.OnClickListener popupClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
         /*1*/
                    case R.id.tvPassword: {
                        Toast.makeText(activity, "tvPassword", Toast.LENGTH_SHORT).show();
                        activity.setFragments(R.id.flPatientMain, ChangeMyPasswordFragment.newInstance(), true);
                        popupWindow.dismiss();
                        break;
                    }
         /*2*/
                    case R.id.tvPractice: {
                        Toast.makeText(activity, "tvPractice", Toast.LENGTH_SHORT).show();
                        activity.setFragments(R.id.flPatientMain, PracticeFragment.newInstance(), true);
                        popupWindow.dismiss();
                        break;
                    }
         /*3*/
                    case R.id.tvDoctors: {
                        Toast.makeText(activity, "tvDoctors", Toast.LENGTH_SHORT).show();
                        activity.setFragments(R.id.flPatientMain, DoctorAndStaffFragment.newInstance(), true);
                        popupWindow.dismiss();
                        break;
                    }
         /*4*/
                    case R.id.tvInsurance: {
                        Toast.makeText(activity, "tvInsurance", Toast.LENGTH_SHORT).show();
                        activity.setFragments(R.id.flPatientMain, InsuranceFragment.newInstance(), true);
                        popupWindow.dismiss();
                        break;
                    }
         /*5*/
                    case R.id.tvBilling: {
                        Toast.makeText(activity, "tvBilling", Toast.LENGTH_SHORT).show();
                        activity.setFragments(R.id.flPatientMain, BillingFragment.newInstance(), true);
                        popupWindow.dismiss();
                        break;
                    }
         /*6*/
                    case R.id.tvAlerter: {
                        Toast.makeText(activity, "tvAlerter", Toast.LENGTH_SHORT).show();
                        activity.setFragments(R.id.flPatientMain, AlerterFragment.newInstance(), true);
                        popupWindow.dismiss();
                        break;
                    }
         /*7*/
                    case R.id.tvYourWebsite: {
                        Toast.makeText(activity, "tvYourWebsite", Toast.LENGTH_SHORT).show();
                        activity.setFragments(R.id.flPatientMain, YourWebsiteFragment.newInstance(), true);
                        popupWindow.dismiss();
                        break;
                    }
         /*8*/
                    case R.id.tvWriteBlog: {
                        Toast.makeText(activity, "tvWriteBlog", Toast.LENGTH_SHORT).show();
                        activity.setFragments(R.id.flPatientMain, WriteBlogFragment.newInstance(), true);
                        popupWindow.dismiss();
                        break;
                    }
                }
            }
        };
    }


    @Override
    public void onClickListener(int position) {
        switch (position) {
/*1*/
            case 0: {       /*Dashboard*/
                setDrawableStatus();
                activity.setFragments(R.id.flPatientMain, DoctorDashboardAdditionalFragment.newInstance(), true);
                break;
            }
/*2*/
            case 1: {       /*Waiting Room*/
                setDrawableStatus();
                activity.setFragments(R.id.flPatientMain, DashboardWaitingRoomFragment.newInstance(), true);
                break;
            }
/*3*/
            case 2: {        /*Visit History*/
                setDrawableStatus();
                activity.setFragments(R.id.flPatientMain, DashboardVisitHistoryFragment.newInstance(), true);
                break;
            }
/*4*/
            case 3: {        /*Patients*/
                setDrawableStatus();
                activity.setFragments(R.id.flPatientMain, DashboardPatientsListFragment.newInstance(), true);
                break;
            }
/*5*/
            case 4: {        /*Blog*/
                setDrawableStatus();
                activity.setFragments(R.id.flPatientMain, WriteBlogFragment.newInstance(), true);
                break;
            }
/*6*/
            case 5: {        /*FAQ*/
                setDrawableStatus();
                break;
            }
/*7*/
            case 6: {        /*Contact Us*/
                setDrawableStatus();
                break;
            }
        }
    }


    private void setDrawableStatus() {
        if (drawable.isDrawerOpen(nvDoctorView)) {
            drawable.closeDrawers();
        } else {
            drawable.openDrawer(nvDoctorView);
        }
    }

    private String[] getDoctorNaviItem() {
        return activity.getResources().getStringArray(R.array.doctor_navi_item);
    }

    public void setTitle(String title) {

    }

    @Override
    public void setTitle(CharSequence title) {

    }

    public void toolbarVisibility(Boolean value) {
        if (value.equals(true)) {
            ll_patient_toolbar_layout.setVisibility(View.GONE);
        } else if (value.equals(false)) {
            ll_patient_toolbar_layout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showAndHideIcons(Boolean drawer, Boolean logo, Boolean search) {
        if (drawer) {
            imvNavBtn.setVisibility(View.GONE);
        } else {
            imvNavBtn.setVisibility(View.VISIBLE);
        }
        if (logo) {
            imvNavLogo.setVisibility(View.GONE);
        } else {
            imvNavLogo.setVisibility(View.GONE);
        }
        if (search) {
            imvNavSearch.setVisibility(View.GONE);
        } else {
            imvNavSearch.setVisibility(View.GONE);
        }
    }

    @Override
    public void changeMenuIcon(Drawable image) {
        if (!image.equals(null)) {
            imvNavSearch.setBackground(image);
        } else {
            imvNavSearch.setImageResource(R.mipmap.icon_search);
        }
    }

}
