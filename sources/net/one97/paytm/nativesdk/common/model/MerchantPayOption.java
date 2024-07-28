package net.one97.paytm.nativesdk.common.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.SavedMandateBanksItem;
import net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile;

public class MerchantPayOption implements BaseDataModel {
    private ArrayList<PaymentModes> paymentModes;
    private ArrayList<SavedInstruments> savedInstruments;
    @c(a = "savedMandateBanks")
    private List<SavedMandateBanksItem> savedMandateBanks;
    @c(a = "upiProfile")
    @a
    private UpiProfile upiProfile;

    public ArrayList<SavedInstruments> getSavedInstruments() {
        return this.savedInstruments;
    }

    public void setSavedInstruments(ArrayList<SavedInstruments> arrayList) {
        this.savedInstruments = arrayList;
    }

    public ArrayList<PaymentModes> getPaymentModes() {
        return this.paymentModes;
    }

    public void setPaymentModes(ArrayList<PaymentModes> arrayList) {
        this.paymentModes = arrayList;
    }

    public List<SavedMandateBanksItem> getSavedMandateBanks() {
        return this.savedMandateBanks;
    }

    public void setSavedMandateBanks(List<SavedMandateBanksItem> list) {
        this.savedMandateBanks = list;
    }

    public String toString() {
        return "ClassPojo [savedInstruments = " + this.savedInstruments + ", paymentModes = " + this.paymentModes + "]";
    }

    public UpiProfile getUpiProfile() {
        UpiProfile upiProfile2 = this.upiProfile;
        if (!(upiProfile2 == null || upiProfile2.getRespDetails() == null || this.upiProfile.getRespDetails().getProfileDetail() == null)) {
            this.upiProfile.getRespDetails().getProfileDetail().init();
        }
        return this.upiProfile;
    }

    public void setUpiProfile(UpiProfile upiProfile2) {
        this.upiProfile = upiProfile2;
    }
}
