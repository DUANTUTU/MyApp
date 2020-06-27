package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.BaseActivity;
import com.example.myapplication.R;
import com.example.myapplication.Util.VolleyCallBack;
import com.example.myapplication.Util.VolleyUtil;
import com.example.myapplication.adapter.hotnewsAdapter;
import com.example.myapplication.bean.newsBean;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HotNewsActivity extends BaseActivity {
    private Toolbar toolbar;
    private TextView toolbarText;
    private RecyclerView hotnewRecyclerview;
    private List<newsBean .NewslistBean> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayout();
        getData();
        initView();
    }

    private void getData() {
            String url="http://api.tianapi.com/guonei/index?key=2d9bef200f3c75b48bbfc7103cbea967&num=15";
        VolleyUtil.post(getApplicationContext(), url, null, new VolleyCallBack() {
            @Override
            public void onSuccess(String json, JSONObject jsonObject) {
                newsBean bean=new Gson().fromJson(jsonObject.toString(), newsBean.class);
                list.addAll(bean.getNewslist());
                Log.d("HotNewsActivity", bean.getNewslist().get(0).getTitle());
                Log.d("HotNewsActivity", list.get(0).getTitle());
            }

            @Override
            public void onFailure(String err) {
                Log.d("HotNewsActivity", "数据获取失败");
            }
        });
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        toolbarText = findViewById(R.id.toolbar_text);
        hotnewRecyclerview = findViewById(R.id.hotnewRecyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        hotnewRecyclerview.setLayoutManager(layoutManager);
        hotnewsAdapter adapter=new hotnewsAdapter(list,this);
        adapter.notifyDataSetChanged();
        hotnewRecyclerview.setAdapter(adapter);

}

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_hot_news;
    }
}
