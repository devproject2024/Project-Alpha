package net.one97.paytm.hotel4.service.model.datamodel.search;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class AutoSearchDataItem extends IJRPaytmDataModel {
    private List<String> display;
    private boolean isRecentSearch;
    private SearchParamsDataItem searchParams;
    private String type;
    private transient Integer viewType;
    private Integer viewTypeCount;

    public AutoSearchDataItem() {
        this((Integer) null, (List) null, (SearchParamsDataItem) null, (String) null, (Integer) null, false, 63, (g) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AutoSearchDataItem(java.lang.Integer r5, java.util.List r6, net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem r7, java.lang.String r8, java.lang.Integer r9, boolean r10, int r11, kotlin.g.b.g r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            r0 = 0
            if (r12 == 0) goto L_0x0009
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
        L_0x0009:
            r12 = r11 & 2
            r1 = 0
            if (r12 == 0) goto L_0x0010
            r12 = r1
            goto L_0x0011
        L_0x0010:
            r12 = r6
        L_0x0011:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r1 = r7
        L_0x0017:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001d
            java.lang.String r8 = ""
        L_0x001d:
            r2 = r8
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0027
            r6 = -1
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
        L_0x0027:
            r3 = r9
            r6 = r11 & 32
            if (r6 == 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r0 = r10
        L_0x002e:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem.<init>(java.lang.Integer, java.util.List, net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem, java.lang.String, java.lang.Integer, boolean, int, kotlin.g.b.g):void");
    }

    public final Integer getViewType() {
        return this.viewType;
    }

    public final void setViewType(Integer num) {
        this.viewType = num;
    }

    public final List<String> getDisplay() {
        return this.display;
    }

    public final void setDisplay(List<String> list) {
        this.display = list;
    }

    public final SearchParamsDataItem getSearchParams() {
        return this.searchParams;
    }

    public final void setSearchParams(SearchParamsDataItem searchParamsDataItem) {
        this.searchParams = searchParamsDataItem;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        k.c(str, "<set-?>");
        this.type = str;
    }

    public final Integer getViewTypeCount() {
        return this.viewTypeCount;
    }

    public final void setViewTypeCount(Integer num) {
        this.viewTypeCount = num;
    }

    public final boolean isRecentSearch() {
        return this.isRecentSearch;
    }

    public final void setRecentSearch(boolean z) {
        this.isRecentSearch = z;
    }

    public AutoSearchDataItem(Integer num, List<String> list, SearchParamsDataItem searchParamsDataItem, String str, Integer num2, boolean z) {
        k.c(str, "type");
        this.viewType = num;
        this.display = list;
        this.searchParams = searchParamsDataItem;
        this.type = str;
        this.viewTypeCount = num2;
        this.isRecentSearch = z;
    }
}
