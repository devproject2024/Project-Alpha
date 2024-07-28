package net.one97.paytm.o2o.movies.common.b;

import android.content.Context;
import android.text.TextUtils;
import com.appsflyer.AFInAppEventType;
import com.google.gsonhtcfix.f;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.shopping.CJRCategoryMap;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f75003a;

    /* renamed from: b  reason: collision with root package name */
    public String f75004b = AFInAppEventType.PURCHASE;

    /* renamed from: c  reason: collision with root package name */
    public String f75005c = "";

    public a(Context context) {
        this.f75003a = context;
    }

    public final void a(String str, CJROrderSummary cJROrderSummary) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/summary");
            String n = b.n(this.f75003a);
            if (!TextUtils.isEmpty(n)) {
                hashMap.put("movie_user_id", n);
            }
            hashMap.put("movie_order_failure_action_name", str);
            if (cJROrderSummary != null && cJROrderSummary.getOrderedCartList() != null && cJROrderSummary.getOrderedCartList().size() > 0 && cJROrderSummary.getOrderedCartList().get(0).getMetaDataResponse() != null) {
                Object metaDataResponse = cJROrderSummary.getOrderedCartList().get(0).getMetaDataResponse();
                f fVar = new f();
                CJROrderSummaryMetadataResponseV2 cJROrderSummaryMetadataResponseV2 = (CJROrderSummaryMetadataResponseV2) fVar.a(fVar.a(metaDataResponse), CJROrderSummaryMetadataResponseV2.class);
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponseV2.getCinema())) {
                    hashMap.put("movie_cinema_name", cJROrderSummaryMetadataResponseV2.getCinema());
                }
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponseV2.getMovie())) {
                    hashMap.put("movie_movie_name", cJROrderSummaryMetadataResponseV2.getMovie());
                }
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponseV2.getCitySearched())) {
                    hashMap.put("movie_city_name", cJROrderSummaryMetadataResponseV2.getCitySearched());
                }
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponseV2.getSource())) {
                    hashMap.put("movie_cinema_listing_type", cJROrderSummaryMetadataResponseV2.getSource());
                }
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponseV2.getShowTime())) {
                    hashMap.put("movie_show_timing_bucket", cJROrderSummaryMetadataResponseV2.getShowTime());
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void a(ArrayList<CJROrderedCart> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (!(arrayList.get(i2).getProductDetail() == null || arrayList.get(i2).getProductDetail().getGAkey() == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("fnl_ga_key", arrayList.get(i2).getProductDetail().getGAkey());
                hashMap.put("fnl_vertical", arrayList.get(i2).getProductDetail().getVertical());
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap("fnl_success_summary_screen_loaded", hashMap, this.f75003a);
            }
        }
    }

    public static void a(CJROrderSummary cJROrderSummary) {
        ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
        HashMap hashMap = new HashMap();
        Iterator<CJROrderedCart> it2 = orderedCartList.iterator();
        while (it2.hasNext()) {
            CJROrderedCart next = it2.next();
            if (next.getProductDetail() != null) {
                CJROrderSummaryProductDetail productDetail = next.getProductDetail();
                String valueOf = String.valueOf(productDetail.getId());
                productDetail.setDiscountedPrice(next.getTotalPrice());
                ArrayList arrayList = (ArrayList) hashMap.get(valueOf);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashMap.put(valueOf, arrayList);
                }
                arrayList.add(productDetail);
            }
        }
        for (String str : hashMap.keySet()) {
            Iterator it3 = ((ArrayList) hashMap.get(str)).iterator();
            if (it3.hasNext()) {
                CJROrderSummaryProductDetail cJROrderSummaryProductDetail = (CJROrderSummaryProductDetail) it3.next();
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendUAEventWithValue(cJROrderSummaryProductDetail.getCategoryMapPath(), String.valueOf(cJROrderSummaryProductDetail.getDiscountedPrice()));
            }
        }
    }

    public static void b(String str, CJROrderSummary cJROrderSummary) {
        String str2;
        String str3;
        String str4;
        CJROrderSummaryProductDetail cJROrderSummaryProductDetail;
        ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator<CJROrderedCart> it2 = orderedCartList.iterator();
        while (it2.hasNext()) {
            CJROrderedCart next = it2.next();
            if (next.getProductDetail() != null) {
                CJROrderSummaryProductDetail productDetail = next.getProductDetail();
                String valueOf = String.valueOf(productDetail.getId());
                productDetail.setDiscountedPrice(next.getDiscountedPrice());
                ArrayList arrayList = (ArrayList) hashMap.get(valueOf);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashMap.put(valueOf, arrayList);
                }
                arrayList.add(productDetail);
                StringBuilder sb = new StringBuilder();
                sb.append(next.getMerchantId());
                hashMap2.put(valueOf, sb.toString());
            }
        }
        String id = cJROrderSummary.getId();
        ArrayList arrayList2 = new ArrayList();
        String str5 = "";
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        for (String str9 : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str9);
            if (arrayList3 == null || arrayList3.size() <= 0 || (cJROrderSummaryProductDetail = (CJROrderSummaryProductDetail) arrayList3.get(0)) == null) {
                str3 = str6;
                str4 = str7;
                str2 = str8;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(arrayList3.size());
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(cJROrderSummaryProductDetail.getId());
                String sb5 = sb4.toString();
                String name = cJROrderSummaryProductDetail.getName();
                StringBuilder sb6 = new StringBuilder();
                sb6.append(cJROrderSummaryProductDetail.getDiscountedPrice());
                String sb7 = sb6.toString();
                arrayList2.clear();
                Iterator<CJRCategoryMap> it3 = cJROrderSummaryProductDetail.getCategoryMap().iterator();
                while (it3.hasNext()) {
                    arrayList2.add(it3.next().getCategoryId());
                }
                str3 = sb3;
                str4 = sb5;
                str2 = name;
                str5 = sb7;
            }
            Iterator it4 = arrayList3.iterator();
            if (it4.hasNext()) {
                it4.next();
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendAppsFlyerPurchaseEvent(str, cJROrderSummary.getAggregateItemPrice(), str5, str4, id, arrayList2, str3, str2, (String) hashMap2.get(str9));
            }
            str7 = str4;
            str6 = str3;
            str8 = str2;
        }
    }
}
