package com.example.artistle.testforijevsk.Activity;
 import android.os.Bundle;
 import android.provider.ContactsContract;
 import android.support.v7.widget.LinearLayoutManager;
 import android.support.v7.widget.RecyclerView;

 import com.arellomobile.mvp.MvpActivity;
 import com.arellomobile.mvp.presenter.InjectPresenter;
 import com.example.artistle.testforijevsk.Presenter.Adapter.UserAdapter;
 import com.example.artistle.testforijevsk.Data.DataRx;
 import com.example.artistle.testforijevsk.Presenter.Presenter;
 import com.example.artistle.testforijevsk.R;
 import com.example.artistle.testforijevsk.View.View;

 import java.lang.*;

public class MainActivity extends MvpActivity implements View {
    private RecyclerView recyclerView;
    private DataRx dataRx;

    @InjectPresenter
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataRx = new DataRx();
        initRecyclerView();

        presenter.loadJson();
        dataRx.Load();
    }
    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }
    @Override
    public void setAdapter(UserAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
