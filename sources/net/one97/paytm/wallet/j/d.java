package net.one97.paytm.wallet.j;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRCashWalletResponse;
import net.one97.paytm.common.entity.wallet.CJRSubWallet;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.network.f;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.utils.at;
import net.one97.paytm.utils.be;
import net.one97.paytm.wallet.entity.BankInfo;
import net.one97.paytm.wallet.entity.BankUPIResponse;
import net.one97.paytm.wallet.entity.WalletInfo;
import net.one97.paytm.wallet.newdesign.utils.AppExecutor;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public final class d extends net.one97.paytm.base.e {

    /* renamed from: b  reason: collision with root package name */
    public boolean f70426b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f70427c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f70428d;

    /* renamed from: e  reason: collision with root package name */
    public y<net.one97.paytm.wallet.utility.c<net.one97.paytm.network.f>> f70429e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<net.one97.paytm.wallet.utility.c<net.one97.paytm.network.f>> f70430f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public y<net.one97.paytm.wallet.utility.c<Boolean>> f70431g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public final y<net.one97.paytm.wallet.utility.c<ArrayList<IJRDataModel>>> f70432h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public final y<net.one97.paytm.wallet.utility.c<o<Integer, ArrayList<IJRDataModel>>>> f70433i = new y<>();
    /* access modifiers changed from: private */
    public y<net.one97.paytm.network.f> j = new y<>();
    /* access modifiers changed from: private */
    public y<net.one97.paytm.network.f> k = new y<>();
    private final z<net.one97.paytm.network.f> l = new b(this);
    private final z<net.one97.paytm.network.f> m;

    static final class b<T> implements z<net.one97.paytm.network.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f70435a;

        b(d dVar) {
            this.f70435a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.network.f fVar = (net.one97.paytm.network.f) obj;
            int i2 = e.f70454a[fVar.f55796a.ordinal()];
            if (i2 == 1) {
                y g2 = this.f70435a.f70429e;
                f.a aVar = net.one97.paytm.network.f.f55795d;
                g2.postValue(new net.one97.paytm.wallet.utility.c(f.a.a(-1, (IJRPaytmDataModel) null, (NetworkCustomError) null)));
            } else if (i2 == 2) {
                y g3 = this.f70435a.f70429e;
                f.a aVar2 = net.one97.paytm.network.f.f55795d;
                g3.postValue(new net.one97.paytm.wallet.utility.c(f.a.a()));
            } else if (i2 == 3) {
                Future<?> runOnBgThread = AppExecutor.getExecutor().runOnBgThread(new a(this, fVar));
                net.one97.paytm.base.f fVar2 = this.f70435a.f49511a;
                kotlin.g.b.k.a((Object) runOnBgThread, "future");
                fVar2.a(runOnBgThread);
            } else if (i2 == 4) {
                y g4 = this.f70435a.f70429e;
                f.a aVar3 = net.one97.paytm.network.f.f55795d;
                g4.postValue(new net.one97.paytm.wallet.utility.c(f.a.b()));
            }
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f70436a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.network.f f70437b;

            a(b bVar, net.one97.paytm.network.f fVar) {
                this.f70436a = bVar;
                this.f70437b = fVar;
            }

            public final void run() {
                String str;
                IJRPaytmDataModel iJRPaytmDataModel = this.f70437b.f55797b;
                if (iJRPaytmDataModel != null) {
                    List<UpiProfileDefaultBank> profileVpaList = ((BankUPIResponse) iJRPaytmDataModel).getProfileVpaList();
                    Collection collection = profileVpaList;
                    if (!(collection == null || collection.isEmpty())) {
                        for (UpiProfileDefaultBank next : profileVpaList) {
                            if (next.isPrimary()) {
                                if (next.getDebitBank() != null) {
                                    BankAccountDetails.BankAccount debitBank = next.getDebitBank();
                                    kotlin.g.b.k.a((Object) debitBank, "bank.debitBank");
                                    if (debitBank.getBankName() != null) {
                                        BankAccountDetails.BankAccount debitBank2 = next.getDebitBank();
                                        kotlin.g.b.k.a((Object) debitBank2, "bank.debitBank");
                                        String bankName = debitBank2.getBankName();
                                        kotlin.g.b.k.a((Object) bankName, "bankName");
                                        if (!p.c(bankName, Constants.DEFAULT_BANK, false)) {
                                            bankName = bankName + " Bank";
                                        }
                                        if (bankName.length() > 10) {
                                            StringBuilder sb = new StringBuilder();
                                            kotlin.g.b.k.a((Object) bankName, "bankName");
                                            if (bankName != null) {
                                                String substring = bankName.substring(0, 10);
                                                kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                                sb.append(substring);
                                                sb.append(".. a/c");
                                                str = sb.toString();
                                                if (str.length() > 15) {
                                                    this.f70436a.f70435a.f70428d = true;
                                                }
                                            } else {
                                                throw new u("null cannot be cast to non-null type java.lang.String");
                                            }
                                        } else {
                                            str = bankName + " a/c";
                                        }
                                        y g2 = this.f70436a.f70435a.f70429e;
                                        f.a aVar = net.one97.paytm.network.f.f55795d;
                                        BankAccountDetails.BankAccount debitBank3 = next.getDebitBank();
                                        kotlin.g.b.k.a((Object) debitBank3, "bank.debitBank");
                                        g2.postValue(new net.one97.paytm.wallet.utility.c(f.a.a(new BankInfo(false, true, str, debitBank3.getBankLogoUrl()))));
                                    }
                                }
                                y g3 = this.f70436a.f70435a.f70429e;
                                f.a aVar2 = net.one97.paytm.network.f.f55795d;
                                g3.postValue(new net.one97.paytm.wallet.utility.c(f.a.a(new BankInfo(true, false, (String) null, (String) null))));
                            }
                        }
                        return;
                    }
                    y g4 = this.f70436a.f70435a.f70429e;
                    f.a aVar3 = net.one97.paytm.network.f.f55795d;
                    g4.postValue(new net.one97.paytm.wallet.utility.c(f.a.a(new BankInfo(true, false, (String) null, (String) null))));
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.wallet.entity.BankUPIResponse");
            }
        }
    }

    /* renamed from: net.one97.paytm.wallet.j.d$d  reason: collision with other inner class name */
    static final class C1424d<T> implements z<net.one97.paytm.network.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f70439a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Application f70440b;

        C1424d(d dVar, Application application) {
            this.f70439a = dVar;
            this.f70440b = application;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.network.f fVar = (net.one97.paytm.network.f) obj;
            int i2 = e.f70455b[fVar.f55796a.ordinal()];
            if (i2 == 1) {
                Future<?> runOnBgThread = AppExecutor.getExecutor().runOnBgThread(new a(this, fVar));
                net.one97.paytm.base.f fVar2 = this.f70439a.f49511a;
                kotlin.g.b.k.a((Object) runOnBgThread, "future");
                fVar2.a(runOnBgThread);
            } else if (i2 == 2) {
                y h2 = this.f70439a.f70430f;
                f.a aVar = net.one97.paytm.network.f.f55795d;
                h2.postValue(new net.one97.paytm.wallet.utility.c(f.a.b()));
            } else if (i2 != 3) {
                if (i2 == 4) {
                    y h3 = this.f70439a.f70430f;
                    f.a aVar2 = net.one97.paytm.network.f.f55795d;
                    h3.postValue(new net.one97.paytm.wallet.utility.c(f.a.a()));
                }
            } else if (fVar.f55798c != null) {
                y h4 = this.f70439a.f70430f;
                f.a aVar3 = net.one97.paytm.network.f.f55795d;
                h4.postValue(new net.one97.paytm.wallet.utility.c(f.a.a(fVar.f55798c.f55799a, fVar.f55798c.f55800b, fVar.f55798c.f55801c)));
            } else {
                y h5 = this.f70439a.f70430f;
                f.a aVar4 = net.one97.paytm.network.f.f55795d;
                h5.postValue(new net.one97.paytm.wallet.utility.c(f.a.a(-1, (IJRPaytmDataModel) null, (NetworkCustomError) null)));
            }
        }

        /* renamed from: net.one97.paytm.wallet.j.d$d$a */
        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1424d f70441a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.network.f f70442b;

            a(C1424d dVar, net.one97.paytm.network.f fVar) {
                this.f70441a = dVar;
                this.f70442b = fVar;
            }

            public final void run() {
                IJRPaytmDataModel iJRPaytmDataModel = this.f70442b.f55797b;
                if (iJRPaytmDataModel != null) {
                    CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
                    if (cJRCashWallet.getResponse() != null) {
                        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f70441a.f70440b, "scannerBalanceListAndroid");
                        CharSequence charSequence = stringFromGTM;
                        if (!TextUtils.isEmpty(charSequence)) {
                            kotlin.g.b.k.a((Object) stringFromGTM, "str");
                            Object[] array = p.a(charSequence, new String[]{AppConstants.COMMA}).toArray(new String[0]);
                            if (array != null) {
                                String[] strArr = (String[]) array;
                                List b2 = kotlin.a.k.b((T[]) (String[]) Arrays.copyOf(strArr, strArr.length));
                                double d2 = 0.0d;
                                CJRCashWalletResponse response = cJRCashWallet.getResponse();
                                kotlin.g.b.k.a((Object) response, "cashWallet.response");
                                for (CJRSubWallet next : response.getSubWalletDetailList()) {
                                    kotlin.g.b.k.a((Object) next, "subWallet");
                                    if (b2.contains(next.getSubWalletName())) {
                                        d2 += next.getBalance();
                                    }
                                }
                                String b3 = com.paytm.utility.b.b(Double.valueOf(d2));
                                net.one97.paytm.wallet.utility.a.a((Context) this.f70441a.f70440b, d2);
                                boolean z = true;
                                if (b3.length() > 6) {
                                    if (this.f70441a.f70439a.f70428d) {
                                        kotlin.g.b.k.a((Object) b3, "amt");
                                        if (b3 != null) {
                                            b3 = b3.substring(0, 6);
                                            kotlin.g.b.k.a((Object) b3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                        } else {
                                            throw new u("null cannot be cast to non-null type java.lang.String");
                                        }
                                    }
                                } else if (!this.f70441a.f70439a.f70428d || b3.length() <= 3) {
                                    z = false;
                                }
                                y h2 = this.f70441a.f70439a.f70430f;
                                f.a aVar = net.one97.paytm.network.f.f55795d;
                                kotlin.g.b.k.a((Object) b3, "amt");
                                h2.postValue(new net.one97.paytm.wallet.utility.c(f.a.a(new WalletInfo(z, b3))));
                                return;
                            }
                            throw new u("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.wallet.CJRCashWallet");
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Application application) {
        super(application);
        kotlin.g.b.k.c(application, "application");
        this.m = new C1424d(this, application);
        y<net.one97.paytm.network.f> yVar = this.j;
        if (yVar != null) {
            LiveData liveData = yVar;
            z<net.one97.paytm.network.f> zVar = this.l;
            if (zVar != null) {
                a(liveData, zVar);
                y<net.one97.paytm.network.f> yVar2 = this.k;
                if (yVar2 != null) {
                    LiveData liveData2 = yVar2;
                    z<net.one97.paytm.network.f> zVar2 = this.m;
                    if (zVar2 != null) {
                        a(liveData2, zVar2);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type androidx.lifecycle.Observer<kotlin.Any>");
                }
                throw new u("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
            }
            throw new u("null cannot be cast to non-null type androidx.lifecycle.Observer<kotlin.Any>");
        }
        throw new u("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f70434a;

        a(d dVar) {
            this.f70434a = dVar;
        }

        public final void run() {
            net.one97.paytm.wallet.h.a aVar = net.one97.paytm.wallet.h.a.f70378a;
            net.one97.paytm.wallet.h.a.a(this.f70434a.j);
        }
    }

    public final void a() {
        AppExecutor.getExecutor().runOnHandlerThread(new a(this));
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f70438a;

        c(d dVar) {
            this.f70438a = dVar;
        }

        public final void run() {
            net.one97.paytm.wallet.h.a aVar = net.one97.paytm.wallet.h.a.f70378a;
            net.one97.paytm.wallet.h.a.b(this.f70438a.k);
        }
    }

    public final void b() {
        Future<?> runOnBgThread = AppExecutor.getExecutor().runOnBgThread(new c(this));
        net.one97.paytm.base.f fVar = this.f49511a;
        kotlin.g.b.k.a((Object) runOnBgThread, "future");
        fVar.a(runOnBgThread);
    }

    public static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f70445a;

        public g(d dVar) {
            this.f70445a = dVar;
        }

        public final void run() {
            net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
            net.one97.paytm.wallet.communicator.c a3 = net.one97.paytm.wallet.communicator.b.a();
            kotlin.g.b.k.a((Object) a3, "WalletCommManager.getWalletCommunicator()");
            if (a2.getBooleanFromGTM(a3.getContext(), "contactSyncOnScannerEnabled", false)) {
                net.one97.paytm.contacts.utils.c cVar = net.one97.paytm.contacts.utils.c.f50249c;
                net.one97.paytm.wallet.communicator.c a4 = net.one97.paytm.wallet.communicator.b.a();
                kotlin.g.b.k.a((Object) a4, "WalletCommManager.getWalletCommunicator()");
                Context context = a4.getContext();
                kotlin.g.b.k.a((Object) context, "WalletCommManager.getWalletCommunicator().context");
                cVar.a(context, e.C0905e.PAY.getType(), e.b.PHONEBOOK.getType());
            }
            d.e();
            net.one97.paytm.wallet.communicator.c a5 = net.one97.paytm.wallet.communicator.b.a();
            net.one97.paytm.wallet.communicator.c a6 = net.one97.paytm.wallet.communicator.b.a();
            kotlin.g.b.k.a((Object) a6, "WalletCommManager.getWalletCommunicator()");
            if (a5.getBooleanFromGTM(a6.getContext(), "shouldInitThemeWallet", false)) {
                d.f();
            }
            d.c(this.f70445a);
        }
    }

    public static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f70444a;

        public f(d dVar) {
            this.f70444a = dVar;
        }

        public final void run() {
            d.g();
        }
    }

    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f70443a;

        public e(d dVar) {
            this.f70443a = dVar;
        }

        public final void run() {
            int integerFromGTM = net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM("walletContactPermissionCount", 2);
            int contactPermissionAskedCount = WalletSharedPrefs.getContactPermissionAskedCount();
            if (integerFromGTM == -1 || contactPermissionAskedCount < integerFromGTM) {
                WalletSharedPrefs.setContactPermissionAskedCount(contactPermissionAskedCount + 1);
                this.f70443a.f70431g.postValue(new net.one97.paytm.wallet.utility.c(Boolean.TRUE));
            }
        }
    }

    static final class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final l f70452a = new l();

        l() {
        }

        public final void run() {
            at.b();
            at.b a2 = at.a();
            kotlin.g.b.k.a((Object) a2, "PaymentSessionEventSender.getInstance()");
            a2.a(Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void c() {
        Future<?> runOnBgThread = AppExecutor.getExecutor().runOnBgThread(l.f70452a);
        net.one97.paytm.base.f fVar = this.f49511a;
        kotlin.g.b.k.a((Object) runOnBgThread, "future");
        fVar.a(runOnBgThread);
    }

    public static final class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f70450a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f70451b;

        public k(d dVar, String str) {
            this.f70450a = dVar;
            this.f70451b = str;
        }

        public final void run() {
            be.a aVar = be.f69718a;
            net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
            kotlin.g.b.k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
            Context context = a2.getContext();
            kotlin.g.b.k.a((Object) context, "WalletCommManager.getWalletCommunicator().context");
            long b2 = be.a.a(context).b("HOME_LAUNCH_MILLIS", 0, false);
            net.one97.paytm.wallet.communicator.c a3 = net.one97.paytm.wallet.communicator.b.a();
            net.one97.paytm.wallet.communicator.c a4 = net.one97.paytm.wallet.communicator.b.a();
            kotlin.g.b.k.a((Object) a4, "WalletCommManager.getWalletCommunicator()");
            a3.pushClickOnPayHawkeyeEvent(a4.getContext(), this.f70451b, System.currentTimeMillis() - b2);
        }
    }

    static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final m f70453a = new m();

        m() {
        }

        public final void run() {
            net.one97.paytm.wallet.a.a aVar = net.one97.paytm.wallet.a.a.f69839a;
            net.one97.paytm.wallet.a.a.b();
        }
    }

    public final void d() {
        Future<?> runOnBgThread = AppExecutor.getExecutor().runOnBgThread(m.f70453a);
        net.one97.paytm.base.f fVar = this.f49511a;
        kotlin.g.b.k.a((Object) runOnBgThread, "f");
        fVar.a(runOnBgThread);
    }

    public static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f70446a;

        public h(d dVar) {
            this.f70446a = dVar;
        }

        public final void run() {
            d.c(this.f70446a);
            this.f70446a.a();
        }
    }

    public static final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f70447a;

        public i(d dVar) {
            this.f70447a = dVar;
        }

        public final void run() {
            y e2 = this.f70447a.f70432h;
            net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
            kotlin.g.b.k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
            e2.postValue(new net.one97.paytm.wallet.utility.c(net.one97.paytm.wallet.p2p.b.a(a2.getContext())));
        }
    }

    static final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f70448a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f70449b;

        j(d dVar, int i2) {
            this.f70448a = dVar;
            this.f70449b = i2;
        }

        public final void run() {
            y f2 = this.f70448a.f70433i;
            Integer valueOf = Integer.valueOf(this.f70449b);
            net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
            kotlin.g.b.k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
            f2.postValue(new net.one97.paytm.wallet.utility.c(new o(valueOf, net.one97.paytm.wallet.p2p.b.a(a2.getContext()))));
        }
    }

    public final void a(int i2) {
        Future<?> runOnBgThread = AppExecutor.getExecutor().runOnBgThread(new j(this, i2));
        net.one97.paytm.base.f fVar = this.f49511a;
        kotlin.g.b.k.a((Object) runOnBgThread, "f");
        fVar.a(runOnBgThread);
    }

    public static final /* synthetic */ void e() {
        net.one97.paytm.wallet.a.a aVar = net.one97.paytm.wallet.a.a.f69839a;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("wallet_send_money_method_name", "qr");
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(net.one97.paytm.wallet.a.a.a(), "wallet_send_money_method_selected", hashMap);
        } catch (Exception unused) {
        }
    }

    public static final /* synthetic */ void f() {
        net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
        net.one97.paytm.wallet.communicator.c a3 = net.one97.paytm.wallet.communicator.b.a();
        kotlin.g.b.k.a((Object) a3, "WalletCommManager.getWalletCommunicator()");
        if (a2.getBooleanFromGTM(a3.getContext(), "shouldShowP2PThemes", false)) {
            net.one97.paytm.wallet.communicator.c a4 = net.one97.paytm.wallet.communicator.b.a();
            kotlin.g.b.k.a((Object) a4, "WalletCommManager.getWalletCommunicator()");
            net.one97.paytm.p2p.theme.g a5 = net.one97.paytm.p2p.theme.g.a(a4.getContext());
            kotlin.g.b.k.a((Object) a5, "P2PThemesDownloadManager…etCommunicator().context)");
            if (!a5.d()) {
                net.one97.paytm.wallet.communicator.c a6 = net.one97.paytm.wallet.communicator.b.a();
                kotlin.g.b.k.a((Object) a6, "WalletCommManager.getWalletCommunicator()");
                net.one97.paytm.p2p.theme.g.a(a6.getContext()).c();
                net.one97.paytm.wallet.communicator.c a7 = net.one97.paytm.wallet.communicator.b.a();
                kotlin.g.b.k.a((Object) a7, "WalletCommManager.getWalletCommunicator()");
                net.one97.paytm.p2p.theme.g a8 = net.one97.paytm.p2p.theme.g.a(a7.getContext());
                kotlin.g.b.k.a((Object) a8, "P2PThemesDownloadManager…etCommunicator().context)");
                a8.e();
            }
        }
    }

    public static final /* synthetic */ void c(d dVar) {
        net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
        kotlin.g.b.k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        a2.getContext();
        net.one97.paytm.wallet.communicator.c a3 = net.one97.paytm.wallet.communicator.b.a();
        kotlin.g.b.k.a((Object) a3, "WalletCommManager.getWalletCommunicator()");
        a3.getContext();
        net.one97.paytm.upi.registration.b.a.b a4 = net.one97.paytm.upi.g.a(net.one97.paytm.upi.g.a((a.C1347a) null));
        kotlin.g.b.k.a((Object) a4, "Injection.provideUpiRegi…nicator().context, null))");
        dVar.f70426b = a4.e();
        net.one97.paytm.wallet.communicator.c a5 = net.one97.paytm.wallet.communicator.b.a();
        kotlin.g.b.k.a((Object) a5, "WalletCommManager.getWalletCommunicator()");
        a5.getContext();
        net.one97.paytm.wallet.communicator.c a6 = net.one97.paytm.wallet.communicator.b.a();
        kotlin.g.b.k.a((Object) a6, "WalletCommManager.getWalletCommunicator()");
        a6.getContext();
        net.one97.paytm.upi.registration.b.a.b a7 = net.one97.paytm.upi.g.a(net.one97.paytm.upi.g.a((a.C1347a) null));
        kotlin.g.b.k.a((Object) a7, "Injection.provideUpiRegi…nicator().context, null))");
        dVar.f70427c = a7.f();
    }

    public static final /* synthetic */ void g() {
        net.one97.paytm.wallet.i.b bVar = net.one97.paytm.wallet.i.b.f70414a;
        net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
        kotlin.g.b.k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        Context context = a2.getContext();
        kotlin.g.b.k.a((Object) context, "WalletCommManager.getWalletCommunicator().context");
        net.one97.paytm.wallet.i.b.a(context);
    }
}
