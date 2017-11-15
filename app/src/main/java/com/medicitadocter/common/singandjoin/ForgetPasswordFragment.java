package com.medicitadocter.common.singandjoin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * Use the {@link ForgetPasswordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForgetPasswordFragment extends BaseFragment {


    /**
     * Use this factory method to create a new instance of
     * this fragment
     *
     * @return A new instance of fragment ForgetPasswordFragment.
     */
    public static ForgetPasswordFragment newInstance() {
        ForgetPasswordFragment fragment = new ForgetPasswordFragment();
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
        return R.layout.c_fragment_forgot_pwd;
    }

    @Override
    protected void findView() {
        getHandler().setTitle("Forgot your password?");
    }

    @Override
    protected void init() {


    }


}
