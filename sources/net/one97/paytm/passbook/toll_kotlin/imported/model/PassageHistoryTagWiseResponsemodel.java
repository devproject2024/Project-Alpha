package net.one97.paytm.passbook.toll_kotlin.imported.model;

import net.one97.paytm.passbook.mapping.IJRDataModel;

public class PassageHistoryTagWiseResponsemodel extends IJRDataModel {
    private String imageUrl;
    private String laneName;
    private String narration;
    private String plazaId;
    private String plazaName;
    private String readerTS;
    private String tagId;
    private String txnAmount;
    private String txnDateTime;
    private String txnId;
    private String txnStatus;
    private String txnTypeApp;
    private String txnTypeDesc;
    private String vehicleRegNo;

    public String getTagId() {
        return this.tagId;
    }

    public void setTagId(String str) {
        this.tagId = str;
    }

    public String getTxnDateTime() {
        return this.txnDateTime;
    }

    public void setTxnDateTime(String str) {
        this.txnDateTime = str;
    }

    public String getTxnAmount() {
        return this.txnAmount;
    }

    public void setTxnAmount(String str) {
        this.txnAmount = str;
    }

    public String getPlazaId() {
        return this.plazaId;
    }

    public void setPlazaId(String str) {
        this.plazaId = str;
    }

    public String getLaneName() {
        return this.laneName;
    }

    public void setLaneName(String str) {
        this.laneName = str;
    }

    public String getVehicleRegNo() {
        return this.vehicleRegNo;
    }

    public void setVehicleRegNo(String str) {
        this.vehicleRegNo = str;
    }

    public String getPlazaName() {
        return this.plazaName;
    }

    public void setPlazaName(String str) {
        this.plazaName = str;
    }

    public String getTxnTypeApp() {
        return this.txnTypeApp;
    }

    public void setTxnTypeApp(String str) {
        this.txnTypeApp = str;
    }

    public String getNarration() {
        return this.narration;
    }

    public void setNarration(String str) {
        this.narration = str;
    }

    public String getTxnStatus() {
        return this.txnStatus;
    }

    public void setTxnStatus(String str) {
        this.txnStatus = str;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public String getReaderTS() {
        return this.readerTS;
    }

    public void setReaderTS(String str) {
        this.readerTS = str;
    }

    public String getTxnTypeDesc() {
        return this.txnTypeDesc;
    }

    public void setTxnTypeDesc(String str) {
        this.txnTypeDesc = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
