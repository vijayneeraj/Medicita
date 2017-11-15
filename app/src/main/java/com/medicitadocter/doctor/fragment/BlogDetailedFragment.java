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

public class BlogDetailedFragment extends BaseFragment {

    private ImageView ivBack;
    private TextView tvTitle;

    public static BlogDetailedFragment newInstance()
    {
        Bundle args=new Bundle();
        BlogDetailedFragment blogDetailedFragment = new BlogDetailedFragment();
        blogDetailedFragment.setArguments(args);
        return blogDetailedFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.c_blog_detail;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        tvTitle = (TextView) findViewByIds(R.id.tvTitle);
        tvTitle.setText("Blog");
        Utils.customBackPressForChildFragment(getFragmentView(),getHandler(),getActivity());
        ivBack = (ImageView)findViewByIds(R.id.ivBack);
        ivBack.setOnClickListener(this);
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
                getHandler().toolbarVisibility(true);
                getActivity().onBackPressed();
                break;
            }
        }
    }
}
