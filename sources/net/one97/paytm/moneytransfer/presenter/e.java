package net.one97.paytm.moneytransfer.presenter;

import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.CJRAccountSummary;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.UpiConstants;

public final class e implements d.a, a.C0960a {

    /* renamed from: a  reason: collision with root package name */
    d.b f54094a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<UpiProfileDefaultBank> f54095b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<UpiProfileDefaultBank> f54096c;

    /* renamed from: d  reason: collision with root package name */
    LinkedHashMap<String, UpiProfileDefaultBank> f54097d;

    /* renamed from: e  reason: collision with root package name */
    String f54098e = "";

    /* renamed from: f  reason: collision with root package name */
    private final String f54099f = "MoneyTransferPresenter";

    /* renamed from: g  reason: collision with root package name */
    private final String f54100g = "ISSUED";

    /* renamed from: h  reason: collision with root package name */
    private b f54101h;

    /* renamed from: i  reason: collision with root package name */
    private net.one97.paytm.upi.registration.b.a.b f54102i;
    private net.one97.paytm.upi.profile.b.b j;
    private UpiConstants.MoneyTransferPaymentOption k;
    private String l;

    public e(UpiConstants.MoneyTransferPaymentOption moneyTransferPaymentOption, b bVar, net.one97.paytm.upi.registration.b.a.b bVar2, net.one97.paytm.upi.profile.b.b bVar3, d.b bVar4) {
        this.k = moneyTransferPaymentOption;
        this.f54101h = bVar;
        this.f54102i = bVar2;
        this.j = bVar3;
        this.f54094a = bVar4;
        this.f54095b = new ArrayList<>();
        this.f54096c = new ArrayList<>();
        this.f54097d = new LinkedHashMap<>();
        this.f54094a.a(this);
        this.l = bVar4.getClass().getSimpleName();
    }

    public final void e() {
        if (!this.f54094a.i() && !this.f54094a.b() && !this.f54094a.f() && !this.f54094a.d() && !this.f54094a.e() && !this.f54094a.h() && !this.f54094a.c()) {
            this.f54094a.j();
        }
        if (this.k != UpiConstants.MoneyTransferPaymentOption.UPI || this.f54094a.g() || this.f54094a.i() || this.f54094a.b()) {
            this.f54101h.b(this, new a.c() {
            });
            this.f54101h.a((a.C0960a) this, (a.c) new a.c() {
            });
            if (c.g().c()) {
                this.f54101h.c(this, new a.c() {
                });
            }
        }
        a();
        c();
    }

    public final void a() {
        if (!this.f54094a.k()) {
            this.f54094a.l();
        } else if (this.k == UpiConstants.MoneyTransferPaymentOption.IMPS) {
            this.f54094a.a(false);
        } else if (!this.f54101h.b()) {
            this.f54102i.c(new a.C1389a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                    if (upiAvailabilityModel.getResponse() != null) {
                        e.this.f54094a.a(upiAvailabilityModel.getResponse().isUpiUser());
                        if (upiAvailabilityModel.getResponse().isUpiUser() && !e.this.f54094a.b() && !e.this.f54094a.d() && !e.this.f54094a.e() && !e.this.f54094a.i()) {
                            e.this.b();
                        }
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    if (e.this.f54094a != null && !e.this.f54094a.h()) {
                        e.this.f54094a.a(false);
                        e.this.f54094a.a(upiCustomVolleyError);
                    }
                }
            }, "MoneyTransferPresenter", this.l);
        } else if (!this.f54094a.b() && !this.f54094a.d() && !this.f54094a.e() && !this.f54094a.i()) {
            b();
        }
    }

    public final void c() {
        if (this.k != UpiConstants.MoneyTransferPaymentOption.IMPS) {
            this.f54102i.b((a.C1389a) new a.C1389a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    if (upiCustomVolleyError != null) {
                        "1006".equalsIgnoreCase(upiCustomVolleyError.getAlertTitle());
                    }
                }
            }, "MoneyTransferPresenter", this.l);
        }
    }

    public final void b() {
        this.j.a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (upiBaseDataModel instanceof UpiProfileModel) {
                    UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                    if (upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") && "0".equalsIgnoreCase(upiProfileModel.getRespCode())) {
                        e.this.f54095b.clear();
                        e.this.f54097d.clear();
                        e.this.f54096c.clear();
                        if (!(upiProfileModel.getResponse() == null || upiProfileModel.getResponse().getProfileDetail().getProfileVpaList() == null)) {
                            e.this.f54094a.a((List<UpiProfileDefaultBank>) e.this.f54095b);
                            for (UpiProfileDefaultBank next : upiProfileModel.getResponse().getProfileDetail().getProfileVpaList()) {
                                if (!(next.getDebitBank() == null || next.getDebitBank().getAccount() == null)) {
                                    e.this.f54096c.add(next);
                                    e.this.f54097d.put(next.getDebitBank().getAccount(), next);
                                }
                                if (next.isPrimary()) {
                                    e.this.f54098e = next.getVirtualAddress();
                                    e.this.f54094a.d(e.this.f54098e);
                                }
                            }
                        }
                        if (!(upiProfileModel.getResponse() == null || upiProfileModel.getResponse().getProfileDetail().getBankAccountList() == null)) {
                            for (BankAccountDetails.BankAccount debitBank : upiProfileModel.getResponse().getProfileDetail().getBankAccountList()) {
                                UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                                upiProfileDefaultBank.setDebitBank(debitBank);
                                upiProfileDefaultBank.setVirtualAddress(e.this.f54098e);
                                e.this.f54097d.put(upiProfileDefaultBank.getDebitBank().getAccount(), upiProfileDefaultBank);
                            }
                        }
                        for (Map.Entry<String, UpiProfileDefaultBank> value : e.this.f54097d.entrySet()) {
                            e.this.f54095b.add(value.getValue());
                        }
                        e.this.f54094a.a(e.this.f54095b, e.this.f54096c);
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (e.this.f54094a != null && !e.this.f54094a.h()) {
                    e.this.f54094a.a(upiCustomVolleyError);
                }
            }
        }, "MoneyTransferPresenter", this.l);
    }

    public final void f() {
        b.d();
        this.f54101h.a("MoneyTransferPresenter");
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        PPBCurrentAccountModel pPBCurrentAccountModel;
        if (iJRPaytmDataModel instanceof IMPSMetaDataModal) {
            IMPSMetaDataModal iMPSMetaDataModal = (IMPSMetaDataModal) iJRPaytmDataModel;
            if (!(iMPSMetaDataModal.getMinAmount() == null || iMPSMetaDataModal.getMaxAmount() == null)) {
                this.f54094a.a(iMPSMetaDataModal.getMinAmount(), iMPSMetaDataModal.getMaxAmount(), iMPSMetaDataModal.getImpsMaxLimit());
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
                            this.f54094a.a(custProductListV2.getResponse().getAccountNumber());
                            break;
                        }
                        break;
                }
            }
        }
        boolean z = iJRPaytmDataModel instanceof PPBCurrentAccountModel;
        if (z && z && (pPBCurrentAccountModel = (PPBCurrentAccountModel) iJRPaytmDataModel) != null && pPBCurrentAccountModel.getIca() != null && !TextUtils.isEmpty(pPBCurrentAccountModel.getIca().getAccountNumber()) && "ISSUED".equalsIgnoreCase(pPBCurrentAccountModel.getIca().getStatus())) {
            this.f54094a.a(pPBCurrentAccountModel);
            this.f54101h.a((a.C1382a) new a.C1382a() {
                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                }

                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    if (upiBaseDataModel instanceof CJRAccountSummary) {
                        CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                        if (cJRAccountSummary.getStatus() != null && cJRAccountSummary.getStatus().equalsIgnoreCase("success")) {
                            e.this.f54094a.c(String.valueOf(cJRAccountSummary.getAccounts().get(0).getEffectiveBalance()));
                        }
                    }
                }
            }, pPBCurrentAccountModel.getIca().getAccountNumber(), pPBCurrentAccountModel.getIca().getCaId());
        }
    }

    public final void a(String str) {
        this.f54101h.a((a.C1382a) new a.C1382a() {
            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            }

            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (upiBaseDataModel instanceof CJRAccountSummary) {
                    CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                    if (cJRAccountSummary.getStatus() != null && cJRAccountSummary.getStatus().equalsIgnoreCase("success")) {
                        e.this.f54094a.b(String.valueOf(cJRAccountSummary.getAccounts().get(0).getEffectiveBalance()));
                    }
                }
            }
        }, str);
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        d.b bVar = this.f54094a;
        if (bVar != null) {
            bVar.a();
            this.f54094a.a(upiCustomVolleyError);
        }
    }
}
