package net.one97.paytm.moneytransfer.viewmodel;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.aj;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.moneytransfer.utils.j;
import net.one97.paytm.upi.common.UpiCustomVolleyError;

public final class g extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public final y<net.one97.paytm.moneytransfer.model.c<IJRPaytmDataModel>> f54756a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final net.one97.paytm.moneytransfer.b.a.b f54757b;

    /* renamed from: c  reason: collision with root package name */
    public int f54758c;

    /* renamed from: d  reason: collision with root package name */
    public final y<net.one97.paytm.moneytransfer.model.c<ArrayList<BeneficiaryEntity>>> f54759d;

    /* renamed from: e  reason: collision with root package name */
    public final LiveData<String> f54760e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final j f54761f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Set<String> f54762g;

    /* renamed from: h  reason: collision with root package name */
    private Job f54763h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final y<String> f54764i;

    static final class f<T1, T2> implements io.reactivex.rxjava3.d.b<x, Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f54777a = new f();

        f() {
        }

        public final /* synthetic */ void accept(Object obj, Object obj2) {
            Throwable th = (Throwable) obj2;
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Application application) {
        super(application);
        k.c(application, "application");
        net.one97.paytm.moneytransfer.b.a.b a2 = net.one97.paytm.moneytransfer.b.a(application);
        k.a((Object) a2, "Injection.provideMoneyTr…erRepository(application)");
        this.f54757b = a2;
        this.f54758c = -1;
        this.f54759d = new y<>();
        this.f54761f = new j();
        this.f54762g = new LinkedHashSet();
        this.f54764i = new y<>();
        this.f54760e = this.f54764i;
    }

    public final void a(List<? extends BeneficiaryEntity> list) {
        k.c(list, "list");
        for (BeneficiaryEntity beneficiaryEntity : list) {
            Set<String> set = this.f54762g;
            String str = beneficiaryEntity.beneficiaryId;
            k.a((Object) str, "it.beneficiaryId");
            set.add(str);
        }
    }

    public static final class a implements a.C0960a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f54765a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f54766b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f54767c;

        public a(g gVar, String str, String str2) {
            this.f54765a = gVar;
            this.f54766b = str;
            this.f54767c = str2;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
            CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) iJRPaytmDataModel;
            if (cJRAddBeneficiary.getError() != null) {
                CJRAddBeneficiary.CJRAddBeneficiairyError error = cJRAddBeneficiary.getError();
                k.a((Object) error, "addBeneficiary.error");
                if (!TextUtils.isEmpty(error.getErrorMsg())) {
                    UpiCustomVolleyError upiCustomVolleyError = new UpiCustomVolleyError();
                    CJRAddBeneficiary.CJRAddBeneficiairyError error2 = cJRAddBeneficiary.getError();
                    k.a((Object) error2, "addBeneficiary.error");
                    upiCustomVolleyError.setAlertMessage(error2.getErrorMsg());
                    y a2 = this.f54765a.f54756a;
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    a2.setValue(c.a.a(upiCustomVolleyError));
                    return;
                }
                y a3 = this.f54765a.f54756a;
                c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
                a3.setValue(c.a.a((UpiCustomVolleyError) null));
            } else if (p.a(cJRAddBeneficiary.getStatusCode(), WebLogin.RESPONSE_CODE_SUCCESS, true)) {
                this.f54765a.f54757b.a(this.f54766b, this.f54767c);
                y a4 = this.f54765a.f54756a;
                c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
                a4.setValue(c.a.a(iJRPaytmDataModel));
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            y a2 = this.f54765a.f54756a;
            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
            a2.setValue(c.a.a(upiCustomVolleyError));
        }
    }

    public final void a(int i2) {
        int i3 = this.f54758c;
        if (i3 < 0) {
            a(0, i2);
        } else {
            a(i2, i3);
        }
    }

    /* access modifiers changed from: private */
    public final void a(int i2, int i3) {
        y<net.one97.paytm.moneytransfer.model.c<ArrayList<BeneficiaryEntity>>> yVar = this.f54759d;
        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
        yVar.setValue(c.a.a());
        this.f54757b.a((a.C0960a) new b(this, i2, i3), (a.b) null, i2, i3);
    }

    public static final class b implements a.C0960a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f54768a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f54769b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f54770c;

        b(g gVar, int i2, int i3) {
            this.f54768a = gVar;
            this.f54769b = i2;
            this.f54770c = i3;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
            try {
                CJRKYCBeneficiaryBase cJRKYCBeneficiaryBase = (CJRKYCBeneficiaryBase) iJRPaytmDataModel;
                this.f54768a.f54758c = cJRKYCBeneficiaryBase.getTotalCount();
                if (cJRKYCBeneficiaryBase.getBeneficiariesList() == null || cJRKYCBeneficiaryBase.getBeneficiariesList().size() <= 0) {
                    y c2 = this.f54768a.f54759d;
                    c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                    c2.setValue(c.a.a((UpiCustomVolleyError) null));
                    return;
                }
                g.a(this.f54768a, cJRKYCBeneficiaryBase, this.f54769b, this.f54770c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            y c2 = this.f54768a.f54759d;
            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
            c2.setValue(c.a.a(upiCustomVolleyError));
        }
    }

    public final void a(String str) {
        k.c(str, "query");
        Job job = this.f54763h;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.f54763h = BuildersKt__Builders_commonKt.launch$default(aj.a(this), (kotlin.d.f) null, (CoroutineStart) null, new c(this, str, (kotlin.d.d) null), 3, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0059, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r7, r9, true) != false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0087, code lost:
        if (kotlin.m.p.a((java.lang.CharSequence) r7, r9, true) != false) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<net.one97.paytm.common.entity.IJRDataModel> a(java.lang.String r10, java.util.List<? extends net.one97.paytm.common.entity.IJRDataModel> r11) {
        /*
            java.lang.String r0 = "query"
            kotlin.g.b.k.c(r10, r0)
            java.lang.String r0 = "list"
            kotlin.g.b.k.c(r11, r0)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r11 = r11.iterator()
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x001b:
            boolean r5 = r11.hasNext()
            r6 = 1
            if (r5 == 0) goto L_0x0093
            java.lang.Object r5 = r11.next()
            r7 = r5
            net.one97.paytm.common.entity.IJRDataModel r7 = (net.one97.paytm.common.entity.IJRDataModel) r7
            boolean r8 = r7 instanceof net.one97.paytm.moneytransferv4.search.SearchTitleModel
            if (r8 == 0) goto L_0x0030
            int r2 = r2 + 1
            goto L_0x008d
        L_0x0030:
            boolean r8 = r7 instanceof net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity
            if (r8 == 0) goto L_0x005e
            net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity r7 = (net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r7
            java.lang.String r8 = net.one97.paytm.moneytransfer.utils.m.b((net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r7)
            java.lang.String r9 = "MoneyTransferUtils.getAccountHolderName(it)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r9 = r10
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r8 = kotlin.m.p.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r9, (boolean) r6)
            if (r8 != 0) goto L_0x005b
            java.lang.String r7 = net.one97.paytm.moneytransfer.utils.m.a((net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity) r7)
            java.lang.String r8 = "MoneyTransferUtils.getAccountOrVpa(it)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.CharSequence) r9, (boolean) r6)
            if (r7 == 0) goto L_0x008c
        L_0x005b:
            int r3 = r3 + 1
            goto L_0x008d
        L_0x005e:
            boolean r8 = r7 instanceof net.one97.paytm.moneytransfer.model.ContactItemModel
            if (r8 == 0) goto L_0x008c
            net.one97.paytm.moneytransfer.model.ContactItemModel r7 = (net.one97.paytm.moneytransfer.model.ContactItemModel) r7
            java.lang.String r8 = r7.getName()
            java.lang.String r9 = "it.name"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r9 = r10
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r8 = kotlin.m.p.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r9, (boolean) r6)
            if (r8 != 0) goto L_0x0089
            java.lang.String r7 = r7.getPhnNo()
            java.lang.String r8 = "it.phnNo"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.CharSequence) r9, (boolean) r6)
            if (r7 == 0) goto L_0x008c
        L_0x0089:
            int r4 = r4 + 1
            goto L_0x008d
        L_0x008c:
            r6 = 0
        L_0x008d:
            if (r6 == 0) goto L_0x001b
            r0.add(r5)
            goto L_0x001b
        L_0x0093:
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r10 = kotlin.a.k.c(r0)
            int r11 = r10.size()
            if (r2 != r11) goto L_0x00a6
            kotlin.a.w r10 = kotlin.a.w.INSTANCE
            java.util.List r10 = (java.util.List) r10
            return r10
        L_0x00a6:
            if (r3 != 0) goto L_0x00b1
            int r11 = r10.size()
            int r11 = r11 - r6
            r10.remove(r11)
            return r10
        L_0x00b1:
            if (r4 != 0) goto L_0x00b6
            r10.remove(r1)
        L_0x00b6:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.viewmodel.g.a(java.lang.String, java.util.List):java.util.List");
    }

    @kotlin.d.b.a.f(b = "MoneyTransferViewAllBeneficiaryViewModel.kt", c = {148}, d = "invokeSuspend", e = "net.one97.paytm.moneytransfer.viewmodel.MoneyTransferViewAllBeneficiaryViewModel$onQueryUpdate$1")
    static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ String $query;
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ g this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(g gVar, String str, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = gVar;
            this.$query = str;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            c cVar = new c(this.this$0, this.$query, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                this.L$0 = this.p$;
                this.label = 1;
                if (DelayKt.delay(150, this) == aVar) {
                    return aVar;
                }
            } else if (i2 == 1) {
                ResultKt.a(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            y f2 = this.this$0.f54764i;
            String str = this.$query;
            if (str != null) {
                f2.setValue(p.b(str).toString());
                return x.f47997a;
            }
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        }
    }

    public static final /* synthetic */ void a(g gVar, CJRKYCBeneficiaryBase cJRKYCBeneficiaryBase, int i2, int i3) {
        ArrayList<BeneficiaryEntity> beneficiariesList = cJRKYCBeneficiaryBase.getBeneficiariesList();
        io.reactivex.rxjava3.a.y.a(new d(gVar, beneficiariesList)).a(io.reactivex.rxjava3.android.b.a.a()).b(io.reactivex.rxjava3.i.a.b()).a((io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.b.c>) new e(gVar, beneficiariesList, i2, i3)).a(f.f54777a);
    }

    static final class d<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f54771a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f54772b;

        d(g gVar, ArrayList arrayList) {
            this.f54771a = gVar;
            this.f54772b = arrayList;
        }

        public final /* synthetic */ Object call() {
            j unused = this.f54771a.f54761f;
            j.a((Context) this.f54771a.getApplication(), (ArrayList<BeneficiaryEntity>) this.f54772b);
            return x.f47997a;
        }
    }

    static final class e<T> implements io.reactivex.rxjava3.d.g<io.reactivex.rxjava3.b.c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f54773a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f54774b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f54775c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f54776d;

        e(g gVar, ArrayList arrayList, int i2, int i3) {
            this.f54773a = gVar;
            this.f54774b = arrayList;
            this.f54775c = i2;
            this.f54776d = i3;
        }

        public final /* synthetic */ void accept(Object obj) {
            y c2 = this.f54773a.f54759d;
            c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
            ArrayList arrayList = this.f54774b;
            k.a((Object) arrayList, "v4Beneficiaries");
            Collection arrayList2 = new ArrayList();
            for (Object next : arrayList) {
                if (!this.f54773a.f54762g.contains(((BeneficiaryEntity) next).beneficiaryId)) {
                    arrayList2.add(next);
                }
            }
            c2.setValue(c.a.a(new ArrayList((List) arrayList2)));
            if (this.f54775c == 0) {
                this.f54773a.a(this.f54774b.size(), this.f54776d);
            }
        }
    }
}
