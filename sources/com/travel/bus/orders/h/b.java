package com.travel.bus.orders.h;

import com.google.gsonhtcfix.f;
import net.one97.paytm.common.entity.busticket.CJRBusOrderedCart;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import org.json.JSONObject;

public final class b {
    public static boolean a(CJRBusOrderedCart cJRBusOrderedCart) {
        CJROrderSummaryProductDetail productDetail;
        if (cJRBusOrderedCart == null || (productDetail = cJRBusOrderedCart.getProductDetail()) == null || productDetail.getVertical() == null || !productDetail.getVertical().equalsIgnoreCase("Flights")) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(new f().a(cJRBusOrderedCart.getMetaDataResponse()));
            if (!jSONObject.has("type") || jSONObject.getString("type") == null || !jSONObject.getString("type").equalsIgnoreCase("ancillary")) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.getProductDetail();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r1) {
        /*
            if (r1 == 0) goto L_0x001d
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()
            if (r1 == 0) goto L_0x001d
            java.lang.String r0 = r1.getVertical()
            if (r0 == 0) goto L_0x001d
            java.lang.String r1 = r1.getVertical()
            java.lang.String r0 = "tickets"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x001d
            r1 = 1
            return r1
        L_0x001d:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.h.b.b(net.one97.paytm.common.entity.busticket.CJRBusOrderedCart):boolean");
    }

    public static String a(int i2) {
        return String.format("%02d", new Object[]{Integer.valueOf(i2 / 60)}) + "h " + String.format("%02d", new Object[]{Integer.valueOf(i2 % 60)}) + "m";
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
            com.paytm.utility.q.c(r1)
        L_0x0034:
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x003e }
            r1.<init>(r6)     // Catch:{ Exception -> 0x003e }
            java.lang.String r4 = r1.format(r0)     // Catch:{ Exception -> 0x003e }
            goto L_0x0046
        L_0x003e:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.c(r6)
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
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.h.b.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.has("order_data");
    }
}
