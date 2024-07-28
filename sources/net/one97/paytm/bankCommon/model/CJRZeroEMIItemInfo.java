package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRZeroEMIItemInfo implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "zero_emi_cashback")
    private int zeroEMICashback;
    @b(a = "zero_emi_cashback_text")
    private String zeroEMICashbackText;
    @b(a = "zero_emi_cashback_title")
    private String zeroEMICashbackTitle;

    public String getZeroEMICashbackTitle() {
        return this.zeroEMICashbackTitle;
    }

    public String getZeroEMICashbackText() {
        return this.zeroEMICashbackText;
    }

    public int getZeroEMICashback() {
        return this.zeroEMICashback;
    }
}
