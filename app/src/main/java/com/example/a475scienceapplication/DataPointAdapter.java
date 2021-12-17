package com.example.a475scienceapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Adapted for adding data points to the recyclerview
 *
 */
public class DataPointAdapter extends RecyclerView.Adapter<DataPointAdapter.MyViewHolder> {

    // Array of datapoints
    ArrayList<DataPoint> datapoints;
    Context context;

    // Constructor
    public DataPointAdapter(ArrayList<DataPoint> datapoints, Context context) {
        this.datapoints = datapoints;
        this.context = context;
    }

    @NonNull
    @Override
    // Inflates a row for the recyclerview to display
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.datapoint_row, parent, false);

        return new MyViewHolder(view);
    }

    // Binds the data to the items in the recyclerview row
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.timestampView.setText(datapoints.get(position).timestamp);

        DataPoint tempdp = datapoints.get(position);
        String valueText = tempdp.value;

        holder.valueView.setText(valueText);
    }

    // returns the amount if items in the recyclerview
    @Override
    public int getItemCount() {

        return datapoints.size();

    }

    // subclass for the ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView timestampView, valueView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            timestampView = itemView.findViewById(R.id.timestampText);
            valueView = itemView.findViewById(R.id.datavalueText);
        }
    }
}
