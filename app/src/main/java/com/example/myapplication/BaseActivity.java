package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * @autor duan
 * create on 2020/4/8
 * creta at 19:18
 */
public abstract class BaseActivity extends SupportActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

    }
    public void initToolbar(String title) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView textView = findViewById(R.id.toolbar_text);
        toolbar.setTitle("");
        textView.setText(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public abstract int getLayout();
}
