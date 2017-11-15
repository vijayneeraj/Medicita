package com.medicitadocter.doctor.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.medicitadocter.R;
import com.medicitadocter.doctor.dialogs.BillingDialog;
import com.medicitadocter.doctor.dialogs.DetailsDialog;
import com.medicitadocter.doctor.dialogs.PrescriptionsDilaog;
import com.medicitadocter.doctor.dialogs.VisitNotesDialog;

/**
 * Created by brsoft on 3/8/17.
 */

public class DashboardVisitHistoryAdapter extends RecyclerView.Adapter<DashboardVisitHistoryAdapter.ViewHelper> {

    Context context;

    public DashboardVisitHistoryAdapter(FragmentActivity activity){
        this.context = activity;
    }

    @Override
    public ViewHelper onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.doc_visit_history_item,parent,false);
        return new ViewHelper(view);
    }

    @Override
    public void onBindViewHolder(DashboardVisitHistoryAdapter.ViewHelper holder, int position) {
        holder.llDollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"llDollar",Toast.LENGTH_SHORT).show();
                BillingDialog billingDialog = new BillingDialog(context);
                billingDialog.show();
            }
        });

        holder.llPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"llPrint",Toast.LENGTH_SHORT).show();
                PrescriptionsDilaog prescriptionsDilaog = new PrescriptionsDilaog(context);
                prescriptionsDilaog.show();
            }
        });

        holder.llNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"llNote",Toast.LENGTH_SHORT).show();
                VisitNotesDialog visitNotesDialog = new VisitNotesDialog(context);
                visitNotesDialog.show();
            }
        });

        holder.llRx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"llRx",Toast.LENGTH_SHORT).show();
                DetailsDialog detailsDialog = new DetailsDialog(context);
                detailsDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHelper extends RecyclerView.ViewHolder
    {

        LinearLayout llPrint,llNote,llRx,llDollar;

        public ViewHelper(View itemView) {
            super(itemView);
            llPrint = (LinearLayout)itemView.findViewById(R.id.llPrint);
            llNote = (LinearLayout)itemView.findViewById(R.id.llNote);
            llRx = (LinearLayout)itemView.findViewById(R.id.llRx);
            llDollar = (LinearLayout)itemView.findViewById(R.id.llDollar);
        }
    }
}
