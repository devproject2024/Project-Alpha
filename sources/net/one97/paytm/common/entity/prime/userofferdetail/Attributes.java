package net.one97.paytm.common.entity.prime.userofferdetail;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class Attributes implements IJRDataModel {
    private ArrayList<String> offer_details;
    private String offer_details_text;
    private ArrayList<String> tnc_details;
    private String tnc_text;

    public String getTnc_text() {
        return this.tnc_text;
    }

    public String getOffer_details_text() {
        return this.offer_details_text;
    }

    public ArrayList<String> getOffer_details() {
        return this.offer_details;
    }

    public ArrayList<String> getTnc_details() {
        return this.tnc_details;
    }

    public void setTnc_text(String str) {
        this.tnc_text = str;
    }

    public void setOffer_details_text(String str) {
        this.offer_details_text = str;
    }

    public void setOffer_details(ArrayList<String> arrayList) {
        this.offer_details = arrayList;
    }

    public void setTnc_details(ArrayList<String> arrayList) {
        this.tnc_details = arrayList;
    }
}
