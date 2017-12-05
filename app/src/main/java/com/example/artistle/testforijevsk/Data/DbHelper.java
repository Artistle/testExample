package com.example.artistle.testforijevsk.Data;
import com.example.artistle.testforijevsk.Model.UserModel;
import com.orm.SugarRecord;

import java.util.List;

public class DbHelper extends SugarRecord {

    List<UserModel.Response> responseList;

    public DbHelper() {
    }

    public DbHelper(List<UserModel.Response> responseList) {
        this.responseList = responseList;
    }

    public void db(){

    }
}
