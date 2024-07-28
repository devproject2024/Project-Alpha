package net.one97.paytm.moneytransfer.presenter;

import net.one97.paytm.moneytransfer.a.e;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.profile.b.b;

public final class c implements e.a {

    /* renamed from: a  reason: collision with root package name */
    e.b f54073a;

    /* renamed from: b  reason: collision with root package name */
    private final String f54074b = "MoneyTransferLinkedAccountPresenter";

    /* renamed from: c  reason: collision with root package name */
    private b f54075c;

    /* renamed from: d  reason: collision with root package name */
    private String f54076d;

    public final void e() {
    }

    public c(e.b bVar, b bVar2) {
        this.f54073a = bVar;
        this.f54076d = bVar.getClass().getSimpleName();
        this.f54075c = bVar2;
        this.f54073a.a(this);
    }

    public final void a() {
        this.f54073a.a();
        this.f54075c.b((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (c.this.f54073a != null) {
                    if (upiBaseDataModel instanceof BaseUpiResponse) {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                        if (!baseUpiResponse.isSuccess() || !"0".equals(baseUpiResponse.getResponse())) {
                            c.this.f54073a.a(baseUpiResponse.getMessage());
                        } else {
                            c.this.f54073a.b();
                        }
                    } else {
                        c.this.f54073a.a("");
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (c.this.f54073a != null) {
                    c.this.f54073a.a("");
                }
            }
        }, "MoneyTransferLinkedAccountPresenter", this.f54076d);
    }

    public final void f() {
        b bVar = this.f54075c;
        if (bVar != null) {
            bVar.a("MoneyTransferLinkedAccountPresenter");
        }
    }
}
