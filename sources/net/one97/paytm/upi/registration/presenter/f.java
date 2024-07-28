package net.one97.paytm.upi.registration.presenter;

import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.a.f;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.b.a.b;

public final class f implements f.a {

    /* renamed from: a  reason: collision with root package name */
    final b f68646a;

    /* renamed from: b  reason: collision with root package name */
    f.b f68647b;

    /* renamed from: c  reason: collision with root package name */
    List<UpiProfileDefaultBank> f68648c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    List<BankAccountDetails.BankAccount> f68649d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final net.one97.paytm.upi.profile.b.b f68650e;

    /* renamed from: f  reason: collision with root package name */
    private final String f68651f = "UpiLandingPagePresenter";

    /* renamed from: g  reason: collision with root package name */
    private int f68652g = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f68653h;

    /* renamed from: i  reason: collision with root package name */
    private String f68654i;

    public f(net.one97.paytm.upi.profile.b.b bVar, b bVar2, f.b bVar3, boolean z) {
        this.f68650e = bVar;
        this.f68646a = bVar2;
        this.f68647b = bVar3;
        this.f68653h = z;
        this.f68654i = bVar3.getClass().getSimpleName();
        this.f68647b.a(this);
    }

    public final void e() {
        this.f68647b.a();
        if (!this.f68653h) {
            this.f68650e.a((a.C1382a) new a.C1382a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    if (f.this.f68647b != null) {
                        if (upiBaseDataModel instanceof UpiProfileModel) {
                            UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                            if (!upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") || !"0".equalsIgnoreCase(upiProfileModel.getRespCode()) || upiProfileModel.getResponse() == null || upiProfileModel.getResponse().getProfileDetail() == null) {
                                f.this.f68647b.a((UpiCustomVolleyError) null);
                                return;
                            }
                            f.this.f68648c = upiProfileModel.getResponse().getProfileDetail().getProfileVpaList();
                            f.this.f68649d = upiProfileModel.getResponse().getProfileDetail().getBankAccountList();
                            f.this.f68647b.a(f.this.f68648c, f.this.f68649d);
                            return;
                        }
                        f.this.f68647b.a((UpiCustomVolleyError) null);
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    if (f.this.f68647b != null) {
                        f.this.f68647b.a(upiCustomVolleyError);
                    }
                }
            }, "UpiLandingPagePresenter", this.f68654i);
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        f.b bVar = this.f68647b;
        if (bVar != null && this.f68652g > 0) {
            bVar.a(accountProvider, this.f68648c.get(0).getVirtualAddress());
        }
    }

    public final void a(int i2) {
        if (this.f68652g >= i2) {
            this.f68647b.a(i2);
        } else {
            this.f68647b.b();
        }
    }

    public final void a() {
        this.f68647b.c();
        this.f68650e.b((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (f.this.f68647b != null) {
                    if (upiBaseDataModel instanceof BaseUpiResponse) {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                        if (!baseUpiResponse.isSuccess() || !"0".equals(baseUpiResponse.getResponse())) {
                            f.this.f68647b.a(baseUpiResponse.getMessage(), baseUpiResponse.getResponse());
                            return;
                        }
                        f.this.f68647b.d();
                        f fVar = f.this;
                        fVar.f68646a.c(new a.C1389a() {
                            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                            }

                            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                            }
                        }, "", "");
                        return;
                    }
                    f.this.f68647b.a("", (String) null);
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (f.this.f68647b != null) {
                    f.this.f68647b.a("", upiCustomVolleyError.getmErrorCode());
                }
            }
        }, "UpiLandingPagePresenter", this.f68654i);
    }

    public final void a(boolean z) {
        this.f68653h = z;
    }

    public final void f() {
        this.f68647b = null;
    }
}
