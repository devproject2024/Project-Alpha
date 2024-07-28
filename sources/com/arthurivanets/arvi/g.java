package com.arthurivanets.arvi;

import android.text.TextUtils;
import com.arthurivanets.arvi.a.b;
import com.arthurivanets.arvi.b.b.c;

public final class g implements Comparable<g> {

    /* renamed from: a  reason: collision with root package name */
    long f31014a;

    /* renamed from: b  reason: collision with root package name */
    String f31015b;

    /* renamed from: c  reason: collision with root package name */
    b f31016c;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        long j = this.f31014a;
        long j2 = ((g) obj).f31014a;
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    public g(b bVar) {
        this(System.currentTimeMillis(), bVar);
    }

    private g(long j, b bVar) {
        this.f31014a = j;
        c.a((Object) bVar);
        this.f31016c = bVar;
        this.f31015b = "";
    }

    public final boolean a() {
        return !TextUtils.isEmpty(this.f31015b);
    }

    public final int hashCode() {
        b bVar = this.f31016c;
        return bVar != null ? bVar.hashCode() : super.hashCode();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof k) && hashCode() == obj.hashCode();
    }

    public final g a(String str) {
        c.a((Object) str);
        this.f31015b = str;
        return this;
    }
}
