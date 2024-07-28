package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public final class ScratchCardSectionListData extends IJRPaytmDataModel {
    @b(a = "beforeTime")
    private String beforeTime;
    @b(a = "excludedIds")
    private ArrayList<Long> excludedIds;
    @b(a = "gratificationSummary")
    private ArrayList<GratificationSummaryData> gratificationSummary;
    @b(a = "isNext")
    private boolean isNext;
    @b(a = "scratchCardList")
    private ArrayList<ScratchCard> scratchCardList;

    public final ArrayList<ScratchCard> getScratchCardList() {
        return this.scratchCardList;
    }

    public final void setScratchCardList(ArrayList<ScratchCard> arrayList) {
        this.scratchCardList = arrayList;
    }

    public final String getBeforeTime() {
        return this.beforeTime;
    }

    public final void setBeforeTime(String str) {
        this.beforeTime = str;
    }

    public final boolean isNext() {
        return this.isNext;
    }

    public final void setNext(boolean z) {
        this.isNext = z;
    }

    public final ArrayList<Long> getExcludedIds() {
        return this.excludedIds;
    }

    public final void setExcludedIds(ArrayList<Long> arrayList) {
        this.excludedIds = arrayList;
    }

    public final ArrayList<GratificationSummaryData> getGratificationSummary() {
        return this.gratificationSummary;
    }

    public final void setGratificationSummary(ArrayList<GratificationSummaryData> arrayList) {
        this.gratificationSummary = arrayList;
    }
}
