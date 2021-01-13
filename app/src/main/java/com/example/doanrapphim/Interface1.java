package com.example.doanrapphim;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Interface1 {
    @POST("index.php")
    Call<Response1> getOperationFromCLient(@Body Request1 request1);
}