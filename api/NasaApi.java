package com.example.astrophoto.api;

import com.example.astrophoto.api.model.DateDTO;
import com.example.astrophoto.api.model.PhotoDTO;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NasaApi {

    @GET("natural/all")
    Single<List<DateDTO>> getDatesWithPhoto();

    @GET("natural/date/{date}")
    Single<List<PhotoDTO>> getPhotosForDate(@Path("date") String date);
}
