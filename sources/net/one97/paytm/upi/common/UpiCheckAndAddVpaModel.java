package net.one97.paytm.upi.common;

import com.google.gson.a.c;
import java.util.ArrayList;

public class UpiCheckAndAddVpaModel implements UpiBaseDataModel {
    @c(a = "finalVirtualAddress")
    private String mFinalVirtualAddress;
    @c(a = "respCode")
    private String mRespCode;
    @c(a = "respMessage")
    private String mRespMessage;
    @c(a = "seqNo")
    private String mSeqNo;
    @c(a = "status")
    private String mStatus;
    @c(a = "suggestedVas")
    private ArrayList<String> mSuggestedVpas;

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public String getRespCode() {
        return this.mRespCode;
    }

    public void setRespCode(String str) {
        this.mRespCode = str;
    }

    public String getRespMessage() {
        return this.mRespMessage;
    }

    public void setRespMessage(String str) {
        this.mRespMessage = str;
    }

    public String getSeqNo() {
        return this.mSeqNo;
    }

    public void setSeqNo(String str) {
        this.mSeqNo = str;
    }

    public String getFinalVirtualAddress() {
        return this.mFinalVirtualAddress;
    }

    public void setFinalVirtualAddress(String str) {
        this.mFinalVirtualAddress = str;
    }

    public ArrayList<String> getSuggestedVpas() {
        return this.mSuggestedVpas;
    }

    public void setSuggestedVpas(ArrayList<String> arrayList) {
        this.mSuggestedVpas = arrayList;
    }
}
