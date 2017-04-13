package com.example.administrator.adapterdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * 九宫格的viewholder
 * Created by Administrator on 2017/2/22 0022.
 */

public class ExampleViewHolder<T> extends RecyclerView.ViewHolder {
    public ExampleViewHolder(int viewId, ViewGroup parent, int viewType) {
        super(((LayoutInflater) parent.getContext().getSystemService(parent.getContext().LAYOUT_INFLATER_SERVICE)).inflate
                (viewId, parent,false));
    }
    public void refreshData(T data, int position) {

    }
}
