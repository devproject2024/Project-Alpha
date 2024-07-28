package net.one97.paytm.hotel4.service.a;

import android.content.Context;
import com.google.gsonhtcfix.f;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem;
import net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem;
import net.one97.paytm.hotel4.utils.d;
import net.one97.paytm.hotels2.utils.c;

public final class b {
    public static void a(AutoSearchDataItem autoSearchDataItem) {
        k.c(autoSearchDataItem, "data");
        boolean z = true;
        try {
            autoSearchDataItem.setRecentSearch(true);
            autoSearchDataItem.setViewType(1);
            ArrayList<AutoSearchDataItem> a2 = a();
            Iterator it2 = a2.iterator();
            int i2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i2 = -1;
                    break;
                }
                AutoSearchDataItem autoSearchDataItem2 = (AutoSearchDataItem) it2.next();
                SearchParamsDataItem searchParams = autoSearchDataItem2.getSearchParams();
                String str = null;
                String city = searchParams != null ? searchParams.getCity() : null;
                SearchParamsDataItem searchParams2 = autoSearchDataItem.getSearchParams();
                if (p.a(city, searchParams2 != null ? searchParams2.getCity() : null, true)) {
                    SearchParamsDataItem searchParams3 = autoSearchDataItem.getSearchParams();
                    String poi = searchParams3 != null ? searchParams3.getPoi() : null;
                    SearchParamsDataItem searchParams4 = autoSearchDataItem2.getSearchParams();
                    if (searchParams4 != null) {
                        str = searchParams4.getPoi();
                    }
                    if (p.a(poi, str, true)) {
                        z = false;
                        break;
                    }
                }
                i2++;
            }
            if (z) {
                if (a2.size() == 5) {
                    a2.remove(4);
                }
            } else if (i2 != -1) {
                a2.remove(i2);
            }
            a2.add(0, autoSearchDataItem);
            Type type = new C0497b().getType();
            d.a aVar = d.f28640a;
            net.one97.paytm.hotels2.utils.d b2 = c.b();
            k.a((Object) b2, "HotelController.getHotelEventListener()");
            Context a3 = b2.a();
            k.a((Object) a3, "HotelController.getHotelEventListener().appContext");
            Context applicationContext = a3.getApplicationContext();
            k.a((Object) applicationContext, "HotelController.getHotel…ontext.applicationContext");
            d.a.a(applicationContext).a("hotel_five_recent_search", new f().a((Object) a2, type), false);
        } catch (Exception unused) {
        }
    }

    /* renamed from: net.one97.paytm.hotel4.service.a.b$b  reason: collision with other inner class name */
    public static final class C0497b extends com.google.gson.b.a<ArrayList<AutoSearchDataItem>> {
        C0497b() {
        }
    }

    public static final class a extends com.google.gson.b.a<ArrayList<AutoSearchDataItem>> {
        a() {
        }
    }

    public static ArrayList<AutoSearchDataItem> a() {
        Type type = new a().getType();
        ArrayList<AutoSearchDataItem> arrayList = new ArrayList<>();
        d.a aVar = d.f28640a;
        net.one97.paytm.hotels2.utils.d b2 = c.b();
        k.a((Object) b2, "HotelController.getHotelEventListener()");
        Context a2 = b2.a();
        k.a((Object) a2, "HotelController.getHotelEventListener().appContext");
        Context applicationContext = a2.getApplicationContext();
        k.a((Object) applicationContext, "HotelController.getHotel…ontext.applicationContext");
        String b3 = d.a.a(applicationContext).b("hotel_five_recent_search", "", false);
        if (!(!k.a((Object) b3, (Object) ""))) {
            return arrayList;
        }
        Object a3 = new f().a(b3, type);
        k.a(a3, "Gson().fromJson(jsonData, type)");
        return (ArrayList) a3;
    }

    public static void a(Context context, String str, String str2) {
        com.paytm.b.a.a aVar;
        Context applicationContext;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            aVar = null;
        } else {
            d.a aVar2 = d.f28640a;
            aVar = d.a.a(applicationContext);
        }
        if (str != null) {
            if (aVar == null) {
                k.a();
            }
            aVar.a("checkindate", str, false);
        } else {
            if (aVar == null) {
                k.a();
            }
            aVar.a("checkindate", false);
        }
        if (str2 != null) {
            aVar.a("checkOutdate", str2, false);
        } else {
            aVar.a("checkOutdate", false);
        }
    }

    public static String b() {
        d.a aVar = d.f28640a;
        net.one97.paytm.hotels2.utils.d b2 = c.b();
        k.a((Object) b2, "HotelController.getHotelEventListener()");
        Context a2 = b2.a();
        k.a((Object) a2, "HotelController.getHotelEventListener().appContext");
        Context applicationContext = a2.getApplicationContext();
        k.a((Object) applicationContext, "HotelController.getHotel…ontext.applicationContext");
        return d.a.a(applicationContext).b("checkOutdate", "", false);
    }

    public static String c() {
        d.a aVar = d.f28640a;
        net.one97.paytm.hotels2.utils.d b2 = c.b();
        k.a((Object) b2, "HotelController.getHotelEventListener()");
        Context a2 = b2.a();
        k.a((Object) a2, "HotelController.getHotelEventListener().appContext");
        Context applicationContext = a2.getApplicationContext();
        k.a((Object) applicationContext, "HotelController.getHotel…ontext.applicationContext");
        return d.a.a(applicationContext).b("checkindate", "", false);
    }
}
