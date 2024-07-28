package c.a.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.Headers;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    protected Type f5546a;

    /* renamed from: b  reason: collision with root package name */
    protected Headers f5547b;

    public void a(int i2, String str) {
    }

    /* access modifiers changed from: protected */
    public void a(T t) {
    }

    public a() {
        Type type;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            type = Object.class;
        } else {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            if (actualTypeArguments.length <= 0) {
                throw new RuntimeException("Index outof bounds");
            } else if (!(actualTypeArguments[0] instanceof Class)) {
                type = Object.class;
            } else {
                type = actualTypeArguments[0];
            }
        }
        this.f5546a = type;
    }

    /* access modifiers changed from: protected */
    public final void a(Headers headers) {
        this.f5547b = headers;
    }
}
