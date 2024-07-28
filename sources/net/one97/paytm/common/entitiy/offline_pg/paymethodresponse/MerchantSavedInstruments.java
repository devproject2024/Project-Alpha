package net.one97.paytm.common.entitiy.offline_pg.paymethodresponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.SavedCard;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.SavedVPA;

public class MerchantSavedInstruments implements IJRDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    private UPIPayMethod sarvatraUserProfile;
    private List<String> sarvatraVpa;
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

    public List<String> getSarvatraVpa() {
        return this.sarvatraVpa;
    }

    public void setSarvatraVpa(List<String> list) {
        this.sarvatraVpa = list;
    }

    public UPIPayMethod getSarvatraUserProfile() {
        return this.sarvatraUserProfile;
    }

    public void setSarvatraUserProfile(UPIPayMethod uPIPayMethod) {
        this.sarvatraUserProfile = uPIPayMethod;
    }
}
