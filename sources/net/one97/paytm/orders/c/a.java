package net.one97.paytm.orders.c;

import android.text.TextUtils;
import java.util.Iterator;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.utils.l;

public final class a {
    public static boolean a(CJROrderSummary cJROrderSummary) {
        if (cJROrderSummary == null || cJROrderSummary.getOrderedCartList() == null || cJROrderSummary.getOrderedCartList().size() == 0) {
            return false;
        }
        Iterator<CJROrderedCart> it2 = cJROrderSummary.getOrderedCartList().iterator();
        while (it2.hasNext()) {
            CJROrderedCart next = it2.next();
            if (!(next == null || next.getProductDetail() == null)) {
                CJROrderSummaryProductDetail productDetail = next.getProductDetail();
                if (productDetail == null) {
                    return false;
                }
                if (productDetail != null && !TextUtils.isEmpty(productDetail.getProductType()) && productDetail.getProductType().equalsIgnoreCase("Recharge")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(CJROrderSummary cJROrderSummary) {
        if (cJROrderSummary == null || cJROrderSummary.getOrderedCartList() == null || cJROrderSummary.getOrderedCartList().size() == 0) {
            return false;
        }
        Iterator<CJROrderedCart> it2 = cJROrderSummary.getOrderedCartList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            CJROrderedCart next = it2.next();
            if (next != null && next.getProductDetail() != null) {
                CJROrderSummaryProductDetail productDetail = next.getProductDetail();
                if (productDetail != null && productDetail != null && !TextUtils.isEmpty(productDetail.getProductType()) && !TextUtils.isEmpty(productDetail.getVertical()) && productDetail.getProductType().equalsIgnoreCase("Marketplace") && l.b(productDetail.getVertical())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.getProductDetail();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(net.one97.paytm.common.entity.shopping.CJROrderedCart r1) {
        /*
            if (r1 == 0) goto L_0x001c
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()
            if (r1 == 0) goto L_0x001c
            java.lang.String r0 = r1.getVertical()
            if (r0 == 0) goto L_0x001c
            java.lang.String r1 = r1.getVertical()
            java.lang.String r0 = "tickets"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x001c
            r1 = 1
            return r1
        L_0x001c:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.orders.c.a.a(net.one97.paytm.common.entity.shopping.CJROrderedCart):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            if (r5 == 0) goto L_0x0056
            java.lang.String r0 = r5.trim()
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0056
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            r0.<init>(r4)
            r4 = 0
            java.util.Date r0 = r0.parse(r5)     // Catch:{ ParseException -> 0x002b }
            java.util.Calendar r1 = java.util.Calendar.getInstance()     // Catch:{ ParseException -> 0x0029 }
            r1.setTime(r0)     // Catch:{ ParseException -> 0x0029 }
            r2 = 12
            r3 = 330(0x14a, float:4.62E-43)
            r1.add(r2, r3)     // Catch:{ ParseException -> 0x0029 }
            java.util.Date r0 = r1.getTime()     // Catch:{ ParseException -> 0x0029 }
            goto L_0x0034
        L_0x0029:
            r1 = move-exception
            goto L_0x002d
        L_0x002b:
            r1 = move-exception
            r0 = r4
        L_0x002d:
            java.lang.String r1 = r1.getMessage()
            com.paytm.utility.q.b(r1)
        L_0x0034:
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x003e }
            r1.<init>(r6)     // Catch:{ Exception -> 0x003e }
            java.lang.String r4 = r1.format(r0)     // Catch:{ Exception -> 0x003e }
            goto L_0x0046
        L_0x003e:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.b(r6)
        L_0x0046:
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x0055
            java.lang.String r5 = "-"
            java.lang.String r6 = " "
            java.lang.String r4 = r4.replace(r5, r6)
            return r4
        L_0x0055:
            return r5
        L_0x0056:
            java.lang.String r4 = ""
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.orders.c.a.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}
