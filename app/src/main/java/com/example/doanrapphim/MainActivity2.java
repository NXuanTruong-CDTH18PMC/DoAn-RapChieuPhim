package com.example.doanrapphim;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class MainActivity2 extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    LinkedList<ThanhVien> listThanhVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Load();

        Button btnQuaylai=(Button)findViewById(R.id.btnQuaylai);
        btnQuaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity1.class);
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

                    Toast.makeText(MainActivity2.this, "Thanh toán thành công", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    public void Load() {
        String url = "http://192.168.1.10/android/api2.php";
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity2.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray arr_Tintuc = new JSONArray(response);
                            JSONObject item_tintuc;
                            listThanhVien = new LinkedList<ThanhVien>();
                            int len = arr_Tintuc.length();
                            //int dm;
                            //Toast.makeText(getApplicationContext(), "" + response, Toast.LENGTH_SHORT).show();
                            for (int i = 0; i < len; i++) {
                                item_tintuc = (JSONObject) arr_Tintuc.get(i);
                                //dm = item_tintuc.getInt("dm");
                                // int anh = R.drawable.ic_launcher_background;
                                //if (dm == 1) anh = R.drawable.icon1;
                                //else if (dm == 2) anh = R.drawable.icon2;
                                //else anh = R.drawable.icon3;

                                listThanhVien.add(new ThanhVien(item_tintuc.getString("TenTV"),
                                        item_tintuc.getString("Email"),
                                        item_tintuc.getString("SDT")));
                                TextView TenTV=(TextView)findViewById(R.id.editText_Hoten);
                                TextView Email=(TextView)findViewById(R.id.editText_Email);
                                TextView SDT=(TextView)findViewById(R.id.editText_SDT);

                                TenTV.setText(item_tintuc.getString("TenTV"));
                                Email.setText(item_tintuc.getString("Email"));
                                SDT.setText(item_tintuc.getString("SDT"));

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Lỗi", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(stringRequest);
    }



}