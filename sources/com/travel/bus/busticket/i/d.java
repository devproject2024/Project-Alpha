package com.travel.bus.busticket.i;

import com.travel.bus.pojo.bussearch.CJRBusSearchItemDictionary;
import com.travel.bus.pojo.busticket.CJRBusFilterContainer;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRLocation;
import java.util.ArrayList;
import java.util.Map;

public class d {

    /* renamed from: i  reason: collision with root package name */
    private static d f22422i;

    /* renamed from: a  reason: collision with root package name */
    public CJRBusFilterContainer f22423a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRBusSearchItem> f22424b;

    /* renamed from: c  reason: collision with root package name */
    public CJRBusSearchItemDictionary f22425c;

    /* renamed from: d  reason: collision with root package name */
    public Map<CJRLocation, Integer> f22426d;

    /* renamed from: e  reason: collision with root package name */
    public Map<CJRLocation, Integer> f22427e;

    /* renamed from: f  reason: collision with root package name */
    public CJRBusSearchInput f22428f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22429g = false;

    /* renamed from: h  reason: collision with root package name */
    public String f22430h;

    private d() {
    }

    public static d a() {
        if (f22422i == null) {
            synchronized (d.class) {
                if (f22422i == null) {
                    f22422i = new d();
                }
            }
        }
        return f22422i;
    }

    public static void b() {
        f22422i = null;
    }

    public final ArrayList<CJRBusSearchItem> c() {
        return this.f22424b;
    }

    public final CJRBusFilterContainer d() {
        return this.f22423a;
    }

    public final CJRBusSearchItemDictionary e() {
        return this.f22425c;
    }
}
