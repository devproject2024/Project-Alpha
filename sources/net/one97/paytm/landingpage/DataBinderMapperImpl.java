package net.one97.paytm.landingpage;

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
        static final HashMap<String, Integer> f52637a = new HashMap<>(0);
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
        if (str == null || (num = b.f52637a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f52636a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.paytmmall.clpartifact.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.nativesdk.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.wallet.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f52636a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(92);
            f52636a = sparseArray;
            sparseArray.put(0, "_all");
            f52636a.put(1, "emiViewModel");
            f52636a.put(2, "instrumentSheetViewModel");
            f52636a.put(3, "section");
            f52636a.put(4, "transcationViewModel");
            f52636a.put(5, "allNetBankingViewModel");
            f52636a.put(6, "bankMandateIfscCodeViewModel");
            f52636a.put(7, "codViewModel");
            f52636a.put(8, "view");
            f52636a.put(9, "netBankingViewModel");
            f52636a.put(10, "netbanking");
            f52636a.put(11, "saveCardModel");
            f52636a.put(12, "model");
            f52636a.put(13, "showInstrumentInfoMsg");
            f52636a.put(14, "a");
            f52636a.put(15, "otpViewholder");
            f52636a.put(16, "pincvvmodel");
            f52636a.put(17, "bank_mandate");
            f52636a.put(18, "debitCardModel");
            f52636a.put(19, "selectedInstrumentSheetViewModel");
            f52636a.put(20, "typeface");
            f52636a.put(21, "aoaWalletViewModel");
            f52636a.put(22, "bankViewModel");
            f52636a.put(23, "landingPageViewModel");
            f52636a.put(24, "walletViewModel");
            f52636a.put(25, "digitalCreditModel");
            f52636a.put(26, "cvvHelpModel");
            f52636a.put(27, "bankMandateSubDetailsViewModel");
            f52636a.put(28, "upiHelpModel");
            f52636a.put(29, "upiCollectModel");
            f52636a.put(30, "handler");
            f52636a.put(31, "slider");
            f52636a.put(32, "isCollapsed");
            f52636a.put(33, "rating");
            f52636a.put(34, "showMoreVisibility");
            f52636a.put(35, "type");
            f52636a.put(36, "showRating");
            f52636a.put(37, "levelToRateCount");
            f52636a.put(38, "id");
            f52636a.put(39, "badgeText");
            f52636a.put(40, "totalReview");
            f52636a.put(41, "item");
            f52636a.put(42, "adapter");
            f52636a.put(43, "reviewDetail");
            f52636a.put(44, "showWishListIcon");
            f52636a.put(45, "ratingModel");
            f52636a.put(46, "entityType");
            f52636a.put(47, "totalRatings");
            f52636a.put(48, "ratingTotal");
            f52636a.put(49, "iSCOLLAPSED");
            f52636a.put(50, "starNumber");
            f52636a.put(51, "offerTag");
            f52636a.put(52, "badgeImageUrl");
            f52636a.put(53, "notificationActive");
            f52636a.put(54, "subCashback");
            f52636a.put(55, "following");
            f52636a.put(56, "name");
            f52636a.put(57, "tickerText");
            f52636a.put(58, "viewModel");
            f52636a.put(59, CLPConstants.ARGUMENT_KEY_POSITION);
            f52636a.put(60, "clickHandler");
            f52636a.put(61, "groupAdapter");
            f52636a.put(62, "dataModel");
            f52636a.put(63, "title");
            f52636a.put(64, "reviewDate");
            f52636a.put(65, "imageUrl");
            f52636a.put(66, "isSelected");
            f52636a.put(67, "isApplied");
            f52636a.put(68, "avgRating");
            f52636a.put(69, "IS_COLLAPSED");
            f52636a.put(70, "redirect");
            f52636a.put(71, "product");
            f52636a.put(72, "holder");
            f52636a.put(73, "label");
            f52636a.put(74, "clickhandler");
            f52636a.put(75, "cashback");
            f52636a.put(76, "entityIdentifier");
            f52636a.put(77, "pagerIndicatorVisibility");
            f52636a.put(78, "fragment");
            f52636a.put(79, "seourl");
            f52636a.put(80, "isWishListed");
            f52636a.put(81, "initialFrom");
            f52636a.put(82, "layoutManager");
            f52636a.put(83, "dialogDataModel");
            f52636a.put(84, "showSeparation");
            f52636a.put(85, "showPrice");
            f52636a.put(86, "showRatingBar");
            f52636a.put(87, "initialTo");
            f52636a.put(88, "category");
            f52636a.put(89, "defaultItemData");
            f52636a.put(90, "ratingData");
        }
    }
}
