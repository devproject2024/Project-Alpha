package com.travel.flight.pojo.flightticket;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightPaymentInfo extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "AUTH_MODE")
    public String aUTHMODE;
    @c(a = "BANK_CODE")
    public String bANKCODE;
    @c(a = "CARD_TYPE")
    public String cARDTYPE;
    @c(a = "CHANNEL_ID")
    public String cHANNELID;
    @c(a = "CHECKSUMHASH")
    public String cHECKSUMHASH;
    @c(a = "DEVICE_ID")
    public String dEVICEID;
    @c(a = "GOODS_INFO")
    public String gOODSINFO;
    @c(a = "hitPG")
    public String hitPG;
    @c(a = "INDUSTRY_TYPE_ID")
    public String iNDUSTRYTYPEID;
    @c(a = "message")
    public String message;
    @c(a = "mid")
    public String mid;
    @c(a = "native_withdraw")
    public int native_withdraw;
    @c(a = "PAYMENT_MODE_DISABLE")
    public String pAYMENTMODEDISABLE;
    @c(a = "PAYMENT_TYPE_ID")
    public String pAYMENTTYPEID;
    @c(a = "PROMO_CAMP_ID")
    public String pROMOCAMPID;
    @c(a = "SHIPPING_INFO")
    public String sHIPPINGINFO;
    @c(a = "status")
    public String status;
    @c(a = "subwalletAmount")
    public String subwalletAmount;
    @c(a = "THEME")
    public String tHEME;
    @c(a = "TOKEN_TYPE")
    public String tOKENTYPE;
    @c(a = "txnAmount")
    public CJRFlightPaymentTxnAmount txnAmount;
    @c(a = "WEBSITE")
    public String wEBSITE;
}
