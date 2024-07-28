package com.paytm.contactsSdk.models.responses.Search;

import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SearchContactInfo {
    private final List<String> emails;
    private final Meta meta;
    private final Phones phones;

    public SearchContactInfo() {
        this((List) null, (Meta) null, (Phones) null, 7, (g) null);
    }

    private final List<String> component1() {
        return this.emails;
    }

    private final Meta component2() {
        return this.meta;
    }

    private final Phones component3() {
        return this.phones;
    }

    public static /* synthetic */ SearchContactInfo copy$default(SearchContactInfo searchContactInfo, List<String> list, Meta meta2, Phones phones2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = searchContactInfo.emails;
        }
        if ((i2 & 2) != 0) {
            meta2 = searchContactInfo.meta;
        }
        if ((i2 & 4) != 0) {
            phones2 = searchContactInfo.phones;
        }
        return searchContactInfo.copy(list, meta2, phones2);
    }

    public final SearchContactInfo copy(List<String> list, Meta meta2, Phones phones2) {
        return new SearchContactInfo(list, meta2, phones2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchContactInfo)) {
            return false;
        }
        SearchContactInfo searchContactInfo = (SearchContactInfo) obj;
        return k.a((Object) this.emails, (Object) searchContactInfo.emails) && k.a((Object) this.meta, (Object) searchContactInfo.meta) && k.a((Object) this.phones, (Object) searchContactInfo.phones);
    }

    public final int hashCode() {
        List<String> list = this.emails;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Meta meta2 = this.meta;
        int hashCode2 = (hashCode + (meta2 != null ? meta2.hashCode() : 0)) * 31;
        Phones phones2 = this.phones;
        if (phones2 != null) {
            i2 = phones2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "SearchContactInfo(emails=" + this.emails + ", meta=" + this.meta + ", phones=" + this.phones + ")";
    }

    public SearchContactInfo(List<String> list, Meta meta2, Phones phones2) {
        this.emails = list;
        this.meta = meta2;
        this.phones = phones2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchContactInfo(List list, Meta meta2, Phones phones2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : meta2, (i2 & 4) != 0 ? null : phones2);
    }
}
