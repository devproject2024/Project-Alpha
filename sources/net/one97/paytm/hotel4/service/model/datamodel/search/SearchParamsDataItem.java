package net.one97.paytm.hotel4.service.model.datamodel.search;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SearchParamsDataItem extends IJRPaytmDataModel {
    private String city;
    private FilterParams filter_params;
    private boolean is_locality_search;
    private boolean nearBy;
    private String poi;
    private String sort_by;

    public SearchParamsDataItem() {
        this((String) null, (String) null, (String) null, false, false, (FilterParams) null, 63, (g) null);
    }

    public static /* synthetic */ SearchParamsDataItem copy$default(SearchParamsDataItem searchParamsDataItem, String str, String str2, String str3, boolean z, boolean z2, FilterParams filterParams, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = searchParamsDataItem.city;
        }
        if ((i2 & 2) != 0) {
            str2 = searchParamsDataItem.poi;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = searchParamsDataItem.sort_by;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            z = searchParamsDataItem.nearBy;
        }
        boolean z3 = z;
        if ((i2 & 16) != 0) {
            z2 = searchParamsDataItem.is_locality_search;
        }
        boolean z4 = z2;
        if ((i2 & 32) != 0) {
            filterParams = searchParamsDataItem.filter_params;
        }
        return searchParamsDataItem.copy(str, str4, str5, z3, z4, filterParams);
    }

    public final String component1() {
        return this.city;
    }

    public final String component2() {
        return this.poi;
    }

    public final String component3() {
        return this.sort_by;
    }

    public final boolean component4() {
        return this.nearBy;
    }

    public final boolean component5() {
        return this.is_locality_search;
    }

    public final FilterParams component6() {
        return this.filter_params;
    }

    public final SearchParamsDataItem copy(String str, String str2, String str3, boolean z, boolean z2, FilterParams filterParams) {
        k.c(str3, "sort_by");
        k.c(filterParams, "filter_params");
        return new SearchParamsDataItem(str, str2, str3, z, z2, filterParams);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchParamsDataItem)) {
            return false;
        }
        SearchParamsDataItem searchParamsDataItem = (SearchParamsDataItem) obj;
        return k.a((Object) this.city, (Object) searchParamsDataItem.city) && k.a((Object) this.poi, (Object) searchParamsDataItem.poi) && k.a((Object) this.sort_by, (Object) searchParamsDataItem.sort_by) && this.nearBy == searchParamsDataItem.nearBy && this.is_locality_search == searchParamsDataItem.is_locality_search && k.a((Object) this.filter_params, (Object) searchParamsDataItem.filter_params);
    }

    public final int hashCode() {
        String str = this.city;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.poi;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.sort_by;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.nearBy;
        if (z) {
            z = true;
        }
        int i3 = (hashCode3 + (z ? 1 : 0)) * 31;
        boolean z2 = this.is_locality_search;
        if (z2) {
            z2 = true;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        FilterParams filterParams = this.filter_params;
        if (filterParams != null) {
            i2 = filterParams.hashCode();
        }
        return i4 + i2;
    }

    public final String toString() {
        return "SearchParamsDataItem(city=" + this.city + ", poi=" + this.poi + ", sort_by=" + this.sort_by + ", nearBy=" + this.nearBy + ", is_locality_search=" + this.is_locality_search + ", filter_params=" + this.filter_params + ")";
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getPoi() {
        return this.poi;
    }

    public final void setPoi(String str) {
        this.poi = str;
    }

    public final String getSort_by() {
        return this.sort_by;
    }

    public final void setSort_by(String str) {
        k.c(str, "<set-?>");
        this.sort_by = str;
    }

    public final boolean getNearBy() {
        return this.nearBy;
    }

    public final void setNearBy(boolean z) {
        this.nearBy = z;
    }

    public final boolean is_locality_search() {
        return this.is_locality_search;
    }

    public final void set_locality_search(boolean z) {
        this.is_locality_search = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SearchParamsDataItem(java.lang.String r5, java.lang.String r6, java.lang.String r7, boolean r8, boolean r9, net.one97.paytm.hotel4.service.model.datamodel.search.FilterParams r10, int r11, kotlin.g.b.g r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            java.lang.String r0 = ""
            if (r12 == 0) goto L_0x0008
            r12 = r0
            goto L_0x0009
        L_0x0008:
            r12 = r5
        L_0x0009:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r6
        L_0x0010:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r0 = r7
        L_0x0016:
            r5 = r11 & 8
            r6 = 0
            if (r5 == 0) goto L_0x001d
            r2 = 0
            goto L_0x001e
        L_0x001d:
            r2 = r8
        L_0x001e:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0024
            r3 = 0
            goto L_0x0025
        L_0x0024:
            r3 = r9
        L_0x0025:
            r5 = r11 & 32
            if (r5 == 0) goto L_0x0030
            net.one97.paytm.hotel4.service.model.datamodel.search.FilterParams r10 = new net.one97.paytm.hotel4.service.model.datamodel.search.FilterParams
            r5 = 3
            r6 = 0
            r10.<init>(r6, r6, r5, r6)
        L_0x0030:
            r11 = r10
            r5 = r4
            r6 = r12
            r7 = r1
            r8 = r0
            r9 = r2
            r10 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, net.one97.paytm.hotel4.service.model.datamodel.search.FilterParams, int, kotlin.g.b.g):void");
    }

    public final FilterParams getFilter_params() {
        return this.filter_params;
    }

    public final void setFilter_params(FilterParams filterParams) {
        k.c(filterParams, "<set-?>");
        this.filter_params = filterParams;
    }

    public SearchParamsDataItem(String str, String str2, String str3, boolean z, boolean z2, FilterParams filterParams) {
        k.c(str3, "sort_by");
        k.c(filterParams, "filter_params");
        this.city = str;
        this.poi = str2;
        this.sort_by = str3;
        this.nearBy = z;
        this.is_locality_search = z2;
        this.filter_params = filterParams;
    }
}
