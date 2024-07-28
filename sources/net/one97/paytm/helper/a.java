package net.one97.paytm.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.ISFPrewarmedResponseAvailableListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.wishList.WishList;
import com.paytmmall.clpartifact.modal.wishList.WishListProduct;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.g.b.k;
import kotlin.n;
import kotlin.x;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0911a f50546a = new C0911a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static a f50547c;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public c f50548b;

    public static final c b() {
        return f50546a.a();
    }

    public static final /* synthetic */ c b(a aVar) {
        c cVar = aVar.f50548b;
        if (cVar == null) {
            k.a("iAddMoneyListener");
        }
        return cVar;
    }

    /* renamed from: net.one97.paytm.helper.a$a  reason: collision with other inner class name */
    public static final class C0911a {
        private C0911a() {
        }

        public /* synthetic */ C0911a(byte b2) {
            this();
        }

        private a b() {
            if (a.f50547c == null) {
                synchronized (this) {
                    if (a.f50547c == null) {
                        AddMoneyUtils.b();
                    }
                    x xVar = x.f47997a;
                }
                CLPArtifact.init(a.f50546a.a().j(), new C0912a());
            }
            a a2 = a.f50547c;
            if (a2 != null) {
                return a2;
            }
            throw new RuntimeException("getInstance() called before init()");
        }

        /* renamed from: net.one97.paytm.helper.a$a$a  reason: collision with other inner class name */
        public static final class C0912a implements ICLPCommunicationListener {
            public /* synthetic */ String getClientRequestID() {
                return ICLPCommunicationListener.CC.$default$getClientRequestID(this);
            }

            public /* synthetic */ int getHomeTabCacheSupportIndex() {
                return ICLPCommunicationListener.CC.$default$getHomeTabCacheSupportIndex(this);
            }

            public /* synthetic */ String getHostScheme() {
                return ICLPCommunicationListener.CC.$default$getHostScheme(this);
            }

            C0912a() {
            }

            public final ArrayList<Item> getActiveOrderCache() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void sendInterStetialEvent(CJRHomePageItem cJRHomePageItem, Context context, String str) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void openTargetScreen(Activity activity, String str, Intent intent) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void onCartChanged(Context context, String str) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void setCartId(Context context, String str) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void openLoginScreen(Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void sendChannelsEvent(int i2, Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getGAId(Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getMoreUrl(Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void sendCustomEventScreenWithMap(String str, String str2, String str3, String str4, Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final List<WishListProduct> getWishListProductsCache() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getCartId() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final boolean getGTMBoolean(String str, boolean z) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void fetchWishList(Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final View getTabView(Activity activity) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getCartTotal(Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void addEventToQueue(Context context, List<TreeMap<String, String>> list, String str) {
                k.c(list, "p1");
                k.c(str, "p2");
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void setMGV(boolean z) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getAppVersion() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void setActiveOrderCache(ArrayList<Item> arrayList) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final boolean isNotificationUnread() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getSiteId() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void emptyGAEventQueue() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final HomeResponse getPreHeatData() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getLongitude(Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final Context getBaseContext(Context context) {
                k.c(context, "p0");
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getSSOToken(Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void setSFPrewarmedResponseAvailableListener(ISFPrewarmedResponseAvailableListener iSFPrewarmedResponseAvailableListener, boolean z) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getUserId(Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String postRequestBodyForV2() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getClient() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final boolean isProductAlreadyInWishList(Context context, String str) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void setWishList(Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final Class<? extends Activity> getSearchActivity() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final boolean isMallApp() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void sendCustomEventWithMap(String str, HashMap<String, Object> hashMap, Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void sendCustomEventWithMap(Map<String, Object> map) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getGTMUrl(String str) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final int getCartCount(Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final int getOSVersion() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void logThresholdBreachOnKibana() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void sendErrorAnalyticsLogs(String str, boolean z) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getAppName() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final boolean isDebug() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void handleDeepLink(Activity activity, Item item) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void savePreHeatData(HomeResponse homeResponse) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getChildSiteId() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getURL(String str, String str2) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getContainerId() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void removeFromWishList(Context context, CLPNetworkService.Callback<WishList> callback, String str) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final ArrayList<Item> getRecentlyViewedItems() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getLatitude(Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getChannel() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String getDefaultParams(Context context, String str) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final int getLangId(Context context) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final String appendDefaultParams(Context context, String str) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final boolean isKibanaResponseNeeded() {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }

            public final void addToWishList(Context context, CLPNetworkService.Callback<WishList> callback, String str, String str2, String str3) {
                throw new n("An operation is not implemented: ".concat("Not yet implemented"));
            }
        }

        public final c a() {
            return a.b(b());
        }
    }
}
