package com.example.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){
        if(retrofit==null){
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl("http://172.30.140.168:8080/");
            builder.addConverterFactory(GsonConverterFactory.create());

            retrofit = builder.build();
        }
        return retrofit;
    }

}
