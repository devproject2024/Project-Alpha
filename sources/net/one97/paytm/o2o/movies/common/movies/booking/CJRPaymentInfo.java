package net.one97.paytm.o2o.movies.common.movies.booking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPaymentInfo extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "AUTH_MODE")
    public String aUTHMODE;
    @b(a = "BANK_CODE")
    public String bANKCODE;
    @b(a = "CARD_TYPE")
    public String cARDTYPE;
    @b(a = "CHANNEL_ID")
    public String cHANNELID;
    @b(a = "CHECKSUMHASH")
    public String cHECKSUMHASH;
    @b(a = "DEVICE_ID")
    public String dEVICEID;
    @b(a = "GOODS_INFO")
    public String gOODSINFO;
    @b(a = "hitPG")
    public String hitPG;
    @b(a = "INDUSTRY_TYPE_ID")
    public String iNDUSTRYTYPEID;
    @b(a = "message")
    public String message;
    @b(a = "mid")
    public String mid;
    @b(a = "native_withdraw")
    public int native_withdraw;
    @b(a = "PAYMENT_MODE_DISABLE")
    public String pAYMENTMODEDISABLE;
    @b(a = "PAYMENT_TYPE_ID")
    public String pAYMENTTYPEID;
    @b(a = "PROMO_CAMP_ID")
    public String pROMOCAMPID;
    @b(a = "SHIPPING_INFO")
    public String sHIPPINGINFO;
    @b(a = "status")
    public String status;
    @b(a = "subwalletAmount")
    public String subwalletAmount;
    @b(a = "THEME")
    public String tHEME;
    @b(a = "TOKEN_TYPE")
    public String tOKENTYPE;
    @b(a = "txnAmount")
    public b txnAmount;
    @b(a = "WEBSITE")
    public String wEBSITE;
}
