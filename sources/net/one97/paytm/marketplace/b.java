package net.one97.paytm.marketplace;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.b.b;
import net.one97.paytm.common.entity.shopping.CJRSearchLayout;
import net.one97.paytm.common.entity.shopping.WishList;
import net.one97.paytm.common.entity.shopping.WishListProduct;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider;

public interface b {
    void addToWishList(Context context, b.a<WishList> aVar, String str, String str2);

    void addTopSearches(Context context, String str);

    void clearRecentSearches(Context context);

    Class<?> getAJRShoppingCartActivityClass();

    Class<? extends Activity> getAJRWeexFullPageFlyoutActivity();

    String getBaseH5Url();

    int getCartCount(Context context);

    PaytmSDKRequestClient getCheckoutListener();

    void getDefaultAddressFromAPI(Context context, String str);

    HashMap<String, Object> getH5Flags(Context context);

    String getH5UrlType(String str, String str2);

    void getImagePlugin(Context context, int i2, Bundle bundle);

    HashMap<String, String> getLocationData(Context context);

    Fragment getMallTabFragment(Bundle bundle);

    String getPincode(Context context);

    String getRecentlyViewedItems();

    HashMap<String, Object> getSessionDetails(Context context);

    ISubventionProvider getSubventionListenser();

    String getTargetClass(String str);

    ArrayList<CJRSearchLayout> getTopSearches();

    String getURL(String str, String str2);

    ArrayList<WishListProduct> getWishListProductsCache();

    boolean handleSearchResult(String str, String str2);

    boolean isProductAlreadyInWishList(Context context, String str);

    void loadMallH5Page(String str);

    void loadPage(Context context, String str, HashMap<String, Serializable> hashMap);

    void onLogout(Context context);

    void openCart();

    boolean openH5OrderSummary(String str, boolean z);

    boolean openOrderDetail(String str, String str2);

    void openProductPage(String str);

    void removeAddressListAndSavedAddress(Activity activity);

    void removeProductIdFromWishList(Context context, String str, CLPNetworkService.Callback<com.paytmmall.clpartifact.modal.wishList.WishList> callback);

    void removeRecentSearchByIndex(Context context, int i2);

    void requestwishlist(Context context);

    String saveCartJson(Context context, String str);

    void saveSearchResponse(Context context, String str);

    void sendLocationServiceResult(Activity activity);

    void sendScanResult(Context context, int i2, int i3, Bundle bundle);

    void setGaJSON(Context context, HashMap<String, Object> hashMap);

    void setSavedAddress(Context context, String str);

    void setSavedAddressListResponse(Context context, String str);

    void setSmartLink(String str);

    void setWishList(Context context);

    void updateCartCache(Context context, String str);
}
