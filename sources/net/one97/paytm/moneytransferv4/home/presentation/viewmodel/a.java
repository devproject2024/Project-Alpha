package net.one97.paytm.moneytransferv4.home.presentation.viewmodel;

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
import java.util.RandomAccess;
import java.util.concurrent.Callable;
import kotlin.a.r;
import kotlin.g.b.ab;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.PPBCurrentAccountModel;
import net.one97.paytm.moneytransfer.model.ContactItemModel;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
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
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.common.upi.UpiToken;
import net.one97.paytm.upi.common.upi.UserMpinDetails;
import net.one97.paytm.upi.common.upi.ValidateVpaResponse;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.requestmoney.b.a.a;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public final class a extends androidx.lifecycle.a implements a.C1347a {
    private net.one97.paytm.upi.h.a A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public final int C;
    /* access modifiers changed from: private */
    public y<UpiProfileDefaultBank> D = new y<>();

    /* renamed from: a  reason: collision with root package name */
    public final y<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransfer.model.b>> f55561a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f55562b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f55563c;

    /* renamed from: d  reason: collision with root package name */
    public y<String> f55564d;

    /* renamed from: e  reason: collision with root package name */
    public y<String> f55565e;

    /* renamed from: f  reason: collision with root package name */
    public y<String> f55566f;

    /* renamed from: g  reason: collision with root package name */
    public y<String> f55567g;

    /* renamed from: h  reason: collision with root package name */
    public y<ArrayList<UpiProfileDefaultBank>> f55568h;

    /* renamed from: i  reason: collision with root package name */
    public y<ArrayList<UpiProfileDefaultBank>> f55569i;
    public double j = 1.0d;
    public double k = 1000000.0d;
    public double l = 200000.0d;
    public y<net.one97.paytm.moneytransfer.model.c<C1030a>> m;
    net.one97.paytm.upi.registration.b.a.b n;
    public final y<net.one97.paytm.moneytransfer.model.c<b>> o = new y<>();
    public y<PPBCurrentAccountModel> p = new y<>();
    public final y<ArrayList<String>> q = new y<>();
    public final ArrayList<String> r = new ArrayList<>();
    public y<net.one97.paytm.moneytransfer.model.c<DealsEntity>> s;
    private net.one97.paytm.moneytransfer.b.a.b t;
    /* access modifiers changed from: private */
    public ArrayList<ContactItemModel> u;
    /* access modifiers changed from: private */
    public ArrayList<ContactItemModel> v;
    private y<Boolean> w;
    private net.one97.paytm.upi.profile.b.b x;
    private net.one97.paytm.moneytransfer.b.a.b y;
    private net.one97.paytm.upi.requestmoney.b.a.b z;

    public final void onServiceConnected() {
    }

    public final void onServiceDisconnected() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        kotlin.g.b.k.c(application, "application");
        Context context = application;
        this.t = net.one97.paytm.moneytransfer.b.a(context);
        this.x = net.one97.paytm.upi.g.a();
        this.y = net.one97.paytm.moneytransfer.b.a(context);
        this.A = net.one97.paytm.upi.g.a((a.C1347a) this);
        this.n = net.one97.paytm.upi.g.a(this.A);
        this.z = net.one97.paytm.upi.g.c();
        this.w = new y<>();
        this.f55565e = new y<>();
        this.f55566f = new y<>();
        this.f55564d = new y<>();
        this.f55568h = new y<>();
        this.f55569i = new y<>();
        this.m = new y<>();
        this.f55567g = new y<>();
        this.s = new y<>();
    }

    public static final class f implements net.one97.paytm.moneytransfer.a.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55582a;

        static final class b<T1, T2> implements io.reactivex.rxjava3.d.b<Boolean, Throwable> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f f55585a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.moneytransfer.model.b f55586b;

            b(f fVar, net.one97.paytm.moneytransfer.model.b bVar) {
                this.f55585a = fVar;
                this.f55586b = bVar;
            }

            public final /* synthetic */ void accept(Object obj, Object obj2) {
                Throwable th = (Throwable) obj2;
                this.f55585a.f55582a.B = false;
                if (th != null) {
                    th.printStackTrace();
                    return;
                }
                y b2 = this.f55585a.f55582a.f55561a;
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                b2.setValue(c.a.a(this.f55586b));
                this.f55585a.f55582a.u = this.f55586b.a();
                this.f55585a.f55582a.v = this.f55586b.b();
            }
        }

        f(a aVar) {
            this.f55582a = aVar;
        }

        public final void a(net.one97.paytm.moneytransfer.model.b bVar) {
            if (bVar != null) {
                this.f55582a.B = false;
                io.reactivex.rxjava3.a.y.a(new C1031a(this, bVar)).b(io.reactivex.rxjava3.i.a.a()).a(io.reactivex.rxjava3.android.b.a.a()).a(new b(this, bVar));
            }
        }

        /* renamed from: net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a$f$a  reason: collision with other inner class name */
        static final class C1031a<V> implements Callable<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f f55583a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.moneytransfer.model.b f55584b;

            C1031a(f fVar, net.one97.paytm.moneytransfer.model.b bVar) {
                this.f55583a = fVar;
                this.f55584b = bVar;
            }

            public final /* synthetic */ Object call() {
                int i2;
                ArrayList<ContactItemModel> a2 = this.f55584b.a();
                kotlin.g.b.k.a((Object) a2, "listContact.contactItemModels");
                List list = a2;
                kotlin.g.a.b bVar = b.INSTANCE;
                kotlin.g.b.k.d(list, "$this$removeAll");
                kotlin.g.b.k.d(bVar, "predicate");
                boolean z = false;
                if (list instanceof RandomAccess) {
                    int a3 = kotlin.a.k.a(list);
                    if (a3 >= 0) {
                        int i3 = 0;
                        i2 = 0;
                        while (true) {
                            Object obj = list.get(i3);
                            if (!((Boolean) bVar.invoke(obj)).booleanValue()) {
                                if (i2 != i3) {
                                    list.set(i2, obj);
                                }
                                i2++;
                            }
                            if (i3 == a3) {
                                break;
                            }
                            i3++;
                        }
                    } else {
                        i2 = 0;
                    }
                    if (i2 < list.size()) {
                        int a4 = kotlin.a.k.a(list);
                        if (a4 >= i2) {
                            while (true) {
                                list.remove(a4);
                                if (a4 == i2) {
                                    break;
                                }
                                a4--;
                            }
                        }
                        z = true;
                    }
                } else if (list != null) {
                    z = r.a(ab.a((Object) list), bVar, true);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
                }
                return Boolean.valueOf(z);
            }
        }
    }

    public final void a() {
        try {
            this.B = true;
            this.f55562b = true;
            net.one97.paytm.moneytransfer.b.a.b bVar = this.t;
            if (bVar != null) {
                bVar.a((net.one97.paytm.moneytransfer.a.a) new f(this));
            }
        } catch (Exception unused) {
        }
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank, String str) {
        kotlin.g.b.k.c(upiProfileDefaultBank, "bankAccountProfile");
        y<net.one97.paytm.moneytransfer.model.c<C1030a>> yVar = this.m;
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
                net.one97.paytm.upi.profile.b.b bVar = this.x;
                if (bVar != null) {
                    BankAccountDetails.BankAccount debitBank3 = upiProfileDefaultBank.getDebitBank();
                    kotlin.g.b.k.a((Object) debitBank3, "bankAccountProfile.debitBank");
                    debitBank3.getAccount();
                    bVar.a(str, (a.C1382a) new h(this, upiProfileDefaultBank));
                    return;
                }
                return;
            }
            net.one97.paytm.upi.profile.b.b bVar2 = this.x;
            if (bVar2 != null) {
                BankAccountDetails.BankAccount debitBank4 = upiProfileDefaultBank.getDebitBank();
                kotlin.g.b.k.a((Object) debitBank4, "bankAccountProfile.debitBank");
                debitBank4.getAccount();
                bVar2.a((a.C1382a) new i(this, upiProfileDefaultBank));
                return;
            }
            return;
        }
        net.one97.paytm.moneytransfer.b.a.b bVar3 = this.y;
        String str2 = null;
        Boolean valueOf = bVar3 != null ? Boolean.valueOf(bVar3.b()) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        boolean z2 = true;
        if (valueOf.booleanValue()) {
            net.one97.paytm.moneytransfer.b.a.b bVar4 = this.y;
            Boolean valueOf2 = bVar4 != null ? Boolean.valueOf(bVar4.a()) : null;
            if (valueOf2 == null) {
                kotlin.g.b.k.a();
            }
            if (!valueOf2.booleanValue()) {
                y<net.one97.paytm.moneytransfer.model.c<C1030a>> yVar2 = this.m;
                if (yVar2 != null) {
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    yVar2.setValue(c.a.a(new C1030a("", "", "", 1)));
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
        final /* synthetic */ a f55589a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f55590b;

        h(a aVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f55589a = aVar;
            this.f55590b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof CJRAccountSummary) {
                CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                if (cJRAccountSummary.getStatus() == null || !p.a(cJRAccountSummary.getStatus(), "success", true)) {
                    y c2 = this.f55589a.m;
                    if (c2 != null) {
                        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                        c2.setValue(c.a.a(new C1030a("", "", "", 0)));
                        return;
                    }
                    return;
                }
                AccountBalanceModel accountBalanceModel = cJRAccountSummary.getAccounts().get(0);
                y c3 = this.f55589a.m;
                if (c3 != null) {
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    kotlin.g.b.k.a((Object) accountBalanceModel, "savingAccount");
                    String valueOf = String.valueOf(accountBalanceModel.getEffectiveBalance());
                    String valueOf2 = String.valueOf(accountBalanceModel.getEffectiveBalance());
                    BankAccountDetails.BankAccount debitBank = this.f55590b.getDebitBank();
                    kotlin.g.b.k.a((Object) debitBank, "bankAccountProfile.debitBank");
                    String accountType = debitBank.getAccountType();
                    kotlin.g.b.k.a((Object) accountType, "bankAccountProfile.debitBank.accountType");
                    c3.setValue(c.a.a(new C1030a(valueOf, valueOf2, accountType, 0)));
                    return;
                }
                return;
            }
            y c4 = this.f55589a.m;
            if (c4 != null) {
                c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                c4.setValue(c.a.a(new C1030a("", "", "", 0)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            kotlin.g.b.k.c(upiCustomVolleyError, "error");
            y c2 = this.f55589a.m;
            if (c2 != null) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                c2.setValue(c.a.a(upiCustomVolleyError));
            }
        }
    }

    public static final class i implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55591a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f55592b;

        i(a aVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f55591a = aVar;
            this.f55592b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof CJRAccountSummary) {
                CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                if (cJRAccountSummary.getStatus() == null || !p.a(cJRAccountSummary.getStatus(), "success", true)) {
                    y c2 = this.f55591a.m;
                    if (c2 != null) {
                        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                        c2.setValue(c.a.a(new C1030a("", "", "", 0)));
                        return;
                    }
                    return;
                }
                AccountBalanceModel accountBalanceModel = cJRAccountSummary.getAccounts().get(0);
                y c3 = this.f55591a.m;
                if (c3 != null) {
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    kotlin.g.b.k.a((Object) accountBalanceModel, "savingAccount");
                    String valueOf = String.valueOf(accountBalanceModel.getEffectiveBalance());
                    String valueOf2 = String.valueOf(accountBalanceModel.getEffectiveBalance());
                    BankAccountDetails.BankAccount debitBank = this.f55592b.getDebitBank();
                    kotlin.g.b.k.a((Object) debitBank, "bankAccountProfile.debitBank");
                    String accountType = debitBank.getAccountType();
                    kotlin.g.b.k.a((Object) accountType, "bankAccountProfile.debitBank.accountType");
                    c3.setValue(c.a.a(new C1030a(valueOf, valueOf2, accountType, 0)));
                    return;
                }
                return;
            }
            y c4 = this.f55591a.m;
            if (c4 != null) {
                c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                c4.setValue(c.a.a(new C1030a("", "", "", 0)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            kotlin.g.b.k.c(upiCustomVolleyError, "error");
            y c2 = this.f55591a.m;
            if (c2 != null) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                c2.setValue(c.a.a(upiCustomVolleyError));
            }
        }
    }

    public static final class j implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55593a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f55594b;

        j(a aVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f55593a = aVar;
            this.f55594b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiToken) {
                a aVar = this.f55593a;
                String upiToken = ((UpiToken) upiBaseDataModel).getUpiToken();
                kotlin.g.b.k.a((Object) upiToken, "response.upiToken");
                a.a(aVar, upiToken, this.f55594b);
                return;
            }
            y c2 = this.f55593a.m;
            if (c2 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                c2.setValue(c.a.a(new C1030a("", "", "", 2)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError == null || !p.a("1006", upiCustomVolleyError.getAlertTitle(), true)) {
                y c2 = this.f55593a.m;
                if (c2 != null) {
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    c2.setValue(c.a.a(upiCustomVolleyError));
                    return;
                }
                return;
            }
            y c3 = this.f55593a.m;
            if (c3 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                c3.setValue(c.a.a(new C1030a("", "", "", 1)));
            }
        }
    }

    public static final class l implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55597a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f55598b;

        l(a aVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f55597a = aVar;
            this.f55598b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            a aVar = this.f55597a;
            UpiProfileDefaultBank upiProfileDefaultBank = this.f55598b;
            kotlin.g.b.k.c(upiProfileDefaultBank, "bankAccountProfile");
            net.one97.paytm.upi.registration.b.a.b bVar = aVar.n;
            if (bVar != null) {
                bVar.d(new g(aVar, upiProfileDefaultBank), "", "");
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
            bVar.b((a.C1389a) new l(this, upiProfileDefaultBank), "", "");
        }
    }

    public static final class g implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55587a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f55588b;

        g(a aVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f55587a = aVar;
            this.f55588b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiToken) {
                a aVar = this.f55587a;
                String upiToken = ((UpiToken) upiBaseDataModel).getUpiToken();
                kotlin.g.b.k.a((Object) upiToken, "response.upiToken");
                a.a(aVar, upiToken, this.f55588b);
                return;
            }
            y c2 = this.f55587a.m;
            if (c2 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                c2.setValue(c.a.a(new C1030a("", "", "", 2)));
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (upiCustomVolleyError == null || !p.a("1006", upiCustomVolleyError.getAlertTitle(), true)) {
                y c2 = this.f55587a.m;
                if (c2 != null) {
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    c2.setValue(c.a.a(upiCustomVolleyError));
                    return;
                }
                return;
            }
            y c3 = this.f55587a.m;
            if (c3 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                c3.setValue(c.a.a(new C1030a("", "", "", 1)));
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
        y<net.one97.paytm.moneytransfer.model.c<C1030a>> yVar = this.m;
        if (yVar != null) {
            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
            yVar.setValue(c.a.a());
        }
        net.one97.paytm.upi.profile.b.b bVar = this.x;
        if (bVar != null) {
            bVar.a(str, userMpinDetails, upiProfileDefaultBank, (a.C1382a) new e(this, upiProfileDefaultBank), "", "");
        }
    }

    public static final class e implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55580a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UpiProfileDefaultBank f55581b;

        e(a aVar, UpiProfileDefaultBank upiProfileDefaultBank) {
            this.f55580a = aVar;
            this.f55581b = upiProfileDefaultBank;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                if (!baseUpiResponse.isSuccess() || !kotlin.g.b.k.a((Object) "0", (Object) baseUpiResponse.getResponse())) {
                    String response = baseUpiResponse.getResponse();
                    a aVar = this.f55580a;
                    kotlin.g.b.k.a((Object) response, "res");
                    aVar.b(response);
                    return;
                }
                try {
                    if (((BaseUpiResponse) upiBaseDataModel).getMobileAppData() instanceof UpiCheckBalanceModel) {
                        Object mobileAppData = ((BaseUpiResponse) upiBaseDataModel).getMobileAppData();
                        if (mobileAppData != null) {
                            UpiCheckBalanceModel upiCheckBalanceModel = (UpiCheckBalanceModel) mobileAppData;
                            y c2 = this.f55580a.m;
                            if (c2 != null) {
                                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                                String availableBalance = upiCheckBalanceModel.getAvailableBalance();
                                if (availableBalance == null) {
                                    availableBalance = "";
                                }
                                String totalBal = upiCheckBalanceModel.getTotalBal();
                                if (totalBal == null) {
                                    totalBal = "";
                                }
                                BankAccountDetails.BankAccount debitBank = this.f55581b.getDebitBank();
                                kotlin.g.b.k.a((Object) debitBank, "bankAccount.debitBank");
                                String accountType = debitBank.getAccountType();
                                kotlin.g.b.k.a((Object) accountType, "bankAccount.debitBank.accountType");
                                c2.setValue(c.a.a(new C1030a(availableBalance, totalBal, accountType, 0)));
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
                this.f55580a.b("");
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            kotlin.g.b.k.c(upiCustomVolleyError, "error");
            a aVar = this.f55580a;
            String str = upiCustomVolleyError.getmErrorCode();
            kotlin.g.b.k.a((Object) str, "error.getmErrorCode()");
            aVar.b(str);
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str) {
        if (p.a("ZM", str, true)) {
            y<net.one97.paytm.moneytransfer.model.c<C1030a>> yVar = this.m;
            if (yVar != null) {
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                yVar.setValue(c.a.a(new C1030a("", "", "", 4)));
            }
        } else if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, str, true) || p.a("410", str, true)) {
            y<net.one97.paytm.moneytransfer.model.c<C1030a>> yVar2 = this.m;
            if (yVar2 != null) {
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                yVar2.setValue(c.a.a(new C1030a("", "", "", 3)));
            }
        } else {
            y<net.one97.paytm.moneytransfer.model.c<C1030a>> yVar3 = this.m;
            if (yVar3 != null) {
                c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                yVar3.setValue(c.a.a(new C1030a("", "", "", 5)));
            }
        }
    }

    public final void a(String str, String str2) {
        kotlin.g.b.k.c(str, "vpa");
        kotlin.g.b.k.c(str2, "intentData");
        y<net.one97.paytm.moneytransfer.model.c<b>> yVar = this.o;
        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar.setValue(c.a.a());
        if (com.paytm.utility.a.m(getApplication())) {
            net.one97.paytm.upi.requestmoney.b.a.b bVar = this.z;
            if (bVar != null) {
                bVar.b(new m(this), "", str, str2, "");
                return;
            }
            return;
        }
        UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
        upiCustomVolleyError.setAlertMessage("We can not detect any internet connectivity. Please check your internet connection and try again.");
        upiCustomVolleyError.setmAlertTitle("No Internet Connection");
        y<net.one97.paytm.moneytransfer.model.c<b>> yVar2 = this.o;
        c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar2.setValue(c.a.a(upiCustomVolleyError));
    }

    public static final class m implements a.C1402a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55599a;

        m(a aVar) {
            this.f55599a = aVar;
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
                        y e2 = this.f55599a.o;
                        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                        String signStatus = validateVpaResponse.getSignStatus();
                        if (signStatus == null) {
                            signStatus = "";
                        }
                        e2.setValue(c.a.a(new b(0, name, "", signStatus)));
                        return;
                    }
                    y e3 = this.f55599a.o;
                    c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    e3.setValue(c.a.a(new b(1, name, respCode, "")));
                } else if ("37".equals(respCode)) {
                    y e4 = this.f55599a.o;
                    c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    e4.setValue(c.a.a(new b(1, "", respCode, "")));
                } else {
                    y e5 = this.f55599a.o;
                    c.a aVar4 = net.one97.paytm.moneytransfer.model.c.f54031e;
                    e5.setValue(c.a.a(new b(2, "", respCode, "")));
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            kotlin.g.b.k.c(upiCustomVolleyError, "error");
            y e2 = this.f55599a.o;
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

    public static final class c<V> implements Callable<DealsEntity> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55578a;

        public c(a aVar) {
            this.f55578a = aVar;
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
                Application application = this.f55578a.getApplication();
                kotlin.g.b.k.a((Object) application, "getApplication()");
                return g2.b(application);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static final class d implements aa<DealsEntity> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55579a;

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            kotlin.g.b.k.c(cVar, "d");
        }

        public d(a aVar) {
            this.f55579a = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            DealsEntity dealsEntity = (DealsEntity) obj;
            if (dealsEntity != null) {
                y f2 = this.f55579a.s;
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                f2.setValue(c.a.a(dealsEntity));
            }
        }
    }

    public static final class k implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f55595a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f55596b;

        k(a aVar, String str) {
            this.f55595a = aVar;
            this.f55596b = str;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof UpiProfileModel) {
                UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                if (p.a(upiProfileModel.getStatus(), "SUCCESS", true) && p.a("0", upiProfileModel.getRespCode(), true) && upiProfileModel.getResponse() != null) {
                    UpiProfileModel.AccountDetails response = upiProfileModel.getResponse();
                    kotlin.g.b.k.a((Object) response, "response.response");
                    UpiProfileModel.ProfileDetails profileDetail = response.getProfileDetail();
                    kotlin.g.b.k.a((Object) profileDetail, "response.response.profileDetail");
                    if (profileDetail.getProfileVpaList() != null) {
                        UpiProfileModel.AccountDetails response2 = upiProfileModel.getResponse();
                        kotlin.g.b.k.a((Object) response2, "response.response");
                        UpiProfileModel.ProfileDetails profileDetail2 = response2.getProfileDetail();
                        kotlin.g.b.k.a((Object) profileDetail2, "response.response.profileDetail");
                        for (UpiProfileDefaultBank next : profileDetail2.getProfileVpaList()) {
                            kotlin.g.b.k.a((Object) next, "upiProfileDefaultBank");
                            if (next.getDebitBank() != null) {
                                BankAccountDetails.BankAccount debitBank = next.getDebitBank();
                                kotlin.g.b.k.a((Object) debitBank, "upiProfileDefaultBank.debitBank");
                                if (debitBank.getAccount() != null && p.a(next.getVirtualAddress(), this.f55596b, true)) {
                                    this.f55595a.D.postValue(next);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            this.f55595a.D.postValue(null);
        }
    }

    public final y<UpiProfileDefaultBank> a(String str) {
        kotlin.g.b.k.c(str, UpiRequestBuilder.KEY_PAYER_VPA);
        net.one97.paytm.upi.profile.b.b bVar = this.x;
        if (bVar != null) {
            bVar.a((a.C1382a) new k(this, str), SDKConstants.PUSH_FROM_COLLECT, "MT_Home");
        }
        return this.D;
    }

    /* renamed from: net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a$a  reason: collision with other inner class name */
    public static final class C1030a {

        /* renamed from: a  reason: collision with root package name */
        public final String f55570a;

        /* renamed from: b  reason: collision with root package name */
        public final String f55571b;

        /* renamed from: c  reason: collision with root package name */
        public final String f55572c;

        /* renamed from: d  reason: collision with root package name */
        public final Integer f55573d;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1030a)) {
                return false;
            }
            C1030a aVar = (C1030a) obj;
            return kotlin.g.b.k.a((Object) this.f55570a, (Object) aVar.f55570a) && kotlin.g.b.k.a((Object) this.f55571b, (Object) aVar.f55571b) && kotlin.g.b.k.a((Object) this.f55572c, (Object) aVar.f55572c) && kotlin.g.b.k.a((Object) this.f55573d, (Object) aVar.f55573d);
        }

        public final int hashCode() {
            String str = this.f55570a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f55571b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f55572c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Integer num = this.f55573d;
            if (num != null) {
                i2 = num.hashCode();
            }
            return hashCode3 + i2;
        }

        public final String toString() {
            return "UPICheckBalModel(availableBal=" + this.f55570a + ", totalBal=" + this.f55571b + ", accountType=" + this.f55572c + ", result=" + this.f55573d + ")";
        }

        public C1030a(String str, String str2, String str3, Integer num) {
            kotlin.g.b.k.c(str, "availableBal");
            kotlin.g.b.k.c(str2, "totalBal");
            kotlin.g.b.k.c(str3, "accountType");
            this.f55570a = str;
            this.f55571b = str2;
            this.f55572c = str3;
            this.f55573d = num;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f55574a;

        /* renamed from: b  reason: collision with root package name */
        public String f55575b;

        /* renamed from: c  reason: collision with root package name */
        public final String f55576c;

        /* renamed from: d  reason: collision with root package name */
        public final String f55577d;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f55574a == bVar.f55574a && kotlin.g.b.k.a((Object) this.f55575b, (Object) bVar.f55575b) && kotlin.g.b.k.a((Object) this.f55576c, (Object) bVar.f55576c) && kotlin.g.b.k.a((Object) this.f55577d, (Object) bVar.f55577d);
        }

        public final int hashCode() {
            int i2 = this.f55574a * 31;
            String str = this.f55575b;
            int i3 = 0;
            int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f55576c;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f55577d;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return hashCode2 + i3;
        }

        public final String toString() {
            return "UPIVpaVerifyModel(code=" + this.f55574a + ", name=" + this.f55575b + ", errorCode=" + this.f55576c + ", signStatus=" + this.f55577d + ")";
        }

        public b(int i2, String str, String str2, String str3) {
            kotlin.g.b.k.c(str, "name");
            kotlin.g.b.k.c(str2, CLConstants.FIELD_ERROR_CODE);
            kotlin.g.b.k.c(str3, "signStatus");
            this.f55574a = i2;
            this.f55575b = str;
            this.f55576c = str2;
            this.f55577d = str3;
        }
    }

    public static final /* synthetic */ void a(a aVar, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        String upiSequenceNo = UpiUtils.getUpiSequenceNo();
        try {
            net.one97.paytm.upi.h.a aVar2 = aVar.A;
            if (aVar2 != null) {
                aVar2.a(upiSequenceNo, "", str, 0, upiProfileDefaultBank.getDebitBank(), new CLRemoteResultReceiver(new MoneyTransferV4ActivityViewModel$getBalanceCredentials$1(aVar, upiSequenceNo, upiProfileDefaultBank, new Handler())));
            }
        } catch (IllegalStateException unused) {
            aVar.b("");
        }
    }

    public static final /* synthetic */ void a(a aVar, int i2, Bundle bundle, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        String string = bundle.getString("error");
        if (string != null) {
            if (!(string.length() == 0)) {
                try {
                    y<net.one97.paytm.moneytransfer.model.c<C1030a>> yVar = aVar.m;
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
                    kotlin.g.b.k.a((Object) getCredentialsResponse, "getCredentialsResponse");
                    getCredentialsResponse.setSubtype(str2);
                    arrayList.add(getCredentialsResponse);
                } catch (v e3) {
                    e3.printStackTrace();
                }
            }
            if (i2 == aVar.C) {
                aVar.a((List<? extends GetCredentialsResponse>) arrayList, str, upiProfileDefaultBank);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
    }
}
