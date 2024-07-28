package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public EdgeEffect f3191a;

    @Deprecated
    public d(Context context) {
        this.f3191a = new EdgeEffect(context);
    }

    @Deprecated
    public final void a(int i2, int i3) {
        this.f3191a.setSize(i2, i3);
    }

    @Deprecated
    public final boolean a(float f2) {
        this.f3191a.onPull(f2);
        return true;
    }

    @Deprecated
    public final boolean a(float f2, float f3) {
        a(this.f3191a, f2, f3);
        return true;
    }

    public static void a(EdgeEffect edgeEffect, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f2, f3);
        } else {
            edgeEffect.onPull(f2);
        }
    }

    @Deprecated
    public final boolean a() {
        this.f3191a.onRelease();
        return this.f3191a.isFinished();
    }

    @Deprecated
    public final boolean a(int i2) {
        this.f3191a.onAbsorb(i2);
        return true;
    }

    @Deprecated
    public final boolean a(Canvas canvas) {
        return this.f3191a.draw(canvas);
    }
}
