package net.one97.paytm.upi.registration.c;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.SignupLinkBankAccountResponse;
import net.one97.paytm.upi.common.upi.UpiListBankAccountsResponse;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.j;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;

public final class d extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.upi.profile.b.b f68553a;

    /* renamed from: b  reason: collision with root package name */
    public y<j<b>> f68554b;

    /* renamed from: c  reason: collision with root package name */
    public final y<j<List<BankAccountDetails.BankAccount>>> f68555c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public final LiveData<j<List<BankAccountDetails.BankAccount>>> f68556d = this.f68555c;

    /* renamed from: e  reason: collision with root package name */
    public final String f68557e;

    /* renamed from: f  reason: collision with root package name */
    public final y<j<a>> f68558f;

    /* renamed from: g  reason: collision with root package name */
    public final LiveData<j<a>> f68559g;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.upi.registration.b.a.b f68560h;

    /* renamed from: i  reason: collision with root package name */
    private y<j<b>> f68561i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Application application) {
        super(application);
        k.c(application, "application");
        String simpleName = d.class.getSimpleName();
        k.a((Object) simpleName, "SignUpLinkBankViewModel::class.java.simpleName");
        this.f68557e = simpleName;
        this.f68558f = new y<>();
        this.f68559g = this.f68558f;
        this.f68560h = net.one97.paytm.upi.g.a((net.one97.paytm.upi.h.a) null);
        this.f68553a = net.one97.paytm.upi.g.a();
        this.f68554b = new y<>();
        this.f68561i = new y<>();
    }

    public static final class g implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f68569a;

        public g(d dVar) {
            this.f68569a = dVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            if (upiBaseDataModel instanceof SignupLinkBankAccountResponse) {
                SignupLinkBankAccountResponse signupLinkBankAccountResponse = (SignupLinkBankAccountResponse) upiBaseDataModel;
                if (!p.a(signupLinkBankAccountResponse.getStatus(), "SUCCESS", true) || !"0".equals(signupLinkBankAccountResponse.getRespCode())) {
                    UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                    upiCustomVolleyError.setmErrorCode(signupLinkBankAccountResponse.getRespCode());
                    upiCustomVolleyError.setAlertMessage(signupLinkBankAccountResponse.getRespMessage());
                    y a2 = this.f68569a.f68554b;
                    if (a2 != null) {
                        j.a aVar = j.f67003d;
                        a2.setValue(j.a.a(upiCustomVolleyError));
                        return;
                    }
                    return;
                }
                if (signupLinkBankAccountResponse.getAccountDetails() != null) {
                    SignupLinkBankAccountResponse.AccountDetails accountDetails = signupLinkBankAccountResponse.getAccountDetails();
                    k.a((Object) accountDetails, "response.accountDetails");
                    if (accountDetails.getProfileDetail() != null) {
                        SignupLinkBankAccountResponse.AccountDetails accountDetails2 = signupLinkBankAccountResponse.getAccountDetails();
                        k.a((Object) accountDetails2, "response.accountDetails");
                        UpiProfileModel.ProfileDetails profileDetail = accountDetails2.getProfileDetail();
                        k.a((Object) profileDetail, "response.accountDetails.profileDetail");
                        if (profileDetail.getBankAccountList() != null) {
                            SignupLinkBankAccountResponse.AccountDetails accountDetails3 = signupLinkBankAccountResponse.getAccountDetails();
                            k.a((Object) accountDetails3, "response.accountDetails");
                            UpiProfileModel.ProfileDetails profileDetail2 = accountDetails3.getProfileDetail();
                            k.a((Object) profileDetail2, "response.accountDetails.profileDetail");
                            if (!profileDetail2.getBankAccountList().isEmpty()) {
                                y a3 = this.f68569a.f68554b;
                                if (a3 != null) {
                                    j.a aVar2 = j.f67003d;
                                    SignupLinkBankAccountResponse.AccountDetails accountDetails4 = signupLinkBankAccountResponse.getAccountDetails();
                                    k.a((Object) accountDetails4, "response.accountDetails");
                                    ArrayList<SignupLinkBankAccountResponse.RefId> newAccountsAdded = accountDetails4.getNewAccountsAdded();
                                    k.a((Object) newAccountsAdded, "response.accountDetails.newAccountsAdded");
                                    SignupLinkBankAccountResponse.AccountDetails accountDetails5 = signupLinkBankAccountResponse.getAccountDetails();
                                    k.a((Object) accountDetails5, "response.accountDetails");
                                    UpiProfileModel.ProfileDetails profileDetail3 = accountDetails5.getProfileDetail();
                                    k.a((Object) profileDetail3, "response.accountDetails.profileDetail");
                                    ArrayList<BankAccountDetails.BankAccount> bankAccountList = profileDetail3.getBankAccountList();
                                    k.a((Object) bankAccountList, "response.accountDetails.…ileDetail.bankAccountList");
                                    a3.setValue(j.a.a((Object) new b(d.a(newAccountsAdded, bankAccountList))));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                UpiCustomVolleyError upiCustomVolleyError2 = new UpiCustomVolleyError();
                upiCustomVolleyError2.setmErrorCode(signupLinkBankAccountResponse.getRespCode());
                upiCustomVolleyError2.setAlertMessage(signupLinkBankAccountResponse.getRespMessage());
                y a4 = this.f68569a.f68554b;
                if (a4 != null) {
                    j.a aVar3 = j.f67003d;
                    a4.setValue(j.a.a(upiCustomVolleyError2));
                    return;
                }
                return;
            }
            y a5 = this.f68569a.f68554b;
            if (a5 != null) {
                j.a aVar4 = j.f67003d;
                a5.setValue(j.a.a((UpiCustomVolleyError) null));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError != null) {
                upiCustomVolleyError.getAlertTitle();
                y a2 = this.f68569a.f68554b;
                if (a2 != null) {
                    j.a aVar = j.f67003d;
                    a2.setValue(j.a.a(upiCustomVolleyError));
                }
            }
        }
    }

    public static final class e implements a.C1389a {
        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
        }

        e() {
        }
    }

    public final void a() {
        net.one97.paytm.upi.profile.b.b bVar = this.f68553a;
        if (bVar != null) {
            bVar.b();
        }
        net.one97.paytm.upi.registration.b.a.b bVar2 = this.f68560h;
        if (bVar2 != null) {
            bVar2.c(new e(), "", "");
        }
        net.one97.paytm.upi.profile.b.b bVar3 = this.f68553a;
        if (bVar3 != null) {
            bVar3.a((a.C1382a) new f(), "", "");
        }
    }

    public static final class f implements a.C1382a {
        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
        }

        f() {
        }
    }

    public static final class c implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f68566a;

        public c(d dVar) {
            this.f68566a = dVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            if (upiBaseDataModel instanceof UpiListBankAccountsResponse) {
                UpiListBankAccountsResponse upiListBankAccountsResponse = (UpiListBankAccountsResponse) upiBaseDataModel;
                if (p.a(upiListBankAccountsResponse.getStatus(), "success", true)) {
                    UpiListBankAccountsResponse.AccountDetails accountDetails = upiListBankAccountsResponse.getAccountDetails();
                    k.a((Object) accountDetails, "response.accountDetails");
                    ArrayList<BankAccountDetails.BankAccount> accounts = accountDetails.getAccounts();
                    k.a((Object) accounts, "response.accountDetails.accounts");
                    if (!accounts.isEmpty()) {
                        y b2 = this.f68566a.f68555c;
                        j.a aVar = j.f67003d;
                        UpiListBankAccountsResponse.AccountDetails accountDetails2 = upiListBankAccountsResponse.getAccountDetails();
                        k.a((Object) accountDetails2, "response.accountDetails");
                        ArrayList<BankAccountDetails.BankAccount> accounts2 = accountDetails2.getAccounts();
                        k.a((Object) accounts2, "response.accountDetails.accounts");
                        b2.setValue(j.a.a((Object) accounts2));
                        return;
                    }
                    return;
                }
                UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                upiCustomVolleyError.setmErrorCode(upiListBankAccountsResponse.getRespCode());
                upiCustomVolleyError.setAlertMessage(upiListBankAccountsResponse.getRespMessage());
                y b3 = this.f68566a.f68555c;
                j.a aVar2 = j.f67003d;
                b3.setValue(j.a.a(upiCustomVolleyError));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            y b2 = this.f68566a.f68555c;
            j.a aVar = j.f67003d;
            if (upiCustomVolleyError == null) {
                upiCustomVolleyError = new UpiCustomVolleyError();
            }
            b2.setValue(j.a.a(upiCustomVolleyError));
        }
    }

    /* renamed from: net.one97.paytm.upi.registration.c.d$d  reason: collision with other inner class name */
    public static final class C1393d implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f68567a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f68568b;

        public C1393d(d dVar, int i2) {
            this.f68567a = dVar;
            this.f68568b = i2;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                if (!baseUpiResponse.isSuccess() || !k.a((Object) baseUpiResponse.getResponse(), (Object) "0")) {
                    y c2 = this.f68567a.f68558f;
                    j.a aVar = j.f67003d;
                    c2.setValue(j.a.a((Object) new a(this.f68568b, false, baseUpiResponse.getResponse())));
                    return;
                }
                y c3 = this.f68567a.f68558f;
                j.a aVar2 = j.f67003d;
                c3.setValue(j.a.a((Object) new a(this.f68568b)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            y c2 = this.f68567a.f68558f;
            j.a aVar = j.f67003d;
            c2.setValue(j.a.a(upiCustomVolleyError));
        }
    }

    public final void onCleared() {
        net.one97.paytm.upi.g.d.b(getApplication()).cancelAll((Object) this.f68557e);
        super.onCleared();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<BankAccountDetails.BankAccount> f68565a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof b) && k.a((Object) this.f68565a, (Object) ((b) obj).f68565a);
            }
            return true;
        }

        public final int hashCode() {
            ArrayList<BankAccountDetails.BankAccount> arrayList = this.f68565a;
            if (arrayList != null) {
                return arrayList.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "LinkedBankModel(linkedBankList=" + this.f68565a + ")";
        }

        public b(ArrayList<BankAccountDetails.BankAccount> arrayList) {
            this.f68565a = arrayList;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f68562a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f68563b;

        /* renamed from: c  reason: collision with root package name */
        public final String f68564c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f68562a == aVar.f68562a && this.f68563b == aVar.f68563b && k.a((Object) this.f68564c, (Object) aVar.f68564c);
        }

        public final int hashCode() {
            int i2 = this.f68562a * 31;
            boolean z = this.f68563b;
            if (z) {
                z = true;
            }
            int i3 = (i2 + (z ? 1 : 0)) * 31;
            String str = this.f68564c;
            return i3 + (str != null ? str.hashCode() : 0);
        }

        public final String toString() {
            return "AccountDeleteResponse(position=" + this.f68562a + ", isSuccess=" + this.f68563b + ", errorCode=" + this.f68564c + ")";
        }

        public a(int i2, boolean z, String str) {
            this.f68562a = i2;
            this.f68563b = z;
            this.f68564c = str;
        }

        public /* synthetic */ a(int i2) {
            this(i2, true, (String) null);
        }
    }

    public static final /* synthetic */ ArrayList a(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            SignupLinkBankAccountResponse.RefId refId = (SignupLinkBankAccountResponse.RefId) it2.next();
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                BankAccountDetails.BankAccount bankAccount = (BankAccountDetails.BankAccount) it3.next();
                k.a((Object) bankAccount, "bankAccount");
                String accRefId = bankAccount.getAccRefId();
                k.a((Object) refId, "refId");
                if (k.a((Object) accRefId, (Object) refId.getAccRefId())) {
                    arrayList3.add(bankAccount);
                }
            }
        }
        return arrayList3;
    }
}
