package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCashback implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "amount")
    private double cashBackAmount;
    @b(a = "cashback_text")
    private String cashbackText;

    public String getCashbackText() {
        return this.cashbackText;
    }

    public double getCashBackAmount() {
        return this.cashBackAmount;
    }
}
