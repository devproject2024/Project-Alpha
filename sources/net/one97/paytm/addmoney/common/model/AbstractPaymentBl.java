package net.one97.paytm.addmoney.common.model;

import java.util.HashMap;
import java.util.List;
import net.one97.paytm.addmoney.common.paymethodresponse.AddMoneyPayMethod;
import net.one97.paytm.addmoney.common.paymethodresponse.AddMoneySavedInstruments;
import net.one97.paytm.addmoney.common.paymethodresponse.CJPayMethodResponse;
import net.one97.paytm.addmoney.common.paymethodresponse.MerchantDetails;
import net.one97.paytm.addmoney.common.paymethodresponse.MerchantPayMethod;
import net.one97.paytm.addmoney.common.paymethodresponse.MerchantSavedInstruments;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class AbstractPaymentBl {
    protected CJPayMethodResponse mPayMethodResponse;
    private HashMap<String, String> mProcessTransactionParams;
    protected double walletBalance;

    public boolean isPgOptionEnable() {
        return false;
    }

    public void updateResponse(CJPayMethodResponse cJPayMethodResponse) {
        this.mPayMethodResponse = cJPayMethodResponse;
    }

    public boolean hasSufficientBalance(double d2) {
        int compare = Double.compare(this.walletBalance, d2);
        return compare > 0 || compare >= 0;
    }

    public MerchantSavedInstruments getMerchantSavedMethods() {
        try {
            return this.mPayMethodResponse.getCjrPayMethods().getPayMethodViews().getMerchantSavedInstruments();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public List<MerchantPayMethod> getMerchantInstrumentMethods() {
        try {
            return this.mPayMethodResponse.getCjrPayMethods().getPayMethodViews().getMerchantPayMethods();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public AddMoneySavedInstruments getAddMoneySavedMethods() {
        try {
            return this.mPayMethodResponse.getCjrPayMethods().getPayMethodViews().getAddMoneySavedInstruments();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public List<AddMoneyPayMethod> getAddMoneyInstrumentMethods() {
        try {
            return this.mPayMethodResponse.getCjrPayMethods().getPayMethodViews().getAddMoneyPayMethods();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public List<MerchantPayMethod> getMerchantPayMethods() {
        try {
            return this.mPayMethodResponse.getCjrPayMethods().getPayMethodViews().getMerchantPayMethods();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public MerchantDetails getMerchantDetails() {
        try {
            return this.mPayMethodResponse.getCjrPayMethods().getMerchantDetails();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public String getOrderId() {
        try {
            return this.mPayMethodResponse.getCjrPayMethods().getOrderId();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public CJPayMethodResponse getPayMethodResponse() {
        return this.mPayMethodResponse;
    }

    public EnableFlow getEnableFlowType() {
        List<String> enabledFlows = this.mPayMethodResponse.getCjrPayMethods().getEnabledFlows();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = 0; i2 < enabledFlows.size(); i2++) {
            if (enabledFlows.get(i2).equalsIgnoreCase("ADD_AND_PAY")) {
                z3 = true;
            } else if (enabledFlows.get(i2).equalsIgnoreCase(SDKConstants.HYBRID)) {
                z = true;
            } else if (enabledFlows.get(i2).equalsIgnoreCase("PG_ONLY")) {
                z2 = true;
            }
        }
        if (z) {
            return EnableFlow.HYBRID;
        }
        if (!z2 || !z3) {
            return EnableFlow.ADD_N_PAY_ONLY;
        }
        return EnableFlow.ADD_N_PAY_PLUS_PG;
    }

    public void setWalletBalance(double d2) {
        this.walletBalance = d2;
    }

    public void setMID(String str) {
        this.mProcessTransactionParams.put("MID", str);
    }

    public void setIndustryTypeId(String str) {
        this.mProcessTransactionParams.put("INDUSTRY_TYPE_ID", str);
    }

    public void setChannelID(String str) {
        this.mProcessTransactionParams.put("CHANNEL_ID", str);
    }

    public void setTxnAmount(String str) {
        this.mProcessTransactionParams.put("TXN_AMOUNT", str);
    }

    public void setAuthMode(String str) {
        this.mProcessTransactionParams.put("AUTH_MODE", str);
    }

    public void setWebsite(String str) {
        this.mProcessTransactionParams.put("WEBSITE", str);
    }

    public void setSSOToken(String str) {
        this.mProcessTransactionParams.put("SSO_TOKEN", str);
    }

    public void setTokenType(String str) {
        this.mProcessTransactionParams.put(CJRPGTransactionRequestUtils.TOKEN_TYPE, str);
    }

    public void setPaymentTypeId(String str) {
        this.mProcessTransactionParams.put("PAYMENT_TYPE_ID", str);
    }

    public void setRequestType(String str) {
        this.mProcessTransactionParams.put("REQUEST_TYPE", str);
    }

    public void setCallBackUrl(String str) {
        this.mProcessTransactionParams.put(CJRPGTransactionRequestUtils.CALLBACK_URL, str);
    }

    public void setBankCode(String str) {
        this.mProcessTransactionParams.put("BANK_CODE", str);
    }

    public HashMap<String, String> getProcessTransactionParams() {
        return this.mProcessTransactionParams;
    }

    public void setPaymentDetails(String str) {
        this.mProcessTransactionParams.put("PAYMENT_DETAILS", str);
    }

    public void initMap() {
        this.mProcessTransactionParams = new HashMap<>();
    }
}
