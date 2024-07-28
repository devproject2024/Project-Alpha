package com.paytm.notification;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.notification.data.c.f;
import com.paytm.notification.models.PaytmInbox;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.g.b.k;

public final class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43032a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static c f43033g;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f43034b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f43035c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final com.paytm.notification.schedulers.c f43036d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final f f43037e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final com.paytm.notification.data.c.b f43038f;

    private d(Context context, com.paytm.notification.schedulers.c cVar, f fVar, com.paytm.notification.data.c.b bVar) {
        this.f43035c = context;
        this.f43036d = cVar;
        this.f43037e = fVar;
        this.f43038f = bVar;
        this.f43034b = Executors.newCachedThreadPool();
    }

    public /* synthetic */ d(Context context, com.paytm.notification.schedulers.c cVar, f fVar, com.paytm.notification.data.c.b bVar, byte b2) {
        this(context, cVar, fVar, bVar);
    }

    public final LiveData<List<com.paytm.notification.data.datasource.dao.f>> a() {
        return this.f43037e.a();
    }

    public final int d() {
        return this.f43037e.d();
    }

    public final y<Integer> e() {
        return this.f43037e.e();
    }

    public final void a(PaytmInbox paytmInbox) {
        k.c(paytmInbox, "paytmInbox");
        this.f43034b.execute(new C0720d(this, paytmInbox));
    }

    /* renamed from: com.paytm.notification.d$d  reason: collision with other inner class name */
    static final class C0720d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f43047a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PaytmInbox f43048b;

        C0720d(d dVar, PaytmInbox paytmInbox) {
            this.f43047a = dVar;
            this.f43048b = paytmInbox;
        }

        public final void run() {
            try {
                this.f43047a.f43034b.execute(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ C0720d f43049a;

                    {
                        this.f43049a = r1;
                    }

                    public final void run() {
                        this.f43049a.f43047a.f43038f.b(this.f43049a.f43048b);
                        this.f43049a.f43047a.f43038f.a();
                    }
                });
                this.f43047a.f43036d.i();
            } catch (Exception e2) {
                com.paytm.notification.b.e.f43014a.b(e2);
            }
        }
    }

    public final void b(PaytmInbox paytmInbox) {
        k.c(paytmInbox, "paytmInbox");
        this.f43034b.execute(new e(this, paytmInbox));
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f43050a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PaytmInbox f43051b;

        e(d dVar, PaytmInbox paytmInbox) {
            this.f43050a = dVar;
            this.f43051b = paytmInbox;
        }

        public final void run() {
            try {
                f d2 = this.f43050a.f43037e;
                String pushId = this.f43051b.getPushId();
                if (pushId == null) {
                    k.a();
                }
                String customerId = this.f43051b.getCustomerId();
                if (customerId == null) {
                    k.a();
                }
                d2.a(pushId, customerId);
                this.f43050a.f43034b.execute(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ e f43052a;

                    {
                        this.f43052a = r1;
                    }

                    public final void run() {
                        this.f43052a.f43050a.f43038f.a(this.f43052a.f43051b);
                        this.f43052a.f43050a.f43038f.a();
                    }
                });
                this.f43050a.f43036d.i();
            } catch (Exception e2) {
                com.paytm.notification.b.e.f43014a.b(e2);
            }
        }
    }

    public final void c() {
        try {
            this.f43036d.e();
        } catch (Exception e2) {
            com.paytm.notification.b.e.f43014a.b(e2);
        }
    }

    public final void a(com.paytm.notification.schedulers.d dVar) {
        k.c(dVar, "strategy");
        this.f43034b.execute(new b(this, dVar));
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f43044a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.notification.schedulers.d f43045b;

        b(d dVar, com.paytm.notification.schedulers.d dVar2) {
            this.f43044a = dVar;
            this.f43045b = dVar2;
        }

        public final void run() {
            new com.paytm.notification.schedulers.b.c(this.f43044a.f43035c).e();
            this.f43044a.f43036d.a(this.f43045b);
        }
    }

    public final void g() {
        this.f43036d.f();
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f43046a;

        c(d dVar) {
            this.f43046a = dVar;
        }

        public final void run() {
            this.f43046a.f43037e.c();
        }
    }

    public final void b() {
        this.f43034b.execute(new c(this));
    }

    public final void f() {
        this.f43037e.f();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
