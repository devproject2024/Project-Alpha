package androidx.work.impl.a.b;

import android.content.Context;
import androidx.work.impl.utils.b.a;

public final class g {

    /* renamed from: e  reason: collision with root package name */
    private static g f5140e;

    /* renamed from: a  reason: collision with root package name */
    public a f5141a;

    /* renamed from: b  reason: collision with root package name */
    public b f5142b;

    /* renamed from: c  reason: collision with root package name */
    public e f5143c;

    /* renamed from: d  reason: collision with root package name */
    public f f5144d;

    public static synchronized g a(Context context, a aVar) {
        g gVar;
        synchronized (g.class) {
            if (f5140e == null) {
                f5140e = new g(context, aVar);
            }
            gVar = f5140e;
        }
        return gVar;
    }

    private g(Context context, a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f5141a = new a(applicationContext, aVar);
        this.f5142b = new b(applicationContext, aVar);
        this.f5143c = new e(applicationContext, aVar);
        this.f5144d = new f(applicationContext, aVar);
    }
}
