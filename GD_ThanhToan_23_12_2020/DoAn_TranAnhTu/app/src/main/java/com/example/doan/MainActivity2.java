package com.example.doan;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnQuaylai=(Button)findViewById(R.id.btnQuaylai);
        btnQuaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
            }
        });


        Button btnThanhtoan=(Button)findViewById(R.id.btnThanhtoan);

        btnThanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText hoten=(EditText)findViewById(R.id.editText_Hoten);
                final String StrHoten=hoten.getText().toString();
                EditText email=(EditText)findViewById(R.id.editText_Email);
                final String StrEmail=email.getText().toString();
                EditText sdt=(EditText)findViewById(R.id.editText_SDT);
                final String StrSDT=sdt.getText().toString();
                if(StrHoten.trim().equals("")) {
                    Toast.makeText(MainActivity2.this, "Chưa nhập họ tên", Toast.LENGTH_SHORT).show();
                    return;
                }else if(StrEmail.trim().equals("")){
                    Toast.makeText(MainActivity2.this, "Chưa nhập Email", Toast.LENGTH_SHORT).show();
                    return;
                }else if(StrSDT.trim().equals("")){
                    Toast.makeText(MainActivity2.this, "Chưa nhập số điện thoại", Toast.LENGTH_SHORT).show();
                    return;
                }else {




                    EditText Hoten=(EditText)findViewById(R.id.editText_Hoten);
                    EditText Email=(EditText)findViewById(R.id.editText_Email);
                    EditText SDT=(EditText)findViewById(R.id.editText_SDT);
                    String dataHoten="";
                    String dataEmail="";
                    String dataSDT="";

                    dataHoten += Hoten.getText().toString();
                    dataEmail += Email.getText().toString();
                    dataSDT += SDT.getText().toString();

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





                    try {

                        JSONArray jsonarray = new JSONArray(StrJson);
                        for (int i = 0; i < jsonarray.length(); i++) {
                            JSONObject jsonobject = jsonarray.getJSONObject(i);
                            String name = jsonobject.getString("name");
                            String url = jsonobject.getString("url");
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(MainActivity2.this, "Thanh toán thành công", Toast.LENGTH_SHORT).show();



                }
            }
        });






    }



}