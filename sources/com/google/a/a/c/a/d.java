package com.google.a.a.c.a;

import com.alipay.mobile.nebula.util.tar.TarConstants;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<char[]> f7557a = new ThreadLocal<char[]>() {
        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ Object initialValue() {
            return new char[TarConstants.EOF_BLOCK];
        }
    };

    static char[] a() {
        return f7557a.get();
    }
}
