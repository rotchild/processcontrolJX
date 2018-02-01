package com.project.cx.processcontrol.base;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.cx.processcontrol.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/24 0024.
 */

public  class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.ViewHolder> implements IAdapter<String> {
    private List<String> mItems;

    public BaseAdapter(List<String> items) {
        mItems=new ArrayList<String>();
        mItems.add("aaa");
        mItems.add("bbb");
        mItems.add("ccc");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText((String)mItems.get(position));
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return mItems!=null? mItems.size():0;
    }

    @Override
    public void setItems(List<String> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public void addItem(String item) {
        mItems.add(item);
        notifyDataSetChanged();
    }

    @Override
    public void delItem(String item) {
        mItems.remove(item);
        notifyDataSetChanged();
    }

    @Override
    public void addItems(List<String> items) {
        mItems.addAll(items);
    }

    @Override
    public void clearItems() {
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public String getItem(int position) {
        return mItems.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textview);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d("baseAdapter","you click");
        }
    }
}
