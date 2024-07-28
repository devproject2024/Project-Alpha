package com.travel.flight.utils;

import android.content.Context;
import android.content.Intent;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.a.af;
import com.travel.flight.flightSRPV2.a.m;
import com.travel.flight.flightSRPV2.a.x;
import com.travel.flight.flightticket.d.b;
import com.travel.flight.pojo.CJRBusHolidayList;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f25593a = new a((byte) 0);

    public static final class a {
        public static String a(boolean z) {
            return !z ? "round_trip" : "one_way";
        }

        public static String a(boolean z, boolean z2) {
            return (!z || !z2) ? (z || z2) ? (z || !z2) ? "DOW" : "IRT" : "DRT" : "IOW";
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static CJRFlightSearchInput a(Intent intent) {
            CJRFlightSearchInput cJRFlightSearchInput = new CJRFlightSearchInput();
            if (intent == null) {
                return cJRFlightSearchInput;
            }
            if (!intent.hasExtra("isShare") || !intent.getBooleanExtra("isShare", false)) {
                if (intent.hasExtra("booking_segment")) {
                    int intExtra = intent.getIntExtra("booking_segment", -1);
                    if (intExtra == 0) {
                        cJRFlightSearchInput.setBookingSegment(b.Modify);
                    } else if (intExtra != 2) {
                        cJRFlightSearchInput.setBookingSegment(b.Regular);
                    } else {
                        cJRFlightSearchInput.setBookingSegment(b.Corporate);
                    }
                } else {
                    cJRFlightSearchInput.setBookingSegment(b.Regular);
                }
                if (intent.hasExtra("MODIFY_BOOKING_REQUEST_ID")) {
                    cJRFlightSearchInput.setModifyBookingRequestId(intent.getStringExtra("MODIFY_BOOKING_REQUEST_ID"));
                }
                if (intent.hasExtra("MODIFY_BOOKING_ORDER_ID")) {
                    cJRFlightSearchInput.setModifyBookingOrderId(intent.getStringExtra("MODIFY_BOOKING_ORDER_ID"));
                }
                if (intent.hasExtra("intent_extra_is_round_trip")) {
                    cJRFlightSearchInput.setRoundTrip(intent.getBooleanExtra("intent_extra_is_round_trip", false));
                }
                if (intent.hasExtra("intent_extra_flight_search_from")) {
                    Serializable serializableExtra = intent.getSerializableExtra("intent_extra_flight_search_from");
                    if (serializableExtra != null) {
                        cJRFlightSearchInput.setSource((com.travel.flight.pojo.flightticket.b) serializableExtra);
                    } else {
                        throw new u("null cannot be cast to non-null type com.travel.flight.pojo.flightticket.CJRAirportCityItem");
                    }
                }
                if (intent.hasExtra("intent_extra_flight_source_city_code")) {
                    cJRFlightSearchInput.setSourceCityCode(intent.getStringExtra("intent_extra_flight_source_city_code"));
                }
                if (intent.hasExtra("nonstop")) {
                    cJRFlightSearchInput.setNonStopSelected(intent.getBooleanExtra("nonstop", false));
                }
                if (intent.hasExtra("flight_holiday_list") && intent.getSerializableExtra("flight_holiday_list") != null) {
                    Serializable serializableExtra2 = intent.getSerializableExtra("flight_holiday_list");
                    if (serializableExtra2 != null) {
                        cJRFlightSearchInput.setmFlightHolidayList((CJRBusHolidayList) serializableExtra2);
                    } else {
                        throw new u("null cannot be cast to non-null type com.travel.flight.pojo.CJRBusHolidayList");
                    }
                }
                if (intent.hasExtra("FlightSRPBannerURL")) {
                    cJRFlightSearchInput.setSrpLoaderBanner(intent.getStringExtra("FlightSRPBannerURL"));
                }
                if (intent.hasExtra("intent_extra_flight_search_to")) {
                    Serializable serializableExtra3 = intent.getSerializableExtra("intent_extra_flight_search_to");
                    if (serializableExtra3 != null) {
                        cJRFlightSearchInput.setDestination((com.travel.flight.pojo.flightticket.b) serializableExtra3);
                    } else {
                        throw new u("null cannot be cast to non-null type com.travel.flight.pojo.flightticket.CJRAirportCityItem");
                    }
                }
                if (intent.hasExtra("intent_extra_flight_destination_city_code")) {
                    cJRFlightSearchInput.setDestCityCode(intent.getStringExtra("intent_extra_flight_destination_city_code"));
                }
                if (intent.hasExtra("intent_extra_flight_class_type")) {
                    cJRFlightSearchInput.setClassType(intent.getStringExtra("intent_extra_flight_class_type"));
                }
                if (intent.hasExtra("intent_extra_flight_search_date")) {
                    cJRFlightSearchInput.setDate(intent.getStringExtra("intent_extra_flight_search_date"));
                }
                if (intent.hasExtra("intent_extra_flight_return_date")) {
                    cJRFlightSearchInput.setReturnDate(intent.getStringExtra("intent_extra_flight_return_date"));
                }
                if (intent.hasExtra("intent_extra_flight_search_no_of_adult_passengers")) {
                    cJRFlightSearchInput.setmCount_adults(intent.getIntExtra("intent_extra_flight_search_no_of_adult_passengers", 1));
                }
                if (intent.hasExtra("intent_extra_flight_search_no_of_child_passengers")) {
                    cJRFlightSearchInput.setmCount_childerns(intent.getIntExtra("intent_extra_flight_search_no_of_child_passengers", 0));
                }
                if (intent.hasExtra("intent_extra_flight_search_no_of_infants_passengers")) {
                    cJRFlightSearchInput.setmCount_infants(intent.getIntExtra("intent_extra_flight_search_no_of_infants_passengers", 0));
                }
                if (intent.hasExtra("intent_extra_flight_search_from_key")) {
                    cJRFlightSearchInput.setmAutoSuggestOriginSearchKey(intent.getStringExtra("intent_extra_flight_search_from_key"));
                }
                if (intent.hasExtra("intent_extra_flight_search_to_key")) {
                    cJRFlightSearchInput.setmAutoSuggestDestinationSearchKey(intent.getStringExtra("intent_extra_flight_search_to_key"));
                }
                if (intent.hasExtra("intent_extra_flight_search_from_pos")) {
                    cJRFlightSearchInput.setmAutoSuggestOriginPos(intent.getIntExtra("intent_extra_flight_search_from_pos", 1));
                }
                if (intent.hasExtra("intent_extra_flight_search_to_pos")) {
                    cJRFlightSearchInput.setmAutoSuggestDestinationPos(intent.getIntExtra("intent_extra_flight_search_to_pos", 1));
                }
                if (intent.hasExtra("referral")) {
                    cJRFlightSearchInput.setmReferral(intent.getStringExtra("referral"));
                }
                if (intent.hasExtra("opened_from")) {
                    cJRFlightSearchInput.setmOpenFrom(intent.getStringExtra("opened_from"));
                }
                if (intent.hasExtra("source_iata_code")) {
                    cJRFlightSearchInput.setSourceIataCode(intent.getStringExtra("source_iata_code"));
                    cJRFlightSearchInput.setNearByAirportSelected(true);
                } else {
                    cJRFlightSearchInput.setSourceIataCode(cJRFlightSearchInput.getSourceCityCode());
                }
                if (intent.hasExtra("dest_iata_code")) {
                    cJRFlightSearchInput.setDestIataCode(intent.getStringExtra("dest_iata_code"));
                    cJRFlightSearchInput.setNearByAirportSelected(true);
                } else {
                    cJRFlightSearchInput.setDestIataCode(cJRFlightSearchInput.getDestCityCode());
                }
                if (intent.hasExtra("intent_extra_airline_codes")) {
                    cJRFlightSearchInput.setmDeeplinkFilterAirlineCodes(intent.getStringExtra("intent_extra_airline_codes"));
                }
                cJRFlightSearchInput.setSortByFlight("price");
                cJRFlightSearchInput.setOrderByFlight("forward");
                if (intent.hasExtra("start_date")) {
                    cJRFlightSearchInput.setModifyStartDateRange(intent.getStringExtra("start_date"));
                }
                if (!intent.hasExtra("end_date")) {
                    return cJRFlightSearchInput;
                }
                cJRFlightSearchInput.setModifyEndDateRange(intent.getStringExtra("end_date"));
                return cJRFlightSearchInput;
            }
            Serializable serializableExtra4 = intent.getSerializableExtra("intent_extra_search_input_data");
            if (serializableExtra4 != null) {
                CJRFlightSearchInput cJRFlightSearchInput2 = (CJRFlightSearchInput) serializableExtra4;
                cJRFlightSearchInput2.setSortByFlight("price");
                cJRFlightSearchInput2.setOrderByFlight("forward");
                return cJRFlightSearchInput2;
            }
            throw new u("null cannot be cast to non-null type com.travel.flight.pojo.flightticket.CJRFlightSearchInput");
        }

        public static void a(m mVar) {
            k.c(mVar, "customErrorEvent");
            k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
            com.travel.flight.b.b().a(mVar);
        }

        public static String a(String str, Context context) {
            k.c(str, "code");
            if (context == null) {
                return "";
            }
            if (p.a(str, "E", true)) {
                String string = context.getResources().getString(R.string.economy_flight);
                k.a((Object) string, "context.resources.getStr…(R.string.economy_flight)");
                return string;
            } else if (p.a(str, "B", true)) {
                String string2 = context.getResources().getString(R.string.business);
                k.a((Object) string2, "context.resources.getString(R.string.business)");
                return string2;
            } else if (!p.a(str, AppConstants.FEED_COMMUNITY_POST, true)) {
                return "";
            } else {
                String string3 = context.getResources().getString(R.string.premium_economy);
                k.a((Object) string3, "context.resources.getStr…R.string.premium_economy)");
                return string3;
            }
        }

        public static String b(String str, Context context) {
            k.c(str, "classType");
            if (context == null) {
                return "";
            }
            if (p.a(str, context.getString(R.string.economy_flight), true)) {
                return "E";
            }
            if (p.a(str, context.getString(R.string.business), true)) {
                return "B";
            }
            if (p.a(str, context.getString(R.string.premium_economy), true)) {
                return AppConstants.FEED_COMMUNITY_POST;
            }
            return "";
        }

        public static HashMap<String, Object> a(CJRFlightSearchInput cJRFlightSearchInput, String str, String str2, String str3, boolean z, Context context) {
            k.c(cJRFlightSearchInput, "searchInput");
            k.c(context, "context");
            HashMap<String, Object> hashMap = new HashMap<>();
            CharSequence charSequence = str;
            boolean z2 = false;
            if (!(charSequence == null || charSequence.length() == 0)) {
                hashMap.put("event_label", str);
            }
            String journeyDetailType = cJRFlightSearchInput.getJourneyDetailType();
            k.a((Object) journeyDetailType, "searchInput.journeyDetailType");
            if (!(journeyDetailType.length() == 0)) {
                String journeyDetailType2 = cJRFlightSearchInput.getJourneyDetailType();
                k.a((Object) journeyDetailType2, "searchInput.journeyDetailType");
                hashMap.put("event_label2", journeyDetailType2);
            }
            Map map = hashMap;
            com.travel.flight.pojo.flightticket.b source = cJRFlightSearchInput.getSource();
            k.a((Object) source, "searchInput.source");
            String cityName = source.getCityName();
            k.a((Object) cityName, "searchInput.source.cityName");
            map.put("event_label3", cityName);
            com.travel.flight.pojo.flightticket.b destination = cJRFlightSearchInput.getDestination();
            k.a((Object) destination, "searchInput.destination");
            String cityName2 = destination.getCityName();
            k.a((Object) cityName2, "searchInput.destination.cityName");
            map.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, cityName2);
            CharSequence charSequence2 = str3;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                map.put("event_label5", str3);
            }
            if (z) {
                try {
                    String classType = cJRFlightSearchInput.getClassType();
                    k.a((Object) classType, "searchInput.classType");
                    hashMap.put("event_label6", b(classType, context));
                } catch (Exception unused) {
                }
            }
            String h2 = com.paytm.utility.b.h(cJRFlightSearchInput.getDate(), "yyyy-MM-dd", "dd MMM yy");
            k.a((Object) h2, "CJRAppCommonUtility.form…GHTS_DISPLAY_DATE_FORMAT)");
            map.put("event_label7", h2);
            CharSequence returnDate = cJRFlightSearchInput.getReturnDate();
            if (!(returnDate == null || p.a(returnDate))) {
                String h3 = com.paytm.utility.b.h(cJRFlightSearchInput.getReturnDate(), "yyyy-MM-dd", "dd MMM yy");
                k.a((Object) h3, "CJRAppCommonUtility.form…GHTS_DISPLAY_DATE_FORMAT)");
                map.put("event_label8", h3);
            }
            String sourceCityCode = cJRFlightSearchInput.getSourceCityCode();
            k.a((Object) sourceCityCode, "searchInput.sourceCityCode");
            map.put("event_label9", sourceCityCode);
            String destCityCode = cJRFlightSearchInput.getDestCityCode();
            k.a((Object) destCityCode, "searchInput.destCityCode");
            map.put("event_label10", destCityCode);
            String journeyType = cJRFlightSearchInput.getJourneyType();
            k.a((Object) journeyType, "searchInput.journeyType");
            if (journeyType.length() > 0) {
                String journeyType2 = cJRFlightSearchInput.getJourneyType();
                k.a((Object) journeyType2, "searchInput.journeyType");
                map.put("event_label11", journeyType2);
            }
            CharSequence charSequence3 = str2;
            if (charSequence3 == null || charSequence3.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                map.put("event_label12", str2);
            }
            return hashMap;
        }

        public static void a(String str) {
            k.c(str, "status");
            HashMap hashMap = new HashMap();
            hashMap.put("event_label", str);
            a("fare_strip_load", (HashMap<String, Object>) hashMap);
        }

        public static void b(String str) {
            k.c(str, "journeyDetailType");
            HashMap hashMap = new HashMap();
            hashMap.put("event_label2", str);
            a("remove_filters_clicked", (HashMap<String, Object>) hashMap);
        }

        public static String a(String str, List<? extends x> list, List<? extends x> list2) {
            k.c(str, "journeyType");
            Collection collection = list;
            boolean z = false;
            String str2 = "";
            if (!(collection == null || collection.isEmpty())) {
                if (p.a(str, "round_trip", true)) {
                    str2 = str2 + "Onward{";
                }
                HashSet hashSet = new HashSet();
                ArrayList<x> arrayList = new ArrayList<>();
                for (Object next : list) {
                    if (hashSet.add(Integer.valueOf(((x) next).e()))) {
                        arrayList.add(next);
                    }
                }
                for (x a2 : arrayList) {
                    str2 = str2 + a(a2) + ", ";
                }
                int length = str2.length() - 2;
                int length2 = str2.length() - 1;
                if (str2 != null) {
                    String obj = p.a((CharSequence) str2, length, length2).toString();
                    if (obj != null) {
                        str2 = p.b(obj).toString();
                        if (p.a(str, "round_trip", true)) {
                            str2 = str2 + "}";
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            Collection collection2 = list2;
            if (collection2 == null || collection2.isEmpty()) {
                z = true;
            }
            if (z) {
                return str2;
            }
            String str3 = str2 + ",Return{";
            HashSet hashSet2 = new HashSet();
            ArrayList<x> arrayList2 = new ArrayList<>();
            for (Object next2 : list2) {
                if (hashSet2.add(Integer.valueOf(((x) next2).e()))) {
                    arrayList2.add(next2);
                }
            }
            for (x a3 : arrayList2) {
                str3 = str3 + a(a3) + ", ";
            }
            int length3 = str3.length() - 2;
            int length4 = str3.length() - 1;
            if (str3 != null) {
                String obj2 = p.a((CharSequence) str3, length3, length4).toString();
                if (obj2 != null) {
                    return p.b(obj2).toString() + "}";
                }
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        }

        private static String a(x xVar) {
            k.c(xVar, "item");
            switch (xVar.e()) {
                case 1:
                    return "Hide Non Refundable flights";
                case 2:
                    return ((af) xVar).f24086a == 1 ? "Non-stop flights" : "Max 1 stop flights";
                case 3:
                    return "Duration";
                case 4:
                    return "Price";
                case 5:
                    return "Departure from Source";
                case 6:
                    return "Arrival at Destination";
                case 7:
                    return "Airlines";
                default:
                    return "";
            }
        }

        public static void a(String str, HashMap<String, Object> hashMap) {
            k.c(str, "eventAction");
            k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
            com.travel.flight.b.b().a(GAUtil.CUSTOM_EVENT, "/flights/search-results", "flights_search", str, hashMap);
        }
    }
}
