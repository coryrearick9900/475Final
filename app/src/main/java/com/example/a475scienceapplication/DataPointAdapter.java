package com.example.a475scienceapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class DataPointAdapter extends RecyclerView.Adapter<DataPointAdapter.MyViewHolder> {

    ArrayList<DataPoint> datapoints;
    Context context;

    public DataPointAdapter(ArrayList<DataPoint> datapoints, Context context) {
        this.datapoints = datapoints;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.datapoint_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.timestampView.setText(datapoints.get(position).timestamp);

        double value = datapoints.get(position).value;
        String valueText = "" + value;

        holder.valueView.setText(valueText);
    }

    @Override
    public int getItemCount() {
        return datapoints.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView timestampView, valueView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            timestampView = itemView.findViewById(R.id.timestampText);
            valueView = itemView.findViewById(R.id.datavalueText);
        }
    }
}
