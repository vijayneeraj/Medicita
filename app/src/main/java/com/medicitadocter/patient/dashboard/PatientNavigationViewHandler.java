package com.medicitadocter.patient.dashboard;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseActivity;
import com.medicitadocter.handler.AdapterClickHandler;
import com.medicitadocter.patient.adapter.PatientNavigationViewAdapter;
import com.medicitadocter.patient.fragment.PatientsDashboardAdditionalFragment;

/**
 * Created by linux on 29/6/17.
 */

public class PatientNavigationViewHandler implements View.OnClickListener, AdapterClickHandler {

    private BaseActivity activity;
    private ImageView imvNavBtn;
    private ImageView imvNavLogo;
    private ImageView imvNavSearch;
    private DrawerLayout drawable;
    private NavigationView nvPatientView;
    private RecyclerView rvNavigationItemList;

    public PatientNavigationViewHandler(BaseActivity activity) {
        this.activity = activity;
    }

   public void findViewIds() {
        drawable = (DrawerLayout) activity.findViewById(R.id.drawerPatient);
        nvPatientView = (NavigationView) activity.findViewById(R.id.nvPatientView);
        imvNavLogo = (ImageView) activity.findViewById(R.id.imvNavLogo);
        imvNavSearch = (ImageView) activity.findViewById(R.id.imvNavSearch);
        imvNavSearch.setOnClickListener(this);
        imvNavBtn = (ImageView) activity.findViewById(R.id.imvNavBtn);
        imvNavBtn.setOnClickListener(this);

        rvNavigationItemList = (RecyclerView) nvPatientView.findViewById(R.id.rvNavigationItemList);
        rvNavigationItemList.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
//        rvNavigationItemList.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.VERTICAL));
        rvNavigationItemList.setAdapter(new PatientNavigationViewAdapter(activity, getPatientNaviItem(), this));
    }

    @Override
    public void onClick(View v) {
        if (imvNavBtn == v) {
            setDrawableStatus();
        }else if (imvNavSearch == v) {
            Toast.makeText(activity,"imvNavSearch",Toast.LENGTH_SHORT).show();
            //Intent i = new Intent(activity,PatientSearchActivity.class);
        /**///    activity.StartActivity(PatientSearchActivity.class);
          // activity.setFragments(R.id.flPatientMain, PatientSearchFragment.newInstance(), true);
        }
    }


    @Override
    public void onClickListener(int position) {
        switch (position) {
            case 0:
                //DashBoard
                setDrawableStatus();
                activity.setFragments(R.id.flPatientMain, PatientsDashboardAdditionalFragment.newInstance(), true);
                break;
            case 1:
                //My Messages
                setDrawableStatus();
             /**///   activity.StartActivity(MyMessageActivity.class);
             /**///   activity.setFragments(R.id.flPatientMain, DoctorMedicalTeamFragment.newInstance(), true);
                break;
            case 2:
                //Settings
                setDrawableStatus();
                //activity.setFragments(R.id.flPatientMain, PSettingFragment.newInstance(), true);
                break;
            case 3:
                //Notifications
                setDrawableStatus();
                //activity.setFragments(R.id.flPatientMain, NotificationSettingsFragment.newInstance(), true);
                //activity.StartActivity(BookYouAppointmentActivity.class);
                break;
            case 4:
                //Blog
                setDrawableStatus();
              /**///  activity.StartActivity(BlogListActivity.class);
                break;
            case 5:
                //Logout
                setDrawableStatus();
                //activity.StartActivity(BookedAppointmentActivity.class);
                break;
            case 6:
                setDrawableStatus();
             /**///   activity.StartActivity(MyHealthActivity.class);
                break;

        }
    }


    private void setDrawableStatus() {
        if (drawable.isDrawerOpen(nvPatientView)) {
            drawable.closeDrawers();
        } else {
            drawable.openDrawer(nvPatientView);
        }
    }

    private String[] getPatientNaviItem() {
        return activity.getResources().getStringArray(R.array.patient_navi_item);
    }

}
