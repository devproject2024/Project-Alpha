package com.travel;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import com.travel.c.ab;
import com.travel.c.ad;
import com.travel.c.af;
import com.travel.c.ah;
import com.travel.c.f;
import com.travel.c.h;
import com.travel.c.j;
import com.travel.c.l;
import com.travel.c.n;
import com.travel.c.p;
import com.travel.c.r;
import com.travel.c.t;
import com.travel.c.v;
import com.travel.c.x;
import com.travel.c.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIONBARTRAVELBOOKINGS = 1;
    private static final int LAYOUT_ACTIVITYCOMMONCALENDAR = 2;
    private static final int LAYOUT_ACTIVITYTRAVELBOOKINGSLIST = 3;
    private static final int LAYOUT_CUSTOMSHAREVIEW = 4;
    private static final int LAYOUT_FRAGMENTCALENDAR = 5;
    private static final int LAYOUT_FRAGMENTTRAVELBOOKINGLIST = 6;
    private static final int LAYOUT_LAYOUTTRAVELBOOKINGNODATA = 7;
    private static final int LAYOUT_LIVESALEVIEW = 8;
    private static final int LAYOUT_ROWMYBOOKINGBUSUPCOMING = 9;
    private static final int LAYOUT_ROWMYBOOKINGCITYBUSUPCOMING = 10;
    private static final int LAYOUT_ROWMYBOOKINGFLIGHTUPCOMING = 11;
    private static final int LAYOUT_ROWMYBOOKINGHOTELUPCOMING = 12;
    private static final int LAYOUT_ROWMYBOOKINGTRAINUPCOMING = 13;
    private static final int LAYOUT_TRAVELGENERICNAVACTIVITY = 14;
    private static final int LAYOUT_TRAVELSALESVIEW = 15;
    private static final int LAYOUT_VHOFFERTC = 16;
    private static final int LAYOUT_VHOFFERTCITEM = 17;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(17);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.action_bar_travel_bookings, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.activity_common_calendar, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.activity_travel_bookings_list, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.custom_share_view, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_calendar, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_travel_booking_list, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_travel_booking_no_data, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.live_sale_view, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.row_mybooking_bus_upcoming, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.row_mybooking_city_bus_upcoming, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.row_mybooking_flight_upcoming, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.row_mybooking_hotel_upcoming, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.row_mybooking_train_upcoming, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.travel_generic_nav_activity, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.travel_sales_view, 15);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_offer_tc, 16);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.vh_offer_tc_item, 17);
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
                    if ("layout/action_bar_travel_bookings_0".equals(tag)) {
                        return new com.travel.c.b(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for action_bar_travel_bookings is invalid. Received: ".concat(String.valueOf(tag)));
                case 2:
                    if ("layout/activity_common_calendar_0".equals(tag)) {
                        return new com.travel.c.d(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_common_calendar is invalid. Received: ".concat(String.valueOf(tag)));
                case 3:
                    if ("layout/activity_travel_bookings_list_0".equals(tag)) {
                        return new f(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_travel_bookings_list is invalid. Received: ".concat(String.valueOf(tag)));
                case 4:
                    if ("layout/custom_share_view_0".equals(tag)) {
                        return new h(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for custom_share_view is invalid. Received: ".concat(String.valueOf(tag)));
                case 5:
                    if ("layout/fragment_calendar_0".equals(tag)) {
                        return new j(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_calendar is invalid. Received: ".concat(String.valueOf(tag)));
                case 6:
                    if ("layout/fragment_travel_booking_list_0".equals(tag)) {
                        return new l(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_travel_booking_list is invalid. Received: ".concat(String.valueOf(tag)));
                case 7:
                    if ("layout/layout_travel_booking_no_data_0".equals(tag)) {
                        return new n(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for layout_travel_booking_no_data is invalid. Received: ".concat(String.valueOf(tag)));
                case 8:
                    if ("layout/live_sale_view_0".equals(tag)) {
                        return new p(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for live_sale_view is invalid. Received: ".concat(String.valueOf(tag)));
                case 9:
                    if ("layout/row_mybooking_bus_upcoming_0".equals(tag)) {
                        return new r(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for row_mybooking_bus_upcoming is invalid. Received: ".concat(String.valueOf(tag)));
                case 10:
                    if ("layout/row_mybooking_city_bus_upcoming_0".equals(tag)) {
                        return new t(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for row_mybooking_city_bus_upcoming is invalid. Received: ".concat(String.valueOf(tag)));
                case 11:
                    if ("layout/row_mybooking_flight_upcoming_0".equals(tag)) {
                        return new v(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for row_mybooking_flight_upcoming is invalid. Received: ".concat(String.valueOf(tag)));
                case 12:
                    if ("layout/row_mybooking_hotel_upcoming_0".equals(tag)) {
                        return new x(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for row_mybooking_hotel_upcoming is invalid. Received: ".concat(String.valueOf(tag)));
                case 13:
                    if ("layout/row_mybooking_train_upcoming_0".equals(tag)) {
                        return new z(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for row_mybooking_train_upcoming is invalid. Received: ".concat(String.valueOf(tag)));
                case 14:
                    if ("layout/travel_generic_nav_activity_0".equals(tag)) {
                        return new ab(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for travel_generic_nav_activity is invalid. Received: ".concat(String.valueOf(tag)));
                case 15:
                    if ("layout/travel_sales_view_0".equals(tag)) {
                        return new ad(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for travel_sales_view is invalid. Received: ".concat(String.valueOf(tag)));
                case 16:
                    if ("layout/vh_offer_tc_0".equals(tag)) {
                        return new af(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_offer_tc is invalid. Received: ".concat(String.valueOf(tag)));
                case 17:
                    if ("layout/vh_offer_tc_item_0".equals(tag)) {
                        return new ah(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for vh_offer_tc_item is invalid. Received: ".concat(String.valueOf(tag)));
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
        if (str == null || (num = b.f21408a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f21407a.get(i2);
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
        static final SparseArray<String> f21407a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(34);
            f21407a = sparseArray;
            sparseArray.put(0, "_all");
            f21407a.put(1, "emiViewModel");
            f21407a.put(2, "instrumentSheetViewModel");
            f21407a.put(3, "section");
            f21407a.put(4, "transcationViewModel");
            f21407a.put(5, "allNetBankingViewModel");
            f21407a.put(6, "bankMandateIfscCodeViewModel");
            f21407a.put(7, "codViewModel");
            f21407a.put(8, "view");
            f21407a.put(9, "netBankingViewModel");
            f21407a.put(10, "netbanking");
            f21407a.put(11, "saveCardModel");
            f21407a.put(12, "model");
            f21407a.put(13, "showInstrumentInfoMsg");
            f21407a.put(14, "a");
            f21407a.put(15, "otpViewholder");
            f21407a.put(16, "pincvvmodel");
            f21407a.put(17, "bank_mandate");
            f21407a.put(18, "debitCardModel");
            f21407a.put(19, "selectedInstrumentSheetViewModel");
            f21407a.put(20, "typeface");
            f21407a.put(21, "aoaWalletViewModel");
            f21407a.put(22, "bankViewModel");
            f21407a.put(23, "landingPageViewModel");
            f21407a.put(24, "walletViewModel");
            f21407a.put(25, "digitalCreditModel");
            f21407a.put(26, "cvvHelpModel");
            f21407a.put(27, "bankMandateSubDetailsViewModel");
            f21407a.put(28, "upiHelpModel");
            f21407a.put(29, "upiCollectModel");
            f21407a.put(30, "bookingInfo");
            f21407a.put(31, "viewModel");
            f21407a.put(32, "bookingData");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f21408a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(17);
            f21408a = hashMap;
            hashMap.put("layout/action_bar_travel_bookings_0", Integer.valueOf(R.layout.action_bar_travel_bookings));
            f21408a.put("layout/activity_common_calendar_0", Integer.valueOf(R.layout.activity_common_calendar));
            f21408a.put("layout/activity_travel_bookings_list_0", Integer.valueOf(R.layout.activity_travel_bookings_list));
            f21408a.put("layout/custom_share_view_0", Integer.valueOf(R.layout.custom_share_view));
            f21408a.put("layout/fragment_calendar_0", Integer.valueOf(R.layout.fragment_calendar));
            f21408a.put("layout/fragment_travel_booking_list_0", Integer.valueOf(R.layout.fragment_travel_booking_list));
            f21408a.put("layout/layout_travel_booking_no_data_0", Integer.valueOf(R.layout.layout_travel_booking_no_data));
            f21408a.put("layout/live_sale_view_0", Integer.valueOf(R.layout.live_sale_view));
            f21408a.put("layout/row_mybooking_bus_upcoming_0", Integer.valueOf(R.layout.row_mybooking_bus_upcoming));
            f21408a.put("layout/row_mybooking_city_bus_upcoming_0", Integer.valueOf(R.layout.row_mybooking_city_bus_upcoming));
            f21408a.put("layout/row_mybooking_flight_upcoming_0", Integer.valueOf(R.layout.row_mybooking_flight_upcoming));
            f21408a.put("layout/row_mybooking_hotel_upcoming_0", Integer.valueOf(R.layout.row_mybooking_hotel_upcoming));
            f21408a.put("layout/row_mybooking_train_upcoming_0", Integer.valueOf(R.layout.row_mybooking_train_upcoming));
            f21408a.put("layout/travel_generic_nav_activity_0", Integer.valueOf(R.layout.travel_generic_nav_activity));
            f21408a.put("layout/travel_sales_view_0", Integer.valueOf(R.layout.travel_sales_view));
            f21408a.put("layout/vh_offer_tc_0", Integer.valueOf(R.layout.vh_offer_tc));
            f21408a.put("layout/vh_offer_tc_item_0", Integer.valueOf(R.layout.vh_offer_tc_item));
        }
    }
}
