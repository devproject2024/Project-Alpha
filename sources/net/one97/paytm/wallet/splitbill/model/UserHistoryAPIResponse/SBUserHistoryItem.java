package net.one97.paytm.wallet.splitbill.model.UserHistoryAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBUserHistoryItem extends CJRWalletDataModel {
    @c(a = "activityId")
    @a
    private String activityId;
    @c(a = "activityType")
    @a
    private String activityType;
    @c(a = "amount")
    @a
    private String amount;
    @c(a = "createDate")
    @a
    private String createDate;
    @c(a = "createdBy")
    @a
    private String createdBy;
    @c(a = "docId")
    @a
    private String docId;
    @c(a = "fromUserId")
    @a
    private String fromUserId;
    @c(a = "fromUserName")
    @a
    private String fromUserName;
    @c(a = "message")
    @a
    private String message;
    @c(a = "moneyMessage")
    @a
    private String moneyMessage;
    @c(a = "updateDate")
    @a
    private String updateDate;
    @c(a = "updatedBy")
    @a
    private String updatedBy;
    @c(a = "userId")
    @a
    private String userId;
    @c(a = "userName")
    @a
    private String userName;

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String str) {
        this.createDate = str;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(String str) {
        this.updateDate = str;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String str) {
        this.createdBy = str;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String str) {
        this.updatedBy = str;
    }

    public String getActivityId() {
        return this.activityId;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getActivityType() {
        return this.activityType;
    }

    public void setActivityType(String str) {
        this.activityType = str;
    }

    public String getMoneyMessage() {
        return this.moneyMessage;
    }

    public void setMoneyMessage(String str) {
        this.moneyMessage = str;
    }

    public String getFromUserId() {
        return this.fromUserId;
    }

    public void setFromUserId(String str) {
        this.fromUserId = str;
    }

    public String getFromUserName() {
        return this.fromUserName;
    }

    public void setFromUserName(String str) {
        this.fromUserName = str;
    }

    public String getDocId() {
        return this.docId;
    }

    public void setDocId(String str) {
        this.docId = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }
}
