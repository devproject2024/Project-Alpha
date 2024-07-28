package net.one97.paytm.paymentsBank.si.e;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.bankCommon.model.BankAccountDetails;
import net.one97.paytm.bankCommon.model.BeneficiaryEntity;
import net.one97.paytm.bankCommon.model.CJRAddBeneficiary;
import net.one97.paytm.bankCommon.model.CJRKYCBeneficiaryBase;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.paymentsBank.si.b.c;
import net.one97.paytm.paymentsBank.si.f.a;
import net.one97.paytm.paymentsBank.si.f.b;

public final class a implements c.a {

    /* renamed from: a  reason: collision with root package name */
    c.b f18889a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f18890b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final String f18891c = "MoneyTransferBeneficiaryPresenter";

    /* renamed from: d  reason: collision with root package name */
    private b f18892d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<BankAccountDetails.BankAccount> f18893e = new ArrayList<>();

    public a(c.b bVar, b bVar2) {
        this.f18889a = bVar;
        this.f18892d = bVar2;
        this.f18889a.a(this);
    }

    public final void a(String str, String str2, boolean z) {
        this.f18889a.a(true);
        this.f18892d.a((a.C0325a) new a.C0325a() {
            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                a.this.f18889a.a(false);
                CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) iJRPaytmDataModel;
                if (cJRAddBeneficiary.getError() != null) {
                    if (cJRAddBeneficiary.getError().getErrorMsg() != null) {
                        a.this.f18889a.a(cJRAddBeneficiary.getError().getErrorMsg());
                    } else {
                        a.this.f18889a.a((String) null);
                    }
                } else if (cJRAddBeneficiary.getStatusCode().equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
                    a.this.f18889a.a();
                }
            }

            public final void a(NetworkCustomError networkCustomError) {
                a.this.f18889a.a(networkCustomError);
                a.this.f18889a.a(false);
            }
        }, str, str2, z);
    }

    public final void a(int i2, int i3) {
        this.f18892d.a((a.C0325a) new a.C0325a() {
            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                a.this.f18889a.b(false);
                CJRKYCBeneficiaryBase cJRKYCBeneficiaryBase = (CJRKYCBeneficiaryBase) iJRPaytmDataModel;
                if ((cJRKYCBeneficiaryBase.getError() == null || (!cJRKYCBeneficiaryBase.getError().getErrorCode().equalsIgnoreCase("B-1002") && !cJRKYCBeneficiaryBase.getError().getErrorCode().equalsIgnoreCase("B-1003"))) && cJRKYCBeneficiaryBase.getError() == null && cJRKYCBeneficiaryBase.getBeneficiariesList() != null && cJRKYCBeneficiaryBase.getBeneficiariesList().size() > 0) {
                    int totalCount = cJRKYCBeneficiaryBase.getTotalCount();
                    ArrayList arrayList = new ArrayList();
                    Iterator<BeneficiaryEntity> it2 = cJRKYCBeneficiaryBase.getBeneficiariesList().iterator();
                    while (it2.hasNext()) {
                        BeneficiaryEntity next = it2.next();
                        if (next.instrumentPreferences.otherBank != null) {
                            String str = next.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber;
                            if (!a.this.f18890b.contains(str)) {
                                arrayList.add(next);
                                a.this.f18890b.add(str);
                            } else {
                                totalCount--;
                            }
                        } else if (next.instrumentPreferences.upi != null) {
                            arrayList.add(next);
                        }
                    }
                    if (arrayList.size() > 0) {
                        a.this.f18889a.a(arrayList, totalCount);
                    }
                }
            }

            public final void a(NetworkCustomError networkCustomError) {
                a.this.f18889a.b(false);
            }
        }, (a.b) new a.b() {
            public final void a() {
                a.this.f18889a.b(false);
            }
        }, i2, i3);
    }

    public final void a() {
        this.f18889a.b(true);
        a(0, 25);
    }
}
