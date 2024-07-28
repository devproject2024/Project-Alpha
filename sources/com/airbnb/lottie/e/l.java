package com.airbnb.lottie.e;

import android.graphics.Color;
import com.airbnb.lottie.c.b.c;
import com.airbnb.lottie.e.a.c;
import com.airbnb.lottie.f.g;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class l implements ai<c> {

    /* renamed from: a  reason: collision with root package name */
    private int f6038a;

    public l(int i2) {
        this.f6038a = i2;
    }

    private void a(c cVar, List<Float> list) {
        double d2;
        c cVar2 = cVar;
        List<Float> list2 = list;
        int i2 = this.f6038a * 4;
        if (list.size() > i2) {
            int size = (list.size() - i2) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i3 = 0;
            while (i2 < list.size()) {
                if (i2 % 2 == 0) {
                    dArr[i3] = (double) list2.get(i2).floatValue();
                } else {
                    dArr2[i3] = (double) list2.get(i2).floatValue();
                    i3++;
                }
                i2++;
            }
            for (int i4 = 0; i4 < cVar2.f5842b.length; i4++) {
                int i5 = cVar2.f5842b[i4];
                double d3 = (double) cVar2.f5841a[i4];
                int i6 = 1;
                while (true) {
                    if (i6 >= dArr.length) {
                        d2 = dArr2[dArr2.length - 1];
                        break;
                    }
                    int i7 = i6 - 1;
                    double d4 = dArr[i7];
                    double d5 = dArr[i6];
                    if (dArr[i6] >= d3) {
                        d2 = g.a(dArr2[i7], dArr2[i6], (d3 - d4) / (d5 - d4));
                        break;
                    }
                    i6++;
                }
                cVar2.f5842b[i4] = Color.argb((int) (d2 * 255.0d), Color.red(i5), Color.green(i5), Color.blue(i5));
            }
        }
    }

    public final /* synthetic */ Object a(com.airbnb.lottie.e.a.c cVar, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = cVar.f() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.a();
        }
        while (cVar.e()) {
            arrayList.add(Float.valueOf((float) cVar.k()));
        }
        if (z) {
            cVar.b();
        }
        if (this.f6038a == -1) {
            this.f6038a = arrayList.size() / 4;
        }
        int i2 = this.f6038a;
        float[] fArr = new float[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f6038a * 4; i5++) {
            int i6 = i5 / 4;
            double floatValue = (double) ((Float) arrayList.get(i5)).floatValue();
            int i7 = i5 % 4;
            if (i7 == 0) {
                fArr[i6] = (float) floatValue;
            } else if (i7 == 1) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i7 == 2) {
                i4 = (int) (floatValue * 255.0d);
            } else if (i7 == 3) {
                iArr[i6] = Color.argb(PriceRangeSeekBar.INVALID_POINTER_ID, i3, i4, (int) (floatValue * 255.0d));
            }
        }
        com.airbnb.lottie.c.b.c cVar2 = new com.airbnb.lottie.c.b.c(fArr, iArr);
        a(cVar2, (List<Float>) arrayList);
        return cVar2;
    }
}
