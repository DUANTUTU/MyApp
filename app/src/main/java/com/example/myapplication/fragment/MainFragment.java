package com.example.myapplication.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TimeUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.bean.WeatherBean;
import com.example.myapplication.view.MyTextView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.mysql.jdbc.TimeUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @autor duan
 * create on 2020/4/8
 * creta at 23:37
 */
public class MainFragment extends Fragment {
    private MyTextView text;
    private LinearLayout weahterlinear;
    private List<WeatherBean.NewslistBean> weahterlist;
    private TextView city;
    private TextView weathernow;
    private LineChart lineChart;



    private TextView wendu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.mainfragment, container,false);
        weahterlinear = view.findViewById(R.id.weahterlinear);
        weahterlinear = view.findViewById(R.id.weahterlinear);
        city = view.findViewById(R.id.city);
        weathernow = view.findViewById(R.id.weathernow);
        wendu = view.findViewById(R.id.wendu);
        lineChart = view.findViewById(R.id.lineChart);
        //  text = view.findViewById(R.id.text);
        return view;
    }

   @Override
   public void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
       EventBus.getDefault().register(this);

  }

    @Subscribe(threadMode= ThreadMode.MAIN,sticky = true)
    public void getWeahterData(WeatherBean bean) {
//            Log.d("MainFragment", bean.getNewslist().get(0).getWeather());
        // text.setText(myEvent.toString()); //写过一段滚动字体 以后用到可以看
        Log.d("MainFragment", bean.getNewslist().get(0).getWeather());
        weahterlist=bean.getNewslist();
        Log.d("MainFragment", weahterlist.get(0).getWeather());
        handler.sendEmptyMessage(0);
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (weahterlist!=null)
            {
                Log.d("MainFragment", weahterlist.get(0).getWeather());
                switchbackground();
                setBaseData();
                setLineChat();
            }
        }

        private void setLineChat() {
            //世界上怎么会有如此拉跨的代码
            List<Entry> valsComp1 = new ArrayList<Entry>();
            int day1=Integer.parseInt(weahterlist.get(0).getReal().substring(0,2));
            int day2=Integer.parseInt(weahterlist.get(1).getReal().substring(0,2));
            int day3=Integer.parseInt(weahterlist.get(2).getReal().substring(0,2));
            int day4=Integer.parseInt(weahterlist.get(3).getReal().substring(0,2));
            int day5=Integer.parseInt(weahterlist.get(4).getReal().substring(0,2));
            int day6=Integer.parseInt(weahterlist.get(5).getReal().substring(0,2));
            int day7=Integer.parseInt(weahterlist.get(6).getReal().substring(0,2));
            Log.d("MainFragment", "day7:" + day7);
            Entry c1e1 = new Entry(0f, day1); // 0 == quarter 1
            valsComp1.add(c1e1);
            Entry c1e2 = new Entry(1f, day2); // 1 == quarter 2 ...
            valsComp1.add(c1e2);
            Entry c1e3 = new Entry(2f, day3); // 1 == quarter 2 ...
            valsComp1.add(c1e3);
            Entry c1e4 = new Entry(3f, day4); // 1 == quarter 2 ...
            valsComp1.add(c1e4);
            Entry c1e5 = new Entry(4f, day5); // 1 == quarter 2 ...
            valsComp1.add(c1e5);
            Entry c1e6 = new Entry(5f, day6); // 1 == quarter 2 ...
            valsComp1.add(c1e6);
            Entry c1e7 = new Entry(6f, day7); // 1 == quarter 2 ...
            valsComp1.add(c1e7);
            // and so on ...
            LineDataSet setComp1 = new LineDataSet(valsComp1, "一周天气情况");
            // use the interface ILineDataSet
            List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(setComp1);
            LineData data = new LineData(dataSets);
            lineChart.setData(data);
            lineChart.invalidate(); // refresh
        }

        private void setBaseData() {
            city.setText(weahterlist.get(0).getArea());
            weathernow.setText(weahterlist.get(0).getWeather());
            wendu.setText(weahterlist.get(0).getReal());
        }

        //根据天气修改背景图片  这个太麻烦了我实在是懒得一张张找图片了就这样吧
        private void switchbackground() {
            String weather=weahterlist.get(0).getWeather();
            if (weather.contains("晴")){
                weahterlinear.setBackgroundResource(R.mipmap.moresun);
            }else  if (weather.contains("多云"))
            {
                weahterlinear.setBackgroundResource(R.mipmap.duoyunzhuanqing);
            } else if (weather.contains("阴")){
              weahterlinear.setBackgroundResource(R.mipmap.duoyun);
            }else if(weather.contains("雨"))
            {
                weahterlinear.setBackgroundResource(R.mipmap.dayu);
            }
        }
    };
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().register(this);
    }
}
