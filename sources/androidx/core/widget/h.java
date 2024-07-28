package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public OverScroller f3197a;

    @Deprecated
    public static h a(Context context, Interpolator interpolator) {
        return new h(context, interpolator);
    }

    private h(Context context, Interpolator interpolator) {
        this.f3197a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public final void a(int i2, int i3, int i4, int i5, int i6) {
        this.f3197a.startScroll(i2, i3, i4, i5, i6);
    }
}
