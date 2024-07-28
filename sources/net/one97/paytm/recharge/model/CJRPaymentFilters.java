package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRPaymentFilters extends IJRPaytmDataModel {
    @b(a = "enablePaymentMode")
    private ArrayList<CJREnablePaymentMode> enablePaymentModes;
    @b(a = "is8DigitBin")
    private boolean is8DigitBin;

    public static /* synthetic */ CJRPaymentFilters copy$default(CJRPaymentFilters cJRPaymentFilters, ArrayList<CJREnablePaymentMode> arrayList, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = cJRPaymentFilters.enablePaymentModes;
        }
        if ((i2 & 2) != 0) {
            z = cJRPaymentFilters.is8DigitBin;
        }
        return cJRPaymentFilters.copy(arrayList, z);
    }

    public final ArrayList<CJREnablePaymentMode> component1() {
        return this.enablePaymentModes;
    }

    public final boolean component2() {
        return this.is8DigitBin;
    }

    public final CJRPaymentFilters copy(ArrayList<CJREnablePaymentMode> arrayList, boolean z) {
        return new CJRPaymentFilters(arrayList, z);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRPaymentFilters) {
                CJRPaymentFilters cJRPaymentFilters = (CJRPaymentFilters) obj;
                if (k.a((Object) this.enablePaymentModes, (Object) cJRPaymentFilters.enablePaymentModes)) {
                    if (this.is8DigitBin == cJRPaymentFilters.is8DigitBin) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        ArrayList<CJREnablePaymentMode> arrayList = this.enablePaymentModes;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        boolean z = this.is8DigitBin;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final String toString() {
        return "CJRPaymentFilters(enablePaymentModes=" + this.enablePaymentModes + ", is8DigitBin=" + this.is8DigitBin + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRPaymentFilters(ArrayList arrayList, boolean z, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : arrayList, z);
    }

    public final ArrayList<CJREnablePaymentMode> getEnablePaymentModes() {
        return this.enablePaymentModes;
    }

    public final void setEnablePaymentModes(ArrayList<CJREnablePaymentMode> arrayList) {
        this.enablePaymentModes = arrayList;
    }

    public final boolean is8DigitBin() {
        return this.is8DigitBin;
    }

    public final void set8DigitBin(boolean z) {
        this.is8DigitBin = z;
    }

    public CJRPaymentFilters(ArrayList<CJREnablePaymentMode> arrayList, boolean z) {
        this.enablePaymentModes = arrayList;
        this.is8DigitBin = z;
    }
}
