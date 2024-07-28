package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.c;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.k;
import kotlin.u;

public final class d<Args extends c> implements g<Args> {

    /* renamed from: a  reason: collision with root package name */
    private Args f3871a;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.k.c<Args> f3872b;

    /* renamed from: c  reason: collision with root package name */
    private final a<Bundle> f3873c;

    public d(kotlin.k.c<Args> cVar, a<Bundle> aVar) {
        k.c(cVar, "navArgsClass");
        k.c(aVar, "argumentProducer");
        this.f3872b = cVar;
        this.f3873c = aVar;
    }

    public final /* synthetic */ Object getValue() {
        Args args = this.f3871a;
        if (args != null) {
            return args;
        }
        Bundle invoke = this.f3873c.invoke();
        Method method = e.b().get(this.f3872b);
        if (method == null) {
            Class<Args> a2 = kotlin.g.a.a(this.f3872b);
            Class[] a3 = e.a();
            method = a2.getMethod("fromBundle", (Class[]) Arrays.copyOf(a3, a3.length));
            e.b().put(this.f3872b, method);
            k.a((Object) method, "navArgsClass.java.getMet…hod\n                    }");
        }
        Args invoke2 = method.invoke((Object) null, new Object[]{invoke});
        if (invoke2 != null) {
            Args args2 = (c) invoke2;
            this.f3871a = args2;
            return args2;
        }
        throw new u("null cannot be cast to non-null type Args");
    }
}
