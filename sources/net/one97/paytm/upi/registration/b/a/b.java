package net.one97.paytm.upi.registration.b.a;

import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.upi.a.c;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiToken;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.registration.a.d;
import net.one97.paytm.upi.registration.b.a.a;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f68406a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a f68407b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final a f68408c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final a f68409d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f68410e = false;

    private b(a aVar, a aVar2, a aVar3) {
        this.f68407b = aVar;
        this.f68408c = aVar2;
        this.f68409d = aVar3;
    }

    public static b a(a aVar, a aVar2, a aVar3) {
        if (f68406a == null) {
            f68406a = new b(aVar, aVar2, aVar3);
        }
        return f68406a;
    }

    public final void a(final a.C1389a aVar, String str, String str2) {
        if (!this.f68410e) {
            this.f68408c.a((a.C1389a) new a.C1389a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    aVar.onSuccess(upiBaseDataModel);
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    aVar.onError(upiCustomVolleyError);
                }
            }, str, str2);
        }
    }

    public final void a(a.C1389a aVar, String str, String str2, HashMap<String, String> hashMap, String str3) {
        d();
        final a.C1389a aVar2 = aVar;
        final String str4 = str;
        final String str5 = str2;
        final HashMap<String, String> hashMap2 = hashMap;
        final String str6 = str3;
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                b.this.f68408c.a((a.C1389a) new a.C1389a() {
                    public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                        aVar2.onSuccess(upiBaseDataModel);
                    }

                    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                        aVar2.onError(upiCustomVolleyError);
                    }
                }, str4, str5, (HashMap<String, String>) hashMap2, str6);
            }
        }, 5000);
    }

    public final String a() {
        return this.f68407b.a();
    }

    public final void a(String str) {
        this.f68407b.a(str);
    }

    public final boolean c() {
        return this.f68407b.c();
    }

    public final void b(String str) {
        this.f68407b.b(str);
    }

    public final String b() {
        return this.f68407b.b();
    }

    public final void d(final a.C1389a aVar, final String str, final String str2) {
        String a2 = this.f68407b.a();
        if (TextUtils.isEmpty(a2)) {
            a((d.a) new d.a() {
                public final void a(boolean z) {
                }

                public final void a(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        PaytmLogs.d("UpiRegistrationRepository", "Challenge Received");
                        b.this.a("initial", str, aVar, str, str2);
                        return;
                    }
                    PaytmLogs.d("UpiRegistrationRepository", "Challenge Not Received");
                    UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                    upiCustomVolleyError.setAlertMessage("Get challenge with CL failed");
                    upiCustomVolleyError.setUrl("get-token");
                    aVar.onError(upiCustomVolleyError);
                }
            }, this.f68409d, "initial");
        } else if (c()) {
            a((d.a) new d.a() {
                public final void a(boolean z) {
                }

                public final void a(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        PaytmLogs.d("UpiRegistrationRepository", "Challenge Received");
                        b.this.a("initial", str, aVar, str, str2);
                        return;
                    }
                    PaytmLogs.d("UpiRegistrationRepository", "Challenge Not Received");
                    UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                    upiCustomVolleyError.setAlertMessage("Get challenge with CL failed");
                    upiCustomVolleyError.setUrl("get-token");
                    aVar.onError(upiCustomVolleyError);
                }
            }, this.f68409d, "initial");
        } else {
            UpiToken upiToken = new UpiToken();
            upiToken.setUpiToken(a2);
            aVar.onSuccess(upiToken);
        }
    }

    public final void j() {
        this.f68407b.j();
    }

    public final void a(String str, String str2, final a.C1389a aVar, String str3, String str4) {
        PaytmLogs.d("UpiRegistrationRepository", "Get Token Called");
        j();
        this.f68408c.a(str, str2, (a.C1389a) new a.C1389a() {
            public final void onSuccess(final UpiBaseDataModel upiBaseDataModel) {
                if (upiBaseDataModel instanceof UpiToken) {
                    b.this.b((d.a) new d.a() {
                        public final void a(String str) {
                        }

                        public final void a(boolean z) {
                            if (z) {
                                b.this.f68407b.a(((UpiToken) upiBaseDataModel).getUpiToken());
                                aVar.onSuccess(upiBaseDataModel);
                                return;
                            }
                            UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                            upiCustomVolleyError.setAlertMessage("App registration with CL failed");
                            upiCustomVolleyError.setUrl("get-token");
                            aVar.onError(upiCustomVolleyError);
                        }
                    }, b.this.f68409d, ((UpiToken) upiBaseDataModel).getUpiToken());
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                aVar.onError(upiCustomVolleyError);
            }
        }, str3, str4);
    }

    public final void b(final a.C1389a aVar, String str, String str2) {
        String b2 = this.f68407b.b();
        if (TextUtils.isEmpty(b2)) {
            this.f68408c.b((a.C1389a) new a.C1389a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                    if (!baseUpiResponse.isSuccess()) {
                        aVar.onError(new UpiCustomVolleyError());
                    } else if (!"0".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                        aVar.onError(new UpiCustomVolleyError());
                    } else if (baseUpiResponse.getMobileAppData() instanceof String) {
                        b.this.f68407b.b((String) baseUpiResponse.getMobileAppData());
                        aVar.onSuccess(baseUpiResponse);
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    aVar.onError(upiCustomVolleyError);
                }
            }, str, str2);
            return;
        }
        BaseUpiResponse baseUpiResponse = new BaseUpiResponse();
        baseUpiResponse.setMobileAppData(b2);
        baseUpiResponse.setSuccess(true);
        baseUpiResponse.setResponse("0");
        aVar.onSuccess(baseUpiResponse);
    }

    public final void a(d.a aVar, net.one97.paytm.upi.h.a aVar2, String str) {
        PaytmLogs.d("UpiRegistrationRepository", "Get Challenge Called");
        this.f68407b.a(aVar, aVar2, str);
    }

    public final void b(d.a aVar, net.one97.paytm.upi.h.a aVar2, String str) {
        this.f68407b.b(aVar, aVar2, str);
    }

    public final void d() {
        this.f68408c.d();
    }

    public final void b(a.C1389a aVar, String str) {
        this.f68408c.b(aVar, str);
    }

    public final void c(a.C1389a aVar, String str) {
        this.f68408c.c(aVar, str);
    }

    public final void c(final a.C1389a aVar, String str, String str2) {
        this.f68408c.c(new a.C1389a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                if (upiAvailabilityModel != null) {
                    if ("success".equalsIgnoreCase(upiAvailabilityModel.getStatus())) {
                        UpiAvailabilityModel.UpiAvailabilityResponse response = upiAvailabilityModel.getResponse();
                        b.this.a(response.isUpiUser());
                        b.this.c(response.isSameDevice());
                        b.this.b(response.isUpiProfileExist());
                        b.this.d(response.ismBankAccountAdded());
                        b.this.e(response.ismPinSet());
                        b.this.m();
                    }
                    aVar.onSuccess(upiAvailabilityModel);
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                aVar.onError(upiCustomVolleyError);
            }
        }, str, str2);
    }

    public final void m() {
        this.f68407b.m();
    }

    public final boolean e() {
        return this.f68407b.e();
    }

    public final boolean f() {
        return this.f68407b.f();
    }

    public final void e(a.C1389a aVar, String str, String str2) {
        boolean e2 = this.f68407b.e();
        boolean g2 = this.f68407b.g();
        boolean f2 = this.f68407b.f();
        boolean h2 = this.f68407b.h();
        boolean i2 = this.f68407b.i();
        UpiAvailabilityModel upiAvailabilityModel = new UpiAvailabilityModel();
        upiAvailabilityModel.getClass();
        UpiAvailabilityModel.UpiAvailabilityResponse upiAvailabilityResponse = new UpiAvailabilityModel.UpiAvailabilityResponse();
        upiAvailabilityModel.setResponse(upiAvailabilityResponse);
        if (e2) {
            upiAvailabilityResponse.setUpiUser(e2);
            upiAvailabilityResponse.setIsSameDevice(g2);
            upiAvailabilityResponse.setUpiProfileExist(f2);
            upiAvailabilityResponse.setmBankAccountAdded(h2);
            upiAvailabilityResponse.setmPinSet(i2);
            upiAvailabilityModel.setmStatus("success");
            upiAvailabilityModel.setRespCode("0");
            upiAvailabilityModel.setRespMessage("success");
            m();
            aVar.onSuccess(upiAvailabilityModel);
            return;
        }
        c(aVar, str, str2);
    }

    public final void d(boolean z) {
        this.f68407b.d(z);
    }

    public final void e(boolean z) {
        this.f68407b.e(z);
    }

    public final boolean h() {
        return this.f68407b.h();
    }

    public final boolean i() {
        return this.f68407b.i();
    }

    public final void a(boolean z) {
        this.f68407b.a(z);
    }

    public final void b(boolean z) {
        this.f68407b.b(z);
    }

    public final boolean g() {
        return this.f68407b.g();
    }

    public final void c(boolean z) {
        this.f68407b.c(z);
    }

    public final void c(String str) {
        this.f68408c.c(str);
    }

    public final void a(a.C1389a aVar, String str, String str2, String str3) {
        this.f68408c.a(aVar, str, str2, str3);
    }

    public final void a(a.C1389a aVar, String str, String str2, boolean z, String str3, String str4) {
        this.f68408c.a(aVar, str, str2, z, str3, str4);
    }

    public final void a(List<AccountProviderBody.AccountProvider> list) {
        this.f68407b.a(list);
    }

    public final List<AccountProviderBody.AccountProvider> k() {
        return this.f68407b.k();
    }

    public final Map<String, AccountProviderBody.AccountProvider> l() {
        return this.f68407b.l();
    }

    public final void a(a.C1389a aVar, String str) {
        this.f68408c.a(aVar, str);
    }

    public final void a(c.b bVar) {
        this.f68408c.a(bVar);
    }

    public final String n() {
        return this.f68407b.n();
    }
}
