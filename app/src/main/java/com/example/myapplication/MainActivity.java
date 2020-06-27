package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Util.VolleyCallBack;
import com.example.myapplication.Util.VolleyUtil;
import com.example.myapplication.activity.HotNewsActivity;
import com.example.myapplication.activity.loginActivity;
import com.example.myapplication.bean.WangYiBean;
import com.example.myapplication.bean.WeatherBean;
import com.example.myapplication.fragment.MainFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener{
    private Toolbar toolbar;
    private TextView toolbarText;
    private FrameLayout mainFragmentlayout;
    private BottomNavigationView bottomNav;
    private NavigationView nav;
    private TextView navTitle1;
    private TextView navTitle2;
    private ImageView heardimage;
    private DrawerLayout drawerlayout;
    WeatherBean bean1;
    List<WeatherBean.NewslistBean> weahterlist=new ArrayList<>();
    List<WangYiBean.NewslistBean> lists=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolbar("主页面");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        initView();
        initNavgiation();
       handler.sendEmptyMessage(1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainpagemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerlayout.openDrawer(GravityCompat.START);
                break;


        }
        return true;
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case 1:
                    getData();//获取网易云骚话
                    getWeatherData();
                    break;
                case 2:
                    EventBus.getDefault().postSticky(bean1);
                    break;
                default:
                    break;
            }
        }
    };

    private void getWeatherData(){
        String url="http://api.tianapi.com/txapi/tianqi/index?key=2d9bef200f3c75b48bbfc7103cbea967&city=保定";
        VolleyUtil.post(getApplication(),url, null,new VolleyCallBack() {
            @Override
            public void onSuccess(String json, JSONObject jsonObject) {
                WeatherBean bean=new Gson().fromJson(jsonObject.toString(), WeatherBean.class);
                bean1=new Gson().fromJson(jsonObject.toString(), WeatherBean.class);
                weahterlist.addAll(bean.getNewslist());
                Log.d("MainActivity", weahterlist.get(0).getWeather());
            }

            @Override
            public void onFailure(String err) {
                Log.d("天气", "onFailure: 天气访问失败");
            }
        });
    }
    private void getData() {
        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        String url="http://api.tianapi.com/txapi/hotreview/index?key=2d9bef200f3c75b48bbfc7103cbea967";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
            WangYiBean bean=new Gson().fromJson(jsonObject.toString(), WangYiBean.class);
            lists.addAll(bean.getNewslist());
                Log.d("TAG", "onResponse: 成功 ");
                Log.d("wangyi", "onResponse: "+lists.get(0).getContent());
                navTitle1.setText("来自《"+lists.get(0).getSource()+"》");
                navTitle2.setText(lists.get(0).getContent());
               handler.sendEmptyMessage(2); // 暂时不想用滚动字体已经取消

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("TAG", "onResponse: 网络访问失败 ");
            }
        });
        queue.add(jsonObjectRequest);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
        private void initNavgiation() {
        nav = findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(this);
        View headView=nav.getHeaderView(0);
        navTitle1 = headView.findViewById(R.id.nav_title1);
        navTitle2 = headView.findViewById(R.id.nav_title2);
        heardimage = headView.findViewById(R.id.heardimage);
        heardimage.setOnClickListener(this);
    }
    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        drawerlayout = findViewById(R.id.drawerlayout);
        toolbarText = findViewById(R.id.toolbar_text);
        mainFragmentlayout = findViewById(R.id.main_fragmentlayout);
        bottomNav = findViewById(R.id.bottom_nav);

        MainFragment mMainFragment = new MainFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fm.beginTransaction();
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.account);

        }
        fragmentTransaction.replace(R.id.main_fragmentlayout, mMainFragment);
        fragmentTransaction.commit();
    }
    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.heardimage:
                Intent intent = new Intent(MainActivity.this, loginActivity.class);
                startActivity(intent);

                break;

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.news1:
                Intent intent = new Intent(this, HotNewsActivity.class);
                startActivity(intent);
                break;
        }
        return false;
    }
}
