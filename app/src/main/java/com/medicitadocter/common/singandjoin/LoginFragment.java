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

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.</p>
 */
public class LoginFragment extends BaseFragment {

    private EditText etEmailAdd;
    private EditText etPwd;
    private TextView tvShowPwd;
    private TextView tvForgotPwd;
    private CheckBox cbKeepSigned;
    private TextView tvSignIn;
//    private TextView tvJoinNowLogin;
    private TextView tvJoinNowLoginDoctor;
    private LinearLayout ll_join_now_msg_layout;
    private TextView tvJoinNowLoginPatient;
    private TextView tvJoinNowTitleMsgPatient;
    private TextView tvJoinNowMsgPatient;

    private String LOGINAS = "";
    private boolean doctorLogin = false;
    private boolean patientLogin = false;
    private boolean showPwdFlag = false;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LoginFragment.
     */
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
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
        return R.layout.c_fragment_login;
    }

    @Override
    protected void findView() {

        getHandler().setTitle("Sign in / Join now");

        LOGINAS = getArguments().getString("LOGINAS");
        Log.d("LOGINAS",LOGINAS);
        if(!TextUtils.isEmpty(LOGINAS)) {
            if (LOGINAS.equals("DOCTOR")) {
                doctorLogin = true;
            } else if (LOGINAS.equals("PATIENT")) {
                patientLogin = true;
            }
        } else {
            Log.d("LOGINAS","BLANK");
        }

        etEmailAdd = (EditText) findViewByIds(R.id.etEmailAdd);

        etPwd = (EditText) findViewByIds(R.id.etPwd);

        tvShowPwd = (TextView) findViewByIds(R.id.tvShowPwd);
        tvShowPwd.setOnClickListener(this);

        tvForgotPwd = (TextView) findViewByIds(R.id.tvForgotPwd);
        tvForgotPwd.setOnClickListener(this);

        cbKeepSigned = (CheckBox) findViewByIds(R.id.cbKeepSigned);
        cbKeepSigned.setOnCheckedChangeListener(this);

        tvSignIn = (TextView) findViewByIds(R.id.tvSignIn);
        tvSignIn.setOnClickListener(this);

        tvJoinNowLoginDoctor = (TextView) findViewByIds(R.id.tvJoinNowLoginDoctor);
        tvJoinNowLoginDoctor.setVisibility(View.GONE);
        tvJoinNowLoginDoctor.setOnClickListener(this);

        ll_join_now_msg_layout = (LinearLayout) findViewByIds(R.id.ll_join_now_msg_layout);
        ll_join_now_msg_layout.setVisibility(View.GONE);

        tvJoinNowTitleMsgPatient = (TextView) findViewByIds(R.id.tvJoinNowTitleMsgPatient);
        tvJoinNowMsgPatient = (TextView) findViewByIds(R.id.tvJoinNowMsgPatient);

        tvJoinNowLoginPatient = (TextView) findViewByIds(R.id.tvJoinNowLoginPatient);
        tvJoinNowLoginPatient.setOnClickListener(this);

        if(doctorLogin) {
            tvJoinNowLoginDoctor.setVisibility(View.VISIBLE);
        }
        else if(patientLogin) {
            ll_join_now_msg_layout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {
        /*super.onClick(v);*/

        if (tvShowPwd == v) {
            showPwd();
        } else if (tvForgotPwd == v) {
            setFragments(R.id.flLoginJoin, ForgetPasswordFragment.newInstance(), true);
        } else if (tvSignIn == v) {
            if(doctorLogin)
            {
                StartActivityWithFinish(DoctorDashboardActivity.class);
            }
            else if (patientLogin)
            {
                StartActivityWithFinish(PatientDashboardActivity.class);
            }
        } else if (tvJoinNowLoginDoctor == v) {
            setFragments(R.id.flLoginJoin, SingInJoinNowFragment.newInstance(), true);
        } else if(tvJoinNowLoginPatient == v) {
            setFragments(R.id.flLoginJoin, SingInJoinNowFragment.newInstance(), true);
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

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        /*super.onCheckedChanged(buttonView, isChecked);*/
        if (cbKeepSigned == buttonView) {

        }
    }
}
