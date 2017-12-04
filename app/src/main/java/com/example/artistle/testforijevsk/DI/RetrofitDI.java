package com.example.artistle.testforijevsk.DI;

import com.example.artistle.testforijevsk.Model.UserModel;
import com.example.artistle.testforijevsk.Presenter.Retrofit.UserRetrofit;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitDI {


    @Provides
    @Singleton
    public UserRetrofit retrofit(){
        UserRetrofit userRetrofit = new Retrofit.Builder()
                .baseUrl("http://gitlab.65apps.com/65gb/static/raw/master/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(UserRetrofit.class);

        return userRetrofit;
    }

}
