package net.one97.paytm.wallet.newdesign.widget;

import android.animation.TimeInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.interpolator.a.a.a;
import androidx.interpolator.a.a.b;
import androidx.interpolator.a.a.c;

public final class d {
    public static TimeInterpolator a(int i2) {
        switch (i2) {
            case 0:
                return new AccelerateDecelerateInterpolator();
            case 1:
                return new AccelerateInterpolator();
            case 2:
                return new AnticipateInterpolator();
            case 3:
                return new AnticipateOvershootInterpolator();
            case 4:
                return new BounceInterpolator();
            case 5:
                return new DecelerateInterpolator();
            case 6:
                return new a();
            case 7:
                return new b();
            case 9:
                return new c();
            case 10:
                return new OvershootInterpolator();
            default:
                return new LinearInterpolator();
        }
    }
}
