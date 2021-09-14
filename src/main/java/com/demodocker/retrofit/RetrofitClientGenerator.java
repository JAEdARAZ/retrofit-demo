package com.demodocker.retrofit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demodocker.retrofit.client.MoviesClient;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitClientGenerator {
    @Value("${tmdb.baseurl}")
    private String BASE_URL_TMDB;

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC);

    public static <S> S createService(Class<S> serviceClass, Retrofit retrofit) {
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging);
        }
        return retrofit.create(serviceClass);
    }

    @Bean
    public MoviesClient moviesClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL_TMDB).client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create()).build();
        return createService(MoviesClient.class, retrofit);
    }
}
