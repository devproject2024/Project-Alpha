package com.paytm.android.chat.bean.pfbean;

import android.text.TextUtils;
import com.paytm.android.chat.bean.jsonbean.UserDataBean;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import net.one97.paytm.p2p.theme.ThemeData;

public class PFPaymentStatusBean implements Serializable {
    public static final int PAY_STATUS_FAILED = 1;
    public static final int PAY_STATUS_PENDING = 2;
    public static final int PAY_STATUS_SUCCESS = 0;
    public static final int PAY_STATUS_UNKNOWN = -1;
    public static final int STATUS_CANCELLED = 5;
    public static final int STATUS_DECLINED = 4;
    public static final int STATUS_EXPIRED = 6;
    public static final int STATUS_MARK_AS_SPAM = 3;
    public static final int STATUS_UPI_REQUESTED = 7;
    private String amount;
    private String channel;
    private long date;
    private String deepLinkUrl;
    private String deeplinkUrl;
    private String errorMsg;
    private String flowType;
    private String importantNote;
    private String mRc;
    private String message;
    private String orderId;
    private String payeeBankAccountNo;
    private String payeeName;
    private String payeeVpa;
    private String payerBankAccountNo;
    private String payerVpa;
    private String paymentMode;
    private String receiver_preview_text;
    private String receiver_quick_reply;
    private String referenceNumber;
    private UserDataBean reply;
    private String sender_preview_text;
    private String sender_quick_reply;
    private int status;
    private ThemeData themeData;
    private String themeId;
    private String txnId;

    public String getDeeplinkUrl() {
        return this.deeplinkUrl;
    }

    public void setDeeplinkUrl(String str) {
        this.deeplinkUrl = str;
    }

    public String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public void setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getmRc() {
        return this.mRc;
    }

    public void setmRc(String str) {
        this.mRc = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getImportantNote() {
        return this.importantNote;
    }

    public void setImportantNote(String str) {
        this.importantNote = str;
    }

    public String getPayeeName() {
        return this.payeeName;
    }

    public void setPayeeName(String str) {
        this.payeeName = str;
    }

    public String getPayeeVpa() {
        return this.payeeVpa;
    }

    public void setPayeeVpa(String str) {
        this.payeeVpa = str;
    }

    public String getPayerVpa() {
        return this.payerVpa;
    }

    public void setPayerVpa(String str) {
        this.payerVpa = str;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getPayeeBankAccountNo() {
        return this.payeeBankAccountNo;
    }

    public void setPayeeBankAccountNo(String str) {
        this.payeeBankAccountNo = str;
    }

    public String getPayerBankAccountNo() {
        return this.payerBankAccountNo;
    }

    public void setPayerBankAccountNo(String str) {
        this.payerBankAccountNo = str;
    }

    public String getThemeId() {
        return this.themeId;
    }

    public void setThemeId(String str) {
        this.themeId = str;
    }

    public String[] getSenderQuickReply() {
        String[] strArr = new String[0];
        try {
            if (TextUtils.isEmpty(this.sender_quick_reply)) {
                return strArr;
            }
            if (this.sender_quick_reply.contains(AppConstants.COMMA)) {
                return this.sender_quick_reply.split(AppConstants.COMMA);
            }
            return new String[]{this.sender_quick_reply};
        } catch (Exception unused) {
            return strArr;
        }
    }

    public String[] getReceiverQuickReply() {
        String[] strArr = new String[0];
        try {
            if (TextUtils.isEmpty(this.receiver_quick_reply)) {
                return strArr;
            }
            if (this.receiver_quick_reply.contains(AppConstants.COMMA)) {
                return this.receiver_quick_reply.split(AppConstants.COMMA);
            }
            return new String[]{this.receiver_quick_reply};
        } catch (Exception unused) {
            return strArr;
        }
    }

    public String getReceiver_preview_text() {
        return this.receiver_preview_text;
    }

    public String getSender_preview_text() {
        return this.sender_preview_text;
    }

    public String getFlowType() {
        return this.flowType;
    }

    public void setFlowType(String str) {
        this.flowType = str;
    }

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public void setReferenceNumber(String str) {
        this.referenceNumber = str;
    }

    public ThemeData getThemeData() {
        return this.themeData;
    }

    public void setThemeData(ThemeData themeData2) {
        this.themeData = themeData2;
    }

    public UserDataBean getReply() {
        return this.reply;
    }
}
