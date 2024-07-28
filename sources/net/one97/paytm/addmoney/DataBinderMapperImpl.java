package net.one97.paytm.addmoney;

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
import net.one97.paytm.addmoney.a.f;
import net.one97.paytm.addmoney.a.h;
import net.one97.paytm.addmoney.a.j;
import net.one97.paytm.addmoney.a.l;
import net.one97.paytm.addmoney.a.n;
import net.one97.paytm.addmoney.a.p;
import net.one97.paytm.addmoney.a.r;
import net.one97.paytm.addmoney.a.t;
import net.one97.paytm.addmoney.a.v;
import net.one97.paytm.addmoney.a.x;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYADDMONEYPOSTTRANSACTION = 1;
    private static final int LAYOUT_AMFRAGMENTAUTOADDEDIT = 3;
    private static final int LAYOUT_AMFRAGMENTSETAUTOMATIC = 2;
    private static final int LAYOUT_AMLAYOUTSELECTPAYOPTIONSBOTTOMSHEET = 4;
    private static final int LAYOUT_FRAGMENTADDMONEYTOWALLETPOSTDETAILVIEW = 5;
    private static final int LAYOUT_FRAGMENTNEWADDMONEYWALLET = 6;
    private static final int LAYOUT_LAYOUTCOUPONBOTTOMSHEET = 7;
    private static final int LAYOUT_LAYOUTNEWADDMONEYSELECTDESTINATION = 8;
    private static final int LAYOUT_UAMCVVHELPCARDLAYOUT = 9;
    private static final int LAYOUT_UAMCVVHELPLAYOUT = 10;
    private static final int LAYOUT_UAMFRAGMENTSOURCEDEBITCARDLAYOUT = 11;
    private static final int LAYOUT_UAMSAVECARDLAYOUT = 12;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(12);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_add_money_post_transaction, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.am_fragment_set_automatic, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.am_fragmentautoadd_edit, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.am_layout_select_payoptions_bottomsheet, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_add_money_to_wallet_post_detail_view, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_new_addmoney_wallet, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_coupon_bottomsheet, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_new_addmoney_selectdestination, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.uam_cvv_help_card_layout, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.uam_cvv_help_layout, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.uam_fragment_source_debit_card_layout, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.uam_save_card_layout, 12);
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
                    if ("layout/activity_add_money_post_transaction_0".equals(tag)) {
                        return new net.one97.paytm.addmoney.a.b(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_add_money_post_transaction is invalid. Received: ".concat(String.valueOf(tag)));
                case 2:
                    if ("layout/am_fragment_set_automatic_0".equals(tag)) {
                        return new net.one97.paytm.addmoney.a.d(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for am_fragment_set_automatic is invalid. Received: ".concat(String.valueOf(tag)));
                case 3:
                    if ("layout/am_fragmentautoadd_edit_0".equals(tag)) {
                        return new f(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for am_fragmentautoadd_edit is invalid. Received: ".concat(String.valueOf(tag)));
                case 4:
                    if ("layout/am_layout_select_payoptions_bottomsheet_0".equals(tag)) {
                        return new h(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for am_layout_select_payoptions_bottomsheet is invalid. Received: ".concat(String.valueOf(tag)));
                case 5:
                    if ("layout/fragment_add_money_to_wallet_post_detail_view_0".equals(tag)) {
                        return new j(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_add_money_to_wallet_post_detail_view is invalid. Received: ".concat(String.valueOf(tag)));
                case 6:
                    if ("layout/fragment_new_addmoney_wallet_0".equals(tag)) {
                        return new l(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_new_addmoney_wallet is invalid. Received: ".concat(String.valueOf(tag)));
                case 7:
                    if ("layout/layout_coupon_bottomsheet_0".equals(tag)) {
                        return new n(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_coupon_bottomsheet is invalid. Received: ".concat(String.valueOf(tag)));
                case 8:
                    if ("layout/layout_new_addmoney_selectdestination_0".equals(tag)) {
                        return new p(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_new_addmoney_selectdestination is invalid. Received: ".concat(String.valueOf(tag)));
                case 9:
                    if ("layout/uam_cvv_help_card_layout_0".equals(tag)) {
                        return new r(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for uam_cvv_help_card_layout is invalid. Received: ".concat(String.valueOf(tag)));
                case 10:
                    if ("layout/uam_cvv_help_layout_0".equals(tag)) {
                        return new t(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for uam_cvv_help_layout is invalid. Received: ".concat(String.valueOf(tag)));
                case 11:
                    if ("layout/uam_fragment_source_debit_card_layout_0".equals(tag)) {
                        return new v(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for uam_fragment_source_debit_card_layout is invalid. Received: ".concat(String.valueOf(tag)));
                case 12:
                    if ("layout/uam_save_card_layout_0".equals(tag)) {
                        return new x(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for uam_save_card_layout is invalid. Received: ".concat(String.valueOf(tag)));
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
        if (str == null || (num = b.f48008a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f48007a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.paytmmall.clpartifact.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f48007a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(67);
            f48007a = sparseArray;
            sparseArray.put(0, "_all");
            f48007a.put(1, "handler");
            f48007a.put(2, "slider");
            f48007a.put(3, "isCollapsed");
            f48007a.put(4, "rating");
            f48007a.put(5, "type");
            f48007a.put(6, "view");
            f48007a.put(7, "showRating");
            f48007a.put(8, "levelToRateCount");
            f48007a.put(9, "model");
            f48007a.put(10, "id");
            f48007a.put(11, "badgeText");
            f48007a.put(12, "totalReview");
            f48007a.put(13, "item");
            f48007a.put(14, "adapter");
            f48007a.put(15, "reviewDetail");
            f48007a.put(16, "showWishListIcon");
            f48007a.put(17, "ratingModel");
            f48007a.put(18, "entityType");
            f48007a.put(19, "totalRatings");
            f48007a.put(20, "ratingTotal");
            f48007a.put(21, "iSCOLLAPSED");
            f48007a.put(22, "starNumber");
            f48007a.put(23, "offerTag");
            f48007a.put(24, "badgeImageUrl");
            f48007a.put(25, "notificationActive");
            f48007a.put(26, "subCashback");
            f48007a.put(27, "following");
            f48007a.put(28, "name");
            f48007a.put(29, "tickerText");
            f48007a.put(30, "viewModel");
            f48007a.put(31, CLPConstants.ARGUMENT_KEY_POSITION);
            f48007a.put(32, "clickHandler");
            f48007a.put(33, "groupAdapter");
            f48007a.put(34, "dataModel");
            f48007a.put(35, "title");
            f48007a.put(36, "reviewDate");
            f48007a.put(37, "imageUrl");
            f48007a.put(38, "isSelected");
            f48007a.put(39, "isApplied");
            f48007a.put(40, "avgRating");
            f48007a.put(41, "IS_COLLAPSED");
            f48007a.put(42, "redirect");
            f48007a.put(43, "product");
            f48007a.put(44, "holder");
            f48007a.put(45, "label");
            f48007a.put(46, "clickhandler");
            f48007a.put(47, "cashback");
            f48007a.put(48, "entityIdentifier");
            f48007a.put(49, "pagerIndicatorVisibility");
            f48007a.put(50, "fragment");
            f48007a.put(51, "seourl");
            f48007a.put(52, "isWishListed");
            f48007a.put(53, "initialFrom");
            f48007a.put(54, "layoutManager");
            f48007a.put(55, "dialogDataModel");
            f48007a.put(56, "showSeparation");
            f48007a.put(57, "showPrice");
            f48007a.put(58, "showRatingBar");
            f48007a.put(59, "initialTo");
            f48007a.put(60, "defaultItemData");
            f48007a.put(61, "ratingData");
            f48007a.put(62, "viewmodel");
            f48007a.put(63, "saveCardModel");
            f48007a.put(64, "state");
            f48007a.put(65, "cvvHelpModel");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f48008a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(12);
            f48008a = hashMap;
            hashMap.put("layout/activity_add_money_post_transaction_0", Integer.valueOf(R.layout.activity_add_money_post_transaction));
            f48008a.put("layout/am_fragment_set_automatic_0", Integer.valueOf(R.layout.am_fragment_set_automatic));
            f48008a.put("layout/am_fragmentautoadd_edit_0", Integer.valueOf(R.layout.am_fragmentautoadd_edit));
            f48008a.put("layout/am_layout_select_payoptions_bottomsheet_0", Integer.valueOf(R.layout.am_layout_select_payoptions_bottomsheet));
            f48008a.put("layout/fragment_add_money_to_wallet_post_detail_view_0", Integer.valueOf(R.layout.fragment_add_money_to_wallet_post_detail_view));
            f48008a.put("layout/fragment_new_addmoney_wallet_0", Integer.valueOf(R.layout.fragment_new_addmoney_wallet));
            f48008a.put("layout/layout_coupon_bottomsheet_0", Integer.valueOf(R.layout.layout_coupon_bottomsheet));
            f48008a.put("layout/layout_new_addmoney_selectdestination_0", Integer.valueOf(R.layout.layout_new_addmoney_selectdestination));
            f48008a.put("layout/uam_cvv_help_card_layout_0", Integer.valueOf(R.layout.uam_cvv_help_card_layout));
            f48008a.put("layout/uam_cvv_help_layout_0", Integer.valueOf(R.layout.uam_cvv_help_layout));
            f48008a.put("layout/uam_fragment_source_debit_card_layout_0", Integer.valueOf(R.layout.uam_fragment_source_debit_card_layout));
            f48008a.put("layout/uam_save_card_layout_0", Integer.valueOf(R.layout.uam_save_card_layout));
        }
    }
}
