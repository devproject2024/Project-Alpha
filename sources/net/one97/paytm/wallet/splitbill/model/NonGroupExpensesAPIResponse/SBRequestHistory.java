package net.one97.paytm.wallet.splitbill.model.NonGroupExpensesAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBRequestHistory extends CJRWalletDataModel {
    @c(a = "amount")
    @a
    private String amount;
    @c(a = "createdAt")
    @a
    private String createdAt;
    @c(a = "groupId")
    @a
    private String groupId;
    @c(a = "groupName")
    @a
    private String groupName;
    @c(a = "message")
    @a
    private String message;
    @c(a = "payeeId")
    @a
    private String payeeId;
    @c(a = "payerId")
    @a
    private String payerId;
    @c(a = "requestId")
    @a
    private String requestId;
    @c(a = "requestName")
    @a
    private String requestName;
    @c(a = "requestType")
    @a
    private String requestType;
    @c(a = "totalAmount")
    @a
    private String totalAmount;

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public void setRequestType(String str) {
        this.requestType = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public String getRequestName() {
        return this.requestName;
    }

    public void setRequestName(String str) {
        this.requestName = str;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public String getPayerId() {
        return this.payerId;
    }

    public void setPayerId(String str) {
        this.payerId = str;
    }

    public String getPayeeId() {
        return this.payeeId;
    }

    public void setPayeeId(String str) {
        this.payeeId = str;
    }
}
