package net.one97.paytm.wallet.splitbill.model.BillDetailsAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBSubRequest extends CJRWalletDataModel {
    @c(a = "amount")
    @a
    private String amount;
    @c(a = "mobile")
    @a
    private String mobile;
    @c(a = "name")
    @a
    private String name;
    @c(a = "percentage")
    @a
    private String percentage;
    @c(a = "share")
    @a
    private String share;
    @c(a = "userId")
    @a
    private String userId;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getShare() {
        return this.share;
    }

    public void setShare(String str) {
        this.share = str;
    }

    public String getPercentage() {
        return this.percentage;
    }

    public void setPercentage(String str) {
        this.percentage = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }
}
