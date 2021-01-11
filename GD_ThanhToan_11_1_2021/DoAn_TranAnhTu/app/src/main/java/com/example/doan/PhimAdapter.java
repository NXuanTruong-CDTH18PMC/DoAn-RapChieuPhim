package com.example.doan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class PhimAdapter extends RecyclerView.Adapter<PhimAdapter.PhimViewHolder> {

    private LinkedList<Phim> lstPhim;
    private Context context;

    public PhimAdapter(LinkedList<Phim> lstPhim,Context context) {
        this.lstPhim=lstPhim;
        this.context=context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public PhimViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        return new PhimViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phim, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull PhimAdapter.PhimViewHolder holder, int position) {
        holder.tenphim.setText(lstPhim.get(position).getTenPhim());
        holder.maghe.setText(lstPhim.get(position).getMaGhe());
        holder.soluong.setText(lstPhim.get(position).getSoLuong());
        holder.thanhtien.setText(lstPhim.get(position).getThanhTien());
    }

    @Override
    public int getItemCount() {
        return lstPhim.size();
    }
    

    public class PhimViewHolder extends RecyclerView.ViewHolder {
        TextView tenphim, maghe, soluong, thanhtien;
        public PhimViewHolder(View itemView) {
            super(itemView);
            tenphim = (TextView) itemView.findViewById(R.id.txttenphim);
            maghe = (TextView) itemView.findViewById(R.id.txtmaghe);
            soluong = (TextView) itemView.findViewById(R.id.txtsoluong);
            thanhtien = (TextView) itemView.findViewById(R.id.txtthanhtien);
        }
    }
}
