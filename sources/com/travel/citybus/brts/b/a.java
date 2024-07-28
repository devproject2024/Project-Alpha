package com.travel.citybus.brts.b;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f23190a = new a();

    private a() {
    }

    public static a a() {
        return f23190a;
    }

    public static void a(Context context, String str, Map map, Map<String, String> map2, String str2, IJRPaytmDataModel iJRPaytmDataModel, b bVar) {
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.TRANSPORT_BRTS;
        bVar2.n = a.b.USER_FACING;
        bVar2.o = "brts";
        bVar2.f42879c = a.C0715a.POST;
        bVar2.f42880d = str;
        bVar2.f42883g = map;
        bVar2.f42882f = map2;
        bVar2.f42884h = str2;
        bVar2.f42885i = iJRPaytmDataModel;
        bVar2.j = bVar;
        com.paytm.network.a l = bVar2.l();
        l.f42859c = true;
        l.a();
    }

    public static void a(Context context, String str, Map<String, String> map, IJRPaytmDataModel iJRPaytmDataModel, b bVar) {
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.TRANSPORT_BRTS;
        bVar2.n = a.b.USER_FACING;
        bVar2.o = "brts";
        bVar2.f42879c = a.C0715a.GET;
        bVar2.f42880d = str;
        bVar2.f42882f = map;
        bVar2.f42885i = iJRPaytmDataModel;
        bVar2.j = bVar;
        com.paytm.network.a l = bVar2.l();
        l.f42859c = true;
        l.a();
    }

    public static com.paytm.network.a b(Context context, String str, Map<String, String> map, IJRPaytmDataModel iJRPaytmDataModel, b bVar) {
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.TRANSPORT_BRTS;
        bVar2.n = a.b.USER_FACING;
        bVar2.o = "brts";
        bVar2.f42879c = a.C0715a.GET;
        bVar2.f42880d = str;
        bVar2.f42882f = map;
        bVar2.f42885i = iJRPaytmDataModel;
        bVar2.j = bVar;
        com.paytm.network.a l = bVar2.l();
        l.f42859c = true;
        return l;
    }
}
