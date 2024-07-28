package com.paytmmall.clpartifact.listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.wishList.WishList;
import com.paytmmall.clpartifact.modal.wishList.WishListProduct;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public interface ICLPCommunicationListener extends ICartChangeListener {
    void addEventToQueue(Context context, List<TreeMap<String, String>> list, String str);

    void addToWishList(Context context, CLPNetworkService.Callback<WishList> callback, String str, String str2, String str3);

    String appendDefaultParams(Context context, String str);

    void emptyGAEventQueue();

    void fetchWishList(Context context);

    ArrayList<Item> getActiveOrderCache();

    String getAppName();

    String getAppVersion();

    Context getBaseContext(Context context);

    HomeResponse getBundleResponse(Context context, HomeResponse homeResponse);

    int getCartCount(Context context);

    String getCartId();

    String getCartTotal(Context context);

    String getChannel();

    String getChildSiteId();

    String getClient();

    String getClientRequestID();

    String getContainerId();

    String getDefaultParams(Context context, String str);

    String getGAId(Context context);

    boolean getGTMBoolean(String str, boolean z);

    String getGTMUrl(String str);

    int getHomeTabCacheSupportIndex();

    String getHostScheme();

    int getLangId(Context context);

    String getLatitude(Context context);

    String getLongitude(Context context);

    String getMoreUrl(Context context);

    int getOSVersion();

    HomeResponse getPreHeatData();

    ArrayList<Item> getRecentlyViewedItems();

    String getSSOToken(Context context);

    Class<? extends Activity> getSearchActivity();

    String getSiteId();

    View getTabView(Activity activity);

    String getURL(String str, String str2);

    String getUserId(Context context);

    List<WishListProduct> getWishListProductsCache();

    void handleDeepLink(Activity activity, Item item);

    void handleDeepLinkopenpop(Activity activity, Item item, Item item2, Map<String, Object> map);

    void handleDeeplinkUrl(Context context, Item item);

    boolean isDebug();

    boolean isKibanaResponseNeeded();

    boolean isMallApp();

    boolean isNotificationUnread();

    boolean isProductAlreadyInWishList(Context context, String str);

    void logErrorResponse(int i2, HashMap<String, String> hashMap);

    void logThresholdBreachOnKibana();

    void openLoginScreen(Context context);

    void openTargetScreen(Activity activity, String str, Intent intent);

    String postRequestBodyForV2();

    void removeFromWishList(Context context, CLPNetworkService.Callback<WishList> callback, String str);

    void savePreHeatData(HomeResponse homeResponse);

    void sendChannelsEvent(int i2, Context context);

    void sendCustomEventScreenWithMap(String str, String str2, String str3, String str4, Context context);

    void sendCustomEventWithMap(String str, HashMap<String, Object> hashMap, Context context);

    void sendCustomEventWithMap(Map<String, Object> map);

    void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    void sendErrorAnalyticsLogs(String str, boolean z);

    void sendInterStetialEvent(CJRHomePageItem cJRHomePageItem, Context context, String str);

    void sendOpenScreenWithDeviceInfo(String str, String str2, Context context);

    void sendPromotionClick(Item item, Context context, int i2, String str, String str2);

    void sendPromotionClickForSmartIconClick(Context context, Item item, String str, String str2, String str3, String str4);

    void setActiveOrderCache(ArrayList<Item> arrayList);

    void setCartId(Context context, String str);

    void setMGV(boolean z);

    void setSFPrewarmedResponseAvailableListener(ISFPrewarmedResponseAvailableListener iSFPrewarmedResponseAvailableListener, boolean z);

    void setWishList(Context context);

    /* renamed from: com.paytmmall.clpartifact.listeners.ICLPCommunicationListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getHomeTabCacheSupportIndex(ICLPCommunicationListener iCLPCommunicationListener) {
            return 0;
        }

        public static String $default$getHostScheme(ICLPCommunicationListener iCLPCommunicationListener) {
            return "paytmmp://";
        }

        public static String $default$getClientRequestID(ICLPCommunicationListener _this) {
            String b2 = a.a(CLPArtifact.getInstance().getContext().getApplicationContext(), a.c.HOME).b(CLPConstants.ADSSDKREQUESTID, "", true);
            if (b2.equals("")) {
                return null;
            }
            return b2;
        }
    }
}
