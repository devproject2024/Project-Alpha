package com.travel.bus.busticket.g;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.bus.pojo.busticket.rnr.CJRRnRDetailsModel;

public final class h {
    public static void a(String str, Context context, final b bVar) {
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.BUS;
        bVar2.f42879c = a.C0715a.GET;
        bVar2.f42880d = str;
        bVar2.f42885i = new CJRRnRDetailsModel();
        bVar2.j = new b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                bVar.onApiSuccess(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                bVar.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
            }
        };
        bVar2.n = a.b.SILENT;
        bVar2.o = "bus-rating-page";
        bVar2.l().a();
    }
}
