package com.demodocker.retrofit;

import java.io.IOException;

import retrofit2.Call;

public class GenericCallRetrofit {
    public static <T> T request(Call<T> callSync) {
        try {
            return callSync.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    } 
}
