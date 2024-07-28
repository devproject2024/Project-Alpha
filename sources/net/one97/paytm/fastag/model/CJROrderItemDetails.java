package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROrderItemDetails extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "existingAttribute")
    private CJRExistingAttribute mExistingAttribute;

    public CJRExistingAttribute getExistingAttribute() {
        return this.mExistingAttribute;
    }
}
