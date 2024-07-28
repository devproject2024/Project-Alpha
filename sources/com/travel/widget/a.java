package com.travel.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.common.R;

public final class a extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f28588a;

    public a(Context context) {
        this.f28588a = context.getResources().getDrawable(R.drawable.pre_tc_travel_cart_item_page_divider_thick);
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.f28588a.setBounds(paddingLeft, bottom, width, this.f28588a.getIntrinsicHeight() + bottom);
            this.f28588a.draw(canvas);
        }
    }
}
