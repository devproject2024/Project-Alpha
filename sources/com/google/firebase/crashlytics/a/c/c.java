package com.google.firebase.crashlytics.a.c;

import com.google.firebase.crashlytics.a.e.v;

public final class c extends o {

    /* renamed from: a  reason: collision with root package name */
    private final v f38176a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38177b;

    public c(v vVar, String str) {
        if (vVar != null) {
            this.f38176a = vVar;
            if (str != null) {
                this.f38177b = str;
                return;
            }
            throw new NullPointerException("Null sessionId");
        }
        throw new NullPointerException("Null report");
    }

    public final v a() {
        return this.f38176a;
    }

    public final String b() {
        return this.f38177b;
    }

    public final String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f38176a + ", sessionId=" + this.f38177b + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            return this.f38176a.equals(oVar.a()) && this.f38177b.equals(oVar.b());
        }
    }

    public final int hashCode() {
        return ((this.f38176a.hashCode() ^ 1000003) * 1000003) ^ this.f38177b.hashCode();
    }
}
