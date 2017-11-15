package com.medicitadocter.doctor.fragment;

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
import com.medicitadocter.base.BaseActivity;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.custom.CustomTextView;
import com.medicitadocter.doctor.adapter.DoctorAdditionalAdapter;
import com.medicitadocter.doctor.dashboard.DoctorDashBoardMenuGanerator;
import com.medicitadocter.doctor.model.DashBoardDoctorMenuModal;

import static com.medicitadocter.doctor.dashboard.DoctorDashBoardMenuGanerator.DASHBOARD_DASHBOARD;
import static com.medicitadocter.doctor.dashboard.DoctorDashBoardMenuGanerator.DASHBOARD_PATIENT;
import static com.medicitadocter.doctor.dashboard.DoctorDashBoardMenuGanerator.DASHBOARD_SCHEDULE;
import static com.medicitadocter.doctor.dashboard.DoctorDashBoardMenuGanerator.DASHBOARD_VISIT_HISTORY;
import static com.medicitadocter.doctor.dashboard.DoctorDashBoardMenuGanerator.DASHBOARD_WAITING_ROOM;


/**
 * Created by ubuntu on 26/6/17.
 */

public class DoctorDashboardAdditionalFragment extends BaseFragment implements DoctorAdditionalAdapter.DashboardClickListners {

    private BaseActivity activity;
    private View view;
    private RecyclerView mRv_Dashboard_Menu;
    private DoctorAdditionalAdapter mdoctorAdditionalAdapter;
    private ImageView iv_chathmassage, iv_notificationimg,iv_patientspic;
    private CustomTextView mTv_DoctorName,tv_patientsname;
    private ImageView iv_Doctorpic;
    private TextView tv_notification;
    private TextView tv_massage;

    public static DoctorDashboardAdditionalFragment newInstance() {
        Bundle args = new Bundle();
        DoctorDashboardAdditionalFragment doctorDashboardAdditionalFragment = new DoctorDashboardAdditionalFragment();
        doctorDashboardAdditionalFragment.setArguments(args);
        return doctorDashboardAdditionalFragment;
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
        iv_Doctorpic = (ImageView) findViewByIds(R.id.iv_patientspic);
        tv_notification = (TextView) findViewByIds(R.id.tv_notification);
        tv_massage = (TextView) findViewByIds(R.id.tv_massage);
        iv_chathmassage = (ImageView) findViewByIds(R.id.iv_chathmassage);
        iv_chathmassage.setOnClickListener(this);
        iv_notificationimg = (ImageView) findViewByIds(R.id.iv_notificationimg);
        iv_notificationimg.setOnClickListener(this);
        mTv_DoctorName = (CustomTextView) findViewByIds(R.id.tv_patientsname);
        mTv_DoctorName.setOnClickListener(this);
        mRv_Dashboard_Menu = (RecyclerView) findViewByIds(R.id.rv_dashboard_menu);
        tv_patientsname = (CustomTextView) findViewByIds(R.id.tv_patientsname);
        iv_patientspic = (ImageView) findViewByIds(R.id.iv_patientspic);
        tv_patientsname.setOnClickListener(this);
        iv_patientspic.setOnClickListener(this);
    }

    @Override
    protected void init() {
        mRv_Dashboard_Menu.setLayoutManager(new GridLayoutManager(getContext(), 3, LinearLayoutManager.VERTICAL, false));
        mdoctorAdditionalAdapter = new DoctorAdditionalAdapter(getActivity(), DoctorDashBoardMenuGanerator.getMenuGanerator(getActivity()));
        mdoctorAdditionalAdapter.setDashboardClickListenrs(this);
        mRv_Dashboard_Menu.setAdapter(mdoctorAdditionalAdapter);
        mRv_Dashboard_Menu.setHasFixedSize(true);
    }


    @Override
    public void DasboardClick(DashBoardDoctorMenuModal menuModal) {
        if (menuModal != null) {

            switch (menuModal.getId()) {
                case DASHBOARD_DASHBOARD:
                    Toast.makeText(getActivity(), "Dashboard", Toast.LENGTH_SHORT);
                    break;
                case DASHBOARD_WAITING_ROOM:
                    Toast.makeText(getActivity(), "Waiting Room", Toast.LENGTH_SHORT);
                    setFragments(R.id.flPatientMain, DashboardWaitingRoomFragment.newInstance(), true);
                    break;
                case DASHBOARD_PATIENT:
                    Toast.makeText(getActivity(), "Patient", Toast.LENGTH_SHORT);
                    setFragments(R.id.flPatientMain, DashboardPatientsListFragment.newInstance(), true);
//                    Intent i = new Intent(getActivity(),PatientsListActivity.class);
//                    startActivity(i);
                    break;
                case DASHBOARD_VISIT_HISTORY:
                    Toast.makeText(getActivity(), "Visit History", Toast.LENGTH_SHORT);
                    setFragments(R.id.flPatientMain, DashboardVisitHistoryFragment.newInstance(), true);
                    break;
                case DASHBOARD_SCHEDULE:
                    Toast.makeText(getActivity(), "Schedule", Toast.LENGTH_SHORT);
                    setFragments(R.id.flPatientMain, DashboardScheduleFragment.newInstance(), true);
                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        // changeFragment(getActivity(),PatientsFindDpctor_Fragment.newInstance(),false,true);
        if (view == iv_chathmassage) {
            //setFragments(R.id.flPatientMain, null, true);
            setFragments(R.id.flPatientMain, VideoChatMainScreen.newInstance(),true);
        }
        else if (view == iv_notificationimg) {
            //setFragments(R.id.flPatientMain, null, true);
        }
        else if (view == mTv_DoctorName) {
            //setFragments(R.id.flPatientMain, null, true);
        }
        else if (view == iv_patientspic){
            doctorProfile();
        }
        else if (view == tv_patientsname){
            doctorProfile();
        }
    }

    private void doctorProfile() {
        setFragments(R.id.flPatientMain, DashboardProfileFragments.newInstance(), true);
    }
}
