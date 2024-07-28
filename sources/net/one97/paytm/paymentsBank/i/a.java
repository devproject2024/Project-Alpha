package net.one97.paytm.paymentsBank.i;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import kotlin.d.b.a.f;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.bankCommon.b.c;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public y<c<Object>> f18547a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<c<Object>> f18548b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f18549c;

    /* renamed from: d  reason: collision with root package name */
    public String f18550d = "";

    /* renamed from: e  reason: collision with root package name */
    private y<c<Object>> f18551e = new y<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public net.one97.paytm.bankCommon.data.bankscope.b f18552f;

    public a(net.one97.paytm.bankCommon.data.bankscope.b bVar) {
        k.c(bVar, "bankScopeTokenRepository");
        this.f18552f = bVar;
    }

    @f(b = "BankTabPassCodeViewModel.kt", c = {40}, d = "invokeSuspend", e = "net.one97.paytm.paymentsBank.passcodebankscope.BankTabPassCodeViewModel$logout$1")
    /* renamed from: net.one97.paytm.paymentsBank.i.a$a  reason: collision with other inner class name */
    public static final class C0318a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0318a(a aVar, d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            C0318a aVar = new C0318a(this.this$0, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C0318a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            y<c<Object>> yVar;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 == 1) {
                    yVar = (y) this.L$0;
                    if (obj instanceof p.b) {
                        throw ((p.b) obj).exception;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else if (!(obj instanceof p.b)) {
                y<c<Object>> yVar2 = this.this$0.f18548b;
                net.one97.paytm.bankCommon.data.bankscope.b a2 = this.this$0.f18552f;
                this.L$0 = yVar2;
                this.label = 1;
                Object a3 = a2.a((d<? super c<? extends Object>>) this);
                if (a3 == aVar) {
                    return aVar;
                }
                yVar = yVar2;
                obj = a3;
            } else {
                throw ((p.b) obj).exception;
            }
            yVar.setValue(obj);
            return x.f47997a;
        }
    }

    @f(b = "BankTabPassCodeViewModel.kt", c = {21}, d = "invokeSuspend", e = "net.one97.paytm.paymentsBank.passcodebankscope.BankTabPassCodeViewModel$validateToken$1")
    public static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ String $enteredToken;
        final /* synthetic */ String $screenName;
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, String str, String str2, d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$enteredToken = str;
            this.$screenName = str2;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            b bVar = new b(this.this$0, this.$enteredToken, this.$screenName, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            y<c<Object>> yVar;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 == 1) {
                    yVar = (y) this.L$0;
                    if (obj instanceof p.b) {
                        throw ((p.b) obj).exception;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else if (!(obj instanceof p.b)) {
                y<c<Object>> yVar2 = this.this$0.f18547a;
                net.one97.paytm.bankCommon.data.bankscope.b a2 = this.this$0.f18552f;
                String str = this.$enteredToken;
                String str2 = this.$screenName;
                this.L$0 = yVar2;
                this.label = 1;
                Object a3 = a2.a(str, str2, this);
                if (a3 == aVar) {
                    return aVar;
                }
                yVar = yVar2;
                obj = a3;
            } else {
                throw ((p.b) obj).exception;
            }
            yVar.setValue(obj);
            return x.f47997a;
        }
    }
}
