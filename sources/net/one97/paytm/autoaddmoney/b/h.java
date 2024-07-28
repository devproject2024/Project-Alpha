package net.one97.paytm.autoaddmoney.b;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f49168a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f49169b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof h) {
                h hVar = (h) obj;
                if (this.f49168a == hVar.f49168a) {
                    if (this.f49169b == hVar.f49169b) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.f49168a;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.f49169b;
        if (!z3) {
            z2 = z3;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public final String toString() {
        return "minMaxAmountEmpty(isMinError=" + this.f49168a + ", isautoError=" + this.f49169b + ")";
    }
}
