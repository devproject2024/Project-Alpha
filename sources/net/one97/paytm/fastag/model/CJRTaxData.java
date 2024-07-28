package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRTaxData extends IJRPaytmDataModel {
    @b(a = "state_entry_tax")
    private String mStateEntryTax;
    @b(a = "value_added_tax")
    private String mValueAddedTax;

    public String getValueAddedTax() {
        return this.mValueAddedTax;
    }

    public String getStateEntryTax() {
        return this.mStateEntryTax;
    }
}
