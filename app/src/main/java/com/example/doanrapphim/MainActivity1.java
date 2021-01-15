package com.example.doanrapphim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

public class MainActivity1 extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    LinkedList<Phim1> listPhim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Load();


        Button btn_tiep = (Button) findViewById(R.id.tiep_theo);
        //final Intent changeActivity = new Intent(this, MainActivity2.class);
        btn_tiep.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(MainActivity1.this,MainActivity2.class);
                                            startActivity(intent);
                                            overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
                                        }
                                    });


        /*TextView Tenphim=(TextView)findViewById(R.id.textView_Tenphim);
        TextView Maghe=(TextView)findViewById(R.id.textView_Maghe);
        TextView Soluong=(TextView)findViewById(R.id.textView_Soluong);
        TextView Tongtien=(TextView)findViewById(R.id.textView_Tongtien);
        //InputStream is=getApplicationContext().getResources().openRawResource(R.raw.note);
        //BufferedReader br=new BufferedReader(new InputStreamReader(is));
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
            JSONArray jsonArray = jsonRootObject.optJSONArray("arr_Tintuc");
            //
            //3. Duyệt từng đối tượng trong Array và lấy giá trị ra

                JSONObject jsonObject = jsonArray.getJSONObject(0);
               // int id = Integer.parseInt(jsonObject.optString("id").toString());
                String tenphim = jsonObject.optString("TenPhim").toString();
                String maghe = jsonObject.optString("MaGhe").toString();
                String soluong = jsonObject.optString("SoLuong").toString();
                String tongtien = jsonObject.optString("ThanhTien").toString();
                dataTenphim += tenphim;
                dataMaghe +=maghe;
                dataSoluong +=soluong;
                dataTongtien += tongtien;


        } catch (JSONException e) {
            e.printStackTrace();
        }
        Tenphim.setText("a");
        Maghe.setText(dataMaghe);
        Soluong.setText(dataSoluong);
        Tongtien.setText(dataTongtien);*/

    }
    public void Load() {
        String url = "http://192.168.1.10/android/api.php";
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity1.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray arr_Tintuc = new JSONArray(response);
                            JSONObject item_phim;
                            listPhim = new LinkedList<>();
                            int len = arr_Tintuc.length();
                            //int dm;
                            //Toast.makeText(getApplicationContext(), "" + response, Toast.LENGTH_SHORT).show();
                            for (int i = 0; i < len; i++) {
                                item_phim = (JSONObject) arr_Tintuc.get(i);

                                listPhim.add(new Phim1(item_phim.getString("TenPhim"),
                                        item_phim.getString("MaGhe"),
                                        item_phim.getString("SoLuong"),
                                        item_phim.getString("ThanhTien")));
                                ImageView Anh =(ImageView)findViewById(R.id.image);
                                TextView Tenphim=(TextView)findViewById(R.id.textView_Tenphim);
                                TextView Maghe=(TextView)findViewById(R.id.textView_Maghe);
                                TextView Soluong=(TextView)findViewById(R.id.textView_Soluong);
                                TextView Tongtien=(TextView)findViewById(R.id.textView_Tongtien);


                                ImageView imvAvatar = (ImageView)findViewById(R.id.image);
                                imvAvatar.setImageResource(R.drawable.anh4);
                                Tenphim.setText(item_phim.getString("TenPhim"));
                                Maghe.setText(item_phim.getString("MaGhe"));
                                Soluong.setText(item_phim.getString("SoLuong"));
                                Tongtien.setText(item_phim.getString("ThanhTien"));
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