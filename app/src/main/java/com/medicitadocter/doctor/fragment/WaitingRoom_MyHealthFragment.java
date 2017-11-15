package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.utils.Utils;

/**
 * Created by br on 29/8/17.
 */

public class WaitingRoom_MyHealthFragment  extends BaseFragment {

    private LinearLayout llAddMedication,llAddMedicationMain,ivAddMedicationSubLayout;
    private ImageView ivAddMedicationMinus;
    private LinearLayout llNetworkInsuranceSummary,llNetworkInsuranceSummaryMain;
    private ImageView ivNetworkInsuranceSummaryMinus;

    public static WaitingRoom_MyHealthFragment newInstance() {
        Bundle args = new Bundle();
        WaitingRoom_MyHealthFragment waitingRoom_myHealthFragment = new WaitingRoom_MyHealthFragment();
        waitingRoom_myHealthFragment.setArguments(args);
        return waitingRoom_myHealthFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_waitingroom_myhealthfragment;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        llAddMedicationMain = (LinearLayout) findViewByIds(R.id.llAddMedicationMain);
        llNetworkInsuranceSummaryMain = (LinearLayout) findViewByIds(R.id.llNetworkInsuranceSummaryMain);
        ivAddMedicationSubLayout = (LinearLayout) findViewByIds(R.id.ivAddMedicationSubLayout);
        llAddMedication = (LinearLayout) findViewByIds(R.id.llAddMedication);
        llNetworkInsuranceSummary = (LinearLayout) findViewByIds(R.id.llNetworkInsuranceSummary);
        ivAddMedicationMinus = (ImageView) findViewByIds(R.id.ivAddMedicationMinus);
        ivNetworkInsuranceSummaryMinus = (ImageView) findViewByIds(R.id.ivNetworkInsuranceSummaryMinus);
        llAddMedication.setOnClickListener(this);
        //llNetworkInsuranceSummary.setOnClickListener(this);
    }


    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        switch (vId) {
            case R.id.llAddMedication:
            {
                Utils.toggle_contents_arrow(getActivity(),ivAddMedicationSubLayout,ivAddMedicationMinus);
                break;
            }
            case R.id.llNetworkInsuranceSummary:
            {
                Utils.toggle_contents_arrow(getActivity(),ivAddMedicationSubLayout,ivNetworkInsuranceSummaryMinus);
                break;
            }
        }
    }
}