package net.one97.paytm.o2o.events.common.entity.events;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.events.CJREventAddOnItemsModel;

public class CJREventsTicketsAddOnsModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "add_on_id")
    private String addOnId;
    @b(a = "addon_items")
    private CJREventAddOnItemsModel addOnItems;
    @b(a = "addOnsAvailable")
    private boolean addOnsAvailable;

    public boolean isAddOnsAvailable() {
        return this.addOnsAvailable;
    }

    public void setAddOnsAvailable(boolean z) {
        this.addOnsAvailable = z;
    }

    public CJREventAddOnItemsModel getAddOnItems() {
        return this.addOnItems;
    }

    public void setAddOnItems(CJREventAddOnItemsModel cJREventAddOnItemsModel) {
        this.addOnItems = cJREventAddOnItemsModel;
    }

    public String getAddOnId() {
        return this.addOnId;
    }

    public void setAddOnId(String str) {
        this.addOnId = str;
    }
}
