package com.travel.bus.b;

import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b {
    public static ArrayList<String> a(ArrayList<Integer> arrayList, HashMap<String, CJRBusSearchAmenitiesInfo> hashMap) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (hashMap != null && hashMap.size() != 0 && arrayList != null && arrayList.size() != 0) {
            Iterator<Integer> it2 = arrayList.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo = hashMap.get(String.valueOf(it2.next().intValue()));
                if (cJRBusSearchAmenitiesInfo != null) {
                    arrayList2.add(cJRBusSearchAmenitiesInfo.getIcon());
                    i2++;
                    if (i2 == 5) {
                        break;
                    }
                }
            }
        }
        return arrayList2;
    }

    public static ArrayList<String> a(ArrayList<Integer> arrayList, HashMap<String, CJRBusSearchAmenitiesInfo> hashMap, int i2) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<Integer> it2 = arrayList.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            arrayList2.add(hashMap.get(String.valueOf(it2.next().intValue())).getIcon());
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList2;
    }
}
