package com.travel.bus.busticket.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;

public final class a extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f22516a;

    public a(Context context) {
        this.f22516a = context.getResources().getDrawable(R.drawable.travel_res_bus_item_page_divider_thik);
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.f22516a.setBounds(paddingLeft, bottom, width, this.f22516a.getIntrinsicHeight() + bottom);
            this.f22516a.draw(canvas);
        }
    }
}
