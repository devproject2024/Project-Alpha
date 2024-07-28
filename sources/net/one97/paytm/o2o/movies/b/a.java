package net.one97.paytm.o2o.movies.b;

import android.content.Context;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.o2o.movies.common.c.b;

public enum a {
    INSTANCE;
    
    private final String TAG;
    private Map<String, Object> checkoutDataForPurchaseMap;
    private Map<String, Object> movieHomeListingImpressionMap;
    private Map<String, Object> movieTheatreListingImpressionMap;
    private int pos;

    public final void initMovieHomeListingImpressionMap(Map<String, Object> map) {
        this.movieHomeListingImpressionMap = map;
    }

    public final void initMovieTheatreListingImpressionMap(Map<String, Object> map) {
        this.movieTheatreListingImpressionMap = map;
    }

    public final void addProductImpression(Map<String, Object> map, boolean z) {
        Map<String, Object> map2;
        if (z) {
            try {
                map2 = this.movieHomeListingImpressionMap;
            } catch (Exception unused) {
                return;
            }
        } else {
            map2 = this.movieTheatreListingImpressionMap;
        }
        if (map2.get("ecommerce") != null) {
            Map map3 = (Map) map2.get("ecommerce");
            if (map3.get("impressions") != null) {
                List list = (List) map3.get("impressions");
                if (!z) {
                    map.put(CLPConstants.BRAND_PARAMS, map2.get("city_name"));
                }
                list.add(map);
                return;
            }
            ArrayList arrayList = new ArrayList();
            map3.put("impressions", arrayList);
            if (!z) {
                map.put(CLPConstants.BRAND_PARAMS, map2.get("city_name"));
            }
            arrayList.add(map);
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        if (!z) {
            map.put(CLPConstants.BRAND_PARAMS, map2.get("city_name"));
        }
        arrayList2.add(map);
        hashMap.put("impressions", arrayList2);
        map2.put("ecommerce", hashMap);
    }

    public final void pushProductImpression(Context context, boolean z) {
        Map<String, Object> map = this.movieHomeListingImpressionMap;
        if (map == null) {
            return;
        }
        if (z) {
            map.put("vertical_name", "Entertainment - Movies");
            b.f75032a.f75033b.sendEnhancedEcommerceEvent("productImpression", this.movieHomeListingImpressionMap, context);
            this.movieHomeListingImpressionMap = new HashMap();
            return;
        }
        this.movieTheatreListingImpressionMap.put("vertical_name", "Entertainment - Movies");
        b.f75032a.f75033b.sendEnhancedEcommerceEvent("productImpression", this.movieTheatreListingImpressionMap, context);
        this.movieTheatreListingImpressionMap = new HashMap();
    }

    public final void setPos(int i2) {
        this.pos = i2;
    }

    public final int getPos() {
        return this.pos;
    }

    public final void setCheckoutDataForPurchaseMap(Map<String, Object> map) {
        this.checkoutDataForPurchaseMap = map;
    }

    public final Map<String, Object> getCheckoutDataForPurchaseMap() {
        return this.checkoutDataForPurchaseMap;
    }
}
