package com.project.cx.processcontrol.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.cx.processcontrol.R;
import com.project.cx.processcontrol.model.bean.TaskCK;

import java.util.List;

/**
 * Created by Administrator on 2018/1/25 0025.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public List<TaskCK> dataList;

    public MyAdapter(List<TaskCK> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dck,parent,false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        TaskCK taskCK=dataList.get(position);
        holder.caseNo.setText(taskCK.getCaseNo());
        holder.licenseno.setText(taskCK.getLicenseno());
        holder.caseTime.setText(taskCK.getCaseTime());
        holder.outNumber.setText(taskCK.getOutNumber());
        holder.risklevel.setText(taskCK.getRisklevel());
        holder.hurt_state.setText(taskCK.getHurt_state());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView caseNo,licenseno,caseTime,outNumber,risklevel,riskstate,hurt_state;
        public ViewHolder(View itemView) {
            super(itemView);
            caseNo= itemView.findViewById(R.id.dck_caseNo);
            licenseno= itemView.findViewById(R.id.dck_licenseno);
            caseTime= itemView.findViewById(R.id.dck_caseTime);
            outNumber= itemView.findViewById(R.id.dck_outNumber);
            risklevel= itemView.findViewById(R.id.dck_risklevel);
            riskstate= itemView.findViewById(R.id.dck_riskstate);
            hurt_state= itemView.findViewById(R.id.dck_hurt_state);
        }
    }
}
