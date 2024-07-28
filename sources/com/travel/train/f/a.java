package com.travel.train.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.train.c.a;
import com.travel.train.j.g;
import com.travel.train.j.n;
import com.travel.train.model.metro.CJRMetroHomeCityBottomSheetModel;
import com.travel.train.model.metro.CJRMetroListModesApiModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final a.C0486a f26656a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f26657b;

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public a(a.C0486a aVar) {
        k.c(aVar, "view");
        this.f26656a = aVar;
    }

    public final void a(int i2, Context context) {
        k.c(context, "context");
        this.f26657b = Integer.valueOf(i2);
        k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
        com.travel.common.a b2 = com.travel.train.b.b();
        k.a((Object) b2, "TrainController.getInstance().trainEventListener");
        String af = b2.af();
        if (!TextUtils.isEmpty(af)) {
            Uri.Builder buildUpon = Uri.parse(af).buildUpon();
            buildUpon.appendQueryParameter("mode", "metro");
            buildUpon.appendQueryParameter("lat", com.paytm.utility.b.s(context));
            buildUpon.appendQueryParameter("long", com.paytm.utility.b.t(context));
            com.paytm.network.a l = new com.paytm.network.b().a(context).a(a.c.TRAIN).a(a.b.SILENT).c(g.H).a(a.C0715a.GET).a(buildUpon.build().toString()).a((Map<String, String>) n.b(context)).a((IJRPaytmDataModel) new CJRMetroListModesApiModel()).a((b) this).l();
            l.b(true);
            l.a();
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRMetroListModesApiModel)) {
            List<CJRMetroHomeCityBottomSheetModel> list = ((CJRMetroListModesApiModel) iJRPaytmDataModel).getBody().modes.get(0).data;
            if (list != null) {
                List list2 = (ArrayList) list;
                k.c(list2, "result");
                Integer num = this.f26657b;
                if (num != null) {
                    num.intValue();
                    Integer num2 = this.f26657b;
                    int i2 = g.E;
                    if (num2 != null && num2.intValue() == i2) {
                        this.f26656a.getModeIdDetails((ArrayList) list2);
                        return;
                    }
                    int i3 = g.C;
                    if (num2 != null && num2.intValue() == i3) {
                        this.f26656a.showBottomSheet((ArrayList) list2);
                        return;
                    }
                    int i4 = g.D;
                    if (num2 != null && num2.intValue() == i4) {
                        this.f26656a.updateUiIfNoDataPassed((ArrayList) list2);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.travel.train.model.metro.CJRMetroHomeCityBottomSheetModel> /* = java.util.ArrayList<com.travel.train.model.metro.CJRMetroHomeCityBottomSheetModel> */");
        }
    }
}
