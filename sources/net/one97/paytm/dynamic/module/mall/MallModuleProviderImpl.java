package net.one97.paytm.dynamic.module.mall;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.a.a;
import com.paytmmall.artifact.cart.activity.AJRShoppingCartActivity;
import com.paytmmall.artifact.d.j;
import com.paytmmall.artifact.d.q;
import com.paytmmall.artifact.d.s;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.d.v;
import com.paytmmall.artifact.flyout.AJRWeexFullPageFlyoutActivity;
import com.paytmmall.clpartifact.common.CartUtils;
import com.paytmmall.clpartifact.modal.cart.CJRCartResponse;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.b.b;
import net.one97.paytm.common.entity.shopping.CJRSearchLayout;
import net.one97.paytm.common.entity.shopping.WishList;
import net.one97.paytm.common.entity.shopping.WishListProduct;
import net.one97.paytm.marketplace.b;
import net.one97.paytm.marketplace.search.activity.AJRSearchActivity;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;
import net.one97.paytm.q.c;
import net.one97.paytm.utils.w;

public class MallModuleProviderImpl implements b {
    private HashMap<String, String> targetClassMap = new HashMap<String, String>() {
        {
            put("ShoppingCartActivityTag", AJRShoppingCartActivity.class.getName());
        }
    };

    public String getChildSiteID() {
        return "1";
    }

    public String getSiteId() {
        return "1";
    }

    public void initMall(Application application) {
    }

    public void setMapMyIndiaAtlasClientId(String str) {
    }

    public void setMapMyIndiaAtlasClientSecret(String str) {
    }

    public void setMapMyIndiaAtlasGrantType(String str) {
    }

    public void setMapMyIndiaMapSDKKey(String str) {
    }

    public void setMapMyIndiaRestAPIKey(String str) {
    }

    public void setSmartLink(String str) {
    }

    public void setTopSearches() {
    }

    public MallModuleProviderImpl() {
        getMallControllerInstance();
    }

    public static t getMallControllerInstance() {
        return JarvisHelper.getInstance().getMallControllerInstance();
    }

    public Fragment getMallTabFragment(Bundle bundle) {
        getMallControllerInstance();
        return t.a(bundle);
    }

    public Class<?> getDetailedItemTrackingClass() {
        getMallControllerInstance();
        return null;
    }

    public Class<?> getOrderDetailsActivity() {
        getMallControllerInstance();
        return null;
    }

    public void updateUrlForMallTab(Fragment fragment, String str) {
        t.c();
    }

    public boolean handleBackpressOnWeex(Fragment fragment) {
        t.c();
        return false;
    }

    private Fragment getChildFragment(Fragment fragment, String str) {
        if (fragment != null) {
            return fragment.getChildFragmentManager().c(str);
        }
        return null;
    }

    public void getDefaultAddressFromAPI(Context context, String str) {
        t.a(context, str);
    }

    public void setSavedAddress(Context context, String str) {
        t.b(context, str);
    }

    public void openCart() {
        a.a();
    }

    public boolean handleSearchResult(String str, String str2) {
        return !TextUtils.isEmpty(str2) && !a.b(str2, str);
    }

    public String getH5UrlType(String str, String str2) {
        return str.equals("AJRSecondaryHome") ? "homepage_secondary" : str2;
    }

    public ArrayList<CJRSearchLayout> getTopSearches() {
        return (ArrayList) com.paytmmall.artifact.e.a.a(q.a(v.a().c()), new com.google.gson.b.a<List<CJRSearchLayout>>() {
        }.getType());
    }

    public void addTopSearches(Context context, String str) {
        v.a().a(context, (com.paytmmall.artifact.search.entity.CJRSearchLayout) com.paytmmall.artifact.e.a.a(str, com.paytmmall.artifact.search.entity.CJRSearchLayout.class));
    }

    public void clearRecentSearches(Context context) {
        v.a().d(context, "recentSearchString");
    }

    public boolean handleSearchUrl(String str) {
        if (str == null || !a.f() || !str.contains("/search")) {
            return false;
        }
        a.b(a.c(str));
        return true;
    }

    public String getBaseH5Url() {
        return a.e();
    }

    public boolean openOrderDetail(String str, String str2) {
        return a.a(str, str2);
    }

    public boolean openH5OrderSummary(String str, boolean z) {
        return a.a(str, z);
    }

    public void saveSearchResponse(Context context, String str) {
        v.a();
        v.e(context, str);
    }

    public void setSavedAddressListResponse(Context context, String str) {
        t.c(context, str);
    }

    public void removeAddressListAndSavedAddress(Activity activity) {
        t.a(activity);
    }

    public String getUserName(Context context) {
        return t.a(context);
    }

    public String getCityName(Context context) {
        return t.b(context);
    }

    public String getPincode(Context context) {
        return t.c(context);
    }

    public HashMap<String, String> getLocationData(Context context) {
        if (context == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String a2 = com.paytmmall.artifact.d.b.a(context);
        if (!TextUtils.isEmpty(a2)) {
            hashMap.put(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, a2);
        }
        String d2 = com.paytmmall.artifact.d.b.d(context);
        if (!TextUtils.isEmpty(d2)) {
            hashMap.put("lat", d2);
        }
        String e2 = com.paytmmall.artifact.d.b.e(context);
        if (!TextUtils.isEmpty(e2)) {
            hashMap.put("long", e2);
        }
        return hashMap;
    }

    public void loadPage(Context context, String str, HashMap<String, Serializable> hashMap) {
        getMallControllerInstance();
        t.a(context, str, hashMap);
    }

    public boolean isDeepLinkHandleByMall(String str) {
        getMallControllerInstance();
        return t.b(str);
    }

    public void showGridPopup(FragmentActivity fragmentActivity, String str, boolean z, boolean z2) {
        getMallControllerInstance();
    }

    public Map<String, String> getExtraQRMap(Context context) {
        getMallControllerInstance();
        return null;
    }

    public void openProductPage(String str) {
        a.b(str, "product");
    }

    public Class<?> getAJRShoppingCartActivityClass() {
        getMallControllerInstance();
        return t.f();
    }

    public Class<? extends Activity> getReturnReplaceActivity() {
        try {
            throw new IllegalAccessException();
        } catch (Exception e2) {
            s.a(e2);
            getMallControllerInstance();
            return null;
        }
    }

    public Class<? extends Activity> getSearchActivity() {
        return AJRSearchActivity.class;
    }

    public Class<? extends Activity> getAJRWeexFullPageFlyoutActivity() {
        return AJRWeexFullPageFlyoutActivity.class;
    }

    public void setGaJSON(Context context, HashMap<String, Object> hashMap) {
        t.c();
        t.a(context, (Map<String, Object>) hashMap);
    }

    public void handlePlayServicesError(Activity activity) {
        t.e().handlePlayServicesError(activity);
    }

    public boolean isAJRProductActivity(Context context) {
        try {
            t.c();
            Class cls = null;
            return cls.isInstance(context);
        } catch (Exception unused) {
            return false;
        }
    }

    public String getTargetClass(String str) {
        return this.targetClassMap.get(str);
    }

    public PaytmSDKRequestClient getCheckoutListener() {
        return JarvisHelper.getInstance().getCheckoutListener();
    }

    public ISubventionProvider getSubventionListenser() {
        return JarvisHelper.getInstance().getSubventionProvider();
    }

    public void requestwishlist(Context context) {
        getMallControllerInstance();
        t.d(context);
    }

    public String getURL(String str, String str2) {
        getMallControllerInstance();
        return t.a(str, str2);
    }

    public ArrayList<WishListProduct> getWishListProductsCache() {
        getMallControllerInstance();
        return (ArrayList) new f().a(new f().a((Object) t.h()), new com.google.gson.b.a<List<WishListProduct>>() {
        }.getType());
    }

    public void removeFromWishList(Context context, final b.a<WishList> aVar, String str) {
        getMallControllerInstance();
        t.a(context, (com.paytmmall.b.b) new com.paytmmall.b.b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                aVar.a();
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                aVar.b();
            }
        }, str);
    }

    public void addToWishList(Context context, final b.a<WishList> aVar, String str, String str2) {
        getMallControllerInstance();
        t.a(context, new com.paytmmall.b.b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                aVar.a();
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                aVar.b();
            }
        }, str, str2);
    }

    public boolean isProductAlreadyInWishList(Context context, String str) {
        getMallControllerInstance();
        return t.d(context, str);
    }

    public void onLogout(Context context) {
        w.c(context);
        v.a().a(context);
    }

    public void getImagePlugin(Context context, int i2, Bundle bundle) {
        t.a(i2, bundle);
    }

    public void sendScanResult(Context context, int i2, int i3, Bundle bundle) {
        t.a(i2, i3, bundle);
    }

    public HashMap<String, Object> getSessionDetails(Context context) {
        return com.paytmmall.artifact.common.b.a.a.c();
    }

    public HashMap<String, Object> getH5Flags(Context context) {
        return com.paytmmall.artifact.common.b.a.a.d();
    }

    public void removeProductIdFromWishList(Context context, String str, final CLPNetworkService.Callback<com.paytmmall.clpartifact.modal.wishList.WishList> callback) {
        t.c();
        t.a(context, (com.paytmmall.b.b) new com.paytmmall.b.b() {
            public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                callback.onSuccess();
            }

            public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                callback.onError();
            }
        }, str);
    }

    public void setWishList(Context context) {
        t.e().setWishList(context);
    }

    public int getCartCount(Context context) {
        return t.a();
    }

    public String getRecentlyViewedItems() {
        return new f().a((Object) t.e().getRecentlyViewedItems());
    }

    public String saveCartJson(Context context, String str) {
        v a2 = v.a();
        a2.a(context, str);
        return new f().a((Object) a2.f15746a != null ? a2.f15746a.getCart() : null);
    }

    public void removeRecentSearchByIndex(Context context, int i2) {
        v a2 = v.a();
        try {
            if (a2.f15748c.size() > i2) {
                Iterator<com.paytmmall.artifact.search.entity.CJRSearchLayout> it2 = a2.f15748c.iterator();
                while (it2.hasNext()) {
                    ArrayList arrayList = new ArrayList();
                    while (it2.hasNext()) {
                        arrayList.add(it2.next());
                    }
                    if (arrayList.size() > i2) {
                        a2.f15748c.remove(i2);
                    }
                }
                a2.b(context);
            }
        } catch (ConcurrentModificationException e2) {
            s.a(e2);
        } catch (Exception e3) {
            s.a(e3);
        }
    }

    public void loadMallH5Page(String str) {
        a.b(j.b(str));
    }

    public void sendLocationServiceResult(Activity activity) {
        t.b(activity);
    }

    public void updateCartCache(Context context, String str) {
        CJRCartResponse cJRCartResponse;
        if (!(str == null || (cJRCartResponse = (CJRCartResponse) c.a(str, CJRCartResponse.class)) == null)) {
            CartUtils.setCartItem(new com.google.gson.f().b(cJRCartResponse.getCart()));
        }
        try {
            v.a().a(context, str);
        } catch (Exception unused) {
        }
    }
}
