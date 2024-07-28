package net.one97.paytm.upi.profile.presenter;

import androidx.core.g.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCheckAndAddVpaModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.SignupLinkBankAccountResponse;
import net.one97.paytm.upi.common.upi.UpiListBankAccountsResponse;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.a.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.b.a.b;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class a implements a.C1380a {

    /* renamed from: a  reason: collision with root package name */
    a.b f68001a;

    /* renamed from: b  reason: collision with root package name */
    b f68002b;

    /* renamed from: c  reason: collision with root package name */
    String f68003c;

    /* renamed from: d  reason: collision with root package name */
    String f68004d;

    /* renamed from: e  reason: collision with root package name */
    UpiConstants.PROFILE_STATE f68005e;

    /* renamed from: f  reason: collision with root package name */
    UserUpiDetails f68006f;

    /* renamed from: g  reason: collision with root package name */
    boolean f68007g;

    /* renamed from: h  reason: collision with root package name */
    private final String f68008h = "BankVPACreationPresenter";

    /* renamed from: i  reason: collision with root package name */
    private net.one97.paytm.upi.profile.b.b f68009i;
    private AccountProviderBody.AccountProvider j;
    private String k;
    private int l = 0;
    private UserUpiDetails m;
    private String n;

    public a(net.one97.paytm.upi.profile.b.b bVar, b bVar2, a.b bVar3, AccountProviderBody.AccountProvider accountProvider, String str, String str2, UpiConstants.PROFILE_STATE profile_state) {
        this.f68009i = (net.one97.paytm.upi.profile.b.b) f.a(bVar, "upiProfileRepo cannot be null");
        this.f68002b = (b) f.a(bVar2, "upiRegisterRepo cannot be null");
        this.f68001a = (a.b) f.a(bVar3, "accountProvider cannot be null!");
        this.n = this.f68001a.getClass().getSimpleName();
        this.k = str;
        this.f68003c = str2;
        this.j = accountProvider;
        this.f68004d = accountProvider.getAccountProvider();
        this.f68001a.a(this);
        this.f68005e = profile_state;
    }

    public final void e() {
        if (this.f68005e.equals(UpiConstants.PROFILE_STATE.CHECK_VPA)) {
            a("", false);
            this.f68007g = true;
        } else if (this.f68005e.equals(UpiConstants.PROFILE_STATE.ADD_BANK)) {
            c();
            a();
        }
    }

    private void c() {
        this.m = new UserUpiDetails.Builder(this.j, this.k).build();
    }

    public final void a(String str, boolean z) {
        if (z) {
            UpiConstants.UpiVpaValidationError isValidVpa = UpiUtils.isValidVpa(str);
            if (isValidVpa != null) {
                this.f68001a.a(isValidVpa);
                return;
            }
            this.k = UpiUtils.buildVpa(str);
        } else {
            this.k = UpiUtils.getPaytmVpa(this.f68003c);
        }
        this.f68001a.a(this.k);
        c();
        this.f68009i.a(this.f68007g, this.m, (a.C1382a) new a.C1382a() {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f68010a = true;

            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (a.this.f68001a != null) {
                    if (upiBaseDataModel instanceof UpiCheckAndAddVpaModel) {
                        UpiCheckAndAddVpaModel upiCheckAndAddVpaModel = (UpiCheckAndAddVpaModel) upiBaseDataModel;
                        if (!upiCheckAndAddVpaModel.getStatus().equalsIgnoreCase("success")) {
                            a.b bVar = a.this.f68001a;
                            String respCode = upiCheckAndAddVpaModel.getRespCode();
                            upiCheckAndAddVpaModel.getRespMessage();
                            bVar.a(respCode, "");
                        } else if (!this.f68010a || upiCheckAndAddVpaModel.getSuggestedVpas() == null) {
                            a.this.f68001a.a();
                        } else {
                            a.this.f68001a.a(upiCheckAndAddVpaModel);
                        }
                    } else {
                        a.this.f68001a.a("", "");
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (a.this.f68001a != null) {
                    a.this.f68001a.a("", upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : "");
                }
            }
        });
    }

    public final void a() {
        this.f68001a.a(this.f68004d, this.f68003c, this.j.getBankLogoUrl());
        this.f68009i.a(this.j.getIfsc(), this.k, (a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (a.this.f68001a != null) {
                    if (upiBaseDataModel instanceof UpiListBankAccountsResponse) {
                        UpiListBankAccountsResponse upiListBankAccountsResponse = (UpiListBankAccountsResponse) upiBaseDataModel;
                        if (!upiListBankAccountsResponse.getStatus().equalsIgnoreCase("SUCCESS") || !"0".equalsIgnoreCase(upiListBankAccountsResponse.getRespCode())) {
                            if ("XH".equalsIgnoreCase(upiListBankAccountsResponse.getRespCode())) {
                                a.this.f68001a.b(a.this.f68004d, a.this.f68003c, upiListBankAccountsResponse.getRespCode());
                            } else if ("1006".equals(upiListBankAccountsResponse.getRespCode())) {
                                a.this.f68001a.b(upiListBankAccountsResponse.getRespCode());
                                if (a.this.f68005e.equals(UpiConstants.PROFILE_STATE.ADD_BANK)) {
                                    a.this.f68001a.b();
                                }
                            } else {
                                a.this.f68001a.b(upiListBankAccountsResponse.getRespCode());
                            }
                        } else if (upiListBankAccountsResponse.getAccountDetails() == null || upiListBankAccountsResponse.getAccountDetails().getAccounts() == null) {
                            a.this.f68001a.b(upiListBankAccountsResponse.getRespMessage());
                        } else {
                            ArrayList<BankAccountDetails.BankAccount> accounts = upiListBankAccountsResponse.getAccountDetails().getAccounts();
                            a aVar = a.this;
                            aVar.f68006f = a.a(aVar, (List) accounts);
                            if (accounts == null || accounts.size() <= 0) {
                                a.this.f68001a.b(a.this.f68004d, a.this.f68003c, upiListBankAccountsResponse.getRespCode());
                            } else if (accounts.size() > 1) {
                                a.this.f68001a.a(a.this.f68006f, a.this.f68007g);
                            } else {
                                a.this.f68001a.a(a.this.f68006f);
                            }
                        }
                    } else {
                        a.this.f68001a.b((String) null);
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (a.this.f68001a != null) {
                    a.this.f68001a.b(upiCustomVolleyError.getmErrorCode());
                }
            }
        }, "BankVPACreationPresenter");
    }

    public final void b() {
        this.f68001a.b(this.f68004d, this.f68003c);
        BankAccountDetails.BankAccount bankAccount = this.f68006f.getBankAccountList().get(0);
        ArrayList arrayList = new ArrayList();
        if (bankAccount != null) {
            arrayList.add(bankAccount.getTempAccRefId());
        }
        this.f68009i.a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (a.this.f68001a != null) {
                    if (upiBaseDataModel instanceof SignupLinkBankAccountResponse) {
                        SignupLinkBankAccountResponse signupLinkBankAccountResponse = (SignupLinkBankAccountResponse) upiBaseDataModel;
                        if (!signupLinkBankAccountResponse.getStatus().equalsIgnoreCase("SUCCESS") || !"0".equals(signupLinkBankAccountResponse.getRespCode())) {
                            a.this.f68001a.a(signupLinkBankAccountResponse.getRespCode(), signupLinkBankAccountResponse.getRespMessage(), a.this.f68006f, a.this.f68004d);
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
                            a aVar = a.this;
                            aVar.f68006f = a.a(aVar, (List) arrayList);
                        }
                        if (a.this.f68005e.equals(UpiConstants.PROFILE_STATE.CHECK_VPA)) {
                            a aVar2 = a.this;
                            aVar2.f68002b.c(new a.C1389a() {
                                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                                }

                                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                                }
                            }, "", "");
                            if (a.this.f68006f.getBankAccountList().isEmpty() || a.this.f68006f.getBankAccountList().get(0).isMpinSet()) {
                                a.this.f68001a.c(a.this.f68006f);
                            } else {
                                a.this.f68001a.d(a.this.f68006f);
                            }
                        } else if (a.this.f68005e.equals(UpiConstants.PROFILE_STATE.ADD_BANK)) {
                            if (!a.this.f68002b.h() || !a.this.f68002b.i()) {
                                a aVar3 = a.this;
                                if (aVar3.f68006f.getBankAccountList() != null && !aVar3.f68006f.getBankAccountList().isEmpty()) {
                                    aVar3.f68002b.e(aVar3.f68006f.getBankAccountList().get(0).isMpinSet());
                                }
                                aVar3.f68002b.d(true);
                                aVar3.f68002b.c(true);
                                aVar3.f68002b.a(true);
                                aVar3.f68002b.m();
                            }
                            a aVar4 = a.this;
                            aVar4.f68001a.b(aVar4.f68006f);
                        }
                    } else {
                        a.this.f68001a.a("", "", a.this.f68006f, a.this.f68004d);
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (a.this.f68001a != null) {
                    a.this.f68001a.a("", "", a.this.f68006f, a.this.f68004d);
                }
            }
        }, "BankVPACreationPresenter", (ArrayList<String>) arrayList);
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        this.j = accountProvider;
        this.f68004d = accountProvider.getAccountProvider();
    }

    public final void f() {
        this.f68001a = null;
        this.f68009i.a("BankVPACreationPresenter");
    }

    static /* synthetic */ UserUpiDetails a(a aVar, List list) {
        if (aVar.m == null) {
            aVar.c();
        }
        return new UserUpiDetails.Builder(aVar.m).setBankAccountList(list).build();
    }
}
