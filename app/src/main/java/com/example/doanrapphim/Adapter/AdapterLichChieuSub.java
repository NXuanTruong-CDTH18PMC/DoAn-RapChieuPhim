package com.example.doanrapphim.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanrapphim.R;
import com.example.doanrapphim.Activity_ChiTiet.TabDatGhe;
import com.example.doanrapphim.Lop.LichChieu;

import java.util.LinkedList;

public class AdapterLichChieuSub extends RecyclerView.Adapter<AdapterLichChieuSub.ViewHolder> {
    private LayoutInflater mInflater;
    private LinkedList<LichChieu> p = new LinkedList<>();
    Context context;
    private  RecyclerView.RecycledViewPool child = new RecyclerView.RecycledViewPool();

    public AdapterLichChieuSub(LinkedList<LichChieu> p, Context context) {
        this.p = p;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterLichChieuSub.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_giochieusub,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLichChieuSub.ViewHolder holder, int position) {
        holder.btn.setText(p.get(position).getGiochieu());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TabDatGhe.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return p.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btn;
        RecyclerView rChild;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.btngiochieu);
        }
    }
}
