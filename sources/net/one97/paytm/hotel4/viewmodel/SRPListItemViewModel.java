package net.one97.paytm.hotel4.viewmodel;

import android.content.Context;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import net.one97.paytm.hotels2.utils.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class SRPListItemViewModel extends BaseItemViewModel {
    private int isOriginalPriceVisible = 8;
    private int position = -1;
    public SRPDataItem rowSRPData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SRPListItemViewModel(BaseViewModel baseViewModel) {
        super(baseViewModel);
        k.c(baseViewModel, "parent");
    }

    public final SRPDataItem getRowSRPData() {
        SRPDataItem sRPDataItem = this.rowSRPData;
        if (sRPDataItem == null) {
            k.a("rowSRPData");
        }
        return sRPDataItem;
    }

    public final void setRowSRPData(SRPDataItem sRPDataItem) {
        k.c(sRPDataItem, "<set-?>");
        this.rowSRPData = sRPDataItem;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i2) {
        this.position = i2;
    }

    public final int isOriginalPriceVisible() {
        return this.isOriginalPriceVisible;
    }

    public final void setOriginalPriceVisible(int i2) {
        this.isOriginalPriceVisible = i2;
    }

    public final void onRecyclerItemClick() {
        if (getParent().getParent().getContext() != null && b.c(getParent().getParent().getContext())) {
            BaseViewModel parent = getParent();
            if (parent != null) {
                SRPViewModel sRPViewModel = (SRPViewModel) parent;
                SRPDataItem sRPDataItem = this.rowSRPData;
                if (sRPDataItem == null) {
                    k.a("rowSRPData");
                }
                sRPViewModel.setSelectedHotel(sRPDataItem);
                if (getParent().getParent().getContext() != null) {
                    HashMap hashMap = new HashMap();
                    if (getParent().getParent().getSearchInput() != null) {
                        Map map = hashMap;
                        CJRHotelSearchInput searchInput = getParent().getParent().getSearchInput();
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
                    SRPDataItem sRPDataItem2 = this.rowSRPData;
                    if (sRPDataItem2 == null) {
                        k.a("rowSRPData");
                    }
                    String name = sRPDataItem2.getName();
                    if (name != null) {
                        map2.put("event_label2", name);
                        map2.put("event_label3", Integer.valueOf(this.position + 1));
                        SRPDataItem sRPDataItem3 = this.rowSRPData;
                        if (sRPDataItem3 == null) {
                            k.a("rowSRPData");
                        }
                        map2.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, Double.valueOf(sRPDataItem3.getPriceData().getFinalPrice()));
                        c.b().a("customEvent", "Search Page", "hotels_srp", "property_selected", map2);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.Any");
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.hotel4.viewmodel.SRPViewModel");
        } else if (getParent().getParent().getContext() != null) {
            Context context = getParent().getParent().getContext();
            Context context2 = getParent().getParent().getContext();
            if (context2 == null) {
                k.a();
            }
            String string = context2.getResources().getString(R.string.hotels_hotel_no_internet_title);
            Context context3 = getParent().getParent().getContext();
            if (context3 == null) {
                k.a();
            }
            b.a(context, string, context3.getResources().getString(R.string.hotels_hotel_no_internet_message));
        }
    }

    public final void setData(SRPDataItem sRPDataItem, int i2) {
        k.c(sRPDataItem, "itemData");
        this.rowSRPData = sRPDataItem;
        this.position = i2;
        setOriginalPriceVisibility();
    }

    private final void setOriginalPriceVisibility() {
        SRPDataItem sRPDataItem = this.rowSRPData;
        if (sRPDataItem == null) {
            k.a("rowSRPData");
        }
        double originalPrice = sRPDataItem.getPriceData().getOriginalPrice();
        SRPDataItem sRPDataItem2 = this.rowSRPData;
        if (sRPDataItem2 == null) {
            k.a("rowSRPData");
        }
        this.isOriginalPriceVisible = originalPrice == sRPDataItem2.getPriceData().getFinalPrice() ? 8 : 0;
    }
}
