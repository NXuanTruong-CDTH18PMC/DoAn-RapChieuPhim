package com.example.listfilm;

import android.media.Rating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>{
    private List<ListFilm> listFilms;
    private ListListener listListener;

    public ListAdapter(List<ListFilm> listFilms, ListListener listListener) {
        this.listFilms = listFilms;
        this.listListener = listListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_ds,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
holder.bindList(listFilms.get(position));
    }

    @Override
    public int getItemCount() {
        return listFilms.size();
    }

    public List<ListFilm> getSelectedLists(){
        List<ListFilm> selectedLists = new ArrayList<>();
        for(ListFilm listFilm : listFilms){
            if(listFilm.isSelected){
                selectedLists.add(listFilm);
            }
        }
        return selectedLists;
    }


    class ListViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout layoutList;
        View viewBackground;
        RoundedImageView imageList;
        TextView textName, textCreatedBy, textStory;
        RatingBar ratingBar;
        ImageView imageSelected;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutList = itemView.findViewById(R.id.layoutList);
            viewBackground = itemView.findViewById(R.id.viewBackground);
            imageList = itemView.findViewById(R.id.imageList);
            textName = itemView.findViewById(R.id.textName);
            textCreatedBy = itemView.findViewById(R.id.textCreateBy);
            textStory = itemView.findViewById(R.id.textStory);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imageSelected = itemView.findViewById(R.id.imageSelected);
        }

        void bindList(final ListFilm listFilm){
            imageList.setImageResource(listFilm.image);
            textName.setText(listFilm.name);
            textCreatedBy.setText(listFilm.createdBy);
            textStory.setText(listFilm.story);
            ratingBar.setRating(listFilm.rating);
            if(listFilm.isSelected){
                viewBackground.setBackgroundResource(R.drawable.danh_sach_selected_background);
                imageSelected.setVisibility(View.VISIBLE);
            }
            else{
                viewBackground.setBackgroundResource(R.drawable.danh_sach_background);
                imageSelected.setVisibility(View.GONE);
            }
            layoutList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listFilm.isSelected){
                        viewBackground.setBackgroundResource(R.drawable.danh_sach_background);
                        imageSelected.setVisibility(View.GONE);
                        listFilm.isSelected = false;
                        if(getSelectedLists().size()==0){
                            listListener.onListAction(false);
                        }
                    }else{
                        viewBackground.setBackgroundResource(R.drawable.danh_sach_selected_background);
                        imageSelected.setVisibility(View.VISIBLE);
                        listFilm.isSelected = true;
                        listListener.onListAction(true);
                    }
                }
            });
        }
    }
}
