package com.example.artistle.testforijevsk.View;

import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpView;
import com.example.artistle.testforijevsk.Presenter.Adapter.UserAdapter;

/**
 * Created by artistle on 03.12.17.
 */

public interface View extends MvpView {
    public void setAdapter(UserAdapter adapter);
    public void initRecyclerView(RecyclerView.LayoutManager layoutManager);
}
