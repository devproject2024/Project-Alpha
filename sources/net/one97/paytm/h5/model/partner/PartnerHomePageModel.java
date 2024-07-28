package net.one97.paytm.h5.model.partner;

import com.google.gsonhtcfix.f;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;

public class PartnerHomePageModel extends CJRHomePageV2 {
    private String responseRaw = "";

    public PartnerHomePageModel parseResponse(String str, f fVar) throws Exception {
        try {
            PartnerHomePageModel partnerHomePageModel = (PartnerHomePageModel) fVar.a(str, getClass());
            partnerHomePageModel.setResponseRaw(str);
            return partnerHomePageModel;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public String getResponseRaw() {
        return this.responseRaw;
    }

    private void setResponseRaw(String str) {
        this.responseRaw = str;
    }
}
