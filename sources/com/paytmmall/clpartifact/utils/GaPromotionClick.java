package com.paytmmall.clpartifact.utils;

import com.google.gson.a.c;
import com.google.gson.f;
import com.paytmmall.clpartifact.ga.GaEvent;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GaPromotionClick implements GaEvent {
    @c(a = "promoClick")
    private PromoClick promoClick;

    public PromoClick getPromoClick() {
        return this.promoClick;
    }

    public void setPromoClick(PromoClick promoClick2) {
        this.promoClick = promoClick2;
    }

    public String toJson() {
        return new f().a((Object) this, (Type) GaPromotionClick.class);
    }

    public static class PromoClick {
        @c(a = "promotions")
        private ArrayList<Promotion> promotions;

        public ArrayList<Promotion> getPromotions() {
            return this.promotions;
        }

        public void setPromotions(ArrayList<Promotion> arrayList) {
            this.promotions = arrayList;
        }
    }
}
