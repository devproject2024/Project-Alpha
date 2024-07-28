package net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBGroupSnapshot extends CJRWalletDataModel {
    @c(a = "amount")
    @a
    private String amount;
    @c(a = "payeeId")
    @a
    private String payeeId;
    @c(a = "payeeMobile")
    @a
    private String payeeMobile;
    @c(a = "payeeName")
    @a
    private String payeeName;
    @c(a = "payerId")
    @a
    private String payerId;
    @c(a = "payerMobile")
    @a
    private String payerMobile;
    @c(a = "payerName")
    @a
    private String payerName;

    public String getPayerId() {
        return this.payerId;
    }

    public void setPayerId(String str) {
        this.payerId = str;
    }

    public String getPayerName() {
        return this.payerName;
    }

    public void setPayerName(String str) {
        this.payerName = str;
    }

    public String getPayeeId() {
        return this.payeeId;
    }

    public void setPayeeId(String str) {
        this.payeeId = str;
    }

    public String getPayeeName() {
        return this.payeeName;
    }

    public void setPayeeName(String str) {
        this.payeeName = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getPayerMobile() {
        return this.payerMobile;
    }

    public void setPayerMobile(String str) {
        this.payerMobile = str;
    }

    public String getPayeeMobile() {
        return this.payeeMobile;
    }

    public void setPayeeMobile(String str) {
        this.payeeMobile = str;
    }
}
