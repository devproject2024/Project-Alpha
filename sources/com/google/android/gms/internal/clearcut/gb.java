package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public final class gb extends es<gb> implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static volatile gb[] f9391c;

    /* renamed from: d  reason: collision with root package name */
    private String f9392d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f9393e = "";

    public gb() {
        this.f9344a = null;
        this.f9357b = -1;
    }

    public static gb[] e() {
        if (f9391c == null) {
            synchronized (ew.f9354a) {
                if (f9391c == null) {
                    f9391c = new gb[0];
                }
            }
        }
        return f9391c;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final gb clone() {
        try {
            return (gb) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    /* access modifiers changed from: protected */
    public final int a() {
        int a2 = super.a();
        String str = this.f9392d;
        if (str != null && !str.equals("")) {
            a2 += eq.b(1, this.f9392d);
        }
        String str2 = this.f9393e;
        return (str2 == null || str2.equals("")) ? a2 : a2 + eq.b(2, this.f9393e);
    }

    public final void a(eq eqVar) throws IOException {
        String str = this.f9392d;
        if (str != null && !str.equals("")) {
            eqVar.a(1, this.f9392d);
        }
        String str2 = this.f9393e;
        if (str2 != null && !str2.equals("")) {
            eqVar.a(2, this.f9393e);
        }
        super.a(eqVar);
    }

    public final /* synthetic */ es b() throws CloneNotSupportedException {
        return (gb) clone();
    }

    public final /* synthetic */ ex c() throws CloneNotSupportedException {
        return (gb) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gb)) {
            return false;
        }
        gb gbVar = (gb) obj;
        String str = this.f9392d;
        if (str == null) {
            if (gbVar.f9392d != null) {
                return false;
            }
        } else if (!str.equals(gbVar.f9392d)) {
            return false;
        }
        String str2 = this.f9393e;
        if (str2 == null) {
            if (gbVar.f9393e != null) {
                return false;
            }
        } else if (!str2.equals(gbVar.f9393e)) {
            return false;
        }
        return (this.f9344a == null || this.f9344a.a()) ? gbVar.f9344a == null || gbVar.f9344a.a() : this.f9344a.equals(gbVar.f9344a);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        String str = this.f9392d;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f9393e;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        if (this.f9344a != null && !this.f9344a.a()) {
            i2 = this.f9344a.hashCode();
        }
        return hashCode3 + i2;
    }
}
