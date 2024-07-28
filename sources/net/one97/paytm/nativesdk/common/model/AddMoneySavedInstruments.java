package net.one97.paytm.nativesdk.common.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddMoneySavedInstruments implements BaseDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    private List<SavedCard> savedCards = null;
    private List<SavedVPA> savedVPAs = null;

    public List<SavedCard> getSavedCards() {
        return this.savedCards;
    }

    public void setSavedCards(List<SavedCard> list) {
        this.savedCards = list;
    }

    public List<SavedVPA> getSavedVPAs() {
        return this.savedVPAs;
    }

    public void setSavedVPAs(List<SavedVPA> list) {
        this.savedVPAs = list;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }
}
