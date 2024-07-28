package net.one97.paytm.autoaddmoney.b;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f49161a;

    /* renamed from: b  reason: collision with root package name */
    public final int f49162b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (this.f49161a == eVar.f49161a) {
                    if (this.f49162b == eVar.f49162b) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.f49161a * 31) + this.f49162b;
    }

    public final String toString() {
        return "MinMaxAmountWrapper(minAmount=" + this.f49161a + ", maxAmount=" + this.f49162b + ")";
    }

    public e(int i2, int i3) {
        this.f49161a = i2;
        this.f49162b = i3;
    }
}
