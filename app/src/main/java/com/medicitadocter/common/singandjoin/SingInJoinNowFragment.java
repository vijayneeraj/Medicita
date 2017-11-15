package com.medicitadocter.common.singandjoin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.doctor.activity.DoctorDashboardActivity;
import com.medicitadocter.patient.activity.PatientDashboardActivity;
import com.medicitadocter.utils.prefs.PrefManager;

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * Use the {@link SingInJoinNowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingInJoinNowFragment extends BaseFragment {

    private CheckBox cbRegisterGroupJN;
    private CheckBox cbRegisterIndiviJN;
    private CheckBox cbTermsFistJN;

    private TextView tvEmailTxtJN;
    private TextView tvPwdTxtJN;
    private TextView tvShowPwd;
    private TextView tvNameTxtJN;
    private TextView tvDOBTxtJN;
    private TextView tvSexTxtJN;
    private TextView tvTermsLinkJN;
    private TextView tvTermsSecJN;
    private TextView tvPrivacyPolicyLinkJN;
    private TextView tvJoinNowJN;

    private EditText etEmailJN;
    private EditText etConfEmailJN;
    private EditText etPwd;
    private EditText etFirstNameJN;
    private EditText etLastNameJN;
    private EditText etDOBMJN;
    private EditText etDOBDJN;
    private EditText etDOBYJN;
    private EditText etMaleJN;
    private EditText etFemaleJN;
    private LinearLayout ll_Register;
    private PrefManager prefManager;
    private String LOGINAS = "";
    private boolean showPwdFlag = false;

    /**
     * Use this factory method to create a new instance of
     * this fragment
     *
     * @return A new instance of fragment SingInJoinNowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SingInJoinNowFragment newInstance() {
        SingInJoinNowFragment fragment = new SingInJoinNowFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.c_fragment_join_now;
    }

    @Override
    protected void findView() {

        getHandler().setTitle("Join now");
        prefManager = new PrefManager(getContext());

        ll_Register = (LinearLayout) findViewByIds(R.id.ll_Register);
        cbRegisterGroupJN = (CheckBox) findViewByIds(R.id.cbRegisterGroupJN);
        cbRegisterIndiviJN = (CheckBox) findViewByIds(R.id.cbRegisterIndiviJN);
        cbTermsFistJN = (CheckBox) findViewByIds(R.id.cbTermsFistJN);

        etEmailJN = (EditText) findViewByIds(R.id.etEmailJN);
        etConfEmailJN = (EditText) findViewByIds(R.id.etConfEmailJN);
        etPwd = (EditText) findViewByIds(R.id.etPwd);
        etFirstNameJN = (EditText) findViewByIds(R.id.etFirstNameJN);
        etLastNameJN = (EditText) findViewByIds(R.id.etLastNameJN);
        etDOBMJN = (EditText) findViewByIds(R.id.etDOBMJN);
        etDOBDJN = (EditText) findViewByIds(R.id.etDOBDJN);
        etDOBYJN = (EditText) findViewByIds(R.id.etDOBYJN);
        etMaleJN = (EditText) findViewByIds(R.id.etMaleJN);
        etFemaleJN = (EditText) findViewByIds(R.id.etFemaleJN);

        LOGINAS = prefManager.getStringPref("LOGINAS");
        Log.d("LOGINAS",LOGINAS);
        if(!TextUtils.isEmpty(LOGINAS)) {
            if (LOGINAS.equals("DOCTOR")) {
                ll_Register.setVisibility(View.VISIBLE);
            } else if (LOGINAS.equals("PATIENT")) {
                ll_Register.setVisibility(View.GONE);
            }
        } else {
            Log.d("LOGINAS","BLANK");
        }

        tvShowPwd = (TextView) findViewByIds(R.id.tvShowPwd);
        tvShowPwd.setOnClickListener(this);

        tvJoinNowJN = (TextView) findViewByIds(R.id.tvJoinNowJN);
        tvJoinNowJN.setOnClickListener(this);


    }

    @Override
    protected void init() {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        /*super.onCheckedChanged(buttonView, isChecked);*/

        if (cbRegisterGroupJN == buttonView) {

        } else if (cbRegisterIndiviJN == buttonView) {

        } else if (cbTermsFistJN == buttonView) {

        }

    }

    @Override
    public void onClick(View v) {
        /*super.onClick(v);*/
        if (tvShowPwd == v) {
            showPwd();
        } else if (tvJoinNowJN == v) {
            if(!TextUtils.isEmpty(LOGINAS)) {
                if (LOGINAS.equals("DOCTOR")) {
                    StartActivityWithFinish(DoctorDashboardActivity.class);
                } else if (LOGINAS.equals("PATIENT")) {
                    StartActivityWithFinish(PatientDashboardActivity.class);
                }
            } else {
                Log.d("LOGINAS","BLANK");
            }
        }

    }

    private void showPwd() {

        if (showPwdFlag) {
            tvShowPwd.setText(getResources().getString(R.string.show));
            etPwd.setInputType(129);
            showPwdFlag = false;
        } else {
            tvShowPwd.setText(getResources().getString(R.string.hide));
            etPwd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            showPwdFlag = true;
        }
    }


}
