package net.one97.paytm.nativesdk;

import android.text.TextUtils;
import java.util.HashMap;
import net.one97.paytm.nativesdk.common.helpers.PCFHelperAIO;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiResponse;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.NBResponse;

public class ApiSession {
    private static ApiSession apiSession;
    private HashMap<String, BinResponse> binResponseHashMap;
    private HashMap<String, EmiResponse> emiResponseHashMap;
    private NBResponse netbankingResponse;

    private ApiSession() {
    }

    public static ApiSession getInstance() {
        if (apiSession == null) {
            apiSession = new ApiSession();
        }
        return apiSession;
    }

    public void setEmiResponse(String str, EmiResponse emiResponse) {
        if (this.emiResponseHashMap == null) {
            this.emiResponseHashMap = new HashMap<>();
        }
        this.emiResponseHashMap.put(str, emiResponse);
    }

    public EmiResponse getEmiResposne(String str) {
        HashMap<String, EmiResponse> hashMap;
        if (TextUtils.isEmpty(str) || (hashMap = this.emiResponseHashMap) == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.emiResponseHashMap.get(str);
    }

    public void setBinResponse(String str, BinResponse binResponse) {
        if (this.binResponseHashMap == null) {
            this.binResponseHashMap = new HashMap<>();
        }
        this.binResponseHashMap.put(str, binResponse);
    }

    public BinResponse getBinResposne(String str) {
        HashMap<String, BinResponse> hashMap;
        if (TextUtils.isEmpty(str) || (hashMap = this.binResponseHashMap) == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.binResponseHashMap.get(str);
    }

    public NBResponse getNetbankingResponse() {
        return this.netbankingResponse;
    }

    public void setNetbankingResponse(NBResponse nBResponse) {
        this.netbankingResponse = nBResponse;
    }

    public void destroySession() {
        MerchantBL.getMerchantInstance().clearInstance();
        DirectPaymentBL.getInstance().clearInstance();
        ConvenienceFeeController.destroyInstance();
        PCFHelperAIO.destroyInstance();
        PaytmSDK.clearInstance();
        this.netbankingResponse = null;
        this.emiResponseHashMap = null;
        this.binResponseHashMap = null;
        apiSession = null;
    }
}
