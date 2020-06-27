package com.example.myapplication.Util;

import org.json.JSONObject;

/**
 * @autor duan
 * create on 2020/4/9
 * creta at 15:21
 */
public interface VolleyCallBack {
    void onSuccess(String json, JSONObject jsonObject);
    void onFailure(String err);
}
