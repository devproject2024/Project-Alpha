package com.paytm.contactsSdk.models;

import kotlin.g.b.k;

public final class EnrichmentData {
    private long enrichmentBitCodeCol_0;
    private long enrichmentBitCodeCol_1;
    private long enrichmentBitCodeCol_2;
    private long enrichmentBitCodeCol_3;
    private String featureJson;
    private final String phoneNumber;

    public static /* synthetic */ EnrichmentData copy$default(EnrichmentData enrichmentData, String str, long j, long j2, long j3, long j4, String str2, int i2, Object obj) {
        EnrichmentData enrichmentData2 = enrichmentData;
        return enrichmentData.copy((i2 & 1) != 0 ? enrichmentData2.phoneNumber : str, (i2 & 2) != 0 ? enrichmentData2.enrichmentBitCodeCol_0 : j, (i2 & 4) != 0 ? enrichmentData2.enrichmentBitCodeCol_1 : j2, (i2 & 8) != 0 ? enrichmentData2.enrichmentBitCodeCol_2 : j3, (i2 & 16) != 0 ? enrichmentData2.enrichmentBitCodeCol_3 : j4, (i2 & 32) != 0 ? enrichmentData2.featureJson : str2);
    }

    public final String component1() {
        return this.phoneNumber;
    }

    public final long component2() {
        return this.enrichmentBitCodeCol_0;
    }

    public final long component3() {
        return this.enrichmentBitCodeCol_1;
    }

    public final long component4() {
        return this.enrichmentBitCodeCol_2;
    }

    public final long component5() {
        return this.enrichmentBitCodeCol_3;
    }

    public final String component6() {
        return this.featureJson;
    }

    public final EnrichmentData copy(String str, long j, long j2, long j3, long j4, String str2) {
        k.c(str, "phoneNumber");
        return new EnrichmentData(str, j, j2, j3, j4, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnrichmentData)) {
            return false;
        }
        EnrichmentData enrichmentData = (EnrichmentData) obj;
        return k.a((Object) this.phoneNumber, (Object) enrichmentData.phoneNumber) && this.enrichmentBitCodeCol_0 == enrichmentData.enrichmentBitCodeCol_0 && this.enrichmentBitCodeCol_1 == enrichmentData.enrichmentBitCodeCol_1 && this.enrichmentBitCodeCol_2 == enrichmentData.enrichmentBitCodeCol_2 && this.enrichmentBitCodeCol_3 == enrichmentData.enrichmentBitCodeCol_3 && k.a((Object) this.featureJson, (Object) enrichmentData.featureJson);
    }

    public final int hashCode() {
        String str = this.phoneNumber;
        int i2 = 0;
        int hashCode = (((((((((str != null ? str.hashCode() : 0) * 31) + Long.valueOf(this.enrichmentBitCodeCol_0).hashCode()) * 31) + Long.valueOf(this.enrichmentBitCodeCol_1).hashCode()) * 31) + Long.valueOf(this.enrichmentBitCodeCol_2).hashCode()) * 31) + Long.valueOf(this.enrichmentBitCodeCol_3).hashCode()) * 31;
        String str2 = this.featureJson;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "EnrichmentData(phoneNumber=" + this.phoneNumber + ", enrichmentBitCodeCol_0=" + this.enrichmentBitCodeCol_0 + ", enrichmentBitCodeCol_1=" + this.enrichmentBitCodeCol_1 + ", enrichmentBitCodeCol_2=" + this.enrichmentBitCodeCol_2 + ", enrichmentBitCodeCol_3=" + this.enrichmentBitCodeCol_3 + ", featureJson=" + this.featureJson + ")";
    }

    public EnrichmentData(String str, long j, long j2, long j3, long j4, String str2) {
        k.c(str, "phoneNumber");
        this.phoneNumber = str;
        this.enrichmentBitCodeCol_0 = j;
        this.enrichmentBitCodeCol_1 = j2;
        this.enrichmentBitCodeCol_2 = j3;
        this.enrichmentBitCodeCol_3 = j4;
        this.featureJson = str2;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final long getEnrichmentBitCodeCol_0() {
        return this.enrichmentBitCodeCol_0;
    }

    public final void setEnrichmentBitCodeCol_0(long j) {
        this.enrichmentBitCodeCol_0 = j;
    }

    public final long getEnrichmentBitCodeCol_1() {
        return this.enrichmentBitCodeCol_1;
    }

    public final void setEnrichmentBitCodeCol_1(long j) {
        this.enrichmentBitCodeCol_1 = j;
    }

    public final long getEnrichmentBitCodeCol_2() {
        return this.enrichmentBitCodeCol_2;
    }

    public final void setEnrichmentBitCodeCol_2(long j) {
        this.enrichmentBitCodeCol_2 = j;
    }

    public final long getEnrichmentBitCodeCol_3() {
        return this.enrichmentBitCodeCol_3;
    }

    public final void setEnrichmentBitCodeCol_3(long j) {
        this.enrichmentBitCodeCol_3 = j;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ EnrichmentData(java.lang.String r10, long r11, long r13, long r15, long r17, java.lang.String r19, int r20, kotlin.g.b.g r21) {
        /*
            r9 = this;
            r0 = r20 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r11
        L_0x0009:
            r0 = r20 & 4
            if (r0 == 0) goto L_0x000f
            r5 = r1
            goto L_0x0010
        L_0x000f:
            r5 = r13
        L_0x0010:
            r0 = r20 & 8
            if (r0 == 0) goto L_0x0016
            r7 = r1
            goto L_0x0017
        L_0x0016:
            r7 = r15
        L_0x0017:
            r0 = r20 & 16
            if (r0 == 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r1 = r17
        L_0x001e:
            r0 = r20 & 32
            if (r0 == 0) goto L_0x0024
            r0 = 0
            goto L_0x0026
        L_0x0024:
            r0 = r19
        L_0x0026:
            r11 = r9
            r12 = r10
            r13 = r3
            r15 = r5
            r17 = r7
            r19 = r1
            r21 = r0
            r11.<init>(r12, r13, r15, r17, r19, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.contactsSdk.models.EnrichmentData.<init>(java.lang.String, long, long, long, long, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getFeatureJson() {
        return this.featureJson;
    }

    public final void setFeatureJson(String str) {
        this.featureJson = str;
    }
}
