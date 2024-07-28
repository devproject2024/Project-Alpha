package net.one97.paytm.common.entity.movies.foodbeverage;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTotalPriceTaxSplit implements IJRDataModel {
    @b(a = "CGST")
    private Float CGST;
    @b(a = "SGST")
    private Float SGST;
    @b(a = "TGST")
    private Float TGST;
    @b(a = "net_premium")
    private Float netPremium;
    @b(a = "total_premium")
    private Float totalPremium;

    public Float getTotalPremium() {
        return this.totalPremium;
    }

    public void setTotalPremium(Float f2) {
        this.totalPremium = f2;
    }

    public Float getNetPremium() {
        return this.netPremium;
    }

    public void setNetPremium(Float f2) {
        this.netPremium = f2;
    }

    public Float getCGST() {
        return this.CGST;
    }

    public void setCGST(Float f2) {
        this.CGST = f2;
    }

    public Float getSGST() {
        return this.SGST;
    }

    public void setSGST(Float f2) {
        this.SGST = f2;
    }

    public Float getTGST() {
        return this.TGST;
    }

    public void setTGST(Float f2) {
        this.TGST = f2;
    }
}
