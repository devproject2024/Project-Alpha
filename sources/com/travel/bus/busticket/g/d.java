package com.travel.bus.busticket.g;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.travel.bus.R;
import com.travel.bus.a;
import com.travel.bus.busticket.c.b;
import com.travel.bus.busticket.i.o;
import com.travel.bus.busticket.i.t;
import com.travel.bus.pojo.busticket.CJRBusSearch;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo;
import com.travel.bus.pojo.busticket.CJRBusTicketFilterItem;
import com.travel.bus.pojo.busticket.CJRBusTicketFilters;
import com.travel.bus.pojo.busticket.CJRLocation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public Context f22363a;

    /* renamed from: b  reason: collision with root package name */
    public CJRBusSearchInput f22364b;

    /* renamed from: c  reason: collision with root package name */
    public CJRBusTicketFilters f22365c;

    /* renamed from: d  reason: collision with root package name */
    public b.a f22366d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22367e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22368f = false;

    /* renamed from: g  reason: collision with root package name */
    private Handler f22369g;

    public d(Context context, b.a aVar) {
        this.f22363a = context;
        this.f22366d = aVar;
        this.f22369g = new Handler();
    }

    public final void a(CJRBusTicketFilters cJRBusTicketFilters, CJRBusSearchInput cJRBusSearchInput) {
        this.f22365c = cJRBusTicketFilters;
        this.f22364b = cJRBusSearchInput;
        a(b(cJRBusTicketFilters, cJRBusSearchInput));
    }

    public final void a(JSONObject jSONObject) {
        this.f22366d.clearAdapter();
        b();
        a.a();
        String s = a.b().s();
        if (TextUtils.isEmpty(s)) {
            s = "https://travel.paytm.com/bus/v3/search";
        }
        String uri = Uri.parse(s).buildUpon().appendQueryParameter(ContactsConstant.LOCALE, com.paytm.utility.b.g()).build().toString();
        if (o.b(this.f22363a)) {
            uri = Uri.parse(uri).buildUpon().appendQueryParameter("is_reseller", "1").build().toString();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f22363a));
        if (com.paytm.utility.b.c(this.f22363a)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(410);
            arrayList.add(422);
            arrayList.add(Integer.valueOf(H5ErrorCode.HTTP_SERVICE_UNAVAILABLE));
            arrayList.add(500);
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f22363a;
            bVar.f42878b = a.c.BUS;
            bVar.f42879c = a.C0715a.POST;
            bVar.f42880d = uri;
            bVar.f42884h = jSONObject.toString();
            bVar.f42881e = null;
            bVar.f42882f = hashMap;
            bVar.f42883g = null;
            bVar.f42885i = new CJRBusSearch();
            bVar.j = this;
            bVar.t = a();
            bVar.n = a.b.USER_FACING;
            bVar.o = "bus-srp-page";
            bVar.l().a();
            return;
        }
        this.f22366d.showSearchApiNoNetworkDialog();
    }

    private static JSONObject b(CJRBusTicketFilters cJRBusTicketFilters, CJRBusSearchInput cJRBusSearchInput) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (!(cJRBusTicketFilters == null || cJRBusTicketFilters.getBusTicketFilterItems() == null)) {
                Iterator<CJRBusTicketFilterItem> it2 = cJRBusTicketFilters.getBusTicketFilterItems().iterator();
                while (it2.hasNext()) {
                    CJRBusTicketFilterItem next = it2.next();
                    if (next != null && next.getTitle() != null && !next.getTitle().equalsIgnoreCase("AC") && next.getTitle().equalsIgnoreCase("Opr") && !TextUtils.isEmpty(next.getFilterValue())) {
                        arrayList3.add(next.getFilterValue());
                    }
                }
            }
            if (cJRBusSearchInput == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            if (cJRBusSearchInput.getSource() != null) {
                jSONObject.put("source_doc_id", cJRBusSearchInput.getSource().getCityId());
            }
            if (cJRBusSearchInput.getDestination() != null) {
                jSONObject.put("destination_doc_id", cJRBusSearchInput.getDestination().getCityId());
            }
            if (cJRBusSearchInput.getDate() != null) {
                jSONObject.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, cJRBusSearchInput.getDate());
            }
            if (cJRBusSearchInput.isDealApplicable()) {
                com.travel.bus.a.a();
                jSONObject.put("is_deal_applicable", com.travel.bus.a.b().a("isBusDealsApplicable", true));
            }
            jSONObject.put("is_departed", true);
            jSONObject.put("is_sold_out", 1);
            jSONObject.put("request_type", "one_way");
            jSONObject.put("leg_number", 0);
            if (arrayList.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    String str = (String) it3.next();
                    if (str != null) {
                        jSONArray.put(str);
                    }
                }
                jSONObject.put("boardingLocation", jSONArray);
            }
            if (arrayList2.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    String str2 = (String) it4.next();
                    if (str2 != null) {
                        jSONArray2.put(str2);
                    }
                }
                jSONObject.put("droppingLocation", jSONArray2);
            }
            if (arrayList3.size() > 0) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator it5 = arrayList3.iterator();
                while (it5.hasNext()) {
                    String str3 = (String) it5.next();
                    if (str3 != null) {
                        jSONArray3.put(str3);
                    }
                }
                jSONObject.put("busOperators", jSONArray3);
            }
            return jSONObject;
        } catch (JSONException e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public static ArrayList<CJRBusSearchItem> a(ArrayList<CJRBusSearchItem> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!(arrayList == null || arrayList.size() == 0)) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (!(arrayList.get(i2).getFlag() == null || arrayList.get(i2).getAvalableSeats().intValue() == 0 || !arrayList.get(i2).getFlag().getDeparted().booleanValue())) {
                    arrayList.set(i2, (Object) null);
                    arrayList3.add(arrayList.get(i2));
                }
            }
        }
        if (!(arrayList == null || arrayList.size() == 0)) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3) != null && arrayList.get(i3).getAvalableSeats().intValue() == 0) {
                    arrayList.set(i3, (Object) null);
                    arrayList2.add(arrayList.get(i3));
                }
            }
        }
        b(arrayList);
        arrayList.addAll(arrayList3);
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    private static void b(ArrayList<CJRBusSearchItem> arrayList) {
        Iterator<CJRBusSearchItem> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                it2.remove();
            }
        }
    }

    public final ArrayList<CJRBusSearchItem> a(ArrayList<CJRBusSearchItem> arrayList, HashMap<String, ArrayList<Integer>> hashMap) {
        String str;
        String str2;
        String str3;
        ArrayList<CJRBusSearchItem> arrayList2 = new ArrayList<>();
        if (arrayList.size() > 0) {
            for (String next : hashMap.keySet()) {
                Iterator<CJRBusSearchItem> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJRBusSearchItem next2 = it2.next();
                    if (next2.getOperatorObj().getIsGrouped().booleanValue() && next2.getOperatorObj().getName().contains(next)) {
                        CJRBusSearchItem cJRBusSearchItem = new CJRBusSearchItem();
                        cJRBusSearchItem.setOperatorObj(next2.getOperatorObj());
                        cJRBusSearchItem.getOperatorObj().setLogoUrl(next2.getOperatorObj().getLogoUrl());
                        cJRBusSearchItem.setmItemType("bus_item_type_header");
                        arrayList2.add(cJRBusSearchItem);
                        break;
                    }
                }
            }
            Iterator<CJRBusSearchItem> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                CJRBusSearchItem next3 = it3.next();
                if (!next3.getOperatorObj().getIsGrouped().booleanValue()) {
                    next3.setmItemType("bus_item_type_list");
                    arrayList2.add(next3);
                }
            }
        }
        Iterator<CJRBusSearchItem> it4 = arrayList.iterator();
        while (it4.hasNext()) {
            CJRBusSearchItem next4 = it4.next();
            if (next4.getDepartureDatetime() == null || next4.getArrivalDatetime() == null) {
                next4.setArrivalTimeInTwelveHours("");
                next4.setDepartureTimeInTwelveHours("");
            } else {
                String a2 = com.paytm.utility.b.a(next4.getDepartureDatetime(), "yyyy-MM-dd HH:mm:ss", "h:mm a");
                String a3 = com.paytm.utility.b.a(next4.getArrivalDatetime(), "yyyy-MM-dd HH:mm:ss", "h:mm a");
                if (a2 == null || a3 == null) {
                    next4.setArrivalTimeInTwelveHours("");
                    next4.setDepartureTimeInTwelveHours("");
                } else {
                    next4.setArrivalTimeInTwelveHours(a3);
                    next4.setDepartureTimeInTwelveHours(a2);
                }
            }
            if (next4.getFare() == null || next4.getFare().getPrices().length <= 0) {
                next4.setFormattedMinfare("");
            } else {
                double[] prices = next4.getFare().getPrices();
                if (prices.length == 1) {
                    String a4 = com.paytm.utility.b.a(prices[0], "###,###,###.##");
                    if (next4.getAvalableSeats().intValue() > 0) {
                        next4.setFormattedMinfare(a4);
                    }
                } else if (prices.length > 1) {
                    double d2 = prices[0];
                    for (int i2 = 0; i2 < prices.length; i2++) {
                        if (prices[i2] < d2) {
                            d2 = prices[i2];
                        }
                    }
                    String a5 = com.paytm.utility.b.a(d2, "###,###,###.##");
                    if (next4.getAvalableSeats().intValue() > 0) {
                        next4.setFormattedMinfare(a5);
                    }
                }
            }
            if (next4.getAvalableSeats() != null && next4.getAvalableSeats().intValue() > 0 && !next4.getFlag().getDeparted().booleanValue()) {
                if (next4.getAvalableSeats().intValue() <= 5 && next4.getAvalableSeats().intValue() > 1) {
                    str3 = this.f22363a.getString(R.string.bus_seats_left_for_booking);
                } else if (next4.getAvalableSeats().intValue() == 1) {
                    str3 = this.f22363a.getString(R.string.bus_seats_one_left_for_booking);
                } else {
                    str3 = this.f22363a.getString(R.string.bus_seats_avaliable_for_booking);
                }
                next4.setSeatPostfix(str3);
            }
            try {
                if (next4.getDuration() == null || next4.getDuration().length() != 4) {
                    next4.setDurationText("");
                } else {
                    String duration = next4.getDuration();
                    String substring = duration.substring(0, 2);
                    String substring2 = duration.substring(2, 4);
                    int intValue = Integer.valueOf(substring).intValue();
                    int intValue2 = Integer.valueOf(substring2).intValue();
                    if (intValue > 0) {
                        str = String.valueOf(intValue) + "h";
                    } else {
                        str = "";
                    }
                    if (intValue2 > 0) {
                        str2 = String.valueOf(intValue2) + "m";
                    } else {
                        str2 = "";
                    }
                    if (intValue > 0) {
                        str2 = v.a(str, " ", str2);
                    }
                    next4.setDurationText(str2.trim());
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
                next4.setDurationText("");
            }
        }
        return arrayList2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0329, code lost:
        if (r5 == false) goto L_0x0330;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x0678, code lost:
        r12 = r5;
        r2 = r31;
        r5 = r32;
        r3 = r33;
     */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03fa A[Catch:{ NumberFormatException -> 0x060c }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04a6 A[Catch:{ NumberFormatException -> 0x060c }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x04c6 A[Catch:{ NumberFormatException -> 0x060c }] */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x04ab A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x04c2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchItem> a(java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchItem> r41, com.travel.bus.pojo.busticket.CJRBusTicketFilters r42) {
        /*
            r40 = this;
            r0 = r41
            monitor-enter(r40)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0758 }
            r1.<init>()     // Catch:{ all -> 0x0758 }
            if (r0 == 0) goto L_0x0756
            if (r42 == 0) goto L_0x0756
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0758 }
            r1.<init>(r0)     // Catch:{ all -> 0x0758 }
            java.lang.String r2 = ""
            java.lang.String r3 = "5 Rating"
            java.lang.String r4 = "4+ Rating"
            java.lang.String r5 = "3+ Rating"
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0758 }
            r6.<init>()     // Catch:{ all -> 0x0758 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0758 }
            r7.<init>()     // Catch:{ all -> 0x0758 }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0758 }
            r8.<init>()     // Catch:{ all -> 0x0758 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x0758 }
            r9.<init>()     // Catch:{ all -> 0x0758 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x0758 }
            r10.<init>()     // Catch:{ all -> 0x0758 }
            java.util.ArrayList r11 = r42.getBusTicketFilterItems()     // Catch:{ all -> 0x0758 }
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r11 == 0) goto L_0x024a
            java.util.ArrayList r11 = r42.getBusTicketFilterItems()     // Catch:{ all -> 0x0758 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0758 }
            r12 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = -1082130432(0xffffffffbf800000, float:-1.0)
            r32 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0066:
            boolean r33 = r11.hasNext()     // Catch:{ all -> 0x0758 }
            if (r33 == 0) goto L_0x0245
            java.lang.Object r33 = r11.next()     // Catch:{ all -> 0x0758 }
            com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r33 = (com.travel.bus.pojo.busticket.CJRBusTicketFilterItem) r33     // Catch:{ all -> 0x0758 }
            java.lang.String r34 = r33.getType()     // Catch:{ all -> 0x0758 }
            boolean r34 = android.text.TextUtils.isEmpty(r34)     // Catch:{ all -> 0x0758 }
            if (r34 != 0) goto L_0x0066
            java.lang.String r13 = r33.getType()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "OperatorTag"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x0090
            java.lang.String r13 = r33.getOperatorTagId()     // Catch:{ all -> 0x0758 }
            r10.add(r13)     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x0090:
            java.lang.String r13 = r33.getType()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Amenity"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x00a4
            java.lang.String r13 = r33.getmAmenityId()     // Catch:{ all -> 0x0758 }
            r9.add(r13)     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x00a4:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "B.Pt"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x00c2
            java.lang.String r13 = r33.getFilterValue()     // Catch:{ all -> 0x0758 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0758 }
            if (r13 != 0) goto L_0x0066
            java.lang.String r13 = r33.getFilterValue()     // Catch:{ all -> 0x0758 }
            r6.add(r13)     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x00c2:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "D.Pt"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x00e0
            java.lang.String r13 = r33.getFilterValue()     // Catch:{ all -> 0x0758 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0758 }
            if (r13 != 0) goto L_0x0066
            java.lang.String r13 = r33.getFilterValue()     // Catch:{ all -> 0x0758 }
            r7.add(r13)     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x00e0:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Opr"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x00ff
            java.lang.String r13 = r33.getFilterValue()     // Catch:{ all -> 0x0758 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0758 }
            if (r13 != 0) goto L_0x0066
            java.lang.String r13 = r33.getFilterValue()     // Catch:{ all -> 0x0758 }
            r8.add(r13)     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x00ff:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Volvo"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x0111
            boolean r23 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x0111:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Mercedes"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x0123
            boolean r24 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x0123:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Scania"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x0135
            boolean r25 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x0135:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Single Axle"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x0147
            boolean r22 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x0147:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Multi Axle"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x0159
            boolean r21 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x0159:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "AC"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x016b
            boolean r16 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x016b:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Non AC"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x017d
            boolean r17 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x017d:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Sleeper"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x018f
            boolean r18 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x018f:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Semi Sleeper"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x01a1
            boolean r20 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x01a1:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Seater"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x01b3
            boolean r19 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x01b3:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Price"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x01c9
            float r31 = r33.getMinvalue()     // Catch:{ all -> 0x0758 }
            float r32 = r33.getMaxValue()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x01c9:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Deprture Time"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x01df
            java.lang.String r12 = r33.getTimeMinValue()     // Catch:{ all -> 0x0758 }
            java.lang.String r15 = r33.getTimeMaxValue()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x01df:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            boolean r13 = r13.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x01ef
            boolean r26 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x01ef:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            boolean r13 = r13.equalsIgnoreCase(r4)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x01ff
            boolean r27 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x01ff:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            boolean r13 = r13.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x020f
            boolean r28 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x020f:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Deals"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x0221
            boolean r29 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x0221:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Social Distancing"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x0233
            boolean r30 = r33.isToggleChecked()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x0233:
            java.lang.String r13 = r33.getTitle()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Popular Choice"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0758 }
            if (r13 == 0) goto L_0x0066
            java.lang.String r2 = r33.getFilterValue()     // Catch:{ all -> 0x0758 }
            goto L_0x0066
        L_0x0245:
            r3 = r31
            r4 = r32
            goto L_0x026e
        L_0x024a:
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
        L_0x026e:
            java.util.ArrayList r5 = r42.getBusTicketFilterItems()     // Catch:{ all -> 0x0758 }
            if (r5 == 0) goto L_0x0756
            java.util.Iterator r5 = r41.iterator()     // Catch:{ all -> 0x0758 }
        L_0x0278:
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x0758 }
            if (r0 == 0) goto L_0x0756
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x0758 }
            r11 = r0
            com.travel.bus.pojo.busticket.CJRBusSearchItem r11 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r11     // Catch:{ all -> 0x0758 }
            java.util.ArrayList r0 = r42.getBusTicketFilterItems()     // Catch:{ all -> 0x0758 }
            java.util.Iterator r13 = r0.iterator()     // Catch:{ all -> 0x0758 }
        L_0x028d:
            boolean r0 = r13.hasNext()     // Catch:{ all -> 0x0758 }
            if (r0 == 0) goto L_0x0278
            r13.next()     // Catch:{ all -> 0x0758 }
            if (r23 != 0) goto L_0x02a1
            if (r24 != 0) goto L_0x02a1
            if (r25 == 0) goto L_0x029d
            goto L_0x02a1
        L_0x029d:
            r32 = r5
            goto L_0x04b2
        L_0x02a1:
            if (r11 == 0) goto L_0x02ae
            java.lang.String r0 = r11.getBusTypeName()     // Catch:{ all -> 0x0758 }
            if (r0 == 0) goto L_0x02ae
            java.lang.String r0 = r11.getBusTypeName()     // Catch:{ all -> 0x0758 }
            goto L_0x02af
        L_0x02ae:
            r0 = 0
        L_0x02af:
            if (r25 == 0) goto L_0x032e
            if (r0 == 0) goto L_0x032e
            java.lang.String r14 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r31 = "Scania"
            r32 = r5
            java.lang.String r5 = r31.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r14.contains(r5)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x0328
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "METROLINK"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x0328
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "METROLINK HD"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x0328
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "SCENIA"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x0328
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "SCN"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x0328
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "VOLVO / SCANIA"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x0328
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "METRO LINK"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 == 0) goto L_0x0326
            goto L_0x0328
        L_0x0326:
            r5 = 0
            goto L_0x0329
        L_0x0328:
            r5 = 1
        L_0x0329:
            if (r5 == 0) goto L_0x0330
        L_0x032b:
            r0 = 1
            goto L_0x04a9
        L_0x032e:
            r32 = r5
        L_0x0330:
            if (r23 == 0) goto L_0x03fc
            if (r0 == 0) goto L_0x03fc
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Volvo"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x03f7
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "VOLVO"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x03f7
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "B9R"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x03f7
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "I-SHIFT"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x03f7
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "VOLVO_PUSH_BACK"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x03f7
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Luxuria"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x03f7
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "VOLVO-MERCEDES BENZ"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x03f7
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "B11R"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x03f7
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "ISHIFT"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x03f7
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "I SHIFT"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x03f7
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Volvo/Mercedes"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x03f7
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "VOLVO / SCANIA"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 == 0) goto L_0x03f5
            goto L_0x03f7
        L_0x03f5:
            r5 = 0
            goto L_0x03f8
        L_0x03f7:
            r5 = 1
        L_0x03f8:
            if (r5 == 0) goto L_0x03fc
            goto L_0x032b
        L_0x03fc:
            if (r24 == 0) goto L_0x04a8
            if (r0 == 0) goto L_0x04a8
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Mercedes"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x04a3
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "MERCEDESBENZ"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x04a3
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Mercedez Benz"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x04a3
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "VOLVO-MERCEDES BENZ"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x04a3
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "MERCIDES"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x04a3
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "MERCERDEZ"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x04a3
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Mercede"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x04a3
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "Mercerdez Benz"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x04a3
            java.lang.String r5 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r14 = "MERCEDEZ"
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r5 = r5.contains(r14)     // Catch:{ all -> 0x0758 }
            if (r5 != 0) goto L_0x04a3
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ all -> 0x0758 }
            java.lang.String r5 = "Volvo/Mercedes"
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ all -> 0x0758 }
            boolean r0 = r0.contains(r5)     // Catch:{ all -> 0x0758 }
            if (r0 == 0) goto L_0x04a1
            goto L_0x04a3
        L_0x04a1:
            r0 = 0
            goto L_0x04a4
        L_0x04a3:
            r0 = 1
        L_0x04a4:
            if (r0 == 0) goto L_0x04a8
            goto L_0x032b
        L_0x04a8:
            r0 = 0
        L_0x04a9:
            if (r0 != 0) goto L_0x04b2
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
        L_0x04ae:
            r5 = r32
            goto L_0x0278
        L_0x04b2:
            if (r16 == 0) goto L_0x04c6
            com.travel.bus.pojo.bussearch.CJRbusSearchItemFlags r0 = r11.getFlags()     // Catch:{ all -> 0x0758 }
            java.lang.Boolean r0 = r0.isAc()     // Catch:{ all -> 0x0758 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0758 }
            if (r0 != 0) goto L_0x04c6
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x04ae
        L_0x04c6:
            if (r17 == 0) goto L_0x04da
            com.travel.bus.pojo.bussearch.CJRbusSearchItemFlags r0 = r11.getFlags()     // Catch:{ all -> 0x0758 }
            java.lang.Boolean r0 = r0.isAc()     // Catch:{ all -> 0x0758 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0758 }
            if (r0 == 0) goto L_0x04da
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x04ae
        L_0x04da:
            if (r18 == 0) goto L_0x04ee
            com.travel.bus.pojo.bussearch.CJRbusSearchItemFlags r0 = r11.getFlags()     // Catch:{ all -> 0x0758 }
            java.lang.Boolean r0 = r0.isSleeper()     // Catch:{ all -> 0x0758 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0758 }
            if (r0 != 0) goto L_0x04ee
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x04ae
        L_0x04ee:
            if (r20 == 0) goto L_0x0502
            com.travel.bus.pojo.bussearch.CJRbusSearchItemFlags r0 = r11.getFlags()     // Catch:{ all -> 0x0758 }
            java.lang.Boolean r0 = r0.isSemiSleeper()     // Catch:{ all -> 0x0758 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0758 }
            if (r0 != 0) goto L_0x0502
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x04ae
        L_0x0502:
            if (r19 == 0) goto L_0x0516
            com.travel.bus.pojo.bussearch.CJRbusSearchItemFlags r0 = r11.getFlags()     // Catch:{ all -> 0x0758 }
            java.lang.Boolean r0 = r0.isSeater()     // Catch:{ all -> 0x0758 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0758 }
            if (r0 != 0) goto L_0x0516
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x04ae
        L_0x0516:
            if (r26 == 0) goto L_0x052a
            com.travel.bus.pojo.busticket.BusRatingModel r0 = r11.getBusRating()     // Catch:{ all -> 0x0758 }
            double r36 = r0.getAvgRating()     // Catch:{ all -> 0x0758 }
            r38 = 4617315517961601024(0x4014000000000000, double:5.0)
            int r0 = (r36 > r38 ? 1 : (r36 == r38 ? 0 : -1))
            if (r0 >= 0) goto L_0x052a
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x04ae
        L_0x052a:
            if (r27 == 0) goto L_0x053f
            com.travel.bus.pojo.busticket.BusRatingModel r0 = r11.getBusRating()     // Catch:{ all -> 0x0758 }
            double r36 = r0.getAvgRating()     // Catch:{ all -> 0x0758 }
            r38 = 4616189618054758400(0x4010000000000000, double:4.0)
            int r0 = (r36 > r38 ? 1 : (r36 == r38 ? 0 : -1))
            if (r0 >= 0) goto L_0x053f
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x04ae
        L_0x053f:
            if (r29 == 0) goto L_0x0571
            java.util.List r0 = r11.getDetailedFare()     // Catch:{ all -> 0x0758 }
            if (r0 == 0) goto L_0x0571
            java.util.List r0 = r11.getDetailedFare()     // Catch:{ all -> 0x0758 }
            int r0 = r0.size()     // Catch:{ all -> 0x0758 }
            if (r0 <= 0) goto L_0x0571
            java.util.List r0 = r11.getDetailedFare()     // Catch:{ all -> 0x0758 }
            r14 = 0
            java.lang.Object r0 = r0.get(r14)     // Catch:{ all -> 0x0758 }
            if (r0 == 0) goto L_0x0572
            java.util.List r0 = r11.getDetailedFare()     // Catch:{ all -> 0x0758 }
            java.lang.Object r0 = r0.get(r14)     // Catch:{ all -> 0x0758 }
            com.travel.bus.pojo.bussearch.CJRDetailedFare r0 = (com.travel.bus.pojo.bussearch.CJRDetailedFare) r0     // Catch:{ all -> 0x0758 }
            com.travel.bus.pojo.bussearch.CJRDeal r0 = r0.getDeal()     // Catch:{ all -> 0x0758 }
            if (r0 != 0) goto L_0x0572
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x04ae
        L_0x0571:
            r14 = 0
        L_0x0572:
            if (r30 == 0) goto L_0x0583
            com.travel.bus.pojo.bussearch.CJRbusSearchItemFlags r0 = r11.getFlags()     // Catch:{ all -> 0x0758 }
            boolean r0 = r0.getSocialDistancingGuaranteed()     // Catch:{ all -> 0x0758 }
            if (r0 != 0) goto L_0x0583
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x04ae
        L_0x0583:
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0758 }
            if (r0 != 0) goto L_0x059e
            java.lang.String r0 = r11.getRouteTimeId()     // Catch:{ all -> 0x0758 }
            if (r0 == 0) goto L_0x059e
            java.lang.String r0 = r11.getRouteTimeId()     // Catch:{ all -> 0x0758 }
            boolean r0 = r2.equalsIgnoreCase(r0)     // Catch:{ all -> 0x0758 }
            if (r0 != 0) goto L_0x059e
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x04ae
        L_0x059e:
            if (r28 == 0) goto L_0x05b3
            com.travel.bus.pojo.busticket.BusRatingModel r0 = r11.getBusRating()     // Catch:{ all -> 0x0758 }
            double r35 = r0.getAvgRating()     // Catch:{ all -> 0x0758 }
            r37 = 4613937818241073152(0x4008000000000000, double:3.0)
            int r0 = (r35 > r37 ? 1 : (r35 == r37 ? 0 : -1))
            if (r0 >= 0) goto L_0x05b3
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x04ae
        L_0x05b3:
            if (r21 == 0) goto L_0x05c2
            if (r22 != 0) goto L_0x05c2
            boolean r0 = a((com.travel.bus.pojo.busticket.CJRBusSearchItem) r11)     // Catch:{ all -> 0x0758 }
            if (r0 != 0) goto L_0x05c2
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x04ae
        L_0x05c2:
            if (r22 == 0) goto L_0x05d1
            if (r21 != 0) goto L_0x05d1
            boolean r0 = a((com.travel.bus.pojo.busticket.CJRBusSearchItem) r11)     // Catch:{ all -> 0x0758 }
            if (r0 == 0) goto L_0x05d1
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x04ae
        L_0x05d1:
            java.lang.String r0 = r11.getDepartureDatetime()     // Catch:{ all -> 0x0758 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0758 }
            if (r0 != 0) goto L_0x0614
            if (r12 == 0) goto L_0x0614
            if (r15 == 0) goto L_0x0614
            java.lang.String r0 = r11.getDepartureDatetime()     // Catch:{ NumberFormatException -> 0x060c }
            java.lang.String r5 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r14 = "HHmm"
            java.lang.String r0 = com.paytm.utility.b.a((java.lang.String) r0, (java.lang.String) r5, (java.lang.String) r14)     // Catch:{ NumberFormatException -> 0x060c }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x060c }
            int r5 = java.lang.Integer.parseInt(r12)     // Catch:{ NumberFormatException -> 0x060c }
            int r14 = java.lang.Integer.parseInt(r15)     // Catch:{ NumberFormatException -> 0x060c }
            if (r5 <= r14) goto L_0x0603
            if (r0 >= r5) goto L_0x0614
            if (r0 <= r14) goto L_0x0614
            r1.remove(r11)     // Catch:{ NumberFormatException -> 0x060c }
            goto L_0x04ae
        L_0x0603:
            if (r0 < r5) goto L_0x0607
            if (r0 <= r14) goto L_0x0614
        L_0x0607:
            r1.remove(r11)     // Catch:{ NumberFormatException -> 0x060c }
            goto L_0x04ae
        L_0x060c:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0758 }
            com.paytm.utility.q.c(r0)     // Catch:{ all -> 0x0758 }
        L_0x0614:
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r0 = r11.getFare()     // Catch:{ all -> 0x0758 }
            if (r0 == 0) goto L_0x0648
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r0 = r11.getFare()     // Catch:{ all -> 0x0758 }
            double[] r0 = r0.getPrices()     // Catch:{ all -> 0x0758 }
            int r0 = r0.length     // Catch:{ all -> 0x0758 }
            if (r0 <= 0) goto L_0x0648
            r0 = 0
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 <= 0) goto L_0x0648
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0648
            r5 = r12
            r14 = r13
            double r12 = (double) r3     // Catch:{ all -> 0x0758 }
            r31 = r2
            r33 = r3
            double r2 = (double) r4     // Catch:{ all -> 0x0758 }
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r0 = r11.getFare()     // Catch:{ all -> 0x0758 }
            double[] r0 = r0.getPrices()     // Catch:{ all -> 0x0758 }
            boolean r0 = a(r12, r2, r0)     // Catch:{ all -> 0x0758 }
            if (r0 != 0) goto L_0x064e
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x0678
        L_0x0648:
            r31 = r2
            r33 = r3
            r5 = r12
            r14 = r13
        L_0x064e:
            boolean r0 = r6.isEmpty()     // Catch:{ all -> 0x0758 }
            if (r0 != 0) goto L_0x0681
            java.util.ArrayList r0 = r11.getBoardingPoints()     // Catch:{ all -> 0x0758 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0758 }
        L_0x065c:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0758 }
            if (r2 == 0) goto L_0x0672
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0758 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0758 }
            if (r2 == 0) goto L_0x065c
            boolean r2 = a((java.lang.String) r2, (java.util.ArrayList<java.lang.String>) r6)     // Catch:{ all -> 0x0758 }
            if (r2 == 0) goto L_0x065c
            r0 = 0
            goto L_0x0673
        L_0x0672:
            r0 = 1
        L_0x0673:
            if (r0 == 0) goto L_0x0681
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
        L_0x0678:
            r12 = r5
            r2 = r31
            r5 = r32
            r3 = r33
            goto L_0x0278
        L_0x0681:
            boolean r0 = r7.isEmpty()     // Catch:{ all -> 0x0758 }
            if (r0 != 0) goto L_0x06ac
            java.util.ArrayList r0 = r11.getDroppingPoints()     // Catch:{ all -> 0x0758 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0758 }
        L_0x068f:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0758 }
            if (r2 == 0) goto L_0x06a5
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0758 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0758 }
            if (r2 == 0) goto L_0x068f
            boolean r2 = a((java.lang.String) r2, (java.util.ArrayList<java.lang.String>) r7)     // Catch:{ all -> 0x0758 }
            if (r2 == 0) goto L_0x068f
            r0 = 0
            goto L_0x06a6
        L_0x06a5:
            r0 = 1
        L_0x06a6:
            if (r0 == 0) goto L_0x06ac
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x0678
        L_0x06ac:
            boolean r0 = r8.isEmpty()     // Catch:{ all -> 0x0758 }
            if (r0 != 0) goto L_0x06ce
            java.lang.String r0 = r11.getComputedTravelsName()     // Catch:{ all -> 0x0758 }
            if (r0 == 0) goto L_0x06ce
            java.lang.String r0 = r11.getComputedTravelsName()     // Catch:{ all -> 0x0758 }
            boolean r2 = r8.isEmpty()     // Catch:{ all -> 0x0758 }
            if (r2 == 0) goto L_0x06c4
            r0 = 0
            goto L_0x06c8
        L_0x06c4:
            boolean r0 = r8.contains(r0)     // Catch:{ all -> 0x0758 }
        L_0x06c8:
            if (r0 != 0) goto L_0x06ce
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x0678
        L_0x06ce:
            int r0 = r9.size()     // Catch:{ all -> 0x0758 }
            if (r0 <= 0) goto L_0x070d
            java.util.ArrayList r0 = r11.getAmenities()     // Catch:{ all -> 0x0758 }
            if (r0 == 0) goto L_0x070a
            java.util.ArrayList r0 = r11.getAmenities()     // Catch:{ all -> 0x0758 }
            int r0 = r0.size()     // Catch:{ all -> 0x0758 }
            if (r0 <= 0) goto L_0x070a
            java.util.ArrayList r0 = r11.getAmenities()     // Catch:{ all -> 0x0758 }
            r2 = 0
            r3 = 0
        L_0x06ea:
            int r12 = r9.size()     // Catch:{ all -> 0x0758 }
            if (r2 >= r12) goto L_0x0704
            java.lang.Object r12 = r9.get(r2)     // Catch:{ all -> 0x0758 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0758 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0758 }
            boolean r12 = r0.contains(r12)     // Catch:{ all -> 0x0758 }
            if (r12 == 0) goto L_0x0701
            r3 = 1
        L_0x0701:
            int r2 = r2 + 1
            goto L_0x06ea
        L_0x0704:
            if (r3 != 0) goto L_0x070d
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x070d
        L_0x070a:
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
        L_0x070d:
            int r0 = r10.size()     // Catch:{ all -> 0x0758 }
            if (r0 <= 0) goto L_0x074c
            java.util.ArrayList r0 = r11.getOperatorTags()     // Catch:{ all -> 0x0758 }
            if (r0 == 0) goto L_0x0749
            java.util.ArrayList r0 = r11.getOperatorTags()     // Catch:{ all -> 0x0758 }
            int r0 = r0.size()     // Catch:{ all -> 0x0758 }
            if (r0 <= 0) goto L_0x0749
            java.util.ArrayList r0 = r11.getOperatorTags()     // Catch:{ all -> 0x0758 }
            r2 = 0
            r3 = 0
        L_0x0729:
            int r12 = r10.size()     // Catch:{ all -> 0x0758 }
            if (r2 >= r12) goto L_0x0743
            java.lang.Object r12 = r10.get(r2)     // Catch:{ all -> 0x0758 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0758 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0758 }
            boolean r12 = r0.contains(r12)     // Catch:{ all -> 0x0758 }
            if (r12 == 0) goto L_0x0740
            r3 = 1
        L_0x0740:
            int r2 = r2 + 1
            goto L_0x0729
        L_0x0743:
            if (r3 != 0) goto L_0x074c
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
            goto L_0x074c
        L_0x0749:
            r1.remove(r11)     // Catch:{ all -> 0x0758 }
        L_0x074c:
            r12 = r5
            r13 = r14
            r2 = r31
            r5 = r32
            r3 = r33
            goto L_0x028d
        L_0x0756:
            monitor-exit(r40)
            return r1
        L_0x0758:
            r0 = move-exception
            monitor-exit(r40)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.g.d.a(java.util.ArrayList, com.travel.bus.pojo.busticket.CJRBusTicketFilters):java.util.ArrayList");
    }

    private static boolean a(String str, ArrayList<String> arrayList) {
        if (arrayList.isEmpty()) {
            return false;
        }
        if (arrayList.contains(str)) {
            return true;
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (it2.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(double d2, double d3, double[] dArr) {
        for (int i2 = 0; i2 < dArr.length; i2++) {
            if (dArr[i2] >= d2 && dArr[i2] <= d3) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(CJRBusSearchItem cJRBusSearchItem) {
        String busTypeName = (cJRBusSearchItem == null || cJRBusSearchItem.getBusTypeName() == null) ? null : cJRBusSearchItem.getBusTypeName();
        if (busTypeName == null) {
            return false;
        }
        if (!busTypeName.toLowerCase().contains("Multi Axle".toLowerCase())) {
            return ((busTypeName.trim().toLowerCase().contains("multi") || busTypeName.trim().toLowerCase().contains("mlt")) && (busTypeName.trim().toLowerCase().contains("axle") || busTypeName.trim().toLowerCase().contains("axel"))) || busTypeName.toLowerCase().contains("MULTI AXLE".toLowerCase()) || busTypeName.toLowerCase().contains("MULTI-AXLE".toLowerCase()) || busTypeName.toLowerCase().contains("MULTIAXLE".toLowerCase()) || busTypeName.toLowerCase().contains("TRI-AXLE".toLowerCase()) || busTypeName.toLowerCase().contains("TRIAXLE".toLowerCase()) || busTypeName.toLowerCase().contains("MULTI-AXEL".toLowerCase()) || busTypeName.toLowerCase().contains("MULTYAXLE".toLowerCase()) || busTypeName.toLowerCase().contains("MULTI-AXILE".toLowerCase()) || busTypeName.toLowerCase().contains("MULTIAXILE".toLowerCase()) || busTypeName.toLowerCase().contains("MULTI AXEL".toLowerCase()) || busTypeName.toLowerCase().contains("TRI AXLE".toLowerCase()) || busTypeName.toLowerCase().contains("MLT AXEL".toLowerCase()) || busTypeName.toLowerCase().contains("M-AXLE".toLowerCase()) || busTypeName.toLowerCase().contains("MUTLIAXLE".toLowerCase()) || busTypeName.toLowerCase().contains("M/Axle".toLowerCase()) || busTypeName.toLowerCase().contains("MALTI AXLE".toLowerCase()) || busTypeName.toLowerCase().contains("MULTI_AXLE".toLowerCase()) || busTypeName.toLowerCase().contains("MULTIAXEL".toLowerCase()) || busTypeName.toLowerCase().contains("MULTI AXILE".toLowerCase()) || busTypeName.toLowerCase().contains("MULTI- AXLE".toLowerCase()) || busTypeName.toLowerCase().contains("MULTI -AXLE".toLowerCase());
        }
        return true;
    }

    private static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusSearchScreen");
            if (com.travel.bus.busticket.i.d.a().f22430h != null) {
                jSONObject.put("requestId", com.travel.bus.busticket.i.d.a().f22430h);
            }
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    private void b() {
        if (com.travel.bus.busticket.i.d.a().f22428f == null) {
            com.travel.bus.busticket.i.d.a().f22428f = this.f22364b;
            return;
        }
        CJRBusSearchInput cJRBusSearchInput = com.travel.bus.busticket.i.d.a().f22428f;
        if (this.f22364b == null || cJRBusSearchInput == null) {
            com.travel.bus.busticket.i.d.a().f22429g = true;
        }
        if (this.f22364b.getSource() != null && this.f22364b.getDestination() != null && this.f22364b.getDate() != null) {
            if (!cJRBusSearchInput.getSource().getName().equalsIgnoreCase(this.f22364b.getSource().getName()) || !cJRBusSearchInput.getDestination().getName().equalsIgnoreCase(this.f22364b.getDestination().getName()) || !cJRBusSearchInput.getDate().equalsIgnoreCase(this.f22364b.getDate())) {
                com.travel.bus.busticket.i.d.a().f22429g = true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0025 A[SYNTHETIC, Splitter:B:17:0x0025] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.travel.bus.pojo.busticket.g a(java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchItem> r24, java.lang.String r25) {
        /*
            r0 = r24
            r1 = r25
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x001c
            int r4 = java.lang.Integer.parseInt(r25)     // Catch:{ Exception -> 0x001c }
            if (r4 <= 0) goto L_0x001a
            com.travel.bus.pojo.busticket.CJRBusTicketFilters r5 = new com.travel.bus.pojo.busticket.CJRBusTicketFilters     // Catch:{ Exception -> 0x001a }
            r5.<init>()     // Catch:{ Exception -> 0x001a }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x001e }
            r6.<init>()     // Catch:{ Exception -> 0x001e }
            r2 = r6
            goto L_0x001e
        L_0x001a:
            r5 = r2
            goto L_0x001e
        L_0x001c:
            r5 = r2
            r4 = 0
        L_0x001e:
            com.travel.bus.pojo.busticket.g r6 = new com.travel.bus.pojo.busticket.g
            r6.<init>()
            if (r0 == 0) goto L_0x01a1
            int r7 = r24.size()     // Catch:{ Exception -> 0x0199 }
            if (r7 <= 0) goto L_0x01a1
            java.lang.Object r7 = r0.get(r3)     // Catch:{ Exception -> 0x0199 }
            com.travel.bus.pojo.busticket.CJRBusSearchItem r7 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r7     // Catch:{ Exception -> 0x0199 }
            r8 = 0
            if (r7 == 0) goto L_0x0060
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r10 = r7.getFare()     // Catch:{ Exception -> 0x0199 }
            if (r10 == 0) goto L_0x0060
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r10 = r7.getFare()     // Catch:{ Exception -> 0x0199 }
            double[] r10 = r10.getPrices()     // Catch:{ Exception -> 0x0199 }
            int r10 = r10.length     // Catch:{ Exception -> 0x0199 }
            if (r10 <= 0) goto L_0x0060
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r8 = r7.getFare()     // Catch:{ Exception -> 0x0199 }
            double[] r8 = r8.getPrices()     // Catch:{ Exception -> 0x0199 }
            r9 = r8[r3]     // Catch:{ Exception -> 0x0199 }
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r7 = r7.getFare()     // Catch:{ Exception -> 0x0199 }
            double[] r7 = r7.getPrices()     // Catch:{ Exception -> 0x0199 }
            r11 = r7[r3]     // Catch:{ Exception -> 0x0199 }
            r22 = r9
            r8 = r11
            r10 = r22
            goto L_0x0061
        L_0x0060:
            r10 = r8
        L_0x0061:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x0199 }
            r7.<init>()     // Catch:{ Exception -> 0x0199 }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x0199 }
            r12.<init>()     // Catch:{ Exception -> 0x0199 }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x0199 }
            r12.<init>()     // Catch:{ Exception -> 0x0199 }
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ Exception -> 0x0199 }
            r13.<init>()     // Catch:{ Exception -> 0x0199 }
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ Exception -> 0x0199 }
            r14.<init>()     // Catch:{ Exception -> 0x0199 }
            java.util.Iterator r0 = r24.iterator()     // Catch:{ Exception -> 0x0199 }
            r15 = 0
        L_0x007f:
            boolean r16 = r0.hasNext()     // Catch:{ Exception -> 0x0199 }
            if (r16 == 0) goto L_0x0169
            java.lang.Object r16 = r0.next()     // Catch:{ Exception -> 0x0199 }
            com.travel.bus.pojo.busticket.CJRBusSearchItem r16 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r16     // Catch:{ Exception -> 0x0199 }
            if (r16 == 0) goto L_0x0166
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r17 = r16.getFare()     // Catch:{ Exception -> 0x0199 }
            double[] r3 = r17.getPrices()     // Catch:{ Exception -> 0x0199 }
            r18 = r8
            r8 = 0
        L_0x0098:
            int r9 = r3.length     // Catch:{ Exception -> 0x0199 }
            if (r8 >= r9) goto L_0x00af
            r20 = r3[r8]     // Catch:{ Exception -> 0x0199 }
            int r9 = (r20 > r10 ? 1 : (r20 == r10 ? 0 : -1))
            if (r9 >= 0) goto L_0x00a4
            r9 = r3[r8]     // Catch:{ Exception -> 0x0199 }
            r10 = r9
        L_0x00a4:
            r20 = r3[r8]     // Catch:{ Exception -> 0x0199 }
            int r9 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1))
            if (r9 <= 0) goto L_0x00ac
            r18 = r3[r8]     // Catch:{ Exception -> 0x0199 }
        L_0x00ac:
            int r8 = r8 + 1
            goto L_0x0098
        L_0x00af:
            com.travel.bus.pojo.busticket.CJRTravelName r3 = new com.travel.bus.pojo.busticket.CJRTravelName     // Catch:{ Exception -> 0x0199 }
            r3.<init>()     // Catch:{ Exception -> 0x0199 }
            com.travel.bus.pojo.CJRBusSearchOperatorInfo r8 = r16.getOperatorObj()     // Catch:{ Exception -> 0x0199 }
            java.lang.String r8 = r8.getName()     // Catch:{ Exception -> 0x0199 }
            r3.setTravelsName(r8)     // Catch:{ Exception -> 0x0199 }
            java.lang.String r9 = r16.getComputedTravelsName()     // Catch:{ Exception -> 0x0199 }
            r3.setComputedTravelsName(r9)     // Catch:{ Exception -> 0x0199 }
            boolean r9 = r14.contains(r8)     // Catch:{ Exception -> 0x0199 }
            if (r9 != 0) goto L_0x00d2
            r7.add(r3)     // Catch:{ Exception -> 0x0199 }
            r14.add(r8)     // Catch:{ Exception -> 0x0199 }
        L_0x00d2:
            java.lang.Integer r3 = r16.getOperatorId()     // Catch:{ Exception -> 0x0199 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0199 }
            if (r3 == 0) goto L_0x0114
            java.lang.Integer r3 = r16.getOperatorId()     // Catch:{ Exception -> 0x0199 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0199 }
            if (r3 != r4) goto L_0x0114
            if (r15 != 0) goto L_0x0114
            com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r3 = new com.travel.bus.pojo.busticket.CJRBusTicketFilterItem     // Catch:{ Exception -> 0x0199 }
            r3.<init>()     // Catch:{ Exception -> 0x0199 }
            com.travel.bus.pojo.busticket.e r8 = com.travel.bus.pojo.busticket.e.BUS_OPERATOR     // Catch:{ Exception -> 0x0199 }
            r3.setFilterCategory(r8)     // Catch:{ Exception -> 0x0199 }
            java.lang.String r8 = "Opr"
            r3.setTitle(r8)     // Catch:{ Exception -> 0x0199 }
            java.lang.String r8 = "list"
            r3.setType(r8)     // Catch:{ Exception -> 0x0199 }
            r3.setOperatorId(r1)     // Catch:{ Exception -> 0x0199 }
            java.lang.String r8 = r16.getTravelsName()     // Catch:{ Exception -> 0x0199 }
            r3.setDisplayValue(r8)     // Catch:{ Exception -> 0x0199 }
            java.lang.String r8 = r16.getComputedTravelsName()     // Catch:{ Exception -> 0x0199 }
            r3.setFilterValue(r8)     // Catch:{ Exception -> 0x0199 }
            r2.add(r3)     // Catch:{ Exception -> 0x0199 }
            r5.setBusTicketFilterItems(r2)     // Catch:{ Exception -> 0x0199 }
            r15 = 1
        L_0x0114:
            java.util.ArrayList r3 = r16.getBoardingPoints()     // Catch:{ Exception -> 0x0199 }
            if (r3 == 0) goto L_0x013c
            int r8 = r3.size()     // Catch:{ Exception -> 0x0199 }
            if (r8 <= 0) goto L_0x013c
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0199 }
        L_0x0124:
            boolean r8 = r3.hasNext()     // Catch:{ Exception -> 0x0199 }
            if (r8 == 0) goto L_0x013c
            java.lang.Object r8 = r3.next()     // Catch:{ Exception -> 0x0199 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0199 }
            if (r8 == 0) goto L_0x0124
            boolean r9 = r12.contains(r8)     // Catch:{ Exception -> 0x0199 }
            if (r9 != 0) goto L_0x0124
            r12.add(r8)     // Catch:{ Exception -> 0x0199 }
            goto L_0x0124
        L_0x013c:
            java.util.ArrayList r3 = r16.getDroppingPoints()     // Catch:{ Exception -> 0x0199 }
            if (r3 == 0) goto L_0x0164
            int r8 = r3.size()     // Catch:{ Exception -> 0x0199 }
            if (r8 <= 0) goto L_0x0164
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0199 }
        L_0x014c:
            boolean r8 = r3.hasNext()     // Catch:{ Exception -> 0x0199 }
            if (r8 == 0) goto L_0x0164
            java.lang.Object r8 = r3.next()     // Catch:{ Exception -> 0x0199 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0199 }
            if (r8 == 0) goto L_0x014c
            boolean r9 = r13.contains(r8)     // Catch:{ Exception -> 0x0199 }
            if (r9 != 0) goto L_0x014c
            r13.add(r8)     // Catch:{ Exception -> 0x0199 }
            goto L_0x014c
        L_0x0164:
            r8 = r18
        L_0x0166:
            r3 = 0
            goto L_0x007f
        L_0x0169:
            java.util.Collections.sort(r12)     // Catch:{ Exception -> 0x0199 }
            java.util.Collections.sort(r13)     // Catch:{ Exception -> 0x0199 }
            java.util.Collections.sort(r7)     // Catch:{ Exception -> 0x0199 }
            com.travel.bus.pojo.busticket.CJRBusFilterContainer r0 = new com.travel.bus.pojo.busticket.CJRBusFilterContainer     // Catch:{ Exception -> 0x0199 }
            r0.<init>()     // Catch:{ Exception -> 0x0199 }
            java.util.ArrayList r1 = c(r12)     // Catch:{ Exception -> 0x0199 }
            r0.setBoardingLocation(r1)     // Catch:{ Exception -> 0x0199 }
            java.util.ArrayList r1 = d(r13)     // Catch:{ Exception -> 0x0199 }
            r0.setDroppingLocations(r1)     // Catch:{ Exception -> 0x0199 }
            r0.setBusOperators(r7)     // Catch:{ Exception -> 0x0199 }
            if (r4 <= 0) goto L_0x018d
            r0.setmBusTicketFilters(r5)     // Catch:{ Exception -> 0x0199 }
        L_0x018d:
            float r1 = (float) r8     // Catch:{ Exception -> 0x0199 }
            float r2 = (float) r10     // Catch:{ Exception -> 0x0199 }
            r6.f22812a = r1     // Catch:{ Exception -> 0x0199 }
            r6.f22813b = r2     // Catch:{ Exception -> 0x0199 }
            r6.f22814c = r0     // Catch:{ Exception -> 0x0199 }
            r0 = 0
            r6.f22815d = r0     // Catch:{ Exception -> 0x0199 }
            goto L_0x01a1
        L_0x0199:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x01a1:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.g.d.a(java.util.ArrayList, java.lang.String):com.travel.bus.pojo.busticket.g");
    }

    private static ArrayList<CJRLocation> c(ArrayList<String> arrayList) {
        ArrayList<CJRLocation> arrayList2 = new ArrayList<>();
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRLocation cJRLocation = new CJRLocation();
            cJRLocation.setLocationName(it2.next());
            arrayList2.add(cJRLocation);
        }
        return arrayList2;
    }

    private static ArrayList<CJRLocation> d(ArrayList<String> arrayList) {
        ArrayList<CJRLocation> arrayList2 = new ArrayList<>();
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRLocation cJRLocation = new CJRLocation();
            cJRLocation.setLocationName(it2.next());
            arrayList2.add(cJRLocation);
        }
        return arrayList2;
    }

    public final void a(CJRBusSearchItem cJRBusSearchItem, int i2, ArrayList<CJRBusSearchItem> arrayList, HashMap<String, CJRBusSearchOperatorTagInfo> hashMap, HashMap<String, CJRBusSearchAmenitiesInfo> hashMap2) {
        Handler handler = this.f22369g;
        if (handler != null) {
            handler.post(new Runnable(cJRBusSearchItem, i2, arrayList, hashMap, hashMap2) {
                private final /* synthetic */ CJRBusSearchItem f$1;
                private final /* synthetic */ int f$2;
                private final /* synthetic */ ArrayList f$3;
                private final /* synthetic */ HashMap f$4;
                private final /* synthetic */ HashMap f$5;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                }

                public final void run() {
                    d.this.b(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                }
            });
        }
    }

    public static String a(String str, int i2) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            a2 = b(str);
        }
        Object[] objArr = new Object[4];
        objArr[0] = i2 > 1 ? " all " : " ";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = a2;
        objArr[3] = i2 > 1 ? " buses" : " bus";
        return String.format("Show%s%s %s%s", objArr);
    }

    private static String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int lastIndexOf = str.lastIndexOf(40);
            int lastIndexOf2 = str.lastIndexOf(41);
            return (lastIndexOf < 0 || lastIndexOf2 < 0 || lastIndexOf >= lastIndexOf2) ? "" : str.substring(lastIndexOf + 1, lastIndexOf2);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String b(String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split("(\\s)+")) {
            if (str2.charAt(0) != '(') {
                sb.append(str2.charAt(0));
            }
        }
        return sb.toString();
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRBusSearch)) {
            this.f22368f = true;
            CJRBusSearch cJRBusSearch = (CJRBusSearch) iJRPaytmDataModel;
            com.travel.bus.busticket.i.d.a().f22430h = cJRBusSearch.getMeta().getRequestid();
            this.f22366d.onUpdateApiResult(cJRBusSearch);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (this.f22367e || !networkCustomError.getErrorType().equals(NetworkCustomError.ErrorType.TimeOutError)) {
            this.f22366d.onUpdateApiError(i2, networkCustomError, iJRPaytmDataModel);
        } else {
            this.f22366d.showTimeOutError(this.f22368f);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(CJRBusSearchItem cJRBusSearchItem, int i2, ArrayList arrayList, HashMap hashMap, HashMap hashMap2) {
        HashMap hashMap3 = hashMap2;
        Object[] objArr = new Object[4];
        objArr[0] = SDKConstants.EVENT_KEY_SCREEN_NAME;
        objArr[1] = "/bus-tickets-search";
        objArr[2] = "ecommerce";
        Object[] objArr2 = new Object[2];
        objArr2[0] = "click";
        Object[] objArr3 = new Object[2];
        objArr3[0] = "actionField";
        Object[] objArr4 = new Object[2];
        objArr4[0] = "products";
        Object[] objArr5 = new Object[1];
        Object[] objArr6 = new Object[42];
        objArr6[0] = "dimension85";
        objArr6[1] = cJRBusSearchItem.getTripId2();
        objArr6[2] = "dimension86";
        ArrayList<Integer> amenities = cJRBusSearchItem.getAmenities();
        ArrayList arrayList2 = new ArrayList();
        if (!(hashMap3 == null || hashMap2.size() == 0 || amenities == null || amenities.size() == 0)) {
            Iterator<Integer> it2 = amenities.iterator();
            while (it2.hasNext()) {
                CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo = (CJRBusSearchAmenitiesInfo) hashMap3.get(String.valueOf(it2.next().intValue()));
                if (cJRBusSearchAmenitiesInfo != null) {
                    arrayList2.add(cJRBusSearchAmenitiesInfo.getName());
                }
            }
        }
        objArr6[3] = arrayList2;
        objArr6[4] = "dimension87";
        objArr6[5] = Double.valueOf(cJRBusSearchItem.getBusRating().getAvgRating());
        objArr6[6] = "dimension88";
        objArr6[7] = Integer.valueOf(cJRBusSearchItem.getBusRating().getCount());
        objArr6[8] = "dimension89";
        objArr6[9] = cJRBusSearchItem.getDuration();
        objArr6[10] = "variant";
        objArr6[11] = Boolean.valueOf(!cJRBusSearchItem.getFlags().isAc().booleanValue());
        objArr6[12] = "category";
        objArr6[13] = Boolean.valueOf(!cJRBusSearchItem.getFlags().isSleeper().booleanValue());
        objArr6[14] = "dimension92";
        objArr6[15] = cJRBusSearchItem.getOperatorObj().getProviderId();
        objArr6[16] = "dimension93";
        objArr6[17] = cJRBusSearchItem.getAvalableSeats();
        objArr6[18] = "price";
        objArr6[19] = cJRBusSearchItem.getFare().getPrices();
        objArr6[20] = CLPConstants.BRAND_PARAMS;
        objArr6[21] = cJRBusSearchItem.getOperatorObj().getName();
        objArr6[22] = "dimension96";
        objArr6[23] = Long.valueOf(this.f22364b.getSource().getCityId());
        objArr6[24] = "dimension97";
        objArr6[25] = Long.valueOf(this.f22364b.getDestination().getCityId());
        objArr6[26] = "dimension99";
        objArr6[27] = cJRBusSearchItem.getSource();
        objArr6[28] = "dimension100";
        objArr6[29] = cJRBusSearchItem.getDestination();
        objArr6[30] = "dimension101";
        objArr6[31] = o.a(cJRBusSearchItem.getOperatorTags(), (HashMap<String, CJRBusSearchOperatorTagInfo>) hashMap);
        objArr6[32] = CLPConstants.ARGUMENT_KEY_POSITION;
        objArr6[33] = Integer.valueOf(arrayList.indexOf(cJRBusSearchItem));
        objArr6[34] = "name";
        objArr6[35] = cJRBusSearchItem.getSource() + "-" + cJRBusSearchItem.getDestination();
        objArr6[36] = "id";
        objArr6[37] = String.valueOf(cJRBusSearchItem.getOperatorId());
        objArr6[38] = "dimension102";
        objArr6[39] = Integer.valueOf(i2 + 1);
        objArr6[40] = "dimension103";
        objArr6[41] = cJRBusSearchItem.getOperatorObj().getIsGrouped();
        objArr5[0] = t.a(objArr6);
        objArr4[1] = t.b(objArr5);
        objArr3[1] = t.a(objArr4);
        objArr2[1] = t.a(objArr3);
        objArr[3] = t.a(objArr2);
        Map<String, Object> a2 = t.a(objArr);
        com.travel.bus.a.a();
        com.travel.bus.a.a("customEvent", "/bus-tickets-search", "ecommerce", "productClick", a2);
    }
}
