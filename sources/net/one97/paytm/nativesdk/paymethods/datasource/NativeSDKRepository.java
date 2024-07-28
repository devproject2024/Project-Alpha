package net.one97.paytm.nativesdk.paymethods.datasource;

import android.content.Context;
import android.net.Uri;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gson.f;
import com.paytm.contactsSdk.database.ContactColumn;
import com.sendbird.android.constant.StringSet;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.model.ApplyPromoRequest;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.CJRVerifyPasscodeResponse;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.common.model.FetchCardDetailsRequest;
import net.one97.paytm.nativesdk.common.model.FetchCardDetailsResponse;
import net.one97.paytm.nativesdk.common.model.PcfDetailsResponse;
import net.one97.paytm.nativesdk.common.model.UpiConsentResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.PromoCodeResponse;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.NBResponse;
import net.one97.paytm.nativesdk.orflow.promo.model.GetCardDetailsResponse;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeSDKRepository implements NativeSdkDataSource {
    private static NativeSDKRepository repository;
    private Context context;
    private boolean isOrderFlow;

    private NativeSDKRepository(Context context2, boolean z) {
        this.context = context2.getApplicationContext();
        this.isOrderFlow = z;
    }

    public static void init(Context context2, boolean z) {
        repository = new NativeSDKRepository(context2, z);
    }

    public static NativeSDKRepository getInstance() {
        if (repository == null) {
            if (PaytmSDK.getCallbackListener() != null) {
                PaytmSDK.getCallbackListener().logCrashAnalytics("NativeSDKRepository", "Repository instance found null, flow type: ".concat(String.valueOf("App Invoke:" + SDKUtility.isAppInvokeFlow() + "   Deferred flow:" + DirectPaymentBL.getInstance().isToCreateOrderPaytmSdk())));
            }
            synchronized (NativeSDKRepository.class) {
                if (repository == null) {
                    repository = new NativeSDKRepository(PaytmSDK.getAppContext(), DirectPaymentBL.getInstance().isToCreateOrderPaytmSdk());
                }
            }
        }
        return repository;
    }

    public void notifyServerAboutCloseOrder() {
        HashMap hashMap = new HashMap();
        hashMap.put("channel", SDKConstants.WAP);
        hashMap.put(SDKConstants.VERSION, "2");
        hashMap.put("client", SDKConstants.WAP);
        hashMap.put(AppConstants.TAG_CHILD_SITE_ID, "1");
        hashMap.put(AppConstants.TAG_SITE_ID, "1");
        hashMap.put("order_id", MerchantBL.getMerchantInstance().getOrderId());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap2.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, MerchantBL.getMerchantInstance().getSsoToken());
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, SDKUtility.addParams(NativeSdkGtmLoader.getCloseOrderUrl(), hashMap), hashMap2, hashMap, (String) null, new Response.Listener() {
            public void onResponse(Object obj) {
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Close Order"));
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
                }
            }
        }, Object.class);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        VolleyRequestQueue.getInstance(this.context).addToRequestQueue(volleyPostRequest);
    }

    public void fetchPayOptions(String str, double d2, String str2, PaymentMethodDataSource.Callback<CJPayMethodResponse> callback) {
        final PaymentMethodDataSource.Callback<CJPayMethodResponse> callback2 = callback;
        String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getFetchPay(str));
        HashMap hashMap = new HashMap();
        hashMap.put("SSO_TOKEN", str2);
        executeRequest(new VolleyPostRequest(1, addAuthDefaultParams, hashMap, (Map<String, String>) null, APIReqtGenerator.createJsonForFetchAPI(SDKConstants.ALL_TYPE, str, String.valueOf(d2), str2, true, true), new Response.Listener() {
            public void onResponse(Object obj) {
                callback2.onResponse((CJPayMethodResponse) obj);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch Pay Options"));
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
                }
                callback2.onErrorResponse(volleyError, null);
            }
        }, CJPayMethodResponse.class));
    }

    public void fetchPayOptions(String str, String str2, String str3, final PaymentMethodDataSource.Callback<CJPayMethodResponse> callback) {
        executeRequest(new VolleyPostRequest(1, SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getFetchPay(str, str2)), (Map<String, String>) null, (Map<String, String>) null, APIReqtGenerator.createJsonForFetchAPI(SDKConstants.ALL_TYPE, str3, false, false), new Response.Listener() {
            public void onResponse(Object obj) {
                callback.onResponse((CJPayMethodResponse) obj);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch Pay Options"));
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
                }
                callback.onErrorResponse(volleyError, null);
            }
        }, CJPayMethodResponse.class));
    }

    public void fetchCardDetails(String str, final PaymentMethodDataSource.Callback<GetCardDetailsResponse> callback) {
        try {
            String mid = MerchantBL.getMerchantInstance().getMid();
            String ssoToken = MerchantBL.getMerchantInstance().getSsoToken();
            String cardDetails = NativeSdkGtmLoader.getCardDetails(mid);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
                jSONObject2.put("channelId", SDKConstants.WAP);
                jSONObject2.put(SDKConstants.VERSION, "1.0");
                jSONObject2.put("tokenType", SDKConstants.SSO);
                jSONObject2.put(StringSet.token, ssoToken);
            } catch (Exception e2) {
                LogUtility.d("Prince", e2.getMessage());
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("mid", mid);
                jSONObject3.put(SDKConstants.CARD_NUMBER, str);
                jSONObject3.put("eightDigitBinRequired", true);
            } catch (Exception e3) {
                LogUtility.d("Prince", e3.getMessage());
            }
            jSONObject.put("head", jSONObject2);
            jSONObject.put("body", jSONObject3);
            executeRequest(new VolleyPostRequest(1, cardDetails, (Map<String, String>) null, (Map<String, String>) null, jSONObject.toString(), new Response.Listener() {
                public void onResponse(Object obj) {
                    try {
                        GetCardDetailsResponse getCardDetailsResponse = (GetCardDetailsResponse) obj;
                        if ("S".equalsIgnoreCase(getCardDetailsResponse.getBody().getResultInfo().getResultStatus())) {
                            callback.onResponse(getCardDetailsResponse);
                            return;
                        }
                        if (SDKUtility.isAppInvokeFlow()) {
                            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch Card Details"));
                            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, getCardDetailsResponse.getBody().getResultInfo().getResultCode()));
                        }
                        callback.onErrorResponse((VolleyError) null, getCardDetailsResponse);
                    } catch (Exception e2) {
                        LogUtility.printStackTrace(e2);
                        callback.onErrorResponse((VolleyError) null, null);
                    }
                }
            }, new Response.ErrorListener() {
                public void onErrorResponse(VolleyError volleyError) {
                    callback.onErrorResponse(volleyError, null);
                }
            }, GetCardDetailsResponse.class));
        } catch (Exception e4) {
            LogUtility.d("Prince", e4.getMessage());
        }
    }

    public void fetchBinDetails(String str, final PaymentMethodDataSource.Callback<BinResponse> callback) {
        String binDetails;
        JSONObject jSONObject;
        try {
            if (this.isOrderFlow) {
                binDetails = NativeSdkGtmLoader.getBinDetails(MerchantBL.getMerchantInstance().getMid());
            } else {
                binDetails = NativeSdkGtmLoader.getBinDetails(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId());
            }
            String str2 = binDetails;
            JSONObject jSONObject2 = new JSONObject();
            if (this.isOrderFlow) {
                jSONObject = SDKUtility.getNecessaryHeadersParamsWithSSO();
            } else {
                jSONObject = SDKUtility.getNecessaryHeadersParams();
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(SDKConstants.BIN, str);
            if (!DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
                jSONObject3.put(SDKConstants.TXN_TYPE, SDKConstants.NATIVE_SDK_NONE);
            } else if (DirectPaymentBL.getInstance().isWalletAmountSufficientToPay()) {
                jSONObject3.put(SDKConstants.TXN_TYPE, SDKConstants.NATIVE_SDK_NONE);
            } else {
                jSONObject3.put(SDKConstants.TXN_TYPE, DirectPaymentBL.getInstance().getPaymentFlowAvailable());
            }
            if (this.isOrderFlow) {
                jSONObject3.put(SDKConstants.MID, MerchantBL.getMerchantInstance().getMid());
            }
            jSONObject2.put(SDKConstants.HEAD, jSONObject);
            jSONObject2.put(SDKConstants.BODY, jSONObject3);
            HashMap hashMap = new HashMap();
            hashMap.put("SSO_TOKEN", MerchantBL.getMerchantInstance().getSsoToken());
            executeRequest(new VolleyPostRequest(1, str2, hashMap, (Map<String, String>) null, jSONObject2.toString(), new Response.Listener() {
                public void onResponse(Object obj) {
                    callback.onResponse((BinResponse) obj);
                }
            }, new Response.ErrorListener() {
                public void onErrorResponse(VolleyError volleyError) {
                    if (SDKUtility.isAppInvokeFlow()) {
                        SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch Bin Details"));
                        SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
                    }
                    callback.onErrorResponse(volleyError, null);
                }
            }, BinResponse.class));
        } catch (Exception unused) {
            callback.onErrorResponse(new CustomVolleyError("Error in creating bin json."), null);
        }
    }

    public void fetchNBDetails(String str, final PaymentMethodDataSource.Callback<NBResponse> callback) {
        String str2;
        if (!this.isOrderFlow) {
            str2 = NativeSdkGtmLoader.getNBList(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId());
        } else {
            str2 = NativeSdkGtmLoader.getNBList(MerchantBL.getMerchantInstance().getMid());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("SSO_TOKEN", MerchantBL.getMerchantInstance().getSsoToken());
        executeRequest(new VolleyPostRequest(1, str2, hashMap, (Map<String, String>) null, APIReqtGenerator.createJsonForNBAPI(str, this.isOrderFlow), new Response.Listener() {
            public void onResponse(Object obj) {
                callback.onResponse((NBResponse) obj);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch NB Details"));
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
                }
                callback.onErrorResponse(volleyError, null);
            }
        }, NBResponse.class));
    }

    public void fetchEmiDetails(String str, String str2, final PaymentMethodDataSource.Callback<EmiResponse> callback) {
        String str3;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("SSO_TOKEN", MerchantBL.getMerchantInstance().getSsoToken());
            if (!this.isOrderFlow) {
                str3 = NativeSdkGtmLoader.getEmiDetailsUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId());
            } else {
                str3 = NativeSdkGtmLoader.getEmiDetailsUrl(MerchantBL.getMerchantInstance().getMid());
            }
            executeRequest(new VolleyPostRequest(1, str3, hashMap, (Map<String, String>) null, APIReqtGenerator.createJsonForEmiDetailsAPI(str, str2, this.isOrderFlow), new Response.Listener<EmiResponse>() {
                public void onResponse(EmiResponse emiResponse) {
                    callback.onResponse(emiResponse);
                }
            }, new Response.ErrorListener() {
                public void onErrorResponse(VolleyError volleyError) {
                    if (SDKUtility.isAppInvokeFlow()) {
                        SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch EMI Details"));
                        SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
                    }
                    callback.onErrorResponse(volleyError, null);
                }
            }, EmiResponse.class));
        } catch (Exception unused) {
            callback.onErrorResponse(new CustomVolleyError("error in initializing request data."), null);
        }
    }

    public void fetchBalance(String str, final PaymentMethodDataSource.Callback<CJRFetchBalanceResponse> callback) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("SSO_TOKEN", MerchantBL.getMerchantInstance().getSsoToken());
        if (this.isOrderFlow) {
            str2 = NativeSdkGtmLoader.getFetchBalanceUrl(MerchantBL.getMerchantInstance().getMid());
        } else {
            str2 = NativeSdkGtmLoader.getFetchBalanceUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId());
        }
        executeRequest(new VolleyPostRequest(1, str2, hashMap, (Map<String, String>) null, APIReqtGenerator.createJsonForFetchBalance(str, this.isOrderFlow), new Response.Listener() {
            public void onResponse(Object obj) {
                callback.onResponse((CJRFetchBalanceResponse) obj);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch Balance"));
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
                }
                callback.onErrorResponse(volleyError, null);
            }
        }, CJRFetchBalanceResponse.class));
    }

    public void fetchPromoCodeDetail(String str, String str2, final PaymentMethodDataSource.Callback<PromoCodeResponse> callback) {
        String str3;
        if (this.isOrderFlow) {
            str3 = NativeSdkGtmLoader.getPromoCodeApiUrl(MerchantBL.getMerchantInstance().getMid());
        } else {
            str3 = NativeSdkGtmLoader.getPromoCodeApiUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId());
        }
        executeRequest(new VolleyPostRequest(1, str3, (Map<String, String>) null, (Map<String, String>) null, APIReqtGenerator.createJSONForFetchPromo(str, str2), new Response.Listener<PromoCodeResponse>() {
            public void onResponse(PromoCodeResponse promoCodeResponse) {
                callback.onResponse(promoCodeResponse);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch Promo Code"));
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
                }
                callback.onErrorResponse(volleyError, null);
            }
        }, PromoCodeResponse.class));
    }

    public void getToken(String str, String str2, final PaymentMethodDataSource.Callback<CJRVerifyPasscodeResponse> callback) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", MerchantBL.getMerchantInstance().getAuthentication());
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("session_token", MerchantBL.getMerchantInstance().getSsoToken());
            String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getToken());
            executeRequest(new VolleyPostRequest(1, addAuthDefaultParams, hashMap, (Map<String, String>) null, "grant_type=" + URLEncoder.encode("password", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&login_id=" + URLEncoder.encode(MerchantBL.getMerchantInstance().getMobileNumber(), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&login_secret=" + URLEncoder.encode(str, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&scope=" + URLEncoder.encode(str2, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&login_id_type=" + URLEncoder.encode(ContactColumn.PHONE_NUMBER, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "&login_secret_type=" + URLEncoder.encode("passcode", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8), new Response.Listener() {
                public void onResponse(Object obj) {
                    callback.onResponse((CJRVerifyPasscodeResponse) obj);
                }
            }, new Response.ErrorListener() {
                public void onErrorResponse(VolleyError volleyError) {
                    if (SDKUtility.isAppInvokeFlow()) {
                        SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Get Token"));
                        SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
                    }
                    callback.onErrorResponse(volleyError, null);
                }
            }, CJRVerifyPasscodeResponse.class));
        } catch (Exception unused) {
            callback.onErrorResponse(new CustomVolleyError("Error in creating request data."), null);
        }
    }

    public void applyOffer(ApplyPromoRequest applyPromoRequest, final PaymentMethodDataSource.Callback<ApplyPromoResponse> callback) {
        executeRequest(new VolleyPostRequest(1, NativeSdkGtmLoader.getApplyPromoUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()), (Map<String, String>) null, (Map<String, String>) null, new f().b(applyPromoRequest), new Response.Listener() {
            public void onResponse(Object obj) {
                callback.onResponse((ApplyPromoResponse) obj);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Apply Offers"));
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
                }
                callback.onErrorResponse(volleyError, null);
            }
        }, ApplyPromoResponse.class));
    }

    public void fetchCardDetails(FetchCardDetailsRequest fetchCardDetailsRequest, final PaymentMethodDataSource.Callback<FetchCardDetailsResponse> callback) {
        executeRequest(new VolleyPostRequest(1, NativeSdkGtmLoader.getFetchCardDetailsUrl(MerchantBL.getMerchantInstance().getMid()), (Map<String, String>) null, (Map<String, String>) null, new f().b(fetchCardDetailsRequest), new Response.Listener() {
            public void onResponse(Object obj) {
                callback.onResponse((FetchCardDetailsResponse) obj);
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch Card Details"));
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
                }
                callback.onErrorResponse(volleyError, null);
            }
        }, FetchCardDetailsResponse.class));
    }

    public void makeUpiConsentApiCall(String str, boolean z, HashMap<String, String> hashMap) {
        try {
            String uri = Uri.parse(NativeSdkGtmLoader.getUpiConsentApi()).buildUpon().appendQueryParameter("seq-no", hashMap.get(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE)).appendQueryParameter("device-id", hashMap.get("deviceId")).appendQueryParameter("timestamp", String.valueOf(System.currentTimeMillis())).build().toString();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("custId", DirectPaymentBL.getInstance().getCustomerId());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("bankCode", str);
            jSONObject2.put("linkAccount", z);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("consentList", jSONArray);
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap3.put("content-type", "application/json");
            hashMap3.put("channel", "paytm");
            hashMap3.put(UpiConstants.CHANNEL_TOKEN, MerchantBL.getMerchantInstance().getSsoToken());
            executeRequest(new VolleyPostRequest(1, uri, hashMap3, hashMap2, jSONObject.toString(), new Response.Listener<UpiConsentResponse>() {
                public void onResponse(UpiConsentResponse upiConsentResponse) {
                    LogUtility.d("upiConsentApi", "upi consent api success");
                    if (upiConsentResponse.getStatus().equals("SUCCESS")) {
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_CONSENT, SDKConstants.GA_UPI_ACCOUNT_LINKED, MerchantBL.getMerchantInstance().getOrderId(), "Success", MerchantBL.getMerchantInstance().getMid()));
                    } else {
                        SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_CONSENT, SDKConstants.GA_UPI_ACCOUNT_LINKED, MerchantBL.getMerchantInstance().getOrderId(), SDKConstants.GA_NATIVE_FAILED, MerchantBL.getMerchantInstance().getMid()));
                    }
                }
            }, new Response.ErrorListener() {
                public void onErrorResponse(VolleyError volleyError) {
                    LogUtility.d("upiConsentApi", "upi consent api error");
                }
            }, UpiConsentResponse.class));
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public void fetchPcfDetails(JSONObject jSONObject, final PaymentMethodDataSource.Callback<PcfDetailsResponse> callback) {
        String pcfDetails = NativeSdkGtmLoader.getPcfDetails(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId());
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(SDKConstants.VERSION, "v1");
            jSONObject2.put("channelId", SDKConstants.WAP);
            jSONObject2.put("txnToken", MerchantBL.getMerchantInstance().getToken());
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            jSONObject3.put(SDKConstants.PAY_METHODS, jSONArray);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(SDKConstants.BODY, jSONObject3);
            jSONObject4.put(SDKConstants.HEAD, jSONObject2);
            executeRequest(new VolleyPostRequest(1, pcfDetails, (Map<String, String>) null, (Map<String, String>) null, jSONObject4.toString(), new Response.Listener() {
                public void onResponse(Object obj) {
                    callback.onResponse((PcfDetailsResponse) obj);
                }
            }, new Response.ErrorListener() {
                public void onErrorResponse(VolleyError volleyError) {
                    if (SDKUtility.isAppInvokeFlow()) {
                        SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_API_ERROR_RESPONSE, "Fetch Card Details"));
                        SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_ERROR_MESSAGE_RESPONSE, volleyError.getLocalizedMessage()));
                    }
                    callback.onErrorResponse(volleyError, null);
                }
            }, PcfDetailsResponse.class));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void executeRequest(Request request) {
        request.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        VolleyRequestQueue.getInstance(this.context).addToRequestQueue(request);
    }
}
