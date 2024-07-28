package net.one97.paytm.nativesdk.common.viewmodel;

import androidx.lifecycle.ai;
import java.util.concurrent.CancellationException;
import kotlin.g.b.k;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import net.one97.paytm.nativesdk.PaytmSDK;

public class BaseNativeViewModel extends ai {
    private final CoroutineExceptionHandler handler = new BaseNativeViewModel$$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    private final CompletableJob job = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);

    public final CompletableJob getJob() {
        return this.job;
    }

    public final CoroutineScope getViewModelScope(ai aiVar) {
        k.c(aiVar, "$this$viewModelScope");
        return CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(this.job).plus(this.handler));
    }

    public void onCleared() {
        super.onCleared();
        try {
            Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
        } catch (Exception e2) {
            if (PaytmSDK.getCallbackListener() != null) {
                PaytmSDK.getCallbackListener().logException("BaseNativeViewModel", "Coroutine clear exception caught", e2);
            }
        } catch (Throwable th) {
            if (PaytmSDK.getCallbackListener() != null) {
                PaytmSDK.getCallbackListener().logException("BaseNativeViewModel", "Coroutine verify exception caught", th);
            }
        }
    }

    public final CoroutineExceptionHandler getHandler() {
        return this.handler;
    }
}
