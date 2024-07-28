package net.one97.paytm.upi.common.upi;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public final class UpiCheckBalanceModel implements UpiBaseDataModel {
    @b(a = "availableBalance")
    private String availableBalance;
    @b(a = "totalBalance")
    private String totalBal;

    public static /* synthetic */ UpiCheckBalanceModel copy$default(UpiCheckBalanceModel upiCheckBalanceModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = upiCheckBalanceModel.totalBal;
        }
        if ((i2 & 2) != 0) {
            str2 = upiCheckBalanceModel.availableBalance;
        }
        return upiCheckBalanceModel.copy(str, str2);
    }

    public final String component1() {
        return this.totalBal;
    }

    public final String component2() {
        return this.availableBalance;
    }

    public final UpiCheckBalanceModel copy(String str, String str2) {
        return new UpiCheckBalanceModel(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpiCheckBalanceModel)) {
            return false;
        }
        UpiCheckBalanceModel upiCheckBalanceModel = (UpiCheckBalanceModel) obj;
        return k.a((Object) this.totalBal, (Object) upiCheckBalanceModel.totalBal) && k.a((Object) this.availableBalance, (Object) upiCheckBalanceModel.availableBalance);
    }

    public final int hashCode() {
        String str = this.totalBal;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.availableBalance;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "UpiCheckBalanceModel(totalBal=" + this.totalBal + ", availableBalance=" + this.availableBalance + ")";
    }

    public UpiCheckBalanceModel(String str, String str2) {
        this.totalBal = str;
        this.availableBalance = str2;
    }

    public final String getTotalBal() {
        return this.totalBal;
    }

    public final void setTotalBal(String str) {
        this.totalBal = str;
    }

    public final String getAvailableBalance() {
        return this.availableBalance;
    }

    public final void setAvailableBalance(String str) {
        this.availableBalance = str;
    }
}
