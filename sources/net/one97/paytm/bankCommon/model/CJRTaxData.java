package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTaxData implements IJRDataModel {
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
