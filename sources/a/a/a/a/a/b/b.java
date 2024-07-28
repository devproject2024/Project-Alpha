package a.a.a.a.a.b;

import a.a.a.a.a.a;
import a.a.a.a.a.e.c;
import android.view.View;

public abstract class b {
    public abstract void a();

    public abstract void a(View view);

    public abstract void b();

    public abstract String c();

    public static b a(c cVar, d dVar) {
        if (a.b()) {
            c.a((Object) cVar, "AdSessionConfiguration is null");
            c.a((Object) dVar, "AdSessionContext is null");
            return new i(cVar, dVar);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }
}
