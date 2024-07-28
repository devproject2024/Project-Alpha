package com.travel.citybus.brts.model.pojo;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class CJRBusStopFareModel {
    @c(a = "amount")
    private double amount;
    @c(a = "paxId")
    private int paxId;
    @c(a = "paxName")
    private String paxName;

    public static /* synthetic */ CJRBusStopFareModel copy$default(CJRBusStopFareModel cJRBusStopFareModel, int i2, String str, double d2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = cJRBusStopFareModel.paxId;
        }
        if ((i3 & 2) != 0) {
            str = cJRBusStopFareModel.paxName;
        }
        if ((i3 & 4) != 0) {
            d2 = cJRBusStopFareModel.amount;
        }
        return cJRBusStopFareModel.copy(i2, str, d2);
    }

    public final int component1() {
        return this.paxId;
    }

    public final String component2() {
        return this.paxName;
    }

    public final double component3() {
        return this.amount;
    }

    public final CJRBusStopFareModel copy(int i2, String str, double d2) {
        k.c(str, "paxName");
        return new CJRBusStopFareModel(i2, str, d2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRBusStopFareModel)) {
            return false;
        }
        CJRBusStopFareModel cJRBusStopFareModel = (CJRBusStopFareModel) obj;
        return this.paxId == cJRBusStopFareModel.paxId && k.a((Object) this.paxName, (Object) cJRBusStopFareModel.paxName) && Double.compare(this.amount, cJRBusStopFareModel.amount) == 0;
    }

    public final int hashCode() {
        int i2 = this.paxId * 31;
        String str = this.paxName;
        int hashCode = str != null ? str.hashCode() : 0;
        long doubleToLongBits = Double.doubleToLongBits(this.amount);
        return ((i2 + hashCode) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public final String toString() {
        return "CJRBusStopFareModel(paxId=" + this.paxId + ", paxName=" + this.paxName + ", amount=" + this.amount + ")";
    }

    public CJRBusStopFareModel(int i2, String str, double d2) {
        k.c(str, "paxName");
        this.paxId = i2;
        this.paxName = str;
        this.amount = d2;
    }

    public final int getPaxId() {
        return this.paxId;
    }

    public final void setPaxId(int i2) {
        this.paxId = i2;
    }

    public final String getPaxName() {
        return this.paxName;
    }

    public final void setPaxName(String str) {
        k.c(str, "<set-?>");
        this.paxName = str;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final void setAmount(double d2) {
        this.amount = d2;
    }
}
