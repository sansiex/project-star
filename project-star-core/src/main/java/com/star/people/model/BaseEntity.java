package com.star.people.model;

import com.google.gson.Gson;

/**
 * Created by zuhai.jiang on 2015/12/22.
 */
public class BaseEntity {

    public String toString(){
        return new Gson().toJson(this);
    }
}
