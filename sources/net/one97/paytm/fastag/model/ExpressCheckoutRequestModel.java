package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class ExpressCheckoutRequestModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "address")
    private TollAddress address;
    @b(a = "billing_address")
    private TollAddress billing_address;
    @b(a = "cart_items")
    private List<TollCartItemModel> cart_items = new ArrayList();
    @b(a = "gstin")
    private String gstin;
    @b(a = "has_gstin")
    private boolean has_gstin;
    @b(a = "promocode")
    private String promocode;

    public TollAddress getAddress() {
        return this.address;
    }

    public void setAddress(TollAddress tollAddress) {
        this.address = tollAddress;
    }

    public boolean isHas_gstin() {
        return this.has_gstin;
    }

    public void setHas_gstin(boolean z) {
        this.has_gstin = z;
    }

    public String getGstin() {
        return this.gstin;
    }

    public void setGstin(String str) {
        this.gstin = str;
    }

    public TollAddress getBilling_address() {
        return this.billing_address;
    }

    public void setBilling_address(TollAddress tollAddress) {
        this.billing_address = tollAddress;
    }

    public List<TollCartItemModel> getCart_items() {
        return this.cart_items;
    }

    public void setCart_items(List<TollCartItemModel> list) {
        this.cart_items = list;
    }

    public String getPromocode() {
        return this.promocode;
    }

    public void setPromocode(String str) {
        this.promocode = str;
    }
}
