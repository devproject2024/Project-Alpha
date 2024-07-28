package com.google.firebase.appindexing.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.s;
import com.google.firebase.appindexing.c;
import com.google.firebase.appindexing.d;
import com.google.firebase.appindexing.h;
import com.google.firebase.appindexing.i;
import com.google.firebase.appindexing.j;
import com.google.firebase.appindexing.k;
import com.google.firebase.appindexing.l;
import com.google.firebase.appindexing.m;
import com.google.firebase.appindexing.n;
import com.google.firebase.appindexing.o;

public final class e {
    public static c a(Status status, String str) {
        s.a(status);
        String str2 = status.f8361h;
        if (str2 != null && !str2.isEmpty()) {
            str = str2;
        }
        int i2 = status.f8360g;
        if (i2 == 17510) {
            return new d(str);
        }
        if (i2 == 17511) {
            return new com.google.firebase.appindexing.e(str);
        }
        if (i2 == 17602) {
            return new o(str);
        }
        switch (i2) {
            case 17513:
                return new i(str);
            case 17514:
                return new h(str);
            case 17515:
                return new n(str);
            case 17516:
                return new l(str);
            case 17517:
                return new m(str);
            case 17518:
                return new k(str);
            case 17519:
                return new j(str);
            default:
                return new c(str);
        }
    }
}
