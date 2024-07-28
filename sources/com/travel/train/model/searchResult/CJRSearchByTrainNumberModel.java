package com.travel.train.model.searchResult;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRSearchByTrainNumberModel extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "body")
    private final Body body;
    @a
    @b(a = "code")
    private final int code;
    @a
    @b(a = "error")
    private final String error;
    @a
    @b(a = "meta")
    private final SearchResultMetaData meta;
    private String mirctcuserid;
    @a
    @b(a = "status")
    private final Status status;

    public CJRSearchByTrainNumberModel() {
        this((String) null, (Status) null, (Body) null, (SearchResultMetaData) null, 0, (String) null, 63, (g) null);
    }

    public final String getError() {
        return this.error;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final Body getBody() {
        return this.body;
    }

    public final SearchResultMetaData getMeta() {
        return this.meta;
    }

    public final int getCode() {
        return this.code;
    }

    public CJRSearchByTrainNumberModel(String str, Status status2, Body body2, SearchResultMetaData searchResultMetaData, int i2, String str2) {
        this.error = str;
        this.status = status2;
        this.body = body2;
        this.meta = searchResultMetaData;
        this.code = i2;
        this.mirctcuserid = str2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRSearchByTrainNumberModel(java.lang.String r6, com.travel.train.model.searchResult.Status r7, com.travel.train.model.searchResult.Body r8, com.travel.train.model.searchResult.SearchResultMetaData r9, int r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0024
            r10 = 0
            r4 = 0
            goto L_0x0025
        L_0x0024:
            r4 = r10
        L_0x0025:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002b
            r12 = r0
            goto L_0x002c
        L_0x002b:
            r12 = r11
        L_0x002c:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.model.searchResult.CJRSearchByTrainNumberModel.<init>(java.lang.String, com.travel.train.model.searchResult.Status, com.travel.train.model.searchResult.Body, com.travel.train.model.searchResult.SearchResultMetaData, int, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getMirctcuserid() {
        return this.mirctcuserid;
    }

    public final void setMirctcuserid(String str) {
        this.mirctcuserid = str;
    }
}
