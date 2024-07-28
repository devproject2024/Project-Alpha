package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.HashMap;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRTrainSearchResults extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "body")
    private CJRTrainSearchResultsBody body;
    @a
    @b(a = "code")
    private Integer code;
    @a
    @b(a = "error")
    private String error;
    private HashMap<String, Object> mTrainQuotaMap;
    @a
    @b(a = "meta")
    private CJRTrainSearchResultsMeta meta;
    @a
    @b(a = "status")
    private CJRTrainStatus status;
    private HashMap<String, String> trainClassesLinkedMap;
    private HashMap<String, Object> trainClassesMap;

    public CJRTrainSearchResults() {
        this((String) null, (CJRTrainStatus) null, (CJRTrainSearchResultsBody) null, (CJRTrainSearchResultsMeta) null, (Integer) null, (HashMap) null, (HashMap) null, (HashMap) null, PriceRangeSeekBar.INVALID_POINTER_ID, (g) null);
    }

    public final String getError() {
        return this.error;
    }

    public final void setError(String str) {
        this.error = str;
    }

    public final CJRTrainStatus getStatus() {
        return this.status;
    }

    public final void setStatus(CJRTrainStatus cJRTrainStatus) {
        this.status = cJRTrainStatus;
    }

    public final CJRTrainSearchResultsBody getBody() {
        return this.body;
    }

    public final void setBody(CJRTrainSearchResultsBody cJRTrainSearchResultsBody) {
        this.body = cJRTrainSearchResultsBody;
    }

    public final CJRTrainSearchResultsMeta getMeta() {
        return this.meta;
    }

    public final void setMeta(CJRTrainSearchResultsMeta cJRTrainSearchResultsMeta) {
        this.meta = cJRTrainSearchResultsMeta;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final void setCode(Integer num) {
        this.code = num;
    }

    public final HashMap<String, Object> getTrainClassesMap() {
        return this.trainClassesMap;
    }

    public final void setTrainClassesMap(HashMap<String, Object> hashMap) {
        this.trainClassesMap = hashMap;
    }

    public final HashMap<String, String> getTrainClassesLinkedMap() {
        return this.trainClassesLinkedMap;
    }

    public final void setTrainClassesLinkedMap(HashMap<String, String> hashMap) {
        this.trainClassesLinkedMap = hashMap;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRTrainSearchResults(java.lang.String r10, com.travel.train.model.trainticket.CJRTrainStatus r11, com.travel.train.model.trainticket.CJRTrainSearchResultsBody r12, com.travel.train.model.trainticket.CJRTrainSearchResultsMeta r13, java.lang.Integer r14, java.util.HashMap r15, java.util.HashMap r16, java.util.HashMap r17, int r18, kotlin.g.b.g r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.model.trainticket.CJRTrainSearchResults.<init>(java.lang.String, com.travel.train.model.trainticket.CJRTrainStatus, com.travel.train.model.trainticket.CJRTrainSearchResultsBody, com.travel.train.model.trainticket.CJRTrainSearchResultsMeta, java.lang.Integer, java.util.HashMap, java.util.HashMap, java.util.HashMap, int, kotlin.g.b.g):void");
    }

    public final HashMap<String, Object> getMTrainQuotaMap() {
        return this.mTrainQuotaMap;
    }

    public final void setMTrainQuotaMap(HashMap<String, Object> hashMap) {
        this.mTrainQuotaMap = hashMap;
    }

    public CJRTrainSearchResults(String str, CJRTrainStatus cJRTrainStatus, CJRTrainSearchResultsBody cJRTrainSearchResultsBody, CJRTrainSearchResultsMeta cJRTrainSearchResultsMeta, Integer num, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2, HashMap<String, Object> hashMap3) {
        this.error = str;
        this.status = cJRTrainStatus;
        this.body = cJRTrainSearchResultsBody;
        this.meta = cJRTrainSearchResultsMeta;
        this.code = num;
        this.trainClassesMap = hashMap;
        this.trainClassesLinkedMap = hashMap2;
        this.mTrainQuotaMap = hashMap3;
    }
}
