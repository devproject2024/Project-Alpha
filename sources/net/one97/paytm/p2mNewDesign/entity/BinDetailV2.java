package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class BinDetailV2 extends CJRWalletDataModel implements IJRDataModel {
    private String bin;
    private String channelCode;
    private String channelName;
    private String cnMax;
    private String cnMin;
    private String cvvL;
    private String cvvR;
    private String expR;
    private String isActive;
    private String isIndian;
    private String issuingBank;
    private String issuingBankCode;
    private String paymentMode;

    public String getCnMin() {
        return this.cnMin;
    }

    public String getCvvR() {
        return this.cvvR;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public String getBin() {
        return this.bin;
    }

    public String getCvvL() {
        return this.cvvL;
    }

    public String getIssuingBankCode() {
        return this.issuingBankCode;
    }

    public String getIsActive() {
        return this.isActive;
    }

    public String getIssuingBank() {
        return this.issuingBank;
    }

    public String getIsIndian() {
        return this.isIndian;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getExpR() {
        return this.expR;
    }

    public String getChannelCode() {
        return this.channelCode;
    }

    public String getCnMax() {
        return this.cnMax;
    }
}
