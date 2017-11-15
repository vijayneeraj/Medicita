package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.utils.Utils;

/**
 * Created by br on 11/8/17.
 */

public class InsuranceFragment extends BaseFragment {

    private TextView tvTitle;
    private ImageView ivBack;
    private ImageView ivNetworkInsuranceSummaryMinus,ivAddMedicationMinus;
    private LinearLayout llNetworkInsuranceSummary,llAddMedication,llAddMedicationSubLayout;

    public static InsuranceFragment newInstance()
    {
        Bundle args=new Bundle();
        InsuranceFragment insuranceFragment = new InsuranceFragment();
        insuranceFragment.setArguments(args);
        return insuranceFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_insurance_layout;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        tvTitle = (TextView) findViewByIds(R.id.tvTitle);
        tvTitle.setText("Insurance");
        ivBack = (ImageView)findViewByIds(R.id.ivBack);
        ivNetworkInsuranceSummaryMinus = (ImageView)findViewByIds(R.id.ivNetworkInsuranceSummaryMinus);
        ivAddMedicationMinus = (ImageView)findViewByIds(R.id.ivAddMedicationMinus);
        llNetworkInsuranceSummary = (LinearLayout)findViewByIds(R.id.llNetworkInsuranceSummary);
        llAddMedication = (LinearLayout)findViewByIds(R.id.llAddMedication);
        llAddMedicationSubLayout = (LinearLayout)findViewByIds(R.id.llAddMedicationSubLayout);
        ivBack.setOnClickListener(this);
        llNetworkInsuranceSummary.setOnClickListener(this);
        llAddMedication.setOnClickListener(this);
        Utils.customBackPressForFragment(getFragmentView(),getHandler(),getActivity());
    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        switch (vId)
        {
            case R.id.ivBack:
            {
                Log.d("ivBack", "ivBack");
                getHandler().toolbarVisibility(false);
                getActivity().onBackPressed();
                break;
            }
            case R.id.llNetworkInsuranceSummary:
            {
                //Utils.toggle_contents(getActivity(),null,ivNetworkInsuranceSummaryMinus);
                Toast.makeText(getActivity(),"Layout Not Available",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.llAddMedication:
            {
                Utils.toggle_contents(getActivity(),llAddMedicationSubLayout,ivAddMedicationMinus);
                break;
            }
        }
    }
}
