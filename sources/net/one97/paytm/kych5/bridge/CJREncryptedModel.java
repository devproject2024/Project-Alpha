package net.one97.paytm.kych5.bridge;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREncryptedModel extends IJRPaytmDataModel implements IJRDataModel {
    private String iv;
    private String key;
    private String rawResponse;

    public void setKey(String str) {
        this.key = str;
    }

    public void setIv(String str) {
        this.iv = str;
    }

    public String getRawResponse() {
        return this.rawResponse;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        try {
            this.rawResponse = net.one97.paytm.common.utility.f.b(this.iv, this.key, str);
            q.d(this.rawResponse);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this;
    }
}
