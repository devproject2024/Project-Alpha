package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRSendMoneyToMerchantResponse extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "cashBackMessage")
    private String mCashBackMessage;
    @b(a = "cashBackStatus")
    private String mCashBackStatus;
    @b(a = "comment")
    private String mComment;
    @b(a = "heading")
    private String mHeading;
    @b(a = "state")
    private String mState;
    @b(a = "timestamp")
    private String mTimestamp;
    @b(a = "txnAmount")
    private String mTxnAmount;
    @b(a = "userGuid")
    private String mUserGuid;
    @b(a = "walletSystemTxnId")
    private String mWalletSystemTxnId;
    @b(a = "pccCode")
    private String pccCode;

    public String getName() {
        return null;
    }

    public String getTxnAmount() {
        return this.mTxnAmount;
    }

    public String getUserGuid() {
        return this.mUserGuid;
    }

    public String getWalletSystemTxnId() {
        return this.mWalletSystemTxnId;
    }

    public String getTimestamp() {
        return this.mTimestamp;
    }

    public String getCashBackStatus() {
        return this.mCashBackStatus;
    }

    public String getPccCode() {
        return this.pccCode;
    }

    public String getCashBackMessage() {
        return this.mCashBackMessage;
    }

    public String getState() {
        return this.mState;
    }

    public String getHeading() {
        return this.mHeading;
    }

    public String toString() {
        return "CJRSendMoneyToMerchantResponse{mUserGuid='" + this.mUserGuid + '\'' + ", mWalletSystemTxnId='" + this.mWalletSystemTxnId + '\'' + ", mTimestamp='" + this.mTimestamp + '\'' + ", mCashBackStatus='" + this.mCashBackStatus + '\'' + ", mCashBackMessage='" + this.mCashBackMessage + '\'' + ", mState='" + this.mState + '\'' + ", pccCode='" + this.pccCode + '\'' + ", mHeading='" + this.mHeading + '\'' + '}';
    }

    public String getmComment() {
        return this.mComment;
    }

    public void setmComment(String str) {
        this.mComment = str;
    }
}
