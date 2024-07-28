package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRTrainSearchResultsMeta extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "classes")
    private HashMap<String, Object> classes;
    @a
    @b(a = "quota")
    private HashMap<String, String> quota;
    @a
    @b(a = "requestid")
    private String requestid;
    @a
    @b(a = "sort_map")
    private HashMap<String, String> sortingTypes;

    public CJRTrainSearchResultsMeta() {
        this((HashMap) null, (HashMap) null, (String) null, (HashMap) null, 15, (g) null);
    }

    public final HashMap<String, String> getQuota() {
        return this.quota;
    }

    public final void setQuota(HashMap<String, String> hashMap) {
        this.quota = hashMap;
    }

    public final HashMap<String, Object> getClasses() {
        return this.classes;
    }

    public final void setClasses(HashMap<String, Object> hashMap) {
        this.classes = hashMap;
    }

    public final String getRequestid() {
        return this.requestid;
    }

    public final void setRequestid(String str) {
        this.requestid = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRTrainSearchResultsMeta(HashMap hashMap, HashMap hashMap2, String str, HashMap hashMap3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : hashMap, (i2 & 2) != 0 ? null : hashMap2, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : hashMap3);
    }

    public final HashMap<String, String> getSortingTypes() {
        return this.sortingTypes;
    }

    public final void setSortingTypes(HashMap<String, String> hashMap) {
        this.sortingTypes = hashMap;
    }

    public CJRTrainSearchResultsMeta(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, String str, HashMap<String, String> hashMap3) {
        this.quota = hashMap;
        this.classes = hashMap2;
        this.requestid = str;
        this.sortingTypes = hashMap3;
    }
}
