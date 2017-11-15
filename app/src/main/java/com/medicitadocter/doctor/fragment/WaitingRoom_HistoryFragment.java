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

public class WaitingRoom_HistoryFragment extends BaseFragment {


    public static WaitingRoom_HistoryFragment newInstance()
    {
        Bundle args=new Bundle();
        WaitingRoom_HistoryFragment waitingRoom_historyFragment=new WaitingRoom_HistoryFragment();
        waitingRoom_historyFragment.setArguments(args);
        return waitingRoom_historyFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }


    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_waitingroom_historyfragment;
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
