package net.one97.paytm.recharge.common.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f61722a = new q();

    static final class a<T> implements Comparator<CJRFrequentOrder> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f61723a = new a();

        a() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return a((CJRFrequentOrder) obj, (CJRFrequentOrder) obj2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x00fc A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00fd A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0102 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0103  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int a(net.one97.paytm.common.entity.recharge.CJRFrequentOrder r11, net.one97.paytm.common.entity.recharge.CJRFrequentOrder r12) {
            /*
                java.lang.String r0 = "o2.cjrBillDetails"
                java.lang.String r1 = "o1.cjrBillDetails"
                r2 = 0
                r4 = 0
                java.lang.String r5 = "o1"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)     // Catch:{ Exception -> 0x00d2 }
                net.one97.paytm.common.entity.recharge.CJRBillDetails r5 = r11.getCjrBillDetails()     // Catch:{ Exception -> 0x00d2 }
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)     // Catch:{ Exception -> 0x00d2 }
                java.lang.String r5 = r5.getExpiry()     // Catch:{ Exception -> 0x00d2 }
                java.lang.String r6 = "SimpleDateFormat(CJRRech…BillDetails()[0].dueDate)"
                java.lang.String r7 = "yyyy-MM-dd"
                if (r5 == 0) goto L_0x003c
                java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x00d2 }
                r5.<init>(r7)     // Catch:{ Exception -> 0x00d2 }
                net.one97.paytm.common.entity.recharge.CJRBillDetails r11 = r11.getCjrBillDetails()     // Catch:{ Exception -> 0x00d2 }
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)     // Catch:{ Exception -> 0x00d2 }
                java.lang.String r11 = r11.getExpiry()     // Catch:{ Exception -> 0x00d2 }
                java.util.Date r11 = r5.parse(r11)     // Catch:{ Exception -> 0x00d2 }
                java.lang.String r1 = "SimpleDateFormat(CJRRech…o1.cjrBillDetails.expiry)"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)     // Catch:{ Exception -> 0x00d2 }
                long r8 = r11.getTime()     // Catch:{ Exception -> 0x00d2 }
                goto L_0x006e
            L_0x003c:
                net.one97.paytm.common.entity.recharge.CJRBillDetails r5 = r11.getCjrBillDetails()     // Catch:{ Exception -> 0x00d2 }
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)     // Catch:{ Exception -> 0x00d2 }
                java.lang.String r1 = r5.getDueDate()     // Catch:{ Exception -> 0x00d2 }
                if (r1 == 0) goto L_0x006d
                java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x00d2 }
                r1.<init>(r7)     // Catch:{ Exception -> 0x00d2 }
                java.util.List r11 = r11.getmBillDetails()     // Catch:{ Exception -> 0x00d2 }
                java.lang.Object r11 = r11.get(r4)     // Catch:{ Exception -> 0x00d2 }
                java.lang.String r5 = "o1.getmBillDetails()[0]"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)     // Catch:{ Exception -> 0x00d2 }
                net.one97.paytm.common.entity.recharge.CJRBillDetails r11 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r11     // Catch:{ Exception -> 0x00d2 }
                java.lang.String r11 = r11.getDueDate()     // Catch:{ Exception -> 0x00d2 }
                java.util.Date r11 = r1.parse(r11)     // Catch:{ Exception -> 0x00d2 }
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r6)     // Catch:{ Exception -> 0x00d2 }
                long r8 = r11.getTime()     // Catch:{ Exception -> 0x00d2 }
                goto L_0x006e
            L_0x006d:
                r8 = r2
            L_0x006e:
                java.lang.String r11 = "o2"
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r11)     // Catch:{ Exception -> 0x00d0 }
                net.one97.paytm.common.entity.recharge.CJRBillDetails r11 = r12.getCjrBillDetails()     // Catch:{ Exception -> 0x00d0 }
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)     // Catch:{ Exception -> 0x00d0 }
                java.lang.String r11 = r11.getExpiry()     // Catch:{ Exception -> 0x00d0 }
                if (r11 == 0) goto L_0x009e
                java.text.SimpleDateFormat r11 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x00d0 }
                r11.<init>(r7)     // Catch:{ Exception -> 0x00d0 }
                net.one97.paytm.common.entity.recharge.CJRBillDetails r12 = r12.getCjrBillDetails()     // Catch:{ Exception -> 0x00d0 }
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)     // Catch:{ Exception -> 0x00d0 }
                java.lang.String r12 = r12.getExpiry()     // Catch:{ Exception -> 0x00d0 }
                java.util.Date r11 = r11.parse(r12)     // Catch:{ Exception -> 0x00d0 }
                java.lang.String r12 = "SimpleDateFormat(CJRRech…o2.cjrBillDetails.expiry)"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x00d0 }
                long r2 = r11.getTime()     // Catch:{ Exception -> 0x00d0 }
                goto L_0x00db
            L_0x009e:
                net.one97.paytm.common.entity.recharge.CJRBillDetails r11 = r12.getCjrBillDetails()     // Catch:{ Exception -> 0x00d0 }
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)     // Catch:{ Exception -> 0x00d0 }
                java.lang.String r11 = r11.getDueDate()     // Catch:{ Exception -> 0x00d0 }
                if (r11 == 0) goto L_0x00db
                java.text.SimpleDateFormat r11 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x00d0 }
                r11.<init>(r7)     // Catch:{ Exception -> 0x00d0 }
                java.util.List r12 = r12.getmBillDetails()     // Catch:{ Exception -> 0x00d0 }
                java.lang.Object r12 = r12.get(r4)     // Catch:{ Exception -> 0x00d0 }
                java.lang.String r0 = "o2.getmBillDetails()[0]"
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)     // Catch:{ Exception -> 0x00d0 }
                net.one97.paytm.common.entity.recharge.CJRBillDetails r12 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r12     // Catch:{ Exception -> 0x00d0 }
                java.lang.String r12 = r12.getDueDate()     // Catch:{ Exception -> 0x00d0 }
                java.util.Date r11 = r11.parse(r12)     // Catch:{ Exception -> 0x00d0 }
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r6)     // Catch:{ Exception -> 0x00d0 }
                long r11 = r11.getTime()     // Catch:{ Exception -> 0x00d0 }
                r2 = r11
                goto L_0x00db
            L_0x00d0:
                r11 = move-exception
                goto L_0x00d4
            L_0x00d2:
                r11 = move-exception
                r8 = r2
            L_0x00d4:
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r12 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
                java.lang.Throwable r11 = (java.lang.Throwable) r11
                r12.debugLogExceptions(r11)
            L_0x00db:
                java.util.Date r11 = new java.util.Date
                r11.<init>()
                long r11 = r11.getTime()
                r0 = 1
                r1 = -1
                int r5 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
                if (r5 > 0) goto L_0x00ee
                int r6 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
                if (r6 > 0) goto L_0x00f8
            L_0x00ee:
                r6 = 1
                long r6 = r6 + r8
                int r10 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r10 <= 0) goto L_0x00f6
                goto L_0x00fe
            L_0x00f6:
                if (r5 <= 0) goto L_0x00fe
            L_0x00f8:
                int r11 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r11 >= 0) goto L_0x00fd
                return r0
            L_0x00fd:
                return r1
            L_0x00fe:
                int r11 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r11 != 0) goto L_0x0103
                return r4
            L_0x0103:
                if (r11 <= 0) goto L_0x0106
                return r0
            L_0x0106:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.q.a.a(net.one97.paytm.common.entity.recharge.CJRFrequentOrder, net.one97.paytm.common.entity.recharge.CJRFrequentOrder):int");
        }
    }

    static final class b<T> implements Comparator<CJRFrequentOrder> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f61724a = new b();

        b() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return a((CJRFrequentOrder) obj, (CJRFrequentOrder) obj2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x00ed A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00ee  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int a(net.one97.paytm.common.entity.recharge.CJRFrequentOrder r11, net.one97.paytm.common.entity.recharge.CJRFrequentOrder r12) {
            /*
                java.lang.String r0 = "o2"
                java.lang.String r1 = "o1.cjrBillDetails"
                java.lang.String r2 = "o2.cjrBillDetails"
                r3 = 0
                r5 = 0
                java.lang.String r6 = "o1"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r6)     // Catch:{ Exception -> 0x00d1 }
                net.one97.paytm.common.entity.recharge.CJRBillDetails r6 = r11.getCjrBillDetails()     // Catch:{ Exception -> 0x00d1 }
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x00d1 }
                java.lang.String r6 = r6.getExpiry()     // Catch:{ Exception -> 0x00d1 }
                java.lang.String r7 = "SimpleDateFormat(CJRRech…BillDetails()[0].dueDate)"
                java.lang.String r8 = "yyyy-MM-dd"
                if (r6 == 0) goto L_0x003e
                java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x00d1 }
                r6.<init>(r8)     // Catch:{ Exception -> 0x00d1 }
                net.one97.paytm.common.entity.recharge.CJRBillDetails r11 = r11.getCjrBillDetails()     // Catch:{ Exception -> 0x00d1 }
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)     // Catch:{ Exception -> 0x00d1 }
                java.lang.String r11 = r11.getExpiry()     // Catch:{ Exception -> 0x00d1 }
                java.util.Date r11 = r6.parse(r11)     // Catch:{ Exception -> 0x00d1 }
                java.lang.String r1 = "SimpleDateFormat(CJRRech…o1.cjrBillDetails.expiry)"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)     // Catch:{ Exception -> 0x00d1 }
                long r9 = r11.getTime()     // Catch:{ Exception -> 0x00d1 }
                goto L_0x0070
            L_0x003e:
                net.one97.paytm.common.entity.recharge.CJRBillDetails r6 = r11.getCjrBillDetails()     // Catch:{ Exception -> 0x00d1 }
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x00d1 }
                java.lang.String r1 = r6.getDueDate()     // Catch:{ Exception -> 0x00d1 }
                if (r1 == 0) goto L_0x006f
                java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x00d1 }
                r1.<init>(r8)     // Catch:{ Exception -> 0x00d1 }
                java.util.List r11 = r11.getmBillDetails()     // Catch:{ Exception -> 0x00d1 }
                java.lang.Object r11 = r11.get(r5)     // Catch:{ Exception -> 0x00d1 }
                java.lang.String r6 = "o1.getmBillDetails()[0]"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r6)     // Catch:{ Exception -> 0x00d1 }
                net.one97.paytm.common.entity.recharge.CJRBillDetails r11 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r11     // Catch:{ Exception -> 0x00d1 }
                java.lang.String r11 = r11.getDueDate()     // Catch:{ Exception -> 0x00d1 }
                java.util.Date r11 = r1.parse(r11)     // Catch:{ Exception -> 0x00d1 }
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r7)     // Catch:{ Exception -> 0x00d1 }
                long r9 = r11.getTime()     // Catch:{ Exception -> 0x00d1 }
                goto L_0x0070
            L_0x006f:
                r9 = r3
            L_0x0070:
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)     // Catch:{ Exception -> 0x00cf }
                net.one97.paytm.common.entity.recharge.CJRBillDetails r11 = r12.getCjrBillDetails()     // Catch:{ Exception -> 0x00cf }
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r2)     // Catch:{ Exception -> 0x00cf }
                java.lang.String r11 = r11.getExpiry()     // Catch:{ Exception -> 0x00cf }
                if (r11 == 0) goto L_0x009e
                java.text.SimpleDateFormat r11 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x00cf }
                r11.<init>(r8)     // Catch:{ Exception -> 0x00cf }
                net.one97.paytm.common.entity.recharge.CJRBillDetails r1 = r12.getCjrBillDetails()     // Catch:{ Exception -> 0x00cf }
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x00cf }
                java.lang.String r1 = r1.getExpiry()     // Catch:{ Exception -> 0x00cf }
                java.util.Date r11 = r11.parse(r1)     // Catch:{ Exception -> 0x00cf }
                java.lang.String r1 = "SimpleDateFormat(CJRRech…o2.cjrBillDetails.expiry)"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)     // Catch:{ Exception -> 0x00cf }
                long r3 = r11.getTime()     // Catch:{ Exception -> 0x00cf }
                goto L_0x00da
            L_0x009e:
                net.one97.paytm.common.entity.recharge.CJRBillDetails r11 = r12.getCjrBillDetails()     // Catch:{ Exception -> 0x00cf }
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r2)     // Catch:{ Exception -> 0x00cf }
                java.lang.String r11 = r11.getDueDate()     // Catch:{ Exception -> 0x00cf }
                if (r11 == 0) goto L_0x00da
                java.text.SimpleDateFormat r11 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x00cf }
                r11.<init>(r8)     // Catch:{ Exception -> 0x00cf }
                java.util.List r1 = r12.getmBillDetails()     // Catch:{ Exception -> 0x00cf }
                java.lang.Object r1 = r1.get(r5)     // Catch:{ Exception -> 0x00cf }
                java.lang.String r6 = "o2.getmBillDetails()[0]"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)     // Catch:{ Exception -> 0x00cf }
                net.one97.paytm.common.entity.recharge.CJRBillDetails r1 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r1     // Catch:{ Exception -> 0x00cf }
                java.lang.String r1 = r1.getDueDate()     // Catch:{ Exception -> 0x00cf }
                java.util.Date r11 = r11.parse(r1)     // Catch:{ Exception -> 0x00cf }
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r7)     // Catch:{ Exception -> 0x00cf }
                long r3 = r11.getTime()     // Catch:{ Exception -> 0x00cf }
                goto L_0x00da
            L_0x00cf:
                r11 = move-exception
                goto L_0x00d3
            L_0x00d1:
                r11 = move-exception
                r9 = r3
            L_0x00d3:
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
                java.lang.Throwable r11 = (java.lang.Throwable) r11
                r1.debugLogExceptions(r11)
            L_0x00da:
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
                net.one97.paytm.common.entity.recharge.CJRBillDetails r11 = r12.getCjrBillDetails()
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r2)
                int r11 = r11.getDaysDiff()
                r12 = -1000(0xfffffffffffffc18, float:NaN)
                r0 = -1
                if (r11 != r12) goto L_0x00ee
                return r0
            L_0x00ee:
                int r11 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
                if (r11 != 0) goto L_0x00f3
                return r5
            L_0x00f3:
                if (r11 <= 0) goto L_0x00f7
                r11 = 1
                return r11
            L_0x00f7:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.q.b.a(net.one97.paytm.common.entity.recharge.CJRFrequentOrder, net.one97.paytm.common.entity.recharge.CJRFrequentOrder):int");
        }
    }

    private q() {
    }

    public static List<CJRFrequentOrder> a(CJRFrequentOrderList cJRFrequentOrderList, String str, String str2) {
        List<CJRFrequentOrder> list;
        if (cJRFrequentOrderList == null || TextUtils.isEmpty(str)) {
            return new ArrayList<>();
        }
        if (str == null) {
            k.a();
        }
        if (str != null) {
            String lowerCase = str.toLowerCase();
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            if (!p.a((CharSequence) lowerCase, (CharSequence) "loan", false)) {
                String lowerCase2 = str.toLowerCase();
                k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                if (!p.a((CharSequence) lowerCase2, (CharSequence) "insurance", false)) {
                    if (str2 == null || !p.a(str2, "Credit card", true)) {
                        list = a((List<? extends CJRFrequentOrder>) cJRFrequentOrderList.getOrderList(), str);
                        if (list == null) {
                            k.a();
                        }
                        return list;
                    }
                    List<CJRFrequentOrder> a2 = a((List<? extends CJRFrequentOrder>) cJRFrequentOrderList.getOrderList(), str, str2);
                    if (a2 == null) {
                        k.a();
                    }
                    Collection arrayList = new ArrayList();
                    for (Object next : a2) {
                        CharSequence cardId = ((CJRFrequentOrder) next).getCardId();
                        if (!(cardId == null || cardId.length() == 0)) {
                            arrayList.add(next);
                        }
                    }
                    return (List) arrayList;
                }
            }
            list = c(cJRFrequentOrderList.getOrderList(), str);
            if (list == null) {
                k.a();
            }
            return list;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    private static List<CJRFrequentOrder> c(List<? extends CJRFrequentOrder> list, String str) {
        if (TextUtils.isEmpty(str)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (CJRFrequentOrder cJRFrequentOrder : list) {
                CJRFrequentOrderProduct frequentOrderProduct = cJRFrequentOrder.getFrequentOrderProduct();
                String paytype = frequentOrderProduct != null ? frequentOrderProduct.getPaytype() : null;
                if (!TextUtils.isEmpty(paytype)) {
                    if (str == null) {
                        k.a();
                    }
                    if (str != null) {
                        String lowerCase = str.toLowerCase();
                        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                        CharSequence charSequence = lowerCase;
                        if (paytype == null) {
                            k.a();
                        }
                        if (paytype != null) {
                            String lowerCase2 = paytype.toLowerCase();
                            k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                            if (p.a(charSequence, (CharSequence) lowerCase2, false)) {
                                arrayList.add(cJRFrequentOrder);
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
        }
        if (arrayList.size() > 1) {
            kotlin.a.k.c(arrayList);
        }
        return arrayList;
    }

    private static List<CJRFrequentOrder> a(List<? extends CJRFrequentOrder> list, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (CJRFrequentOrder cJRFrequentOrder : list) {
                if (TextUtils.isEmpty(str2)) {
                    CJRFrequentOrderProduct frequentOrderProduct = cJRFrequentOrder.getFrequentOrderProduct();
                    k.a((Object) frequentOrderProduct, "order.frequentOrderProduct");
                    if (p.a(str, frequentOrderProduct.getService(), true)) {
                        arrayList.add(cJRFrequentOrder);
                    }
                } else if (p.a(str2, cJRFrequentOrder.getPayType(), true)) {
                    CJRFrequentOrderProduct frequentOrderProduct2 = cJRFrequentOrder.getFrequentOrderProduct();
                    if (p.a(str, frequentOrderProduct2 != null ? frequentOrderProduct2.getService() : null, true)) {
                        arrayList.add(cJRFrequentOrder);
                    }
                }
            }
        }
        if (arrayList.size() > 1) {
            kotlin.a.k.c(arrayList);
        }
        return arrayList;
    }

    public static List<CJRFrequentOrder> a(List<? extends CJRFrequentOrder> list, String str) {
        return a(list, str, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b5 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder> b(java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRFrequentOrder> r8, java.lang.String r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 1
            r3 = 0
            if (r8 == 0) goto L_0x00b8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
            r4 = 0
        L_0x0015:
            boolean r5 = r8.hasNext()
            if (r5 == 0) goto L_0x00b8
            java.lang.Object r5 = r8.next()
            int r6 = r4 + 1
            if (r4 >= 0) goto L_0x0026
            kotlin.a.k.a()
        L_0x0026:
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r5 = (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r5
            java.util.List r4 = r5.getmBillDetails()
            if (r4 == 0) goto L_0x0033
            int r7 = r4.size()
            goto L_0x0034
        L_0x0033:
            r7 = 0
        L_0x0034:
            if (r7 <= 0) goto L_0x00b2
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r7 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            android.content.Context r7 = r7.getApplicationContext()
            boolean r7 = net.one97.paytm.recharge.common.utils.az.b((android.content.Context) r7)
            if (r7 == 0) goto L_0x005d
            java.lang.String r7 = "Mobile"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r9, (boolean) r2)
            if (r7 != 0) goto L_0x0052
            java.lang.String r7 = "datacard"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r9, (boolean) r2)
            if (r7 == 0) goto L_0x005d
        L_0x0052:
            java.lang.Object r4 = r4.get(r3)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r4 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r4
            net.one97.paytm.common.entity.recharge.CJRBillDetails r4 = net.one97.paytm.recharge.common.utils.ba.a((net.one97.paytm.common.entity.recharge.CJRBillDetails) r4)
            goto L_0x008c
        L_0x005d:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r7 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            android.content.Context r7 = r7.getApplicationContext()
            boolean r7 = net.one97.paytm.recharge.common.utils.az.d(r7)
            if (r7 == 0) goto L_0x007c
            java.lang.String r7 = "Financial Services"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r9, (boolean) r2)
            if (r7 == 0) goto L_0x007c
            java.lang.Object r4 = r4.get(r3)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r4 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r4
            net.one97.paytm.common.entity.recharge.CJRBillDetails r4 = net.one97.paytm.recharge.common.utils.ba.b((net.one97.paytm.common.entity.recharge.CJRBillDetails) r4)
            goto L_0x008c
        L_0x007c:
            java.lang.Object r4 = r4.get(r3)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r4 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r4
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r7 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            android.content.Context r7 = r7.getApplicationContext()
            net.one97.paytm.common.entity.recharge.CJRBillDetails r4 = net.one97.paytm.recharge.common.utils.ba.b((net.one97.paytm.common.entity.recharge.CJRBillDetails) r4, (android.content.Context) r7)
        L_0x008c:
            if (r4 == 0) goto L_0x00ab
            r5.setCjrBillDetails(r4)     // Catch:{ CloneNotSupportedException -> 0x009d }
            r5.setBillDueToday(r2)     // Catch:{ CloneNotSupportedException -> 0x009d }
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r4 = r5.clone()     // Catch:{ CloneNotSupportedException -> 0x009d }
            r1.add(r3, r4)     // Catch:{ CloneNotSupportedException -> 0x009d }
            r4 = 1
            goto L_0x00ac
        L_0x009d:
            r4 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r7 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r4 = r4.getMessage()
            if (r4 != 0) goto L_0x00a8
            java.lang.String r4 = ""
        L_0x00a8:
            r7.debugLog(r4)
        L_0x00ab:
            r4 = 0
        L_0x00ac:
            if (r4 != 0) goto L_0x00b5
            r0.add(r5)
            goto L_0x00b5
        L_0x00b2:
            r0.add(r5)
        L_0x00b5:
            r4 = r6
            goto L_0x0015
        L_0x00b8:
            int r8 = r1.size()
            if (r8 <= 0) goto L_0x00e5
            java.lang.String r8 = net.one97.paytm.recharge.common.utils.ab.f61496a
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r9, (boolean) r2)
            if (r8 == 0) goto L_0x00d6
            r8 = r1
            java.util.List r8 = (java.util.List) r8
            net.one97.paytm.recharge.common.utils.q$b r9 = net.one97.paytm.recharge.common.utils.q.b.f61724a
            java.util.Comparator r9 = (java.util.Comparator) r9
            kotlin.a.k.a(r8, r9)
            java.util.Collection r1 = (java.util.Collection) r1
            r0.addAll(r3, r1)
            goto L_0x00e5
        L_0x00d6:
            r8 = r1
            java.util.List r8 = (java.util.List) r8
            net.one97.paytm.recharge.common.utils.q$a r9 = net.one97.paytm.recharge.common.utils.q.a.f61723a
            java.util.Comparator r9 = (java.util.Comparator) r9
            kotlin.a.k.a(r8, r9)
            java.util.Collection r1 = (java.util.Collection) r1
            r0.addAll(r3, r1)
        L_0x00e5:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.q.b(java.util.List, java.lang.String):java.util.List");
    }

    public static List<CJRFrequentOrder> a(String str, String str2) {
        CJRFrequentOrderList frequentOrderList;
        if (TextUtils.isEmpty(str) || CJRRechargeUtilities.INSTANCE.getApplicationContext() == null || (frequentOrderList = CJRRechargeUtilities.INSTANCE.getFrequentOrderList()) == null) {
            return null;
        }
        if (str == null) {
            k.a();
        }
        List<CJRFrequentOrder> a2 = a(frequentOrderList, str, str2);
        if (a2 != null) {
            if (!TextUtils.isEmpty((CharSequence) null)) {
                k.a();
                List<CJRFrequentOrder> a3 = a(frequentOrderList, (String) null, (String) null);
                if (a2 != null) {
                    ArrayList arrayList = (ArrayList) a2;
                    if (a3 != null) {
                        arrayList.addAll((ArrayList) a3);
                    } else {
                        throw new u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.common.entity.recharge.CJRFrequentOrder>");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.common.entity.recharge.CJRFrequentOrder>");
                }
            }
            return b(a2, str);
        }
        throw null;
    }
}
