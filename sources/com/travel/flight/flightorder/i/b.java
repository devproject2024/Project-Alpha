package com.travel.flight.flightorder.i;

import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems;

public final class b {
    public static boolean a(CJROrderSummaryItems cJROrderSummaryItems) {
        if (cJROrderSummaryItems == null || cJROrderSummaryItems == null || !"Flights".equalsIgnoreCase(cJROrderSummaryItems.getType())) {
            return false;
        }
        try {
            if (cJROrderSummaryItems.getType().equalsIgnoreCase("ancillary")) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public static int a(ArrayList<CJROrderSummaryItems> arrayList) {
        Iterator<CJROrderSummaryItems> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJROrderSummaryItems next = it2.next();
            if (next.getNumber_of_passengers() != null) {
                try {
                    return Integer.parseInt(next.getNumber_of_passengers());
                } catch (NumberFormatException unused) {
                }
            }
        }
        return 0;
    }
}
