package net.one97.paytm.v2.features.cashbacklanding.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CashbackCardInfo implements IJRDataModel {
    @b(a = "beforeTime")
    private String beforeTime;
    @b(a = "data")
    private ArrayList<CardOfferData> cardOfferDataList;
    @b(a = "excludedIds")
    private ArrayList<Long> excludedIds;
    @b(a = "remainingTypes")
    private ArrayList<String> remainingTypes;

    public final String getBeforeTime() {
        return this.beforeTime;
    }

    public final void setBeforeTime(String str) {
        this.beforeTime = str;
    }

    public final ArrayList<Long> getExcludedIds() {
        return this.excludedIds;
    }

    public final void setExcludedIds(ArrayList<Long> arrayList) {
        this.excludedIds = arrayList;
    }

    public final ArrayList<String> getRemainingTypes() {
        return this.remainingTypes;
    }

    public final void setRemainingTypes(ArrayList<String> arrayList) {
        this.remainingTypes = arrayList;
    }

    public final ArrayList<CardOfferData> getCardOfferDataList() {
        return this.cardOfferDataList;
    }

    public final void setCardOfferDataList(ArrayList<CardOfferData> arrayList) {
        this.cardOfferDataList = arrayList;
    }
}
