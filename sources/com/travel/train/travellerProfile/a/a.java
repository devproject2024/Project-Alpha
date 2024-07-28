package com.travel.train.travellerProfile.a;

import android.content.Context;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.travel.train.j.g;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.model.travellerProfile.model.CJRTpDeleteResponse;
import com.travel.train.model.travellerProfile.model.CJRTpUserProfile;
import com.travel.train.travellerProfile.travel.CJRTpUserProfileContact;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f27731a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CJRTpUserProfileContact> f27732b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<Integer, CJRTpUserProfileContact> f27733c = new HashMap<>();

    public static a a() {
        if (f27731a == null) {
            f27731a = new a();
        }
        return f27731a;
    }

    private a() {
    }

    public final void a(ArrayList<CJRTpUserProfileContact> arrayList) {
        this.f27732b = new ArrayList<>();
        this.f27732b = arrayList;
    }

    public static boolean a(Context context, com.travel.train.travellerProfile.travel.a aVar, b bVar) {
        String str;
        if (context == null) {
            return false;
        }
        com.travel.train.b.a();
        String k = com.travel.train.b.b().k();
        if (aVar == com.travel.train.travellerProfile.travel.a.all) {
            str = k + "?vertical=";
        } else {
            str = k + "?vertical=" + aVar;
        }
        String s = com.paytm.utility.b.s(context, str);
        if (aVar.name().equalsIgnoreCase("train")) {
            s = o.b(context, s);
        }
        if (!URLUtil.isValidUrl(s)) {
            return false;
        }
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.TRAIN;
        bVar2.n = a.b.SILENT;
        bVar2.o = g.f27559i;
        bVar2.f42879c = a.C0715a.GET;
        bVar2.f42880d = s;
        bVar2.f42882f = n.b(context);
        bVar2.f42885i = new CJRTpUserProfile();
        bVar2.j = bVar;
        bVar2.l().a();
        return true;
    }

    public final void a(Context context, CJRTpUserProfileContact cJRTpUserProfileContact, b bVar) {
        a(cJRTpUserProfileContact);
        com.travel.train.b.a();
        String s = com.paytm.utility.b.s(context, com.travel.train.b.b().z());
        JSONObject a2 = b.a(cJRTpUserProfileContact);
        if (URLUtil.isValidUrl(s)) {
            com.paytm.network.b bVar2 = new com.paytm.network.b();
            bVar2.f42877a = context;
            bVar2.f42878b = a.c.TRAIN;
            bVar2.n = a.b.SILENT;
            bVar2.o = g.f27559i;
            bVar2.f42879c = a.C0715a.POST;
            bVar2.f42880d = s;
            bVar2.f42882f = n.c(context);
            bVar2.f42884h = a2.toString();
            bVar2.f42885i = new CJRTpDeleteResponse();
            bVar2.j = bVar;
            bVar2.l().a();
        }
    }

    private void a(CJRTpUserProfileContact cJRTpUserProfileContact) {
        ArrayList<CJRTpUserProfileContact> arrayList = this.f27732b;
        if (arrayList != null && arrayList.size() > 0) {
            this.f27732b.remove(cJRTpUserProfileContact);
        }
    }
}
