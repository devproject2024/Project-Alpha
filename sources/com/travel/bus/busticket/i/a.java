package com.travel.bus.busticket.i;

import android.content.Context;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.pojo.busticket.CJRLocation;
import com.travel.bus.pojo.busticket.CJRTravelName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a {
    public static void a(int i2, List<CJRTravelName> list, Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_search");
        hashMap.put("event_action", "operator_filter_done");
        hashMap.put("event_label", Integer.valueOf(i2));
        String str = list.size() > 0 ? list.get(0).mTravelsName : "";
        if (list.size() > 1) {
            str = str + AppConstants.AND_SIGN;
        }
        String str2 = str;
        int i3 = 1;
        while (true) {
            int i4 = i2 - 1;
            if (i3 <= i4) {
                if (i3 < i4) {
                    str2 = str2 + list.get(i3).mTravelsName + AppConstants.AND_SIGN;
                }
                if (i3 == i4) {
                    str2 = str2 + list.get(i3).mTravelsName;
                }
                i3++;
            } else {
                hashMap.put("event_label2", str2);
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
                hashMap.put("vertical_name", "bus");
                hashMap.put("user_id", b.n(context));
                com.travel.bus.a.a();
                com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
                return;
            }
        }
    }

    public static void a(CJRTravelName cJRTravelName, Context context, String str, String str2) {
        if (cJRTravelName != null) {
            try {
                if (cJRTravelName.getTravelsName() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Select Bus page - Refine section");
                    hashMap.put("bus_user_id", b.n(context));
                    hashMap.put("bus_origin", str);
                    hashMap.put("bus_destination", str2);
                    hashMap.put("bus_bus_operator_name", cJRTravelName.getTravelsName());
                    com.travel.bus.a.a();
                    com.travel.bus.a.b().a("bus_refine_bus_operator_selected", (Map<String, Object>) hashMap, context);
                }
            } catch (Exception e2) {
                if (b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    public static void a(CJRTravelName cJRTravelName, Context context) {
        if (cJRTravelName != null) {
            try {
                if (cJRTravelName.getTravelsName() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("operator_name", cJRTravelName.getTravelsName());
                    hashMap.put("user_id", b.n(context));
                    com.travel.bus.a.a();
                    com.travel.bus.a.b().a("bus_search_bus_operators_filter_selected", (Map<String, Object>) hashMap, context);
                }
            } catch (Exception e2) {
                if (b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    public static void a(String str, Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_search");
        hashMap.put("event_action", "operator_search");
        hashMap.put("event_label", str);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", b.n(context));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(int r11, java.util.List<com.travel.bus.pojo.busticket.CJRBusTicketFilterItem> r12, int r13, android.content.Context r14) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x000e:
            if (r3 >= r11) goto L_0x0056
            java.lang.Object r6 = r12.get(r3)
            com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r6 = (com.travel.bus.pojo.busticket.CJRBusTicketFilterItem) r6
            java.lang.String r6 = r6.getTitle()
            java.lang.String r7 = "B.Pt"
            boolean r6 = r6.equalsIgnoreCase(r7)
            if (r6 == 0) goto L_0x0032
            int r5 = r5 + 1
            java.lang.Object r6 = r12.get(r3)
            com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r6 = (com.travel.bus.pojo.busticket.CJRBusTicketFilterItem) r6
            java.lang.String r6 = r6.getDisplayValue()
            r0.add(r6)
            goto L_0x0053
        L_0x0032:
            java.lang.Object r6 = r12.get(r3)
            com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r6 = (com.travel.bus.pojo.busticket.CJRBusTicketFilterItem) r6
            java.lang.String r6 = r6.getTitle()
            java.lang.String r7 = "D.Pt"
            boolean r6 = r6.equalsIgnoreCase(r7)
            if (r6 == 0) goto L_0x0053
            int r4 = r4 + 1
            java.lang.Object r6 = r12.get(r3)
            com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r6 = (com.travel.bus.pojo.busticket.CJRBusTicketFilterItem) r6
            java.lang.String r6 = r6.getDisplayValue()
            r1.add(r6)
        L_0x0053:
            int r3 = r3 + 1
            goto L_0x000e
        L_0x0056:
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            java.lang.String r3 = "event_category"
            java.lang.String r6 = "bus_search"
            r12.put(r3, r6)
            java.lang.String r3 = "event_label2"
            java.lang.String r6 = ""
            java.lang.String r7 = "event_label"
            java.lang.String r8 = "event_action"
            java.lang.String r9 = "&"
            r10 = 1
            if (r13 != r10) goto L_0x00e1
            java.lang.String r13 = "boarding_filter_done"
            r12.put(r8, r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r5)
            r12.put(r7, r13)
            int r13 = r0.size()
            if (r13 <= 0) goto L_0x0088
            java.lang.Object r13 = r0.get(r2)
            r6 = r13
            java.lang.String r6 = (java.lang.String) r6
        L_0x0088:
            int r13 = r0.size()
            if (r13 <= r10) goto L_0x009d
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r6)
            r13.append(r9)
            java.lang.String r6 = r13.toString()
        L_0x009d:
            r13 = 1
        L_0x009e:
            int r1 = r0.size()
            int r1 = r1 - r10
            if (r13 > r1) goto L_0x00dc
            int r1 = r11 + -1
            if (r13 >= r1) goto L_0x00c1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            java.lang.Object r4 = r0.get(r13)
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            r2.append(r9)
            java.lang.String r6 = r2.toString()
        L_0x00c1:
            if (r13 != r1) goto L_0x00d9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            java.lang.Object r2 = r0.get(r13)
            java.lang.String r2 = (java.lang.String) r2
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6 = r1
        L_0x00d9:
            int r13 = r13 + 1
            goto L_0x009e
        L_0x00dc:
            r12.put(r3, r6)
            goto L_0x0159
        L_0x00e1:
            java.lang.String r11 = "dropping_filter_done"
            r12.put(r8, r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r4)
            r12.put(r7, r11)
            int r11 = r1.size()
            if (r11 <= 0) goto L_0x00fa
            java.lang.Object r11 = r1.get(r2)
            r6 = r11
            java.lang.String r6 = (java.lang.String) r6
        L_0x00fa:
            int r11 = r1.size()
            if (r11 <= r10) goto L_0x010f
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r6)
            r11.append(r9)
            java.lang.String r6 = r11.toString()
        L_0x010f:
            r11 = 1
        L_0x0110:
            int r13 = r1.size()
            int r13 = r13 - r10
            if (r11 > r13) goto L_0x0156
            int r13 = r1.size()
            int r13 = r13 - r10
            if (r11 >= r13) goto L_0x0136
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r6)
            java.lang.Object r0 = r1.get(r11)
            java.lang.String r0 = (java.lang.String) r0
            r13.append(r0)
            r13.append(r9)
            java.lang.String r6 = r13.toString()
        L_0x0136:
            int r13 = r1.size()
            int r13 = r13 - r10
            if (r11 != r13) goto L_0x0153
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r6)
            java.lang.Object r0 = r1.get(r11)
            java.lang.String r0 = (java.lang.String) r0
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            r6 = r13
        L_0x0153:
            int r11 = r11 + 1
            goto L_0x0110
        L_0x0156:
            r12.put(r3, r6)
        L_0x0159:
            java.lang.String r11 = "screenName"
            java.lang.String r13 = "/bus-tickets-search"
            r12.put(r11, r13)
            java.lang.String r11 = "vertical_name"
            java.lang.String r13 = "bus"
            r12.put(r11, r13)
            java.lang.String r11 = com.paytm.utility.b.n((android.content.Context) r14)
            java.lang.String r13 = "user_id"
            r12.put(r13, r11)
            com.travel.bus.a.a()
            com.travel.g.a r11 = com.travel.bus.a.b()
            java.lang.String r13 = "custom_event"
            r11.a((java.lang.String) r13, (java.util.Map<java.lang.String, java.lang.Object>) r12, (android.content.Context) r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.i.a.a(int, java.util.List, int, android.content.Context):void");
    }

    public static void a(CJRLocation cJRLocation, int i2, String str, String str2, Context context) {
        String str3;
        if (cJRLocation != null) {
            try {
                if (cJRLocation.getLocationName() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Select Bus page - Refine section");
                    hashMap.put("bus_user_id", b.n(context));
                    hashMap.put("bus_origin", str);
                    hashMap.put("bus_destination", str2);
                    if (i2 == 1) {
                        hashMap.put("bus_boarding_point_name", cJRLocation.getLocationName());
                        str3 = "bus_refine_boarding_point_selected";
                    } else {
                        hashMap.put("bus_dropping_point_name", cJRLocation.getLocationName());
                        str3 = "bus_refine_dropping_point_selected";
                    }
                    com.travel.bus.a.a();
                    com.travel.bus.a.b().a(str3, (Map<String, Object>) hashMap, context);
                }
            } catch (Exception e2) {
                if (b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    public static void a(CJRLocation cJRLocation, int i2, Context context) {
        String str;
        if (cJRLocation != null) {
            try {
                if (cJRLocation.getLocationName() != null) {
                    HashMap hashMap = new HashMap();
                    if (i2 == 1) {
                        hashMap.put("boarding_point", cJRLocation.getLocationName());
                        str = "bus_search_boarding_point_selected";
                    } else {
                        hashMap.put("dropping_point", cJRLocation.getLocationName());
                        str = "bus_search_dropping_point_selected";
                    }
                    hashMap.put("user_id", b.n(context));
                    com.travel.bus.a.a();
                    com.travel.bus.a.b().a(str, (Map<String, Object>) hashMap, context);
                }
            } catch (Exception e2) {
                if (b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }
}
