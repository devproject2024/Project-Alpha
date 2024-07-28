package net.one97.paytm.recharge.model.rechargeutility;

import com.google.gsonhtcfix.a.b;

public final class CJRGetBillData {
    @b(a = "status")
    private final int status;

    public static /* synthetic */ CJRGetBillData copy$default(CJRGetBillData cJRGetBillData, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = cJRGetBillData.status;
        }
        return cJRGetBillData.copy(i2);
    }

    public final int component1() {
        return this.status;
    }

    public final CJRGetBillData copy(int i2) {
        return new CJRGetBillData(i2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRGetBillData) {
                if (this.status == ((CJRGetBillData) obj).status) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.status;
    }

    public final String toString() {
        return "CJRGetBillData(status=" + this.status + ")";
    }

    public CJRGetBillData(int i2) {
        this.status = i2;
    }

    public final int getStatus() {
        return this.status;
    }
}
