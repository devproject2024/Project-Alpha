package net.one97.paytm.nativesdk.Utils;

import android.content.Context;
import android.text.TextUtils;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import org.json.JSONException;
import org.json.JSONObject;

public class FetchOptionsRequest implements Response.ErrorListener, Response.Listener {
    private JSONObject additionalPostParams;
    private double amount;
    private boolean applyPaymentOffer = true;
    private Context context;
    private boolean fetchAllPaymentOffers = true;
    private FetchPayOptionsListener fetchPayOptionsListener;
    private boolean isOrderFlow;
    private String mId;
    private String orderID;
    private String ssoToken;
    private String txnToken;

    public FetchOptionsRequest(Context context2, String str, String str2, String str3, FetchPayOptionsListener fetchPayOptionsListener2) {
        this.context = context2;
        this.mId = str;
        this.orderID = str2;
        this.fetchPayOptionsListener = fetchPayOptionsListener2;
        this.txnToken = str3;
    }

    public FetchOptionsRequest(Context context2, String str, String str2, double d2, FetchPayOptionsListener fetchPayOptionsListener2) {
        if (context2 == null) {
            throw new IllegalArgumentException("Context cannot be null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Mid cannot be null");
        } else if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("sso token cannot be null");
        } else if (d2 > 0.0d) {
            this.context = context2;
            this.mId = str;
            this.fetchPayOptionsListener = fetchPayOptionsListener2;
            this.ssoToken = str2;
            this.isOrderFlow = true;
            this.amount = d2;
        } else {
            throw new IllegalArgumentException("amount cannot be 0");
        }
    }

    public FetchOptionsRequest(Context context2, String str, String str2, JSONObject jSONObject, FetchPayOptionsListener fetchPayOptionsListener2) {
        if (context2 == null) {
            throw new IllegalArgumentException("Context cannot be null");
        } else if (jSONObject != null) {
            try {
                if (!jSONObject.has("mid") || TextUtils.isEmpty(jSONObject.getString("mid"))) {
                    throw new IllegalArgumentException("Mid cannot be null");
                }
                try {
                    if (!jSONObject.has("txnAmount") || jSONObject.getJSONObject("txnAmount") == null || jSONObject.getJSONObject("txnAmount").getInt("value") < 0) {
                        throw new IllegalArgumentException("Transaction amount cannot be null");
                    }
                    this.context = context2;
                    this.mId = str;
                    this.additionalPostParams = jSONObject;
                    this.fetchPayOptionsListener = fetchPayOptionsListener2;
                    this.ssoToken = str2;
                    this.isOrderFlow = true;
                } catch (JSONException unused) {
                    throw new IllegalArgumentException("Transaction amount cannot be null");
                }
            } catch (JSONException unused2) {
                throw new IllegalArgumentException("Mid cannot be null");
            }
        } else {
            throw new IllegalArgumentException("additionalPostParams cannot be null");
        }
    }

    public void executeRequest() {
        callFetchPayAPI();
        this.fetchPayOptionsListener.onRequestStart();
    }

    private Request getFetchInstrumentRequest() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Compression", "gzip");
        hashMap.put("SSO_TOKEN", this.ssoToken);
        if (this.isOrderFlow) {
            if (DirectPaymentBL.getInstance().isSubsCriptionFlow()) {
                str = NativeSdkGtmLoader.getFetchPay(this.mId, this.orderID);
            } else {
                str = NativeSdkGtmLoader.getFetchPay(this.mId);
            }
            String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(this.context, str);
            JSONObject jSONObject = this.additionalPostParams;
            if (jSONObject != null) {
                return new VolleyPostRequest(1, addAuthDefaultParams, hashMap, (Map<String, String>) null, APIReqtGenerator.createJsonForFetchAPI(SDKConstants.ALL_TYPE, this.ssoToken, jSONObject, true, this.fetchAllPaymentOffers, this.applyPaymentOffer), this, this, CJPayMethodResponse.class);
            }
            return new VolleyPostRequest(1, addAuthDefaultParams, hashMap, (Map<String, String>) null, APIReqtGenerator.createJsonForFetchAPI(SDKConstants.ALL_TYPE, this.mId, String.valueOf(this.amount), this.ssoToken, this.fetchAllPaymentOffers, this.applyPaymentOffer), this, this, CJPayMethodResponse.class);
        }
        return new VolleyPostRequest(1, SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getFetchPay(this.mId, this.orderID)), hashMap, (Map<String, String>) null, APIReqtGenerator.createJsonForFetchAPI(SDKConstants.ALL_TYPE, this.txnToken, this.fetchAllPaymentOffers, this.applyPaymentOffer), this, this, CJPayMethodResponse.class);
    }

    private void callFetchPayAPI() {
        Request fetchInstrumentRequest = getFetchInstrumentRequest();
        fetchInstrumentRequest.setRetryPolicy(new DefaultRetryPolicy(40000, 0, 1.0f));
        executeRequest(fetchInstrumentRequest);
    }

    private void executeRequest(Request request) {
        if (SDKUtility.isNetworkAvailable(this.context)) {
            VolleyRequestQueue.getInstance(this.context).addToRequestQueue(request);
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        FetchPayOptionsListener fetchPayOptionsListener2 = this.fetchPayOptionsListener;
        if (fetchPayOptionsListener2 instanceof NewFetchPayOptionsListener) {
            ((NewFetchPayOptionsListener) fetchPayOptionsListener2).onPaymentOptionsError((CustomVolleyError) volleyError);
        }
        this.fetchPayOptionsListener.onPaymentOptionsError();
    }

    public void onResponse(Object obj) {
        if (obj instanceof CJPayMethodResponse) {
            CJPayMethodResponse cJPayMethodResponse = (CJPayMethodResponse) obj;
            this.fetchPayOptionsListener.onPaymentOptionsReceived(cJPayMethodResponse);
            this.fetchPayOptionsListener.onRequestEnd(cJPayMethodResponse, (VpaFetch) null);
        }
    }

    public void setApplyPaymentOffer(boolean z) {
        this.applyPaymentOffer = z;
    }

    public void setFetchAllPaymentOffers(boolean z) {
        this.fetchAllPaymentOffers = z;
    }
}
