package com.example.linqingcai.dynamicHeightViewPage.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.linqingcai.dynamicHeightViewPage.R;
import com.example.linqingcai.dynamicHeightViewPage.bean.DemoBean;
import com.example.linqingcai.dynamicHeightViewPage.bean.ImagesBean;
import com.example.linqingcai.dynamicHeightViewPage.utils.CollectionsUtil;
import com.example.linqingcai.dynamicHeightViewPage.utils.ScreenUtil;
import com.example.linqingcai.dynamicHeightViewPage.widget.DynamicHeightViewPage;

import java.util.List;

/**
 * Created by linqingcai on 2017/6/4.
 */

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private List<DemoBean> mList;

    public DemoAdapter(List<DemoBean> list) {
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (DemoBean.ITEM_TYPE_FULL_TEXT == viewType) {
            TextView textView = new TextView(parent.getContext());
            textView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setTextColor(Color.BLACK);
            textView.setGravity(Gravity.CENTER);
            textView.setBackgroundColor(Color.GRAY);
            textView.setText("itemtype1");
            textView.setOnClickListener(DemoAdapter.this);
            return new RecyclerView.ViewHolder(textView) {
            };

        } else if (DemoBean.ITEM_TYPE_TWO_IMGS == viewType || DemoBean.ITEM_TYPE_THREE_IMGS == viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_pics_rv_item, null);
            itemView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
            return new ImageViewHolder(itemView);

        } else {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_dynamic_viewpage_item, null);
            itemView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
            return new ViewpageViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (DemoBean.ITEM_TYPE_FULL_TEXT == holder.getItemViewType()) {

            holder.itemView.setTag("itemtype1+position:" + position);

        } else if (DemoBean.ITEM_TYPE_TWO_IMGS == holder.getItemViewType()) {

            ImageViewHolder demoTwoViewHolder = (ImageViewHolder) holder;
            Glide.with(holder.itemView.getContext()).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496578439525&di=92562e2ae8beeef02e2ed9620648ce19&imgtype=0&src=http%3A%2F%2Fimg1.cache.netease.com%2Fcatchpic%2F2%2F2A%2F2AEA383B6EC641CD748399BFC3E569F5.jpg")
                    .into(demoTwoViewHolder.imageView);
            demoTwoViewHolder.textView.setText("itemtype2");
            holder.itemView.setTag("itemtype2+position:" + position);


        } else if (DemoBean.ITEM_TYPE_THREE_IMGS == holder.getItemViewType()) {

            ImageViewHolder demoThreeViewHolder = (ImageViewHolder) holder;
            Glide.with(holder.itemView.getContext()).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496578439523&di=42f3121211273bea525460a4dc96d934&imgtype=0&src=http%3A%2F%2Fhunan.sinaimg.cn%2F2013%2F0408%2FU9127P1192DT20130408144211.jpg")
                    .into(demoThreeViewHolder.imageView);
            demoThreeViewHolder.textView.setText("itemtype3");
            holder.itemView.setTag("itemtype3+position:" + position);

        } else if (DemoBean.ITEM_TYPE_VIEWPAGE == holder.getItemViewType()) {

            ViewpageViewHolder viewpageViewHolder = (ViewpageViewHolder) holder;
            viewpageViewHolder.dynamicHeightViewPage.setmDisplayHeights(getImgsHeights(mList.get(position).getImgsList(), viewpageViewHolder.itemView.getContext()));
            viewpageViewHolder.vpAdapter.setData(mList.get(position).getImgsList());
            viewpageViewHolder.vpAdapter.notifyDataSetChanged();


        }


    }

    private int[] getImgsHeights(List<ImagesBean> imagesBeanList, Context context) {
        if (CollectionsUtil.isEmpty(imagesBeanList)) {
            return null;
        }

        ScreenUtil.ScreenInfo info = ScreenUtil.getScreenInfo(context);
        int maxHeight = (info.Width * 7) / 6;

        int[] res = new int[imagesBeanList.size()];

        for (int i = 0; i < imagesBeanList.size(); i++) {
            ImagesBean imagesBean = imagesBeanList.get(i);
            int height = Math.min((imagesBean.getHeight() * info.Width) / imagesBean.getWidth(), maxHeight);
            res[i] = height;
        }
        return res;
    }

    @Override
    public int getItemCount() {
        return CollectionsUtil.size(mList);
    }

    public int getItemViewType(int position) {
        return mList.get(position).itemType;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), (String) v.getTag(), Toast.LENGTH_SHORT).show();

    }


    class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;


        public ImageViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(DemoAdapter.this);
            imageView = (ImageView) itemView.findViewById(R.id.iv_pic);
            textView = (TextView) itemView.findViewById(R.id.tv_pics_type);
        }
    }


    class ViewpageViewHolder extends RecyclerView.ViewHolder {
        DynamicHeightViewPage dynamicHeightViewPage;
        ViewpageAdapter vpAdapter;


        public ViewpageViewHolder(View itemView) {
            super(itemView);
            dynamicHeightViewPage = (DynamicHeightViewPage) itemView.findViewById(R.id.demo_vp_dynamic);
            vpAdapter = new ViewpageAdapter();
            dynamicHeightViewPage.setAdapter(vpAdapter);
        }
    }

}
