package net.one97.paytm.contacts.sync;

import android.content.Context;
import android.os.Build;
import androidx.core.content.b;
import java.util.List;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.p;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.contacts.db.ContactDatabase;
import net.one97.paytm.contacts.utils.c;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.utils.x;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    Context f50199a;

    /* renamed from: b  reason: collision with root package name */
    x.e f50200b;

    /* renamed from: c  reason: collision with root package name */
    int f50201c;

    public f(Context context, x.e eVar, int i2) {
        k.c(context, "context");
        k.c(eVar, "listener");
        this.f50199a = context;
        this.f50200b = eVar;
        this.f50201c = i2;
    }

    public final void a() {
        if (Build.VERSION.SDK_INT < 23 || (Build.VERSION.SDK_INT >= 23 && b.a(this.f50199a, "android.permission.READ_CONTACTS") == 0)) {
            CoroutineDispatcher io2 = Dispatchers.getIO();
            c cVar = c.f50249c;
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(io2.plus(c.c())), (kotlin.d.f) null, (CoroutineStart) null, new a(this, (d) null), 3, (Object) null);
        } else if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this.f50199a, "isContactSyncEnableV2", true) && com.paytm.utility.b.r(this.f50199a)) {
            this.f50200b.a(e.h.LOCAL_DB_SYNC_DONE, this.f50199a, this.f50201c, false);
        }
    }

    @kotlin.d.b.a.f(b = "ContactLocalSyncReqtV2.kt", c = {26}, d = "invokeSuspend", e = "net/one97/paytm/contacts/sync/ContactLocalSyncReqtV2$handle$1")
    static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super kotlin.x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ f this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(f fVar, d dVar) {
            super(2, dVar);
            this.this$0 = fVar;
        }

        public final d<kotlin.x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            a aVar = new a(this.this$0, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                net.one97.paytm.contacts.utils.a aVar2 = net.one97.paytm.contacts.utils.a.f50219b;
                Context context = this.this$0.f50199a;
                c.b r0 = new c.b(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a f50202a;

                    public final void a() {
                    }

                    {
                        this.f50202a = r1;
                    }

                    public final void a(boolean z) {
                        if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this.f50202a.this$0.f50199a, "isContactSyncEnableV2", true) && com.paytm.utility.b.r(this.f50202a.this$0.f50199a)) {
                            this.f50202a.this$0.f50200b.a(e.h.LOCAL_DB_SYNC_DONE, this.f50202a.this$0.f50199a, this.f50202a.this$0.f50201c, z);
                        }
                    }
                };
                k.c(context, "context");
                k.c(r0, "syncListener");
                if (ContactDatabase.f50139a.a(context).f().a((List<Integer>) kotlin.a.k.d(Integer.valueOf(e.b.TRANSFER_BENEFICIARY.getType()), Integer.valueOf(e.b.PHONEBOOK.getType()))) == 0) {
                    net.one97.paytm.contacts.utils.a.a(context);
                } else {
                    net.one97.paytm.contacts.utils.a.b(context);
                }
                int a2 = ContactDatabase.f50139a.a(context).f().a((List<Integer>) kotlin.a.k.d(Integer.valueOf(e.b.TRANSFER_BENEFICIARY.getType()), Integer.valueOf(e.b.PHONEBOOK.getType())));
                if (a2 == 0) {
                    r0.a(net.one97.paytm.contacts.utils.a.f50218a);
                } else {
                    String.valueOf(a2);
                    r0.a(net.one97.paytm.contacts.utils.a.f50218a);
                }
                net.one97.paytm.contacts.utils.a.f50218a = false;
                return kotlin.x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }
}
