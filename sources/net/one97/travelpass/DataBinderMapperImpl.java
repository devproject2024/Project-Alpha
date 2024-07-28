package net.one97.travelpass;

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
import net.one97.travelpass.b.ab;
import net.one97.travelpass.b.ad;
import net.one97.travelpass.b.af;
import net.one97.travelpass.b.ah;
import net.one97.travelpass.b.aj;
import net.one97.travelpass.b.al;
import net.one97.travelpass.b.an;
import net.one97.travelpass.b.ap;
import net.one97.travelpass.b.ar;
import net.one97.travelpass.b.at;
import net.one97.travelpass.b.av;
import net.one97.travelpass.b.ax;
import net.one97.travelpass.b.az;
import net.one97.travelpass.b.bb;
import net.one97.travelpass.b.bd;
import net.one97.travelpass.b.bf;
import net.one97.travelpass.b.bh;
import net.one97.travelpass.b.bj;
import net.one97.travelpass.b.bl;
import net.one97.travelpass.b.bn;
import net.one97.travelpass.b.bp;
import net.one97.travelpass.b.br;
import net.one97.travelpass.b.bt;
import net.one97.travelpass.b.f;
import net.one97.travelpass.b.h;
import net.one97.travelpass.b.j;
import net.one97.travelpass.b.l;
import net.one97.travelpass.b.n;
import net.one97.travelpass.b.p;
import net.one97.travelpass.b.r;
import net.one97.travelpass.b.t;
import net.one97.travelpass.b.v;
import net.one97.travelpass.b.x;
import net.one97.travelpass.b.z;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_FRAGMENTMYPASS = 1;
    private static final int LAYOUT_FRAGMENTTRAVELPASSDETAIL = 2;
    private static final int LAYOUT_FRAGMENTTRAVELPASSDETAILS = 3;
    private static final int LAYOUT_FRAGMENTTRAVELPASSHOME = 4;
    private static final int LAYOUT_FRAGMENTTRAVELPASSORDERSUMMARY = 5;
    private static final int LAYOUT_FRAMELAYOUT = 6;
    private static final int LAYOUT_ORDERSUMMERYPASSDETAILS = 7;
    private static final int LAYOUT_ORDERSUMMERYPASSITEMDETAILS = 8;
    private static final int LAYOUT_REDEMPTIONLISTITEM = 9;
    private static final int LAYOUT_REDEMPTIONVIEW = 10;
    private static final int LAYOUT_TPABOUTACTIVITYVIEW = 11;
    private static final int LAYOUT_TPDETAILACTIVITYVIEW = 12;
    private static final int LAYOUT_TPEMPTYSCREENVIEW = 13;
    private static final int LAYOUT_TPHOMEACTIVITYVIEW = 14;
    private static final int LAYOUT_TPPASSESACTIVITYVIEW = 15;
    private static final int LAYOUT_TRAVELFRAMELAYOUT = 16;
    private static final int LAYOUT_TRAVELPASSDETAILSQUANTITY = 17;
    private static final int LAYOUT_TRAVELPASSORDERSUMMARY = 18;
    private static final int LAYOUT_VHFAQDETAILS = 19;
    private static final int LAYOUT_VHKNOWMORE = 20;
    private static final int LAYOUT_VHKNOWMOREITEM = 21;
    private static final int LAYOUT_VHOFFERTCITEMTP = 22;
    private static final int LAYOUT_VHOFFERTCTP = 23;
    private static final int LAYOUT_VHPASSDETAILS = 24;
    private static final int LAYOUT_VHPASSDETAILSINFOCONTAINER = 25;
    private static final int LAYOUT_VHTPTABS = 26;
    private static final int LAYOUT_VHTRAVELBENEFITS = 27;
    private static final int LAYOUT_VHTRAVELBUTTON = 28;
    private static final int LAYOUT_VHTRAVELFAQITEMS = 29;
    private static final int LAYOUT_VHTRAVELHOWTOUSEITEMS = 30;
    private static final int LAYOUT_VHTRAVELIMAGES = 31;
    private static final int LAYOUT_VHTRAVELINTERNALOFFERS = 32;
    private static final int LAYOUT_VHTRAVELPASSES = 33;
    private static final int LAYOUT_VHTRAVELPRICEDETAILS = 34;
    private static final int LAYOUT_VHTRAVELPRICEITEMS = 35;
    private static final int LAYOUT_VHTRAVELTEAMS = 36;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(36);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.fragment_my_pass, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_travel_pass_detail, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_travel_pass_details, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_travel_pass_home, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_travel_pass_order_summary, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.frame_layout, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.order_summery_pass_details, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.order_summery_pass_item_details, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.redemption_list_item, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.redemption_view, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.tp_about_activity_view, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.tp_detail_activity_view, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.tp_empty_screen_view, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.tp_home_activity_view, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.tp_passes_activity_view, 15);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.travel_frame_layout, 16);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.travel_pass_details_quantity, 17);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.travel_pass_order_summary, 18);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_faq_details, 19);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_know_more, 20);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_know_more_item, 21);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_offer_tc_item_tp, 22);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_offer_tc_tp, 23);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_pass_details, 24);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_pass_details_info_container, 25);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_tp_tabs, 26);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_travel_benefits, 27);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_travel_button, 28);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_travel_faq_items, 29);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_travel_how_to_use_items, 30);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_travel_images, 31);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_travel_internal_offers, 32);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_travel_passes, 33);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_travel_price_details, 34);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_travel_price_items, 35);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_travel_teams, 36);
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
                    if ("layout/fragment_my_pass_0".equals(tag)) {
                        return new net.one97.travelpass.b.b(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_my_pass is invalid. Received: ".concat(String.valueOf(tag)));
                case 2:
                    if ("layout/fragment_travel_pass_detail_0".equals(tag)) {
                        return new net.one97.travelpass.b.d(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_travel_pass_detail is invalid. Received: ".concat(String.valueOf(tag)));
                case 3:
                    if ("layout/fragment_travel_pass_details_0".equals(tag)) {
                        return new f(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_travel_pass_details is invalid. Received: ".concat(String.valueOf(tag)));
                case 4:
                    if ("layout/fragment_travel_pass_home_0".equals(tag)) {
                        return new h(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_travel_pass_home is invalid. Received: ".concat(String.valueOf(tag)));
                case 5:
                    if ("layout/fragment_travel_pass_order_summary_0".equals(tag)) {
                        return new j(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_travel_pass_order_summary is invalid. Received: ".concat(String.valueOf(tag)));
                case 6:
                    if ("layout/frame_layout_0".equals(tag)) {
                        return new l(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for frame_layout is invalid. Received: ".concat(String.valueOf(tag)));
                case 7:
                    if ("layout/order_summery_pass_details_0".equals(tag)) {
                        return new n(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for order_summery_pass_details is invalid. Received: ".concat(String.valueOf(tag)));
                case 8:
                    if ("layout/order_summery_pass_item_details_0".equals(tag)) {
                        return new p(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for order_summery_pass_item_details is invalid. Received: ".concat(String.valueOf(tag)));
                case 9:
                    if ("layout/redemption_list_item_0".equals(tag)) {
                        return new r(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for redemption_list_item is invalid. Received: ".concat(String.valueOf(tag)));
                case 10:
                    if ("layout/redemption_view_0".equals(tag)) {
                        return new t(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for redemption_view is invalid. Received: ".concat(String.valueOf(tag)));
                case 11:
                    if ("layout/tp_about_activity_view_0".equals(tag)) {
                        return new v(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for tp_about_activity_view is invalid. Received: ".concat(String.valueOf(tag)));
                case 12:
                    if ("layout/tp_detail_activity_view_0".equals(tag)) {
                        return new x(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for tp_detail_activity_view is invalid. Received: ".concat(String.valueOf(tag)));
                case 13:
                    if ("layout/tp_empty_screen_view_0".equals(tag)) {
                        return new z(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for tp_empty_screen_view is invalid. Received: ".concat(String.valueOf(tag)));
                case 14:
                    if ("layout/tp_home_activity_view_0".equals(tag)) {
                        return new ab(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for tp_home_activity_view is invalid. Received: ".concat(String.valueOf(tag)));
                case 15:
                    if ("layout/tp_passes_activity_view_0".equals(tag)) {
                        return new ad(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for tp_passes_activity_view is invalid. Received: ".concat(String.valueOf(tag)));
                case 16:
                    if ("layout/travel_frame_layout_0".equals(tag)) {
                        return new af(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for travel_frame_layout is invalid. Received: ".concat(String.valueOf(tag)));
                case 17:
                    if ("layout/travel_pass_details_quantity_0".equals(tag)) {
                        return new ah(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for travel_pass_details_quantity is invalid. Received: ".concat(String.valueOf(tag)));
                case 18:
                    if ("layout/travel_pass_order_summary_0".equals(tag)) {
                        return new aj(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for travel_pass_order_summary is invalid. Received: ".concat(String.valueOf(tag)));
                case 19:
                    if ("layout/vh_faq_details_0".equals(tag)) {
                        return new al(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_faq_details is invalid. Received: ".concat(String.valueOf(tag)));
                case 20:
                    if ("layout/vh_know_more_0".equals(tag)) {
                        return new an(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_know_more is invalid. Received: ".concat(String.valueOf(tag)));
                case 21:
                    if ("layout/vh_know_more_item_0".equals(tag)) {
                        return new ap(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_know_more_item is invalid. Received: ".concat(String.valueOf(tag)));
                case 22:
                    if ("layout/vh_offer_tc_item_tp_0".equals(tag)) {
                        return new ar(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_offer_tc_item_tp is invalid. Received: ".concat(String.valueOf(tag)));
                case 23:
                    if ("layout/vh_offer_tc_tp_0".equals(tag)) {
                        return new at(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_offer_tc_tp is invalid. Received: ".concat(String.valueOf(tag)));
                case 24:
                    if ("layout/vh_pass_details_0".equals(tag)) {
                        return new av(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_pass_details is invalid. Received: ".concat(String.valueOf(tag)));
                case 25:
                    if ("layout/vh_pass_details_info_container_0".equals(tag)) {
                        return new ax(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_pass_details_info_container is invalid. Received: ".concat(String.valueOf(tag)));
                case 26:
                    if ("layout/vh_tp_tabs_0".equals(tag)) {
                        return new az(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_tp_tabs is invalid. Received: ".concat(String.valueOf(tag)));
                case 27:
                    if ("layout/vh_travel_benefits_0".equals(tag)) {
                        return new bb(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_travel_benefits is invalid. Received: ".concat(String.valueOf(tag)));
                case 28:
                    if ("layout/vh_travel_button_0".equals(tag)) {
                        return new bd(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_travel_button is invalid. Received: ".concat(String.valueOf(tag)));
                case 29:
                    if ("layout/vh_travel_faq_items_0".equals(tag)) {
                        return new bf(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_travel_faq_items is invalid. Received: ".concat(String.valueOf(tag)));
                case 30:
                    if ("layout/vh_travel_how_to_use_items_0".equals(tag)) {
                        return new bh(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_travel_how_to_use_items is invalid. Received: ".concat(String.valueOf(tag)));
                case 31:
                    if ("layout/vh_travel_images_0".equals(tag)) {
                        return new bj(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_travel_images is invalid. Received: ".concat(String.valueOf(tag)));
                case 32:
                    if ("layout/vh_travel_internal_offers_0".equals(tag)) {
                        return new bl(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_travel_internal_offers is invalid. Received: ".concat(String.valueOf(tag)));
                case 33:
                    if ("layout/vh_travel_passes_0".equals(tag)) {
                        return new bn(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_travel_passes is invalid. Received: ".concat(String.valueOf(tag)));
                case 34:
                    if ("layout/vh_travel_price_details_0".equals(tag)) {
                        return new bp(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_travel_price_details is invalid. Received: ".concat(String.valueOf(tag)));
                case 35:
                    if ("layout/vh_travel_price_items_0".equals(tag)) {
                        return new br(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_travel_price_items is invalid. Received: ".concat(String.valueOf(tag)));
                case 36:
                    if ("layout/vh_travel_teams_0".equals(tag)) {
                        return new bt(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_travel_teams is invalid. Received: ".concat(String.valueOf(tag)));
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
        if (str == null || (num = b.f30027a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f30026a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.travel.common.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.nativesdk.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f30026a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(34);
            f30026a = sparseArray;
            sparseArray.put(0, "_all");
            f30026a.put(1, "emiViewModel");
            f30026a.put(2, "instrumentSheetViewModel");
            f30026a.put(3, "section");
            f30026a.put(4, "transcationViewModel");
            f30026a.put(5, "allNetBankingViewModel");
            f30026a.put(6, "bankMandateIfscCodeViewModel");
            f30026a.put(7, "codViewModel");
            f30026a.put(8, "view");
            f30026a.put(9, "netBankingViewModel");
            f30026a.put(10, "netbanking");
            f30026a.put(11, "saveCardModel");
            f30026a.put(12, "model");
            f30026a.put(13, "showInstrumentInfoMsg");
            f30026a.put(14, "a");
            f30026a.put(15, "otpViewholder");
            f30026a.put(16, "pincvvmodel");
            f30026a.put(17, "bank_mandate");
            f30026a.put(18, "debitCardModel");
            f30026a.put(19, "selectedInstrumentSheetViewModel");
            f30026a.put(20, "typeface");
            f30026a.put(21, "aoaWalletViewModel");
            f30026a.put(22, "bankViewModel");
            f30026a.put(23, "landingPageViewModel");
            f30026a.put(24, "walletViewModel");
            f30026a.put(25, "digitalCreditModel");
            f30026a.put(26, "cvvHelpModel");
            f30026a.put(27, "bankMandateSubDetailsViewModel");
            f30026a.put(28, "upiHelpModel");
            f30026a.put(29, "upiCollectModel");
            f30026a.put(30, "redemptionAdapter");
            f30026a.put(31, CLPConstants.ARGUMENT_KEY_POSITION);
            f30026a.put(32, "itemClickListener");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f30027a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(36);
            f30027a = hashMap;
            hashMap.put("layout/fragment_my_pass_0", Integer.valueOf(R.layout.fragment_my_pass));
            f30027a.put("layout/fragment_travel_pass_detail_0", Integer.valueOf(R.layout.fragment_travel_pass_detail));
            f30027a.put("layout/fragment_travel_pass_details_0", Integer.valueOf(R.layout.fragment_travel_pass_details));
            f30027a.put("layout/fragment_travel_pass_home_0", Integer.valueOf(R.layout.fragment_travel_pass_home));
            f30027a.put("layout/fragment_travel_pass_order_summary_0", Integer.valueOf(R.layout.fragment_travel_pass_order_summary));
            f30027a.put("layout/frame_layout_0", Integer.valueOf(R.layout.frame_layout));
            f30027a.put("layout/order_summery_pass_details_0", Integer.valueOf(R.layout.order_summery_pass_details));
            f30027a.put("layout/order_summery_pass_item_details_0", Integer.valueOf(R.layout.order_summery_pass_item_details));
            f30027a.put("layout/redemption_list_item_0", Integer.valueOf(R.layout.redemption_list_item));
            f30027a.put("layout/redemption_view_0", Integer.valueOf(R.layout.redemption_view));
            f30027a.put("layout/tp_about_activity_view_0", Integer.valueOf(R.layout.tp_about_activity_view));
            f30027a.put("layout/tp_detail_activity_view_0", Integer.valueOf(R.layout.tp_detail_activity_view));
            f30027a.put("layout/tp_empty_screen_view_0", Integer.valueOf(R.layout.tp_empty_screen_view));
            f30027a.put("layout/tp_home_activity_view_0", Integer.valueOf(R.layout.tp_home_activity_view));
            f30027a.put("layout/tp_passes_activity_view_0", Integer.valueOf(R.layout.tp_passes_activity_view));
            f30027a.put("layout/travel_frame_layout_0", Integer.valueOf(R.layout.travel_frame_layout));
            f30027a.put("layout/travel_pass_details_quantity_0", Integer.valueOf(R.layout.travel_pass_details_quantity));
            f30027a.put("layout/travel_pass_order_summary_0", Integer.valueOf(R.layout.travel_pass_order_summary));
            f30027a.put("layout/vh_faq_details_0", Integer.valueOf(R.layout.vh_faq_details));
            f30027a.put("layout/vh_know_more_0", Integer.valueOf(R.layout.vh_know_more));
            f30027a.put("layout/vh_know_more_item_0", Integer.valueOf(R.layout.vh_know_more_item));
            f30027a.put("layout/vh_offer_tc_item_tp_0", Integer.valueOf(R.layout.vh_offer_tc_item_tp));
            f30027a.put("layout/vh_offer_tc_tp_0", Integer.valueOf(R.layout.vh_offer_tc_tp));
            f30027a.put("layout/vh_pass_details_0", Integer.valueOf(R.layout.vh_pass_details));
            f30027a.put("layout/vh_pass_details_info_container_0", Integer.valueOf(R.layout.vh_pass_details_info_container));
            f30027a.put("layout/vh_tp_tabs_0", Integer.valueOf(R.layout.vh_tp_tabs));
            f30027a.put("layout/vh_travel_benefits_0", Integer.valueOf(R.layout.vh_travel_benefits));
            f30027a.put("layout/vh_travel_button_0", Integer.valueOf(R.layout.vh_travel_button));
            f30027a.put("layout/vh_travel_faq_items_0", Integer.valueOf(R.layout.vh_travel_faq_items));
            f30027a.put("layout/vh_travel_how_to_use_items_0", Integer.valueOf(R.layout.vh_travel_how_to_use_items));
            f30027a.put("layout/vh_travel_images_0", Integer.valueOf(R.layout.vh_travel_images));
            f30027a.put("layout/vh_travel_internal_offers_0", Integer.valueOf(R.layout.vh_travel_internal_offers));
            f30027a.put("layout/vh_travel_passes_0", Integer.valueOf(R.layout.vh_travel_passes));
            f30027a.put("layout/vh_travel_price_details_0", Integer.valueOf(R.layout.vh_travel_price_details));
            f30027a.put("layout/vh_travel_price_items_0", Integer.valueOf(R.layout.vh_travel_price_items));
            f30027a.put("layout/vh_travel_teams_0", Integer.valueOf(R.layout.vh_travel_teams));
        }
    }
}
