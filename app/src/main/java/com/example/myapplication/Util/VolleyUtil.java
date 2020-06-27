package com.example.myapplication.Util;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.InitApp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @autor duan
 * create on 2020/4/9
 * creta at 15:22
 */
public class VolleyUtil  {
    public static RequestQueue requestQueue;
    public static void post(Context context,String url, JSONObject json, final VolleyCallBack callBack)
    {
       requestQueue=Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, json, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                callBack.onSuccess(jsonObject.toString(),jsonObject);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                callBack.onFailure(volleyError.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }


}
