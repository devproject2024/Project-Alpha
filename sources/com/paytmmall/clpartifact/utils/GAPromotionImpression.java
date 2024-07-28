package com.paytmmall.clpartifact.utils;

import com.google.gson.a.c;
import com.google.gson.f;
import com.paytmmall.clpartifact.ga.GaEvent;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GAPromotionImpression implements GaEvent {
    @c(a = "promoView")
    private PromoView impressionsList;

    public PromoView getPromotion() {
        return this.impressionsList;
    }

    public void setPromotion(PromoView promoView) {
        this.impressionsList = promoView;
    }

    public String toJson() {
        return new f().a((Object) this, (Type) GAPromotionImpression.class);
    }

    public static class PromoView {
        @c(a = "promotions")
        private List<Promotion> promotionList = new ArrayList();

        public List<Promotion> getImpressionsList() {
            return this.promotionList;
        }

        public void setImpressionsList(List<Promotion> list) {
            this.promotionList = list;
        }
    }
}
