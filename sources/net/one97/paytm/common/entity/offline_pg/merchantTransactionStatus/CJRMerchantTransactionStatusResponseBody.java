package net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.ExtendInfo;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRMerchantTransactionStatusResponseBody extends CJRWalletDataModel implements IJRDataModel {
    String BANKNAME;
    String BANKTXNID;
    String GATEWAYNAME;
    String ORDERID;
    String PAYMENTMODE;
    String PRN;
    String REFUNDAMT;
    String RESPCODE;
    String RESPMSG;
    String STATUS;
    String TXNAMOUNT;
    String TXNDATE;
    String TXNID;
    String TXNTYPE;
    ExtendInfo extendInfo;
    ResultInfo resultInfo;

    public String getTXNID() {
        return this.TXNID;
    }

    public String getBANKTXNID() {
        return this.BANKTXNID;
    }

    public String getORDERID() {
        return this.ORDERID;
    }

    public ExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public String getTXNAMOUNT() {
        return this.TXNAMOUNT;
    }

    public String getSTATUS() {
        return this.STATUS;
    }

    public String getTXNTYPE() {
        return this.TXNTYPE;
    }

    public String getGATEWAYNAME() {
        return this.GATEWAYNAME;
    }

    public String getRESPCODE() {
        return this.RESPCODE;
    }

    public String getRESPMSG() {
        return this.RESPMSG;
    }

    public String getBANKNAME() {
        return this.BANKNAME;
    }

    public String getPAYMENTMODE() {
        return this.PAYMENTMODE;
    }

    public String getREFUNDAMT() {
        return this.REFUNDAMT;
    }

    public String getTXNDATE() {
        return this.TXNDATE;
    }

    public String getPRN() {
        return this.PRN;
    }

    public void setPRN(String str) {
        this.PRN = str;
    }
}
