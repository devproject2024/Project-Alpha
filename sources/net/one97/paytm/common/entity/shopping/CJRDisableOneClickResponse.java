package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRDisableOneClickResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private DisableVSBodyObject bodyObject;

    public DisableVSBodyObject getBodyObject() {
        return this.bodyObject;
    }

    public void setBodyObject(DisableVSBodyObject disableVSBodyObject) {
        this.bodyObject = disableVSBodyObject;
    }
}
