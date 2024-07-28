package net.one97.paytm.common.entity;

import java.util.ArrayList;

public class CJRPostcardFetchResponse implements IJRDataModel {
    private ArrayList<CJRPostcardFetchInitiatorList> initiatorList;
    private ArrayList<CJRPostcardFetchRecipientList> recipientList;

    public ArrayList<CJRPostcardFetchInitiatorList> getInitiatorList() {
        return this.initiatorList;
    }

    public void setInitiatorList(ArrayList<CJRPostcardFetchInitiatorList> arrayList) {
        this.initiatorList = arrayList;
    }

    public ArrayList<CJRPostcardFetchRecipientList> getRecipientList() {
        return this.recipientList;
    }

    public void setRecipientList(ArrayList<CJRPostcardFetchRecipientList> arrayList) {
        this.recipientList = arrayList;
    }
}
