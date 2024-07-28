package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPrevalidateCartItemModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "configuration")
    private CJRConfigurationModel configuration;
    @b(a = "is_F_B")
    private boolean is_F_B;
    @b(a = "is_ticket")
    private boolean is_ticket;
    @b(a = "meta_data")
    protected Object meta_data;
    @b(a = "product_id")
    protected String product_id;
    @b(a = "promocode")
    protected String promocode;
    @b(a = "promotext")
    protected String promotext;
    @b(a = "qty")
    protected String qty;

    public void setIs_F_B(boolean z) {
        this.is_F_B = z;
    }

    public boolean isIs_F_B() {
        return this.is_F_B;
    }

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

    public void setMetadata(CJRInputMetaDataModel cJRInputMetaDataModel) {
        this.meta_data = cJRInputMetaDataModel;
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
