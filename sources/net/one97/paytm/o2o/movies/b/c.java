package net.one97.paytm.o2o.movies.b;

import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRMovieICancelProtectModel;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRSummaryFoodBeveragesResponse;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRSummaryFoodData;
import net.one97.paytm.common.entity.shopping.CJRFullFillmentObject;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodVoucherItem;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRSummaryFoodVoucherData;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.a;
import net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2;
import net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig;
import net.one97.paytm.o2o.movies.utils.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f74903a = c.class.getName();

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a4 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.orders.datamodel.CJRSummarySendTicketItem a(net.one97.paytm.common.entity.shopping.CJROrderSummary r5) {
        /*
            r0 = 0
            java.util.ArrayList r1 = r5.getOrderedCartList()     // Catch:{ Exception -> 0x00a5 }
            if (r1 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.util.ArrayList r1 = r5.getOrderedCartList()     // Catch:{ Exception -> 0x00a5 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x00a5 }
            if (r1 != 0) goto L_0x0013
            return r0
        L_0x0013:
            java.util.ArrayList r1 = r5.getOrderedCartList()     // Catch:{ Exception -> 0x00a5 }
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x00a5 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x00a5 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r1 = a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r1)     // Catch:{ Exception -> 0x00a5 }
            if (r1 != 0) goto L_0x0025
            return r0
        L_0x0025:
            int r3 = r1.getIsInsurancePresentV2()     // Catch:{ Exception -> 0x00a5 }
            r4 = 1
            if (r3 != r4) goto L_0x003f
            java.util.ArrayList r3 = r5.getOrderedCartList()     // Catch:{ Exception -> 0x00a5 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ Exception -> 0x00a5 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3     // Catch:{ Exception -> 0x00a5 }
            int r3 = c((net.one97.paytm.common.entity.shopping.CJROrderedCart) r3)     // Catch:{ Exception -> 0x00a5 }
            r4 = 20
            if (r3 != r4) goto L_0x003f
            return r0
        L_0x003f:
            java.lang.String r1 = r1.getShowTime()     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r3 = net.one97.paytm.o2o.movies.utils.n.b()     // Catch:{ Exception -> 0x00a5 }
            if (r1 == 0) goto L_0x00a5
            if (r3 == 0) goto L_0x00a5
            boolean r1 = net.one97.paytm.o2o.movies.utils.n.a((java.lang.String) r3, (java.lang.String) r1)     // Catch:{ Exception -> 0x00a5 }
            if (r1 != 0) goto L_0x00a5
            java.lang.String r1 = r5.getId()     // Catch:{ Exception -> 0x00a5 }
            java.util.ArrayList r5 = r5.getOrderedCartList()     // Catch:{ Exception -> 0x00a5 }
            java.lang.Object r5 = r5.get(r2)     // Catch:{ Exception -> 0x00a5 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5     // Catch:{ Exception -> 0x00a5 }
            java.lang.Object r2 = r5.getMetaDataResponse()     // Catch:{ Exception -> 0x00a5 }
            if (r2 != 0) goto L_0x0067
        L_0x0065:
            r5 = r0
            goto L_0x00a2
        L_0x0067:
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r2 = a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r5)     // Catch:{ Exception -> 0x00a5 }
            if (r2 != 0) goto L_0x006e
            goto L_0x0065
        L_0x006e:
            net.one97.paytm.orders.datamodel.CJRSummarySendTicketItem$a r3 = new net.one97.paytm.orders.datamodel.CJRSummarySendTicketItem$a     // Catch:{ Exception -> 0x00a5 }
            r3.<init>()     // Catch:{ Exception -> 0x00a5 }
            net.one97.paytm.orders.datamodel.CJRSummarySendTicketItem r4 = r3.f56865a     // Catch:{ Exception -> 0x00a5 }
            java.lang.String unused = r4.orderId = r1     // Catch:{ Exception -> 0x00a5 }
            int r1 = r2.getTicketCount()     // Catch:{ Exception -> 0x00a5 }
            net.one97.paytm.orders.datamodel.CJRSummarySendTicketItem r4 = r3.f56865a     // Catch:{ Exception -> 0x00a5 }
            int unused = r4.noOfTickets = r1     // Catch:{ Exception -> 0x00a5 }
            int r1 = r2.getIsInsurancePresentV2()     // Catch:{ Exception -> 0x00a5 }
            net.one97.paytm.orders.datamodel.CJRSummarySendTicketItem r4 = r3.f56865a     // Catch:{ Exception -> 0x00a5 }
            int unused = r4.isInsurancePresent = r1     // Catch:{ Exception -> 0x00a5 }
            net.one97.paytm.common.entity.movies.foodbeverage.CJRMovieICancelProtectModel r1 = r2.getInsurance()     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r1 = a((net.one97.paytm.common.entity.movies.foodbeverage.CJRMovieICancelProtectModel) r1)     // Catch:{ Exception -> 0x00a5 }
            net.one97.paytm.orders.datamodel.CJRSummarySendTicketItem r2 = r3.f56865a     // Catch:{ Exception -> 0x00a5 }
            java.lang.String unused = r2.durationBeforeShowTime = r1     // Catch:{ Exception -> 0x00a5 }
            int r5 = c((net.one97.paytm.common.entity.shopping.CJROrderedCart) r5)     // Catch:{ Exception -> 0x00a5 }
            net.one97.paytm.orders.datamodel.CJRSummarySendTicketItem r1 = r3.f56865a     // Catch:{ Exception -> 0x00a5 }
            int unused = r1.movieInsuranceState = r5     // Catch:{ Exception -> 0x00a5 }
            net.one97.paytm.orders.datamodel.CJRSummarySendTicketItem r5 = r3.f56865a     // Catch:{ Exception -> 0x00a5 }
        L_0x00a2:
            if (r5 == 0) goto L_0x00a5
            return r5
        L_0x00a5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.b.c.a(net.one97.paytm.common.entity.shopping.CJROrderSummary):net.one97.paytm.orders.datamodel.CJRSummarySendTicketItem");
    }

    private static String a(CJRMovieICancelProtectModel cJRMovieICancelProtectModel) {
        if (cJRMovieICancelProtectModel != null) {
            return cJRMovieICancelProtectModel.getDurationBeforeShowTime();
        }
        return null;
    }

    public static int b(CJROrderSummary cJROrderSummary) {
        if (a(cJROrderSummary.getOrderedCartList().get(0)) == null) {
            return 0;
        }
        return c(cJROrderSummary.getOrderedCartList().get(0));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x008c A[EDGE_INSN: B:70:0x008c->B:29:0x008c ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r7, net.one97.paytm.common.entity.shopping.CJROrderSummary r8) {
        /*
            java.util.ArrayList r0 = r8.getOrderedCartList()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.ArrayList r0 = r8.getOrderedCartList()
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0013
            return r1
        L_0x0013:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            r4 = 0
        L_0x001f:
            java.util.ArrayList r5 = r8.getOrderedCartList()
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x004c
            java.util.ArrayList r5 = r8.getOrderedCartList()
            java.lang.Object r5 = r5.get(r4)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5
            if (r5 == 0) goto L_0x0049
            java.lang.String r6 = r5.getStatus()
            if (r6 == 0) goto L_0x0049
            java.lang.String r6 = r5.getStatus()
            r0.add(r6)
            java.lang.String r5 = r5.getItemStatus()
            r2.add(r5)
        L_0x0049:
            int r4 = r4 + 1
            goto L_0x001f
        L_0x004c:
            int r8 = r0.size()
            if (r8 <= 0) goto L_0x008c
            java.util.Iterator r8 = r0.iterator()
        L_0x0056:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r8.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "SUCCESS"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 != 0) goto L_0x0082
            java.lang.String r5 = "BOOKED"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 != 0) goto L_0x0082
            java.lang.String r5 = "CANCELLED"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 != 0) goto L_0x0082
            java.lang.String r5 = "Cancel Pending"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L_0x0056
        L_0x0082:
            android.content.res.Resources r8 = r7.getResources()
            int r1 = net.one97.paytm.o2o.movies.R.string.train_booking_successful
            java.lang.String r1 = r8.getString(r1)
        L_0x008c:
            if (r1 != 0) goto L_0x00b7
            int r8 = r0.size()
            if (r8 <= 0) goto L_0x00b7
            java.util.Iterator r8 = r0.iterator()
        L_0x0098:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x00b7
            java.lang.Object r4 = r8.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "FAILED"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L_0x00b7
            android.content.res.Resources r1 = r7.getResources()
            int r4 = net.one97.paytm.o2o.movies.R.string.booking_failed
            java.lang.String r1 = r1.getString(r4)
            goto L_0x0098
        L_0x00b7:
            if (r1 != 0) goto L_0x00ea
            int r8 = r0.size()
            if (r8 <= 0) goto L_0x00ea
            java.util.Iterator r8 = r0.iterator()
        L_0x00c3:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00ea
            java.lang.Object r0 = r8.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r4 = "PENDING"
            boolean r4 = r0.equalsIgnoreCase(r4)
            if (r4 != 0) goto L_0x00df
            java.lang.String r4 = "PROCESSING"
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x00ea
        L_0x00df:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = net.one97.paytm.o2o.movies.R.string.train_booking_pending
            java.lang.String r1 = r0.getString(r1)
            goto L_0x00c3
        L_0x00ea:
            int r8 = r2.size()
            if (r8 <= 0) goto L_0x0122
            java.util.Iterator r8 = r2.iterator()
            r0 = 0
        L_0x00f5:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x0116
            java.lang.Object r0 = r8.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "17"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 != 0) goto L_0x0114
            java.lang.String r2 = "18"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0112
            goto L_0x0114
        L_0x0112:
            r0 = 0
            goto L_0x0116
        L_0x0114:
            r0 = 1
            goto L_0x00f5
        L_0x0116:
            if (r0 == 0) goto L_0x0122
            android.content.res.Resources r7 = r7.getResources()
            int r8 = net.one97.paytm.o2o.movies.R.string.train_booking_cancelled
            java.lang.String r1 = r7.getString(r8)
        L_0x0122:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.b.c.a(android.content.Context, net.one97.paytm.common.entity.shopping.CJROrderSummary):java.lang.String");
    }

    public static String c(CJROrderSummary cJROrderSummary) {
        if (cJROrderSummary == null || cJROrderSummary.getOrderedCartList() == null || cJROrderSummary.getOrderedCartList().size() == 0 || cJROrderSummary.getOrderedCartList().get(0).getProductDetail() == null) {
            return null;
        }
        return cJROrderSummary.getOrderedCartList().get(0).getProductDetail().getMerchantName();
    }

    public static String d(CJROrderSummary cJROrderSummary) {
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderSummaryProductDetail productDetail;
        if (cJROrderSummary == null || (orderedCartList = cJROrderSummary.getOrderedCartList()) == null || orderedCartList.size() <= 0 || (productDetail = orderedCartList.get(0).getProductDetail()) == null) {
            return null;
        }
        return productDetail.getVertical();
    }

    public static CJROrderSummaryMetadataResponseV2 a(CJROrderedCart cJROrderedCart) {
        Object metaDataResponse = cJROrderedCart.getMetaDataResponse();
        f fVar = new f();
        return (CJROrderSummaryMetadataResponseV2) fVar.a(fVar.a(metaDataResponse), CJROrderSummaryMetadataResponseV2.class);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r1 = r16.getOrderedCartList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem e(net.one97.paytm.common.entity.shopping.CJROrderSummary r16) {
        /*
            r0 = 0
            if (r16 == 0) goto L_0x016e
            java.util.ArrayList r1 = r16.getOrderedCartList()
            boolean r1 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r1)
            if (r1 == 0) goto L_0x000f
            goto L_0x016e
        L_0x000f:
            java.util.ArrayList r1 = r16.getOrderedCartList()
            r2 = 0
            java.lang.Object r3 = r1.get(r2)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r4 = a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r3)
            if (r4 != 0) goto L_0x0021
            return r0
        L_0x0021:
            int r5 = r1.size()
            r6 = 1
            if (r5 <= r6) goto L_0x0083
            java.util.ArrayList r5 = r16.getOrderedCartList()
            java.lang.Object r5 = r5.get(r6)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5
            if (r5 != 0) goto L_0x0036
        L_0x0034:
            r5 = r0
            goto L_0x0041
        L_0x0036:
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r5 = a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r5)
            if (r5 != 0) goto L_0x003d
            goto L_0x0034
        L_0x003d:
            net.one97.paytm.common.entity.movies.foodbeverage.CJRSummaryFoodBeveragesResponse r5 = r5.getFoodAndBeverages()
        L_0x0041:
            if (r5 == 0) goto L_0x0048
            java.lang.String r7 = r5.getTotalChargedPrice()
            goto L_0x0049
        L_0x0048:
            r7 = r0
        L_0x0049:
            java.util.ArrayList r8 = r16.getOrderedCartList()
            if (r8 == 0) goto L_0x0081
            int r9 = r8.size()
            int r9 = r9 - r6
        L_0x0054:
            if (r9 < 0) goto L_0x0081
            java.lang.Object r10 = r8.get(r9)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r10 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r10
            if (r10 == 0) goto L_0x007e
            java.util.Map r10 = r10.getRechargeConfiguration()
            if (r10 == 0) goto L_0x007e
            java.lang.String r11 = "ty"
            java.lang.Object r11 = r10.get(r11)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = "3dglasses"
            boolean r11 = r12.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x007e
            java.lang.String r8 = "price"
            java.lang.Object r8 = r10.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0086
        L_0x007e:
            int r9 = r9 + -1
            goto L_0x0054
        L_0x0081:
            r8 = r0
            goto L_0x0086
        L_0x0083:
            r5 = r0
            r7 = r5
            r8 = r7
        L_0x0086:
            java.util.List r9 = f(r16)
            int r10 = r9.size()     // Catch:{ Exception -> 0x00ba }
            if (r10 <= 0) goto L_0x00ba
            r10 = 0
            java.util.Iterator r12 = r9.iterator()     // Catch:{ Exception -> 0x00ba }
        L_0x0096:
            boolean r13 = r12.hasNext()     // Catch:{ Exception -> 0x00ba }
            if (r13 == 0) goto L_0x00ac
            java.lang.Object r13 = r12.next()     // Catch:{ Exception -> 0x00ba }
            net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodVoucherItem r13 = (net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodVoucherItem) r13     // Catch:{ Exception -> 0x00ba }
            java.lang.String r13 = r13.getTotalChargedPrice()     // Catch:{ Exception -> 0x00ba }
            double r13 = java.lang.Double.parseDouble(r13)     // Catch:{ Exception -> 0x00ba }
            double r10 = r10 + r13
            goto L_0x0096
        L_0x00ac:
            java.lang.String r12 = "%.2f"
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00ba }
            java.lang.Double r10 = java.lang.Double.valueOf(r10)     // Catch:{ Exception -> 0x00ba }
            r6[r2] = r10     // Catch:{ Exception -> 0x00ba }
            java.lang.String r0 = java.lang.String.format(r12, r6)     // Catch:{ Exception -> 0x00ba }
        L_0x00ba:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem$a r6 = new net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem$a
            r6.<init>()
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r10 = r6.f75155a
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 unused = r10.metadataResponse = r4
            java.lang.String r4 = ""
            r10 = r4
            r11 = r10
            r12 = 0
        L_0x00c9:
            boolean r13 = android.text.TextUtils.isEmpty(r10)
            if (r13 == 0) goto L_0x00ef
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x00ef
            int r11 = r1.size()
            if (r12 >= r11) goto L_0x00ef
            java.lang.Object r10 = r1.get(r12)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r10 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r10
            java.lang.String r11 = r10.getPromoCode()
            java.lang.String r10 = r10.getPromoText()
            int r12 = r12 + 1
            r15 = r11
            r11 = r10
            r10 = r15
            goto L_0x00c9
        L_0x00ef:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r11 = r6.f75155a
            java.lang.String unused = r11.promoCode = r10
            r2 = r4
            r10 = 0
        L_0x00f6:
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0119
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 == 0) goto L_0x0119
            int r4 = r1.size()
            if (r10 >= r4) goto L_0x0119
            java.lang.Object r2 = r1.get(r10)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r2
            java.lang.String r4 = r2.getPromoCode()
            java.lang.String r2 = r2.getPromoText()
            int r10 = r10 + 1
            goto L_0x00f6
        L_0x0119:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r1 = r6.f75155a
            java.lang.String unused = r1.promoText = r2
            double r1 = r16.getGrandTotal()
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r4 = r6.f75155a
            double unused = r4.grandTotal = r1
            java.lang.String r1 = r16.getId()
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r2 = r6.f75155a
            java.lang.String unused = r2.orderId = r1
            java.lang.Object r1 = r3.getMetaDataResponse()
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r2 = r6.f75155a
            java.lang.Object unused = r2.metaDataObject = r1
            java.util.ArrayList r1 = r16.getPaymentInfo()
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r2 = r6.f75155a
            r2.mPaymentInfo = r1
            java.util.ArrayList r1 = r16.getTransactionDetails()
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r2 = r6.f75155a
            java.util.ArrayList unused = r2.transactionList = r1
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r1 = r6.f75155a
            java.lang.String unused = r1.totalFoodPrice = r7
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r1 = r6.f75155a
            java.lang.String unused = r1.totalFoodVoucherPrice = r0
            double r0 = r16.getDiscountAmount()
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r2 = r6.f75155a
            double unused = r2.discountAmount = r0
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r0 = r6.f75155a
            java.lang.String unused = r0.mTotal3Dprice = r8
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r0 = r6.f75155a
            net.one97.paytm.common.entity.movies.foodbeverage.CJRSummaryFoodBeveragesResponse unused = r0.foodBeveragesResponse = r5
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r0 = r6.f75155a
            java.util.List unused = r0.allFoodVoucher = r9
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r0 = r6.f75155a
        L_0x016e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.b.c.e(net.one97.paytm.common.entity.shopping.CJROrderSummary):net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem");
    }

    public static CJRSummaryMovieDescItemV2 a(CJROrderedCart cJROrderedCart, CJROrderSummary cJROrderSummary, String str, String str2) {
        int i2;
        CJROrderSummaryMetadataResponseV2 a2;
        CJRSummaryFoodBeveragesResponse foodAndBeverages;
        String str3 = null;
        if (cJROrderedCart == null || cJROrderedCart.getMetaDataResponse() == null) {
            return null;
        }
        CJROrderSummaryMetadataResponseV2 a3 = a(cJROrderedCart);
        boolean booleanValue = (a3.getInsuranceConfig() == null || a3.getInsuranceConfig().getShare_booking_id() == null) ? false : a3.getInsuranceConfig().getShare_booking_id().booleanValue();
        if (a3 == null) {
            return null;
        }
        CJRSummaryMovieDescItemV2.a aVar = new CJRSummaryMovieDescItemV2.a();
        String unused = aVar.f75154a.movieShowTime = a3.getShowTime();
        String unused2 = aVar.f75154a.movieName = a3.getMovie();
        String unused3 = aVar.f75154a.movieLanguage = a3.getLanguage();
        String unused4 = aVar.f75154a.movieDuration = n.a(a3.getDuration());
        CJROrderedCart unused5 = aVar.f75154a.movieItem = cJROrderedCart;
        CJROrderSummaryMetadataResponseV2 unused6 = aVar.f75154a.metaDataresponse = a3;
        String unused7 = aVar.f75154a.uniqueBookingId = b(cJROrderedCart);
        String unused8 = aVar.f75154a.encryptedOrderId = d(cJROrderedCart);
        int unused9 = aVar.f75154a.movieTicketStatus = c(cJROrderedCart);
        int unused10 = aVar.f75154a.movieTicketCount = a3.getTicketCount();
        CJROrderSummary unused11 = aVar.f75154a.summary = cJROrderSummary;
        int unused12 = aVar.f75154a.movieInsurancePresent = a3.getIsInsurancePresentV2();
        CJRMovieICancelProtectModel insurance = a3.getInsurance();
        if (insurance != null) {
            str3 = insurance.getInsuranceEndDate();
        }
        String unused13 = aVar.f75154a.movieInsuranceEndDate = str3;
        String unused14 = aVar.f75154a.durationBeforeShowTime = a(a3.getInsurance());
        String unused15 = aVar.f75154a.cancelledMsg = str;
        String unused16 = aVar.f75154a.orderId = str2;
        double unused17 = aVar.f75154a.grandTotal = cJROrderSummary.getGrandTotal();
        ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
        if (orderedCartList.size() <= 1 || (a2 = a(orderedCartList.get(1))) == null || (foodAndBeverages = a2.getFoodAndBeverages()) == null) {
            i2 = 0;
        } else {
            ArrayList<CJRSummaryFoodData> data = foodAndBeverages.getData();
            i2 = 0;
            for (int i3 = 0; i3 < data.size(); i3++) {
                i2 += data.get(i3).getQuantity();
            }
        }
        int unused18 = aVar.f75154a.foodItems = i2;
        CJRInsuranceConfig unused19 = aVar.f75154a.insuranceConfig = a3.getInsuranceConfig();
        boolean unused20 = aVar.f75154a.shareBookingId = booleanValue;
        return aVar.f75154a;
    }

    private static List<CJRFoodVoucherItem> f(CJROrderSummary cJROrderSummary) {
        CJROrderSummaryMetadataResponseV2 a2;
        String str;
        String str2;
        int i2;
        String str3;
        String str4;
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONObject optJSONObject2;
        JSONArray optJSONArray2;
        ArrayList arrayList = new ArrayList();
        try {
            HashMap hashMap = new HashMap();
            Iterator<CJROrderedCart> it2 = cJROrderSummary.getOrderedCartList().iterator();
            while (it2.hasNext()) {
                CJROrderedCart next = it2.next();
                if (!(next.getProductDetail() == null || (a2 = a(next)) == null || a2.getFoodVoucher() == null || a2.getFoodVoucher().getData() == null)) {
                    String str5 = "0";
                    String str6 = "";
                    if (a2.getFoodVoucher().getData().size() > 0) {
                        CJRSummaryFoodVoucherData cJRSummaryFoodVoucherData = a2.getFoodVoucher().getData().get(0);
                        str4 = cJRSummaryFoodVoucherData.getItemName();
                        str3 = cJRSummaryFoodVoucherData.getUnitPrice();
                        i2 = cJRSummaryFoodVoucherData.getQuantity();
                        String totalChargedPrice = cJRSummaryFoodVoucherData.getTotalChargedPrice();
                        String termConditionRedeemProcess = cJRSummaryFoodVoucherData.getTermConditionRedeemProcess();
                        String expiry = cJRSummaryFoodVoucherData.getExpiry();
                        if (TextUtils.isEmpty(str4)) {
                            str4 = str6;
                        }
                        if (TextUtils.isEmpty(str3)) {
                            str3 = str5;
                        }
                        str2 = expiry;
                        if (!TextUtils.isEmpty(totalChargedPrice)) {
                            str5 = totalChargedPrice;
                        }
                        str = termConditionRedeemProcess;
                    } else {
                        str4 = str6;
                        str5 = str4;
                        str3 = str5;
                        str2 = str3;
                        str = str2;
                        i2 = 0;
                    }
                    CJRFoodVoucherItem cJRFoodVoucherItem = (CJRFoodVoucherItem) hashMap.get(Long.valueOf(next.getProductDetail().getId()));
                    if (cJRFoodVoucherItem == null) {
                        JSONObject e2 = e(next);
                        if (!(e2 == null || (optJSONObject2 = e2.optJSONObject(String.valueOf(next.getId()))) == null || (optJSONArray2 = optJSONObject2.optJSONArray("codes")) == null || optJSONArray2.length() <= 0 || TextUtils.isEmpty(optJSONArray2.getString(0)))) {
                            str6 = optJSONArray2.getString(0);
                        }
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(Long.valueOf(next.getId()), new a(Long.valueOf(next.getId()), str4, str6, str2, str));
                        cJRFoodVoucherItem = new CJRFoodVoucherItem(str4, Long.valueOf(next.getProductDetail().getId()), str3, str5, Integer.valueOf(i2), hashMap2);
                    } else {
                        JSONObject e3 = e(next);
                        if (!(e3 == null || (optJSONObject = e3.optJSONObject(String.valueOf(next.getId()))) == null || (optJSONArray = optJSONObject.optJSONArray("codes")) == null || optJSONArray.length() <= 0 || TextUtils.isEmpty(optJSONArray.getString(0)))) {
                            str6 = optJSONArray.getString(0);
                        }
                        cJRFoodVoucherItem.getIdVoucherCodeMapping().put(Long.valueOf(next.getId()), new a(Long.valueOf(next.getId()), str4, str6, str2, str));
                    }
                    hashMap.put(Long.valueOf(next.getProductDetail().getId()), cJRFoodVoucherItem);
                }
            }
            arrayList.addAll(hashMap.values());
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static String b(CJROrderedCart cJROrderedCart) {
        JSONObject e2 = e(cJROrderedCart);
        if (e2 == null) {
            return null;
        }
        try {
            if (!e2.has("uniqueBookingId") || TextUtils.isEmpty(e2.getString("uniqueBookingId"))) {
                return null;
            }
            return e2.getString("uniqueBookingId");
        } catch (JSONException unused) {
            q.c("");
            return null;
        }
    }

    public static int c(CJROrderedCart cJROrderedCart) {
        JSONObject e2 = e(cJROrderedCart);
        if (e2 == null) {
            return -1;
        }
        try {
            if (e2.has("movieTicketStatus")) {
                return e2.getInt("movieTicketStatus");
            }
            return -1;
        } catch (JSONException unused) {
            q.c("");
            return -1;
        }
    }

    public static String d(CJROrderedCart cJROrderedCart) {
        JSONObject e2 = e(cJROrderedCart);
        if (e2 == null) {
            return null;
        }
        try {
            if (!e2.has("encryptedOrderId") || TextUtils.isEmpty(e2.getString("encryptedOrderId"))) {
                return null;
            }
            return e2.getString("encryptedOrderId");
        } catch (JSONException unused) {
            q.c("");
            return null;
        }
    }

    private static JSONObject e(CJROrderedCart cJROrderedCart) {
        if (cJROrderedCart.getFullFillmentOject() == null) {
            return null;
        }
        CJRFullFillmentObject fullFillmentOject = cJROrderedCart.getFullFillmentOject();
        if (fullFillmentOject.getFullFillment() != null) {
            return fullFillmentOject.getFullFillment();
        }
        return null;
    }
}
