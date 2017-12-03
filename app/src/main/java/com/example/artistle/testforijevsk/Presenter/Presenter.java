package com.example.artistle.testforijevsk.Presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.artistle.testforijevsk.Presenter.Adapter.UserAdapter;
import com.example.artistle.testforijevsk.Model.UserModel;
import com.example.artistle.testforijevsk.Presenter.Retrofit.UserRetrofit;
import com.example.artistle.testforijevsk.View.View;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InjectViewState
public class Presenter extends MvpPresenter<View> {

    private static final String BASE_URL = "http://gitlab.65apps.com/65gb/static/raw/master/";
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private UserAdapter adapter;
    private List<UserModel.Response> infoListModels;

    public void loadJson(){

        UserRetrofit userRetrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(UserRetrofit.class);

        compositeDisposable.add(userRetrofit.register()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError));
}
    private void handleResponse(UserModel.Example userList) {
        Adapter(userList);

        //Contacts contacts = new Contacts(infoListModels);
        //contacts.save();
    }
    private void handleError(Throwable error) {
        Log.e("TAG","Error" + error.getLocalizedMessage());
    }

    public void Adapter(UserModel.Example userList){
        infoListModels = userList.getResponse();
        adapter = new UserAdapter(infoListModels);
        adapter.notifyDataSetChanged();

        getViewState().setAdapter(adapter);
    }
}
