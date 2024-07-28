package io.branch.referral;

import io.branch.referral.s;

public final class v extends s {

    /* renamed from: h  reason: collision with root package name */
    int f46601h;

    /* renamed from: i  reason: collision with root package name */
    private a f46602i;

    public interface a {
    }

    public final boolean a() {
        return false;
    }

    public final void b() {
    }

    public final boolean c() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean e() {
        return true;
    }

    public final void a(ag agVar, c cVar) {
        if (agVar == null) {
            a(-116, "Failed to get last attributed touch data");
        } else if (this.f46602i != null) {
            agVar.a();
        }
    }

    public final void a(int i2, String str) {
        if (this.f46602i != null) {
            new f("Failed to get last attributed touch data", -116);
        }
    }

    public final s.a k() {
        return s.a.V1_LATD;
    }
}
