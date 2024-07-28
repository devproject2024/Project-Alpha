package com.travel.train.j;

import android.content.Context;
import com.google.gsonhtcfix.f;
import com.travel.train.j.w;
import com.travel.train.model.metro.CJRParcelableMetroStationModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final v f27608a = new v();

    private v() {
    }

    public static ArrayList<CJRParcelableMetroStationModel> a(Context context) {
        k.c(context, "context");
        f fVar = new f();
        w.a aVar = w.f27609a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        com.paytm.b.a.a a2 = w.a.a(applicationContext);
        String str = g.L;
        k.a((Object) str, "CJRTrainConstants.METRO_SEARCH_PREF_KEY");
        ArrayList<CJRParcelableMetroStationModel> arrayList = (ArrayList) fVar.a(a2.b(str, "", true), new a().getType());
        if (arrayList == null) {
            return null;
        }
        if (arrayList == null) {
            k.a();
        }
        return arrayList;
    }

    public static final class a extends com.google.gson.b.a<List<? extends CJRParcelableMetroStationModel>> {
        a() {
        }
    }

    public static void b(Context context) {
        k.c(context, "context");
        w.a aVar = w.f27609a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        com.paytm.b.a.a a2 = w.a.a(applicationContext);
        String str = g.L;
        k.a((Object) str, "CJRTrainConstants.METRO_SEARCH_PREF_KEY");
        a2.a(str, true);
    }
}
