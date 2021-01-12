package com.example.doanrapphim.Activity_ChiTiet;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanrapphim.R;
import com.example.doanrapphim.Adapter.AdapterDatGhe;
import com.example.doanrapphim.Adapter.AdapterJson;
import com.example.doanrapphim.Lop.Ghe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class TabDatGhe extends AppCompatActivity {
    RecyclerView recyclerView;
    LinkedList<Ghe> Ghes = new LinkedList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_datghe);
        recyclerView = findViewById(R.id.rclview);
        layDsGhe();
        AdapterDatGhe adapterDatGhe = new AdapterDatGhe(Ghes,this);
        GridLayoutManager gridLayout = new GridLayoutManager(this,5);
        recyclerView.setLayoutManager(gridLayout);
        recyclerView.setAdapter(adapterDatGhe);
    }
    private void layDsGhe() {
        String d = new AdapterJson().read(this, R.raw.data);
        //Bundle bundle = getActivity().getIntent().getExtras();
       // int maPhim = bundle.getInt("id");
        try {
            JSONObject jsonRoot = new JSONObject(d);
            JSONArray jsonArray = jsonRoot.getJSONArray("ghe");
            int l = jsonArray.length();
            for (int i = 0; i < l; i++) {
               {
                   Ghe g = new Ghe();
                   g.setId(jsonArray.getJSONObject(i).getInt("id"));
                    g.setHang(jsonArray.getJSONObject(i).getString("hang"));
                    g.setCot(jsonArray.getJSONObject(i).getInt("cot"));
                    g.setRap(jsonArray.getJSONObject(i).getInt("rap"));
                    Ghes.add(i,g);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
