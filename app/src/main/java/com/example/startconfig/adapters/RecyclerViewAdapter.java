package com.example.startconfig.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.startconfig.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> stats;


    public RecyclerViewAdapter(ArrayList<String> stats) {
        this.stats = stats;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        holder.setIsRecyclable(false);

        final String status = stats.get(position);

        holder.setStatus(position+1 + ".) " + status);


    }

    @Override
    public int getItemCount() {
        return stats.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private TextView status;

        ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

        }

        void setStatus(String paStatus) {
            status = mView.findViewById(R.id.recycleViewItem);
            status.setText(paStatus);
        }
    }
}
