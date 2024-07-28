package net.one97.paytm.moneytransfer.presenter;

import android.os.Handler;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase;
import net.one97.paytm.moneytransfer.a.c;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountBalanceModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.CJRAccountSummary;
import net.one97.paytm.upi.common.upi.GetCredentialsResponse;
import net.one97.paytm.upi.common.upi.UpiCheckBalanceModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.common.upi.UpiToken;
import net.one97.paytm.upi.common.upi.UserMpinDetails;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.UpiUtils;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public final class b implements c.a {

    /* renamed from: a  reason: collision with root package name */
    c.b f54050a;

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.moneytransfer.b.a.b f54051b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<BankAccountDetails.BankAccount> f54052c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<String> f54053d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    a f54054e;

    /* renamed from: f  reason: collision with root package name */
    net.one97.paytm.upi.registration.b.a.b f54055f;

    /* renamed from: g  reason: collision with root package name */
    int f54056g = -1;

    /* renamed from: h  reason: collision with root package name */
    private final String f54057h = "MoneyTransferBeneficiaryPresenter";

    /* renamed from: i  reason: collision with root package name */
    private net.one97.paytm.upi.profile.b.b f54058i;
    private String j;
    private ArrayList<BeneficiaryEntity> k;

    public b(c.b bVar, net.one97.paytm.moneytransfer.b.a.b bVar2, net.one97.paytm.upi.profile.b.b bVar3, net.one97.paytm.upi.registration.b.a.b bVar4, a aVar) {
        this.f54050a = bVar;
        this.j = bVar.getClass().getSimpleName();
        this.f54051b = bVar2;
        this.f54058i = bVar3;
        this.f54055f = bVar4;
        this.f54054e = aVar;
        this.f54050a.a(this);
    }

    public final void a(final String str, final String str2, boolean z) {
        this.f54050a.a(true);
        this.f54051b.a((a.C0960a) new a.C0960a() {
            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                if (b.this.g()) {
                    b.this.f54050a.a(false);
                    CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) iJRPaytmDataModel;
                    if (cJRAddBeneficiary.getError() != null) {
                        if (cJRAddBeneficiary.getError().getErrorMsg() != null) {
                            b.this.f54050a.a(cJRAddBeneficiary.getError().getErrorMsg());
                        } else {
                            b.this.f54050a.a((String) null);
                        }
                    } else if (cJRAddBeneficiary.getStatusCode().equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
                        b.this.f54051b.a(str, str2);
                        b.this.f54050a.b();
                    }
                }
            }

            public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                if (b.this.g()) {
                    b.this.f54050a.a(upiCustomVolleyError);
                    b.this.f54050a.a(false);
                }
            }
        }, str, str2, z);
    }

    public final void a() {
        d.c();
        this.f54058i.a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (b.this.g()) {
                    b.this.f54050a.c(false);
                    if (upiBaseDataModel instanceof UpiProfileModel) {
                        UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                        if (upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") && "0".equalsIgnoreCase(upiProfileModel.getRespCode()) && upiProfileModel.getResponse() != null && upiProfileModel.getResponse().getProfileDetail().getProfileVpaList() != null && upiProfileModel.getResponse().getProfileDetail().getProfileVpaList().size() > 0 && upiProfileModel.getResponse().getProfileDetail().getBankAccountList() != null) {
                            Iterator<BankAccountDetails.BankAccount> it2 = upiProfileModel.getResponse().getProfileDetail().getBankAccountList().iterator();
                            while (it2.hasNext()) {
                                BankAccountDetails.BankAccount next = it2.next();
                                if (!b.this.f54053d.contains(next.getAccount())) {
                                    b.this.f54052c.add(next);
                                    b.this.f54053d.add(next.getAccount());
                                }
                            }
                            b.this.f54050a.a(b.this.f54052c, upiProfileModel.getResponse().getProfileDetail().getProfileVpaList().get(0).getVirtualAddress());
                        }
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (b.this.f54050a != null) {
                    b.this.f54050a.c(false);
                    b.this.f54050a.f();
                }
            }
        }, "MoneyTransferBeneficiaryPresenter", this.j);
    }

    public final void c() {
        if (!this.f54053d.isEmpty()) {
            this.f54053d.clear();
            this.f54052c.clear();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, int i3, CJRKYCBeneficiaryBase cJRKYCBeneficiaryBase) {
        if (g()) {
            if (cJRKYCBeneficiaryBase.getBeneficiariesList() == null || cJRKYCBeneficiaryBase.getTotalCount() == 0) {
                this.f54050a.b(true);
                a(i2, i3);
                return;
            }
            this.f54050a.b(false);
            this.f54050a.a(cJRKYCBeneficiaryBase.getBeneficiariesList());
            this.k.addAll(cJRKYCBeneficiaryBase.getBeneficiariesList());
            a(i2, i3);
        }
    }

    private void a(int i2, int i3) {
        this.f54051b.a((a.C0960a) new a.C0960a() {
            public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            }

            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                try {
                    CJRKYCBeneficiaryBase cJRKYCBeneficiaryBase = (CJRKYCBeneficiaryBase) iJRPaytmDataModel;
                    b.this.f54056g = cJRKYCBeneficiaryBase.getTotalCount();
                    if ((cJRKYCBeneficiaryBase.getError() == null || (!cJRKYCBeneficiaryBase.getError().getErrorCode().equalsIgnoreCase("B-1002") && !cJRKYCBeneficiaryBase.getError().getErrorCode().equalsIgnoreCase("B-1003"))) && cJRKYCBeneficiaryBase.getError() == null && cJRKYCBeneficiaryBase.getBeneficiariesList() != null && cJRKYCBeneficiaryBase.getBeneficiariesList().size() > 0) {
                        b.this.a(cJRKYCBeneficiaryBase);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }, (a.b) null, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(CJRKYCBeneficiaryBase cJRKYCBeneficiaryBase) {
        if (this.f54050a != null) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet(this.f54053d);
            ArrayList arrayList = new ArrayList();
            Iterator<BeneficiaryEntity> it2 = this.k.iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next().beneficiaryId);
            }
            Iterator<BeneficiaryEntity> it3 = cJRKYCBeneficiaryBase.getBeneficiariesList().iterator();
            while (true) {
                boolean z = false;
                if (!it3.hasNext()) {
                    break;
                }
                BeneficiaryEntity next = it3.next();
                boolean contains = hashSet.contains(next.beneficiaryId);
                if (next.instrumentPreferences.otherBank != null) {
                    z = hashSet2.contains(next.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber);
                }
                if (!z && !contains) {
                    arrayList.add(next);
                }
            }
            if (!this.k.isEmpty()) {
                Collections.sort(arrayList, $$Lambda$b$JjnxgK7v9C4IJyx_wFIVhP6cJE.INSTANCE);
            }
            if (arrayList.size() > 0) {
                this.f54051b.a((ArrayList<BeneficiaryEntity>) arrayList);
            }
            this.f54050a.b(false);
            this.k.addAll(0, arrayList);
            this.f54050a.a(this.k);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int a(BeneficiaryEntity beneficiaryEntity, BeneficiaryEntity beneficiaryEntity2) {
        String str;
        long j2;
        String str2 = "";
        if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
            str = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).creationTime;
        } else if (beneficiaryEntity.instrumentPreferences.upi != null) {
            str = beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).creationTime;
        } else {
            str = beneficiaryEntity.instrumentPreferences.wallet != null ? beneficiaryEntity.instrumentPreferences.wallet.accounts.get(0).creationTime : str2;
        }
        if (beneficiaryEntity2.instrumentPreferences.otherBank != null) {
            str2 = beneficiaryEntity2.instrumentPreferences.otherBank.accounts.get(0).creationTime;
        } else if (beneficiaryEntity2.instrumentPreferences.upi != null) {
            str2 = beneficiaryEntity2.instrumentPreferences.upi.accounts.get(0).creationTime;
        } else if (beneficiaryEntity2.instrumentPreferences.wallet != null) {
            str2 = beneficiaryEntity2.instrumentPreferences.wallet.accounts.get(0).creationTime;
        }
        long j3 = 0;
        try {
            j2 = m.j(str);
            try {
                j3 = m.j(str2);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return Long.compare(j2, j3);
            }
        } catch (Exception e3) {
            e = e3;
            j2 = 0;
            e.printStackTrace();
            return Long.compare(j2, j3);
        }
        return Long.compare(j2, j3);
    }

    public final void e() {
        d.c();
        this.f54050a.c(true);
        this.f54050a.b(true);
        this.k = new ArrayList<>();
        this.f54051b.a((a.b) new a.b(0, 25) {
            private final /* synthetic */ int f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onSuccess(CJRKYCBeneficiaryBase cJRKYCBeneficiaryBase) {
                b.this.a(this.f$1, this.f$2, cJRKYCBeneficiaryBase);
            }
        });
    }

    public final void f() {
        this.f54050a = null;
    }

    public final boolean b() {
        return this.f54051b.a();
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        c.b bVar = this.f54050a;
        if (bVar != null) {
            bVar.a(accountProvider);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(List<GetCredentialsResponse> list, String str, final BankAccountDetails.BankAccount bankAccount) {
        if (g()) {
            UserMpinDetails userMpinDetails = new UserMpinDetails();
            for (GetCredentialsResponse next : list) {
                if ("MPIN".equalsIgnoreCase(next.getSubtype())) {
                    userMpinDetails.setMpin(next.getData().getCode() + AppConstants.COMMA + next.getData().getKi() + AppConstants.COMMA + next.getData().getEncryptedBase64String());
                }
            }
            UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
            upiProfileDefaultBank.setVirtualAddress(this.f54050a.e());
            upiProfileDefaultBank.setDebitBank(bankAccount);
            this.f54058i.a(str, userMpinDetails, upiProfileDefaultBank, (a.C1382a) new a.C1382a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    if (b.this.g()) {
                        if (upiBaseDataModel instanceof BaseUpiResponse) {
                            BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                            if (!baseUpiResponse.isSuccess() || !"0".equals(baseUpiResponse.getResponse())) {
                                b.this.f54050a.d(false);
                                b.this.f54050a.a((UpiCustomVolleyError) null, baseUpiResponse.getResponse());
                                return;
                            }
                            try {
                                if (baseUpiResponse.getMobileAppData() instanceof UpiCheckBalanceModel) {
                                    UpiCheckBalanceModel upiCheckBalanceModel = (UpiCheckBalanceModel) baseUpiResponse.getMobileAppData();
                                    b.this.f54050a.a(upiCheckBalanceModel.getTotalBal(), upiCheckBalanceModel.getAvailableBalance(), bankAccount.getAccountType());
                                    b.this.f54050a.d(true);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            b.this.f54050a.d(false);
                            b.this.f54050a.a((UpiCustomVolleyError) null, "");
                        }
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    if (b.this.g()) {
                        b.this.f54050a.d(false);
                        b.this.f54050a.a(upiCustomVolleyError, "");
                    }
                }
            }, "MoneyTransferBeneficiaryPresenter", "");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        return this.f54050a != null;
    }

    public final int d() {
        return this.f54056g;
    }

    public final void a(final BankAccountDetails.BankAccount bankAccount) {
        if (bankAccount.getIfsc().contains("PYTM")) {
            net.one97.paytm.upi.profile.b.b bVar = this.f54058i;
            bankAccount.getAccount();
            bVar.a((a.C1382a) new a.C1382a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    if (b.this.g()) {
                        if (upiBaseDataModel instanceof CJRAccountSummary) {
                            CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                            if (cJRAccountSummary.getStatus() == null || !cJRAccountSummary.getStatus().equalsIgnoreCase("success")) {
                                b.this.f54050a.d(false);
                                b.this.f54050a.a((UpiCustomVolleyError) null, "");
                                b.this.f54050a.d(false);
                                return;
                            }
                            AccountBalanceModel accountBalanceModel = cJRAccountSummary.getAccounts().get(0);
                            b.this.f54050a.a(String.valueOf(accountBalanceModel.getEffectiveBalance()), String.valueOf(accountBalanceModel.getEffectiveBalance()), bankAccount.getAccountType());
                            b.this.f54050a.d(true);
                            return;
                        }
                        b.this.f54050a.d(false);
                        b.this.f54050a.a((UpiCustomVolleyError) null, "");
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    if (b.this.g()) {
                        b.this.f54050a.d(false);
                        b.this.f54050a.a(upiCustomVolleyError, "");
                    }
                }
            });
        } else if (!this.f54051b.b() || this.f54051b.a()) {
            this.f54055f.b((a.C1389a) new a.C1389a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    if (b.this.f54050a != null) {
                        if (upiBaseDataModel instanceof BaseUpiResponse) {
                            b bVar = b.this;
                            bVar.f54055f.d(new a.C1389a((String) ((BaseUpiResponse) upiBaseDataModel).getMobileAppData(), bankAccount) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ String f54068a;

                                /* renamed from: b  reason: collision with root package name */
                                final /* synthetic */ BankAccountDetails.BankAccount f54069b;

                                {
                                    this.f54068a = r2;
                                    this.f54069b = r3;
                                }

                                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                                    if (b.this.f54050a != null) {
                                        if (upiBaseDataModel instanceof UpiToken) {
                                            b bVar = b.this;
                                            String str = this.f54068a;
                                            String upiToken = ((UpiToken) upiBaseDataModel).getUpiToken();
                                            BankAccountDetails.BankAccount bankAccount = this.f54069b;
                                            String upiSequenceNo = UpiUtils.getUpiSequenceNo();
                                            if (bVar.f54054e.a()) {
                                                bVar.f54054e.a(upiSequenceNo, str, upiToken, 0, bankAccount, new CLRemoteResultReceiver(new MoneyTransferBeneficiaryPresenter$7(bVar, new Handler(), upiSequenceNo, bankAccount)));
                                                return;
                                            }
                                            bVar.f54050a.d(false);
                                            bVar.f54050a.a(new UpiCustomVolleyError());
                                            return;
                                        }
                                        b.this.f54050a.d(false);
                                        b.this.f54050a.a((UpiCustomVolleyError) null, "");
                                    }
                                }

                                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                                    if (b.this.g()) {
                                        b.this.f54050a.d(false);
                                        b.this.f54050a.a(upiCustomVolleyError, upiCustomVolleyError.getAlertTitle());
                                    }
                                }
                            }, "MoneyTransferBeneficiaryPresenter", "");
                        } else if (b.this.g()) {
                            b.this.f54050a.d(false);
                            b.this.f54050a.c();
                        }
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    if (b.this.f54050a != null) {
                        b.this.f54050a.d(false);
                        b.this.f54050a.c();
                        b.this.f54050a.d(false);
                    }
                }
            }, "MoneyTransferBeneficiaryPresenter", "");
        } else {
            this.f54050a.a();
        }
    }
}
