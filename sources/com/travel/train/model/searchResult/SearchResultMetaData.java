package com.travel.train.model.searchResult;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SearchResultMetaData extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "classes")
    private HashMap<String, Object> classesMeta;
    @a
    @b(a = "quota")
    private HashMap<String, String> quotaMeta;
    @a
    @b(a = "requestid")
    private String requestid;

    public final HashMap<String, Object> getClassesMeta() {
        return this.classesMeta;
    }

    public final void setClassesMeta(HashMap<String, Object> hashMap) {
        this.classesMeta = hashMap;
    }

    public final HashMap<String, String> getQuotaMeta() {
        return this.quotaMeta;
    }

    public final void setQuotaMeta(HashMap<String, String> hashMap) {
        this.quotaMeta = hashMap;
    }

    public SearchResultMetaData(HashMap<String, Object> hashMap, HashMap<String, String> hashMap2, String str) {
        this.classesMeta = hashMap;
        this.quotaMeta = hashMap2;
        this.requestid = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchResultMetaData(HashMap hashMap, HashMap hashMap2, String str, int i2, g gVar) {
        this(hashMap, hashMap2, (i2 & 4) != 0 ? null : str);
    }

    public final String getRequestid() {
        return this.requestid;
    }

    public final void setRequestid(String str) {
        this.requestid = str;
    }
}
