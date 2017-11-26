package com.example.artistle.testforijevsk;
 import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.support.v7.widget.LinearLayoutManager;
 import android.support.v7.widget.RecyclerView;
 import android.util.Log;

 import com.example.artistle.testforijevsk.Adapter.UserAdapter;
 import com.example.artistle.testforijevsk.Data.Contacts;
 import com.example.artistle.testforijevsk.Model.UserModel;
 import com.example.artistle.testforijevsk.Retrofit.UserRetrofit;
 import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
 import java.util.List;
 import io.reactivex.android.schedulers.AndroidSchedulers;
 import io.reactivex.disposables.CompositeDisposable;
 import io.reactivex.schedulers.Schedulers;
 import retrofit2.Retrofit;
 import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://gitlab.65apps.com/65gb/static/raw/master/";
    private RecyclerView recyclerView;
    private CompositeDisposable compositeDisposable;
    private UserAdapter adapter;
    private List<UserModel.Response> infoListModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compositeDisposable = new CompositeDisposable();

        initRecyclerView();
        loadJSON();
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    private void loadJSON() {
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
        infoListModels = userList.getResponse();
        adapter = new UserAdapter(infoListModels);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        Contacts contacts = new Contacts(infoListModels);
        contacts.save();
    }
    private void handleError(Throwable error) {
        Log.e("TAG","Error" + error.getLocalizedMessage());
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
