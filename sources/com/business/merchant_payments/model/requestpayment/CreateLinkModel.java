package com.business.merchant_payments.model.requestpayment;

import com.business.merchant_payments.model.BaseModel;
import java.io.Serializable;

public class CreateLinkModel extends BaseModel {
    public static final long serialVersionUID = 1;
    public boolean active;
    public double amount;
    public long createdDate;
    public int id;
    public String linkDescription;
    public String linkName;
    public String linkType;
    public String longUrl;
    public String merchantId;
    public ResultInfo resultInfo;
    public String shortUrl;
    public int version;

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public String getLongUrl() {
        return this.longUrl;
    }

    public String getShortUrl() {
        return this.shortUrl;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public long getCreatedDate() {
        return this.createdDate;
    }

    public String getLinkDescription() {
        return this.linkDescription;
    }

    public String getLinkName() {
        return this.linkName;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public double getAmount() {
        return this.amount;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isActive() {
        return this.active;
    }

    public String getId() {
        return "LI_" + this.id;
    }

    public String getEdcId() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id);
        return sb.toString();
    }

    public class ResultInfo implements Serializable {
        public String resultMessage;

        public ResultInfo(CreateLinkModel createLinkModel) {
        }

        public String getResultMessage() {
            return this.resultMessage;
        }

        public void setResultMessage(String str) {
            this.resultMessage = str;
        }
    }
}
