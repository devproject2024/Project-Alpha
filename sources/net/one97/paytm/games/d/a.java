package net.one97.paytm.games.d;

import android.content.Context;
import com.android.billingclient.api.b;
import com.android.billingclient.api.c;
import com.android.billingclient.api.d;
import com.android.billingclient.api.f;
import com.android.billingclient.api.g;
import com.android.billingclient.api.h;
import java.util.List;

public final class a implements h {

    /* renamed from: a  reason: collision with root package name */
    b f35572a;

    /* renamed from: b  reason: collision with root package name */
    boolean f35573b;

    /* renamed from: c  reason: collision with root package name */
    final C0594a f35574c;

    /* renamed from: d  reason: collision with root package name */
    public int f35575d;

    /* renamed from: net.one97.paytm.games.d.a$a  reason: collision with other inner class name */
    public interface C0594a {
        void Y_();

        void a(int i2, List<g> list);

        void a(String str, int i2);
    }

    public a(Context context, C0594a aVar) {
        this.f35574c = aVar;
        b.a aVar2 = new b.a(context, (byte) 0);
        aVar2.f30913b = this;
        if (aVar2.f30912a == null) {
            throw new IllegalArgumentException("Please provide a valid Context.");
        } else if (aVar2.f30913b != null) {
            this.f35572a = new c(aVar2.f30912a, aVar2.f30913b);
            b(new Runnable() {
                public final void run() {
                    a.this.f35574c.Y_();
                }
            });
        } else {
            throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
        }
    }

    public final void a(int i2, List<g> list) {
        if (i2 == 0) {
            this.f35574c.a(i2, list);
        } else {
            this.f35574c.a(i2, (List<g>) null);
        }
    }

    public final void a() {
        b bVar = this.f35572a;
        if (bVar != null && bVar.a()) {
            this.f35572a.b();
            this.f35572a = null;
        }
    }

    public final void a(final String str) {
        final AnonymousClass3 r0 = new f() {
            public final void a(int i2, String str) {
                a.this.f35574c.a(str, i2);
            }
        };
        a((Runnable) new Runnable() {
            public final void run() {
                a.this.f35572a.a(str, r0);
            }
        });
    }

    private void b(final Runnable runnable) {
        this.f35572a.a((d) new d() {
            public final void a(int i2) {
                if (i2 == 0) {
                    a.this.f35573b = true;
                    Runnable runnable = runnable;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                a.this.f35575d = i2;
            }

            public final void a() {
                a.this.f35573b = false;
            }
        });
    }

    public final void a(Runnable runnable) {
        if (this.f35573b) {
            runnable.run();
        } else {
            b(runnable);
        }
    }
}
