package com.paytm.contactsSdk.models.responses.Search;

import com.paytm.contactsSdk.database.Tables;
import java.util.List;
import kotlin.g.b.k;

public final class EnrichmentContactResponse {
    private final String contactType;
    private final List<EnrichedContact> contacts;
    private final boolean lastPage;
    private final long timeStamp;
    private final int totalCount;

    public static /* synthetic */ EnrichmentContactResponse copy$default(EnrichmentContactResponse enrichmentContactResponse, int i2, String str, long j, boolean z, List<EnrichedContact> list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = enrichmentContactResponse.totalCount;
        }
        if ((i3 & 2) != 0) {
            str = enrichmentContactResponse.contactType;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            j = enrichmentContactResponse.timeStamp;
        }
        long j2 = j;
        if ((i3 & 8) != 0) {
            z = enrichmentContactResponse.lastPage;
        }
        boolean z2 = z;
        if ((i3 & 16) != 0) {
            list = enrichmentContactResponse.contacts;
        }
        return enrichmentContactResponse.copy(i2, str2, j2, z2, list);
    }

    public final int component1() {
        return this.totalCount;
    }

    public final String component2() {
        return this.contactType;
    }

    public final long component3() {
        return this.timeStamp;
    }

    public final boolean component4() {
        return this.lastPage;
    }

    public final List<EnrichedContact> component5() {
        return this.contacts;
    }

    public final EnrichmentContactResponse copy(int i2, String str, long j, boolean z, List<EnrichedContact> list) {
        k.c(str, "contactType");
        k.c(list, Tables.CONTACTS);
        return new EnrichmentContactResponse(i2, str, j, z, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnrichmentContactResponse)) {
            return false;
        }
        EnrichmentContactResponse enrichmentContactResponse = (EnrichmentContactResponse) obj;
        return this.totalCount == enrichmentContactResponse.totalCount && k.a((Object) this.contactType, (Object) enrichmentContactResponse.contactType) && this.timeStamp == enrichmentContactResponse.timeStamp && this.lastPage == enrichmentContactResponse.lastPage && k.a((Object) this.contacts, (Object) enrichmentContactResponse.contacts);
    }

    public final int hashCode() {
        int hashCode = Integer.valueOf(this.totalCount).hashCode() * 31;
        String str = this.contactType;
        int i2 = 0;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Long.valueOf(this.timeStamp).hashCode()) * 31;
        boolean z = this.lastPage;
        if (z) {
            z = true;
        }
        int i3 = (hashCode2 + (z ? 1 : 0)) * 31;
        List<EnrichedContact> list = this.contacts;
        if (list != null) {
            i2 = list.hashCode();
        }
        return i3 + i2;
    }

    public final String toString() {
        return "EnrichmentContactResponse(totalCount=" + this.totalCount + ", contactType=" + this.contactType + ", timeStamp=" + this.timeStamp + ", lastPage=" + this.lastPage + ", contacts=" + this.contacts + ")";
    }

    public EnrichmentContactResponse(int i2, String str, long j, boolean z, List<EnrichedContact> list) {
        k.c(str, "contactType");
        k.c(list, Tables.CONTACTS);
        this.totalCount = i2;
        this.contactType = str;
        this.timeStamp = j;
        this.lastPage = z;
        this.contacts = list;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final String getContactType() {
        return this.contactType;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final boolean getLastPage() {
        return this.lastPage;
    }

    public final List<EnrichedContact> getContacts() {
        return this.contacts;
    }
}
