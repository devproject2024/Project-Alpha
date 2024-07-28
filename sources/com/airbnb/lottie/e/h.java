package com.airbnb.lottie.e;

import com.airbnb.lottie.c.b;
import com.airbnb.lottie.e.a.c;
import com.alipay.mobile.h5container.api.H5Param;
import java.io.IOException;

public final class h implements ai<b> {

    /* renamed from: a  reason: collision with root package name */
    public static final h f6032a = new h();

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f6033b = c.a.a("t", "f", "s", "j", "tr", "lh", H5Param.LANDSCAPE, "fc", H5Param.SAFEPAY_CONTEXT, "sw", "of");

    private h() {
    }

    public final /* synthetic */ Object a(c cVar, float f2) throws IOException {
        b.a aVar = b.a.CENTER;
        cVar.c();
        b.a aVar2 = aVar;
        String str = null;
        String str2 = null;
        float f3 = 0.0f;
        int i2 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i3 = 0;
        int i4 = 0;
        float f6 = 0.0f;
        boolean z = true;
        while (cVar.e()) {
            switch (cVar.a(f6033b)) {
                case 0:
                    str = cVar.i();
                    break;
                case 1:
                    str2 = cVar.i();
                    break;
                case 2:
                    f3 = (float) cVar.k();
                    break;
                case 3:
                    int l = cVar.l();
                    if (l <= b.a.CENTER.ordinal() && l >= 0) {
                        aVar2 = b.a.values()[l];
                        break;
                    } else {
                        aVar2 = b.a.CENTER;
                        break;
                    }
                case 4:
                    i2 = cVar.l();
                    break;
                case 5:
                    f4 = (float) cVar.k();
                    break;
                case 6:
                    f5 = (float) cVar.k();
                    break;
                case 7:
                    i3 = p.a(cVar);
                    break;
                case 8:
                    i4 = p.a(cVar);
                    break;
                case 9:
                    f6 = (float) cVar.k();
                    break;
                case 10:
                    z = cVar.j();
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        c cVar2 = cVar;
        cVar.d();
        return new b(str, str2, f3, aVar2, i2, f4, f5, i3, i4, f6, z);
    }
}
