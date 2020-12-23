package com.example.doan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Button btntiep= (Button) findViewById(R.id.tiep_theo) ;
        btntiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });*/

        Button btn_tiep = (Button) findViewById(R.id.tiep_theo);
        //final Intent changeActivity = new Intent(this, MainActivity2.class);
        btn_tiep.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                                            startActivity(intent);
                                            overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
                                        }
                                    });


        TextView Tenphim=(TextView)findViewById(R.id.textView_Tenphim);
        TextView Maghe=(TextView)findViewById(R.id.textView_Maghe);
        TextView Soluong=(TextView)findViewById(R.id.textView_Soluong);
        TextView Tongtien=(TextView)findViewById(R.id.textView_Tongtien);
        InputStream is=getApplicationContext().getResources().openRawResource(R.raw.note);
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        StringBuilder sb=new StringBuilder();
        String s=null;
        while (true){
            try {
                if(!((s=br.readLine())!=null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            sb.append(s);
            sb.append("\n");
        }
        final String StrJson = sb.toString();
        String dataTenphim="";
        String dataMaghe="";
        String dataSoluong="";
        String dataTongtien="";
        try {
            //1. Khai báo đối tượng json root object
            JSONObject jsonRootObject = new JSONObject(StrJson);

            //2. Đưa jsonRootObject vào array object
            JSONArray jsonArray = jsonRootObject.optJSONArray("ds");
            //
            //3. Duyệt từng đối tượng trong Array và lấy giá trị ra

                JSONObject jsonObject = jsonArray.getJSONObject(0);
                int id = Integer.parseInt(jsonObject.optString("id").toString());
                String tenphim = jsonObject.optString("tenphim").toString();
                String maghe = jsonObject.optString("maghe").toString();
                String soluong = jsonObject.optString("soluong").toString();
                String tongtien = jsonObject.optString("tongtien").toString();
                dataTenphim += tenphim;
                dataMaghe +=maghe;
                dataSoluong +=soluong;
                dataTongtien += tongtien;


        } catch (JSONException e) {
            e.printStackTrace();
        }
        Tenphim.setText(dataTenphim);
        Maghe.setText(dataMaghe);
        Soluong.setText(dataSoluong);
        Tongtien.setText(dataTongtien);










        /*InputStream is=getApplicationContext().getResources().openRawResource(R.raw.note);
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        StringBuilder sb=new StringBuilder();
        String s=null;
        while (true){
            try {
                if(!((s=br.readLine())!=null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            sb.append(s);
            sb.append("\n");
        }
        final String sJson = sb.toString();

        try {
            JSONObject jsonRoot = new JSONObject(sJson);
            JSONArray jsonArray=jsonRoot.getJSONArray("ds");
            int len=jsonArray.length();
            for(int i=0;i<len;i++){
                mWordList.addLast(jsonArray.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Button bt=findViewById(R.id.tiep_theo);
        FloatingActionButton fab = findViewById(R.id.fab);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //.setAction("Action", null).show();

                Toast.makeText(getApplicationContext(),mWordList.getFirst(),Toast.LENGTH_LONG).show();;
            }
        });*/
    }

}