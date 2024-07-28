package net.one97.paytm.moneytransferv4.home.presentation.a;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.CustProductListV2;
import net.one97.paytm.common.entity.PPBCurrentAccountModel;
import net.one97.paytm.common.entity.wallet.IMPSMetaDataModal;
import net.one97.paytm.moneytransfer.a.d;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.b.a.b;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.common.upi.CJRAccountSummary;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.UpiConstants;

public final class d implements d.a, a.C0960a {

    /* renamed from: a  reason: collision with root package name */
    d.b f55498a;

    /* renamed from: b  reason: collision with root package name */
    private final String f55499b = "MoneyTransferPresenter";

    /* renamed from: c  reason: collision with root package name */
    private final String f55500c = "ISSUED";

    /* renamed from: d  reason: collision with root package name */
    private b f55501d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.upi.registration.b.a.b f55502e;

    /* renamed from: f  reason: collision with root package name */
    private UpiConstants.MoneyTransferPaymentOption f55503f;

    /* renamed from: g  reason: collision with root package name */
    private String f55504g;

    /* renamed from: h  reason: collision with root package name */
    private String f55505h = "";

    public final void b() {
    }

    public d(UpiConstants.MoneyTransferPaymentOption moneyTransferPaymentOption, b bVar, net.one97.paytm.upi.registration.b.a.b bVar2, d.b bVar3) {
        this.f55501d = bVar;
        this.f55502e = bVar2;
        this.f55498a = bVar3;
        this.f55503f = moneyTransferPaymentOption;
    }

    public final void a() {
        if (!this.f55498a.k()) {
            this.f55498a.l();
        } else if (this.f55503f == UpiConstants.MoneyTransferPaymentOption.IMPS) {
            this.f55498a.a(false);
        } else if (!this.f55501d.b()) {
            this.f55502e.c(new a.C1389a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                    if (upiAvailabilityModel.getResponse() != null) {
                        d.this.f55498a.a(upiAvailabilityModel.getResponse().isUpiUser());
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    if (d.this.f55498a != null && !d.this.f55498a.h()) {
                        d.this.f55498a.a(false);
                        d.this.f55498a.a(upiCustomVolleyError);
                    }
                }
            }, "MoneyTransferPresenter", this.f55504g);
        }
    }

    public final void c() {
        if (this.f55503f != UpiConstants.MoneyTransferPaymentOption.IMPS) {
            this.f55502e.b((a.C1389a) new a.C1389a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    if (upiCustomVolleyError != null) {
                        "1006".equalsIgnoreCase(upiCustomVolleyError.getAlertTitle());
                    }
                }
            }, "MoneyTransferPresenter", this.f55504g);
        }
    }

    public final void f() {
        b.d();
        this.f55501d.a("MoneyTransferPresenter");
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        PPBCurrentAccountModel pPBCurrentAccountModel;
        if (iJRPaytmDataModel instanceof IMPSMetaDataModal) {
            IMPSMetaDataModal iMPSMetaDataModal = (IMPSMetaDataModal) iJRPaytmDataModel;
            if (!(iMPSMetaDataModal.getMinAmount() == null || iMPSMetaDataModal.getMaxAmount() == null)) {
                this.f55498a.a(iMPSMetaDataModal.getMinAmount(), iMPSMetaDataModal.getMaxAmount(), iMPSMetaDataModal.getImpsMaxLimit());
            }
        }
        if (iJRPaytmDataModel instanceof CustProductListV2) {
            CustProductListV2 custProductListV2 = (CustProductListV2) iJRPaytmDataModel;
            if (custProductListV2.getStatus().equalsIgnoreCase("SUCCESS") && custProductListV2.isSuccess() && custProductListV2.getResponse() != null) {
                String isaStatus = custProductListV2.getResponse().getIsaStatus();
                char c2 = 65535;
                switch (isaStatus.hashCode()) {
                    case -2125830485:
                        if (isaStatus.equals("ISSUED")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -1757359925:
                        if (isaStatus.equals("INITIATED")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -604548089:
                        if (isaStatus.equals("IN_PROGRESS")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -287297839:
                        if (isaStatus.equals("NOT_APPLIED")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 2332508:
                        if (isaStatus.equals("LEAD")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 35394935:
                        if (isaStatus.equals("PENDING")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 2066319421:
                        if (isaStatus.equals("FAILED")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                    case 1:
                        net.one97.paytm.moneytransfer.d.d.c().a(net.one97.paytm.moneytransfer.d.d.c().a(), net.one97.paytm.moneytransfer.utils.a.NOT_APPLIED.getNumVal());
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        net.one97.paytm.moneytransfer.d.d.c().a(net.one97.paytm.moneytransfer.d.d.c().a(), net.one97.paytm.moneytransfer.utils.a.PROCESSING.getNumVal());
                        break;
                    case 6:
                        net.one97.paytm.moneytransfer.d.d.c().a(net.one97.paytm.moneytransfer.d.d.c().a(), net.one97.paytm.moneytransfer.utils.a.ISSUED.getNumVal());
                        if (!TextUtils.isEmpty(custProductListV2.getResponse().getAccountNumber())) {
                            this.f55498a.a(custProductListV2.getResponse().getAccountNumber());
                            break;
                        }
                        break;
                }
            }
        }
        boolean z = iJRPaytmDataModel instanceof PPBCurrentAccountModel;
        if (z && z && (pPBCurrentAccountModel = (PPBCurrentAccountModel) iJRPaytmDataModel) != null && pPBCurrentAccountModel.getIca() != null && !TextUtils.isEmpty(pPBCurrentAccountModel.getIca().getAccountNumber()) && "ISSUED".equalsIgnoreCase(pPBCurrentAccountModel.getIca().getStatus())) {
            this.f55498a.a(pPBCurrentAccountModel);
            this.f55501d.a((a.C1382a) new a.C1382a() {
                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                }

                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    if (upiBaseDataModel instanceof CJRAccountSummary) {
                        CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                        if (cJRAccountSummary.getStatus() != null && cJRAccountSummary.getStatus().equalsIgnoreCase("success")) {
                            d.this.f55498a.c(String.valueOf(cJRAccountSummary.getAccounts().get(0).getEffectiveBalance()));
                        }
                    }
                }
            }, pPBCurrentAccountModel.getIca().getAccountNumber(), pPBCurrentAccountModel.getIca().getCaId());
        }
    }

    public final void a(String str) {
        this.f55501d.a((a.C1382a) new a.C1382a() {
            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            }

            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (upiBaseDataModel instanceof CJRAccountSummary) {
                    CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                    if (cJRAccountSummary.getStatus() != null && cJRAccountSummary.getStatus().equalsIgnoreCase("success")) {
                        d.this.f55498a.b(String.valueOf(cJRAccountSummary.getAccounts().get(0).getEffectiveBalance()));
                    }
                }
            }
        }, str);
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        d.b bVar = this.f55498a;
        if (bVar != null) {
            bVar.a();
            this.f55498a.a(upiCustomVolleyError);
        }
    }

    public final void e() {
        if (this.f55503f != UpiConstants.MoneyTransferPaymentOption.UPI || this.f55498a.g() || this.f55498a.i() || this.f55498a.b()) {
            this.f55501d.b(this, new a.c() {
            });
            this.f55501d.a((a.C0960a) this, (a.c) new a.c() {
            });
            if (c.g().c()) {
                this.f55501d.c(this, new a.c() {
                });
            }
        }
        a();
        c();
    }
}
