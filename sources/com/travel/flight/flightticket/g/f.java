package com.travel.flight.flightticket.g;

import android.content.Context;
import android.widget.Toast;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.travel.flight.R;
import com.travel.flight.flightticket.i.c;
import com.travel.flight.pojo.flightticket.CJRFareAlertHomeAnalyticsModel;
import com.travel.flight.pojo.flightticket.CJRFareAlertsSubscribeResponse;
import com.travel.flight.pojo.flightticket.CJRPromocodeErrorResponse;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public c f25024a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25025b;

    public f(c cVar, Context context) {
        this.f25024a = cVar;
        this.f25025b = context.getApplicationContext();
    }

    public final void a() {
        if (!b.c(this.f25025b)) {
            this.f25024a.b();
        } else {
            com.travel.flight.flightticket.e.b.a(this.f25025b, new CJRFareAlertHomeAnalyticsModel(), new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    f.this.f25024a.c();
                    if (iJRPaytmDataModel instanceof CJRFareAlertHomeAnalyticsModel) {
                        f.this.f25024a.a(((CJRFareAlertHomeAnalyticsModel) iJRPaytmDataModel).getBody().f25432a);
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    Toast.makeText(f.this.f25025b, networkCustomError.getMessage(), 0).show();
                    f.this.f25024a.c();
                }
            });
        }
    }

    public final void a(final CJRFareAlertHomeAnalyticsModel.a aVar) {
        if (!b.c(this.f25025b)) {
            this.f25024a.b();
            return;
        }
        this.f25024a.a(this.f25025b.getString(R.string.pre_f_please_wait_progress_msg));
        com.travel.flight.flightticket.e.b.b(this.f25025b, aVar.f25427c, aVar.f25428d, b.d(aVar.f25429e, "dd MMM yyyy", "yyyyMMdd"), new CJRFareAlertsSubscribeResponse(), new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                f.this.f25024a.c();
                if (iJRPaytmDataModel instanceof CJRFareAlertsSubscribeResponse) {
                    Toast.makeText(f.this.f25025b, ((CJRFareAlertsSubscribeResponse) iJRPaytmDataModel).body, 0).show();
                    aVar.f25431g = true;
                    f.this.f25024a.e();
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                f.this.f25024a.c();
                f.a(f.this, networkCustomError);
            }
        });
    }

    static /* synthetic */ void a(f fVar, NetworkCustomError networkCustomError) {
        CJRPromocodeErrorResponse cJRPromocodeErrorResponse = new CJRPromocodeErrorResponse();
        if (networkCustomError != null && networkCustomError.networkResponse != null && networkCustomError.networkResponse.data != null) {
            try {
                CJRPromocodeErrorResponse cJRPromocodeErrorResponse2 = (CJRPromocodeErrorResponse) new com.google.gsonhtcfix.f().a(new String(networkCustomError.networkResponse.data), cJRPromocodeErrorResponse.getClass());
                if (cJRPromocodeErrorResponse2 != null && cJRPromocodeErrorResponse2.getStatus() != null && cJRPromocodeErrorResponse2.getStatus().getMessage() != null && cJRPromocodeErrorResponse2.getStatus().getMessage().getMessage() != null) {
                    Toast.makeText(fVar.f25025b, cJRPromocodeErrorResponse2.getStatus().getMessage().getMessage(), 0).show();
                }
            } catch (Exception unused) {
            }
        }
    }
}
