package com.travel.flight.seatancillary;

import android.content.Context;
import android.net.Uri;
import android.webkit.URLUtil;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatAvailability;
import com.travel.flight.pojo.seatancillaryentity.skeleton.CJRSeatAncillaryCombinedModel;
import com.travel.flight.seatancillary.b.a;
import java.util.HashMap;

public final class f implements b, a.b {

    /* renamed from: a  reason: collision with root package name */
    private a.b.C0477a f25490a;

    /* renamed from: b  reason: collision with root package name */
    private Context f25491b;

    public f(a.b.C0477a aVar, Context context) {
        this.f25490a = aVar;
        this.f25491b = context;
    }

    public final void a() {
        this.f25490a = null;
    }

    public final boolean a(HashMap<String, String> hashMap) {
        com.travel.flight.b.a();
        String a2 = a(hashMap, com.travel.flight.b.b().P());
        if (!URLUtil.isValidUrl(a2)) {
            return false;
        }
        String s = com.paytm.utility.b.s(this.f25491b.getApplicationContext(), a2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f25491b.getApplicationContext()));
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this.f25491b.getApplicationContext();
        bVar.n = a.b.SILENT;
        bVar.o = this.f25491b.getClass().getSimpleName();
        bVar.f42878b = a.c.FLIGHT;
        bVar.f42879c = a.C0715a.GET;
        bVar.f42880d = s;
        bVar.f42881e = null;
        bVar.f42882f = hashMap2;
        bVar.f42883g = null;
        bVar.f42884h = null;
        bVar.f42885i = new CJRSeatAncillaryCombinedModel();
        bVar.j = this;
        bVar.l().a();
        return true;
    }

    public final boolean b(HashMap<String, String> hashMap) {
        com.travel.flight.b.a();
        String a2 = a(hashMap, com.travel.flight.b.b().Q());
        if (!URLUtil.isValidUrl(a2)) {
            return false;
        }
        String s = com.paytm.utility.b.s(this.f25491b.getApplicationContext(), a2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f25491b.getApplicationContext()));
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this.f25491b.getApplicationContext();
        bVar.n = a.b.SILENT;
        bVar.o = this.f25491b.getClass().getSimpleName();
        bVar.f42878b = a.c.FLIGHT;
        bVar.f42879c = a.C0715a.POST;
        bVar.f42880d = s;
        bVar.f42881e = null;
        bVar.f42882f = hashMap2;
        bVar.f42883g = null;
        bVar.f42884h = null;
        bVar.f42885i = new CJRSeatAvailability();
        bVar.j = this;
        bVar.l().a();
        return true;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        a.b.C0477a aVar = this.f25490a;
        if (aVar != null) {
            aVar.a(iJRPaytmDataModel);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a.b.C0477a aVar = this.f25490a;
        if (aVar != null) {
            aVar.a(iJRPaytmDataModel, networkCustomError);
        }
    }

    private static String a(HashMap<String, String> hashMap, String str) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String next : hashMap.keySet()) {
            buildUpon.appendQueryParameter(next, hashMap.get(next));
        }
        return buildUpon.build().toString();
    }
}
