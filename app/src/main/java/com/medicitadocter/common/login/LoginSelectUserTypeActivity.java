package com.medicitadocter.common.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseActivity;
import com.medicitadocter.utils.prefs.PrefManager;

public class LoginSelectUserTypeActivity extends BaseActivity {

    /**
     * Reference of buttons
     */
    private TextView tvLoginAsPatient;
    private TextView tvLoginAsProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.c_activity_login;
    }

    @Override
    protected void findView() {
        /**
         * Call Patient Login Screen Button initialization
         * Set on Click Listener
         */
        tvLoginAsPatient = (TextView) findViewById(R.id.tvLoginAsPatient);
        tvLoginAsPatient.setOnClickListener(this);

        /**
         * Call Provider Login screen button initialization
         * Set on Click Listener
         */
        tvLoginAsProvider = (TextView) findViewById(R.id.tvLoginAsProvider);
        tvLoginAsProvider.setOnClickListener(this);
    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {
        /*super.onClick(v);*/
        PrefManager prefManager = new PrefManager(this);
        Bundle bundle = new Bundle();
        if (tvLoginAsProvider == v) {
            bundle.putString("LOGINAS","DOCTOR");
            prefManager.setStringPref("LOGINAS","DOCTOR");
            Log.d("LOGINAS","DOCTOR");
            StartActivityWithBundle(LoginJoinNowBaseActivity.class,bundle);
        } else if (tvLoginAsPatient == v) {
            bundle.putString("LOGINAS","PATIENT");
            prefManager.setStringPref("LOGINAS","PATIENT");
            Log.d("LOGINAS","PATIENT");
            StartActivityWithBundle(LoginJoinNowBaseActivity.class,bundle);
        }

    }
}
