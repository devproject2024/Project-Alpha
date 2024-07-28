package net.one97.paytm.paymentsBank.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.paymentsBank.R;

public final class a extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private Context f19644a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f19645b;

    /* renamed from: c  reason: collision with root package name */
    private int f19646c;

    public a(Context context) {
        this.f19644a = context;
        this.f19645b = b.a(this.f19644a, R.drawable.pb_upi_passbook_item_divider_decoration);
    }

    public a(Context context, Drawable drawable, int i2) {
        this.f19644a = context;
        this.f19645b = drawable;
        this.f19646c = i2;
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.f19645b.setBounds(this.f19646c + paddingLeft, bottom, width, this.f19645b.getIntrinsicHeight() + bottom);
            this.f19645b.draw(canvas);
        }
    }
}
