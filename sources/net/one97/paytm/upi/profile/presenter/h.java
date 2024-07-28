package net.one97.paytm.upi.profile.presenter;

import java.util.List;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.profile.a.h;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.profile.b.b;
import net.one97.paytm.upi.registration.b.a.a;

public final class h implements h.a {

    /* renamed from: a  reason: collision with root package name */
    h.b f68093a;

    /* renamed from: b  reason: collision with root package name */
    UpiProfileModel.ProfileDetails f68094b;

    /* renamed from: c  reason: collision with root package name */
    int f68095c;

    /* renamed from: d  reason: collision with root package name */
    private b f68096d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.upi.registration.b.a.b f68097e;

    /* renamed from: f  reason: collision with root package name */
    private final String f68098f = "UpiProfilePresenter";

    /* renamed from: g  reason: collision with root package name */
    private String f68099g;

    public h(b bVar, net.one97.paytm.upi.registration.b.a.b bVar2, h.b bVar3) {
        this.f68096d = bVar;
        this.f68097e = bVar2;
        this.f68093a = bVar3;
        this.f68099g = bVar3.getClass().getSimpleName();
        this.f68093a.a(this);
    }

    public final void a(boolean z) {
        if (z) {
            this.f68093a.a();
        }
        this.f68096d.a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (h.this.f68093a != null) {
                    if (upiBaseDataModel instanceof UpiProfileModel) {
                        UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                        if (!upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") || !"0".equalsIgnoreCase(upiProfileModel.getRespCode())) {
                            h.this.f68093a.a((UpiCustomVolleyError) null);
                            return;
                        }
                        h.this.f68094b = upiProfileModel.getResponse().getProfileDetail();
                        if (h.this.f68094b.getProfileVpaList() != null) {
                            h hVar = h.this;
                            hVar.f68095c = hVar.f68094b.getProfileVpaList().size();
                        }
                        h.this.f68093a.a(h.this.f68094b);
                        return;
                    }
                    h.this.f68093a.a((UpiCustomVolleyError) null);
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (h.this.f68093a != null) {
                    h.this.f68093a.a(upiCustomVolleyError);
                }
            }
        }, "UpiProfilePresenter", this.f68099g);
    }

    public final void a() {
        this.f68093a.d();
        this.f68096d.b((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (h.this.f68093a != null) {
                    if (upiBaseDataModel instanceof BaseUpiResponse) {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                        if (!baseUpiResponse.isSuccess() || !"0".equals(baseUpiResponse.getResponse())) {
                            h.this.f68093a.a(baseUpiResponse.getMessage());
                        } else {
                            h.this.f68093a.c();
                        }
                    } else {
                        h.this.f68093a.a("");
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (h.this.f68093a != null) {
                    h.this.f68093a.a("");
                }
            }
        }, "UpiProfilePresenter", this.f68099g);
    }

    public final void a(int i2) {
        if (this.f68095c >= i2) {
            this.f68093a.a(i2);
        } else {
            this.f68093a.e();
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        UpiProfileModel.ProfileDetails profileDetails;
        List<UpiProfileDefaultBank> profileVpaList;
        if (this.f68093a != null && (profileDetails = this.f68094b) != null && (profileVpaList = profileDetails.getProfileVpaList()) != null) {
            this.f68093a.a(accountProvider, profileVpaList.get(0).getVirtualAddress());
        }
    }

    public final void f() {
        this.f68093a = null;
        this.f68096d.a("UpiProfilePresenter");
    }

    public final void e() {
        this.f68093a.a();
        this.f68097e.c(new a.C1389a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (h.this.f68093a != null) {
                    if (upiBaseDataModel instanceof UpiAvailabilityModel) {
                        UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                        if (upiAvailabilityModel.getResponse() == null) {
                            return;
                        }
                        if (upiAvailabilityModel.getResponse().isUpiUser()) {
                            h.this.a(false);
                        } else {
                            h.this.f68093a.b();
                        }
                    } else {
                        h.this.f68093a.b();
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (h.this.f68093a != null) {
                    h.this.f68093a.a(upiCustomVolleyError);
                }
            }
        }, "UpiProfilePresenter", this.f68099g);
    }
}
