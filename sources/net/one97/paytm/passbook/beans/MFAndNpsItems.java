package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class MFAndNpsItems extends IJRDataModel {
    @b(a = "currentValue")
    private Double currentValue;
    @b(a = "deeplink")
    private String deeplink;

    public MFAndNpsItems() {
        this((Double) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ MFAndNpsItems copy$default(MFAndNpsItems mFAndNpsItems, Double d2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = mFAndNpsItems.currentValue;
        }
        if ((i2 & 2) != 0) {
            str = mFAndNpsItems.deeplink;
        }
        return mFAndNpsItems.copy(d2, str);
    }

    public final Double component1() {
        return this.currentValue;
    }

    public final String component2() {
        return this.deeplink;
    }

    public final MFAndNpsItems copy(Double d2, String str) {
        return new MFAndNpsItems(d2, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MFAndNpsItems)) {
            return false;
        }
        MFAndNpsItems mFAndNpsItems = (MFAndNpsItems) obj;
        return k.a((Object) this.currentValue, (Object) mFAndNpsItems.currentValue) && k.a((Object) this.deeplink, (Object) mFAndNpsItems.deeplink);
    }

    public final int hashCode() {
        Double d2 = this.currentValue;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 31;
        String str = this.deeplink;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "MFAndNpsItems(currentValue=" + this.currentValue + ", deeplink=" + this.deeplink + ")";
    }

    public final Double getCurrentValue() {
        return this.currentValue;
    }

    public final void setCurrentValue(Double d2) {
        this.currentValue = d2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MFAndNpsItems(Double d2, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : d2, (i2 & 2) != 0 ? null : str);
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public MFAndNpsItems(Double d2, String str) {
        this.currentValue = d2;
        this.deeplink = str;
    }
}
