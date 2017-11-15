package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.doctor.adapter.DashboardVisitHistoryAdapter;
import com.medicitadocter.doctor.dialogs.VisitHistorySearch;
import com.medicitadocter.utils.Utils;

/**
 * Created by br on 11/8/17.
 */

public class DashboardVisitHistoryFragment extends BaseFragment {

    private ImageView ivBack,ivDot;
    private TextView tvTitle;
    private RecyclerView rvBlogList;
    private DashboardVisitHistoryAdapter mAdapter;

    public static DashboardVisitHistoryFragment newInstance()
    {
        Bundle args=new Bundle();
        DashboardVisitHistoryFragment dashboardVisitHistoryFragment = new DashboardVisitHistoryFragment();
        dashboardVisitHistoryFragment.setArguments(args);
        return dashboardVisitHistoryFragment;
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
        tvTitle = (TextView)findViewByIds(R.id.tvTitle);
        tvTitle.setText("Visit History");
        ivDot = (ImageView)findViewByIds(R.id.ivDot);

        ivDot.setBackground(getActivity().getResources().getDrawable(R.drawable.places_ic_search));
        ivBack = (ImageView) findViewByIds(R.id.ivBack);
        rvBlogList = (RecyclerView) findViewByIds(R.id.rvBlogList);
        ivDot.setOnClickListener(this);
        ivBack.setOnClickListener(this);

        rvBlogList.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mAdapter=new DashboardVisitHistoryAdapter(getActivity());
        rvBlogList.setAdapter(mAdapter);

//        ItemClickSupport.addTo(rvBlogList).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
//            @Override
//            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
////                String TAG = v.getTag().toString();
//                Log.d("rahul ",": "+position+" : "+v.getId());
////                switch (TAG)
////                {
////                    case "a":
////                    {
////                        Toast.makeText(getActivity(),"a",Toast.LENGTH_SHORT).show();
////                        //Log.d("rvBlogList", "rvBlogList");
////                        //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
////                        //fragmentManager.beginTransaction().replace(R.id.flPatientMain, BlogDetailedFragment.newInstance()).addToBackStack(null).commit();
////                        break;
////                    }
////                    case "b":
////                    {
////                        Toast.makeText(getActivity(),"b",Toast.LENGTH_SHORT).show();
////                        break;
////                    }
////                    case "c":
////                    {
////                        Toast.makeText(getActivity(),"c",Toast.LENGTH_SHORT).show();
////                        break;
////                    }
////                    case "d":
////                    {
////                        Toast.makeText(getActivity(),"d",Toast.LENGTH_SHORT).show();
////                        break;
////                    }
////                }
//            }
//        });

        Utils.customBackPressForFragment(getFragmentView(),getHandler(),getActivity());
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
            case R.id.ivDot:
            {
                Log.d("ivDot", "ivDot");
                VisitHistorySearch visitHistorySearch = new VisitHistorySearch(getActivity());
                visitHistorySearch.show();
                break;
            }
        }
    }
}
