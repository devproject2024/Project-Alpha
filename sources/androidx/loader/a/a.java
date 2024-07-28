package androidx.loader.a;

import android.os.Bundle;
import androidx.lifecycle.ao;
import androidx.lifecycle.q;
import androidx.loader.b.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a {

    /* renamed from: androidx.loader.a.a$a  reason: collision with other inner class name */
    public interface C0056a<D> {
        c<D> a(Bundle bundle);

        void a(c<D> cVar);

        void a(c<D> cVar, D d2);
    }

    public abstract <D> c<D> a(int i2, Bundle bundle, C0056a<D> aVar);

    public abstract <D> c<D> a(int i2, C0056a<D> aVar);

    public abstract void a();

    public abstract void a(int i2);

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract <D> c<D> b(int i2);

    public static <T extends q & ao> a a(T t) {
        return new b(t, ((ao) t).getViewModelStore());
    }
}
