package com.example.artistle.testforijevsk.Model.Data;

import com.example.artistle.testforijevsk.Model.UserModel;
import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by artistle on 26.11.17.
 */

public class Contacts extends SugarRecord {

    List<UserModel.Response> responses;

    public Contacts() {
    }

    public Contacts(List<UserModel.Response>  responses) {
        this.responses = responses;
    }
}
