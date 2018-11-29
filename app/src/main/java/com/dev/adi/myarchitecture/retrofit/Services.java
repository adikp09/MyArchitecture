package com.dev.adi.myarchitecture.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface Services {

    @GET("/users")
    Call<List<User>> getUser();
}
