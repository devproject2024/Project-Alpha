package com.paytm.business.merchantprofile.event;

import com.business.common_module.f.a;
import com.paytm.business.merchantprofile.model.EditGstinAddress;

public class EditBusinessDetailEvent extends a {
    public EditGstinAddress editGstinAddress;
    public String type;
    public String value;

    public EditBusinessDetailEvent(String str, String str2) {
        this.type = str;
        this.value = str2;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public EditGstinAddress getEditGstinAddress() {
        return this.editGstinAddress;
    }

    public void setEditGstinAddress(EditGstinAddress editGstinAddress2) {
        this.editGstinAddress = editGstinAddress2;
    }
}
