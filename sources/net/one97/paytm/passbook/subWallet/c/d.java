package net.one97.paytm.passbook.subWallet.c;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRAccountSummary;
import net.one97.paytm.passbook.beans.CJRCashWallet;
import net.one97.paytm.passbook.beans.CJRP2BStatus;
import net.one97.paytm.passbook.beans.CustProductList;
import net.one97.paytm.passbook.beans.GiftVoucherResponseData;
import net.one97.paytm.passbook.beans.TransactionModel;
import net.one97.paytm.passbook.beans.postpaid.CJRPPUserProfileKycTnc;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity;
import net.one97.paytm.passbook.subWallet.c.a;
import net.one97.paytm.passbook.utility.e;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends a.C1134a {

    /* renamed from: b  reason: collision with root package name */
    public Activity f58894b;

    /* renamed from: c  reason: collision with root package name */
    private String f58895c;

    /* renamed from: d  reason: collision with root package name */
    private String f58896d;

    public d(a.b bVar, Activity activity) {
        super(bVar);
        this.f58894b = activity;
    }

    public final void a() {
        ((a.b) this.f57072a).k();
    }

    public final void b() {
        ((a.b) this.f57072a).g();
        e.a(this.f58894b, new i.a<IJRDataModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                IJRDataModel iJRDataModel = (IJRDataModel) obj;
                ((a.b) d.this.f57072a).h();
                if (iJRDataModel instanceof CJRP2BStatus) {
                    ((a.b) d.this.f57072a).e(iJRDataModel);
                }
            }
        }, new g() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                ((a.b) d.this.f57072a).h();
                ((a.b) d.this.f57072a).a((Throwable) networkCustomError);
            }
        });
    }

    public final void c() {
        Activity activity = this.f58894b;
        if (activity != null && (activity instanceof PassbookSubwalletActivity)) {
            try {
                net.one97.paytm.passbook.mapping.e.a();
                this.f58895c = net.one97.paytm.passbook.mapping.e.j();
                if (this.f58895c == null) {
                    return;
                }
                if (URLUtil.isValidUrl(this.f58895c)) {
                    this.f58895c = b.e((Context) this.f58894b, this.f58895c);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("request", new JSONObject().put("isDetailInfo", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
                    HashMap hashMap = new HashMap();
                    hashMap.put("ssotoken", com.paytm.utility.a.q(this.f58894b));
                    hashMap.put("Accept-Encoding", "gzip");
                    new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this.f58894b));
                    b.j();
                    if (b.c((Context) this.f58894b)) {
                        ((a.b) this.f57072a).e();
                        c.a();
                        c.b(new net.one97.paytm.passbook.mapping.a.b(this.f58895c, new i.a<IJRDataModel>() {
                            public final /* synthetic */ void onResponse(Object obj) {
                                ((a.b) d.this.f57072a).f();
                                ((a.b) d.this.f57072a).b((IJRDataModel) obj);
                            }
                        }, new g() {
                            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                ((a.b) d.this.f57072a).f();
                                ((a.b) d.this.f57072a).b();
                            }
                        }, new CJRCashWallet(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, net.one97.paytm.passbook.subWallet.b.d.class.getName()));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void d() {
        Activity activity = this.f58894b;
        if (activity != null && (activity instanceof PassbookSubwalletActivity) && b.c((Context) activity)) {
            ((a.b) this.f57072a).e();
            Activity activity2 = this.f58894b;
            AnonymousClass7 r3 = new i.a<IJRDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    ((a.b) d.this.f57072a).f();
                    ((a.b) d.this.f57072a).c((IJRDataModel) obj);
                }
            };
            AnonymousClass8 r4 = new g() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    ((a.b) d.this.f57072a).f();
                    ((a.b) d.this.f57072a).c();
                }
            };
            a.c cVar = a.c.PAYMENTSBANK;
            a.b bVar = a.b.USER_FACING;
            String simpleName = getClass().getSimpleName();
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization".toLowerCase(), com.paytm.utility.a.q(activity2));
            hashMap.put("Content-Type", "application/json");
            hashMap.put("channel", UpiConstants.B2C_ANDROID);
            net.one97.paytm.passbook.mapping.e.a();
            net.one97.paytm.passbook.mapping.a.a aVar = new net.one97.paytm.passbook.mapping.a.a(net.one97.paytm.passbook.mapping.e.k(), r3, r4, new CJRAccountSummary(), hashMap, cVar, bVar, simpleName);
            this.f58894b.getApplicationContext();
            c.a();
            c.b(aVar);
        }
    }

    public final void e() {
        Activity activity = this.f58894b;
        if (activity != null && (activity instanceof PassbookSubwalletActivity)) {
            net.one97.paytm.passbook.mapping.e.a();
            String d2 = net.one97.paytm.passbook.mapping.e.d();
            if (!TextUtils.isEmpty(d2) && URLUtil.isValidUrl(d2)) {
                this.f58896d = Uri.parse(d2).buildUpon().appendQueryParameter("fetch_type", "ACCOUNTS").appendQueryParameter("channel", StringSet.Android).appendQueryParameter("version", "2").appendQueryParameter(AppConstants.TAG_SITE_ID, "1").appendQueryParameter(AppConstants.TAG_CHILD_SITE_ID, "1").build().toString();
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f58894b));
                net.one97.paytm.passbook.mapping.a.a aVar = new net.one97.paytm.passbook.mapping.a.a(this.f58896d, (i.a<IJRDataModel>) new i.a<IJRDataModel>() {
                    public final /* synthetic */ void onResponse(Object obj) {
                        ((a.b) d.this.f57072a).f();
                        ((a.b) d.this.f57072a).d((IJRDataModel) obj);
                    }
                }, (g) new g() {
                    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        ((a.b) d.this.f57072a).f();
                        ((a.b) d.this.f57072a).d();
                    }
                }, (IJRDataModel) new CJRPPUserProfileKycTnc(), (Map<String, String>) hashMap, a.c.PASSBOOK, a.b.USER_FACING, getClass().getName(), (byte) 0);
                c.a();
                c.b(aVar);
            }
        }
    }

    public final void f() {
        Activity activity = this.f58894b;
        if (activity != null && (activity instanceof PassbookSubwalletActivity)) {
            final TransactionModel transactionModel = new TransactionModel(activity);
            if (transactionModel.isInternetAvailable()) {
                ((a.b) this.f57072a).e();
                Activity activity2 = this.f58894b;
                AnonymousClass11 r4 = new i.a<IJRDataModel>() {
                    public final /* synthetic */ void onResponse(Object obj) {
                        CustProductList custProductList = (CustProductList) ((IJRDataModel) obj);
                        if (!TextUtils.isEmpty(custProductList.getErrorMessage())) {
                            ((a.b) d.this.f57072a).f();
                            b.b((Context) d.this.f58894b, transactionModel.getApplicationContext().getString(R.string.error), custProductList.getErrorMessage());
                        } else if ("ISSUED".equals(custProductList.getIsaStatus())) {
                            ((a.b) d.this.f57072a).f();
                            String isaAccNum = custProductList.getIsaAccNum();
                            if (!TextUtils.isEmpty(isaAccNum)) {
                                ((a.b) d.this.f57072a).a(isaAccNum);
                                if (CustProductList.isToShowAccountFreeze(custProductList)) {
                                    ((a.b) d.this.f57072a).a(custProductList.getAccountFreezeDescription());
                                }
                            }
                        } else {
                            ((a.b) d.this.f57072a).i();
                        }
                    }
                };
                AnonymousClass2 r5 = new g() {
                    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        ((a.b) d.this.f57072a).f();
                    }
                };
                a.c cVar = a.c.PAYMENTSBANK;
                a.b bVar = a.b.USER_FACING;
                String simpleName = getClass().getSimpleName();
                HashMap hashMap = new HashMap();
                hashMap.put("User-Token", com.paytm.utility.a.q(activity2));
                hashMap.put("Content-Type", "application/json");
                hashMap.put("channel", UpiConstants.B2C_ANDROID);
                net.one97.paytm.passbook.mapping.e.a();
                net.one97.paytm.passbook.mapping.a.a aVar = new net.one97.paytm.passbook.mapping.a.a(b.e((Context) activity2, net.one97.paytm.passbook.mapping.e.l()), r4, r5, new CustProductList(), hashMap, cVar, bVar, simpleName);
                c.a();
                c.b(aVar);
            }
        }
    }

    public final void g() {
        net.one97.paytm.passbook.mapping.e.a();
        String b2 = net.one97.paytm.passbook.mapping.e.b();
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", com.paytm.utility.a.q(this.f58894b));
        hashMap.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ppiType", "GIFT_VOUCHER");
            jSONObject2.put("ppiStatus", "UNCLAIMED");
            jSONObject.put("request", jSONObject2);
            jSONObject.put("metadata", "Testing");
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
            jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
            jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "SALES_TO_USER_CREDIT");
        } catch (JSONException unused) {
        }
        net.one97.paytm.passbook.mapping.a.b bVar = new net.one97.paytm.passbook.mapping.a.b(b2, new i.a() {
            public final void onResponse(Object obj) {
                d.this.a((IJRDataModel) obj);
            }
        }, new g() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                ((a.b) d.this.f57072a).f();
                ((a.b) d.this.f57072a).a();
            }
        }, new GiftVoucherResponseData(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, PassbookSubwalletActivity.class.getName());
        if (b.c((Context) this.f58894b)) {
            c.a(bVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IJRDataModel iJRDataModel) {
        ((a.b) this.f57072a).a(iJRDataModel);
    }
}
