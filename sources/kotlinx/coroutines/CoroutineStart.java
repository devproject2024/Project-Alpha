package kotlinx.coroutines;

import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.m;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            $EnumSwitchMapping$0[CoroutineStart.ATOMIC.ordinal()] = 2;
            $EnumSwitchMapping$0[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            $EnumSwitchMapping$0[CoroutineStart.LAZY.ordinal()] = 4;
            int[] iArr2 = new int[CoroutineStart.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[CoroutineStart.DEFAULT.ordinal()] = 1;
            $EnumSwitchMapping$1[CoroutineStart.ATOMIC.ordinal()] = 2;
            $EnumSwitchMapping$1[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            $EnumSwitchMapping$1[CoroutineStart.LAZY.ordinal()] = 4;
        }
    }

    public final <T> void invoke(b<? super d<? super T>, ? extends Object> bVar, d<? super T> dVar) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 == 1) {
            CancellableKt.startCoroutineCancellable(bVar, dVar);
        } else if (i2 == 2) {
            k.d(bVar, "$this$startCoroutine");
            k.d(dVar, "completion");
            kotlin.d.a.b.a(kotlin.d.a.b.a(bVar, dVar)).resumeWith(p.m530constructorimpl(x.f47997a));
        } else if (i2 == 3) {
            UndispatchedKt.startCoroutineUndispatched(bVar, dVar);
        } else if (i2 != 4) {
            throw new m();
        }
    }

    public final <R, T> void invoke(kotlin.g.a.m<? super R, ? super d<? super T>, ? extends Object> mVar, R r, d<? super T> dVar) {
        int i2 = WhenMappings.$EnumSwitchMapping$1[ordinal()];
        if (i2 == 1) {
            CancellableKt.startCoroutineCancellable(mVar, r, dVar);
        } else if (i2 == 2) {
            k.d(mVar, "$this$startCoroutine");
            k.d(dVar, "completion");
            kotlin.d.a.b.a(kotlin.d.a.b.a(mVar, r, dVar)).resumeWith(p.m530constructorimpl(x.f47997a));
        } else if (i2 == 3) {
            UndispatchedKt.startCoroutineUndispatched(mVar, r, dVar);
        } else if (i2 != 4) {
            throw new m();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }
}
