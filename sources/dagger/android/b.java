package dagger.android;

import dagger.a.g;
import dagger.android.a;
import java.util.ArrayList;
import java.util.Map;

public final class b<T> implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, javax.a.a<a.C0767a<?>>> f46003a;

    private boolean b(T t) {
        javax.a.a aVar = this.f46003a.get(t.getClass().getName());
        if (aVar == null) {
            return false;
        }
        a.C0767a aVar2 = (a.C0767a) aVar.get();
        try {
            ((a) g.a(aVar2.a(), "%s.create(I) should not return null.", aVar2.getClass())).a(t);
            return true;
        } catch (ClassCastException e2) {
            throw new a(String.format("%s does not implement AndroidInjector.Factory<%s>", new Object[]{aVar2.getClass().getCanonicalName(), t.getClass().getCanonicalName()}), e2);
        }
    }

    public final void a(T t) {
        if (!b(t)) {
            throw new IllegalArgumentException(c(t));
        }
    }

    public static final class a extends RuntimeException {
        a(String str, ClassCastException classCastException) {
            super(str, classCastException);
        }
    }

    private String c(T t) {
        ArrayList arrayList = new ArrayList();
        for (Class cls = t.getClass(); cls != null; cls = cls.getSuperclass()) {
            if (this.f46003a.containsKey(cls.getCanonicalName())) {
                arrayList.add(cls.getCanonicalName());
            }
        }
        if (arrayList.isEmpty()) {
            return String.format("No injector factory bound for Class<%s>", new Object[]{t.getClass().getCanonicalName()});
        }
        return String.format("No injector factory bound for Class<%1$s>. Injector factories were bound for supertypes of %1$s: %2$s. Did you mean to bind an injector factory for the subtype?", new Object[]{t.getClass().getCanonicalName(), arrayList});
    }
}
