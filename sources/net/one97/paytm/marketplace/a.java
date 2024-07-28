package net.one97.paytm.marketplace;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.google.gsonhtcfix.f;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.wishList.WishList;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.x;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.b.b;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRSearchLayout;
import net.one97.paytm.common.entity.shopping.CJRShoppingCart;
import net.one97.paytm.common.entity.shopping.WishListProduct;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.w;
import net.one97.paytm.dynamicModule.CommonDynamicFragment;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.marketplace.search.activity.AJRSearchActivity;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53331a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, Object> f53332b = new HashMap<>();

    public static Class<? extends Activity> f() {
        return null;
    }

    public static boolean a(String str) {
        w wVar = w.f50379a;
        return w.a(str);
    }

    public static Bundle a(HashMap<String, Serializable> hashMap) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("BUNDLE_MAP_TAG", hashMap);
        return bundle;
    }

    public static void a(final CJRShoppingCart cJRShoppingCart) {
        if (cJRShoppingCart == null) {
            q.d("invalid data for updateCLPCartCache");
        } else {
            com.paytm.utility.d.a.a(new kotlin.g.a.a<x>() {
                public final /* synthetic */ Object invoke() {
                    Bundle bundle = new Bundle();
                    bundle.putString(net.one97.paytm.deeplink.x.UPDATE_CART_CACHE.name(), new f().a((Object) cJRShoppingCart));
                    w wVar = w.f50379a;
                    String a2 = w.a(net.one97.paytm.deeplink.x.UPDATE_CART_CACHE);
                    h.a aVar = h.f50349a;
                    h.a.a(CJRJarvisApplication.getAppContext(), a2, bundle);
                    return null;
                }
            });
        }
    }

    public static void a() {
        w wVar = w.f50379a;
        String a2 = w.a(net.one97.paytm.deeplink.x.ON_LOG_OUT);
        h.a aVar = h.f50349a;
        h.a.a(CJRJarvisApplication.getAppContext(), a2, (Bundle) null);
    }

    public static void a(int i2, Intent intent) {
        if (intent == null) {
            q.d("invalid data for getImagePlugin");
            return;
        }
        Bundle extras = intent.getExtras();
        extras.putInt("RESULT_CODE", i2);
        w wVar = w.f50379a;
        String a2 = w.a(net.one97.paytm.deeplink.x.GET_IMAGE_PLUGIN);
        h.a aVar = h.f50349a;
        h.a.a(CJRJarvisApplication.getAppContext(), a2, extras);
    }

    public static void a(int i2, int i3, Intent intent) {
        if (intent == null) {
            q.d("invalid data for getImagePlugin");
            return;
        }
        Bundle extras = intent.getExtras();
        extras.putInt("REQUEST_CODE", i2);
        extras.putInt("RESULT_CODE", i3);
        w wVar = w.f50379a;
        String a2 = w.a(net.one97.paytm.deeplink.x.SEND_SCAN_RESULLT);
        h.a aVar = h.f50349a;
        h.a.a(CJRJarvisApplication.getAppContext(), a2, extras);
    }

    public static HashMap<String, Object> a(Context context) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 == null || context == null) {
            return new HashMap<>();
        }
        return a2.getSessionDetails(context);
    }

    public static HashMap<String, Object> b(Context context) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 == null || context == null) {
            return new HashMap<>();
        }
        return a2.getH5Flags(context);
    }

    public static ArrayList<CJRSearchLayout> b() {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null) {
            return a2.getTopSearches();
        }
        return null;
    }

    public static void a(Activity activity, CJRSearchLayout cJRSearchLayout) {
        if (activity == null || cJRSearchLayout == null) {
            q.d("invalid data for addTopSearch");
        } else {
            com.paytm.utility.d.a.a(new kotlin.g.a.a() {
                public final Object invoke() {
                    return a.a(CJRSearchLayout.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ x a(CJRSearchLayout cJRSearchLayout) {
        Bundle bundle = new Bundle();
        bundle.putString(net.one97.paytm.deeplink.x.ADD_TOP_SEARCHES.name(), new f().a((Object) cJRSearchLayout));
        w wVar = w.f50379a;
        String a2 = w.a(net.one97.paytm.deeplink.x.ADD_TOP_SEARCHES);
        h.a aVar = h.f50349a;
        h.a.a(CJRJarvisApplication.getAppContext(), a2, bundle);
        return null;
    }

    public static void c() {
        w wVar = w.f50379a;
        String a2 = w.a(net.one97.paytm.deeplink.x.CLEAR_RECENT_SEARCHES);
        h.a aVar = h.f50349a;
        h.a.a(CJRJarvisApplication.getAppContext(), a2, (Bundle) null);
    }

    public static String d() {
        w wVar = w.f50379a;
        b a2 = w.a();
        return a2 != null ? a2.getBaseH5Url() : "";
    }

    public static boolean a(String str, boolean z) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null) {
            return a2.openH5OrderSummary(str, z);
        }
        return false;
    }

    public static void b(String str) {
        com.paytm.utility.d.a.a(new kotlin.g.a.a(str) {
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Object invoke() {
                return a.f(this.f$0);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ x f(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(net.one97.paytm.deeplink.x.SAVE_SEARCH_RESPONSE.name(), str);
        w wVar = w.f50379a;
        String a2 = w.a(net.one97.paytm.deeplink.x.SAVE_SEARCH_RESPONSE);
        h.a aVar = h.f50349a;
        h.a.a(CJRJarvisApplication.getAppContext(), a2, bundle);
        return null;
    }

    public static void a(Context context, final CLPNetworkService.Callback<WishList> callback, String str, String str2) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null && context != null) {
            a2.addToWishList(context, new b.a<net.one97.paytm.common.entity.shopping.WishList>() {
                public final void a() {
                    CLPNetworkService.Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess();
                    }
                }

                public final void b() {
                    CLPNetworkService.Callback callback = callback;
                    if (callback != null) {
                        callback.onError();
                    }
                }
            }, str, str2);
        }
    }

    public static void a(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(H5StartParamManager.index, i2);
        w wVar = w.f50379a;
        String a2 = w.a(net.one97.paytm.deeplink.x.REMOVE_RECENT_SEARCH_BY_INDEX);
        h.a aVar = h.f50349a;
        h.a.a(CJRJarvisApplication.getAppContext(), a2, bundle);
    }

    public static void a(Activity activity) {
        w wVar = w.f50379a;
        String a2 = w.a(net.one97.paytm.deeplink.x.SEND_LOCATION_SERVICE_RESULT);
        h.a aVar = h.f50349a;
        h.a.a(activity, a2, (Bundle) null);
    }

    public static Fragment a(Bundle bundle) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null) {
            return a2.getMallTabFragment(bundle);
        }
        return CommonDynamicFragment.newInstance(bundle, "ddbase", "net.one97.paytm.dynamic.module.mall.MallInitFragment", "");
    }

    public static void b(Activity activity) {
        w wVar = w.f50379a;
        String a2 = w.a(net.one97.paytm.deeplink.x.REMOVE_ADDRESS_LIST_AND_SAVED_ADDRESS);
        h.a aVar = h.f50349a;
        h.a.a(activity, a2, (Bundle) null);
    }

    public static void a(Context context, String str, HashMap<String, Serializable> hashMap) {
        if (context != null && !TextUtils.isEmpty(str) && hashMap != null) {
            w wVar = w.f50379a;
            b a2 = w.a();
            if (a2 != null) {
                a2.loadPage(context, str, hashMap);
            }
        }
    }

    public static void a(Context context, HashMap<String, Object> hashMap) {
        if (context != null && hashMap != null) {
            w wVar = w.f50379a;
            b a2 = w.a();
            if (a2 != null) {
                a2.setGaJSON(context, hashMap);
            }
        }
    }

    public static Class<? extends Activity> e() {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null) {
            return a2.getAJRWeexFullPageFlyoutActivity();
        }
        return AJRMainActivity.class;
    }

    public static Class<? extends Activity> g() {
        return AJRSearchActivity.class;
    }

    public static void a(String str, String str2) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null) {
            a2.openOrderDetail(str, str2);
        }
    }

    public static void c(String str) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null) {
            a2.openProductPage(str);
        }
    }

    public static void h() {
        if (AJRSearchActivity.f53438a != null) {
            for (int i2 = 0; i2 < AJRSearchActivity.f53438a.size(); i2++) {
                AJRSearchActivity.f53438a.remove(i2);
            }
            AJRSearchActivity.f53438a = null;
        }
    }

    public static void i() {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null) {
            a2.openCart();
        }
    }

    public static boolean b(String str, String str2) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null) {
            return a2.handleSearchResult(str, str2);
        }
        return false;
    }

    public static String c(String str, String str2) {
        w wVar = w.f50379a;
        b a2 = w.a();
        return a2 != null ? a2.getH5UrlType(str, str2) : "";
    }

    public static Class<?> j() {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null) {
            return a2.getAJRShoppingCartActivityClass();
        }
        return AJRMainActivity.class;
    }

    public static void a(Activity activity, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        if (DynamicModuleManager.getInstance().isInstalled("ddbase")) {
            intent.setClassName(activity, d(intent.getStringExtra("target_activity_tag")));
            int intExtra = intent.getIntExtra("result_code_required", Integer.MIN_VALUE);
            if (intExtra != Integer.MIN_VALUE) {
                activity.startActivityForResult(intent, intExtra);
                return;
            }
            intent.setFlags(268435456);
            activity.startActivity(intent);
            return;
        }
        intent.setClass(activity, CommonDynamicLoaderActivity.class);
        if (Application.class.isAssignableFrom(activity.getClass())) {
            intent.setFlags(268435456);
        }
        intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.mall.MallInitActivity");
        intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "ddbase");
        activity.startActivity(intent);
    }

    public static String d(String str) {
        w wVar = w.f50379a;
        b a2 = w.a();
        return (a2 == null || TextUtils.isEmpty(str) || a2.getTargetClass(str) == null || str == null) ? "net.one97.paytm.dynamic.module.mall.MallInitActivity" : a2.getTargetClass(str);
    }

    public static String a(CJRHomePageItem cJRHomePageItem, String str) {
        String str2;
        if (cJRHomePageItem != null && !TextUtils.isEmpty(cJRHomePageItem.getDeeplink())) {
            return cJRHomePageItem.getDeeplink();
        }
        StringBuilder sb = new StringBuilder("paytmmp://");
        sb.append(str);
        if (cJRHomePageItem == null || TextUtils.isEmpty(cJRHomePageItem.getURL())) {
            str2 = "";
        } else {
            str2 = "?url=" + cJRHomePageItem.getURL();
        }
        sb.append(str2);
        return sb.toString();
    }

    public static HashMap<String, Object> a(CJRHomePageItem cJRHomePageItem) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("search_input_type", cJRHomePageItem.getSearchType());
        hashMap.put("search_output_type", cJRHomePageItem.getSearchResultType());
        hashMap.put("search_category", cJRHomePageItem.getSearchCategory());
        hashMap.put("search_autosuggest_data", cJRHomePageItem.getAutoSuggestMetaData());
        return hashMap;
    }

    public static void b(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        f53332b = hashMap;
    }

    public static HashMap<String, Object> k() {
        return f53332b;
    }

    public static String c(Context context) {
        w wVar = w.f50379a;
        b a2 = w.a();
        return (a2 == null || context == null) ? "" : a2.getPincode(context);
    }

    public static HashMap<String, String> d(Context context) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 == null || context == null) {
            return null;
        }
        return a2.getLocationData(context);
    }

    public static PaytmSDKRequestClient l() {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null) {
            return a2.getCheckoutListener();
        }
        return null;
    }

    public static ISubventionProvider m() {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null) {
            return a2.getSubventionListenser();
        }
        return null;
    }

    public static void e(Context context) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null && context != null) {
            a2.requestwishlist(context);
        }
    }

    public static String d(String str, String str2) {
        String url;
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 == null || (url = a2.getURL(str, str2)) == null) {
            return "";
        }
        return url;
    }

    public static ArrayList<WishListProduct> n() {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null) {
            return a2.getWishListProductsCache();
        }
        return new ArrayList<>();
    }

    public static boolean a(Context context, String str) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 == null || context == null) {
            return false;
        }
        return a2.isProductAlreadyInWishList(context, str);
    }

    public static void a(Context context, String str, CLPNetworkService.Callback<WishList> callback) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null && context != null && callback != null) {
            a2.removeProductIdFromWishList(context, str, callback);
        }
    }

    public static void f(Context context) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null && context != null) {
            a2.setWishList(context);
        }
    }

    public static int g(Context context) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 == null || context == null) {
            return 0;
        }
        return a2.getCartCount(context);
    }

    public static String o() {
        w wVar = w.f50379a;
        b a2 = w.a();
        return a2 != null ? a2.getRecentlyViewedItems() : "";
    }

    public static String b(Context context, String str) {
        w wVar = w.f50379a;
        b a2 = w.a();
        return (a2 == null || context == null) ? "" : a2.saveCartJson(context, str);
    }

    public static void e(String str) {
        w wVar = w.f50379a;
        b a2 = w.a();
        if (a2 != null) {
            a2.setSmartLink(str);
        }
    }
}
