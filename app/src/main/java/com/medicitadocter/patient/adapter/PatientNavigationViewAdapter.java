package com.medicitadocter.patient.adapter;


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

public class PatientNavigationViewAdapter extends RecyclerView.Adapter<PatientNavigationViewAdapter.ViewHolder> {

    Context context;
    String[] getPatientNavItem;
    AdapterClickHandler clickHandler;

    public PatientNavigationViewAdapter(Context context, String[] getPatientNavItem, AdapterClickHandler clickHandler) {
        this.context = context;
        this.getPatientNavItem = getPatientNavItem;
        this.clickHandler = clickHandler;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.c_patient_navigation_list_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvNviItemName.setText(getPatientNavItem[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickHandler.onClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getPatientNavItem.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNviItemName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNviItemName = (TextView) itemView.findViewById(R.id.tvNviItemName);
        }
    }

}
