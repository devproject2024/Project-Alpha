package net.one97.paytm.hotel4.viewmodel;

import com.travel.utils.l;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import net.one97.paytm.hotels2.utils.c;

public final class SRPSortViewModel extends BaseViewModel {
    private l<Boolean> closeButtonClickListener = new l<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SRPSortViewModel(SharedViewModel sharedViewModel) {
        super(sharedViewModel);
        k.c(sharedViewModel, "parent");
    }

    public final l<Boolean> getCloseButtonClickListener() {
        return this.closeButtonClickListener;
    }

    public final void setCloseButtonClickListener(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.closeButtonClickListener = lVar;
    }

    public final void closeButtonClickHandler() {
        this.closeButtonClickListener.setValue(Boolean.TRUE);
    }

    public final void sortItemClickHandler(SortKeysItem sortKeysItem, int i2) {
        k.c(sortKeysItem, "data");
        CJRHotelSearchInput searchInput = getParent().getSearchInput();
        if (searchInput != null) {
            searchInput.setSortBy(sortKeysItem);
        }
        this.closeButtonClickListener.setValue(Boolean.TRUE);
        sendPulseEvent(sortKeysItem.getName());
        getParent().postScreenNavigationEvent("2", "3");
    }

    private final void sendPulseEvent(String str) {
        HashMap hashMap = new HashMap();
        if (getParent().getSearchInput() != null) {
            Map map = hashMap;
            CJRHotelSearchInput searchInput = getParent().getSearchInput();
            if (searchInput == null) {
                k.a();
            }
            String city = searchInput.getCity();
            if (city != null) {
                map.put("event_label", city);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Any");
            }
        }
        Map map2 = hashMap;
        if (str != null) {
            map2.put("event_label2", str);
            c.b().a("customEvent", "Search Page", "hotels_srp", "results_sorted", map2);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.Any");
    }
}
