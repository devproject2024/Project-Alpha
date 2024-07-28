package net.one97.paytm.o2o.movies.common.customui;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.a.a.b;
import androidx.interpolator.a.a.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final Interpolator f75091a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    static final Interpolator f75092b = new b();

    /* renamed from: c  reason: collision with root package name */
    static final Interpolator f75093c = new androidx.interpolator.a.a.a();

    /* renamed from: d  reason: collision with root package name */
    static final Interpolator f75094d = new c();

    /* renamed from: e  reason: collision with root package name */
    static final Interpolator f75095e = new DecelerateInterpolator();

    static int a(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * ((float) (i3 - i2)));
    }
}
