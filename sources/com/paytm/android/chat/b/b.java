package com.paytm.android.chat.b;

import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f41775a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f41776b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f41775a == bVar.f41775a && k.a((Object) this.f41776b, (Object) bVar.f41776b);
    }

    public final int hashCode() {
        boolean z = this.f41775a;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        String str = this.f41776b;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "ChatListingFilterConfig(isConfigNeeded=" + this.f41775a + ", storeFilterId=" + this.f41776b + ")";
    }

    public b(String str) {
        k.c(str, "storeFilterId");
        this.f41776b = str;
    }

    public final void a(String str) {
        k.c(str, "<set-?>");
        this.f41776b = str;
    }
}
