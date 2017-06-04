package com.example.linqingcai.dynamicHeightViewPage;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.linqingcai.dynamicHeightViewPage.adapter.DemoAdapter;
import com.example.linqingcai.dynamicHeightViewPage.bean.DemoBean;
import com.example.linqingcai.dynamicHeightViewPage.bean.ImagesBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linqingcai on 2017/6/4.
 */
public class MainActivity extends AppCompatActivity {

    public final static int COLUMN_TOATAL = 6;

    private RecyclerView mRecycleView;

    private DemoAdapter mDemoAdapter;

    private List<DemoBean> mList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView = (RecyclerView) findViewById(R.id.demo_rv_spansize_lookup);
        initData();
    }

    private void initData() {
        mRecycleView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int margin = parent.getContext().getResources().getDimensionPixelSize(R.dimen.common_item_margin_2_point_5_dp);

                outRect.set(margin, margin, margin, margin);
            }
        });
        GridLayoutManager gm = new GridLayoutManager(this, COLUMN_TOATAL);
        gm.setSpanSizeLookup(getSpanSizeLookup());
        mRecycleView.setLayoutManager(gm);

        mList.add(getImsViewpageData());


        mList.add(new DemoBean(DemoBean.ITEM_TYPE_THREE_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_THREE_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_THREE_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_THREE_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_THREE_IMGS));

        mList.add(getImsViewpageData());


        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));

        mList.add(getImsViewpageData());
        mList.add(getImsViewpageData());

        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_TWO_IMGS));

        mList.add(getImsViewpageData());

        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));
        mList.add(new DemoBean(DemoBean.ITEM_TYPE_FULL_TEXT));


        mDemoAdapter = new DemoAdapter(mList);
        mRecycleView.setAdapter(mDemoAdapter);


    }

    /**
     * 动态改变高度图片数据
     * @return
     */
    private DemoBean getImsViewpageData() {
        DemoBean demoBean = new DemoBean(DemoBean.ITEM_TYPE_VIEWPAGE);

        List<ImagesBean> imgsList = new ArrayList<>();
        imgsList.add(new ImagesBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496594936665&di=4401895b8c1446ec31bd4c166b41f300&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F140305%2F240449-1403050T41292.jpg",
                1000, 667));

        imgsList.add(new ImagesBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496595015682&di=d3d31b1948d106e78e49ccc088c2ca0e&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201505%2F23%2F20150523003845_YvRPa.jpeg",
                739, 1108));

        imgsList.add(new ImagesBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496595015681&di=1384a0895143348ce9f2b39791bbef93&imgtype=0&src=http%3A%2F%2Fimg0.pclady.com.cn%2Fpclady%2F1601%2F07%2F1422163_image011.jpg",
                875, 581));

        imgsList.add(new ImagesBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496595015680&di=df25e6965af73be1174d658ac8b659bb&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201304%2F08%2F20130408211433_fQXsh.thumb.700_0.jpeg",
                700, 700));

        imgsList.add(new ImagesBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496595015680&di=93c5e4b7cc0dd95d5df5136c12184983&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201602%2F06%2F20160206141805_LcVZx.jpeg",
                1200, 898));

        demoBean.setImgsList(imgsList);
        return demoBean;
    }

    /**
     * getSpanSize 获取 占位
     *
     * @return
     */
    public GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        return new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (DemoBean.ITEM_TYPE_FULL_TEXT == mList.get(position).itemType
                        || DemoBean.ITEM_TYPE_VIEWPAGE == mList.get(position).itemType) {
                    return 6;

                } else if (DemoBean.ITEM_TYPE_TWO_IMGS == mList.get(position).itemType) {
                    return 3;

                } else if (DemoBean.ITEM_TYPE_THREE_IMGS == mList.get(position).itemType) {
                    return 2;

                } else {

                    return 1;
                }

            }
        };
    }
}
