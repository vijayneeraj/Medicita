package com.medicitadocter.doctor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.medicitadocter.R;
import com.medicitadocter.custom.CustomTextView;
import com.medicitadocter.doctor.model.DashBoardDoctorMenuModal;

import java.util.ArrayList;

/**
 * Created by ubuntu on 26/6/17.
 */

public class DoctorAdditionalAdapter extends RecyclerView.Adapter<DoctorAdditionalAdapter.Viewholders> {
    Context context;
    ArrayList<DashBoardDoctorMenuModal> dashmenu_list;
    DashboardClickListners clickListners;

    public DoctorAdditionalAdapter(Context context, ArrayList<DashBoardDoctorMenuModal> dashmenu_list) {
        this.context = context;
        this.dashmenu_list = dashmenu_list;
    }

    @Override
    public Viewholders onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.c_patients_additional_adapte_item, parent, false);
        return new Viewholders(itemView);
    }

    @Override
    public void onBindViewHolder(Viewholders holder, int position) {
        holder.bindViews(dashmenu_list.get(position), clickListners);
    }

    @Override
    public int getItemCount() {
        return dashmenu_list.size();
    }

    public void setDashboardClickListenrs(DashboardClickListners clickListners) {
        this.clickListners = clickListners;
    }

    public interface DashboardClickListners {
        void DasboardClick(DashBoardDoctorMenuModal menuModal);
    }

    public class Viewholders extends RecyclerView.ViewHolder {
        private ImageView mIv_DashMenuImg;
        private CustomTextView mTv_DashTital;

        public Viewholders(View itemView) {

            super(itemView);
            iniviews();
        }

        private void iniviews() {
            mIv_DashMenuImg = (ImageView) itemView.findViewById(R.id.iv_dashmenuimg);
            mTv_DashTital = (CustomTextView) itemView.findViewById(R.id.tv_dashtital);
        }


        public void bindViews(final DashBoardDoctorMenuModal menuModal, final DashboardClickListners clickListners) {
            mIv_DashMenuImg.setImageResource(menuModal.getImgSrc());
            mTv_DashTital.setText(menuModal.getMenutital());

            mIv_DashMenuImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListners != null) {
                        clickListners.DasboardClick(menuModal);
                    }
                }
            });

        }
    }
}
