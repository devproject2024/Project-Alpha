package net.one97.paytm.m;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.a.w;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.contacts.entities.beans.ContactsResponse;
import net.one97.paytm.moneytransfer.model.c;
import net.one97.paytm.moneytransferv4.accounts.i;
import net.one97.paytm.moneytransferv4.search.SearchTitleModel;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.PendingRequestsModel;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.passbook.b.a.a;

public final class f extends i {
    /* access modifiers changed from: package-private */
    public boolean l;
    /* access modifiers changed from: package-private */
    public List<? extends ContactsResponse> m = w.INSTANCE;
    /* access modifiers changed from: package-private */
    public final y<net.one97.paytm.moneytransfer.model.c<List<Object>>> n = new y<>();
    /* access modifiers changed from: package-private */
    public final y<ArrayList<UpiPendingRequestModel>> o = new y<>();
    final net.one97.paytm.upi.registration.b.a.a p;
    final net.one97.paytm.upi.passbook.b.a.a q;
    /* access modifiers changed from: private */
    public boolean r;
    /* access modifiers changed from: private */
    public List<? extends BankAccountDetails.BankAccount> s = w.INSTANCE;
    private final net.one97.paytm.upi.profile.b.a t;
    /* access modifiers changed from: private */
    public final net.one97.paytm.moneytransferv4.a.b.a u;

    static final class c<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f53183a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f53184b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f53185c;

        c(f fVar, String str, String str2) {
            this.f53183a = fVar;
            this.f53184b = str;
            this.f53185c = str2;
        }

        public final /* synthetic */ Object apply(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            f fVar = this.f53183a;
            List list = (List) cVar.f54033b;
            if (list == null) {
                list = w.INSTANCE;
            }
            fVar.s = list;
            this.f53183a.r = true;
            int i2 = g.f53186a[cVar.f54032a.ordinal()];
            if (i2 == 1) {
                return f.a(this.f53183a, this.f53184b, this.f53185c);
            }
            if (i2 == 2) {
                return net.one97.paytm.moneytransfer.model.c.f54031e;
            }
            if (i2 != 3) {
                return net.one97.paytm.moneytransfer.model.c.f54031e;
            }
            return f.b(this.f53184b, this.f53185c);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(net.one97.paytm.upi.profile.b.a aVar, net.one97.paytm.upi.registration.b.a.a aVar2, net.one97.paytm.moneytransferv4.a.b.a aVar3, net.one97.paytm.upi.passbook.b.a.a aVar4) {
        super(aVar, aVar2);
        k.c(aVar, "profileRepository");
        k.c(aVar2, "registrationRepository");
        k.c(aVar3, "beneficiaryRepository");
        k.c(aVar4, "passbookDataSource");
        this.t = aVar;
        this.p = aVar2;
        this.u = aVar3;
        this.q = aVar4;
    }

    public static net.one97.paytm.moneytransfer.model.c<List<Object>> b(String str, String str2) {
        k.c(str, "firstTitle");
        k.c(str2, "secondTitle");
        c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
        return c.a.a(kotlin.a.k.b((T[]) new Object[]{new SearchTitleModel(str), new b(), new SearchTitleModel(str2), new b()}));
    }

    public static final class b implements a.C1379a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f53182a;

        b(f fVar) {
            this.f53182a = fVar;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            if (upiBaseDataModel instanceof PendingRequestsModel.PendingRequests) {
                PendingRequestsModel.PendingRequests pendingRequests = (PendingRequestsModel.PendingRequests) upiBaseDataModel;
                if (pendingRequests.getPendingRequests().size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<UpiPendingRequestModel> it2 = pendingRequests.getPendingRequests().iterator();
                    while (it2.hasNext()) {
                        UpiPendingRequestModel next = it2.next();
                        k.a((Object) next, "request");
                        if (!p.a(next.getDirection(), "INITIATED", true)) {
                            arrayList.add(next);
                        }
                    }
                    this.f53182a.o.setValue(arrayList);
                }
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            this.f53182a.o.setValue(new ArrayList());
        }
    }

    public final LiveData<net.one97.paytm.moneytransfer.model.c<List<Object>>> a(String str, String str2) {
        k.c(str, "firstTitle");
        k.c(str2, "secondTitle");
        LiveData<net.one97.paytm.moneytransfer.model.c<List<Object>>> a2 = ah.a(this.f54964a, new c(this, str, str2));
        k.a((Object) a2, "Transformations.map(supe…)\n            }\n        }");
        return a2;
    }

    @kotlin.d.b.a.f(b = "TransferToBankAccountViewModel.kt", c = {97}, d = "invokeSuspend", e = "net.one97.paytm.moneytransferv5.TransferToBankAccountViewModel$fetchBeneficiaries$1")
    static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ String $firstTitle;
        final /* synthetic */ String $secondTitle;
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ f this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(f fVar, String str, String str2, d dVar) {
            super(2, dVar);
            this.this$0 = fVar;
            this.$firstTitle = str;
            this.$secondTitle = str2;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            a aVar = new a(this.this$0, this.$firstTitle, this.$secondTitle, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = this.p$;
                if (this.this$0.l) {
                    return x.f47997a;
                }
                net.one97.paytm.moneytransferv4.a.b.a d2 = this.this$0.u;
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = d2.a(this);
                if (obj == aVar) {
                    return aVar;
                }
            } else if (i2 == 1) {
                try {
                    ResultKt.a(obj);
                } catch (Exception e2) {
                    this.this$0.l = true;
                    this.this$0.n.setValue(f.a(this.this$0, this.$firstTitle, this.$secondTitle));
                    e2.printStackTrace();
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ArrayList arrayList = (ArrayList) obj;
            this.this$0.l = true;
            this.this$0.m = arrayList != null ? arrayList : w.INSTANCE;
            this.this$0.n.setValue(f.a(this.this$0, this.$firstTitle, this.$secondTitle));
            return x.f47997a;
        }
    }

    public static final /* synthetic */ net.one97.paytm.moneytransfer.model.c a(f fVar, String str, String str2) {
        List arrayList = new ArrayList();
        if (!fVar.r) {
            arrayList.add(new SearchTitleModel(str));
            arrayList.add(new b());
        } else if (!fVar.s.isEmpty()) {
            arrayList.add(new SearchTitleModel(str));
            arrayList.addAll(fVar.s);
        }
        Collection collection = fVar.m;
        boolean z = false;
        if (!(collection == null || collection.isEmpty()) || !fVar.l) {
            Collection collection2 = fVar.m;
            if (collection2 == null || collection2.isEmpty()) {
                z = true;
            }
            if (z) {
                arrayList.add(new SearchTitleModel(str2));
                arrayList.add(new b());
                c.a aVar = net.one97.paytm.moneytransfer.model.c.f54031e;
                return c.a.a(arrayList);
            }
            arrayList.add(new SearchTitleModel(str2));
            arrayList.addAll(fVar.m);
            arrayList.add(new a());
            c.a aVar2 = net.one97.paytm.moneytransfer.model.c.f54031e;
            return c.a.a(arrayList);
        }
        c.a aVar3 = net.one97.paytm.moneytransfer.model.c.f54031e;
        return c.a.a(arrayList);
    }
}
