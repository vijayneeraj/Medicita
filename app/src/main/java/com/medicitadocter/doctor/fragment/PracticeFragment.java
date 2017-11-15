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
 * Created by rahul on 8/11/2017.
 */

public class PracticeFragment extends BaseFragment {

    ImageView ivBack,ivDot,ivOverviewMinus,ivOfficeLocationsMinus,ivQualificationsMinus;
    TextView tvTitle,tvOfficeLocationsSubmit;
    LinearLayout llOverview,llOverviewSubLayout,llOfficeLocations,llOfficeLocationsSubLayout,llQualifications,llQualificationsSubLayout;

    public static PracticeFragment newInstance()
    {
        Bundle args=new Bundle();
        PracticeFragment practiceFragment=new PracticeFragment();
        practiceFragment.setArguments(args);
        return practiceFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }


    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_practice_layout;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        ivBack = (ImageView)findViewByIds(R.id.ivBack);
        ivDot = (ImageView)findViewByIds(R.id.ivDot);
        tvTitle = (TextView)findViewByIds(R.id.tvTitle);

        ivOverviewMinus = (ImageView)findViewByIds(R.id.ivOverviewMinus);
        ivOfficeLocationsMinus = (ImageView)findViewByIds(R.id.ivOfficeLocationsMinus);
        ivQualificationsMinus = (ImageView)findViewByIds(R.id.ivQualificationsMinus);

        llOverview = (LinearLayout)findViewByIds(R.id.llOverview);
        llOverviewSubLayout = (LinearLayout)findViewByIds(R.id.llOverviewSubLayout);
        llOfficeLocations =  (LinearLayout)findViewByIds(R.id.llOfficeLocations);
        llOfficeLocationsSubLayout =  (LinearLayout)findViewByIds(R.id.llOfficeLocationsSubLayout);
        llQualifications =  (LinearLayout)findViewByIds(R.id.llQualifications);
        llQualificationsSubLayout =  (LinearLayout)findViewByIds(R.id.llQualificationsSubLayout);

        tvOfficeLocationsSubmit = (TextView)findViewByIds(R.id.tvOfficeLocationsSubmit);

        llOverview.setOnClickListener(this);
        llOfficeLocations.setOnClickListener(this);
        llQualifications.setOnClickListener(this);

        tvOfficeLocationsSubmit.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }

    @Override
    protected void init() {
        tvTitle.setText("Doctor & Staff");
        Utils.customBackPressForFragment(getFragmentView(),getHandler(),getActivity());
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        switch (vId) {
            case R.id.ivBack:
                {
                Log.d("ivBack", "ivBack");
                getHandler().toolbarVisibility(false);
                getActivity().onBackPressed();
                break;
            }
            case R.id.ivDot: {
                Toast.makeText(getActivity(), "ivDot", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.llOverview:
            {
                Utils.toggle_contents(getActivity(),llOverviewSubLayout,ivOverviewMinus);
                break;
            }
            case R.id.llOfficeLocations:
            {
                Utils.toggle_contents(getActivity(),llOfficeLocationsSubLayout,ivOfficeLocationsMinus);
                break;
            }
            case R.id.llQualifications:
            {
                Utils.toggle_contents(getActivity(),llQualificationsSubLayout,ivQualificationsMinus);
                break;
            }
            case R.id.tvOfficeLocationsSubmit:
            {
                getHandler().toolbarVisibility(false);
                getActivity().onBackPressed();
                break;
            }
        }
    }

}
