package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class DataInfo extends IJRDataModel {
    @b(a = "deeplink")
    private String deeplink;
    @b(a = "mutualFunds")
    private MFAndNpsItems mutualFunds;
    @b(a = "nps")
    private MFAndNpsItems nps;
    @b(a = "totalCurrentValue")
    private Double totalCurrentValue;

    public DataInfo() {
        this((Double) null, (String) null, (MFAndNpsItems) null, (MFAndNpsItems) null, 15, (g) null);
    }

    public static /* synthetic */ DataInfo copy$default(DataInfo dataInfo, Double d2, String str, MFAndNpsItems mFAndNpsItems, MFAndNpsItems mFAndNpsItems2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = dataInfo.totalCurrentValue;
        }
        if ((i2 & 2) != 0) {
            str = dataInfo.deeplink;
        }
        if ((i2 & 4) != 0) {
            mFAndNpsItems = dataInfo.mutualFunds;
        }
        if ((i2 & 8) != 0) {
            mFAndNpsItems2 = dataInfo.nps;
        }
        return dataInfo.copy(d2, str, mFAndNpsItems, mFAndNpsItems2);
    }

    public final Double component1() {
        return this.totalCurrentValue;
    }

    public final String component2() {
        return this.deeplink;
    }

    public final MFAndNpsItems component3() {
        return this.mutualFunds;
    }

    public final MFAndNpsItems component4() {
        return this.nps;
    }

    public final DataInfo copy(Double d2, String str, MFAndNpsItems mFAndNpsItems, MFAndNpsItems mFAndNpsItems2) {
        return new DataInfo(d2, str, mFAndNpsItems, mFAndNpsItems2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataInfo)) {
            return false;
        }
        DataInfo dataInfo = (DataInfo) obj;
        return k.a((Object) this.totalCurrentValue, (Object) dataInfo.totalCurrentValue) && k.a((Object) this.deeplink, (Object) dataInfo.deeplink) && k.a((Object) this.mutualFunds, (Object) dataInfo.mutualFunds) && k.a((Object) this.nps, (Object) dataInfo.nps);
    }

    public final int hashCode() {
        Double d2 = this.totalCurrentValue;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 31;
        String str = this.deeplink;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        MFAndNpsItems mFAndNpsItems = this.mutualFunds;
        int hashCode3 = (hashCode2 + (mFAndNpsItems != null ? mFAndNpsItems.hashCode() : 0)) * 31;
        MFAndNpsItems mFAndNpsItems2 = this.nps;
        if (mFAndNpsItems2 != null) {
            i2 = mFAndNpsItems2.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "DataInfo(totalCurrentValue=" + this.totalCurrentValue + ", deeplink=" + this.deeplink + ", mutualFunds=" + this.mutualFunds + ", nps=" + this.nps + ")";
    }

    public final Double getTotalCurrentValue() {
        return this.totalCurrentValue;
    }

    public final void setTotalCurrentValue(Double d2) {
        this.totalCurrentValue = d2;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final MFAndNpsItems getMutualFunds() {
        return this.mutualFunds;
    }

    public final void setMutualFunds(MFAndNpsItems mFAndNpsItems) {
        this.mutualFunds = mFAndNpsItems;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataInfo(Double d2, String str, MFAndNpsItems mFAndNpsItems, MFAndNpsItems mFAndNpsItems2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : d2, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : mFAndNpsItems, (i2 & 8) != 0 ? null : mFAndNpsItems2);
    }

    public final MFAndNpsItems getNps() {
        return this.nps;
    }

    public final void setNps(MFAndNpsItems mFAndNpsItems) {
        this.nps = mFAndNpsItems;
    }

    public DataInfo(Double d2, String str, MFAndNpsItems mFAndNpsItems, MFAndNpsItems mFAndNpsItems2) {
        this.totalCurrentValue = d2;
        this.deeplink = str;
        this.mutualFunds = mFAndNpsItems;
        this.nps = mFAndNpsItems2;
    }
}
