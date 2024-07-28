package com.travel.bus.busticket.g;

import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.a;
import com.travel.bus.busticket.a.f;
import com.travel.bus.busticket.fragment.b;
import com.travel.bus.pojo.busticket.BusRecentLocationData;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRLocation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class c {
    public static h a(BusRecentLocationData busRecentLocationData, BusRecentLocationData busRecentLocationData2, boolean z, ArrayList<CJRLocation> arrayList, f.a aVar, List<Address> list, double d2, double d3, List<Address> list2, double d4, double d5) {
        b bVar;
        boolean z2 = z;
        f.a aVar2 = aVar;
        Bundle bundle = new Bundle();
        ArrayList<CJRLocation> arrayList2 = arrayList;
        bundle.putSerializable("bus_bundle_location_list", arrayList);
        bundle.putBoolean("bus_is_boarding_point", z);
        if (z2) {
            if (busRecentLocationData != null) {
                bVar = new b(aVar);
                bundle.putDouble("bus_bundle_latitude", busRecentLocationData.getLatitude().doubleValue());
                bundle.putDouble("bus_bundle_longitude", busRecentLocationData.getLongitude().doubleValue());
                bundle.putBoolean("bus_bundle_is_lat_long_present", true);
            } else if (list != null) {
                bVar = new b(aVar);
                bundle.putDouble("bus_bundle_latitude", d2);
                bundle.putDouble("bus_bundle_longitude", d3);
                bundle.putBoolean("bus_bundle_is_lat_long_present", true);
            } else {
                bVar = new b(aVar);
                bundle.putBoolean("bus_bundle_is_lat_long_present", false);
            }
        } else if (busRecentLocationData2 != null) {
            bVar = new b(aVar);
            bundle.putDouble("bus_bundle_latitude", busRecentLocationData2.getLatitude().doubleValue());
            bundle.putDouble("bus_bundle_longitude", busRecentLocationData2.getLongitude().doubleValue());
            bundle.putBoolean("bus_bundle_is_lat_long_present", true);
        } else if (list2 != null) {
            bVar = new b(aVar);
            bundle.putDouble("bus_bundle_latitude", d4);
            bundle.putDouble("bus_bundle_longitude", d5);
            bundle.putBoolean("bus_bundle_is_lat_long_present", true);
        } else {
            bVar = new b(aVar);
            bundle.putBoolean("bus_bundle_is_lat_long_present", false);
        }
        bVar.setArguments(bundle);
        return bVar;
    }

    public static void a(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_boarding");
        hashMap.put("event_action", "find_nearest_clicked");
        if (z) {
            hashMap.put("event_label", "boarding");
        } else {
            hashMap.put("event_label", "dropping");
        }
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Boarding screen");
        hashMap.put("vertical_name", "bus");
        a.a();
        hashMap.put("user_id", com.paytm.utility.b.n(a.b().D()));
        a.a();
        com.travel.g.a b2 = a.b();
        a.a();
        b2.a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, a.b().D());
    }

    public static CJRBusSearchItem a(CJRBusSearchItem cJRBusSearchItem, double d2, double d3, boolean z) {
        if (cJRBusSearchItem == null) {
            return null;
        }
        for (int i2 = 0; i2 < cJRBusSearchItem.getDroppingLocations().size(); i2++) {
            cJRBusSearchItem.getDroppingLocations().get(i2).setSelectedLatitude(d2);
            cJRBusSearchItem.getDroppingLocations().get(i2).setSelectedLongitude(d3);
            cJRBusSearchItem.getDroppingLocations().get(i2).setIsSelected(z);
        }
        return cJRBusSearchItem;
    }

    public static CJRBusSearchItem b(CJRBusSearchItem cJRBusSearchItem, double d2, double d3, boolean z) {
        if (cJRBusSearchItem == null) {
            return null;
        }
        for (int i2 = 0; i2 < cJRBusSearchItem.getBoardingLocations().size(); i2++) {
            cJRBusSearchItem.getBoardingLocations().get(i2).setSelectedLatitude(d2);
            cJRBusSearchItem.getBoardingLocations().get(i2).setSelectedLongitude(d3);
            cJRBusSearchItem.getBoardingLocations().get(i2).setIsSelected(z);
        }
        return cJRBusSearchItem;
    }

    public static CJRBusSearchItem a(double d2, double d3, boolean z, CJRBusSearchItem cJRBusSearchItem) {
        if (cJRBusSearchItem != null) {
            if (z) {
                Iterator<CJRLocation> it2 = cJRBusSearchItem.getBoardingLocations().iterator();
                while (it2.hasNext()) {
                    CJRLocation next = it2.next();
                    if (a(next)) {
                        next.setDistance(String.format("%.1f", new Object[]{Float.valueOf(a(next, d2, d3, new Location(""), new Location("")))}));
                    }
                }
                Collections.sort(cJRBusSearchItem.getBoardingLocations());
            } else {
                Iterator<CJRLocation> it3 = cJRBusSearchItem.getDroppingLocations().iterator();
                while (it3.hasNext()) {
                    CJRLocation next2 = it3.next();
                    if (a(next2)) {
                        next2.setDistance(String.format("%.1f", new Object[]{Float.valueOf(a(next2, d2, d3, new Location(""), new Location("")))}));
                    }
                }
                Collections.sort(cJRBusSearchItem.getDroppingLocations());
            }
        }
        return cJRBusSearchItem;
    }

    private static boolean a(CJRLocation cJRLocation) {
        if (cJRLocation == null || cJRLocation.getLatitude() == null || cJRLocation.getLatitude().equalsIgnoreCase("null") || cJRLocation.getLongitude() == null || cJRLocation.getLongitude().equalsIgnoreCase("null")) {
            return false;
        }
        return true;
    }

    private static float a(CJRLocation cJRLocation, double d2, double d3, Location location, Location location2) {
        if (cJRLocation == null || TextUtils.isEmpty(cJRLocation.getLatitude()) || TextUtils.isEmpty(cJRLocation.getLongitude())) {
            return 0.0f;
        }
        location.setLatitude(d2);
        location.setLongitude(d3);
        location2.setLatitude(Double.parseDouble(cJRLocation.getLatitude()));
        location2.setLongitude(Double.parseDouble(cJRLocation.getLongitude()));
        return location.distanceTo(location2) / 1000.0f;
    }
}
