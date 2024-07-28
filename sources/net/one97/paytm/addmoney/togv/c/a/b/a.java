package net.one97.paytm.addmoney.togv.c.a.b;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.network.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.SendMoneyP2PLimitStatusModel;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.addmoney.utils.p;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.newdesign.addmoney.model.ConsolidatePaymentInstrumentationRes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class a implements net.one97.paytm.addmoney.togv.c.a.a {

    /* renamed from: e  reason: collision with root package name */
    private static a f48681e;

    /* renamed from: a  reason: collision with root package name */
    private final String f48682a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Context f48683b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f48684c;

    /* renamed from: d  reason: collision with root package name */
    private p f48685d;

    /* renamed from: f  reason: collision with root package name */
    private int f48686f = net.one97.paytm.helper.a.b().h("addmoney_total_polling_count");

    /* renamed from: g  reason: collision with root package name */
    private int f48687g = net.one97.paytm.helper.a.b().h("addMoney_polling_gap_in_seconds");

    /* renamed from: h  reason: collision with root package name */
    private long f48688h = TimeUnit.SECONDS.toMillis((long) this.f48687g);

    /* renamed from: i  reason: collision with root package name */
    private int f48689i = 0;

    private a(Context context, Activity activity) {
        this.f48683b = context;
        this.f48684c = activity;
        this.f48689i = 0;
    }

    public static synchronized a a(Context context, Activity activity) {
        a aVar;
        synchronized (a.class) {
            if (f48681e == null) {
                f48681e = new a(context, activity);
            }
            aVar = f48681e;
        }
        return aVar;
    }

    public final void a(String str) {
        f.b(this.f48683b).cancelAll((Object) str);
        f48681e = null;
    }

    public final void a(final h hVar, String str, String str2) {
        this.f48685d = new p(this.f48683b);
        new HashMap().put("screen_name", this.f48683b.getClass().getSimpleName());
        if (b.c(this.f48683b)) {
            com.paytm.network.b a2 = net.one97.paytm.addmoney.common.a.a();
            p pVar = this.f48685d;
            new Object[1][0] = str;
            a2.f42880d = pVar.a();
            a2.f42877a = this.f48683b;
            a2.f42885i = new ConsolidatePaymentInstrumentationRes();
            a2.o = this.f48683b.getClass().getSimpleName();
            p pVar2 = this.f48685d;
            Object[] objArr = {str};
            HashMap hashMap = new HashMap();
            String str3 = (!TextUtils.isEmpty(b.af(pVar2.f49000a)) ? b.af(pVar2.f49000a) : "") + System.currentTimeMillis();
            hashMap.put(UpiConstants.DESTINATION_PHONE, (String) objArr[0]);
            hashMap.put(UpiConstants.USER_TOKEN, com.paytm.utility.a.q(pVar2.f49000a));
            hashMap.put(UpiConstants.CACHE_CONTROL, "no-cache");
            hashMap.put(UpiConstants.REQUEST_TOKEN, str3);
            a2.f42882f = hashMap;
            a2.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    hVar.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    hVar.b(networkCustomError);
                }
            };
            a2.l().a();
            return;
        }
        Context context = this.f48683b;
        b.b(context, context.getResources().getString(R.string.no_connection), this.f48683b.getResources().getString(R.string.no_internet));
    }

    public final void a(final h hVar, String str, double d2, String str2, boolean z) {
        String f2 = net.one97.paytm.helper.a.b().f("walletLimitV2");
        String q = com.paytm.utility.a.q(this.f48684c.getApplicationContext());
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("ssotoken", q);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("addMoneyDestination", "GIFT_VOUCHER");
            jSONObject2.put("amount", d2);
            jSONObject2.put("ssoId", b.n(this.f48683b));
            if (z) {
                jSONObject2.put("walletOperationType", "ADD_MONEY");
            } else {
                jSONObject2.put("walletOperationType", "GIFT_GV");
                jSONObject2.put("targetPhoneNo", str2);
            }
            jSONObject.put("request", jSONObject2);
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
            jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "WALLET_LIMIT");
            jSONObject.put("channel", UpiConstants.MP_ANDROID);
        } catch (JSONException e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
        new HashMap().put("screen_name", this.f48684c.getClass().getSimpleName());
        if (b.c((Context) this.f48684c)) {
            com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
            b2.f42880d = f2;
            b2.f42882f = hashMap;
            b2.f42884h = jSONObject.toString();
            b2.o = this.f48684c.getClass().getSimpleName();
            b2.f42885i = new SendMoneyP2PLimitStatusModel();
            b2.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    hVar.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    hVar.b(networkCustomError);
                }
            };
            b2.l().a();
        }
    }

    public final void a(final h hVar, String str, String str2, double d2, String str3, String str4, String str5, boolean z) {
        String str6;
        JSONObject a2 = a(d2, str3, str4, str5, z);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        net.one97.paytm.helper.a.b().k();
        net.one97.paytm.helper.a.b().a((Context) this.f48684c, (String) null, (String) null, (String) null);
        String d3 = net.one97.paytm.helper.a.b().d();
        if (!TextUtils.isEmpty(d3)) {
            hashMap.put("risk_extended_info", d3);
        }
        net.one97.paytm.helper.a.b().k();
        if (j.a()) {
            net.one97.paytm.helper.a.b();
        }
        String b2 = b.b((Context) this.f48684c, net.one97.paytm.helper.a.b().f("cartCheckout"));
        net.one97.paytm.wallet.utility.f fVar = net.one97.paytm.wallet.utility.f.f72321a;
        String a3 = net.one97.paytm.wallet.utility.f.a(b2);
        net.one97.paytm.wallet.utility.f fVar2 = net.one97.paytm.wallet.utility.f.f72321a;
        String b3 = net.one97.paytm.wallet.utility.f.b(a3);
        String k = b.k();
        if (TextUtils.isEmpty(str2)) {
            str6 = Uri.parse(b3).buildUpon().appendQueryParameter("client_id", k).build().toString();
        } else {
            str6 = Uri.parse(b3).buildUpon().appendQueryParameter("client_id", k).appendQueryParameter("wallet_token", str2).build().toString();
        }
        String d4 = b.d(str6, "POST");
        if (net.one97.paytm.helper.a.b().g("shouldUseUniversalAddMoneyNative7.4") && !TextUtils.isEmpty(d4)) {
            if (d4.contains("?")) {
                d4 = d4 + "&native_withdraw=1";
            } else {
                d4 = d4 + "?native_withdraw=1";
            }
        }
        if (b.c((Context) this.f48684c)) {
            com.paytm.network.b b4 = net.one97.paytm.addmoney.common.a.b();
            b4.f42880d = d4;
            b4.f42882f = hashMap;
            b4.f42877a = this.f48683b;
            b4.f42884h = a2.toString();
            b4.o = this.f48684c.getClass().getSimpleName();
            b4.f42885i = new CJRRechargePayment();
            b4.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    hVar.a(iJRPaytmDataModel);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    hVar.b(networkCustomError);
                }
            };
            b4.l().a();
            return;
        }
        NetworkCustomError networkCustomError = new NetworkCustomError();
        networkCustomError.setmAlertTitle("No Internet");
        networkCustomError.setAlertMessage("You are not connected to internet");
        hVar.b(networkCustomError);
    }

    private static JSONObject a(double d2, String str, String str2, String str3, boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(CLPConstants.PRODUCT_ID, net.one97.paytm.helper.a.b().f("PaytmGiftVoucherProductId"));
            jSONObject2.put("qty", 1);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("price", d2);
            if (!z) {
                jSONObject3.put("targetMobile", str);
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            jSONObject3.put(CJRQRScanResultModel.KEY_COMMENT_SMALL, str2);
            jSONObject3.put("name", str3);
            jSONObject2.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject3);
            jSONArray.put(jSONObject2);
            jSONObject.put("cart_items", jSONArray);
            if (!TextUtils.isEmpty((CharSequence) null)) {
                jSONObject.put(Utility.EVENT_CATEGORY_PROMOCODE, (Object) null);
            }
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public final void a(h hVar, String str, String str2, boolean z) {
        String str3 = net.one97.paytm.helper.a.b().f("orderdetail") + str2;
        net.one97.paytm.wallet.utility.f fVar = net.one97.paytm.wallet.utility.f.f72321a;
        String a2 = net.one97.paytm.wallet.utility.f.a(b.b(this.f48683b, str3) + "&actions=1");
        net.one97.paytm.wallet.utility.f fVar2 = net.one97.paytm.wallet.utility.f.f72321a;
        String b2 = net.one97.paytm.wallet.utility.f.b(a2);
        if (b.c((Context) this.f48684c)) {
            com.paytm.network.b a3 = net.one97.paytm.addmoney.common.a.a();
            a3.f42880d = b2;
            Context context = this.f48683b;
            a3.f42877a = context;
            a3.o = context.getClass().getSimpleName();
            a3.f42885i = new CJROrderSummary();
            final h hVar2 = hVar;
            final boolean z2 = z;
            final String str4 = str;
            final String str5 = str2;
            a3.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    CJROrderSummary cJROrderSummary = (CJROrderSummary) iJRPaytmDataModel;
                    if (cJROrderSummary != null && cJROrderSummary.getOrderedCartList() != null && cJROrderSummary.getOrderedCartList().size() > 0) {
                        int orderStatus = cJROrderSummary.getOrderStatus();
                        String itemStatus = cJROrderSummary.getOrderedCartList().get(0).getItemStatus();
                        if (2 == orderStatus) {
                            if (itemStatus.equalsIgnoreCase("20") || itemStatus.equalsIgnoreCase("7")) {
                                hVar2.a(iJRPaytmDataModel);
                            } else if (itemStatus.equalsIgnoreCase("2") || itemStatus.equalsIgnoreCase("5") || itemStatus.equalsIgnoreCase("15")) {
                                a.a(a.this, cJROrderSummary, z2, hVar2, str4, str5);
                            } else if (itemStatus.equalsIgnoreCase("6") || itemStatus.equalsIgnoreCase("8") || itemStatus.equalsIgnoreCase("18")) {
                                hVar2.a(iJRPaytmDataModel);
                            }
                        } else if (1 == orderStatus || 3 == orderStatus) {
                            a.a(a.this, cJROrderSummary, z2, hVar2, str4, str5);
                        } else if (4 == orderStatus || 8 == orderStatus) {
                            hVar2.a(iJRPaytmDataModel);
                        } else {
                            a.a(a.this, cJROrderSummary, z2, hVar2, str4, str5);
                        }
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    hVar2.b(networkCustomError);
                }
            };
            com.paytm.network.a l = a3.l();
            this.f48689i++;
            l.a();
            return;
        }
        NetworkCustomError networkCustomError = new NetworkCustomError();
        networkCustomError.setmAlertTitle("No Internet");
        networkCustomError.setAlertMessage("You are not connected to internet");
        hVar.b(networkCustomError);
    }

    public final void a(final h hVar, String str) {
        try {
            String f2 = net.one97.paytm.helper.a.b().f("check_user_balance_service");
            if (f2 == null) {
                return;
            }
            if (URLUtil.isValidUrl(f2)) {
                String e2 = b.e(this.f48683b, f2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request", new JSONObject().put("isDetailInfo", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(this.f48683b));
                hashMap.put("Accept-Encoding", "gzip");
                new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this.f48683b));
                b.j();
                if (b.c((Context) this.f48684c)) {
                    com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
                    b2.f42880d = e2;
                    b2.f42877a = this.f48683b;
                    b2.f42882f = hashMap;
                    b2.f42884h = jSONObject.toString();
                    b2.o = this.f48683b.getClass().getSimpleName();
                    b2.f42885i = new CJRCashWallet();
                    b2.j = new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            hVar.a(iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            hVar.b(networkCustomError);
                        }
                    };
                    b2.l().a();
                    return;
                }
                NetworkCustomError networkCustomError = new NetworkCustomError();
                networkCustomError.setmAlertTitle("No Internet");
                networkCustomError.setAlertMessage("You are not connected to internet");
                hVar.b(networkCustomError);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    static /* synthetic */ void a(a aVar, IJRPaytmDataModel iJRPaytmDataModel, boolean z, h hVar, String str, String str2) {
        if (!z || aVar.f48689i > aVar.f48686f) {
            hVar.a(iJRPaytmDataModel);
            return;
        }
        final h hVar2 = hVar;
        final String str3 = str;
        final String str4 = str2;
        final boolean z2 = z;
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                a.this.a(hVar2, str3, str4, z2);
            }
        }, aVar.f48688h);
    }
}
