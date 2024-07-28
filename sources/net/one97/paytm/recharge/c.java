package net.one97.paytm.recharge;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.gsonhtcfix.f;
import com.paytm.utility.b;
import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.h5.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.utils.t;

public final class c implements c.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f60405a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String f60406d = f60406d;

    /* renamed from: b  reason: collision with root package name */
    private final Context f60407b;

    /* renamed from: c  reason: collision with root package name */
    private final String f60408c;

    public c(Context context, String str) {
        k.c(context, "context");
        k.c(str, "verticalName");
        this.f60407b = context;
        this.f60408c = str;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String a(Context context) {
            String str;
            k.c(context, "context");
            String c2 = com.paytm.utility.a.c(context, "");
            String k = com.paytm.utility.b.k();
            Uri parse = Uri.parse(c2);
            k.a((Object) parse, "Uri.parse(url)");
            if (parse.getQuery() != null) {
                str = c2 + "&client_id=" + k;
            } else {
                str = c2 + "?client_id=" + k;
            }
            k.a((Object) str, "url");
            return str;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:4|5|(1:7)|8|9|10|(7:12|13|(1:15)|16|17|18|(1:20)(5:21|(1:23)|24|(1:26)|(4:28|(2:30|(2:32|(2:34|48)(1:35))(1:47))|36|37)(2:38|39)))(2:40|41)) */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0100, code lost:
            r12 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0101, code lost:
            r13 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE;
            r13.debugLog("Unable to get " + r14 + " payment options");
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE.debugLogExceptions(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0120, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003e */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0044 A[SYNTHETIC, Splitter:B:12:0x0044] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0066 A[Catch:{ Exception -> 0x0100 }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0067 A[Catch:{ Exception -> 0x0100 }] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00df A[Catch:{ Exception -> 0x0100 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void a(android.app.Activity r12, android.os.Bundle r13, java.lang.String r14) {
            /*
                java.lang.String r0 = "requestBody"
                java.lang.String r1 = "isS2SEnabled"
                java.lang.String r2 = "isBankOfferEnabled"
                java.lang.String r3 = "verifyResponse"
                java.lang.String r4 = "response"
                java.lang.String r5 = "activity"
                kotlin.g.b.k.c(r12, r5)
                java.lang.String r5 = "bundle"
                kotlin.g.b.k.c(r13, r5)
                java.lang.String r5 = "targetKey"
                kotlin.g.b.k.c(r14, r5)
                net.one97.paytm.common.entity.recharge.CJRRechargePayment r5 = new net.one97.paytm.common.entity.recharge.CJRRechargePayment     // Catch:{ Exception -> 0x0100 }
                r5.<init>()     // Catch:{ Exception -> 0x0100 }
                kotlin.g.b.x$e r8 = new kotlin.g.b.x$e     // Catch:{ Exception -> 0x0100 }
                r8.<init>()     // Catch:{ Exception -> 0x0100 }
                r6 = 0
                r8.element = r6     // Catch:{ Exception -> 0x0100 }
                boolean r6 = r13.containsKey(r4)     // Catch:{ Exception -> 0x0100 }
                if (r6 == 0) goto L_0x00f0
                java.lang.Object r4 = r13.get(r4)     // Catch:{ Exception -> 0x003e }
                if (r4 != 0) goto L_0x0037
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x003e }
            L_0x0037:
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x003e }
                r5.parseJSONObject(r4)     // Catch:{ Exception -> 0x003e }
            L_0x003e:
                boolean r4 = r13.containsKey(r3)     // Catch:{ Exception -> 0x0100 }
                if (r4 == 0) goto L_0x00df
                com.google.gsonhtcfix.f r4 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0060 }
                r4.<init>()     // Catch:{ Exception -> 0x0060 }
                java.lang.Object r3 = r13.get(r3)     // Catch:{ Exception -> 0x0060 }
                if (r3 != 0) goto L_0x0052
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0060 }
            L_0x0052:
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0060 }
                java.lang.Class<net.one97.paytm.common.entity.CJRRechargeCart> r6 = net.one97.paytm.common.entity.CJRRechargeCart.class
                java.lang.Object r3 = r4.a((java.lang.String) r3, r6)     // Catch:{ Exception -> 0x0060 }
                net.one97.paytm.common.entity.CJRRechargeCart r3 = (net.one97.paytm.common.entity.CJRRechargeCart) r3     // Catch:{ Exception -> 0x0060 }
                r8.element = r3     // Catch:{ Exception -> 0x0060 }
            L_0x0060:
                T r3 = r8.element     // Catch:{ Exception -> 0x0100 }
                net.one97.paytm.common.entity.CJRRechargeCart r3 = (net.one97.paytm.common.entity.CJRRechargeCart) r3     // Catch:{ Exception -> 0x0100 }
                if (r3 != 0) goto L_0x0067
                return
            L_0x0067:
                kotlin.g.b.x$a r10 = new kotlin.g.b.x$a     // Catch:{ Exception -> 0x0100 }
                r10.<init>()     // Catch:{ Exception -> 0x0100 }
                r3 = 0
                r10.element = r3     // Catch:{ Exception -> 0x0100 }
                boolean r4 = r13.containsKey(r2)     // Catch:{ Exception -> 0x0100 }
                if (r4 == 0) goto L_0x007b
                boolean r2 = r13.getBoolean(r2)     // Catch:{ Exception -> 0x0100 }
                r10.element = r2     // Catch:{ Exception -> 0x0100 }
            L_0x007b:
                boolean r2 = r13.containsKey(r1)     // Catch:{ Exception -> 0x0100 }
                if (r2 == 0) goto L_0x0085
                boolean r3 = r13.getBoolean(r1)     // Catch:{ Exception -> 0x0100 }
            L_0x0085:
                if (r3 == 0) goto L_0x00cd
                boolean r1 = r13.containsKey(r0)     // Catch:{ Exception -> 0x0100 }
                if (r1 == 0) goto L_0x00b0
                java.lang.Object r13 = r13.get(r0)     // Catch:{ Exception -> 0x0100 }
                if (r13 == 0) goto L_0x00af
                java.lang.String r0 = r13.toString()     // Catch:{ Exception -> 0x0100 }
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0100 }
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0100 }
                if (r0 == 0) goto L_0x00a0
                goto L_0x00af
            L_0x00a0:
                net.one97.paytm.recharge.common.utils.y r0 = net.one97.paytm.recharge.common.utils.y.f61814b     // Catch:{ Exception -> 0x0100 }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0100 }
                java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0100 }
                r0.<init>(r13)     // Catch:{ Exception -> 0x0100 }
                net.one97.paytm.recharge.common.utils.y.a((org.json.JSONObject) r0)     // Catch:{ Exception -> 0x0100 }
                goto L_0x00b0
            L_0x00af:
                return
            L_0x00b0:
                net.one97.paytm.recharge.common.utils.az r13 = net.one97.paytm.recharge.common.utils.az.f61525a     // Catch:{ Exception -> 0x0100 }
                T r13 = r8.element     // Catch:{ Exception -> 0x0100 }
                net.one97.paytm.common.entity.CJRRechargeCart r13 = (net.one97.paytm.common.entity.CJRRechargeCart) r13     // Catch:{ Exception -> 0x0100 }
                net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.common.entity.CJRRechargeCart) r13)     // Catch:{ Exception -> 0x0100 }
                net.one97.paytm.recharge.common.utils.a r13 = net.one97.paytm.recharge.common.utils.a.f61493a     // Catch:{ Exception -> 0x0100 }
                java.lang.String r1 = ""
                T r13 = r8.element     // Catch:{ Exception -> 0x0100 }
                r2 = r13
                net.one97.paytm.common.entity.CJRRechargeCart r2 = (net.one97.paytm.common.entity.CJRRechargeCart) r2     // Catch:{ Exception -> 0x0100 }
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                boolean r7 = r10.element     // Catch:{ Exception -> 0x0100 }
                r0 = r12
                net.one97.paytm.recharge.common.utils.a.a(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0100 }
                return
            L_0x00cd:
                r13 = r12
                android.content.Context r13 = (android.content.Context) r13     // Catch:{ Exception -> 0x0100 }
                net.one97.paytm.recharge.c$a$c r0 = new net.one97.paytm.recharge.c$a$c     // Catch:{ Exception -> 0x0100 }
                r6 = r0
                r7 = r12
                r9 = r5
                r11 = r14
                r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0100 }
                net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener r0 = (net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener) r0     // Catch:{ Exception -> 0x0100 }
                net.one97.paytm.utils.t.a((android.content.Context) r13, (net.one97.paytm.common.entity.recharge.CJRRechargePayment) r5, (net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener) r0)     // Catch:{ Exception -> 0x0100 }
                return
            L_0x00df:
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r12 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE     // Catch:{ Exception -> 0x0100 }
                java.lang.String r13 = "verify response is required for "
                java.lang.String r0 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x0100 }
                java.lang.String r13 = r13.concat(r0)     // Catch:{ Exception -> 0x0100 }
                r12.debugLog(r13)     // Catch:{ Exception -> 0x0100 }
                return
            L_0x00f0:
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r12 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE     // Catch:{ Exception -> 0x0100 }
                java.lang.String r13 = "checkout response is required for "
                java.lang.String r0 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x0100 }
                java.lang.String r13 = r13.concat(r0)     // Catch:{ Exception -> 0x0100 }
                r12.debugLog(r13)     // Catch:{ Exception -> 0x0100 }
                return
            L_0x0100:
                r12 = move-exception
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r13 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "Unable to get "
                r0.<init>(r1)
                r0.append(r14)
                java.lang.String r14 = " payment options"
                r0.append(r14)
                java.lang.String r14 = r0.toString()
                r13.debugLog(r14)
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r13 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
                java.lang.Throwable r12 = (java.lang.Throwable) r12
                r13.debugLogExceptions(r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.c.a.a(android.app.Activity, android.os.Bundle, java.lang.String):void");
        }

        /* renamed from: net.one97.paytm.recharge.c$a$c  reason: collision with other inner class name */
        public static final class C1167c implements FetchPayOptionsListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Activity f60422a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ x.e f60423b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ CJRRechargePayment f60424c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ x.a f60425d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f60426e;

            public final void onPaymentOptionsError() {
            }

            public final void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
            }

            public final void onRequestStart() {
            }

            public final void onVpaReceived(VpaFetch vpaFetch) {
            }

            C1167c(Activity activity, x.e eVar, CJRRechargePayment cJRRechargePayment, x.a aVar, String str) {
                this.f60422a = activity;
                this.f60423b = eVar;
                this.f60424c = cJRRechargePayment;
                this.f60425d = aVar;
                this.f60426e = str;
            }

            public final void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
                PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
                try {
                    net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
                    net.one97.paytm.recharge.common.utils.a.a(this.f60422a, "", (CJRRechargeCart) this.f60423b.element, this.f60424c, (Map<String, ? extends Object>) null, (Class<?>) null, (Object) null, this.f60425d.element);
                } catch (Exception e2) {
                    CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                    cJRRechargeUtilities.debugLog("Unable to navigate Payment Gateway for " + this.f60426e);
                    CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
                }
            }
        }

        public static void b(Activity activity, Bundle bundle, String str) {
            k.c(activity, "activity");
            k.c(bundle, "bundle");
            k.c(str, "targetKey");
            try {
                x.a aVar = new x.a();
                aVar.element = false;
                x.e eVar = new x.e();
                eVar.element = "";
                x.e eVar2 = new x.e();
                eVar2.element = "";
                x.e eVar3 = new x.e();
                eVar3.element = "";
                x.e eVar4 = new x.e();
                eVar4.element = "";
                x.e eVar5 = new x.e();
                eVar5.element = "";
                x.e eVar6 = new x.e();
                eVar6.element = "";
                y.a(new C1165a(bundle, str)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new b(aVar, bundle, eVar, eVar2, eVar3, eVar4, eVar5, eVar6, activity));
            } catch (Exception e2) {
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                cJRRechargeUtilities.debugLog("Unable to get " + str + " payment options");
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
            }
        }

        /* renamed from: net.one97.paytm.recharge.c$a$a  reason: collision with other inner class name */
        static final class C1165a<T> implements ab<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Bundle f60411a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f60412b;

            C1165a(Bundle bundle, String str) {
                this.f60411a = bundle;
                this.f60412b = str;
            }

            public final void subscribe(z<CJRRechargeCart> zVar) {
                k.a((Object) zVar, "emitter");
                if (!zVar.isDisposed()) {
                    CJRRechargeCart cJRRechargeCart = null;
                    Bundle bundle = this.f60411a;
                    a aVar = c.f60405a;
                    if (bundle.containsKey(c.f60406d)) {
                        try {
                            f fVar = new f();
                            Bundle bundle2 = this.f60411a;
                            a aVar2 = c.f60405a;
                            Object obj = bundle2.get(c.f60406d);
                            if (obj == null) {
                                k.a();
                            }
                            cJRRechargeCart = (CJRRechargeCart) fVar.a(obj.toString(), CJRRechargeCart.class);
                        } catch (Exception unused) {
                        }
                    } else {
                        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                        cJRRechargeUtilities.debugLog("verify response is required for " + this.f60412b);
                    }
                    if (cJRRechargeCart != null && cJRRechargeCart.getCart() == null) {
                        f fVar2 = new f();
                        Bundle bundle3 = this.f60411a;
                        a aVar3 = c.f60405a;
                        Object obj2 = bundle3.get(c.f60406d);
                        if (obj2 == null) {
                            k.a();
                        }
                        cJRRechargeCart.setmCart((CJRCart) fVar2.a(obj2.toString(), CJRCart.class));
                    }
                    if (cJRRechargeCart != null && cJRRechargeCart.getCart() != null) {
                        zVar.onSuccess(cJRRechargeCart);
                    }
                }
            }
        }

        public static final class b implements aa<CJRRechargeCart> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ x.a f60413a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Bundle f60414b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ x.e f60415c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ x.e f60416d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ x.e f60417e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ x.e f60418f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ x.e f60419g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ x.e f60420h;

            /* renamed from: i  reason: collision with root package name */
            final /* synthetic */ Activity f60421i;

            public final void onError(Throwable th) {
                k.c(th, "e");
            }

            public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
                k.c(cVar, "d");
            }

            b(x.a aVar, Bundle bundle, x.e eVar, x.e eVar2, x.e eVar3, x.e eVar4, x.e eVar5, x.e eVar6, Activity activity) {
                this.f60413a = aVar;
                this.f60414b = bundle;
                this.f60415c = eVar;
                this.f60416d = eVar2;
                this.f60417e = eVar3;
                this.f60418f = eVar4;
                this.f60419g = eVar5;
                this.f60420h = eVar6;
                this.f60421i = activity;
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                T t;
                CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) obj;
                k.c(cJRRechargeCart, "t");
                this.f60413a.element = this.f60414b.getBoolean("isDealsFastForward", false);
                this.f60415c.element = this.f60414b.getString("protectionUrl", "");
                this.f60416d.element = this.f60414b.getString("categoryName", "");
                this.f60417e.element = this.f60414b.getString("serviceType", "");
                this.f60418f.element = this.f60414b.getString(Utility.EVENT_CATEGORY_PROMOCODE, "");
                x.e eVar = this.f60419g;
                Object obj2 = this.f60414b.get("categoryId");
                if (obj2 == null || (t = obj2.toString()) == null) {
                    t = "";
                }
                eVar.element = t;
                this.f60420h.element = this.f60414b.getString("gaKey", "");
                net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
                Activity activity = this.f60421i;
                String str = (String) this.f60416d.element;
                if (str == null) {
                    str = "";
                }
                Boolean valueOf = Boolean.valueOf(this.f60413a.element);
                String str2 = (String) this.f60415c.element;
                String str3 = (String) this.f60416d.element;
                String str4 = (String) this.f60417e.element;
                if (str4 == null) {
                    str4 = (String) this.f60420h.element;
                }
                if (str4 == null) {
                    str4 = "";
                }
                net.one97.paytm.recharge.common.utils.a.a(activity, str, cJRRechargeCart, (Class) null, valueOf, str2, str3, str4, (String) null, (String) null, (String) this.f60418f.element, (String) this.f60419g.element, (Boolean) null, (Boolean) null, 54856);
            }
        }
    }

    public final void provideValuesForKeys(String str, c.C0910c cVar) {
        k.c(str, "key");
        switch (str.hashCode()) {
            case -1638015529:
                if (str.equals("emailId")) {
                    if (cVar != null) {
                        cVar.onResult(com.paytm.utility.a.c(this.f60407b));
                        return;
                    }
                    return;
                }
                break;
            case -1581184615:
                if (str.equals("customerId")) {
                    if (cVar != null) {
                        cVar.onResult(com.paytm.utility.a.a(this.f60407b));
                        return;
                    }
                    return;
                }
                break;
            case -1459599807:
                if (str.equals("lastName")) {
                    if (cVar != null) {
                        cVar.onResult(b.i(this.f60407b));
                        return;
                    }
                    return;
                }
                break;
            case -1192969641:
                if (str.equals("phoneNumber")) {
                    if (cVar != null) {
                        cVar.onResult(com.paytm.utility.a.b(this.f60407b));
                        return;
                    }
                    return;
                }
                break;
            case -1043086647:
                if (str.equals("checkoutUrlWithSignature")) {
                    if (cVar != null) {
                        cVar.onResult(a("reactCartCheckout", this.f60407b, false));
                        return;
                    }
                    return;
                }
                break;
            case -811857536:
                if (str.equals("walletToken")) {
                    if (cVar != null) {
                        cVar.onResult(t.c(this.f60407b));
                        return;
                    }
                    return;
                }
                break;
            case -85904877:
                if (str.equals("environment")) {
                    if (cVar != null) {
                        cVar.onResult("release");
                        return;
                    }
                    return;
                }
                break;
            case 132835675:
                if (str.equals("firstName")) {
                    if (cVar != null) {
                        cVar.onResult(b.h(this.f60407b));
                        return;
                    }
                    return;
                }
                break;
            case 695062194:
                if (str.equals("fastForwardCheckoutUrlWithSignature")) {
                    if (cVar != null) {
                        cVar.onResult(a("reactCartCheckout", this.f60407b, true));
                        return;
                    }
                    return;
                }
                break;
            case 802258218:
                if (str.equals("ssoToken")) {
                    if (cVar != null) {
                        cVar.onResult(t.b(this.f60407b));
                        return;
                    }
                    return;
                }
                break;
            case 870336295:
                if (str.equals("defaultParams")) {
                    if (cVar != null) {
                        cVar.onResult(a.a(this.f60407b));
                        return;
                    }
                    return;
                }
                break;
            case 1326405379:
                if (str.equals("fixVersion")) {
                    if (cVar != null) {
                        String str2 = this.f60408c;
                        int hashCode = str2.hashCode();
                        String str3 = "v1.0";
                        if (hashCode == 1223027634 ? !str2.equals("Donation") : hashCode != 2097162658 || !str2.equals("Fastag")) {
                            str3 = "";
                        }
                        cVar.onResult(str3);
                        return;
                    }
                    return;
                }
                break;
        }
        if (cVar != null) {
            cVar.onResult("");
        }
    }

    private static String a(String str, Context context, boolean z) {
        String str2;
        k.c(str, "appManagerKey");
        k.c(context, "context");
        String str3 = p.a("release", SDKConstants.KEY_STAGING_API, true) ? "https://staging.paytm.com/api/v1/expresscart/checkout" : "https://paytm.com/api/v1/expresscart/checkout";
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a(str, str3);
        if (TextUtils.isEmpty(a2)) {
            a2 = str3;
        }
        if (URLUtil.isValidUrl(a2)) {
            String c2 = com.paytm.utility.a.c(context, a2);
            String k = b.k();
            Uri parse = Uri.parse(c2);
            k.a((Object) parse, "Uri.parse(url)");
            if (parse.getQuery() != null) {
                str2 = c2 + "&client_id=" + k;
            } else {
                str2 = c2 + "?client_id=" + k;
            }
            if (z) {
                str2 = str2 + "&withdraw=1";
            }
            a2 = net.one97.paytm.recharge.common.utils.ab.b(b.d(str2, "POST"));
        }
        return a2 == null ? "" : a2;
    }
}
