package com.alipay.plus.android.a.a;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.plus.android.a.a.a.d;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15167a = d.a("ConfigGetter");

    /* access modifiers changed from: protected */
    public abstract e b();

    private Object d(String str) {
        e b2 = b();
        if (b2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return b2.get(str);
    }

    public final e a(String str) {
        Object d2 = d(str);
        if (d2 instanceof e) {
            return (e) d2;
        }
        return null;
    }

    public final com.alibaba.a.b b(String str) {
        Object d2 = d(str);
        if (d2 instanceof com.alibaba.a.b) {
            return (com.alibaba.a.b) d2;
        }
        return null;
    }

    public final String c(String str) {
        Object d2 = d(str);
        if (d2 == null) {
            return null;
        }
        return String.valueOf(d2);
    }
}
