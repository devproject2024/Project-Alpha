package net.one97.paytm.dynamic.module.feed;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

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
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return InnerBrLookup.sKeys.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new net.one97.paytm.feed.DataBinderMapperImpl());
        return arrayList;
    }

    static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(121);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sKeys.put(44, "emiViewModel");
            sKeys.put(45, "instrumentSheetViewModel");
            sKeys.put(46, "section");
            sKeys.put(47, "transcationViewModel");
            sKeys.put(48, "allNetBankingViewModel");
            sKeys.put(49, "bankMandateIfscCodeViewModel");
            sKeys.put(50, "codViewModel");
            sKeys.put(51, "view");
            sKeys.put(52, "netBankingViewModel");
            sKeys.put(53, "netbanking");
            sKeys.put(39, "saveCardModel");
            sKeys.put(19, "model");
            sKeys.put(54, "showInstrumentInfoMsg");
            sKeys.put(55, "a");
            sKeys.put(56, "otpViewholder");
            sKeys.put(57, "pincvvmodel");
            sKeys.put(58, "bank_mandate");
            sKeys.put(59, "debitCardModel");
            sKeys.put(60, "selectedInstrumentSheetViewModel");
            sKeys.put(61, "typeface");
            sKeys.put(62, "aoaWalletViewModel");
            sKeys.put(63, "bankViewModel");
            sKeys.put(64, "landingPageViewModel");
            sKeys.put(65, "walletViewModel");
            sKeys.put(66, "digitalCreditModel");
            sKeys.put(41, "cvvHelpModel");
            sKeys.put(67, "bankMandateSubDetailsViewModel");
            sKeys.put(68, "upiHelpModel");
            sKeys.put(69, "upiCollectModel");
            sKeys.put(72, "handler");
            sKeys.put(73, "slider");
            sKeys.put(74, "isCollapsed");
            sKeys.put(75, "rating");
            sKeys.put(76, "showMoreVisibility");
            sKeys.put(8, "type");
            sKeys.put(77, "showRating");
            sKeys.put(78, "levelToRateCount");
            sKeys.put(79, "id");
            sKeys.put(80, "badgeText");
            sKeys.put(81, "totalReview");
            sKeys.put(82, "item");
            sKeys.put(20, "adapter");
            sKeys.put(83, "reviewDetail");
            sKeys.put(84, "showWishListIcon");
            sKeys.put(85, "ratingModel");
            sKeys.put(86, "entityType");
            sKeys.put(87, "totalRatings");
            sKeys.put(88, "ratingTotal");
            sKeys.put(89, "iSCOLLAPSED");
            sKeys.put(90, "starNumber");
            sKeys.put(91, "offerTag");
            sKeys.put(92, "badgeImageUrl");
            sKeys.put(93, "notificationActive");
            sKeys.put(94, "subCashback");
            sKeys.put(95, "following");
            sKeys.put(96, "name");
            sKeys.put(97, "tickerText");
            sKeys.put(33, "viewModel");
            sKeys.put(35, CLPConstants.ARGUMENT_KEY_POSITION);
            sKeys.put(98, "clickHandler");
            sKeys.put(99, "groupAdapter");
            sKeys.put(5, "dataModel");
            sKeys.put(9, "title");
            sKeys.put(100, "reviewDate");
            sKeys.put(101, "imageUrl");
            sKeys.put(102, "isSelected");
            sKeys.put(103, "isApplied");
            sKeys.put(104, "avgRating");
            sKeys.put(105, "IS_COLLAPSED");
            sKeys.put(106, "redirect");
            sKeys.put(107, "product");
            sKeys.put(108, "holder");
            sKeys.put(109, "label");
            sKeys.put(110, "clickhandler");
            sKeys.put(111, "cashback");
            sKeys.put(112, "entityIdentifier");
            sKeys.put(113, "pagerIndicatorVisibility");
            sKeys.put(114, "fragment");
            sKeys.put(115, "seourl");
            sKeys.put(116, "isWishListed");
            sKeys.put(117, "initialFrom");
            sKeys.put(118, "layoutManager");
            sKeys.put(119, "dialogDataModel");
            sKeys.put(120, "showSeparation");
            sKeys.put(121, "showPrice");
            sKeys.put(122, "showRatingBar");
            sKeys.put(123, "initialTo");
            sKeys.put(124, "category");
            sKeys.put(125, "defaultItemData");
            sKeys.put(126, "ratingData");
            sKeys.put(8060928, "data");
            sKeys.put(8060929, "viewAllUrl");
            sKeys.put(8060930, "bg");
            sKeys.put(8060931, "listener");
            sKeys.put(8060932, CLConstants.FIELD_ERROR_CODE);
            sKeys.put(8060933, "update");
            sKeys.put(8060934, "source");
            sKeys.put(8060935, "error");
            sKeys.put(8060936, "empty");
            sKeys.put(8060937, "storyCardPosition");
            sKeys.put(8060938, "actionsViewModel");
            sKeys.put(8060939, "blocked");
            sKeys.put(8060940, "feedCommentViewModel");
            sKeys.put(BR.loggedin, "loggedin");
            sKeys.put(8060942, "isKenburn");
            sKeys.put(8060943, "progressVisibility");
            sKeys.put(8060944, "pipe");
            sKeys.put(8060945, "messageToSend");
            sKeys.put(8060946, "vote");
            sKeys.put(8060947, "messageEmpty");
            sKeys.put(8060948, "feedViewModel");
            sKeys.put(8060949, "visibility");
            sKeys.put(8060950, "commentactivity");
            sKeys.put(8060951, "sensitive");
            sKeys.put(8060952, "url");
            sKeys.put(8060953, "merchantStoreFrontViewModel");
            sKeys.put(8060954, H5Logger.HEADER);
            sKeys.put(8060955, "feedhidden");
            sKeys.put(8060956, "handlerComment");
        }
    }

    static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys = new HashMap<>(0);

        private InnerLayoutIdLookup() {
        }
    }
}
