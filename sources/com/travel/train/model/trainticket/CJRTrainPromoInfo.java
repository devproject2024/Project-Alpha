package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainPromoInfo extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "background_image")
    private String backgroundImage;
    @b(a = "cashback_key")
    private String cashbackKey;
    @b(a = "cashback_text")
    private String cashbackText;
    @b(a = "pax_info")
    private ArrayList<CJRTrainPromoItems> paxInfo = null;
    @b(a = "promo_status")
    private int promoStatus;
    @b(a = "promo_text")
    private String promoText;
    @b(a = "status_action")
    private ArrayList<CJRTrainPromoInfoStatusAction> statusAction = null;
    @b(a = "travellers_key")
    private String travellersKey;

    public String getBackgroundImage() {
        return this.backgroundImage;
    }

    public int getPromoStatus() {
        return this.promoStatus;
    }

    public String getCashbackText() {
        return this.cashbackText;
    }

    public String getPromoText() {
        return this.promoText;
    }

    public String getTravellersKey() {
        return this.travellersKey;
    }

    public String getCashbackKey() {
        return this.cashbackKey;
    }

    public ArrayList<CJRTrainPromoItems> getPaxInfo() {
        return this.paxInfo;
    }

    public ArrayList<CJRTrainPromoInfoStatusAction> getStatusAction() {
        return this.statusAction;
    }
}
