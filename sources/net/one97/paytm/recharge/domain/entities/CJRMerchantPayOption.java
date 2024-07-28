package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRMerchantPayOption extends IJRPaytmDataModel {
    @b(a = "paymentModes")
    private ArrayList<CJRPaymentModes> paymentModes;
    @b(a = "savedInstruments")
    private ArrayList<CJRSavedInstrument> savedInstruments;

    public CJRMerchantPayOption() {
        this((ArrayList) null, (ArrayList) null, 3, (g) null);
    }

    public static /* synthetic */ CJRMerchantPayOption copy$default(CJRMerchantPayOption cJRMerchantPayOption, ArrayList<CJRSavedInstrument> arrayList, ArrayList<CJRPaymentModes> arrayList2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = cJRMerchantPayOption.savedInstruments;
        }
        if ((i2 & 2) != 0) {
            arrayList2 = cJRMerchantPayOption.paymentModes;
        }
        return cJRMerchantPayOption.copy(arrayList, arrayList2);
    }

    public final ArrayList<CJRSavedInstrument> component1() {
        return this.savedInstruments;
    }

    public final ArrayList<CJRPaymentModes> component2() {
        return this.paymentModes;
    }

    public final CJRMerchantPayOption copy(ArrayList<CJRSavedInstrument> arrayList, ArrayList<CJRPaymentModes> arrayList2) {
        return new CJRMerchantPayOption(arrayList, arrayList2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRMerchantPayOption)) {
            return false;
        }
        CJRMerchantPayOption cJRMerchantPayOption = (CJRMerchantPayOption) obj;
        return k.a((Object) this.savedInstruments, (Object) cJRMerchantPayOption.savedInstruments) && k.a((Object) this.paymentModes, (Object) cJRMerchantPayOption.paymentModes);
    }

    public final int hashCode() {
        ArrayList<CJRSavedInstrument> arrayList = this.savedInstruments;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        ArrayList<CJRPaymentModes> arrayList2 = this.paymentModes;
        if (arrayList2 != null) {
            i2 = arrayList2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRMerchantPayOption(savedInstruments=" + this.savedInstruments + ", paymentModes=" + this.paymentModes + ")";
    }

    public final ArrayList<CJRSavedInstrument> getSavedInstruments() {
        return this.savedInstruments;
    }

    public final void setSavedInstruments(ArrayList<CJRSavedInstrument> arrayList) {
        this.savedInstruments = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMerchantPayOption(ArrayList arrayList, ArrayList arrayList2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : arrayList, (i2 & 2) != 0 ? null : arrayList2);
    }

    public final ArrayList<CJRPaymentModes> getPaymentModes() {
        return this.paymentModes;
    }

    public final void setPaymentModes(ArrayList<CJRPaymentModes> arrayList) {
        this.paymentModes = arrayList;
    }

    public CJRMerchantPayOption(ArrayList<CJRSavedInstrument> arrayList, ArrayList<CJRPaymentModes> arrayList2) {
        this.savedInstruments = arrayList;
        this.paymentModes = arrayList2;
    }
}
