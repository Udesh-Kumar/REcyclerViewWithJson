package com.example.cc.recyclerviewwithjson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("volley_array.json")
    Call<List<ModalClass>> getMovies();


}
