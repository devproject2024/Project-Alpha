package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class ResponseV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "bankAccounts")
    private ArrayList<Object> bankAccounts;
    @b(a = "vpaDetails")
    private ArrayList<VpaDetails> vpaDetails;

    public ResponseV2() {
        this((ArrayList) null, (ArrayList) null, 3, (g) null);
    }

    public static /* synthetic */ ResponseV2 copy$default(ResponseV2 responseV2, ArrayList<VpaDetails> arrayList, ArrayList<Object> arrayList2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = responseV2.vpaDetails;
        }
        if ((i2 & 2) != 0) {
            arrayList2 = responseV2.bankAccounts;
        }
        return responseV2.copy(arrayList, arrayList2);
    }

    public final ArrayList<VpaDetails> component1() {
        return this.vpaDetails;
    }

    public final ArrayList<Object> component2() {
        return this.bankAccounts;
    }

    public final ResponseV2 copy(ArrayList<VpaDetails> arrayList, ArrayList<Object> arrayList2) {
        return new ResponseV2(arrayList, arrayList2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseV2)) {
            return false;
        }
        ResponseV2 responseV2 = (ResponseV2) obj;
        return k.a((Object) this.vpaDetails, (Object) responseV2.vpaDetails) && k.a((Object) this.bankAccounts, (Object) responseV2.bankAccounts);
    }

    public final int hashCode() {
        ArrayList<VpaDetails> arrayList = this.vpaDetails;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        ArrayList<Object> arrayList2 = this.bankAccounts;
        if (arrayList2 != null) {
            i2 = arrayList2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ResponseV2(vpaDetails=" + this.vpaDetails + ", bankAccounts=" + this.bankAccounts + ")";
    }

    public final ArrayList<VpaDetails> getVpaDetails() {
        return this.vpaDetails;
    }

    public final void setVpaDetails(ArrayList<VpaDetails> arrayList) {
        this.vpaDetails = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResponseV2(ArrayList arrayList, ArrayList arrayList2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : arrayList, (i2 & 2) != 0 ? null : arrayList2);
    }

    public final ArrayList<Object> getBankAccounts() {
        return this.bankAccounts;
    }

    public final void setBankAccounts(ArrayList<Object> arrayList) {
        this.bankAccounts = arrayList;
    }

    public ResponseV2(ArrayList<VpaDetails> arrayList, ArrayList<Object> arrayList2) {
        this.vpaDetails = arrayList;
        this.bankAccounts = arrayList2;
    }
}
