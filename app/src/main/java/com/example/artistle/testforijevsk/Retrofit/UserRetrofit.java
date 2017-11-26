package com.example.artistle.testforijevsk.Retrofit;

import com.example.artistle.testforijevsk.Model.UserModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserRetrofit {

    @GET("testTask.json")
    Observable<UserModel.Example> register();
}
