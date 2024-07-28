package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRDisplayValues;

public class CJRPaymentOptions implements IJRDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "displayValues")
    private List<CJRDisplayValues> displayValues = null;
    @b(a = "invoiceNumber")
    private String invoiceNumber;
    @b(a = "label")
    private String label;
    @b(a = "stbNumber")
    private String stbNumber;

    public String getAmount() {
        return this.amount;
    }

    public String getLabel() {
        return this.label;
    }

    public List<CJRDisplayValues> getDisplayValues() {
        return this.displayValues;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CJRPaymentOptions)) {
            return false;
        }
        CJRPaymentOptions cJRPaymentOptions = (CJRPaymentOptions) obj;
        return getLabel().equalsIgnoreCase(cJRPaymentOptions.getLabel()) && getAmount().equalsIgnoreCase(cJRPaymentOptions.getAmount());
    }

    public String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    public void setInvoiceNumber(String str) {
        this.invoiceNumber = str;
    }

    public String getStbNumber() {
        return this.stbNumber;
    }

    public void setStbNumber(String str) {
        this.stbNumber = str;
    }
}
