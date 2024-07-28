package a.a.a.a.a.h;

import a.a.a.a.a.d.a;
import a.a.a.a.a.h.a.c;
import a.a.a.a.a.h.a.e;
import a.a.a.a.a.h.a.f;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class a implements a.C0001a {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f752a = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private static a f753c = new a();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static Handler f754d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final Runnable f755e = new b();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final Runnable f756f = new c();

    /* renamed from: b  reason: collision with root package name */
    public List<e> f757b = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private int f758g;

    /* renamed from: h  reason: collision with root package name */
    private a.a.a.a.a.d.b f759h = new a.a.a.a.a.d.b();

    /* renamed from: i  reason: collision with root package name */
    private b f760i = new b();
    /* access modifiers changed from: private */
    public c j = new c(new c());
    private long k;

    /* renamed from: a.a.a.a.a.h.a$a  reason: collision with other inner class name */
    public class C0003a implements Runnable {
        public C0003a() {
        }

        public final void run() {
            a.this.j.b();
        }
    }

    static class b implements Runnable {
        b() {
        }

        public final void run() {
            a.b(a.a());
        }
    }

    static class c implements Runnable {
        c() {
        }

        public final void run() {
            if (a.f754d != null) {
                a.f754d.post(a.f755e);
                a.f754d.postDelayed(a.f756f, 200);
            }
        }
    }

    public interface d extends e {
    }

    public interface e {
    }

    a() {
    }

    public static a a() {
        return f753c;
    }

    private void a(long j2) {
        if (this.f757b.size() > 0) {
            for (e eVar : this.f757b) {
                TimeUnit.NANOSECONDS.toMillis(j2);
                boolean z = eVar instanceof d;
            }
        }
    }

    private void a(View view, a.a.a.a.a.d.a aVar, JSONObject jSONObject, d dVar) {
        aVar.a(view, jSONObject, this, dVar == d.PARENT_VIEW);
    }

    public static void b() {
        if (f754d == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f754d = handler;
            handler.post(f755e);
            f754d.postDelayed(f756f, 200);
        }
    }

    public static void c() {
        Handler handler = f754d;
        if (handler != null) {
            handler.removeCallbacks(f756f);
            f754d = null;
        }
    }

    static /* synthetic */ void b(a aVar) {
        boolean z;
        aVar.f758g = 0;
        aVar.k = System.nanoTime();
        b bVar = aVar.f760i;
        a.a.a.a.a.c.a a2 = a.a.a.a.a.c.a.a();
        if (a2 != null) {
            for (T t : Collections.unmodifiableCollection(a2.f712b)) {
                View d2 = t.d();
                if (t.e()) {
                    if (d2 != null) {
                        if (d2.hasWindowFocus()) {
                            HashSet hashSet = new HashSet();
                            View view = d2;
                            while (true) {
                                if (view != null) {
                                    if (!a.a.a.a.a.e.d.c(view)) {
                                        break;
                                    }
                                    hashSet.add(view);
                                    ViewParent parent = view.getParent();
                                    view = parent instanceof View ? (View) parent : null;
                                } else {
                                    bVar.f773c.addAll(hashSet);
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            bVar.f774d.add(t.f705e);
                            bVar.f771a.put(d2, t.f705e);
                            bVar.a(t);
                        }
                    }
                    bVar.f775e.add(t.f705e);
                }
            }
        }
        long nanoTime = System.nanoTime();
        a.a.a.a.a.d.c cVar = aVar.f759h.f731a;
        if (aVar.f760i.f775e.size() > 0) {
            JSONObject a3 = cVar.a((View) null);
            c cVar2 = aVar.j;
            cVar2.f777a.a(new e(cVar2, aVar.f760i.f775e, a3, nanoTime));
        }
        if (aVar.f760i.f774d.size() > 0) {
            JSONObject a4 = cVar.a((View) null);
            aVar.a((View) null, cVar, a4, d.PARENT_VIEW);
            a.a.a.a.a.e.b.a(a4);
            c cVar3 = aVar.j;
            cVar3.f777a.a(new f(cVar3, aVar.f760i.f774d, a4, nanoTime));
        } else {
            aVar.j.b();
        }
        b bVar2 = aVar.f760i;
        bVar2.f771a.clear();
        bVar2.f772b.clear();
        bVar2.f773c.clear();
        bVar2.f774d.clear();
        bVar2.f775e.clear();
        bVar2.f776f = false;
        aVar.a(System.nanoTime() - aVar.k);
    }

    public final void a(View view, a.a.a.a.a.d.a aVar, JSONObject jSONObject) {
        String str;
        boolean z;
        if (a.a.a.a.a.e.d.c(view)) {
            b bVar = this.f760i;
            d dVar = bVar.f773c.contains(view) ? d.PARENT_VIEW : bVar.f776f ? d.OBSTRUCTION_VIEW : d.UNDERLYING_VIEW;
            if (dVar != d.UNDERLYING_VIEW) {
                JSONObject a2 = aVar.a(view);
                a.a.a.a.a.e.b.a(jSONObject, a2);
                b bVar2 = this.f760i;
                ArrayList arrayList = null;
                if (bVar2.f771a.size() == 0) {
                    str = null;
                } else {
                    str = bVar2.f771a.get(view);
                    if (str != null) {
                        bVar2.f771a.remove(view);
                    }
                }
                if (str != null) {
                    a.a.a.a.a.e.b.a(a2, str);
                    this.f760i.f776f = true;
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    b bVar3 = this.f760i;
                    if (!(bVar3.f772b.size() == 0 || (arrayList = bVar3.f772b.get(view)) == null)) {
                        bVar3.f772b.remove(view);
                        Collections.sort(arrayList);
                    }
                    if (arrayList != null) {
                        a.a.a.a.a.e.b.a(a2, (List<String>) arrayList);
                    }
                    a(view, aVar, a2, dVar);
                }
                this.f758g++;
            }
        }
    }
}
