package net.one97.paytm.recharge;

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
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.recharge.b.f;
import net.one97.paytm.recharge.b.h;
import net.one97.paytm.recharge.b.j;
import net.one97.paytm.recharge.b.l;
import net.one97.paytm.recharge.b.n;
import net.one97.paytm.recharge.b.p;
import net.one97.paytm.recharge.b.r;
import net.one97.paytm.recharge.b.t;
import net.one97.paytm.recharge.b.v;
import net.one97.paytm.recharge.b.x;
import net.one97.paytm.recharge.b.z;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYRECHARGEMYPAYMENTSHISTORY = 1;
    private static final int LAYOUT_ALERTITEM = 2;
    private static final int LAYOUT_APSCITEM = 3;
    private static final int LAYOUT_AUTOMATICSUBSCRIPTIONHISTORYITEM = 4;
    private static final int LAYOUT_CONTENTRECHARGEMYPAYMENTHISTORYITEM = 5;
    private static final int LAYOUT_FRAGMENTALERTBOTTOMSHEET = 6;
    private static final int LAYOUT_FRAGMENTBROWSEPLANDETAILBOTTOMSHEET = 7;
    private static final int LAYOUT_FRAGMENTUTILITYAUTOMATICLIST = 8;
    private static final int LAYOUT_UTILITYAUTOMATICLISTITEMADDNEW = 9;
    private static final int LAYOUT_UTILITYAUTOMATICLISTITEMDUEDATE = 10;
    private static final int LAYOUT_UTILITYAUTOMATICLISTITEMHEADER = 11;
    private static final int LAYOUT_UTILITYAUTOMATICLISTITEMLASTBILLPAID = 12;
    private static final int LAYOUT_UTILITYAUTOMATICLISTITEMTOBEGENERATED = 13;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(13);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_recharge_my_payments_history, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.alert_item, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.apsc_item, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.automatic_subscription_history_item, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.content_recharge_my_payment_history_item, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_alert_bottom_sheet, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_browse_plan_detail_bottom_sheet, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_utility_automatic_list, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.utility_automatic_list_item_add_new, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.utility_automatic_list_item_due_date, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.utility_automatic_list_item_header, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.utility_automatic_list_item_last_bill_paid, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.utility_automatic_list_item_to_be_generated, 13);
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
                    if ("layout/activity_recharge_my_payments_history_0".equals(tag)) {
                        return new net.one97.paytm.recharge.b.b(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_recharge_my_payments_history is invalid. Received: ".concat(String.valueOf(tag)));
                case 2:
                    if ("layout/alert_item_0".equals(tag)) {
                        return new net.one97.paytm.recharge.b.d(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for alert_item is invalid. Received: ".concat(String.valueOf(tag)));
                case 3:
                    if ("layout/apsc_item_0".equals(tag)) {
                        return new f(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for apsc_item is invalid. Received: ".concat(String.valueOf(tag)));
                case 4:
                    if ("layout/automatic_subscription_history_item_0".equals(tag)) {
                        return new h(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for automatic_subscription_history_item is invalid. Received: ".concat(String.valueOf(tag)));
                case 5:
                    if ("layout/content_recharge_my_payment_history_item_0".equals(tag)) {
                        return new j(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for content_recharge_my_payment_history_item is invalid. Received: ".concat(String.valueOf(tag)));
                case 6:
                    if ("layout/fragment_alert_bottom_sheet_0".equals(tag)) {
                        return new l(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_alert_bottom_sheet is invalid. Received: ".concat(String.valueOf(tag)));
                case 7:
                    if ("layout/fragment_browse_plan_detail_bottom_sheet_0".equals(tag)) {
                        return new n(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_browse_plan_detail_bottom_sheet is invalid. Received: ".concat(String.valueOf(tag)));
                case 8:
                    if ("layout/fragment_utility_automatic_list_0".equals(tag)) {
                        return new p(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_utility_automatic_list is invalid. Received: ".concat(String.valueOf(tag)));
                case 9:
                    if ("layout/utility_automatic_list_item_add_new_0".equals(tag)) {
                        return new r(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for utility_automatic_list_item_add_new is invalid. Received: ".concat(String.valueOf(tag)));
                case 10:
                    if ("layout/utility_automatic_list_item_due_date_0".equals(tag)) {
                        return new t(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for utility_automatic_list_item_due_date is invalid. Received: ".concat(String.valueOf(tag)));
                case 11:
                    if ("layout/utility_automatic_list_item_header_0".equals(tag)) {
                        return new v(eVar, new View[]{view});
                    }
                    throw new IllegalArgumentException("The tag for utility_automatic_list_item_header is invalid. Received: ".concat(String.valueOf(tag)));
                case 12:
                    if ("layout/utility_automatic_list_item_last_bill_paid_0".equals(tag)) {
                        return new x(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for utility_automatic_list_item_last_bill_paid is invalid. Received: ".concat(String.valueOf(tag)));
                case 13:
                    if ("layout/utility_automatic_list_item_to_be_generated_0".equals(tag)) {
                        return new z(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for utility_automatic_list_item_to_be_generated is invalid. Received: ".concat(String.valueOf(tag)));
                default:
                    return null;
            }
        } else {
            throw new RuntimeException("view must have a tag");
        }
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2) {
        int i3;
        if (!(viewArr == null || viewArr.length == 0 || (i3 = INTERNAL_LAYOUT_ID_LOOKUP.get(i2)) <= 0)) {
            Object tag = viewArr[0].getTag();
            if (tag == null) {
                throw new RuntimeException("view must have a tag");
            } else if (i3 == 11) {
                if ("layout/utility_automatic_list_item_header_0".equals(tag)) {
                    return new v(eVar, viewArr);
                }
                throw new IllegalArgumentException("The tag for utility_automatic_list_item_header is invalid. Received: ".concat(String.valueOf(tag)));
            }
        }
        return null;
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f60179a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f60178a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.paytmmall.clpartifact.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.addmoney.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.nativesdk.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f60178a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(94);
            f60178a = sparseArray;
            sparseArray.put(0, "_all");
            f60178a.put(1, "emiViewModel");
            f60178a.put(2, "instrumentSheetViewModel");
            f60178a.put(3, "section");
            f60178a.put(4, "transcationViewModel");
            f60178a.put(5, "allNetBankingViewModel");
            f60178a.put(6, "codViewModel");
            f60178a.put(7, "view");
            f60178a.put(8, "netBankingViewModel");
            f60178a.put(9, "netbanking");
            f60178a.put(10, "saveCardModel");
            f60178a.put(11, "model");
            f60178a.put(12, "showInstrumentInfoMsg");
            f60178a.put(13, "a");
            f60178a.put(14, "otpViewholder");
            f60178a.put(15, "pincvvmodel");
            f60178a.put(16, "debitCardModel");
            f60178a.put(17, "selectedInstrumentSheetViewModel");
            f60178a.put(18, "typeface");
            f60178a.put(19, "aoaWalletViewModel");
            f60178a.put(20, "bankViewModel");
            f60178a.put(21, "landingPageViewModel");
            f60178a.put(22, "walletViewModel");
            f60178a.put(23, "digitalCreditModel");
            f60178a.put(24, "cvvHelpModel");
            f60178a.put(25, "upiHelpModel");
            f60178a.put(26, "upiCollectModel");
            f60178a.put(27, "viewmodel");
            f60178a.put(28, "viewModel");
            f60178a.put(29, "state");
            f60178a.put(30, "handler");
            f60178a.put(31, "slider");
            f60178a.put(32, "isCollapsed");
            f60178a.put(33, "rating");
            f60178a.put(34, "type");
            f60178a.put(35, "showRating");
            f60178a.put(36, "levelToRateCount");
            f60178a.put(37, "id");
            f60178a.put(38, "badgeText");
            f60178a.put(39, "totalReview");
            f60178a.put(40, "item");
            f60178a.put(41, "adapter");
            f60178a.put(42, "reviewDetail");
            f60178a.put(43, "showWishListIcon");
            f60178a.put(44, "ratingModel");
            f60178a.put(45, "entityType");
            f60178a.put(46, "totalRatings");
            f60178a.put(47, "ratingTotal");
            f60178a.put(48, "iSCOLLAPSED");
            f60178a.put(49, "starNumber");
            f60178a.put(50, "offerTag");
            f60178a.put(51, "badgeImageUrl");
            f60178a.put(52, "notificationActive");
            f60178a.put(53, "subCashback");
            f60178a.put(54, "following");
            f60178a.put(55, "name");
            f60178a.put(56, "tickerText");
            f60178a.put(57, CLPConstants.ARGUMENT_KEY_POSITION);
            f60178a.put(58, "clickHandler");
            f60178a.put(59, "groupAdapter");
            f60178a.put(60, "dataModel");
            f60178a.put(61, "title");
            f60178a.put(62, "reviewDate");
            f60178a.put(63, "imageUrl");
            f60178a.put(64, "isSelected");
            f60178a.put(65, "isApplied");
            f60178a.put(66, "avgRating");
            f60178a.put(67, "IS_COLLAPSED");
            f60178a.put(68, "redirect");
            f60178a.put(69, "product");
            f60178a.put(70, "holder");
            f60178a.put(71, "label");
            f60178a.put(72, "clickhandler");
            f60178a.put(73, "cashback");
            f60178a.put(74, "entityIdentifier");
            f60178a.put(75, "pagerIndicatorVisibility");
            f60178a.put(76, "fragment");
            f60178a.put(77, "seourl");
            f60178a.put(78, "isWishListed");
            f60178a.put(79, "initialFrom");
            f60178a.put(80, "layoutManager");
            f60178a.put(81, "dialogDataModel");
            f60178a.put(82, "showSeparation");
            f60178a.put(83, "showPrice");
            f60178a.put(84, "showRatingBar");
            f60178a.put(85, "initialTo");
            f60178a.put(86, "defaultItemData");
            f60178a.put(87, "ratingData");
            f60178a.put(88, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            f60178a.put(89, "payAmount");
            f60178a.put(90, "history");
            f60178a.put(91, "statusColorCode");
            f60178a.put(92, "payStatus");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f60179a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(13);
            f60179a = hashMap;
            hashMap.put("layout/activity_recharge_my_payments_history_0", Integer.valueOf(R.layout.activity_recharge_my_payments_history));
            f60179a.put("layout/alert_item_0", Integer.valueOf(R.layout.alert_item));
            f60179a.put("layout/apsc_item_0", Integer.valueOf(R.layout.apsc_item));
            f60179a.put("layout/automatic_subscription_history_item_0", Integer.valueOf(R.layout.automatic_subscription_history_item));
            f60179a.put("layout/content_recharge_my_payment_history_item_0", Integer.valueOf(R.layout.content_recharge_my_payment_history_item));
            f60179a.put("layout/fragment_alert_bottom_sheet_0", Integer.valueOf(R.layout.fragment_alert_bottom_sheet));
            f60179a.put("layout/fragment_browse_plan_detail_bottom_sheet_0", Integer.valueOf(R.layout.fragment_browse_plan_detail_bottom_sheet));
            f60179a.put("layout/fragment_utility_automatic_list_0", Integer.valueOf(R.layout.fragment_utility_automatic_list));
            f60179a.put("layout/utility_automatic_list_item_add_new_0", Integer.valueOf(R.layout.utility_automatic_list_item_add_new));
            f60179a.put("layout/utility_automatic_list_item_due_date_0", Integer.valueOf(R.layout.utility_automatic_list_item_due_date));
            f60179a.put("layout/utility_automatic_list_item_header_0", Integer.valueOf(R.layout.utility_automatic_list_item_header));
            f60179a.put("layout/utility_automatic_list_item_last_bill_paid_0", Integer.valueOf(R.layout.utility_automatic_list_item_last_bill_paid));
            f60179a.put("layout/utility_automatic_list_item_to_be_generated_0", Integer.valueOf(R.layout.utility_automatic_list_item_to_be_generated));
        }
    }
}
