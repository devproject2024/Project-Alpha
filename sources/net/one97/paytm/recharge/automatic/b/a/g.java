package net.one97.paytm.recharge.automatic.b.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.automatic.R;

public final class g extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f60250a;

    /* renamed from: b  reason: collision with root package name */
    private final int f60251b;

    public g(Context context, int i2) {
        k.c(context, "context");
        this.f60251b = i2;
        this.f60250a = b.a(context, R.drawable.divider_recent);
    }

    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        k.c(canvas, "c");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        try {
            int c2 = com.paytm.utility.b.c(this.f60251b);
            int width = recyclerView.getWidth();
            int childCount = recyclerView.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = recyclerView.getChildAt(i2);
                Integer num = null;
                ViewGroup.LayoutParams layoutParams = childAt != null ? childAt.getLayoutParams() : null;
                if (layoutParams != null) {
                    int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
                    Drawable drawable = this.f60250a;
                    if (drawable != null) {
                        num = Integer.valueOf(drawable.getIntrinsicHeight());
                    }
                    if (num == null) {
                        k.a();
                    }
                    int intValue = num.intValue() + bottom;
                    Drawable drawable2 = this.f60250a;
                    if (drawable2 != null) {
                        drawable2.setBounds(c2, bottom, width, intValue);
                    }
                    Drawable drawable3 = this.f60250a;
                    if (drawable3 != null) {
                        drawable3.draw(canvas);
                    }
                    i2++;
                } else {
                    throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                }
            }
        } catch (Exception unused) {
        }
    }
}
