package com.travel.bus.orders.d;

import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.travel.bus.busticket.i.y;
import com.travel.bus.orders.f.e;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse;
import com.travel.bus.pojo.busticket.CJRBusPassengerData;
import com.travel.bus.pojo.hotel.CJRHotelObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public String f22630a = "CJRHotelCardApiHelper";

    /* renamed from: b  reason: collision with root package name */
    public String f22631b;

    /* renamed from: c  reason: collision with root package name */
    public CJRBusOrderSummary f22632c;

    /* renamed from: d  reason: collision with root package name */
    private final e f22633d;

    public c(e eVar) {
        k.c(eVar, "onHotelResponseListener");
        this.f22633d = eVar;
    }

    public static String a(CJRBusOrderSummaryMetaDataResponse cJRBusOrderSummaryMetaDataResponse) {
        int i2;
        int i3;
        ArrayList<CJRBusPassengerData> passengerData = cJRBusOrderSummaryMetaDataResponse.getPassengerData();
        List<Number> arrayList = new ArrayList<>();
        if (passengerData != null) {
            Iterator<CJRBusPassengerData> it2 = passengerData.iterator();
            i3 = 0;
            i2 = 0;
            while (it2.hasNext()) {
                CJRBusPassengerData next = it2.next();
                k.a((Object) next, "passenger");
                String age = next.getAge();
                k.a((Object) age, "passenger.age");
                if (((int) Double.parseDouble(age)) <= 13) {
                    i2++;
                    String age2 = next.getAge();
                    k.a((Object) age2, "passenger.age");
                    arrayList.add(Integer.valueOf((int) Double.parseDouble(age2)));
                } else {
                    i3++;
                }
            }
        } else {
            i3 = 0;
            i2 = 0;
        }
        if (i2 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(i3);
            sb.append('|');
            sb.append(i2);
            sb.append('|');
            String sb2 = sb.toString();
            for (Number intValue : arrayList) {
                sb2 = sb2 + intValue.intValue() + '|';
            }
            int length = sb2.length() - 1;
            if (sb2 != null) {
                String substring = sb2.substring(0, length);
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i3);
        sb3.append('|');
        sb3.append(i2);
        sb3.append('|');
        return sb3.toString();
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusOrderSummaryScreen");
            if (this.f22632c != null) {
                CJRBusOrderSummary cJRBusOrderSummary = this.f22632c;
                if (cJRBusOrderSummary == null) {
                    k.a();
                }
                if (cJRBusOrderSummary.getId() != null) {
                    CJRBusOrderSummary cJRBusOrderSummary2 = this.f22632c;
                    if (cJRBusOrderSummary2 == null) {
                        k.a();
                    }
                    jSONObject.put("order_id", cJRBusOrderSummary2.getId());
                }
            }
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return jSONObject;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
        if (iJRPaytmDataModel instanceof CJRHotelObject) {
            y yVar = y.f22482a;
            y.a((Object) iJRPaytmDataModel);
            c.class.getSimpleName();
            this.f22633d.a((CJRHotelObject) iJRPaytmDataModel);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
        k.c(networkCustomError, "networkCustomError");
        c.class.getSimpleName();
        this.f22633d.d();
    }
}
