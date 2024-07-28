package net.one97.paytm.common.entity.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightFairDetail implements IJRDataModel {
    @b(a = "convenience_fee")
    private double mConvenience;
    @b(a = "tax")
    private double mTax;
    @b(a = "price")
    private double mTotalPrice;
    @b(a = "tax_break_up")
    private CJRFlightTaxBreakupDetail texBreakup;

    public CJRFlightTaxBreakupDetail getTexBreakup() {
        return this.texBreakup;
    }

    public void setTexBreakup(CJRFlightTaxBreakupDetail cJRFlightTaxBreakupDetail) {
        this.texBreakup = cJRFlightTaxBreakupDetail;
    }

    public double getmTotalPrice() {
        return this.mTotalPrice;
    }

    public void setmTotalPrice(int i2) {
        this.mTotalPrice = (double) i2;
    }

    public double getmTax() {
        return this.mTax;
    }

    public void setmTax(int i2) {
        this.mTax = (double) i2;
    }

    public double getmConvenience() {
        return this.mConvenience;
    }

    public void setmConvenience(int i2) {
        this.mConvenience = (double) i2;
    }
}
