package retrofit2.adapter.rxjava3;

import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.l;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.a.y;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

public final class RxJava3CallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;
    private final x scheduler;

    public static RxJava3CallAdapterFactory create() {
        return new RxJava3CallAdapterFactory((x) null, true);
    }

    public static RxJava3CallAdapterFactory createSynchronous() {
        return new RxJava3CallAdapterFactory((x) null, false);
    }

    public static RxJava3CallAdapterFactory createWithScheduler(x xVar) {
        if (xVar != null) {
            return new RxJava3CallAdapterFactory(xVar, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    private RxJava3CallAdapterFactory(x xVar, boolean z) {
        this.scheduler = xVar;
        this.isAsync = z;
    }

    public final CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        boolean z;
        boolean z2;
        Type type2;
        Class<?> rawType = getRawType(type);
        if (rawType == b.class) {
            return new RxJava3CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
        }
        boolean z3 = rawType == h.class;
        boolean z4 = rawType == y.class;
        boolean z5 = rawType == l.class;
        if (rawType != p.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type parameterUpperBound = getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType2 = getRawType(parameterUpperBound);
        if (rawType2 == Response.class) {
            if (parameterUpperBound instanceof ParameterizedType) {
                type2 = getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                z2 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (rawType2 != Result.class) {
            type2 = parameterUpperBound;
            z2 = false;
            z = true;
            return new RxJava3CallAdapter(type2, this.scheduler, this.isAsync, z2, z, z3, z4, z5, false);
        } else if (parameterUpperBound instanceof ParameterizedType) {
            type2 = getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
            z2 = true;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        z = false;
        return new RxJava3CallAdapter(type2, this.scheduler, this.isAsync, z2, z, z3, z4, z5, false);
    }
}
