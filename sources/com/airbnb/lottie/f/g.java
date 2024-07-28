package com.airbnb.lottie.f;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.a.a.k;
import com.airbnb.lottie.c.a;
import com.airbnb.lottie.c.b.l;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.c.f;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static PointF f6121a = new PointF();

    public static double a(double d2, double d3, double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int a(int i2, int i3, float f2) {
        return (int) (((float) i2) + (f2 * ((float) (i3 - i2))));
    }

    public static boolean c(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(l lVar, Path path) {
        path.reset();
        PointF pointF = lVar.f5888b;
        path.moveTo(pointF.x, pointF.y);
        f6121a.set(pointF.x, pointF.y);
        for (int i2 = 0; i2 < lVar.f5887a.size(); i2++) {
            a aVar = lVar.f5887a.get(i2);
            PointF pointF2 = aVar.f5807a;
            PointF pointF3 = aVar.f5808b;
            PointF pointF4 = aVar.f5809c;
            if (!pointF2.equals(f6121a) || !pointF3.equals(pointF4)) {
                path.cubicTo(pointF2.x, pointF2.y, pointF3.x, pointF3.y, pointF4.x, pointF4.y);
            } else {
                path.lineTo(pointF4.x, pointF4.y);
            }
            f6121a.set(pointF4.x, pointF4.y);
        }
        if (lVar.f5889c) {
            path.close();
        }
    }

    public static int a(int i2) {
        return Math.max(0, Math.min(PriceRangeSeekBar.INVALID_POINTER_ID, i2));
    }

    public static float b(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    public static void a(e eVar, int i2, List<e> list, e eVar2, k kVar) {
        if (eVar.c(kVar.b(), i2)) {
            list.add(eVar2.a(kVar.b()).a((f) kVar));
        }
    }

    static int a(float f2, float f3) {
        int i2 = (int) f2;
        int i3 = (int) f3;
        int i4 = i2 / i3;
        int i5 = i2 % i3;
        if (!((i2 ^ i3) >= 0) && i5 != 0) {
            i4--;
        }
        return i2 - (i3 * i4);
    }
}
