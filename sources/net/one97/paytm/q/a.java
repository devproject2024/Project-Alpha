package net.one97.paytm.q;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.firebase.perf.metrics.Trace;
import com.google.gson.u;
import com.google.gsonhtcfix.f;
import com.paytm.utility.b;
import com.paytm.utility.c;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.ISFPrewarmedResponseAvailableListener;
import com.paytmmall.clpartifact.modal.cart.CJRCart;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.wishList.WishList;
import com.paytmmall.clpartifact.modal.wishList.WishListProduct;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.LogUtils;
import com.paytmmall.clpartifact.utils.SFGsonUtils;
import com.paytmmall.clpartifact.utils.UrlUtils;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.au;
import net.one97.paytm.utils.j;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.t;

public final class a implements ICLPCommunicationListener {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<Item> f59816a;

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, Class<? extends Activity>> f59817c = new HashMap<String, Class<? extends Activity>>() {
        {
            put(CLPConstants.TargetScreenType.SCREEN_TYPE_LOGIN, AJRAuthActivity.class);
            put(CLPConstants.TargetScreenType.SCREEN_TYPE_EMBED, AJREmbedWebView.class);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private boolean f59818b;

    public final String getAppName() {
        return "paytm";
    }

    public final String getAppVersion() {
        return "9.1.3";
    }

    public final String getChannel() {
        return UpiConstants.MP_ANDROID;
    }

    public final String getChildSiteId() {
        return "1";
    }

    public final String getClient() {
        return "androidapp";
    }

    public final String getContainerId() {
        return "";
    }

    public final int getHomeTabCacheSupportIndex() {
        return 1001;
    }

    public /* synthetic */ String getHostScheme() {
        return ICLPCommunicationListener.CC.$default$getHostScheme(this);
    }

    public final String getSiteId() {
        return "1";
    }

    public final View getTabView(Activity activity) {
        return null;
    }

    public final boolean isDebug() {
        return false;
    }

    public final boolean isKibanaResponseNeeded() {
        return false;
    }

    public final boolean isMallApp() {
        return false;
    }

    public final void handleDeepLink(Activity activity, Item item) {
        Trace a2 = com.google.firebase.perf.a.a("Home_handleDeepLinkTrace");
        if ((activity instanceof AJRMainActivity) && "wallet-pay".equalsIgnoreCase(item.getUrlType())) {
            net.one97.paytm.landingpage.f.a.b();
            ((AJRMainActivity) activity).f();
        }
        CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) SFGsonUtils.INSTANCE.getMGson().a(SFGsonUtils.INSTANCE.getMGson().b(item), CJRHomePageItem.class);
        if (cJRHomePageItem != null) {
            Map gaData = item.getGaData();
            String str = "";
            if (item != null) {
                if (CLPConstants.GA_CHANNEL_NAME.equalsIgnoreCase(item.getUrlType())) {
                    item.setUrlType("homepage_secondary");
                }
                cJRHomePageItem.setUrl(item.getUrl() != null ? item.getUrl() : str);
                if (cJRHomePageItem != null && !TextUtils.isEmpty(cJRHomePageItem.getURL())) {
                    cJRHomePageItem.setUrl(UrlUtils.appendQueryParameter(cJRHomePageItem.getURL(), CLPConstants.IS_MGV, String.valueOf(this.f59818b)));
                }
                if (item.getUrlType() != null) {
                    str = item.getUrlType();
                }
                cJRHomePageItem.setUrlType(str);
                cJRHomePageItem.setName(item.getName());
                str = "paytmmp://" + item.getUrlType() + "?url=" + item.getUrl();
                if (!TextUtils.isEmpty(item.getSearchQuery())) {
                    cJRHomePageItem.setSearchTerm(item.getSearchQuery());
                }
            }
            if (gaData == null) {
                gaData = new HashMap();
            }
            if (net.one97.paytm.marketplace.a.a(cJRHomePageItem.getURLType())) {
                gaData.put("extra_home_data", cJRHomePageItem);
                try {
                    net.one97.paytm.marketplace.a.a((Context) activity, cJRHomePageItem.getURLType(), a((Map<String, Object>) gaData));
                } catch (Exception e2) {
                    LogUtils.printStackTrace(e2);
                }
            } else if (!TextUtils.isEmpty(str) && item != null) {
                j.a("", (Context) activity, cJRHomePageItem.getURLType(), (IJRDataModel) cJRHomePageItem, "", 0, (ArrayList<? extends CJRItem>) null, false, "");
            }
            a(activity, item, gaData);
        }
        a2.stop();
    }

    public final void handleDeepLinkopenpop(Activity activity, Item item, Item item2, Map<String, Object> map) {
        String str;
        CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) new f().a(new com.google.gson.f().b(item), CJRHomePageItem.class);
        String str2 = "";
        if (cJRHomePageItem != null) {
            str = "paytmmp://" + cJRHomePageItem.getURLType() + "?url=" + cJRHomePageItem.getURL();
        } else {
            str = str2;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (cJRHomePageItem != null && net.one97.paytm.marketplace.a.a(cJRHomePageItem.getURLType())) {
            map.put("extra_home_data", cJRHomePageItem);
            try {
                net.one97.paytm.marketplace.a.a((Context) activity, cJRHomePageItem.getURLType(), a(map));
            } catch (Exception e2) {
                LogUtils.printStackTrace(e2);
            }
        } else if (!TextUtils.isEmpty(str) && cJRHomePageItem != null) {
            String uRLType = cJRHomePageItem.getURLType();
            if (TextUtils.isEmpty(cJRHomePageItem.getDeeplink())) {
                cJRHomePageItem.setDeeplink(cJRHomePageItem.getURL());
            }
            String deeplink = cJRHomePageItem.getDeeplink();
            if (!(!TextUtils.isEmpty(deeplink) && (deeplink.startsWith("paytmmp") || deeplink.startsWith("paytmmall")))) {
                String url = cJRHomePageItem.getURL();
                StringBuilder sb = new StringBuilder();
                sb.append("paytmmp://");
                sb.append(uRLType);
                if (!TextUtils.isEmpty(url)) {
                    str2 = "?url=".concat(String.valueOf(url));
                }
                sb.append(str2);
                cJRHomePageItem.setDeeplink(sb.toString());
            }
            d.a().a(activity, uRLType, cJRHomePageItem, "", -1, (ArrayList<? extends CJRItem>) null, false, "", (String) null);
        }
        a(activity, item2, map);
    }

    private static HashMap<String, Serializable> a(Map<String, Object> map) {
        HashMap<String, Serializable> hashMap = new HashMap<>();
        for (Map.Entry next : map.entrySet()) {
            if (next != null) {
                try {
                    if (next.getValue() instanceof Serializable) {
                        hashMap.put(next.getKey(), (Serializable) next.getValue());
                    }
                } catch (Exception e2) {
                    LogUtils.printStackTrace(e2);
                }
            }
        }
        return hashMap;
    }

    private static void a(Context context, Item item, Map<String, Object> map) {
        String str;
        if (item != null && map != null) {
            map.put("list_position", Integer.valueOf(item.getPosition()));
            if (TextUtils.isEmpty(item.getTitle())) {
                str = item.getName();
            } else {
                str = item.getTitle();
            }
            map.put(GAUtil.KEY_PREV_WIDGET_NAME, str);
            net.one97.paytm.marketplace.a.a(context, (HashMap<String, Object>) (HashMap) map);
        }
    }

    public final String getDefaultParams(Context context, String str) {
        return com.paytm.utility.a.c(context, str);
    }

    public final String getUserId(Context context) {
        return com.paytm.utility.a.a(context);
    }

    public final boolean isProductAlreadyInWishList(Context context, String str) {
        return net.one97.paytm.marketplace.a.a(context, str);
    }

    public final void removeFromWishList(Context context, CLPNetworkService.Callback<WishList> callback, String str) {
        net.one97.paytm.marketplace.a.a(context, str, callback);
    }

    public final void setWishList(Context context) {
        net.one97.paytm.marketplace.a.f(context);
    }

    public final void addToWishList(Context context, CLPNetworkService.Callback<WishList> callback, String str, String str2, String str3) {
        net.one97.paytm.marketplace.a.a(context, callback, str2, str3);
    }

    public final String getSSOToken(Context context) {
        return t.b(context);
    }

    public final String getURL(String str, String str2) {
        return net.one97.paytm.marketplace.a.d(str, str2);
    }

    public final int getCartCount(Context context) {
        return net.one97.paytm.marketplace.a.g(context);
    }

    public final String getGAId(Context context) {
        return com.paytm.utility.a.w(context);
    }

    public final void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public final void sendCustomEventScreenWithMap(String str, String str2, String str3, String str4, Context context) {
        net.one97.paytm.j.a.a(str, str2, str3, str4, context);
    }

    public final void sendCustomEventWithMap(String str, HashMap<String, Object> hashMap, Context context) {
        net.one97.paytm.j.a.a(str, (Map<String, Object>) hashMap, context);
    }

    public final void sendCustomEventWithMap(Map<String, Object> map) {
        net.one97.paytm.j.a.b("customEvent", map, CJRJarvisApplication.getAppContext());
    }

    public final void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        net.one97.paytm.j.a.a(context, str, str2, str3, str4, str5, str6);
    }

    public final void emptyGAEventQueue() {
        GaHandler.getInstance().emptyPendingQueue();
    }

    public final void sendChannelsEvent(int i2, Context context) {
        Item item = new Item();
        switch (i2) {
            case 1001:
                item.setUrlType("channels_search");
                handleDeepLink((Activity) context, item);
                return;
            case 1002:
                item.setUrlType("channels_all_brands");
                handleDeepLink((Activity) context, item);
                return;
            case 1003:
                item.setUrlType("channels_all_categories");
                handleDeepLink((Activity) context, item);
                return;
            default:
                return;
        }
    }

    public final String getCartId() {
        return t.g(CJRJarvisApplication.getAppContext());
    }

    public final String postRequestBodyForV2() {
        return l.a(CJRJarvisApplication.getAppContext(), (String) null, (String) null);
    }

    public final List<WishListProduct> getWishListProductsCache() {
        return (List) new com.google.gson.f().a(new f().a((Object) net.one97.paytm.marketplace.a.n()), new com.google.gson.b.a<List<WishListProduct>>() {
        }.getType());
    }

    public final void openLoginScreen(Context context) {
        Intent intent = new Intent();
        intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
        a((Activity) context, intent, CLPConstants.TargetScreenType.SCREEN_TYPE_LOGIN, 111);
    }

    private static void a(Activity activity, Intent intent, String str, int i2) {
        Class cls;
        if (activity != null && intent != null && !activity.isFinishing() && (cls = f59817c.get(str)) != null) {
            intent.setClass(activity, cls);
            if (i2 != Integer.MAX_VALUE) {
                activity.startActivityForResult(intent, i2);
            } else {
                activity.startActivity(intent);
            }
        }
    }

    public final ArrayList<Item> getRecentlyViewedItems() {
        try {
            return (ArrayList) new com.google.gson.f().a(net.one97.paytm.marketplace.a.o(), new com.google.gson.b.a<List<Item>>() {
            }.getType());
        } catch (u e2) {
            q.b(e2.getMessage());
            return new ArrayList<>();
        }
    }

    public final int getOSVersion() {
        return b.d();
    }

    public final void setActiveOrderCache(ArrayList<Item> arrayList) {
        ArrayList<Item> arrayList2 = f59816a;
        int size = arrayList2 == null ? 0 : arrayList2.size();
        f59816a = arrayList;
        if (size != 0) {
            androidx.localbroadcastmanager.a.a.a(CLPArtifact.getInstance().getContext()).a(new Intent(CLPConstants.ACTION_UPDATE_ACTIVE_ORDER));
        }
    }

    public final ArrayList<Item> getActiveOrderCache() {
        return f59816a;
    }

    public final void onCartChanged(Context context, String str) {
        if (str != null) {
            CJRCart cJRCart = (CJRCart) c.a(new f().a((Object) net.one97.paytm.marketplace.a.b(context, str)), CJRCart.class);
            if (cJRCart != null) {
                t.a(context, cJRCart.getCount());
                t.b(context, String.valueOf(cJRCart.getOrderTotal()));
            }
        }
    }

    public final String appendDefaultParams(Context context, String str) {
        return d.a(str + c.a(context, false) + "&resolution=" + com.paytm.utility.a.v(context) + "&quality=high&client=mall-app");
    }

    public final String getLatitude(Context context) {
        return String.valueOf(com.paytm.utility.a.g(context));
    }

    public final String getLongitude(Context context) {
        return String.valueOf(com.paytm.utility.a.h(context));
    }

    public final Class<? extends Activity> getSearchActivity() {
        return net.one97.paytm.marketplace.a.g();
    }

    public final void setCartId(Context context, String str) {
        t.a(context, str);
    }

    public final void fetchWishList(Context context) {
        net.one97.paytm.marketplace.a.e(context);
    }

    public final void sendErrorAnalyticsLogs(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            au.e eVar = (au.e) new com.google.gson.f().a(str, au.e.class);
            if (z) {
                b.a(eVar, au.c.ApiLog);
            } else {
                b.a(eVar, au.c.ApiError);
            }
        }
    }

    public final String getGTMUrl(String str) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, "");
    }

    public final String getClientRequestID() {
        String b2 = ag.a(CLPArtifact.getInstance().getContext()).b(CLPConstants.ADSSDKREQUESTID, "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public final void setMGV(boolean z) {
        this.f59818b = z;
    }

    public final boolean isNotificationUnread() {
        return net.one97.paytm.landingpage.utils.d.a() > 0;
    }

    public final void sendInterStetialEvent(CJRHomePageItem cJRHomePageItem, Context context, String str) {
        net.one97.paytm.j.a.a(cJRHomePageItem, context, str);
    }

    public final void savePreHeatData(HomeResponse homeResponse) {
        if (homeResponse != null) {
            net.one97.paytm.landingpage.a.a().a(homeResponse);
        }
    }

    public final void setSFPrewarmedResponseAvailableListener(ISFPrewarmedResponseAvailableListener iSFPrewarmedResponseAvailableListener, boolean z) {
        net.one97.paytm.landingpage.a.a().a(iSFPrewarmedResponseAvailableListener, z);
    }

    public final void logThresholdBreachOnKibana() {
        au.e eVar = new au.e();
        eVar.g("Cache fetching post Threshold breach");
        b.a(eVar, au.c.LocalError);
    }

    public final void openTargetScreen(Activity activity, String str, Intent intent) {
        a(activity, intent, str, Integer.MAX_VALUE);
    }

    public final boolean getGTMBoolean(String str, boolean z) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, z);
    }

    public final void addEventToQueue(Context context, List<TreeMap<String, String>> list, String str) {
        if (list != null && !list.isEmpty()) {
            net.one97.paytm.j.a.a(context, (List<Map<String, String>>) new ArrayList(list), "/", str);
        }
    }

    public final HomeResponse getPreHeatData() {
        net.one97.paytm.landingpage.a a2 = net.one97.paytm.landingpage.a.a();
        if (a2.f52641a != null && !com.google.android.gms.common.util.f.a(a2.f52641a.getPage())) {
            return net.one97.paytm.landingpage.a.a().b();
        }
        return null;
    }

    public final void sendPromotionClickForSmartIconClick(Context context, Item item, String str, String str2, String str3, String str4) {
        net.one97.paytm.j.a.a((CJRHomePageItem) new f().a(new com.google.gson.f().b(item), CJRHomePageItem.class), "", context, str, str2, str3, str4);
    }

    public final void sendPromotionClick(Item item, Context context, int i2, String str, String str2) {
        d.a().a(item, i2, str, str2, context);
    }

    public final String getMoreUrl(Context context) {
        return d.b().a(CLPConstants.KEY_CATEGORY_V2_URL);
    }

    public final HomeResponse getBundleResponse(Context context, HomeResponse homeResponse) {
        return net.one97.paytm.landingpage.utils.j.a(context, homeResponse);
    }

    public final Context getBaseContext(Context context) {
        return e.a(context);
    }

    public final void logErrorResponse(int i2, HashMap<String, String> hashMap) {
        au.e eVar = new au.e();
        eVar.s = a(hashMap, "response_type");
        eVar.B = a(hashMap, CLPConstants.PRODUCT_ID);
        eVar.v = a(hashMap, "mid");
        eVar.r = a(a(hashMap, CLPConstants.RESPONSE_SIZE));
        b.a(eVar, au.c.LocalError);
    }

    private static int a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str);
            }
            return 0;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private static String a(HashMap<String, String> hashMap, String str) {
        return hashMap.containsKey(str) ? hashMap.get(str) : "";
    }

    public final void handleDeeplinkUrl(Context context, Item item) {
        h.a aVar = h.f50349a;
        h.a.a(context, item.getUrl(), (Bundle) null);
    }

    public final String getCartTotal(Context context) {
        return ag.a(context.getApplicationContext()).b("order_total", "0", true);
    }

    public final int getLangId(Context context) {
        Integer num;
        String a2 = n.a(context, n.a());
        if (a2 == null || (num = com.paytm.utility.e.p.get(a2)) == null) {
            return 0;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return 1;
        }
        return intValue;
    }
}
