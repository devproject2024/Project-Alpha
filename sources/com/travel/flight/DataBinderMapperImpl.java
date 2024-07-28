package com.travel.flight;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.travel.flight.b.ab;
import com.travel.flight.b.ad;
import com.travel.flight.b.af;
import com.travel.flight.b.ah;
import com.travel.flight.b.aj;
import com.travel.flight.b.al;
import com.travel.flight.b.an;
import com.travel.flight.b.ap;
import com.travel.flight.b.ar;
import com.travel.flight.b.at;
import com.travel.flight.b.av;
import com.travel.flight.b.ax;
import com.travel.flight.b.az;
import com.travel.flight.b.bb;
import com.travel.flight.b.bd;
import com.travel.flight.b.bf;
import com.travel.flight.b.bh;
import com.travel.flight.b.bj;
import com.travel.flight.b.bl;
import com.travel.flight.b.bn;
import com.travel.flight.b.bp;
import com.travel.flight.b.br;
import com.travel.flight.b.bt;
import com.travel.flight.b.bv;
import com.travel.flight.b.bx;
import com.travel.flight.b.bz;
import com.travel.flight.b.cb;
import com.travel.flight.b.cd;
import com.travel.flight.b.cf;
import com.travel.flight.b.ch;
import com.travel.flight.b.cj;
import com.travel.flight.b.cl;
import com.travel.flight.b.cn;
import com.travel.flight.b.cp;
import com.travel.flight.b.cr;
import com.travel.flight.b.ct;
import com.travel.flight.b.cv;
import com.travel.flight.b.cx;
import com.travel.flight.b.cz;
import com.travel.flight.b.db;
import com.travel.flight.b.dd;
import com.travel.flight.b.df;
import com.travel.flight.b.dh;
import com.travel.flight.b.dj;
import com.travel.flight.b.dl;
import com.travel.flight.b.dn;
import com.travel.flight.b.dp;
import com.travel.flight.b.dr;
import com.travel.flight.b.f;
import com.travel.flight.b.h;
import com.travel.flight.b.j;
import com.travel.flight.b.l;
import com.travel.flight.b.n;
import com.travel.flight.b.p;
import com.travel.flight.b.r;
import com.travel.flight.b.t;
import com.travel.flight.b.v;
import com.travel.flight.b.x;
import com.travel.flight.b.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYFLIGHTMBCHARGES = 1;
    private static final int LAYOUT_ACTIVITYFLIGHTSRPV2 = 2;
    private static final int LAYOUT_ACTIVITYPRIORITYCHECKIN = 3;
    private static final int LAYOUT_FLIGHTLAYOUTNOFLIGHTSFOUND = 4;
    private static final int LAYOUT_FLIGHTLISTITEMAIRLINEPRICESTRIP = 5;
    private static final int LAYOUT_FLIGHTSMBCHARGESITEM = 6;
    private static final int LAYOUT_FLIGHTSMBFLIGHTITEM = 7;
    private static final int LAYOUT_FLIGHTSMBIMPNOTES = 8;
    private static final int LAYOUT_FLIGHTSMBNOTESTEXTITEM = 9;
    private static final int LAYOUT_FLIGHTSMBNOTESWITHICON = 10;
    private static final int LAYOUT_FLIGHTSMBTRAVELERITEM = 11;
    private static final int LAYOUT_FLIGHTSMBTRAVELERSITEM = 12;
    private static final int LAYOUT_FRAGMENTDOMESTICROUNDTRIP = 13;
    private static final int LAYOUT_FRAGMENTFLIGHTDRTSORTHOME = 14;
    private static final int LAYOUT_FRAGMENTFLIGHTFILTERHOMEPAGE = 15;
    private static final int LAYOUT_FRAGMENTFLIGHTFILTERPAGE = 16;
    private static final int LAYOUT_FRAGMENTFLIGHTIRTSORTHOME = 17;
    private static final int LAYOUT_FRAGMENTFLIGHTNONETWORKV2 = 18;
    private static final int LAYOUT_FRAGMENTFLIGHTONEWAYSORTHOME = 19;
    private static final int LAYOUT_FRAGMENTINTERNATIONALROUNDTRIP = 20;
    private static final int LAYOUT_FRAGMENTIRTSPLITVIEW = 21;
    private static final int LAYOUT_FRAGMENTSRPLOADING = 22;
    private static final int LAYOUT_FRAGMENTSRPMODIFY = 23;
    private static final int LAYOUT_FRAGMENTSRPONEWAYV2 = 24;
    private static final int LAYOUT_ITEMDRTDISCOUNTSTRIP = 25;
    private static final int LAYOUT_ITEMDRTFLIGHTLIST = 26;
    private static final int LAYOUT_ITEMIRTFLIGHTLIST = 27;
    private static final int LAYOUT_ITEMIRTFLIGHTSPITVIEWLIST = 28;
    private static final int LAYOUT_LAYOUTFLIGHTREFUND = 29;
    private static final int LAYOUT_LAYOUTMODIFIEDORDERSUMMARYITEM = 30;
    private static final int LAYOUT_LAYOUTPRICEINFOBAR = 31;
    private static final int LAYOUT_LAYOUTREVIEWPAYMENTDETAILS = 32;
    private static final int LAYOUT_LAYOUTSRPBOTTOMSTRIPONEWAYV2 = 33;
    private static final int LAYOUT_LAYOUTSRPBOTTOMSTRIPV2DRT = 34;
    private static final int LAYOUT_LAYOUTSRPBOTTOMSTRIPV2IRT = 35;
    private static final int LAYOUT_LAYOUTSRPTOOLTIP = 36;
    private static final int LAYOUT_LISTITEMMODIFYTICKETTRAVELLER = 37;
    private static final int LAYOUT_LISTITEMREFUNDINFO = 38;
    private static final int LAYOUT_LISTITEMREFUNDSOURCE = 39;
    private static final int LAYOUT_LISTITEMREVIEWPAYMENTDETAIL = 40;
    private static final int LAYOUT_LISTITEMREVIEWPAYMENTITEM = 41;
    private static final int LAYOUT_PREFAIRLINEFILTERITEM = 42;
    private static final int LAYOUT_PREFBLANKSPACE = 43;
    private static final int LAYOUT_PREFFILTERLISTSTRIP = 44;
    private static final int LAYOUT_PREFFLIGHTDATEPRICEITEMV2 = 45;
    private static final int LAYOUT_PREFFLIGHTFAREALERTMESSAGELYT = 46;
    private static final int LAYOUT_PREFFLIGHTFILTERITEMV2 = 47;
    private static final int LAYOUT_PREFFLIGHTSRPV2ACTIONBAR = 48;
    private static final int LAYOUT_PREFFLIGHTSRPV2ACTIONBARLOADERFRAGMENT = 49;
    private static final int LAYOUT_PREFITEMFLIGHTCHILDSEARCHLISTREVAMP2 = 50;
    private static final int LAYOUT_PREFITEMFLIGHTSEARCHAIRLINEFILTER = 51;
    private static final int LAYOUT_PREFITEMFLIGHTSEARCHBANNER = 52;
    private static final int LAYOUT_PREFITEMFLIGHTSEARCHDURATION = 53;
    private static final int LAYOUT_PREFITEMFLIGHTSEARCHLISTREVAMP2 = 54;
    private static final int LAYOUT_PREFITEMFLIGHTSEARCHPRICEFILTER = 55;
    private static final int LAYOUT_PREFITEMFLIGHTSEARCHTIMEFILTER = 56;
    private static final int LAYOUT_PREFITEMVIEWORDERSUMMARYHOTELOPTION = 57;
    private static final int LAYOUT_PREFLAYOUTORDERSUMMARYHOTELOPTIONS = 58;
    private static final int LAYOUT_PREFROWSRPFILTERHEADER = 59;
    private static final int LAYOUT_PREFROWSRPHEADER = 60;
    private static final int LAYOUT_ROWFLIGHTORDERSUMMARYBUNDLECOUPON = 61;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(61);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_flight_mb_charges, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.activity_flight_srp_v2, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.activity_priority_checkin, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.flight_layout_no_flights_found, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.flight_list_item_airline_price_strip, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.flights_mb_charges_item, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.flights_mb_flight_item, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.flights_mb_imp_notes, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.flights_mb_notes_text_item, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.flights_mb_notes_with_icon, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.flights_mb_traveler_item, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.flights_mb_travelers_item, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_domestic_round_trip, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_flight_drt_sort_home, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_flight_filter_home_page, 15);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_flight_filter_page, 16);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_flight_irt_sort_home, 17);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_flight_no_network_v2, 18);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_flight_one_way_sort_home, 19);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_international_round_trip, 20);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_irt_split_view, 21);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_srp_loading, 22);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_srp_modify, 23);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_srp_one_way_v2, 24);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_drt_discount_strip, 25);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_drt_flight_list, 26);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_irt_flight_list, 27);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_irt_flight_spit_view_list, 28);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_flight_refund, 29);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_modified_order_summary_item, 30);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_price_info_bar, 31);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_review_payment_details, 32);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_srp_bottom_strip_oneway_v2, 33);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_srp_bottom_strip_v2_drt, 34);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_srp_bottom_strip_v2_irt, 35);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_srp_tool_tip, 36);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.list_item_modify_ticket_traveller, 37);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.list_item_refund_info, 38);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.list_item_refund_source, 39);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.list_item_review_payment_detail, 40);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.list_item_review_payment_item, 41);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_airline_filter_item, 42);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_blank_space, 43);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_filter_list_strip, 44);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_flight_date_price_item_v2, 45);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_flight_fare_alert_message_lyt, 46);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_flight_filter_item_v2, 47);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_flight_srp_v2_action_bar, 48);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_flight_srp_v2_action_bar_loader_fragment, 49);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_item_flight_child_search_list_revamp2, 50);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_item_flight_search_airline_filter, 51);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_item_flight_search_banner, 52);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_item_flight_search_duration, 53);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_item_flight_search_list_revamp2, 54);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_item_flight_search_price_filter, 55);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_item_flight_search_time_filter, 56);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_item_view_order_summary_hotel_option, 57);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_layout_order_summary_hotel_options, 58);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_row_srp_filter_header, 59);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pre_f_row_srp_header, 60);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.row_flight_order_summary_bundle_coupon, 61);
    }

    private final ViewDataBinding internalGetViewDataBinding0(e eVar, View view, int i2, Object obj) {
        switch (i2) {
            case 1:
                if ("layout/activity_flight_mb_charges_0".equals(obj)) {
                    return new com.travel.flight.b.b(eVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_flight_mb_charges is invalid. Received: ".concat(String.valueOf(obj)));
            case 2:
                if ("layout/activity_flight_srp_v2_0".equals(obj)) {
                    return new com.travel.flight.b.d(eVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_flight_srp_v2 is invalid. Received: ".concat(String.valueOf(obj)));
            case 3:
                if ("layout/activity_priority_checkin_0".equals(obj)) {
                    return new f(eVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_priority_checkin is invalid. Received: ".concat(String.valueOf(obj)));
            case 4:
                if ("layout/flight_layout_no_flights_found_0".equals(obj)) {
                    return new h(eVar, view);
                }
                throw new IllegalArgumentException("The tag for flight_layout_no_flights_found is invalid. Received: ".concat(String.valueOf(obj)));
            case 5:
                if ("layout/flight_list_item_airline_price_strip_0".equals(obj)) {
                    return new j(eVar, view);
                }
                throw new IllegalArgumentException("The tag for flight_list_item_airline_price_strip is invalid. Received: ".concat(String.valueOf(obj)));
            case 6:
                if ("layout/flights_mb_charges_item_0".equals(obj)) {
                    return new l(eVar, view);
                }
                throw new IllegalArgumentException("The tag for flights_mb_charges_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 7:
                if ("layout/flights_mb_flight_item_0".equals(obj)) {
                    return new n(eVar, view);
                }
                throw new IllegalArgumentException("The tag for flights_mb_flight_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 8:
                if ("layout/flights_mb_imp_notes_0".equals(obj)) {
                    return new p(eVar, view);
                }
                throw new IllegalArgumentException("The tag for flights_mb_imp_notes is invalid. Received: ".concat(String.valueOf(obj)));
            case 9:
                if ("layout/flights_mb_notes_text_item_0".equals(obj)) {
                    return new r(eVar, view);
                }
                throw new IllegalArgumentException("The tag for flights_mb_notes_text_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 10:
                if ("layout/flights_mb_notes_with_icon_0".equals(obj)) {
                    return new t(eVar, view);
                }
                throw new IllegalArgumentException("The tag for flights_mb_notes_with_icon is invalid. Received: ".concat(String.valueOf(obj)));
            case 11:
                if ("layout/flights_mb_traveler_item_0".equals(obj)) {
                    return new v(eVar, view);
                }
                throw new IllegalArgumentException("The tag for flights_mb_traveler_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 12:
                if ("layout/flights_mb_travelers_item_0".equals(obj)) {
                    return new x(eVar, view);
                }
                throw new IllegalArgumentException("The tag for flights_mb_travelers_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 13:
                if ("layout/fragment_domestic_round_trip_0".equals(obj)) {
                    return new z(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_domestic_round_trip is invalid. Received: ".concat(String.valueOf(obj)));
            case 14:
                if ("layout/fragment_flight_drt_sort_home_0".equals(obj)) {
                    return new ab(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_flight_drt_sort_home is invalid. Received: ".concat(String.valueOf(obj)));
            case 15:
                if ("layout/fragment_flight_filter_home_page_0".equals(obj)) {
                    return new ad(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_flight_filter_home_page is invalid. Received: ".concat(String.valueOf(obj)));
            case 16:
                if ("layout/fragment_flight_filter_page_0".equals(obj)) {
                    return new af(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_flight_filter_page is invalid. Received: ".concat(String.valueOf(obj)));
            case 17:
                if ("layout/fragment_flight_irt_sort_home_0".equals(obj)) {
                    return new ah(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_flight_irt_sort_home is invalid. Received: ".concat(String.valueOf(obj)));
            case 18:
                if ("layout/fragment_flight_no_network_v2_0".equals(obj)) {
                    return new aj(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_flight_no_network_v2 is invalid. Received: ".concat(String.valueOf(obj)));
            case 19:
                if ("layout/fragment_flight_one_way_sort_home_0".equals(obj)) {
                    return new al(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_flight_one_way_sort_home is invalid. Received: ".concat(String.valueOf(obj)));
            case 20:
                if ("layout/fragment_international_round_trip_0".equals(obj)) {
                    return new an(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_international_round_trip is invalid. Received: ".concat(String.valueOf(obj)));
            case 21:
                if ("layout/fragment_irt_split_view_0".equals(obj)) {
                    return new ap(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_irt_split_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 22:
                if ("layout/fragment_srp_loading_0".equals(obj)) {
                    return new ar(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_srp_loading is invalid. Received: ".concat(String.valueOf(obj)));
            case 23:
                if ("layout/fragment_srp_modify_0".equals(obj)) {
                    return new at(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_srp_modify is invalid. Received: ".concat(String.valueOf(obj)));
            case 24:
                if ("layout/fragment_srp_one_way_v2_0".equals(obj)) {
                    return new av(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_srp_one_way_v2 is invalid. Received: ".concat(String.valueOf(obj)));
            case 25:
                if ("layout/item_drt_discount_strip_0".equals(obj)) {
                    return new ax(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_drt_discount_strip is invalid. Received: ".concat(String.valueOf(obj)));
            case 26:
                if ("layout/item_drt_flight_list_0".equals(obj)) {
                    return new az(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_drt_flight_list is invalid. Received: ".concat(String.valueOf(obj)));
            case 27:
                if ("layout/item_irt_flight_list_0".equals(obj)) {
                    return new bb(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_irt_flight_list is invalid. Received: ".concat(String.valueOf(obj)));
            case 28:
                if ("layout/item_irt_flight_spit_view_list_0".equals(obj)) {
                    return new bd(eVar, view);
                }
                throw new IllegalArgumentException("The tag for item_irt_flight_spit_view_list is invalid. Received: ".concat(String.valueOf(obj)));
            case 29:
                if ("layout/layout_flight_refund_0".equals(obj)) {
                    return new bf(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_flight_refund is invalid. Received: ".concat(String.valueOf(obj)));
            case 30:
                if ("layout/layout_modified_order_summary_item_0".equals(obj)) {
                    return new bh(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_modified_order_summary_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 31:
                if ("layout/layout_price_info_bar_0".equals(obj)) {
                    return new bj(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_price_info_bar is invalid. Received: ".concat(String.valueOf(obj)));
            case 32:
                if ("layout/layout_review_payment_details_0".equals(obj)) {
                    return new bl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_review_payment_details is invalid. Received: ".concat(String.valueOf(obj)));
            case 33:
                if ("layout/layout_srp_bottom_strip_oneway_v2_0".equals(obj)) {
                    return new bn(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_srp_bottom_strip_oneway_v2 is invalid. Received: ".concat(String.valueOf(obj)));
            case 34:
                if ("layout/layout_srp_bottom_strip_v2_drt_0".equals(obj)) {
                    return new bp(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_srp_bottom_strip_v2_drt is invalid. Received: ".concat(String.valueOf(obj)));
            case 35:
                if ("layout/layout_srp_bottom_strip_v2_irt_0".equals(obj)) {
                    return new br(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_srp_bottom_strip_v2_irt is invalid. Received: ".concat(String.valueOf(obj)));
            case 36:
                if ("layout/layout_srp_tool_tip_0".equals(obj)) {
                    return new bt(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_srp_tool_tip is invalid. Received: ".concat(String.valueOf(obj)));
            case 37:
                if ("layout/list_item_modify_ticket_traveller_0".equals(obj)) {
                    return new bv(eVar, view);
                }
                throw new IllegalArgumentException("The tag for list_item_modify_ticket_traveller is invalid. Received: ".concat(String.valueOf(obj)));
            case 38:
                if ("layout/list_item_refund_info_0".equals(obj)) {
                    return new bx(eVar, view);
                }
                throw new IllegalArgumentException("The tag for list_item_refund_info is invalid. Received: ".concat(String.valueOf(obj)));
            case 39:
                if ("layout/list_item_refund_source_0".equals(obj)) {
                    return new bz(eVar, view);
                }
                throw new IllegalArgumentException("The tag for list_item_refund_source is invalid. Received: ".concat(String.valueOf(obj)));
            case 40:
                if ("layout/list_item_review_payment_detail_0".equals(obj)) {
                    return new cb(eVar, view);
                }
                throw new IllegalArgumentException("The tag for list_item_review_payment_detail is invalid. Received: ".concat(String.valueOf(obj)));
            case 41:
                if ("layout/list_item_review_payment_item_0".equals(obj)) {
                    return new cd(eVar, view);
                }
                throw new IllegalArgumentException("The tag for list_item_review_payment_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 42:
                if ("layout/pre_f_airline_filter_item_0".equals(obj)) {
                    return new cf(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_airline_filter_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 43:
                if ("layout/pre_f_blank_space_0".equals(obj)) {
                    return new ch(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_blank_space is invalid. Received: ".concat(String.valueOf(obj)));
            case 44:
                if ("layout/pre_f_filter_list_strip_0".equals(obj)) {
                    return new cj(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_filter_list_strip is invalid. Received: ".concat(String.valueOf(obj)));
            case 45:
                if ("layout/pre_f_flight_date_price_item_v2_0".equals(obj)) {
                    return new cl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_flight_date_price_item_v2 is invalid. Received: ".concat(String.valueOf(obj)));
            case 46:
                if ("layout/pre_f_flight_fare_alert_message_lyt_0".equals(obj)) {
                    return new cn(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_flight_fare_alert_message_lyt is invalid. Received: ".concat(String.valueOf(obj)));
            case 47:
                if ("layout/pre_f_flight_filter_item_v2_0".equals(obj)) {
                    return new cp(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_flight_filter_item_v2 is invalid. Received: ".concat(String.valueOf(obj)));
            case 48:
                if ("layout/pre_f_flight_srp_v2_action_bar_0".equals(obj)) {
                    return new cr(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_flight_srp_v2_action_bar is invalid. Received: ".concat(String.valueOf(obj)));
            case 49:
                if ("layout/pre_f_flight_srp_v2_action_bar_loader_fragment_0".equals(obj)) {
                    return new ct(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_flight_srp_v2_action_bar_loader_fragment is invalid. Received: ".concat(String.valueOf(obj)));
            case 50:
                if ("layout/pre_f_item_flight_child_search_list_revamp2_0".equals(obj)) {
                    return new cv(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_item_flight_child_search_list_revamp2 is invalid. Received: ".concat(String.valueOf(obj)));
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(e eVar, View view, int i2, Object obj) {
        switch (i2) {
            case 51:
                if ("layout/pre_f_item_flight_search_airline_filter_0".equals(obj)) {
                    return new cx(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_item_flight_search_airline_filter is invalid. Received: ".concat(String.valueOf(obj)));
            case 52:
                if ("layout/pre_f_item_flight_search_banner_0".equals(obj)) {
                    return new cz(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_item_flight_search_banner is invalid. Received: ".concat(String.valueOf(obj)));
            case 53:
                if ("layout/pre_f_item_flight_search_duration_0".equals(obj)) {
                    return new db(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_item_flight_search_duration is invalid. Received: ".concat(String.valueOf(obj)));
            case 54:
                if ("layout/pre_f_item_flight_search_list_revamp2_0".equals(obj)) {
                    return new dd(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_item_flight_search_list_revamp2 is invalid. Received: ".concat(String.valueOf(obj)));
            case 55:
                if ("layout/pre_f_item_flight_search_price_filter_0".equals(obj)) {
                    return new df(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_item_flight_search_price_filter is invalid. Received: ".concat(String.valueOf(obj)));
            case 56:
                if ("layout/pre_f_item_flight_search_time_filter_0".equals(obj)) {
                    return new dh(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_item_flight_search_time_filter is invalid. Received: ".concat(String.valueOf(obj)));
            case 57:
                if ("layout/pre_f_item_view_order_summary_hotel_option_0".equals(obj)) {
                    return new dj(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_item_view_order_summary_hotel_option is invalid. Received: ".concat(String.valueOf(obj)));
            case 58:
                if ("layout/pre_f_layout_order_summary_hotel_options_0".equals(obj)) {
                    return new dl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_layout_order_summary_hotel_options is invalid. Received: ".concat(String.valueOf(obj)));
            case 59:
                if ("layout/pre_f_row_srp_filter_header_0".equals(obj)) {
                    return new dn(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_row_srp_filter_header is invalid. Received: ".concat(String.valueOf(obj)));
            case 60:
                if ("layout/pre_f_row_srp_header_0".equals(obj)) {
                    return new dp(eVar, view);
                }
                throw new IllegalArgumentException("The tag for pre_f_row_srp_header is invalid. Received: ".concat(String.valueOf(obj)));
            case 61:
                if ("layout/row_flight_order_summary_bundle_coupon_0".equals(obj)) {
                    return new dr(eVar, view);
                }
                throw new IllegalArgumentException("The tag for row_flight_order_summary_bundle_coupon is invalid. Received: ".concat(String.valueOf(obj)));
            default:
                return null;
        }
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        int i3 = INTERNAL_LAYOUT_ID_LOOKUP.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            int i4 = (i3 - 1) / 50;
            if (i4 == 0) {
                return internalGetViewDataBinding0(eVar, view, i3, tag);
            }
            if (i4 != 1) {
                return null;
            }
            return internalGetViewDataBinding1(eVar, view, i3, tag);
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
        if (str == null || (num = b.f23465a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f23464a.get(i2);
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
        static final SparseArray<String> f23464a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(135);
            f23464a = sparseArray;
            sparseArray.put(0, "_all");
            f23464a.put(1, "emiViewModel");
            f23464a.put(2, "instrumentSheetViewModel");
            f23464a.put(3, "section");
            f23464a.put(4, "transcationViewModel");
            f23464a.put(5, "allNetBankingViewModel");
            f23464a.put(6, "bankMandateIfscCodeViewModel");
            f23464a.put(7, "codViewModel");
            f23464a.put(8, "view");
            f23464a.put(9, "netBankingViewModel");
            f23464a.put(10, "netbanking");
            f23464a.put(11, "saveCardModel");
            f23464a.put(12, "model");
            f23464a.put(13, "showInstrumentInfoMsg");
            f23464a.put(14, "a");
            f23464a.put(15, "otpViewholder");
            f23464a.put(16, "pincvvmodel");
            f23464a.put(17, "bank_mandate");
            f23464a.put(18, "debitCardModel");
            f23464a.put(19, "selectedInstrumentSheetViewModel");
            f23464a.put(20, "typeface");
            f23464a.put(21, "aoaWalletViewModel");
            f23464a.put(22, "bankViewModel");
            f23464a.put(23, "landingPageViewModel");
            f23464a.put(24, "walletViewModel");
            f23464a.put(25, "digitalCreditModel");
            f23464a.put(26, "cvvHelpModel");
            f23464a.put(27, "bankMandateSubDetailsViewModel");
            f23464a.put(28, "upiHelpModel");
            f23464a.put(29, "upiCollectModel");
            f23464a.put(30, "handler");
            f23464a.put(31, "slider");
            f23464a.put(32, "isCollapsed");
            f23464a.put(33, "rating");
            f23464a.put(34, "showMoreVisibility");
            f23464a.put(35, "type");
            f23464a.put(36, "showRating");
            f23464a.put(37, "levelToRateCount");
            f23464a.put(38, "id");
            f23464a.put(39, "badgeText");
            f23464a.put(40, "totalReview");
            f23464a.put(41, "item");
            f23464a.put(42, "adapter");
            f23464a.put(43, "reviewDetail");
            f23464a.put(44, "showWishListIcon");
            f23464a.put(45, "ratingModel");
            f23464a.put(46, "entityType");
            f23464a.put(47, "totalRatings");
            f23464a.put(48, "ratingTotal");
            f23464a.put(49, "iSCOLLAPSED");
            f23464a.put(50, "starNumber");
            f23464a.put(51, "offerTag");
            f23464a.put(52, "badgeImageUrl");
            f23464a.put(53, "notificationActive");
            f23464a.put(54, "subCashback");
            f23464a.put(55, "following");
            f23464a.put(56, "name");
            f23464a.put(57, "tickerText");
            f23464a.put(58, "viewModel");
            f23464a.put(59, CLPConstants.ARGUMENT_KEY_POSITION);
            f23464a.put(60, "clickHandler");
            f23464a.put(61, "groupAdapter");
            f23464a.put(62, "dataModel");
            f23464a.put(63, "title");
            f23464a.put(64, "reviewDate");
            f23464a.put(65, "imageUrl");
            f23464a.put(66, "isSelected");
            f23464a.put(67, "isApplied");
            f23464a.put(68, "avgRating");
            f23464a.put(69, "IS_COLLAPSED");
            f23464a.put(70, "redirect");
            f23464a.put(71, "product");
            f23464a.put(72, "holder");
            f23464a.put(73, "label");
            f23464a.put(74, "clickhandler");
            f23464a.put(75, "cashback");
            f23464a.put(76, "entityIdentifier");
            f23464a.put(77, "pagerIndicatorVisibility");
            f23464a.put(78, "fragment");
            f23464a.put(79, "seourl");
            f23464a.put(80, "isWishListed");
            f23464a.put(81, "initialFrom");
            f23464a.put(82, "layoutManager");
            f23464a.put(83, "dialogDataModel");
            f23464a.put(84, "showSeparation");
            f23464a.put(85, "showPrice");
            f23464a.put(86, "showRatingBar");
            f23464a.put(87, "initialTo");
            f23464a.put(88, "category");
            f23464a.put(89, "defaultItemData");
            f23464a.put(90, "ratingData");
            f23464a.put(91, "note");
            f23464a.put(92, "flight");
            f23464a.put(93, "cards");
            f23464a.put(94, "orderSummaryBundleResponse");
            f23464a.put(95, "isOnwardJourney");
            f23464a.put(96, "parentViewModel");
            f23464a.put(97, "onwardFlightImage");
            f23464a.put(98, "isDepartureFilter");
            f23464a.put(99, "hotelData");
            f23464a.put(100, "selectedAirline");
            f23464a.put(101, "paymentDetail");
            f23464a.put(102, "oneWayViewModel");
            f23464a.put(103, "airlineInfo");
            f23464a.put(104, "datePriceInfo");
            f23464a.put(105, "sharedViewModel");
            f23464a.put(106, "flightBookingRefund");
            f23464a.put(107, "paymentDetails");
            f23464a.put(108, "info");
            f23464a.put(109, "rootBody");
            f23464a.put(110, "flightInfo");
            f23464a.put(111, "presenter");
            f23464a.put(112, "parentOrder");
            f23464a.put(113, "filterViewModel");
            f23464a.put(114, "toolTip");
            f23464a.put(115, "flightBundleCouponViewHolderCompanion");
            f23464a.put(116, "rootData");
            f23464a.put(117, "passengerInfo");
            f23464a.put(118, "imgNote");
            f23464a.put(119, "irtSplitViewModel");
            f23464a.put(120, "filterInfo");
            f23464a.put(121, "important");
            f23464a.put(122, "discountedStrip");
            f23464a.put(123, "irtViewModel");
            f23464a.put(124, "charges");
            f23464a.put(125, "hotelInfo");
            f23464a.put(126, "returnFlightImage");
            f23464a.put(127, "filterHomeViewModel");
            f23464a.put(128, "passenger");
            f23464a.put(129, "filterRemoveIcon");
            f23464a.put(130, "filterChangeListener");
            f23464a.put(131, BaseViewModel.PaymentType.CARD);
            f23464a.put(132, "formattedPriorityCheckindatamodel");
            f23464a.put(133, "flightItem");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f23465a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(61);
            f23465a = hashMap;
            hashMap.put("layout/activity_flight_mb_charges_0", Integer.valueOf(R.layout.activity_flight_mb_charges));
            f23465a.put("layout/activity_flight_srp_v2_0", Integer.valueOf(R.layout.activity_flight_srp_v2));
            f23465a.put("layout/activity_priority_checkin_0", Integer.valueOf(R.layout.activity_priority_checkin));
            f23465a.put("layout/flight_layout_no_flights_found_0", Integer.valueOf(R.layout.flight_layout_no_flights_found));
            f23465a.put("layout/flight_list_item_airline_price_strip_0", Integer.valueOf(R.layout.flight_list_item_airline_price_strip));
            f23465a.put("layout/flights_mb_charges_item_0", Integer.valueOf(R.layout.flights_mb_charges_item));
            f23465a.put("layout/flights_mb_flight_item_0", Integer.valueOf(R.layout.flights_mb_flight_item));
            f23465a.put("layout/flights_mb_imp_notes_0", Integer.valueOf(R.layout.flights_mb_imp_notes));
            f23465a.put("layout/flights_mb_notes_text_item_0", Integer.valueOf(R.layout.flights_mb_notes_text_item));
            f23465a.put("layout/flights_mb_notes_with_icon_0", Integer.valueOf(R.layout.flights_mb_notes_with_icon));
            f23465a.put("layout/flights_mb_traveler_item_0", Integer.valueOf(R.layout.flights_mb_traveler_item));
            f23465a.put("layout/flights_mb_travelers_item_0", Integer.valueOf(R.layout.flights_mb_travelers_item));
            f23465a.put("layout/fragment_domestic_round_trip_0", Integer.valueOf(R.layout.fragment_domestic_round_trip));
            f23465a.put("layout/fragment_flight_drt_sort_home_0", Integer.valueOf(R.layout.fragment_flight_drt_sort_home));
            f23465a.put("layout/fragment_flight_filter_home_page_0", Integer.valueOf(R.layout.fragment_flight_filter_home_page));
            f23465a.put("layout/fragment_flight_filter_page_0", Integer.valueOf(R.layout.fragment_flight_filter_page));
            f23465a.put("layout/fragment_flight_irt_sort_home_0", Integer.valueOf(R.layout.fragment_flight_irt_sort_home));
            f23465a.put("layout/fragment_flight_no_network_v2_0", Integer.valueOf(R.layout.fragment_flight_no_network_v2));
            f23465a.put("layout/fragment_flight_one_way_sort_home_0", Integer.valueOf(R.layout.fragment_flight_one_way_sort_home));
            f23465a.put("layout/fragment_international_round_trip_0", Integer.valueOf(R.layout.fragment_international_round_trip));
            f23465a.put("layout/fragment_irt_split_view_0", Integer.valueOf(R.layout.fragment_irt_split_view));
            f23465a.put("layout/fragment_srp_loading_0", Integer.valueOf(R.layout.fragment_srp_loading));
            f23465a.put("layout/fragment_srp_modify_0", Integer.valueOf(R.layout.fragment_srp_modify));
            f23465a.put("layout/fragment_srp_one_way_v2_0", Integer.valueOf(R.layout.fragment_srp_one_way_v2));
            f23465a.put("layout/item_drt_discount_strip_0", Integer.valueOf(R.layout.item_drt_discount_strip));
            f23465a.put("layout/item_drt_flight_list_0", Integer.valueOf(R.layout.item_drt_flight_list));
            f23465a.put("layout/item_irt_flight_list_0", Integer.valueOf(R.layout.item_irt_flight_list));
            f23465a.put("layout/item_irt_flight_spit_view_list_0", Integer.valueOf(R.layout.item_irt_flight_spit_view_list));
            f23465a.put("layout/layout_flight_refund_0", Integer.valueOf(R.layout.layout_flight_refund));
            f23465a.put("layout/layout_modified_order_summary_item_0", Integer.valueOf(R.layout.layout_modified_order_summary_item));
            f23465a.put("layout/layout_price_info_bar_0", Integer.valueOf(R.layout.layout_price_info_bar));
            f23465a.put("layout/layout_review_payment_details_0", Integer.valueOf(R.layout.layout_review_payment_details));
            f23465a.put("layout/layout_srp_bottom_strip_oneway_v2_0", Integer.valueOf(R.layout.layout_srp_bottom_strip_oneway_v2));
            f23465a.put("layout/layout_srp_bottom_strip_v2_drt_0", Integer.valueOf(R.layout.layout_srp_bottom_strip_v2_drt));
            f23465a.put("layout/layout_srp_bottom_strip_v2_irt_0", Integer.valueOf(R.layout.layout_srp_bottom_strip_v2_irt));
            f23465a.put("layout/layout_srp_tool_tip_0", Integer.valueOf(R.layout.layout_srp_tool_tip));
            f23465a.put("layout/list_item_modify_ticket_traveller_0", Integer.valueOf(R.layout.list_item_modify_ticket_traveller));
            f23465a.put("layout/list_item_refund_info_0", Integer.valueOf(R.layout.list_item_refund_info));
            f23465a.put("layout/list_item_refund_source_0", Integer.valueOf(R.layout.list_item_refund_source));
            f23465a.put("layout/list_item_review_payment_detail_0", Integer.valueOf(R.layout.list_item_review_payment_detail));
            f23465a.put("layout/list_item_review_payment_item_0", Integer.valueOf(R.layout.list_item_review_payment_item));
            f23465a.put("layout/pre_f_airline_filter_item_0", Integer.valueOf(R.layout.pre_f_airline_filter_item));
            f23465a.put("layout/pre_f_blank_space_0", Integer.valueOf(R.layout.pre_f_blank_space));
            f23465a.put("layout/pre_f_filter_list_strip_0", Integer.valueOf(R.layout.pre_f_filter_list_strip));
            f23465a.put("layout/pre_f_flight_date_price_item_v2_0", Integer.valueOf(R.layout.pre_f_flight_date_price_item_v2));
            f23465a.put("layout/pre_f_flight_fare_alert_message_lyt_0", Integer.valueOf(R.layout.pre_f_flight_fare_alert_message_lyt));
            f23465a.put("layout/pre_f_flight_filter_item_v2_0", Integer.valueOf(R.layout.pre_f_flight_filter_item_v2));
            f23465a.put("layout/pre_f_flight_srp_v2_action_bar_0", Integer.valueOf(R.layout.pre_f_flight_srp_v2_action_bar));
            f23465a.put("layout/pre_f_flight_srp_v2_action_bar_loader_fragment_0", Integer.valueOf(R.layout.pre_f_flight_srp_v2_action_bar_loader_fragment));
            f23465a.put("layout/pre_f_item_flight_child_search_list_revamp2_0", Integer.valueOf(R.layout.pre_f_item_flight_child_search_list_revamp2));
            f23465a.put("layout/pre_f_item_flight_search_airline_filter_0", Integer.valueOf(R.layout.pre_f_item_flight_search_airline_filter));
            f23465a.put("layout/pre_f_item_flight_search_banner_0", Integer.valueOf(R.layout.pre_f_item_flight_search_banner));
            f23465a.put("layout/pre_f_item_flight_search_duration_0", Integer.valueOf(R.layout.pre_f_item_flight_search_duration));
            f23465a.put("layout/pre_f_item_flight_search_list_revamp2_0", Integer.valueOf(R.layout.pre_f_item_flight_search_list_revamp2));
            f23465a.put("layout/pre_f_item_flight_search_price_filter_0", Integer.valueOf(R.layout.pre_f_item_flight_search_price_filter));
            f23465a.put("layout/pre_f_item_flight_search_time_filter_0", Integer.valueOf(R.layout.pre_f_item_flight_search_time_filter));
            f23465a.put("layout/pre_f_item_view_order_summary_hotel_option_0", Integer.valueOf(R.layout.pre_f_item_view_order_summary_hotel_option));
            f23465a.put("layout/pre_f_layout_order_summary_hotel_options_0", Integer.valueOf(R.layout.pre_f_layout_order_summary_hotel_options));
            f23465a.put("layout/pre_f_row_srp_filter_header_0", Integer.valueOf(R.layout.pre_f_row_srp_filter_header));
            f23465a.put("layout/pre_f_row_srp_header_0", Integer.valueOf(R.layout.pre_f_row_srp_header));
            f23465a.put("layout/row_flight_order_summary_bundle_coupon_0", Integer.valueOf(R.layout.row_flight_order_summary_bundle_coupon));
        }
    }
}
