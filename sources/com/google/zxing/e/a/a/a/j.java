package com.google.zxing.e.a.a.a;

import com.google.zxing.b.a;
import com.google.zxing.h;
import com.google.zxing.m;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    final a f40318a;

    /* renamed from: b  reason: collision with root package name */
    final s f40319b;

    public abstract String a() throws m, h;

    j(a aVar) {
        this.f40318a = aVar;
        this.f40319b = new s(aVar);
    }

    public static j a(a aVar) {
        if (aVar.a(1)) {
            return new g(aVar);
        }
        if (!aVar.a(2)) {
            return new k(aVar);
        }
        int a2 = s.a(aVar, 1, 4);
        if (a2 == 4) {
            return new a(aVar);
        }
        if (a2 == 5) {
            return new b(aVar);
        }
        int a3 = s.a(aVar, 1, 5);
        if (a3 == 12) {
            return new c(aVar);
        }
        if (a3 == 13) {
            return new d(aVar);
        }
        switch (s.a(aVar, 1, 7)) {
            case 56:
                return new e(aVar, "310", "11");
            case 57:
                return new e(aVar, "320", "11");
            case 58:
                return new e(aVar, "310", "13");
            case 59:
                return new e(aVar, "320", "13");
            case 60:
                return new e(aVar, "310", "15");
            case 61:
                return new e(aVar, "320", "15");
            case 62:
                return new e(aVar, "310", "17");
            case 63:
                return new e(aVar, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(aVar)));
        }
    }
}
