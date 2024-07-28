package net.one97.paytm.contacts.sync;

import android.content.Context;
import java.util.List;
import kotlin.d.b.a.f;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.p;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.contacts.db.ContactDatabase;
import net.one97.paytm.contacts.utils.c;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.utils.x;
import net.one97.paytm.wallet.communicator.b;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public Context f50195a;

    /* renamed from: b  reason: collision with root package name */
    public x.e f50196b;

    /* renamed from: c  reason: collision with root package name */
    public int f50197c;

    public e(Context context, x.e eVar, int i2) {
        k.c(context, "context");
        k.c(eVar, "listener");
        this.f50195a = context;
        this.f50196b = eVar;
        this.f50197c = i2;
    }

    @f(b = "ContactLocalSyncReqt.kt", c = {26}, d = "invokeSuspend", e = "net/one97/paytm/contacts/sync/ContactLocalSyncReqt$handle$1")
    public static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super kotlin.x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar, d dVar) {
            super(2, dVar);
            this.this$0 = eVar;
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
                Context context = this.this$0.f50195a;
                c.b r0 = new c.b(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a f50198a;

                    public final void a(boolean z) {
                    }

                    {
                        this.f50198a = r1;
                    }

                    public final void a() {
                        if (b.a().getBooleanFromGTM(this.f50198a.this$0.f50195a, "isContactSyncEnableV2", true) && com.paytm.utility.b.r(this.f50198a.this$0.f50195a)) {
                            this.f50198a.this$0.f50196b.b(e.h.LOCAL_DB_SYNC_DONE, this.f50198a.this$0.f50195a, this.f50198a.this$0.f50197c);
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
                ContactDatabase.f50139a.a(context).f().a((List<Integer>) kotlin.a.k.d(Integer.valueOf(e.b.TRANSFER_BENEFICIARY.getType()), Integer.valueOf(e.b.PHONEBOOK.getType())));
                r0.a();
                net.one97.paytm.contacts.utils.a.f50218a = false;
                return kotlin.x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }
}
