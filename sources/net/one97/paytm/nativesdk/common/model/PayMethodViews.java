package net.one97.paytm.nativesdk.common.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayMethodViews implements BaseDataModel {
    private List<AddMoneyPayMethod> addMoneyPayMethods = null;
    private AddMoneySavedInstruments addMoneySavedInstruments;
    private Map<String, Object> additionalProperties = new HashMap();
    private List<MerchantPayMethod> merchantPayMethods = null;
    private MerchantSavedInstruments merchantSavedInstruments;

    public MerchantSavedInstruments getMerchantSavedInstruments() {
        return this.merchantSavedInstruments;
    }

    public void setMerchantSavedInstruments(MerchantSavedInstruments merchantSavedInstruments2) {
        this.merchantSavedInstruments = merchantSavedInstruments2;
    }

    public AddMoneySavedInstruments getAddMoneySavedInstruments() {
        return this.addMoneySavedInstruments;
    }

    public void setAddMoneySavedInstruments(AddMoneySavedInstruments addMoneySavedInstruments2) {
        this.addMoneySavedInstruments = addMoneySavedInstruments2;
    }

    public List<MerchantPayMethod> getMerchantPayMethods() {
        return this.merchantPayMethods;
    }

    public void setMerchantPayMethods(List<MerchantPayMethod> list) {
        this.merchantPayMethods = list;
    }

    public List<AddMoneyPayMethod> getAddMoneyPayMethods() {
        return this.addMoneyPayMethods;
    }

    public void setAddMoneyPayMethods(List<AddMoneyPayMethod> list) {
        this.addMoneyPayMethods = list;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }
}
