package com.travel.bus.busticket.g;

import android.text.TextUtils;
import com.paytm.utility.q;
import com.travel.bus.pojo.busticket.CJRBusSearchCancellationPolicy;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static ArrayList<CJRBusSearchCancellationPolicy> a(CJRBusSearchItem cJRBusSearchItem) {
        ArrayList<CJRBusSearchCancellationPolicy> arrayList = null;
        if (cJRBusSearchItem == null) {
            return null;
        }
        String travelsName = cJRBusSearchItem.getTravelsName();
        if (TextUtils.isEmpty(travelsName)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(travelsName).getJSONArray("cancellationPolicyJSON");
            if (jSONArray == null) {
                return null;
            }
            ArrayList<CJRBusSearchCancellationPolicy> arrayList2 = new ArrayList<>();
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    CJRBusSearchCancellationPolicy cJRBusSearchCancellationPolicy = new CJRBusSearchCancellationPolicy();
                    if (jSONObject != null) {
                        cJRBusSearchCancellationPolicy.setDeparture_heading(jSONObject.getString("departure_heading"));
                        cJRBusSearchCancellationPolicy.setPolicy_heading(jSONObject.getString("policy_heading"));
                    }
                    arrayList2.add(cJRBusSearchCancellationPolicy);
                    i2++;
                } catch (JSONException e2) {
                    e = e2;
                    arrayList = arrayList2;
                    q.c(e.getMessage());
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (JSONException e3) {
            e = e3;
            q.c(e.getMessage());
            return arrayList;
        }
    }

    public static double a(ArrayList<TripBusDetailsItem> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return 0.0d;
        }
        double d2 = 0.0d;
        int i2 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i2).getFare() != null && !arrayList.get(i2).getFare().isEmpty()) {
                try {
                    d2 = Double.parseDouble(arrayList.get(i2).getFare());
                    if (d2 != 0.0d) {
                        d2 = Double.parseDouble(arrayList.get(i2).getFare());
                        break;
                    }
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
            }
            i2++;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3).getFare() != null && !arrayList.get(i3).getFare().isEmpty()) {
                try {
                    double parseDouble = Double.parseDouble(arrayList.get(i3).getFare());
                    int i4 = (parseDouble > 0.0d ? 1 : (parseDouble == 0.0d ? 0 : -1));
                    if (i4 != 0 && parseDouble < d2) {
                        d2 = Double.parseDouble(arrayList.get(i3).getFare());
                    }
                    if (parseDouble <= d2 && i4 != 0) {
                        d2 = parseDouble;
                    }
                } catch (Exception e3) {
                    q.c(e3.getMessage());
                }
            }
        }
        return d2;
    }
}
