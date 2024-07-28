package com.travel.train;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f25785a = new HashMap<>(0);
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        if (INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f25785a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f25784a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.paytmmall.clpartifact.DataBinderMapperImpl());
        arrayList.add(new com.travel.common.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.nativesdk.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f25784a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(92);
            f25784a = sparseArray;
            sparseArray.put(0, "_all");
            f25784a.put(1, "emiViewModel");
            f25784a.put(2, "instrumentSheetViewModel");
            f25784a.put(3, "section");
            f25784a.put(4, "transcationViewModel");
            f25784a.put(5, "allNetBankingViewModel");
            f25784a.put(6, "bankMandateIfscCodeViewModel");
            f25784a.put(7, "codViewModel");
            f25784a.put(8, "view");
            f25784a.put(9, "netBankingViewModel");
            f25784a.put(10, "netbanking");
            f25784a.put(11, "saveCardModel");
            f25784a.put(12, "model");
            f25784a.put(13, "showInstrumentInfoMsg");
            f25784a.put(14, "a");
            f25784a.put(15, "otpViewholder");
            f25784a.put(16, "pincvvmodel");
            f25784a.put(17, "bank_mandate");
            f25784a.put(18, "debitCardModel");
            f25784a.put(19, "selectedInstrumentSheetViewModel");
            f25784a.put(20, "typeface");
            f25784a.put(21, "aoaWalletViewModel");
            f25784a.put(22, "bankViewModel");
            f25784a.put(23, "landingPageViewModel");
            f25784a.put(24, "walletViewModel");
            f25784a.put(25, "digitalCreditModel");
            f25784a.put(26, "cvvHelpModel");
            f25784a.put(27, "bankMandateSubDetailsViewModel");
            f25784a.put(28, "upiHelpModel");
            f25784a.put(29, "upiCollectModel");
            f25784a.put(30, "handler");
            f25784a.put(31, "slider");
            f25784a.put(32, "isCollapsed");
            f25784a.put(33, "rating");
            f25784a.put(34, "showMoreVisibility");
            f25784a.put(35, "type");
            f25784a.put(36, "showRating");
            f25784a.put(37, "levelToRateCount");
            f25784a.put(38, "id");
            f25784a.put(39, "badgeText");
            f25784a.put(40, "totalReview");
            f25784a.put(41, "item");
            f25784a.put(42, "adapter");
            f25784a.put(43, "reviewDetail");
            f25784a.put(44, "showWishListIcon");
            f25784a.put(45, "ratingModel");
            f25784a.put(46, "entityType");
            f25784a.put(47, "totalRatings");
            f25784a.put(48, "ratingTotal");
            f25784a.put(49, "iSCOLLAPSED");
            f25784a.put(50, "starNumber");
            f25784a.put(51, "offerTag");
            f25784a.put(52, "badgeImageUrl");
            f25784a.put(53, "notificationActive");
            f25784a.put(54, "subCashback");
            f25784a.put(55, "following");
            f25784a.put(56, "name");
            f25784a.put(57, "tickerText");
            f25784a.put(58, "viewModel");
            f25784a.put(59, CLPConstants.ARGUMENT_KEY_POSITION);
            f25784a.put(60, "clickHandler");
            f25784a.put(61, "groupAdapter");
            f25784a.put(62, "dataModel");
            f25784a.put(63, "title");
            f25784a.put(64, "reviewDate");
            f25784a.put(65, "imageUrl");
            f25784a.put(66, "isSelected");
            f25784a.put(67, "isApplied");
            f25784a.put(68, "avgRating");
            f25784a.put(69, "IS_COLLAPSED");
            f25784a.put(70, "redirect");
            f25784a.put(71, "product");
            f25784a.put(72, "holder");
            f25784a.put(73, "label");
            f25784a.put(74, "clickhandler");
            f25784a.put(75, "cashback");
            f25784a.put(76, "entityIdentifier");
            f25784a.put(77, "pagerIndicatorVisibility");
            f25784a.put(78, "fragment");
            f25784a.put(79, "seourl");
            f25784a.put(80, "isWishListed");
            f25784a.put(81, "initialFrom");
            f25784a.put(82, "layoutManager");
            f25784a.put(83, "dialogDataModel");
            f25784a.put(84, "showSeparation");
            f25784a.put(85, "showPrice");
            f25784a.put(86, "showRatingBar");
            f25784a.put(87, "initialTo");
            f25784a.put(88, "category");
            f25784a.put(89, "defaultItemData");
            f25784a.put(90, "ratingData");
        }
    }
}
