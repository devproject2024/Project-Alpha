package com.travel.train.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;

public final class c extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f28375a;

    public c(Context context) {
        this.f28375a = context.getResources().getDrawable(R.drawable.pre_t_train_cart_item_page_divider_thick);
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.f28375a.setBounds(paddingLeft, bottom, width, this.f28375a.getIntrinsicHeight() + bottom);
            this.f28375a.draw(canvas);
        }
    }
}
