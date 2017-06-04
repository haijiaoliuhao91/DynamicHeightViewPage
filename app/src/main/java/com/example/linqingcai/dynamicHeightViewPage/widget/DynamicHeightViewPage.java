package com.example.linqingcai.dynamicHeightViewPage.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by linqingcai on 2016/6/4.
 */

public class DynamicHeightViewPage extends ViewPager {
    private OnPageHeightChangeListener mOnPageHeightChangeListener;
    private int[] mDisplayHeights;

    public DynamicHeightViewPage(Context context) {
        super(context);
        initData();
    }

    public DynamicHeightViewPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    /**
     * 计算ViewPager现在应该的高度,heights[]表示页面高度的数组。
     * 然后为ViewPager设置高度
     */

    private void initData() {
        addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (mDisplayHeights == null || position == mDisplayHeights.length - 1) {
                    return;
                }
                int height =(int) (mDisplayHeights[position] * (1 - positionOffset) + mDisplayHeights[position + 1]
                                * positionOffset);

                ViewGroup.LayoutParams params = getLayoutParams();
                params.height = height;
                setLayoutParams(params);
                if (mOnPageHeightChangeListener != null) {
                    mOnPageHeightChangeListener.onChangeHeight(DynamicHeightViewPage.this, position, height);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setmDisplayHeights(int[] mDisplayHeights) {
        this.mDisplayHeights = mDisplayHeights;

        int pos = getCurrentItem();
        if (mDisplayHeights != null && pos < mDisplayHeights.length) {
            int height = mDisplayHeights[pos];

            ViewGroup.LayoutParams params = getLayoutParams();
            params.height = height;
            setLayoutParams(params);
        }
    }

    public void setPageHeightChangeListener(OnPageHeightChangeListener onPageHeightChangeListener) {
        this.mOnPageHeightChangeListener = onPageHeightChangeListener;
    }

    public interface OnPageHeightChangeListener {
        public void onChangeHeight(ViewPager viewPager, int position, int height);
    }

}

