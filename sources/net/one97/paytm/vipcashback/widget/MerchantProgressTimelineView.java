package net.one97.paytm.vipcashback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import kotlin.g.b.k;

public final class MerchantProgressTimelineView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f21045a;

    /* renamed from: b  reason: collision with root package name */
    public int f21046b;

    /* renamed from: c  reason: collision with root package name */
    public int f21047c;

    /* renamed from: d  reason: collision with root package name */
    public Context f21048d;

    public final int getTotalWidth() {
        return this.f21045a;
    }

    public final void setTotalWidth(int i2) {
        this.f21045a = i2;
    }

    public final int getCurrentTxnCount() {
        return this.f21046b;
    }

    public final void setCurrentTxnCount(int i2) {
        this.f21046b = i2;
    }

    public final int getTotalTxnCount() {
        return this.f21047c;
    }

    public final void setTotalTxnCount(int i2) {
        this.f21047c = i2;
    }

    public final Context getMContext() {
        Context context = this.f21048d;
        if (context == null) {
            k.a("mContext");
        }
        return context;
    }

    public final void setMContext(Context context) {
        k.c(context, "<set-?>");
        this.f21048d = context;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MerchantProgressTimelineView(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MerchantProgressTimelineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        k.c(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MerchantProgressTimelineView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        k.c(context, "context");
        this.f21048d = context;
        setOrientation(0);
        setGravity(16);
    }
}
