package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.d.a;

final class c extends h {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7749a;

    /* renamed from: b  reason: collision with root package name */
    private final a f7750b;

    /* renamed from: c  reason: collision with root package name */
    private final a f7751c;

    /* renamed from: d  reason: collision with root package name */
    private final String f7752d;

    c(Context context, a aVar, a aVar2, String str) {
        if (context != null) {
            this.f7749a = context;
            if (aVar != null) {
                this.f7750b = aVar;
                if (aVar2 != null) {
                    this.f7751c = aVar2;
                    if (str != null) {
                        this.f7752d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public final Context a() {
        return this.f7749a;
    }

    public final a b() {
        return this.f7750b;
    }

    public final a c() {
        return this.f7751c;
    }

    public final String d() {
        return this.f7752d;
    }

    public final String toString() {
        return "CreationContext{applicationContext=" + this.f7749a + ", wallClock=" + this.f7750b + ", monotonicClock=" + this.f7751c + ", backendName=" + this.f7752d + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.f7749a.equals(hVar.a()) && this.f7750b.equals(hVar.b()) && this.f7751c.equals(hVar.c()) && this.f7752d.equals(hVar.d());
        }
    }

    public final int hashCode() {
        return ((((((this.f7749a.hashCode() ^ 1000003) * 1000003) ^ this.f7750b.hashCode()) * 1000003) ^ this.f7751c.hashCode()) * 1000003) ^ this.f7752d.hashCode();
    }
}
