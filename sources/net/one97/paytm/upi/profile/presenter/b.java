package net.one97.paytm.upi.profile.presenter;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.SignupLinkBankAccountResponse;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.a.b;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;

public final class b implements b.a {

    /* renamed from: a  reason: collision with root package name */
    final net.one97.paytm.upi.registration.b.a.b f68015a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f68016b;

    /* renamed from: c  reason: collision with root package name */
    UserUpiDetails f68017c;

    /* renamed from: d  reason: collision with root package name */
    b.C1381b f68018d;

    /* renamed from: e  reason: collision with root package name */
    private final net.one97.paytm.upi.profile.b.b f68019e;

    /* renamed from: f  reason: collision with root package name */
    private final String f68020f = "ChooseBankAccountPresenter";

    /* renamed from: g  reason: collision with root package name */
    private String f68021g;

    public b(net.one97.paytm.upi.profile.b.b bVar, net.one97.paytm.upi.registration.b.a.b bVar2, b.C1381b bVar3, UserUpiDetails userUpiDetails, boolean z) {
        this.f68019e = bVar;
        this.f68015a = bVar2;
        this.f68018d = bVar3;
        this.f68021g = bVar3.getClass().getSimpleName();
        this.f68017c = userUpiDetails;
        this.f68016b = z;
        this.f68018d.a(this);
    }

    public final void e() {
        UserUpiDetails userUpiDetails = this.f68017c;
        if (!(userUpiDetails == null || userUpiDetails.getAccountProvider() == null || TextUtils.isEmpty(this.f68017c.getAccountProvider().getIfsc()))) {
            this.f68018d.b(this.f68017c.getAccountProvider().getBankLogoUrl());
        }
        this.f68018d.a(this.f68017c.getBankAccountList());
    }

    /* access modifiers changed from: private */
    public static boolean b(List<BankAccountDetails.BankAccount> list) {
        if (list.isEmpty()) {
            return true;
        }
        for (BankAccountDetails.BankAccount isMpinSet : list) {
            if (isMpinSet.isMpinSet()) {
                return true;
            }
        }
        return false;
    }

    public final void a(ArrayList<String> arrayList) {
        this.f68018d.a();
        this.f68019e.a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (b.this.f68018d != null) {
                    if (upiBaseDataModel instanceof SignupLinkBankAccountResponse) {
                        SignupLinkBankAccountResponse signupLinkBankAccountResponse = (SignupLinkBankAccountResponse) upiBaseDataModel;
                        if (!signupLinkBankAccountResponse.getStatus().equalsIgnoreCase("SUCCESS") || !"0".equals(signupLinkBankAccountResponse.getRespCode())) {
                            b.this.f68018d.a(signupLinkBankAccountResponse.getRespCode());
                            return;
                        }
                        if (!(signupLinkBankAccountResponse.getAccountDetails() == null || signupLinkBankAccountResponse.getAccountDetails().getProfileDetail() == null || signupLinkBankAccountResponse.getAccountDetails().getProfileDetail().getBankAccountList() == null || signupLinkBankAccountResponse.getAccountDetails().getProfileDetail().getBankAccountList().isEmpty())) {
                            ArrayList<SignupLinkBankAccountResponse.RefId> newAccountsAdded = signupLinkBankAccountResponse.getAccountDetails().getNewAccountsAdded();
                            ArrayList<BankAccountDetails.BankAccount> bankAccountList = signupLinkBankAccountResponse.getAccountDetails().getProfileDetail().getBankAccountList();
                            ArrayList arrayList = new ArrayList();
                            Iterator<SignupLinkBankAccountResponse.RefId> it2 = newAccountsAdded.iterator();
                            while (it2.hasNext()) {
                                SignupLinkBankAccountResponse.RefId next = it2.next();
                                Iterator<BankAccountDetails.BankAccount> it3 = bankAccountList.iterator();
                                while (it3.hasNext()) {
                                    BankAccountDetails.BankAccount next2 = it3.next();
                                    if (next2.getAccRefId().equals(next.getAccRefId())) {
                                        arrayList.add(next2);
                                    }
                                }
                            }
                            b bVar = b.this;
                            bVar.f68017c = new UserUpiDetails.Builder(bVar.f68017c).setBankAccountList(arrayList).build();
                        }
                        if (b.this.f68016b) {
                            b bVar2 = b.this;
                            bVar2.f68015a.c(new a.C1389a() {
                                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                                }

                                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                                }
                            }, "", "");
                            if (b.b(b.this.f68017c.getBankAccountList())) {
                                b.this.f68018d.a(b.this.f68017c);
                            } else {
                                b.this.f68018d.c(b.this.f68017c);
                            }
                        } else {
                            if (!b.this.f68015a.h() || !b.this.f68015a.i()) {
                                b.a(b.this);
                            }
                            if (b.b(b.this.f68017c.getBankAccountList())) {
                                b.this.f68018d.b(b.this.f68017c);
                            } else {
                                b.this.f68018d.c(b.this.f68017c);
                            }
                        }
                    } else {
                        b.this.f68018d.a("");
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (b.this.f68018d != null) {
                    b.this.f68018d.a("");
                }
            }
        }, "ChooseBankAccountPresenter", arrayList);
    }

    public final void f() {
        this.f68018d = null;
        this.f68019e.a("ChooseBankAccountPresenter");
    }

    static /* synthetic */ void a(b bVar) {
        if (bVar.f68017c.getBankAccountList() != null && !bVar.f68017c.getBankAccountList().isEmpty()) {
            bVar.f68015a.e(b(bVar.f68017c.getBankAccountList()));
        }
        bVar.f68015a.d(true);
        bVar.f68015a.c(true);
        bVar.f68015a.a(true);
        bVar.f68015a.m();
    }
}
