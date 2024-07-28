package net.one97.paytm.hotel4.service.model;

import java.util.List;
import kotlin.g.b.g;
import net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem;

public final class HotelSuggestionDataItem {
    private final List<AutoSearchDataItem> city;
    private final List<AutoSearchDataItem> hotels;
    private final List<AutoSearchDataItem> localities;

    public HotelSuggestionDataItem() {
        this((List) null, (List) null, (List) null, 7, (g) null);
    }

    public HotelSuggestionDataItem(List<AutoSearchDataItem> list, List<AutoSearchDataItem> list2, List<AutoSearchDataItem> list3) {
        this.city = list;
        this.hotels = list2;
        this.localities = list3;
    }

    public final List<AutoSearchDataItem> getCity() {
        return this.city;
    }

    public final List<AutoSearchDataItem> getHotels() {
        return this.hotels;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HotelSuggestionDataItem(List list, List list2, List list3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : list2, (i2 & 4) != 0 ? null : list3);
    }

    public final List<AutoSearchDataItem> getLocalities() {
        return this.localities;
    }
}
