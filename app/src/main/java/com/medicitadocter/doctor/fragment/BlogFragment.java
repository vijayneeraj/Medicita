package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.patient.adapter.BlogListAdapter;
import com.medicitadocter.utils.ItemClickSupport;
import com.medicitadocter.utils.Utils;

/**
 * Created by br on 11/8/17.
 */

public class BlogFragment extends BaseFragment {

    private ImageView ivBack;
    private TextView tvTitle;
    private RecyclerView rvBlogList;
    private BlogListAdapter mAdapter;
    private GridLayoutManager gridLayoutManager;

    public static BlogFragment newInstance()
    {
        Bundle args=new Bundle();
        BlogFragment blogFragment = new BlogFragment();
        blogFragment.setArguments(args);
        return blogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.c_fragment_blog_list;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        tvTitle = (TextView) findViewByIds(R.id.tvTitle);
        ivBack = (ImageView)findViewByIds(R.id.ivBack);
        tvTitle.setText("Blog");
        rvBlogList = (RecyclerView)findViewByIds(R.id.rvBlogList);
        Utils.customBackPressForChildFragment(getFragmentView(),getHandler(),getActivity());
        ivBack.setOnClickListener(this);

        rvBlogList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mAdapter=new BlogListAdapter(getActivity());
        rvBlogList.setAdapter(mAdapter);

        ItemClickSupport.addTo(rvBlogList).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                Log.d("rvBlogList", "rvBlogList");
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flPatientMain, BlogDetailedFragment.newInstance()).addToBackStack(null).commit();

            }
        });
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
                getActivity().onBackPressed();
                break;
            }
        }
    }

}
