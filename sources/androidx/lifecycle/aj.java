package androidx.lifecycle;

import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

public final class aj {
    public static final CoroutineScope a(ai aiVar) {
        k.c(aiVar, "$this$viewModelScope");
        CoroutineScope coroutineScope = (CoroutineScope) aiVar.getTag("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Object tagIfAbsent = aiVar.setTagIfAbsent("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new c(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate())));
        k.a(tagIfAbsent, "setTagIfAbsent(JOB_KEY,\n…patchers.Main.immediate))");
        return (CoroutineScope) tagIfAbsent;
    }
}
