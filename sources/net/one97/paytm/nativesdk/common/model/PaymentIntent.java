package net.one97.paytm.nativesdk.common.model;

import android.text.SpannableString;
import java.util.ArrayList;

public class PaymentIntent implements BaseDataModel {
    private ArrayList<String> banks;
    private String bin6;
    private String bin8;
    private String cardHash;
    private ArrayList<String> channels;
    private double convFee;
    private String feePercent;
    private String mode;
    private String mode_type;
    private String nativeConvFeeText;
    private String offerMsg;
    private SpannableString spannableConvFeeText;
    private double txnAmount;
    private String vpa;

    public double getConvFee() {
        return this.convFee;
    }

    public void setConvFee(double d2) {
        this.convFee = d2;
    }

    public double getTxnAmount() {
        return this.txnAmount;
    }

    public void setTxnAmount(double d2) {
        this.txnAmount = d2;
    }

    public ArrayList<String> getChannels() {
        return this.channels;
    }

    public void setChannels(ArrayList<String> arrayList) {
        this.channels = arrayList;
    }

    public ArrayList<String> getBanks() {
        return this.banks;
    }

    public void setBanks(ArrayList<String> arrayList) {
        this.banks = arrayList;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public String getMode_type() {
        return this.mode_type;
    }

    public void setMode_type(String str) {
        this.mode_type = str;
    }

    public String getCardHash() {
        return this.cardHash;
    }

    public void setCardHash(String str) {
        this.cardHash = str;
    }

    public String getBin6() {
        return this.bin6;
    }

    public void setBin6(String str) {
        this.bin6 = str;
    }

    public String getBin8() {
        return this.bin8;
    }

    public void setBin8(String str) {
        this.bin8 = str;
    }

    public String getVpa() {
        return this.vpa;
    }

    public void setVpa(String str) {
        this.vpa = str;
    }

    public String getConvFeeText() {
        return this.nativeConvFeeText;
    }

    public void setNativeConvFeeText(String str) {
        this.nativeConvFeeText = str;
    }

    public String getFeePercent() {
        return this.feePercent;
    }

    public void setFeePercent(String str) {
        this.feePercent = str;
    }

    public String getOfferMsg() {
        return this.offerMsg;
    }

    public void setOfferMsg(String str) {
        this.offerMsg = str;
    }

    public SpannableString getSpannableConvFeeText() {
        return this.spannableConvFeeText;
    }

    public void setSpannableConvFeeText(SpannableString spannableString) {
        this.spannableConvFeeText = spannableString;
    }
}
