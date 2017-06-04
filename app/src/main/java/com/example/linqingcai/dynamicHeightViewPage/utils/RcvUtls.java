package com.example.linqingcai.dynamicHeightViewPage.utils;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by linqingcai on 2015/5/4.
 */

public class RcvUtls {

    public void setLinearLayoutManager(Context context, RecyclerView recyclerView) {
        setLinearLayoutManager(context, recyclerView, 0);
    }

    public void setLinearLayoutManager(Context context, RecyclerView recyclerView, int spaceSize) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        if (spaceSize > 0) {
            CommentLinearSpaceItemDecoration itemDecoration = new CommentLinearSpaceItemDecoration(context, spaceSize);
            recyclerView.addItemDecoration(itemDecoration);
        }
    }
}
