package net.one97.paytm.moneytransfer.viewmodel;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.google.gsonhtcfix.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import io.reactivex.rxjava3.a.aa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.PPBCurrentAccountModel;
import net.one97.paytm.moneytransfer.model.ContactItemModel;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.p2p.theme.DealsEntity;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountBalanceModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.CJRAccountSummary;
import net.one97.paytm.upi.common.upi.CredentialsData;
import net.one97.paytm.upi.common.upi.GetCredentialsResponse;
import net.one97.paytm.upi.common.upi.UpiCheckBalanceModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiToken;
import net.one97.paytm.upi.common.upi.UserMpinDetails;
import net.one97.paytm.upi.common.upi.ValidateVpaResponse;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.requestmoney.b.a.a;
import net.one97.paytm.upi.util.UpiUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public final class b extends androidx.lifecycle.a implements a.C1347a {
    private net.one97.paytm.upi.requestmoney.b.a.b A;
    private net.one97.paytm.upi.h.a B;
    /* access modifiers changed from: private */
    public final int C;

    /* renamed from: a  reason: collision with root package name */
    public final y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransfer.model.b>> f54676a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f54677b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f54678c;

    /* renamed from: d  reason: collision with root package name */
    public y<String> f54679d;

    /* renamed from: e  reason: collision with root package name */
    public y<String> f54680e;

    /* renamed from: f  reason: collision with root package name */
    public y<String> f54681f;

    /* renamed from: g  reason: collision with root package name */
    public y<String> f54682g;

    /* renamed from: h  reason: collision with root package name */
    public y<ArrayList<UpiProfileDefaultBank>> f54683h;

    /* renamed from: i  reason: collision with root package name */
    public y<ArrayList<UpiProfileDefaultBank>> f54684i;
    public double j = 1.0d;
    public double k = 1000000.0d;
    public double l = 200000.0d;
    public y<net.one97.paytm.moneytransfer.model.c<a>> m;
    net.one97.paytm.upi.registration.b.a.b n;
    public boolean o;
    public final y<net.one97.paytm.moneytransfer.model.c<C0979b>> p = new y<>();
    public y<PPBCurrentAccountModel> q = new y<>();
    public final y<ArrayList<String>> r = new y<>();
    public final ArrayList<String> s = new ArrayList<>();
    public y<net.one97.paytm.moneytransfer.model.c<DealsEntity>> t;
    private net.one97.paytm.moneytransfer.b.a.b u;
    /* access modifiers changed from: private */
    public ArrayList<ContactItemModel> v;
    /* access modifiers changed from: private */
    public ArrayList<ContactItemModel> w;
    private y<Boolean> x;
    private net.one97.paytm.upi.profile.b.b y;
    private net.one97.paytm.moneytransfer.b.a.b z;

    public final void onServiceConnected() {
    }

    public final void onServiceDisconnected() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        kotlin.g.b.k.c(application, "application");
        Context context = application;
        this.u = net.one97.paytm.moneytransfer.b.a(context);
        this.y = net.one97.paytm.upi.g.a();
        this.z = net.one97.paytm.moneytransfer.b.a(context);
        this.B = net.one97.paytm.upi.g.a((a.C1347a) this);
        this.n = net.one97.paytm.upi.g.a(this.B);
        this.A = net.one97.paytm.upi.g.c();
        this.x = new y<>();
        this.f54680e = new y<>();
        this.f54681f = new y<>();
        this.f54679d = new y<>();
        this.f54683h = new y<>();
        this.f54684i = new y<>();
        this.m = new y<>();
        this.f54682g = new y<>();
        this.t = new y<>();
    }

    public final void a() {
        try {
            this.o = true;
            this.f54677b = true;
            net.one97.paytm.moneytransfer.b.a.b bVar = this.u;
            if (bVar != null) {
                bVar.a((net.one97.paytm.moneytransfer.a.a) new f(this));
            }
        } catch (Exception unused) {
        }
    }

    public static final class f implements net.one97.paytm.moneytransfer.a.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54697a;

        f(b bVar) {
            this.f54697a = bVar;
        }

        public final void a(net.one97.paytm.moneytransfer.model.b bVar) {
            if (bVar != null) {
                this.f54697a.o = false;
                y b2 = this.f54697a.f54676a;
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                b2.setValue(c.a.a(bVar));
                this.f54697a.v = bVar.a();
                this.f54697a.w = bVar.b();
            }
        }
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank, String str) {
        kotlin.g.b.k.c(upiProfileDefaultBank, "bankAccountProfile");
        y<net.one97.paytm.moneytransfer.model.c<a>> yVar = this.m;
        if (yVar != null) {
            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
            yVar.setValue(c.a.a());
        }
        BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
        kotlin.g.b.k.a((Object) debitBank, "bankAccountProfile.debitBank");
        if (a(debitBank)) {
            BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank2, "bankAccountProfile.debitBank");
            if (kotlin.g.b.k.a((Object) debitBank2.getAccountType(), (Object) "CURRENT")) {
                net.one97.paytm.upi.profile.b.b bVar = this.y;
                if (bVar != null) {
                    BankAccountDetails.BankAccount debitBank3 = upiProfileDefaultBank.getDebitBank();
                    kotlin.g.b.k.a((Object) debitBank3, "bankAccountProfile.debitBank");
                    debitBank3.getAccount();
                    bVar.a(str, (a.C1382a) new h(this, upiProfileDefaultBank));
                    return;
                }
                return;
            }
            net.one97.paytm.upi.profile.b.b bVar2 = this.y;
            if (bVar2 != null) {
                BankAccountDetails.BankAccount debitBank4 = upiProfileDefaultBank.getDebitBank();
                kotlin.g.b.k.a((Object) debitBank4, "bankAccountProfile.debitBank");
                debitBank4.getAccount();
                bVar2.a((a.C1382a) new i(this, upiProfileDefaultBank));
                return;
            }
            return;
        }
        net.one97.paytm.moneytransfer.b.a.b bVar3 = this.z;
        String str2 = null;
        Boolean valueOf = bVar3 != null ? Boolean.valueOf(bVar3.b()) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        boolean z2 = true;
        if (valueOf.booleanValue()) {
            net.one97.paytm.moneytransfer.b.a.b bVar4 = this.z;
            Boolean valueOf2 = bVar4 != null ? Boolean.valueOf(bVar4.a()) : null;
            if (valueOf2 == null) {
                kotlin.g.b.k.a();
            }
            if (!valueOf2.booleanValue()) {
                y<net.one97.paytm.moneytransfer.model.c<a>> yVar2 = this.m;
                if (yVar2 != null) {
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    yVar2.setValue(c.a.a(new a("", "", "", 1)));
                    return;
                }
                return;
            }
        }
        net.one97.paytm.upi.registration.b.a.b bVar5 = this.n;
        if (bVar5 != null) {
            str2 = bVar5.b();
        }
        CharSequence charSequence = str2;
        if (charSequence != null && !p.a(charSequence)) {
            z2 = false;
        }
        if (z2) {
            a(upiProfileDefaultBank);
            return;
        }
        net.one97.paytm.upi.registration.b.a.b bVar6 = this.n;
        if (bVar6 != null) {
            bVar6.d(new j(this, upiProfileDefaultBank), "", "");
        }
    }

    public static final class h implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54700a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f54701b;

        h(b bVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f54700a = bVar;
            this.f54701b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof CJRAccountSummary) {
                CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                if (cJRAccountSummary.getStatus() == null || !p.a(cJRAccountSummary.getStatus(), "success", true)) {
                    y c2 = this.f54700a.m;
                    if (c2 != null) {
                        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                        c2.setValue(c.a.a(new a("", "", "", 0)));
                        return;
                    }
                    return;
                }
                AccountBalanceModel accountBalanceModel = cJRAccountSummary.getAccounts().get(0);
                y c3 = this.f54700a.m;
                if (c3 != null) {
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    kotlin.g.b.k.a((Object) accountBalanceModel, "savingAccount");
                    String valueOf = String.valueOf(accountBalanceModel.getEffectiveBalance());
                    String valueOf2 = String.valueOf(accountBalanceModel.getEffectiveBalance());
                    BankAccountDetails.BankAccount debitBank = this.f54701b.getDebitBank();
                    kotlin.g.b.k.a((Object) debitBank, "bankAccountProfile.debitBank");
                    String accountType = debitBank.getAccountType();
                    kotlin.g.b.k.a((Object) accountType, "bankAccountProfile.debitBank.accountType");
                    c3.setValue(c.a.a(new a(valueOf, valueOf2, accountType, 0)));
                    return;
                }
                return;
            }
            y c4 = this.f54700a.m;
            if (c4 != null) {
                c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                c4.setValue(c.a.a(new a("", "", "", 0)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            kotlin.g.b.k.c(upiCustomVolleyError, "error");
            y c2 = this.f54700a.m;
            if (c2 != null) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                c2.setValue(c.a.a(upiCustomVolleyError));
            }
        }
    }

    public static final class i implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54702a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f54703b;

        i(b bVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f54702a = bVar;
            this.f54703b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof CJRAccountSummary) {
                CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                if (cJRAccountSummary.getStatus() == null || !p.a(cJRAccountSummary.getStatus(), "success", true)) {
                    y c2 = this.f54702a.m;
                    if (c2 != null) {
                        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                        c2.setValue(c.a.a(new a("", "", "", 0)));
                        return;
                    }
                    return;
                }
                AccountBalanceModel accountBalanceModel = cJRAccountSummary.getAccounts().get(0);
                y c3 = this.f54702a.m;
                if (c3 != null) {
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    kotlin.g.b.k.a((Object) accountBalanceModel, "savingAccount");
                    String valueOf = String.valueOf(accountBalanceModel.getEffectiveBalance());
                    String valueOf2 = String.valueOf(accountBalanceModel.getEffectiveBalance());
                    BankAccountDetails.BankAccount debitBank = this.f54703b.getDebitBank();
                    kotlin.g.b.k.a((Object) debitBank, "bankAccountProfile.debitBank");
                    String accountType = debitBank.getAccountType();
                    kotlin.g.b.k.a((Object) accountType, "bankAccountProfile.debitBank.accountType");
                    c3.setValue(c.a.a(new a(valueOf, valueOf2, accountType, 0)));
                    return;
                }
                return;
            }
            y c4 = this.f54702a.m;
            if (c4 != null) {
                c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                c4.setValue(c.a.a(new a("", "", "", 0)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            kotlin.g.b.k.c(upiCustomVolleyError, "error");
            y c2 = this.f54702a.m;
            if (c2 != null) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                c2.setValue(c.a.a(upiCustomVolleyError));
            }
        }
    }

    public static final class j implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54704a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f54705b;

        j(b bVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f54704a = bVar;
            this.f54705b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiToken) {
                b bVar = this.f54704a;
                String upiToken = ((UpiToken) upiBaseDataModel).getUpiToken();
                kotlin.g.b.k.a((Object) upiToken, "response.upiToken");
                b.a(bVar, upiToken, this.f54705b);
                return;
            }
            y c2 = this.f54704a.m;
            if (c2 != null) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                c2.setValue(c.a.a(new a("", "", "", 2)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError == null || !p.a("1006", upiCustomVolleyError.getAlertTitle(), true)) {
                y c2 = this.f54704a.m;
                if (c2 != null) {
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    c2.setValue(c.a.a(upiCustomVolleyError));
                    return;
                }
                return;
            }
            y c3 = this.f54704a.m;
            if (c3 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                c3.setValue(c.a.a(new a("", "", "", 1)));
            }
        }
    }

    public static final class k implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54706a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f54707b;

        k(b bVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f54706a = bVar;
            this.f54707b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            b bVar = this.f54706a;
            UpiProfileDefaultBank upiProfileDefaultBank = this.f54707b;
            kotlin.g.b.k.c(upiProfileDefaultBank, "bankAccountProfile");
            net.one97.paytm.upi.registration.b.a.b bVar2 = bVar.n;
            if (bVar2 != null) {
                bVar2.d(new g(bVar, upiProfileDefaultBank), "", "");
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError != null) {
                p.a("1006", upiCustomVolleyError.getAlertTitle(), true);
            }
        }
    }

    private void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        kotlin.g.b.k.c(upiProfileDefaultBank, "bankAccountProfile");
        net.one97.paytm.upi.registration.b.a.b bVar = this.n;
        if (bVar != null) {
            bVar.b((a.C1389a) new k(this, upiProfileDefaultBank), "", "");
        }
    }

    public static final class g implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54698a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f54699b;

        g(b bVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f54698a = bVar;
            this.f54699b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiToken) {
                b bVar = this.f54698a;
                String upiToken = ((UpiToken) upiBaseDataModel).getUpiToken();
                kotlin.g.b.k.a((Object) upiToken, "response.upiToken");
                b.a(bVar, upiToken, this.f54699b);
                return;
            }
            y c2 = this.f54698a.m;
            if (c2 != null) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                c2.setValue(c.a.a(new a("", "", "", 2)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError == null || !p.a("1006", upiCustomVolleyError.getAlertTitle(), true)) {
                y c2 = this.f54698a.m;
                if (c2 != null) {
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    c2.setValue(c.a.a(upiCustomVolleyError));
                    return;
                }
                return;
            }
            y c3 = this.f54698a.m;
            if (c3 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                c3.setValue(c.a.a(new a("", "", "", 1)));
            }
        }
    }

    private final void a(List<? extends GetCredentialsResponse> list, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        UserMpinDetails userMpinDetails = new UserMpinDetails();
        for (GetCredentialsResponse getCredentialsResponse : list) {
            if (p.a("MPIN", getCredentialsResponse.getSubtype(), true)) {
                StringBuilder sb = new StringBuilder();
                CredentialsData data = getCredentialsResponse.getData();
                kotlin.g.b.k.a((Object) data, "credential.data");
                sb.append(data.getCode());
                sb.append(AppConstants.COMMA);
                CredentialsData data2 = getCredentialsResponse.getData();
                kotlin.g.b.k.a((Object) data2, "credential.data");
                sb.append(data2.getKi());
                sb.append(AppConstants.COMMA);
                CredentialsData data3 = getCredentialsResponse.getData();
                kotlin.g.b.k.a((Object) data3, "credential.data");
                sb.append(data3.getEncryptedBase64String());
                userMpinDetails.setMpin(sb.toString());
            }
        }
        y<net.one97.paytm.moneytransfer.model.c<a>> yVar = this.m;
        if (yVar != null) {
            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
            yVar.setValue(c.a.a());
        }
        net.one97.paytm.upi.profile.b.b bVar = this.y;
        if (bVar != null) {
            bVar.a(str, userMpinDetails, upiProfileDefaultBank, (a.C1382a) new e(this, upiProfileDefaultBank), "", "");
        }
    }

    public static final class e implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54695a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f54696b;

        e(b bVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f54695a = bVar;
            this.f54696b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                if (!baseUpiResponse.isSuccess() || !kotlin.g.b.k.a((Object) "0", (Object) baseUpiResponse.getResponse())) {
                    String response = baseUpiResponse.getResponse();
                    b bVar = this.f54695a;
                    kotlin.g.b.k.a((Object) response, "res");
                    bVar.b(response);
                    return;
                }
                try {
                    if (((BaseUpiResponse) upiBaseDataModel).getMobileAppData() instanceof UpiCheckBalanceModel) {
                        Object mobileAppData = ((BaseUpiResponse) upiBaseDataModel).getMobileAppData();
                        if (mobileAppData != null) {
                            UpiCheckBalanceModel upiCheckBalanceModel = (UpiCheckBalanceModel) mobileAppData;
                            y c2 = this.f54695a.m;
                            if (c2 != null) {
                                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                                String availableBalance = upiCheckBalanceModel.getAvailableBalance();
                                if (availableBalance == null) {
                                    availableBalance = "";
                                }
                                String totalBal = upiCheckBalanceModel.getTotalBal();
                                if (totalBal == null) {
                                    totalBal = "";
                                }
                                BankAccountDetails.BankAccount debitBank = this.f54696b.getDebitBank();
                                kotlin.g.b.k.a((Object) debitBank, "bankAccount.debitBank");
                                String accountType = debitBank.getAccountType();
                                kotlin.g.b.k.a((Object) accountType, "bankAccount.debitBank.accountType");
                                c2.setValue(c.a.a(new a(availableBalance, totalBal, accountType, 0)));
                                return;
                            }
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.UpiCheckBalanceModel");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                this.f54695a.b("");
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            kotlin.g.b.k.c(upiCustomVolleyError, "error");
            b bVar = this.f54695a;
            String str = upiCustomVolleyError.getmErrorCode();
            kotlin.g.b.k.a((Object) str, "error.getmErrorCode()");
            bVar.b(str);
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str) {
        if (p.a("ZM", str, true)) {
            y<net.one97.paytm.moneytransfer.model.c<a>> yVar = this.m;
            if (yVar != null) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                yVar.setValue(c.a.a(new a("", "", "", 4)));
            }
        } else if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, str, true) || p.a("410", str, true)) {
            y<net.one97.paytm.moneytransfer.model.c<a>> yVar2 = this.m;
            if (yVar2 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                yVar2.setValue(c.a.a(new a("", "", "", 3)));
            }
        } else {
            y<net.one97.paytm.moneytransfer.model.c<a>> yVar3 = this.m;
            if (yVar3 != null) {
                c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                yVar3.setValue(c.a.a(new a("", "", "", 5)));
            }
        }
    }

    public final void a(String str, String str2) {
        kotlin.g.b.k.c(str, "vpa");
        kotlin.g.b.k.c(str2, "intentData");
        y<net.one97.paytm.moneytransfer.model.c<C0979b>> yVar = this.p;
        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar.setValue(c.a.a());
        if (com.paytm.utility.a.m(getApplication())) {
            net.one97.paytm.upi.requestmoney.b.a.b bVar = this.A;
            if (bVar != null) {
                bVar.b(new l(this), "", str, str2, "");
                return;
            }
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setAlertMessage("We can not detect any internet connectivity. Please check your internet connection and try again.");
        upiCustomVolleyError.setmAlertTitle("No Internet Connection");
        y<net.one97.paytm.moneytransfer.model.c<C0979b>> yVar2 = this.p;
        c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar2.setValue(c.a.a(upiCustomVolleyError));
    }

    public static final class l implements a.C1402a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54708a;

        l(b bVar) {
            this.f54708a = bVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof ValidateVpaResponse) {
                ValidateVpaResponse validateVpaResponse = (ValidateVpaResponse) upiBaseDataModel;
                String respCode = validateVpaResponse.getRespCode();
                if (respCode == null) {
                    respCode = "";
                }
                if (p.a(validateVpaResponse.getStatus(), "success", true) && p.a("0", respCode, true)) {
                    String name = validateVpaResponse.getName();
                    if (name == null) {
                        name = "";
                    }
                    if (!TextUtils.isEmpty(name)) {
                        y e2 = this.f54708a.p;
                        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                        String signStatus = validateVpaResponse.getSignStatus();
                        if (signStatus == null) {
                            signStatus = "";
                        }
                        e2.setValue(c.a.a(new C0979b(0, name, "", signStatus)));
                        return;
                    }
                    y e3 = this.f54708a.p;
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    e3.setValue(c.a.a(new C0979b(1, name, respCode, "")));
                } else if ("37".equals(respCode)) {
                    y e4 = this.f54708a.p;
                    c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    e4.setValue(c.a.a(new C0979b(1, "", respCode, "")));
                } else {
                    y e5 = this.f54708a.p;
                    c.a aVar4 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    e5.setValue(c.a.a(new C0979b(2, "", respCode, "")));
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            kotlin.g.b.k.c(upiCustomVolleyError, "error");
            y e2 = this.f54708a.p;
            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
            e2.setValue(c.a.a(upiCustomVolleyError));
        }
    }

    private static boolean a(BankAccountDetails.BankAccount bankAccount) {
        kotlin.g.b.k.c(bankAccount, "bankAccount");
        String ifsc = bankAccount.getIfsc();
        kotlin.g.b.k.a((Object) ifsc, "bankAccount.ifsc");
        return p.a((CharSequence) ifsc, (CharSequence) "PYTM", false);
    }

    public final void a(boolean z2) {
        this.f54678c = Boolean.valueOf(z2);
    }

    public final y<String> b() {
        y<String> yVar = this.f54679d;
        if (yVar == null) {
            kotlin.g.b.k.a();
        }
        return yVar;
    }

    public final y<ArrayList<UpiProfileDefaultBank>> c() {
        y<ArrayList<UpiProfileDefaultBank>> yVar = this.f54683h;
        if (yVar == null) {
            kotlin.g.b.k.a();
        }
        return yVar;
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "accNo");
        y<String> yVar = this.f54680e;
        if (yVar != null) {
            yVar.setValue(str);
        }
    }

    public static final class c<V> implements Callable<DealsEntity> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54693a;

        public c(b bVar) {
            this.f54693a = bVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public DealsEntity call() {
            net.one97.paytm.upi.f.a g2;
            try {
                net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
                if (a2 == null || (g2 = a2.g()) == null) {
                    return null;
                }
                Application application = this.f54693a.getApplication();
                kotlin.g.b.k.a((Object) application, "getApplication()");
                return g2.b(application);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static final class d implements aa<DealsEntity> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f54694a;

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            kotlin.g.b.k.c(cVar, "d");
        }

        public d(b bVar) {
            this.f54694a = bVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            DealsEntity dealsEntity = (DealsEntity) obj;
            if (dealsEntity != null) {
                y f2 = this.f54694a.t;
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                f2.setValue(c.a.a(dealsEntity));
            }
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f54685a;

        /* renamed from: b  reason: collision with root package name */
        public final String f54686b;

        /* renamed from: c  reason: collision with root package name */
        public final String f54687c;

        /* renamed from: d  reason: collision with root package name */
        public final Integer f54688d;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.g.b.k.a((Object) this.f54685a, (Object) aVar.f54685a) && kotlin.g.b.k.a((Object) this.f54686b, (Object) aVar.f54686b) && kotlin.g.b.k.a((Object) this.f54687c, (Object) aVar.f54687c) && kotlin.g.b.k.a((Object) this.f54688d, (Object) aVar.f54688d);
        }

        public final int hashCode() {
            String str = this.f54685a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f54686b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f54687c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Integer num = this.f54688d;
            if (num != null) {
                i2 = num.hashCode();
            }
            return hashCode3 + i2;
        }

        public final String toString() {
            return "UPICheckBalModel(availableBal=" + this.f54685a + ", totalBal=" + this.f54686b + ", accountType=" + this.f54687c + ", result=" + this.f54688d + ")";
        }

        public a(String str, String str2, String str3, Integer num) {
            kotlin.g.b.k.c(str, "availableBal");
            kotlin.g.b.k.c(str2, "totalBal");
            kotlin.g.b.k.c(str3, "accountType");
            this.f54685a = str;
            this.f54686b = str2;
            this.f54687c = str3;
            this.f54688d = num;
        }
    }

    /* renamed from: net.one97.paytm.moneytransfer.viewmodel.b$b  reason: collision with other inner class name */
    public static final class C0979b {

        /* renamed from: a  reason: collision with root package name */
        public final int f54689a;

        /* renamed from: b  reason: collision with root package name */
        public String f54690b;

        /* renamed from: c  reason: collision with root package name */
        public final String f54691c;

        /* renamed from: d  reason: collision with root package name */
        public final String f54692d;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0979b)) {
                return false;
            }
            C0979b bVar = (C0979b) obj;
            return this.f54689a == bVar.f54689a && kotlin.g.b.k.a((Object) this.f54690b, (Object) bVar.f54690b) && kotlin.g.b.k.a((Object) this.f54691c, (Object) bVar.f54691c) && kotlin.g.b.k.a((Object) this.f54692d, (Object) bVar.f54692d);
        }

        public final int hashCode() {
            int i2 = this.f54689a * 31;
            String str = this.f54690b;
            int i3 = 0;
            int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f54691c;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f54692d;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return hashCode2 + i3;
        }

        public final String toString() {
            return "UPIVpaVerifyModel(code=" + this.f54689a + ", name=" + this.f54690b + ", errorCode=" + this.f54691c + ", signStatus=" + this.f54692d + ")";
        }

        public C0979b(int i2, String str, String str2, String str3) {
            kotlin.g.b.k.c(str, "name");
            kotlin.g.b.k.c(str2, CLConstants.FIELD_ERROR_CODE);
            kotlin.g.b.k.c(str3, "signStatus");
            this.f54689a = i2;
            this.f54690b = str;
            this.f54691c = str2;
            this.f54692d = str3;
        }
    }

    public static final /* synthetic */ void a(b bVar, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        String upiSequenceNo = UpiUtils.getUpiSequenceNo();
        try {
            net.one97.paytm.upi.h.a aVar = bVar.B;
            if (aVar != null) {
                aVar.a(upiSequenceNo, "", str, 0, upiProfileDefaultBank.getDebitBank(), new CLRemoteResultReceiver(new MoneyTransferActivityViewModel$getBalanceCredentials$1(bVar, upiSequenceNo, upiProfileDefaultBank, new Handler())));
            }
        } catch (IllegalStateException unused) {
            bVar.b("");
        }
    }

    public static final /* synthetic */ void a(b bVar, int i2, Bundle bundle, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        String string = bundle.getString("error");
        if (string != null) {
            if (!(string.length() == 0)) {
                try {
                    y<net.one97.paytm.moneytransfer.model.c<a>> yVar = bVar.m;
                    if (yVar != null) {
                        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                        yVar.setValue(c.a.c());
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
        Serializable serializable = bundle.getSerializable("credBlocks");
        if (serializable != null) {
            HashMap hashMap = (HashMap) serializable;
            ArrayList arrayList = new ArrayList();
            for (String str2 : hashMap.keySet()) {
                try {
                    GetCredentialsResponse getCredentialsResponse = (GetCredentialsResponse) new com.google.gsonhtcfix.f().a((String) hashMap.get(str2), GetCredentialsResponse.class);
                    kotlin.g.b.k.a((Object) getCredentialsResponse, "getCredentialsResponse");
                    getCredentialsResponse.setSubtype(str2);
                    arrayList.add(getCredentialsResponse);
                } catch (v e3) {
                    e3.printStackTrace();
                }
            }
            if (i2 == bVar.C) {
                bVar.a((List<? extends GetCredentialsResponse>) arrayList, str, upiProfileDefaultBank);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
    }
}
