package net.one97.paytm.fastag.model;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;

public class CJRMerchantContacts extends IJRPaytmDataModel {
    private List<CJRMerchantContact> mMerchantContacts = new ArrayList();

    public List<CJRMerchantContact> getMerchantContacts() {
        return this.mMerchantContacts;
    }

    public void setMerchatContacts(List<CJRMerchantContact> list) {
        this.mMerchantContacts = list;
    }
}
