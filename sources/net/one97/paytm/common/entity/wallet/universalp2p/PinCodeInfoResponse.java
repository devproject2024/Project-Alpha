package net.one97.paytm.common.entity.wallet.universalp2p;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;
import org.json.JSONObject;

public class PinCodeInfoResponse extends CJRWalletDataModel implements IJRDataModel {
    private JSONObject addressDictionary;
    private String responseCode;
    private String responseMessage;

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public JSONObject getAddressDictionary() {
        return this.addressDictionary;
    }

    public void setAddressDictionary(JSONObject jSONObject) {
        this.addressDictionary = jSONObject;
    }
}
