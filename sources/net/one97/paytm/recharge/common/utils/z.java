package net.one97.paytm.recharge.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.b.g;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.b;
import com.paytm.utility.e;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.f.d;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.a;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.ordersummary.f.i;
import net.one97.paytm.recharge.ordersummary.f.p;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity;
import net.one97.paytm.recharge.presentation.c.a;
import org.json.JSONObject;

public class z {
    /* access modifiers changed from: private */
    public static /* synthetic */ x a(StringBuilder sb, String str) {
        c cVar = c.f62654a;
        sb.append(c.a(str));
        return x.f47997a;
    }

    public static boolean a(Context context) {
        try {
            String b2 = ax.a(context.getApplicationContext()).b("sso_token=", "", true);
            return b2 != "" && b2.length() > 0;
        } catch (Exception unused) {
        }
    }

    public static void a(Activity activity) {
        a(activity, (Fragment) null, 7);
    }

    public static void a(Activity activity, int i2) {
        a(activity, (Fragment) null, i2);
    }

    public static void a(Activity activity, Fragment fragment, int i2) {
        a aVar = a.f62650a;
        Intent intent = new Intent(activity, a.b());
        intent.putExtra("parent_activity", CJRRechargeBaseActivity.class.getName());
        CJRRechargeUtilities.INSTANCE.signOut(activity, false, (NetworkCustomError) null);
        intent.putExtra("sign_in_title", activity.getResources().getString(R.string.sign_in_recharge));
        intent.putExtra("sign_up_title", activity.getResources().getString(R.string.sign_up_recharge));
        intent.putExtra("set_result_required", true);
        intent.putExtra("VERTICAL_NAME", "Recharge");
        if (fragment == null) {
            activity.startActivityForResult(intent, i2);
        } else {
            fragment.startActivityForResult(intent, i2);
        }
    }

    public static String a(NetworkResponse networkResponse) {
        if (networkResponse == null) {
            return "";
        }
        try {
            String str = networkResponse.headers.get("Content-Encoding");
            String str2 = new String(networkResponse.data);
            Reader reader = null;
            if ("gzip".equalsIgnoreCase(str)) {
                reader = g.a(networkResponse.data);
            }
            if (reader != null && "gzip".equalsIgnoreCase(str)) {
                str2 = g.a(reader);
            }
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            return str2;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean a(CJRCashWallet cJRCashWallet, CJRCart cJRCart) {
        boolean z;
        if (!(cJRCashWallet == null || cJRCashWallet.getResponse() == null)) {
            double amount = cJRCashWallet.getResponse().getAmount();
            double d2 = 0.0d;
            if (cJRCart != null) {
                try {
                    if (cJRCart.getCartItems() != null) {
                        d2 = Double.parseDouble(cJRCart.getFinalPrice());
                        z = false;
                        if (d2 <= amount || z) {
                            return false;
                        }
                        return true;
                    }
                } catch (Exception e2) {
                    q.d(e2.getMessage());
                }
            }
            z = true;
            if (d2 <= amount) {
            }
        }
        return false;
    }

    public static String a(String str) {
        return str != null ? str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase() : "";
    }

    public static boolean b(String str) {
        if (!e.z.equalsIgnoreCase(str)) {
            return false;
        }
        c cVar = c.f62654a;
        return c.ah();
    }

    public static String a(double d2) {
        if (b.a(Double.valueOf(d2))) {
            return String.valueOf((int) d2);
        }
        return String.valueOf(d2);
    }

    public static String c(String str) {
        try {
            double parseDouble = Double.parseDouble(str);
            if (b.a(Double.valueOf(parseDouble))) {
                return String.valueOf((int) parseDouble);
            }
        } catch (Exception unused) {
        }
        return String.valueOf(str);
    }

    public static void a(String str, String str2, CJRItem cJRItem, Context context) {
        net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a(str, context, str2) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ Context f$2;
            private final /* synthetic */ String f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object invoke() {
                return z.a(CJRItem.this, this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ x a(CJRItem cJRItem, String str, Context context, String str2) {
        if (cJRItem == null || TextUtils.isEmpty(cJRItem.getName()) || !cJRItem.getName().equalsIgnoreCase(str)) {
            return null;
        }
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a(context, cJRItem.getName() + " (new)", str2, "/" + cJRItem.getName().toLowerCase(), "");
        return null;
    }

    public static void a(CJRRechargeCart cJRRechargeCart, Context context, j jVar, String str, String str2, View.OnClickListener onClickListener, BottomSheetBehavior.a aVar) {
        if (cJRRechargeCart == null) {
            return;
        }
        if (cJRRechargeCart.getCart() == null || TextUtils.isEmpty(cJRRechargeCart.getCart().getErrorInfo())) {
            boolean z = (cJRRechargeCart.getCart() == null || cJRRechargeCart.getCart().getCartItems() == null || cJRRechargeCart.getCart().getCartItems().size() <= 0) ? false : true;
            c cVar = c.f62654a;
            if (c.bz()) {
                z = z && cJRRechargeCart.getCart().getCartItems().get(0).getServiceOptions() != null;
            }
            if (z) {
                a(cJRRechargeCart, context, false);
                return;
            }
            a.C1278a aVar2 = net.one97.paytm.recharge.presentation.c.a.f64795a;
            a.C1278a.a(context, context.getString(R.string.verify_account), Html.fromHtml(context.getString(R.string.we_cant_verify_this_account_number, new Object[]{str2, str})), context.getString(R.string.proceed), onClickListener, aVar).show(jVar, net.one97.paytm.recharge.presentation.c.a.class.getSimpleName());
            return;
        }
        try {
            if (new JSONObject(cJRRechargeCart.getCart().getErrorInfo()).optBoolean("isValidInput")) {
                a(cJRRechargeCart, context, false);
                return;
            }
            a.C1278a aVar3 = net.one97.paytm.recharge.presentation.c.a.f64795a;
            a.C1278a.a(context, context.getString(R.string.verify_account), Html.fromHtml(context.getString(R.string.we_cant_verify_this_account_number, new Object[]{str2, str})), context.getString(R.string.proceed), onClickListener, aVar).show(jVar, net.one97.paytm.recharge.presentation.c.a.class.getSimpleName());
        } catch (Exception unused) {
        }
    }

    public static void a(CJRRechargeCart cJRRechargeCart, Context context, boolean z) {
        String str;
        if (cJRRechargeCart != null && cJRRechargeCart.getCart() != null && cJRRechargeCart.getCart().getCartItems() != null && cJRRechargeCart.getCart().getCartItems().size() > 0) {
            CJRCartProduct cJRCartProduct = cJRRechargeCart.getCart().getCartItems().get(0);
            String replace = cJRCartProduct.getImageUrl().replace(" ", "%20");
            Map<String, String> configurationList = cJRCartProduct.getConfigurationList();
            if (configurationList != null) {
                str = "";
                for (String equalsIgnoreCase : configurationList.keySet()) {
                    if (equalsIgnoreCase.equalsIgnoreCase("recharge_number") && !TextUtils.isEmpty(configurationList.get("recharge_number"))) {
                        str = String.valueOf(configurationList.get("recharge_number"));
                    }
                }
            } else {
                str = "";
            }
            Intent intent = new Intent(context, AJRAutomaticSetupActivity.class);
            intent.putExtra("recharge_number", str);
            intent.putExtra("configuraton", (com.google.gsonhtcfix.b.g) cJRRechargeCart.getCart().getCartItems().get(0).getConfigurationList());
            intent.putExtra(CLPConstants.PRODUCT_ID, cJRCartProduct.getProductId());
            intent.putExtra("nick_name", "");
            intent.putExtra("operator_logo", replace);
            intent.putExtra("is_bank_mandate_enabled", z);
            intent.putExtra("service_type", cJRCartProduct.getmProductAttrubutes().getService());
            if (!TextUtils.isEmpty(cJRCartProduct.getmProductAttrubutes().getService()) && !TextUtils.isEmpty(cJRCartProduct.getmProductAttrubutes().getPaytype())) {
                intent.putExtra("service_paytype", cJRCartProduct.getmProductAttrubutes().getService().toLowerCase() + "_" + cJRCartProduct.getmProductAttrubutes().getPaytype().toLowerCase());
            }
            context.startActivity(intent);
        }
    }

    public static NetworkCustomError a(NetworkCustomError networkCustomError, NetworkCustomError networkCustomError2) {
        networkCustomError.setAlertMessage(networkCustomError2.getAlertMessage());
        networkCustomError.setmAlertTitle(networkCustomError2.getAlertTitle());
        networkCustomError.setUrl(networkCustomError2.getUrl());
        networkCustomError.setNetworkResponse(networkCustomError2.getNetworkResponse());
        networkCustomError.setErrorType(networkCustomError2.getErrorType());
        networkCustomError.setUniqueReference(networkCustomError2.getUniqueReference());
        return networkCustomError;
    }

    public static void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                CJRRechargeUtilities.INSTANCE.getCategoryIdUrl().put(str, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                CJRRechargeUtilities.INSTANCE.getCategoryIdUrlType().put(str, str3);
            }
        }
    }

    public static void a(String str, Context context, String str2, String str3, ai aiVar, p pVar, i iVar, Handler handler, int i2, Object obj) {
        String str4;
        String str5 = str2;
        if (context != null) {
            StringBuilder sb = new StringBuilder();
            g.a((kotlin.g.a.a<x>) new kotlin.g.a.a(sb) {
                private final /* synthetic */ StringBuilder f$0;

                {
                    this.f$0 = r1;
                }

                public final Object invoke() {
                    return this.f$0.append("http://demo2348773.mockable.io/order/");
                }
            }, (kotlin.g.a.a<x>) new kotlin.g.a.a(sb, str3) {
                private final /* synthetic */ StringBuilder f$0;
                private final /* synthetic */ String f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final Object invoke() {
                    return z.a(this.f$0, this.f$1);
                }
            });
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                aiVar.a(str, 0, (IJRPaytmDataModel) null, new NetworkCustomError("Request URL is Empty"), obj);
            } else if (!TextUtils.isEmpty(CJRRechargeUtilities.INSTANCE.getSSOToken(context))) {
                String b2 = com.paytm.utility.c.b(sb2, context);
                if (!"Payment".equalsIgnoreCase(str2) || !"paytm_automatic".equalsIgnoreCase(str2)) {
                    str4 = b2 + "&actions=1";
                } else {
                    str4 = b2 + "&actions=1";
                }
                HashMap hashMap = new HashMap();
                hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(context));
                final p pVar2 = pVar;
                final ai aiVar2 = aiVar;
                final int i3 = i2;
                final Handler handler2 = handler;
                final Context context2 = context;
                final String str6 = str2;
                final String str7 = str3;
                final i iVar2 = iVar;
                net.one97.paytm.recharge.common.f.b bVar = new net.one97.paytm.recharge.common.f.b(str, str4, new ai() {

                    /* renamed from: d  reason: collision with root package name */
                    final /* synthetic */ int f61825d = 3;

                    public final void a_(final String str, IJRPaytmDataModel iJRPaytmDataModel, final Object obj) {
                        if (iJRPaytmDataModel == null || !(iJRPaytmDataModel instanceof CJROrderSummary)) {
                            ai aiVar = aiVar2;
                            if (aiVar != null) {
                                aiVar.a(str, 0, (IJRPaytmDataModel) null, new NetworkCustomError("Response is Empty"), obj);
                            }
                        } else if (pVar2.a(iJRPaytmDataModel)) {
                            aiVar2.a_(str, iJRPaytmDataModel, obj);
                        } else {
                            if (i3 < this.f61825d) {
                                handler2.postDelayed(new Runnable() {
                                    public final void run() {
                                        z.a(str, context2, str6, str7, aiVar2, pVar2, iVar2, handler2, i3 + 1, obj);
                                    }
                                }, 5000);
                            } else {
                                i iVar = iVar2;
                                if (iVar != null) {
                                    iVar.aw_();
                                }
                            }
                            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                            cJRRechargeUtilities.debugLog(z.class.getSimpleName() + "Valid Order Response: Retry - " + i3);
                        }
                    }

                    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                        ai aiVar = aiVar2;
                        if (aiVar != null) {
                            aiVar.a(str, 0, (IJRPaytmDataModel) null, networkCustomError, obj);
                        }
                    }
                }, new CJROrderSummary(), hashMap, obj);
                bVar.a("order_detail_request");
                d.a();
                d.b(bVar);
            } else {
                aiVar.a(str, 0, (IJRPaytmDataModel) null, new NetworkCustomError("Request SSO is Empty"), obj);
            }
        }
    }
}
