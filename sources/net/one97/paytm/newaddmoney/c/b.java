package net.one97.paytm.newaddmoney.c;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.addmoney.j;

public final class b extends al.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f55842a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f55843d;

    /* renamed from: b  reason: collision with root package name */
    private final net.one97.paytm.addmoney.common.d.b f55844b;

    /* renamed from: c  reason: collision with root package name */
    private final Application f55845c;

    public /* synthetic */ b(net.one97.paytm.addmoney.common.d.b bVar, Application application, byte b2) {
        this(bVar, application);
    }

    private b(net.one97.paytm.addmoney.common.d.b bVar, Application application) {
        super(application);
        this.f55844b = bVar;
        this.f55845c = application;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(a.class)) {
            return (ai) new a(this.f55844b, this.f55845c);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + cls.getName());
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(Application application, Fragment fragment) {
            b a2;
            b a3 = b.f55843d;
            if (a3 != null) {
                return a3;
            }
            synchronized (b.class) {
                a2 = b.f55843d;
                if (a2 == null) {
                    Context applicationContext = application != null ? application.getApplicationContext() : null;
                    if (applicationContext == null) {
                        k.a();
                    }
                    net.one97.paytm.addmoney.common.d.b a4 = j.a(applicationContext, fragment);
                    k.a((Object) a4, "Injection.provideAddMone…Context!!,parentFragment)");
                    a2 = new b(a4, application, (byte) 0);
                    b.f55843d = a2;
                }
            }
            return a2;
        }
    }
}
