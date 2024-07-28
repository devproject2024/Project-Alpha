package net.one97.paytm.wallet.newdesign.utils;

import android.content.Context;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import net.one97.paytm.AppCompatLockActivity;

@f(b = "DelegrateUtil.kt", c = {27, 32}, d = "invokeSuspend", e = "net/one97/paytm/wallet/newdesign/utils/DelegateUtil$handleSecurityCheck$1")
final class DelegateUtil$handleSecurityCheck$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ AppCompatLockActivity.a $isPatternLockEnabled;
    boolean Z$0;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DelegateUtil$handleSecurityCheck$1(Context context, AppCompatLockActivity.a aVar, d dVar) {
        super(2, dVar);
        this.$context = context;
        this.$isPatternLockEnabled = aVar;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        DelegateUtil$handleSecurityCheck$1 delegateUtil$handleSecurityCheck$1 = new DelegateUtil$handleSecurityCheck$1(this.$context, this.$isPatternLockEnabled, dVar);
        delegateUtil$handleSecurityCheck$1.p$ = (CoroutineScope) obj;
        return delegateUtil$handleSecurityCheck$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((DelegateUtil$handleSecurityCheck$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    @f(b = "DelegrateUtil.kt", c = {29}, d = "invokeSuspend", e = "net/one97/paytm/wallet/newdesign/utils/DelegateUtil$handleSecurityCheck$1$1")
    /* renamed from: net.one97.paytm.wallet.newdesign.utils.DelegateUtil$handleSecurityCheck$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends k implements m<CoroutineScope, d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ DelegateUtil$handleSecurityCheck$1 this$0;

        {
            this.this$0 = r1;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, isPatternLockEnabled, dVar);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            a aVar = a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                if (isPatternLockEnabled) {
                    this.this$0.$isPatternLockEnabled.a();
                }
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (obj instanceof p.b) {
                throw ((p.b) obj).exception;
            }
        } else if (!(obj instanceof p.b)) {
            final boolean isPatternLockEnabled = WalletSharedPrefs.INSTANCE.isPatternLockEnabled(this.$context);
            this.Z$0 = isPatternLockEnabled;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this, (d) null), this) == aVar) {
                return aVar;
            }
        } else {
            throw ((p.b) obj).exception;
        }
        return x.f47997a;
    }
}
