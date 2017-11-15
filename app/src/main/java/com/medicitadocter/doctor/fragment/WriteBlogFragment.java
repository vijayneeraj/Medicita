package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
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

public class WriteBlogFragment extends BaseFragment {

    private ImageView ivBack;
    private TextView tvTitle,tvSubmit,tvExploreMore;

    public static WriteBlogFragment newInstance()
    {
        Bundle args=new Bundle();
        WriteBlogFragment writeBlogFragment = new WriteBlogFragment();
        writeBlogFragment.setArguments(args);
        return writeBlogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_write_blog_layout;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        tvTitle = (TextView) findViewByIds(R.id.tvTitle);
        tvTitle.setText("Write Blog");
        tvSubmit = (TextView) findViewByIds(R.id.tvSubmit);
        tvExploreMore = (TextView) findViewByIds(R.id.tvExploreMore);
        Utils.customBackPressForFragment(getFragmentView(),getHandler(),getActivity());
        ivBack = (ImageView)findViewByIds(R.id.ivBack);
        ivBack.setOnClickListener(this);
        tvSubmit.setOnClickListener(this);
        tvExploreMore.setOnClickListener(this);
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
            case R.id.tvSubmit:
            {
                Log.d("tvSubmit", "tvSubmit");
                getHandler().toolbarVisibility(false);
                getActivity().onBackPressed();
                break;
            }
            case R.id.tvExploreMore:
            {
                Log.d("tvExploreMore", "tvExploreMore");
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flPatientMain, BlogFragment.newInstance()).addToBackStack(null).commit();
                break;
            }
        }
    }
}
