package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRbusSearchItemFlags implements IJRDataModel {
    @b(a = "ac")
    private Boolean ac;
    @b(a = "cancellable")
    private Boolean cancellable;
    @b(a = "is_social_distancing_guaranteed")
    private boolean isSocialDistancingGuaranteed;
    @b(a = "m_ticket")
    private Boolean mTicket;
    @b(a = "seater")
    private Boolean seater;
    @b(a = "semi_sleeper")
    private Boolean semiSleeper;
    @b(a = "sleeper")
    private Boolean sleeper;

    public Boolean isSleeper() {
        return this.sleeper;
    }

    public void setSleeper(Boolean bool) {
        this.sleeper = bool;
    }

    public Boolean isAc() {
        return this.ac;
    }

    public void setAc(Boolean bool) {
        this.ac = bool;
    }

    public void setCancellable(Boolean bool) {
        this.cancellable = bool;
    }

    public void setMTicket(Boolean bool) {
        this.mTicket = bool;
    }

    public Boolean isSeater() {
        return this.seater;
    }

    public void setSeater(Boolean bool) {
        this.seater = bool;
    }

    public Boolean isSemiSleeper() {
        return this.semiSleeper;
    }

    public void setSemiSleeper(Boolean bool) {
        this.semiSleeper = bool;
    }

    public boolean getSocialDistancingGuaranteed() {
        return this.isSocialDistancingGuaranteed;
    }

    public void setSocialDistancingGuaranteed(boolean z) {
        this.isSocialDistancingGuaranteed = z;
    }
}
