package com.example.artistle.testforijevsk.View;

import com.arellomobile.mvp.MvpView;
import com.example.artistle.testforijevsk.Presenter.Adapter.UserAdapter;

/**
 * Created by artistle on 03.12.17.
 */

public interface View extends MvpView {
    public void setAdapter(UserAdapter adapter);
}
