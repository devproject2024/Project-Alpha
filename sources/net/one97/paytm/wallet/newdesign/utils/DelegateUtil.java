package net.one97.paytm.wallet.newdesign.utils;

import android.content.Context;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.AppCompatLockActivity;
import net.one97.paytm.wallet.newdesign.c.a;

public final class DelegateUtil {
    public static final DelegateUtil INSTANCE = new DelegateUtil();

    private DelegateUtil() {
    }

    public final void execute(a aVar) {
        k.c(aVar, "deleteListener");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (f) null, (CoroutineStart) null, new DelegateUtil$execute$1(aVar, (d) null), 3, (Object) null);
    }

    public final void handleSecurityCheck(Context context, AppCompatLockActivity.a aVar) {
        k.c(context, "context");
        k.c(aVar, "isPatternLockEnabled");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (f) null, (CoroutineStart) null, new DelegateUtil$handleSecurityCheck$1(context, aVar, (d) null), 3, (Object) null);
    }

    public final void writeObjectToFile(Context context, Object obj, String str) {
        k.c(context, "context");
        k.c(obj, "obj");
        k.c(str, "filename");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (f) null, (CoroutineStart) null, new DelegateUtil$writeObjectToFile$1(context, obj, str, (d) null), 3, (Object) null);
    }

    public final void excecuteScanflowAfterLogin(Context context, boolean z, boolean z2, String str, boolean z3, a aVar) {
        k.c(context, "context");
        a aVar2 = aVar;
        k.c(aVar2, "deleteListener");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (f) null, (CoroutineStart) null, new DelegateUtil$excecuteScanflowAfterLogin$1(context, aVar2, z, z2, str, z3, (d) null), 3, (Object) null);
    }

    public final void deleteAllEventLogData() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (f) null, (CoroutineStart) null, new DelegateUtil$deleteAllEventLogData$1((d) null), 3, (Object) null);
    }
}
