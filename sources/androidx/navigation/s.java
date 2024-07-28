package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.k;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class s<D extends k> {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList<c> f3963a = new CopyOnWriteArrayList<>();

    public interface a {
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        String a();
    }

    public interface c {
        void a(s sVar);
    }

    public abstract k a(D d2, Bundle bundle, p pVar, a aVar);

    public void a(Bundle bundle) {
    }

    public abstract boolean a();

    public abstract D b();

    public Bundle c() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void d() {
    }

    /* access modifiers changed from: protected */
    public void e() {
    }

    public final void a(c cVar) {
        if (this.f3963a.add(cVar) && this.f3963a.size() == 1) {
            d();
        }
    }

    public final void b(c cVar) {
        if (this.f3963a.remove(cVar) && this.f3963a.isEmpty()) {
            e();
        }
    }
}
