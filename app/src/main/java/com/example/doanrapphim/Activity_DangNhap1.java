package com.example.doanrapphim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activity_DangNhap1 extends AppCompatActivity {

    Button btnLogin,btnRegister;
    EditText txtEmail,txtPass,txtName;
    TextView tvKQ,tvLoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap1);
        btnLogin =findViewById(R.id.btn_login);
        btnRegister =findViewById(R.id.btn_register);
        txtEmail = findViewById(R.id.txtEmail_login);
        txtName = findViewById(R.id.txtName_login);
        txtPass = findViewById(R.id.txtPass_login);
        tvKQ =findViewById(R.id.txtKetQua);
        // tvLoi =findViewById(R.id.txtLoi);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resgisterFN(txtName.getText().toString(),txtEmail.getText().toString(),txtPass.getText().toString());
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginFN(txtEmail.getText().toString(),txtPass.getText().toString());
            }
        });
    }
    public void loginFN(String email,String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        User1 user1 = new User1();
        user1.setEmail(email);
        user1.setPassword(password);
        Request1 request1 = new Request1();
        request1.setUser(user1);
        request1.setOperation(Const.LOGIN_OPER);
        Interface1 interface1 = retrofit.create(Interface1.class);
        Call<Response1>call=interface1.getOperationFromCLient(request1);
        call.enqueue(new Callback<Response1>() {
            @Override
            public void onResponse(Call<Response1> call, Response<Response1> response) {
                Response1 response1 = response.body();
                String kq = response1.getMessage();
                if (response1.getResult().equals(Const.SUCCESS)){
                    Const.IS_LOGIN="true";
                    Const.EMAIL = response1.getUser().getEmail();
                }
                tvKQ.setText(kq + ": "+Const.EMAIL);
                Intent intent = new Intent(Activity_DangNhap1.this, Activity_TrangChu.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Response1> call, Throwable t) {
                String loi = t.getLocalizedMessage();
                  tvKQ.setText(loi);

            }
        });
    }
    public void resgisterFN(String name,String email,String password)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        User1 user1 = new User1();
        user1.setName(name);
        user1.setPassword(password);
        user1.setEmail(email);
        Request1 request1 = new Request1();
        request1.setOperation(Const.REGISTER_OPER);
        request1.setUser(user1);
        Interface1 interface1 = retrofit.create(Interface1.class);
        Call<Response1> call=interface1.getOperationFromCLient(request1);
        call.enqueue(new Callback<Response1>() {
            @Override
            public void onResponse(Call<Response1> call, Response<Response1> response) {
                Response1 response1 = response.body();
                String kq = response1.getMessage();
                tvKQ.setText(kq);
            }

            @Override
            public void onFailure(Call<Response1> call, Throwable t) {
                String loi = t.getLocalizedMessage();
                   tvKQ.setText(loi);
            }
        });
    }
}