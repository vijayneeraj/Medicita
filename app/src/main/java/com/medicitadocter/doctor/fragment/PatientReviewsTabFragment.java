package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;

/**
 * Created by br on 14/8/17.
 */

public class PatientReviewsTabFragment extends BaseFragment {

    public static PatientReviewsTabFragment newInstance()
    {
        Bundle args=new Bundle();
        PatientReviewsTabFragment patientReviewsTabFragment = new PatientReviewsTabFragment();
        patientReviewsTabFragment.setArguments(args);
        return patientReviewsTabFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_ptientreviews_fragment;
    }

    @Override
    protected void findView() {

    }

    @Override
    protected void init() {

    }
}
