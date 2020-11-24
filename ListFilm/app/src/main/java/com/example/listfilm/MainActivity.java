package com.example.listfilm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListListener{

    private Button buttonAddFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView listFilmRecyclerView = findViewById(R.id.listFilmRecyclerView);
        buttonAddFilm = findViewById(R.id.buttonAddFilm);

        final List<ListFilm> listFilms = new ArrayList<>();

        ListFilm item1 = new ListFilm();
        item1.image = R.drawable.item1;
        item1.name = "Infinity War";
        item1.rating = 5f;
        item1.createdBy = "Marvel Studio";
        item1.story = "Superheroes fight to protect earth peace";
        listFilms.add(item1);

        ListFilm item2 = new ListFilm();
        item2.image = R.drawable.item2;
        item2.name = "EndGame";
        item2.rating = 5f;
        item2.createdBy = "Marvel Studio";
        item2.story = "Superheroes fight to protect earth peace part 2.";
        listFilms.add(item2);


        ListFilm item3 = new ListFilm();
        item3.image = R.drawable.item3;
        item3.name = "Mat Biec";
        item3.rating = 4.5f;
        item3.createdBy = "Victor Vu";
        item3.story = " The story about love of old school students and promises for the future does not come true.";
        listFilms.add(item3);



        ListFilm item4 = new ListFilm();
        item4.image = R.drawable.item4;
        item4.name = "Ròm";
        item4.rating = 4f;
        item4.createdBy = "Vu Quang Huy";
        item4.story = "The movie is about a boy struggling to get money to live a living.";
        listFilms.add(item4);

        ListFilm item5 = new ListFilm();
        item5.image = R.drawable.item5;
        item5.name = "Tiec trang mau";
        item5.rating = 4f;
        item5.createdBy = "Nguyen Quang Dung";
        item5.story = "The film with many complex psychological details";
        listFilms.add(item5);


        ListFilm item6 = new ListFilm();
        item6.image = R.drawable.item6;
        item6.name = "Lion King";
        item6.rating = 5f;
        item6.createdBy = "Disney";
        item6.story = "The process of rising and asserting yourself of a lion.";
        listFilms.add(item6);


        ListFilm item7 = new ListFilm();
        item7.image = R.drawable.item7;
        item7.name = "Aladin";
        item7.rating = 4f;
        item7.createdBy = "Disney";
        item7.story = "The story about a guy named Aladin and his magic lamp.";
        listFilms.add(item7);

        ListFilm item8 = new ListFilm();
        item8.image = R.drawable.item8;
        item8.name = "Parasite";
        item8.rating = 5f;
        item8.createdBy = "Boong Joon Ho";
        item8.story = "Talk about a family for money that has defied everything to get and get a satisfactory ending.";
        listFilms.add(item8);

        final ListAdapter listAdapter = new ListAdapter(listFilms,this);
        listFilmRecyclerView.setAdapter(listAdapter);
        buttonAddFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ListFilm> selectedListFilms = listAdapter.getSelectedLists();
                StringBuilder listNames = new StringBuilder();
                for(int i = 0; i < selectedListFilms.size(); i++){
                    if(i==0){
                        listNames.append(selectedListFilms.get(i).name);
                    }else{
                        listNames.append("\n").append(selectedListFilms.get(i).name);
                    }
                }
                Toast.makeText(MainActivity.this, listNames.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onListAction(Boolean isSelected) {
        if(isSelected){
    buttonAddFilm.setVisibility(View.VISIBLE);
        }else{
            buttonAddFilm.setVisibility(View.GONE);
        }
    }
}