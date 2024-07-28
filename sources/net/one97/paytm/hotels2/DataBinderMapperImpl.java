package net.one97.paytm.hotels2;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.hotels2.b.ab;
import net.one97.paytm.hotels2.b.ad;
import net.one97.paytm.hotels2.b.af;
import net.one97.paytm.hotels2.b.ah;
import net.one97.paytm.hotels2.b.aj;
import net.one97.paytm.hotels2.b.al;
import net.one97.paytm.hotels2.b.an;
import net.one97.paytm.hotels2.b.ap;
import net.one97.paytm.hotels2.b.ar;
import net.one97.paytm.hotels2.b.at;
import net.one97.paytm.hotels2.b.av;
import net.one97.paytm.hotels2.b.ax;
import net.one97.paytm.hotels2.b.az;
import net.one97.paytm.hotels2.b.bb;
import net.one97.paytm.hotels2.b.bd;
import net.one97.paytm.hotels2.b.bf;
import net.one97.paytm.hotels2.b.bh;
import net.one97.paytm.hotels2.b.bj;
import net.one97.paytm.hotels2.b.bl;
import net.one97.paytm.hotels2.b.bn;
import net.one97.paytm.hotels2.b.bp;
import net.one97.paytm.hotels2.b.br;
import net.one97.paytm.hotels2.b.bt;
import net.one97.paytm.hotels2.b.bv;
import net.one97.paytm.hotels2.b.bx;
import net.one97.paytm.hotels2.b.bz;
import net.one97.paytm.hotels2.b.cb;
import net.one97.paytm.hotels2.b.cd;
import net.one97.paytm.hotels2.b.cf;
import net.one97.paytm.hotels2.b.ch;
import net.one97.paytm.hotels2.b.cj;
import net.one97.paytm.hotels2.b.cl;
import net.one97.paytm.hotels2.b.cn;
import net.one97.paytm.hotels2.b.cp;
import net.one97.paytm.hotels2.b.cr;
import net.one97.paytm.hotels2.b.ct;
import net.one97.paytm.hotels2.b.cv;
import net.one97.paytm.hotels2.b.cx;
import net.one97.paytm.hotels2.b.cz;
import net.one97.paytm.hotels2.b.db;
import net.one97.paytm.hotels2.b.dd;
import net.one97.paytm.hotels2.b.df;
import net.one97.paytm.hotels2.b.dh;
import net.one97.paytm.hotels2.b.dj;
import net.one97.paytm.hotels2.b.dl;
import net.one97.paytm.hotels2.b.dn;
import net.one97.paytm.hotels2.b.dp;
import net.one97.paytm.hotels2.b.dr;
import net.one97.paytm.hotels2.b.dt;
import net.one97.paytm.hotels2.b.dv;
import net.one97.paytm.hotels2.b.dx;
import net.one97.paytm.hotels2.b.dz;
import net.one97.paytm.hotels2.b.eb;
import net.one97.paytm.hotels2.b.ed;
import net.one97.paytm.hotels2.b.ef;
import net.one97.paytm.hotels2.b.eh;
import net.one97.paytm.hotels2.b.ej;
import net.one97.paytm.hotels2.b.el;
import net.one97.paytm.hotels2.b.en;
import net.one97.paytm.hotels2.b.ep;
import net.one97.paytm.hotels2.b.er;
import net.one97.paytm.hotels2.b.et;
import net.one97.paytm.hotels2.b.ev;
import net.one97.paytm.hotels2.b.ex;
import net.one97.paytm.hotels2.b.ez;
import net.one97.paytm.hotels2.b.f;
import net.one97.paytm.hotels2.b.fb;
import net.one97.paytm.hotels2.b.fd;
import net.one97.paytm.hotels2.b.ff;
import net.one97.paytm.hotels2.b.fh;
import net.one97.paytm.hotels2.b.fj;
import net.one97.paytm.hotels2.b.fl;
import net.one97.paytm.hotels2.b.fn;
import net.one97.paytm.hotels2.b.fp;
import net.one97.paytm.hotels2.b.fr;
import net.one97.paytm.hotels2.b.ft;
import net.one97.paytm.hotels2.b.fv;
import net.one97.paytm.hotels2.b.fx;
import net.one97.paytm.hotels2.b.fz;
import net.one97.paytm.hotels2.b.gb;
import net.one97.paytm.hotels2.b.gd;
import net.one97.paytm.hotels2.b.gf;
import net.one97.paytm.hotels2.b.gh;
import net.one97.paytm.hotels2.b.gj;
import net.one97.paytm.hotels2.b.gl;
import net.one97.paytm.hotels2.b.gn;
import net.one97.paytm.hotels2.b.gp;
import net.one97.paytm.hotels2.b.gr;
import net.one97.paytm.hotels2.b.gt;
import net.one97.paytm.hotels2.b.h;
import net.one97.paytm.hotels2.b.j;
import net.one97.paytm.hotels2.b.l;
import net.one97.paytm.hotels2.b.n;
import net.one97.paytm.hotels2.b.p;
import net.one97.paytm.hotels2.b.r;
import net.one97.paytm.hotels2.b.t;
import net.one97.paytm.hotels2.b.v;
import net.one97.paytm.hotels2.b.x;
import net.one97.paytm.hotels2.b.z;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_H4CANCELORDERLYOUT = 1;
    private static final int LAYOUT_H4CANCELORDERPAYMENTDETAILS = 2;
    private static final int LAYOUT_H4CANCELORDERREASON = 3;
    private static final int LAYOUT_H4CANCELORDERREFUNDSUMMARY = 4;
    private static final int LAYOUT_H4CANCELORDERROOMDETAILS = 5;
    private static final int LAYOUT_H4CANCELORDERSUMMARYDATESLYOUT = 6;
    private static final int LAYOUT_H4DETAILSABOUTHOTEL = 7;
    private static final int LAYOUT_H4DETAILSADDRESS = 8;
    private static final int LAYOUT_H4DETAILSAMENITIES = 9;
    private static final int LAYOUT_H4DETAILSCINCOUT = 10;
    private static final int LAYOUT_H4DETAILSHEADER = 11;
    private static final int LAYOUT_H4DETAILSIMAGESELECTOR = 12;
    private static final int LAYOUT_H4DETAILSPOLICIES = 13;
    private static final int LAYOUT_H4DETAILSSCREEN = 14;
    private static final int LAYOUT_H4EDITSEARCHQUERYVIEW = 15;
    private static final int LAYOUT_H4FAREBREAKUPBOTTOMSHEET = 16;
    private static final int LAYOUT_H4FILTERAMENITIESHOTELTYPEVIEW = 17;
    private static final int LAYOUT_H4FILTERHOTELCHAINVIEW = 18;
    private static final int LAYOUT_H4FILTERHOTELTHEMEVIEW = 19;
    private static final int LAYOUT_H4FILTERLOCALITYHOTELCHAINBOTTOMSHEET = 20;
    private static final int LAYOUT_H4FILTERLOCALITYVIEW = 21;
    private static final int LAYOUT_H4FILTERPRICESTARTVIEW = 22;
    private static final int LAYOUT_H4FRAGMENTERRORDIALOG = 23;
    private static final int LAYOUT_H4FRAGMENTFULLMAP = 24;
    private static final int LAYOUT_H4FRAGMENTHOTELOFFERS = 25;
    private static final int LAYOUT_H4FRAGMENTMAP = 26;
    private static final int LAYOUT_H4FRAGMENTSHOWDATA = 27;
    private static final int LAYOUT_H4GALLERYFRAGMENT = 28;
    private static final int LAYOUT_H4GALLERYHEADER = 29;
    private static final int LAYOUT_H4GALLERYITEMSELECTIONFRAGMENT = 30;
    private static final int LAYOUT_H4GALLERYLISTFRAGMENT = 31;
    private static final int LAYOUT_H4GALLERYSELECTEDITEM = 32;
    private static final int LAYOUT_H4HOMEACTIVITY = 33;
    private static final int LAYOUT_H4HOTELBOOKINGACTIVITY = 34;
    private static final int LAYOUT_H4HOTELSOLDOUTLYT = 35;
    private static final int LAYOUT_H4IMAGETEXTBOTTOMSHEET = 36;
    private static final int LAYOUT_H4LAYOUTHOTELSUMMARYPAYMENTDETAILS = 37;
    private static final int LAYOUT_H4LAYOUTORDERSUMMARYDATES = 38;
    private static final int LAYOUT_H4LAYOUTORDERSUMMARYPOLICYTNC = 39;
    private static final int LAYOUT_H4LAYOUTSIMILARHOTELS = 40;
    private static final int LAYOUT_H4LISTITEMAMENITY = 41;
    private static final int LAYOUT_H4LISTITEMMAPHOTELS = 42;
    private static final int LAYOUT_H4LISTITEMPAIR = 43;
    private static final int LAYOUT_H4LISTITEMROOMPRICE = 44;
    private static final int LAYOUT_H4LISTITEMSIMILARHOTELS = 45;
    private static final int LAYOUT_H4LOCALITYHOTELCHAINFILTERLISTITEM = 46;
    private static final int LAYOUT_H4NOROOMSBOTTOMSHEET = 47;
    private static final int LAYOUT_H4ORDERSUMMARYACTIVITY = 48;
    private static final int LAYOUT_H4RBCINCOUT = 49;
    private static final int LAYOUT_H4RBGST = 50;
    private static final int LAYOUT_H4RBGSTINFO = 51;
    private static final int LAYOUT_H4RBGUESTDETAILS = 52;
    private static final int LAYOUT_H4RBHEADER = 53;
    private static final int LAYOUT_H4RBHOTELDETAILES = 54;
    private static final int LAYOUT_H4RBPAYMENTSUMMENRY = 55;
    private static final int LAYOUT_H4RBPROCESSPAY = 56;
    private static final int LAYOUT_H4RBPROMOCODE = 57;
    private static final int LAYOUT_H4RBPROMOCODEAPPLY = 58;
    private static final int LAYOUT_H4RBPROMOCODECELL = 59;
    private static final int LAYOUT_H4RBROOMDETAILES = 60;
    private static final int LAYOUT_H4REVIEWSCREEN = 61;
    private static final int LAYOUT_H4ROOMSELECTEDPOPUP = 62;
    private static final int LAYOUT_H4ROOMSELECTIONCONTINUE = 63;
    private static final int LAYOUT_H4ROOMSELECTIONHEADER = 64;
    private static final int LAYOUT_H4ROOMSELECTIONVPAGER = 65;
    private static final int LAYOUT_H4RSADDREDUCEROOM = 66;
    private static final int LAYOUT_H4RSSELECTROOM = 67;
    private static final int LAYOUT_H4RSSELECTROOMSTICKY = 68;
    private static final int LAYOUT_H4RSSTICKYHEADER = 69;
    private static final int LAYOUT_H4SELECTROOMIMAGEGALLERY = 70;
    private static final int LAYOUT_H4SORTVIEWLISTITEM = 71;
    private static final int LAYOUT_H4SRPBOTTOMSORTFILTERVIEW = 72;
    private static final int LAYOUT_H4SRPERRORLYOUT = 73;
    private static final int LAYOUT_H4SRPFILTERHEADER = 74;
    private static final int LAYOUT_H4SRPFILTERLAYOUT = 75;
    private static final int LAYOUT_H4SRPFILTERPRICERANGELISTITEM = 76;
    private static final int LAYOUT_H4SRPINPUTEDITBOTTOMSHEET = 77;
    private static final int LAYOUT_H4SRPNORESULTLYOUT = 78;
    private static final int LAYOUT_H4SRPSORTVIEW = 79;
    private static final int LAYOUT_HOTEL4AMENITIESLISTITEMS = 80;
    private static final int LAYOUT_HOTEL4AUTOSEARCHITEM = 81;
    private static final int LAYOUT_HOTEL4BULLETLIST = 82;
    private static final int LAYOUT_HOTEL4FILTERAMENITIESLISTITEM = 83;
    private static final int LAYOUT_HOTEL4GALLERYIMAGELISTITEMS = 84;
    private static final int LAYOUT_HOTEL4IMAGELISTITEM = 85;
    private static final int LAYOUT_HOTEL4IMAGETEXTBOTTOMSHEETITEMS = 86;
    private static final int LAYOUT_HOTEL4LOADER = 87;
    private static final int LAYOUT_HOTEL4POPULARSEARCH = 88;
    private static final int LAYOUT_HOTEL4ROOMCONFIG = 89;
    private static final int LAYOUT_HOTEL4ROOMCONFIGTAX = 90;
    private static final int LAYOUT_HOTEL4ROOMSELECTIONAMENITIESLISTITEMS = 91;
    private static final int LAYOUT_HOTEL4SEARCHFRAGMENT = 92;
    private static final int LAYOUT_HOTEL4SELECTEDCITYLISTITEMS = 93;
    private static final int LAYOUT_HOTEL4SRPHEADER = 94;
    private static final int LAYOUT_HOTEL4SRPLISTITEMS = 95;
    private static final int LAYOUT_HOTEL4SRPLOADER = 96;
    private static final int LAYOUT_HOTEL4SRPVIEW = 97;
    private static final int LAYOUT_HOTELSNEARME = 98;
    private static final int LAYOUT_LAYOUTDETAILSSCREENSHIMMER = 99;
    private static final int LAYOUT_LAYOUTERRORFRAGMENT = 100;
    private static final int LAYOUT_LAYOUTHOTELBOOKINGSHIMMER = 101;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(101);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.h4_cancel_order_lyout, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_cancel_order_paymentdetails, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_cancel_order_reason, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_cancel_order_refund_summary, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_cancel_order_room_details, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_cancel_order_summary_dates_lyout, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_details_about_hotel, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_details_address, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_details_amenities, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_details_cin_cout, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_details_header, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_details_image_selector, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_details_policies, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_details_screen, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_edit_search_query_view, 15);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_fare_breakup_bottom_sheet, 16);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_filter_amenities_hotel_type_view, 17);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_filter_hotel_chain_view, 18);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_filter_hotel_theme_view, 19);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_filter_locality_hotel_chain_bottom_sheet, 20);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_filter_locality_view, 21);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_filter_price_start_view, 22);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_fragment_error_dialog, 23);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_fragment_full_map, 24);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_fragment_hotel_offers, 25);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_fragment_map, 26);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_fragment_show_data, 27);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_gallery_fragment, 28);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_gallery_header, 29);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_gallery_item_selection_fragment, 30);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_gallery_list_fragment, 31);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_gallery_selected_item, 32);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_home_activity, 33);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_hotel_booking_activity, 34);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_hotel_sold_out_lyt, 35);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_image_text_bottom_sheet, 36);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_layout_hotel_summary_payment_details, 37);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_layout_order_summary_dates, 38);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_layout_order_summary_policy_tnc, 39);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_layout_similar_hotels, 40);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_list_item_amenity, 41);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_list_item_map_hotels, 42);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_list_item_pair, 43);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_list_item_room_price, 44);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_list_item_similar_hotels, 45);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_locality_hotel_chain_filter_list_item, 46);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_no_rooms_bottom_sheet, 47);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_order_summary_activity, 48);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rb_cin_cout, 49);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rb_gst, 50);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rb_gst_info, 51);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rb_guest_details, 52);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rb_header, 53);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rb_hotel_detailes, 54);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rb_payment_summenry, 55);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rb_process_pay, 56);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rb_promo_code, 57);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rb_promo_code_apply, 58);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rb_promocode_cell, 59);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rb_room_detailes, 60);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_review_screen, 61);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_room_selected_popup, 62);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_room_selection_continue, 63);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_room_selection_header, 64);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_room_selection_vpager, 65);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rs_add_reduce_room, 66);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rs_select_room, 67);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rs_select_room_sticky, 68);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_rs_sticky_header, 69);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_select_room_image_gallery, 70);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_sort_view_list_item, 71);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_srp_bottom_sort_filter_view, 72);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_srp_error_lyout, 73);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_srp_filter_header, 74);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_srp_filter_layout, 75);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_srp_filter_price_range_list_item, 76);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_srp_inputedit_bottom_sheet, 77);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_srp_no_result_lyout, 78);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.h4_srp_sort_view, 79);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_amenities_list_items, 80);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_auto_search_item, 81);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_bullet_list, 82);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_filter_amenities_list_item, 83);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_gallery_image_list_items, 84);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_image_list_item, 85);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_image_text_bottomsheet_items, 86);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_loader, 87);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_popular_search, 88);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_room_config, 89);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_room_config_tax, 90);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_room_selection_amenities_list_items, 91);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_search_fragment, 92);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_selected_city_list_items, 93);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_srp_header, 94);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_srp_list_items, 95);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_srp_loader, 96);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotel4_srp_view, 97);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.hotels_near_me, 98);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_details_screen_shimmer, 99);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_error_fragment, 100);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_hotel_booking_shimmer, 101);
    }

    private final ViewDataBinding internalGetViewDataBinding0(e eVar, View view, int i2, Object obj) {
        switch (i2) {
            case 1:
                if ("layout/h4_cancel_order_lyout_0".equals(obj)) {
                    return new net.one97.paytm.hotels2.b.b(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_cancel_order_lyout is invalid. Received: ".concat(String.valueOf(obj)));
            case 2:
                if ("layout/h4_cancel_order_paymentdetails_0".equals(obj)) {
                    return new net.one97.paytm.hotels2.b.d(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_cancel_order_paymentdetails is invalid. Received: ".concat(String.valueOf(obj)));
            case 3:
                if ("layout/h4_cancel_order_reason_0".equals(obj)) {
                    return new f(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_cancel_order_reason is invalid. Received: ".concat(String.valueOf(obj)));
            case 4:
                if ("layout/h4_cancel_order_refund_summary_0".equals(obj)) {
                    return new h(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_cancel_order_refund_summary is invalid. Received: ".concat(String.valueOf(obj)));
            case 5:
                if ("layout/h4_cancel_order_room_details_0".equals(obj)) {
                    return new j(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_cancel_order_room_details is invalid. Received: ".concat(String.valueOf(obj)));
            case 6:
                if ("layout/h4_cancel_order_summary_dates_lyout_0".equals(obj)) {
                    return new l(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_cancel_order_summary_dates_lyout is invalid. Received: ".concat(String.valueOf(obj)));
            case 7:
                if ("layout/h4_details_about_hotel_0".equals(obj)) {
                    return new n(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_details_about_hotel is invalid. Received: ".concat(String.valueOf(obj)));
            case 8:
                if ("layout/h4_details_address_0".equals(obj)) {
                    return new p(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_details_address is invalid. Received: ".concat(String.valueOf(obj)));
            case 9:
                if ("layout/h4_details_amenities_0".equals(obj)) {
                    return new r(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_details_amenities is invalid. Received: ".concat(String.valueOf(obj)));
            case 10:
                if ("layout/h4_details_cin_cout_0".equals(obj)) {
                    return new t(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_details_cin_cout is invalid. Received: ".concat(String.valueOf(obj)));
            case 11:
                if ("layout/h4_details_header_0".equals(obj)) {
                    return new v(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_details_header is invalid. Received: ".concat(String.valueOf(obj)));
            case 12:
                if ("layout/h4_details_image_selector_0".equals(obj)) {
                    return new x(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_details_image_selector is invalid. Received: ".concat(String.valueOf(obj)));
            case 13:
                if ("layout/h4_details_policies_0".equals(obj)) {
                    return new z(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_details_policies is invalid. Received: ".concat(String.valueOf(obj)));
            case 14:
                if ("layout/h4_details_screen_0".equals(obj)) {
                    return new ab(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_details_screen is invalid. Received: ".concat(String.valueOf(obj)));
            case 15:
                if ("layout/h4_edit_search_query_view_0".equals(obj)) {
                    return new ad(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_edit_search_query_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 16:
                if ("layout/h4_fare_breakup_bottom_sheet_0".equals(obj)) {
                    return new af(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_fare_breakup_bottom_sheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 17:
                if ("layout/h4_filter_amenities_hotel_type_view_0".equals(obj)) {
                    return new ah(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_filter_amenities_hotel_type_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 18:
                if ("layout/h4_filter_hotel_chain_view_0".equals(obj)) {
                    return new aj(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_filter_hotel_chain_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 19:
                if ("layout/h4_filter_hotel_theme_view_0".equals(obj)) {
                    return new al(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_filter_hotel_theme_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 20:
                if ("layout/h4_filter_locality_hotel_chain_bottom_sheet_0".equals(obj)) {
                    return new an(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_filter_locality_hotel_chain_bottom_sheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 21:
                if ("layout/h4_filter_locality_view_0".equals(obj)) {
                    return new ap(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_filter_locality_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 22:
                if ("layout/h4_filter_price_start_view_0".equals(obj)) {
                    return new ar(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_filter_price_start_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 23:
                if ("layout/h4_fragment_error_dialog_0".equals(obj)) {
                    return new at(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_fragment_error_dialog is invalid. Received: ".concat(String.valueOf(obj)));
            case 24:
                if ("layout/h4_fragment_full_map_0".equals(obj)) {
                    return new av(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_fragment_full_map is invalid. Received: ".concat(String.valueOf(obj)));
            case 25:
                if ("layout/h4_fragment_hotel_offers_0".equals(obj)) {
                    return new ax(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_fragment_hotel_offers is invalid. Received: ".concat(String.valueOf(obj)));
            case 26:
                if ("layout/h4_fragment_map_0".equals(obj)) {
                    return new az(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_fragment_map is invalid. Received: ".concat(String.valueOf(obj)));
            case 27:
                if ("layout/h4_fragment_show_data_0".equals(obj)) {
                    return new bb(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_fragment_show_data is invalid. Received: ".concat(String.valueOf(obj)));
            case 28:
                if ("layout/h4_gallery_fragment_0".equals(obj)) {
                    return new bd(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_gallery_fragment is invalid. Received: ".concat(String.valueOf(obj)));
            case 29:
                if ("layout/h4_gallery_header_0".equals(obj)) {
                    return new bf(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_gallery_header is invalid. Received: ".concat(String.valueOf(obj)));
            case 30:
                if ("layout/h4_gallery_item_selection_fragment_0".equals(obj)) {
                    return new bh(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_gallery_item_selection_fragment is invalid. Received: ".concat(String.valueOf(obj)));
            case 31:
                if ("layout/h4_gallery_list_fragment_0".equals(obj)) {
                    return new bj(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_gallery_list_fragment is invalid. Received: ".concat(String.valueOf(obj)));
            case 32:
                if ("layout/h4_gallery_selected_item_0".equals(obj)) {
                    return new bl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_gallery_selected_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 33:
                if ("layout/h4_home_activity_0".equals(obj)) {
                    return new bn(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_home_activity is invalid. Received: ".concat(String.valueOf(obj)));
            case 34:
                if ("layout/h4_hotel_booking_activity_0".equals(obj)) {
                    return new bp(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_hotel_booking_activity is invalid. Received: ".concat(String.valueOf(obj)));
            case 35:
                if ("layout/h4_hotel_sold_out_lyt_0".equals(obj)) {
                    return new br(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_hotel_sold_out_lyt is invalid. Received: ".concat(String.valueOf(obj)));
            case 36:
                if ("layout/h4_image_text_bottom_sheet_0".equals(obj)) {
                    return new bt(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_image_text_bottom_sheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 37:
                if ("layout/h4_layout_hotel_summary_payment_details_0".equals(obj)) {
                    return new bv(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_layout_hotel_summary_payment_details is invalid. Received: ".concat(String.valueOf(obj)));
            case 38:
                if ("layout/h4_layout_order_summary_dates_0".equals(obj)) {
                    return new bx(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_layout_order_summary_dates is invalid. Received: ".concat(String.valueOf(obj)));
            case 39:
                if ("layout/h4_layout_order_summary_policy_tnc_0".equals(obj)) {
                    return new bz(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_layout_order_summary_policy_tnc is invalid. Received: ".concat(String.valueOf(obj)));
            case 40:
                if ("layout/h4_layout_similar_hotels_0".equals(obj)) {
                    return new cb(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_layout_similar_hotels is invalid. Received: ".concat(String.valueOf(obj)));
            case 41:
                if ("layout/h4_list_item_amenity_0".equals(obj)) {
                    return new cd(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_list_item_amenity is invalid. Received: ".concat(String.valueOf(obj)));
            case 42:
                if ("layout/h4_list_item_map_hotels_0".equals(obj)) {
                    return new cf(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_list_item_map_hotels is invalid. Received: ".concat(String.valueOf(obj)));
            case 43:
                if ("layout/h4_list_item_pair_0".equals(obj)) {
                    return new ch(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_list_item_pair is invalid. Received: ".concat(String.valueOf(obj)));
            case 44:
                if ("layout/h4_list_item_room_price_0".equals(obj)) {
                    return new cj(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_list_item_room_price is invalid. Received: ".concat(String.valueOf(obj)));
            case 45:
                if ("layout/h4_list_item_similar_hotels_0".equals(obj)) {
                    return new cl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_list_item_similar_hotels is invalid. Received: ".concat(String.valueOf(obj)));
            case 46:
                if ("layout/h4_locality_hotel_chain_filter_list_item_0".equals(obj)) {
                    return new cn(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_locality_hotel_chain_filter_list_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 47:
                if ("layout/h4_no_rooms_bottom_sheet_0".equals(obj)) {
                    return new cp(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_no_rooms_bottom_sheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 48:
                if ("layout/h4_order_summary_activity_0".equals(obj)) {
                    return new cr(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_order_summary_activity is invalid. Received: ".concat(String.valueOf(obj)));
            case 49:
                if ("layout/h4_rb_cin_cout_0".equals(obj)) {
                    return new ct(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rb_cin_cout is invalid. Received: ".concat(String.valueOf(obj)));
            case 50:
                if ("layout/h4_rb_gst_0".equals(obj)) {
                    return new cv(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rb_gst is invalid. Received: ".concat(String.valueOf(obj)));
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(e eVar, View view, int i2, Object obj) {
        switch (i2) {
            case 51:
                if ("layout/h4_rb_gst_info_0".equals(obj)) {
                    return new cx(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rb_gst_info is invalid. Received: ".concat(String.valueOf(obj)));
            case 52:
                if ("layout/h4_rb_guest_details_0".equals(obj)) {
                    return new cz(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rb_guest_details is invalid. Received: ".concat(String.valueOf(obj)));
            case 53:
                if ("layout/h4_rb_header_0".equals(obj)) {
                    return new db(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rb_header is invalid. Received: ".concat(String.valueOf(obj)));
            case 54:
                if ("layout/h4_rb_hotel_detailes_0".equals(obj)) {
                    return new dd(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rb_hotel_detailes is invalid. Received: ".concat(String.valueOf(obj)));
            case 55:
                if ("layout/h4_rb_payment_summenry_0".equals(obj)) {
                    return new df(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rb_payment_summenry is invalid. Received: ".concat(String.valueOf(obj)));
            case 56:
                if ("layout/h4_rb_process_pay_0".equals(obj)) {
                    return new dh(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rb_process_pay is invalid. Received: ".concat(String.valueOf(obj)));
            case 57:
                if ("layout/h4_rb_promo_code_0".equals(obj)) {
                    return new dl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rb_promo_code is invalid. Received: ".concat(String.valueOf(obj)));
            case 58:
                if ("layout/h4_rb_promo_code_apply_0".equals(obj)) {
                    return new dj(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rb_promo_code_apply is invalid. Received: ".concat(String.valueOf(obj)));
            case 59:
                if ("layout/h4_rb_promocode_cell_0".equals(obj)) {
                    return new dn(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rb_promocode_cell is invalid. Received: ".concat(String.valueOf(obj)));
            case 60:
                if ("layout/h4_rb_room_detailes_0".equals(obj)) {
                    return new dp(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rb_room_detailes is invalid. Received: ".concat(String.valueOf(obj)));
            case 61:
                if ("layout/h4_review_screen_0".equals(obj)) {
                    return new dr(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_review_screen is invalid. Received: ".concat(String.valueOf(obj)));
            case 62:
                if ("layout/h4_room_selected_popup_0".equals(obj)) {
                    return new dt(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_room_selected_popup is invalid. Received: ".concat(String.valueOf(obj)));
            case 63:
                if ("layout/h4_room_selection_continue_0".equals(obj)) {
                    return new dv(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_room_selection_continue is invalid. Received: ".concat(String.valueOf(obj)));
            case 64:
                if ("layout/h4_room_selection_header_0".equals(obj)) {
                    return new dx(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_room_selection_header is invalid. Received: ".concat(String.valueOf(obj)));
            case 65:
                if ("layout/h4_room_selection_vpager_0".equals(obj)) {
                    return new dz(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_room_selection_vpager is invalid. Received: ".concat(String.valueOf(obj)));
            case 66:
                if ("layout/h4_rs_add_reduce_room_0".equals(obj)) {
                    return new eb(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rs_add_reduce_room is invalid. Received: ".concat(String.valueOf(obj)));
            case 67:
                if ("layout/h4_rs_select_room_0".equals(obj)) {
                    return new ed(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rs_select_room is invalid. Received: ".concat(String.valueOf(obj)));
            case 68:
                if ("layout/h4_rs_select_room_sticky_0".equals(obj)) {
                    return new ef(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rs_select_room_sticky is invalid. Received: ".concat(String.valueOf(obj)));
            case 69:
                if ("layout/h4_rs_sticky_header_0".equals(obj)) {
                    return new eh(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_rs_sticky_header is invalid. Received: ".concat(String.valueOf(obj)));
            case 70:
                if ("layout/h4_select_room_image_gallery_0".equals(obj)) {
                    return new ej(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_select_room_image_gallery is invalid. Received: ".concat(String.valueOf(obj)));
            case 71:
                if ("layout/h4_sort_view_list_item_0".equals(obj)) {
                    return new el(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_sort_view_list_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 72:
                if ("layout/h4_srp_bottom_sort_filter_view_0".equals(obj)) {
                    return new en(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_srp_bottom_sort_filter_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 73:
                if ("layout/h4_srp_error_lyout_0".equals(obj)) {
                    return new ep(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_srp_error_lyout is invalid. Received: ".concat(String.valueOf(obj)));
            case 74:
                if ("layout/h4_srp_filter_header_0".equals(obj)) {
                    return new er(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_srp_filter_header is invalid. Received: ".concat(String.valueOf(obj)));
            case 75:
                if ("layout/h4_srp_filter_layout_0".equals(obj)) {
                    return new et(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_srp_filter_layout is invalid. Received: ".concat(String.valueOf(obj)));
            case 76:
                if ("layout/h4_srp_filter_price_range_list_item_0".equals(obj)) {
                    return new ev(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_srp_filter_price_range_list_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 77:
                if ("layout/h4_srp_inputedit_bottom_sheet_0".equals(obj)) {
                    return new ex(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_srp_inputedit_bottom_sheet is invalid. Received: ".concat(String.valueOf(obj)));
            case 78:
                if ("layout/h4_srp_no_result_lyout_0".equals(obj)) {
                    return new ez(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_srp_no_result_lyout is invalid. Received: ".concat(String.valueOf(obj)));
            case 79:
                if ("layout/h4_srp_sort_view_0".equals(obj)) {
                    return new fb(eVar, view);
                }
                throw new IllegalArgumentException("The tag for h4_srp_sort_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 80:
                if ("layout/hotel4_amenities_list_items_0".equals(obj)) {
                    return new fd(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_amenities_list_items is invalid. Received: ".concat(String.valueOf(obj)));
            case 81:
                if ("layout/hotel4_auto_search_item_0".equals(obj)) {
                    return new ff(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_auto_search_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 82:
                if ("layout/hotel4_bullet_list_0".equals(obj)) {
                    return new fh(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_bullet_list is invalid. Received: ".concat(String.valueOf(obj)));
            case 83:
                if ("layout/hotel4_filter_amenities_list_item_0".equals(obj)) {
                    return new fj(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_filter_amenities_list_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 84:
                if ("layout/hotel4_gallery_image_list_items_0".equals(obj)) {
                    return new fl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_gallery_image_list_items is invalid. Received: ".concat(String.valueOf(obj)));
            case 85:
                if ("layout/hotel4_image_list_item_0".equals(obj)) {
                    return new fn(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_image_list_item is invalid. Received: ".concat(String.valueOf(obj)));
            case 86:
                if ("layout/hotel4_image_text_bottomsheet_items_0".equals(obj)) {
                    return new fp(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_image_text_bottomsheet_items is invalid. Received: ".concat(String.valueOf(obj)));
            case 87:
                if ("layout/hotel4_loader_0".equals(obj)) {
                    return new fr(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_loader is invalid. Received: ".concat(String.valueOf(obj)));
            case 88:
                if ("layout/hotel4_popular_search_0".equals(obj)) {
                    return new ft(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_popular_search is invalid. Received: ".concat(String.valueOf(obj)));
            case 89:
                if ("layout/hotel4_room_config_0".equals(obj)) {
                    return new fv(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_room_config is invalid. Received: ".concat(String.valueOf(obj)));
            case 90:
                if ("layout/hotel4_room_config_tax_0".equals(obj)) {
                    return new fx(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_room_config_tax is invalid. Received: ".concat(String.valueOf(obj)));
            case 91:
                if ("layout/hotel4_room_selection_amenities_list_items_0".equals(obj)) {
                    return new fz(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_room_selection_amenities_list_items is invalid. Received: ".concat(String.valueOf(obj)));
            case 92:
                if ("layout/hotel4_search_fragment_0".equals(obj)) {
                    return new gb(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_search_fragment is invalid. Received: ".concat(String.valueOf(obj)));
            case 93:
                if ("layout/hotel4_selected_city_list_items_0".equals(obj)) {
                    return new gd(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_selected_city_list_items is invalid. Received: ".concat(String.valueOf(obj)));
            case 94:
                if ("layout/hotel4_srp_header_0".equals(obj)) {
                    return new gf(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_srp_header is invalid. Received: ".concat(String.valueOf(obj)));
            case 95:
                if ("layout/hotel4_srp_list_items_0".equals(obj)) {
                    return new gh(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_srp_list_items is invalid. Received: ".concat(String.valueOf(obj)));
            case 96:
                if ("layout/hotel4_srp_loader_0".equals(obj)) {
                    return new gj(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_srp_loader is invalid. Received: ".concat(String.valueOf(obj)));
            case 97:
                if ("layout/hotel4_srp_view_0".equals(obj)) {
                    return new gl(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotel4_srp_view is invalid. Received: ".concat(String.valueOf(obj)));
            case 98:
                if ("layout/hotels_near_me_0".equals(obj)) {
                    return new gn(eVar, view);
                }
                throw new IllegalArgumentException("The tag for hotels_near_me is invalid. Received: ".concat(String.valueOf(obj)));
            case 99:
                if ("layout/layout_details_screen_shimmer_0".equals(obj)) {
                    return new gp(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_details_screen_shimmer is invalid. Received: ".concat(String.valueOf(obj)));
            case 100:
                if ("layout/layout_error_fragment_0".equals(obj)) {
                    return new gr(eVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_error_fragment is invalid. Received: ".concat(String.valueOf(obj)));
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding2(e eVar, View view, int i2, Object obj) {
        if (i2 != 101) {
            return null;
        }
        if ("layout/layout_hotel_booking_shimmer_0".equals(obj)) {
            return new gt(eVar, view);
        }
        throw new IllegalArgumentException("The tag for layout_hotel_booking_shimmer is invalid. Received: ".concat(String.valueOf(obj)));
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
            if (i4 == 1) {
                return internalGetViewDataBinding1(eVar, view, i3, tag);
            }
            if (i4 != 2) {
                return null;
            }
            return internalGetViewDataBinding2(eVar, view, i3, tag);
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
        if (str == null || (num = b.f29085a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f29084a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.travel.common.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.nativesdk.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f29084a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(92);
            f29084a = sparseArray;
            sparseArray.put(0, "_all");
            f29084a.put(1, "emiViewModel");
            f29084a.put(2, "instrumentSheetViewModel");
            f29084a.put(3, "section");
            f29084a.put(4, "transcationViewModel");
            f29084a.put(5, "allNetBankingViewModel");
            f29084a.put(6, "bankMandateIfscCodeViewModel");
            f29084a.put(7, "codViewModel");
            f29084a.put(8, "view");
            f29084a.put(9, "netBankingViewModel");
            f29084a.put(10, "netbanking");
            f29084a.put(11, "saveCardModel");
            f29084a.put(12, "model");
            f29084a.put(13, "showInstrumentInfoMsg");
            f29084a.put(14, "a");
            f29084a.put(15, "otpViewholder");
            f29084a.put(16, "pincvvmodel");
            f29084a.put(17, "bank_mandate");
            f29084a.put(18, "debitCardModel");
            f29084a.put(19, "selectedInstrumentSheetViewModel");
            f29084a.put(20, "typeface");
            f29084a.put(21, "aoaWalletViewModel");
            f29084a.put(22, "bankViewModel");
            f29084a.put(23, "landingPageViewModel");
            f29084a.put(24, "walletViewModel");
            f29084a.put(25, "digitalCreditModel");
            f29084a.put(26, "cvvHelpModel");
            f29084a.put(27, "bankMandateSubDetailsViewModel");
            f29084a.put(28, "upiHelpModel");
            f29084a.put(29, "upiCollectModel");
            f29084a.put(30, "titleMsg");
            f29084a.put(31, "parentIndex");
            f29084a.put(32, "data");
            f29084a.put(33, "reviewViewModel");
            f29084a.put(34, "_amenities_extra_visibility");
            f29084a.put(35, SDKConstants.EVENT_KEY_SCREEN_NAME);
            f29084a.put(36, "showMoreLess");
            f29084a.put(37, "sharedViewModel");
            f29084a.put(38, "details");
            f29084a.put(39, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            f29084a.put(40, "isInfoVisible");
            f29084a.put(41, "srpHeaderViewModel");
            f29084a.put(42, "_amenities2_visibility");
            f29084a.put(43, "cancelOrderViewModel");
            f29084a.put(44, "viewmodel");
            f29084a.put(45, "datamodel");
            f29084a.put(46, "detailsviewmodel");
            f29084a.put(47, "autoSearchDataItem");
            f29084a.put(48, "roomItem");
            f29084a.put(49, "hotelBookingStatusViewModel");
            f29084a.put(50, "_amenities2_image");
            f29084a.put(51, "_amenities_extra");
            f29084a.put(52, "selectedGalleryImage");
            f29084a.put(53, "isTitleVisible");
            f29084a.put(54, "name");
            f29084a.put(55, "viewModel");
            f29084a.put(56, "refundData");
            f29084a.put(57, "headerViewModel");
            f29084a.put(58, "reviewModel");
            f29084a.put(59, "_amenities1_image");
            f29084a.put(60, "selectedCity");
            f29084a.put(61, "dataModel");
            f29084a.put(62, "srpHeaderViewModelNoresult");
            f29084a.put(63, "imageSrc");
            f29084a.put(64, "_amenities3_visibility");
            f29084a.put(65, "title");
            f29084a.put(66, "hotelSearchViewModel");
            f29084a.put(67, "amenityType");
            f29084a.put(68, "pagerGalleryViewmodel");
            f29084a.put(69, "rvviewmodel");
            f29084a.put(70, "srpHeaderViewModelInclude");
            f29084a.put(71, "rsviewmodel");
            f29084a.put(72, "dataViewModel");
            f29084a.put(73, "hotel");
            f29084a.put(74, "errorViewModel");
            f29084a.put(75, "showingAllPromocode");
            f29084a.put(76, "_amenities1_visibility");
            f29084a.put(77, "cancelViewModel");
            f29084a.put(78, "srpViewModel");
            f29084a.put(79, "selectedRoomOption");
            f29084a.put(80, "message");
            f29084a.put(81, "pair");
            f29084a.put(82, "_amenities0_visibility");
            f29084a.put(83, "amenityUrl");
            f29084a.put(84, "_amenities3_image");
            f29084a.put(85, "continueView");
            f29084a.put(86, "selectedRoom");
            f29084a.put(87, "_amenities0_image");
            f29084a.put(88, "promoitem");
            f29084a.put(89, "imgSrc");
            f29084a.put(90, "headerTitleMsg");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f29085a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(101);
            f29085a = hashMap;
            hashMap.put("layout/h4_cancel_order_lyout_0", Integer.valueOf(R.layout.h4_cancel_order_lyout));
            f29085a.put("layout/h4_cancel_order_paymentdetails_0", Integer.valueOf(R.layout.h4_cancel_order_paymentdetails));
            f29085a.put("layout/h4_cancel_order_reason_0", Integer.valueOf(R.layout.h4_cancel_order_reason));
            f29085a.put("layout/h4_cancel_order_refund_summary_0", Integer.valueOf(R.layout.h4_cancel_order_refund_summary));
            f29085a.put("layout/h4_cancel_order_room_details_0", Integer.valueOf(R.layout.h4_cancel_order_room_details));
            f29085a.put("layout/h4_cancel_order_summary_dates_lyout_0", Integer.valueOf(R.layout.h4_cancel_order_summary_dates_lyout));
            f29085a.put("layout/h4_details_about_hotel_0", Integer.valueOf(R.layout.h4_details_about_hotel));
            f29085a.put("layout/h4_details_address_0", Integer.valueOf(R.layout.h4_details_address));
            f29085a.put("layout/h4_details_amenities_0", Integer.valueOf(R.layout.h4_details_amenities));
            f29085a.put("layout/h4_details_cin_cout_0", Integer.valueOf(R.layout.h4_details_cin_cout));
            f29085a.put("layout/h4_details_header_0", Integer.valueOf(R.layout.h4_details_header));
            f29085a.put("layout/h4_details_image_selector_0", Integer.valueOf(R.layout.h4_details_image_selector));
            f29085a.put("layout/h4_details_policies_0", Integer.valueOf(R.layout.h4_details_policies));
            f29085a.put("layout/h4_details_screen_0", Integer.valueOf(R.layout.h4_details_screen));
            f29085a.put("layout/h4_edit_search_query_view_0", Integer.valueOf(R.layout.h4_edit_search_query_view));
            f29085a.put("layout/h4_fare_breakup_bottom_sheet_0", Integer.valueOf(R.layout.h4_fare_breakup_bottom_sheet));
            f29085a.put("layout/h4_filter_amenities_hotel_type_view_0", Integer.valueOf(R.layout.h4_filter_amenities_hotel_type_view));
            f29085a.put("layout/h4_filter_hotel_chain_view_0", Integer.valueOf(R.layout.h4_filter_hotel_chain_view));
            f29085a.put("layout/h4_filter_hotel_theme_view_0", Integer.valueOf(R.layout.h4_filter_hotel_theme_view));
            f29085a.put("layout/h4_filter_locality_hotel_chain_bottom_sheet_0", Integer.valueOf(R.layout.h4_filter_locality_hotel_chain_bottom_sheet));
            f29085a.put("layout/h4_filter_locality_view_0", Integer.valueOf(R.layout.h4_filter_locality_view));
            f29085a.put("layout/h4_filter_price_start_view_0", Integer.valueOf(R.layout.h4_filter_price_start_view));
            f29085a.put("layout/h4_fragment_error_dialog_0", Integer.valueOf(R.layout.h4_fragment_error_dialog));
            f29085a.put("layout/h4_fragment_full_map_0", Integer.valueOf(R.layout.h4_fragment_full_map));
            f29085a.put("layout/h4_fragment_hotel_offers_0", Integer.valueOf(R.layout.h4_fragment_hotel_offers));
            f29085a.put("layout/h4_fragment_map_0", Integer.valueOf(R.layout.h4_fragment_map));
            f29085a.put("layout/h4_fragment_show_data_0", Integer.valueOf(R.layout.h4_fragment_show_data));
            f29085a.put("layout/h4_gallery_fragment_0", Integer.valueOf(R.layout.h4_gallery_fragment));
            f29085a.put("layout/h4_gallery_header_0", Integer.valueOf(R.layout.h4_gallery_header));
            f29085a.put("layout/h4_gallery_item_selection_fragment_0", Integer.valueOf(R.layout.h4_gallery_item_selection_fragment));
            f29085a.put("layout/h4_gallery_list_fragment_0", Integer.valueOf(R.layout.h4_gallery_list_fragment));
            f29085a.put("layout/h4_gallery_selected_item_0", Integer.valueOf(R.layout.h4_gallery_selected_item));
            f29085a.put("layout/h4_home_activity_0", Integer.valueOf(R.layout.h4_home_activity));
            f29085a.put("layout/h4_hotel_booking_activity_0", Integer.valueOf(R.layout.h4_hotel_booking_activity));
            f29085a.put("layout/h4_hotel_sold_out_lyt_0", Integer.valueOf(R.layout.h4_hotel_sold_out_lyt));
            f29085a.put("layout/h4_image_text_bottom_sheet_0", Integer.valueOf(R.layout.h4_image_text_bottom_sheet));
            f29085a.put("layout/h4_layout_hotel_summary_payment_details_0", Integer.valueOf(R.layout.h4_layout_hotel_summary_payment_details));
            f29085a.put("layout/h4_layout_order_summary_dates_0", Integer.valueOf(R.layout.h4_layout_order_summary_dates));
            f29085a.put("layout/h4_layout_order_summary_policy_tnc_0", Integer.valueOf(R.layout.h4_layout_order_summary_policy_tnc));
            f29085a.put("layout/h4_layout_similar_hotels_0", Integer.valueOf(R.layout.h4_layout_similar_hotels));
            f29085a.put("layout/h4_list_item_amenity_0", Integer.valueOf(R.layout.h4_list_item_amenity));
            f29085a.put("layout/h4_list_item_map_hotels_0", Integer.valueOf(R.layout.h4_list_item_map_hotels));
            f29085a.put("layout/h4_list_item_pair_0", Integer.valueOf(R.layout.h4_list_item_pair));
            f29085a.put("layout/h4_list_item_room_price_0", Integer.valueOf(R.layout.h4_list_item_room_price));
            f29085a.put("layout/h4_list_item_similar_hotels_0", Integer.valueOf(R.layout.h4_list_item_similar_hotels));
            f29085a.put("layout/h4_locality_hotel_chain_filter_list_item_0", Integer.valueOf(R.layout.h4_locality_hotel_chain_filter_list_item));
            f29085a.put("layout/h4_no_rooms_bottom_sheet_0", Integer.valueOf(R.layout.h4_no_rooms_bottom_sheet));
            f29085a.put("layout/h4_order_summary_activity_0", Integer.valueOf(R.layout.h4_order_summary_activity));
            f29085a.put("layout/h4_rb_cin_cout_0", Integer.valueOf(R.layout.h4_rb_cin_cout));
            f29085a.put("layout/h4_rb_gst_0", Integer.valueOf(R.layout.h4_rb_gst));
            f29085a.put("layout/h4_rb_gst_info_0", Integer.valueOf(R.layout.h4_rb_gst_info));
            f29085a.put("layout/h4_rb_guest_details_0", Integer.valueOf(R.layout.h4_rb_guest_details));
            f29085a.put("layout/h4_rb_header_0", Integer.valueOf(R.layout.h4_rb_header));
            f29085a.put("layout/h4_rb_hotel_detailes_0", Integer.valueOf(R.layout.h4_rb_hotel_detailes));
            f29085a.put("layout/h4_rb_payment_summenry_0", Integer.valueOf(R.layout.h4_rb_payment_summenry));
            f29085a.put("layout/h4_rb_process_pay_0", Integer.valueOf(R.layout.h4_rb_process_pay));
            f29085a.put("layout/h4_rb_promo_code_0", Integer.valueOf(R.layout.h4_rb_promo_code));
            f29085a.put("layout/h4_rb_promo_code_apply_0", Integer.valueOf(R.layout.h4_rb_promo_code_apply));
            f29085a.put("layout/h4_rb_promocode_cell_0", Integer.valueOf(R.layout.h4_rb_promocode_cell));
            f29085a.put("layout/h4_rb_room_detailes_0", Integer.valueOf(R.layout.h4_rb_room_detailes));
            f29085a.put("layout/h4_review_screen_0", Integer.valueOf(R.layout.h4_review_screen));
            f29085a.put("layout/h4_room_selected_popup_0", Integer.valueOf(R.layout.h4_room_selected_popup));
            f29085a.put("layout/h4_room_selection_continue_0", Integer.valueOf(R.layout.h4_room_selection_continue));
            f29085a.put("layout/h4_room_selection_header_0", Integer.valueOf(R.layout.h4_room_selection_header));
            f29085a.put("layout/h4_room_selection_vpager_0", Integer.valueOf(R.layout.h4_room_selection_vpager));
            f29085a.put("layout/h4_rs_add_reduce_room_0", Integer.valueOf(R.layout.h4_rs_add_reduce_room));
            f29085a.put("layout/h4_rs_select_room_0", Integer.valueOf(R.layout.h4_rs_select_room));
            f29085a.put("layout/h4_rs_select_room_sticky_0", Integer.valueOf(R.layout.h4_rs_select_room_sticky));
            f29085a.put("layout/h4_rs_sticky_header_0", Integer.valueOf(R.layout.h4_rs_sticky_header));
            f29085a.put("layout/h4_select_room_image_gallery_0", Integer.valueOf(R.layout.h4_select_room_image_gallery));
            f29085a.put("layout/h4_sort_view_list_item_0", Integer.valueOf(R.layout.h4_sort_view_list_item));
            f29085a.put("layout/h4_srp_bottom_sort_filter_view_0", Integer.valueOf(R.layout.h4_srp_bottom_sort_filter_view));
            f29085a.put("layout/h4_srp_error_lyout_0", Integer.valueOf(R.layout.h4_srp_error_lyout));
            f29085a.put("layout/h4_srp_filter_header_0", Integer.valueOf(R.layout.h4_srp_filter_header));
            f29085a.put("layout/h4_srp_filter_layout_0", Integer.valueOf(R.layout.h4_srp_filter_layout));
            f29085a.put("layout/h4_srp_filter_price_range_list_item_0", Integer.valueOf(R.layout.h4_srp_filter_price_range_list_item));
            f29085a.put("layout/h4_srp_inputedit_bottom_sheet_0", Integer.valueOf(R.layout.h4_srp_inputedit_bottom_sheet));
            f29085a.put("layout/h4_srp_no_result_lyout_0", Integer.valueOf(R.layout.h4_srp_no_result_lyout));
            f29085a.put("layout/h4_srp_sort_view_0", Integer.valueOf(R.layout.h4_srp_sort_view));
            f29085a.put("layout/hotel4_amenities_list_items_0", Integer.valueOf(R.layout.hotel4_amenities_list_items));
            f29085a.put("layout/hotel4_auto_search_item_0", Integer.valueOf(R.layout.hotel4_auto_search_item));
            f29085a.put("layout/hotel4_bullet_list_0", Integer.valueOf(R.layout.hotel4_bullet_list));
            f29085a.put("layout/hotel4_filter_amenities_list_item_0", Integer.valueOf(R.layout.hotel4_filter_amenities_list_item));
            f29085a.put("layout/hotel4_gallery_image_list_items_0", Integer.valueOf(R.layout.hotel4_gallery_image_list_items));
            f29085a.put("layout/hotel4_image_list_item_0", Integer.valueOf(R.layout.hotel4_image_list_item));
            f29085a.put("layout/hotel4_image_text_bottomsheet_items_0", Integer.valueOf(R.layout.hotel4_image_text_bottomsheet_items));
            f29085a.put("layout/hotel4_loader_0", Integer.valueOf(R.layout.hotel4_loader));
            f29085a.put("layout/hotel4_popular_search_0", Integer.valueOf(R.layout.hotel4_popular_search));
            f29085a.put("layout/hotel4_room_config_0", Integer.valueOf(R.layout.hotel4_room_config));
            f29085a.put("layout/hotel4_room_config_tax_0", Integer.valueOf(R.layout.hotel4_room_config_tax));
            f29085a.put("layout/hotel4_room_selection_amenities_list_items_0", Integer.valueOf(R.layout.hotel4_room_selection_amenities_list_items));
            f29085a.put("layout/hotel4_search_fragment_0", Integer.valueOf(R.layout.hotel4_search_fragment));
            f29085a.put("layout/hotel4_selected_city_list_items_0", Integer.valueOf(R.layout.hotel4_selected_city_list_items));
            f29085a.put("layout/hotel4_srp_header_0", Integer.valueOf(R.layout.hotel4_srp_header));
            f29085a.put("layout/hotel4_srp_list_items_0", Integer.valueOf(R.layout.hotel4_srp_list_items));
            f29085a.put("layout/hotel4_srp_loader_0", Integer.valueOf(R.layout.hotel4_srp_loader));
            f29085a.put("layout/hotel4_srp_view_0", Integer.valueOf(R.layout.hotel4_srp_view));
            f29085a.put("layout/hotels_near_me_0", Integer.valueOf(R.layout.hotels_near_me));
            f29085a.put("layout/layout_details_screen_shimmer_0", Integer.valueOf(R.layout.layout_details_screen_shimmer));
            f29085a.put("layout/layout_error_fragment_0", Integer.valueOf(R.layout.layout_error_fragment));
            f29085a.put("layout/layout_hotel_booking_shimmer_0", Integer.valueOf(R.layout.layout_hotel_booking_shimmer));
        }
    }
}
