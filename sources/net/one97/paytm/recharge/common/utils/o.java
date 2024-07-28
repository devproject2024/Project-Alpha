package net.one97.paytm.recharge.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.s;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.recharge.CJRSelectedRecharge;
import net.one97.paytm.common.entity.shopping.CJRAddress;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.app.VerifyPromoResultListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;
import net.one97.paytm.nativesdk.orflow.promo.utils.Constants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.u;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJRPersonalInsurance;
import net.one97.paytm.recharge.model.CJRPromoCode;
import net.one97.paytm.recharge.model.CJRPromoSearchModel;
import net.one97.paytm.recharge.model.ErrorDesc;
import net.one97.paytm.recharge.model.ErrorInfo;
import net.one97.paytm.recharge.widgets.c.h;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class o implements VerifyPromoCallbackListener, OnPromoActivityDestroyListener {
    private final boolean A;
    private final String B;
    private final String C;
    private final String D;

    /* renamed from: a  reason: collision with root package name */
    public boolean f61684a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<PaymentIntent> f61685b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f61686c;

    /* renamed from: d  reason: collision with root package name */
    public Context f61687d;

    /* renamed from: e  reason: collision with root package name */
    final String f61688e;

    /* renamed from: f  reason: collision with root package name */
    CJRRechargeCart f61689f;

    /* renamed from: g  reason: collision with root package name */
    final u f61690g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f61691h;

    /* renamed from: i  reason: collision with root package name */
    private final String f61692i;
    /* access modifiers changed from: private */
    public CJRPromoSearchModel j;
    private ArrayList<CJRSelectedRecharge> k;
    private ArrayList<String> l;
    private CJRSelectedRecharge m;
    private CJRPersonalInsurance n;
    private CJRAddress o;
    /* access modifiers changed from: private */
    public CJRPromoCode p;
    private com.google.gsonhtcfix.o q;
    private com.google.gsonhtcfix.o r;
    /* access modifiers changed from: private */
    public boolean s;
    /* access modifiers changed from: private */
    public String t;
    /* access modifiers changed from: private */
    public String u;
    private final String v;
    private final String w;
    private final double x;
    private final String y;
    private CJRDetailProduct z;

    public final void clearPromoCode(String str, PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
    }

    public o(Context context, String str, String str2, String str3, double d2, CJRRechargeCart cJRRechargeCart, String str4, CJRDetailProduct cJRDetailProduct, boolean z2, String str5, String str6, u uVar, String str7) {
        k.c(str2, "categoryVerticalName");
        k.c(str3, "categoryId");
        this.f61687d = context;
        this.f61688e = str;
        this.v = str2;
        this.w = str3;
        this.x = d2;
        this.f61689f = cJRRechargeCart;
        this.y = str4;
        this.z = cJRDetailProduct;
        this.A = z2;
        this.B = str5;
        this.C = str6;
        this.f61690g = uVar;
        this.D = str7;
        this.f61692i = "v1";
        this.f61691h = f();
        b();
        this.k = new ArrayList<>();
        this.l = new ArrayList<>();
        this.m = new CJRSelectedRecharge();
        this.s = true;
        this.t = "";
        this.u = "";
    }

    public /* synthetic */ o(Context context, String str, String str2, u uVar) {
        this(context, (String) null, str, str2, 10.0d, (CJRRechargeCart) null, (String) null, (CJRDetailProduct) null, false, (String) null, (String) null, uVar, (String) null);
    }

    public final void a(ArrayList<CJRSelectedRecharge> arrayList) {
        k.c(arrayList, "rechargeList");
        this.k = arrayList;
    }

    public final void b(ArrayList<String> arrayList) {
        k.c(arrayList, "couponIdList");
        this.l = arrayList;
    }

    public final void a(CJRSelectedRecharge cJRSelectedRecharge) {
        k.c(cJRSelectedRecharge, "rechargeProduct");
        this.m = cJRSelectedRecharge;
    }

    public final void a(CJRPersonalInsurance cJRPersonalInsurance) {
        k.c(cJRPersonalInsurance, "personalInsurance");
        this.n = cJRPersonalInsurance;
    }

    public final boolean a() {
        return this.j != null;
    }

    public final void b() {
        x.e eVar = new x.e();
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        eVar.element = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        ((CJRRechargeErrorModel) eVar.element).setUserFacing(a.b.SILENT);
        y.a(new a(this, eVar)).a(io.reactivex.rxjava3.i.a.b()).b(io.reactivex.rxjava3.android.b.a.a()).a(new b(this, eVar));
    }

    static final class a<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61693a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f61694b;

        a(o oVar, x.e eVar) {
            this.f61693a = oVar;
            this.f61694b = eVar;
        }

        public final void subscribe(z<CJRPromoSearchModel> zVar) {
            String str;
            k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed()) {
                String str2 = "";
                if (TextUtils.isEmpty(this.f61693a.f61691h)) {
                    str = this.f61693a.f();
                    this.f61693a.f61691h = str;
                } else {
                    str = str2;
                }
                ay ayVar = ay.f61523a;
                ay.a("load_bank_offers", (Object) (CJRRechargeErrorModel) this.f61694b.element);
                ((CJRRechargeErrorModel) this.f61694b.element).setUrl(str);
                HashMap hashMap = new HashMap();
                if (this.f61693a.f61687d != null) {
                    Map map = hashMap;
                    String a2 = com.paytm.utility.d.a(this.f61693a.f61687d);
                    if (a2 != null) {
                        str2 = a2;
                    }
                    map.put(AppConstants.SSO_TOKEN, str2);
                }
                String a3 = this.f61693a.f61691h;
                ai aVar = new C1190a(this, zVar);
                IJRPaytmDataModel cJRPromoSearchModel = new CJRPromoSearchModel((ArrayList) null, 1, (kotlin.g.b.g) null);
                if (this.f61693a.f61687d == null || !com.paytm.utility.d.c(this.f61693a.f61687d)) {
                    hashMap = null;
                }
                net.one97.paytm.recharge.common.f.b bVar = new net.one97.paytm.recharge.common.f.b("load_bank_offers", a3, aVar, cJRPromoSearchModel, hashMap, (CJRRechargeErrorModel) this.f61694b.element);
                if (com.paytm.utility.b.c(this.f61693a.f61687d)) {
                    net.one97.paytm.recharge.common.f.d.a();
                    net.one97.paytm.recharge.common.f.d.b(bVar);
                    return;
                }
                zVar.tryOnError(new h());
            }
        }

        /* renamed from: net.one97.paytm.recharge.common.utils.o$a$a  reason: collision with other inner class name */
        public static final class C1190a implements ai {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f61695a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ z f61696b;

            C1190a(a aVar, z zVar) {
                this.f61695a = aVar;
                this.f61696b = zVar;
            }

            public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                k.c(str, "tag");
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.BANK_OFFERS_LOADED_SUCCESSFULLY);
                z zVar = this.f61696b;
                if (iJRPaytmDataModel != null) {
                    zVar.onSuccess((CJRPromoSearchModel) iJRPaytmDataModel);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.model.CJRPromoSearchModel");
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                k.c(str, "tag");
                if (obj instanceof CJRRechargeErrorModel) {
                    this.f61695a.f61694b.element = (CJRRechargeErrorModel) obj;
                }
                if (networkCustomError != null) {
                    this.f61696b.tryOnError(networkCustomError);
                }
            }
        }
    }

    public static final class b implements aa<CJRPromoSearchModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61697a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f61698b;

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            k.c(cVar, "d");
        }

        b(o oVar, x.e eVar) {
            this.f61697a = oVar;
            this.f61698b = eVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            CJRPromoSearchModel cJRPromoSearchModel = (CJRPromoSearchModel) obj;
            k.c(cJRPromoSearchModel, "t");
            this.f61697a.j = cJRPromoSearchModel;
        }

        public final void onError(Throwable th) {
            k.c(th, "e");
            if (!(th instanceof h)) {
                az azVar = az.f61525a;
                az.a((CJRRechargeErrorModel) this.f61698b.element);
            }
        }
    }

    /* access modifiers changed from: private */
    public final String f() {
        String str;
        String str2;
        CJRCart cart;
        ArrayList<CJRCartProduct> cartItems;
        CJRCartProduct cJRCartProduct;
        CJRRechargeCart cJRRechargeCart = this.f61689f;
        if (cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null || (cartItems = cart.getCartItems()) == null || (cJRCartProduct = cartItems.get(0)) == null || (str = cJRCartProduct.getOffersUrl()) == null) {
            str = "https://gateway.paytm.com/papi/v2/promosearch/category/" + this.w + "/offers?price=" + this.x;
        }
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence) || !p.a(charSequence, (CharSequence) this.f61692i, false)) {
            str2 = "";
        } else {
            String a2 = p.a(str, this.f61692i, "v2", false);
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            str2 = k.a(net.one97.paytm.recharge.di.helper.c.V(), (Object) a2);
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Context context = this.f61687d;
        if (context != null) {
            str = com.paytm.utility.b.s(context, str);
            k.a((Object) str, "CJRAppCommonUtility.addD…outSSO(context, offerUrl)");
            az azVar = az.f61525a;
            Context context2 = this.f61687d;
            if (context2 == null) {
                k.a();
            }
            if (az.f(context2)) {
                str = str + "&isReseller=true";
            }
        }
        return str + "&sortType=2";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        if (r3 == null) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPaymentIntentSelected(java.lang.String r11, java.util.ArrayList<net.one97.paytm.nativesdk.common.model.PaymentIntent> r12, java.lang.String r13, net.one97.paytm.nativesdk.app.VerifyPromoResultListener r14) {
        /*
            r10 = this;
            android.content.Context r0 = r10.f61687d
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            r1 = 0
            if (r0 == 0) goto L_0x004b
            r0 = 1
            r10.s = r0
            r10.f61685b = r12
            r10.t = r11
            r10.u = r13
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r2 = "(this as java.lang.String).toUpperCase()"
            if (r11 == 0) goto L_0x002a
            if (r11 == 0) goto L_0x0024
            java.lang.String r3 = r11.toUpperCase()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
            if (r3 != 0) goto L_0x002c
            goto L_0x002a
        L_0x0024:
            kotlin.u r11 = new kotlin.u
            r11.<init>(r0)
            throw r11
        L_0x002a:
            java.lang.String r3 = ""
        L_0x002c:
            org.json.JSONObject r5 = r10.a((java.lang.String) r3, (java.lang.String) r1, (java.util.ArrayList<net.one97.paytm.nativesdk.common.model.PaymentIntent>) r12, (java.lang.String) r13)
            if (r11 == 0) goto L_0x0042
            if (r11 == 0) goto L_0x003c
            java.lang.String r1 = r11.toUpperCase()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            goto L_0x0042
        L_0x003c:
            kotlin.u r11 = new kotlin.u
            r11.<init>(r0)
            throw r11
        L_0x0042:
            r8 = r1
            r7 = 0
            r6 = 1
            r4 = r10
            r9 = r14
            r4.a((org.json.JSONObject) r5, (boolean) r6, (int) r7, (java.lang.String) r8, (net.one97.paytm.nativesdk.app.VerifyPromoResultListener) r9)
            return
        L_0x004b:
            if (r14 == 0) goto L_0x0060
            android.content.Context r11 = r10.f61687d
            if (r11 == 0) goto L_0x005d
            android.content.res.Resources r11 = r11.getResources()
            if (r11 == 0) goto L_0x005d
            int r12 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r1 = r11.getString(r12)
        L_0x005d:
            r14.onVerifyPromoError(r1)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.o.onPaymentIntentSelected(java.lang.String, java.util.ArrayList, java.lang.String, net.one97.paytm.nativesdk.app.VerifyPromoResultListener):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bb, code lost:
        if (r8 == null) goto L_0x00c4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPromoSelected(java.lang.String r41, int r42, java.lang.String r43, net.one97.paytm.nativesdk.app.VerifyPromoResultListener r44) {
        /*
            r40 = this;
            r6 = r40
            r0 = r41
            r1 = r43
            r5 = r44
            android.content.Context r2 = r6.f61687d
            boolean r2 = com.paytm.utility.b.c((android.content.Context) r2)
            r3 = 0
            if (r2 == 0) goto L_0x00f6
            r2 = 0
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r7 = 1
            if (r4 != 0) goto L_0x00ac
            net.one97.paytm.recharge.model.CJRPromoSearchModel r4 = r6.j
            if (r4 == 0) goto L_0x0082
            if (r4 != 0) goto L_0x0025
            kotlin.g.b.k.a()
        L_0x0025:
            java.util.ArrayList r4 = r4.getCodes()
            if (r4 == 0) goto L_0x0082
            net.one97.paytm.recharge.model.CJRPromoSearchModel r4 = r6.j
            if (r4 != 0) goto L_0x0032
            kotlin.g.b.k.a()
        L_0x0032:
            java.util.ArrayList r4 = r4.getCodes()
            if (r4 != 0) goto L_0x003b
            kotlin.g.b.k.a()
        L_0x003b:
            java.util.Iterator r4 = r4.iterator()
        L_0x003f:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x005d
            java.lang.Object r8 = r4.next()
            net.one97.paytm.recharge.model.CJRPromoCode r8 = (net.one97.paytm.recharge.model.CJRPromoCode) r8
            if (r0 != 0) goto L_0x0050
            kotlin.g.b.k.a()
        L_0x0050:
            java.lang.String r9 = r8.getCode()
            boolean r9 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r9, (boolean) r7)
            if (r9 == 0) goto L_0x003f
            r6.p = r8
            r2 = 1
        L_0x005d:
            if (r2 != 0) goto L_0x00ac
            net.one97.paytm.recharge.model.CJRPromoCode r2 = new net.one97.paytm.recharge.model.CJRPromoCode
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 8191(0x1fff, float:1.1478E-41)
            r23 = 0
            r8 = r2
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r2.setCode(r0)
            r6.p = r2
            goto L_0x00ac
        L_0x0082:
            net.one97.paytm.recharge.model.CJRPromoCode r2 = new net.one97.paytm.recharge.model.CJRPromoCode
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 8191(0x1fff, float:1.1478E-41)
            r39 = 0
            r24 = r2
            r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)
            r2.setCode(r0)
            r6.p = r2
        L_0x00ac:
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r4 = "(this as java.lang.String).toUpperCase()"
            if (r0 == 0) goto L_0x00c4
            if (r0 == 0) goto L_0x00be
            java.lang.String r8 = r41.toUpperCase()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)
            if (r8 != 0) goto L_0x00c6
            goto L_0x00c4
        L_0x00be:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r2)
            throw r0
        L_0x00c4:
            java.lang.String r8 = ""
        L_0x00c6:
            org.json.JSONObject r8 = r6.a((java.lang.String) r8, (java.lang.String) r1, (java.util.ArrayList<net.one97.paytm.nativesdk.common.model.PaymentIntent>) r3, (java.lang.String) r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r1 = r1 ^ r7
            r6.f61684a = r1
            boolean r1 = r6.f61684a
            r7 = r7 ^ r1
            if (r0 == 0) goto L_0x00e9
            if (r0 == 0) goto L_0x00e3
            java.lang.String r0 = r41.toUpperCase()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r4 = r0
            goto L_0x00ea
        L_0x00e3:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r2)
            throw r0
        L_0x00e9:
            r4 = r3
        L_0x00ea:
            r0 = r40
            r1 = r8
            r2 = r7
            r3 = r42
            r5 = r44
            r0.a((org.json.JSONObject) r1, (boolean) r2, (int) r3, (java.lang.String) r4, (net.one97.paytm.nativesdk.app.VerifyPromoResultListener) r5)
            return
        L_0x00f6:
            if (r5 == 0) goto L_0x010b
            android.content.Context r0 = r6.f61687d
            if (r0 == 0) goto L_0x0108
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x0108
            int r1 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r3 = r0.getString(r1)
        L_0x0108:
            r5.onVerifyPromoError(r3)
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.o.onPromoSelected(java.lang.String, int, java.lang.String, net.one97.paytm.nativesdk.app.VerifyPromoResultListener):void");
    }

    public final void c() {
        Context context = this.f61687d;
        if (context == null || !com.paytm.utility.d.c(context)) {
            c cVar = new c();
            u uVar = this.f61690g;
            if (uVar != null) {
                uVar.a((NetworkCustomError) cVar);
                return;
            }
            return;
        }
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        Context context2 = this.f61687d;
        if (context2 == null) {
            k.a();
        }
        String str = this.f61688e;
        double d2 = this.x;
        String g2 = g();
        String str2 = this.f61691h;
        if (str2 == null) {
            str2 = "";
        }
        cJRRechargeUtilities.openPromoSelectionScreen(context2, str, d2, g2, str2, this, this);
    }

    private final String g() {
        try {
            if (this.j != null) {
                String a2 = new com.google.gsonhtcfix.f().a((Object) this.j);
                k.a((Object) a2, "Gson().toJson(promoResponse)");
                return a2;
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public final void onPromoSearchActivityDestroy(boolean z2) {
        if (!z2) {
            this.f61684a = false;
            this.f61685b = null;
        }
    }

    /* access modifiers changed from: private */
    public final void a(JSONObject jSONObject, boolean z2, int i2, String str, VerifyPromoResultListener verifyPromoResultListener) {
        x.a aVar = new x.a();
        aVar.element = z2;
        x.e eVar = new x.e();
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        eVar.element = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        ay ayVar = ay.f61523a;
        ay.a(ERROR_TYPE.INLINE_ERROR, ACTION_TYPE.BANK_PROMO_VERIFY, (CJRRechargeErrorModel) eVar.element);
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        String a2 = net.one97.paytm.recharge.widgets.c.d.a(jSONObject);
        CRUFlowModel flowName = ((CJRRechargeErrorModel) eVar.element).getFlowName();
        if (flowName != null) {
            flowName.setRequestBody(a2);
        }
        y.a(new c(this, jSONObject, i2, eVar, verifyPromoResultListener)).a(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new d(this, i2, str, aVar, verifyPromoResultListener, eVar));
    }

    static final class c<T> implements ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61699a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f61700b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f61701c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x.e f61702d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ VerifyPromoResultListener f61703e;

        c(o oVar, JSONObject jSONObject, int i2, x.e eVar, VerifyPromoResultListener verifyPromoResultListener) {
            this.f61699a = oVar;
            this.f61700b = jSONObject;
            this.f61701c = i2;
            this.f61702d = eVar;
            this.f61703e = verifyPromoResultListener;
        }

        public final void subscribe(final z<CJRRechargeCart> zVar) {
            Resources resources;
            Resources resources2;
            k.a((Object) zVar, "emitter");
            if (!zVar.isDisposed()) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("Content-Type", "application/json");
                if (this.f61699a.f61687d != null) {
                    hashMap = com.paytm.utility.b.a(hashMap, this.f61699a.f61687d);
                    k.a((Object) hashMap, "CJRAppCommonUtility.addS…nHeader(headers, context)");
                }
                az azVar = az.f61525a;
                String a2 = az.a(this.f61700b);
                net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                String c2 = net.one97.paytm.recharge.di.helper.c.c(a2);
                if (URLUtil.isValidUrl(c2)) {
                    String s = com.paytm.utility.b.s(this.f61699a.f61687d, ba.a(a2, c2));
                    if (this.f61699a.f61687d != null) {
                        az azVar2 = az.f61525a;
                        Context context = this.f61699a.f61687d;
                        if (context == null) {
                            k.a();
                        }
                        if (az.f(context)) {
                            s = s + "&is_reseller=1";
                        }
                    }
                    if (az.a(this.f61699a.f61687d, a2)) {
                        Uri.Builder appendQueryParameter = Uri.parse(s).buildUpon().appendQueryParameter("payment_info_version", "2");
                        if (this.f61701c == 1) {
                            appendQueryParameter.appendQueryParameter("manual_promocode", "1");
                        }
                        try {
                            s = new URL(appendQueryParameter.build().toString()).toString();
                        } catch (MalformedURLException unused) {
                        }
                        if (az.a(this.f61699a.f61687d)) {
                            s = k.a(s, (Object) "&show_bank_offers=1");
                        }
                    }
                    String str = s;
                    String str2 = null;
                    if (!URLUtil.isValidUrl(str)) {
                        VerifyPromoResultListener verifyPromoResultListener = this.f61703e;
                        if (verifyPromoResultListener != null) {
                            Context context2 = this.f61699a.f61687d;
                            if (!(context2 == null || (resources = context2.getResources()) == null)) {
                                str2 = resources.getString(R.string.msg_invalid_url);
                            }
                            verifyPromoResultListener.onVerifyPromoError(str2);
                        }
                    } else if (com.paytm.utility.b.c(this.f61699a.f61687d)) {
                        net.one97.paytm.recharge.common.f.d.a();
                        net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.c("fetch_promo_verify", str, (ai) new ai(this) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ c f61704a;

                            {
                                this.f61704a = r1;
                            }

                            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                                k.c(str, "tag");
                                if (obj instanceof CJRRechargeErrorModel) {
                                    this.f61704a.f61702d.element = (CJRRechargeErrorModel) obj;
                                }
                                if (networkCustomError != null) {
                                    zVar.tryOnError(networkCustomError);
                                }
                            }

                            public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                                k.c(str, "tag");
                                if (obj instanceof CJRRechargeErrorModel) {
                                    this.f61704a.f61702d.element = (CJRRechargeErrorModel) obj;
                                }
                                z zVar = zVar;
                                if (iJRPaytmDataModel != null) {
                                    zVar.onSuccess((CJRRechargeCart) iJRPaytmDataModel);
                                    return;
                                }
                                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRRechargeCart");
                            }
                        }, (IJRPaytmDataModel) new CJRRechargeCart(), (Map<String, String>) hashMap, this.f61700b.toString(), a.C0715a.POST, (Object) (CJRRechargeErrorModel) this.f61702d.element));
                    } else {
                        VerifyPromoResultListener verifyPromoResultListener2 = this.f61703e;
                        if (verifyPromoResultListener2 != null) {
                            Context context3 = this.f61699a.f61687d;
                            if (!(context3 == null || (resources2 = context3.getResources()) == null)) {
                                str2 = resources2.getString(R.string.no_internet);
                            }
                            verifyPromoResultListener2.onVerifyPromoError(str2);
                        }
                    }
                }
            }
        }
    }

    public static final class d implements aa<CJRRechargeCart> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61706a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f61707b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f61708c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x.a f61709d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ VerifyPromoResultListener f61710e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ x.e f61711f;

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            k.c(cVar, "d");
        }

        d(o oVar, int i2, String str, x.a aVar, VerifyPromoResultListener verifyPromoResultListener, x.e eVar) {
            this.f61706a = oVar;
            this.f61707b = i2;
            this.f61708c = str;
            this.f61709d = aVar;
            this.f61710e = verifyPromoResultListener;
            this.f61711f = eVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d9, code lost:
            if (r0 == null) goto L_0x00e2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onSuccess(java.lang.Object r9) {
            /*
                r8 = this;
                net.one97.paytm.common.entity.CJRRechargeCart r9 = (net.one97.paytm.common.entity.CJRRechargeCart) r9
                java.lang.String r0 = "response"
                kotlin.g.b.k.c(r9, r0)
                net.one97.paytm.common.entity.shopping.CJRCart r0 = r9.getCart()
                r1 = 0
                if (r0 == 0) goto L_0x0013
                com.google.gsonhtcfix.o r0 = r0.getPaymentInstruments()
                goto L_0x0014
            L_0x0013:
                r0 = r1
            L_0x0014:
                net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = net.one97.paytm.recharge.common.utils.o.b((com.google.gsonhtcfix.o) r0)
                int r2 = r8.f61707b
                java.lang.String r3 = r8.f61708c
                boolean r2 = net.one97.paytm.recharge.common.utils.o.a((int) r2, (java.lang.String) r3, (net.one97.paytm.common.entity.CJRRechargeCart) r9)
                r3 = 0
                if (r2 == 0) goto L_0x002c
                net.one97.paytm.recharge.common.utils.o r2 = r8.f61706a
                r2.f61684a = true
                kotlin.g.b.x$a r2 = r8.f61709d
                r2.element = r3
            L_0x002c:
                net.one97.paytm.common.entity.shopping.CJRCart r2 = r9.getCart()
                java.lang.String r4 = "response.cart"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
                r2.setPromoMetaData(r1)
                net.one97.paytm.recharge.common.utils.o r2 = r8.f61706a
                r2.f61689f = r9
                kotlin.g.b.x$a r2 = r8.f61709d
                boolean r2 = r2.element
                java.lang.String r5 = "SUCCESS"
                java.lang.String r6 = ""
                r7 = 1
                if (r2 == 0) goto L_0x01e2
                net.one97.paytm.recharge.common.utils.o r2 = r8.f61706a
                boolean r2 = r2.f61684a
                if (r2 != 0) goto L_0x0054
                net.one97.paytm.recharge.common.utils.o r2 = r8.f61706a
                r2.f61685b = null
            L_0x0054:
                net.one97.paytm.recharge.common.utils.o r2 = r8.f61706a
                boolean r2 = r2.f61684a
                if (r2 == 0) goto L_0x012b
                net.one97.paytm.recharge.common.utils.o r2 = r8.f61706a
                boolean r2 = r2.s
                if (r2 == 0) goto L_0x012b
                net.one97.paytm.recharge.common.utils.o r0 = r8.f61706a
                boolean r0 = r0.s
                if (r0 == 0) goto L_0x012a
                net.one97.paytm.recharge.common.utils.o r0 = r8.f61706a
                r0.s = false
                net.one97.paytm.recharge.common.utils.o r0 = r8.f61706a
                android.content.Context r0 = r0.f61687d
                boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
                if (r0 == 0) goto L_0x0111
                net.one97.paytm.recharge.common.utils.o r0 = r8.f61706a
                java.util.ArrayList r0 = r0.f61685b
                if (r0 == 0) goto L_0x00c4
                java.util.Collection r0 = (java.util.Collection) r0
                boolean r0 = r0.isEmpty()
                r0 = r0 ^ r7
                if (r0 != r7) goto L_0x00c4
                net.one97.paytm.recharge.common.utils.o r0 = r8.f61706a
                java.util.ArrayList r0 = r0.f61685b
                if (r0 == 0) goto L_0x00c4
                java.lang.Object r0 = r0.get(r3)
                net.one97.paytm.nativesdk.common.model.PaymentIntent r0 = (net.one97.paytm.nativesdk.common.model.PaymentIntent) r0
                if (r0 == 0) goto L_0x00c4
                net.one97.paytm.common.entity.shopping.CJRCart r9 = r9.getCart()
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
                java.lang.String r9 = r9.getGrandTotalExcludingConvFee()
                if (r9 == 0) goto L_0x00b7
                java.math.BigDecimal r2 = new java.math.BigDecimal
                r2.<init>(r9)
                double r2 = r2.doubleValue()
                java.lang.Double r9 = java.lang.Double.valueOf(r2)
                goto L_0x00b8
            L_0x00b7:
                r9 = r1
            L_0x00b8:
                if (r9 != 0) goto L_0x00bd
                kotlin.g.b.k.a()
            L_0x00bd:
                double r2 = r9.doubleValue()
                r0.setTxnAmount(r2)
            L_0x00c4:
                net.one97.paytm.recharge.common.utils.o r9 = r8.f61706a
                java.lang.String r0 = r9.t
                java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
                java.lang.String r3 = "(this as java.lang.String).toUpperCase()"
                if (r0 == 0) goto L_0x00e2
                if (r0 == 0) goto L_0x00dc
                java.lang.String r0 = r0.toUpperCase()
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
                if (r0 != 0) goto L_0x00e3
                goto L_0x00e2
            L_0x00dc:
                kotlin.u r9 = new kotlin.u
                r9.<init>(r2)
                throw r9
            L_0x00e2:
                r0 = r6
            L_0x00e3:
                net.one97.paytm.recharge.common.utils.o r4 = r8.f61706a
                java.util.ArrayList r4 = r4.f61685b
                net.one97.paytm.recharge.common.utils.o r5 = r8.f61706a
                java.lang.String r5 = r5.u
                org.json.JSONObject r9 = r9.a((java.lang.String) r0, (java.lang.String) null, (java.util.ArrayList<net.one97.paytm.nativesdk.common.model.PaymentIntent>) r4, (java.lang.String) r5)
                net.one97.paytm.recharge.common.utils.o r0 = r8.f61706a
                java.lang.String r4 = r0.t
                if (r4 == 0) goto L_0x010b
                if (r4 == 0) goto L_0x0105
                java.lang.String r1 = r4.toUpperCase()
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
                goto L_0x010b
            L_0x0105:
                kotlin.u r9 = new kotlin.u
                r9.<init>(r2)
                throw r9
            L_0x010b:
                net.one97.paytm.nativesdk.app.VerifyPromoResultListener r2 = r8.f61710e
                r0.a((org.json.JSONObject) r9, true, 0, (java.lang.String) r1, (net.one97.paytm.nativesdk.app.VerifyPromoResultListener) r2)
                return
            L_0x0111:
                net.one97.paytm.nativesdk.app.VerifyPromoResultListener r9 = r8.f61710e
                if (r9 == 0) goto L_0x012a
                net.one97.paytm.recharge.common.utils.o r0 = r8.f61706a
                android.content.Context r0 = r0.f61687d
                if (r0 == 0) goto L_0x0127
                android.content.res.Resources r0 = r0.getResources()
                if (r0 == 0) goto L_0x0127
                int r1 = net.one97.paytm.recharge.R.string.no_internet
                java.lang.String r1 = r0.getString(r1)
            L_0x0127:
                r9.onVerifyPromoError(r1)
            L_0x012a:
                return
            L_0x012b:
                net.one97.paytm.common.entity.shopping.CJRCartStatus r2 = r9.getCartStatus()
                if (r2 == 0) goto L_0x0136
                java.lang.String r2 = r2.getResult()
                goto L_0x0137
            L_0x0136:
                r2 = r1
            L_0x0137:
                boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r7)
                if (r2 == 0) goto L_0x01a8
                net.one97.paytm.recharge.common.utils.o r1 = r8.f61706a
                net.one97.paytm.nativesdk.app.VerifyPromoResultListener r2 = r8.f61710e
                kotlin.g.b.x$e r3 = r8.f61711f
                T r3 = r3.element
                net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3
                kotlin.g.b.x$a r5 = r8.f61709d
                boolean r5 = r5.element
                boolean r1 = r1.a((net.one97.paytm.common.entity.CJRRechargeCart) r9, (net.one97.paytm.nativesdk.app.VerifyPromoResultListener) r2, (java.lang.Object) r3, (boolean) r5)
                if (r1 != 0) goto L_0x028d
                net.one97.paytm.common.entity.shopping.CJRCart r1 = r9.getCart()
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
                java.lang.String r1 = r1.getPromoStatus()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x0192
                net.one97.paytm.common.entity.shopping.CJRCart r1 = r9.getCart()
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
                java.lang.String r1 = r1.getPromoStatus()
                java.lang.String r2 = "Success"
                boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r7)
                if (r1 == 0) goto L_0x0192
                net.one97.paytm.recharge.common.utils.o r1 = r8.f61706a
                net.one97.paytm.recharge.common.e.u r1 = r1.f61690g
                if (r1 == 0) goto L_0x0186
                net.one97.paytm.recharge.common.utils.o r2 = r8.f61706a
                net.one97.paytm.recharge.model.CJRPromoCode r2 = r2.p
                r1.a(r2, r9)
            L_0x0186:
                net.one97.paytm.recharge.common.utils.o r1 = r8.f61706a
                net.one97.paytm.nativesdk.app.VerifyPromoResultListener r2 = r8.f61710e
                kotlin.g.b.x$a r3 = r8.f61709d
                boolean r3 = r3.element
                net.one97.paytm.recharge.common.utils.o.a((net.one97.paytm.recharge.common.utils.o) r1, (net.one97.paytm.nativesdk.app.VerifyPromoResultListener) r2, (boolean) r3, (net.one97.paytm.nativesdk.common.model.CJPayMethodResponse) r0, (net.one97.paytm.common.entity.CJRRechargeCart) r9)
                return
            L_0x0192:
                net.one97.paytm.recharge.common.utils.o r0 = r8.f61706a
                net.one97.paytm.nativesdk.app.VerifyPromoResultListener r1 = r8.f61710e
                net.one97.paytm.common.entity.shopping.CJRCart r9 = r9.getCart()
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
                java.lang.String r6 = r9.getPromoFailureText()
                java.lang.String r9 = "response.cart.promoFailureText"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
                goto L_0x0284
            L_0x01a8:
                kotlin.g.b.x$e r0 = r8.f61711f
                T r0 = r0.element
                net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
                net.one97.paytm.common.entity.shopping.CJRCartStatus r2 = r9.getCartStatus()
                if (r2 == 0) goto L_0x01be
                com.paytm.network.model.CJRError r2 = r2.getMessage()
                if (r2 == 0) goto L_0x01be
                java.lang.String r1 = r2.getMessage()
            L_0x01be:
                r0.setErrorMsg(r1)
                net.one97.paytm.recharge.common.utils.o r0 = r8.f61706a
                net.one97.paytm.nativesdk.app.VerifyPromoResultListener r1 = r8.f61710e
                net.one97.paytm.common.entity.shopping.CJRCartStatus r9 = r9.getCartStatus()
                if (r9 == 0) goto L_0x01d7
                com.paytm.network.model.CJRError r9 = r9.getMessage()
                if (r9 == 0) goto L_0x01d7
                java.lang.String r9 = r9.getMessage()
                if (r9 != 0) goto L_0x01d8
            L_0x01d7:
                r9 = r6
            L_0x01d8:
                kotlin.g.b.x$e r2 = r8.f61711f
                T r2 = r2.element
                net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2
                r0.a((net.one97.paytm.nativesdk.app.VerifyPromoResultListener) r1, (java.lang.String) r9, (java.lang.Object) r2)
                return
            L_0x01e2:
                net.one97.paytm.common.entity.shopping.CJRCartStatus r2 = r9.getCartStatus()
                if (r2 == 0) goto L_0x01ed
                java.lang.String r2 = r2.getResult()
                goto L_0x01ee
            L_0x01ed:
                r2 = r1
            L_0x01ee:
                boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r7)
                if (r2 == 0) goto L_0x0253
                net.one97.paytm.recharge.common.utils.o r1 = r8.f61706a
                net.one97.paytm.nativesdk.app.VerifyPromoResultListener r2 = r8.f61710e
                kotlin.g.b.x$e r3 = r8.f61711f
                T r3 = r3.element
                net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3
                kotlin.g.b.x$a r4 = r8.f61709d
                boolean r4 = r4.element
                boolean r1 = r1.a((net.one97.paytm.common.entity.CJRRechargeCart) r9, (net.one97.paytm.nativesdk.app.VerifyPromoResultListener) r2, (java.lang.Object) r3, (boolean) r4)
                if (r1 != 0) goto L_0x028d
                net.one97.paytm.nativesdk.MerchantBL r1 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
                java.lang.String r2 = "MerchantBL.getMerchantInstance()"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                net.one97.paytm.recharge.common.utils.o r2 = r8.f61706a
                java.lang.String r2 = r2.f61688e
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 == 0) goto L_0x0240
                net.one97.paytm.recharge.common.utils.o r2 = r8.f61706a
                net.one97.paytm.common.entity.CJRRechargeCart r2 = r2.f61689f
                if (r2 == 0) goto L_0x0244
                net.one97.paytm.common.entity.shopping.CJRCart r2 = r2.getCart()
                if (r2 == 0) goto L_0x0244
                com.google.gsonhtcfix.o r2 = r2.getPaymentInfo()
                if (r2 == 0) goto L_0x0244
                java.lang.String r3 = "mid"
                com.google.gsonhtcfix.l r2 = r2.b(r3)
                if (r2 == 0) goto L_0x0244
                java.lang.String r2 = r2.b()
                if (r2 != 0) goto L_0x023e
                goto L_0x0244
            L_0x023e:
                r6 = r2
                goto L_0x0244
            L_0x0240:
                net.one97.paytm.recharge.common.utils.o r2 = r8.f61706a
                java.lang.String r6 = r2.f61688e
            L_0x0244:
                r1.setMid(r6)
                net.one97.paytm.recharge.common.utils.o r1 = r8.f61706a
                net.one97.paytm.nativesdk.app.VerifyPromoResultListener r2 = r8.f61710e
                kotlin.g.b.x$a r3 = r8.f61709d
                boolean r3 = r3.element
                net.one97.paytm.recharge.common.utils.o.a((net.one97.paytm.recharge.common.utils.o) r1, (net.one97.paytm.nativesdk.app.VerifyPromoResultListener) r2, (boolean) r3, (net.one97.paytm.nativesdk.common.model.CJPayMethodResponse) r0, (net.one97.paytm.common.entity.CJRRechargeCart) r9)
                return
            L_0x0253:
                kotlin.g.b.x$e r0 = r8.f61711f
                T r0 = r0.element
                net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
                net.one97.paytm.common.entity.shopping.CJRCartStatus r2 = r9.getCartStatus()
                if (r2 == 0) goto L_0x0269
                com.paytm.network.model.CJRError r2 = r2.getMessage()
                if (r2 == 0) goto L_0x0269
                java.lang.String r1 = r2.getMessage()
            L_0x0269:
                r0.setErrorMsg(r1)
                net.one97.paytm.recharge.common.utils.o r0 = r8.f61706a
                net.one97.paytm.nativesdk.app.VerifyPromoResultListener r1 = r8.f61710e
                net.one97.paytm.common.entity.shopping.CJRCartStatus r9 = r9.getCartStatus()
                if (r9 == 0) goto L_0x0284
                com.paytm.network.model.CJRError r9 = r9.getMessage()
                if (r9 == 0) goto L_0x0284
                java.lang.String r9 = r9.getMessage()
                if (r9 != 0) goto L_0x0283
                goto L_0x0284
            L_0x0283:
                r6 = r9
            L_0x0284:
                kotlin.g.b.x$e r9 = r8.f61711f
                T r9 = r9.element
                net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r9 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r9
                r0.a((net.one97.paytm.nativesdk.app.VerifyPromoResultListener) r1, (java.lang.String) r6, (java.lang.Object) r9)
            L_0x028d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.o.d.onSuccess(java.lang.Object):void");
        }

        public final void onError(Throwable th) {
            s sVar;
            s sVar2;
            Resources resources;
            Resources resources2;
            Resources resources3;
            Resources resources4;
            k.c(th, "e");
            NetworkCustomError networkCustomError = th instanceof NetworkCustomError ? (NetworkCustomError) th : new NetworkCustomError(th);
            if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                o oVar = this.f61706a;
                k.c(networkCustomError, "error");
                String str = null;
                if (networkCustomError instanceof ap) {
                    Integer valueOf = Integer.valueOf(((ap) networkCustomError).getStatusCode());
                    Context context = oVar.f61687d;
                    String string = (context == null || (resources4 = context.getResources()) == null) ? null : resources4.getString(R.string.msg_invalid_url);
                    Context context2 = oVar.f61687d;
                    if (!(context2 == null || (resources3 = context2.getResources()) == null)) {
                        str = resources3.getString(R.string.error);
                    }
                    sVar = new s(valueOf, string, str);
                } else if (networkCustomError instanceof as) {
                    Integer valueOf2 = Integer.valueOf(((as) networkCustomError).getStatusCode());
                    Context context3 = oVar.f61687d;
                    String string2 = (context3 == null || (resources2 = context3.getResources()) == null) ? null : resources2.getString(R.string.no_internet);
                    Context context4 = oVar.f61687d;
                    if (!(context4 == null || (resources = context4.getResources()) == null)) {
                        str = resources.getString(R.string.no_connection);
                    }
                    sVar = new s(valueOf2, string2, str);
                } else {
                    if (networkCustomError instanceof bc) {
                        sVar2 = new s(410, null, null);
                    } else if (networkCustomError instanceof c) {
                        sVar2 = new s(410, null, null);
                    } else {
                        sVar = new s(Integer.valueOf(networkCustomError.getStatusCode()), ai.a(networkCustomError.getAlertMessage(), networkCustomError.getMessage()), networkCustomError.getAlertTitle());
                    }
                    sVar = sVar2;
                }
                if (this.f61710e != null) {
                    Integer num = (Integer) sVar.getFirst();
                    String str2 = (String) sVar.getSecond();
                    String str3 = (String) sVar.getThird();
                    VerifyPromoResultListener verifyPromoResultListener = this.f61710e;
                    k.c(verifyPromoResultListener, "verifyListener");
                    PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
                    apiResponseError.setStatusCode(num != null ? num.intValue() : -1);
                    apiResponseError.setErrorMsg(str2);
                    apiResponseError.setErrorTitle(str3);
                    apiResponseError.setShouldClosePG(true);
                    apiResponseError.setClosePgWithoutError(true);
                    verifyPromoResultListener.onVerifyPromoNetworkError(apiResponseError);
                    this.f61706a.a(networkCustomError);
                    return;
                }
                return;
            }
            o oVar2 = this.f61706a;
            VerifyPromoResultListener verifyPromoResultListener2 = this.f61710e;
            String alertMessage = networkCustomError.getAlertMessage();
            k.a((Object) alertMessage, "error.alertMessage");
            oVar2.a(verifyPromoResultListener2, alertMessage, (Object) (CJRRechargeErrorModel) this.f61711f.element);
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61717a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NetworkCustomError f61718b;

        g(o oVar, NetworkCustomError networkCustomError) {
            this.f61717a = oVar;
            this.f61718b = networkCustomError;
        }

        public final void run() {
            u uVar = this.f61717a.f61690g;
            if (uVar != null) {
                uVar.a(this.f61718b);
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
        new Handler().postDelayed(new g(this, networkCustomError), 300);
    }

    /* access modifiers changed from: private */
    public static CJPayMethodResponse b(com.google.gsonhtcfix.o oVar) {
        if (oVar != null) {
            try {
                Object a2 = new com.google.gsonhtcfix.f().a(oVar.toString(), CJPayMethodResponse.class);
                if (a2 != null) {
                    return (CJPayMethodResponse) a2;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.nativesdk.common.model.CJPayMethodResponse");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final void a(VerifyPromoResultListener verifyPromoResultListener, String str, Object obj) {
        az azVar = az.f61525a;
        if (obj != null) {
            az.a((CJRRechargeErrorModel) obj);
            Context context = this.f61687d;
            if (context != null) {
                try {
                    if (context == null) {
                        k.a();
                    }
                    net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
                    String str2 = this.D;
                    if (str2 == null) {
                        str2 = "";
                    }
                    String str3 = str2;
                    StringBuilder sb = new StringBuilder();
                    CJRPromoCode cJRPromoCode = this.p;
                    sb.append(cJRPromoCode != null ? cJRPromoCode.getCode() : null);
                    sb.append("/");
                    sb.append(str);
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, str3, "apply_promocode_failed", (Object) null, sb.toString(), (Object) null, (Object) null, (Object) null, 116);
                } catch (Throwable unused) {
                }
            }
            if (verifyPromoResultListener != null) {
                verifyPromoResultListener.onVerifyPromoError(str);
                return;
            }
            return;
        }
        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel");
    }

    /* access modifiers changed from: private */
    public final JSONObject a(String str, String str2, ArrayList<PaymentIntent> arrayList, String str3) {
        String str4 = str;
        String str5 = str2;
        ArrayList<PaymentIntent> arrayList2 = arrayList;
        String str6 = str3;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = this.f61686c;
        if (jSONObject2 == null) {
            try {
                if (this.k.size() > 0) {
                    int size = this.k.size();
                    int i2 = 0;
                    while (i2 < size) {
                        JSONObject jSONObject3 = new JSONObject();
                        CJRSelectedRecharge cJRSelectedRecharge = this.k.get(i2);
                        k.a((Object) cJRSelectedRecharge, "mSelectedRechargeList[index]");
                        jSONObject3.put(CLPConstants.PRODUCT_ID, cJRSelectedRecharge.getProductId());
                        jSONObject3.put("qty", 1);
                        JSONObject jSONObject4 = new JSONObject();
                        int i3 = size;
                        CJRSelectedRecharge cJRSelectedRecharge2 = this.k.get(i2);
                        k.a((Object) cJRSelectedRecharge2, "mSelectedRechargeList[index]");
                        Map<String, String> configList = cJRSelectedRecharge2.getConfigList();
                        for (String next : configList.keySet()) {
                            jSONObject4.put(next, configList.get(next));
                            ArrayList<PaymentIntent> arrayList3 = arrayList;
                            String str7 = str3;
                        }
                        if (!k.a((Object) this.m, (Object) this.k.get(i2))) {
                            jSONObject4.put("upsell", 1);
                        }
                        jSONObject3.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject4);
                        CJRSelectedRecharge cJRSelectedRecharge3 = this.k.get(i2);
                        k.a((Object) cJRSelectedRecharge3, "mSelectedRechargeList[index]");
                        String productId = cJRSelectedRecharge3.getProductId();
                        k.a((Object) productId, "mSelectedRechargeList[index].productId");
                        CJRCartProduct a2 = a(productId);
                        Object metaDataResponse = a2 != null ? a2.getMetaDataResponse() : null;
                        if (metaDataResponse != null) {
                            try {
                                String a3 = new com.google.gsonhtcfix.f().a(metaDataResponse);
                                if (!TextUtils.isEmpty(a3)) {
                                    JSONObject jSONObject5 = new JSONObject(a3);
                                    if (!TextUtils.isEmpty(this.y)) {
                                        jSONObject5.put("post_order_view_type", this.y);
                                    }
                                    a(jSONObject5);
                                    if (this.A && g.c(str) && TextUtils.isEmpty(str5)) {
                                        if (str4 != null) {
                                            String upperCase = str.toUpperCase();
                                            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                                            jSONObject5.put(Utility.EVENT_CATEGORY_PROMOCODE, upperCase);
                                        } else {
                                            throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
                                        }
                                    }
                                    jSONObject3.put("meta_data", jSONObject5);
                                } else {
                                    continue;
                                }
                            } catch (Exception unused) {
                                continue;
                            }
                        } else {
                            JSONObject jSONObject6 = new JSONObject();
                            if (!TextUtils.isEmpty(this.y)) {
                                jSONObject6.put("post_order_view_type", this.y);
                            }
                            a(jSONObject6);
                            jSONObject3.put("meta_data", jSONObject6);
                        }
                        jSONArray.put(jSONObject3);
                        i2++;
                        ArrayList<PaymentIntent> arrayList4 = arrayList;
                        String str8 = str3;
                        size = i3;
                    }
                }
                if (this.l.size() > 0) {
                    int size2 = this.l.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        JSONObject jSONObject7 = new JSONObject();
                        jSONObject7.put(CLPConstants.PRODUCT_ID, this.l.get(i4));
                        jSONObject7.put("qty", 1);
                        try {
                            String str9 = this.l.get(i4);
                            CJRPersonalInsurance cJRPersonalInsurance = this.n;
                            try {
                                if (p.a(str9, cJRPersonalInsurance != null ? cJRPersonalInsurance.getProductID() : null, true)) {
                                    try {
                                        com.google.gson.f fVar = new com.google.gson.f();
                                        CJRPersonalInsurance cJRPersonalInsurance2 = this.n;
                                        String b2 = fVar.b(cJRPersonalInsurance2 != null ? cJRPersonalInsurance2.getMetaDataInsurance() : null);
                                        if (!TextUtils.isEmpty(b2)) {
                                            JSONObject jSONObject8 = new JSONObject(b2);
                                            jSONObject8.put("insurance_url", this.C);
                                            jSONObject7.put("meta_data", jSONObject8);
                                        }
                                    } catch (Exception unused2) {
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                                jSONArray.put(jSONObject7);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                            jSONArray.put(jSONObject7);
                        }
                        jSONArray.put(jSONObject7);
                    }
                }
                if (jSONArray.length() == 0) {
                    return jSONObject;
                }
                jSONObject.put("cart_items", jSONArray);
            } catch (Throwable th3) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(th3);
            }
        } else {
            jSONObject = jSONObject2;
        }
        CharSequence charSequence = str5;
        if (TextUtils.isEmpty(charSequence) && jSONObject != null) {
            jSONObject.put(Utility.EVENT_CATEGORY_PROMOCODE, str4);
        }
        if (!TextUtils.isEmpty(this.B) && jSONObject != null) {
            jSONObject.put("payment_method", this.B);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            try {
                if (!TextUtils.isEmpty(new com.google.gsonhtcfix.f().a((Object) str5)) && jSONObject != null) {
                    jSONObject.put("paymentFilters", str5);
                }
            } catch (Exception unused3) {
            }
        } else if (jSONObject != null) {
            jSONObject.put("paymentFilters", (Object) null);
        }
        ArrayList<PaymentIntent> arrayList5 = arrayList;
        if (arrayList5 != null && arrayList.size() > 0) {
            try {
                String a4 = new com.google.gsonhtcfix.f().a((Object) arrayList5);
                if (jSONObject != null) {
                    jSONObject.put("payment_intent", a4);
                }
            } catch (Exception unused4) {
            }
        }
        String str10 = str3;
        if (!TextUtils.isEmpty(str10) && jSONObject != null) {
            jSONObject.put("enable_upi_psp", str10);
        }
        if (this.o != null) {
            aw awVar = aw.f61520a;
            JSONObject a5 = aw.a(this.o);
            if (!(a5 == null || jSONObject == null)) {
                jSONObject.put(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, a5);
            }
        }
        y yVar = y.f61814b;
        y.a(jSONObject);
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    public final String d() {
        ArrayList<PaymentIntent> arrayList = this.f61685b;
        if (arrayList != null) {
            if (arrayList == null) {
                k.a();
            }
            if (!arrayList.isEmpty()) {
                try {
                    return new com.google.gsonhtcfix.f().a((Object) this.f61685b);
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    private final CJRCartProduct a(String str) {
        CJRCart cart;
        if (!TextUtils.isEmpty(str)) {
            CJRRechargeCart cJRRechargeCart = this.f61689f;
            if ((cJRRechargeCart != null ? cJRRechargeCart.getCart() : null) != null) {
                CJRRechargeCart cJRRechargeCart2 = this.f61689f;
                if (((cJRRechargeCart2 == null || (cart = cJRRechargeCart2.getCart()) == null) ? null : cart.getCartItems()) != null) {
                    CJRRechargeCart cJRRechargeCart3 = this.f61689f;
                    if (cJRRechargeCart3 == null) {
                        k.a();
                    }
                    CJRCart cart2 = cJRRechargeCart3.getCart();
                    if (cart2 == null) {
                        k.a();
                    }
                    Iterator<CJRCartProduct> it2 = cart2.getCartItems().iterator();
                    while (it2.hasNext()) {
                        CJRCartProduct next = it2.next();
                        if (next != null && p.a(str, next.getProductId(), true)) {
                            return next;
                        }
                    }
                }
            }
        }
        return null;
    }

    private final void a(JSONObject jSONObject) {
        CJRDetailProduct cJRDetailProduct = this.z;
        if (cJRDetailProduct != null) {
            Map<String, String> attributes = cJRDetailProduct != null ? cJRDetailProduct.getAttributes() : null;
            if (attributes != null) {
                for (String next : attributes.keySet()) {
                    if (p.a("tag_price", next, true) || p.a("security", next, true) || p.a("threshold", next, true)) {
                        jSONObject.put(next, String.valueOf(attributes.get(next)));
                    }
                }
            }
        }
    }

    public final boolean e() {
        Context context = this.f61687d;
        return context != null && az.a(context, this.w) && az.d(this.f61687d, this.w);
    }

    public final void a(CJRRechargeCart cJRRechargeCart, CJRRechargePayment cJRRechargePayment) {
        CJRCart cart;
        k.c(cJRRechargeCart, "rechargeCart");
        CJRCart cart2 = cJRRechargeCart.getCart();
        if ((cart2 != null ? cart2.getPaymentInstruments() : null) != null) {
            CJRCart cart3 = cJRRechargeCart.getCart();
            this.q = cart3 != null ? cart3.getPaymentInstruments() : null;
        }
        CJRCart cart4 = cJRRechargeCart.getCart();
        if ((cart4 != null ? cart4.getPaymentInfo() : null) != null) {
            CJRCart cart5 = cJRRechargeCart.getCart();
            this.r = cart5 != null ? cart5.getPaymentInfo() : null;
        }
        if (!(this.r == null || (cart = cJRRechargeCart.getCart()) == null)) {
            cart.setPaymentInfo(this.r);
        }
        com.google.gsonhtcfix.o oVar = this.q;
        PaytmSDK.parseAndSetInstruments(oVar != null ? oVar.toString() : null);
        if (this.f61687d != null) {
            a aVar = a.f61493a;
            Context context = this.f61687d;
            if (context != null) {
                String str = this.v;
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                a.a((Activity) context, str, cJRRechargeCart, cJRRechargePayment, (Map<String, ? extends Object>) null, (Class<?>) null, net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null), this.f61684a);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.app.Activity");
        }
    }

    private static boolean a(String str, String str2) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (str2 == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            q.d(e2.getMessage());
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("cart");
        if (!(optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("promoMetaData")) == null || (optJSONObject2 = optJSONObject.optJSONObject("campData")) == null)) {
            String upperCase = str2.toUpperCase();
            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            JSONObject optJSONObject4 = optJSONObject2.optJSONObject(upperCase);
            if (optJSONObject4 != null) {
                return p.a(Constants.BANK_OFFER_KEY, optJSONObject4.optString("campaignType"), true);
            }
        }
        return false;
    }

    public final void a(CJRRechargeCart cJRRechargeCart, boolean z2) {
        k.c(cJRRechargeCart, "cjrRechargeCart");
        u uVar = this.f61690g;
        if (uVar != null) {
            uVar.a(cJRRechargeCart);
        }
        this.f61685b = null;
        this.f61684a = false;
        if (z2) {
            new Handler().postDelayed(new e(this), 400);
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61712a;

        e(o oVar) {
            this.f61712a = oVar;
        }

        public final void run() {
            this.f61712a.c();
        }
    }

    /* access modifiers changed from: private */
    public final boolean a(CJRRechargeCart cJRRechargeCart, VerifyPromoResultListener verifyPromoResultListener, Object obj, boolean z2) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        if ((cJRRechargeCart != null ? cJRRechargeCart.getCart() : null) != null) {
            CJRCart cart = cJRRechargeCart.getCart();
            k.a((Object) cart, "rechargeCart.cart");
            ArrayList<CJRCartProduct> cartItems = cart.getCartItems();
            CJRCart cart2 = cJRRechargeCart.getCart();
            k.a((Object) cart2, "rechargeCart.cart");
            String errorInfo = cart2.getErrorInfo();
            if (errorInfo != null && !p.a(errorInfo)) {
                try {
                    com.google.gson.f fVar = new com.google.gson.f();
                    CJRCart cart3 = cJRRechargeCart.getCart();
                    k.a((Object) cart3, "rechargeCart.cart");
                    Object a2 = fVar.a(cart3.getErrorInfo(), ErrorInfo.class);
                    if (a2 != null) {
                        ErrorInfo errorInfo2 = (ErrorInfo) a2;
                        com.google.gson.f fVar2 = new com.google.gson.f();
                        CJRCart cart4 = cJRRechargeCart.getCart();
                        k.a((Object) cart4, "rechargeCart.cart");
                        CJRCartProduct cJRCartProduct = cart4.getCartItems().get(0);
                        k.a((Object) cJRCartProduct, "rechargeCart.cart.cartItems[0]");
                        String b2 = fVar2.b(cJRCartProduct.getMetaDataResponse());
                        JSONObject jSONObject = b2 != null ? new JSONObject(b2) : null;
                        if (jSONObject != null && jSONObject.has("doNotBlockOnValidate") && jSONObject.getInt("doNotBlockOnValidate") == 1) {
                            ErrorDesc errorDesc = errorInfo2.getErrorDesc();
                            if (p.a("Action_ProceedOnValidationBlock", errorDesc != null ? errorDesc.getButtonAction() : null, true)) {
                                return false;
                            }
                        }
                        if (obj != null) {
                            ((CJRRechargeErrorModel) obj).setErrorCode(String.valueOf(errorInfo2.getErrorCode()));
                            ErrorDesc errorDesc2 = errorInfo2.getErrorDesc();
                            k.a((Object) errorDesc2, "errorInfo.errorDesc");
                            ((CJRRechargeErrorModel) obj).setErrorMsg(errorDesc2.getMessage());
                            ErrorDesc errorDesc3 = errorInfo2.getErrorDesc();
                            if (errorDesc3 != null) {
                                String message = errorDesc3.getMessage();
                                k.a((Object) message, "error.message");
                                a(verifyPromoResultListener, message, obj);
                                return true;
                            }
                        } else {
                            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel");
                        }
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.model.ErrorInfo");
                    }
                } catch (Exception unused) {
                }
            }
            Iterator<CJRCartProduct> it2 = cartItems.iterator();
            while (it2.hasNext()) {
                CJRCartProduct next = it2.next();
                k.a((Object) next, "cartProduct");
                if (next.getError() != null) {
                    if (obj != null) {
                        CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                        String error = next.getError();
                        if (error == null) {
                            error = "";
                        }
                        cJRRechargeErrorModel.setErrorMsg(error);
                        String error2 = next.getError();
                        k.a((Object) error2, "cartProduct.error");
                        a(verifyPromoResultListener, error2, obj);
                        return true;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel");
                }
            }
            CJRCart cart5 = cJRRechargeCart.getCart();
            k.a((Object) cart5, "rechargeCart.cart");
            if (cart5.getError() == null) {
                CJRCart cart6 = cJRRechargeCart.getCart();
                if (cart6 != null) {
                    str4 = cart6.getPromoStatus();
                }
                if (p.a(str4, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, true) && z2) {
                    if (obj != null) {
                        CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) obj;
                        CJRCart cart7 = cJRRechargeCart.getCart();
                        if (cart7 == null || (str = cart7.getPromoFailureText()) == null) {
                            str = "";
                        }
                        cJRRechargeErrorModel2.setErrorMsg(str);
                        CJRCart cart8 = cJRRechargeCart.getCart();
                        if (cart8 == null || (str2 = cart8.getPromoFailureText()) == null) {
                            str2 = "";
                        }
                        a(verifyPromoResultListener, str2, obj);
                        return true;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel");
                }
            } else if (obj != null) {
                CJRRechargeErrorModel cJRRechargeErrorModel3 = (CJRRechargeErrorModel) obj;
                CJRCart cart9 = cJRRechargeCart.getCart();
                if (cart9 == null || (str3 = cart9.getError()) == null) {
                    str3 = "";
                }
                cJRRechargeErrorModel3.setErrorMsg(str3);
                CJRCart cart10 = cJRRechargeCart.getCart();
                k.a((Object) cart10, "rechargeCart.cart");
                String error3 = cart10.getError();
                k.a((Object) error3, "rechargeCart.cart.error");
                a(verifyPromoResultListener, error3, obj);
                return true;
            } else {
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel");
            }
        }
        return false;
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f61713a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Integer f61714b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f61715c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f61716d;

        f(o oVar, Integer num, String str, String str2) {
            this.f61713a = oVar;
            this.f61714b = num;
            this.f61715c = str;
            this.f61716d = str2;
        }

        public final void run() {
            u uVar = this.f61713a.f61690g;
            if (uVar != null) {
                uVar.a(this.f61714b, this.f61715c, this.f61716d);
            }
        }
    }

    public static final /* synthetic */ boolean a(int i2, String str, CJRRechargeCart cJRRechargeCart) {
        if (i2 != 1) {
            return false;
        }
        String a2 = new com.google.gsonhtcfix.f().a((Object) cJRRechargeCart);
        k.a((Object) a2, "Gson().toJson(response)");
        return a(a2, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x005c, code lost:
        r4 = (r4 = r4.getPaymentInfo()).b("mid");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.recharge.common.utils.o r4, net.one97.paytm.nativesdk.app.VerifyPromoResultListener r5, boolean r6, net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r7, net.one97.paytm.common.entity.CJRRechargeCart r8) {
        /*
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ConvFeeResponse r0 = new net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ConvFeeResponse
            r0.<init>()
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r8.getCart()
            java.lang.String r2 = "response.cart"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r1 = r1.getAggregatePGConvFee()
            r0.setAggregatePGConvFee(r1)
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r8.getCart()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r1 = r1.getFinalPrice()
            r0.setTotalAmtIncConvFee(r1)
            if (r5 == 0) goto L_0x009e
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$VerifyResponseData r1 = new net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$VerifyResponseData
            r1.<init>()
            r1.setConvFeeResponse(r0)
            r1.setVerifyModel(r8)
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r8.getCart()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.String r0 = r0.getPromoText()
            r1.setOfferText(r0)
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r8.getCart()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.String r0 = r0.getPromoCode()
            r1.setPromoCode(r0)
            java.lang.String r4 = r4.f61688e
            if (r4 != 0) goto L_0x006a
            net.one97.paytm.common.entity.shopping.CJRCart r4 = r8.getCart()
            if (r4 == 0) goto L_0x0069
            com.google.gsonhtcfix.o r4 = r4.getPaymentInfo()
            if (r4 == 0) goto L_0x0069
            java.lang.String r0 = "mid"
            com.google.gsonhtcfix.l r4 = r4.b(r0)
            if (r4 == 0) goto L_0x0069
            java.lang.String r4 = r4.b()
            goto L_0x006a
        L_0x0069:
            r4 = 0
        L_0x006a:
            if (r4 != 0) goto L_0x006e
            java.lang.String r4 = ""
        L_0x006e:
            r1.setMid(r4)
            net.one97.paytm.common.entity.shopping.CJRCart r4 = r8.getCart()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            java.lang.String r4 = r4.getPaytmCashBack()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x009b
            net.one97.paytm.common.entity.shopping.CJRCart r4 = r8.getCart()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            java.lang.String r4 = r4.getPaytmCashBack()
            java.lang.String r8 = "response.cart.paytmCashBack"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            double r2 = java.lang.Double.parseDouble(r4)
            r1.setPaytmCashBack(r2)
        L_0x009b:
            r5.onVerifyPromoSuccess(r7, r6, r1)
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.o.a(net.one97.paytm.recharge.common.utils.o, net.one97.paytm.nativesdk.app.VerifyPromoResultListener, boolean, net.one97.paytm.nativesdk.common.model.CJPayMethodResponse, net.one97.paytm.common.entity.CJRRechargeCart):void");
    }
}
