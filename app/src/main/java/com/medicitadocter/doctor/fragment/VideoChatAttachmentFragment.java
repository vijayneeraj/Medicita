package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.utils.Utils;

/**
 * Created by br on 16/8/17.
 */

public class VideoChatAttachmentFragment extends BaseFragment {


    public static VideoChatAttachmentFragment newInstance()
    {
        Bundle args=new Bundle();
        VideoChatAttachmentFragment videoChatAttachmentFragment = new VideoChatAttachmentFragment();
        videoChatAttachmentFragment.setArguments(args);
        return videoChatAttachmentFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_visit_details_and_prescriptions;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        Utils.customBackPressForChildFragment(getFragmentView(),getHandler(),getActivity());
    }

    @Override
    protected void init() {

    }
}
