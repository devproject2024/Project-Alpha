package com.paytm.android.chat.data.models.messages;

import com.google.gsonhtcfix.a.b;
import com.paytm.android.chat.bean.CTA;
import com.paytm.android.chat.bean.jsonbean.UserDataBean;
import java.io.Serializable;
import java.util.List;

public final class ChatMessageUPIData implements Serializable {
    @b(a = "amount")
    private String amount;
    @b(a = "deeplinkUrl")
    private String deeplinkUrl;
    @b(a = "expireOn")
    private String expireOn;
    @b(a = "msgStatus")
    private String msgStatus;
    @b(a = "note")
    private String note;
    @b(a = "payeeName")
    private String payeeName;
    @b(a = "payeeVpa")
    private String payeeVpa;
    @b(a = "payerName")
    private String payerName;
    @b(a = "payerVpa")
    private String payerVpa;
    @b(a = "paymentMode")
    private String paymentMode;
    @b(a = "receiver")
    private String receiver;
    @b(a = "receiver_ctas")
    private List<CTA> receiverCtas;
    @b(a = "receiver_desc")
    private String receiverDesc;
    @b(a = "receiver_state")
    private String receiverState;
    @b(a = "receiver_vpa")
    private String receiverVpa;
    @b(a = "reply")
    private UserDataBean reply;
    @b(a = "sender_ctas")
    private List<CTA> senderCtas;
    @b(a = "sender_desc")
    private String senderDesc;
    @b(a = "sender_state")
    private String senderState;
    @b(a = "sender_vpa")
    private String senderVpa;
    @b(a = "txnId")
    private String txnId;

    public final String getReceiverState() {
        return this.receiverState;
    }

    public final void setReceiverState(String str) {
        this.receiverState = str;
    }

    public final String getSenderState() {
        return this.senderState;
    }

    public final void setSenderState(String str) {
        this.senderState = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public final void setTxnId(String str) {
        this.txnId = str;
    }

    public final String getReceiverVpa() {
        return this.receiverVpa;
    }

    public final void setReceiverVpa(String str) {
        this.receiverVpa = str;
    }

    public final String getSenderVpa() {
        return this.senderVpa;
    }

    public final void setSenderVpa(String str) {
        this.senderVpa = str;
    }

    public final String getReceiver() {
        return this.receiver;
    }

    public final void setReceiver(String str) {
        this.receiver = str;
    }

    public final List<CTA> getSenderCtas() {
        return this.senderCtas;
    }

    public final void setSenderCtas(List<CTA> list) {
        this.senderCtas = list;
    }

    public final List<CTA> getReceiverCtas() {
        return this.receiverCtas;
    }

    public final void setReceiverCtas(List<CTA> list) {
        this.receiverCtas = list;
    }

    public final String getExpireOn() {
        return this.expireOn;
    }

    public final void setExpireOn(String str) {
        this.expireOn = str;
    }

    public final String getSenderDesc() {
        return this.senderDesc;
    }

    public final void setSenderDesc(String str) {
        this.senderDesc = str;
    }

    public final String getReceiverDesc() {
        return this.receiverDesc;
    }

    public final void setReceiverDesc(String str) {
        this.receiverDesc = str;
    }

    public final String getNote() {
        return this.note;
    }

    public final void setNote(String str) {
        this.note = str;
    }

    public final String getMsgStatus() {
        return this.msgStatus;
    }

    public final void setMsgStatus(String str) {
        this.msgStatus = str;
    }

    public final String getPayerName() {
        return this.payerName;
    }

    public final void setPayerName(String str) {
        this.payerName = str;
    }

    public final String getPayerVpa() {
        return this.payerVpa;
    }

    public final void setPayerVpa(String str) {
        this.payerVpa = str;
    }

    public final String getPayeeName() {
        return this.payeeName;
    }

    public final void setPayeeName(String str) {
        this.payeeName = str;
    }

    public final String getPayeeVpa() {
        return this.payeeVpa;
    }

    public final void setPayeeVpa(String str) {
        this.payeeVpa = str;
    }

    public final String getDeeplinkUrl() {
        return this.deeplinkUrl;
    }

    public final void setDeeplinkUrl(String str) {
        this.deeplinkUrl = str;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public final UserDataBean getReply() {
        return this.reply;
    }

    public final void setReply(UserDataBean userDataBean) {
        this.reply = userDataBean;
    }
}
