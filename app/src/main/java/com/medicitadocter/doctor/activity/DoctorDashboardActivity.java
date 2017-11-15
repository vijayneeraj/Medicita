package com.medicitadocter.doctor.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseActivity;
import com.medicitadocter.doctor.dashboard.DoctorNavigationViewHandler;
import com.medicitadocter.doctor.fragment.DoctorDashboardAdditionalFragment;

public class DoctorDashboardActivity extends BaseActivity {

    DoctorNavigationViewHandler navigationViewHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.c_activity_patient_deshboard;
    }

    @Override
    protected void findView() {
        navigationViewHandler = new DoctorNavigationViewHandler(this);
        navigationViewHandler.findViewIds();
        setFragments(R.id.flPatientMain, DoctorDashboardAdditionalFragment.newInstance(), false);
    }

    @Override
    protected void init() {

    }

    @Override
    public void setTitle(CharSequence title) {
        /*super.setTitle(title);*/
        navigationViewHandler.setTitle(String.valueOf(title));
    }

    @Override
    public void toolbarVisibility(Boolean value) {
        navigationViewHandler.toolbarVisibility(value);
    }

    @Override
    public void showAndHideIcons(Boolean drawer, Boolean logo, Boolean search) {
        navigationViewHandler.showAndHideIcons(drawer, logo, search);
    }

    @Override
    public void changeMenuIcon(Drawable image) {
        navigationViewHandler.changeMenuIcon(image);
    }

}
