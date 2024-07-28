package net.one97.paytm.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class LifeInsPlanTaxBreakUp extends IJRPaytmDataModel {
    @b(a = "tax_amount")
    private String taxAmount;
    @b(a = "tax_name")
    private String taxName;
    @b(a = "tax_rate")
    private String taxRate;

    public String getTaxName() {
        return this.taxName;
    }

    public void setTaxName(String str) {
        this.taxName = str;
    }

    public String getTaxRate() {
        return this.taxRate;
    }

    public void setTaxRate(String str) {
        this.taxRate = str;
    }

    public String getTaxAmount() {
        return this.taxAmount;
    }

    public void setTaxAmount(String str) {
        this.taxAmount = str;
    }
}
