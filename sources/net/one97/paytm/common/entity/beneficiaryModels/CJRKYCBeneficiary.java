package net.one97.paytm.common.entity.beneficiaryModels;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRKYCBeneficiary extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "beneficiaryId")
    private String beneficiaryId;
    @b(a = "instrumentPreferences")
    private CJRInstrumentPreferences instrumentPreferences;
    @b(a = "nickName")
    private String nickName;

    public String getBeneficiaryId() {
        return this.beneficiaryId;
    }

    public void setBeneficiaryId(String str) {
        this.beneficiaryId = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public CJRInstrumentPreferences getInstrumentPreferences() {
        return this.instrumentPreferences;
    }

    public void setInstrumentPreferences(CJRInstrumentPreferences cJRInstrumentPreferences) {
        this.instrumentPreferences = cJRInstrumentPreferences;
    }
}
