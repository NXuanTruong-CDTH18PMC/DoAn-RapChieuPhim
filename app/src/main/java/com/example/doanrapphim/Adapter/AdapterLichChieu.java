package com.example.doanrapphim.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanrapphim.R;
import com.example.doanrapphim.Lop.LichChieu;
import com.example.doanrapphim.Lop.Rap;

import java.util.LinkedList;

public class AdapterLichChieu extends RecyclerView.Adapter<AdapterLichChieu.ViewHolder> {
    private LayoutInflater mInflater;
    private LinkedList<Rap> p = new LinkedList<>();
    private LinkedList<LichChieu> lichchieuses = new LinkedList<>();
    Context context;
    public AdapterLichChieu(LinkedList<Rap> p, LinkedList<LichChieu> a, Context context) {
        this.p = p;
        this.lichchieuses = a;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterLichChieu.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_giochieu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLichChieu.ViewHolder holder, int position) {
        holder.ten.setText(p.get(position).getTenrap());
        boolean isExpand = p.get(position).isExpand();
        holder.rChild.setVisibility(isExpand ? View.VISIBLE : View.GONE);
        GridLayoutManager gridLayout = new GridLayoutManager(context,3);
        holder.rChild.setLayoutManager(gridLayout);
        AdapterLichChieuSub child = new AdapterLichChieuSub(gioChieu(p.get(position).getId(), lichchieuses),context);
        holder.rChild.setAdapter(child);
    }

    @Override
    public int getItemCount() {
        return p.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ten;
        RecyclerView rChild;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ten = itemView.findViewById(R.id.tieude);
            rChild = itemView.findViewById(R.id.rcchild);
            ten.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Rap raps = p.get(getAdapterPosition());
                    raps.setExpand(!raps.isExpand());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }
    public LinkedList<LichChieu> gioChieu(int idPRap, LinkedList<LichChieu> b){
        LinkedList<LichChieu> lichchieuses = new LinkedList<>();
        for (LichChieu l: b) {
            if (idPRap == l.getRap()){
             lichchieuses.add(l);
            }
        }
        return lichchieuses;
    }
    public void filterl(LinkedList<Rap> liches, LinkedList<LichChieu> lichchieuses){
        p = liches;
        this.lichchieuses = lichchieuses;
        notifyDataSetChanged();
    }
}
