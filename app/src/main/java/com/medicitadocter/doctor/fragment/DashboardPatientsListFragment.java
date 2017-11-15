package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.doctor.adapter.PatientListRecyclerAdapter;
import com.medicitadocter.utils.Utils;

/**
 * Created by br on 10/8/17.
 */

public class DashboardPatientsListFragment extends BaseFragment {

    private TextView tvTitlePatient;
    private ImageView imvBackArrowPatient;
    private ImageView ivSearch;
    private RecyclerView rvPatientList;
    private PatientListRecyclerAdapter patientListRecyclerAdapter;


    public static DashboardPatientsListFragment newInstance()
    {
        Bundle args=new Bundle();
        DashboardPatientsListFragment dashboardPatientsListFragment =new DashboardPatientsListFragment();
        dashboardPatientsListFragment.setArguments(args);
        return dashboardPatientsListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }


    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_patient_fragment;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        tvTitlePatient = (TextView)findViewByIds(R.id.tvTitlePatient);
        ivSearch = (ImageView)findViewByIds(R.id.ivSearch);
        imvBackArrowPatient = (ImageView)findViewByIds(R.id.imvBackArrowPatient);
        rvPatientList=(RecyclerView)findViewByIds(R.id.rvPatientList);
        imvBackArrowPatient.setOnClickListener(this);
        ivSearch.setOnClickListener(this);

        Utils.customBackPressForFragment(getFragmentView(),getHandler(),getActivity());
    }


    @Override
    protected void init() {
        tvTitlePatient.setText("Patient");
        rvPatientList.setLayoutManager(new LinearLayoutManager((getActivity()),LinearLayoutManager.VERTICAL,false));
        patientListRecyclerAdapter = new PatientListRecyclerAdapter(getActivity());
        rvPatientList.setAdapter(patientListRecyclerAdapter);
        rvPatientList.setHasFixedSize(true);
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        switch (vId) {
            case R.id.imvBackArrowPatient: {
                Log.d("imvBackArrowPatient", "imvBackArrowPatient");
                getHandler().toolbarVisibility(false);
                getActivity().onBackPressed();
                break;
            }
            case R.id.ivSearch: {
                Toast.makeText(getActivity(), "ivSearch", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
