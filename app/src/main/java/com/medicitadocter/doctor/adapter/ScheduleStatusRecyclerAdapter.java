package com.medicitadocter.doctor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.medicitadocter.R;

import java.util.List;

/**
 * Created by br on 30/8/17.
 */

public class ScheduleStatusRecyclerAdapter extends RecyclerView.Adapter<ScheduleStatusRecyclerAdapter.ViewHelper> {

    Context context;
    List<String> timeSlot;

    public ScheduleStatusRecyclerAdapter(Context activity, List<String> timeSlot){
        this.context = activity;
        this.timeSlot = timeSlot;
    }

    @Override
    public ScheduleStatusRecyclerAdapter.ViewHelper onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.doc_scheduling_item3,parent,false);
        return new ScheduleStatusRecyclerAdapter.ViewHelper(view);
    }

    @Override
    public void onBindViewHolder(ScheduleStatusRecyclerAdapter.ViewHelper holder, int position) {
        holder.tvItem.setText(timeSlot.get(position));
    }

    @Override
    public int getItemCount() {
        return timeSlot.size();
    }

    public class ViewHelper extends RecyclerView.ViewHolder
    {
        LinearLayout llItem;
        TextView tvItem;

        public ViewHelper(View itemView) {
            super(itemView);
            llItem = (LinearLayout) itemView.findViewById(R.id.llItem);
            tvItem = (TextView) itemView.findViewById(R.id.tvItem);
        }
    }
}
