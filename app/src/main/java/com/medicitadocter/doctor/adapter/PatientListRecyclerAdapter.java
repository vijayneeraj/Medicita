package com.medicitadocter.doctor.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.medicitadocter.R;
import com.medicitadocter.doctor.dialogs.EnrolledDialog;

/**
 * Created by br on 10/8/17.
 */

public class PatientListRecyclerAdapter extends RecyclerView.Adapter<PatientListRecyclerAdapter.ViewHelper>
{

    private Context context;

    public PatientListRecyclerAdapter(FragmentActivity activity) {
        this.context = activity;
    }

    @Override
    public PatientListRecyclerAdapter.ViewHelper onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.doc_patient_item,parent,false);
        return new PatientListRecyclerAdapter.ViewHelper(itemView);

    }

    @Override
    public void onBindViewHolder(PatientListRecyclerAdapter.ViewHelper holder, int position)
    {
        holder.tvErolled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnrolledDialog enrolledDialog = new EnrolledDialog(context);
                enrolledDialog.show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return 10;
    }

    public class ViewHelper extends RecyclerView.ViewHolder
    {
        private ImageView ivPatientProfilePic;
        private ImageView ivGender;
        private TextView tvName,tvPhoneNo,tvEmail,tvGender,tvDate,tvErolled;

        public ViewHelper(View itemView)
        {
            super(itemView);
            ivPatientProfilePic = (ImageView) itemView.findViewById(R.id.ivPatientProfilePic);
            ivGender = (ImageView) itemView.findViewById(R.id.ivGender);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPhoneNo = (TextView) itemView.findViewById(R.id.tvPhoneNo);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            tvGender = (TextView) itemView.findViewById(R.id.tvGender);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvErolled = (TextView) itemView.findViewById(R.id.tvErolled);
        }
    }

}
