package net.one97.paytm.acceptPayment;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.acceptPayment.a.f;
import net.one97.paytm.acceptPayment.a.h;
import net.one97.paytm.acceptPayment.a.j;
import net.one97.paytm.acceptPayment.a.l;
import net.one97.paytm.acceptPayment.a.n;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACCEPTPAYMENTINIT = 1;
    private static final int LAYOUT_ACCEPTPAYMENTMERCHANTSETTINGS = 2;
    private static final int LAYOUT_APACCEPTPAYMENTMAIN = 3;
    private static final int LAYOUT_APACTIONBARLYT = 4;
    private static final int LAYOUT_APFRAGMENT = 5;
    private static final int LAYOUT_APFRAGMENTSTOREFRONT = 6;
    private static final int LAYOUT_JSWEBKITWEBVIEW = 7;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(7);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.accept_payment_init, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.accept_payment_merchant_settings, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.ap_accept_payment_main, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.ap_action_bar_lyt, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.ap_fragment, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.ap_fragment_store_front, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.js_webkit_webview, 7);
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        int i3 = INTERNAL_LAYOUT_ID_LOOKUP.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i3) {
                case 1:
                    if ("layout/accept_payment_init_0".equals(tag)) {
                        return new net.one97.paytm.acceptPayment.a.b(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for accept_payment_init is invalid. Received: ".concat(String.valueOf(tag)));
                case 2:
                    if ("layout/accept_payment_merchant_settings_0".equals(tag)) {
                        return new net.one97.paytm.acceptPayment.a.d(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for accept_payment_merchant_settings is invalid. Received: ".concat(String.valueOf(tag)));
                case 3:
                    if ("layout/ap_accept_payment_main_0".equals(tag)) {
                        return new f(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for ap_accept_payment_main is invalid. Received: ".concat(String.valueOf(tag)));
                case 4:
                    if ("layout/ap_action_bar_lyt_0".equals(tag)) {
                        return new h(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for ap_action_bar_lyt is invalid. Received: ".concat(String.valueOf(tag)));
                case 5:
                    if ("layout/ap_fragment_0".equals(tag)) {
                        return new j(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for ap_fragment is invalid. Received: ".concat(String.valueOf(tag)));
                case 6:
                    if ("layout/ap_fragment_store_front_0".equals(tag)) {
                        return new l(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for ap_fragment_store_front is invalid. Received: ".concat(String.valueOf(tag)));
                case 7:
                    if ("layout/js_webkit_webview_0".equals(tag)) {
                        return new n(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for js_webkit_webview is invalid. Received: ".concat(String.valueOf(tag)));
                default:
                    return null;
            }
        } else {
            throw new RuntimeException("view must have a tag");
        }
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f51965a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f51964a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.business.merchant_payments.DataBinderMapperImpl());
        arrayList.add(new com.paytm.business.merchantprofile.DataBinderMapperImpl());
        arrayList.add(new com.paytmmall.clpartifact.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f51964a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(96);
            f51964a = sparseArray;
            sparseArray.put(1, "IS_COLLAPSED");
            f51964a.put(0, "_all");
            f51964a.put(2, "adapter");
            f51964a.put(3, "audioAlertView");
            f51964a.put(4, "avgRating");
            f51964a.put(5, "backButtonClick");
            f51964a.put(6, "badgeImageUrl");
            f51964a.put(7, "badgeText");
            f51964a.put(8, "bindingUtils");
            f51964a.put(9, "cashback");
            f51964a.put(10, "checkChangeListener");
            f51964a.put(11, "clickHandler");
            f51964a.put(12, "clickhandler");
            f51964a.put(13, "data");
            f51964a.put(14, "dataModel");
            f51964a.put(15, "defaultItemData");
            f51964a.put(16, "dialogDataModel");
            f51964a.put(17, "embedWebViewViewModel");
            f51964a.put(18, "entityIdentifier");
            f51964a.put(19, "entityType");
            f51964a.put(20, "following");
            f51964a.put(21, "fragment");
            f51964a.put(22, "groupAdapter");
            f51964a.put(23, "handler");
            f51964a.put(24, "holder");
            f51964a.put(25, "iSCOLLAPSED");
            f51964a.put(26, H5Param.MENU_ICON);
            f51964a.put(27, "id");
            f51964a.put(28, "imageUrl");
            f51964a.put(29, "initialFrom");
            f51964a.put(30, "initialTo");
            f51964a.put(31, "initiateRefundViewModel");
            f51964a.put(32, "isApplied");
            f51964a.put(33, "isChecked");
            f51964a.put(34, "isCollapsed");
            f51964a.put(35, "isNegativeBtnVisible");
            f51964a.put(36, "isSelected");
            f51964a.put(37, "isTitleVisible");
            f51964a.put(38, "isWishListed");
            f51964a.put(39, "item");
            f51964a.put(40, "itemColor");
            f51964a.put(41, "label");
            f51964a.put(42, "layoutManager");
            f51964a.put(43, "levelToRateCount");
            f51964a.put(44, "listener");
            f51964a.put(45, "mChannelsViewModel");
            f51964a.put(46, "mTitle");
            f51964a.put(47, "message");
            f51964a.put(48, "model");
            f51964a.put(49, "modelData");
            f51964a.put(50, "msg");
            f51964a.put(51, "name");
            f51964a.put(52, "negativeText");
            f51964a.put(53, "noNetworkViewModel");
            f51964a.put(54, "notificationActive");
            f51964a.put(55, "offerTag");
            f51964a.put(56, "onClickAction");
            f51964a.put(57, "onNegativeClick");
            f51964a.put(58, "onPositiveClick");
            f51964a.put(59, "pagerIndicatorVisibility");
            f51964a.put(60, "parentViewModel");
            f51964a.put(61, CLPConstants.ARGUMENT_KEY_POSITION);
            f51964a.put(62, "positiveText");
            f51964a.put(63, "primaryViewVisibility");
            f51964a.put(64, "product");
            f51964a.put(65, "rating");
            f51964a.put(66, "ratingData");
            f51964a.put(67, "ratingModel");
            f51964a.put(68, "ratingTotal");
            f51964a.put(69, "receiver");
            f51964a.put(70, "redirect");
            f51964a.put(71, "refundDetailsViewModel");
            f51964a.put(72, "refundInitiatedViewModel");
            f51964a.put(73, "removeButtonVisibility");
            f51964a.put(74, "reviewDate");
            f51964a.put(75, "reviewDetail");
            f51964a.put(76, "seourl");
            f51964a.put(77, "showPrice");
            f51964a.put(78, "showRating");
            f51964a.put(79, "showRatingBar");
            f51964a.put(80, "showSeparation");
            f51964a.put(81, "showVerifyQrPopup");
            f51964a.put(82, "showWishListIcon");
            f51964a.put(83, "slider");
            f51964a.put(84, "starNumber");
            f51964a.put(85, "subCashback");
            f51964a.put(86, "subtitle");
            f51964a.put(87, "tickerText");
            f51964a.put(88, "title");
            f51964a.put(89, "totalRatings");
            f51964a.put(90, "totalReview");
            f51964a.put(91, "type");
            f51964a.put(92, "view");
            f51964a.put(93, "viewModel");
            f51964a.put(94, "viewmodel");
            f51964a.put(95, "vm");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f51965a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(7);
            f51965a = hashMap;
            hashMap.put("layout/accept_payment_init_0", Integer.valueOf(R.layout.accept_payment_init));
            f51965a.put("layout/accept_payment_merchant_settings_0", Integer.valueOf(R.layout.accept_payment_merchant_settings));
            f51965a.put("layout/ap_accept_payment_main_0", Integer.valueOf(R.layout.ap_accept_payment_main));
            f51965a.put("layout/ap_action_bar_lyt_0", Integer.valueOf(R.layout.ap_action_bar_lyt));
            f51965a.put("layout/ap_fragment_0", Integer.valueOf(R.layout.ap_fragment));
            f51965a.put("layout/ap_fragment_store_front_0", Integer.valueOf(R.layout.ap_fragment_store_front));
            f51965a.put("layout/js_webkit_webview_0", Integer.valueOf(R.layout.js_webkit_webview));
        }
    }
}
