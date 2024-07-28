package net.one97.paytm.common.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;

public final class j extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private Context f49921a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f49922b = b.a(this.f49921a, R.drawable.upi_passbook_item_divider_decoration);

    /* renamed from: c  reason: collision with root package name */
    private int f49923c;

    public j(Context context) {
        this.f49921a = context;
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.f49922b.setBounds(this.f49923c + paddingLeft, bottom, width, this.f49922b.getIntrinsicHeight() + bottom);
            this.f49922b.draw(canvas);
        }
    }
}
