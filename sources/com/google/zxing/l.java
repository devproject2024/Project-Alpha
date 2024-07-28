package com.google.zxing;

import com.google.zxing.a.c;
import com.google.zxing.b.b;
import com.google.zxing.e.ab;
import com.google.zxing.e.d;
import com.google.zxing.e.f;
import com.google.zxing.e.h;
import com.google.zxing.e.j;
import com.google.zxing.e.o;
import com.google.zxing.e.u;
import java.util.Map;

public final class l implements v {
    public final b a(String str, a aVar, int i2, int i3) throws w {
        return a(str, aVar, i2, i3, (Map<g, ?>) null);
    }

    public final b a(String str, a aVar, int i2, int i3, Map<g, ?> map) throws w {
        v vVar;
        switch (aVar) {
            case EAN_8:
                vVar = new com.google.zxing.e.l();
                break;
            case UPC_E:
                vVar = new ab();
                break;
            case EAN_13:
                vVar = new j();
                break;
            case UPC_A:
                vVar = new u();
                break;
            case QR_CODE:
                vVar = new com.google.zxing.g.b();
                break;
            case CODE_39:
                vVar = new f();
                break;
            case CODE_93:
                vVar = new h();
                break;
            case CODE_128:
                vVar = new d();
                break;
            case ITF:
                vVar = new o();
                break;
            case PDF_417:
                vVar = new com.google.zxing.f.d();
                break;
            case CODABAR:
                vVar = new com.google.zxing.e.b();
                break;
            case DATA_MATRIX:
                vVar = new com.google.zxing.c.b();
                break;
            case AZTEC:
                vVar = new c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(aVar)));
        }
        return vVar.a(str, aVar, i2, i3, map);
    }
}
