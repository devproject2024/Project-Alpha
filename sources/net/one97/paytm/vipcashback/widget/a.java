package net.one97.paytm.vipcashback.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;

public final class a extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f21062a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21063b;

    public a(Drawable drawable) {
        k.c(drawable, "mDivider");
        this.f21062a = drawable;
        this.f21063b = 0;
    }

    public /* synthetic */ a(Drawable drawable, byte b2) {
        this(drawable);
    }

    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        k.c(canvas, "canvas");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        int i2 = this.f21063b;
        int i3 = childCount - 2;
        if (i2 <= i3) {
            while (true) {
                View childAt = recyclerView.getChildAt(i2);
                k.a((Object) childAt, "child");
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams != null) {
                    int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
                    this.f21062a.setBounds(paddingLeft, bottom, width, this.f21062a.getIntrinsicHeight() + bottom);
                    this.f21062a.draw(canvas);
                    if (i2 != i3) {
                        i2++;
                    } else {
                        return;
                    }
                } else {
                    throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                }
            }
        }
    }
}
