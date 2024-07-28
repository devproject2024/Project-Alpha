package com.paytm.network.b;

import com.paytm.network.model.Header;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c {
    public static List<Header> a(List<com.android.volley.Header> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (com.android.volley.Header next : list) {
            arrayList.add(new Header(next.getName(), next.getValue()));
        }
        return arrayList;
    }
}
