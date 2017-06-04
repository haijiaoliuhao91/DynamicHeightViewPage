package com.example.linqingcai.dynamicHeightViewPage.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.linqingcai.dynamicHeightViewPage.R;
import com.example.linqingcai.dynamicHeightViewPage.bean.ImagesBean;
import com.example.linqingcai.dynamicHeightViewPage.utils.CollectionsUtil;

import java.util.List;

/**
 * Created by linqingcai on 2017/6/4.
 */

public class ViewpageAdapter extends PagerAdapter {


    private List<ImagesBean> mImgsList;

    @Override
    public int getCount() {
        return CollectionsUtil.size(mImgsList);
    }

    public void setData(List<ImagesBean> imgsList) {
        this.mImgsList = imgsList;
    }

    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView ivCover=new ImageView(container.getContext());
        ivCover.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ivCover.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        Glide.with(container.getContext()).load(mImgsList.get(position).getUrl()).into(ivCover);
        container.addView(ivCover);
        return ivCover;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
