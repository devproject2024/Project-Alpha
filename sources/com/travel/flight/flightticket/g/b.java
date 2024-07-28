package com.travel.flight.flightticket.g;

import android.content.Context;
import android.widget.Toast;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.flight.R;
import com.travel.flight.flightticket.i.a;
import com.travel.flight.pojo.flightticket.CJRFareAlertsSubscribeResponse;
import com.travel.flight.pojo.flightticket.CJRPromocodeErrorResponse;
import com.travel.flight.pojo.flightticket.CJRViewFareAlerts;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    a f25007a;

    /* renamed from: b  reason: collision with root package name */
    private Context f25008b;

    public b(a aVar) {
        this.f25007a = aVar;
        this.f25008b = (Context) aVar;
    }

    public final void a(CJRViewFareAlerts.a aVar, final String str, final String str2, final String str3) {
        if (!com.paytm.utility.b.c(this.f25008b.getApplicationContext())) {
            this.f25007a.b();
            return;
        }
        this.f25007a.a(this.f25008b.getApplicationContext().getString(R.string.pre_f_please_wait_progress_msg));
        this.f25008b.getApplicationContext();
        com.travel.flight.flightticket.e.b.b(this.f25008b.getApplicationContext(), aVar.getSource_iata(), aVar.getDestination_iata(), com.paytm.utility.b.d(aVar.getDoj(), "dd MMM yyyy", "yyyyMMdd"), new CJRFareAlertsSubscribeResponse(), new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof CJRFareAlertsSubscribeResponse) {
                    new StringBuilder("Removed Success: ").append(((CJRFareAlertsSubscribeResponse) iJRPaytmDataModel).message);
                    b.this.a(str, str2, str3);
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                b.a(b.this, networkCustomError);
                b.this.f25007a.c();
            }
        });
    }

    public final void a(String str, String str2, String str3) {
        if (!com.paytm.utility.b.c(this.f25008b.getApplicationContext())) {
            this.f25007a.b();
            return;
        }
        this.f25007a.a(this.f25008b.getApplicationContext().getString(R.string.pre_f_please_wait_progress_msg));
        this.f25008b.getApplicationContext();
        com.travel.flight.flightticket.e.b.a(this.f25008b.getApplicationContext(), com.paytm.utility.b.d(str3, "E, dd MMM yy", "yyyyMMdd"), str, str2, new CJRFareAlertsSubscribeResponse(), new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof CJRFareAlertsSubscribeResponse) {
                    CJRFareAlertsSubscribeResponse cJRFareAlertsSubscribeResponse = (CJRFareAlertsSubscribeResponse) iJRPaytmDataModel;
                    StringBuilder sb = new StringBuilder("Success: ");
                    sb.append(cJRFareAlertsSubscribeResponse.code);
                    sb.append(" ");
                    sb.append(cJRFareAlertsSubscribeResponse.message);
                    sb.append(" ");
                    sb.append(cJRFareAlertsSubscribeResponse.body);
                    com.travel.flight.flightticket.fragment.a.a();
                    b.this.f25007a.c();
                    b.this.f25007a.a();
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                b.a(b.this, networkCustomError);
                b.this.f25007a.c();
            }
        });
    }

    static /* synthetic */ void a(b bVar, NetworkCustomError networkCustomError) {
        CJRPromocodeErrorResponse cJRPromocodeErrorResponse = new CJRPromocodeErrorResponse();
        if (networkCustomError != null && networkCustomError.networkResponse != null && networkCustomError.networkResponse.data != null) {
            try {
                CJRPromocodeErrorResponse cJRPromocodeErrorResponse2 = (CJRPromocodeErrorResponse) new f().a(new String(networkCustomError.networkResponse.data), cJRPromocodeErrorResponse.getClass());
                if (cJRPromocodeErrorResponse2 != null && cJRPromocodeErrorResponse2.getStatus() != null && cJRPromocodeErrorResponse2.getStatus().getMessage() != null && cJRPromocodeErrorResponse2.getStatus().getMessage().getMessage() != null) {
                    Toast.makeText(bVar.f25008b.getApplicationContext(), cJRPromocodeErrorResponse2.getStatus().getMessage().getMessage(), 0).show();
                }
            } catch (Exception unused) {
            }
        }
    }
}
