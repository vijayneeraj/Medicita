package com.medicitadocter.patient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.custom.CustomTextView;
import com.medicitadocter.patient.adapter.PatientsAdditionalAdapter;
import com.medicitadocter.patient.dashboard.PatientDashBoardMenuGanerator;
import com.medicitadocter.patient.model.DashBoardPatientMenuModal;

import static com.medicitadocter.patient.dashboard.PatientDashBoardMenuGanerator.DASHBOARD_APPOINMENT;
import static com.medicitadocter.patient.dashboard.PatientDashBoardMenuGanerator.DASHBOARD_CONSULT;
import static com.medicitadocter.patient.dashboard.PatientDashBoardMenuGanerator.DASHBOARD_HEALTH;
import static com.medicitadocter.patient.dashboard.PatientDashBoardMenuGanerator.DASHBOARD_MASSAGE;
import static com.medicitadocter.patient.dashboard.PatientDashBoardMenuGanerator.DASHBOARD_REMAINDER;
import static com.medicitadocter.patient.dashboard.PatientDashBoardMenuGanerator.DASHBOARD_SETTING;

/**
 * Created by ubuntu on 26/6/17.
 */

public class PatientsDashboardAdditionalFragment extends BaseFragment implements PatientsAdditionalAdapter.DashboardClickListners {

    private View view;
    private RecyclerView mRv_Dashboard_Menu;
    private PatientsAdditionalAdapter mPatientsAdditionalAdapter;
    private ImageView iv_chathmassage, iv_notificationimg;
    private CustomTextView mTv_PatientsName;
    private ImageView iv_patientspic;
    private TextView tv_notification;
    private TextView tv_massage;

    public static PatientsDashboardAdditionalFragment newInstance() {
        Bundle args = new Bundle();
        PatientsDashboardAdditionalFragment patientsAdditional_fragment = new PatientsDashboardAdditionalFragment();
        patientsAdditional_fragment.setArguments(args);
        return patientsAdditional_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.c_patients_additional_fragment;
    }

    @Override
    protected void findView() {
        iv_patientspic = (ImageView) findViewByIds(R.id.iv_patientspic);
        tv_notification = (TextView) findViewByIds(R.id.tv_notification);
        tv_massage = (TextView) findViewByIds(R.id.tv_massage);
        iv_chathmassage = (ImageView) findViewByIds(R.id.iv_chathmassage);
        iv_chathmassage.setOnClickListener(this);
        iv_notificationimg = (ImageView) findViewByIds(R.id.iv_notificationimg);
        iv_notificationimg.setOnClickListener(this);
        mTv_PatientsName = (CustomTextView) findViewByIds(R.id.tv_patientsname);
        mTv_PatientsName.setOnClickListener(this);
        mRv_Dashboard_Menu = (RecyclerView) findViewByIds(R.id.rv_dashboard_menu);
    }

    @Override
    protected void init() {
        mRv_Dashboard_Menu.setLayoutManager(new GridLayoutManager(getContext(), 3, LinearLayoutManager.VERTICAL, false));
        mPatientsAdditionalAdapter = new PatientsAdditionalAdapter(getActivity(), PatientDashBoardMenuGanerator.getMenuGanerator(getActivity()));
        mPatientsAdditionalAdapter.setDashboardClickListenrs(this);
        mRv_Dashboard_Menu.setAdapter(mPatientsAdditionalAdapter);
        mRv_Dashboard_Menu.setHasFixedSize(true);
    }


    @Override
    public void DasboardClick(DashBoardPatientMenuModal menuModal) {
        if (menuModal != null) {

            switch (menuModal.getId()) {
                case DASHBOARD_SETTING:
                    Toast.makeText(getActivity(), "Setting", Toast.LENGTH_SHORT);
                    break;
                case DASHBOARD_MASSAGE:
                    Toast.makeText(getActivity(), "Massage", Toast.LENGTH_SHORT);
             /**///       StartActivity(MyMessageActivity.class);
                    break;
                case DASHBOARD_CONSULT:
                    Toast.makeText(getActivity(), "Cosult now", Toast.LENGTH_SHORT);
             /**///       StartActivity(BookedAppointmentActivity.class);
                    //setFragments(R.id.flPatientMain, DoctorPastAppointmentFragment.newInstance(), true);
                    break;
                case DASHBOARD_REMAINDER:
                    Toast.makeText(getActivity(), "Wellness Remainder", Toast.LENGTH_SHORT);
                    break;
                case DASHBOARD_APPOINMENT:
                    Toast.makeText(getActivity(), "Past Appointment", Toast.LENGTH_SHORT);
                    break;
                case DASHBOARD_HEALTH:
                    Toast.makeText(getActivity(), "My Health", Toast.LENGTH_SHORT);
            /**///        StartActivity(MyHealthActivity.class);
                    //setFragments(R.id.flPatientMain, PatientsHelpFragment.newInstance(), true);
                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        // changeFragment(getActivity(),PatientsFindDpctor_Fragment.newInstance(),false,true);
        if (view == iv_chathmassage) {
    /**///        setFragments(R.id.flPatientMain, PatientsFindDoctorFragment.newInstance(), true);
        }
        else if (view == iv_notificationimg) {
    /**///        setFragments(R.id.flPatientMain, DoctorMedicalTeamFragment.newInstance(), true);
        }
        else if (view == mTv_PatientsName) {
     /**///       setFragments(R.id.flPatientMain, DoctorUpcomingAppointmentFragment.newInstance(), true);
        }
    }
}
