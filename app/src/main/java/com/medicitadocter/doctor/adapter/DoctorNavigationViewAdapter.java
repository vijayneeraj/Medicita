package com.medicitadocter.doctor.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.medicitadocter.R;
import com.medicitadocter.handler.AdapterClickHandler;

/**
 * Created by linux on 29/6/17.
 */

public class DoctorNavigationViewAdapter extends RecyclerView.Adapter<DoctorNavigationViewAdapter.ViewHolder> {

    Context context;
    String[] getDoctorNavItem;
    AdapterClickHandler clickHandler;

    public DoctorNavigationViewAdapter(Context context, String[] getDoctorNavItem, AdapterClickHandler clickHandler) {
        this.context = context;
        this.getDoctorNavItem = getDoctorNavItem;
        this.clickHandler = clickHandler;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup doctor, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.c_patient_navigation_list_item_layout, doctor, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvNviItemName.setText(getDoctorNavItem[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickHandler.onClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getDoctorNavItem.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNviItemName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNviItemName = (TextView) itemView.findViewById(R.id.tvNviItemName);
        }
    }

}
