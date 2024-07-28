package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInsiderHoldCallResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "add_on_id")
    String addOnId;
    @b(a = "addOnsAvailable")
    boolean addOnsAvailable;
    @b(a = "cgstDelivery")
    double cgstDelivery;
    @b(a = "eventsCommission")
    double eventsCommission;
    @b(a = "price")
    double price;
    @b(a = "sgstDelivery")
    double sgstDelivery;
    @b(a = "status")
    String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double d2) {
        this.price = d2;
    }

    public double getSgstDelivery() {
        return this.sgstDelivery;
    }

    public void setSgstDelivery(double d2) {
        this.sgstDelivery = d2;
    }

    public double getCgstDelivery() {
        return this.cgstDelivery;
    }

    public void setCgstDelivery(double d2) {
        this.cgstDelivery = d2;
    }

    public double getEventsCommission() {
        return this.eventsCommission;
    }

    public void setEventsCommission(double d2) {
        this.eventsCommission = d2;
    }

    public boolean isAddOnsAvailable() {
        return this.addOnsAvailable;
    }

    public void setAddOnsAvailable(boolean z) {
        this.addOnsAvailable = z;
    }

    public String getAddOnId() {
        return this.addOnId;
    }

    public void setAddOnId(String str) {
        this.addOnId = str;
    }
}
