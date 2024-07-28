package net.one97.paytm.common.entity.prime.userofferdetail;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class OverLayPopUpDetails implements IJRDataModel {
    private String btn_text;
    private String description;
    private ArrayList<MerchantPageUrl> merchant_page_url;
    private String note_text;
    private String title;

    public String getBtn_text() {
        return this.btn_text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getNote_text() {
        return this.note_text;
    }

    public String getDescription() {
        return this.description;
    }

    public ArrayList<MerchantPageUrl> getMerchant_page_url() {
        return this.merchant_page_url;
    }
}
