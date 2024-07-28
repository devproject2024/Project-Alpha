package net.one97.paytm.upi.deeplink;

import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.deeplink.c;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.b.a.b;

public final class d implements c.a {

    /* renamed from: a  reason: collision with root package name */
    c.b f66699a;

    /* renamed from: b  reason: collision with root package name */
    b f66700b;

    /* renamed from: c  reason: collision with root package name */
    final String f66701c = "UPIProfilePresenter";

    /* renamed from: d  reason: collision with root package name */
    String f66702d = "UPIDeeplinkView";

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.upi.requestmoney.b.a.b f66703e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.upi.profile.b.b f66704f;

    public final void e() {
    }

    public final void f() {
    }

    public d(c.b bVar, net.one97.paytm.upi.profile.b.b bVar2, b bVar3, net.one97.paytm.upi.requestmoney.b.a.b bVar4) {
        k.c(bVar, "view");
        k.c(bVar2, "upiProfile");
        k.c(bVar3, "upiRegRepository");
        k.c(bVar4, "upiRequestMoneyRepository");
        this.f66699a = bVar;
        this.f66704f = bVar2;
        this.f66700b = bVar3;
        this.f66703e = bVar4;
    }

    public static final class a implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f66705a;

        a(d dVar) {
            this.f66705a = dVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (this.f66705a.f66699a != null) {
                if (upiBaseDataModel instanceof UpiAvailabilityModel) {
                    UpiAvailabilityModel.UpiAvailabilityResponse response = ((UpiAvailabilityModel) upiBaseDataModel).getResponse();
                    if (response == null) {
                        c.b bVar = this.f66705a.f66699a;
                        if (bVar != null) {
                            bVar.b();
                        }
                        c.b bVar2 = this.f66705a.f66699a;
                        if (bVar2 != null) {
                            bVar2.e();
                        }
                    } else if (!response.isUpiUser()) {
                        c.b bVar3 = this.f66705a.f66699a;
                        if (bVar3 != null) {
                            bVar3.b();
                        }
                        c.b bVar4 = this.f66705a.f66699a;
                        if (bVar4 != null) {
                            bVar4.a(response);
                        }
                    } else if (!response.ismBankAccountAdded()) {
                        c.b bVar5 = this.f66705a.f66699a;
                        if (bVar5 != null) {
                            bVar5.b();
                        }
                        c.b bVar6 = this.f66705a.f66699a;
                        if (bVar6 != null) {
                            bVar6.b(response);
                        }
                    } else if (!response.ismPinSet()) {
                        c.b bVar7 = this.f66705a.f66699a;
                        if (bVar7 != null) {
                            bVar7.b();
                        }
                        c.b bVar8 = this.f66705a.f66699a;
                        if (bVar8 != null) {
                            bVar8.c(response);
                        }
                    } else {
                        c.b bVar9 = this.f66705a.f66699a;
                        if (bVar9 != null) {
                            bVar9.d(response);
                        }
                    }
                } else {
                    c.b bVar10 = this.f66705a.f66699a;
                    if (bVar10 != null) {
                        bVar10.b();
                    }
                    c.b bVar11 = this.f66705a.f66699a;
                    if (bVar11 != null) {
                        bVar11.e();
                    }
                }
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            c.b bVar;
            k.c(upiCustomVolleyError, "error");
            c.b bVar2 = this.f66705a.f66699a;
            if (bVar2 != null) {
                bVar2.b();
            }
            if (upiCustomVolleyError.networkResponse == null) {
                c.b bVar3 = this.f66705a.f66699a;
                if (bVar3 != null) {
                    bVar3.d();
                }
            } else if ((upiCustomVolleyError.networkResponse.statusCode == 401 || upiCustomVolleyError.networkResponse.statusCode == 410) && (bVar = this.f66705a.f66699a) != null) {
                bVar.c();
            }
        }
    }
}
