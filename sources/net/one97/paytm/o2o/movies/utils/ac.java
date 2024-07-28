package net.one97.paytm.o2o.movies.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.common.assets.R;

public final class ac extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f75916a;

    public ac(Context context) {
        this.f75916a = context.getResources().getDrawable(R.drawable.cart_item_page_divider_thick);
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.f75916a.setBounds(paddingLeft, bottom, width, this.f75916a.getIntrinsicHeight() + bottom);
            this.f75916a.draw(canvas);
        }
    }
}
