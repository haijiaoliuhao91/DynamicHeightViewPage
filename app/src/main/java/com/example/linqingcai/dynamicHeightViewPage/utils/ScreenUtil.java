package com.example.linqingcai.dynamicHeightViewPage.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by linqingcai on 2017/6/4.
 */

public class ScreenUtil {

    public static ScreenInfo getScreenInfo(Context ctx) {
        ScreenInfo info = new ScreenInfo();
        WindowManager window = (WindowManager) ctx
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metric = new DisplayMetrics();
        window.getDefaultDisplay().getMetrics(metric);
        info.Width = metric.widthPixels;
        info.Height = metric.heightPixels;
        info.density = metric.densityDpi;
        return info;
    }

    public static class ScreenInfo {
        public int Width;
        public int Height;
        public int density;

        public int getDiplayHeight(int realWidth) {
            return  (int)(1.0 * this.Height / this.Width * realWidth);
        }

        public int getDiplayWidth(int realHeight) {
            return  (int)(1.0 * this.Width / this.Height * realHeight);
        }
    }
}
