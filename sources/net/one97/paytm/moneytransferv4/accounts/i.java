package net.one97.paytm.moneytransferv4.accounts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.moneytransferv4.PaymentManager;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.b.a;

public class i extends ai {
    public static final b k = new b((byte) 0);
    private static final String p;

    /* renamed from: a  reason: collision with root package name */
    protected final y<net.one97.paytm.moneytransfer.model.c<List<BankAccountDetails.BankAccount>>> f54964a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final LiveData<net.one97.paytm.moneytransfer.model.c<List<BankAccountDetails.BankAccount>>> f54965b = this.f54964a;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public final y<a> f54966c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    final String f54967d = "self accounts tag";

    /* renamed from: e  reason: collision with root package name */
    public final LiveData<net.one97.paytm.moneytransfer.model.c<d>> f54968e = this.m;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public final y<net.one97.paytm.moneytransfer.model.c<UserUpiDetails>> f54969f = new y<>();
    /* access modifiers changed from: package-private */

    /* renamed from: g  reason: collision with root package name */
    public String f54970g = "";

    /* renamed from: h  reason: collision with root package name */
    boolean f54971h;

    /* renamed from: i  reason: collision with root package name */
    public BankAccountDetails.BankAccount f54972i;
    final net.one97.paytm.upi.profile.b.a j;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public final y<net.one97.paytm.moneytransfer.model.c<d>> m = new y<>();
    /* access modifiers changed from: private */
    public boolean n;
    private final net.one97.paytm.upi.registration.b.a.a o;

    public i(net.one97.paytm.upi.profile.b.a aVar, net.one97.paytm.upi.registration.b.a.a aVar2) {
        k.c(aVar, "profileRepository");
        k.c(aVar2, "registrationRepository");
        this.j = aVar;
        this.o = aVar2;
    }

    public final String a() {
        String str = this.l;
        return str == null ? "" : str;
    }

    public final BankAccountDetails.BankAccount b() {
        BankAccountDetails.BankAccount bankAccount = this.f54972i;
        if (bankAccount == null) {
            k.a("selectedBankAccount");
        }
        return bankAccount;
    }

    public static final class e implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f54984a;

        e(i iVar) {
            this.f54984a = iVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:48:0x01a5, code lost:
            if (r10.booleanValue() != false) goto L_0x01a7;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSuccess(net.one97.paytm.upi.common.UpiBaseDataModel r13) {
            /*
                r12 = this;
                java.lang.String r0 = "response"
                kotlin.g.b.k.c(r13, r0)
                boolean r0 = r13 instanceof net.one97.paytm.upi.common.upi.UpiProfileModel
                if (r0 == 0) goto L_0x022e
                net.one97.paytm.upi.common.upi.UpiProfileModel r13 = (net.one97.paytm.upi.common.upi.UpiProfileModel) r13
                java.lang.String r0 = r13.getRespCode()
                java.lang.String r1 = "0"
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
                if (r0 == 0) goto L_0x022e
                java.lang.String r0 = r13.getStatus()
                r1 = 1
                java.lang.String r2 = "SUCCESS"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
                if (r0 == 0) goto L_0x022e
                net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r0 = r13.getResponse()
                if (r0 == 0) goto L_0x022e
                net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r0 = r13.getResponse()
                java.lang.String r2 = "response.response"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                net.one97.paytm.upi.common.upi.UpiProfileModel$ProfileDetails r0 = r0.getProfileDetail()
                java.lang.String r3 = "response.response.profileDetail"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
                java.util.ArrayList r0 = r0.getBankAccountList()
                java.util.Collection r0 = (java.util.Collection) r0
                r4 = 0
                if (r0 == 0) goto L_0x004e
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x004c
                goto L_0x004e
            L_0x004c:
                r0 = 0
                goto L_0x004f
            L_0x004e:
                r0 = 1
            L_0x004f:
                if (r0 != 0) goto L_0x022e
                net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r0 = r13.getResponse()
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                net.one97.paytm.upi.common.upi.UpiProfileModel$ProfileDetails r0 = r0.getProfileDetail()
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
                java.util.List r0 = r0.getProfileVpaList()
                java.util.Collection r0 = (java.util.Collection) r0
                if (r0 == 0) goto L_0x0070
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x006e
                goto L_0x0070
            L_0x006e:
                r0 = 0
                goto L_0x0071
            L_0x0070:
                r0 = 1
            L_0x0071:
                if (r0 != 0) goto L_0x022e
                net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r0 = r13.getResponse()
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                net.one97.paytm.upi.common.upi.UpiProfileModel$ProfileDetails r0 = r0.getProfileDetail()
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
                java.util.List r0 = r0.getProfileVpaList()
                java.lang.String r5 = "response.response.profileDetail.profileVpaList"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.Iterator r0 = r0.iterator()
            L_0x0090:
                boolean r5 = r0.hasNext()
                if (r5 == 0) goto L_0x00a9
                java.lang.Object r5 = r0.next()
                r6 = r5
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r6 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r6
                java.lang.String r7 = "it"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
                boolean r6 = r6.isPrimary()
                if (r6 == 0) goto L_0x0090
                goto L_0x00aa
            L_0x00a9:
                r5 = 0
            L_0x00aa:
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r5 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r5
                java.lang.String r0 = ""
                if (r5 == 0) goto L_0x00cc
                net.one97.paytm.moneytransferv4.accounts.i r6 = r12.f54984a
                java.lang.String r7 = r5.getVirtualAddress()
                r6.l = r7
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r5 = r5.getDebitBank()
                java.lang.String r6 = "it.debitBank"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
                java.lang.String r5 = r5.getAccRefId()
                java.lang.String r6 = "it.debitBank.accRefId"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
                goto L_0x00cd
            L_0x00cc:
                r5 = r0
            L_0x00cd:
                net.one97.paytm.moneytransferv4.accounts.i r6 = r12.f54984a
                java.lang.String r6 = r6.l
                if (r6 != 0) goto L_0x0128
                net.one97.paytm.moneytransferv4.accounts.i r5 = r12.f54984a
                net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r6 = r13.getResponse()
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
                net.one97.paytm.upi.common.upi.UpiProfileModel$ProfileDetails r6 = r6.getProfileDetail()
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
                java.util.List r6 = r6.getProfileVpaList()
                java.lang.Object r6 = r6.get(r4)
                java.lang.String r7 = "response.response.profileDetail.profileVpaList[0]"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r6 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r6
                java.lang.String r6 = r6.getVirtualAddress()
                r5.l = r6
                net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r5 = r13.getResponse()
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
                net.one97.paytm.upi.common.upi.UpiProfileModel$ProfileDetails r5 = r5.getProfileDetail()
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)
                java.util.List r5 = r5.getProfileVpaList()
                java.lang.Object r5 = r5.get(r4)
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r5 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r5
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r5 = r5.getDebitBank()
                java.lang.String r6 = "response.response.profil…ofileVpaList[0].debitBank"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
                java.lang.String r5 = r5.getAccRefId()
                java.lang.String r6 = "response.response.profil…ist[0].debitBank.accRefId"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            L_0x0128:
                net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r13 = r13.getResponse()
                kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r2)
                net.one97.paytm.upi.common.upi.UpiProfileModel$ProfileDetails r13 = r13.getProfileDetail()
                kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
                java.util.ArrayList r13 = r13.getBankAccountList()
                java.lang.String r2 = "list"
                kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r2)
                r2 = r13
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                java.util.Iterator r2 = r2.iterator()
                r3 = -1
                r6 = 0
                r7 = -1
            L_0x0149:
                boolean r8 = r2.hasNext()
                if (r8 == 0) goto L_0x01b9
                java.lang.Object r8 = r2.next()
                int r9 = r6 + 1
                if (r6 >= 0) goto L_0x015a
                kotlin.a.k.a()
            L_0x015a:
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r8 = (net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount) r8
                java.lang.String r10 = "bankAccount"
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
                java.lang.String r10 = r8.getAccRefId()
                boolean r10 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r5)
                java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
                r8.setPrimaryAccount(r10)
                r8.setSelected(r4)
                net.one97.paytm.moneytransferv4.accounts.i r10 = r12.f54984a
                java.lang.String r10 = r10.f54970g
                java.lang.String r11 = r8.getAccRefId()
                boolean r10 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r11)
                if (r10 == 0) goto L_0x0184
                goto L_0x01a7
            L_0x0184:
                net.one97.paytm.moneytransferv4.accounts.i r10 = r12.f54984a
                java.lang.String r10 = r10.f54970g
                boolean r10 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r0)
                java.lang.String r11 = "bankAccount.primaryAccount"
                if (r10 == 0) goto L_0x01aa
                net.one97.paytm.moneytransferv4.accounts.i r10 = r12.f54984a
                boolean r10 = r10.n
                if (r10 != 0) goto L_0x01aa
                java.lang.Boolean r10 = r8.getPrimaryAccount()
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto L_0x01aa
            L_0x01a7:
                r3 = r6
            L_0x01a8:
                r6 = r9
                goto L_0x0149
            L_0x01aa:
                java.lang.Boolean r8 = r8.getPrimaryAccount()
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r11)
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L_0x01a8
                r7 = r6
                goto L_0x01a8
            L_0x01b9:
                if (r3 >= 0) goto L_0x01c7
                net.one97.paytm.moneytransferv4.accounts.i r2 = r12.f54984a
                boolean r2 = r2.n
                if (r2 != 0) goto L_0x01c7
                if (r7 < 0) goto L_0x01c7
                r3 = r7
                goto L_0x01dc
            L_0x01c7:
                if (r3 >= 0) goto L_0x01dc
                net.one97.paytm.moneytransferv4.accounts.i r2 = r12.f54984a
                boolean r2 = r2.n
                if (r2 == 0) goto L_0x01dc
                net.one97.paytm.moneytransferv4.accounts.i r2 = r12.f54984a
                androidx.lifecycle.y r2 = r2.f54966c
                net.one97.paytm.moneytransferv4.accounts.i$a$a r4 = net.one97.paytm.moneytransferv4.accounts.i.a.C0994a.f54973a
                r2.setValue(r4)
            L_0x01dc:
                if (r3 < 0) goto L_0x0203
                java.lang.Object r2 = r13.get(r3)
                java.lang.String r4 = "list.get(foundIndex)"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = (net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount) r2
                r2.setSelected(r1)
                net.one97.paytm.moneytransferv4.accounts.i r1 = r12.f54984a
                java.lang.Object r2 = r13.get(r3)
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = (net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount) r2
                java.lang.String r2 = r2.getAccRefId()
                java.lang.String r3 = "list.get(foundIndex).accRefId"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                r1.f54970g = r2
            L_0x0203:
                net.one97.paytm.moneytransferv4.accounts.i r1 = r12.f54984a
                androidx.lifecycle.y<net.one97.paytm.moneytransfer.model.c<java.util.List<net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount>>> r1 = r1.f54964a
                net.one97.paytm.moneytransfer.model.c$a r2 = net.one97.paytm.moneytransfer.model.c.f54031e
                net.one97.paytm.moneytransfer.model.c r2 = net.one97.paytm.moneytransfer.model.c.a.a(r13)
                r1.setValue(r2)
                boolean r13 = r13.isEmpty()
                if (r13 != 0) goto L_0x021e
                net.one97.paytm.moneytransferv4.accounts.i r13 = r12.f54984a
                boolean r13 = r13.n
                if (r13 == 0) goto L_0x022e
            L_0x021e:
                net.one97.paytm.moneytransferv4.accounts.i r13 = r12.f54984a
                r13.f54970g = r0
                net.one97.paytm.moneytransferv4.accounts.i r13 = r12.f54984a
                androidx.lifecycle.y r13 = r13.f54966c
                net.one97.paytm.moneytransferv4.accounts.i$a$a r0 = net.one97.paytm.moneytransferv4.accounts.i.a.C0994a.f54973a
                r13.setValue(r0)
            L_0x022e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.accounts.i.e.onSuccess(net.one97.paytm.upi.common.UpiBaseDataModel):void");
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            y<net.one97.paytm.moneytransfer.model.c<List<BankAccountDetails.BankAccount>>> yVar = this.f54984a.f54964a;
            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
            yVar.setValue(c.a.a(upiCustomVolleyError));
        }
    }

    public final void c() {
        y<net.one97.paytm.moneytransfer.model.c<List<BankAccountDetails.BankAccount>>> yVar = this.f54964a;
        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar.setValue(c.a.a());
        this.j.a(new e(this), this.f54967d, "");
    }

    public final boolean d() {
        return this.o.g();
    }

    public final void a(String str, BankAccountDetails.BankAccount bankAccount) {
        k.c(str, "vpa");
        k.c(bankAccount, "bankAccount");
        y<net.one97.paytm.moneytransfer.model.c<d>> yVar = this.m;
        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar.setValue(c.a.a());
        this.j.a(new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, str).setBankAccountList(kotlin.a.k.a(bankAccount)).setSelectedBankIdx(0).build(), new d(this), this.f54967d, "");
    }

    public static final class d implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f54983a;

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        }

        d(i iVar) {
            this.f54983a = iVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                if (!baseUpiResponse.isSuccess() || !k.a((Object) baseUpiResponse.getResponse(), (Object) "0")) {
                    y e2 = this.f54983a.m;
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    String response = baseUpiResponse.getResponse();
                    String message = baseUpiResponse.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    e2.setValue(c.a.a(new d(false, response, message)));
                    return;
                }
                y e3 = this.f54983a.m;
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                e3.setValue(c.a.a(new d()));
            }
        }
    }

    public static final class c implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f54981a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserUpiDetails f54982b;

        c(i iVar, UserUpiDetails userUpiDetails) {
            this.f54981a = iVar;
            this.f54982b = userUpiDetails;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                if (!baseUpiResponse.isSuccess() || !k.a((Object) "0", (Object) baseUpiResponse.getResponse())) {
                    UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                    upiCustomVolleyError.setmAlertTitle(baseUpiResponse.getMessage());
                    y f2 = this.f54981a.f54969f;
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    f2.setValue(c.a.a(upiCustomVolleyError));
                    return;
                }
                y f3 = this.f54981a.f54969f;
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                f3.setValue(c.a.a(this.f54982b));
                return;
            }
            y f4 = this.f54981a.f54969f;
            c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
            f4.setValue(c.a.a(new UpiCustomVolleyError()));
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            y f2 = this.f54981a.f54969f;
            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
            f2.setValue(c.a.a(upiCustomVolleyError));
        }
    }

    public void onCleared() {
        this.j.a(this.f54967d);
        super.onCleared();
    }

    public final void a(String str) {
        List list;
        BankAccountDetails.BankAccount bankAccount;
        List list2;
        BankAccountDetails.BankAccount bankAccount2;
        net.one97.paytm.moneytransfer.model.c value;
        List list3;
        BankAccountDetails.BankAccount bankAccount3;
        net.one97.paytm.moneytransfer.model.c value2;
        List list4;
        BankAccountDetails.BankAccount bankAccount4;
        k.c(str, "refId");
        try {
            if (!k.a((Object) str, (Object) this.f54970g)) {
                if ((!k.a((Object) this.f54970g, (Object) "")) && k.a((Object) str, (Object) "")) {
                    int b2 = b(this.f54970g);
                    if (!(b2 == -1 || (value2 = this.f54964a.getValue()) == null || (list4 = (List) value2.f54033b) == null || (bankAccount4 = (BankAccountDetails.BankAccount) list4.get(b2)) == null)) {
                        bankAccount4.setSelected(false);
                    }
                    this.f54966c.setValue(a.C0994a.f54973a);
                    this.f54964a.postValue(this.f54964a.getValue());
                    this.n = true;
                } else if (!k.a((Object) this.f54970g, (Object) "") || !(!k.a((Object) str, (Object) ""))) {
                    int b3 = b(this.f54970g);
                    net.one97.paytm.moneytransfer.model.c value3 = this.f54964a.getValue();
                    if (!(value3 == null || (list2 = (List) value3.f54033b) == null || (bankAccount2 = (BankAccountDetails.BankAccount) list2.get(b3)) == null)) {
                        bankAccount2.setSelected(false);
                    }
                    int b4 = b(str);
                    net.one97.paytm.moneytransfer.model.c value4 = this.f54964a.getValue();
                    if (!(value4 == null || (list = (List) value4.f54033b) == null || (bankAccount = (BankAccountDetails.BankAccount) list.get(b4)) == null)) {
                        bankAccount.setSelected(true);
                    }
                    this.f54964a.postValue(this.f54964a.getValue());
                } else {
                    int b5 = b(str);
                    if (!(b5 == -1 || (value = this.f54964a.getValue()) == null || (list3 = (List) value.f54033b) == null || (bankAccount3 = (BankAccountDetails.BankAccount) list3.get(b5)) == null)) {
                        bankAccount3.setSelected(true);
                    }
                    this.f54966c.setValue(a.b.f54974a);
                    this.f54964a.postValue(this.f54964a.getValue());
                    this.n = false;
                }
                this.f54970g = str;
            }
        } catch (Exception e2) {
            PaytmLogs.e(p, "OnBankSelectionChanged", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final int b(String str) {
        List list;
        net.one97.paytm.moneytransfer.model.c value = this.f54964a.getValue();
        if (value == null || (list = (List) value.f54033b) == null) {
            return -1;
        }
        int i2 = 0;
        for (Object next : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.k.a();
            }
            if (k.a((Object) ((BankAccountDetails.BankAccount) next).getAccRefId(), (Object) str)) {
                return i2;
            }
            i2 = i3;
        }
        return -1;
    }

    public static abstract class a {

        /* renamed from: net.one97.paytm.moneytransferv4.accounts.i$a$a  reason: collision with other inner class name */
        public static final class C0994a extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0994a f54973a = new C0994a();

            private C0994a() {
                super((byte) 0);
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static final class b extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final b f54974a = new b();

            private b() {
                super((byte) 0);
            }
        }

        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final c f54975a = new c();

            private c() {
                super((byte) 0);
            }
        }

        public static final class d extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final d f54976a = new d();

            private d() {
                super((byte) 0);
            }
        }

        public static final class f extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final f f54980a = new f();

            private f() {
                super((byte) 0);
            }
        }

        public static final class e extends a {

            /* renamed from: a  reason: collision with root package name */
            final BankAccountDetails.BankAccount f54977a;

            /* renamed from: b  reason: collision with root package name */
            final String f54978b;

            /* renamed from: c  reason: collision with root package name */
            final PaymentManager.PaymentUiModel f54979c;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return k.a((Object) this.f54977a, (Object) eVar.f54977a) && k.a((Object) this.f54978b, (Object) eVar.f54978b) && k.a((Object) this.f54979c, (Object) eVar.f54979c);
            }

            public final int hashCode() {
                BankAccountDetails.BankAccount bankAccount = this.f54977a;
                int i2 = 0;
                int hashCode = (bankAccount != null ? bankAccount.hashCode() : 0) * 31;
                String str = this.f54978b;
                int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
                PaymentManager.PaymentUiModel paymentUiModel = this.f54979c;
                if (paymentUiModel != null) {
                    i2 = paymentUiModel.hashCode();
                }
                return hashCode2 + i2;
            }

            public final String toString() {
                return "OnBankSelectionConfirmed(bankAccount=" + this.f54977a + ", vpa=" + this.f54978b + ", bankUiModel=" + this.f54979c + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(BankAccountDetails.BankAccount bankAccount, String str, PaymentManager.PaymentUiModel paymentUiModel) {
                super((byte) 0);
                k.c(str, "vpa");
                k.c(paymentUiModel, "bankUiModel");
                this.f54977a = bankAccount;
                this.f54978b = str;
                this.f54979c = paymentUiModel;
            }
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        String canonicalName = i.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "";
        }
        p = canonicalName;
    }
}
