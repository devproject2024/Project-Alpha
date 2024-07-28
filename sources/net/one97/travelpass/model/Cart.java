package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;

public final class Cart extends IJRPaytmDataModel {
    @b(a = "AUTH_MODE")
    public String AUTH_MODE;
    @b(a = "BANK_CODE")
    public String BANK_CODE;
    @b(a = "CARD_TYPE")
    public String CARD_TYPE;
    @b(a = "CHANNEL_ID")
    public String CHANNEL_ID;
    @b(a = "CHECKSUMHASH")
    public String CHECKSUMHASH;
    @b(a = "CUST_ID")
    private long CUST_ID;
    @b(a = "DEVICE_ID")
    public String DEVICE_ID;
    @b(a = "EMI_OPTIONS")
    public String EMI_OPTIONS;
    @b(a = "INDUSTRY_TYPE_ID")
    public String INDUSTRY_TYPE_ID;
    @b(a = "MID")
    public String MID;
    @b(a = "ORDER_ID")
    private long ORDER_ID;
    @b(a = "PAYMENT_MODE_DISABLE")
    public String PAYMENT_MODE_DISABLE;
    @b(a = "PAYMENT_TYPE_ID")
    public String PAYMENT_TYPE_ID;
    @b(a = "PAYTM_TOKEN")
    public String PAYTM_TOKEN;
    @b(a = "PROMO_CAMP_ID")
    public String PROMO_CAMP_ID;
    @b(a = "SSO_TOKEN")
    public String SSO_TOKEN;
    @b(a = "THEME")
    public String THEME;
    @b(a = "TOKEN_TYPE")
    public String TOKEN_TYPE;
    @b(a = "TXN_AMOUNT")
    private float TXN_AMOUNT;
    @b(a = "WEBSITE")
    public String WEBSITE;
    @b(a = "hitPG")
    public String hitPG;
    @b(a = "message")
    public String message;
    @b(a = "pgUrlToHit")
    public String pgUrlToHit;
    @b(a = "status")
    public String status;
    @b(a = "subwalletAmount")
    public String subwalletAmount;

    public final String getMID() {
        String str = this.MID;
        if (str == null) {
            k.a("MID");
        }
        return str;
    }

    public final void setMID(String str) {
        k.c(str, "<set-?>");
        this.MID = str;
    }

    public final long getORDER_ID() {
        return this.ORDER_ID;
    }

    public final void setORDER_ID(long j) {
        this.ORDER_ID = j;
    }

    public final long getCUST_ID() {
        return this.CUST_ID;
    }

    public final void setCUST_ID(long j) {
        this.CUST_ID = j;
    }

    public final float getTXN_AMOUNT() {
        return this.TXN_AMOUNT;
    }

    public final void setTXN_AMOUNT(float f2) {
        this.TXN_AMOUNT = f2;
    }

    public final String getCHANNEL_ID() {
        String str = this.CHANNEL_ID;
        if (str == null) {
            k.a("CHANNEL_ID");
        }
        return str;
    }

    public final void setCHANNEL_ID(String str) {
        k.c(str, "<set-?>");
        this.CHANNEL_ID = str;
    }

    public final String getWEBSITE() {
        String str = this.WEBSITE;
        if (str == null) {
            k.a("WEBSITE");
        }
        return str;
    }

    public final void setWEBSITE(String str) {
        k.c(str, "<set-?>");
        this.WEBSITE = str;
    }

    public final String getPAYMENT_MODE_DISABLE() {
        String str = this.PAYMENT_MODE_DISABLE;
        if (str == null) {
            k.a(CJRPGTransactionRequestUtils.PAYMENT_MODE_DISABLE);
        }
        return str;
    }

    public final void setPAYMENT_MODE_DISABLE(String str) {
        k.c(str, "<set-?>");
        this.PAYMENT_MODE_DISABLE = str;
    }

    public final String getCHECKSUMHASH() {
        String str = this.CHECKSUMHASH;
        if (str == null) {
            k.a("CHECKSUMHASH");
        }
        return str;
    }

    public final void setCHECKSUMHASH(String str) {
        k.c(str, "<set-?>");
        this.CHECKSUMHASH = str;
    }

    public final String getSSO_TOKEN() {
        String str = this.SSO_TOKEN;
        if (str == null) {
            k.a("SSO_TOKEN");
        }
        return str;
    }

    public final void setSSO_TOKEN(String str) {
        k.c(str, "<set-?>");
        this.SSO_TOKEN = str;
    }

    public final String getPAYTM_TOKEN() {
        String str = this.PAYTM_TOKEN;
        if (str == null) {
            k.a(CJRPGTransactionRequestUtils.PAYTM_TOKEN);
        }
        return str;
    }

    public final void setPAYTM_TOKEN(String str) {
        k.c(str, "<set-?>");
        this.PAYTM_TOKEN = str;
    }

    public final String getDEVICE_ID() {
        String str = this.DEVICE_ID;
        if (str == null) {
            k.a("DEVICE_ID");
        }
        return str;
    }

    public final void setDEVICE_ID(String str) {
        k.c(str, "<set-?>");
        this.DEVICE_ID = str;
    }

    public final String getSubwalletAmount() {
        String str = this.subwalletAmount;
        if (str == null) {
            k.a("subwalletAmount");
        }
        return str;
    }

    public final void setSubwalletAmount(String str) {
        k.c(str, "<set-?>");
        this.subwalletAmount = str;
    }

    public final String getINDUSTRY_TYPE_ID() {
        String str = this.INDUSTRY_TYPE_ID;
        if (str == null) {
            k.a("INDUSTRY_TYPE_ID");
        }
        return str;
    }

    public final void setINDUSTRY_TYPE_ID(String str) {
        k.c(str, "<set-?>");
        this.INDUSTRY_TYPE_ID = str;
    }

    public final String getAUTH_MODE() {
        String str = this.AUTH_MODE;
        if (str == null) {
            k.a("AUTH_MODE");
        }
        return str;
    }

    public final void setAUTH_MODE(String str) {
        k.c(str, "<set-?>");
        this.AUTH_MODE = str;
    }

    public final String getPAYMENT_TYPE_ID() {
        String str = this.PAYMENT_TYPE_ID;
        if (str == null) {
            k.a("PAYMENT_TYPE_ID");
        }
        return str;
    }

    public final void setPAYMENT_TYPE_ID(String str) {
        k.c(str, "<set-?>");
        this.PAYMENT_TYPE_ID = str;
    }

    public final String getBANK_CODE() {
        String str = this.BANK_CODE;
        if (str == null) {
            k.a("BANK_CODE");
        }
        return str;
    }

    public final void setBANK_CODE(String str) {
        k.c(str, "<set-?>");
        this.BANK_CODE = str;
    }

    public final String getCARD_TYPE() {
        String str = this.CARD_TYPE;
        if (str == null) {
            k.a(CJRPGTransactionRequestUtils.CARD_TYPE);
        }
        return str;
    }

    public final void setCARD_TYPE(String str) {
        k.c(str, "<set-?>");
        this.CARD_TYPE = str;
    }

    public final String getPROMO_CAMP_ID() {
        String str = this.PROMO_CAMP_ID;
        if (str == null) {
            k.a(CJRPGTransactionRequestUtils.PROMO_CAMP_ID);
        }
        return str;
    }

    public final void setPROMO_CAMP_ID(String str) {
        k.c(str, "<set-?>");
        this.PROMO_CAMP_ID = str;
    }

    public final String getTHEME() {
        String str = this.THEME;
        if (str == null) {
            k.a(CJRPGTransactionRequestUtils.THEME);
        }
        return str;
    }

    public final void setTHEME(String str) {
        k.c(str, "<set-?>");
        this.THEME = str;
    }

    public final String getEMI_OPTIONS() {
        String str = this.EMI_OPTIONS;
        if (str == null) {
            k.a(CJRPGTransactionRequestUtils.EMI_OPTIONS);
        }
        return str;
    }

    public final void setEMI_OPTIONS(String str) {
        k.c(str, "<set-?>");
        this.EMI_OPTIONS = str;
    }

    public final String getTOKEN_TYPE() {
        String str = this.TOKEN_TYPE;
        if (str == null) {
            k.a(CJRPGTransactionRequestUtils.TOKEN_TYPE);
        }
        return str;
    }

    public final void setTOKEN_TYPE(String str) {
        k.c(str, "<set-?>");
        this.TOKEN_TYPE = str;
    }

    public final String getStatus() {
        String str = this.status;
        if (str == null) {
            k.a("status");
        }
        return str;
    }

    public final void setStatus(String str) {
        k.c(str, "<set-?>");
        this.status = str;
    }

    public final String getMessage() {
        String str = this.message;
        if (str == null) {
            k.a("message");
        }
        return str;
    }

    public final void setMessage(String str) {
        k.c(str, "<set-?>");
        this.message = str;
    }

    public final String getHitPG() {
        String str = this.hitPG;
        if (str == null) {
            k.a("hitPG");
        }
        return str;
    }

    public final void setHitPG(String str) {
        k.c(str, "<set-?>");
        this.hitPG = str;
    }

    public final String getPgUrlToHit() {
        String str = this.pgUrlToHit;
        if (str == null) {
            k.a(CJRPGTransactionRequestUtils.PG_PAGE_URL);
        }
        return str;
    }

    public final void setPgUrlToHit(String str) {
        k.c(str, "<set-?>");
        this.pgUrlToHit = str;
    }
}
