package retrofit2;

import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import kotlin.ResultKt;
import kotlin.g.b.k;
import kotlin.p;
import kotlinx.coroutines.CancellableContinuation;

public final class KotlinExtensions$awaitResponse$2$2 implements Callback<T> {
    final /* synthetic */ CancellableContinuation $continuation;

    KotlinExtensions$awaitResponse$2$2(CancellableContinuation cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public final void onResponse(Call<T> call, Response<T> response) {
        k.c(call, H5Event.TYPE_CALL);
        k.c(response, Payload.RESPONSE);
        p.a aVar = p.Companion;
        this.$continuation.resumeWith(p.m530constructorimpl(response));
    }

    public final void onFailure(Call<T> call, Throwable th) {
        k.c(call, H5Event.TYPE_CALL);
        k.c(th, "t");
        p.a aVar = p.Companion;
        this.$continuation.resumeWith(p.m530constructorimpl(ResultKt.a(th)));
    }
}
