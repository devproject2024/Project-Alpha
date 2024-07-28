package net.one97.paytm.o2o.events.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.events.CJRConfigurationModel;

public class CJRPrevalidateCartItemStaticModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "configuration")
    private CJRConfigurationModel configuration;
    @b(a = "is_ticket")
    private boolean is_ticket;
    @b(a = "meta_data")
    private Object meta_data;
    @b(a = "product_id")
    private String product_id;
    @b(a = "promocode")
    private String promocode;
    @b(a = "promotext")
    private String promotext;
    @b(a = "qty")
    private String qty;

    public String getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(String str) {
        this.product_id = str;
    }

    public String getQty() {
        return this.qty;
    }

    public void setQty(String str) {
        this.qty = str;
    }

    public CJRConfigurationModel getConfiguration() {
        return this.configuration;
    }

    public void setConfiguration(CJRConfigurationModel cJRConfigurationModel) {
        this.configuration = cJRConfigurationModel;
    }

    public Object getMetadata() {
        return this.meta_data;
    }

    public void setMetadata(CJRInputStaticMetaDataModel cJRInputStaticMetaDataModel) {
        this.meta_data = cJRInputStaticMetaDataModel;
    }

    public String getPromocode() {
        return this.promocode;
    }

    public void setPromocode(String str) {
        this.promocode = str;
    }

    public String getPromotext() {
        return this.promotext;
    }

    public void setPromotext(String str) {
        this.promotext = str;
    }

    public boolean isIs_ticket() {
        return this.is_ticket;
    }

    public void setIs_ticket(boolean z) {
        this.is_ticket = z;
    }
}
