package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.ac;
import androidx.lifecycle.k;

public final class ab implements q {

    /* renamed from: i  reason: collision with root package name */
    private static final ab f3603i = new ab();

    /* renamed from: a  reason: collision with root package name */
    int f3604a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f3605b = 0;

    /* renamed from: c  reason: collision with root package name */
    boolean f3606c = true;

    /* renamed from: d  reason: collision with root package name */
    Handler f3607d;

    /* renamed from: e  reason: collision with root package name */
    final t f3608e = new t(this);

    /* renamed from: f  reason: collision with root package name */
    Runnable f3609f = new Runnable() {
        public final void run() {
            ab abVar = ab.this;
            if (abVar.f3605b == 0) {
                abVar.f3606c = true;
                abVar.f3608e.a(k.a.ON_PAUSE);
            }
            ab.this.d();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    ac.a f3610g = new ac.a() {
        public final void a() {
            ab.this.b();
        }

        public final void b() {
            ab.this.c();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private boolean f3611h = true;

    public static q a() {
        return f3603i;
    }

    static void a(Context context) {
        ab abVar = f3603i;
        abVar.f3607d = new Handler();
        abVar.f3608e.a(k.a.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new f() {
            public final void onActivityPreCreated(Activity activity, Bundle bundle) {
                activity.registerActivityLifecycleCallbacks(new f() {
                    public final void onActivityPostStarted(Activity activity) {
                        ab.this.b();
                    }

                    public final void onActivityPostResumed(Activity activity) {
                        ab.this.c();
                    }
                });
            }

            public final void onActivityCreated(Activity activity, Bundle bundle) {
                if (Build.VERSION.SDK_INT < 29) {
                    ac.b(activity).f3614a = ab.this.f3610g;
                }
            }

            public final void onActivityPaused(Activity activity) {
                ab abVar = ab.this;
                abVar.f3605b--;
                if (abVar.f3605b == 0) {
                    abVar.f3607d.postDelayed(abVar.f3609f, 700);
                }
            }

            public final void onActivityStopped(Activity activity) {
                ab abVar = ab.this;
                abVar.f3604a--;
                abVar.d();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.f3604a++;
        if (this.f3604a == 1 && this.f3611h) {
            this.f3608e.a(k.a.ON_START);
            this.f3611h = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f3605b++;
        if (this.f3605b != 1) {
            return;
        }
        if (this.f3606c) {
            this.f3608e.a(k.a.ON_RESUME);
            this.f3606c = false;
            return;
        }
        this.f3607d.removeCallbacks(this.f3609f);
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        if (this.f3604a == 0 && this.f3606c) {
            this.f3608e.a(k.a.ON_STOP);
            this.f3611h = true;
        }
    }

    private ab() {
    }

    public final k getLifecycle() {
        return this.f3608e;
    }
}
