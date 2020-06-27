package com.example.myapplication;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import org.litepal.LitePal;
/**
 * created by LiuXia
 * on 2020/1/29
 **/
public class InitApp extends MultiDexApplication {
    public static InitApp instance;
    public InitApp() {
        instance=this;
        LitePal.initialize(this);
    }
}
