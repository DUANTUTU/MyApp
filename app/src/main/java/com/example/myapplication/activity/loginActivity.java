package com.example.myapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.BaseActivity;
import com.example.myapplication.R;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginActivity extends BaseActivity implements View.OnClickListener {
    private EditText username;
    private EditText passwd;
    private Button beginlogin;
    private Button registred;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    getData();
                    break;
            }
        }
    };

    private void getData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://39.102.32.247:3306/mydatabase";
            java.sql.Connection cn= DriverManager.getConnection(url,"root","@duan2000");
            String sql="select username from android_user";
            Statement statement=cn.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                String name=rs.getString("username");
                Log.d("loginActivity", name);
            }
            cn.close();
            statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        username = findViewById(R.id.username);
        passwd = findViewById(R.id.passwd);
        beginlogin = findViewById(R.id.beginlogin);
        registred = findViewById(R.id.registred);
        beginlogin.setOnClickListener(this);

    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.beginlogin:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                      handler.sendEmptyMessage(1);
                    }
                }).start();
                break;
        }

    }
}
