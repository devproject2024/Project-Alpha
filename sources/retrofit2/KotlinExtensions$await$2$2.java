package retrofit2;

import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import java.lang.reflect.Method;
import kotlin.ResultKt;
import kotlin.e;
import kotlin.g.b.k;
import kotlin.p;
import kotlinx.coroutines.CancellableContinuation;

public final class KotlinExtensions$await$2$2 implements Callback<T> {
    final /* synthetic */ CancellableContinuation $continuation;

    KotlinExtensions$await$2$2(CancellableContinuation cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public final void onResponse(Call<T> call, Response<T> response) {
        k.c(call, H5Event.TYPE_CALL);
        k.c(response, Payload.RESPONSE);
        if (response.isSuccessful()) {
            T body = response.body();
            if (body == null) {
                Object tag = call.request().tag(Invocation.class);
                if (tag == null) {
                    k.a();
                }
                k.a(tag, "call.request().tag(Invocation::class.java)!!");
                Method method = ((Invocation) tag).method();
                StringBuilder sb = new StringBuilder("Response from ");
                k.a((Object) method, "method");
                Class<?> declaringClass = method.getDeclaringClass();
                k.a((Object) declaringClass, "method.declaringClass");
                sb.append(declaringClass.getName());
                sb.append('.');
                sb.append(method.getName());
                sb.append(" was null but response body type was declared as non-null");
                e eVar = new e(sb.toString());
                p.a aVar = p.Companion;
                this.$continuation.resumeWith(p.m530constructorimpl(ResultKt.a((Throwable) eVar)));
                return;
            }
            p.a aVar2 = p.Companion;
            this.$continuation.resumeWith(p.m530constructorimpl(body));
            return;
        }
        p.a aVar3 = p.Companion;
        this.$continuation.resumeWith(p.m530constructorimpl(ResultKt.a((Throwable) new HttpException(response))));
    }

    public final void onFailure(Call<T> call, Throwable th) {
        k.c(call, H5Event.TYPE_CALL);
        k.c(th, "t");
        p.a aVar = p.Companion;
        this.$continuation.resumeWith(p.m530constructorimpl(ResultKt.a(th)));
    }
}
