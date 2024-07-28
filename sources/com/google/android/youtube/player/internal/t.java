package com.google.android.youtube.player.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.youtube.player.internal.f;
import com.google.android.youtube.player.internal.l;
import com.google.android.youtube.player.internal.v;
import java.util.ArrayList;

public abstract class t<T extends IInterface> implements v {

    /* renamed from: a  reason: collision with root package name */
    final Handler f37589a;

    /* renamed from: b  reason: collision with root package name */
    T f37590b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<v.a> f37591c;

    /* renamed from: d  reason: collision with root package name */
    final ArrayList<b<?>> f37592d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    boolean f37593e = false;

    /* renamed from: f  reason: collision with root package name */
    private final Context f37594f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<v.a> f37595g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private boolean f37596h = false;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<v.b> f37597i;
    private boolean j = false;
    private ServiceConnection k;

    /* renamed from: com.google.android.youtube.player.internal.t$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37598a = new int[com.google.android.youtube.player.b.values().length];

        static {
            try {
                f37598a[com.google.android.youtube.player.b.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    protected final class d extends f.a {
        protected d() {
        }

        public final void a(String str, IBinder iBinder) {
            t.this.f37589a.sendMessage(t.this.f37589a.obtainMessage(1, new c(str, iBinder)));
        }
    }

    protected t(Context context, v.a aVar, v.b bVar) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            this.f37594f = (Context) c.a(context);
            this.f37591c = new ArrayList<>();
            this.f37591c.add(c.a(aVar));
            this.f37597i = new ArrayList<>();
            this.f37597i.add(c.a(bVar));
            this.f37589a = new a();
            return;
        }
        throw new IllegalStateException("Clients must be created on the UI thread.");
    }

    static com.google.android.youtube.player.b a(String str) {
        try {
            return com.google.android.youtube.player.b.valueOf(str);
        } catch (IllegalArgumentException unused) {
            return com.google.android.youtube.player.b.UNKNOWN_ERROR;
        } catch (NullPointerException unused2) {
            return com.google.android.youtube.player.b.UNKNOWN_ERROR;
        }
    }

    /* access modifiers changed from: protected */
    public abstract T a(IBinder iBinder);

    /* access modifiers changed from: protected */
    public abstract void a(l lVar, d dVar) throws RemoteException;

    /* access modifiers changed from: protected */
    public abstract String b();

    /* access modifiers changed from: protected */
    public final void b(IBinder iBinder) {
        try {
            a(l.a.a(iBinder), new d());
        } catch (RemoteException unused) {
        }
    }

    /* access modifiers changed from: protected */
    public abstract String c();

    public final void e() {
        this.f37593e = true;
        com.google.android.youtube.player.b a2 = com.google.android.youtube.player.a.a(this.f37594f);
        if (a2 != com.google.android.youtube.player.b.SUCCESS) {
            Handler handler = this.f37589a;
            handler.sendMessage(handler.obtainMessage(3, a2));
            return;
        }
        Intent intent = new Intent(c()).setPackage(aa.a(this.f37594f));
        if (this.k != null) {
            g();
        }
        this.k = new e();
        if (!this.f37594f.bindService(intent, this.k, 129)) {
            Handler handler2 = this.f37589a;
            handler2.sendMessage(handler2.obtainMessage(3, com.google.android.youtube.player.b.ERROR_CONNECTING_TO_SERVICE));
        }
    }

    public final boolean f() {
        return this.f37590b != null;
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        ServiceConnection serviceConnection = this.k;
        if (serviceConnection != null) {
            try {
                this.f37594f.unbindService(serviceConnection);
            } catch (IllegalArgumentException unused) {
            }
        }
        this.f37590b = null;
        this.k = null;
    }

    /* access modifiers changed from: protected */
    public final void h() {
        synchronized (this.f37591c) {
            boolean z = true;
            c.a(!this.f37596h);
            this.f37589a.removeMessages(4);
            this.f37596h = true;
            if (this.f37595g.size() != 0) {
                z = false;
            }
            c.a(z);
            ArrayList<v.a> arrayList = this.f37591c;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size && this.f37593e && f(); i2++) {
                if (!this.f37595g.contains(arrayList.get(i2))) {
                    arrayList.get(i2).a();
                }
            }
            this.f37595g.clear();
            this.f37596h = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void i() {
        this.f37589a.removeMessages(4);
        synchronized (this.f37591c) {
            this.f37596h = true;
            ArrayList<v.a> arrayList = this.f37591c;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size && this.f37593e; i2++) {
                if (this.f37591c.contains(arrayList.get(i2))) {
                    arrayList.get(i2).b();
                }
            }
            this.f37596h = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void j() {
        this.f37589a.removeMessages(4);
        synchronized (this.f37597i) {
            this.j = true;
            ArrayList<v.b> arrayList = this.f37597i;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                if (this.f37593e) {
                    if (this.f37597i.contains(arrayList.get(i2))) {
                        arrayList.get(i2).a();
                    }
                    i2++;
                } else {
                    return;
                }
            }
            this.j = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void k() {
        if (!f()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* access modifiers changed from: protected */
    public final T l() {
        k();
        return this.f37590b;
    }

    final class a extends Handler {
        a() {
        }

        public final void handleMessage(Message message) {
            if (message.what == 3) {
                t tVar = t.this;
                Object obj = message.obj;
                tVar.j();
            } else if (message.what == 4) {
                synchronized (t.this.f37591c) {
                    if (t.this.f37593e && t.this.f() && t.this.f37591c.contains(message.obj)) {
                        ((v.a) message.obj).a();
                    }
                }
            } else if (message.what == 2 && !t.this.f()) {
            } else {
                if (message.what == 2 || message.what == 1) {
                    ((b) message.obj).a();
                }
            }
        }
    }

    protected abstract class b<TListener> {

        /* renamed from: a  reason: collision with root package name */
        TListener f37600a;

        public final void a() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f37600a;
            }
            a(tlistener);
        }

        /* access modifiers changed from: protected */
        public abstract void a(TListener tlistener);

        public b(TListener tlistener) {
            this.f37600a = tlistener;
            synchronized (t.this.f37592d) {
                t.this.f37592d.add(this);
            }
        }
    }

    protected final class c extends b<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        public final com.google.android.youtube.player.b f37602c;

        /* renamed from: d  reason: collision with root package name */
        public final IBinder f37603d;

        public c(String str, IBinder iBinder) {
            super(Boolean.TRUE);
            this.f37602c = t.a(str);
            this.f37603d = iBinder;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void a(Object obj) {
            if (((Boolean) obj) == null) {
                return;
            }
            if (AnonymousClass1.f37598a[this.f37602c.ordinal()] != 1) {
                t.this.j();
                return;
            }
            try {
                if (t.this.b().equals(this.f37603d.getInterfaceDescriptor())) {
                    t.this.f37590b = t.this.a(this.f37603d);
                    if (t.this.f37590b != null) {
                        t.this.h();
                        return;
                    }
                }
            } catch (RemoteException unused) {
            }
            t.this.g();
            t tVar = t.this;
            com.google.android.youtube.player.b bVar = com.google.android.youtube.player.b.INTERNAL_ERROR;
            tVar.j();
        }
    }

    final class e implements ServiceConnection {
        e() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            t.this.b(iBinder);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            t tVar = t.this;
            tVar.f37590b = null;
            tVar.i();
        }
    }

    public void d() {
        i();
        this.f37593e = false;
        synchronized (this.f37592d) {
            int size = this.f37592d.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.f37592d.get(i2);
                synchronized (bVar) {
                    bVar.f37600a = null;
                }
            }
            this.f37592d.clear();
        }
        g();
    }
}
