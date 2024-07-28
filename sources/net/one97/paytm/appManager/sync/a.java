package net.one97.paytm.appManager.sync;

import android.content.Context;
import android.os.AsyncTask;
import androidx.work.c;
import androidx.work.m;
import androidx.work.n;
import androidx.work.v;
import androidx.work.w;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.appManager.b.b;
import net.one97.paytm.appManager.sync.SyncAndSaveWork;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f49082a = new a();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static v f49083b;

    /* renamed from: c  reason: collision with root package name */
    private static int f49084c;

    private a() {
    }

    public static int a() {
        return f49084c;
    }

    public static void a(int i2) {
        f49084c = i2;
    }

    /* renamed from: net.one97.paytm.appManager.sync.a$a  reason: collision with other inner class name */
    static final class C0867a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f49085a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Long f49086b;

        C0867a(Context context, Long l) {
            this.f49085a = context;
            this.f49086b = l;
        }

        public final void run() {
            c b2 = new c.a().a(m.CONNECTED).b();
            k.a((Object) b2, "with(Constraints.Builder…ED)\n            }.build()");
            final x.e eVar = new x.e();
            n.a aVar = new n.a(SyncAndSaveWork.class);
            aVar.a(b2);
            SyncAndSaveWork.a aVar2 = SyncAndSaveWork.f49070g;
            aVar.a(SyncAndSaveWork.f49071i);
            aVar.a(4, TimeUnit.SECONDS);
            T c2 = ((n.a) aVar.a(androidx.work.a.EXPONENTIAL, 1, TimeUnit.MINUTES)).c();
            k.a((Object) c2, "with(OneTimeWorkRequest.…ES)\n            }.build()");
            eVar.element = (n) c2;
            a aVar3 = a.f49082a;
            if (a.f49083b == null) {
                a aVar4 = a.f49082a;
                a.f49083b = v.a(this.f49085a);
            }
            v a2 = v.a(this.f49085a);
            SyncAndSaveWork.a aVar5 = SyncAndSaveWork.f49070g;
            a2.a(SyncAndSaveWork.f49071i);
            a aVar6 = a.f49082a;
            if (a.b(this.f49085a, this.f49086b)) {
                net.one97.paytm.appManager.storage.b.a aVar7 = net.one97.paytm.appManager.storage.b.a.f49053c;
                if (net.one97.paytm.appManager.storage.b.a.a(this.f49085a) == -1) {
                    b.a aVar8 = b.f49032f;
                    net.one97.paytm.appManager.a.a r0 = new net.one97.paytm.appManager.a.a() {
                        public final void a(boolean z) {
                            if (!z) {
                                a aVar = a.f49082a;
                                v b2 = a.f49083b;
                                if (b2 != null) {
                                    b2.a((w) (n) eVar.element);
                                }
                            }
                            b.a aVar2 = b.f49032f;
                            net.one97.paytm.appManager.a.a aVar3 = this;
                            synchronized (b.f49033i) {
                                b.a aVar4 = b.f49032f;
                                HashSet hashSet = (HashSet) b.f49033i.get();
                                if (hashSet != null) {
                                    Boolean.valueOf(hashSet.remove(aVar3));
                                }
                            }
                        }
                    };
                    synchronized (b.f49033i) {
                        b.a aVar9 = b.f49032f;
                        HashSet hashSet = (HashSet) b.f49033i.get();
                        if (hashSet != null) {
                            Boolean.valueOf(hashSet.add(r0));
                        }
                    }
                    return;
                }
                a aVar10 = a.f49082a;
                v b3 = a.f49083b;
                if (b3 != null) {
                    b3.a((w) (n) eVar.element);
                }
            }
        }
    }

    public final synchronized void a(Context context, Long l) {
        k.c(context, "context");
        AsyncTask.SERIAL_EXECUTOR.execute(new C0867a(context, l));
    }

    public static final /* synthetic */ boolean b(Context context, Long l) {
        if (l == null) {
            return true;
        }
        net.one97.paytm.appManager.storage.b.a aVar = net.one97.paytm.appManager.storage.b.a.f49053c;
        k.c(context, "context");
        if (System.currentTimeMillis() > net.one97.paytm.appManager.storage.b.a.c(context).b(net.one97.paytm.appManager.storage.b.a.f49051a, -1, false) + l.longValue()) {
            return true;
        }
        return false;
    }
}
