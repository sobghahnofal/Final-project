package com.excelreader.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.excelreader.R;
import com.excelreader.models.DummyData;

import java.util.ArrayList;

public class DummyDataListRecycleViewAdapter extends RecyclerView.Adapter<DummyDataListRecycleViewAdapter.ViewHolder> {

    private ArrayList<DummyData> dummyData = new ArrayList<>();

    private int lastPosition = -1;

    private Context context;

    public DummyDataListRecycleViewAdapter(ArrayList<DummyData> dummyData, Context context) {
        this.dummyData = dummyData;
        this.context = context;
    }

    @NonNull
    @Override
    public DummyDataListRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DummyDataListRecycleViewAdapter.ViewHolder holder, int position) {
        holder.sno.setText(String.valueOf(dummyData.get(position).getsNo()));
        holder.group.setText(String.valueOf(dummyData.get(position).getGroup()));
        holder.sec.setText(String.valueOf(dummyData.get(position).getSec()));
        holder.name.setText(String.valueOf(dummyData.get(position).getName()));
        holder.kauid.setText(String.valueOf(dummyData.get(position).getKauid()));
        holder.q1.setText(String.valueOf(dummyData.get(position).getQ1()));
        holder.q2.setText(String.valueOf(dummyData.get(position).getQ2()));
        holder.q3.setText(String.valueOf(dummyData.get(position).getQ3()));
        holder.q4.setText(String.valueOf(dummyData.get(position).getQ4()));
    }

    @Override
    public int getItemCount() {
        return dummyData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView sno, group, sec, name, kauid, q1, q2, q3, q4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sno = itemView.findViewById(R.id.sno);
            group = itemView.findViewById(R.id.group);
            sec = itemView.findViewById(R.id.sec);
            name = itemView.findViewById(R.id.name);
            kauid = itemView.findViewById(R.id.kauid);
            q1 = itemView.findViewById(R.id.q1);
            q2 = itemView.findViewById(R.id.q2);
            q3 = itemView.findViewById(R.id.q3);
            q4 = itemView.findViewById(R.id.q4);
        }
    }
}
