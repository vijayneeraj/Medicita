package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;

/**
 * Created by br on 29/8/17.
 */

public class WaitingRoom_MedicitaDetailsFragment  extends BaseFragment {


    public static WaitingRoom_MedicitaDetailsFragment newInstance() {
        Bundle args = new Bundle();
        WaitingRoom_MedicitaDetailsFragment waitingRoom_medicitaDetailsFragment = new WaitingRoom_MedicitaDetailsFragment();
        waitingRoom_medicitaDetailsFragment.setArguments(args);
        return waitingRoom_medicitaDetailsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_waitingroom_medicitadetailsfragment;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);

    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        switch (vId) {

        }
    }
}