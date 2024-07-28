package net.one97.paytm.upi.profile.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.d;
import com.paytm.network.e;
import com.paytm.network.listener.c;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCheckAndAddVpaModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.models.CJRBankDetails;
import net.one97.paytm.upi.common.models.FeatureActionMapping;
import net.one97.paytm.upi.common.models.GetOtpResponse;
import net.one97.paytm.upi.common.models.Request;
import net.one97.paytm.upi.common.models.SetUserPreference;
import net.one97.paytm.upi.common.models.SmartTransferFeature;
import net.one97.paytm.upi.common.models.SmartTransferReponse;
import net.one97.paytm.upi.common.models.UPIProfileMultipartResponse;
import net.one97.paytm.upi.common.models.UserPreference;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.RefreshAccountResponse;
import net.one97.paytm.upi.common.upi.SignupLinkBankAccountResponse;
import net.one97.paytm.upi.common.upi.UpiListBankAccountsResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.common.upi.UserMpinDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.common.upi.UserVpaInfo;
import net.one97.paytm.upi.g.d;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.profile.b.b.a;
import net.one97.paytm.upi.registration.EditVpaResponse;
import net.one97.paytm.upi.registration.c.a;
import net.one97.paytm.upi.util.ApiCallDataSource;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements a {

    /* renamed from: g  reason: collision with root package name */
    private static b f67822g;

    /* renamed from: a  reason: collision with root package name */
    public a f67823a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.upi.profile.b.a.a f67824b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67825c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67826d = false;

    /* renamed from: e  reason: collision with root package name */
    ExecutorService f67827e = Executors.newCachedThreadPool();

    /* renamed from: f  reason: collision with root package name */
    Handler f67828f = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.upi.registration.b.a.b f67829h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public UpiBaseDataModel f67830i;

    private b(a aVar, net.one97.paytm.upi.profile.b.a.a aVar2, net.one97.paytm.upi.registration.b.a.b bVar) {
        this.f67823a = aVar;
        this.f67824b = aVar2;
        this.f67829h = bVar;
    }

    public static b a(a aVar, net.one97.paytm.upi.profile.b.a.a aVar2, net.one97.paytm.upi.registration.b.a.b bVar) {
        if (f67822g == null) {
            f67822g = new b(aVar, aVar2, bVar);
        }
        return f67822g;
    }

    public static boolean a() {
        return f67822g != null;
    }

    public final void a(final a.C1382a aVar, String str, ArrayList<String> arrayList) {
        net.one97.paytm.upi.profile.b.b.a aVar2 = this.f67823a;
        AnonymousClass22 r1 = new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                boolean unused = b.this.f67825c = true;
                aVar.onSuccess(upiBaseDataModel);
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                aVar.onError(upiCustomVolleyError);
            }
        };
        if (UpiAppUtils.isNetworkAvailable(aVar2.f67892a)) {
            String addAuthDefaultParams = UpiAppUtils.addAuthDefaultParams(aVar2.f67892a, UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getLinkbankAccountUrl());
            new f();
            Map<String, String> headersWithApplicationJson = UpiRequestBuilder.getHeadersWithApplicationJson(aVar2.f67892a);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                jSONArray.put(it2.next());
            }
            try {
                jSONObject.put("deviceId", UpiUtils.getDeviceId(aVar2.f67892a));
                jSONObject.put("mobileNo", UpiUtils.getMobile(aVar2.f67892a));
                jSONObject.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, UpiUtils.getUpiSequenceNo());
                jSONObject.put("isProfileRequired", true);
                jSONObject.put("tempAccRefIds", jSONArray);
                for (Map.Entry next : UpiRequestBuilder.getCommonDeviceParams(aVar2.f67892a).entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            d.b(aVar2.f67892a.getApplicationContext()).add(new net.one97.paytm.upi.g.b(addAuthDefaultParams, (Response.Listener<UpiBaseDataModel>) new Response.Listener<UpiBaseDataModel>(r1) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a.C1382a f67926a;

                {
                    this.f67926a = r2;
                }

                public final /* synthetic */ void onResponse(Object obj) {
                    this.f67926a.onSuccess((UpiBaseDataModel) obj);
                }
            }, (Response.ErrorListener) new Response.ErrorListener(r1) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a.C1382a f67952a;

                {
                    this.f67952a = r2;
                }

                public final void onErrorResponse(VolleyError volleyError) {
                    this.f67952a.onError((UpiCustomVolleyError) volleyError);
                }
            }, (UpiBaseDataModel) new SignupLinkBankAccountResponse(), UpiRequestBuilder.getCommonDeviceParams(aVar2.f67892a), headersWithApplicationJson, jSONObject.toString(), (byte) 0)).setTag(str);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        r1.onError(upiCustomVolleyError);
    }

    public final void a(UpiConstants.PROFILE_VPA_ACCOUNT_TYPE profile_vpa_account_type, UserUpiDetails userUpiDetails, final a.C1382a aVar, String str, String str2) {
        this.f67823a.a(profile_vpa_account_type, userUpiDetails, (a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                boolean unused = b.this.f67825c = true;
                aVar.onSuccess(upiBaseDataModel);
                b.this.a((a.C1382a) null, b.class.getSimpleName(), b.class.getSimpleName());
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                aVar.onError(upiCustomVolleyError);
            }
        }, str, str2);
    }

    public final void a(String str, UserMpinDetails userMpinDetails, UpiProfileDefaultBank upiProfileDefaultBank, final a.C1382a aVar, String str2, String str3) {
        this.f67823a.a(str, userMpinDetails, upiProfileDefaultBank, (a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                aVar.onSuccess(upiBaseDataModel);
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                aVar.onError(upiCustomVolleyError);
            }
        }, str2, str3);
    }

    public final void a(String str, UserMpinDetails userMpinDetails, UserUpiDetails userUpiDetails, final a.C1382a aVar) {
        net.one97.paytm.upi.profile.b.b.a aVar2 = this.f67823a;
        AnonymousClass28 r1 = new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                aVar.onSuccess(upiBaseDataModel);
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                aVar.onError(upiCustomVolleyError);
            }
        };
        com.paytm.network.b postRequestCommonNetworkCallBuilder = ApiCallDataSource.postRequestCommonNetworkCallBuilder();
        postRequestCommonNetworkCallBuilder.f42880d = UpiRequestBuilder.ChangeMPIN.getUrl();
        postRequestCommonNetworkCallBuilder.f42882f = UpiRequestBuilder.getHeadersWithApplicationJson(aVar2.f67892a);
        postRequestCommonNetworkCallBuilder.f42884h = UpiRequestBuilder.ChangeMPIN.getBodyParams(aVar2.f67892a, userUpiDetails, userMpinDetails);
        postRequestCommonNetworkCallBuilder.k = true;
        postRequestCommonNetworkCallBuilder.f42883g = UpiRequestBuilder.ChangeMPIN.getRequestParams(str);
        postRequestCommonNetworkCallBuilder.f42885i = new GetOtpResponse("", "", "", "");
        postRequestCommonNetworkCallBuilder.j = new com.paytm.network.listener.b(r1) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a.C1382a f67979a;

            {
                this.f67979a = r2;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof GetOtpResponse) {
                    GetOtpResponse getOtpResponse = (GetOtpResponse) iJRPaytmDataModel;
                    BaseUpiResponse baseUpiResponse = new BaseUpiResponse();
                    baseUpiResponse.setSuccess(getOtpResponse.getRespCode().equals("0"));
                    baseUpiResponse.setResponse(getOtpResponse.getRespCode());
                    this.f67979a.onSuccess(baseUpiResponse);
                    return;
                }
                this.f67979a.onError(new UpiCustomVolleyError());
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                this.f67979a.onError(new UpiCustomVolleyError());
            }
        };
        postRequestCommonNetworkCallBuilder.l().a();
    }

    public final void a(final a.C1382a aVar) {
        this.f67823a.a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                aVar.onSuccess(upiBaseDataModel);
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                aVar.onError(upiCustomVolleyError);
            }
        });
    }

    public final void a(String str, final a.C1382a aVar) {
        this.f67823a.a(str, (a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                aVar.onSuccess(upiBaseDataModel);
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                aVar.onError(upiCustomVolleyError);
            }
        });
    }

    public final void a(UserUpiDetails userUpiDetails, final a.C1382a aVar, String str, String str2) {
        this.f67823a.a(userUpiDetails, (a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                boolean unused = b.this.f67825c = true;
                aVar.onSuccess(upiBaseDataModel);
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                aVar.onError(upiCustomVolleyError);
            }
        }, str, str2);
    }

    public final void a(UserUpiDetails userUpiDetails, String str, a.C1382a aVar, String str2) {
        net.one97.paytm.upi.profile.b.b.a aVar2 = this.f67823a;
        final a.C1382a aVar3 = aVar;
        AnonymousClass7 r3 = new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                boolean unused = b.this.f67825c = true;
                aVar3.onSuccess(upiBaseDataModel);
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                aVar3.onError(upiCustomVolleyError);
            }
        };
        if (UpiAppUtils.isNetworkAvailable(aVar2.f67892a)) {
            String addAuthDefaultParams = UpiAppUtils.addAuthDefaultParams(aVar2.f67892a, UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiRefreshAccount());
            new f();
            Map<String, String> headersWithApplicationJson = UpiRequestBuilder.getHeadersWithApplicationJson(aVar2.f67892a);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deviceId", UpiUtils.getDeviceId(aVar2.f67892a));
                jSONObject.put("mobile", UpiUtils.getMobile(aVar2.f67892a));
                jSONObject.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, UpiUtils.getUpiSequenceNo());
                BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
                jSONObject.put("accRefId", selectedBankAccount.getAccRefId());
                jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, str);
                jSONObject.put("payerName", selectedBankAccount.getCustomerName());
                jSONObject.put("payerVa", userUpiDetails.getVpa());
                for (Map.Entry next : UpiRequestBuilder.getCommonDeviceParams(aVar2.f67892a).entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            d.b(aVar2.f67892a.getApplicationContext()).add(new net.one97.paytm.upi.g.b(addAuthDefaultParams, (Response.Listener<UpiBaseDataModel>) new Response.Listener<UpiBaseDataModel>(r3) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a.C1382a f67924a;

                {
                    this.f67924a = r2;
                }

                public final /* synthetic */ void onResponse(Object obj) {
                    this.f67924a.onSuccess((UpiBaseDataModel) obj);
                }
            }, (Response.ErrorListener) new Response.ErrorListener(r3) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a.C1382a f67928a;

                {
                    this.f67928a = r2;
                }

                public final void onErrorResponse(VolleyError volleyError) {
                    this.f67928a.onError((UpiCustomVolleyError) volleyError);
                }
            }, (UpiBaseDataModel) new RefreshAccountResponse(), UpiRequestBuilder.getCommonDeviceParams(aVar2.f67892a), headersWithApplicationJson, jSONObject.toString(), (byte) 0)).setTag(str2);
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        r3.onError(upiCustomVolleyError);
    }

    public final void b(final a.C1382a aVar, String str, String str2) {
        this.f67823a.b(new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (upiBaseDataModel instanceof BaseUpiResponse) {
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                    if (baseUpiResponse.isSuccess() && "0".equals(baseUpiResponse.getResponse())) {
                        b.this.f67829h.a(false);
                        b.this.f67829h.c(false);
                        b.this.f67829h.b(true);
                        net.one97.paytm.upi.profile.b.a.a.a(b.this.f67824b.f67819a, "upi_recent_txns");
                        b.this.f67829h.m();
                        b.this.b();
                        boolean unused = b.this.f67825c = true;
                    }
                }
                aVar.onSuccess(upiBaseDataModel);
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                aVar.onError(upiCustomVolleyError);
            }
        }, str, str2);
    }

    public final void a(final a.b bVar) {
        this.f67824b.a((a.b) new a.b() {
            public final void a(List<UserVpaInfo> list) {
                if (list == null || list.size() <= 0) {
                    b.a(b.this, bVar);
                } else {
                    bVar.a(list);
                }
            }

            public final void a() {
                bVar.a();
            }
        });
    }

    public final void b() {
        this.f67825c = true;
        this.f67830i = null;
        this.f67824b.a();
    }

    public final void a(a.C1382a aVar, String str, String str2) {
        UpiBaseDataModel upiBaseDataModel;
        if (!this.f67825c && this.f67830i == null) {
            c(aVar, str, str2);
            this.f67827e.execute(new Runnable(aVar) {
                private final /* synthetic */ a.C1382a f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    b.this.b(this.f$1);
                }
            });
        } else if (this.f67825c || (upiBaseDataModel = this.f67830i) == null) {
            c(aVar, str, str2);
        } else {
            aVar.onSuccess(upiBaseDataModel);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(final a.C1382a aVar) {
        net.one97.paytm.upi.profile.b.a.a aVar2 = this.f67824b;
        AnonymousClass12 r2 = new a.C1382a() {
            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            }

            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (upiBaseDataModel != null) {
                    b.this.f67828f.post(new Runnable(upiBaseDataModel) {
                        private final /* synthetic */ UpiBaseDataModel f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            a.C1382a.this.onSuccess(this.f$1);
                        }
                    });
                }
            }
        };
        try {
            String b2 = PaytmUpiPrefUtil.getPref(aVar2.f67819a.getApplicationContext()).b(UpiConstants.KEY_UPI_PROFILE_INFO, "", false);
            if (b2.equals("")) {
                b2 = null;
            }
            r2.onSuccess((UpiBaseDataModel) new f().a(b2, UpiProfileModel.class));
        } catch (Exception e2) {
            PaytmLogs.e(aVar2.f67820b, e2.getMessage());
            r2.onError((UpiCustomVolleyError) null);
        }
    }

    private void c(final a.C1382a aVar, String str, String str2) {
        this.f67823a.a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                boolean unused = b.this.f67825c = false;
                UpiBaseDataModel unused2 = b.this.f67830i = upiBaseDataModel;
                a.C1382a aVar = aVar;
                if (aVar != null) {
                    aVar.onSuccess(upiBaseDataModel);
                }
                Future unused3 = b.this.f67827e.submit(new Callable<Boolean>(upiBaseDataModel) {
                    public final /* synthetic */ Object call() throws Exception {
                        boolean z;
                        b bVar = b.this;
                        UpiBaseDataModel upiBaseDataModel = r3;
                        net.one97.paytm.upi.profile.b.a.a aVar = bVar.f67824b;
                        if (upiBaseDataModel instanceof UpiProfileModel) {
                            UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                            if (upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") && "0".equalsIgnoreCase(upiProfileModel.getRespCode())) {
                                List<UpiProfileDefaultBank> profileVpaList = upiProfileModel.getResponse().getProfileDetail().getProfileVpaList();
                                ArrayList arrayList = new ArrayList();
                                for (UpiProfileDefaultBank next : profileVpaList) {
                                    if (!TextUtils.isEmpty(next.getVirtualAddress()) && next.getDebitBank() != null) {
                                        BankAccountDetails.BankAccount debitBank = next.getDebitBank();
                                        UserVpaInfo userVpaInfo = new UserVpaInfo();
                                        userVpaInfo.setVpa(next.getVirtualAddress());
                                        userVpaInfo.setAccountNum(debitBank.getAccRefNumber());
                                        userVpaInfo.setBankName(debitBank.getBankName());
                                        userVpaInfo.setIsMpinSet(debitBank.isMpinSet());
                                        userVpaInfo.setPrimaryVpa(next.isPrimary());
                                        userVpaInfo.setBankCredsAllowed(debitBank.getCredsAllowed().getChild());
                                        arrayList.add(userVpaInfo);
                                    }
                                }
                                if (arrayList.size() > 0) {
                                    PaytmUpiPrefUtil.getPref(aVar.f67819a.getApplicationContext()).a(UpiConstants.KEY_SHARED_PREF_VPA_INFO, new f().b(arrayList), false);
                                    z = true;
                                } else {
                                    z = false;
                                }
                                PaytmUpiPrefUtil.getPref(aVar.f67819a.getApplicationContext()).a(UpiConstants.KEY_UPI_PROFILE_INFO, new f().b(upiProfileModel), false);
                                return Boolean.valueOf(z);
                            }
                        }
                        z = false;
                        return Boolean.valueOf(z);
                    }
                });
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (b.this.f67825c) {
                    UpiBaseDataModel unused = b.this.f67830i = null;
                }
                a.C1382a aVar = aVar;
                if (aVar != null) {
                    aVar.onError(upiCustomVolleyError);
                }
            }
        }, str, str2);
    }

    public final void a(String str, String str2, a.C1382a aVar, String str3) {
        if (!this.f67826d) {
            net.one97.paytm.upi.profile.b.b.a aVar2 = this.f67823a;
            final a.C1382a aVar3 = aVar;
            AnonymousClass16 r3 = new a.C1382a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    aVar3.onSuccess(upiBaseDataModel);
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    aVar3.onError(upiCustomVolleyError);
                }
            };
            if (UpiAppUtils.isNetworkAvailable(aVar2.f67892a)) {
                String addAuthDefaultParams = UpiAppUtils.addAuthDefaultParams(aVar2.f67892a, UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getListbankAccountUrl());
                new f();
                Map<String, String> headersWithApplicationJson = UpiRequestBuilder.getHeadersWithApplicationJson(aVar2.f67892a);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("deviceId", UpiUtils.getDeviceId(aVar2.f67892a));
                    jSONObject.put("mobile", UpiUtils.getMobile(aVar2.f67892a));
                    jSONObject.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, UpiUtils.getUpiSequenceNo());
                    jSONObject.put("payerVa", str2);
                    jSONObject.put("ifsc", str);
                    jSONObject.put("payerName", UpiUtils.getCustomerName(aVar2.f67892a));
                    for (Map.Entry next : UpiRequestBuilder.getCommonDeviceParams(aVar2.f67892a).entrySet()) {
                        jSONObject.put((String) next.getKey(), next.getValue());
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                d.b(aVar2.f67892a.getApplicationContext()).add(new net.one97.paytm.upi.g.b(addAuthDefaultParams, (Response.Listener<UpiBaseDataModel>) new Response.Listener<UpiBaseDataModel>(r3) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a.C1382a f67896a;

                    {
                        this.f67896a = r2;
                    }

                    public final /* synthetic */ void onResponse(Object obj) {
                        this.f67896a.onSuccess((UpiBaseDataModel) obj);
                    }
                }, (Response.ErrorListener) new Response.ErrorListener(r3) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a.C1382a f67902a;

                    {
                        this.f67902a = r2;
                    }

                    public final void onErrorResponse(VolleyError volleyError) {
                        this.f67902a.onError((UpiCustomVolleyError) volleyError);
                    }
                }, (UpiBaseDataModel) new UpiListBankAccountsResponse(), UpiRequestBuilder.getCommonDeviceParams(aVar2.f67892a), headersWithApplicationJson, jSONObject.toString(), (byte) 0)).setTag(str3);
                return;
            }
            UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
            upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
            r3.onError(upiCustomVolleyError);
        }
    }

    public final void b(String str, final a.C1382a aVar) {
        net.one97.paytm.upi.profile.b.b.a aVar2 = this.f67823a;
        AnonymousClass17 r1 = new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                aVar.onSuccess(upiBaseDataModel);
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                aVar.onError(upiCustomVolleyError);
            }
        };
        String bankUrl = UpiGTMLoader.getInstance().getBankUrl();
        if (URLUtil.isValidUrl(bankUrl)) {
            String addAuthDefaultParams = UpiAppUtils.addAuthDefaultParams(aVar2.f67892a, bankUrl);
            HashMap hashMap = new HashMap();
            hashMap.put("ssotoken", i.a().f66980a);
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ifscCode", str);
                jSONObject.put("request", jSONObject2);
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                jSONObject.put("channel", UpiConstants.MP_ANDROID);
                String appVersionName = UpiAppUtils.getAppVersionName(aVar2.f67892a);
                if (appVersionName != null) {
                    jSONObject.put("version", appVersionName);
                }
            } catch (Exception unused) {
            }
            d.b(aVar2.f67892a.getApplicationContext()).add(new net.one97.paytm.upi.g.b(addAuthDefaultParams, (Response.Listener<UpiBaseDataModel>) new Response.Listener<UpiBaseDataModel>(r1) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a.C1382a f67920a;

                {
                    this.f67920a = r2;
                }

                public final /* synthetic */ void onResponse(Object obj) {
                    this.f67920a.onSuccess((UpiBaseDataModel) obj);
                }
            }, (Response.ErrorListener) new Response.ErrorListener(r1) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a.C1382a f67922a;

                {
                    this.f67922a = r2;
                }

                public final void onErrorResponse(VolleyError volleyError) {
                    this.f67922a.onError((UpiCustomVolleyError) volleyError);
                }
            }, (UpiBaseDataModel) new CJRBankDetails(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), (byte) 0));
        }
    }

    public final void a(final boolean z, UserUpiDetails userUpiDetails, final a.C1382a aVar) {
        if (!this.f67826d) {
            net.one97.paytm.upi.profile.b.b.a aVar2 = this.f67823a;
            aVar2.a((a.C1382a) new a.C1382a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    if (z && (upiBaseDataModel instanceof UpiCheckAndAddVpaModel)) {
                        UpiCheckAndAddVpaModel upiCheckAndAddVpaModel = (UpiCheckAndAddVpaModel) upiBaseDataModel;
                        if (upiCheckAndAddVpaModel.getStatus().equalsIgnoreCase("success") && "0".equals(upiCheckAndAddVpaModel.getRespCode())) {
                            b.this.f67829h.a(true);
                            b.this.f67829h.c(true);
                        }
                    }
                    boolean unused = b.this.f67825c = true;
                    aVar.onSuccess(upiBaseDataModel);
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    aVar.onError(upiCustomVolleyError);
                }
            }, UpiRequestBuilder.CheckVpaAvailabilityAndAddVpa.getCheckVpaAvailabilityAndAddVpa(aVar2.f67892a), UpiRequestBuilder.CheckVpaAvailabilityAndAddVpa.getParams(aVar2.f67892a, userUpiDetails), UpiRequestBuilder.getHeadersWithApplicationJson(aVar2.f67892a), (UpiBaseDataModel) new UpiCheckAndAddVpaModel());
        }
    }

    public final void a(UserUpiDetails userUpiDetails, final a.C1382a aVar) {
        if (!this.f67826d) {
            net.one97.paytm.upi.profile.b.b.a aVar2 = this.f67823a;
            AnonymousClass21 r1 = new a.C1382a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    aVar.onSuccess(upiBaseDataModel);
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    aVar.onError(upiCustomVolleyError);
                }
            };
            com.paytm.network.b postRequestCommonNetworkCallBuilder = ApiCallDataSource.postRequestCommonNetworkCallBuilder();
            postRequestCommonNetworkCallBuilder.f42880d = UpiRequestBuilder.GenerateOTP.getUrl();
            postRequestCommonNetworkCallBuilder.f42882f = UpiRequestBuilder.getHeadersWithApplicationJson(aVar2.f67892a);
            postRequestCommonNetworkCallBuilder.f42884h = UpiRequestBuilder.GenerateOTP.getRequestBody(userUpiDetails.getSelectedBankAccount(), aVar2.f67892a);
            postRequestCommonNetworkCallBuilder.k = true;
            postRequestCommonNetworkCallBuilder.f42883g = UpiRequestBuilder.GenerateOTP.getRequestParams();
            postRequestCommonNetworkCallBuilder.f42885i = new GetOtpResponse("", "", "", "");
            postRequestCommonNetworkCallBuilder.j = new com.paytm.network.listener.b(r1) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a.C1382a f67981a;

                {
                    this.f67981a = r2;
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (iJRPaytmDataModel instanceof GetOtpResponse) {
                        GetOtpResponse getOtpResponse = (GetOtpResponse) iJRPaytmDataModel;
                        BaseUpiResponse baseUpiResponse = new BaseUpiResponse();
                        baseUpiResponse.setSuccess(getOtpResponse.getRespCode().equals("0"));
                        baseUpiResponse.setResponse(getOtpResponse.getRespCode());
                        this.f67981a.onSuccess(baseUpiResponse);
                        return;
                    }
                    this.f67981a.onError(new UpiCustomVolleyError());
                }

                public final void handleErrorCode(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.45.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.45.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            };
            postRequestCommonNetworkCallBuilder.l().a();
        }
    }

    public final void a(String str) {
        this.f67823a.a(str);
    }

    public final void a(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap) {
        this.f67823a.a(str, str2, str3, str4, str5, hashMap);
    }

    public final void a(final a.C1390a aVar, String str, Boolean bool) {
        net.one97.paytm.upi.profile.b.b.a aVar2 = this.f67823a;
        AnonymousClass23 r1 = new a.C1390a() {
            public final void a(EditVpaResponse editVpaResponse) {
                boolean unused = b.this.f67825c = true;
                aVar.a(editVpaResponse);
            }

            public final void a(NetworkCustomError networkCustomError) {
                aVar.a(networkCustomError);
            }

            public final void a() {
                aVar.a();
            }
        };
        if (UpiAppUtils.isNetworkAvailable(aVar2.f67892a)) {
            Map<String, String> headersWithApplicationJson = UpiRequestBuilder.getHeadersWithApplicationJson(aVar2.f67892a);
            String requestBody = UpiRequestBuilder.EditVpa.getRequestBody(aVar2.f67892a, str, bool);
            String url = UpiRequestBuilder.EditVpa.getUrl(aVar2.f67892a);
            com.paytm.network.b postRequestCommonNetworkCallBuilder = ApiCallDataSource.postRequestCommonNetworkCallBuilder();
            postRequestCommonNetworkCallBuilder.f42884h = requestBody;
            postRequestCommonNetworkCallBuilder.f42882f = headersWithApplicationJson;
            postRequestCommonNetworkCallBuilder.f42880d = url;
            postRequestCommonNetworkCallBuilder.f42885i = new EditVpaResponse("", "", "", "", false, new HashMap());
            postRequestCommonNetworkCallBuilder.j = new com.paytm.network.listener.b(r1) {

                /* renamed from: a */
                final /* synthetic */ a.C1390a f67965a;

                public final void onApiSuccess(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.4.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.4.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/

                public final void handleErrorCode(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.4.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.4.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            };
            postRequestCommonNetworkCallBuilder.l().a();
            return;
        }
        NetworkCustomError networkCustomError = new NetworkCustomError();
        networkCustomError.setErrorType(NetworkCustomError.ErrorType.NetworkError);
        r1.a(networkCustomError);
    }

    public final void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, UpiProfileDefaultBank upiProfileDefaultBank, String str9, String str10, String str11) {
        this.f67823a.a(aVar, str, str2, str3, str4, str5, str6, str7, str8, upiProfileDefaultBank, str9, str10, str11);
    }

    public final void a(a.c cVar, String str) {
        net.one97.paytm.upi.profile.b.b.a aVar = this.f67823a;
        String str2 = (UpiGTMLoader.getInstance().getUPSBaseUrl() + UpiGTMLoader.getInstance().getUPSWalletUrl()) + "?preferenceKeys=" + str;
        String Q = com.paytm.utility.b.Q(aVar.f67892a);
        TextUtils.isEmpty(Q);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("sso-token", i.a().f66980a);
        hashMap.put("deviceId", UpiUtils.getDeviceId(aVar.f67892a));
        hashMap.put("requestId", UUID.randomUUID().toString());
        hashMap.put("appVersion", Q);
        com.paytm.network.b requestCommonNetworkCallBuilder = ApiCallDataSource.getRequestCommonNetworkCallBuilder();
        requestCommonNetworkCallBuilder.f42882f = hashMap;
        requestCommonNetworkCallBuilder.f42880d = str2;
        requestCommonNetworkCallBuilder.f42885i = new UserPreference();
        requestCommonNetworkCallBuilder.j = new com.paytm.network.listener.b(cVar) {

            /* renamed from: a */
            final /* synthetic */ a.c f67955a;

            public final void onApiSuccess(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.36.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes7.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.36.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/

            public final void handleErrorCode(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.36.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes7.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.36.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        };
        requestCommonNetworkCallBuilder.l().a();
    }

    public final void a(a.c cVar, String str, String str2) {
        net.one97.paytm.upi.profile.b.b.a aVar = this.f67823a;
        String Q = com.paytm.utility.b.Q(aVar.f67892a);
        TextUtils.isEmpty(Q);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("sso-token", i.a().f66980a);
        hashMap.put("deviceId", UpiUtils.getDeviceId(aVar.f67892a));
        hashMap.put("requestId", UUID.randomUUID().toString());
        hashMap.put("appVersion", Q);
        SetUserPreference setUserPreference = new SetUserPreference(new Request(str, str2));
        com.paytm.network.b putRequestCommonNetworkCallBuilder = ApiCallDataSource.putRequestCommonNetworkCallBuilder();
        putRequestCommonNetworkCallBuilder.f42882f = hashMap;
        putRequestCommonNetworkCallBuilder.f42880d = UpiGTMLoader.getInstance().getUPSBaseUrl() + UpiGTMLoader.getInstance().getUPSWalletUrl();
        putRequestCommonNetworkCallBuilder.f42884h = new f().b(setUserPreference);
        putRequestCommonNetworkCallBuilder.f42885i = new UserPreference();
        putRequestCommonNetworkCallBuilder.j = new com.paytm.network.listener.b(cVar, str2) {

            /* renamed from: a */
            final /* synthetic */ a.c f67957a;

            /* renamed from: b */
            final /* synthetic */ String f67958b;

            public final void onApiSuccess(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.37.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes7.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.37.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/

            public final void handleErrorCode(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.37.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes7.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.37.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        };
        putRequestCommonNetworkCallBuilder.l().a();
    }

    public final void b(a.c cVar, String str, String str2) {
        net.one97.paytm.upi.profile.b.b.a aVar = this.f67823a;
        Context context = aVar.f67892a;
        String addAuthDefaultParams = UpiAppUtils.addAuthDefaultParams(context, UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUPIUserPreferenceURL());
        HashMap hashMap = new HashMap();
        hashMap.put("requestId", UpiUtils.getUpiSequenceNo());
        String addExtratParams = UpiAppUtils.addExtratParams(aVar.f67892a, addAuthDefaultParams, hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put(UpiConstants.CHANNEL_TOKEN, i.a().f66980a);
        hashMap2.put("channel", UpiRequestBuilder.PAYTM_CHANNEL);
        FeatureActionMapping featureActionMapping = new FeatureActionMapping(str, str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(featureActionMapping);
        SmartTransferFeature smartTransferFeature = new SmartTransferFeature(UpiUtils.getDeviceId(aVar.f67892a), arrayList, UpiUtils.getMobile(aVar.f67892a));
        com.paytm.network.b postRequestCommonNetworkCallBuilder = ApiCallDataSource.postRequestCommonNetworkCallBuilder();
        postRequestCommonNetworkCallBuilder.f42882f = hashMap2;
        postRequestCommonNetworkCallBuilder.f42880d = addExtratParams;
        postRequestCommonNetworkCallBuilder.f42884h = new f().b(smartTransferFeature);
        postRequestCommonNetworkCallBuilder.f42885i = new SmartTransferReponse("", (String) null, (String) null, "", "");
        postRequestCommonNetworkCallBuilder.j = new com.paytm.network.listener.b(str2, cVar) {

            /* renamed from: a */
            final /* synthetic */ String f67960a;

            /* renamed from: b */
            final /* synthetic */ a.c f67961b;

            public final void onApiSuccess(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.38.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes7.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.38.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/

            public final void handleErrorCode(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.38.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes7.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.38.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        };
        postRequestCommonNetworkCallBuilder.l().a();
    }

    public final void a(a.d dVar, File file) {
        net.one97.paytm.upi.profile.b.b.a aVar = this.f67823a;
        String profileUploadUrl = UpiGTMLoader.getInstance().getProfileUploadUrl();
        if (URLUtil.isValidUrl(profileUploadUrl)) {
            HashMap hashMap = new HashMap();
            hashMap.put(UpiConstantServiceApi.KEY_PROFILE_PIC_URL, file);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("Content-Type", "application/json");
            hashMap2.put("session_token", com.paytm.utility.a.q(aVar.f67892a.getApplicationContext()));
            HashMap hashMap3 = new HashMap();
            e eVar = new e();
            eVar.f42918c = hashMap;
            eVar.f42919d = hashMap2;
            eVar.f42923h = profileUploadUrl;
            eVar.n = new UPIProfileMultipartResponse();
            eVar.f42921f = a.c.MONEYTRANSFER;
            eVar.k = "profile";
            eVar.f42916a = aVar.f67892a.getApplicationContext();
            eVar.f42917b = hashMap3;
            eVar.f42922g = a.C0715a.POST;
            eVar.j = d.a.USER_FACING;
            eVar.f42924i = new c(dVar) {

                /* renamed from: a */
                final /* synthetic */ a.d f67963a;

                public final void onApiSuccess(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.39.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.39.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/

                public final void handleErrorCode(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.39.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.39.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            };
            eVar.a().a();
            return;
        }
        dVar.a((NetworkCustomError) null);
    }

    public final void c() {
        this.f67825c = true;
    }

    static /* synthetic */ void a(b bVar, final a.b bVar2) {
        Class<b> cls = b.class;
        bVar.f67823a.a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                boolean unused = b.this.f67825c = false;
                UpiBaseDataModel unused2 = b.this.f67830i = upiBaseDataModel;
                Future b2 = b.this.f67827e.submit(new Callable<Boolean>(upiBaseDataModel) {
                    public final /* synthetic */ Object call() throws Exception {
                        boolean z;
                        b bVar = b.this;
                        UpiBaseDataModel upiBaseDataModel = r3;
                        net.one97.paytm.upi.profile.b.a.a aVar = bVar.f67824b;
                        if (upiBaseDataModel instanceof UpiProfileModel) {
                            UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                            if (upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") && "0".equalsIgnoreCase(upiProfileModel.getRespCode())) {
                                List<UpiProfileDefaultBank> profileVpaList = upiProfileModel.getResponse().getProfileDetail().getProfileVpaList();
                                ArrayList arrayList = new ArrayList();
                                for (UpiProfileDefaultBank next : profileVpaList) {
                                    if (!TextUtils.isEmpty(next.getVirtualAddress()) && next.getDebitBank() != null) {
                                        BankAccountDetails.BankAccount debitBank = next.getDebitBank();
                                        UserVpaInfo userVpaInfo = new UserVpaInfo();
                                        userVpaInfo.setVpa(next.getVirtualAddress());
                                        userVpaInfo.setAccountNum(debitBank.getAccRefNumber());
                                        userVpaInfo.setBankName(debitBank.getBankName());
                                        userVpaInfo.setIsMpinSet(debitBank.isMpinSet());
                                        userVpaInfo.setPrimaryVpa(next.isPrimary());
                                        userVpaInfo.setBankCredsAllowed(debitBank.getCredsAllowed().getChild());
                                        arrayList.add(userVpaInfo);
                                    }
                                }
                                if (arrayList.size() > 0) {
                                    PaytmUpiPrefUtil.getPref(aVar.f67819a.getApplicationContext()).a(UpiConstants.KEY_SHARED_PREF_VPA_INFO, new f().b(arrayList), false);
                                    z = true;
                                } else {
                                    z = false;
                                }
                                PaytmUpiPrefUtil.getPref(aVar.f67819a.getApplicationContext()).a(UpiConstants.KEY_UPI_PROFILE_INFO, new f().b(upiProfileModel), false);
                                return Boolean.valueOf(z);
                            }
                        }
                        z = false;
                        return Boolean.valueOf(z);
                    }
                });
                if (bVar2 != null) {
                    try {
                        if (((Boolean) b2.get()).booleanValue()) {
                            b.this.f67824b.a(bVar2);
                        } else {
                            bVar2.a();
                        }
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        bVar2.a();
                    } catch (ExecutionException e3) {
                        e3.printStackTrace();
                        bVar2.a();
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                boolean unused = b.this.f67825c = true;
                UpiBaseDataModel unused2 = b.this.f67830i = null;
                a.b bVar = bVar2;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }, cls.getSimpleName(), cls.getSimpleName());
    }
}
