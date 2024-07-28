package com.paytmmall.artifact.common.b.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.paytm.utility.q;
import com.paytmmall.a.a;
import com.paytmmall.artifact.clp.activity.AJRSecondaryHome;
import com.paytmmall.artifact.common.entity.CJRDataSource;
import com.paytmmall.artifact.common.entity.CJRHomePageItem;
import com.paytmmall.artifact.common.entity.CJRHomePageLayoutV2;
import com.paytmmall.artifact.common.entity.CJRItem;
import com.paytmmall.artifact.d.c;
import com.paytmmall.artifact.d.o;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.grid.entity.CJRGridProduct;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15662a = a.class.getSimpleName();

    public static void a(Map<String, String> map, Context context) {
        int i2;
        CJRHomePageLayoutV2 cJRHomePageLayoutV2;
        Map<String, String> map2;
        String str;
        String str2 = map.get("seoUrl");
        String str3 = map.get("urlType");
        String str4 = map.get("widgetPosition");
        String str5 = map.get("widgetLayoutType");
        ArrayList<CJRHomePageItem> arrayList = null;
        if (!"product".equalsIgnoreCase(str3) && !TextUtils.isEmpty(str2)) {
            Uri parse = Uri.parse(str2);
            if (parse == null) {
                str = null;
            } else {
                str = parse.getQueryParameter("title");
            }
            if (!TextUtils.isEmpty(str)) {
                t.e().setUTMData(str);
            }
        }
        String host = Uri.parse(str2).getHost();
        if ("nearbuy".equals(host) || "deals".equals(host)) {
            str3 = host;
        }
        CJRHomePageItem a2 = o.a(t.e().getApplicationContext(), str2, str3);
        if (a2 == null) {
            boolean z = c.f15691a;
            return;
        }
        String str6 = map.get("productList");
        String str7 = map.get(CLPConstants.ARGUMENT_KEY_POSITION);
        if (map.containsKey("listName")) {
            a2.setListName(map.get("listName"));
        }
        if (map.containsKey("listId")) {
            a2.setListId(map.get("listId"));
        }
        if (map.containsKey(CLPConstants.PARENT_ID)) {
            a2.setParentId(map.get(CLPConstants.PARENT_ID));
        }
        if (map.containsKey("searchData")) {
            try {
                HashMap<String, Object> a3 = a(map.get("searchData"), Object.class);
                a2.setSearchType(String.valueOf(a3.get("search_input_type")));
                a2.setSearchResultType(String.valueOf(a3.get("search_output_type")));
                a2.setSearchCategory(String.valueOf(a3.get("search_category")));
                a2.setSearchTerm(String.valueOf(a3.get("search_term")));
                a2.setExperimentName(String.valueOf(a3.get("experimentName")));
                t.e().setSearchMap(a3);
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
        }
        if (!TextUtils.isEmpty(str7)) {
            int intValue = Integer.valueOf(str7).intValue();
            a2.setListPosition(intValue);
            i2 = intValue;
        } else {
            i2 = -1;
        }
        if (map.containsKey("product") && map.containsKey("gridId")) {
            CJRGridProduct cJRGridProduct = (CJRGridProduct) new f().a(map.get("product"), CJRGridProduct.class);
            a2.setListId(map.get("gridId"));
            a2.setItemID(cJRGridProduct.getProductID());
            a2.setParentId(cJRGridProduct.getParentId());
            a2.setVerticalid(cJRGridProduct.getVerticalId());
        }
        if (map.containsKey("sourceName")) {
            a2.setSourceName(map.get("sourceName"));
        }
        if (TextUtils.isEmpty(str6) || str6.equals("[]") || i2 == -1) {
            cJRHomePageLayoutV2 = null;
        } else {
            cJRHomePageLayoutV2 = (CJRHomePageLayoutV2) new f().a(str6, CJRHomePageLayoutV2.class);
            if (cJRHomePageLayoutV2.getHomePageItemList() != null && cJRHomePageLayoutV2.getHomePageItemList().size() - 1 >= i2) {
                CJRHomePageItem cJRHomePageItem = cJRHomePageLayoutV2.getHomePageItemList().get(i2);
                a2.setItemID(cJRHomePageItem.getItemID());
                a2.setParentId(cJRHomePageItem.getParentID());
                a2.setVerticalid(cJRHomePageItem.getVerticalid());
            }
            if (cJRHomePageLayoutV2.getDatasources() != null && cJRHomePageLayoutV2.getDatasources().size() > 0) {
                CJRDataSource cJRDataSource = cJRHomePageLayoutV2.getDatasources().get(0);
                a2.setmContainerInstanceID(cJRDataSource.getmContainerInstanceID());
                a2.setListId(cJRDataSource.getmListId());
            }
            a2.setLayoutType(cJRHomePageLayoutV2.getLayout());
            a2.setSourceInfo(((CJRHomePageItem) new f().a(str6, CJRHomePageItem.class)).getSourceInfo());
        }
        if (!TextUtils.isEmpty(str4)) {
            a2.setWidgetPosition(Integer.parseInt(str4));
        }
        if (!TextUtils.isEmpty(str5)) {
            a2.setLayoutType(str5);
        }
        if (context == null || !(context instanceof AJRSecondaryHome)) {
            map2 = null;
        } else {
            map2 = ((AJRSecondaryHome) context).f15578a;
        }
        if (map2 != null) {
            a2.setqRCodeId(map2.get("qrcode_id"));
            a2.setqRCodeOrderId(map2.get("qrcode_order_id"));
            a2.setAffilaiteID(map2.get("affiliateID"));
            a2.setTimestamp(map2.get("timestamp"));
            a2.setDeeplink(map2.get("deeplink"));
        }
        if (!TextUtils.isEmpty(str2) && !"nolink".equalsIgnoreCase(str3)) {
            String origin = (a2 == null || TextUtils.isEmpty(a2.getOrigin())) ? null : a2.getOrigin();
            if (context != null && !a.d()) {
                String uRLType = a2.getURLType();
                if (cJRHomePageLayoutV2 != null) {
                    arrayList = cJRHomePageLayoutV2.getHomePageItemList();
                }
                t.a(context, uRLType, a2, "", i2, (ArrayList<? extends CJRItem>) arrayList, origin);
            }
        }
    }

    private static <T> HashMap<String, T> a(String str, Class<T> cls) throws JSONException {
        HashMap<String, T> hashMap = new HashMap<>();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                hashMap.put(next, cls.cast(jSONObject.get(next)));
            } catch (ClassCastException e2) {
                q.c(e2.getMessage());
                hashMap.put(next, (Object) null);
            }
        }
        return hashMap;
    }
}
