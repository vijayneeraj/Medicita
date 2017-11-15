package com.medicitadocter.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by linux on 29/6/17.
 */

public abstract class BaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(getLayoutResourceView(), parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        setData(holder, position);
    }

    @Override
    public int getItemCount() {
        return getItemSize();
    }

    /**
     * Get Resource View
     *
     * @return int return layout view id
     */
    protected abstract int getLayoutResourceView();


    protected abstract int getItemSize();

    protected void setData(RecyclerView.ViewHolder holder, int position) {

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
