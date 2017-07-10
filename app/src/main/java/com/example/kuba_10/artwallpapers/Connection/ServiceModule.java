package com.example.kuba_10.artwallpapers.Connection;

import com.example.kuba_10.artwallpapers.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



@Module
public class ServiceModule {

    private String mBaseURL;
    public ServiceModule(String mBaseURL) {
        this.mBaseURL = mBaseURL;
    }

    @Singleton
    @Provides
    GsonConverterFactory provideGson(){return GsonConverterFactory.create();}

    @Singleton
    @Provides
    RxJava2CallAdapterFactory provideRxJava(){return RxJava2CallAdapterFactory.create();}

    @Singleton
    @Provides

    Retrofit provideRetrofit(GsonConverterFactory gson, RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
        return new Retrofit.Builder()
                .addConverterFactory(gson)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .baseUrl(mBaseURL)
                .build();




    }}