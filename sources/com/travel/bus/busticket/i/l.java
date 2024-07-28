package com.travel.bus.busticket.i;

import android.content.Context;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.a;
import com.travel.bus.pojo.busticket.CJRBusSearch;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class l {
    public static void a(CJRBusSearch cJRBusSearch, HashMap<String, ArrayList<Integer>> hashMap, Context context) {
        int size = (cJRBusSearch == null || cJRBusSearch.getBody() == null || cJRBusSearch.getBody().getTrips() == null || cJRBusSearch.getBody().getTrips().size() <= 0) ? 0 : cJRBusSearch.getBody().getTrips().size();
        String str = "";
        String source = (cJRBusSearch == null || cJRBusSearch.getBody() == null || cJRBusSearch.getBody().getTrips() == null || cJRBusSearch.getBody().getTrips().size() <= 0) ? str : cJRBusSearch.getBody().getTrips().get(0).getSource();
        String destination = cJRBusSearch.getBody().getTrips().get(0).getDestination() != null ? cJRBusSearch.getBody().getTrips().get(0).getDestination() : str;
        if (cJRBusSearch.getBody().getTrips().get(0).getArrivalDatetime() != null) {
            str = cJRBusSearch.getBody().getTrips().get(0).getArrivalDatetime();
        }
        String str2 = source + AppConstants.AND_SIGN + destination + AppConstants.AND_SIGN + str;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("event_category", "bus_search");
        hashMap2.put("event_action", "trips_count");
        if (!hashMap.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry next : hashMap.entrySet()) {
                String str3 = (String) next.getKey();
                ArrayList arrayList3 = (ArrayList) next.getValue();
                arrayList.add(0, str3);
                Iterator<CJRBusSearchItem> it2 = cJRBusSearch.getBody().getTrips().iterator();
                int i2 = 0;
                while (it2.hasNext()) {
                    if (it2.next().getOperatorGroupName().equalsIgnoreCase(str3)) {
                        arrayList2.add(i2, arrayList3);
                        i2++;
                    }
                }
            }
            HashMap hashMap3 = new HashMap();
            if (hashMap.size() > 1) {
                for (Map.Entry next2 : hashMap.entrySet()) {
                    Iterator<CJRBusSearchItem> it3 = cJRBusSearch.getBody().getTrips().iterator();
                    int i3 = 0;
                    while (it3.hasNext()) {
                        if (it3.next().getOperatorGroupName().equalsIgnoreCase((String) next2.getKey())) {
                            i3++;
                        }
                    }
                    hashMap3.put(next2.getKey(), Integer.valueOf(i3));
                }
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                int i4 = 0;
                for (Map.Entry entry : hashMap3.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append(AppConstants.COMMA);
                    i4 += ((Integer) entry.getValue()).intValue();
                    sb2.append(entry.getValue());
                    sb2.append(AppConstants.COMMA);
                }
                hashMap2.put("event_label", "rtc=" + sb.toString().substring(0, sb.toString().length() - 1) + "&count=" + sb2.toString().substring(0, sb2.toString().length() - 1) + "&non_rtc_count=" + (size - i4));
            } else {
                hashMap2.put("event_label", "rtc=" + ((String) arrayList.get(0)) + "&count=" + arrayList2.size() + "&non_rtc_count=" + (size - arrayList2.size()));
            }
        } else {
            hashMap2.put("event_label", "rtc=&rtc_count=0&non_rtc_count=".concat(String.valueOf(size)));
        }
        hashMap2.put("event_label2", str2);
        hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
        hashMap2.put("vertical_name", "bus");
        hashMap2.put("user_id", b.n(context));
        a.a();
        a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap2, context);
    }

    public static void a(Context context, int i2, NetworkCustomError networkCustomError) {
        if (networkCustomError != null) {
            try {
                if (networkCustomError.getAlertMessage() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("event_category", "bus_search");
                    hashMap.put("event_action", "error_popup");
                    hashMap.put("event_label", networkCustomError.getAlertMessage());
                    hashMap.put("event_label2", Integer.valueOf(i2));
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
                    hashMap.put("vertical_name", "bus");
                    hashMap.put("user_id", b.n(context));
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }

    public static void a(Context context, String str, CJRBusSearchItem cJRBusSearchItem) {
        String str2;
        if (!(!str.equals("ratings") || cJRBusSearchItem == null || cJRBusSearchItem.getBusRating() == null)) {
            String valueOf = String.valueOf(cJRBusSearchItem.getBusRating().getAvgRating());
            Float valueOf2 = Float.valueOf(0.0f);
            try {
                if (String.valueOf(cJRBusSearchItem.getBusRating().getAvgRating()) != null && !String.valueOf(cJRBusSearchItem.getBusRating().getAvgRating()).isEmpty()) {
                    valueOf2 = Float.valueOf(Float.parseFloat(valueOf));
                }
            } catch (Exception unused) {
            }
            if (valueOf2.floatValue() > 0.0f) {
                str2 = String.format("%.1f", new Object[]{valueOf2}) + AppConstants.AND_SIGN + cJRBusSearchItem.getBusRating().getCount();
                HashMap hashMap = new HashMap();
                hashMap.put("event_category", "bus_search");
                hashMap.put("event_action", str + "_clicked");
                hashMap.put("event_label", str2);
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
                hashMap.put("vertical_name", "bus");
                hashMap.put("user_id", b.n(context));
                a.a();
                a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
            }
        }
        str2 = "";
        HashMap hashMap2 = new HashMap();
        hashMap2.put("event_category", "bus_search");
        hashMap2.put("event_action", str + "_clicked");
        hashMap2.put("event_label", str2);
        hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
        hashMap2.put("vertical_name", "bus");
        hashMap2.put("user_id", b.n(context));
        a.a();
        a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap2, context);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:3|4|(1:6)|7|(5:(1:11)|12|(2:14|35)(1:36)|15|8)|34|16|17|(3:19|20|(1:22))|23|(3:25|26|27)|28|29|40) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00ca */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r12, com.travel.bus.pojo.busticket.CJRBusSearchItem r13, int r14) {
        /*
            java.lang.String r0 = "|"
            if (r13 == 0) goto L_0x015a
            java.lang.String r1 = "no"
            r2 = 0
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x014e }
            r3 = 0
            java.lang.Float r3 = java.lang.Float.valueOf(r3)     // Catch:{ Exception -> 0x014e }
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFlag r4 = r13.getFlag()     // Catch:{ Exception -> 0x014e }
            boolean r4 = r4.getSellingFast()     // Catch:{ Exception -> 0x014e }
            if (r4 == 0) goto L_0x001f
            java.lang.String r1 = "yes"
        L_0x001f:
            r4 = 0
            r5 = r2
            r2 = 0
        L_0x0022:
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r6 = r13.getFare()     // Catch:{ Exception -> 0x014e }
            double[] r6 = r6.getPrices()     // Catch:{ Exception -> 0x014e }
            int r6 = r6.length     // Catch:{ Exception -> 0x014e }
            if (r2 >= r6) goto L_0x0060
            if (r2 != 0) goto L_0x003d
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r5 = r13.getFare()     // Catch:{ Exception -> 0x014e }
            double[] r5 = r5.getPrices()     // Catch:{ Exception -> 0x014e }
            r6 = r5[r2]     // Catch:{ Exception -> 0x014e }
            java.lang.Double r5 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x014e }
        L_0x003d:
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r6 = r13.getFare()     // Catch:{ Exception -> 0x014e }
            double[] r6 = r6.getPrices()     // Catch:{ Exception -> 0x014e }
            r7 = r6[r2]     // Catch:{ Exception -> 0x014e }
            double r9 = r5.doubleValue()     // Catch:{ Exception -> 0x014e }
            int r6 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r6 >= 0) goto L_0x005d
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r5 = r13.getFare()     // Catch:{ Exception -> 0x014e }
            double[] r5 = r5.getPrices()     // Catch:{ Exception -> 0x014e }
            r6 = r5[r2]     // Catch:{ Exception -> 0x014e }
            java.lang.Double r5 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x014e }
        L_0x005d:
            int r2 = r2 + 1
            goto L_0x0022
        L_0x0060:
            java.lang.String r2 = r13.getDuration()     // Catch:{ Exception -> 0x014e }
            java.lang.String r6 = " "
            r7 = 1
            if (r2 == 0) goto L_0x00b0
            java.lang.String r2 = r13.getDuration()     // Catch:{ Exception -> 0x014e }
            int r2 = r2.length()     // Catch:{ Exception -> 0x014e }
            r8 = 4
            if (r2 != r8) goto L_0x00b0
            java.lang.String r2 = r13.getDuration()     // Catch:{ Exception -> 0x014e }
            r9 = 2
            java.lang.String r10 = r2.substring(r4, r9)     // Catch:{ Exception -> 0x014e }
            java.lang.String r2 = r2.substring(r9, r8)     // Catch:{ Exception -> 0x014e }
            r8 = 3
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ Exception -> 0x014e }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014e }
            r11.<init>()     // Catch:{ Exception -> 0x014e }
            r11.append(r10)     // Catch:{ Exception -> 0x014e }
            java.lang.String r10 = "H"
            r11.append(r10)     // Catch:{ Exception -> 0x014e }
            java.lang.String r10 = r11.toString()     // Catch:{ Exception -> 0x014e }
            r8[r4] = r10     // Catch:{ Exception -> 0x014e }
            r8[r7] = r6     // Catch:{ Exception -> 0x014e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014e }
            r6.<init>()     // Catch:{ Exception -> 0x014e }
            r6.append(r2)     // Catch:{ Exception -> 0x014e }
            java.lang.String r2 = "M"
            r6.append(r2)     // Catch:{ Exception -> 0x014e }
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x014e }
            r8[r9] = r2     // Catch:{ Exception -> 0x014e }
            java.lang.String r6 = com.paytm.utility.v.a((java.lang.String[]) r8)     // Catch:{ Exception -> 0x014e }
        L_0x00b0:
            com.travel.bus.pojo.busticket.BusRatingModel r2 = r13.getBusRating()     // Catch:{ Exception -> 0x014e }
            if (r2 == 0) goto L_0x00ca
            com.travel.bus.pojo.busticket.BusRatingModel r2 = r13.getBusRating()     // Catch:{ Exception -> 0x014e }
            double r8 = r2.getAvgRating()     // Catch:{ Exception -> 0x014e }
            java.lang.String r2 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x014e }
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ Exception -> 0x00ca }
            java.lang.Float r3 = java.lang.Float.valueOf(r2)     // Catch:{ Exception -> 0x00ca }
        L_0x00ca:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x014e }
            r2.<init>()     // Catch:{ Exception -> 0x014e }
            java.lang.String r8 = "event_category"
            java.lang.String r9 = "bus_search"
            r2.put(r8, r9)     // Catch:{ Exception -> 0x014e }
            java.lang.String r8 = "event_action"
            java.lang.String r9 = "merchant_bus_clicked"
            r2.put(r8, r9)     // Catch:{ Exception -> 0x014e }
            java.lang.String r8 = "event_label"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014e }
            r9.<init>()     // Catch:{ Exception -> 0x014e }
            java.lang.String r10 = r13.getTravelsName()     // Catch:{ Exception -> 0x014e }
            r9.append(r10)     // Catch:{ Exception -> 0x014e }
            r9.append(r0)     // Catch:{ Exception -> 0x014e }
            java.lang.String r10 = "%.1f"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x014e }
            r7[r4] = r3     // Catch:{ Exception -> 0x014e }
            java.lang.String r3 = java.lang.String.format(r10, r7)     // Catch:{ Exception -> 0x014e }
            r9.append(r3)     // Catch:{ Exception -> 0x014e }
            r9.append(r0)     // Catch:{ Exception -> 0x014e }
            r9.append(r14)     // Catch:{ Exception -> 0x014e }
            r9.append(r0)     // Catch:{ Exception -> 0x014e }
            r9.append(r1)     // Catch:{ Exception -> 0x014e }
            r9.append(r0)     // Catch:{ Exception -> 0x014e }
            r9.append(r5)     // Catch:{ Exception -> 0x014e }
            r9.append(r0)     // Catch:{ Exception -> 0x014e }
            java.lang.Integer r13 = r13.getAvalableSeats()     // Catch:{ Exception -> 0x014e }
            r9.append(r13)     // Catch:{ Exception -> 0x014e }
            r9.append(r0)     // Catch:{ Exception -> 0x014e }
            java.lang.String r13 = r6.trim()     // Catch:{ Exception -> 0x014e }
            r9.append(r13)     // Catch:{ Exception -> 0x014e }
            java.lang.String r13 = r9.toString()     // Catch:{ Exception -> 0x014e }
            r2.put(r8, r13)     // Catch:{ Exception -> 0x014e }
            java.lang.String r13 = "screenName"
            java.lang.String r14 = "/bus-tickets-search"
            r2.put(r13, r14)     // Catch:{ Exception -> 0x014e }
            java.lang.String r13 = "vertical_name"
            java.lang.String r14 = "bus"
            r2.put(r13, r14)     // Catch:{ Exception -> 0x014e }
            java.lang.String r13 = "user_id"
            java.lang.String r14 = com.paytm.utility.b.n((android.content.Context) r12)     // Catch:{ Exception -> 0x014e }
            r2.put(r13, r14)     // Catch:{ Exception -> 0x014e }
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x014e }
            com.travel.g.a r13 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x014e }
            java.lang.String r14 = "custom_event"
            r13.a((java.lang.String) r14, (java.util.Map<java.lang.String, java.lang.Object>) r2, (android.content.Context) r12)     // Catch:{ Exception -> 0x014e }
            goto L_0x015a
        L_0x014e:
            r12 = move-exception
            boolean r13 = com.paytm.utility.b.v
            if (r13 == 0) goto L_0x015a
            java.lang.String r12 = r12.getMessage()
            com.paytm.utility.q.c(r12)
        L_0x015a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.i.l.a(android.content.Context, com.travel.bus.pojo.busticket.CJRBusSearchItem, int):void");
    }

    public static void a(Context context, String str, String str2, String str3) {
        String format = String.format("old_value=%s;modified_value=%s", new Object[]{str2, str3});
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_search");
        hashMap.put("event_action", str + "_modified");
        hashMap.put("event_label", format);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", b.n(context));
        a.a();
        a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
    }

    public static void a(Context context, String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_search");
        hashMap.put("event_action", z ? "quick_filter_selected" : "quick_filter_deselected");
        hashMap.put("event_label", str);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", b.n(context));
        a.a();
        a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
    }
}
