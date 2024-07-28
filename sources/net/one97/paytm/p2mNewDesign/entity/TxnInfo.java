package net.one97.paytm.p2mNewDesign.entity;

import java.io.Serializable;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class TxnInfo extends CJRWalletDataModel implements Serializable, IJRDataModel {
    private String ADDITIONAL_INFO;
    private String ADDITIONAL_PARAM;
    private String BANKNAME;
    private String BANKTXNID;
    private String CHECKSUMHASH;
    private String CURRENCY;
    private String GATEWAYNAME;
    private String MERC_UNQ_REF;
    private String MID;
    private String ORDERID;
    private String PAYMENTMODE;
    private String PRN;
    private String RESPCODE;
    private String RESPMSG;
    private String STATUS;
    private String TXNAMOUNT;
    private String TXNDATE;
    private String TXNID;

    public String getPRN() {
        return this.PRN;
    }

    public void setPRN(String str) {
        this.PRN = str;
    }

    public String getCURRENCY() {
        return this.CURRENCY;
    }

    public void setCURRENCY(String str) {
        this.CURRENCY = str;
    }

    public String getORDERID() {
        return this.ORDERID;
    }

    public void setORDERID(String str) {
        this.ORDERID = str;
    }

    public String getBANKTXNID() {
        return this.BANKTXNID;
    }

    public void setBANKTXNID(String str) {
        this.BANKTXNID = str;
    }

    public String getSTATUS() {
        return this.STATUS;
    }

    public void setSTATUS(String str) {
        this.STATUS = str;
    }

    public String getRESPMSG() {
        return this.RESPMSG;
    }

    public void setRESPMSG(String str) {
        this.RESPMSG = str;
    }

    public String getMID() {
        return this.MID;
    }

    public void setMID(String str) {
        this.MID = str;
    }

    public String getRESPCODE() {
        return this.RESPCODE;
    }

    public void setRESPCODE(String str) {
        this.RESPCODE = str;
    }

    public String getCHECKSUMHASH() {
        return this.CHECKSUMHASH;
    }

    public void setCHECKSUMHASH(String str) {
        this.CHECKSUMHASH = str;
    }

    public String getTXNAMOUNT() {
        return this.TXNAMOUNT;
    }

    public void setTXNAMOUNT(String str) {
        this.TXNAMOUNT = str;
    }

    public String getADDITIONAL_INFO() {
        return this.ADDITIONAL_INFO;
    }

    public void setADDITIONAL_INFO(String str) {
        this.ADDITIONAL_INFO = str;
    }

    public String getADDITIONAL_PARAM() {
        return this.ADDITIONAL_PARAM;
    }

    public void setADDITIONAL_PARAM(String str) {
        this.ADDITIONAL_PARAM = str;
    }

    public String getGATEWAYNAME() {
        return this.GATEWAYNAME;
    }

    public void setGATEWAYNAME(String str) {
        this.GATEWAYNAME = str;
    }

    public String getMERC_UNQ_REF() {
        return this.MERC_UNQ_REF;
    }

    public void setMERC_UNQ_REF(String str) {
        this.MERC_UNQ_REF = str;
    }

    public String getPAYMENTMODE() {
        return this.PAYMENTMODE;
    }

    public void setPAYMENTMODE(String str) {
        this.PAYMENTMODE = str;
    }

    public String getTXNDATE() {
        return this.TXNDATE;
    }

    public void setTXNDATE(String str) {
        this.TXNDATE = str;
    }

    public String getTXNID() {
        return this.TXNID;
    }

    public void setTXNID(String str) {
        this.TXNID = str;
    }

    public String getBANKNAME() {
        return this.BANKNAME;
    }

    public void setBANKNAME(String str) {
        this.BANKNAME = str;
    }

    public String toString() {
        return "ClassPojo [CURRENCY = " + this.CURRENCY + ", ORDERID = " + this.ORDERID + ", BANKNAME = " + this.BANKNAME + ", BANKTXNID = " + this.BANKTXNID + ", STATUS = " + this.STATUS + ", RESPMSG = " + this.RESPMSG + ", MID = " + this.MID + ", RESPCODE = " + this.RESPCODE + ", CHECKSUMHASH = " + this.CHECKSUMHASH + ", TXNAMOUNT = " + this.TXNAMOUNT + "]";
    }
}
