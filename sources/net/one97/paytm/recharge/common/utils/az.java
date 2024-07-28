package net.one97.paytm.recharge.common.utils;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.o;
import com.paytm.network.a;
import com.paytm.utility.e;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.squareup.picasso.w;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.model.VERTICAL;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class az {

    /* renamed from: a  reason: collision with root package name */
    public static final az f61525a = new az();

    /* renamed from: b  reason: collision with root package name */
    private static o f61526b;

    static final class h implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final h f61529a = new h();

        h() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    static final class j implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final j f61531a = new j();

        j() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    static final class l implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final l f61534a = new l();

        l() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    private az() {
    }

    public static o a() {
        return f61526b;
    }

    public static void a(o oVar) {
        f61526b = oVar;
    }

    public static String a(JSONObject jSONObject) {
        kotlin.g.b.k.c(jSONObject, "jsonCart");
        JSONArray optJSONArray = jSONObject.optJSONArray("cart_items");
        if (optJSONArray != null) {
            int i2 = 0;
            int length = optJSONArray.length();
            while (i2 < length) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                JSONObject jSONObject2 = (JSONObject) (optJSONObject != null ? optJSONObject.opt(CLConstants.INPUT_KEY_CONFIGURATION) : null);
                if (jSONObject2 == null || jSONObject2.opt("category_id") == null) {
                    i2++;
                } else {
                    Object obj = jSONObject2.get("category_id");
                    if (obj != null) {
                        return (String) obj;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            }
        }
        return null;
    }

    public static void a(CJRRechargeCart cJRRechargeCart) {
        kotlin.g.b.k.c(cJRRechargeCart, "rechargeCart");
        CJRCart cart = cJRRechargeCart.getCart();
        String str = null;
        o paymentInstruments = cart != null ? cart.getPaymentInstruments() : null;
        if (paymentInstruments != null) {
            str = paymentInstruments.toString();
        }
        PaytmSDK.parseAndSetInstruments(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        r1 = (r1 = (r1 = r3.getCart()).getPaymentInfo()).b("native_withdraw");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean a(android.content.Context r1, java.lang.String r2, net.one97.paytm.common.entity.CJRRechargeCart r3) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r1, r0)
            java.lang.String r0 = "categoryId"
            kotlin.g.b.k.c(r2, r0)
            boolean r1 = a((android.content.Context) r1, (java.lang.String) r2)
            if (r1 == 0) goto L_0x002e
            if (r3 == 0) goto L_0x002e
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r3.getCart()
            if (r1 == 0) goto L_0x002e
            com.google.gsonhtcfix.o r1 = r1.getPaymentInfo()
            if (r1 == 0) goto L_0x002e
            java.lang.String r2 = "native_withdraw"
            com.google.gsonhtcfix.l r1 = r1.b(r2)
            if (r1 == 0) goto L_0x002e
            int r1 = r1.e()
            r2 = 1
            if (r1 != r2) goto L_0x002e
            return r2
        L_0x002e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.az.a(android.content.Context, java.lang.String, net.one97.paytm.common.entity.CJRRechargeCart):boolean");
    }

    public static final boolean b(Context context, String str, CJRRechargeCart cJRRechargeCart) {
        CJRCart cart;
        o paymentInfo;
        com.google.gsonhtcfix.l b2;
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "categoryId");
        if (!a(context, str)) {
            return false;
        }
        if (cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null || (paymentInfo = cart.getPaymentInfo()) == null || (b2 = paymentInfo.b("native_withdraw")) == null) {
            return true;
        }
        b2.e();
        return true;
    }

    public static final boolean c(Context context, String str, CJRRechargeCart cJRRechargeCart) {
        kotlin.g.b.k.c(context, "context");
        if (str == null) {
            str = "";
        }
        if (!a(context, str, cJRRechargeCart) || cJRRechargeCart == null || cJRRechargeCart.getCart() == null) {
            return false;
        }
        CJRCart cart = cJRRechargeCart.getCart();
        kotlin.g.b.k.a((Object) cart, "rechargeCart.cart");
        return cart.isConvFeeFlow();
    }

    public static final boolean d(Context context, String str, CJRRechargeCart cJRRechargeCart) {
        kotlin.g.b.k.c(context, "context");
        if (str == null) {
            str = "";
        }
        a(context, str, cJRRechargeCart);
        if (cJRRechargeCart == null || cJRRechargeCart.getCart() == null) {
            return false;
        }
        CJRCart cart = cJRRechargeCart.getCart();
        kotlin.g.b.k.a((Object) cart, "rechargeCart.cart");
        return cart.isConvFeeFlow();
    }

    public static final boolean a(Context context, String str) {
        try {
            com.google.gson.f fVar = new com.google.gson.f();
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            Object a2 = fVar.a(net.one97.paytm.recharge.di.helper.c.P(), HashMap.class);
            if (a2 != null) {
                HashMap hashMap = (HashMap) a2;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                Map map = hashMap;
                if (map == null) {
                    throw new u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                } else if (!map.containsKey(str) || !ba.c((String) hashMap.get(str), context)) {
                    return false;
                } else {
                    return true;
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a3.setErrorMsg("Unable check S2S Enabled");
            CRUFlowModel flowName = a3.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UI_DISTORT.name());
            }
            a(a3, (Throwable) e2);
            return false;
        }
    }

    public static final boolean a(Context context) {
        try {
            com.google.gson.f fVar = new com.google.gson.f();
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            Object a2 = fVar.a(net.one97.paytm.recharge.di.helper.c.bT(), HashMap.class);
            if (!(a2 instanceof HashMap)) {
                a2 = null;
            }
            HashMap hashMap = (HashMap) a2;
            if (hashMap == null || !ba.c((String) hashMap.get("ru_show_bank_offer"), context)) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            q.d(e2.getMessage());
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a3.setErrorMsg("Show Bank Offer Param Key is not coming");
            CRUFlowModel flowName = a3.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UI_DISTORT.name());
            }
            a(a3, (Throwable) e2);
            return false;
        }
    }

    public static final boolean b(Context context, String str) {
        try {
            com.google.gson.f fVar = new com.google.gson.f();
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            Object a2 = fVar.a(net.one97.paytm.recharge.di.helper.c.K(), HashMap.class);
            if (!(a2 instanceof HashMap)) {
                a2 = null;
            }
            HashMap hashMap = (HashMap) a2;
            if (!TextUtils.isEmpty(str) && hashMap != null) {
                Map map = hashMap;
                if (map == null) {
                    throw new u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                } else if (!map.containsKey(str) || !ba.c((String) hashMap.get(str), context)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a3.setErrorMsg("Unable check isDbCachedEnable");
            CRUFlowModel flowName = a3.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UI_DISTORT.name());
            }
            a(a3, (Throwable) e2);
        }
        return true;
    }

    public static final boolean b(Context context) {
        try {
            com.google.gson.f fVar = new com.google.gson.f();
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            Object a2 = fVar.a(net.one97.paytm.recharge.di.helper.c.Q(), HashMap.class);
            if (!(a2 instanceof HashMap)) {
                a2 = null;
            }
            HashMap hashMap = (HashMap) a2;
            if (hashMap == null) {
                hashMap = new HashMap();
                hashMap.put("isMobileNewFlowEnabled", "8.12.2");
            }
            if (!hashMap.containsKey("isMobileNewFlowEnabled") || !ba.c((String) hashMap.get("isMobileNewFlowEnabled"), context)) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            q.d(e2.getMessage());
            return false;
        }
    }

    public static final boolean c(Context context, String str) {
        kotlin.g.b.k.c(str, "categoryId");
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    com.google.gson.f fVar = new com.google.gson.f();
                    net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                    Object a2 = fVar.a(net.one97.paytm.recharge.di.helper.c.bS(), HashMap.class);
                    if (!(a2 instanceof HashMap)) {
                        a2 = null;
                    }
                    HashMap hashMap = (HashMap) a2;
                    if (hashMap == null || !hashMap.containsKey(str) || !ba.c((String) hashMap.get(str), context)) {
                        return false;
                    }
                    return true;
                }
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }
        return false;
    }

    public static final boolean a(String str, List<? extends CJRFrequentOrder> list) {
        if (list == null) {
            return false;
        }
        for (CJRFrequentOrder cJRFrequentOrder : list) {
            if (cJRFrequentOrder != null && cJRFrequentOrder.getConfiguration() != null && str != null && p.a(str, cJRFrequentOrder.getConfiguration().get("recharge_number"), true)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean a(String str, double d2, List<? extends CJRFrequentOrder> list) {
        if (list == null) {
            return false;
        }
        for (CJRFrequentOrder cJRFrequentOrder : list) {
            if (!(cJRFrequentOrder.getConfiguration() == null || str == null || !p.a(str, cJRFrequentOrder.getConfiguration().get("recharge_number"), true))) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                double c2 = net.one97.paytm.recharge.widgets.c.d.c(String.valueOf(d2));
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                if (c2 == net.one97.paytm.recharge.widgets.c.d.c(cJRFrequentOrder.getRechargeAmount())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean c(Context context) {
        try {
            com.google.gson.f fVar = new com.google.gson.f();
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            Object a2 = fVar.a(net.one97.paytm.recharge.di.helper.c.bL(), HashMap.class);
            if (a2 != null) {
                HashMap hashMap = (HashMap) a2;
                if (!hashMap.containsKey("h5_automatic") || !ba.c((String) hashMap.get("h5_automatic"), context)) {
                    return false;
                }
                return true;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
        } catch (Exception e2) {
            q.d(e2.getMessage());
            return false;
        }
    }

    public static final boolean d(Context context) {
        if (context == null) {
            return false;
        }
        try {
            com.google.gson.f fVar = new com.google.gson.f();
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            Object a2 = fVar.a(net.one97.paytm.recharge.di.helper.c.bI(), HashMap.class);
            if (!(a2 instanceof HashMap)) {
                a2 = null;
            }
            HashMap hashMap = (HashMap) a2;
            if (hashMap == null) {
                hashMap = new HashMap();
                hashMap.put("isCCNewFlowEnabled", "8.12.2");
            }
            if (!hashMap.containsKey("isCCNewFlowEnabled") || !ba.c((String) hashMap.get("isCCNewFlowEnabled"), context)) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    public static final boolean e(Context context) {
        if (context == null) {
            return false;
        }
        try {
            com.google.gson.f fVar = new com.google.gson.f();
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            Object a2 = fVar.a(net.one97.paytm.recharge.di.helper.c.bJ(), HashMap.class);
            if (!(a2 instanceof HashMap)) {
                a2 = null;
            }
            HashMap hashMap = (HashMap) a2;
            if (hashMap == null) {
                hashMap = new HashMap();
                hashMap.put("isCCConsentFlowEnabled", "8.12.2");
            }
            if (!hashMap.containsKey("isCCConsentFlowEnabled") || !ba.c((String) hashMap.get("isCCConsentFlowEnabled"), context)) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    public static boolean a(Context context, String str, String str2) {
        kotlin.g.b.k.c(str, "categoryId");
        if (context == null) {
            return false;
        }
        try {
            com.google.gson.f fVar = new com.google.gson.f();
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            Object a2 = fVar.a(net.one97.paytm.recharge.di.helper.c.R(), HashMap.class);
            if (!(a2 instanceof HashMap)) {
                a2 = null;
            }
            HashMap hashMap = (HashMap) a2;
            if (!TextUtils.isEmpty(str) && hashMap != null && hashMap.containsKey(str)) {
                Object a3 = new com.google.gson.f().a((String) hashMap.get(str), HashMap.class);
                if (!(a3 instanceof HashMap)) {
                    a3 = null;
                }
                HashMap hashMap2 = (HashMap) a3;
                if (hashMap2 == null || !(!hashMap2.isEmpty()) || !hashMap2.containsKey(str2) || !ba.c((String) hashMap2.get(str2), context)) {
                    return false;
                }
                return true;
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a4 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a4.setErrorMsg("Unable check Footer Menu to show or not");
            a(a4, (Throwable) e2);
        }
        return false;
    }

    public static final boolean d(Context context, String str) {
        try {
            com.google.gson.f fVar = new com.google.gson.f();
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            Object a2 = fVar.a(net.one97.paytm.recharge.di.helper.c.bl(), HashMap.class);
            if (a2 != null) {
                HashMap hashMap = (HashMap) a2;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                Map map = hashMap;
                if (map == null) {
                    throw new u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                } else if (!map.containsKey(str) || !ba.c((String) hashMap.get(str), context)) {
                    return false;
                } else {
                    return true;
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a3.setErrorMsg("Unable to enable PROMO pg");
            CRUFlowModel flowName = a3.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UI_DISTORT.name());
            }
            a(a3, (Throwable) e2);
            return false;
        }
    }

    static final class k implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f61532a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f61533b;

        k(Context context) {
            this.f61533b = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f61532a) {
                s.b(this.f61533b);
                return;
            }
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:com.android.providers.downloads"));
                this.f61533b.startActivity(intent);
            } catch (ActivityNotFoundException e2) {
                q.d(e2.getMessage());
                this.f61533b.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r11, net.one97.paytm.recharge.widgets.model.ERROR_TYPE r12, net.one97.paytm.recharge.widgets.model.ACTION_TYPE r13, net.one97.paytm.common.entity.CJRRechargeCart r14) {
        /*
            java.lang.String r0 = "rechargeCart"
            kotlin.g.b.k.c(r14, r0)
            r0 = 0
            net.one97.paytm.common.entity.shopping.CJRCart r14 = r14.getCart()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r1 = "rechargeCart.cart"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r1)     // Catch:{ Exception -> 0x0031 }
            java.util.ArrayList r14 = r14.getCartItems()     // Catch:{ Exception -> 0x0031 }
            r1 = 0
            java.lang.Object r14 = r14.get(r1)     // Catch:{ Exception -> 0x0031 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r14 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r14     // Catch:{ Exception -> 0x0031 }
            java.lang.String r1 = "cartProduct"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r1)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r1 = r14.getProductId()     // Catch:{ Exception -> 0x0031 }
            java.util.Map r14 = r14.getConfigurationList()     // Catch:{ Exception -> 0x0032 }
            java.lang.String r2 = "category_id"
            java.lang.Object r14 = r14.get(r2)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x0032 }
            r8 = r14
            goto L_0x0033
        L_0x0031:
            r1 = r0
        L_0x0032:
            r8 = r0
        L_0x0033:
            r9 = r1
            r5 = 0
            if (r11 == 0) goto L_0x003d
            int r14 = net.one97.paytm.recharge.R.string.no_description_error
            java.lang.String r0 = r11.getString(r14)
        L_0x003d:
            r6 = r0
            r7 = 0
            r10 = 680(0x2a8, float:9.53E-43)
            r2 = r11
            r3 = r12
            r4 = r13
            a((android.content.Context) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r4, (java.lang.String) r5, (java.lang.String) r6, (boolean) r7, (java.lang.String) r8, (java.lang.String) r9, (int) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.az.a(android.content.Context, net.one97.paytm.recharge.widgets.model.ERROR_TYPE, net.one97.paytm.recharge.widgets.model.ACTION_TYPE, net.one97.paytm.common.entity.CJRRechargeCart):void");
    }

    public static /* synthetic */ void a(Context context, ERROR_TYPE error_type, ACTION_TYPE action_type, String str, String str2, int i2) {
        if ((i2 & 2) != 0) {
            error_type = ERROR_TYPE.UNDEFINED;
        }
        if ((i2 & 4) != 0) {
            action_type = null;
        }
        if ((i2 & 8) != 0) {
            str = "utility_hide_title";
        }
        if ((i2 & 16) != 0) {
            str2 = null;
        }
        a(context, error_type, action_type, str, str2);
    }

    public static void a(Context context, ERROR_TYPE error_type, ACTION_TYPE action_type, String str, String str2) {
        a(context, error_type, action_type, str, str2, false, (String) null, (String) null, 512);
    }

    public static /* synthetic */ void a(Context context, ERROR_TYPE error_type, ACTION_TYPE action_type, String str, String str2, boolean z, String str3, String str4, int i2) {
        int i3 = i2;
        a(context, (i3 & 2) != 0 ? ERROR_TYPE.UNDEFINED : error_type, (i3 & 4) != 0 ? null : action_type, (i3 & 8) != 0 ? "utility_hide_title" : str, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? false : z, (i3 & 64) != 0 ? null : str3, (String) null, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? null : str4, false);
    }

    public static void a(Context context, ERROR_TYPE error_type, ACTION_TYPE action_type, String str, String str2, boolean z, String str3, String str4, String str5, boolean z2) {
        String str6 = str;
        String str7 = str2;
        if (context != null) {
            if (error_type == ERROR_TYPE.PARSING) {
                com.paytm.utility.b.d(context, str, str2);
            } else {
                com.paytm.utility.b.b(context, str, str2, z);
            }
            new net.one97.paytm.recharge.widgets.c.i(new e(z2, error_type, str2, str3, str4, str5, action_type, context)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    static final class e extends kotlin.g.b.l implements kotlin.g.a.a<x> {
        final /* synthetic */ ACTION_TYPE $actionType;
        final /* synthetic */ String $categoryId;
        final /* synthetic */ Context $context;
        final /* synthetic */ ERROR_TYPE $errorType;
        final /* synthetic */ boolean $isFrontEndError;
        final /* synthetic */ String $message;
        final /* synthetic */ String $productId;
        final /* synthetic */ String $screenName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(boolean z, ERROR_TYPE error_type, String str, String str2, String str3, String str4, ACTION_TYPE action_type, Context context) {
            super(0);
            this.$isFrontEndError = z;
            this.$errorType = error_type;
            this.$message = str;
            this.$categoryId = str2;
            this.$screenName = str3;
            this.$productId = str4;
            this.$actionType = action_type;
            this.$context = context;
        }

        public final void invoke() {
            try {
                if (!this.$isFrontEndError) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    String str = null;
                    CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    VERTICAL verticalName = a2.getVerticalName();
                    if (verticalName == null) {
                        verticalName = VERTICAL.RECHARGES;
                    }
                    a2.setVerticalName(verticalName);
                    a2.setErrorType(this.$errorType);
                    a2.setUserFacing(a.b.USER_FACING);
                    a2.setErrorMsg(this.$message);
                    String str2 = this.$categoryId;
                    if (str2 == null) {
                        str2 = a2.getCategoryId();
                    }
                    a2.setCategoryId(str2);
                    String str3 = this.$screenName;
                    if (str3 == null) {
                        str3 = a2.getScreenName();
                    }
                    a2.setScreenName(str3);
                    String str4 = this.$productId;
                    if (str4 == null) {
                        str4 = a2.getProductId();
                    }
                    a2.setProductId(str4);
                    CRUFlowModel flowName = a2.getFlowName();
                    if (flowName != null) {
                        ERROR_TYPE error_type = this.$errorType;
                        flowName.setErrorType(error_type != null ? error_type.name() : null);
                    }
                    CRUFlowModel flowName2 = a2.getFlowName();
                    if (flowName2 != null) {
                        ACTION_TYPE action_type = this.$actionType;
                        if (action_type != null) {
                            str = action_type.name();
                        }
                        flowName2.setActionType(str);
                    }
                    CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                    Context applicationContext = this.$context.getApplicationContext();
                    kotlin.g.b.k.a((Object) applicationContext, "context.applicationContext");
                    cJRRechargeUtilities.sendEventToPaytmAnalytics(a2, applicationContext);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static /* synthetic */ void a(Context context, ERROR_TYPE error_type, ACTION_TYPE action_type, String str, String str2, boolean z, CJRRechargeErrorModel cJRRechargeErrorModel, boolean z2, int i2) {
        int i3 = i2;
        a(context, (i3 & 2) != 0 ? ERROR_TYPE.UNDEFINED : error_type, (i3 & 4) != 0 ? null : action_type, (i3 & 8) != 0 ? "utility_hide_title" : str, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? false : z, (String) null, (String) null, (String) null, (i3 & 512) != 0 ? null : cJRRechargeErrorModel, (i3 & TarConstants.EOF_BLOCK) != 0 ? false : z2);
    }

    public static void a(Context context, ERROR_TYPE error_type, ACTION_TYPE action_type, String str, String str2, boolean z, String str3, String str4, String str5, CJRRechargeErrorModel cJRRechargeErrorModel, boolean z2) {
        String str6 = str;
        String str7 = str2;
        CJRRechargeErrorModel cJRRechargeErrorModel2 = cJRRechargeErrorModel;
        if (context == null) {
            return;
        }
        if (cJRRechargeErrorModel2 == null) {
            a(context, error_type, action_type, str, str2, z, str3, str4, str5, z2);
            return;
        }
        if (error_type == ERROR_TYPE.PARSING) {
            com.paytm.utility.b.d(context, str, str2);
        } else {
            boolean z3 = z;
            com.paytm.utility.b.b(context, str, str2, z);
        }
        new net.one97.paytm.recharge.widgets.c.i(new f(cJRRechargeErrorModel2, str2, z2, context)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static final class f extends kotlin.g.b.l implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ CJRRechargeErrorModel $hawkeyeModel;
        final /* synthetic */ boolean $isFrontEndError;
        final /* synthetic */ String $message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(CJRRechargeErrorModel cJRRechargeErrorModel, String str, boolean z, Context context) {
            super(0);
            this.$hawkeyeModel = cJRRechargeErrorModel;
            this.$message = str;
            this.$isFrontEndError = z;
            this.$context = context;
        }

        public final void invoke() {
            StringBuilder journeyStackTrace;
            try {
                CJRRechargeErrorModel cJRRechargeErrorModel = this.$hawkeyeModel;
                String errorMsg = this.$hawkeyeModel.getErrorMsg();
                if (errorMsg == null) {
                    errorMsg = this.$message;
                }
                cJRRechargeErrorModel.setErrorMsg(errorMsg);
                CRUFlowModel flowName = this.$hawkeyeModel.getFlowName();
                if (flowName != null) {
                    flowName.setAlertType("");
                }
                CRUFlowModel flowName2 = this.$hawkeyeModel.getFlowName();
                if (!(flowName2 == null || (journeyStackTrace = flowName2.getJourneyStackTrace()) == null)) {
                    p.a(journeyStackTrace);
                }
                if (!this.$isFrontEndError) {
                    CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                    CJRRechargeErrorModel cJRRechargeErrorModel2 = this.$hawkeyeModel;
                    Context applicationContext = this.$context.getApplicationContext();
                    kotlin.g.b.k.a((Object) applicationContext, "context.applicationContext");
                    cJRRechargeUtilities.sendEventToPaytmAnalytics(cJRRechargeErrorModel2, applicationContext);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static /* synthetic */ void a(String str, VERTICAL vertical, ERROR_TYPE error_type) {
        kotlin.g.b.k.c(vertical, "verticalName");
        kotlin.g.b.k.c(error_type, "errorType");
        new net.one97.paytm.recharge.widgets.c.i(new b((String) null, vertical, error_type, (String) null, str, (String) null, (String) null, (String) null, (ACTION_TYPE) null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static final class b extends kotlin.g.b.l implements kotlin.g.a.a<x> {
        final /* synthetic */ ACTION_TYPE $actionType;
        final /* synthetic */ String $categoryId;
        final /* synthetic */ ERROR_TYPE $errorType;
        final /* synthetic */ String $message;
        final /* synthetic */ String $productId;
        final /* synthetic */ String $screenName;
        final /* synthetic */ String $statusCode;
        final /* synthetic */ String $url;
        final /* synthetic */ VERTICAL $verticalName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, VERTICAL vertical, ERROR_TYPE error_type, String str2, String str3, String str4, String str5, String str6, ACTION_TYPE action_type) {
            super(0);
            this.$statusCode = str;
            this.$verticalName = vertical;
            this.$errorType = error_type;
            this.$url = str2;
            this.$message = str3;
            this.$categoryId = str4;
            this.$screenName = str5;
            this.$productId = str6;
            this.$actionType = action_type;
        }

        public final void invoke() {
            CRUFlowModel flowName;
            try {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                String str = null;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                a2.setErrorCode(this.$statusCode);
                a2.setVerticalName(this.$verticalName);
                a2.setErrorType(this.$errorType);
                a2.setUserFacing(a.b.USER_FACING);
                if (URLUtil.isValidUrl(this.$url)) {
                    a2.setUrl(com.paytm.utility.b.P(this.$url));
                } else if (!(this.$url == null || (flowName = a2.getFlowName()) == null)) {
                    flowName.setOtherDetails("Invalid Url");
                }
                String str2 = this.$message;
                if (str2 == null) {
                    str2 = "";
                }
                a2.setErrorMsg(str2);
                String str3 = this.$categoryId;
                if (str3 == null) {
                    str3 = a2.getCategoryId();
                }
                a2.setCategoryId(str3);
                String str4 = this.$screenName;
                if (str4 == null) {
                    str4 = a2.getScreenName();
                }
                a2.setScreenName(str4);
                String str5 = this.$productId;
                if (str5 == null) {
                    str5 = a2.getProductId();
                }
                a2.setProductId(str5);
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setErrorType(this.$errorType.name());
                }
                CRUFlowModel flowName3 = a2.getFlowName();
                if (flowName3 != null) {
                    ACTION_TYPE action_type = this.$actionType;
                    if (action_type != null) {
                        str = action_type.name();
                    }
                    flowName3.setActionType(str);
                }
                Context applicationContext = CJRRechargeUtilities.INSTANCE.getApplicationContext();
                if (applicationContext != null) {
                    CJRRechargeUtilities.INSTANCE.sendEventToPaytmAnalytics(a2, applicationContext);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(CJRRechargeErrorModel cJRRechargeErrorModel) {
        kotlin.g.b.k.c(cJRRechargeErrorModel, "hawkeyeModel");
        new net.one97.paytm.recharge.widgets.c.i(new c(cJRRechargeErrorModel)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static final class c extends kotlin.g.b.l implements kotlin.g.a.a<x> {
        final /* synthetic */ CJRRechargeErrorModel $hawkeyeModel;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(CJRRechargeErrorModel cJRRechargeErrorModel) {
            super(0);
            this.$hawkeyeModel = cJRRechargeErrorModel;
        }

        public final void invoke() {
            try {
                Context applicationContext = CJRRechargeUtilities.INSTANCE.getApplicationContext();
                if (applicationContext != null) {
                    CJRRechargeUtilities.INSTANCE.sendEventToPaytmAnalytics(this.$hawkeyeModel, applicationContext);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(CJRRechargeErrorModel cJRRechargeErrorModel, Throwable th) {
        kotlin.g.b.k.c(cJRRechargeErrorModel, "hawkeyeModel");
        kotlin.g.b.k.c(th, "e");
        new net.one97.paytm.recharge.widgets.c.i(new a(th, cJRRechargeErrorModel)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    static final class a extends kotlin.g.b.l implements kotlin.g.a.a<x> {
        final /* synthetic */ Throwable $e;
        final /* synthetic */ CJRRechargeErrorModel $hawkeyeModel;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Throwable th, CJRRechargeErrorModel cJRRechargeErrorModel) {
            super(0);
            this.$e = th;
            this.$hawkeyeModel = cJRRechargeErrorModel;
        }

        public final void invoke() {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder("Message: ");
            String message = this.$e.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            arrayList.add(sb.toString());
            StackTraceElement[] stackTrace = this.$e.getStackTrace();
            if (stackTrace != null) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (arrayList.size() < 3) {
                        kotlin.g.b.k.a((Object) stackTraceElement, "stackTraceElement");
                        String className = stackTraceElement.getClassName();
                        if (className != null && p.b(className, "net.one97.paytm.recharge", false)) {
                            arrayList.add(stackTraceElement.toString());
                        }
                    }
                }
            }
            CRUFlowModel flowName = this.$hawkeyeModel.getFlowName();
            if (flowName != null) {
                flowName.setStackTrace(arrayList);
            }
            try {
                Context applicationContext = CJRRechargeUtilities.INSTANCE.getApplicationContext();
                if (applicationContext != null) {
                    CJRRechargeUtilities.INSTANCE.sendEventToPaytmAnalytics(this.$hawkeyeModel, applicationContext);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context, CJRRechargeCart cJRRechargeCart, ACTION_TYPE action_type) {
        kotlin.g.b.k.c(action_type, "actionType");
        Bundle a2 = a(context, cJRRechargeCart, false, false);
        boolean z = a2.getBoolean("extra.has.error");
        if (z) {
            String string = a2.getString("extra.error.title");
            String string2 = a2.getString("extra.error.msg");
            a2.getString("extra.show.error.info");
            a(context, ERROR_TYPE.UNDEFINED, action_type, string, string2);
        }
        return z;
    }

    public static /* synthetic */ Bundle a(Context context, CJRRechargeCart cJRRechargeCart, boolean z, int i2) {
        if ((i2 & 1) != 0) {
            context = null;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        return a(context, cJRRechargeCart, false, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7 A[SYNTHETIC, Splitter:B:27:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d2 A[Catch:{ Exception -> 0x01b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x018e A[SYNTHETIC, Splitter:B:84:0x018e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.os.Bundle a(android.content.Context r17, net.one97.paytm.common.entity.CJRRechargeCart r18, boolean r19, boolean r20) {
        /*
            r0 = r17
            java.lang.String r1 = "message"
            java.lang.String r2 = "doNotBlockOnValidate"
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            if (r18 == 0) goto L_0x0012
            net.one97.paytm.common.entity.shopping.CJRCart r5 = r18.getCart()
            goto L_0x0013
        L_0x0012:
            r5 = 0
        L_0x0013:
            java.lang.String r6 = "extra.has.error"
            r7 = 0
            if (r5 == 0) goto L_0x037a
            net.one97.paytm.common.entity.shopping.CJRCart r5 = r18.getCart()
            java.lang.String r8 = "rechargeCart.cart"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            java.util.ArrayList r5 = r5.getCartItems()
            net.one97.paytm.common.entity.shopping.CJRCart r9 = r18.getCart()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r8)
            java.lang.String r9 = r9.getErrorInfo()
            java.lang.String r11 = "extra.error.code"
            java.lang.String r12 = "extra.error.msg"
            java.lang.String r13 = "extra.error.title"
            java.lang.String r14 = ""
            r15 = 1
            if (r9 == 0) goto L_0x01b2
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = kotlin.m.p.a(r9)
            if (r9 != 0) goto L_0x01b2
            net.one97.paytm.common.entity.shopping.CJRCart r9 = r18.getCart()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r8)
            java.lang.String r9 = r9.getErrorInfo()
            java.lang.String r4 = "extra.show.error.info"
            r3.putString(r4, r9)
            com.google.gson.f r4 = new com.google.gson.f     // Catch:{ Exception -> 0x0076 }
            r4.<init>()     // Catch:{ Exception -> 0x0076 }
            net.one97.paytm.common.entity.shopping.CJRCart r9 = r18.getCart()     // Catch:{ Exception -> 0x0076 }
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r8)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r9 = r9.getErrorInfo()     // Catch:{ Exception -> 0x0076 }
            java.lang.Class<net.one97.paytm.recharge.model.ErrorInfo> r10 = net.one97.paytm.recharge.model.ErrorInfo.class
            java.lang.Object r4 = r4.a((java.lang.String) r9, r10)     // Catch:{ Exception -> 0x0076 }
            if (r4 == 0) goto L_0x006e
            net.one97.paytm.recharge.model.ErrorInfo r4 = (net.one97.paytm.recharge.model.ErrorInfo) r4     // Catch:{ Exception -> 0x0076 }
            goto L_0x0077
        L_0x006e:
            kotlin.u r4 = new kotlin.u     // Catch:{ Exception -> 0x0076 }
            java.lang.String r9 = "null cannot be cast to non-null type net.one97.paytm.recharge.model.ErrorInfo"
            r4.<init>(r9)     // Catch:{ Exception -> 0x0076 }
            throw r4     // Catch:{ Exception -> 0x0076 }
        L_0x0076:
            r4 = 0
        L_0x0077:
            if (r4 == 0) goto L_0x0112
            com.google.gson.f r9 = new com.google.gson.f     // Catch:{ Exception -> 0x00a4 }
            r9.<init>()     // Catch:{ Exception -> 0x00a4 }
            net.one97.paytm.common.entity.shopping.CJRCart r10 = r18.getCart()     // Catch:{ Exception -> 0x00a4 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r8)     // Catch:{ Exception -> 0x00a4 }
            java.util.ArrayList r10 = r10.getCartItems()     // Catch:{ Exception -> 0x00a4 }
            java.lang.Object r10 = r10.get(r7)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r7 = "rechargeCart.cart.cartItems[0]"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r7)     // Catch:{ Exception -> 0x00a4 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r10 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r10     // Catch:{ Exception -> 0x00a4 }
            java.lang.Object r7 = r10.getMetaDataResponse()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r7 = r9.b(r7)     // Catch:{ Exception -> 0x00a4 }
            if (r7 == 0) goto L_0x00a4
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a4 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00a5
        L_0x00a4:
            r9 = 0
        L_0x00a5:
            if (r9 == 0) goto L_0x00cc
            boolean r7 = r9.has(r2)     // Catch:{ Exception -> 0x01b1 }
            if (r7 == 0) goto L_0x00cc
            int r2 = r9.getInt(r2)     // Catch:{ Exception -> 0x01b1 }
            if (r2 != r15) goto L_0x00cc
            java.lang.String r2 = "Action_ProceedOnValidationBlock"
            net.one97.paytm.recharge.model.ErrorDesc r7 = r4.getErrorDesc()     // Catch:{ Exception -> 0x01b1 }
            if (r7 == 0) goto L_0x00c0
            java.lang.String r7 = r7.getButtonAction()     // Catch:{ Exception -> 0x01b1 }
            goto L_0x00c1
        L_0x00c0:
            r7 = 0
        L_0x00c1:
            boolean r2 = r2.equals(r7)     // Catch:{ Exception -> 0x01b1 }
            if (r2 == 0) goto L_0x00cc
            r1 = 0
            r3.putBoolean(r6, r1)     // Catch:{ Exception -> 0x01b1 }
            return r3
        L_0x00cc:
            net.one97.paytm.recharge.model.ErrorDesc r2 = r4.getErrorDesc()     // Catch:{ Exception -> 0x01b1 }
            if (r2 == 0) goto L_0x0112
            net.one97.paytm.recharge.model.ErrorDesc r1 = r4.getErrorDesc()     // Catch:{ Exception -> 0x01b1 }
            if (r1 != 0) goto L_0x00db
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x01b1 }
        L_0x00db:
            java.lang.String r2 = r1.getHeading()     // Catch:{ Exception -> 0x01b1 }
            r3.putString(r13, r2)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r2 = r1.getMessage()     // Catch:{ Exception -> 0x01b1 }
            r3.putString(r12, r2)     // Catch:{ Exception -> 0x01b1 }
            net.one97.paytm.common.entity.shopping.CJRCart r2 = r18.getCart()     // Catch:{ Exception -> 0x01b1 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r2 = r2.getErrorCode()     // Catch:{ Exception -> 0x01b1 }
            r3.putString(r11, r2)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r2 = "extra.error.action.btn.label"
            java.lang.String r4 = r1.getButtonText()     // Catch:{ Exception -> 0x01b1 }
            r3.putString(r2, r4)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r2 = "extra.error.action.btn"
            java.lang.String r1 = r1.getButtonAction()     // Catch:{ Exception -> 0x01b1 }
            r3.putString(r2, r1)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r1 = "extra.show.error.info.dialog"
            r3.putBoolean(r1, r15)     // Catch:{ Exception -> 0x01b1 }
            r3.putBoolean(r6, r15)     // Catch:{ Exception -> 0x01b1 }
            return r3
        L_0x0112:
            if (r19 == 0) goto L_0x01b2
            net.one97.paytm.common.entity.shopping.CJRCart r2 = r18.getCart()     // Catch:{ Exception -> 0x01b1 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r2 = r2.getErrorTitle()     // Catch:{ Exception -> 0x01b1 }
            if (r2 == 0) goto L_0x016f
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x01b1 }
            int r7 = r4.length()     // Catch:{ Exception -> 0x01b1 }
            int r7 = r7 - r15
            r9 = r7
            r7 = 0
            r10 = 0
        L_0x012c:
            if (r7 > r9) goto L_0x0153
            if (r10 != 0) goto L_0x0132
            r15 = r7
            goto L_0x0133
        L_0x0132:
            r15 = r9
        L_0x0133:
            char r15 = r4.charAt(r15)     // Catch:{ Exception -> 0x01b1 }
            r19 = r2
            r2 = 32
            if (r15 > r2) goto L_0x013f
            r2 = 1
            goto L_0x0140
        L_0x013f:
            r2 = 0
        L_0x0140:
            if (r10 != 0) goto L_0x014b
            if (r2 != 0) goto L_0x0148
            r2 = r19
            r10 = 1
            goto L_0x0151
        L_0x0148:
            int r7 = r7 + 1
            goto L_0x014f
        L_0x014b:
            if (r2 == 0) goto L_0x0155
            int r9 = r9 + -1
        L_0x014f:
            r2 = r19
        L_0x0151:
            r15 = 1
            goto L_0x012c
        L_0x0153:
            r19 = r2
        L_0x0155:
            r2 = 1
            int r9 = r9 + r2
            java.lang.CharSequence r2 = r4.subSequence(r7, r9)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01b1 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x01b1 }
            int r2 = r2.length()     // Catch:{ Exception -> 0x01b1 }
            if (r2 <= 0) goto L_0x0169
            r2 = 1
            goto L_0x016a
        L_0x0169:
            r2 = 0
        L_0x016a:
            if (r2 == 0) goto L_0x016f
            r2 = r19
            goto L_0x017a
        L_0x016f:
            if (r0 == 0) goto L_0x0179
            int r2 = net.one97.paytm.recharge.R.string.unable_to_proceed     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x01b1 }
            if (r2 != 0) goto L_0x017a
        L_0x0179:
            r2 = r14
        L_0x017a:
            net.one97.paytm.common.entity.shopping.CJRCart r4 = r18.getCart()     // Catch:{ Exception -> 0x01b1 }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r4 = r4.getErrorInfo()     // Catch:{ Exception -> 0x01b1 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x018b }
            r7.<init>(r4)     // Catch:{ Exception -> 0x018b }
            goto L_0x018c
        L_0x018b:
            r7 = 0
        L_0x018c:
            if (r7 == 0) goto L_0x0198
            boolean r9 = r7.has(r1)     // Catch:{ Exception -> 0x01b1 }
            if (r9 == 0) goto L_0x0198
            java.lang.String r4 = r7.optString(r1)     // Catch:{ Exception -> 0x01b1 }
        L_0x0198:
            r3.putString(r13, r2)     // Catch:{ Exception -> 0x01b1 }
            r3.putString(r12, r4)     // Catch:{ Exception -> 0x01b1 }
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r18.getCart()     // Catch:{ Exception -> 0x01b1 }
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r1 = r1.getErrorCode()     // Catch:{ Exception -> 0x01b1 }
            r3.putString(r11, r1)     // Catch:{ Exception -> 0x01b1 }
            r1 = 1
            r3.putBoolean(r6, r1)     // Catch:{ Exception -> 0x01b1 }
            return r3
        L_0x01b1:
        L_0x01b2:
            if (r5 == 0) goto L_0x02a1
            r1 = r5
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            if (r1 != r2) goto L_0x02a1
            java.util.Iterator r1 = r5.iterator()
        L_0x01c3:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x02a1
            java.lang.Object r2 = r1.next()
            net.one97.paytm.common.entity.shopping.CJRCartProduct r2 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r2
            java.lang.String r4 = "cartProduct"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.String r4 = r2.getError()
            if (r4 == 0) goto L_0x01c3
            java.lang.String r1 = r2.getError()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0232
            java.lang.String r1 = r2.getError()
            java.lang.String r4 = "CT_CP_4001"
            r5 = 1
            boolean r1 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r5)
            if (r1 != 0) goto L_0x01ff
            java.lang.String r1 = r2.getError()
            java.lang.String r4 = "CT_CP_4010"
            boolean r1 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r5)
            if (r1 == 0) goto L_0x0232
        L_0x01ff:
            if (r0 == 0) goto L_0x0209
            int r1 = net.one97.paytm.recharge.R.string.title_msg_for_deals
            java.lang.String r1 = r0.getString(r1)
            if (r1 != 0) goto L_0x020a
        L_0x0209:
            r1 = r14
        L_0x020a:
            java.lang.String r4 = "context?.getString(R.str…itle_msg_for_deals) ?: \"\""
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            if (r0 == 0) goto L_0x021b
            int r4 = net.one97.paytm.recharge.R.string.error_msg_for_deals
            java.lang.String r0 = r0.getString(r4)
            if (r0 != 0) goto L_0x021a
            goto L_0x021b
        L_0x021a:
            r14 = r0
        L_0x021b:
            java.lang.String r0 = "context?.getString(R.str…rror_msg_for_deals) ?: \"\""
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            r3.putString(r13, r1)
            r3.putString(r12, r14)
            java.lang.String r0 = r2.getError()
            r3.putString(r11, r0)
            r1 = 1
            r3.putBoolean(r6, r1)
            return r3
        L_0x0232:
            r1 = 1
            java.lang.String r4 = r2.getErrorTitle()
            if (r4 == 0) goto L_0x027f
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r7 = r5.length()
            int r7 = r7 - r1
            r1 = r7
            r7 = 0
            r8 = 0
        L_0x0244:
            if (r7 > r1) goto L_0x0264
            if (r8 != 0) goto L_0x024a
            r9 = r7
            goto L_0x024b
        L_0x024a:
            r9 = r1
        L_0x024b:
            char r9 = r5.charAt(r9)
            r10 = 32
            if (r9 > r10) goto L_0x0255
            r9 = 1
            goto L_0x0256
        L_0x0255:
            r9 = 0
        L_0x0256:
            if (r8 != 0) goto L_0x025f
            if (r9 != 0) goto L_0x025c
            r8 = 1
            goto L_0x0244
        L_0x025c:
            int r7 = r7 + 1
            goto L_0x0244
        L_0x025f:
            if (r9 == 0) goto L_0x0264
            int r1 = r1 + -1
            goto L_0x0244
        L_0x0264:
            r8 = 1
            int r1 = r1 + r8
            java.lang.CharSequence r1 = r5.subSequence(r7, r1)
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0279
            r16 = 1
            goto L_0x027b
        L_0x0279:
            r16 = 0
        L_0x027b:
            if (r16 == 0) goto L_0x027f
            r14 = r4
            goto L_0x028b
        L_0x027f:
            if (r0 == 0) goto L_0x028b
            int r1 = net.one97.paytm.recharge.R.string.unable_to_proceed
            java.lang.String r0 = r0.getString(r1)
            if (r0 != 0) goto L_0x028a
            goto L_0x028b
        L_0x028a:
            r14 = r0
        L_0x028b:
            r3.putString(r13, r14)
            java.lang.String r0 = r2.getError()
            r3.putString(r12, r0)
            java.lang.String r0 = r2.getErrorCode()
            r3.putString(r11, r0)
            r0 = 1
            r3.putBoolean(r6, r0)
            return r3
        L_0x02a1:
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r18.getCart()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            java.lang.String r1 = r1.getError()
            if (r1 == 0) goto L_0x0331
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r18.getCart()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            java.lang.String r1 = r1.getErrorTitle()
            if (r1 == 0) goto L_0x0301
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r4 = r2.length()
            r5 = 1
            int r4 = r4 - r5
            r5 = 0
            r7 = 0
        L_0x02c6:
            if (r7 > r4) goto L_0x02e6
            if (r5 != 0) goto L_0x02cc
            r9 = r7
            goto L_0x02cd
        L_0x02cc:
            r9 = r4
        L_0x02cd:
            char r9 = r2.charAt(r9)
            r10 = 32
            if (r9 > r10) goto L_0x02d7
            r9 = 1
            goto L_0x02d8
        L_0x02d7:
            r9 = 0
        L_0x02d8:
            if (r5 != 0) goto L_0x02e1
            if (r9 != 0) goto L_0x02de
            r5 = 1
            goto L_0x02c6
        L_0x02de:
            int r7 = r7 + 1
            goto L_0x02c6
        L_0x02e1:
            if (r9 == 0) goto L_0x02e6
            int r4 = r4 + -1
            goto L_0x02c6
        L_0x02e6:
            r5 = 1
            int r4 = r4 + r5
            java.lang.CharSequence r2 = r2.subSequence(r7, r4)
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x02fb
            r16 = 1
            goto L_0x02fd
        L_0x02fb:
            r16 = 0
        L_0x02fd:
            if (r16 == 0) goto L_0x0301
            r14 = r1
            goto L_0x030d
        L_0x0301:
            if (r0 == 0) goto L_0x030d
            int r1 = net.one97.paytm.recharge.R.string.unable_to_proceed
            java.lang.String r0 = r0.getString(r1)
            if (r0 != 0) goto L_0x030c
            goto L_0x030d
        L_0x030c:
            r14 = r0
        L_0x030d:
            r3.putString(r13, r14)
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r18.getCart()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            java.lang.String r0 = r0.getError()
            r3.putString(r12, r0)
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r18.getCart()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            java.lang.String r0 = r0.getErrorCode()
            r3.putString(r11, r0)
            r0 = 1
            r3.putBoolean(r6, r0)
            return r3
        L_0x0331:
            if (r20 == 0) goto L_0x037a
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r18.getCart()
            if (r1 == 0) goto L_0x033e
            java.lang.String r4 = r1.getPromoFailureText()
            goto L_0x033f
        L_0x033e:
            r4 = 0
        L_0x033f:
            if (r4 == 0) goto L_0x037a
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r18.getCart()
            if (r1 == 0) goto L_0x034c
            java.lang.String r4 = r1.getPromoStatus()
            goto L_0x034d
        L_0x034c:
            r4 = 0
        L_0x034d:
            java.lang.String r1 = "failure"
            r2 = 1
            boolean r1 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r2)
            if (r1 == 0) goto L_0x037a
            if (r0 == 0) goto L_0x0360
            int r1 = net.one97.paytm.recharge.R.string.msg_invalid_recharge_promo_code
            java.lang.String r0 = r0.getString(r1)
            if (r0 != 0) goto L_0x0361
        L_0x0360:
            r0 = r14
        L_0x0361:
            r3.putString(r13, r0)
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r18.getCart()
            if (r0 == 0) goto L_0x0372
            java.lang.String r0 = r0.getPromoFailureText()
            if (r0 != 0) goto L_0x0371
            goto L_0x0372
        L_0x0371:
            r14 = r0
        L_0x0372:
            r3.putString(r12, r14)
            r0 = 1
            r3.putBoolean(r6, r0)
            return r3
        L_0x037a:
            r0 = 0
            r3.putBoolean(r6, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.az.a(android.content.Context, net.one97.paytm.common.entity.CJRRechargeCart, boolean, boolean):android.os.Bundle");
    }

    public static boolean f(Context context) {
        kotlin.g.b.k.c(context, "context");
        return p.a(e.b.RESELLER.toString(), com.paytm.utility.b.ak(context), true);
    }

    public static boolean e(Context context, String str) {
        kotlin.g.b.k.c(context, "context");
        return a(context, str) && f(context);
    }

    public static boolean a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, CJRFrequentOrder cJRFrequentOrder) {
        kotlin.g.b.k.c(cJRAutomaticSubscriptionItemModel, "subscription");
        kotlin.g.b.k.c(cJRFrequentOrder, "recent");
        String operator = cJRAutomaticSubscriptionItemModel.getProduct().getOperator();
        String circle = cJRAutomaticSubscriptionItemModel.getProduct().getCircle();
        String service = cJRAutomaticSubscriptionItemModel.getProduct().getService();
        String paytype = cJRAutomaticSubscriptionItemModel.getProduct().getPaytype();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(operator)) {
            sb.append(operator);
        }
        if (!TextUtils.isEmpty(circle)) {
            sb.append(circle);
        }
        if (!TextUtils.isEmpty(service)) {
            sb.append(service);
        }
        if (!TextUtils.isEmpty(paytype)) {
            sb.append(paytype);
        }
        String sb2 = sb.toString();
        kotlin.g.b.k.a((Object) sb2, "subscriptionBuilder.toString()");
        if (TextUtils.isEmpty(sb2)) {
            return false;
        }
        CJRFrequentOrderProduct frequentOrderProduct = cJRFrequentOrder.getFrequentOrderProduct();
        kotlin.g.b.k.a((Object) frequentOrderProduct, "recent.frequentOrderProduct");
        String operator2 = frequentOrderProduct.getOperator();
        CJRFrequentOrderProduct frequentOrderProduct2 = cJRFrequentOrder.getFrequentOrderProduct();
        kotlin.g.b.k.a((Object) frequentOrderProduct2, "recent.frequentOrderProduct");
        String circle2 = frequentOrderProduct2.getCircle();
        CJRFrequentOrderProduct frequentOrderProduct3 = cJRFrequentOrder.getFrequentOrderProduct();
        kotlin.g.b.k.a((Object) frequentOrderProduct3, "recent.frequentOrderProduct");
        String service2 = frequentOrderProduct3.getService();
        CJRFrequentOrderProduct frequentOrderProduct4 = cJRFrequentOrder.getFrequentOrderProduct();
        kotlin.g.b.k.a((Object) frequentOrderProduct4, "recent.frequentOrderProduct");
        String paytype2 = frequentOrderProduct4.getPaytype();
        StringBuilder sb3 = new StringBuilder();
        if (!TextUtils.isEmpty(operator2)) {
            sb3.append(operator2);
        }
        if (!TextUtils.isEmpty(circle2)) {
            sb3.append(circle2);
        }
        if (!TextUtils.isEmpty(service2)) {
            sb3.append(service2);
        }
        if (!TextUtils.isEmpty(paytype2)) {
            sb3.append(paytype2);
        }
        String sb4 = sb3.toString();
        kotlin.g.b.k.a((Object) sb4, "recentBuilder.toString()");
        if (TextUtils.isEmpty(sb4)) {
            return false;
        }
        return p.a(sb4, sb2, true);
    }

    public static void g(Context context) {
        kotlin.g.b.k.c(context, "context");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(context.getString(R.string.read_contact_alert_message));
            builder.setPositiveButton(context.getString(R.string.action_settings), new g(context));
            builder.setNegativeButton(context.getString(R.string.cancel), h.f61529a);
            builder.show();
        } catch (Exception e2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
    }

    static final class g implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f61528a;

        g(Context context) {
            this.f61528a = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            s.b(this.f61528a);
        }
    }

    public static final boolean b(String str, Context context) {
        kotlin.g.b.k.c(context, "context");
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        HashMap<String, String> bv = net.one97.paytm.recharge.di.helper.c.bv();
        if (bv == null) {
            return false;
        }
        Map map = bv;
        if (map == null) {
            throw new u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        } else if (map.containsKey(str)) {
            return ba.c((String) map.get(str), context);
        } else {
            return false;
        }
    }

    public static final void a(Context context, long j2) {
        kotlin.g.b.k.c(context, "context");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(H5TabbarUtils.MATCH_TYPE_PATH, "/mysubscriptions/".concat(String.valueOf(j2)));
            jSONObject.put("params", "?type=CART");
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            jSONObject.put("sparams", new JSONObject(net.one97.paytm.recharge.di.helper.c.bP()));
            String jSONObject2 = jSONObject.toString();
            kotlin.g.b.k.a((Object) jSONObject2, "paramsJson.toString()");
            Charset charset = kotlin.m.d.f47971a;
            if (jSONObject2 != null) {
                byte[] bytes = jSONObject2.getBytes(charset);
                kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                String encodeToString = Base64.encodeToString(bytes, 0);
                kotlin.g.b.k.a((Object) encodeToString, "android.util.Base64.enco…e64.DEFAULT\n            )");
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                StringBuilder sb = new StringBuilder("paytmmp://mini-app?aId=");
                net.one97.paytm.recharge.di.helper.c cVar2 = net.one97.paytm.recharge.di.helper.c.f62654a;
                sb.append(net.one97.paytm.recharge.di.helper.c.bN());
                sb.append("&data=");
                sb.append(encodeToString);
                sb.append("&url=");
                net.one97.paytm.recharge.di.helper.c cVar3 = net.one97.paytm.recharge.di.helper.c.f62654a;
                sb.append(net.one97.paytm.recharge.di.helper.c.bO());
                cJRRechargeUtilities.launchDeeplink(context, sb.toString(), new CJRHomePageItem());
                return;
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    public static final void f(Context context, String str) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "rechargeNumber");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(H5TabbarUtils.MATCH_TYPE_PATH, "/mysubscriptions");
        if (TextUtils.isEmpty(str)) {
            jSONObject.put("params", "");
        } else {
            jSONObject.put("params", "?recharge_number=".concat(String.valueOf(str)));
        }
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        jSONObject.put("sparams", new JSONObject(net.one97.paytm.recharge.di.helper.c.bP()));
        String jSONObject2 = jSONObject.toString();
        kotlin.g.b.k.a((Object) jSONObject2, "paramsJson.toString()");
        Charset charset = kotlin.m.d.f47971a;
        if (jSONObject2 != null) {
            byte[] bytes = jSONObject2.getBytes(charset);
            kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 0);
            kotlin.g.b.k.a((Object) encodeToString, "android.util.Base64.enco…roid.util.Base64.DEFAULT)");
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            StringBuilder sb = new StringBuilder("paytmmp://mini-app?aId=");
            net.one97.paytm.recharge.di.helper.c cVar2 = net.one97.paytm.recharge.di.helper.c.f62654a;
            sb.append(net.one97.paytm.recharge.di.helper.c.bN());
            sb.append("&data=");
            sb.append(encodeToString);
            sb.append("&url=");
            net.one97.paytm.recharge.di.helper.c cVar3 = net.one97.paytm.recharge.di.helper.c.f62654a;
            sb.append(net.one97.paytm.recharge.di.helper.c.bO());
            cJRRechargeUtilities.launchDeeplink(context, sb.toString(), new CJRHomePageItem());
            return;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public static final void g(Context context, String str) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "rechargeNumber");
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        StringBuilder sb = new StringBuilder("paytmmp://automatic-h5?url=");
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        sb.append(net.one97.paytm.recharge.di.helper.c.bM());
        sb.append("&recharge_number=");
        sb.append(str);
        cJRRechargeUtilities.launchDeeplink(context, sb.toString(), new CJRHomePageItem());
    }

    public static void h(Context context) {
        kotlin.g.b.k.c(context, "context");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(context.getString(R.string.read_sms_alert_message));
            builder.setPositiveButton(context.getString(R.string.action_settings), new i(context));
            builder.setNegativeButton(context.getString(R.string.cancel), j.f61531a);
            builder.show();
        } catch (Exception e2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
    }

    static final class i implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f61530a;

        i(Context context) {
            this.f61530a = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            s.b(this.f61530a);
        }
    }

    public static void a(ImageView imageView, String str) {
        kotlin.g.b.k.c(imageView, "imageView");
        if (str == null) {
            imageView.setImageDrawable(androidx.core.content.b.a(imageView.getContext(), R.drawable.transparent_border));
            return;
        }
        if (!(str.length() > 0)) {
            imageView.setImageDrawable(androidx.core.content.b.a(imageView.getContext(), R.drawable.v4_cardit_card_default_bg_12dp_radius));
        } else {
            w.a().a(str).a(imageView, (com.squareup.picasso.e) new d(imageView));
        }
    }

    public static final class d implements com.squareup.picasso.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f61527a;

        public final void onSuccess() {
        }

        d(ImageView imageView) {
            this.f61527a = imageView;
        }

        public final void onError(Exception exc) {
            ImageView imageView = this.f61527a;
            imageView.setImageDrawable(androidx.core.content.b.a(imageView.getContext(), R.drawable.v4_cardit_card_default_bg_12dp_radius));
        }
    }

    public static final String a(String str) {
        kotlin.g.b.k.c(str, SDKConstants.CARD_NUMBER);
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        int a2 = ba.a(str);
        if (a2 == 1 || a2 == 2 || a2 == 3) {
            String c2 = ba.c(charSequence);
            kotlin.g.b.k.a((Object) c2, "RechargeUtils.formatText…rd_Extraspace(cardNumber)");
            return c2;
        } else if (a2 == 4) {
            if (!TextUtils.isEmpty(charSequence) && str.length() > 6) {
                StringBuilder sb = new StringBuilder();
                String substring = str.substring(0, 6);
                kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring);
                sb.append("XXXXX");
                String substring2 = str.substring(str.length() - 4, str.length());
                kotlin.g.b.k.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring2);
                str = sb.toString();
            }
            String e2 = ba.e((CharSequence) str);
            kotlin.g.b.k.a((Object) e2, "RechargeUtils.formatText…aspace(updatedCardNumber)");
            return e2;
        } else if (a2 != 5) {
            String c3 = ba.c(charSequence);
            kotlin.g.b.k.a((Object) c3, "RechargeUtils.formatText…rd_Extraspace(cardNumber)");
            return c3;
        } else {
            if (!TextUtils.isEmpty(charSequence) && str.length() > 6) {
                StringBuilder sb2 = new StringBuilder();
                String substring3 = str.substring(0, 6);
                kotlin.g.b.k.a((Object) substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb2.append(substring3);
                sb2.append("XXXX");
                String substring4 = str.substring(str.length() - 4, str.length());
                kotlin.g.b.k.a((Object) substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb2.append(substring4);
                str = sb2.toString();
            }
            String e3 = ba.e((CharSequence) str);
            kotlin.g.b.k.a((Object) e3, "RechargeUtils.formatText…aspace(updatedCardNumber)");
            return e3;
        }
    }

    public static void a(EditText editText, int i2) {
        kotlin.g.b.k.c(editText, "view");
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            kotlin.g.b.k.a((Object) declaredField, "TextView::class.java.get…eld(\"mCursorDrawableRes\")");
            declaredField.setAccessible(true);
            int i3 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            kotlin.g.b.k.a((Object) declaredField2, "TextView::class.java.getDeclaredField(\"mEditor\")");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            kotlin.g.b.k.a(obj, "field.get(view)");
            Drawable a2 = androidx.core.content.b.a(editText.getContext(), i3);
            if (a2 != null) {
                a2.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            }
            Drawable[] drawableArr = {a2, a2};
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            kotlin.g.b.k.a((Object) declaredField3, "editor.javaClass.getDecl…dField(\"mCursorDrawable\")");
            declaredField3.setAccessible(true);
            declaredField3.set(obj, drawableArr);
        } catch (Throwable th) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
        }
    }

    public static final void i(Context context) {
        kotlin.g.b.k.c(context, "context");
        CJRRechargeUtilities.INSTANCE.launchDeeplink(context, "paytmmp://automatic-h5?showCategories=true", new CJRHomePageItem());
    }

    public static final String b(String str) {
        kotlin.g.b.k.c(str, "categoryId");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "https://storefront.paytm.com/v2/h/" + str + "-scratch-card";
    }

    public static final boolean a(String str, Context context) {
        boolean z;
        String str2;
        kotlin.g.b.k.c(str, "downloadUrl");
        kotlin.g.b.k.c(context, "context");
        int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
        if (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) {
            kotlin.g.b.k.c(context, "context");
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage(context.getResources().getString(R.string.enable_download_manager_permission_alert_msg));
                builder.setPositiveButton(context.getResources().getString(R.string.action_settings), new k(context));
                builder.setNegativeButton(context.getResources().getString(R.string.cancel), l.f61534a);
                builder.show();
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
            z = false;
        } else {
            z = true;
        }
        if (z && kotlin.g.b.k.a((Object) "mounted", (Object) Environment.getExternalStorageState())) {
            try {
                Object systemService = context.getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
                if (systemService != null) {
                    DownloadManager downloadManager = (DownloadManager) systemService;
                    Uri parse = Uri.parse(str);
                    kotlin.g.b.k.a((Object) parse, "Uri.parse(downloadUrl)");
                    DownloadManager.Request request = new DownloadManager.Request(parse);
                    String path = parse.getPath();
                    if (path != null) {
                        String path2 = parse.getPath();
                        if (path2 == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) path2, "uri.path!!");
                        int a2 = p.a((CharSequence) path2, '/', p.d(path2)) + 1;
                        if (path != null) {
                            str2 = path.substring(a2);
                            kotlin.g.b.k.a((Object) str2, "(this as java.lang.String).substring(startIndex)");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        str2 = null;
                    }
                    request.setDescription("Downloading...");
                    request.setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, str2);
                    request.setNotificationVisibility(1);
                    downloadManager.enqueue(request);
                    return true;
                }
                throw new u("null cannot be cast to non-null type android.app.DownloadManager");
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
