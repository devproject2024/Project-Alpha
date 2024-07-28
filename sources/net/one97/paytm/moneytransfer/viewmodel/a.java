package net.one97.paytm.moneytransfer.viewmodel;

import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.google.gsonhtcfix.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.moneytransfer.viewmodel.b;
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
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.util.UpiUtils;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public final class a extends androidx.lifecycle.a implements a.C1347a {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.upi.registration.b.a.b f54658a;

    /* renamed from: b  reason: collision with root package name */
    public y<net.one97.paytm.moneytransfer.model.c<b.a>> f54659b = new y<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f54660c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.upi.h.a f54661d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.upi.profile.b.b f54662e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.moneytransfer.b.a.b f54663f;

    public final void onServiceConnected() {
    }

    public final void onServiceDisconnected() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
        this.f54663f = net.one97.paytm.moneytransfer.b.a(application);
        this.f54658a = g.a(this.f54661d);
        this.f54661d = g.a((a.C1347a) this);
        this.f54662e = g.a();
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank, String str) {
        k.c(upiProfileDefaultBank, "bankAccountProfile");
        y<net.one97.paytm.moneytransfer.model.c<b.a>> yVar = this.f54659b;
        if (yVar != null) {
            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
            yVar.setValue(c.a.a());
        }
        BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
        k.a((Object) debitBank, "bankAccountProfile.debitBank");
        if (a(debitBank)) {
            BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank.getDebitBank();
            k.a((Object) debitBank2, "bankAccountProfile.debitBank");
            if (k.a((Object) debitBank2.getAccountType(), (Object) "CURRENT")) {
                net.one97.paytm.upi.profile.b.b bVar = this.f54662e;
                if (bVar != null) {
                    BankAccountDetails.BankAccount debitBank3 = upiProfileDefaultBank.getDebitBank();
                    k.a((Object) debitBank3, "bankAccountProfile.debitBank");
                    debitBank3.getAccount();
                    bVar.a(str, (a.C1382a) new c(this, upiProfileDefaultBank));
                    return;
                }
                return;
            }
            net.one97.paytm.upi.profile.b.b bVar2 = this.f54662e;
            if (bVar2 != null) {
                BankAccountDetails.BankAccount debitBank4 = upiProfileDefaultBank.getDebitBank();
                k.a((Object) debitBank4, "bankAccountProfile.debitBank");
                debitBank4.getAccount();
                bVar2.a((a.C1382a) new d(this, upiProfileDefaultBank));
                return;
            }
            return;
        }
        net.one97.paytm.moneytransfer.b.a.b bVar3 = this.f54663f;
        String str2 = null;
        Boolean valueOf = bVar3 != null ? Boolean.valueOf(bVar3.b()) : null;
        if (valueOf == null) {
            k.a();
        }
        boolean z = true;
        if (valueOf.booleanValue()) {
            net.one97.paytm.moneytransfer.b.a.b bVar4 = this.f54663f;
            Boolean valueOf2 = bVar4 != null ? Boolean.valueOf(bVar4.a()) : null;
            if (valueOf2 == null) {
                k.a();
            }
            if (!valueOf2.booleanValue()) {
                y<net.one97.paytm.moneytransfer.model.c<b.a>> yVar2 = this.f54659b;
                if (yVar2 != null) {
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    yVar2.setValue(c.a.a(new b.a("", "", "", 1)));
                    return;
                }
                return;
            }
        }
        net.one97.paytm.upi.registration.b.a.b bVar5 = this.f54658a;
        if (bVar5 != null) {
            str2 = bVar5.b();
        }
        CharSequence charSequence = str2;
        if (charSequence != null && !p.a(charSequence)) {
            z = false;
        }
        if (z) {
            a(upiProfileDefaultBank);
            return;
        }
        net.one97.paytm.upi.registration.b.a.b bVar6 = this.f54658a;
        if (bVar6 != null) {
            bVar6.d(new e(this, upiProfileDefaultBank), "", "");
        }
    }

    public static final class c implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54668a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f54669b;

        c(a aVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f54668a = aVar;
            this.f54669b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof CJRAccountSummary) {
                CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                if (cJRAccountSummary.getStatus() == null || !p.a(cJRAccountSummary.getStatus(), "success", true)) {
                    y a2 = this.f54668a.f54659b;
                    if (a2 != null) {
                        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                        a2.setValue(c.a.a(new b.a("", "", "", 0)));
                        return;
                    }
                    return;
                }
                AccountBalanceModel accountBalanceModel = cJRAccountSummary.getAccounts().get(0);
                y a3 = this.f54668a.f54659b;
                if (a3 != null) {
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    k.a((Object) accountBalanceModel, "savingAccount");
                    String valueOf = String.valueOf(accountBalanceModel.getEffectiveBalance());
                    String valueOf2 = String.valueOf(accountBalanceModel.getEffectiveBalance());
                    BankAccountDetails.BankAccount debitBank = this.f54669b.getDebitBank();
                    k.a((Object) debitBank, "bankAccountProfile.debitBank");
                    String accountType = debitBank.getAccountType();
                    k.a((Object) accountType, "bankAccountProfile.debitBank.accountType");
                    a3.setValue(c.a.a(new b.a(valueOf, valueOf2, accountType, 0)));
                    return;
                }
                return;
            }
            y a4 = this.f54668a.f54659b;
            if (a4 != null) {
                c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                a4.setValue(c.a.a(new b.a("", "", "", 0)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            y a2 = this.f54668a.f54659b;
            if (a2 != null) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                a2.setValue(c.a.a(upiCustomVolleyError));
            }
        }
    }

    public static final class d implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54670a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f54671b;

        d(a aVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f54670a = aVar;
            this.f54671b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof CJRAccountSummary) {
                CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                if (cJRAccountSummary.getStatus() == null || !p.a(cJRAccountSummary.getStatus(), "success", true)) {
                    y a2 = this.f54670a.f54659b;
                    if (a2 != null) {
                        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                        a2.setValue(c.a.a(new b.a("", "", "", 0)));
                        return;
                    }
                    return;
                }
                AccountBalanceModel accountBalanceModel = cJRAccountSummary.getAccounts().get(0);
                y a3 = this.f54670a.f54659b;
                if (a3 != null) {
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    k.a((Object) accountBalanceModel, "savingAccount");
                    String valueOf = String.valueOf(accountBalanceModel.getEffectiveBalance());
                    String valueOf2 = String.valueOf(accountBalanceModel.getEffectiveBalance());
                    BankAccountDetails.BankAccount debitBank = this.f54671b.getDebitBank();
                    k.a((Object) debitBank, "bankAccountProfile.debitBank");
                    String accountType = debitBank.getAccountType();
                    k.a((Object) accountType, "bankAccountProfile.debitBank.accountType");
                    a3.setValue(c.a.a(new b.a(valueOf, valueOf2, accountType, 0)));
                    return;
                }
                return;
            }
            y a4 = this.f54670a.f54659b;
            if (a4 != null) {
                c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                a4.setValue(c.a.a(new b.a("", "", "", 0)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            y a2 = this.f54670a.f54659b;
            if (a2 != null) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                a2.setValue(c.a.a(upiCustomVolleyError));
            }
        }
    }

    public static final class e implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54672a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f54673b;

        e(a aVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f54672a = aVar;
            this.f54673b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiToken) {
                a aVar = this.f54672a;
                String upiToken = ((UpiToken) upiBaseDataModel).getUpiToken();
                k.a((Object) upiToken, "response.upiToken");
                a.a(aVar, upiToken, this.f54673b);
                return;
            }
            y a2 = this.f54672a.f54659b;
            if (a2 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                a2.setValue(c.a.a(new b.a("", "", "", 2)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError == null || !p.a("1006", upiCustomVolleyError.getAlertTitle(), true)) {
                y a2 = this.f54672a.f54659b;
                if (a2 != null) {
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    a2.setValue(c.a.a(upiCustomVolleyError));
                    return;
                }
                return;
            }
            y a3 = this.f54672a.f54659b;
            if (a3 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                a3.setValue(c.a.a(new b.a("", "", "", 1)));
            }
        }
    }

    public static final class f implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54674a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f54675b;

        f(a aVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f54674a = aVar;
            this.f54675b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            a aVar = this.f54674a;
            UpiProfileDefaultBank upiProfileDefaultBank = this.f54675b;
            k.c(upiProfileDefaultBank, "bankAccountProfile");
            net.one97.paytm.upi.registration.b.a.b bVar = aVar.f54658a;
            if (bVar != null) {
                bVar.d(new b(aVar, upiProfileDefaultBank), "", "");
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError != null) {
                p.a("1006", upiCustomVolleyError.getAlertTitle(), true);
            }
        }
    }

    private void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        k.c(upiProfileDefaultBank, "bankAccountProfile");
        net.one97.paytm.upi.registration.b.a.b bVar = this.f54658a;
        if (bVar != null) {
            bVar.b((a.C1389a) new f(this, upiProfileDefaultBank), "", "");
        }
    }

    public static final class b implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54666a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f54667b;

        b(a aVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f54666a = aVar;
            this.f54667b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiToken) {
                a aVar = this.f54666a;
                String upiToken = ((UpiToken) upiBaseDataModel).getUpiToken();
                k.a((Object) upiToken, "response.upiToken");
                a.a(aVar, upiToken, this.f54667b);
                return;
            }
            y a2 = this.f54666a.f54659b;
            if (a2 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                a2.setValue(c.a.a(new b.a("", "", "", 2)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError == null || !p.a("1006", upiCustomVolleyError.getAlertTitle(), true)) {
                y a2 = this.f54666a.f54659b;
                if (a2 != null) {
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    a2.setValue(c.a.a(upiCustomVolleyError));
                    return;
                }
                return;
            }
            y a3 = this.f54666a.f54659b;
            if (a3 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                a3.setValue(c.a.a(new b.a("", "", "", 1)));
            }
        }
    }

    private final void a(List<? extends GetCredentialsResponse> list, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        UserMpinDetails userMpinDetails = new UserMpinDetails();
        for (GetCredentialsResponse getCredentialsResponse : list) {
            if (p.a("MPIN", getCredentialsResponse.getSubtype(), true)) {
                StringBuilder sb = new StringBuilder();
                CredentialsData data = getCredentialsResponse.getData();
                k.a((Object) data, "credential.data");
                sb.append(data.getCode());
                sb.append(AppConstants.COMMA);
                CredentialsData data2 = getCredentialsResponse.getData();
                k.a((Object) data2, "credential.data");
                sb.append(data2.getKi());
                sb.append(AppConstants.COMMA);
                CredentialsData data3 = getCredentialsResponse.getData();
                k.a((Object) data3, "credential.data");
                sb.append(data3.getEncryptedBase64String());
                userMpinDetails.setMpin(sb.toString());
            }
        }
        y<net.one97.paytm.moneytransfer.model.c<b.a>> yVar = this.f54659b;
        if (yVar != null) {
            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
            yVar.setValue(c.a.a());
        }
        net.one97.paytm.upi.profile.b.b bVar = this.f54662e;
        if (bVar != null) {
            bVar.a(str, userMpinDetails, upiProfileDefaultBank, (a.C1382a) new C0978a(this, upiProfileDefaultBank), "", "");
        }
    }

    /* renamed from: net.one97.paytm.moneytransfer.viewmodel.a$a  reason: collision with other inner class name */
    public static final class C0978a implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54664a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f54665b;

        C0978a(a aVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f54664a = aVar;
            this.f54665b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                if (!baseUpiResponse.isSuccess() || !k.a((Object) "0", (Object) baseUpiResponse.getResponse())) {
                    this.f54664a.a(baseUpiResponse.getResponse());
                    return;
                }
                try {
                    if (((BaseUpiResponse) upiBaseDataModel).getMobileAppData() instanceof UpiCheckBalanceModel) {
                        Object mobileAppData = ((BaseUpiResponse) upiBaseDataModel).getMobileAppData();
                        if (mobileAppData != null) {
                            UpiCheckBalanceModel upiCheckBalanceModel = (UpiCheckBalanceModel) mobileAppData;
                            y a2 = this.f54664a.f54659b;
                            if (a2 != null) {
                                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                                String availableBalance = upiCheckBalanceModel.getAvailableBalance();
                                if (availableBalance == null) {
                                    availableBalance = "";
                                }
                                String totalBal = upiCheckBalanceModel.getTotalBal();
                                if (totalBal == null) {
                                    totalBal = "";
                                }
                                BankAccountDetails.BankAccount debitBank = this.f54665b.getDebitBank();
                                k.a((Object) debitBank, "bankAccount.debitBank");
                                String accountType = debitBank.getAccountType();
                                k.a((Object) accountType, "bankAccount.debitBank.accountType");
                                a2.setValue(c.a.a(new b.a(availableBalance, totalBal, accountType, 0)));
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
                this.f54664a.a("");
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            this.f54664a.a(upiCustomVolleyError.getmErrorCode());
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        if (p.a("ZM", str, true)) {
            y<net.one97.paytm.moneytransfer.model.c<b.a>> yVar = this.f54659b;
            if (yVar != null) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                yVar.setValue(c.a.a(new b.a("", "", "", 4)));
            }
        } else if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, str, true) || p.a("410", str, true)) {
            y<net.one97.paytm.moneytransfer.model.c<b.a>> yVar2 = this.f54659b;
            if (yVar2 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                yVar2.setValue(c.a.a(new b.a("", "", "", 3)));
            }
        } else if (p.a("Z6", str, true)) {
            y<net.one97.paytm.moneytransfer.model.c<b.a>> yVar3 = this.f54659b;
            if (yVar3 != null) {
                c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                yVar3.setValue(c.a.a(new b.a("", "", "", 6)));
            }
        } else {
            y<net.one97.paytm.moneytransfer.model.c<b.a>> yVar4 = this.f54659b;
            if (yVar4 != null) {
                c.a aVar4 = net.one97.paytm.moneytransfer.model.c.f54031e;
                yVar4.setValue(c.a.a(new b.a("", "", "", 5)));
            }
        }
    }

    private static boolean a(BankAccountDetails.BankAccount bankAccount) {
        k.c(bankAccount, "bankAccount");
        String ifsc = bankAccount.getIfsc();
        k.a((Object) ifsc, "bankAccount.ifsc");
        return p.a((CharSequence) ifsc, (CharSequence) "PYTM", false);
    }

    public static final /* synthetic */ void a(a aVar, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        String upiSequenceNo = UpiUtils.getUpiSequenceNo();
        try {
            net.one97.paytm.upi.h.a aVar2 = aVar.f54661d;
            if (aVar2 != null) {
                aVar2.a(upiSequenceNo, "", str, 0, upiProfileDefaultBank.getDebitBank(), new CLRemoteResultReceiver(new MoneyTransferAccountsViewModel$getBalanceCredentials$1(aVar, upiSequenceNo, upiProfileDefaultBank, new Handler())));
            }
        } catch (IllegalStateException unused) {
            aVar.a("");
        }
    }

    public static final /* synthetic */ void a(a aVar, int i2, Bundle bundle, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        String string = bundle.getString("error");
        if (string != null) {
            if (!(string.length() == 0)) {
                try {
                    y<net.one97.paytm.moneytransfer.model.c<b.a>> yVar = aVar.f54659b;
                    if (yVar != null) {
                        c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
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
                    k.a((Object) getCredentialsResponse, "getCredentialsResponse");
                    getCredentialsResponse.setSubtype(str2);
                    arrayList.add(getCredentialsResponse);
                } catch (v e3) {
                    e3.printStackTrace();
                }
            }
            if (i2 == aVar.f54660c) {
                aVar.a((List<? extends GetCredentialsResponse>) arrayList, str, upiProfileDefaultBank);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
    }
}
