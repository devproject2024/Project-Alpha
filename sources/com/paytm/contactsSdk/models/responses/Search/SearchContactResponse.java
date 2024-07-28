package com.paytm.contactsSdk.models.responses.Search;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SearchContactResponse extends IJRPaytmDataModel {
    private final String requestId;
    private final EnrichmentContactResponse response;
    private final SearchStatusInfo statusInfo;

    public SearchContactResponse() {
        this((SearchStatusInfo) null, (EnrichmentContactResponse) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ SearchContactResponse copy$default(SearchContactResponse searchContactResponse, SearchStatusInfo searchStatusInfo, EnrichmentContactResponse enrichmentContactResponse, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            searchStatusInfo = searchContactResponse.statusInfo;
        }
        if ((i2 & 2) != 0) {
            enrichmentContactResponse = searchContactResponse.response;
        }
        if ((i2 & 4) != 0) {
            str = searchContactResponse.requestId;
        }
        return searchContactResponse.copy(searchStatusInfo, enrichmentContactResponse, str);
    }

    public final SearchStatusInfo component1() {
        return this.statusInfo;
    }

    public final EnrichmentContactResponse component2() {
        return this.response;
    }

    public final String component3() {
        return this.requestId;
    }

    public final SearchContactResponse copy(SearchStatusInfo searchStatusInfo, EnrichmentContactResponse enrichmentContactResponse, String str) {
        return new SearchContactResponse(searchStatusInfo, enrichmentContactResponse, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchContactResponse)) {
            return false;
        }
        SearchContactResponse searchContactResponse = (SearchContactResponse) obj;
        return k.a((Object) this.statusInfo, (Object) searchContactResponse.statusInfo) && k.a((Object) this.response, (Object) searchContactResponse.response) && k.a((Object) this.requestId, (Object) searchContactResponse.requestId);
    }

    public final int hashCode() {
        SearchStatusInfo searchStatusInfo = this.statusInfo;
        int i2 = 0;
        int hashCode = (searchStatusInfo != null ? searchStatusInfo.hashCode() : 0) * 31;
        EnrichmentContactResponse enrichmentContactResponse = this.response;
        int hashCode2 = (hashCode + (enrichmentContactResponse != null ? enrichmentContactResponse.hashCode() : 0)) * 31;
        String str = this.requestId;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "SearchContactResponse(statusInfo=" + this.statusInfo + ", response=" + this.response + ", requestId=" + this.requestId + ")";
    }

    public final SearchStatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public final EnrichmentContactResponse getResponse() {
        return this.response;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchContactResponse(SearchStatusInfo searchStatusInfo, EnrichmentContactResponse enrichmentContactResponse, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : searchStatusInfo, (i2 & 2) != 0 ? null : enrichmentContactResponse, (i2 & 4) != 0 ? null : str);
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public SearchContactResponse(SearchStatusInfo searchStatusInfo, EnrichmentContactResponse enrichmentContactResponse, String str) {
        this.statusInfo = searchStatusInfo;
        this.response = enrichmentContactResponse;
        this.requestId = str;
    }
}
