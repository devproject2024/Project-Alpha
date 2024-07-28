package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class h extends v.d.a.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f38463a;

    public final String a() {
        return this.f38463a;
    }

    public final String toString() {
        return "Organization{clsId=" + this.f38463a + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.a.b) {
            return this.f38463a.equals(((v.d.a.b) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f38463a.hashCode() ^ 1000003;
    }
}
