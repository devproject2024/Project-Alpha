package net.one97.paytm.moneytransfer.b.a.b;

import android.content.Context;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.network.a;
import com.paytm.network.b.g;
import com.paytm.network.f;
import com.paytm.network.model.CJRIllegalCodeError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.BeneficiaryDeleteResponse;
import net.one97.paytm.common.entity.CJRClaimCashbackDataModel;
import net.one97.paytm.common.entity.CustProductListV2;
import net.one97.paytm.common.entity.PPBCurrentAccountModel;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRBankDetails;
import net.one97.paytm.common.entity.wallet.IMPSMetaDataModal;
import net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.h;
import net.one97.paytm.moneytransferv4.PaymentManager;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.GetCredentialsApiBuilder;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public class a implements net.one97.paytm.moneytransfer.b.a.a {

    /* renamed from: c  reason: collision with root package name */
    private static a f53547c;

    /* renamed from: a  reason: collision with root package name */
    private final String f53548a = a.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f53549b;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(VolleyError volleyError) {
    }

    public final void a(String str, String str2) {
    }

    public final void a(ArrayList<BeneficiaryEntity> arrayList) {
    }

    public final void a(net.one97.paytm.moneytransfer.a.a aVar) {
    }

    public final void a(a.b bVar) {
    }

    public final boolean a() {
        return false;
    }

    public final void b(String str) {
    }

    public final boolean b() {
        return false;
    }

    public final String c() {
        return null;
    }

    private a(Context context) {
        this.f53549b = context;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f53547c == null) {
                f53547c = new a(context);
            }
            aVar = f53547c;
        }
        return aVar;
    }

    public final void a(a.C0960a aVar, a.c cVar) {
        if (d.c().b(this.f53549b) && this.f53549b != null) {
            String a2 = c.a(c.g().k);
            if (URLUtil.isValidUrl(a2)) {
                HashMap hashMap = new HashMap();
                hashMap.put("transactionType", "APP_FUND_TRANSFER");
                String a3 = a(a2, (HashMap<String, String>) hashMap);
                new HashMap().put("screen_name", getClass().getSimpleName());
                HashMap hashMap2 = new HashMap();
                hashMap2.put("authorization", com.paytm.utility.a.q(this.f53549b));
                hashMap2.put("Content-Type", "application/json");
                if (com.paytm.utility.a.m(this.f53549b)) {
                    f.b(this.f53549b.getApplicationContext()).add(new com.paytm.network.c(this.f53549b, a.c.MONEYTRANSFER, a.C0715a.GET, a3, hashMap2, new Response.Listener() {
                        public final void onResponse(Object obj) {
                            a.d(a.C0960a.this, (IJRPaytmDataModel) obj);
                        }
                    }, new Response.ErrorListener(aVar, a3) {
                        private final /* synthetic */ a.C0960a f$1;
                        private final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onErrorResponse(VolleyError volleyError) {
                            a.this.b(this.f$1, this.f$2, volleyError);
                        }
                    }, new IMPSMetaDataModal(), (String) null));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void d(a.C0960a aVar, IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof IMPSMetaDataModal) {
            aVar.a(iJRPaytmDataModel);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(a.C0960a aVar, String str, VolleyError volleyError) {
        if (volleyError instanceof UpiCustomVolleyError) {
            aVar.a((UpiCustomVolleyError) volleyError);
        } else {
            aVar.a(a(volleyError, str));
        }
    }

    private static String a(String str, HashMap<String, String> hashMap) {
        if (str == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        for (Map.Entry next : hashMap.entrySet()) {
            String str2 = (String) next.getKey();
            String str3 = (String) next.getValue();
            if (sb.length() <= 1 || !sb.toString().contains("?")) {
                sb.append("?");
                sb.append(str2);
                sb.append("=");
                sb.append(str3);
            } else {
                sb.append(AppConstants.AND_SIGN);
                sb.append(str2);
                sb.append("=");
                sb.append(str3);
            }
        }
        return sb.toString();
    }

    public final void a(a.C1382a aVar, String str) {
        net.one97.paytm.upi.profile.b.b.a.a(this.f53549b).a(aVar);
    }

    public final void b(a.C0960a aVar, a.c cVar) {
        if (this.f53549b != null) {
            String a2 = c.a(c.g().m);
            if (URLUtil.isValidUrl(a2)) {
                String e2 = b.e(this.f53549b, a2);
                HashMap hashMap = new HashMap();
                hashMap.put("User-Token", com.paytm.utility.a.q(this.f53549b));
                hashMap.put("Content-Type", "application/json");
                if (com.paytm.utility.a.m(this.f53549b)) {
                    f.b(this.f53549b.getApplicationContext()).add(new com.paytm.network.c(this.f53549b, a.c.MONEYTRANSFER, a.C0715a.GET, e2, hashMap, new Response.Listener() {
                        public final void onResponse(Object obj) {
                            a.c(a.C0960a.this, (IJRPaytmDataModel) obj);
                        }
                    }, new Response.ErrorListener(aVar, e2) {
                        private final /* synthetic */ a.C0960a f$1;
                        private final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onErrorResponse(VolleyError volleyError) {
                            a.this.a(this.f$1, this.f$2, volleyError);
                        }
                    }, new CustProductListV2(), (String) null));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(a.C0960a aVar, IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CustProductListV2) {
            aVar.a(iJRPaytmDataModel);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(a.C0960a aVar, String str, VolleyError volleyError) {
        if (volleyError instanceof UpiCustomVolleyError) {
            aVar.a((UpiCustomVolleyError) volleyError);
        } else {
            aVar.a(a(volleyError, str));
        }
    }

    public final void a(final a.C0960a aVar, String str, String str2) {
        if (com.paytm.utility.a.m(this.f53549b)) {
            String bankUrl = UpiGTMLoader.getInstance().getBankUrl();
            if (URLUtil.isValidUrl(bankUrl)) {
                String addAuthDefaultParams = UpiAppUtils.addAuthDefaultParams(this.f53549b, bankUrl);
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ifscCode", str2);
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                    jSONObject.put("channel", UpiConstants.MP_ANDROID);
                    String appVersionName = UpiAppUtils.getAppVersionName(this.f53549b);
                    if (appVersionName != null) {
                        jSONObject.put("version", appVersionName);
                    }
                } catch (Exception unused) {
                }
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", i.a().f66980a);
                hashMap.put("Content-Type", "application/json");
                com.paytm.network.b a2 = net.one97.paytm.moneytransfer.utils.d.a();
                a2.f42882f = hashMap;
                a2.f42880d = addAuthDefaultParams;
                a2.f42883g = null;
                a2.f42884h = jSONObject.toString();
                a2.f42885i = new CJRBankDetails();
                a2.j = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        aVar.a(iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                        StringBuilder sb = new StringBuilder();
                        sb.append(networkCustomError.getStatusCode());
                        upiCustomVolleyError.setAlertMessage(sb.toString());
                    }
                };
                a2.l().a();
            }
        }
    }

    public final void a(String str) {
        f.b(this.f53549b).cancelAll((Object) str);
    }

    public final void a(String str, String str2, String str3, String str4, String str5, String str6, CLRemoteResultReceiver cLRemoteResultReceiver, String str7, String str8, String str9, String str10, String str11, List<BankAccountDetails.BankAccountCredentials> list, String str12) {
        final String str13 = str;
        final String str14 = str2;
        final String str15 = str3;
        final String str16 = str4;
        final String str17 = str5;
        final String str18 = str6;
        final CLRemoteResultReceiver cLRemoteResultReceiver2 = cLRemoteResultReceiver;
        final String str19 = str7;
        final String str20 = str8;
        final String str21 = str9;
        final String str22 = str10;
        AnonymousClass7 r16 = r0;
        final String str23 = str11;
        Context context = this.f53549b;
        final List<BankAccountDetails.BankAccountCredentials> list2 = list;
        final String str24 = str12;
        AnonymousClass7 r0 = new a.C1347a() {
            public final void onServiceConnected() {
                GetCredentialsApiBuilder.getPinFromCommonLib(a.this.f53549b, str13, str14, str15, str16, str17, str18, cLRemoteResultReceiver2, str19, str20, str21, str22, str23, list2, str24);
            }

            public final void onServiceDisconnected() {
                throw new IllegalStateException("CL Services is null");
            }
        };
        net.one97.paytm.upi.h.a.a(context, r16);
    }

    public final void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, UpiProfileDefaultBank upiProfileDefaultBank, String str11, String str12, CommonPayParams commonPayParams, String str13, String str14) {
        net.one97.paytm.upi.profile.b.b.a a2 = net.one97.paytm.upi.profile.b.b.a.a(this.f53549b);
        a2.a(aVar, str2, UpiRequestBuilder.CommonPayVPA.getCommonPayVpaUrl(a2.f67892a, true), UpiRequestBuilder.CommonPayVPA.getParamsForBankAccount(a2.f67892a, str, str3, str4, str5, str6, str7, str8, str9, str10, upiProfileDefaultBank, str11, commonPayParams, str13, str14), UpiRequestBuilder.getHeaders(a2.f67892a), 24, str12);
    }

    public final void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, UpiProfileDefaultBank upiProfileDefaultBank, String str12, boolean z, String str13, CommonPayParams commonPayParams, String str14, String str15) {
        a.C1382a aVar2 = aVar;
        net.one97.paytm.upi.profile.b.b.a.a(this.f53549b).a(aVar, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, upiProfileDefaultBank, str12, z, str13, commonPayParams, str14, str15);
    }

    public final void a(a.C1382a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, UpiProfileDefaultBank upiProfileDefaultBank, String str9, String str10) {
        net.one97.paytm.upi.profile.b.b.a.a(this.f53549b).a(aVar, str, str2, str3, str4, str5, str6, str7, str8, upiProfileDefaultBank, str9, str10, "");
    }

    public final void a(final a.C0960a aVar, a.b bVar) {
        if (com.paytm.utility.a.m(this.f53549b)) {
            Context context = this.f53549b;
            AnonymousClass8 r6 = new Response.Listener<IJRPaytmDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
                    if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof CJRKYCBeneficiaryBase)) {
                        aVar.a(new UpiCustomVolleyError((Throwable) new VolleyError()));
                        return;
                    }
                    aVar.a(iJRPaytmDataModel);
                }
            };
            AnonymousClass9 r7 = new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    if (volleyError instanceof UpiCustomVolleyError) {
                        aVar.a((UpiCustomVolleyError) volleyError);
                    } else {
                        aVar.a(a.this.a(volleyError, (String) null));
                    }
                }
            };
            if (context != null) {
                String a2 = c.a(c.g().q);
                if (URLUtil.isValidUrl(a2)) {
                    d.c();
                    HashMap hashMap = new HashMap();
                    hashMap.put("session_token", com.paytm.utility.a.q(context));
                    f.b(context).add(new com.paytm.network.c(context, a.c.MONEYTRANSFER, a.C0715a.GET, b.e(context, a2) + "&type=upi,otherBank", hashMap, r6, r7, new CJRKYCBeneficiaryBase(), ""));
                }
            }
        }
    }

    public final void a(final a.C0960a aVar, a.b bVar, int i2, int i3) {
        if (com.paytm.utility.a.m(this.f53549b)) {
            h.a(this.f53549b, new Response.Listener<IJRPaytmDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
                    if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof CJRKYCBeneficiaryBase)) {
                        aVar.a(new UpiCustomVolleyError((Throwable) new VolleyError()));
                        return;
                    }
                    aVar.a(iJRPaytmDataModel);
                }
            }, new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    if (volleyError instanceof UpiCustomVolleyError) {
                        aVar.a((UpiCustomVolleyError) volleyError);
                    } else {
                        aVar.a(a.this.a(volleyError, (String) null));
                    }
                }
            }, i2, i3);
        }
    }

    public final void a(a.C0960a aVar, String str, String str2, String str3, String str4) {
        final a.C0960a aVar2 = aVar;
        String str5 = str;
        String str6 = str2;
        BeneficiaryEntity beneficiaryEntity = new BeneficiaryEntity();
        if (UpiAppUtils.checkIsVpa(str)) {
            BeneficiaryEntity.InstrumentPreferences instrumentPreferences = new BeneficiaryEntity.InstrumentPreferences();
            BeneficiaryEntity.UPI upi = new BeneficiaryEntity.UPI();
            ArrayList<BeneficiaryEntity.UPIAccount> arrayList = new ArrayList<>();
            BeneficiaryEntity.UPIAccount uPIAccount = new BeneficiaryEntity.UPIAccount();
            BeneficiaryEntity.Source source = new BeneficiaryEntity.Source();
            source.upi = "ENABLED";
            source.wallet = "DISABLED";
            source.oba = "DISABLED";
            BeneficiaryEntity.UPIAccountDetail uPIAccountDetail = new BeneficiaryEntity.UPIAccountDetail();
            uPIAccountDetail.vpa = str5;
            uPIAccountDetail.accountHolderName = str6;
            uPIAccount.source = source;
            uPIAccount.accountDetail = uPIAccountDetail;
            arrayList.add(uPIAccount);
            instrumentPreferences.upi = upi;
            instrumentPreferences.upi.accounts = arrayList;
            beneficiaryEntity.instrumentPreferences = instrumentPreferences;
        } else {
            BeneficiaryEntity.InstrumentPreferences instrumentPreferences2 = new BeneficiaryEntity.InstrumentPreferences();
            BeneficiaryEntity.OtherBank otherBank = new BeneficiaryEntity.OtherBank();
            ArrayList<BeneficiaryEntity.OtherBankAccount> arrayList2 = new ArrayList<>();
            BeneficiaryEntity.OtherBankAccount otherBankAccount = new BeneficiaryEntity.OtherBankAccount();
            BeneficiaryEntity.Source source2 = new BeneficiaryEntity.Source();
            source2.upi = "ENABLED";
            source2.wallet = "ENABLED";
            source2.oba = "ENABLED";
            BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = new BeneficiaryEntity.OtherBankAccountDetail();
            otherBankAccountDetail.accountNumber = str5;
            otherBankAccountDetail.accountHolderName = str6;
            otherBankAccountDetail.ifscCode = str3;
            otherBankAccountDetail.bankName = str4;
            otherBankAccount.source = source2;
            otherBankAccount.accountDetail = otherBankAccountDetail;
            arrayList2.add(otherBankAccount);
            instrumentPreferences2.otherBank = otherBank;
            instrumentPreferences2.otherBank.accounts = arrayList2;
            beneficiaryEntity.instrumentPreferences = instrumentPreferences2;
        }
        String a2 = c.a(c.g().n);
        if (URLUtil.isValidUrl(a2)) {
            final String e2 = b.e(this.f53549b, a2);
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", com.paytm.utility.a.q(this.f53549b));
            hashMap.put("Content-Type", "application/json");
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray.put(new JSONObject(new com.google.gsonhtcfix.f().a((Object) beneficiaryEntity)));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            f.b(this.f53549b.getApplicationContext()).add(new com.paytm.network.c(this.f53549b, a.c.MONEYTRANSFER, a.C0715a.POST, e2, hashMap, new Response.Listener<IJRPaytmDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    aVar2.a((IJRPaytmDataModel) obj);
                }
            }, new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    if (volleyError instanceof UpiCustomVolleyError) {
                        aVar2.a((UpiCustomVolleyError) volleyError);
                    } else {
                        aVar2.a(a.this.a(volleyError, e2));
                    }
                }
            }, new CJRAddBeneficiary(), jSONArray.toString()));
        }
    }

    public final void a(final a.C0960a aVar, String str) {
        if (com.paytm.utility.a.m(this.f53549b)) {
            f.b(this.f53549b).add(new com.paytm.network.c(this.f53549b, a.c.MONEYTRANSFER, a.C0715a.GET, UpiAppUtils.getConsolidatePaymentInstUrl(new Object[0]), UpiAppUtils.getConsolidatePaymentInstHeader(this.f53549b, str), new Response.Listener<IJRPaytmDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
                    if (iJRPaytmDataModel instanceof ConsolidatePaymentInstrumentationRes) {
                        aVar.a((IJRPaytmDataModel) (ConsolidatePaymentInstrumentationRes) iJRPaytmDataModel);
                        return;
                    }
                    aVar.a((UpiCustomVolleyError) null);
                }
            }, new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    String str;
                    CJRIllegalCodeError cJRIllegalCodeError;
                    UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError((Throwable) volleyError);
                    NetworkResponse networkResponse = volleyError.networkResponse;
                    if (networkResponse != null) {
                        String str2 = networkResponse.headers.get("Content-Encoding");
                        if (networkResponse.data != null) {
                            if (str2 == null || !str2.equals("gzip")) {
                                str = new String(networkResponse.data);
                                cJRIllegalCodeError = (CJRIllegalCodeError) new com.google.gsonhtcfix.f().a(str, new CJRIllegalCodeError().getClass());
                                if (!(cJRIllegalCodeError == null || cJRIllegalCodeError.getErrorCode() == null)) {
                                    upiCustomVolleyError.setmErrorCode(cJRIllegalCodeError.getErrorCode());
                                }
                                aVar.a(upiCustomVolleyError);
                            }
                            Reader a2 = g.a(networkResponse.data);
                            if (a2 != null) {
                                str = g.a(a2);
                                cJRIllegalCodeError = (CJRIllegalCodeError) new com.google.gsonhtcfix.f().a(str, new CJRIllegalCodeError().getClass());
                                upiCustomVolleyError.setmErrorCode(cJRIllegalCodeError.getErrorCode());
                                aVar.a(upiCustomVolleyError);
                            }
                        }
                    }
                    str = "";
                    try {
                        cJRIllegalCodeError = (CJRIllegalCodeError) new com.google.gsonhtcfix.f().a(str, new CJRIllegalCodeError().getClass());
                        upiCustomVolleyError.setmErrorCode(cJRIllegalCodeError.getErrorCode());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        StringBuilder sb = new StringBuilder();
                        sb.append(networkResponse.statusCode);
                        upiCustomVolleyError.setmErrorCode(sb.toString());
                    }
                    aVar.a(upiCustomVolleyError);
                }
            }, new ConsolidatePaymentInstrumentationRes(), (String) null));
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setmErrorCode(UpiConstants.NETWORK_ERROR_CODE);
        aVar.a(upiCustomVolleyError);
        Context context = this.f53549b;
        CustomDialog.showAlert(context, context.getResources().getString(R.string.no_connection), this.f53549b.getResources().getString(R.string.no_internet));
    }

    public final void a(a.C0960a aVar, String str, String str2, boolean z) {
        final a.C0960a aVar2 = aVar;
        Context context = this.f53549b;
        AnonymousClass3 r8 = new Response.Listener<IJRPaytmDataModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                aVar2.a((IJRPaytmDataModel) obj);
            }
        };
        AnonymousClass4 r9 = new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
                aVar2.a(new UpiCustomVolleyError((Throwable) volleyError));
            }
        };
        if (context != null) {
            String a2 = c.a(c.g().p);
            if (URLUtil.isValidUrl(a2)) {
                String e2 = b.e(context, a2);
                HashMap hashMap = new HashMap();
                hashMap.put("session_token", com.paytm.utility.a.q(context));
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
                } catch (Exception e3) {
                    if (b.v) {
                        e3.printStackTrace();
                    }
                }
                f.b(context.getApplicationContext()).add(new com.paytm.network.c(context, a.c.MONEYTRANSFER, a.C0715a.POST, e2, hashMap, r8, r9, new CJRAddBeneficiary(), jSONArray.toString()));
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.one97.paytm.upi.common.UpiCustomVolleyError a(com.android.volley.VolleyError r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = 0
            java.lang.String r1 = "net.one97.paytm.app.b"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x006f }
            r1.newInstance()     // Catch:{ Exception -> 0x006f }
            java.lang.reflect.Field[] r1 = r1.getDeclaredFields()     // Catch:{ Exception -> 0x006f }
            int r2 = r1.length     // Catch:{ Exception -> 0x006f }
            r3 = 0
            r4 = r0
            r5 = r4
            r6 = r5
        L_0x0013:
            if (r3 >= r2) goto L_0x0076
            r7 = r1[r3]     // Catch:{ Exception -> 0x006d }
            r8 = 1
            r7.setAccessible(r8)     // Catch:{ Exception -> 0x006d }
            java.lang.String r8 = r7.getName()     // Catch:{ Exception -> 0x006d }
            java.lang.String r9 = "mAlertMessage"
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x006d }
            if (r8 == 0) goto L_0x002f
            java.lang.Object r7 = r7.get(r11)     // Catch:{ Exception -> 0x006d }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x006d }
            r0 = r7
            goto L_0x006a
        L_0x002f:
            java.lang.String r8 = r7.getName()     // Catch:{ Exception -> 0x006d }
            java.lang.String r9 = "mAlertTitle"
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x006d }
            if (r8 == 0) goto L_0x0043
            java.lang.Object r7 = r7.get(r11)     // Catch:{ Exception -> 0x006d }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x006d }
            r5 = r7
            goto L_0x006a
        L_0x0043:
            java.lang.String r8 = r7.getName()     // Catch:{ Exception -> 0x006d }
            java.lang.String r9 = "mErrorCode"
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x006d }
            if (r8 == 0) goto L_0x0057
            java.lang.Object r7 = r7.get(r11)     // Catch:{ Exception -> 0x006d }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x006d }
            r6 = r7
            goto L_0x006a
        L_0x0057:
            java.lang.String r8 = r7.getName()     // Catch:{ Exception -> 0x006d }
            java.lang.String r9 = "mUrl"
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x006d }
            if (r8 == 0) goto L_0x006a
            java.lang.Object r7 = r7.get(r11)     // Catch:{ Exception -> 0x006d }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x006d }
            r4 = r7
        L_0x006a:
            int r3 = r3 + 1
            goto L_0x0013
        L_0x006d:
            r11 = move-exception
            goto L_0x0073
        L_0x006f:
            r11 = move-exception
            r4 = r0
            r5 = r4
            r6 = r5
        L_0x0073:
            r11.printStackTrace()
        L_0x0076:
            net.one97.paytm.upi.common.UpiCustomVolleyError r11 = new net.one97.paytm.upi.common.UpiCustomVolleyError
            r11.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0089
            android.content.Context r0 = r10.f53549b
            int r1 = net.one97.paytm.moneytransfer.R.string.some_went_wrong
            java.lang.String r0 = r0.getString(r1)
        L_0x0089:
            r11.setAlertMessage(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r12 = r4
        L_0x0094:
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 != 0) goto L_0x009d
            r11.setUrl(r12)
        L_0x009d:
            boolean r12 = android.text.TextUtils.isEmpty(r5)
            if (r12 != 0) goto L_0x00a6
            r11.setmAlertTitle(r5)
        L_0x00a6:
            boolean r12 = android.text.TextUtils.isEmpty(r6)
            if (r12 != 0) goto L_0x00af
            r11.setmErrorCode(r6)
        L_0x00af:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.b.a.b.a.a(com.android.volley.VolleyError, java.lang.String):net.one97.paytm.upi.common.UpiCustomVolleyError");
    }

    public final void b(final a.C0960a aVar, String str, String str2) {
        if (this.f53549b != null) {
            c g2 = c.g();
            String str3 = c.a(g2.f53992g) + c.a(g2.f53993h);
            if (URLUtil.isValidUrl(str3)) {
                final String e2 = b.e(this.f53549b, str3);
                HashMap hashMap = new HashMap();
                hashMap.put(UpiRequestBuilder.SESSION_TOKEN, com.paytm.utility.a.q(this.f53549b));
                hashMap.put("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("txnId", str);
                    jSONObject.put("scratchCardId", str2);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                f.b(this.f53549b.getApplicationContext()).add(new com.paytm.network.c(this.f53549b, a.c.MONEYTRANSFER, a.C0715a.POST, e2, hashMap, new Response.Listener<IJRPaytmDataModel>() {
                    public final /* synthetic */ void onResponse(Object obj) {
                        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
                        if (iJRPaytmDataModel instanceof CJRClaimCashbackDataModel) {
                            aVar.a(iJRPaytmDataModel);
                        }
                    }
                }, new Response.ErrorListener() {
                    public final void onErrorResponse(VolleyError volleyError) {
                        if (volleyError instanceof UpiCustomVolleyError) {
                            aVar.a((UpiCustomVolleyError) volleyError);
                        } else {
                            aVar.a(a.this.a(volleyError, e2));
                        }
                    }
                }, new CJRClaimCashbackDataModel(), jSONObject.toString()));
            }
        }
    }

    public final void c(a.C0960a aVar, a.c cVar) {
        String pPPCurrentAccountUrl = UpiGTMLoader.getInstance().getPPPCurrentAccountUrl();
        if (URLUtil.isValidUrl(pPPCurrentAccountUrl)) {
            HashMap hashMap = new HashMap();
            hashMap.put("User-Token", com.paytm.utility.a.q(this.f53549b));
            hashMap.put("Content-Type", "application/json");
            if (com.paytm.utility.a.m(this.f53549b)) {
                f.b(this.f53549b.getApplicationContext()).add(new com.paytm.network.c(this.f53549b, a.c.MONEYTRANSFER, a.C0715a.GET, b.e(this.f53549b, pPPCurrentAccountUrl) + "&accType=ICA", hashMap, new Response.Listener() {
                    public final void onResponse(Object obj) {
                        a.b(a.C0960a.this, (IJRPaytmDataModel) obj);
                    }
                }, $$Lambda$a$yNqVOzu0fPO5TWIPNhEyp7SCU.INSTANCE, new PPBCurrentAccountModel(), (String) null));
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(a.C0960a aVar, IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof PPBCurrentAccountModel) {
            aVar.a(iJRPaytmDataModel);
        }
    }

    public final void a(a.C1382a aVar, String str, String str2) {
        net.one97.paytm.upi.profile.b.b.a.a(this.f53549b).a(str2, aVar);
    }

    public final void a(a.C0960a aVar, PaymentManager.PaymentUiModel paymentUiModel) {
        if (this.f53549b != null) {
            String e2 = b.e(this.f53549b, c.a(c.g().v));
            if (com.paytm.utility.a.m(this.f53549b)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("deviceId", UpiUtils.getDeviceId(this.f53549b));
                    jSONObject.put("contactType", e.b.TRANSFER_BENEFICIARY.name());
                    jSONObject.put("contactId", paymentUiModel.getBeneficiaryId());
                    jSONObject.put("paymentInstrumentId", paymentUiModel.getPaymentInstrumentId());
                    jSONObject.put("paymentInstrumentType", paymentUiModel.getPaymentInstrumentType());
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                f.b(this.f53549b).add(new com.paytm.network.c(this.f53549b, a.c.MONEYTRANSFER, a.C0715a.POST, e2, h.a(this.f53549b), new Response.Listener() {
                    public final void onResponse(Object obj) {
                        a.C0960a.this.a((IJRPaytmDataModel) obj);
                    }
                }, new Response.ErrorListener() {
                    public final void onErrorResponse(VolleyError volleyError) {
                        a.a(a.C0960a.this, volleyError);
                    }
                }, new BeneficiaryDeleteResponse(), jSONObject.toString()));
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(a.C0960a aVar, VolleyError volleyError) {
        if (volleyError instanceof UpiCustomVolleyError) {
            aVar.a((UpiCustomVolleyError) volleyError);
        } else {
            aVar.a(new UpiCustomVolleyError());
        }
    }
}
