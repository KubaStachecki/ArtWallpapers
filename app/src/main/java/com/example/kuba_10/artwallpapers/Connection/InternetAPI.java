package com.example.kuba_10.artwallpapers.Connection;

import com.example.kuba_10.artwallpapers.Model.Film;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Kuba-10 on 10.07.2017.
 */

public interface InternetAPI {

    @GET("get/bSciNrOTCa?indent=2")
    Observable<List<Film>> getData();
}
