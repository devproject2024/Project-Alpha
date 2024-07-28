package com.travel.flight.flightticket.g;

import android.content.Context;
import android.widget.Toast;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.travel.flight.R;
import com.travel.flight.flightticket.i.d;
import com.travel.flight.pojo.flightticket.CJRFareAlertsSubscribeResponse;
import com.travel.flight.pojo.flightticket.CJRPromocodeErrorResponse;
import com.travel.flight.pojo.flightticket.CJRViewFareAlerts;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public d f25003a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25004b;

    public a(d dVar) {
        this.f25003a = dVar;
        this.f25004b = (Context) dVar;
    }

    public final void a(CJRViewFareAlerts.a aVar) {
        if (!b.c(this.f25004b.getApplicationContext())) {
            this.f25003a.c();
            return;
        }
        this.f25003a.a(this.f25004b.getApplicationContext().getString(R.string.pre_f_please_wait_progress_msg));
        com.travel.flight.flightticket.e.b.b(this.f25004b.getApplicationContext(), aVar.getSource_iata(), aVar.getDestination_iata(), b.h(aVar.getDoj(), "dd MMM yyyy", "yyyyMMdd"), new CJRFareAlertsSubscribeResponse(), new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                a.this.f25003a.b();
                if (iJRPaytmDataModel instanceof CJRFareAlertsSubscribeResponse) {
                    CJRFareAlertsSubscribeResponse cJRFareAlertsSubscribeResponse = (CJRFareAlertsSubscribeResponse) iJRPaytmDataModel;
                    new StringBuilder("Success: ").append(cJRFareAlertsSubscribeResponse.message);
                    Toast.makeText(a.this.f25004b.getApplicationContext(), cJRFareAlertsSubscribeResponse.body, 0).show();
                    a.this.f25003a.a();
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                a.a(a.this, networkCustomError);
                a.this.f25003a.b();
            }
        });
    }

    static /* synthetic */ void a(a aVar, NetworkCustomError networkCustomError) {
        CJRPromocodeErrorResponse cJRPromocodeErrorResponse = new CJRPromocodeErrorResponse();
        if (networkCustomError != null && networkCustomError.networkResponse != null && networkCustomError.networkResponse.data != null) {
            try {
                CJRPromocodeErrorResponse cJRPromocodeErrorResponse2 = (CJRPromocodeErrorResponse) new f().a(new String(networkCustomError.networkResponse.data), cJRPromocodeErrorResponse.getClass());
                if (cJRPromocodeErrorResponse2 != null && cJRPromocodeErrorResponse2.getStatus() != null && cJRPromocodeErrorResponse2.getStatus().getMessage() != null && cJRPromocodeErrorResponse2.getStatus().getMessage().getMessage() != null) {
                    Toast.makeText(aVar.f25004b.getApplicationContext(), cJRPromocodeErrorResponse2.getStatus().getMessage().getMessage(), 0).show();
                }
            } catch (Exception unused) {
            }
        }
    }
}
