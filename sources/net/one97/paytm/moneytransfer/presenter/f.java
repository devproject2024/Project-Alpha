package net.one97.paytm.moneytransfer.presenter;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.CJRClaimCashbackDataModel;
import net.one97.paytm.moneytransfer.a.g;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.b.a.b;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.profile.b.a;

public final class f implements g.a {

    /* renamed from: a  reason: collision with root package name */
    g.b f54111a;

    /* renamed from: b  reason: collision with root package name */
    UpiProfileDefaultBank f54112b;

    /* renamed from: c  reason: collision with root package name */
    private b f54113c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.upi.profile.b.b f54114d;

    public final void e() {
    }

    public final void f() {
    }

    public f(g.b bVar, b bVar2, net.one97.paytm.upi.profile.b.b bVar3) {
        this.f54111a = bVar;
        this.f54113c = bVar2;
        this.f54114d = bVar3;
    }

    public final void a() {
        this.f54114d.a((a.C1382a) new a.C1382a() {
            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            }

            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (upiBaseDataModel instanceof UpiProfileModel) {
                    UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                    if (upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") && "0".equalsIgnoreCase(upiProfileModel.getRespCode()) && upiProfileModel.getResponse() != null && upiProfileModel.getResponse().getProfileDetail().getProfileVpaList() != null) {
                        for (UpiProfileDefaultBank next : upiProfileModel.getResponse().getProfileDetail().getProfileVpaList()) {
                            if (next.isPrimary()) {
                                f fVar = f.this;
                                fVar.f54112b = next;
                                fVar.f54111a.a(f.this.f54112b);
                            }
                        }
                    }
                }
            }
        }, "", "");
    }

    public final void a(String str, String str2) {
        this.f54113c.b(new a.C0960a() {
            public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            }

            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof CJRClaimCashbackDataModel) {
                    f.this.f54111a.a((CJRClaimCashbackDataModel) iJRPaytmDataModel);
                }
            }
        }, str, str2);
    }
}
