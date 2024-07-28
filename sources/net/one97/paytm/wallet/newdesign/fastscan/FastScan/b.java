package net.one97.paytm.wallet.newdesign.fastscan.FastScan;

import android.app.Application;
import android.content.Context;
import android.view.SurfaceHolder;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import kotlin.g.b.k;
import net.one97.paytm.fastscanner.b.e;
import net.one97.paytm.utils.at;
import net.one97.paytm.wallet.a.d;

public final class b extends androidx.lifecycle.a implements z<d> {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.wallet.newdesign.fastscan.a.c f70898a = new net.one97.paytm.wallet.newdesign.fastscan.a.c();

    /* renamed from: b  reason: collision with root package name */
    public y<d> f70899b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<Boolean> f70900c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    y<Boolean> f70901d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public Long f70902e;

    /* renamed from: f  reason: collision with root package name */
    public Long f70903f;

    public static final class a<T> implements z<e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f70904a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f70905b;

        public a(b bVar, boolean z) {
            this.f70904a = bVar;
            this.f70905b = z;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            e eVar = (e) obj;
            b bVar = this.f70904a;
            k.a((Object) eVar, "it");
            b.a(bVar, eVar, this.f70905b);
        }
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.fastscan.FastScan.b$b  reason: collision with other inner class name */
    public static final class C1433b<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f70906a;

        public C1433b(b bVar) {
            this.f70906a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                this.f70906a.f70900c.postValue(Boolean.TRUE);
            }
        }
    }

    public static final class c<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f70907a;

        public c(b bVar) {
            this.f70907a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                this.f70907a.f70901d.postValue(Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        k.c(application, "application");
        net.one97.paytm.wallet.newdesign.fastscan.a.a aVar = net.one97.paytm.wallet.newdesign.fastscan.a.a.f70919c;
        net.one97.paytm.wallet.newdesign.fastscan.a.a.a().observeForever(this);
    }

    public final /* synthetic */ void onChanged(Object obj) {
        d dVar = (d) obj;
        if (dVar == null) {
            return;
        }
        if (dVar instanceof d.e) {
            this.f70899b.postValue((d.e) dVar);
        } else if (dVar instanceof d.h) {
            at.b a2 = at.a();
            k.a((Object) a2, "PaymentSessionEventSender.getInstance()");
            a2.b(Long.valueOf(System.currentTimeMillis()));
            this.f70899b.postValue((d.h) dVar);
        } else if (dVar instanceof d.j) {
            this.f70899b.postValue((d.j) dVar);
        } else if (dVar instanceof d.g) {
            this.f70899b.postValue((d.g) dVar);
        } else if (dVar instanceof d.i) {
            this.f70899b.postValue((d.i) dVar);
        } else {
            this.f70899b.postValue(dVar);
        }
    }

    public static void a(Context context) {
        k.c(context, "context");
        net.one97.paytm.fastscanner.b.d dVar = net.one97.paytm.fastscanner.b.d.f50426a;
        net.one97.paytm.fastscanner.b.d.a(context);
    }

    public static void a() {
        net.one97.paytm.fastscanner.b.d dVar = net.one97.paytm.fastscanner.b.d.f50426a;
        net.one97.paytm.fastscanner.b.d.c();
    }

    public static void a(SurfaceHolder surfaceHolder) {
        k.c(surfaceHolder, "holder");
        net.one97.paytm.fastscanner.b.d dVar = net.one97.paytm.fastscanner.b.d.f50426a;
        net.one97.paytm.fastscanner.b.d.a(surfaceHolder);
    }

    public static void b() {
        net.one97.paytm.fastscanner.b.d dVar = net.one97.paytm.fastscanner.b.d.f50426a;
        net.one97.paytm.fastscanner.b.d.d();
    }

    public static void c() {
        net.one97.paytm.fastscanner.b.d dVar = net.one97.paytm.fastscanner.b.d.f50426a;
        net.one97.paytm.fastscanner.b.d.e();
        net.one97.paytm.fastscanner.b.d dVar2 = net.one97.paytm.fastscanner.b.d.f50426a;
        net.one97.paytm.fastscanner.b.d.f();
    }

    public static void d() {
        net.one97.paytm.fastscanner.b.d dVar = net.one97.paytm.fastscanner.b.d.f50426a;
        net.one97.paytm.fastscanner.b.d.e();
    }

    public static void a(boolean z) {
        net.one97.paytm.fastscanner.b.d dVar = net.one97.paytm.fastscanner.b.d.f50426a;
        net.one97.paytm.fastscanner.b.d.a(z);
    }

    public static boolean e() {
        net.one97.paytm.fastscanner.b.d dVar = net.one97.paytm.fastscanner.b.d.f50426a;
        return net.one97.paytm.fastscanner.b.d.h();
    }

    public final void onCleared() {
        net.one97.paytm.wallet.newdesign.fastscan.a.a aVar = net.one97.paytm.wallet.newdesign.fastscan.a.a.f70919c;
        k.c(this, "fastScanViewModel");
        net.one97.paytm.wallet.newdesign.fastscan.a.a.f70918b.postValue(null);
        net.one97.paytm.wallet.newdesign.fastscan.a.a.f70918b.removeObserver(this);
        y<d> yVar = net.one97.paytm.wallet.newdesign.fastscan.a.a.f70917a;
        if (yVar != null) {
            yVar.removeObserver(aVar);
        }
        net.one97.paytm.wallet.newdesign.fastscan.a.a.f70917a = null;
        super.onCleared();
    }

    public static final /* synthetic */ void a(b bVar, e eVar, boolean z) {
        bVar.f70902e = Long.valueOf(System.currentTimeMillis());
        net.one97.paytm.wallet.newdesign.fastscan.a.a.f70919c.a(eVar.f50433a, z);
    }
}
