package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.doctor.adapter.WaitingRoomAttachmentRecylerAdapter;

/**
 * Created by br on 29/8/17.
 */

public class WaitingRoom_AttachmentsFragment extends BaseFragment {

    private RecyclerView rvAttachments;
    private WaitingRoomAttachmentRecylerAdapter waitingRoomPagerAdapter;

    public static WaitingRoom_AttachmentsFragment newInstance() {
        Bundle args = new Bundle();
        WaitingRoom_AttachmentsFragment waitingRoom_attachmentsFragment = new WaitingRoom_AttachmentsFragment();
        waitingRoom_attachmentsFragment.setArguments(args);
        return waitingRoom_attachmentsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_waitingroom_attachmentsfragment;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        rvAttachments = (RecyclerView) findViewByIds(R.id.rvAttachments);
    }

    @Override
    protected void init() {
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        rvAttachments.setLayoutManager(new GridLayoutManager(getActivity(),2));
        waitingRoomPagerAdapter = new WaitingRoomAttachmentRecylerAdapter(getActivity());
        rvAttachments.setAdapter(waitingRoomPagerAdapter);
        rvAttachments.setHasFixedSize(true);
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        switch (vId) {

        }
    }
}