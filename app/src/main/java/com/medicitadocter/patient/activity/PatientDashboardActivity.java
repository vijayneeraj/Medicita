package com.medicitadocter.patient.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseActivity;
import com.medicitadocter.patient.dashboard.PatientNavigationViewHandler;
import com.medicitadocter.patient.fragment.PatientsDashboardAdditionalFragment;

public class PatientDashboardActivity extends BaseActivity {

    PatientNavigationViewHandler navigationViewHandler;

    private ImageView imvUserPick;
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
        navigationViewHandler = new PatientNavigationViewHandler(this);
        navigationViewHandler.findViewIds();
        setFragments(R.id.flPatientMain, PatientsDashboardAdditionalFragment.newInstance(), false);
        imvUserPick = (ImageView) findViewById(R.id.imvUserPick);
        imvUserPick.setOnClickListener(this);
    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {
    /**///    StartActivity(PatientUserprofileActivity.class);
    }
}
