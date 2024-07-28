package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.bf;

final class db implements ck {

    /* renamed from: a  reason: collision with root package name */
    final cm f9268a;

    /* renamed from: b  reason: collision with root package name */
    final dc f9269b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9270c;

    db(cm cmVar, String str, Object[] objArr) {
        this.f9268a = cmVar;
        this.f9270c = str;
        this.f9269b = new dc(cmVar.getClass(), str, objArr);
    }

    public final cm c() {
        return this.f9268a;
    }

    public final int a() {
        return (this.f9269b.f9273c & 1) == 1 ? bf.g.f9203h : bf.g.f9204i;
    }

    public final boolean b() {
        return (this.f9269b.f9273c & 2) == 2;
    }
}
