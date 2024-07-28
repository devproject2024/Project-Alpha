package com.travel.bus.pojo.busticket;

import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRBusPayment extends IJRPaytmDataModel {
    private static String LOG_TAG = "CJRBusPayment";
    private static final long serialVersionUID = 1;
    private final String KEY_ACTION = "action";
    private final String KEY_BODY = "body";
    private final String KEY_CODE = "code";
    private final String KEY_ERROR = "error";
    private final String KEY_MESSAGE = "message";
    private final String KEY_MID = "MID";
    private final String KEY_NATIVE_WITHDRAWL = "native_withdraw";
    private final String KEY_ORDER_ID = "ORDER_ID";
    private final String KEY_PG_URL_TO_HIT = CJRPGTransactionRequestUtils.PG_PAGE_URL;
    private final String KEY_RESULT = "result";
    private final String KEY_STATUS = "status";
    private final String KEY_TITLE = "title";
    private final String KEY_TXN_TOKEN = "txnToken";
    private final String NATIVE_WITHDRAWL_DETAILS = "native_withdraw_details";
    private String mAction;
    private int mCode;
    private CJRError mError;
    private String mMID;
    private String mNativeWithdrawl;
    private String mOrderId;
    private HashMap<String, String> mPGParams = new HashMap<>();
    private String mPGUrlToHit;
    private String mResult;
    private String mStatus;
    private String mTxnToken;

    public void setmTxnToken(String str) {
        this.mTxnToken = str;
    }

    public void setmNativeWithdrawl(String str) {
        this.mNativeWithdrawl = str;
    }

    public String getMID() {
        return this.mMID;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public CJRError getError() {
        return this.mError;
    }

    public String getPGUrlToHit() {
        return this.mPGUrlToHit;
    }

    public HashMap<String, String> getPGParams() {
        return this.mPGParams;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getmPGUrlToHit() {
        return this.mPGUrlToHit;
    }

    public void setmPGUrlToHit(String str) {
        this.mPGUrlToHit = str;
    }

    public String getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(String str) {
        this.mStatus = str;
    }

    public CJRError getmError() {
        return this.mError;
    }

    public void setmError(CJRError cJRError) {
        this.mError = cJRError;
    }

    public String getmResult() {
        return this.mResult;
    }

    public void setmResult(String str) {
        this.mResult = str;
    }

    public int getmCode() {
        return this.mCode;
    }

    public void setmCode(int i2) {
        this.mCode = i2;
    }

    public String getmOrderId() {
        return this.mOrderId;
    }

    public void setmOrderId(String str) {
        this.mOrderId = str;
    }

    public String getmMID() {
        return this.mMID;
    }

    public void setmMID(String str) {
        this.mMID = str;
    }

    public HashMap<String, String> getmPGParams() {
        return this.mPGParams;
    }

    public void setmPGParams(HashMap<String, String> hashMap) {
        this.mPGParams = hashMap;
    }

    public String getAction() {
        return this.mAction;
    }

    public void setAction(String str) {
        this.mAction = str;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRBusPayment cJRBusPayment = new CJRBusPayment();
        cJRBusPayment.parseJSONData(str);
        return cJRBusPayment;
    }

    public void parseJSONData(String str) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            JSONObject jSONObject3 = jSONObject2.getJSONObject("status");
            if (jSONObject2.has("body")) {
                JSONObject jSONObject4 = jSONObject2.getJSONObject("body");
                this.mCode = jSONObject2.getInt("code");
                if (jSONObject3 != null && jSONObject3.has("result")) {
                    this.mStatus = jSONObject3.getString("result");
                    this.mResult = jSONObject3.getString("result");
                }
                if (jSONObject4 != null) {
                    if (jSONObject4.has(CJRPGTransactionRequestUtils.PG_PAGE_URL)) {
                        this.mPGUrlToHit = jSONObject4.getString(CJRPGTransactionRequestUtils.PG_PAGE_URL);
                    }
                    if (jSONObject4.has("MID")) {
                        this.mMID = jSONObject4.getString("MID");
                    }
                    if (jSONObject4.has("ORDER_ID")) {
                        this.mOrderId = jSONObject4.getString("ORDER_ID");
                    }
                    if (jSONObject4.has("action")) {
                        this.mAction = jSONObject4.getString("action");
                    }
                }
            }
            if (TextUtils.isEmpty(this.mResult) || !this.mResult.equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE) || (jSONObject = jSONObject3.getJSONObject("message")) == null) {
                JSONObject jSONObject5 = jSONObject2.getJSONObject("body");
                Iterator<String> keys = jSONObject5.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!next.equalsIgnoreCase("error")) {
                        if (next.equalsIgnoreCase("native_withdraw")) {
                            this.mNativeWithdrawl = jSONObject5.getString("native_withdraw");
                        }
                        if (next.equalsIgnoreCase("native_withdraw_details")) {
                            JSONObject jSONObject6 = jSONObject5.getJSONObject("native_withdraw_details");
                            Iterator<String> keys2 = jSONObject6.keys();
                            while (keys2.hasNext()) {
                                if (keys2.next().equalsIgnoreCase("txnToken")) {
                                    this.mTxnToken = jSONObject6.getString("txnToken");
                                }
                            }
                        }
                        this.mPGParams.put(next, jSONObject5.getString(next));
                    }
                }
                return;
            }
            this.mError = new CJRError();
            if (jSONObject.has("message")) {
                this.mError.setMessage(jSONObject.getString("message"));
            }
            if (jSONObject.has("title")) {
                this.mError.setTitle(jSONObject.getString("title"));
            }
        } catch (JSONException unused) {
        }
    }

    public void parseJSONObject(String str) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("code")) {
                this.mCode = jSONObject2.getInt("code");
            }
            try {
                if (jSONObject2.has("status")) {
                    Object obj = jSONObject2.get("status");
                    if ((obj instanceof JSONObject) && obj != null) {
                        JSONObject jSONObject3 = (JSONObject) obj;
                        if (jSONObject3.has("result")) {
                            this.mResult = jSONObject3.getString("result");
                        }
                        this.mStatus = jSONObject3.getString("result");
                        if (!TextUtils.isEmpty(this.mResult) && this.mResult.equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE) && (jSONObject = jSONObject3.getJSONObject("message")) != null) {
                            this.mError = new CJRError();
                            if (jSONObject.has("message")) {
                                this.mError.setMessage(jSONObject.getString("message"));
                            }
                            if (jSONObject.has("title")) {
                                this.mError.setTitle(jSONObject.getString("title"));
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
            Iterator<String> keys = jSONObject2.getJSONObject("body").keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase(CJRPGTransactionRequestUtils.PG_PAGE_URL)) {
                    this.mPGUrlToHit = jSONObject2.getString(CJRPGTransactionRequestUtils.PG_PAGE_URL);
                } else if (next.equalsIgnoreCase("status")) {
                    this.mStatus = jSONObject2.getString("status");
                } else if (next.equalsIgnoreCase("error")) {
                    Object obj2 = jSONObject2.get(next);
                    JSONObject jSONObject4 = null;
                    if (obj2 instanceof JSONObject) {
                        jSONObject4 = jSONObject2.getJSONObject("error");
                    } else if (obj2 instanceof String) {
                        jSONObject4 = new JSONObject();
                        jSONObject4.put("message", obj2);
                    }
                    if (jSONObject4 != null) {
                        this.mError = new CJRError();
                        if (jSONObject4.has("message")) {
                            this.mError.setMessage(jSONObject4.getString("message"));
                        }
                        if (jSONObject4.has("title")) {
                            this.mError.setTitle(jSONObject4.getString("title"));
                        }
                    }
                } else {
                    if (next.equalsIgnoreCase("ORDER_ID")) {
                        this.mOrderId = jSONObject2.getString("ORDER_ID");
                    }
                    if (next.equalsIgnoreCase("MID")) {
                        this.mMID = jSONObject2.getString("MID");
                    }
                    this.mPGParams.put(next, jSONObject2.getString(next));
                }
            }
        } catch (JSONException e3) {
            q.c(e3.getMessage());
        }
    }

    public String getmTxnToken() {
        return this.mTxnToken;
    }

    public String isNativeEnabled() {
        return this.mNativeWithdrawl;
    }

    public String toString() {
        return new f().a((Object) this);
    }
}
