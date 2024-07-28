package com.travel.flight.flightorder.h;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.travel.flight.flightorder.g.e;
import com.travel.flight.flightorder.g.f;
import com.travel.flight.pojo.flightticket.CJRActionResponse;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import java.util.HashMap;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryAction;

public final class b implements com.paytm.network.listener.b, e {

    /* renamed from: a  reason: collision with root package name */
    public f f24417a;

    /* renamed from: b  reason: collision with root package name */
    private Context f24418b;

    /* renamed from: c  reason: collision with root package name */
    private CJRFlightOrderSummaryResponse f24419c;

    public b(Context context) {
        this.f24418b = context;
        if (this.f24418b == null) {
            throw new IllegalArgumentException("Error! Context can not be null.");
        }
    }

    public b() {
    }

    public final void a(f fVar) {
        this.f24417a = fVar;
        if (this.f24417a == null) {
            throw new IllegalArgumentException("Error! UI Listener can not be null.");
        }
    }

    public final void a(String str, boolean z) {
        com.travel.flight.b.a();
        String q = com.travel.flight.b.b().q();
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", str);
        if (z) {
            hashMap.put("request_src_txn", "0");
        } else {
            hashMap.put("request_src_txn", "1");
        }
        hashMap.put("actions", "1");
        hashMap.put(AppConstants.SSO_TOKEN, a.q(this.f24418b));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(AppConstants.SSO_TOKEN, a.q(this.f24418b));
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this.f24418b;
        bVar.n = a.b.SILENT;
        bVar.o = this.f24418b.getClass().getSimpleName();
        bVar.f42878b = a.c.FLIGHT;
        bVar.f42879c = a.C0715a.GET;
        bVar.f42880d = q;
        bVar.f42881e = null;
        bVar.f42882f = hashMap2;
        bVar.f42883g = hashMap;
        bVar.f42884h = null;
        bVar.f42885i = new CJRFlightOrderSummaryResponse();
        bVar.j = this;
        bVar.l = true;
        bVar.t = null;
        bVar.l().a();
    }

    public final void a() {
        this.f24417a = null;
    }

    public final CJRFlightOrderSummaryResponse b() {
        return this.f24419c;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        f fVar = this.f24417a;
        if (fVar != null) {
            if (iJRPaytmDataModel instanceof CJRFlightOrderSummaryResponse) {
                fVar.g();
                CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse = (CJRFlightOrderSummaryResponse) iJRPaytmDataModel;
                this.f24419c = cJRFlightOrderSummaryResponse;
                CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse2 = this.f24419c;
                if (!(cJRFlightOrderSummaryResponse2 == null || cJRFlightOrderSummaryResponse2.getBody() == null || this.f24419c.getBody().getPayments().size() <= 0 || this.f24419c.getBody().getPayments().get(0).getTransaction_number() == null || this.f24419c.getBody().getPayments().get(0).getPg_amount() == null)) {
                    String transaction_number = this.f24419c.getBody().getPayments().get(0).getTransaction_number();
                    String valueOf = String.valueOf(this.f24419c.getBody().getPayments().get(0).getPg_amount());
                    com.travel.flight.b.a();
                    com.travel.flight.b.b().a(this.f24418b, transaction_number, valueOf);
                }
                this.f24417a.b(cJRFlightOrderSummaryResponse);
            } else if (iJRPaytmDataModel instanceof CJRActionResponse) {
                fVar.a((CJRActionResponse) iJRPaytmDataModel);
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        f fVar = this.f24417a;
        if (fVar != null) {
            fVar.g();
        }
        if (networkCustomError != null) {
            try {
                networkCustomError.getMessage();
                if (i2 != 503) {
                    if (i2 != 410) {
                        if (i2 != 401) {
                            com.travel.flight.b.a();
                            CJRError a2 = com.travel.flight.b.b().a(this.f24418b, networkCustomError);
                            if (a2 == null || TextUtils.isEmpty(a2.getTitle()) || TextUtils.isEmpty(a2.getMessage())) {
                                if (networkCustomError.getErrorType() == NetworkCustomError.ErrorType.ParsingError) {
                                    if (this.f24418b instanceof Activity) {
                                        net.one97.paytmflight.a.b.a((Activity) this.f24418b, networkCustomError);
                                        return;
                                    }
                                    return;
                                } else if (this.f24418b instanceof Activity) {
                                    net.one97.paytmflight.a.b.a((Activity) this.f24418b, networkCustomError);
                                    return;
                                } else {
                                    return;
                                }
                            } else if (this.f24418b instanceof Activity) {
                                net.one97.paytmflight.a.b.a((Activity) this.f24418b, networkCustomError);
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    if (this.f24418b instanceof Activity) {
                        net.one97.paytmflight.a.b.a((Activity) this.f24418b, networkCustomError);
                    }
                }
            } catch (Exception e2) {
                e2.getMessage();
                com.paytm.utility.b.j();
            }
        }
    }

    public final void a(CJROrderSummaryAction cJROrderSummaryAction) {
        if (cJROrderSummaryAction != null && cJROrderSummaryAction.getUrlParams() != null && !TextUtils.isEmpty(cJROrderSummaryAction.getUrlParams().getUrl())) {
            String url = cJROrderSummaryAction.getUrlParams().getUrl();
            CJRActionResponse cJRActionResponse = new CJRActionResponse();
            cJRActionResponse.setRequestUrl(url);
            HashMap hashMap = new HashMap();
            hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f24418b));
            a.C0715a aVar = a.C0715a.GET;
            if (!TextUtils.isEmpty(cJROrderSummaryAction.getUrlParams().getMethod()) && cJROrderSummaryAction.getUrlParams().getMethod().equalsIgnoreCase("POST")) {
                aVar = a.C0715a.POST;
            }
            new HashMap().put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f24418b));
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f24418b;
            bVar.n = a.b.SILENT;
            bVar.o = this.f24418b.getClass().getSimpleName();
            bVar.f42878b = a.c.FLIGHT;
            bVar.f42879c = aVar;
            bVar.f42880d = url;
            bVar.f42881e = null;
            bVar.f42882f = null;
            bVar.f42883g = hashMap;
            bVar.f42884h = null;
            bVar.f42885i = cJRActionResponse;
            bVar.j = this;
            bVar.l = true;
            bVar.t = null;
            bVar.l().a();
        }
    }
}
