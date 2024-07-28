package net.one97.paytm.wallet;

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
        static final HashMap<String, Integer> f69837a = new HashMap<>(0);
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
        if (str == null || (num = b.f69837a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f69836a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.paytmmall.clpartifact.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.nativesdk.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f69836a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(84);
            f69836a = sparseArray;
            sparseArray.put(0, "_all");
            f69836a.put(1, "emiViewModel");
            f69836a.put(2, "instrumentSheetViewModel");
            f69836a.put(3, "section");
            f69836a.put(4, "transcationViewModel");
            f69836a.put(5, "allNetBankingViewModel");
            f69836a.put(6, "codViewModel");
            f69836a.put(7, "view");
            f69836a.put(8, "netBankingViewModel");
            f69836a.put(9, "netbanking");
            f69836a.put(10, "saveCardModel");
            f69836a.put(11, "model");
            f69836a.put(12, "showInstrumentInfoMsg");
            f69836a.put(13, "a");
            f69836a.put(14, "otpViewholder");
            f69836a.put(15, "pincvvmodel");
            f69836a.put(16, "debitCardModel");
            f69836a.put(17, "selectedInstrumentSheetViewModel");
            f69836a.put(18, "typeface");
            f69836a.put(19, "aoaWalletViewModel");
            f69836a.put(20, "bankViewModel");
            f69836a.put(21, "landingPageViewModel");
            f69836a.put(22, "walletViewModel");
            f69836a.put(23, "digitalCreditModel");
            f69836a.put(24, "cvvHelpModel");
            f69836a.put(25, "upiHelpModel");
            f69836a.put(26, "upiCollectModel");
            f69836a.put(27, "handler");
            f69836a.put(28, "slider");
            f69836a.put(29, "isCollapsed");
            f69836a.put(30, "rating");
            f69836a.put(31, "type");
            f69836a.put(32, "showRating");
            f69836a.put(33, "levelToRateCount");
            f69836a.put(34, "id");
            f69836a.put(35, "badgeText");
            f69836a.put(36, "totalReview");
            f69836a.put(37, "item");
            f69836a.put(38, "adapter");
            f69836a.put(39, "reviewDetail");
            f69836a.put(40, "ratingModel");
            f69836a.put(41, "entityType");
            f69836a.put(42, "totalRatings");
            f69836a.put(43, "ratingTotal");
            f69836a.put(44, "iSCOLLAPSED");
            f69836a.put(45, "starNumber");
            f69836a.put(46, "offerTag");
            f69836a.put(47, "badgeImageUrl");
            f69836a.put(48, "subCashback");
            f69836a.put(49, "following");
            f69836a.put(50, "name");
            f69836a.put(51, "tickerText");
            f69836a.put(52, "viewModel");
            f69836a.put(53, CLPConstants.ARGUMENT_KEY_POSITION);
            f69836a.put(54, "clickHandler");
            f69836a.put(55, "groupAdapter");
            f69836a.put(56, "dataModel");
            f69836a.put(57, "title");
            f69836a.put(58, "reviewDate");
            f69836a.put(59, "imageUrl");
            f69836a.put(60, "isApplied");
            f69836a.put(61, "avgRating");
            f69836a.put(62, "IS_COLLAPSED");
            f69836a.put(63, "redirect");
            f69836a.put(64, "product");
            f69836a.put(65, "holder");
            f69836a.put(66, "label");
            f69836a.put(67, "clickhandler");
            f69836a.put(68, "cashback");
            f69836a.put(69, "entityIdentifier");
            f69836a.put(70, "pagerIndicatorVisibility");
            f69836a.put(71, "fragment");
            f69836a.put(72, "seourl");
            f69836a.put(73, "isWishListed");
            f69836a.put(74, "initialFrom");
            f69836a.put(75, "layoutManager");
            f69836a.put(76, "dialogDataModel");
            f69836a.put(77, "showSeparation");
            f69836a.put(78, "showPrice");
            f69836a.put(79, "showRatingBar");
            f69836a.put(80, "initialTo");
            f69836a.put(81, "defaultItemData");
            f69836a.put(82, "ratingData");
        }
    }
}
