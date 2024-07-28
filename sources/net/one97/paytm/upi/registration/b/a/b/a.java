package net.one97.paytm.upi.registration.b.a.b;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.google.gson.g;
import com.google.gson.u;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.a.c;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.UpiInitiateSmsV3Response;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.common.models.UpiExpireSmsTokenModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.ReferralCodeResponse;
import net.one97.paytm.upi.common.upi.UpiCreateProfileResponse;
import net.one97.paytm.upi.common.upi.UpiProfileBaseResponseModel;
import net.one97.paytm.upi.common.upi.UpiToken;
import net.one97.paytm.upi.deserializer.BaseUpiDeserializer;
import net.one97.paytm.upi.g.b;
import net.one97.paytm.upi.g.c;
import net.one97.paytm.upi.g.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.registration.a.d;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.ApiCallDataSource;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements net.one97.paytm.upi.registration.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    private static a f68436a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f68437b = a.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f68438c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f68439d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f68440e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f68441f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f68442g = false;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f68443h = false;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f68444i = false;

    public final String a() {
        return null;
    }

    public final void a(String str) {
    }

    public final void a(List<AccountProviderBody.AccountProvider> list) {
    }

    public final void a(d.a aVar, net.one97.paytm.upi.h.a aVar2, String str) {
    }

    public final void a(boolean z) {
    }

    public final String b() {
        return null;
    }

    public final void b(String str) {
    }

    public final void b(d.a aVar, net.one97.paytm.upi.h.a aVar2, String str) {
    }

    public final void b(boolean z) {
    }

    public final void c(boolean z) {
    }

    public final boolean c() {
        return true;
    }

    public final void d(boolean z) {
    }

    public final void e(boolean z) {
    }

    public final boolean e() {
        return false;
    }

    public final boolean f() {
        return false;
    }

    public final boolean g() {
        return false;
    }

    public final boolean h() {
        return false;
    }

    public final boolean i() {
        return false;
    }

    public final void j() {
    }

    public final List<AccountProviderBody.AccountProvider> k() {
        return null;
    }

    public final Map<String, AccountProviderBody.AccountProvider> l() {
        return null;
    }

    public final void m() {
    }

    public final String n() {
        return "false";
    }

    private a(Context context) {
        this.f68438c = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f68436a == null) {
                f68436a = new a(context);
            }
            aVar = f68436a;
        }
        return aVar;
    }

    public final void a(final a.C1389a aVar, String str, String str2) {
        if (UpiAppUtils.isNetworkAvailable(this.f68438c)) {
            new HashMap().put("screen_name", str2);
            String accountProviderUrl = UpiRequestBuilder.AccountProviderRequest.getAccountProviderUrl(this.f68438c);
            AnonymousClass1 r1 = new Response.Listener<String>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    String str = (String) obj;
                    PaytmLogs.i(a.this.f68437b, str);
                    g gVar = new g();
                    gVar.a(BaseUpiResponse.class, new BaseUpiDeserializer(12));
                    try {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) gVar.a().a(str, BaseUpiResponse.class);
                        if (baseUpiResponse.getMobileAppData() instanceof AccountProviderBody.AccountProviderDetails) {
                            aVar.onSuccess((AccountProviderBody.AccountProviderDetails) baseUpiResponse.getMobileAppData());
                            return;
                        }
                        aVar.onError(new net.one97.paytm.upi.registration.b.a());
                    } catch (u e2) {
                        e2.printStackTrace();
                        aVar.onError(new net.one97.paytm.upi.registration.b.a());
                    }
                }
            };
            AnonymousClass11 r2 = new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    PaytmLogs.e(a.this.f68437b, volleyError.toString());
                    aVar.onError((UpiCustomVolleyError) volleyError);
                }
            };
            g.d dVar = g.d.UPI;
            g.c cVar = g.c.USER_FACING;
            AnonymousClass20 r6 = new c(accountProviderUrl, r1, r2) {
                public final Map<String, String> getParams() {
                    return UpiRequestBuilder.AccountProviderRequest.getParams(a.this.f68438c);
                }

                public final Map<String, String> getHeaders() throws AuthFailureError {
                    return UpiRequestBuilder.getHeaders(a.this.f68438c);
                }
            };
            PaytmLogs.d("[Request]", r6.toString());
            r6.setTag(str);
            net.one97.paytm.upi.g.d.b(this.f68438c).add(r6);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setAlertMessage(this.f68438c.getString(R.string.network_error_message));
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.onError(upiCustomVolleyError);
    }

    public final void d() {
        this.f68439d = 0;
    }

    public final void a(a.C1389a aVar, String str, String str2, HashMap<String, String> hashMap, String str3) {
        HashMap<String, String> hashMap2 = hashMap;
        if (TextUtils.isEmpty(this.f68440e)) {
            Iterator<String> it2 = hashMap.keySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String next = it2.next();
                if (next.equalsIgnoreCase("carrier")) {
                    this.f68440e = hashMap2.get(next);
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(this.f68441f)) {
            Iterator<String> it3 = hashMap.keySet().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                String next2 = it3.next();
                if (next2.equalsIgnoreCase("vmn")) {
                    this.f68441f = hashMap2.get(next2);
                    break;
                }
            }
        }
        new HashMap().put("screen_name", str3);
        String deviceBindingV2Url = UpiRequestBuilder.DeviceBindingV2Request.getDeviceBindingV2Url(this.f68438c);
        Context context = this.f68438c;
        final a.C1389a aVar2 = aVar;
        final String str4 = str;
        final String str5 = str2;
        final HashMap<String, String> hashMap3 = hashMap;
        final String str6 = str3;
        AnonymousClass24 r0 = new Response.Listener<String>() {
            public final /* synthetic */ void onResponse(Object obj) {
                ArrayList arrayList;
                String str = (String) obj;
                PaytmLogs.i(a.this.f68437b, str);
                int c2 = a.this.f68439d - 1;
                int i2 = c2 <= 5 ? c2 * 3 : ((c2 - 5) * 5) + 15;
                String string = a.this.f68438c.getString(R.string.upi_some_went_wrong);
                com.google.gson.g gVar = new com.google.gson.g();
                gVar.a(BaseUpiResponse.class, new BaseUpiDeserializer(33));
                try {
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) gVar.a().a(str, BaseUpiResponse.class);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add("failed_attempts=" + c2 + ";time=" + i2);
                    arrayList2.add("sms_operator=" + a.this.f68440e + ";vmn=" + a.this.f68441f);
                    arrayList2.add(baseUpiResponse.getResponse());
                    if (baseUpiResponse.isSuccess()) {
                        if (!"0".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                            if (!"INT-1222".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                                if (a.this.f68439d >= 27) {
                                    CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_poll_failure", arrayList2, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                                    UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                                    upiCustomVolleyError.setAlertMessage(baseUpiResponse.getMessage());
                                    upiCustomVolleyError.setUrl(UpiRequestBuilder.DeviceBindingV2Request.getDeviceBindingV2Url(a.this.f68438c));
                                    aVar2.onError(upiCustomVolleyError);
                                    return;
                                } else if (a.this.f68439d <= 5) {
                                    new Handler().postDelayed(new Runnable() {
                                        public final void run() {
                                            a.this.a(aVar2, str4, str5, (HashMap<String, String>) hashMap3, str6);
                                        }
                                    }, 3000);
                                    return;
                                } else if (a.this.f68439d < 27) {
                                    new Handler().postDelayed(new Runnable() {
                                        public final void run() {
                                            a.this.a(aVar2, str4, str5, (HashMap<String, String>) hashMap3, str6);
                                        }
                                    }, 5000);
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                        boolean unused = a.this.f68444i = true;
                        if (!a.this.f68442g || a.this.f68443h) {
                            arrayList = arrayList2;
                        } else {
                            boolean unused2 = a.this.f68443h = true;
                            arrayList = arrayList2;
                            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_poll_connection_successful_first_time", arrayList2, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        }
                        CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_poll_success", arrayList, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        aVar2.onSuccess(baseUpiResponse);
                        return;
                    }
                    ArrayList arrayList3 = arrayList2;
                    if ("1005".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                        if (TextUtils.isEmpty(a.this.f68440e)) {
                            String unused3 = a.this.f68440e = "";
                        }
                        boolean unused4 = a.this.f68444i = true;
                        if (a.this.f68442g && !a.this.f68443h) {
                            boolean unused5 = a.this.f68443h = true;
                            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_poll_connection_successful_first_time", arrayList3, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        }
                        CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_poll_success", arrayList3, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        aVar2.onSuccess(baseUpiResponse);
                    } else if ("1001".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                        CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_poll_failure", arrayList3, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        aVar2.onSuccess(baseUpiResponse);
                    } else {
                        if (!"INT-1621".equalsIgnoreCase(baseUpiResponse.getResponse()) && !"INT-1622".equalsIgnoreCase(baseUpiResponse.getResponse()) && !"INT-1234".equalsIgnoreCase(baseUpiResponse.getResponse()) && !"INT-1228".equalsIgnoreCase(baseUpiResponse.getResponse()) && !"INT-1232".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                            if (!"INT-1233".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                                if (!"1004".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                                    CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_poll_failure", arrayList3, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                                    UpiCustomVolleyError upiCustomVolleyError2 = new UpiCustomVolleyError();
                                    upiCustomVolleyError2.setAlertMessage(baseUpiResponse.getMessage());
                                    upiCustomVolleyError2.setUrl(UpiRequestBuilder.DeviceBindingV2Request.getDeviceBindingV2Url(a.this.f68438c));
                                    aVar2.onError(upiCustomVolleyError2);
                                    return;
                                } else if (a.this.f68439d >= 27) {
                                    CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_poll_failure", arrayList3, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                                    aVar2.onSuccess(baseUpiResponse);
                                    return;
                                } else if (a.this.f68439d <= 5) {
                                    new Handler().postDelayed(new Runnable() {
                                        public final void run() {
                                            a.this.a(aVar2, str4, str5, (HashMap<String, String>) hashMap3, str6);
                                        }
                                    }, 3000);
                                    return;
                                } else if (a.this.f68439d < 27) {
                                    new Handler().postDelayed(new Runnable() {
                                        public final void run() {
                                            a.this.a(aVar2, str4, str5, (HashMap<String, String>) hashMap3, str6);
                                        }
                                    }, 5000);
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                        CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_poll_failure", arrayList3, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        aVar2.onSuccess(baseUpiResponse);
                    }
                } catch (u e2) {
                    PaytmLogs.e(a.this.f68437b, e2.getMessage());
                    ArrayList arrayList4 = new ArrayList();
                    arrayList4.add("failed_attempts=" + c2 + ";time=" + i2);
                    StringBuilder sb = new StringBuilder("sms_operator=");
                    sb.append(a.this.f68440e);
                    arrayList4.add(sb.toString());
                    CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_poll_failure", arrayList4, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                    UpiCustomVolleyError upiCustomVolleyError3 = new UpiCustomVolleyError();
                    upiCustomVolleyError3.setAlertMessage(string);
                    upiCustomVolleyError3.setUrl(UpiRequestBuilder.DeviceBindingV2Request.getDeviceBindingV2Url(a.this.f68438c));
                    aVar2.onError(upiCustomVolleyError3);
                }
            }
        };
        AnonymousClass25 r02 = new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
                UpiCustomVolleyError upiCustomVolleyError = (UpiCustomVolleyError) volleyError;
                int c2 = a.this.f68439d - 1;
                int i2 = c2 <= 5 ? c2 * 3 : ((c2 - 5) * 5) + 15;
                if (!a.this.f68442g) {
                    boolean unused = a.this.f68442g = true;
                    CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_poll_connection_timeout_first_time", "", "sms_operator=" + a.this.f68440e + ";vmn=" + a.this.f68441f, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                }
                if (a.this.f68439d >= 27) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("failed_attempts=" + c2 + ";time=" + i2);
                    StringBuilder sb = new StringBuilder("sms_operator=");
                    sb.append(a.this.f68440e);
                    arrayList.add(sb.toString());
                    arrayList.add(upiCustomVolleyError.getmErrorCode());
                    CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_poll_failure", arrayList, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                    upiCustomVolleyError.setUrl(UpiRequestBuilder.DeviceBindingV2Request.getDeviceBindingV2Url(a.this.f68438c));
                    aVar2.onError(upiCustomVolleyError);
                } else if (a.this.f68439d <= 5) {
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            a.this.a(aVar2, str4, str5, (HashMap<String, String>) hashMap3, str6);
                        }
                    }, 3000);
                } else if (a.this.f68439d < 27) {
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            a.this.a(aVar2, str4, str5, (HashMap<String, String>) hashMap3, str6);
                        }
                    }, 5000);
                }
            }
        };
        g.d dVar = g.d.UPI;
        g.c cVar = g.c.USER_FACING;
        final HashMap<String, String> hashMap4 = hashMap;
        final String str7 = str2;
        AnonymousClass26 r03 = new c(context, deviceBindingV2Url, r0, r02) {
            public final Map<String, String> getParams() {
                HashMap hashMap = hashMap4;
                StringBuilder sb = new StringBuilder();
                sb.append(a.this.f68439d);
                hashMap.put("pollIteration", sb.toString());
                hashMap4.put("simCount", String.valueOf(UpiGTMLoader.getInstance().doSendUpiSmsFromBothSim() ? 2 : 1));
                com.paytm.b.a.a pref = PaytmUpiPrefUtil.getPref(a.this.f68438c.getApplicationContext());
                if (pref.b(UpiConstants.PREF_KEY_IS_PROFILE_EXIST, false, true)) {
                    HashMap hashMap2 = hashMap4;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(pref.b(UpiConstants.PREF_KEY_IS_PROFILE_EXIST, false, true));
                    hashMap2.put("restore-old-upiprofile", sb2.toString());
                }
                return UpiRequestBuilder.DeviceBindingV2Request.getParams(a.this.f68438c, str7, hashMap4);
            }

            public final Map<String, String> getHeaders() throws AuthFailureError {
                return UpiRequestBuilder.getHeaders(a.this.f68438c);
            }
        };
        this.f68439d++;
        if (this.f68439d == 1) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_poll_connection_initiated_first_time", "", "sms_operator=" + this.f68440e + ";vmn=" + this.f68441f, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
        }
        PaytmLogs.d("[Request]", r03.toString());
        r03.setTag(str);
        net.one97.paytm.upi.g.d.b(this.f68438c).add(r03);
    }

    public final void a(String str, String str2, final a.C1389a aVar, String str3, String str4) {
        if (UpiAppUtils.isNetworkAvailable(this.f68438c)) {
            new HashMap().put("screen_name", str4);
            String getTokenUrl = UpiRequestBuilder.GetTokenRequest.getGetTokenUrl(this.f68438c);
            AnonymousClass27 r5 = new Response.Listener<String>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    String str = (String) obj;
                    PaytmLogs.i(a.this.f68437b, str);
                    a.a(a.this, aVar, str);
                }
            };
            AnonymousClass28 r6 = new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    UpiCustomVolleyError upiCustomVolleyError = (UpiCustomVolleyError) volleyError;
                    PaytmLogs.e(a.this.f68437b, upiCustomVolleyError.toString());
                    Context b2 = a.this.f68438c;
                    String str = upiCustomVolleyError.getmErrorCode();
                    CJRSendGTMTag.sendNewCustomGTMEvents(b2, GAConstants.CATEGORY.UPI_ONB_V1, "get_token_response_failure", str, "vmn=" + a.this.f68441f, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                    upiCustomVolleyError.setUrl(UpiRequestBuilder.GetTokenRequest.getGetTokenUrl(a.this.f68438c));
                    aVar.onError(upiCustomVolleyError);
                }
            };
            g.d dVar = g.d.UPI;
            g.c cVar = g.c.SILENT;
            final String str5 = str;
            final String str6 = str2;
            AnonymousClass29 r2 = new c(getTokenUrl, r5, r6) {
                public final Map<String, String> getParams() {
                    return UpiRequestBuilder.GetTokenRequest.getParams(a.this.f68438c, str5, str6);
                }

                public final Map<String, String> getHeaders() throws AuthFailureError {
                    return UpiRequestBuilder.getHeaders(a.this.f68438c);
                }

                public final Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
                    return super.setRetryPolicy(new DefaultRetryPolicy(60000, UpiGTMLoader.getInstance().getUpiTokenRetryCount(), 1.0f));
                }
            };
            PaytmLogs.d("[Request]", r2.toString());
            r2.setTag(str3);
            net.one97.paytm.upi.g.d.b(this.f68438c).add(r2);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setUrl(UpiRequestBuilder.GetTokenRequest.getGetTokenUrl(this.f68438c));
        upiCustomVolleyError.setAlertMessage(this.f68438c.getString(R.string.network_error_message));
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.onError(upiCustomVolleyError);
    }

    public final void b(final a.C1389a aVar, String str, String str2) {
        if (UpiAppUtils.isNetworkAvailable(this.f68438c)) {
            i.a();
            new HashMap().put("screen_name", str2);
            String listKeysUrl = UpiRequestBuilder.ListKeys.getListKeysUrl(this.f68438c);
            AnonymousClass2 r1 = new Response.Listener<String>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    String str = (String) obj;
                    PaytmLogs.i(a.this.f68437b, str);
                    a.this.f68438c.getString(R.string.upi_some_went_wrong);
                    try {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) new f().a(str, BaseUpiResponse.class);
                        if (!baseUpiResponse.isSuccess()) {
                            UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                            upiCustomVolleyError.setAlertMessage(baseUpiResponse.getMessage());
                            upiCustomVolleyError.setmAlertTitle(baseUpiResponse.getResponse());
                            upiCustomVolleyError.setmErrorCode(baseUpiResponse.getResponse());
                            upiCustomVolleyError.setUrl(UpiRequestBuilder.ListKeys.getListKeysUrl(a.this.f68438c));
                            aVar.onError(upiCustomVolleyError);
                        } else if ("0".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                            aVar.onSuccess(baseUpiResponse);
                        } else {
                            UpiCustomVolleyError upiCustomVolleyError2 = new UpiCustomVolleyError();
                            upiCustomVolleyError2.setAlertMessage(baseUpiResponse.getMessage());
                            upiCustomVolleyError2.setmErrorCode(baseUpiResponse.getResponse());
                            upiCustomVolleyError2.setUrl(UpiRequestBuilder.ListKeys.getListKeysUrl(a.this.f68438c));
                            aVar.onError(upiCustomVolleyError2);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        UpiCustomVolleyError upiCustomVolleyError3 = new UpiCustomVolleyError();
                        upiCustomVolleyError3.setAlertMessage("JsonSyntax Exception");
                        upiCustomVolleyError3.setUrl(UpiRequestBuilder.ListKeys.getListKeysUrl(a.this.f68438c));
                        aVar.onError(upiCustomVolleyError3);
                    }
                }
            };
            AnonymousClass3 r2 = new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    UpiCustomVolleyError upiCustomVolleyError = (UpiCustomVolleyError) volleyError;
                    PaytmLogs.e(a.this.f68437b, upiCustomVolleyError.toString());
                    upiCustomVolleyError.setUrl(UpiRequestBuilder.ListKeys.getListKeysUrl(a.this.f68438c));
                    aVar.onError(upiCustomVolleyError);
                }
            };
            g.d dVar = g.d.UPI;
            g.c cVar = g.c.SILENT;
            AnonymousClass4 r6 = new c(listKeysUrl, r1, r2) {
                public final Map<String, String> getParams() {
                    return UpiRequestBuilder.ListKeys.getParams(a.this.f68438c);
                }

                public final Map<String, String> getHeaders() throws AuthFailureError {
                    return UpiRequestBuilder.getHeaders(a.this.f68438c);
                }
            };
            PaytmLogs.d("[Request]", r6.toString());
            r6.setTag(str);
            net.one97.paytm.upi.g.d.b(this.f68438c).add(r6);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setUrl(UpiRequestBuilder.ListKeys.getListKeysUrl(this.f68438c));
        upiCustomVolleyError.setAlertMessage(this.f68438c.getString(R.string.network_error_message));
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.onError(upiCustomVolleyError);
    }

    public final void b(final a.C1389a aVar, String str) {
        String str2;
        if (UpiAppUtils.isNetworkAvailable(this.f68438c)) {
            String str3 = UpiAppUtils.addAuthDefaultParams(this.f68438c, UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getSetUpProfileUrl()) + "&requestId=" + UpiUtils.getUpiSequenceNo();
            Map<String, String> headersWithApplicationJson = UpiRequestBuilder.getHeadersWithApplicationJson(this.f68438c);
            JSONObject jSONObject = new JSONObject();
            try {
                if (i.a().f66982c == null) {
                    str2 = "xyz@xyz.com";
                } else {
                    str2 = i.a().f66982c;
                }
                jSONObject.put("customer-email-id", str2);
                jSONObject.put("mobile", UpiUtils.getMobile(this.f68438c));
                boolean f2 = net.one97.paytm.upi.g.a(net.one97.paytm.upi.h.a.a(net.one97.paytm.upi.g.d(), (a.C1347a) null)).f();
                if (f2) {
                    jSONObject.put("restore-old-upiprofile", String.valueOf(f2));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            net.one97.paytm.upi.g.d.b(this.f68438c.getApplicationContext()).add(new b(str3, (Response.Listener<UpiBaseDataModel>) new Response.Listener<UpiBaseDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    aVar.onSuccess((UpiBaseDataModel) obj);
                }
            }, (Response.ErrorListener) new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    aVar.onError((UpiCustomVolleyError) volleyError);
                }
            }, (UpiBaseDataModel) new UpiProfileBaseResponseModel(), (Map<String, String>) null, headersWithApplicationJson, jSONObject.toString(), (byte) 0)).setTag(str);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.onError(upiCustomVolleyError);
    }

    public final void c(final a.C1389a aVar, String str) {
        String str2;
        if (UpiAppUtils.isNetworkAvailable(this.f68438c)) {
            String str3 = UpiAppUtils.addAuthDefaultParams(this.f68438c, UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getSetUpProfileUrl()) + "&requestId=" + UpiUtils.getUpiSequenceNo();
            Map<String, String> headersWithApplicationJson = UpiRequestBuilder.getHeadersWithApplicationJson(this.f68438c);
            JSONObject jSONObject = new JSONObject();
            try {
                if (i.a().f66982c == null) {
                    str2 = "xyz@xyz.com";
                } else {
                    str2 = i.a().f66982c;
                }
                jSONObject.put("customer-email-id", str2);
                jSONObject.put("mobile", UpiUtils.getMobile(this.f68438c));
                jSONObject.put("fetchAccounts", true);
                boolean f2 = net.one97.paytm.upi.g.a(net.one97.paytm.upi.h.a.a(net.one97.paytm.upi.g.d(), (a.C1347a) null)).f();
                if (f2) {
                    jSONObject.put("restore-old-upiprofile", String.valueOf(f2));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            net.one97.paytm.upi.g.d.b(this.f68438c.getApplicationContext()).add(new b(str3, (Response.Listener<UpiBaseDataModel>) new Response.Listener<UpiBaseDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    aVar.onSuccess((UpiBaseDataModel) obj);
                }
            }, (Response.ErrorListener) new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    aVar.onError((UpiCustomVolleyError) volleyError);
                }
            }, (UpiBaseDataModel) new UpiProfileBaseResponseModel(), (Map<String, String>) null, headersWithApplicationJson, jSONObject.toString(), (byte) 0)).setTag(str);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.onError(upiCustomVolleyError);
    }

    public final void c(final a.C1389a aVar, String str, String str2) {
        String str3 = UpiAppUtils.addAuthDefaultParams(this.f68438c, UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiAvailabilityUrlV2()) + "&requestId=" + UpiUtils.getUpiSequenceNo();
        if (UpiAppUtils.isNetworkAvailable(this.f68438c)) {
            Map<String, String> headersWithApplicationJson = UpiRequestBuilder.getHeadersWithApplicationJson(this.f68438c);
            new HashMap().put("screen_name", str2);
            net.one97.paytm.upi.g.a aVar2 = new net.one97.paytm.upi.g.a(str3, new Response.Listener<UpiBaseDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    aVar.onSuccess((UpiBaseDataModel) obj);
                }
            }, new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    aVar.onError((UpiCustomVolleyError) volleyError);
                }
            }, new UpiAvailabilityModel(), headersWithApplicationJson);
            aVar2.setTag(str);
            net.one97.paytm.upi.g.d.a(aVar2);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setUrl(str3);
        upiCustomVolleyError.setAlertMessage(this.f68438c.getString(R.string.network_error_message));
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.onError(upiCustomVolleyError);
    }

    public final void c(String str) {
        if (!this.f68444i && this.f68439d < 27 && "RegistrationProgressPresenter".equalsIgnoreCase(str)) {
            int i2 = this.f68439d - 1;
            int i3 = i2 <= 5 ? i2 * 3 : ((i2 - 5) * 5) + 15;
            ArrayList arrayList = new ArrayList();
            arrayList.add("failed_attempts=" + i2 + ";time=" + i3);
            arrayList.add("sms_operator=" + this.f68440e + ";vmn=" + this.f68441f);
            arrayList.add("user_aborted_error");
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_sms_poll_aborted", arrayList, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
        }
        net.one97.paytm.upi.g.d.b(this.f68438c).cancelAll((Object) str);
    }

    public final void a(final a.C1389a aVar, String str, String str2, boolean z, String str3, String str4) {
        String upiInitiateSmsUrlV3 = UpiRequestBuilder.UpiInitiateSms.getUpiInitiateSmsUrlV3();
        if (!TextUtils.isEmpty(str3)) {
            str3 = str3.replace(" ", "");
        }
        String str5 = (upiInitiateSmsUrlV3 + UpiAppUtils.getAuthDefaultParams(this.f68438c)) + "&requestId=" + UpiUtils.getUpiSequenceNo() + "&fetchAccounts=" + z + "&carrier=" + str3;
        if (UpiAppUtils.isNetworkAvailable(this.f68438c)) {
            com.paytm.network.b requestCommonNetworkCallBuilder = ApiCallDataSource.getRequestCommonNetworkCallBuilder();
            requestCommonNetworkCallBuilder.f42880d = str5;
            requestCommonNetworkCallBuilder.f42882f = UpiRequestBuilder.getHeadersWithApplicationJson(this.f68438c);
            requestCommonNetworkCallBuilder.k = true;
            requestCommonNetworkCallBuilder.f42885i = new UpiInitiateSmsV3Response("", "", "", "", new UpiInitiateSmsV3Response.ResponseDetails("", new ArrayList()));
            requestCommonNetworkCallBuilder.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (iJRPaytmDataModel instanceof UpiInitiateSmsV3Response) {
                        UpiInitiateSmsV3Response upiInitiateSmsV3Response = (UpiInitiateSmsV3Response) iJRPaytmDataModel;
                        CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_get_sms_text_response_success", upiInitiateSmsV3Response.getRespCode(), "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        aVar.onSuccess(upiInitiateSmsV3Response);
                        return;
                    }
                    CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_get_sms_text_response_failed", "parse_error", "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                    aVar.onError(new UpiCustomVolleyError());
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                    if (!(networkCustomError == null || networkCustomError.networkResponse == null || !UpiUtils.isAuthenticationFailure(String.valueOf(networkCustomError.networkResponse.statusCode)))) {
                        upiCustomVolleyError.setmErrorCode(UpiUtils.AUTHENTICATION_FAILURE_401);
                    }
                    aVar.onError(upiCustomVolleyError);
                    CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_get_sms_text_response_failed", upiCustomVolleyError.getMessage(), "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                }
            };
            requestCommonNetworkCallBuilder.l().a();
            return;
        }
        CJRSendGTMTag.sendNewCustomGTMEvents(this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_get_sms_text_response_failed", "network_error", "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setUrl(str5);
        upiCustomVolleyError.setAlertMessage(this.f68438c.getString(R.string.network_error_message));
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.onError(upiCustomVolleyError);
    }

    public final void a(final a.C1389a aVar, String str, String str2, String str3) {
        final String upiSmsTokenExpireUrl = UpiRequestBuilder.UpiExpireSmsToken.getUpiSmsTokenExpireUrl(this.f68438c);
        if (com.paytm.utility.a.m(this.f68438c)) {
            new HashMap().put("screen_name", str2);
            AnonymousClass13 r4 = new Response.Listener<String>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    try {
                        UpiExpireSmsTokenModel upiExpireSmsTokenModel = (UpiExpireSmsTokenModel) new f().a((String) obj, UpiExpireSmsTokenModel.class);
                        if ("SUCCESS".equalsIgnoreCase(upiExpireSmsTokenModel.getStatus())) {
                            CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_expire_sms_token_response_success", upiExpireSmsTokenModel.getResponseCode(), "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        } else {
                            CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_expire_sms_token_response_failed", upiExpireSmsTokenModel.getResponseCode(), "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        }
                        aVar.onSuccess(upiExpireSmsTokenModel);
                    } catch (Exception e2) {
                        CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_expire_sms_token_response_failed", "parse_error", "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        e2.printStackTrace();
                        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                        upiCustomVolleyError.setAlertMessage("JsonSyntax Exception");
                        upiCustomVolleyError.setUrl(upiSmsTokenExpireUrl);
                        aVar.onError(upiCustomVolleyError);
                    }
                }
            };
            AnonymousClass14 r5 = new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    CJRSendGTMTag.sendNewCustomGTMEvents(a.this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_expire_sms_token_response_failed", volleyError.getMessage(), "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                    aVar.onError((UpiCustomVolleyError) volleyError);
                }
            };
            g.d dVar = g.d.UPI;
            g.c cVar = g.c.SILENT;
            final String str4 = str3;
            AnonymousClass15 r1 = new c(upiSmsTokenExpireUrl, r4, r5) {
                public final Map<String, String> getParams() throws AuthFailureError {
                    return UpiRequestBuilder.UpiExpireSmsToken.getParams(a.this.f68438c, str4);
                }

                public final Map<String, String> getHeaders() throws AuthFailureError {
                    return UpiRequestBuilder.getHeaders(a.this.f68438c);
                }
            };
            PaytmLogs.d("[Request]", r1.toString());
            r1.setTag(str);
            net.one97.paytm.upi.g.d.b(this.f68438c.getApplicationContext()).add(r1);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setUrl(upiSmsTokenExpireUrl);
        upiCustomVolleyError.setAlertMessage(this.f68438c.getString(R.string.network_error_message));
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        CJRSendGTMTag.sendNewCustomGTMEvents(this.f68438c, GAConstants.CATEGORY.UPI_ONB_V1, "device_binding_expire_sms_token_response_failed", "network_error", "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
        aVar.onError(upiCustomVolleyError);
    }

    public final void a(final a.C1389a aVar, String str) {
        if (UpiAppUtils.isNetworkAvailable(this.f68438c)) {
            String addAuthDefaultParams = UpiAppUtils.addAuthDefaultParams(this.f68438c, UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getCreateProfileUrl());
            new f();
            Map<String, String> headersWithApplicationJson = UpiRequestBuilder.getHeadersWithApplicationJson(this.f68438c);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deviceId", UpiUtils.getDeviceId(this.f68438c));
                jSONObject.put("mobile", UpiUtils.getMobile(this.f68438c));
                jSONObject.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, UpiUtils.getUpiSequenceNo());
                jSONObject.put("linkBankAccounts", true);
                for (Map.Entry next : UpiRequestBuilder.getCommonDeviceParams(this.f68438c).entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            net.one97.paytm.upi.g.d.b(this.f68438c.getApplicationContext()).add(new b(addAuthDefaultParams, (Response.Listener<UpiBaseDataModel>) new Response.Listener<UpiBaseDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    aVar.onSuccess((UpiBaseDataModel) obj);
                }
            }, (Response.ErrorListener) new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    aVar.onError((UpiCustomVolleyError) volleyError);
                }
            }, (UpiBaseDataModel) new UpiCreateProfileResponse(), UpiRequestBuilder.getCommonDeviceParams(this.f68438c), headersWithApplicationJson, jSONObject.toString(), (byte) 0)).setTag(str);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.onError(upiCustomVolleyError);
    }

    public final void d(final a.C1389a aVar, String str) {
        if (UpiAppUtils.isNetworkAvailable(this.f68438c)) {
            String addAuthDefaultParams = UpiAppUtils.addAuthDefaultParams(this.f68438c, UpiGTMLoader.getInstance().getUpiCashbackBaseUrl() + UpiGTMLoader.getInstance().getUpiGenerateReferralCodeUrl());
            Map<String, String> headersWithApplicationJson = UpiRequestBuilder.getHeadersWithApplicationJson(this.f68438c);
            headersWithApplicationJson.put(UpiRequestBuilder.SESSION_TOKEN, i.a().f66980a);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deviceId", UpiUtils.getDeviceId(this.f68438c));
                jSONObject.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, UpiUtils.getUpiSequenceNo());
                for (Map.Entry next : UpiRequestBuilder.getCommonDeviceParams(this.f68438c).entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            net.one97.paytm.upi.g.d.b(this.f68438c.getApplicationContext()).add(new b(addAuthDefaultParams, (Response.Listener<UpiBaseDataModel>) new Response.Listener<UpiBaseDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    aVar.onSuccess((UpiBaseDataModel) obj);
                }
            }, (Response.ErrorListener) new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    aVar.onError((UpiCustomVolleyError) volleyError);
                }
            }, (UpiBaseDataModel) new ReferralCodeResponse(), UpiRequestBuilder.getCommonDeviceParams(this.f68438c), headersWithApplicationJson, jSONObject.toString(), (byte) 0)).setTag(str);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.onError(upiCustomVolleyError);
    }

    public final void d(final a.C1389a aVar, String str, String str2) {
        if (UpiAppUtils.isNetworkAvailable(this.f68438c)) {
            String addAuthDefaultParams = UpiAppUtils.addAuthDefaultParams(this.f68438c, UpiGTMLoader.getInstance().getUpiCashbackBaseUrl() + UpiGTMLoader.getInstance().getUpiClaimReferralCodeUrl());
            Map<String, String> headersWithApplicationJson = UpiRequestBuilder.getHeadersWithApplicationJson(this.f68438c);
            headersWithApplicationJson.put(UpiRequestBuilder.SESSION_TOKEN, i.a().f66980a);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deviceId", UpiUtils.getDeviceId(this.f68438c));
                jSONObject.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, UpiUtils.getUpiSequenceNo());
                jSONObject.put("referralCode", str2);
                for (Map.Entry next : UpiRequestBuilder.getCommonDeviceParams(this.f68438c).entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            net.one97.paytm.upi.g.d.b(this.f68438c.getApplicationContext()).add(new b(addAuthDefaultParams, (Response.Listener<UpiBaseDataModel>) new Response.Listener<UpiBaseDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    UpiBaseDataModel upiBaseDataModel = (UpiBaseDataModel) obj;
                    a.C1389a aVar = aVar;
                    if (aVar != null) {
                        aVar.onSuccess(upiBaseDataModel);
                    }
                }
            }, (Response.ErrorListener) new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    a.C1389a aVar = aVar;
                    if (aVar != null) {
                        aVar.onError((UpiCustomVolleyError) volleyError);
                    }
                }
            }, (UpiBaseDataModel) new ReferralCodeResponse(), UpiRequestBuilder.getCommonDeviceParams(this.f68438c), headersWithApplicationJson, jSONObject.toString(), (byte) 0)).setTag(str);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        if (aVar != null) {
            aVar.onError(upiCustomVolleyError);
        }
    }

    public final void a(final c.b bVar) {
        if (UpiAppUtils.isNetworkAvailable(this.f68438c)) {
            String url = UpiRequestBuilder.AddBankAccountSuccessPopup.getUrl();
            Map<String, String> queryParams = UpiRequestBuilder.AddBankAccountSuccessPopup.getQueryParams(this.f68438c);
            com.paytm.network.b postRequestCommonNetworkCallBuilder = ApiCallDataSource.postRequestCommonNetworkCallBuilder();
            postRequestCommonNetworkCallBuilder.f42880d = url;
            postRequestCommonNetworkCallBuilder.f42883g = queryParams;
            postRequestCommonNetworkCallBuilder.k = false;
            postRequestCommonNetworkCallBuilder.f42885i = new CJRHomePageV2();
            postRequestCommonNetworkCallBuilder.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (iJRPaytmDataModel instanceof CJRHomePageV2) {
                        bVar.a((CJRHomePageV2) iJRPaytmDataModel);
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    c.b bVar = bVar;
                    if (networkCustomError == null) {
                        networkCustomError = new NetworkCustomError();
                    }
                    bVar.a(networkCustomError);
                }
            };
            postRequestCommonNetworkCallBuilder.l().a();
            return;
        }
        NetworkCustomError networkCustomError = new NetworkCustomError();
        networkCustomError.setErrorType(NetworkCustomError.ErrorType.NetworkError);
        bVar.a(networkCustomError);
    }

    static /* synthetic */ void a(a aVar, a.C1389a aVar2, String str) {
        a aVar3 = aVar;
        a.C1389a aVar4 = aVar2;
        if (TextUtils.isEmpty(str)) {
            Context context = aVar3.f68438c;
            String concat = "internal_error_code_".concat(String.valueOf(str));
            CJRSendGTMTag.sendNewCustomGTMEvents(context, GAConstants.CATEGORY.UPI_ONB_V1, "get_token_response_failure", concat, "vmn=" + aVar3.f68441f, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
            UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
            upiCustomVolleyError.setAlertMessage(aVar3.f68438c.getString(R.string.upi_some_went_wrong));
            aVar4.onError(upiCustomVolleyError);
            return;
        }
        String string = aVar3.f68438c.getString(R.string.upi_some_went_wrong);
        try {
            BaseUpiResponse baseUpiResponse = (BaseUpiResponse) new f().a(str, BaseUpiResponse.class);
            String response = baseUpiResponse.getResponse();
            String message = baseUpiResponse.getMessage();
            if (baseUpiResponse.isSuccess()) {
                Object mobileAppData = baseUpiResponse.getMobileAppData();
                if (mobileAppData instanceof String) {
                    String removeNewLine = UpiUtils.removeNewLine((String) mobileAppData);
                    if ("0".equalsIgnoreCase(response)) {
                        Context context2 = aVar3.f68438c;
                        CJRSendGTMTag.sendNewCustomGTMEvents(context2, GAConstants.CATEGORY.UPI_ONB_V1, "get_token_response_success", "", "vmn=" + aVar3.f68441f, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        try {
                            String substring = removeNewLine.substring(removeNewLine.indexOf("<keyValue"), removeNewLine.lastIndexOf("</keyValue>"));
                            String substring2 = substring.substring(substring.indexOf(SimpleComparison.GREATER_THAN_OPERATION) + 1);
                            UpiToken upiToken = new UpiToken();
                            upiToken.setUpiToken(substring2);
                            aVar4.onSuccess(upiToken);
                        } catch (Exception e2) {
                            Context context3 = aVar3.f68438c;
                            CJRSendGTMTag.sendNewCustomGTMEvents(context3, GAConstants.CATEGORY.UPI_ONB_V1, "get_token_response_failure", "app_parse_error", "vmn=" + aVar3.f68441f, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                            UpiCustomVolleyError upiCustomVolleyError2 = new UpiCustomVolleyError();
                            upiCustomVolleyError2.setAlertMessage(e2.getMessage());
                            upiCustomVolleyError2.setUrl(UpiRequestBuilder.GetTokenRequest.getGetTokenUrl(aVar3.f68438c));
                            aVar4.onError(upiCustomVolleyError2);
                        }
                    } else {
                        Context context4 = aVar3.f68438c;
                        CJRSendGTMTag.sendNewCustomGTMEvents(context4, GAConstants.CATEGORY.UPI_ONB_V1, "get_token_response_failure", response, "vmn=" + aVar3.f68441f, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                        UpiCustomVolleyError upiCustomVolleyError3 = new UpiCustomVolleyError();
                        upiCustomVolleyError3.setAlertMessage(message);
                        upiCustomVolleyError3.setmAlertTitle(response);
                        upiCustomVolleyError3.setUrl(UpiRequestBuilder.GetTokenRequest.getGetTokenUrl(aVar3.f68438c));
                        aVar4.onError(upiCustomVolleyError3);
                    }
                }
            } else {
                Context context5 = aVar3.f68438c;
                CJRSendGTMTag.sendNewCustomGTMEvents(context5, GAConstants.CATEGORY.UPI_ONB_V1, "get_token_response_failure", response, "vmn=" + aVar3.f68441f, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
                UpiCustomVolleyError upiCustomVolleyError4 = new UpiCustomVolleyError();
                upiCustomVolleyError4.setAlertMessage(message);
                upiCustomVolleyError4.setmAlertTitle(response);
                upiCustomVolleyError4.setUrl(UpiRequestBuilder.GetTokenRequest.getGetTokenUrl(aVar3.f68438c));
                aVar4.onError(upiCustomVolleyError4);
            }
        } catch (u e3) {
            PaytmLogs.e(aVar3.f68437b, e3.getMessage());
            Context context6 = aVar3.f68438c;
            CJRSendGTMTag.sendNewCustomGTMEvents(context6, GAConstants.CATEGORY.UPI_ONB_V1, "get_token_response_failure", "app_parse_error", "vmn=" + aVar3.f68441f, "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
            UpiCustomVolleyError upiCustomVolleyError5 = new UpiCustomVolleyError();
            upiCustomVolleyError5.setAlertMessage(string);
            upiCustomVolleyError5.setUrl(UpiRequestBuilder.GetTokenRequest.getGetTokenUrl(aVar3.f68438c));
            aVar4.onError(upiCustomVolleyError5);
        }
    }
}
