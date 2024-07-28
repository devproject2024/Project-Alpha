package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRConfigurationModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "addOnId")
    private String addOnId;
    @b(a = "conv_fee")
    protected String conv_fee;
    private int insurance_id;
    @b(a = "is_F_B")
    private boolean is_F_B;
    @b(a = "is_merchandise")
    private boolean is_merchandise;
    private boolean is_ticket;
    @b(a = "price")
    protected String price;
    private String type;

    public boolean isIs_F_B() {
        return this.is_F_B;
    }

    public void setIs_F_B(boolean z) {
        this.is_F_B = z;
    }

    public String getAddOnId() {
        return this.addOnId;
    }

    public void setAddOnId(String str) {
        this.addOnId = str;
    }

    public boolean is_merchandise() {
        return this.is_merchandise;
    }

    public void is_merchandise(boolean z) {
        this.is_merchandise = z;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getconv_fee() {
        return this.conv_fee;
    }

    public void setconv_fee(String str) {
        this.conv_fee = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public int getInsurance_id() {
        return this.insurance_id;
    }

    public void setInsurance_id(int i2) {
        this.insurance_id = i2;
    }

    public void setIs_ticket(boolean z) {
        this.is_ticket = z;
    }
}
