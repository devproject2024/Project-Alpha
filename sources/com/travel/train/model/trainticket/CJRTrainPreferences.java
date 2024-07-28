package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainPreferences extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "enabled")
    private boolean mEnable;
    @b(a = "reservation_choice")
    private HashMap<String, Integer> mPreferenceChoice;

    public boolean isEnable() {
        return this.mEnable;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public HashMap<String, Integer> getPreferenceChoice() {
        return this.mPreferenceChoice;
    }

    public ArrayList<String> getPreferenceList() {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, Integer> hashMap = this.mPreferenceChoice;
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Integer> key : this.mPreferenceChoice.entrySet()) {
                arrayList.add(key.getKey());
            }
        }
        return arrayList;
    }
}
