package net.one97.paytm.wallet.newdesign.utils;

import android.content.Context;
import com.google.android.gms.vision.barcode.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import net.one97.paytm.wallet.newdesign.c.a;

@f(b = "DelegrateUtil.kt", c = {42, 51}, d = "invokeSuspend", e = "net/one97/paytm/wallet/newdesign/utils/DelegateUtil$excecuteScanflowAfterLogin$1")
final class DelegateUtil$excecuteScanflowAfterLogin$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ net.one97.paytm.wallet.newdesign.c.a $deleteListener;
    final /* synthetic */ boolean $isFromLogin;
    final /* synthetic */ boolean $isScanOnly;
    final /* synthetic */ boolean $isShowInvoke;
    final /* synthetic */ String $qrCodeId;
    Object L$0;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DelegateUtil$excecuteScanflowAfterLogin$1(Context context, net.one97.paytm.wallet.newdesign.c.a aVar, boolean z, boolean z2, String str, boolean z3, d dVar) {
        super(2, dVar);
        this.$context = context;
        this.$deleteListener = aVar;
        this.$isScanOnly = z;
        this.$isFromLogin = z2;
        this.$qrCodeId = str;
        this.$isShowInvoke = z3;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        DelegateUtil$excecuteScanflowAfterLogin$1 delegateUtil$excecuteScanflowAfterLogin$1 = new DelegateUtil$excecuteScanflowAfterLogin$1(this.$context, this.$deleteListener, this.$isScanOnly, this.$isFromLogin, this.$qrCodeId, this.$isShowInvoke, dVar);
        delegateUtil$excecuteScanflowAfterLogin$1.p$ = (CoroutineScope) obj;
        return delegateUtil$excecuteScanflowAfterLogin$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((DelegateUtil$excecuteScanflowAfterLogin$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    @f(b = "DelegrateUtil.kt", c = {44}, d = "invokeSuspend", e = "net/one97/paytm/wallet/newdesign/utils/DelegateUtil$excecuteScanflowAfterLogin$1$1")
    /* renamed from: net.one97.paytm.wallet.newdesign.utils.DelegateUtil$excecuteScanflowAfterLogin$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends k implements m<CoroutineScope, d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ DelegateUtil$excecuteScanflowAfterLogin$1 this$0;

        {
            this.this$0 = r1;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, a2, dVar);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                com.google.android.gms.vision.barcode.a aVar2 = a2;
                kotlin.g.b.k.a((Object) aVar2, "barcodeDetector");
                if (!aVar2.b()) {
                    this.this$0.$deleteListener.a(this.this$0.$isScanOnly);
                } else {
                    this.this$0.$deleteListener.a(this.this$0.$isFromLogin, this.this$0.$qrCodeId, this.this$0.$isShowInvoke);
                }
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    public final Object invokeSuspend(Object obj) {
        kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (obj instanceof p.b) {
                throw ((p.b) obj).exception;
            }
        } else if (!(obj instanceof p.b)) {
            final com.google.android.gms.vision.barcode.a a2 = new a.C0165a(this.$context).a();
            this.L$0 = a2;
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
