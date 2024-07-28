package net.one97.paytm.splitbill;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class SBMarkAsPaid implements IJRDataModel {
    @c(a = "description")
    @a
    private String description;
    @c(a = "name")
    @a
    private String name;
    @c(a = "payeeId")
    @a
    private String payeeId;
    @c(a = "payerId")
    @a
    private String payerId;
    @c(a = "paymentMode")
    @a
    private String paymentMode;
    @c(a = "totalAmount")
    @a
    private String totalAmount;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPayeeId() {
        return this.payeeId;
    }

    public void setPayeeId(String str) {
        this.payeeId = str;
    }

    public String getPayerId() {
        return this.payerId;
    }

    public void setPayerId(String str) {
        this.payerId = str;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }
}
