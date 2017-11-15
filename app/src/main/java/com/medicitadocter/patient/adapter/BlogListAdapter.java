package com.medicitadocter.patient.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medicitadocter.R;

/**
 * Created by brsoft on 3/8/17.
 */

public class BlogListAdapter extends RecyclerView.Adapter<BlogListAdapter.Viewholder> {

    public BlogListAdapter(FragmentActivity activity){

    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.c_item_blog_list,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        public Viewholder(View itemView) {
            super(itemView);
        }
    }
}
