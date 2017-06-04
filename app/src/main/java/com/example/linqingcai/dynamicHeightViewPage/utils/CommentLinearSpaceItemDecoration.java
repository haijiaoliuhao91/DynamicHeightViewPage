package com.example.linqingcai.dynamicHeightViewPage.utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author linqingcai 2016.09.13
 */
public class CommentLinearSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int mSpace;
    // 首个item上方是否需要间隙
    private boolean mIsFirstTopNeed;

    public CommentLinearSpaceItemDecoration(Context context, int space, boolean isFirstTopNeed) {
        this.mSpace = space;
        mIsFirstTopNeed = isFirstTopNeed;
    }

    public CommentLinearSpaceItemDecoration(Context context, int space) {
        this(context, space, true);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//		outRect.left = mSpace;
//		outRect.right = mSpace;
        outRect.bottom = mSpace;
        if (mIsFirstTopNeed && parent.getChildAdapterPosition(view) == 0) {
            outRect.top = mSpace;
        }
    }
}
