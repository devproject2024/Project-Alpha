package net.one97.paytm.contacts.utils;

import android.content.Context;
import android.os.Build;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.p;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.contacts.db.ContactDatabase;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.sync.c;
import net.one97.paytm.contacts.sync.e;
import net.one97.paytm.contacts.sync.h;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.utils.x;

public final class c implements x.e {

    /* renamed from: a  reason: collision with root package name */
    public static y<ArrayList<ContactDetail>> f50247a;

    /* renamed from: b  reason: collision with root package name */
    public static y<LinkedHashSet<IJRDataModel>> f50248b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f50249c = new c();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static int f50250d = e.a.NONE.getType();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static boolean f50251e;

    /* renamed from: f  reason: collision with root package name */
    private static final CoroutineExceptionHandler f50252f = new a(CoroutineExceptionHandler.Key);

    public interface b {
        void a();

        void a(boolean z);
    }

    public final void d() {
    }

    static final class e<T> implements z<net.one97.paytm.network.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f50254a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ContactDetail f50255b;

        e(Context context, ContactDetail contactDetail) {
            this.f50254a = context;
            this.f50255b = contactDetail;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (((net.one97.paytm.network.f) obj).f55796a == net.one97.paytm.network.h.SUCCESS) {
                CoroutineDispatcher io2 = Dispatchers.getIO();
                c cVar = c.f50249c;
                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(io2.plus(c.c())), (kotlin.d.f) null, (CoroutineStart) null, new m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                    int label;
                    private CoroutineScope p$;
                    final /* synthetic */ e this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                        k.c(dVar, "completion");
                        AnonymousClass1 r0 = 

                        private c() {
                        }

                        public final void a(ArrayList<ContactDetail> arrayList) {
                            k.c(arrayList, "contactList");
                            k.c(arrayList, "contactList");
                        }

                        public final void a(LinkedHashSet<IJRDataModel> linkedHashSet) {
                            k.c(linkedHashSet, "contactList");
                            k.c(linkedHashSet, "contactList");
                        }

                        public final void a(e.h hVar, Context context, int i2, boolean z) {
                            k.c(hVar, "sycing");
                            k.c(context, "context");
                            x.e.a.b(hVar, context);
                        }

                        public static y<ArrayList<ContactDetail>> a() {
                            y<ArrayList<ContactDetail>> yVar = f50247a;
                            if (yVar == null) {
                                k.a("contactList");
                            }
                            return yVar;
                        }

                        public static y<LinkedHashSet<IJRDataModel>> b() {
                            y<LinkedHashSet<IJRDataModel>> yVar = f50248b;
                            if (yVar == null) {
                                k.a("contactListV2");
                            }
                            return yVar;
                        }

                        public static final class a extends kotlin.d.a implements CoroutineExceptionHandler {
                            public a(f.c cVar) {
                                super(cVar);
                            }

                            public final void handleException(kotlin.d.f fVar, Throwable th) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(th);
                                sb.append(" handled !");
                            }
                        }

                        public final y<ArrayList<ContactDetail>> a(Context context, int i2, int i3) {
                            k.c(context, "context");
                            if (f50250d != e.a.IN_PROCESS.getType()) {
                                f50248b = new y<>();
                                f50247a = new y<>();
                                f50251e = false;
                            }
                            a(context, i2, i3, (Integer[]) null, (x.e) new f());
                            y<ArrayList<ContactDetail>> yVar = f50247a;
                            if (yVar == null) {
                                k.a("contactList");
                            }
                            return yVar;
                        }

                        public static final class f implements x.e {
                            public final void d() {
                            }

                            f() {
                            }

                            public final void a(LinkedHashSet<IJRDataModel> linkedHashSet) {
                                k.c(linkedHashSet, "contactList");
                                k.c(linkedHashSet, "contactList");
                            }

                            public final void a(e.h hVar, Context context, int i2, boolean z) {
                                k.c(hVar, "sycing");
                                k.c(context, "context");
                                x.e.a.b(hVar, context);
                            }

                            public final void b(e.h hVar, Context context, int i2) {
                                k.c(hVar, "sycing");
                                k.c(context, "context");
                                x.e.a.a(hVar, context);
                            }

                            public final void a(ArrayList<ContactDetail> arrayList) {
                                k.c(arrayList, "contact");
                                c cVar = c.f50249c;
                                c.a().postValue(arrayList);
                            }
                        }

                        public final y<LinkedHashSet<IJRDataModel>> a(Context context, int i2, int i3, Integer[] numArr) {
                            k.c(context, "context");
                            if (f50250d != e.a.IN_PROCESS.getType()) {
                                f50248b = new y<>();
                                f50247a = new y<>();
                                f50251e = false;
                            }
                            a(context, i2, i3, numArr, (x.e) new g());
                            y<LinkedHashSet<IJRDataModel>> yVar = f50248b;
                            if (yVar == null) {
                                k.a("contactListV2");
                            }
                            return yVar;
                        }

                        public static final class g implements x.e {
                            public final void d() {
                            }

                            g() {
                            }

                            public final void a(e.h hVar, Context context, int i2, boolean z) {
                                k.c(hVar, "sycing");
                                k.c(context, "context");
                                x.e.a.b(hVar, context);
                            }

                            public final void b(e.h hVar, Context context, int i2) {
                                k.c(hVar, "sycing");
                                k.c(context, "context");
                                x.e.a.a(hVar, context);
                            }

                            public final void a(LinkedHashSet<IJRDataModel> linkedHashSet) {
                                k.c(linkedHashSet, "contactList");
                                c cVar = c.f50249c;
                                c.b().postValue(linkedHashSet);
                            }

                            public final void a(ArrayList<ContactDetail> arrayList) {
                                k.c(arrayList, "contactList");
                                c cVar = c.f50249c;
                                c.b().postValue(new LinkedHashSet(arrayList));
                            }
                        }

                        /* renamed from: net.one97.paytm.contacts.utils.c$c  reason: collision with other inner class name */
                        public static final class C0904c implements x.e {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ int f50253a;

                            public final void d() {
                            }

                            C0904c(int i2) {
                                this.f50253a = i2;
                            }

                            public final void a(ArrayList<ContactDetail> arrayList) {
                                k.c(arrayList, "contactList");
                                k.c(arrayList, "contactList");
                            }

                            public final void a(LinkedHashSet<IJRDataModel> linkedHashSet) {
                                k.c(linkedHashSet, "contactList");
                                k.c(linkedHashSet, "contactList");
                            }

                            public final void b(e.h hVar, Context context, int i2) {
                                k.c(hVar, "sycing");
                                k.c(context, "context");
                                x.e.a.a(hVar, context);
                            }

                            public final void a(e.h hVar, Context context, int i2, boolean z) {
                                k.c(hVar, "sycing");
                                k.c(context, "context");
                                if (z) {
                                    a aVar = a.f50219b;
                                    LinkedHashSet<ContactDetail> a2 = a.a(context, this.f50253a);
                                    c cVar = c.f50249c;
                                    c.f50251e = true;
                                    ArrayList arrayList = new ArrayList();
                                    if (a2.size() > 0) {
                                        arrayList.addAll(a2);
                                    }
                                    b bVar = b.f50245a;
                                    b.a(a2);
                                    c cVar2 = c.f50249c;
                                    c.a().postValue(arrayList);
                                }
                                c.f50249c.a(hVar, context, i2);
                            }
                        }

                        public static void b(Context context, int i2, int i3) {
                            k.c(context, "context");
                            new net.one97.paytm.contacts.sync.f(context, new C0904c(i3), i2).a();
                        }

                        public final void a(e.h hVar, Context context, int i2) {
                            e.h hVar2 = hVar;
                            while (true) {
                                k.c(hVar2, "sycing");
                                k.c(context, "context");
                                switch (d.f50260a[hVar2.ordinal()]) {
                                    case 1:
                                        new net.one97.paytm.contacts.sync.d(context, this, i2, false, e.b.PHONEBOOK.getType()).a();
                                        return;
                                    case 2:
                                        net.one97.paytm.contacts.sync.e eVar = new net.one97.paytm.contacts.sync.e(context, this, i2);
                                        if (Build.VERSION.SDK_INT < 23 || (Build.VERSION.SDK_INT >= 23 && androidx.core.content.b.a(eVar.f50195a, "android.permission.READ_CONTACTS") == 0)) {
                                            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(f50252f)), (kotlin.d.f) null, (CoroutineStart) null, new e.a(eVar, (kotlin.d.d) null), 3, (Object) null);
                                            return;
                                        } else if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(eVar.f50195a, "isContactSyncEnableV2", true) && com.paytm.utility.b.r(eVar.f50195a)) {
                                            eVar.f50196b.b(e.h.LOCAL_DB_SYNC_DONE, eVar.f50195a, eVar.f50197c);
                                            return;
                                        } else {
                                            return;
                                        }
                                    case 3:
                                        if (i2 == e.C0905e.PAY.getType()) {
                                            hVar2 = e.h.TRANSFER_BEN_CALL_DONE;
                                        } else {
                                            new net.one97.paytm.contacts.sync.b(context, this, e.b.TRANSFER_BENEFICIARY.getType(), i2).a();
                                            return;
                                        }
                                    case 4:
                                        net.one97.paytm.contacts.sync.h hVar3 = new net.one97.paytm.contacts.sync.h(context, this, e.b.PHONEBOOK.getType(), i2);
                                        Job unused2 = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(hVar3.f50210g)), (kotlin.d.f) null, (CoroutineStart) null, new h.b(hVar3, (kotlin.d.d) null), 3, (Object) null);
                                        return;
                                    case 5:
                                        Job unused3 = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (kotlin.d.f) null, (CoroutineStart) null, new c.C0901c(new net.one97.paytm.contacts.sync.c(context, this, e.b.PHONEBOOK.getType(), i2), (kotlin.d.d) null), 3, (Object) null);
                                        return;
                                    case 6:
                                        new net.one97.paytm.contacts.sync.b(context, this, e.b.PHONEBOOK.getType(), i2).a();
                                        return;
                                    case 7:
                                        f50250d = e.a.COMPLETED.getType();
                                        return;
                                    case 8:
                                        f50250d = e.a.NONE.getType();
                                        return;
                                    default:
                                        return;
                                }
                            }
                        }

                        public static void a(ContactDetail contactDetail, Context context) {
                            k.c(contactDetail, "item");
                            k.c(context, "mContext");
                            net.one97.paytm.contacts.sync.a aVar = net.one97.paytm.contacts.sync.a.f50159a;
                            LiveData<net.one97.paytm.network.f> a2 = net.one97.paytm.contacts.sync.a.a(context, contactDetail);
                            if (a2 != null) {
                                a2.observeForever(new e(context, contactDetail));
                            }
                        }

                        public static void a(Context context) {
                            k.c(context, "context");
                            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(f50252f)), (kotlin.d.f) null, (CoroutineStart) null, new d(context, (kotlin.d.d) null), 3, (Object) null);
                        }

                        public static CoroutineExceptionHandler c() {
                            return f50252f;
                        }

                        public final void b(e.h hVar, Context context, int i2) {
                            k.c(hVar, "sycing");
                            k.c(context, "context");
                            a(hVar, context, i2);
                        }

                        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
                            if ((r12.length == 0) != false) goto L_0x0037;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        private final void a(android.content.Context r9, int r10, int r11, java.lang.Integer[] r12, net.one97.paytm.utils.x.e r13) {
                            /*
                                r8 = this;
                                kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()
                                kotlin.d.f r0 = (kotlin.d.f) r0
                                kotlinx.coroutines.CoroutineScope r1 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r0)
                                net.one97.paytm.contacts.utils.c$h r0 = new net.one97.paytm.contacts.utils.c$h
                                r7 = 0
                                r2 = r0
                                r3 = r11
                                r4 = r9
                                r5 = r10
                                r6 = r13
                                r2.<init>(r3, r4, r5, r6, r7)
                                r4 = r0
                                kotlin.g.a.m r4 = (kotlin.g.a.m) r4
                                r2 = 0
                                r3 = 0
                                r5 = 3
                                r6 = 0
                                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r1, r2, r3, r4, r5, r6)
                                int r0 = f50250d
                                net.one97.paytm.contacts.utils.e$a r1 = net.one97.paytm.contacts.utils.e.a.IN_PROCESS
                                int r1 = r1.getType()
                                if (r0 == r1) goto L_0x00c6
                                r0 = 0
                                f50251e = r0
                                r1 = 1
                                if (r12 == 0) goto L_0x0037
                                int r2 = r12.length
                                if (r2 != 0) goto L_0x0034
                                r2 = 1
                                goto L_0x0035
                            L_0x0034:
                                r2 = 0
                            L_0x0035:
                                if (r2 == 0) goto L_0x0038
                            L_0x0037:
                                r0 = 1
                            L_0x0038:
                                if (r0 != 0) goto L_0x003e
                                a((android.content.Context) r9, (int) r10, (net.one97.paytm.utils.x.e) r13, (int) r11, (java.lang.Integer[]) r12)
                                return
                            L_0x003e:
                                boolean r12 = com.paytm.utility.b.r((android.content.Context) r9)
                                if (r12 != 0) goto L_0x0050
                                net.one97.paytm.contacts.utils.e$a r12 = net.one97.paytm.contacts.utils.e.a.IN_PROCESS
                                int r12 = r12.getType()
                                f50250d = r12
                                b((android.content.Context) r9, (int) r10, (int) r11)
                                return
                            L_0x0050:
                                net.one97.paytm.wallet.communicator.c r12 = net.one97.paytm.wallet.communicator.b.a()
                                java.lang.String r13 = "isContactSyncEnableV2"
                                boolean r12 = r12.getBooleanFromGTM(r9, r13, r1)
                                if (r12 == 0) goto L_0x008e
                                net.one97.paytm.contacts.utils.e$a r11 = net.one97.paytm.contacts.utils.e.a.IN_PROCESS
                                int r11 = r11.getType()
                                f50250d = r11
                                net.one97.paytm.contacts.utils.e$b r11 = net.one97.paytm.contacts.utils.e.b.PHONEBOOK
                                int r11 = r11.getType()
                                net.one97.paytm.contacts.utils.e$e r12 = net.one97.paytm.contacts.utils.e.C0905e.MONEY_TRANSFER
                                int r12 = r12.getType()
                                if (r10 != r12) goto L_0x0078
                                net.one97.paytm.contacts.utils.e$b r11 = net.one97.paytm.contacts.utils.e.b.TRANSFER_BENEFICIARY
                                int r11 = r11.getType()
                            L_0x0078:
                                r5 = r11
                                net.one97.paytm.contacts.sync.d r11 = new net.one97.paytm.contacts.sync.d
                                net.one97.paytm.contacts.utils.c$i r12 = new net.one97.paytm.contacts.utils.c$i
                                r12.<init>()
                                r2 = r12
                                net.one97.paytm.utils.x$e r2 = (net.one97.paytm.utils.x.e) r2
                                r4 = 1
                                r0 = r11
                                r1 = r9
                                r3 = r10
                                r0.<init>(r1, r2, r3, r4, r5)
                                r11.a()
                                return
                            L_0x008e:
                                net.one97.paytm.wallet.communicator.c r12 = net.one97.paytm.wallet.communicator.b.a()
                                java.lang.String r13 = "isPhoneSyncEnableV2"
                                boolean r12 = r12.getBooleanFromGTM(r9, r13, r1)
                                if (r12 == 0) goto L_0x00a5
                                net.one97.paytm.contacts.utils.e$a r12 = net.one97.paytm.contacts.utils.e.a.IN_PROCESS
                                int r12 = r12.getType()
                                f50250d = r12
                                b((android.content.Context) r9, (int) r10, (int) r11)
                            L_0x00a5:
                                net.one97.paytm.contacts.utils.e$e r11 = net.one97.paytm.contacts.utils.e.C0905e.MONEY_TRANSFER
                                int r11 = r11.getType()
                                if (r10 != r11) goto L_0x00c6
                                net.one97.paytm.contacts.utils.e$a r11 = net.one97.paytm.contacts.utils.e.a.IN_PROCESS
                                int r11 = r11.getType()
                                f50250d = r11
                                net.one97.paytm.contacts.sync.b r11 = new net.one97.paytm.contacts.sync.b
                                r12 = r8
                                net.one97.paytm.utils.x$e r12 = (net.one97.paytm.utils.x.e) r12
                                net.one97.paytm.contacts.utils.e$b r13 = net.one97.paytm.contacts.utils.e.b.TRANSFER_BENEFICIARY
                                int r13 = r13.getType()
                                r11.<init>(r9, r12, r13, r10)
                                r11.a()
                            L_0x00c6:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.contacts.utils.c.a(android.content.Context, int, int, java.lang.Integer[], net.one97.paytm.utils.x$e):void");
                        }

                        public static final class i implements x.e {
                            public final void d() {
                            }

                            i() {
                            }

                            public final void a(ArrayList<ContactDetail> arrayList) {
                                k.c(arrayList, "contactList");
                                k.c(arrayList, "contactList");
                            }

                            public final void a(LinkedHashSet<IJRDataModel> linkedHashSet) {
                                k.c(linkedHashSet, "contactList");
                                k.c(linkedHashSet, "contactList");
                            }

                            public final void b(e.h hVar, Context context, int i2) {
                                k.c(hVar, "sycing");
                                k.c(context, "context");
                                x.e.a.a(hVar, context);
                            }

                            public final void a(e.h hVar, Context context, int i2, boolean z) {
                                k.c(hVar, "sycing");
                                k.c(context, "context");
                                if (hVar == e.h.ABORT) {
                                    c cVar = c.f50249c;
                                    c.f50250d = e.a.NONE.getType();
                                    return;
                                }
                                c cVar2 = c.f50249c;
                                c.b(context, i2, e.b.PHONEBOOK.getType());
                            }
                        }

                        public static final class j implements x.e {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ Context f50256a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ int f50257b;

                            /* renamed from: c  reason: collision with root package name */
                            final /* synthetic */ int f50258c;

                            /* renamed from: d  reason: collision with root package name */
                            final /* synthetic */ x.e f50259d;

                            j(Context context, int i2, int i3, x.e eVar) {
                                this.f50256a = context;
                                this.f50257b = i2;
                                this.f50258c = i3;
                                this.f50259d = eVar;
                            }

                            public final void a(ArrayList<ContactDetail> arrayList) {
                                k.c(arrayList, "contactList");
                                k.c(arrayList, "contactList");
                            }

                            public final void a(LinkedHashSet<IJRDataModel> linkedHashSet) {
                                k.c(linkedHashSet, "contactList");
                                k.c(linkedHashSet, "contactList");
                            }

                            public final void a(e.h hVar, Context context, int i2, boolean z) {
                                k.c(hVar, "sycing");
                                k.c(context, "context");
                                x.e.a.b(hVar, context);
                            }

                            public final void d() {
                                c cVar = c.f50249c;
                                c.f50250d = e.a.COMPLETED.getType();
                                b bVar = b.f50245a;
                                b.b();
                                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (kotlin.d.f) null, (CoroutineStart) null, new a(this, (kotlin.d.d) null), 3, (Object) null);
                            }

                            public final void b(e.h hVar, Context context, int i2) {
                                k.c(hVar, "sycing");
                                k.c(context, "context");
                                c.f50249c.a(hVar, context, i2);
                            }

                            @kotlin.d.b.a.f(b = "ContactSyncManager.kt", c = {283}, d = "invokeSuspend", e = "net/one97/paytm/contacts/utils/ContactSyncManager$syncHandler$1$onSyncProcessCompletion$1")
                            static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                                int label;
                                private CoroutineScope p$;
                                final /* synthetic */ j this$0;

                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                a(j jVar, kotlin.d.d dVar) {
                                    super(2, dVar);
                                    this.this$0 = jVar;
                                }

                                public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                    k.c(dVar, "completion");
                                    a aVar = new a(this.this$0, dVar);
                                    aVar.p$ = (CoroutineScope) obj;
                                    return aVar;
                                }

                                public final Object invoke(Object obj, Object obj2) {
                                    return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
                                }

                                public final Object invokeSuspend(Object obj) {
                                    kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                    if (this.label != 0) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    } else if (!(obj instanceof p.b)) {
                                        a aVar2 = a.f50219b;
                                        this.this$0.f50259d.a((LinkedHashSet<IJRDataModel>) new LinkedHashSet(a.c(this.this$0.f50256a, this.this$0.f50258c)));
                                        return kotlin.x.f47997a;
                                    } else {
                                        throw ((p.b) obj).exception;
                                    }
                                }
                            }
                        }

                        private static void a(Context context, int i2, x.e eVar, int i3, Integer[] numArr) {
                            k.c(context, "context");
                            k.c(eVar, "listner");
                            k.c(numArr, "syncingParms");
                            new f(context, i2, new j(context, i3, i2, eVar)).a(numArr);
                        }

                        @kotlin.d.b.a.f(b = "ContactSyncManager.kt", c = {170}, d = "invokeSuspend", e = "net/one97/paytm/contacts/utils/ContactSyncManager$clearContactDB$1")
                        static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                            final /* synthetic */ Context $context;
                            int label;
                            private CoroutineScope p$;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            d(Context context, kotlin.d.d dVar) {
                                super(2, dVar);
                                this.$context = context;
                            }

                            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                k.c(dVar, "completion");
                                d dVar2 = new d(this.$context, dVar);
                                dVar2.p$ = (CoroutineScope) obj;
                                return dVar2;
                            }

                            public final Object invoke(Object obj, Object obj2) {
                                return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
                            }

                            public final Object invokeSuspend(Object obj) {
                                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                if (this.label != 0) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                } else if (!(obj instanceof p.b)) {
                                    ContactDatabase.f50139a.a(this.$context).c().g();
                                    return kotlin.x.f47997a;
                                } else {
                                    throw ((p.b) obj).exception;
                                }
                            }
                        }

                        @kotlin.d.b.a.f(b = "ContactSyncManager.kt", c = {185, 196, 210}, d = "invokeSuspend", e = "net/one97/paytm/contacts/utils/ContactSyncManager$syncAndFetchContacts$1")
                        static final class h extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                            final /* synthetic */ int $contactType;
                            final /* synthetic */ Context $context;
                            final /* synthetic */ int $launchFrom;
                            final /* synthetic */ x.e $listner;
                            Object L$0;
                            Object L$1;
                            int label;
                            private CoroutineScope p$;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            h(int i2, Context context, int i3, x.e eVar, kotlin.d.d dVar) {
                                super(2, dVar);
                                this.$contactType = i2;
                                this.$context = context;
                                this.$launchFrom = i3;
                                this.$listner = eVar;
                            }

                            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                k.c(dVar, "completion");
                                h hVar = new h(this.$contactType, this.$context, this.$launchFrom, this.$listner, dVar);
                                hVar.p$ = (CoroutineScope) obj;
                                return hVar;
                            }

                            public final Object invoke(Object obj, Object obj2) {
                                return ((h) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
                            }

                            public final Object invokeSuspend(Object obj) {
                                T t;
                                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                int i2 = this.label;
                                if (i2 != 0) {
                                    if (i2 != 1) {
                                        if (i2 != 2) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        } else if (obj instanceof p.b) {
                                            throw ((p.b) obj).exception;
                                        }
                                    } else if (obj instanceof p.b) {
                                        throw ((p.b) obj).exception;
                                    }
                                } else if (obj instanceof p.b) {
                                    throw ((p.b) obj).exception;
                                } else if (this.$contactType == e.b.BEN_PHONE_TYPE.getType()) {
                                    final x.e eVar = new x.e();
                                    a aVar2 = a.f50219b;
                                    eVar.element = a.c(this.$context, this.$launchFrom);
                                    this.L$0 = eVar;
                                    this.label = 1;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                                        int label;
                                        private CoroutineScope p$;
                                        final /* synthetic */ h this$0;

                                        {
                                            this.this$0 = r1;
                                        }

                                        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                            k.c(dVar, "completion");
                                            AnonymousClass1 r0 = 
                                        }
