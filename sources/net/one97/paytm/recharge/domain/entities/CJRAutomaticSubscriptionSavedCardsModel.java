package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRAutomaticSubscriptionSavedCardsModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "data")
    private ArrayList<AutomaticSubscriptionSavedCard> data;

    public CJRAutomaticSubscriptionSavedCardsModel() {
        this((ArrayList) null, 1, (g) null);
    }

    public static /* synthetic */ CJRAutomaticSubscriptionSavedCardsModel copy$default(CJRAutomaticSubscriptionSavedCardsModel cJRAutomaticSubscriptionSavedCardsModel, ArrayList<AutomaticSubscriptionSavedCard> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = cJRAutomaticSubscriptionSavedCardsModel.data;
        }
        return cJRAutomaticSubscriptionSavedCardsModel.copy(arrayList);
    }

    public final ArrayList<AutomaticSubscriptionSavedCard> component1() {
        return this.data;
    }

    public final CJRAutomaticSubscriptionSavedCardsModel copy(ArrayList<AutomaticSubscriptionSavedCard> arrayList) {
        return new CJRAutomaticSubscriptionSavedCardsModel(arrayList);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRAutomaticSubscriptionSavedCardsModel) && k.a((Object) this.data, (Object) ((CJRAutomaticSubscriptionSavedCardsModel) obj).data);
        }
        return true;
    }

    public final int hashCode() {
        ArrayList<AutomaticSubscriptionSavedCard> arrayList = this.data;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRAutomaticSubscriptionSavedCardsModel(data=" + this.data + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRAutomaticSubscriptionSavedCardsModel(ArrayList arrayList, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : arrayList);
    }

    public final ArrayList<AutomaticSubscriptionSavedCard> getData() {
        return this.data;
    }

    public final void setData(ArrayList<AutomaticSubscriptionSavedCard> arrayList) {
        this.data = arrayList;
    }

    public CJRAutomaticSubscriptionSavedCardsModel(ArrayList<AutomaticSubscriptionSavedCard> arrayList) {
        this.data = arrayList;
    }
}
