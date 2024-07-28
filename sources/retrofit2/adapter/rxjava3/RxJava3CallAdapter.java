package retrofit2.adapter.rxjava3;

import io.reactivex.rxjava3.a.a;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.x;
import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;

final class RxJava3CallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isFlowable;
    private final boolean isMaybe;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final x scheduler;

    RxJava3CallAdapter(Type type, x xVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.responseType = type;
        this.scheduler = xVar;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isFlowable = z4;
        this.isSingle = z5;
        this.isMaybe = z6;
        this.isCompletable = z7;
    }

    public final Type responseType() {
        return this.responseType;
    }

    public final Object adapt(Call<R> call) {
        p pVar;
        p callEnqueueObservable = this.isAsync ? new CallEnqueueObservable(call) : new CallExecuteObservable(call);
        if (this.isResult) {
            pVar = new ResultObservable(callEnqueueObservable);
        } else {
            pVar = this.isBody ? new BodyObservable(callEnqueueObservable) : callEnqueueObservable;
        }
        x xVar = this.scheduler;
        if (xVar != null) {
            pVar = pVar.subscribeOn(xVar);
        }
        if (this.isFlowable) {
            return pVar.toFlowable(a.LATEST);
        }
        if (this.isSingle) {
            return pVar.singleOrError();
        }
        if (this.isMaybe) {
            return pVar.singleElement();
        }
        if (this.isCompletable) {
            return pVar.ignoreElements();
        }
        return io.reactivex.rxjava3.h.a.a(pVar);
    }
}
