package net.one97.paytm.recharge.ordersummary.h;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.di.helper.b;
import net.one97.paytm.recharge.ordersummary.f.m;

public final class d implements m {

    /* renamed from: c  reason: collision with root package name */
    public static final a f64339c = new a((byte) 0);

    /* renamed from: g  reason: collision with root package name */
    private static final String f64340g = f64340g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final String f64341h = f64341h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String f64342i = f64342i;
    /* access modifiers changed from: private */
    public static final String j = j;
    /* access modifiers changed from: private */
    public static final String k = k;
    /* access modifiers changed from: private */
    public static final String l = l;
    /* access modifiers changed from: private */
    public static final String m = m;
    /* access modifiers changed from: private */
    public static final String n = n;
    /* access modifiers changed from: private */
    public static final String o = o;
    /* access modifiers changed from: private */
    public static final String p = p;
    /* access modifiers changed from: private */
    public static final String q = q;
    /* access modifiers changed from: private */
    public static final String r = r;
    /* access modifiers changed from: private */
    public static final String s = s;
    /* access modifiers changed from: private */
    public static final String t = t;

    /* renamed from: a  reason: collision with root package name */
    public CJRItem f64343a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f64344b;

    /* renamed from: d  reason: collision with root package name */
    private String f64345d;

    /* renamed from: e  reason: collision with root package name */
    private String f64346e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f64347f = true;

    public d(Context context) {
        k.c(context, "context");
        this.f64344b = context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final String r() {
        String str = this.f64345d;
        return str == null ? "" : str;
    }

    public final void b(String str) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        String replace = new l("\\s+").replace((CharSequence) p.b(str).toString(), "_");
        if (replace != null) {
            String lowerCase = replace.toLowerCase();
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            this.f64345d = lowerCase;
            return;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final String a() {
        String str;
        CJRItem cJRItem = this.f64343a;
        if (cJRItem == null || (str = cJRItem.getName()) == null) {
            str = this.f64346e;
        }
        return str == null ? "" : str;
    }

    public final void a(String str) {
        k.c(str, "categoryName");
        String replace = new l("\\s+").replace((CharSequence) p.b(str).toString(), "_");
        if (replace != null) {
            String lowerCase = replace.toLowerCase();
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            this.f64346e = lowerCase;
            return;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final String a(String str, String str2) {
        StringBuilder sb = new StringBuilder("/" + f64340g);
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            StringBuilder sb2 = new StringBuilder("/");
            if (str == null) {
                k.a();
            }
            if (str != null) {
                String replace = new l("\\s+").replace((CharSequence) p.b(charSequence).toString(), "_");
                if (replace != null) {
                    String lowerCase = replace.toLowerCase();
                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    sb2.append(lowerCase);
                    sb.append(sb2.toString());
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        CharSequence charSequence2 = str2;
        if (!TextUtils.isEmpty(charSequence2)) {
            StringBuilder sb3 = new StringBuilder("/");
            if (str2 == null) {
                k.a();
            }
            if (str2 != null) {
                String replace2 = new l("\\s+").replace((CharSequence) p.b(charSequence2).toString(), "_");
                if (replace2 != null) {
                    String lowerCase2 = replace2.toLowerCase();
                    k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                    sb3.append(lowerCase2);
                    sb.append(sb3.toString());
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        String sb4 = sb.toString();
        k.a((Object) sb4, "builder.toString()");
        return sb4;
    }

    public final String b(String str, String str2) {
        StringBuilder sb = new StringBuilder(f64340g);
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            StringBuilder sb2 = new StringBuilder("_");
            if (str == null) {
                k.a();
            }
            if (str != null) {
                String replace = new l("\\s+").replace((CharSequence) p.b(charSequence).toString(), "_");
                if (replace != null) {
                    String lowerCase = replace.toLowerCase();
                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    sb2.append(lowerCase);
                    sb.append(sb2.toString());
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        CharSequence charSequence2 = str2;
        if (!TextUtils.isEmpty(charSequence2)) {
            StringBuilder sb3 = new StringBuilder("_");
            if (str2 == null) {
                k.a();
            }
            if (str2 != null) {
                String replace2 = new l("\\s+").replace((CharSequence) p.b(charSequence2).toString(), "_");
                if (replace2 != null) {
                    String lowerCase2 = replace2.toLowerCase();
                    k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                    sb3.append(lowerCase2);
                    sb.append(sb3.toString());
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        String sb4 = sb.toString();
        k.a((Object) sb4, "builder.toString()");
        return sb4;
    }

    public final void b(boolean z) {
        this.f64347f = z;
    }

    public final void a(Context context, String str) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        if (this.f64347f) {
            try {
                b bVar = b.f62652a;
                b.a(context, str);
            } catch (Throwable unused) {
            }
        }
    }

    public final Map<String, Object> a(String str, String str2, String str3, String str4, boolean z) {
        String str5;
        k.c(str, "inputFieldValues");
        k.c(str2, "groupFieldValues");
        k.c(str3, "amount");
        k.c(str4, "serviceType");
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("recharge_utilities_input_field_values", str);
        hashMap.put("recharge_utilities_group_field_values", str2);
        hashMap.put("recharge_utilities_amount", str3);
        hashMap.put("recharge_utilities_service_type", str4);
        CJRItem cJRItem = this.f64343a;
        if (cJRItem == null || (str5 = cJRItem.getName()) == null) {
            str5 = "";
        }
        hashMap.put("recharge_utilities_business_sub_vertical", str5);
        if (z) {
            hashMap.put("recharge_utilities_ff_state", "checked");
        } else {
            hashMap.put("recharge_utilities_ff_state", "unchecked");
        }
        return hashMap;
    }

    public static /* synthetic */ void a(d dVar, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, int i2) {
        dVar.a(obj, obj2, (i2 & 4) != 0 ? "" : obj3, (i2 & 8) != 0 ? "" : obj4, (i2 & 16) != 0 ? "recharges_utilities" : obj5, (i2 & 32) != 0 ? "" : obj6, (i2 & 64) != 0 ? "" : obj7);
    }

    public final void a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        k.c(obj, "eventCategory");
        k.c(obj2, "eventAction");
        k.c(obj3, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(obj4, "label");
        k.c(obj5, "vertical");
        k.c(obj6, "label2");
        k.c(obj7, "label3");
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", obj);
            hashMap.put("event_action", obj2);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, obj3);
            hashMap.put("event_label", obj4);
            if ((obj6 instanceof String) && !TextUtils.isEmpty((CharSequence) obj6)) {
                hashMap.put("event_label2", obj6);
            }
            if ((obj7 instanceof String) && !TextUtils.isEmpty((CharSequence) obj7)) {
                hashMap.put("event_label3", obj7);
            }
            hashMap.put("user_id", com.paytm.utility.b.n(this.f64344b) != null ? com.paytm.utility.b.n(this.f64344b) : "");
            hashMap.put("vertical_name", obj5);
            b bVar = b.f62652a;
            b.a((HashMap<String, Object>) hashMap, this.f64344b);
        } catch (Throwable unused) {
        }
    }

    public final void c(String str, String str2) {
        if (this.f64347f) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("event_category", this.f64346e);
                hashMap.put("event_action", str);
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, this.f64345d);
                hashMap.put("event_label", str2);
                hashMap.put("user_id", com.paytm.utility.b.n(this.f64344b) != null ? com.paytm.utility.b.n(this.f64344b) : "");
                hashMap.put("vertical_name", "recharges_utilities");
                b bVar = b.f62652a;
                b.a((HashMap<String, Object>) hashMap, this.f64344b);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x013b A[Catch:{ all -> 0x0170 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0148 A[Catch:{ all -> 0x0170 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0166 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(net.one97.paytm.common.entity.shopping.CJROrderSummary r21) {
        /*
            r20 = this;
            r0 = r20
            boolean r1 = r0.f64347f
            if (r1 == 0) goto L_0x0170
            if (r21 == 0) goto L_0x0170
            java.lang.String r10 = "af_purchase"
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ all -> 0x0170 }
            r11.<init>()     // Catch:{ all -> 0x0170 }
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ all -> 0x0170 }
            r12.<init>()     // Catch:{ all -> 0x0170 }
            java.util.ArrayList r1 = r21.getOrderedCartList()     // Catch:{ all -> 0x0170 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0170 }
        L_0x001c:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0170 }
            if (r2 == 0) goto L_0x007c
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0170 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r2     // Catch:{ all -> 0x0170 }
            java.lang.String r3 = "cart"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0170 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r3 = r2.getProductDetail()     // Catch:{ all -> 0x0170 }
            if (r3 == 0) goto L_0x001c
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r3 = r2.getProductDetail()     // Catch:{ all -> 0x0170 }
            java.lang.String r4 = "product"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0170 }
            long r4 = r3.getId()     // Catch:{ all -> 0x0170 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0170 }
            double r5 = r2.getDiscountedPrice()     // Catch:{ all -> 0x0170 }
            r3.setDiscountedPrice(r5)     // Catch:{ all -> 0x0170 }
            java.lang.Object r5 = r11.get(r4)     // Catch:{ all -> 0x0170 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x0170 }
            if (r5 != 0) goto L_0x005e
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0170 }
            r5.<init>()     // Catch:{ all -> 0x0170 }
            r6 = r11
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ all -> 0x0170 }
            r6.put(r4, r5)     // Catch:{ all -> 0x0170 }
        L_0x005e:
            r5.add(r3)     // Catch:{ all -> 0x0170 }
            r3 = r12
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            r5.<init>()     // Catch:{ all -> 0x0170 }
            long r6 = r2.getMerchantId()     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0170 }
            r5.append(r2)     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x0170 }
            r3.put(r4, r2)     // Catch:{ all -> 0x0170 }
            goto L_0x001c
        L_0x007c:
            java.lang.String r13 = r21.getId()     // Catch:{ all -> 0x0170 }
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0170 }
            r14.<init>()     // Catch:{ all -> 0x0170 }
            java.util.Set r1 = r11.keySet()     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = "productMap.keys"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0170 }
            java.util.Iterator r15 = r1.iterator()     // Catch:{ all -> 0x0170 }
            java.lang.String r1 = ""
            r2 = r1
            r3 = r2
            r4 = r3
        L_0x0097:
            boolean r5 = r15.hasNext()     // Catch:{ all -> 0x0170 }
            if (r5 == 0) goto L_0x0170
            java.lang.Object r5 = r15.next()     // Catch:{ all -> 0x0170 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0170 }
            java.lang.Object r6 = r11.get(r5)     // Catch:{ all -> 0x0170 }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x0170 }
            if (r6 == 0) goto L_0x0131
            int r7 = r6.size()     // Catch:{ all -> 0x0170 }
            if (r7 <= 0) goto L_0x0131
            r7 = 0
            java.lang.Object r7 = r6.get(r7)     // Catch:{ all -> 0x0170 }
            java.lang.String r8 = "products[0]"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)     // Catch:{ all -> 0x0170 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r7 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail) r7     // Catch:{ all -> 0x0170 }
            if (r7 == 0) goto L_0x0131
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            r1.<init>()     // Catch:{ all -> 0x0170 }
            int r2 = r6.size()     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0170 }
            r1.append(r2)     // Catch:{ all -> 0x0170 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            r2.<init>()     // Catch:{ all -> 0x0170 }
            long r3 = r7.getId()     // Catch:{ all -> 0x0170 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0170 }
            r2.append(r3)     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0170 }
            java.lang.String r3 = r7.getName()     // Catch:{ all -> 0x0170 }
            java.lang.String r4 = "prod.name"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0170 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0170 }
            r4.<init>()     // Catch:{ all -> 0x0170 }
            double r8 = r7.getDiscountedPrice()     // Catch:{ all -> 0x0170 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0170 }
            r4.append(r8)     // Catch:{ all -> 0x0170 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0170 }
            r14.clear()     // Catch:{ all -> 0x0170 }
            java.util.ArrayList r7 = r7.getCategoryMap()     // Catch:{ all -> 0x0170 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0170 }
        L_0x010f:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x0170 }
            if (r8 == 0) goto L_0x0128
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x0170 }
            net.one97.paytm.common.entity.shopping.CJRCategoryMap r8 = (net.one97.paytm.common.entity.shopping.CJRCategoryMap) r8     // Catch:{ all -> 0x0170 }
            java.lang.String r9 = "cm"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ all -> 0x0170 }
            java.lang.String r8 = r8.getCategoryId()     // Catch:{ all -> 0x0170 }
            r14.add(r8)     // Catch:{ all -> 0x0170 }
            goto L_0x010f
        L_0x0128:
            r18 = r1
            r17 = r2
            r19 = r3
            r16 = r4
            goto L_0x0139
        L_0x0131:
            r18 = r1
            r16 = r2
            r17 = r3
            r19 = r4
        L_0x0139:
            if (r6 != 0) goto L_0x013e
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0170 }
        L_0x013e:
            java.util.Iterator r1 = r6.iterator()     // Catch:{ all -> 0x0170 }
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0170 }
            if (r2 == 0) goto L_0x0166
            r1.next()     // Catch:{ all -> 0x0170 }
            net.one97.paytm.recharge.di.helper.b r1 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x0170 }
            java.lang.String r2 = r21.getAggregateItemPrice()     // Catch:{ all -> 0x0170 }
            java.lang.Object r1 = r12.get(r5)     // Catch:{ all -> 0x0170 }
            r9 = r1
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0170 }
            r1 = r10
            r3 = r16
            r4 = r17
            r5 = r13
            r6 = r14
            r7 = r18
            r8 = r19
            net.one97.paytm.recharge.di.helper.b.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0170 }
        L_0x0166:
            r2 = r16
            r3 = r17
            r1 = r18
            r4 = r19
            goto L_0x0097
        L_0x0170:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.h.d.b(net.one97.paytm.common.entity.shopping.CJROrderSummary):void");
    }
}
