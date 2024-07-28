package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRPromoSearchModel extends IJRPaytmDataModel {
    @b(a = "codes")
    private ArrayList<CJRPromoCode> codes;

    public CJRPromoSearchModel() {
        this((ArrayList) null, 1, (g) null);
    }

    public static /* synthetic */ CJRPromoSearchModel copy$default(CJRPromoSearchModel cJRPromoSearchModel, ArrayList<CJRPromoCode> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = cJRPromoSearchModel.codes;
        }
        return cJRPromoSearchModel.copy(arrayList);
    }

    public final ArrayList<CJRPromoCode> component1() {
        return this.codes;
    }

    public final CJRPromoSearchModel copy(ArrayList<CJRPromoCode> arrayList) {
        return new CJRPromoSearchModel(arrayList);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRPromoSearchModel) && k.a((Object) this.codes, (Object) ((CJRPromoSearchModel) obj).codes);
        }
        return true;
    }

    public final int hashCode() {
        ArrayList<CJRPromoCode> arrayList = this.codes;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRPromoSearchModel(codes=" + this.codes + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRPromoSearchModel(ArrayList arrayList, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : arrayList);
    }

    public final ArrayList<CJRPromoCode> getCodes() {
        return this.codes;
    }

    public final void setCodes(ArrayList<CJRPromoCode> arrayList) {
        this.codes = arrayList;
    }

    public CJRPromoSearchModel(ArrayList<CJRPromoCode> arrayList) {
        this.codes = arrayList;
    }
}
