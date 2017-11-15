package com.medicitadocter.doctor.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.medicitadocter.R;

/**
 * Created by br on 29/8/17.
 */

public class WaitingRoomAttachmentRecylerAdapter extends RecyclerView.Adapter<WaitingRoomAttachmentRecylerAdapter.ViewHelper>
{

    private Context context;
    int itemWidth = 0;

    public WaitingRoomAttachmentRecylerAdapter(FragmentActivity activity) {
        this.context = activity;
        this.itemWidth = Math.round(((float)Resources.getSystem().getDisplayMetrics().widthPixels)/2);
    }

    @Override
    public WaitingRoomAttachmentRecylerAdapter.ViewHelper onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.doc_waiting_room_attachments_item,parent,false);
        return new WaitingRoomAttachmentRecylerAdapter.ViewHelper(itemView);
    }

    @Override
    public void onBindViewHolder(WaitingRoomAttachmentRecylerAdapter.ViewHelper holder, final int position)
    {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.llAttachmentItem.getLayoutParams();
        params.width = itemWidth;
        params.height =itemWidth;
        holder.llAttachmentItem.setLayoutParams(params);
        holder.tvAttachmentTitle.setText("Item "+position);
        holder.llAttachmentItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Item : "+position,Toast.LENGTH_SHORT).show();
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
        private ImageView ivAttachmentImage;
        private TextView tvAttachmentTitle;
        private LinearLayout llAttachmentItem;

        public ViewHelper(View itemView)
        {
            super(itemView);
            ivAttachmentImage = (ImageView) itemView.findViewById(R.id.ivAttachmentImage);
            tvAttachmentTitle = (TextView) itemView.findViewById(R.id.tvAttachmentTitle);
            llAttachmentItem = (LinearLayout) itemView.findViewById(R.id.llAttachmentItem);
        }
    }
}
