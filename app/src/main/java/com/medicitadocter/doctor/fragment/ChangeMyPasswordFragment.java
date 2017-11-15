package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.utils.Utils;

/**
 * Created by rahul on 8/11/2017.
 */

public class ChangeMyPasswordFragment extends BaseFragment {

    private TextView tvSubmit,tvTitlePatient;
    private ImageView ivSearch,imvBackArrowPatient;
    private EditText etCurrentPassword,etNewPassword,etConfirmPassword;

    public static ChangeMyPasswordFragment newInstance()
    {
        Bundle args=new Bundle();
        ChangeMyPasswordFragment changeMyPasswordFragment=new ChangeMyPasswordFragment();
        changeMyPasswordFragment.setArguments(args);
        return changeMyPasswordFragment;
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_change_password;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        Utils.customBackPressForFragment(getFragmentView(),getHandler(),getActivity());
        tvSubmit = (TextView)findViewByIds(R.id.tvSubmit);
        tvTitlePatient = (TextView)findViewByIds(R.id.tvTitlePatient);
        tvTitlePatient.setText("Change My Password");
        ivSearch = (ImageView)findViewByIds(R.id.ivSearch);
        imvBackArrowPatient = (ImageView)findViewByIds(R.id.imvBackArrowPatient);
        etConfirmPassword = (EditText)findViewByIds(R.id.etConfirmPassword);
        etCurrentPassword = (EditText)findViewByIds(R.id.etCurrentPassword);
        etNewPassword = (EditText)findViewByIds(R.id.etNewPassword);
        tvSubmit.setOnClickListener(this);
        imvBackArrowPatient.setOnClickListener(this);
    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        switch (vId)
        {
            case R.id.tvSubmit:
            {
                getHandler().toolbarVisibility(false);
                getActivity().onBackPressed();
                break;
            }
            case R.id.imvBackArrowPatient:
            {
                getHandler().toolbarVisibility(false);
                getActivity().onBackPressed();
                break;
            }
        }
    }
}
