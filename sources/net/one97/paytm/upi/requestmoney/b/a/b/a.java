package net.one97.paytm.upi.requestmoney.b.a.b;

import android.content.Context;
import android.webkit.URLUtil;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.google.gson.u;
import com.paytm.network.model.CJRIllegalCodeError;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.ConsolidatePaymentInstrumentationRes;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.models.CJRAddBeneficiary;
import net.one97.paytm.upi.common.models.CJRKYCBeneficiaryBase;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.PendingRequestsV2;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.common.upi.ValidateVpaResponse;
import net.one97.paytm.upi.e;
import net.one97.paytm.upi.g.b;
import net.one97.paytm.upi.g.c;
import net.one97.paytm.upi.g.d;
import net.one97.paytm.upi.g.g;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.requestmoney.b.a.a;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class a implements net.one97.paytm.upi.requestmoney.b.a.a {

    /* renamed from: c  reason: collision with root package name */
    private static a f69122c;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f69123a = a.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f69124b;

    public final void a(UpiDBTransactionModel upiDBTransactionModel) {
    }

    public final void a(e eVar) {
    }

    public final boolean a() {
        return false;
    }

    private a(Context context) {
        this.f69124b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f69122c == null) {
                f69122c = new a(context);
            }
            aVar = f69122c;
        }
        return aVar;
    }

    public final void a(a.C1402a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        final a.C1402a aVar2 = aVar;
        if (UpiAppUtils.isNetworkAvailable(this.f69124b)) {
            new HashMap().put("screen_name", str10);
            String collectRequestUrl = UpiRequestBuilder.CollectRequest.getCollectRequestUrl(this.f69124b);
            AnonymousClass1 r3 = new Response.Listener<String>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    String str = (String) obj;
                    try {
                        PaytmLogs.i(a.this.f69123a, str);
                        aVar2.a((UpiBaseDataModel) (BaseUpiResponse) new f().a(str, BaseUpiResponse.class));
                    } catch (u e2) {
                        e2.printStackTrace();
                        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                        upiCustomVolleyError.setAlertMessage("Something went wrong.");
                        upiCustomVolleyError.setUrl(UpiRequestBuilder.CollectRequest.getCollectRequestUrl(a.this.f69124b));
                        aVar2.a(upiCustomVolleyError);
                    }
                }
            };
            AnonymousClass10 r4 = new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    UpiCustomVolleyError upiCustomVolleyError = (UpiCustomVolleyError) volleyError;
                    upiCustomVolleyError.setAlertMessage("Something went wrong.");
                    upiCustomVolleyError.setUrl(UpiRequestBuilder.CollectRequest.getCollectRequestUrl(a.this.f69124b));
                    aVar2.a(upiCustomVolleyError);
                }
            };
            g.d dVar = g.d.UPI;
            g.c cVar = g.c.USER_FACING;
            final String str11 = str2;
            final String str12 = str3;
            final String str13 = str4;
            final String str14 = str5;
            final String str15 = str6;
            final String str16 = str8;
            final String str17 = str7;
            final String str18 = str9;
            AnonymousClass11 r0 = new c(collectRequestUrl, r3, r4) {
                public final Map<String, String> getParams() {
                    return UpiRequestBuilder.CollectRequest.getParams(a.this.f69124b, str11, str12, str13, str14, str15, str16, str17, str18);
                }

                public final Map<String, String> getHeaders() throws AuthFailureError {
                    return UpiRequestBuilder.getHeaders(a.this.f69124b);
                }
            };
            PaytmLogs.d("[Request]", r0.toString());
            r0.setTag(str);
            d.b(this.f69124b).add(r0);
        }
    }

    public final void a(final a.C1402a aVar, String str, String str2) {
        net.one97.paytm.upi.profile.b.b.a.a(this.f69124b).a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                aVar.a(upiBaseDataModel);
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                aVar.a(upiCustomVolleyError);
            }
        }, str, str2);
    }

    public final void a(final a.C1402a aVar, String str, String str2, String str3, String str4) {
        if (UpiAppUtils.isNetworkAvailable(this.f69124b)) {
            new HashMap().put("screen_name", str4);
            String validateAddressUrl = UpiRequestBuilder.ValidateAddress.getValidateAddressUrl(this.f69124b);
            AnonymousClass13 r5 = new Response.Listener<String>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    String str = (String) obj;
                    try {
                        PaytmLogs.i(a.this.f69123a, str);
                        aVar.a((UpiBaseDataModel) (BaseUpiResponse) new f().a(str, BaseUpiResponse.class));
                    } catch (u unused) {
                        BaseUpiResponse baseUpiResponse = new BaseUpiResponse();
                        baseUpiResponse.setSuccess(false);
                        baseUpiResponse.setResponse("");
                        aVar.a((UpiBaseDataModel) baseUpiResponse);
                    }
                }
            };
            AnonymousClass14 r6 = new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    BaseUpiResponse baseUpiResponse = new BaseUpiResponse();
                    baseUpiResponse.setSuccess(false);
                    baseUpiResponse.setResponse(((UpiCustomVolleyError) volleyError).getmErrorCode());
                    aVar.a((UpiBaseDataModel) baseUpiResponse);
                }
            };
            g.d dVar = g.d.UPI;
            g.c cVar = g.c.USER_FACING;
            final String str5 = str2;
            final String str6 = str3;
            AnonymousClass15 r2 = new c(validateAddressUrl, r5, r6) {
                public final Map<String, String> getParams() {
                    return UpiRequestBuilder.ValidateAddress.getParams(a.this.f69124b, str5, str6);
                }

                public final Map<String, String> getHeaders() throws AuthFailureError {
                    return UpiRequestBuilder.getHeaders(a.this.f69124b);
                }
            };
            PaytmLogs.d("[Request]", r2.toString());
            r2.setTag(str);
            d.b(this.f69124b).add(r2);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setAlertMessage("Something went wrong.");
        upiCustomVolleyError.setUrl(UpiRequestBuilder.ValidateAddress.getValidateAddressUrl(this.f69124b));
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.a((UpiCustomVolleyError) null);
    }

    public final void b(final a.C1402a aVar, String str, String str2, String str3, String str4) {
        String validateAddressV2Url = UpiRequestBuilder.ValidateAddressV2.getValidateAddressV2Url(this.f69124b);
        Map<String, String> params = UpiRequestBuilder.ValidateAddressV2.getParams(this.f69124b, str2, str3);
        Map<String, String> headersWithApplicationJson = UpiRequestBuilder.getHeadersWithApplicationJson(this.f69124b);
        ValidateVpaResponse validateVpaResponse = new ValidateVpaResponse();
        if (UpiAppUtils.isNetworkAvailable(this.f69124b)) {
            new f();
            d.b(this.f69124b.getApplicationContext()).add(new b(validateAddressV2Url, new Response.Listener<UpiBaseDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    aVar.a((UpiBaseDataModel) obj);
                }
            }, new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    aVar.a((UpiCustomVolleyError) volleyError);
                }
            }, validateVpaResponse, UpiRequestBuilder.getCommonDeviceParams(this.f69124b), headersWithApplicationJson, new JSONObject(params).toString()));
        }
    }

    public final void a(String str) {
        d.b(this.f69124b).cancelAll((Object) str);
    }

    public final void a(final a.C1402a aVar, String str) {
        if (UpiAppUtils.isNetworkAvailable(this.f69124b)) {
            d.b(this.f69124b).add(new net.one97.paytm.upi.g.a(UpiAppUtils.getConsolidatePaymentInstUrl(new Object[0]), new Response.Listener<UpiBaseDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    UpiBaseDataModel upiBaseDataModel = (UpiBaseDataModel) obj;
                    if (upiBaseDataModel instanceof ConsolidatePaymentInstrumentationRes) {
                        aVar.a((UpiBaseDataModel) (ConsolidatePaymentInstrumentationRes) upiBaseDataModel);
                        return;
                    }
                    aVar.a((UpiCustomVolleyError) null);
                }
            }, new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError((Throwable) volleyError);
                    if (volleyError.getMessage() != null) {
                        CJRIllegalCodeError cJRIllegalCodeError = (CJRIllegalCodeError) new com.google.gsonhtcfix.f().a(volleyError.getMessage(), new CJRIllegalCodeError().getClass());
                        if (!(cJRIllegalCodeError == null || cJRIllegalCodeError.getErrorCode() == null)) {
                            upiCustomVolleyError.setmErrorCode(cJRIllegalCodeError.getErrorCode());
                        }
                    }
                    aVar.a(upiCustomVolleyError);
                }
            }, new ConsolidatePaymentInstrumentationRes(), UpiAppUtils.getConsolidatePaymentInstHeader(this.f69124b, str)));
            return;
        }
        aVar.a((UpiCustomVolleyError) null);
        Context context = this.f69124b;
        CustomDialog.showAlert(context, context.getResources().getString(R.string.no_connection), this.f69124b.getResources().getString(R.string.no_internet));
    }

    public final void a(final a.C1402a aVar, String str, int i2, String str2) {
        if (!UpiAppUtils.isNetworkAvailable(this.f69124b) || this.f69124b != null) {
            String str3 = UpiGTMLoader.getInstance().getUpiGatewayBaseUrl() + UpiGTMLoader.getInstance().getUpiRequestMoneyPendingRequestUrl();
            if (URLUtil.isValidUrl(str3)) {
                Map<String, String> headersWithApplicationJson = UpiRequestBuilder.getHeadersWithApplicationJson(this.f69124b);
                headersWithApplicationJson.put(UpiConstants.PENDING_REQUEST_CUST_ID, str2);
                d.b(this.f69124b).add(new b(str3, new Response.Listener<UpiBaseDataModel>() {
                    public final /* synthetic */ void onResponse(Object obj) {
                        aVar.a((UpiBaseDataModel) obj);
                    }
                }, new Response.ErrorListener() {
                    public final void onErrorResponse(VolleyError volleyError) {
                        aVar.a((UpiCustomVolleyError) volleyError);
                    }
                }, new PendingRequestsV2(), (Map<String, String>) null, headersWithApplicationJson, (String) null));
            }
        }
    }

    public final void a(final a.C1402a aVar, String str, String str2, boolean z) {
        if (this.f69124b != null) {
            String deleteBeneficiaryURL = UpiGTMLoader.getInstance().deleteBeneficiaryURL();
            if (URLUtil.isValidUrl(deleteBeneficiaryURL)) {
                String addAuthDefaultParams = UpiAppUtils.addAuthDefaultParams(this.f69124b, deleteBeneficiaryURL);
                HashMap hashMap = new HashMap();
                hashMap.put("session_token", i.a().f66980a);
                hashMap.put("Content-Type", "application/json");
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject4 = new JSONObject();
                try {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("status", StringSet.deleted);
                    jSONObject4.put("settings", jSONObject5);
                    jSONObject4.put("uuid", str);
                    jSONArray2.put(jSONObject4);
                    jSONObject3.put("accounts", jSONArray2);
                    if (z) {
                        jSONObject2.put("upi", jSONObject3);
                    } else {
                        jSONObject2.put("otherBank", jSONObject3);
                    }
                    jSONObject.put("instrumentPreferences", jSONObject2);
                    jSONObject.put("beneficiaryId", str2);
                    jSONArray.put(jSONObject);
                } catch (Exception unused) {
                }
                d.b(this.f69124b.getApplicationContext()).add(new b(addAuthDefaultParams, (Response.Listener<UpiBaseDataModel>) new Response.Listener<UpiBaseDataModel>() {
                    public final /* synthetic */ void onResponse(Object obj) {
                        aVar.a((UpiBaseDataModel) obj);
                    }
                }, (Response.ErrorListener) new Response.ErrorListener() {
                    public final void onErrorResponse(VolleyError volleyError) {
                        aVar.a((UpiCustomVolleyError) volleyError);
                    }
                }, (UpiBaseDataModel) new CJRAddBeneficiary(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONArray.toString(), (byte) 0));
            }
        }
    }

    public final void a(final a.C1402a aVar, a.b bVar, int i2, int i3) {
        if (!UpiAppUtils.isNetworkAvailable(this.f69124b)) {
            bVar.a();
        } else if (this.f69124b != null) {
            String beneficiaryURLV4 = UpiGTMLoader.getInstance().getBeneficiaryURLV4();
            if (URLUtil.isValidUrl(beneficiaryURLV4)) {
                HashMap hashMap = new HashMap();
                hashMap.put("session_token", i.a().f66980a);
                d.b(this.f69124b).add(new net.one97.paytm.upi.g.a(UpiAppUtils.addAuthDefaultParams(this.f69124b, beneficiaryURLV4) + "&offset=" + i2 + "&limit=" + i3 + "&type=upi", new Response.Listener<UpiBaseDataModel>() {
                    public final /* synthetic */ void onResponse(Object obj) {
                        UpiBaseDataModel upiBaseDataModel = (UpiBaseDataModel) obj;
                        if (upiBaseDataModel == null || !(upiBaseDataModel instanceof CJRKYCBeneficiaryBase)) {
                            aVar.a((UpiCustomVolleyError) new VolleyError());
                            return;
                        }
                        aVar.a(upiBaseDataModel);
                    }
                }, new Response.ErrorListener() {
                    public final void onErrorResponse(VolleyError volleyError) {
                        aVar.a((UpiCustomVolleyError) volleyError);
                    }
                }, new CJRKYCBeneficiaryBase(), hashMap));
            }
        }
    }
}
