package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJREnablePaymentMode extends IJRPaytmDataModel {
    @b(a = "banks")
    private ArrayList<String> banks;
    @b(a = "mode")
    private String mode;

    public CJREnablePaymentMode() {
        this((String) null, (ArrayList) null, 3, (g) null);
    }

    public static /* synthetic */ CJREnablePaymentMode copy$default(CJREnablePaymentMode cJREnablePaymentMode, String str, ArrayList<String> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJREnablePaymentMode.mode;
        }
        if ((i2 & 2) != 0) {
            arrayList = cJREnablePaymentMode.banks;
        }
        return cJREnablePaymentMode.copy(str, arrayList);
    }

    public final String component1() {
        return this.mode;
    }

    public final ArrayList<String> component2() {
        return this.banks;
    }

    public final CJREnablePaymentMode copy(String str, ArrayList<String> arrayList) {
        return new CJREnablePaymentMode(str, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJREnablePaymentMode)) {
            return false;
        }
        CJREnablePaymentMode cJREnablePaymentMode = (CJREnablePaymentMode) obj;
        return k.a((Object) this.mode, (Object) cJREnablePaymentMode.mode) && k.a((Object) this.banks, (Object) cJREnablePaymentMode.banks);
    }

    public final int hashCode() {
        String str = this.mode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ArrayList<String> arrayList = this.banks;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJREnablePaymentMode(mode=" + this.mode + ", banks=" + this.banks + ")";
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJREnablePaymentMode(String str, ArrayList arrayList, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : arrayList);
    }

    public final ArrayList<String> getBanks() {
        return this.banks;
    }

    public final void setBanks(ArrayList<String> arrayList) {
        this.banks = arrayList;
    }

    public CJREnablePaymentMode(String str, ArrayList<String> arrayList) {
        this.mode = str;
        this.banks = arrayList;
    }
}
