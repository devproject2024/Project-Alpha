package com.google.android.play.core.assetpacks;

final /* synthetic */ class bi implements bn {

    /* renamed from: a  reason: collision with root package name */
    private final bo f37054a;

    /* renamed from: b  reason: collision with root package name */
    private final int f37055b;

    bi(bo boVar, int i2) {
        this.f37054a = boVar;
        this.f37055b = i2;
    }

    public final Object a() {
        bo boVar = this.f37054a;
        int i2 = this.f37055b;
        bl b2 = boVar.b(i2);
        if (by.a(b2.f37064c.f37059c)) {
            ad adVar = boVar.f37072b;
            bk bkVar = b2.f37064c;
            adVar.g(bkVar.f37057a, b2.f37063b, bkVar.f37058b);
            bk bkVar2 = b2.f37064c;
            int i3 = bkVar2.f37059c;
            if (i3 != 5 && i3 != 6) {
                return null;
            }
            ad adVar2 = boVar.f37072b;
            String str = bkVar2.f37057a;
            if (!adVar2.a(str).exists()) {
                return null;
            }
            ad.c(adVar2.a(str));
            return null;
        }
        throw new ax(String.format("Could not safely delete session %d because it is not in a terminal state.", new Object[]{Integer.valueOf(i2)}), i2);
    }
}
