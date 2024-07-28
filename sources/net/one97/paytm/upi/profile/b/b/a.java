package net.one97.paytm.upi.profile.b.b;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.google.gson.g;
import com.google.gson.u;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.trainticket.CJRStoreFrontBanners;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.models.CheckBalanceV4Response;
import net.one97.paytm.upi.common.models.CustProductList;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.CJRAccountSummary;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.common.upi.SetPrimaryVpaResponse;
import net.one97.paytm.upi.common.upi.UpiCheckBalanceModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.common.upi.UserMpinDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.deserializer.BaseUpiDeserializer;
import net.one97.paytm.upi.g.c;
import net.one97.paytm.upi.g.d;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.util.ApiCallDataSource;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class a implements net.one97.paytm.upi.profile.b.a {

    /* renamed from: b  reason: collision with root package name */
    private static a f67891b;

    /* renamed from: a  reason: collision with root package name */
    public final Context f67892a;

    /* renamed from: c  reason: collision with root package name */
    private int[] f67893c = {0, 1000, 1000, 1000, H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY, H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY, 5000, 5000};

    /* renamed from: d  reason: collision with root package name */
    private com.paytm.network.a f67894d = null;

    /* renamed from: e  reason: collision with root package name */
    private Handler f67895e = new Handler();

    private a(Context context) {
        this.f67892a = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f67891b == null) {
                f67891b = new a(context);
            }
            aVar = f67891b;
        }
        return aVar;
    }

    public final void a(UpiConstants.PROFILE_VPA_ACCOUNT_TYPE profile_vpa_account_type, UserUpiDetails userUpiDetails, a.C1382a aVar, String str, String str2) {
        a(aVar, str, UpiRequestBuilder.SetDefaultAccount.getSetDefaultAccount(this.f67892a), UpiRequestBuilder.SetDefaultAccount.getParams(this.f67892a, userUpiDetails, profile_vpa_account_type), UpiRequestBuilder.getHeaders(this.f67892a), 22, str2);
    }

    public final void a(String str, UserMpinDetails userMpinDetails, UpiProfileDefaultBank upiProfileDefaultBank, a.C1382a aVar, String str2, String str3) {
        if (TextUtils.isEmpty(upiProfileDefaultBank.getDebitBank().getAccRefId())) {
            a(aVar, str2, UpiRequestBuilder.CheckAccountBalanceV2.getCheckAccountBalanceV2(), UpiRequestBuilder.CheckAccountBalanceV2.getParams(this.f67892a, str, upiProfileDefaultBank, userMpinDetails), UpiRequestBuilder.getHeaders(this.f67892a), 21, str3);
            return;
        }
        a(str, userMpinDetails, upiProfileDefaultBank, aVar);
    }

    private void a(final String str, UserMpinDetails userMpinDetails, UpiProfileDefaultBank upiProfileDefaultBank, final a.C1382a aVar) {
        b postRequestCommonNetworkCallBuilder = ApiCallDataSource.postRequestCommonNetworkCallBuilder();
        postRequestCommonNetworkCallBuilder.f42882f = UpiRequestBuilder.getHeadersWithApplicationJson(this.f67892a);
        postRequestCommonNetworkCallBuilder.f42880d = UpiRequestBuilder.CheckAccountBalance.getCheckAccountBalanceV4(this.f67892a);
        postRequestCommonNetworkCallBuilder.f42884h = UpiRequestBuilder.CheckAccountBalance.getRequestBody(this.f67892a, str, upiProfileDefaultBank, userMpinDetails).toString();
        postRequestCommonNetworkCallBuilder.f42885i = new CheckBalanceV4Response((UpiCheckBalanceModel) null, "", "", "");
        postRequestCommonNetworkCallBuilder.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof CheckBalanceV4Response) {
                    a.a(a.this, (CheckBalanceV4Response) iJRPaytmDataModel, aVar, str, 0);
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                if (!(networkCustomError == null || networkCustomError.networkResponse == null || !UpiUtils.isAuthenticationFailure(String.valueOf(networkCustomError.networkResponse.statusCode)))) {
                    upiCustomVolleyError.setmErrorCode(UpiUtils.AUTHENTICATION_FAILURE_401);
                }
                aVar.onError(upiCustomVolleyError);
            }
        };
        postRequestCommonNetworkCallBuilder.l().a();
    }

    public final void a(UserUpiDetails userUpiDetails, a.C1382a aVar, String str, String str2) {
        a(aVar, str, UpiRequestBuilder.DeleteBankAccount.getDeleteBankAccount(this.f67892a), UpiRequestBuilder.DeleteBankAccount.getParams(this.f67892a, userUpiDetails), UpiRequestBuilder.getHeaders(this.f67892a), 26, str2);
    }

    public final void b(a.C1382a aVar, String str, String str2) {
        a(aVar, str, UpiRequestBuilder.DeregisterProfile.getDeregisterProfile(this.f67892a), UpiRequestBuilder.DeregisterProfile.getParams(this.f67892a), UpiRequestBuilder.getHeaders(this.f67892a), 27, str2);
    }

    private static BankAccountDetails.BankAccount a(String str, ArrayList<BankAccountDetails.BankAccount> arrayList) {
        Iterator<BankAccountDetails.BankAccount> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            BankAccountDetails.BankAccount next = it2.next();
            if (next.getAccRefId().equalsIgnoreCase(str)) {
                return next;
            }
        }
        return arrayList.get(0);
    }

    public final void a(final a.C1382a aVar, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("Session-Token", i.a().f66980a);
        hashMap.put("Device-Id", UpiUtils.getDeviceId(this.f67892a));
        hashMap.put("channel", UpiRequestBuilder.PAYTM_CHANNEL);
        new HashMap().put("screen_name", str2);
        String str3 = UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiProfileUrl();
        net.one97.paytm.upi.g.a aVar2 = new net.one97.paytm.upi.g.a(UpiAppUtils.addAuthDefaultParams(this.f67892a, str3) + "&seq-no=" + UpiUtils.getUpiSequenceNo() + "&fetchPreferences=true", new Response.Listener<UpiBaseDataModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                UpiBaseDataModel upiBaseDataModel = (UpiBaseDataModel) obj;
                if (upiBaseDataModel instanceof UpiProfileModel) {
                    UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                    if (!upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") || !"0".equalsIgnoreCase(upiProfileModel.getRespCode())) {
                        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                        upiCustomVolleyError.setAlertMessage(upiProfileModel.getRespMessage());
                        upiCustomVolleyError.setmErrorCode(upiProfileModel.getRespCode());
                        upiCustomVolleyError.setUrl(UpiGTMLoader.getInstance().getUpiProfileUrl());
                        aVar.onError(upiCustomVolleyError);
                        return;
                    }
                    a.a(upiProfileModel);
                    aVar.onSuccess(upiBaseDataModel);
                    return;
                }
                UpiCustomVolleyError upiCustomVolleyError2 = new UpiCustomVolleyError();
                upiCustomVolleyError2.setAlertMessage("Cannot get Upi Profile");
                upiCustomVolleyError2.setUrl(UpiGTMLoader.getInstance().getUpiProfileUrl());
                aVar.onError(upiCustomVolleyError2);
            }
        }, new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
                aVar.onError((UpiCustomVolleyError) volleyError);
            }
        }, new UpiProfileModel(), hashMap);
        aVar2.setTag(str);
        d.a(aVar2);
    }

    public final void a(final a.C1382a aVar) {
        new HashMap().put("screen_name", getClass().getSimpleName());
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization".toLowerCase(), i.a().f66980a);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("channel", UpiConstants.B2C_ANDROID);
        d.b(this.f67892a.getApplicationContext()).add(new net.one97.paytm.upi.g.a(UpiGTMLoader.getInstance().getPaymentBankBalanceUrl(), new Response.Listener<UpiBaseDataModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                aVar.onSuccess((UpiBaseDataModel) obj);
            }
        }, new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
                aVar.onError((UpiCustomVolleyError) volleyError);
            }
        }, new CJRAccountSummary(), hashMap, ""));
    }

    public final void a(String str, final a.C1382a aVar) {
        new HashMap().put("screen_name", getClass().getSimpleName());
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization".toLowerCase(), i.a().f66980a);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("channel", UpiConstants.B2C_ANDROID);
        String paymentBankBalanceUrl = UpiGTMLoader.getInstance().getPaymentBankBalanceUrl();
        d.b(this.f67892a.getApplicationContext()).add(new net.one97.paytm.upi.g.a(paymentBankBalanceUrl.contains("account_type=isa") ? paymentBankBalanceUrl.replace("account_type=isa", "account_type=ica&account_ref_id=".concat(String.valueOf(str))) : paymentBankBalanceUrl, new Response.Listener<UpiBaseDataModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                aVar.onSuccess((UpiBaseDataModel) obj);
            }
        }, new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
                aVar.onError((UpiCustomVolleyError) volleyError);
            }
        }, new CJRAccountSummary(), hashMap, ""));
    }

    public final void b(final a.C1382a aVar) {
        if (UpiAppUtils.isNetworkAvailable(this.f67892a)) {
            new HashMap().put("screen_name", getClass().getSimpleName());
            HashMap hashMap = new HashMap();
            hashMap.put("User-Token", i.a().f66980a);
            hashMap.put("Content-Type", "application/json");
            hashMap.put("channel", UpiConstants.B2C_ANDROID);
            d.b(this.f67892a.getApplicationContext()).add(new net.one97.paytm.upi.g.a(com.paytm.utility.b.e(this.f67892a, UpiGTMLoader.getInstance().getPPBCustProductListUrl()), new Response.Listener<UpiBaseDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    aVar.onSuccess((UpiBaseDataModel) obj);
                }
            }, new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    aVar.onError((UpiCustomVolleyError) volleyError);
                }
            }, new CustProductList(), hashMap, ""));
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.onError(upiCustomVolleyError);
    }

    public final void a(final a.C1382a aVar, String str, final String str2, Map<String, String> map, Map<String, String> map2, final int i2, String str3) {
        a.C1382a aVar2 = aVar;
        String str4 = str2;
        int i3 = i2;
        if (UpiAppUtils.isNetworkAvailable(this.f67892a)) {
            new HashMap().put("screen_name", str3);
            final Map<String, String> map3 = map;
            final Map<String, String> map4 = map2;
            AnonymousClass28 r0 = new c(str2, new Response.Listener<String>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    String str = (String) obj;
                    PaytmLogs.i(net.one97.paytm.upi.registration.b.a.b.a.class.getSimpleName(), str);
                    g gVar = new g();
                    gVar.a(BaseUpiResponse.class, new BaseUpiDeserializer(i2));
                    try {
                        aVar.onSuccess((BaseUpiResponse) gVar.a().a(str, BaseUpiResponse.class));
                    } catch (u e2) {
                        e2.printStackTrace();
                        if (i2 == 13) {
                            CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f67892a, GAConstants.CATEGORY.UPI_ONB_V1, "va_availability_response_failure", "app_parse_error", "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        }
                        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                        upiCustomVolleyError.setAlertMessage(a.this.f67892a.getString(R.string.upi_some_went_wrong));
                        upiCustomVolleyError.setUrl(str2);
                        aVar.onError(upiCustomVolleyError);
                    }
                }
            }, new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    UpiCustomVolleyError upiCustomVolleyError = (UpiCustomVolleyError) volleyError;
                    PaytmLogs.e(a.class.getSimpleName(), upiCustomVolleyError.toString());
                    if (i2 == 13) {
                        CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f67892a, GAConstants.CATEGORY.UPI_ONB_V1, "va_availability_response_failure", upiCustomVolleyError.getmErrorCode(), "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                    }
                    upiCustomVolleyError.setAlertMessage("Time out Error");
                    upiCustomVolleyError.setUrl(str2);
                    aVar.onError(upiCustomVolleyError);
                }
            }) {
                public final Map<String, String> getParams() {
                    return map3;
                }

                public final Map<String, String> getHeaders() throws AuthFailureError {
                    return map4;
                }
            };
            PaytmLogs.d("[Request]", r0.toString());
            String str5 = str;
            r0.setTag(str);
            d.b(this.f67892a).add(r0);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.onError(upiCustomVolleyError);
    }

    public final void a(final a.C1382a aVar, String str, Map<String, String> map, Map<String, String> map2, UpiBaseDataModel upiBaseDataModel) {
        if (UpiAppUtils.isNetworkAvailable(this.f67892a)) {
            new f();
            String str2 = str;
            UpiBaseDataModel upiBaseDataModel2 = upiBaseDataModel;
            Map<String, String> map3 = map2;
            d.b(this.f67892a.getApplicationContext()).add(new net.one97.paytm.upi.g.b(str2, new Response.Listener<UpiBaseDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    aVar.onSuccess((UpiBaseDataModel) obj);
                }
            }, new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    aVar.onError((UpiCustomVolleyError) volleyError);
                }
            }, upiBaseDataModel2, UpiRequestBuilder.getCommonDeviceParams(this.f67892a), map3, new JSONObject(map).toString()));
        }
    }

    public final void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, UpiProfileDefaultBank upiProfileDefaultBank, String str12, boolean z, String str13, CommonPayParams commonPayParams, String str14, String str15) {
        String str16 = str;
        a(aVar, str2, UpiRequestBuilder.CommonPayVPA.getCommonPayVpaUrl(this.f67892a, true), UpiRequestBuilder.CommonPayVPA.getParamsForVPA(this.f67892a, str, str3, str4, str5, str6, str7, str8, str9, str10, str11, upiProfileDefaultBank, str12, z, commonPayParams, str14, str15), UpiRequestBuilder.getHeaders(this.f67892a), 24, str13);
    }

    public final void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, UpiProfileDefaultBank upiProfileDefaultBank, String str9, String str10, String str11) {
        a(aVar, str2, UpiRequestBuilder.CollectPayRequest.getCommonPayVpaUrl(this.f67892a), UpiRequestBuilder.CollectPayRequest.getParamsForCollectReqPay(this.f67892a, str, str3, str4, str5, str6, str7, upiProfileDefaultBank, str9, str8, str11), UpiRequestBuilder.getHeaders(this.f67892a), 24, str10);
    }

    public final void a(String str) {
        d.b(this.f67892a).cancelAll((Object) str);
        com.paytm.network.a aVar = this.f67894d;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap) {
        String str6 = str2;
        String addAuthDefaultParams = UpiAppUtils.addAuthDefaultParams(this.f67892a, UpiGTMLoader.getInstance().getUpiGatewayBaseUrl() + UpiGTMLoader.getInstance().getUpiCaptureEventApiUrl());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put(UpiConstants.CHANNEL_TOKEN, i.a().f66980a);
        hashMap2.put("channel", UpiRequestBuilder.PAYTM_CHANNEL);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("appVersion", UpiAppUtils.getAppVersionName(this.f67892a));
            jSONObject2.put("deviceId", UpiUtils.getDeviceId(this.f67892a));
            jSONObject2.put("appId", UpiUtils.getAppId(this.f67892a));
            jSONObject2.put("osVersion", UpiAppUtils.getOSVersion());
            jSONObject2.put("client", "androidapp");
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry next : hashMap.entrySet()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("paramName", next.getKey());
                jSONObject3.put("paramValue", next.getValue());
                jSONArray.put(jSONObject3);
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(CLConstants.FIELD_TXN_ID, str6);
            jSONObject4.put("txnAmount", str3);
            jSONObject4.put("deviceId", UpiUtils.getDeviceId(this.f67892a));
            jSONObject4.put("appId", UpiUtils.getAppId(this.f67892a));
            jSONObject4.put("mobileNumber", UpiUtils.getMobile(this.f67892a));
            jSONObject4.put(CLConstants.SALT_FIELD_PAYER_ADDR, str4);
            jSONObject4.put(CLConstants.SALT_FIELD_PAYEE_ADDR, str5);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("paramName", CLConstants.INPUT_KEY_SALT);
            jSONObject5.put("paramValue", jSONObject4);
            jSONArray.put(jSONObject5);
            jSONObject.put("respCode", str);
            jSONObject.put("txnId", str6);
            jSONObject.put("mobileNumber", UpiUtils.getMobile(this.f67892a));
            jSONObject.put("deviceInfo", jSONObject2);
            jSONObject.put("data", jSONArray);
        } catch (Exception unused) {
        }
        d.b(this.f67892a.getApplicationContext()).add(new net.one97.paytm.upi.g.b(addAuthDefaultParams, (Response.Listener<UpiBaseDataModel>) new Response.Listener<UpiBaseDataModel>() {
            public final /* bridge */ /* synthetic */ void onResponse(Object obj) {
            }
        }, (Response.ErrorListener) new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
            }
        }, (UpiBaseDataModel) new SetPrimaryVpaResponse(), UpiRequestBuilder.getCommonDeviceParams(this.f67892a), (Map<String, String>) hashMap2, jSONObject.toString(), (byte) 0));
    }

    public final void a(String str, HashMap<String, String> hashMap) {
        String addAuthDefaultParams = UpiAppUtils.addAuthDefaultParams(this.f67892a, UpiGTMLoader.getInstance().getUpiGatewayBaseUrl() + UpiGTMLoader.getInstance().getUpiCaptureEventApiUrl());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put(UpiConstants.CHANNEL_TOKEN, i.a().f66980a);
        hashMap2.put("channel", UpiRequestBuilder.PAYTM_CHANNEL);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("appVersion", UpiAppUtils.getAppVersionName(this.f67892a));
            jSONObject2.put("deviceId", UpiUtils.getDeviceId(this.f67892a));
            jSONObject2.put("appId", UpiUtils.getAppId(this.f67892a));
            jSONObject2.put("osVersion", UpiAppUtils.getOSVersion());
            jSONObject2.put("client", "androidapp");
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry next : hashMap.entrySet()) {
                jSONObject3.put((String) next.getKey(), next.getValue());
            }
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("paramName", "intent_flow_event");
            jSONObject4.put("paramValue", jSONObject3);
            jSONArray.put(jSONObject4);
            jSONObject.put("respCode", "intent");
            jSONObject.put("txnId", str);
            jSONObject.put("mobileNumber", UpiUtils.getMobile(this.f67892a));
            jSONObject.put("deviceInfo", jSONObject2);
            jSONObject.put("data", jSONArray);
        } catch (Exception unused) {
        }
        d.b(this.f67892a.getApplicationContext()).add(new net.one97.paytm.upi.g.b(addAuthDefaultParams, (Response.Listener<UpiBaseDataModel>) new Response.Listener<UpiBaseDataModel>() {
            public final /* bridge */ /* synthetic */ void onResponse(Object obj) {
            }
        }, (Response.ErrorListener) new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
            }
        }, (UpiBaseDataModel) new SetPrimaryVpaResponse(), UpiRequestBuilder.getCommonDeviceParams(this.f67892a), (Map<String, String>) hashMap2, jSONObject.toString(), (byte) 0));
    }

    public final void a(final a.c cVar) {
        UpiGTMLoader.getInstance().getPPBLBannerUrl();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        b postRequestCommonNetworkCallBuilder = ApiCallDataSource.postRequestCommonNetworkCallBuilder();
        postRequestCommonNetworkCallBuilder.f42882f = hashMap;
        postRequestCommonNetworkCallBuilder.f42880d = "https://storefront.paytm.com/v2/h/bank-linking-failure?client=android&version=" + UpiAppUtils.getAppVersionName(this.f67892a);
        postRequestCommonNetworkCallBuilder.f42885i = new CJRStoreFrontBanners();
        postRequestCommonNetworkCallBuilder.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof CJRStoreFrontBanners) {
                    cVar.a(iJRPaytmDataModel);
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                upiCustomVolleyError.setValue("");
                if (networkCustomError != null && networkCustomError.networkResponse != null && UpiUtils.isAuthenticationFailure(String.valueOf(networkCustomError.networkResponse.statusCode))) {
                    upiCustomVolleyError.setmErrorCode(UpiUtils.AUTHENTICATION_FAILURE_401);
                } else if (!TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                    upiCustomVolleyError.setAlertMessage(networkCustomError.getAlertMessage());
                }
                cVar.a(upiCustomVolleyError);
            }
        };
        postRequestCommonNetworkCallBuilder.l().a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(final a.C1382a aVar, final String str, final int i2) {
        b postRequestCommonNetworkCallBuilder = ApiCallDataSource.postRequestCommonNetworkCallBuilder();
        postRequestCommonNetworkCallBuilder.f42882f = UpiRequestBuilder.getHeadersWithApplicationJson(this.f67892a);
        postRequestCommonNetworkCallBuilder.f42880d = UpiRequestBuilder.CheckAccountBalance.getCheckAccountBalanceStatus(this.f67892a);
        postRequestCommonNetworkCallBuilder.f42884h = UpiRequestBuilder.CheckAccountBalance.getRequestBody(str, this.f67892a);
        postRequestCommonNetworkCallBuilder.f42885i = new CheckBalanceV4Response((UpiCheckBalanceModel) null, "", "", "");
        postRequestCommonNetworkCallBuilder.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof CheckBalanceV4Response) {
                    a.a(a.this, (CheckBalanceV4Response) iJRPaytmDataModel, aVar, str, i2 + 1);
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                if (!(networkCustomError == null || networkCustomError.networkResponse == null || !UpiUtils.isAuthenticationFailure(String.valueOf(networkCustomError.networkResponse.statusCode)))) {
                    upiCustomVolleyError.setmErrorCode(UpiUtils.AUTHENTICATION_FAILURE_401);
                }
                aVar.onError(upiCustomVolleyError);
            }
        };
        this.f67894d = postRequestCommonNetworkCallBuilder.l();
        this.f67894d.a();
    }

    static /* synthetic */ void a(a aVar, CheckBalanceV4Response checkBalanceV4Response, a.C1382a aVar2, String str, int i2) {
        if (checkBalanceV4Response.getStatus().equalsIgnoreCase("SUCCESS") && checkBalanceV4Response.getUserBalanceDetail() != null) {
            BaseUpiResponse baseUpiResponse = new BaseUpiResponse();
            baseUpiResponse.setSuccess(true);
            baseUpiResponse.setMobileAppData(checkBalanceV4Response.getUserBalanceDetail());
            baseUpiResponse.setResponse("0");
            aVar2.onSuccess(baseUpiResponse);
        } else if (checkBalanceV4Response.getResponseCode() == null || !checkBalanceV4Response.getResponseCode().equals("93")) {
            BaseUpiResponse baseUpiResponse2 = new BaseUpiResponse();
            baseUpiResponse2.setResponse(checkBalanceV4Response.getResponseCode());
            baseUpiResponse2.setSuccess(false);
            aVar2.onSuccess(baseUpiResponse2);
        } else {
            int[] iArr = aVar.f67893c;
            if (i2 == iArr.length) {
                BaseUpiResponse baseUpiResponse3 = new BaseUpiResponse();
                baseUpiResponse3.setResponse(checkBalanceV4Response.getResponseCode());
                baseUpiResponse3.setSuccess(false);
                aVar2.onSuccess(baseUpiResponse3);
                return;
            }
            aVar.f67895e.postDelayed(new Runnable(aVar2, str, i2) {
                private final /* synthetic */ a.C1382a f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ int f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    a.this.a(this.f$1, this.f$2, this.f$3);
                }
            }, (long) iArr[i2]);
        }
    }

    static /* synthetic */ void a(UpiProfileModel upiProfileModel) {
        if (upiProfileModel.getResponse() != null && upiProfileModel.getResponse().getProfileDetail() != null) {
            for (UpiProfileDefaultBank next : upiProfileModel.getResponse().getProfileDetail().getProfileVpaList()) {
                ArrayList<BankAccountDetails.BankAccount> bankAccountList = upiProfileModel.getResponse().getProfileDetail().getBankAccountList();
                if (!TextUtils.isEmpty(next.getDefaultDebitAccRefId()) && bankAccountList != null && bankAccountList.size() > 0) {
                    next.setDebitBank(a(next.getDefaultDebitAccRefId(), upiProfileModel.getResponse().getProfileDetail().getBankAccountList()));
                }
                if (!TextUtils.isEmpty(next.getDefaultCreditAccRefId()) && bankAccountList != null && bankAccountList.size() > 0) {
                    next.setCreditBank(a(next.getDefaultCreditAccRefId(), upiProfileModel.getResponse().getProfileDetail().getBankAccountList()));
                }
            }
        }
    }
}
