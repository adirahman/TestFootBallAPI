package com.arc.footballapi;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

public class BaseRepo {
    public Context context;
    public ResponseCourier courier;
    public Map<String,Object> headerRequest = new HashMap<>();
    public String userId;

    public BaseRepo(Context context,ResponseCourier courier){
        this.context = context;
        this.courier = courier;

        headerRequest.put("Content-type","application/json");
    }
}
