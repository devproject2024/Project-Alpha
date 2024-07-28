package com.paytm.android.chat.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f41777a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f41778b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f41779c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f41777a == cVar.f41777a && this.f41779c == cVar.f41779c && this.f41778b == cVar.f41778b;
    }

    public final int hashCode() {
        boolean z = this.f41777a;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.f41779c;
        if (z3) {
            z3 = true;
        }
        int i3 = (i2 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.f41778b;
        if (!z4) {
            z2 = z4;
        }
        return i3 + (z2 ? 1 : 0);
    }

    public final String toString() {
        return "ChatUIConfig(showNewChatButton=" + this.f41777a + ", showPayButton=" + this.f41779c + ", isFriendsEnabled=" + this.f41778b + ")";
    }

    public c(boolean z, boolean z2, boolean z3) {
        this.f41777a = z;
        this.f41779c = z2;
        this.f41778b = z3;
    }
}
