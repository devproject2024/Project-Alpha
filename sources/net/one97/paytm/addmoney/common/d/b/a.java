package net.one97.paytm.addmoney.common.d.b;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.fragment.app.Fragment;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.AccountNameModel;
import net.one97.paytm.addmoney.common.model.CJRAccountSummary;
import net.one97.paytm.addmoney.common.paymethodresponse.CJPayMethodResponse;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.i;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.newdesign.addmoney.c.e;
import net.one97.paytm.wallet.newdesign.addmoney.model.AddMoneyOffers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements net.one97.paytm.addmoney.common.d.a {

    /* renamed from: d  reason: collision with root package name */
    private static a f48466d;

    /* renamed from: a  reason: collision with root package name */
    private Context f48467a;

    /* renamed from: b  reason: collision with root package name */
    private Fragment f48468b;

    /* renamed from: c  reason: collision with root package name */
    private String f48469c = this.f48467a.getClass().getSimpleName();

    private a(Context context, Fragment fragment) {
        this.f48467a = context;
        this.f48468b = fragment;
    }

    public static synchronized a a(Context context, Fragment fragment) {
        a aVar;
        synchronized (a.class) {
            if (f48466d == null) {
                f48466d = new a(context, fragment);
            }
            aVar = f48466d;
        }
        return aVar;
    }

    public final void a(String str) {
        f.b(this.f48467a).cancelAll((Object) str);
        f48466d = null;
    }

    public final void a(final i iVar, String str) {
        g.a().b();
        g.a().a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                iVar.a(upiBaseDataModel);
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                iVar.a(new NetworkCustomError((Throwable) upiCustomVolleyError));
            }
        }, str, this.f48469c);
    }

    public final void b(final i iVar, String str) {
        g.a(net.one97.paytm.upi.h.a.a(this.f48467a, (a.C1347a) null)).e(new a.C1389a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                iVar.a(upiBaseDataModel);
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                iVar.a(new NetworkCustomError((Throwable) upiCustomVolleyError));
            }
        }, str, this.f48469c);
    }

    public final void a(final h hVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Token", com.paytm.utility.a.q(this.f48467a));
        hashMap.put("Content-Type", "application/json");
        hashMap.put("channel", UpiConstants.B2C_ANDROID);
        String e2 = b.e(this.f48467a, net.one97.paytm.helper.a.b().f(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT));
        com.paytm.network.b a2 = net.one97.paytm.addmoney.common.a.a();
        a2.f42877a = this.f48467a;
        a2.o = getClass().getSimpleName();
        a2.f42880d = e2;
        a2.f42882f = hashMap;
        a2.f42885i = new CustProductList();
        a2.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                hVar.a(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                hVar.b(networkCustomError);
            }
        };
        com.paytm.network.a l = a2.l();
        l.a((Object) str);
        l.a();
    }

    public final void b(final h hVar, String str) {
        net.one97.paytm.helper.a.b().a(this.f48467a, (e) new e() {
            public final void a(String str) {
                hVar.a(new AccountNameModel(str));
            }

            public final void b(String str) {
                hVar.a(new AccountNameModel(str));
            }
        });
    }

    public final void a(h hVar, String str, String str2, int i2, String str3) {
        Context context = this.f48467a;
        Fragment fragment = this.f48468b;
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        net.one97.paytm.addmoney.addmoneysource.a.c.b.a((net.one97.paytm.addmoney.addmoneysource.a.c.a) net.one97.paytm.addmoney.addmoneysource.a.c.a.a.a(context), (net.one97.paytm.addmoney.addmoneysource.a.c.a) net.one97.paytm.addmoney.addmoneysource.a.c.b.a.a(context, fragment)).a(hVar, str, str2, i2, str3);
    }

    public final void b(h hVar, String str, String str2, int i2, String str3) {
        net.one97.paytm.addmoney.utils.a aVar = new net.one97.paytm.addmoney.utils.a(this.f48467a, this.f48468b);
        if (b.c(aVar.f48941a)) {
            JSONObject a2 = net.one97.paytm.addmoney.utils.a.a(str, str2, i2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            String b2 = b.b(aVar.f48941a, net.one97.paytm.helper.a.b().f("cartVerify"));
            net.one97.paytm.wallet.utility.f fVar = net.one97.paytm.wallet.utility.f.f72321a;
            String a3 = net.one97.paytm.wallet.utility.f.a(b2);
            net.one97.paytm.wallet.utility.f fVar2 = net.one97.paytm.wallet.utility.f.f72321a;
            String b3 = net.one97.paytm.wallet.utility.f.b(a3);
            new HashMap().put("screen_name", aVar.f48941a.getClass().getSimpleName());
            com.paytm.network.b b4 = net.one97.paytm.addmoney.common.a.b();
            b4.f42885i = new CJRRechargeCart();
            b4.f42880d = b3;
            b4.f42884h = a2.toString();
            b4.f42882f = hashMap;
            b4.j = new com.paytm.network.listener.b(hVar) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ h f48947a;

                {
                    this.f48947a = r2;
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    this.f48947a.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    this.f48947a.b(networkCustomError);
                }
            };
            com.paytm.network.a l = b4.l();
            l.a((Object) str3);
            l.a();
            return;
        }
        hVar.b(new NetworkCustomError(aVar.f48941a.getString(R.string.check_your_network)));
    }

    public final void c(final h hVar, String str) {
        String f2 = net.one97.paytm.helper.a.b().f("check_user_balance_service");
        if (f2 != null) {
            try {
                if (URLUtil.isValidUrl(f2)) {
                    String e2 = b.e(this.f48467a, f2);
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("isDetailInfo", H5Param.DEFAULT_LONG_PRESSO_LOGIN);
                    jSONObject2.put("computeAddableAmount", true);
                    jSONObject.put("request", jSONObject2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("ssotoken", com.paytm.utility.a.q(this.f48467a));
                    hashMap.put("Accept-Encoding", "gzip");
                    if (b.c(this.f48467a)) {
                        com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
                        b2.f42882f = hashMap;
                        b2.f42880d = e2;
                        b2.f42885i = new CJRCashWallet();
                        b2.f42884h = jSONObject.toString();
                        b2.o = getClass().getSimpleName();
                        b2.j = new com.paytm.network.listener.b() {
                            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                hVar.a(iJRPaytmDataModel);
                            }

                            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                hVar.b(networkCustomError);
                            }
                        };
                        com.paytm.network.a l = b2.l();
                        l.a((Object) str);
                        l.a();
                        return;
                    }
                    NetworkCustomError networkCustomError = new NetworkCustomError();
                    networkCustomError.setUrl(e2);
                    hVar.b(networkCustomError);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                NetworkCustomError networkCustomError2 = new NetworkCustomError();
                networkCustomError2.setUrl(f2);
                hVar.b(networkCustomError2);
            }
        }
    }

    public final void a(String str, String str2, String str3, final h hVar, String str4) {
        if (this.f48467a != null) {
            String f2 = net.one97.paytm.helper.a.b().f("getW2BTxnValidation");
            if (URLUtil.isValidUrl(f2)) {
                final String e2 = b.e(this.f48467a, f2);
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(this.f48467a));
                hashMap.put("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(SDKConstants.TXN_TYPE, "PAYER_TO_BANK_TRANSFER");
                    jSONObject2.put("ssoId", b.n(this.f48467a));
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("ifscCode", str);
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject3.put(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject3.put("txnAmount", str3);
                    }
                    jSONObject2.put("additionalParams", jSONObject3);
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, b.o());
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                    jSONObject.put("channel", UpiConstants.MP_ANDROID);
                    String Q = b.Q(this.f48467a);
                    if (Q != null) {
                        jSONObject.put("version", Q);
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    NetworkCustomError networkCustomError = new NetworkCustomError();
                    networkCustomError.setUrl(e2);
                    hVar.b(networkCustomError);
                }
                if (b.c(this.f48467a)) {
                    com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
                    b2.f42882f = hashMap;
                    b2.f42880d = e2;
                    b2.f42885i = new CJRP2BStatus();
                    b2.f42884h = jSONObject.toString();
                    b2.o = getClass().getSimpleName();
                    b2.j = new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            hVar.a(iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            networkCustomError.setUrl(e2);
                            hVar.b(networkCustomError);
                        }
                    };
                    com.paytm.network.a l = b2.l();
                    l.a((Object) str4);
                    l.a();
                    return;
                }
                NetworkCustomError networkCustomError2 = new NetworkCustomError();
                networkCustomError2.setUrl(e2);
                hVar.b(networkCustomError2);
            }
        }
    }

    public final void a(String str, String str2, String str3, final h hVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        String str4 = b.v(this.f48467a) + System.currentTimeMillis();
        try {
            jSONObject2.put(b.f43688a, net.one97.paytm.helper.a.b().f());
            jSONObject2.put(com.paytm.utility.e.aT, str);
            net.one97.paytm.helper.a.b().c(str);
            jSONObject2.put(b.f43690c, str4);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put(StringSet.token, com.paytm.utility.a.q(net.one97.paytm.helper.a.b().j()));
            jSONObject2.put("tokenType", b.a().toUpperCase());
            jSONObject2.put(net.one97.paytm.addmoney.utils.b.f48949a, "1.0");
            jSONObject3.put(b.f43693f, "");
            jSONObject3.put(b.f43694g, "WEB");
            jSONObject3.put(b.f43695h, SDKConstants.KEY_RETAIL);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("currency", "INR");
            jSONObject4.put("value", "100");
            jSONObject3.put(b.f43696i, jSONObject4);
            net.one97.paytm.helper.a.b().b("100");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(SDKConstants.ALL_TYPE);
            jSONArray.put("NB_TOP5");
            jSONObject3.put(b.j, jSONArray);
            jSONObject3.put(b.k, jSONArray);
            jSONObject3.put(b.l, (Object) null);
            jSONObject3.put(b.m, (Object) null);
            jSONObject.put(b.n, jSONObject2);
            jSONObject.put(b.o, jSONObject3);
        } catch (JSONException unused) {
        }
        final String e2 = b.e(this.f48467a, net.one97.paytm.helper.a.b().f("fetch_offline_instrument_v2"));
        com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
        b2.f42882f = hashMap;
        b2.f42880d = e2;
        b2.f42885i = new CJPayMethodResponse();
        b2.f42884h = jSONObject.toString();
        b2.o = getClass().getSimpleName();
        b2.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                hVar.a(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                networkCustomError.setUrl(e2);
                hVar.b(networkCustomError);
            }
        };
        com.paytm.network.a l = b2.l();
        l.a((Object) str3);
        l.a();
    }

    public final void a(String str, String str2, final h hVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization".toLowerCase(), com.paytm.utility.a.q(net.one97.paytm.helper.a.b().j()));
        hashMap.put("Content-Type", "application/json");
        hashMap.put("channel", UpiConstants.B2C_ANDROID);
        String f2 = net.one97.paytm.helper.a.b().f(UpiConstantServiceApi.KEY_FETCH_PAYMENT_BANK_BALANCE_NEW);
        com.paytm.network.b a2 = net.one97.paytm.addmoney.common.a.a();
        a2.f42885i = new CJRAccountSummary();
        a2.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                hVar.a(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                hVar.b(networkCustomError);
            }
        };
        a2.f42882f = hashMap;
        a2.f42880d = f2;
        a2.o = getClass().getSimpleName();
        a2.l().a();
    }

    public final void a(String str, final h hVar) {
        String s = b.s(this.f48467a, net.one97.paytm.helper.a.b().f("PROMOCODE_SEARCH_PRODUCT") + str + "/offers");
        if (URLUtil.isValidUrl(s)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f48467a));
            com.paytm.network.b a2 = net.one97.paytm.addmoney.common.a.a();
            a2.f42880d = s;
            a2.f42885i = new AddMoneyOffers();
            a2.f42882f = hashMap;
            a2.f42877a = this.f48467a;
            a2.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    hVar.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    hVar.b(networkCustomError);
                }
            };
            com.paytm.network.a l = a2.l();
            if (b.c(this.f48467a)) {
                l.a();
            }
        }
    }
}
