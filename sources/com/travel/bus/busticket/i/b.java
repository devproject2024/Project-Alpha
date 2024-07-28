package com.travel.bus.busticket.i;

import com.travel.bus.busticket.e.n;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public n f22418a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRBusSearchItem> f22419b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, ArrayList<Integer>> f22420c;

    public b(n nVar, ArrayList<CJRBusSearchItem> arrayList, HashMap<String, ArrayList<Integer>> hashMap) {
        k.c(nVar, "groupViewHolder");
        k.c(arrayList, "groupSearchItem");
        k.c(hashMap, "originalHashMap");
        this.f22418a = nVar;
        this.f22419b = arrayList;
        this.f22420c = hashMap;
    }
}
