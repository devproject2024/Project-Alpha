package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;

public final class p extends i {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f61719a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f61720b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f61721c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(Context context, boolean z, boolean z2) {
        super(context, 1);
        k.c(context, "context");
        this.f61721c = z2;
        this.f61719a = b.a(context, R.drawable.divider_recent);
        this.f61720b = z;
    }

    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int i2;
        k.c(canvas, "c");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        int i3 = 0;
        if (this.f61721c) {
            i2 = 0;
        } else {
            i2 = com.paytm.utility.b.c(76);
        }
        int width = recyclerView.getWidth();
        int childCount = recyclerView.getChildCount();
        if (!this.f61720b) {
            childCount--;
        }
        while (i3 < childCount) {
            Integer num = null;
            View childAt = recyclerView != null ? recyclerView.getChildAt(i3) : null;
            ViewGroup.LayoutParams layoutParams = childAt != null ? childAt.getLayoutParams() : null;
            if (layoutParams != null) {
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                Integer valueOf = childAt != null ? Integer.valueOf(childAt.getBottom()) : null;
                if (valueOf == null) {
                    k.a();
                }
                int intValue = valueOf.intValue() + layoutParams2.bottomMargin;
                Drawable drawable = this.f61719a;
                if (drawable != null) {
                    num = Integer.valueOf(drawable.getIntrinsicHeight());
                }
                if (num == null) {
                    k.a();
                }
                int intValue2 = num.intValue() + intValue;
                Drawable drawable2 = this.f61719a;
                if (drawable2 != null) {
                    drawable2.setBounds(i2, intValue, width, intValue2);
                }
                Drawable drawable3 = this.f61719a;
                if (drawable3 != null) {
                    drawable3.draw(canvas);
                }
                i3++;
            } else {
                throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
        }
    }
}
