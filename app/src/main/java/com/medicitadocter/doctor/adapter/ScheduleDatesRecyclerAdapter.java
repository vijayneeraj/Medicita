package com.medicitadocter.doctor.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medicitadocter.R;

import java.util.List;

/**
 * Created by br on 30/8/17.
 */

public class ScheduleDatesRecyclerAdapter extends RecyclerView.Adapter<ScheduleDatesRecyclerAdapter.ViewHelper>  {

    Context context;
    List<String> timeSlot;

    public ScheduleDatesRecyclerAdapter(FragmentActivity activity, List<String> timeSlot){
        this.context = activity;
        this.timeSlot = timeSlot;
    }

    @Override
    public ScheduleDatesRecyclerAdapter.ViewHelper onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.doc_schedule_dates_recycler_item,parent,false);
        return new ScheduleDatesRecyclerAdapter.ViewHelper(view);
    }

    @Override
    public void onBindViewHolder(ScheduleDatesRecyclerAdapter.ViewHelper holder, int position) {
        holder.rvScheduleStatus.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        ScheduleStatusRecyclerAdapter mAdapter=new ScheduleStatusRecyclerAdapter(context,timeSlot);
        holder.rvScheduleStatus.setAdapter(mAdapter);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHelper extends RecyclerView.ViewHolder
    {
        RecyclerView rvScheduleStatus;

        public ViewHelper(View itemView) {
            super(itemView);
            rvScheduleStatus = (RecyclerView) itemView.findViewById(R.id.rvScheduleStatus);
        }
    }

}
