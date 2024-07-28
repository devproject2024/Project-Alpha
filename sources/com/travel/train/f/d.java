package com.travel.train.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import com.travel.common.a;
import com.travel.train.c.c;
import com.travel.train.j.g;
import com.travel.train.j.n;
import com.travel.train.model.metro.CJRMetroAllStationsResponseModel;
import com.travel.train.model.metro.CJRStationAutoSuggestModel;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;

public final class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public final c.a f26670a;

    /* renamed from: b  reason: collision with root package name */
    private String f26671b;

    public d(c.a aVar) {
        k.c(aVar, "view");
        this.f26670a = aVar;
    }

    public final void a(String str, String str2, Context context) {
        k.c(str2, "modeId");
        k.c(context, "context");
        this.f26670a.a(true);
        this.f26671b = str;
        k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
        a b2 = com.travel.train.b.b();
        k.a((Object) b2, "TrainController.getInstance().trainEventListener");
        String ag = b2.ag();
        if (!TextUtils.isEmpty(ag)) {
            Uri.Builder buildUpon = Uri.parse(ag).buildUpon();
            buildUpon.appendQueryParameter("modeid", str2);
            if (str != null) {
                if (str.length() > 0) {
                    buildUpon.appendQueryParameter(StringSet.query_type, "autosuggest");
                    buildUpon.appendQueryParameter("station", str);
                    com.paytm.network.a l = new com.paytm.network.b().a(context).a(a.c.TRAIN).a(a.b.SILENT).c(g.I).a(a.C0715a.GET).a(buildUpon.build().toString()).a((Map<String, String>) n.b(context)).a((IJRPaytmDataModel) new CJRMetroAllStationsResponseModel()).a((b) this).l();
                    l.b(true);
                    l.a();
                }
            }
            buildUpon.appendQueryParameter(StringSet.query_type, "all_stations");
            com.paytm.network.a l2 = new com.paytm.network.b().a(context).a(a.c.TRAIN).a(a.b.SILENT).c(g.I).a(a.C0715a.GET).a(buildUpon.build().toString()).a((Map<String, String>) n.b(context)).a((IJRPaytmDataModel) new CJRMetroAllStationsResponseModel()).a((b) this).l();
            l2.b(true);
            l2.a();
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (networkCustomError != null) {
            c.a aVar = this.f26670a;
            String alertTitle = networkCustomError.getAlertTitle();
            k.a((Object) alertTitle, "networkError.alertTitle");
            String alertMessage = networkCustomError.getAlertMessage();
            k.a((Object) alertMessage, "networkError.alertMessage");
            aVar.a(alertTitle, alertMessage);
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRMetroAllStationsResponseModel)) {
            boolean z = false;
            this.f26670a.a(false);
            List<CJRStationAutoSuggestModel> list = ((CJRMetroAllStationsResponseModel) iJRPaytmDataModel).getBody().stations;
            Collection collection = list;
            if (collection == null || collection.isEmpty()) {
                z = true;
            }
            if (z) {
                this.f26670a.a();
            } else if (this.f26671b == null) {
                this.f26670a.c(list);
            } else {
                this.f26670a.b(list);
            }
        }
    }
}
