package net.one97.paytm.common.entity;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Map;
import net.one97.paytm.common.entity.upgradeKyc.BaseModel;
import net.one97.paytm.common.entity.upgradeKyc.PincodeItem;

public class UADPincode extends BaseModel {
    private static final long serialVersionUID = 1;
    private Map<String, ArrayList<PincodeItem>> addressDictionary;
    private String responseCode;
    private String responseMessage;

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public Map<String, ArrayList<PincodeItem>> getAddressDictionary() {
        return this.addressDictionary;
    }

    public PincodeItem getPincodeItem(String str) {
        Map<String, ArrayList<PincodeItem>> map;
        ArrayList arrayList;
        if (!TextUtils.isEmpty(str) && (map = this.addressDictionary) != null && (arrayList = map.get(str)) != null && arrayList.size() > 0) {
            return (PincodeItem) arrayList.get(0);
        }
        return null;
    }
}
