package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import com.squareup.picasso.a;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class w {

    /* renamed from: a  reason: collision with root package name */
    static final Handler f45444a = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 3) {
                if (i2 == 8) {
                    List list = (List) message.obj;
                    int size = list.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        c cVar = (c) list.get(i3);
                        w wVar = cVar.f45394b;
                        a aVar = cVar.k;
                        List<a> list2 = cVar.l;
                        boolean z = true;
                        boolean z2 = list2 != null && !list2.isEmpty();
                        if (aVar == null && !z2) {
                            z = false;
                        }
                        if (z) {
                            Exception exc = cVar.p;
                            Bitmap bitmap = cVar.m;
                            d dVar = cVar.o;
                            if (aVar != null) {
                                wVar.a(bitmap, dVar, aVar, exc);
                            }
                            if (z2) {
                                int size2 = list2.size();
                                for (int i4 = 0; i4 < size2; i4++) {
                                    wVar.a(bitmap, dVar, list2.get(i4), exc);
                                }
                            }
                            if (!(wVar.f45446c == null || exc == null)) {
                                wVar.f45446c.a(exc);
                            }
                        }
                    }
                } else if (i2 == 13) {
                    List list3 = (List) message.obj;
                    int size3 = list3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        a aVar2 = (a) list3.get(i5);
                        w wVar2 = aVar2.f45341a;
                        Bitmap b2 = s.shouldReadFromMemoryCache(aVar2.f45345e) ? wVar2.b(aVar2.f45349i) : null;
                        if (b2 != null) {
                            wVar2.a(b2, d.MEMORY, aVar2, (Exception) null);
                            if (wVar2.n) {
                                String a2 = aVar2.f45342b.a();
                                ai.a("Main", "completed", a2, "from " + d.MEMORY);
                            }
                        } else {
                            wVar2.a(aVar2);
                            if (wVar2.n) {
                                ai.a("Main", "resumed", aVar2.f45342b.a());
                            }
                        }
                    }
                } else {
                    throw new AssertionError("Unknown handler message received: " + message.what);
                }
            } else {
                a aVar3 = (a) message.obj;
                if (aVar3.f45341a.n) {
                    ai.a("Main", "canceled", aVar3.f45342b.a(), "target got garbage collected");
                }
                aVar3.f45341a.a(aVar3.b());
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static volatile w f45445b = null;

    /* renamed from: c  reason: collision with root package name */
    final c f45446c;

    /* renamed from: d  reason: collision with root package name */
    final List<ab> f45447d;

    /* renamed from: e  reason: collision with root package name */
    final Context f45448e;

    /* renamed from: f  reason: collision with root package name */
    final i f45449f;

    /* renamed from: g  reason: collision with root package name */
    public final d f45450g;

    /* renamed from: h  reason: collision with root package name */
    final ad f45451h;

    /* renamed from: i  reason: collision with root package name */
    final Map<Object, a> f45452i;
    final Map<ImageView, h> j;
    final ReferenceQueue<Object> k;
    final Bitmap.Config l;
    boolean m;
    volatile boolean n;
    boolean o;
    private final f p;
    private final b q;

    public interface c {
        void a(Exception exc);
    }

    public enum e {
        LOW,
        NORMAL,
        HIGH
    }

    public interface f {

        /* renamed from: a  reason: collision with root package name */
        public static final f f45466a = new f() {
            public final z a(z zVar) {
                return zVar;
            }
        };

        z a(z zVar);
    }

    w(Context context, i iVar, d dVar, c cVar, f fVar, List<ab> list, ad adVar, Bitmap.Config config, boolean z, boolean z2) {
        this.f45448e = context;
        this.f45449f = iVar;
        this.f45450g = dVar;
        this.f45446c = cVar;
        this.p = fVar;
        this.l = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new ac(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new f(context));
        arrayList.add(new q(context));
        arrayList.add(new g(context));
        arrayList.add(new b(context));
        arrayList.add(new l(context));
        arrayList.add(new u(iVar.f45417d, adVar));
        this.f45447d = Collections.unmodifiableList(arrayList);
        this.f45451h = adVar;
        this.f45452i = new WeakHashMap();
        this.j = new WeakHashMap();
        this.m = z;
        this.n = z2;
        this.k = new ReferenceQueue<>();
        this.q = new b(this.k, f45444a);
        this.q.start();
    }

    public final void a(ImageView imageView) {
        if (imageView != null) {
            a((Object) imageView);
            return;
        }
        throw new IllegalArgumentException("view cannot be null.");
    }

    public final void a(af afVar) {
        if (afVar != null) {
            a((Object) afVar);
            return;
        }
        throw new IllegalArgumentException("target cannot be null.");
    }

    public final aa a(Uri uri) {
        return new aa(this, uri, 0);
    }

    public final aa a(String str) {
        if (str == null) {
            return new aa(this, (Uri) null, 0);
        }
        if (str.trim().length() != 0) {
            return a(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public final aa a(int i2) {
        if (i2 != 0) {
            return new aa(this, (Uri) null, i2);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    /* access modifiers changed from: package-private */
    public final z a(z zVar) {
        z a2 = this.p.a(zVar);
        if (a2 != null) {
            return a2;
        }
        throw new IllegalStateException("Request transformer " + this.p.getClass().getCanonicalName() + " returned null for " + zVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(ImageView imageView, h hVar) {
        if (this.j.containsKey(imageView)) {
            a((Object) imageView);
        }
        this.j.put(imageView, hVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        Object b2 = aVar.b();
        if (!(b2 == null || this.f45452i.get(b2) == aVar)) {
            a(b2);
            this.f45452i.put(b2, aVar);
        }
        b(aVar);
    }

    /* access modifiers changed from: package-private */
    public final void b(a aVar) {
        this.f45449f.a(aVar);
    }

    /* access modifiers changed from: package-private */
    public final Bitmap b(String str) {
        Bitmap a2 = this.f45450g.a(str);
        if (a2 != null) {
            this.f45451h.a();
        } else {
            this.f45451h.f45367c.sendEmptyMessage(1);
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj) {
        h remove;
        ai.b();
        a remove2 = this.f45452i.remove(obj);
        if (remove2 != null) {
            remove2.a();
            this.f45449f.b(remove2);
        }
        if ((obj instanceof ImageView) && (remove = this.j.remove((ImageView) obj)) != null) {
            remove.a();
        }
    }

    static class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private final ReferenceQueue<Object> f45462a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f45463b;

        b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f45462a = referenceQueue;
            this.f45463b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public final void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a.C0762a aVar = (a.C0762a) this.f45462a.remove(1000);
                    Message obtainMessage = this.f45463b.obtainMessage();
                    if (aVar != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = aVar.f45350a;
                        this.f45463b.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e2) {
                    this.f45463b.post(new Runnable() {
                        public final void run() {
                            throw new RuntimeException(e2);
                        }
                    });
                    return;
                }
            }
        }
    }

    public static w a() {
        if (f45445b == null) {
            synchronized (w.class) {
                if (f45445b == null) {
                    if (PicassoProvider.f45340a != null) {
                        f45445b = new a(PicassoProvider.f45340a).a();
                    } else {
                        throw new IllegalStateException("context == null");
                    }
                }
            }
        }
        return f45445b;
    }

    public static void a(w wVar) {
        if (wVar != null) {
            synchronized (w.class) {
                if (f45445b == null) {
                    f45445b = wVar;
                } else {
                    throw new IllegalStateException("Singleton instance already exists.");
                }
            }
            return;
        }
        throw new IllegalArgumentException("Picasso must not be null.");
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public j f45453a;

        /* renamed from: b  reason: collision with root package name */
        public c f45454b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f45455c;

        /* renamed from: d  reason: collision with root package name */
        private ExecutorService f45456d;

        /* renamed from: e  reason: collision with root package name */
        private d f45457e;

        /* renamed from: f  reason: collision with root package name */
        private f f45458f;

        /* renamed from: g  reason: collision with root package name */
        private List<ab> f45459g;

        /* renamed from: h  reason: collision with root package name */
        private Bitmap.Config f45460h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f45461i;
        private boolean j;

        public a(Context context) {
            if (context != null) {
                this.f45455c = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public final w a() {
            Context context = this.f45455c;
            if (this.f45453a == null) {
                this.f45453a = new v(context);
            }
            if (this.f45457e == null) {
                this.f45457e = new o(context);
            }
            if (this.f45456d == null) {
                this.f45456d = new y();
            }
            if (this.f45458f == null) {
                this.f45458f = f.f45466a;
            }
            ad adVar = new ad(this.f45457e);
            Context context2 = context;
            return new w(context2, new i(context2, this.f45456d, w.f45444a, this.f45453a, this.f45457e, adVar), this.f45457e, this.f45454b, this.f45458f, this.f45459g, adVar, this.f45460h, this.f45461i, this.j);
        }
    }

    public enum d {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        
        final int debugColor;

        private d(int i2) {
            this.debugColor = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Bitmap bitmap, d dVar, a aVar, Exception exc) {
        if (!aVar.l) {
            if (!aVar.k) {
                this.f45452i.remove(aVar.b());
            }
            if (bitmap == null) {
                aVar.a(exc);
                if (this.n) {
                    ai.a("Main", "errored", aVar.f45342b.a(), exc.getMessage());
                }
            } else if (dVar != null) {
                aVar.a(bitmap, dVar);
                if (this.n) {
                    ai.a("Main", "completed", aVar.f45342b.a(), "from ".concat(String.valueOf(dVar)));
                }
            } else {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
        }
    }
}
