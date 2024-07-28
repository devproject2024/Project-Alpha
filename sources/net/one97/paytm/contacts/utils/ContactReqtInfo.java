package net.one97.paytm.contacts.utils;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.contacts.entities.beans.PhoneInfo;
import org.json.JSONObject;

public class ContactReqtInfo extends IJRPaytmDataModel implements IJRDataModel {
    ArrayList<String> emails = new ArrayList<>();
    JSONObject meta;
    PhoneInfo phones;

    public ArrayList<String> getEmail() {
        return this.emails;
    }

    public void setEmail(ArrayList<String> arrayList) {
        this.emails = arrayList;
    }

    public JSONObject getMeta() {
        return this.meta;
    }

    public void setMeta(JSONObject jSONObject) {
        this.meta = jSONObject;
    }

    public PhoneInfo getPhoneInfo() {
        return this.phones;
    }

    public void setPhoneInfo(PhoneInfo phoneInfo) {
        this.phones = phoneInfo;
    }
}
