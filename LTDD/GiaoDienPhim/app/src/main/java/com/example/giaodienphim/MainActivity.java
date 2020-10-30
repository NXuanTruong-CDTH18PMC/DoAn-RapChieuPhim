package com.example.giaodienphim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listview);

        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Phim kinh di");
        arrayList.add("Phim hanh dong");
        arrayList.add("Phim hai");
        arrayList.add("Phim trinh tham");
        arrayList.add("Phim KH vien tuong");
        arrayList.add("Phim kinh di");
        arrayList.add("Phim hanh dong");
        arrayList.add("Phim hai");
        arrayList.add("Phim trinh tham");
        arrayList.add("Phim KH vien tuong");
        arrayList.add("Phim kinh di");
        arrayList.add("Phim hanh dong");
        arrayList.add("Phim hai");
        arrayList.add("Phim trinh tham");
        arrayList.add("Phim KH vien tuong");
        arrayList.add("Phim kinh di");
        arrayList.add("Phim hanh dong");
        arrayList.add("Phim hai");
        arrayList.add("Phim trinh tham");
        arrayList.add("Phim KH vien tuong");

        final ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(MainActivity.this,"click item:"+i+" "+arrayList.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}