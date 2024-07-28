package net.one97.paytm;

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
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.g.f;
import net.one97.paytm.g.h;
import net.one97.paytm.g.j;
import net.one97.paytm.g.l;
import net.one97.paytm.paytm_finance.R;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_FRAGMENTDYNAMICMODULELOADER = 1;
    private static final int LAYOUT_FRAGMENTDYNAMICMODULELOADERBOTTOMSHEET = 2;
    private static final int LAYOUT_MULTIPLEITEMDYNAMICMODULELOADER = 3;
    private static final int LAYOUT_SINGLEITEMDYNAMICMODULELOADER = 4;
    private static final int LAYOUT_SINGLEITEMFULLSCREENDYNAMICMODULELOADER = 5;
    private static final int LAYOUT_VISADISABLEONECLICKBSDIALOG = 6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(6);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.fragment_dynamic_module_loader, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_dynamic_module_loader_bottomsheet, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.multiple_item_dynamic_module_loader, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.single_item_dynamic_module_loader, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.single_item_fullscreen_dynamic_module_loader, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.visa_disable_one_click_bs_dialog, 6);
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
                    if ("layout/fragment_dynamic_module_loader_0".equals(tag)) {
                        return new net.one97.paytm.g.b(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_dynamic_module_loader is invalid. Received: ".concat(String.valueOf(tag)));
                case 2:
                    if ("layout/fragment_dynamic_module_loader_bottomsheet_0".equals(tag)) {
                        return new net.one97.paytm.g.d(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_dynamic_module_loader_bottomsheet is invalid. Received: ".concat(String.valueOf(tag)));
                case 3:
                    if ("layout/multiple_item_dynamic_module_loader_0".equals(tag)) {
                        return new f(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for multiple_item_dynamic_module_loader is invalid. Received: ".concat(String.valueOf(tag)));
                case 4:
                    if ("layout/single_item_dynamic_module_loader_0".equals(tag)) {
                        return new h(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for single_item_dynamic_module_loader is invalid. Received: ".concat(String.valueOf(tag)));
                case 5:
                    if ("layout/single_item_fullscreen_dynamic_module_loader_0".equals(tag)) {
                        return new j(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for single_item_fullscreen_dynamic_module_loader is invalid. Received: ".concat(String.valueOf(tag)));
                case 6:
                    if ("layout/visa_disable_one_click_bs_dialog_0".equals(tag)) {
                        return new l(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for visa_disable_one_click_bs_dialog is invalid. Received: ".concat(String.valueOf(tag)));
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
        if (str == null || (num = b.f51825a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f51824a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(15);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.business.merchant_payments.DataBinderMapperImpl());
        arrayList.add(new com.paytm.business.merchantprofile.DataBinderMapperImpl());
        arrayList.add(new com.paytmmall.clpartifact.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.acceptPayment.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.addmoney.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.landingpage.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.moneytransfer.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.nativesdk.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.p2b.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.prime.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.recharge.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.upgradeKyc.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.wallet.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f51824a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(133);
            f51824a = sparseArray;
            sparseArray.put(0, "_all");
            f51824a.put(1, "msg");
            f51824a.put(2, "itemColor");
            f51824a.put(3, "listener");
            f51824a.put(4, "parentViewModel");
            f51824a.put(5, "dataModel");
            f51824a.put(6, H5Param.MENU_ICON);
            f51824a.put(7, "primaryViewVisibility");
            f51824a.put(8, "type");
            f51824a.put(9, "title");
            f51824a.put(10, "onPositiveClick");
            f51824a.put(11, "removeButtonVisibility");
            f51824a.put(12, "onClickAction");
            f51824a.put(13, "negativeText");
            f51824a.put(14, "modelData");
            f51824a.put(15, "audioAlertView");
            f51824a.put(16, "noNetworkViewModel");
            f51824a.put(17, "showVerifyQrPopup");
            f51824a.put(18, "isNegativeBtnVisible");
            f51824a.put(19, "model");
            f51824a.put(20, "adapter");
            f51824a.put(21, "checkChangeListener");
            f51824a.put(22, "receiver");
            f51824a.put(23, "viewmodel");
            f51824a.put(24, "bindingUtils");
            f51824a.put(25, "refundInitiatedViewModel");
            f51824a.put(26, "message");
            f51824a.put(27, "isChecked");
            f51824a.put(28, "initiateRefundViewModel");
            f51824a.put(29, "isTitleVisible");
            f51824a.put(30, "onNegativeClick");
            f51824a.put(31, "subtitle");
            f51824a.put(32, "embedWebViewViewModel");
            f51824a.put(33, "viewModel");
            f51824a.put(34, "mTitle");
            f51824a.put(35, CLPConstants.ARGUMENT_KEY_POSITION);
            f51824a.put(36, "positiveText");
            f51824a.put(37, "refundDetailsViewModel");
            f51824a.put(38, "backButtonClick");
            f51824a.put(39, "saveCardModel");
            f51824a.put(40, "state");
            f51824a.put(41, "cvvHelpModel");
            f51824a.put(42, "mChannelsViewModel");
            f51824a.put(43, "vm");
            f51824a.put(44, "emiViewModel");
            f51824a.put(45, "instrumentSheetViewModel");
            f51824a.put(46, "section");
            f51824a.put(47, "transcationViewModel");
            f51824a.put(48, "allNetBankingViewModel");
            f51824a.put(49, "bankMandateIfscCodeViewModel");
            f51824a.put(50, "codViewModel");
            f51824a.put(51, "view");
            f51824a.put(52, "netBankingViewModel");
            f51824a.put(53, "netbanking");
            f51824a.put(54, "showInstrumentInfoMsg");
            f51824a.put(55, "a");
            f51824a.put(56, "otpViewholder");
            f51824a.put(57, "pincvvmodel");
            f51824a.put(58, "bank_mandate");
            f51824a.put(59, "debitCardModel");
            f51824a.put(60, "selectedInstrumentSheetViewModel");
            f51824a.put(61, "typeface");
            f51824a.put(62, "aoaWalletViewModel");
            f51824a.put(63, "bankViewModel");
            f51824a.put(64, "landingPageViewModel");
            f51824a.put(65, "walletViewModel");
            f51824a.put(66, "digitalCreditModel");
            f51824a.put(67, "bankMandateSubDetailsViewModel");
            f51824a.put(68, "upiHelpModel");
            f51824a.put(69, "upiCollectModel");
            f51824a.put(70, "isViewAll");
            f51824a.put(71, "data");
            f51824a.put(72, "handler");
            f51824a.put(73, "slider");
            f51824a.put(74, "isCollapsed");
            f51824a.put(75, "rating");
            f51824a.put(76, "showMoreVisibility");
            f51824a.put(77, "showRating");
            f51824a.put(78, "levelToRateCount");
            f51824a.put(79, "id");
            f51824a.put(80, "badgeText");
            f51824a.put(81, "totalReview");
            f51824a.put(82, "item");
            f51824a.put(83, "reviewDetail");
            f51824a.put(84, "showWishListIcon");
            f51824a.put(85, "ratingModel");
            f51824a.put(86, "entityType");
            f51824a.put(87, "totalRatings");
            f51824a.put(88, "ratingTotal");
            f51824a.put(89, "iSCOLLAPSED");
            f51824a.put(90, "starNumber");
            f51824a.put(91, "offerTag");
            f51824a.put(92, "badgeImageUrl");
            f51824a.put(93, "notificationActive");
            f51824a.put(94, "subCashback");
            f51824a.put(95, "following");
            f51824a.put(96, "name");
            f51824a.put(97, "tickerText");
            f51824a.put(98, "clickHandler");
            f51824a.put(99, "groupAdapter");
            f51824a.put(100, "reviewDate");
            f51824a.put(101, "imageUrl");
            f51824a.put(102, "isSelected");
            f51824a.put(103, "isApplied");
            f51824a.put(104, "avgRating");
            f51824a.put(105, "IS_COLLAPSED");
            f51824a.put(106, "redirect");
            f51824a.put(107, "product");
            f51824a.put(108, "holder");
            f51824a.put(109, "label");
            f51824a.put(110, "clickhandler");
            f51824a.put(111, "cashback");
            f51824a.put(112, "entityIdentifier");
            f51824a.put(113, "pagerIndicatorVisibility");
            f51824a.put(114, "fragment");
            f51824a.put(115, "seourl");
            f51824a.put(116, "isWishListed");
            f51824a.put(117, "initialFrom");
            f51824a.put(118, "layoutManager");
            f51824a.put(119, "dialogDataModel");
            f51824a.put(120, "showSeparation");
            f51824a.put(121, "showPrice");
            f51824a.put(122, "showRatingBar");
            f51824a.put(123, "initialTo");
            f51824a.put(124, "category");
            f51824a.put(125, "defaultItemData");
            f51824a.put(126, "ratingData");
            f51824a.put(127, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            f51824a.put(128, "payAmount");
            f51824a.put(129, "history");
            f51824a.put(130, "statusColorCode");
            f51824a.put(131, "payStatus");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f51825a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(6);
            f51825a = hashMap;
            hashMap.put("layout/fragment_dynamic_module_loader_0", Integer.valueOf(R.layout.fragment_dynamic_module_loader));
            f51825a.put("layout/fragment_dynamic_module_loader_bottomsheet_0", Integer.valueOf(R.layout.fragment_dynamic_module_loader_bottomsheet));
            f51825a.put("layout/multiple_item_dynamic_module_loader_0", Integer.valueOf(R.layout.multiple_item_dynamic_module_loader));
            f51825a.put("layout/single_item_dynamic_module_loader_0", Integer.valueOf(R.layout.single_item_dynamic_module_loader));
            f51825a.put("layout/single_item_fullscreen_dynamic_module_loader_0", Integer.valueOf(R.layout.single_item_fullscreen_dynamic_module_loader));
            f51825a.put("layout/visa_disable_one_click_bs_dialog_0", Integer.valueOf(R.layout.visa_disable_one_click_bs_dialog));
        }
    }
}
