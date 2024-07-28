package com.travel.train.helper;

import android.content.Context;
import android.net.Uri;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.travel.train.R;
import com.travel.train.i.x;
import com.travel.train.j.g;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainTDRDetails;
import com.travel.train.model.trainticket.CJRTrainTDRSubmitResponse;

public final class m implements b, x.a {

    /* renamed from: a  reason: collision with root package name */
    private x.b f27337a;

    /* renamed from: b  reason: collision with root package name */
    private Context f27338b;

    public m(x.b bVar, Context context) {
        this.f27337a = bVar;
        this.f27338b = context;
        this.f27337a.a(this);
    }

    public final void a(String str) {
        if (URLUtil.isValidUrl(str)) {
            String b2 = o.b(this.f27338b, com.paytm.utility.b.s(this.f27338b, str));
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f27338b;
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.q;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = b2;
            bVar.f42882f = n.b(this.f27338b);
            bVar.f42885i = new CJRTrainTDRDetails();
            bVar.j = this;
            a l = bVar.l();
            l.f42859c = false;
            if (com.paytm.utility.b.c(this.f27338b)) {
                this.f27337a.a(this.f27338b.getResources().getString(R.string.pp_please_wait));
                l.a();
                return;
            }
            this.f27337a.showNetworkDialog(l, this.f27338b.getString(R.string.no_connection), this.f27338b.getString(R.string.no_internet));
        }
    }

    public final void a(String str, String str2, String str3, String str4) {
        if (URLUtil.isValidUrl(str2)) {
            Uri.Builder buildUpon = Uri.parse(o.b(this.f27338b, com.paytm.utility.b.s(this.f27338b, str2))).buildUpon();
            buildUpon.appendQueryParameter("order_id", str);
            buildUpon.appendQueryParameter(Item.KEY_REASON, str3);
            buildUpon.appendQueryParameter("serial", str4);
            String uri = buildUpon.build().toString();
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f27338b;
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.q;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = uri;
            bVar.f42882f = n.b(this.f27338b);
            bVar.f42885i = new CJRTrainTDRSubmitResponse();
            bVar.j = this;
            a l = bVar.l();
            l.f42859c = false;
            if (com.paytm.utility.b.c(this.f27338b)) {
                this.f27337a.a(this.f27338b.getResources().getString(R.string.pp_please_wait));
                l.a();
                return;
            }
            this.f27337a.showNetworkDialog(l, this.f27338b.getString(R.string.no_connection), this.f27338b.getString(R.string.no_internet));
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f27337a.a();
        if (iJRPaytmDataModel != null) {
            this.f27337a.a(iJRPaytmDataModel);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f27337a.a();
        if (networkCustomError != null) {
            this.f27337a.a(i2, networkCustomError);
        }
    }
}
