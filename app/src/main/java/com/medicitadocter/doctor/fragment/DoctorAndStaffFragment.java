package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.utils.Utils;


/**
 * Created by br on 11/8/17.
 */

public class DoctorAndStaffFragment extends BaseFragment {

    private ImageView ivBack;
    private TextView tvTitle;

    public static DoctorAndStaffFragment newInstance()
    {
        Bundle args=new Bundle();
        DoctorAndStaffFragment doctorAndStaffFragment = new DoctorAndStaffFragment();
        doctorAndStaffFragment.setArguments(args);
        return doctorAndStaffFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_doctor_and_staff_layout;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        tvTitle = (TextView)findViewByIds(R.id.tvTitle);
        tvTitle.setText("Doctor & Staff");
        ivBack = (ImageView)findViewByIds(R.id.ivBack);
        ivBack.setOnClickListener(this);
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
        }
    }
}
