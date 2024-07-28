package net.one97.paytm.upi.passbook.b.a.b;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.google.gson.g;
import com.google.gson.u;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.MiniStatementV2Model;
import net.one97.paytm.upi.common.upi.PendingCollectMandateRequests;
import net.one97.paytm.upi.common.upi.PendingRequestsModel;
import net.one97.paytm.upi.common.upi.UpiTransactionStatusModel;
import net.one97.paytm.upi.common.upi.UpiTxnHistoryV2RequestBody;
import net.one97.paytm.upi.deserializer.BaseUpiDeserializer;
import net.one97.paytm.upi.g.b;
import net.one97.paytm.upi.g.c;
import net.one97.paytm.upi.g.d;
import net.one97.paytm.upi.g.g;
import net.one97.paytm.upi.passbook.b.a.a;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public class a implements net.one97.paytm.upi.passbook.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static String f67623a = "UPI_POLLING_ERROR";

    /* renamed from: b  reason: collision with root package name */
    private static int f67624b = 5;

    /* renamed from: d  reason: collision with root package name */
    private static a f67625d;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f67626c = 2;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f67627e = a.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f67628f;

    /* renamed from: g  reason: collision with root package name */
    private int f67629g = 0;

    /* renamed from: h  reason: collision with root package name */
    private String[] f67630h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f67631i = 1;

    static /* synthetic */ int e(a aVar) {
        int i2 = aVar.f67631i;
        aVar.f67631i = i2 + 1;
        return i2;
    }

    private a(Context context) {
        this.f67628f = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f67625d == null) {
                f67625d = new a(context);
            }
            aVar = f67625d;
        }
        return aVar;
    }

    public final void a(final a.C1379a aVar, String str, String str2) {
        new HashMap().put("screen_name", str2);
        if (UpiAppUtils.isNetworkAvailable(this.f67628f)) {
            String pendingRequestsUrl = UpiRequestBuilder.GetPendingRequests.getPendingRequestsUrl(this.f67628f);
            AnonymousClass1 r1 = new Response.Listener<String>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    String str = (String) obj;
                    PaytmLogs.i(a.this.f67627e, str);
                    g gVar = new g();
                    gVar.a(BaseUpiResponse.class, new BaseUpiDeserializer(25));
                    try {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) gVar.a().a(str, BaseUpiResponse.class);
                        String response = baseUpiResponse.getResponse();
                        String message = baseUpiResponse.getMessage();
                        if (!baseUpiResponse.isSuccess()) {
                            UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                            upiCustomVolleyError.setUrl(UpiRequestBuilder.GetPendingRequests.getPendingRequestsUrl(a.this.f67628f));
                            upiCustomVolleyError.setAlertMessage(message);
                            upiCustomVolleyError.setmAlertTitle(response);
                            aVar.a(upiCustomVolleyError);
                        } else if (!"0".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                            UpiCustomVolleyError upiCustomVolleyError2 = new UpiCustomVolleyError();
                            upiCustomVolleyError2.setUrl(UpiRequestBuilder.GetPendingRequests.getPendingRequestsUrl(a.this.f67628f));
                            upiCustomVolleyError2.setAlertMessage(message);
                            upiCustomVolleyError2.setmAlertTitle(response);
                            aVar.a(upiCustomVolleyError2);
                        } else if (baseUpiResponse.getMobileAppData() instanceof PendingRequestsModel) {
                            PendingRequestsModel pendingRequestsModel = (PendingRequestsModel) baseUpiResponse.getMobileAppData();
                            if (pendingRequestsModel == null || pendingRequestsModel.getDetails() == null) {
                                UpiCustomVolleyError upiCustomVolleyError3 = new UpiCustomVolleyError();
                                upiCustomVolleyError3.setUrl(UpiRequestBuilder.GetPendingRequests.getPendingRequestsUrl(a.this.f67628f));
                                upiCustomVolleyError3.setAlertMessage(message);
                                upiCustomVolleyError3.setmAlertTitle(response);
                                aVar.a(upiCustomVolleyError3);
                                return;
                            }
                            aVar.a((UpiBaseDataModel) pendingRequestsModel.getDetails());
                        } else {
                            UpiCustomVolleyError upiCustomVolleyError4 = new UpiCustomVolleyError();
                            upiCustomVolleyError4.setUrl(UpiRequestBuilder.GetPendingRequests.getPendingRequestsUrl(a.this.f67628f));
                            upiCustomVolleyError4.setAlertMessage(message);
                            upiCustomVolleyError4.setmAlertTitle(response);
                            aVar.a(upiCustomVolleyError4);
                        }
                    } catch (u e2) {
                        e2.printStackTrace();
                        UpiCustomVolleyError upiCustomVolleyError5 = new UpiCustomVolleyError();
                        upiCustomVolleyError5.setUrl(UpiRequestBuilder.GetPendingRequests.getPendingRequestsUrl(a.this.f67628f));
                        upiCustomVolleyError5.setAlertMessage("JSONSyntax Exception");
                        aVar.a(upiCustomVolleyError5);
                    }
                }
            };
            AnonymousClass12 r2 = new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    aVar.a((UpiCustomVolleyError) volleyError);
                }
            };
            g.d dVar = g.d.UPI;
            g.c cVar = g.c.SILENT;
            AnonymousClass17 r6 = new c(pendingRequestsUrl, r1, r2) {
                public final Map<String, String> getParams() {
                    return UpiRequestBuilder.GetPendingRequests.getParams(a.this.f67628f);
                }

                public final Map<String, String> getHeaders() throws AuthFailureError {
                    return UpiRequestBuilder.getHeaders(a.this.f67628f);
                }
            };
            PaytmLogs.d("[Request]", r6.toString());
            r6.setTag(str);
            d.b(this.f67628f).add(r6);
        }
    }

    public final void a(final a.C1379a aVar, String str, int i2, String str2) {
        if (UpiAppUtils.isNetworkAvailable(this.f67628f)) {
            new HashMap().put("screen_name", str2);
            String pendingRequestsUrl = UpiRequestBuilder.GetPendingRequests.getPendingRequestsUrl(this.f67628f);
            AnonymousClass18 r5 = new Response.Listener<String>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    String str = (String) obj;
                    PaytmLogs.i(a.this.f67627e, str);
                    com.google.gson.g gVar = new com.google.gson.g();
                    gVar.a(BaseUpiResponse.class, new BaseUpiDeserializer(25));
                    try {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) gVar.a().a(str, BaseUpiResponse.class);
                        String response = baseUpiResponse.getResponse();
                        String message = baseUpiResponse.getMessage();
                        if (!baseUpiResponse.isSuccess()) {
                            UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                            upiCustomVolleyError.setUrl(UpiRequestBuilder.GetPendingRequests.getPendingRequestsUrl(a.this.f67628f));
                            upiCustomVolleyError.setAlertMessage(message);
                            upiCustomVolleyError.setmAlertTitle(response);
                            aVar.a(upiCustomVolleyError);
                        } else if (!"0".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                            UpiCustomVolleyError upiCustomVolleyError2 = new UpiCustomVolleyError();
                            upiCustomVolleyError2.setUrl(UpiRequestBuilder.GetPendingRequests.getPendingRequestsUrl(a.this.f67628f));
                            upiCustomVolleyError2.setAlertMessage(message);
                            upiCustomVolleyError2.setmAlertTitle(response);
                            aVar.a(upiCustomVolleyError2);
                        } else if (baseUpiResponse.getMobileAppData() instanceof PendingRequestsModel) {
                            PendingRequestsModel pendingRequestsModel = (PendingRequestsModel) baseUpiResponse.getMobileAppData();
                            if (pendingRequestsModel == null || pendingRequestsModel.getDetails() == null) {
                                UpiCustomVolleyError upiCustomVolleyError3 = new UpiCustomVolleyError();
                                upiCustomVolleyError3.setUrl(UpiRequestBuilder.GetPendingRequests.getPendingRequestsUrl(a.this.f67628f));
                                upiCustomVolleyError3.setAlertMessage(message);
                                upiCustomVolleyError3.setmAlertTitle(response);
                                aVar.a(upiCustomVolleyError3);
                                return;
                            }
                            aVar.a((UpiBaseDataModel) pendingRequestsModel.getDetails());
                        } else {
                            UpiCustomVolleyError upiCustomVolleyError4 = new UpiCustomVolleyError();
                            upiCustomVolleyError4.setUrl(UpiRequestBuilder.GetPendingRequests.getPendingRequestsUrl(a.this.f67628f));
                            upiCustomVolleyError4.setAlertMessage(message);
                            upiCustomVolleyError4.setmAlertTitle(response);
                            aVar.a(upiCustomVolleyError4);
                        }
                    } catch (u e2) {
                        e2.printStackTrace();
                        UpiCustomVolleyError upiCustomVolleyError5 = new UpiCustomVolleyError();
                        upiCustomVolleyError5.setUrl(UpiRequestBuilder.GetPendingRequests.getPendingRequestsUrl(a.this.f67628f));
                        upiCustomVolleyError5.setAlertMessage("JSONSyntax Exception");
                        aVar.a(upiCustomVolleyError5);
                    }
                }
            };
            AnonymousClass19 r6 = new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    aVar.a((UpiCustomVolleyError) volleyError);
                }
            };
            g.d dVar = g.d.UPI;
            g.c cVar = g.c.USER_FACING;
            final int i3 = i2;
            AnonymousClass20 r2 = new c(pendingRequestsUrl, r5, r6) {
                public final Map<String, String> getParams() {
                    return UpiRequestBuilder.GetPendingRequests.getParams(a.this.f67628f, i3);
                }

                public final Map<String, String> getHeaders() throws AuthFailureError {
                    return UpiRequestBuilder.getHeaders(a.this.f67628f);
                }
            };
            PaytmLogs.d("[Request]", r2.toString());
            r2.setTag(str);
            d.b(this.f67628f).add(r2);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.a(upiCustomVolleyError);
    }

    public final void a(final a.C1379a aVar, String str, String str2, String str3) {
        if (UpiAppUtils.isNetworkAvailable(this.f67628f)) {
            String addAuthDefaultParams = UpiAppUtils.addAuthDefaultParams(this.f67628f, UpiGTMLoader.getInstance().getUpiGatewayBaseUrl() + UpiGTMLoader.getInstance().getLighterApiV3Url());
            new f();
            Map<String, String> headersWithApplicationJson = UpiRequestBuilder.getHeadersWithApplicationJson(this.f67628f);
            headersWithApplicationJson.put(UpiConstants.PENDING_REQUEST_CUST_ID, str);
            d.b(this.f67628f.getApplicationContext()).add(new b(addAuthDefaultParams, (Response.Listener<UpiBaseDataModel>) new Response.Listener<UpiBaseDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    aVar.a((UpiBaseDataModel) obj);
                }
            }, (Response.ErrorListener) new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    aVar.a((UpiCustomVolleyError) volleyError);
                }
            }, (UpiBaseDataModel) new PendingCollectMandateRequests(), UpiRequestBuilder.getCommonDeviceParams(this.f67628f), headersWithApplicationJson, (String) null, (byte) 0));
        }
    }

    public final void a(a.C1379a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        final a.C1379a aVar2 = aVar;
        if (UpiAppUtils.isNetworkAvailable(this.f67628f)) {
            new HashMap().put("screen_name", str11);
            String collectRequestAuthUrl = UpiRequestBuilder.CollectAuthRequest.getCollectRequestAuthUrl(this.f67628f);
            AnonymousClass23 r3 = new Response.Listener<String>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    String str = (String) obj;
                    PaytmLogs.i(a.this.f67627e, str);
                    aVar2.a((UpiBaseDataModel) (BaseUpiResponse) new f().a(str, BaseUpiResponse.class));
                }
            };
            AnonymousClass2 r4 = new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    aVar2.a((UpiCustomVolleyError) volleyError);
                }
            };
            g.d dVar = g.d.UPI;
            g.c cVar = g.c.USER_FACING;
            final String str12 = str2;
            final String str13 = str3;
            final String str14 = str4;
            final String str15 = str5;
            final String str16 = str6;
            final String str17 = str7;
            final String str18 = str8;
            final String str19 = str9;
            final String str20 = str10;
            AnonymousClass3 r0 = new c(collectRequestAuthUrl, r3, r4) {
                public final Map<String, String> getParams() {
                    return UpiRequestBuilder.CollectAuthRequest.getParams(a.this.f67628f, (String) null, (String) null, str12, str13, str14, str15, str16, str17, str18, str19, str20);
                }

                public final Map<String, String> getHeaders() throws AuthFailureError {
                    return UpiRequestBuilder.getHeaders(a.this.f67628f);
                }
            };
            PaytmLogs.d("[Request]", r0.toString());
            r0.setTag(str);
            d.b(this.f67628f).add(r0);
        }
    }

    public final void a(final a.b bVar, String str, String str2, String str3, String str4, String str5) {
        a.b bVar2 = bVar;
        if (UpiAppUtils.isNetworkAvailable(this.f67628f)) {
            new HashMap().put("screen_name", str5);
            String markSpamUrl = UpiRequestBuilder.MarkSpamRequest.getMarkSpamUrl(this.f67628f);
            AnonymousClass4 r3 = new Response.Listener<String>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    String str = (String) obj;
                    try {
                        PaytmLogs.i(a.this.f67627e, str);
                        bVar.a((UpiBaseDataModel) (BaseUpiResponse) new f().a(str, BaseUpiResponse.class));
                    } catch (u e2) {
                        e2.printStackTrace();
                        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                        upiCustomVolleyError.setAlertMessage("Parsing Error");
                        upiCustomVolleyError.setUrl(UpiRequestBuilder.MarkSpamRequest.getMarkSpamUrl(a.this.f67628f));
                        bVar.a((VolleyError) upiCustomVolleyError);
                    }
                }
            };
            AnonymousClass5 r4 = new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    UpiCustomVolleyError upiCustomVolleyError = (UpiCustomVolleyError) volleyError;
                    upiCustomVolleyError.setAlertMessage("Time out Error");
                    upiCustomVolleyError.setUrl(UpiRequestBuilder.MarkSpamRequest.getMarkSpamUrl(a.this.f67628f));
                    bVar.a((VolleyError) upiCustomVolleyError);
                }
            };
            g.d dVar = g.d.UPI;
            g.c cVar = g.c.USER_FACING;
            final String str6 = str4;
            final String str7 = str2;
            final String str8 = str3;
            AnonymousClass6 r0 = new c(markSpamUrl, r3, r4) {
                public final Map<String, String> getParams() {
                    return UpiRequestBuilder.MarkSpamRequest.getParams(a.this.f67628f, str6, str7, str8);
                }

                public final Map<String, String> getHeaders() throws AuthFailureError {
                    return UpiRequestBuilder.getHeaders(a.this.f67628f);
                }
            };
            PaytmLogs.d("[Request]", r0.toString());
            String str9 = str;
            r0.setTag(str);
            d.b(this.f67628f).add(r0);
        }
    }

    public final void b(final a.C1379a aVar, String str, int i2, String str2) {
        if (UpiAppUtils.isNetworkAvailable(this.f67628f)) {
            new HashMap().put("screen_name", str2);
            String spamRequestsUrl = UpiRequestBuilder.GetSpamRequests.getSpamRequestsUrl(this.f67628f);
            AnonymousClass7 r0 = new Response.Listener<String>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    String str = (String) obj;
                    PaytmLogs.i(a.this.f67627e, str);
                    com.google.gson.g gVar = new com.google.gson.g();
                    gVar.a(BaseUpiResponse.class, new BaseUpiDeserializer(25));
                    try {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) gVar.a().a(str, BaseUpiResponse.class);
                        String response = baseUpiResponse.getResponse();
                        String message = baseUpiResponse.getMessage();
                        if (!baseUpiResponse.isSuccess()) {
                            UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                            upiCustomVolleyError.setUrl(UpiRequestBuilder.GetSpamRequests.getSpamRequestsUrl(a.this.f67628f));
                            upiCustomVolleyError.setAlertMessage(message);
                            upiCustomVolleyError.setmAlertTitle(response);
                            aVar.a(upiCustomVolleyError);
                        } else if (!"0".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                            UpiCustomVolleyError upiCustomVolleyError2 = new UpiCustomVolleyError();
                            upiCustomVolleyError2.setUrl(UpiRequestBuilder.GetSpamRequests.getSpamRequestsUrl(a.this.f67628f));
                            upiCustomVolleyError2.setAlertMessage(message);
                            upiCustomVolleyError2.setmAlertTitle(response);
                            aVar.a(upiCustomVolleyError2);
                        } else if (baseUpiResponse.getMobileAppData() instanceof PendingRequestsModel) {
                            PendingRequestsModel pendingRequestsModel = (PendingRequestsModel) baseUpiResponse.getMobileAppData();
                            if (pendingRequestsModel == null || pendingRequestsModel.getDetails() == null) {
                                UpiCustomVolleyError upiCustomVolleyError3 = new UpiCustomVolleyError();
                                upiCustomVolleyError3.setUrl(UpiRequestBuilder.GetSpamRequests.getSpamRequestsUrl(a.this.f67628f));
                                upiCustomVolleyError3.setAlertMessage(message);
                                upiCustomVolleyError3.setmAlertTitle(response);
                                aVar.a(upiCustomVolleyError3);
                                return;
                            }
                            aVar.a((UpiBaseDataModel) pendingRequestsModel.getDetails());
                        } else {
                            UpiCustomVolleyError upiCustomVolleyError4 = new UpiCustomVolleyError();
                            upiCustomVolleyError4.setUrl(UpiRequestBuilder.GetSpamRequests.getSpamRequestsUrl(a.this.f67628f));
                            upiCustomVolleyError4.setAlertMessage(message);
                            upiCustomVolleyError4.setmAlertTitle(response);
                            aVar.a(upiCustomVolleyError4);
                        }
                    } catch (u e2) {
                        e2.printStackTrace();
                        UpiCustomVolleyError upiCustomVolleyError5 = new UpiCustomVolleyError();
                        upiCustomVolleyError5.setUrl(UpiRequestBuilder.GetSpamRequests.getSpamRequestsUrl(a.this.f67628f));
                        upiCustomVolleyError5.setAlertMessage("JSONSyntax Exception");
                        aVar.a(upiCustomVolleyError5);
                    }
                }
            };
            AnonymousClass8 r1 = new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    aVar.a((UpiCustomVolleyError) volleyError);
                }
            };
            g.d dVar = g.d.UPI;
            g.c cVar = g.c.USER_FACING;
            AnonymousClass9 r5 = new c(spamRequestsUrl, r0, r1) {
                public final Map<String, String> getHeaders() throws AuthFailureError {
                    return UpiRequestBuilder.GetSpamRequests.getHeaders(a.this.f67628f);
                }
            };
            PaytmLogs.d("[Request]", r5.toString());
            r5.setTag(str);
            d.b(this.f67628f).add(r5);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.a(upiCustomVolleyError);
    }

    public final void a() {
        this.f67629g = 0;
        this.f67631i = 1;
        String upiTransactionStatusPollingLimit = UpiGTMLoader.getInstance().getUpiTransactionStatusPollingLimit();
        if (!TextUtils.isEmpty(upiTransactionStatusPollingLimit)) {
            this.f67630h = upiTransactionStatusPollingLimit.split(AppConstants.COMMA);
            f67624b = this.f67630h.length;
        }
    }

    public final void b(final a.C1379a aVar, String str, String str2, String str3) {
        if (UpiAppUtils.isNetworkAvailable(this.f67628f)) {
            new HashMap().put("screen_name", str3);
            String upiTransactionStatusUrl = UpiRequestBuilder.UpiTransactionStatus.getUpiTransactionStatusUrl(this.f67628f);
            final a.C1379a aVar2 = aVar;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            AnonymousClass10 r5 = new Response.Listener<String>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    UpiTransactionStatusModel upiTransactionStatusModel;
                    String str = (String) obj;
                    com.google.gson.g gVar = new com.google.gson.g();
                    gVar.a(BaseUpiResponse.class, new BaseUpiDeserializer(29));
                    try {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) gVar.a().a(str, BaseUpiResponse.class);
                        if (!baseUpiResponse.isSuccess()) {
                            a.this.f67631i = 1;
                            UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                            upiCustomVolleyError.setUrl(UpiRequestBuilder.UpiTransactionStatus.getUpiTransactionStatusUrl(a.this.f67628f));
                            upiCustomVolleyError.setAlertMessage(baseUpiResponse.getMessage());
                            aVar2.a(upiCustomVolleyError);
                        } else if ((baseUpiResponse.getMobileAppData() instanceof UpiTransactionStatusModel) && (upiTransactionStatusModel = (UpiTransactionStatusModel) baseUpiResponse.getMobileAppData()) != null && upiTransactionStatusModel.getDetails() != null) {
                            if ("PENDING".equalsIgnoreCase(upiTransactionStatusModel.getDetails().getStatus())) {
                                if (a.this.f67631i == a.this.f67626c) {
                                    UpiCustomVolleyError upiCustomVolleyError2 = new UpiCustomVolleyError();
                                    upiCustomVolleyError2.setmErrorCode(a.f67623a);
                                    aVar2.a(upiCustomVolleyError2);
                                }
                                a.a(a.this, aVar2, str4, str5, str6);
                                a.e(a.this);
                                return;
                            }
                            a.this.f67631i = 1;
                            aVar2.a((UpiBaseDataModel) baseUpiResponse);
                        }
                    } catch (u e2) {
                        a.this.f67631i = 1;
                        e2.printStackTrace();
                        UpiCustomVolleyError upiCustomVolleyError3 = new UpiCustomVolleyError();
                        upiCustomVolleyError3.setUrl(UpiRequestBuilder.UpiTransactionStatus.getUpiTransactionStatusUrl(a.this.f67628f));
                        upiCustomVolleyError3.setAlertMessage("Parse Exception");
                        aVar2.a(upiCustomVolleyError3);
                    }
                }
            };
            AnonymousClass11 r6 = new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    a.this.f67631i = 1;
                    aVar.a((UpiCustomVolleyError) volleyError);
                }
            };
            g.d dVar = g.d.UPI;
            g.c cVar = g.c.USER_FACING;
            final String str7 = str;
            AnonymousClass13 r2 = new c(upiTransactionStatusUrl, r5, r6) {
                public final Map<String, String> getParams() {
                    return UpiRequestBuilder.UpiTransactionStatus.getParams(a.this.f67628f, str7);
                }

                public final Map<String, String> getHeaders() throws AuthFailureError {
                    return UpiRequestBuilder.getHeaders(a.this.f67628f);
                }
            };
            PaytmLogs.d("[Request]", r2.toString());
            this.f67629g++;
            r2.setTag(str2);
            d.b(this.f67628f).add(r2);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setUrl(UpiRequestBuilder.UpiTransactionStatus.getUpiTransactionStatusUrl(this.f67628f));
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.a(upiCustomVolleyError);
    }

    public final void a(String str) {
        d.b(this.f67628f).cancelAll((Object) str);
    }

    public final void a(final a.C1379a aVar, String str, UpiTxnHistoryV2RequestBody upiTxnHistoryV2RequestBody) {
        if (UpiAppUtils.isNetworkAvailable(this.f67628f)) {
            String addAuthDefaultParams = UpiAppUtils.addAuthDefaultParams(this.f67628f, UpiGTMLoader.getInstance().getUpiGatewayBaseUrl() + UpiGTMLoader.getInstance().getUpiGatewayMiniStmtV2());
            f fVar = new f();
            d.b(this.f67628f.getApplicationContext()).add(new b(addAuthDefaultParams, (Response.Listener<UpiBaseDataModel>) new Response.Listener<UpiBaseDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    aVar.a((UpiBaseDataModel) obj);
                }
            }, (Response.ErrorListener) new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    aVar.a((UpiCustomVolleyError) volleyError);
                }
            }, (UpiBaseDataModel) new MiniStatementV2Model(), UpiRequestBuilder.getCommonDeviceParams(this.f67628f), UpiRequestBuilder.getHeadersWithApplicationJson(this.f67628f), fVar.b(upiTxnHistoryV2RequestBody), (byte) 0));
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.a(upiCustomVolleyError);
    }

    static /* synthetic */ void a(a aVar, a.C1379a aVar2, String str, String str2, String str3) {
        if (aVar.f67629g <= f67624b) {
            try {
                final a.C1379a aVar3 = aVar2;
                final String str4 = str;
                final String str5 = str2;
                final String str6 = str3;
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        a.this.b(aVar3, str4, str5, str6);
                    }
                }, (long) (Integer.parseInt(aVar.f67630h[aVar.f67629g - 1]) * 1000));
            } catch (NumberFormatException unused) {
            }
        } else {
            UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
            upiCustomVolleyError.setAlertMessage("Max tries exceeded");
            aVar2.a(upiCustomVolleyError);
            aVar.f67631i = 1;
        }
    }
}
