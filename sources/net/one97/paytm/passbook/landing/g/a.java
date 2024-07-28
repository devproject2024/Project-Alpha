package net.one97.paytm.passbook.landing.g;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.d.f;
import kotlin.p;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.passbook.beans.BankAccStatusListener;
import net.one97.paytm.passbook.beans.CJRAccountSummary;
import net.one97.paytm.passbook.beans.CJRCashWallet;
import net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2;
import net.one97.paytm.passbook.beans.CustProductList;
import net.one97.paytm.passbook.beans.creditcard.CreditCardInfoResponse;
import net.one97.paytm.passbook.beans.goldv2.GoldResponse;
import net.one97.paytm.passbook.beans.postpaid.CJRPPUserProfileKycTnc;
import net.one97.paytm.passbook.beans.upi.UpiAvailabilityModel;
import net.one97.paytm.passbook.beans.upi.UpiProfileModel;
import net.one97.paytm.passbook.landing.e.aa;
import net.one97.paytm.passbook.landing.e.ac;
import net.one97.paytm.passbook.landing.e.s;
import net.one97.paytm.passbook.landing.e.u;
import net.one97.paytm.passbook.landing.e.v;
import net.one97.paytm.passbook.landing.e.x;
import net.one97.paytm.passbook.landing.repositories.g;
import net.one97.paytm.upi.util.UpiConstants;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public y<net.one97.paytm.passbook.landing.e.a> f57738a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<Boolean> f57739b = new y<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f57740c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f57741d;

    /* renamed from: e  reason: collision with root package name */
    private d f57742e = d.HOME;

    /* renamed from: f  reason: collision with root package name */
    private final CoroutineExceptionHandler f57743f = new C1093a(CoroutineExceptionHandler.Key);

    public static final class c<T> implements z<net.one97.paytm.passbook.mapping.a.f<? extends UpiProfileModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57744a;

        public c(a aVar) {
            this.f57744a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.f fVar = (net.one97.paytm.passbook.mapping.a.f) obj;
            y<net.one97.paytm.passbook.landing.e.a> yVar = this.f57744a.f57738a;
            kotlin.g.b.k.a((Object) fVar, "it");
            yVar.setValue(new aa(fVar));
        }
    }

    static final class g<T> implements z<net.one97.paytm.passbook.mapping.a.f<? extends CreditCardInfoResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57746a;

        g(a aVar) {
            this.f57746a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.f fVar = (net.one97.paytm.passbook.mapping.a.f) obj;
            y<net.one97.paytm.passbook.landing.e.a> yVar = this.f57746a.f57738a;
            kotlin.g.b.k.a((Object) fVar, "it");
            yVar.setValue(new net.one97.paytm.passbook.landing.e.f(fVar));
        }
    }

    static final class h<T> implements z<net.one97.paytm.passbook.mapping.a.f<? extends CJRAccountSummary>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57747a;

        h(a aVar) {
            this.f57747a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.f fVar = (net.one97.paytm.passbook.mapping.a.f) obj;
            y<net.one97.paytm.passbook.landing.e.a> yVar = this.f57747a.f57738a;
            kotlin.g.b.k.a((Object) fVar, "it");
            yVar.setValue(new net.one97.paytm.passbook.landing.e.j(fVar));
        }
    }

    static final class i<T> implements z<net.one97.paytm.passbook.mapping.a.f<? extends CustProductList>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57748a;

        i(a aVar) {
            this.f57748a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.f fVar = (net.one97.paytm.passbook.mapping.a.f) obj;
            y<net.one97.paytm.passbook.landing.e.a> yVar = this.f57748a.f57738a;
            kotlin.g.b.k.a((Object) fVar, "it");
            yVar.setValue(new net.one97.paytm.passbook.landing.e.l(fVar));
        }
    }

    static final class j<T> implements z<net.one97.paytm.passbook.genericPassbook.b<? extends IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57749a;

        j(a aVar) {
            this.f57749a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.genericPassbook.b bVar = (net.one97.paytm.passbook.genericPassbook.b) obj;
            int i2 = b.f57757a[bVar.f57331a.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    this.f57749a.f57740c = false;
                    this.f57749a.f57741d = true;
                } else if (i2 == 3) {
                    this.f57749a.f57740c = false;
                    this.f57749a.f57741d = false;
                }
            }
            y<net.one97.paytm.passbook.landing.e.a> yVar = this.f57749a.f57738a;
            kotlin.g.b.k.a((Object) bVar, "it");
            yVar.setValue(new net.one97.paytm.passbook.landing.e.n(bVar));
        }
    }

    static final class k<T> implements z<net.one97.paytm.passbook.mapping.a.f<? extends CJRCashWallet>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57750a;

        k(a aVar) {
            this.f57750a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.f fVar = (net.one97.paytm.passbook.mapping.a.f) obj;
            y<net.one97.paytm.passbook.landing.e.a> yVar = this.f57750a.f57738a;
            kotlin.g.b.k.a((Object) fVar, "it");
            yVar.setValue(new net.one97.paytm.passbook.landing.e.c(fVar));
        }
    }

    static final class l<T> implements z<net.one97.paytm.passbook.mapping.a.f<? extends GoldResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57751a;

        l(a aVar) {
            this.f57751a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.f fVar = (net.one97.paytm.passbook.mapping.a.f) obj;
            y<net.one97.paytm.passbook.landing.e.a> yVar = this.f57751a.f57738a;
            kotlin.g.b.k.a((Object) fVar, "it");
            yVar.postValue(new net.one97.paytm.passbook.landing.e.h(fVar));
        }
    }

    static final class m<T> implements z<net.one97.paytm.passbook.mapping.a.f<? extends CJRPaytmMoneyInfoV2>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57752a;

        m(a aVar) {
            this.f57752a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.f fVar = (net.one97.paytm.passbook.mapping.a.f) obj;
            y<net.one97.paytm.passbook.landing.e.a> yVar = this.f57752a.f57738a;
            kotlin.g.b.k.a((Object) fVar, "it");
            yVar.setValue(new net.one97.paytm.passbook.landing.e.p(fVar));
        }
    }

    static final class n<T> implements z<net.one97.paytm.passbook.mapping.a.f<? extends CJRPPUserProfileKycTnc>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57753a;

        n(a aVar) {
            this.f57753a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.f fVar = (net.one97.paytm.passbook.mapping.a.f) obj;
            y<net.one97.paytm.passbook.landing.e.a> yVar = this.f57753a.f57738a;
            kotlin.g.b.k.a((Object) fVar, "it");
            yVar.setValue(new s(fVar));
        }
    }

    static final class o<T> implements z<net.one97.paytm.passbook.mapping.a.f<? extends CustProductList>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57754a;

        o(a aVar) {
            this.f57754a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.f fVar = (net.one97.paytm.passbook.mapping.a.f) obj;
            y<net.one97.paytm.passbook.landing.e.a> yVar = this.f57754a.f57738a;
            kotlin.g.b.k.a((Object) fVar, "it");
            yVar.setValue(new x(fVar));
        }
    }

    static final class p<T> implements z<net.one97.paytm.passbook.mapping.a.f<? extends CJRAccountSummary>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57755a;

        p(a aVar) {
            this.f57755a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.f fVar = (net.one97.paytm.passbook.mapping.a.f) obj;
            y<net.one97.paytm.passbook.landing.e.a> yVar = this.f57755a.f57738a;
            kotlin.g.b.k.a((Object) fVar, "it");
            yVar.setValue(new v(fVar));
        }
    }

    static final class q<T> implements z<net.one97.paytm.passbook.mapping.a.f<? extends UpiAvailabilityModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57756a;

        q(a aVar) {
            this.f57756a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.f fVar = (net.one97.paytm.passbook.mapping.a.f) obj;
            com.paytm.utility.q.b("hasUPIVPA() called");
            y<net.one97.paytm.passbook.landing.e.a> yVar = this.f57756a.f57738a;
            kotlin.g.b.k.a((Object) fVar, "it");
            yVar.setValue(new ac(fVar));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        kotlin.g.b.k.c(application, "application");
    }

    public final void a(d dVar) {
        kotlin.g.b.k.c(dVar, "source");
        this.f57742e = dVar;
    }

    public final void a() {
        net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
        kotlin.g.b.k.a((Object) b2, "PassbookHelper.getImplListener()");
        Context b3 = b2.b();
        kotlin.g.b.k.a((Object) b3, "PassbookHelper.getImplLi…ener().applicationContext");
        if (!net.one97.paytm.passbook.utility.f.a(b3)) {
            this.f57739b.setValue(Boolean.TRUE);
            return;
        }
        i();
        net.one97.paytm.passbook.landing.repositories.g.f57781b.a((BankAccStatusListener) new f(this));
        l();
        com.paytm.utility.q.b("hasUPIVPA() called from fetchAllData()");
        b();
        if (this.f57742e != d.PAYMENTS_BANK) {
            j();
            k();
            h();
            d();
            e();
            f();
            g();
            n();
            o();
        }
    }

    static final class f implements BankAccStatusListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57745a;

        f(a aVar) {
            this.f57745a = aVar;
        }

        public final void onBankStatus(BankAccStatusListener.AccountStatus accountStatus) {
            a.a(this.f57745a);
        }
    }

    /* renamed from: net.one97.paytm.passbook.landing.g.a$a  reason: collision with other inner class name */
    public static final class C1093a extends kotlin.d.a implements CoroutineExceptionHandler {
        public C1093a(f.c cVar) {
            super(cVar);
        }

        public final void handleException(kotlin.d.f fVar, Throwable th) {
            net.one97.paytm.common.utility.l.a(th);
        }
    }

    private final void d() {
        if (net.one97.paytm.passbook.d.b().a("pass2CashbackVouchersEnabled", false)) {
            this.f57738a.setValue(new net.one97.paytm.passbook.landing.e.e());
        }
    }

    private final void e() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), this.f57743f, (CoroutineStart) null, new d(this, (kotlin.d.d) null), 2, (Object) null);
    }

    private final void f() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), this.f57743f, (CoroutineStart) null, new b(this, (kotlin.d.d) null), 2, (Object) null);
    }

    private final void g() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), this.f57743f, (CoroutineStart) null, new e(this, (kotlin.d.d) null), 2, (Object) null);
    }

    public final void b() {
        net.one97.paytm.passbook.landing.repositories.k.f57801b.c().observeForever(new q(this));
    }

    private final void h() {
        if (!net.one97.paytm.passbook.d.b().a("pass2postpaidEnabled", false)) {
            return;
        }
        if (net.one97.paytm.passbook.d.b().a("pass2postpaidEnabled", true)) {
            String f2 = net.one97.paytm.passbook.landing.repositories.i.f57793b.f();
            if (f2 != null) {
                net.one97.paytm.passbook.landing.repositories.i iVar = net.one97.paytm.passbook.landing.repositories.i.f57793b;
                if (!kotlin.g.b.k.a((Object) f2, (Object) net.one97.paytm.passbook.landing.repositories.i.c())) {
                    net.one97.paytm.passbook.landing.repositories.i iVar2 = net.one97.paytm.passbook.landing.repositories.i.f57793b;
                    if (kotlin.g.b.k.a((Object) f2, (Object) net.one97.paytm.passbook.landing.repositories.i.b()) || net.one97.paytm.passbook.landing.repositories.i.f57793b.e()) {
                        m();
                        return;
                    }
                    return;
                }
            }
            this.f57738a.postValue(new u());
        } else if (net.one97.paytm.passbook.landing.repositories.i.f57793b.e()) {
            m();
        } else {
            String f3 = net.one97.paytm.passbook.landing.repositories.i.f57793b.f();
            net.one97.paytm.passbook.landing.repositories.i iVar3 = net.one97.paytm.passbook.landing.repositories.i.f57793b;
            if (kotlin.g.b.k.a((Object) f3, (Object) net.one97.paytm.passbook.landing.repositories.i.b())) {
                m();
                return;
            }
            net.one97.paytm.passbook.landing.repositories.i iVar4 = net.one97.paytm.passbook.landing.repositories.i.f57793b;
            if (kotlin.g.b.k.a((Object) f3, (Object) net.one97.paytm.passbook.landing.repositories.i.c())) {
                this.f57738a.postValue(new u());
            }
        }
    }

    private final void i() {
        net.one97.paytm.passbook.landing.repositories.m.f57814b.b().observeForever(new k(this));
    }

    private final void j() {
        if (net.one97.paytm.passbook.d.b().a("pass2PaytmMoneyEnabled", false)) {
            net.one97.paytm.passbook.landing.repositories.h.f57790b.b().observeForever(new m(this));
        }
    }

    private final void k() {
        if (net.one97.paytm.passbook.d.b().a("pass2PFCCEnabled", false)) {
            net.one97.paytm.passbook.landing.repositories.b.f57766b.b().observeForever(new g(this));
        }
    }

    public final void c() {
        net.one97.paytm.passbook.landing.repositories.g.f57781b.c().observeForever(new p(this));
    }

    private final void l() {
        net.one97.paytm.passbook.landing.repositories.g gVar = net.one97.paytm.passbook.landing.repositories.g.f57781b;
        if (net.one97.paytm.passbook.landing.repositories.g.d()) {
            net.one97.paytm.passbook.landing.repositories.g.f57781b.b().observeForever(new i(this));
        }
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "currentAcctRefId");
        net.one97.paytm.passbook.landing.repositories.g gVar = net.one97.paytm.passbook.landing.repositories.g.f57781b;
        if (net.one97.paytm.passbook.landing.repositories.g.d()) {
            net.one97.paytm.passbook.landing.repositories.g.f57781b.a(str).observeForever(new h(this));
        }
    }

    private final void m() {
        net.one97.paytm.passbook.landing.repositories.i.f57793b.d().observeForever(new n(this));
    }

    private final void n() {
        if (net.one97.paytm.passbook.d.b().a("pfg_passbook_card", true) && !this.f57741d && !this.f57740c) {
            this.f57740c = true;
            net.one97.paytm.passbook.genericPassbook.d.a.e eVar = net.one97.paytm.passbook.genericPassbook.d.a.e.f57457a;
            Application application = getApplication();
            kotlin.g.b.k.a((Object) application, "getApplication()");
            eVar.a(application).observeForever(new j(this));
        }
    }

    private final void o() {
        if (net.one97.paytm.passbook.d.b().a("pass2PaytmGoldEnabled", true)) {
            net.one97.paytm.passbook.landing.repositories.c cVar = net.one97.paytm.passbook.landing.repositories.c.f57769b;
            net.one97.paytm.passbook.landing.repositories.c.b().observeForever(new l(this));
        }
    }

    @kotlin.d.b.a.f(b = "BalanceSummaryViewModel.kt", c = {94, 96, 103}, d = "invokeSuspend", e = "net/one97/paytm/passbook/landing/viewModel/BalanceSummaryViewModel$checkBrandRewardsData$1")
    static final class b extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            b bVar = new b(this.this$0, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        if (obj instanceof p.b) {
                            throw ((p.b) obj).exception;
                        }
                        return kotlin.x.f47997a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                this.label = 1;
                if (DelayKt.delay(50, this) == aVar) {
                    return aVar;
                }
            } else {
                throw ((p.b) obj).exception;
            }
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getMain(), new kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                int label;
                private CoroutineScope p$;
                final /* synthetic */ b this$0;

                {
                    this.this$0 = r1;
                }

                public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                    kotlin.g.b.k.c(dVar, "completion");
                    AnonymousClass1 r0 = 

                    @kotlin.d.b.a.f(b = "BalanceSummaryViewModel.kt", c = {78, 80, 83}, d = "invokeSuspend", e = "net/one97/paytm/passbook/landing/viewModel/BalanceSummaryViewModel$checkPaytmRewardPoints$1")
                    static final class d extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                        int label;
                        private CoroutineScope p$;
                        final /* synthetic */ a this$0;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        d(a aVar, kotlin.d.d dVar) {
                            super(2, dVar);
                            this.this$0 = aVar;
                        }

                        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                            kotlin.g.b.k.c(dVar, "completion");
                            d dVar2 = new d(this.this$0, dVar);
                            dVar2.p$ = (CoroutineScope) obj;
                            return dVar2;
                        }

                        public final Object invoke(Object obj, Object obj2) {
                            return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
                        }

                        public final Object invokeSuspend(Object obj) {
                            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                            int i2 = this.label;
                            if (i2 != 0) {
                                if (i2 != 1) {
                                    if (i2 == 2) {
                                        if (obj instanceof p.b) {
                                            throw ((p.b) obj).exception;
                                        }
                                        return kotlin.x.f47997a;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                } else if (obj instanceof p.b) {
                                    throw ((p.b) obj).exception;
                                }
                            } else if (!(obj instanceof p.b)) {
                                this.label = 1;
                                if (DelayKt.delay(10, this) == aVar) {
                                    return aVar;
                                }
                            } else {
                                throw ((p.b) obj).exception;
                            }
                            this.label = 2;
                            if (BuildersKt.withContext(Dispatchers.getMain(), new kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                                int label;
                                private CoroutineScope p$;
                                final /* synthetic */ d this$0;

                                {
                                    this.this$0 = r1;
                                }

                                public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                    kotlin.g.b.k.c(dVar, "completion");
                                    AnonymousClass1 r0 = 

                                    @kotlin.d.b.a.f(b = "BalanceSummaryViewModel.kt", c = {114, 116, 123}, d = "invokeSuspend", e = "net/one97/paytm/passbook/landing/viewModel/BalanceSummaryViewModel$checkStickersData$1")
                                    static final class e extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                                        int label;
                                        private CoroutineScope p$;
                                        final /* synthetic */ a this$0;

                                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                        e(a aVar, kotlin.d.d dVar) {
                                            super(2, dVar);
                                            this.this$0 = aVar;
                                        }

                                        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                            kotlin.g.b.k.c(dVar, "completion");
                                            e eVar = new e(this.this$0, dVar);
                                            eVar.p$ = (CoroutineScope) obj;
                                            return eVar;
                                        }

                                        public final Object invoke(Object obj, Object obj2) {
                                            return ((e) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
                                        }

                                        public final Object invokeSuspend(Object obj) {
                                            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                            int i2 = this.label;
                                            if (i2 != 0) {
                                                if (i2 != 1) {
                                                    if (i2 == 2) {
                                                        if (obj instanceof p.b) {
                                                            throw ((p.b) obj).exception;
                                                        }
                                                        return kotlin.x.f47997a;
                                                    }
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                } else if (obj instanceof p.b) {
                                                    throw ((p.b) obj).exception;
                                                }
                                            } else if (!(obj instanceof p.b)) {
                                                this.label = 1;
                                                if (DelayKt.delay(100, this) == aVar) {
                                                    return aVar;
                                                }
                                            } else {
                                                throw ((p.b) obj).exception;
                                            }
                                            this.label = 2;
                                            if (BuildersKt.withContext(Dispatchers.getMain(), new kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                                                int label;
                                                private CoroutineScope p$;
                                                final /* synthetic */ e this$0;

                                                {
                                                    this.this$0 = r1;
                                                }

                                                public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                                    kotlin.g.b.k.c(dVar, "completion");
                                                    AnonymousClass1 r0 = 

                                                    public static final /* synthetic */ void a(a aVar) {
                                                        net.one97.paytm.passbook.landing.repositories.g gVar = net.one97.paytm.passbook.landing.repositories.g.f57781b;
                                                        y yVar = new y();
                                                        kotlin.g.b.k.a((Object) net.one97.paytm.passbook.mapping.e.a(), "GTMLoader.getInstance()");
                                                        String e2 = com.paytm.utility.b.e(gVar.a(), net.one97.paytm.passbook.mapping.e.l());
                                                        Map hashMap = new HashMap();
                                                        Context a2 = gVar.a();
                                                        if (a2 != null && !TextUtils.isEmpty(net.one97.paytm.passbook.mapping.b.a(a2))) {
                                                            String a3 = net.one97.paytm.passbook.mapping.b.a(a2);
                                                            kotlin.g.b.k.a((Object) a3, "CJRServerUtility.getSSOToken(it)");
                                                            hashMap.put("User-Token", a3);
                                                        }
                                                        hashMap.put("Content-Type", "application/json");
                                                        hashMap.put("channel", UpiConstants.B2C_ANDROID);
                                                        kotlin.g.b.k.a((Object) e2, "custProductListUrl");
                                                        gVar.a(e2, new CustProductList(), hashMap, new g.f(yVar), new g.e(yVar));
                                                        yVar.observeForever(new o(aVar));
                                                    }
                                                }
