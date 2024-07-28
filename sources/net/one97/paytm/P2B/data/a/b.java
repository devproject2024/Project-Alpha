package net.one97.paytm.p2b.data.a;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.paytm.network.a;
import com.paytm.network.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.StringResponseModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.P2B.CJRP2bCheckTxnStatus;
import net.one97.paytm.P2B.CJRP2bTransaction;
import net.one97.paytm.P2B.P2bLimitStatusModel;
import net.one97.paytm.cashback.posttxn.CashbackBaseTagOfferListModel;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRBankDetails;
import net.one97.paytm.common.entity.wallet.CJRLedger;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2b.d.c;
import net.one97.paytm.p2b.d.h;
import net.one97.paytm.p2b.d.i;
import net.one97.paytm.p2b.data.a.a;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static long f12733a = ((long) (h.b().a("w2bPostPayPollingDuration", 5) * 1000));

    /* renamed from: b  reason: collision with root package name */
    private static b f12734b = null;

    /* renamed from: d  reason: collision with root package name */
    private static int f12735d = h.b().a("w2bPostPayMaxPollingCount", 9);

    /* renamed from: c  reason: collision with root package name */
    private Context f12736c;

    /* renamed from: e  reason: collision with root package name */
    private int f12737e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f12738f;

    private b(Context context) {
        this.f12736c = context;
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f12734b == null) {
                f12734b = new b(context);
            }
            bVar = f12734b;
        }
        return bVar;
    }

    public final void a(final a.C0169a aVar, String str, String str2) {
        Context context = this.f12736c;
        if (context != null) {
            AnonymousClass5 r1 = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    aVar.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    aVar.a(networkCustomError);
                }
            };
            if (com.paytm.utility.b.c(context)) {
                String h2 = h.b().h();
                if (URLUtil.isValidUrl(h2)) {
                    String e2 = com.paytm.utility.b.e(context, h2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("ssotoken", h.b().a(context));
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
                        String Q = com.paytm.utility.b.Q(context);
                        if (Q != null) {
                            jSONObject.put("version", Q);
                        }
                    } catch (Exception unused) {
                    }
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = context;
                    bVar.f42878b = a.c.P2B;
                    bVar.f42879c = a.C0715a.POST;
                    bVar.n = a.b.SILENT;
                    bVar.o = "SendMoneyToBankHelper";
                    bVar.f42884h = jSONObject.toString();
                    bVar.f42882f = hashMap;
                    bVar.f42880d = e2;
                    bVar.f42885i = new CJRBankDetails();
                    bVar.j = r1;
                    bVar.x = 0;
                    com.paytm.network.a l = bVar.l();
                    l.a((Object) str2);
                    l.a();
                }
            }
        }
    }

    public final void a(final a.C0169a aVar, String str) {
        String str2;
        Context context = this.f12736c;
        if (context != null) {
            AnonymousClass6 r1 = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    aVar.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    aVar.a(networkCustomError);
                }
            };
            if (context != null) {
                String g2 = h.b().g();
                if (URLUtil.isValidUrl(g2)) {
                    String e2 = com.paytm.utility.b.e(context, g2);
                    if (!e2.contains("?")) {
                        str2 = e2 + "?";
                    } else {
                        str2 = e2 + AppConstants.AND_SIGN;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("session_token", com.paytm.utility.a.q(context));
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = context;
                    bVar.f42878b = a.c.P2B;
                    bVar.f42879c = a.C0715a.GET;
                    bVar.n = a.b.SILENT;
                    bVar.o = "SendMoneyToBankHelper";
                    bVar.f42882f = hashMap;
                    bVar.f42880d = str2 + "source_name=wallet&type=otherBank";
                    bVar.f42885i = new CJRKYCBeneficiaryBase();
                    bVar.j = r1;
                    bVar.x = 0;
                    com.paytm.network.a l = bVar.l();
                    l.a((Object) str);
                    l.a();
                }
            }
        }
    }

    public final void a(String str) {
        Context context = this.f12736c;
        if (context != null && !TextUtils.isEmpty(str)) {
            f.b(context).cancelAll((Object) str);
        }
    }

    public final void b(final a.C0169a aVar, String str) {
        Context context = this.f12736c;
        if (context != null && com.paytm.utility.b.c(context)) {
            i.a(this.f12736c, (com.paytm.network.listener.b) new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    aVar.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    aVar.a(networkCustomError);
                }
            }, str);
        }
    }

    public final void a(String str, String str2, String str3, String str4, boolean z, a.C0169a aVar, String str5) {
        boolean z2 = z;
        Context context = this.f12736c;
        if (context != null) {
            final a.C0169a aVar2 = aVar;
            AnonymousClass8 r3 = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    aVar2.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    aVar2.a(networkCustomError);
                }
            };
            if (context != null) {
                BeneficiaryEntity beneficiaryEntity = new BeneficiaryEntity();
                BeneficiaryEntity.InstrumentPreferences instrumentPreferences = new BeneficiaryEntity.InstrumentPreferences();
                BeneficiaryEntity.OtherBank otherBank = new BeneficiaryEntity.OtherBank();
                ArrayList<BeneficiaryEntity.OtherBankAccount> arrayList = new ArrayList<>();
                BeneficiaryEntity.OtherBankAccount otherBankAccount = new BeneficiaryEntity.OtherBankAccount();
                BeneficiaryEntity.Source source = new BeneficiaryEntity.Source();
                source.upi = "disabled";
                source.wallet = "enabled";
                source.oba = "disabled";
                BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = new BeneficiaryEntity.OtherBankAccountDetail();
                otherBankAccountDetail.accountNumber = str;
                otherBankAccountDetail.accountHolderName = str3;
                otherBankAccountDetail.ifscCode = str2;
                otherBankAccountDetail.bankName = str4;
                otherBankAccount.source = source;
                if (z2) {
                    otherBankAccount.self = z2;
                    if (!TextUtils.isEmpty(com.paytm.utility.b.l(context))) {
                        otherBankAccountDetail.beneficiaryPhone = "91" + com.paytm.utility.b.l(context);
                    }
                }
                otherBankAccount.accountDetail = otherBankAccountDetail;
                arrayList.add(otherBankAccount);
                instrumentPreferences.otherBank = otherBank;
                instrumentPreferences.otherBank.accounts = arrayList;
                beneficiaryEntity.instrumentPreferences = instrumentPreferences;
                String f2 = h.b().f();
                if (URLUtil.isValidUrl(f2)) {
                    String e2 = com.paytm.utility.b.e(context, f2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("session_token", h.b().a(context));
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("uid", com.paytm.utility.b.n(context));
                    JSONArray jSONArray = new JSONArray();
                    try {
                        jSONArray.put(new JSONObject(new com.google.gson.f().b(beneficiaryEntity)));
                    } catch (JSONException unused) {
                    }
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = context;
                    bVar.f42878b = a.c.P2B;
                    bVar.f42879c = a.C0715a.POST;
                    bVar.n = a.b.SILENT;
                    bVar.o = "SendMoneyToBankHelper";
                    bVar.f42884h = jSONArray.toString();
                    bVar.f42882f = hashMap;
                    bVar.f42880d = e2;
                    bVar.f42885i = new CJRAddBeneficiary();
                    bVar.j = r3;
                    bVar.x = 0;
                    com.paytm.network.a l = bVar.l();
                    l.a((Object) str5);
                    l.a();
                }
            }
        }
    }

    public final void a(final a.C0169a aVar, String str, String str2, String str3, boolean z, String str4) {
        Context context = this.f12736c;
        if (context != null) {
            AnonymousClass9 r1 = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    aVar.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    aVar.a(networkCustomError);
                }
            };
            if (context != null) {
                String a2 = h.b().a("getW2BTxnValidation", "https://trust.paytm.in/wallet-web/services/v2/txnValidation");
                if (URLUtil.isValidUrl(a2)) {
                    String e2 = com.paytm.utility.b.e(context, a2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("ssotoken", h.b().a(context));
                    hashMap.put("Content-Type", "application/json");
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    if (z) {
                        try {
                            jSONObject2.put(SDKConstants.TXN_TYPE, "CC_PAYER_TO_BANK_TRANSFER");
                        } catch (JSONException unused) {
                        }
                    } else {
                        jSONObject2.put(SDKConstants.TXN_TYPE, "PAYER_TO_BANK_TRANSFER");
                    }
                    jSONObject2.put("ssoId", com.paytm.utility.b.n(context));
                    JSONObject jSONObject3 = new JSONObject();
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject3.put(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, str3);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject3.put("ifscCode", str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject3.put("txnAmount", str2);
                    }
                    jSONObject2.put("additionalParams", jSONObject3);
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                    jSONObject.put("channel", UpiConstants.MP_ANDROID);
                    String Q = com.paytm.utility.b.Q(context);
                    if (Q != null) {
                        jSONObject.put("version", Q);
                    }
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = context;
                    bVar.f42878b = a.c.P2B;
                    bVar.f42879c = a.C0715a.POST;
                    bVar.n = a.b.SILENT;
                    bVar.o = "SendMoneyToBankHelper";
                    bVar.f42884h = jSONObject.toString();
                    bVar.f42882f = hashMap;
                    bVar.f42880d = e2;
                    bVar.f42885i = new CJRP2BStatus();
                    bVar.j = r1;
                    bVar.x = 0;
                    com.paytm.network.a l = bVar.l();
                    l.a((Object) str4);
                    l.a();
                }
            }
        }
    }

    public final void a(String str, String str2, final a.C0169a aVar, String str3) {
        Context context = this.f12736c;
        if (context != null) {
            AnonymousClass10 r1 = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    aVar.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    aVar.a(networkCustomError);
                }
            };
            if (context != null) {
                String b2 = h.b().b();
                if (URLUtil.isValidUrl(b2)) {
                    String e2 = com.paytm.utility.b.e(context, b2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("session_token", h.b().a(context));
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("reference_number", str2);
                    hashMap.put("otp", str);
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = context;
                    bVar.f42878b = a.c.P2B;
                    bVar.f42879c = a.C0715a.POST;
                    bVar.n = a.b.SILENT;
                    bVar.o = "SendMoneyToBankHelper";
                    bVar.f42884h = "";
                    bVar.f42882f = hashMap;
                    bVar.f42880d = e2;
                    bVar.f42885i = new CJRAddBeneficiary();
                    bVar.j = r1;
                    bVar.x = 0;
                    com.paytm.network.a l = bVar.l();
                    l.a((Object) str3);
                    l.a();
                }
            }
        }
    }

    public final void a(BeneficiaryEntity beneficiaryEntity, boolean z, final a.C0169a aVar, String str) {
        Context context = this.f12736c;
        AnonymousClass11 r1 = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                aVar.a(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                aVar.a(networkCustomError);
            }
        };
        if (context != null) {
            if (z) {
                beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).self = z;
                if (!TextUtils.isEmpty(com.paytm.utility.b.l(context))) {
                    BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail;
                    otherBankAccountDetail.beneficiaryPhone = "91" + com.paytm.utility.b.l(context);
                }
            }
            String d2 = h.b().d();
            if (URLUtil.isValidUrl(d2)) {
                String e2 = com.paytm.utility.b.e(context, d2);
                HashMap hashMap = new HashMap();
                hashMap.put("session_token", h.b().a(context));
                hashMap.put("Content-Type", "application/json");
                hashMap.put("uid", com.paytm.utility.b.n(context));
                JSONArray jSONArray = new JSONArray();
                try {
                    jSONArray.put(new JSONObject(new com.google.gson.f().b(beneficiaryEntity)));
                } catch (JSONException unused) {
                }
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = context;
                bVar.f42878b = a.c.P2B;
                bVar.f42879c = a.C0715a.POST;
                bVar.n = a.b.SILENT;
                bVar.o = "SendMoneyToBankHelper";
                bVar.f42884h = jSONArray.toString();
                bVar.f42882f = hashMap;
                bVar.f42880d = e2;
                bVar.f42885i = new CJRAddBeneficiary();
                bVar.j = r1;
                bVar.x = 0;
                com.paytm.network.a l = bVar.l();
                l.a((Object) str);
                l.a();
            }
        }
    }

    public final void b(final a.C0169a aVar, String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            Context context = this.f12736c;
            AnonymousClass1 r1 = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    aVar.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    aVar.a(networkCustomError);
                }
            };
            if (context != null) {
                String c2 = h.b().c();
                if (URLUtil.isValidUrl(c2)) {
                    String e2 = com.paytm.utility.b.e(context, c2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("ssoid", com.paytm.utility.b.n(context));
                    hashMap.put("ssotoken", h.b().a(context));
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("startLimit", 0);
                        jSONObject.put("lastLimit", 1);
                        jSONObject.put("id", str);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("alipay", false);
                        jSONObject2.put("request", jSONObject);
                        str3 = jSONObject2.toString();
                    } catch (JSONException unused) {
                        str3 = "";
                    }
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = context;
                    bVar.f42878b = a.c.P2B;
                    bVar.f42879c = a.C0715a.POST;
                    bVar.n = a.b.SILENT;
                    bVar.o = "SendMoneyToBankHelper";
                    bVar.f42884h = str3.toString();
                    bVar.f42882f = hashMap;
                    bVar.f42880d = e2;
                    bVar.f42885i = new CJRLedger();
                    bVar.j = r1;
                    bVar.x = 0;
                    com.paytm.network.a l = bVar.l();
                    l.a((Object) str2);
                    l.a();
                }
            }
        }
    }

    public final void a(final a.C0169a aVar, String str, String str2, double d2, String str3) {
        Context context = this.f12736c;
        AnonymousClass2 r2 = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                aVar.a(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                aVar.a(networkCustomError);
            }
        };
        String a2 = h.b().a();
        if (URLUtil.isValidUrl(a2)) {
            String a3 = h.b().a(context.getApplicationContext());
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ssotoken", a3);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ssoId", com.paytm.utility.b.n(context));
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put("P2B_TRANSFER");
                jSONArray.put(d2);
                jSONObject2.put("walletOperationTypeList", jSONArray2);
                jSONObject2.put("walletOperationTypeBasedAmountList", jSONArray);
                jSONObject2.put("walletOperationtype", "P2B_TRANSFER");
                jSONObject2.put("destAccNo", str);
                jSONObject2.put("destIfsc", str2);
                jSONObject.put("request", jSONObject2);
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "WALLET_LIMIT");
                jSONObject.put("channel", UpiConstants.MP_ANDROID);
            } catch (JSONException unused) {
            }
            new HashMap().put("screen_name", context.getClass().getSimpleName());
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = context;
            bVar.f42879c = a.C0715a.POST;
            bVar.n = a.b.SILENT;
            bVar.o = "SendMoneyToBankHelper";
            bVar.f42884h = jSONObject.toString();
            bVar.f42882f = hashMap;
            bVar.f42880d = a2;
            bVar.f42878b = a.c.P2B;
            bVar.f42885i = new P2bLimitStatusModel();
            bVar.j = r2;
            bVar.x = 0;
            com.paytm.network.a l = bVar.l();
            l.a((Object) str3);
            l.a();
        }
    }

    public final void a() {
        this.f12738f = System.currentTimeMillis();
        this.f12737e = 0;
    }

    public final void a(String str, Context context, com.paytm.network.listener.b bVar, String str2) {
        try {
            String e2 = com.paytm.utility.b.e(context, str);
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", com.paytm.utility.b.n(context));
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put("Content-Type", "application/json");
            com.paytm.network.b bVar2 = new com.paytm.network.b();
            bVar2.f42877a = context;
            bVar2.f42878b = a.c.P2B;
            bVar2.f42879c = a.C0715a.POST;
            bVar2.n = a.b.SILENT;
            bVar2.o = "SendMoneyToBankHelper";
            bVar2.f42882f = hashMap;
            bVar2.f42880d = e2;
            bVar2.f42885i = new StringResponseModel();
            bVar2.j = bVar;
            bVar2.x = 0;
            com.paytm.network.a l = bVar2.l();
            l.a((Object) str2);
            l.a();
        } catch (Exception unused) {
        }
    }

    public final void a(Context context, com.paytm.network.listener.b bVar, String str) {
        try {
            String a2 = h.b().a("offerTagP2b", "Wallet To Bank Transfer Offers");
            String a3 = h.b().a("p2b_cashback_url", "https://gateway.paytm.com/api/v4/promocard/supercash/tagoffers");
            if (a3 == null) {
                return;
            }
            if (URLUtil.isValidUrl(a3)) {
                String uri = Uri.parse(com.paytm.utility.b.e(context, a3)).buildUpon().appendQueryParameter("offer_tag", a2).build().toString();
                HashMap hashMap = new HashMap();
                hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(context));
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("Content-Type", "application/json");
                com.paytm.network.b bVar2 = new com.paytm.network.b();
                bVar2.f42877a = context;
                bVar2.f42878b = a.c.P2B;
                bVar2.f42879c = a.C0715a.GET;
                bVar2.n = a.b.SILENT;
                bVar2.o = "SendMoneyToBank";
                bVar2.f42882f = hashMap;
                bVar2.f42880d = uri;
                bVar2.f42885i = new CashbackBaseTagOfferListModel();
                bVar2.j = bVar;
                bVar2.x = 0;
                com.paytm.network.a l = bVar2.l();
                l.a((Object) str);
                l.a();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public boolean b() {
        long currentTimeMillis = System.currentTimeMillis() - this.f12738f;
        int i2 = f12735d;
        return currentTimeMillis <= ((long) i2) * f12733a && this.f12737e < i2;
    }

    public final void a(String str, String str2, String str3, a.C0169a aVar) {
        this.f12737e++;
        Context context = this.f12736c;
        final a.C0169a aVar2 = aVar;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        AnonymousClass4 r1 = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof CJRP2bCheckTxnStatus) {
                    CJRP2bCheckTxnStatus cJRP2bCheckTxnStatus = (CJRP2bCheckTxnStatus) iJRPaytmDataModel;
                    if (!TextUtils.isEmpty(cJRP2bCheckTxnStatus.getStatus()) && cJRP2bCheckTxnStatus.getStatus().equalsIgnoreCase("SUCCESS") && cJRP2bCheckTxnStatus.getResponse() != null && cJRP2bCheckTxnStatus.getResponse().getTxnList().size() > 0) {
                        CJRP2bTransaction cJRP2bTransaction = cJRP2bCheckTxnStatus.getResponse().getTxnList().get(0);
                        if (TextUtils.isEmpty(cJRP2bTransaction.getMessage()) || !c.Z.contains(cJRP2bTransaction.getMessage())) {
                            b.a(b.this, str4, str5, str6, aVar2);
                            return;
                        }
                    } else if ((TextUtils.isEmpty(cJRP2bCheckTxnStatus.getStatus()) || !cJRP2bCheckTxnStatus.getStatus().equalsIgnoreCase("FAILURE")) && b.this.b()) {
                        b.a(b.this, str4, str5, str6, aVar2);
                        return;
                    }
                    b.this.a();
                    aVar2.a(iJRPaytmDataModel);
                } else if (b.this.b()) {
                    b.a(b.this, str4, str5, str6, aVar2);
                } else {
                    b.this.a();
                    aVar2.a((NetworkCustomError) null);
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (b.this.b()) {
                    b.a(b.this, str4, str5, str6, aVar2);
                    return;
                }
                b.this.a();
                aVar2.a(networkCustomError);
            }
        };
        String a2 = h.b().a("check_p2b_transaction_status", "");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(context, a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ssotoken", str2);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("requestType", "walletTxnId");
                jSONObject2.put(SDKConstants.TXN_TYPE, "p2b");
                jSONObject2.put("txnId", str);
                jSONObject.put("request", jSONObject2);
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                jSONObject.put("channel", UpiConstants.MP_ANDROID);
                jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "CHECK_TXN_STATUS");
                String str7 = null;
                try {
                    str7 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                } catch (Exception e3) {
                    if (com.paytm.utility.b.v) {
                        e3.printStackTrace();
                    }
                }
                if (str7 != null) {
                    jSONObject.put("version", str7);
                }
            } catch (JSONException e4) {
                if (com.paytm.utility.b.v) {
                    e4.printStackTrace();
                }
            }
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = context;
            bVar.f42879c = a.C0715a.POST;
            bVar.n = a.b.SILENT;
            bVar.o = "SendMoneyToBankHelper";
            bVar.f42884h = jSONObject.toString();
            bVar.f42882f = hashMap;
            bVar.f42880d = e2;
            bVar.f42885i = new CJRP2bCheckTxnStatus();
            bVar.j = r1;
            bVar.f42878b = a.c.P2B;
            bVar.x = 0;
            com.paytm.network.a l = bVar.l();
            l.a((Object) str3);
            l.a();
        }
    }

    static /* synthetic */ void a(b bVar, String str, String str2, String str3, a.C0169a aVar) {
        if (bVar.b()) {
            try {
                final String str4 = str;
                final String str5 = str2;
                final String str6 = str3;
                final a.C0169a aVar2 = aVar;
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        b.this.a(str4, str5, str6, aVar2);
                    }
                }, f12733a);
            } catch (NumberFormatException unused) {
            }
        } else {
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.setAlertMessage("Max tries exceeded");
            aVar.a(networkCustomError);
            bVar.a();
        }
    }
}
