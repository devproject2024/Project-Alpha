package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class PBCJRCard extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "code")
    private int mCode;
    @b(a = "created_at")
    private String mCreatedAt;
    private String mFirstName;
    @b(a = "id")
    private String mId;
    @b(a = "issue_status")
    private String mIssueStatus;
    private String mLastName;
    @b(a = "masked_number")
    private String mMaskedNumber;
    @b(a = "message")
    private String mMessage;
    @b(a = "params")
    private String mParams;
    @b(a = "status")
    private String mStatus;
    @b(a = "type")
    private String mType;
    @b(a = "updated_at")
    private String mUpdatedAt;

    public enum PinStatusEnum {
        NOT_SET,
        SET_FROM_APP,
        SET_FROM_ATM,
        SET_FROM_IVR,
        SET_FROM_SMS
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getMaskedNumber() {
        return this.mMaskedNumber;
    }

    public void setMaskedNumber(String str) {
        this.mMaskedNumber = str;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getIssueStatus() {
        return this.mIssueStatus;
    }

    public void setIssueStatus(String str) {
        this.mIssueStatus = str;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public String getCreatedAt() {
        return this.mCreatedAt;
    }

    public void setCreatedAt(String str) {
        this.mCreatedAt = str;
    }

    public String getUpdatedAt() {
        return this.mUpdatedAt;
    }

    public void setUpdatedAt(String str) {
        this.mUpdatedAt = str;
    }

    public String getFirstName() {
        return this.mFirstName;
    }

    public void setFirstName(String str) {
        this.mFirstName = str;
    }

    public String getLastName() {
        return this.mLastName;
    }

    public void setLastName(String str) {
        this.mLastName = str;
    }

    public int getCode() {
        return this.mCode;
    }

    public void setCode(int i2) {
        this.mCode = i2;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public String getParams() {
        return this.mParams;
    }

    public void setParams(String str) {
        this.mParams = str;
    }
}
