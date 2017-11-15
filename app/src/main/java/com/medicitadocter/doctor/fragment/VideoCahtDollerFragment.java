package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.doctor.dialogs.CompleteAndLeaveVisitDialog;
import com.medicitadocter.utils.Utils;

/**
 * Created by br on 16/8/17.
 */

public class VideoCahtDollerFragment extends BaseFragment {

    TextView tvChangePatientCard;

    public static VideoCahtDollerFragment newInstance()
    {
        Bundle args=new Bundle();
        VideoCahtDollerFragment videoCahtDollerFragment = new VideoCahtDollerFragment();
        videoCahtDollerFragment.setArguments(args);
        return videoCahtDollerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_complete_visit_feedback_main_layout_at_video_call;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        tvChangePatientCard = (TextView) findViewByIds(R.id.tvChangePatientCard);
        tvChangePatientCard.setOnClickListener(this);
        Utils.customBackPressForChildFragment(getFragmentView(),getHandler(),getActivity());
    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tvChangePatientCard:
            {
                CompleteAndLeaveVisitDialog completeAndLeaveVisitDialog = new CompleteAndLeaveVisitDialog(getActivity());
                completeAndLeaveVisitDialog.show();
                break;
            }
        }
    }
}
