package com.paytm.notification.data.datasource.dao;

import kotlin.g.b.k;
import kotlin.u;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    long f43171a;

    /* renamed from: b  reason: collision with root package name */
    public String f43172b;

    /* renamed from: c  reason: collision with root package name */
    public long f43173c;

    public l(String str, long j) {
        this.f43172b = str;
        this.f43173c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k.a((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj == null) {
            throw new u("null cannot be cast to non-null type com.paytm.notification.data.datasource.dao.PushData");
        } else if (!k.a((Object) this.f43172b, (Object) ((l) obj).f43172b)) {
            return false;
        } else {
            return true;
        }
    }

    public final int hashCode() {
        String str = this.f43172b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
