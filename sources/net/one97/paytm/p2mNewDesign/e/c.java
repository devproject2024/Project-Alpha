package net.one97.paytm.p2mNewDesign.e;

import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2mNewDesign.db.PaymentInstrumentDatabase;
import net.one97.paytm.p2mNewDesign.e.a.e;
import net.one97.paytm.p2mNewDesign.e.a.g;
import net.one97.paytm.p2mNewDesign.e.a.h;
import net.one97.paytm.p2mNewDesign.e.a.i;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.utils.af;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    List<net.one97.paytm.p2mNewDesign.db.b.a> f51254a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f51255b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    Context f51256c;

    /* renamed from: d  reason: collision with root package name */
    private String f51257d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f51258e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<a> f51259f;

    /* renamed from: g  reason: collision with root package name */
    private Comparator<a> f51260g = new b();

    public final void a(LinearLayout linearLayout, ArrayList<a> arrayList, ArrayList<a> arrayList2) {
        boolean z;
        a aVar;
        boolean z2;
        k.c(linearLayout, "view");
        k.c(arrayList, "controller");
        k.c(arrayList2, "disbaledList");
        this.f51259f = arrayList2;
        this.f51258e = linearLayout;
        k.c(arrayList, "controller");
        k.c(arrayList, "controller");
        if (this.f51254a == null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new a(this, (d) null), 3, (Object) null);
        }
        Collections.sort(arrayList, this.f51260g);
        int integerFromGTM = net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(this.f51256c, "wallet_balance_threshold");
        a c2 = c("BALANCE");
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(arrayList);
        if (this.f51254a != null) {
            Iterator<a> it2 = arrayList.iterator();
            z = false;
            int i2 = 0;
            while (it2.hasNext()) {
                a next = it2.next();
                boolean a2 = next.a(this.f51254a);
                if (!a2) {
                    next = null;
                }
                if (a2 && next != null) {
                    arrayList3.remove(next);
                    arrayList3.add(i2, next);
                    i2++;
                    z = true;
                }
            }
        } else {
            z = false;
        }
        if (!z && c2 != null && arrayList.size() > 0) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f2, "DirectPaymentBl.getInstance()");
            if (f2.j() != null) {
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                k.a((Object) f3, "DirectPaymentBl.getInstance()");
                InstrumentInfo j = f3.j();
                k.a((Object) j, "DirectPaymentBl.getInstance().walletInstrumentInfo");
                String totalBalance = j.getTotalBalance();
                k.a((Object) totalBalance, "DirectPaymentBl.getInsta…strumentInfo.totalBalance");
                if (af.a(totalBalance) <= ((double) integerFromGTM)) {
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                    k.a((Object) f4, "DirectPaymentBl.getInstance()");
                    InstrumentInfo j2 = f4.j();
                    k.a((Object) j2, "DirectPaymentBl.getInstance().walletInstrumentInfo");
                    if (!j2.isWalletAPIFAIL()) {
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                        k.a((Object) f5, "DirectPaymentBl.getInstance()");
                        InstrumentInfo j3 = f5.j();
                        k.a((Object) j3, "DirectPaymentBl.getInstance().walletInstrumentInfo");
                        if (j3.isAllPaymodeFetched() && (arrayList.get(0) instanceof i)) {
                            Iterator it3 = arrayList3.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    aVar = null;
                                    z2 = false;
                                    break;
                                }
                                aVar = (a) it3.next();
                                if ((aVar instanceof g) && aVar.f51247c) {
                                    z2 = true;
                                    break;
                                }
                            }
                            if (!z2) {
                                Iterator it4 = arrayList3.iterator();
                                while (true) {
                                    if (!it4.hasNext()) {
                                        break;
                                    }
                                    a aVar2 = (a) it4.next();
                                    if (!(aVar2 instanceof i) && aVar2.f51247c && !(aVar2 instanceof net.one97.paytm.p2mNewDesign.b.b) && !(aVar2 instanceof h)) {
                                        aVar = aVar2;
                                        break;
                                    }
                                }
                            }
                            if (aVar != null) {
                                arrayList3.remove(aVar);
                                arrayList3.add(0, aVar);
                                aVar.a(true);
                            }
                        }
                    }
                }
            }
        }
        this.f51255b.clear();
        this.f51255b.addAll(arrayList3);
        k();
    }

    private void g(String str) {
        k.c(str, "instrumentId");
        if (!p.a(this.f51257d, str, false)) {
            for (a aVar : this.f51255b) {
                aVar.a(p.a(str, aVar.a(), true));
            }
            this.f51257d = str;
        }
    }

    public final void a(String str) {
        k.c(str, "amount");
        for (a aVar : this.f51255b) {
            if (aVar instanceof g) {
                g gVar = (g) aVar;
                InstrumentInfo d2 = gVar.d();
                k.a((Object) d2, "it.instrumentInfo");
                d2.setBlocked(false);
                InstrumentInfo d3 = gVar.d();
                k.a((Object) d3, "it.instrumentInfo");
                d3.setBlockMessage((String) null);
            }
        }
        for (a a2 : this.f51255b) {
            a2.a(str);
        }
        b();
    }

    private a i() {
        for (a aVar : this.f51255b) {
            if (aVar.a().equals(this.f51257d)) {
                return aVar;
            }
        }
        return null;
    }

    public final void a() {
        a i2 = i();
        if (i2 != null) {
            i2.b();
        }
    }

    public final void b() {
        if (!j()) {
            for (a aVar : this.f51255b) {
                if (aVar.f51247c) {
                    g(aVar.a());
                    return;
                }
            }
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a((InstrumentInfo) null);
        }
    }

    private final boolean j() {
        for (a aVar : this.f51255b) {
            if (p.a(aVar.a(), this.f51257d, true)) {
                return aVar.f51247c;
            }
        }
        return false;
    }

    public static final class b implements Comparator<a> {
        b() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            k.c(aVar, "instrument1");
            k.c(aVar2, "instrument2");
            if ((!aVar.f() || !aVar2.f()) && aVar.f()) {
                return 1;
            }
            if (TextUtils.isEmpty(aVar.e()) || TextUtils.isEmpty(aVar2.e())) {
                return aVar.e().compareTo(aVar2.e());
            }
            return k.a(Integer.parseInt(aVar.e()), Integer.parseInt(aVar2.e()));
        }
    }

    private void k() {
        LinearLayout linearLayout = this.f51258e;
        if (linearLayout == null) {
            k.a("paymentInstrumentView");
        }
        linearLayout.removeAllViews();
        int size = this.f51255b.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f51255b.get(i2).f51247c && !z) {
                this.f51255b.get(i2).a(true);
                z = true;
            }
            LinearLayout linearLayout2 = this.f51258e;
            if (linearLayout2 == null) {
                k.a("paymentInstrumentView");
            }
            linearLayout2.addView(this.f51255b.get(i2).c());
        }
    }

    public final void c() {
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        k.a((Object) f2, "DirectPaymentBl.getInstance()");
        if (f2.l() != null) {
            StringBuilder sb = new StringBuilder();
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f3, "DirectPaymentBl.getInstance()");
            InstrumentInfo l = f3.l();
            k.a((Object) l, "DirectPaymentBl.getInsta…().selectedInstrumentInfo");
            sb.append(l.getPayMode());
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f4, "DirectPaymentBl.getInstance()");
            InstrumentInfo l2 = f4.l();
            k.a((Object) l2, "DirectPaymentBl.getInsta…().selectedInstrumentInfo");
            sb.append(l2.getCardLastFourDigit());
            a c2 = c(sb.toString());
            if (c2 != null) {
                ((net.one97.paytm.p2mNewDesign.e.a.a) c2).g();
            }
        }
    }

    public final void b(String str) {
        k.c(str, "selectedInstrumentId");
        this.f51257d = str;
        for (a aVar : this.f51255b) {
            if (!p.a(aVar.a(), this.f51257d, true)) {
                aVar.a(false);
            }
        }
    }

    public final void a(boolean z) {
        a c2 = c("BALANCE");
        if (c2 != null) {
            ((i) c2).d(z);
        }
    }

    public final void d() {
        a c2 = c("UPI");
        if (c2 != null) {
            ((i) c2).g();
        }
    }

    public final boolean e() {
        for (a aVar : this.f51255b) {
            if (aVar instanceof g) {
                ((g) aVar).g();
                return true;
            }
        }
        return false;
    }

    public final a c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (a aVar : this.f51255b) {
            if (p.a(aVar.a(), str, false)) {
                return aVar;
            }
        }
        return null;
    }

    public final void d(String str) {
        k.c(str, "blockMessage");
        for (a aVar : this.f51255b) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f2, "DirectPaymentBl.getInstance()");
            InstrumentInfo l = f2.l();
            if (l != null) {
                String a2 = aVar.a();
                if (!p.a(a2, "UPI" + l.getAccountNumber(), false)) {
                    continue;
                } else if (aVar != null) {
                    g gVar = (g) aVar;
                    InstrumentInfo d2 = gVar.d();
                    k.a((Object) d2, "instrument");
                    d2.setBlockMessage(str);
                    d2.setBlocked(true);
                    gVar.a(d2);
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.instruments.controllers.UPIInstrumentController");
                }
            }
        }
    }

    public final void f() {
        for (a aVar : this.f51255b) {
            if (aVar instanceof i) {
                ((i) aVar).g();
            } else if (aVar instanceof net.one97.paytm.p2mNewDesign.e.a.f) {
                ((net.one97.paytm.p2mNewDesign.e.a.f) aVar).d();
            } else if (aVar instanceof g) {
                ((g) aVar).h();
            } else if (aVar instanceof e) {
                ((e) aVar).d();
            } else if (aVar instanceof net.one97.paytm.p2mNewDesign.e.a.c) {
                ((net.one97.paytm.p2mNewDesign.e.a.c) aVar).d();
            } else if (aVar instanceof net.one97.paytm.p2mNewDesign.e.a.a) {
                net.one97.paytm.p2mNewDesign.e.a.a aVar2 = (net.one97.paytm.p2mNewDesign.e.a.a) aVar;
                aVar2.k();
                aVar2.m();
            } else if (aVar instanceof net.one97.paytm.p2mNewDesign.e.a.b) {
                ((net.one97.paytm.p2mNewDesign.e.a.b) aVar).d();
            } else if (aVar instanceof net.one97.paytm.p2mNewDesign.b.b) {
                ((net.one97.paytm.p2mNewDesign.b.b) aVar).h();
            } else if (aVar instanceof net.one97.paytm.p2mNewDesign.b.c) {
                ((net.one97.paytm.p2mNewDesign.b.c) aVar).j();
            } else if (aVar instanceof net.one97.paytm.p2mNewDesign.e.a.d) {
                ((net.one97.paytm.p2mNewDesign.e.a.d) aVar).h();
            }
        }
    }

    public final void g() {
        for (a aVar : this.f51255b) {
            if (aVar instanceof i) {
                ((i) aVar).h();
            } else if (aVar instanceof net.one97.paytm.p2mNewDesign.e.a.f) {
                ((net.one97.paytm.p2mNewDesign.e.a.f) aVar).g();
            } else if (aVar instanceof g) {
                ((g) aVar).j();
            } else if (aVar instanceof e) {
                ((e) aVar).g();
            } else if (aVar instanceof net.one97.paytm.p2mNewDesign.e.a.c) {
                ((net.one97.paytm.p2mNewDesign.e.a.c) aVar).g();
            } else if (aVar instanceof net.one97.paytm.p2mNewDesign.e.a.a) {
                net.one97.paytm.p2mNewDesign.e.a.a aVar2 = (net.one97.paytm.p2mNewDesign.e.a.a) aVar;
                aVar2.n();
                aVar2.l();
            } else if (aVar instanceof net.one97.paytm.p2mNewDesign.e.a.b) {
                ((net.one97.paytm.p2mNewDesign.e.a.b) aVar).g();
            } else if (aVar instanceof net.one97.paytm.p2mNewDesign.b.b) {
                ((net.one97.paytm.p2mNewDesign.b.b) aVar).g();
            } else if (aVar instanceof net.one97.paytm.p2mNewDesign.b.c) {
                ((net.one97.paytm.p2mNewDesign.b.c) aVar).k();
            } else if (aVar instanceof net.one97.paytm.p2mNewDesign.e.a.d) {
                ((net.one97.paytm.p2mNewDesign.e.a.d) aVar).j();
            }
        }
    }

    public final void h() {
        a c2 = c("BALANCE");
        if (c2 != null) {
            ((i) c2).d();
        }
    }

    public final boolean e(String str) {
        a c2;
        k.c(str, "pcfNetAmt");
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        k.a((Object) f2, "DirectPaymentBl.getInstance()");
        if (f2.l() == null) {
            return true;
        }
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        k.a((Object) f3, "DirectPaymentBl.getInstance()");
        InstrumentInfo l = f3.l();
        k.a((Object) l, "DirectPaymentBl.getInsta…().selectedInstrumentInfo");
        String payMode = l.getPayMode();
        if (p.a(payMode, "BALANCE", true)) {
            a c3 = c(payMode);
            if (c3 != null) {
                ((i) c3).b(str);
                return c3.f51247c;
            }
        } else if (p.a(payMode, SDKConstants.AI_KEY_PPBL, true)) {
            a c4 = c(payMode);
            if (c4 != null) {
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                k.a((Object) f4, "DirectPaymentBl.getInstance()");
                ((e) c4).a(str, f4.l());
                return c4.f51247c;
            }
        } else if (p.a(payMode, "UPI", true)) {
            a c5 = c(payMode);
            if (c5 != null) {
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                k.a((Object) f5, "DirectPaymentBl.getInstance()");
                ((g) c5).a(str, f5.l());
                return c5.f51247c;
            }
        } else if (p.a(payMode, "PAYTM_DIGITAL_CREDIT", true) && (c2 = c(payMode)) != null) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f6, "DirectPaymentBl.getInstance()");
            ((net.one97.paytm.p2mNewDesign.e.a.f) c2).a(str, f6.l());
            return c2.f51247c;
        }
        return true;
    }

    public final void b(boolean z) {
        if (z) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f2, "DirectPaymentBl.getInstance()");
            a c2 = c(f2.H());
            if (c2 == null ? true : c2.f51247c) {
                for (a i2 : this.f51255b) {
                    i2.i();
                }
            }
        }
    }

    public final void a(Context context) {
        k.c(context, "context");
        this.f51256c = context;
    }

    public final void c(boolean z) {
        for (a aVar : this.f51255b) {
            if (aVar instanceof e) {
                ((e) aVar).d(z);
                return;
            }
        }
    }

    public final boolean f(String str) {
        k.c(str, SDKConstants.KEY_PAYMODE);
        for (a aVar : this.f51255b) {
            if (aVar instanceof g) {
                return true;
            }
        }
        return false;
    }

    @kotlin.d.b.a.f(b = "InstrumentsHolder.kt", c = {231}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/instruments/InstrumentsHolder$getLastUsedInstrumentFromDB$1")
    static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c cVar, d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            a aVar = new a(this.this$0, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                PaymentInstrumentDatabase.a aVar2 = PaymentInstrumentDatabase.f51202a;
                Context context = this.this$0.f51256c;
                if (context == null) {
                    k.a();
                }
                PaymentInstrumentDatabase a2 = aVar2.a(context);
                this.this$0.f51254a = a2.a().a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(this.this$0.f51256c, "MaxLastUsedInstrumentAndroid"));
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                k.a((Object) f2, "DirectPaymentBl.getInstance()");
                f2.a(this.this$0.f51254a);
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }
}
