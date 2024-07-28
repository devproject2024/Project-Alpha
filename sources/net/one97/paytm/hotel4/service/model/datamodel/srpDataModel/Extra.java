package net.one97.paytm.hotel4.service.model.datamodel.srpDataModel;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Extra {
    private final List<FiltersItem> filters;
    private final int hotelCount;
    private int nextPage;
    private final SearchParams searchParams;
    @b(a = "selected_sorting_param")
    private final String selectedSortingParam;
    @b(a = "sort_keys")
    private final List<SortKeysItem> sortKeys;

    public static /* synthetic */ Extra copy$default(Extra extra, String str, List<FiltersItem> list, SearchParams searchParams2, List<SortKeysItem> list2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = extra.selectedSortingParam;
        }
        if ((i4 & 2) != 0) {
            list = extra.filters;
        }
        List<FiltersItem> list3 = list;
        if ((i4 & 4) != 0) {
            searchParams2 = extra.searchParams;
        }
        SearchParams searchParams3 = searchParams2;
        if ((i4 & 8) != 0) {
            list2 = extra.sortKeys;
        }
        List<SortKeysItem> list4 = list2;
        if ((i4 & 16) != 0) {
            i2 = extra.hotelCount;
        }
        int i5 = i2;
        if ((i4 & 32) != 0) {
            i3 = extra.nextPage;
        }
        return extra.copy(str, list3, searchParams3, list4, i5, i3);
    }

    public final String component1() {
        return this.selectedSortingParam;
    }

    public final List<FiltersItem> component2() {
        return this.filters;
    }

    public final SearchParams component3() {
        return this.searchParams;
    }

    public final List<SortKeysItem> component4() {
        return this.sortKeys;
    }

    public final int component5() {
        return this.hotelCount;
    }

    public final int component6() {
        return this.nextPage;
    }

    public final Extra copy(String str, List<FiltersItem> list, SearchParams searchParams2, List<SortKeysItem> list2, int i2, int i3) {
        k.c(str, "selectedSortingParam");
        k.c(searchParams2, "searchParams");
        return new Extra(str, list, searchParams2, list2, i2, i3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Extra)) {
            return false;
        }
        Extra extra = (Extra) obj;
        return k.a((Object) this.selectedSortingParam, (Object) extra.selectedSortingParam) && k.a((Object) this.filters, (Object) extra.filters) && k.a((Object) this.searchParams, (Object) extra.searchParams) && k.a((Object) this.sortKeys, (Object) extra.sortKeys) && this.hotelCount == extra.hotelCount && this.nextPage == extra.nextPage;
    }

    public final int hashCode() {
        String str = this.selectedSortingParam;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<FiltersItem> list = this.filters;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        SearchParams searchParams2 = this.searchParams;
        int hashCode3 = (hashCode2 + (searchParams2 != null ? searchParams2.hashCode() : 0)) * 31;
        List<SortKeysItem> list2 = this.sortKeys;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return ((((hashCode3 + i2) * 31) + this.hotelCount) * 31) + this.nextPage;
    }

    public final String toString() {
        return "Extra(selectedSortingParam=" + this.selectedSortingParam + ", filters=" + this.filters + ", searchParams=" + this.searchParams + ", sortKeys=" + this.sortKeys + ", hotelCount=" + this.hotelCount + ", nextPage=" + this.nextPage + ")";
    }

    public Extra(String str, List<FiltersItem> list, SearchParams searchParams2, List<SortKeysItem> list2, int i2, int i3) {
        k.c(str, "selectedSortingParam");
        k.c(searchParams2, "searchParams");
        this.selectedSortingParam = str;
        this.filters = list;
        this.searchParams = searchParams2;
        this.sortKeys = list2;
        this.hotelCount = i2;
        this.nextPage = i3;
    }

    public final String getSelectedSortingParam() {
        return this.selectedSortingParam;
    }

    public final List<FiltersItem> getFilters() {
        return this.filters;
    }

    public final SearchParams getSearchParams() {
        return this.searchParams;
    }

    public final List<SortKeysItem> getSortKeys() {
        return this.sortKeys;
    }

    public final int getHotelCount() {
        return this.hotelCount;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Extra(String str, List list, SearchParams searchParams2, List list2, int i2, int i3, int i4, g gVar) {
        this((i4 & 1) != 0 ? "" : str, list, searchParams2, list2, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 0 : i3);
    }

    public final int getNextPage() {
        return this.nextPage;
    }

    public final void setNextPage(int i2) {
        this.nextPage = i2;
    }
}
