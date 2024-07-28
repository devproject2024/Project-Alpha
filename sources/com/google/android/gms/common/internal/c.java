package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.o;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c<T extends IInterface> {

    /* renamed from: a  reason: collision with root package name */
    private static final Feature[] f8792a = new Feature[0];

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f8793h = {"service_esmobile", "service_googleme"};
    /* access modifiers changed from: private */
    public ConnectionResult A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public volatile zzc C;

    /* renamed from: b  reason: collision with root package name */
    int f8794b;

    /* renamed from: c  reason: collision with root package name */
    long f8795c;

    /* renamed from: d  reason: collision with root package name */
    protected final Context f8796d;

    /* renamed from: e  reason: collision with root package name */
    final Handler f8797e;

    /* renamed from: f  reason: collision with root package name */
    protected C0130c f8798f;

    /* renamed from: g  reason: collision with root package name */
    protected AtomicInteger f8799g;

    /* renamed from: i  reason: collision with root package name */
    private long f8800i;
    private int j;
    private long k;
    private aq l;
    private final Looper m;
    private final i n;
    private final com.google.android.gms.common.d o;
    private final Object p;
    /* access modifiers changed from: private */
    public final Object q;
    /* access modifiers changed from: private */
    public o r;
    private T s;
    /* access modifiers changed from: private */
    public final ArrayList<h<?>> t;
    private i u;
    private int v;
    /* access modifiers changed from: private */
    public final a w;
    /* access modifiers changed from: private */
    public final b x;
    private final int y;
    private final String z;

    public interface a {
        void a();

        void a(int i2);
    }

    public interface b {
        void a(ConnectionResult connectionResult);
    }

    /* renamed from: com.google.android.gms.common.internal.c$c  reason: collision with other inner class name */
    public interface C0130c {
        void a(ConnectionResult connectionResult);
    }

    public class d implements C0130c {
        public d() {
        }

        public final void a(ConnectionResult connectionResult) {
            if (connectionResult.b()) {
                c cVar = c.this;
                cVar.a((l) null, cVar.s());
            } else if (c.this.x != null) {
                c.this.x.a(connectionResult);
            }
        }
    }

    public interface e {
        void a();
    }

    /* access modifiers changed from: protected */
    public abstract T a(IBinder iBinder);

    /* access modifiers changed from: protected */
    public abstract String a();

    /* access modifiers changed from: protected */
    public abstract String b();

    public boolean c() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public Account n() {
        return null;
    }

    protected c(Context context, Looper looper, a aVar, b bVar) {
        this(context, looper, i.a(context), com.google.android.gms.common.d.b(), 93, (a) s.a(aVar), (b) s.a(bVar), (String) null);
    }

    final class g extends com.google.android.gms.internal.d.h {
        public g(Looper looper) {
            super(looper);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: android.app.PendingIntent} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r7) {
            /*
                r6 = this;
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.c.this
                java.util.concurrent.atomic.AtomicInteger r0 = r0.f8799g
                int r0 = r0.get()
                int r1 = r7.arg1
                if (r0 == r1) goto L_0x0016
                boolean r0 = b(r7)
                if (r0 == 0) goto L_0x0015
                a(r7)
            L_0x0015:
                return
            L_0x0016:
                int r0 = r7.what
                r1 = 4
                r2 = 1
                r3 = 5
                if (r0 == r2) goto L_0x002a
                int r0 = r7.what
                r4 = 7
                if (r0 == r4) goto L_0x002a
                int r0 = r7.what
                if (r0 == r1) goto L_0x002a
                int r0 = r7.what
                if (r0 != r3) goto L_0x0036
            L_0x002a:
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.c.this
                boolean r0 = r0.h()
                if (r0 != 0) goto L_0x0036
                a(r7)
                return
            L_0x0036:
                int r0 = r7.what
                r4 = 8
                r5 = 3
                if (r0 != r1) goto L_0x0080
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.c.this
                com.google.android.gms.common.ConnectionResult r1 = new com.google.android.gms.common.ConnectionResult
                int r7 = r7.arg2
                r1.<init>(r7)
                com.google.android.gms.common.ConnectionResult unused = r0.A = r1
                com.google.android.gms.common.internal.c r7 = com.google.android.gms.common.internal.c.this
                boolean r7 = r7.v()
                if (r7 == 0) goto L_0x005f
                com.google.android.gms.common.internal.c r7 = com.google.android.gms.common.internal.c.this
                boolean r7 = r7.B
                if (r7 != 0) goto L_0x005f
                com.google.android.gms.common.internal.c r7 = com.google.android.gms.common.internal.c.this
                r7.a((int) r5, null)
                return
            L_0x005f:
                com.google.android.gms.common.internal.c r7 = com.google.android.gms.common.internal.c.this
                com.google.android.gms.common.ConnectionResult r7 = r7.A
                if (r7 == 0) goto L_0x006e
                com.google.android.gms.common.internal.c r7 = com.google.android.gms.common.internal.c.this
                com.google.android.gms.common.ConnectionResult r7 = r7.A
                goto L_0x0073
            L_0x006e:
                com.google.android.gms.common.ConnectionResult r7 = new com.google.android.gms.common.ConnectionResult
                r7.<init>(r4)
            L_0x0073:
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.c.this
                com.google.android.gms.common.internal.c$c r0 = r0.f8798f
                r0.a(r7)
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.c.this
                r0.a((com.google.android.gms.common.ConnectionResult) r7)
                return
            L_0x0080:
                int r0 = r7.what
                if (r0 != r3) goto L_0x00a5
                com.google.android.gms.common.internal.c r7 = com.google.android.gms.common.internal.c.this
                com.google.android.gms.common.ConnectionResult r7 = r7.A
                if (r7 == 0) goto L_0x0093
                com.google.android.gms.common.internal.c r7 = com.google.android.gms.common.internal.c.this
                com.google.android.gms.common.ConnectionResult r7 = r7.A
                goto L_0x0098
            L_0x0093:
                com.google.android.gms.common.ConnectionResult r7 = new com.google.android.gms.common.ConnectionResult
                r7.<init>(r4)
            L_0x0098:
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.c.this
                com.google.android.gms.common.internal.c$c r0 = r0.f8798f
                r0.a(r7)
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.c.this
                r0.a((com.google.android.gms.common.ConnectionResult) r7)
                return
            L_0x00a5:
                int r0 = r7.what
                r1 = 0
                if (r0 != r5) goto L_0x00c9
                java.lang.Object r0 = r7.obj
                boolean r0 = r0 instanceof android.app.PendingIntent
                if (r0 == 0) goto L_0x00b5
                java.lang.Object r0 = r7.obj
                r1 = r0
                android.app.PendingIntent r1 = (android.app.PendingIntent) r1
            L_0x00b5:
                com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult
                int r7 = r7.arg2
                r0.<init>(r7, r1)
                com.google.android.gms.common.internal.c r7 = com.google.android.gms.common.internal.c.this
                com.google.android.gms.common.internal.c$c r7 = r7.f8798f
                r7.a(r0)
                com.google.android.gms.common.internal.c r7 = com.google.android.gms.common.internal.c.this
                r7.a((com.google.android.gms.common.ConnectionResult) r0)
                return
            L_0x00c9:
                int r0 = r7.what
                r4 = 6
                if (r0 != r4) goto L_0x00f8
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.c.this
                r0.a((int) r3, null)
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.c.this
                com.google.android.gms.common.internal.c$a r0 = r0.w
                if (r0 == 0) goto L_0x00e6
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.c.this
                com.google.android.gms.common.internal.c$a r0 = r0.w
                int r4 = r7.arg2
                r0.a(r4)
            L_0x00e6:
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.c.this
                int r7 = r7.arg2
                r0.f8794b = r7
                long r4 = java.lang.System.currentTimeMillis()
                r0.f8795c = r4
                com.google.android.gms.common.internal.c r7 = com.google.android.gms.common.internal.c.this
                boolean unused = r7.a(r3, r2, r1)
                return
            L_0x00f8:
                int r0 = r7.what
                r1 = 2
                if (r0 != r1) goto L_0x0109
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.c.this
                boolean r0 = r0.g()
                if (r0 != 0) goto L_0x0109
                a(r7)
                return
            L_0x0109:
                boolean r0 = b(r7)
                if (r0 == 0) goto L_0x0117
                java.lang.Object r7 = r7.obj
                com.google.android.gms.common.internal.c$h r7 = (com.google.android.gms.common.internal.c.h) r7
                r7.b()
                return
            L_0x0117:
                int r7 = r7.what
                r0 = 45
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r0)
                java.lang.String r0 = "Don't know how to handle message: "
                r1.append(r0)
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                java.lang.Exception r0 = new java.lang.Exception
                r0.<init>()
                java.lang.String r1 = "GmsClient"
                android.util.Log.wtf(r1, r7, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.c.g.handleMessage(android.os.Message):void");
        }

        private static void a(Message message) {
            ((h) message.obj).c();
        }

        private static boolean b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 7;
        }
    }

    protected abstract class h<TListener> {

        /* renamed from: a  reason: collision with root package name */
        private TListener f8806a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f8807b = false;

        public h(TListener tlistener) {
            this.f8806a = tlistener;
        }

        /* access modifiers changed from: protected */
        public abstract void a(TListener tlistener);

        public final void b() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f8806a;
                if (this.f8807b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                }
            }
            if (tlistener != null) {
                try {
                    a(tlistener);
                } catch (RuntimeException e2) {
                    throw e2;
                }
            }
            synchronized (this) {
                this.f8807b = true;
            }
            c();
        }

        public final void c() {
            d();
            synchronized (c.this.t) {
                c.this.t.remove(this);
            }
        }

        public final void d() {
            synchronized (this) {
                this.f8806a = null;
            }
        }
    }

    public final class i implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private final int f8809a;

        public i(int i2) {
            this.f8809a = i2;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            o oVar;
            if (iBinder == null) {
                c.a(c.this);
                return;
            }
            synchronized (c.this.q) {
                c cVar = c.this;
                if (iBinder == null) {
                    oVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof o)) {
                        oVar = new o.a.C0132a(iBinder);
                    } else {
                        oVar = (o) queryLocalInterface;
                    }
                }
                o unused = cVar.r = oVar;
            }
            c.this.a(0, this.f8809a);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (c.this.q) {
                o unused = c.this.r = null;
            }
            c.this.f8797e.sendMessage(c.this.f8797e.obtainMessage(6, this.f8809a, 1));
        }
    }

    public static final class j extends n.a {

        /* renamed from: a  reason: collision with root package name */
        private c f8811a;

        /* renamed from: b  reason: collision with root package name */
        private final int f8812b;

        public j(c cVar, int i2) {
            this.f8811a = cVar;
            this.f8812b = i2;
        }

        public final void a(int i2, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        public final void a(int i2, IBinder iBinder, Bundle bundle) {
            s.a(this.f8811a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f8811a.a(i2, iBinder, bundle, this.f8812b);
            this.f8811a = null;
        }

        public final void a(int i2, IBinder iBinder, zzc zzc) {
            s.a(this.f8811a, (Object) "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            s.a(zzc);
            this.f8811a.C = zzc;
            a(i2, iBinder, zzc.f8876a);
        }
    }

    protected final class k extends f {

        /* renamed from: a  reason: collision with root package name */
        private final IBinder f8813a;

        public k(int i2, IBinder iBinder, Bundle bundle) {
            super(i2, bundle);
            this.f8813a = iBinder;
        }

        /* access modifiers changed from: protected */
        public final void a(ConnectionResult connectionResult) {
            if (c.this.x != null) {
                c.this.x.a(connectionResult);
            }
            c.this.a(connectionResult);
        }

        /* access modifiers changed from: protected */
        public final boolean a() {
            try {
                String interfaceDescriptor = this.f8813a.getInterfaceDescriptor();
                if (!c.this.b().equals(interfaceDescriptor)) {
                    String b2 = c.this.b();
                    StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(b2);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    return false;
                }
                IInterface a2 = c.this.a(this.f8813a);
                if (a2 == null) {
                    return false;
                }
                if (!c.this.a(2, 4, a2) && !c.this.a(3, 4, a2)) {
                    return false;
                }
                ConnectionResult unused = c.this.A = null;
                if (c.this.w != null) {
                    c.this.w.a();
                }
                return true;
            } catch (RemoteException unused2) {
                return false;
            }
        }
    }

    abstract class f extends h<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private final int f8802a;

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f8803b;

        protected f(int i2, Bundle bundle) {
            super(Boolean.TRUE);
            this.f8802a = i2;
            this.f8803b = bundle;
        }

        /* access modifiers changed from: protected */
        public abstract void a(ConnectionResult connectionResult);

        /* access modifiers changed from: protected */
        public abstract boolean a();

        /* JADX WARNING: type inference failed for: r5v11, types: [android.os.Parcelable] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void a(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                r0 = 1
                if (r5 != 0) goto L_0x000b
                com.google.android.gms.common.internal.c r5 = com.google.android.gms.common.internal.c.this
                r5.a((int) r0, null)
                return
            L_0x000b:
                int r5 = r4.f8802a
                r1 = 0
                if (r5 == 0) goto L_0x0061
                r2 = 10
                if (r5 == r2) goto L_0x0031
                com.google.android.gms.common.internal.c r5 = com.google.android.gms.common.internal.c.this
                r5.a((int) r0, null)
                android.os.Bundle r5 = r4.f8803b
                if (r5 == 0) goto L_0x0026
                java.lang.String r0 = "pendingIntent"
                android.os.Parcelable r5 = r5.getParcelable(r0)
                r1 = r5
                android.app.PendingIntent r1 = (android.app.PendingIntent) r1
            L_0x0026:
                com.google.android.gms.common.ConnectionResult r5 = new com.google.android.gms.common.ConnectionResult
                int r0 = r4.f8802a
                r5.<init>(r0, r1)
                r4.a((com.google.android.gms.common.ConnectionResult) r5)
                goto L_0x0076
            L_0x0031:
                com.google.android.gms.common.internal.c r5 = com.google.android.gms.common.internal.c.this
                r5.a((int) r0, null)
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                r1 = 3
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                java.lang.Class r3 = r4.getClass()
                java.lang.String r3 = r3.getSimpleName()
                r1[r2] = r3
                com.google.android.gms.common.internal.c r2 = com.google.android.gms.common.internal.c.this
                java.lang.String r2 = r2.a()
                r1[r0] = r2
                r0 = 2
                com.google.android.gms.common.internal.c r2 = com.google.android.gms.common.internal.c.this
                java.lang.String r2 = r2.b()
                r1[r0] = r2
                java.lang.String r0 = "A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. "
                java.lang.String r0 = java.lang.String.format(r0, r1)
                r5.<init>(r0)
                throw r5
            L_0x0061:
                boolean r5 = r4.a()
                if (r5 != 0) goto L_0x0076
                com.google.android.gms.common.internal.c r5 = com.google.android.gms.common.internal.c.this
                r5.a((int) r0, null)
                com.google.android.gms.common.ConnectionResult r5 = new com.google.android.gms.common.ConnectionResult
                r0 = 8
                r5.<init>(r0, r1)
                r4.a((com.google.android.gms.common.ConnectionResult) r5)
            L_0x0076:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.c.f.a(java.lang.Object):void");
        }
    }

    protected final class l extends f {
        public l(int i2) {
            super(i2, (Bundle) null);
        }

        /* access modifiers changed from: protected */
        public final void a(ConnectionResult connectionResult) {
            c.this.f8798f.a(connectionResult);
            c.this.a(connectionResult);
        }

        /* access modifiers changed from: protected */
        public final boolean a() {
            c.this.f8798f.a(ConnectionResult.f8333a);
            return true;
        }
    }

    protected c(Context context, Looper looper, i iVar, com.google.android.gms.common.d dVar, int i2, a aVar, b bVar, String str) {
        this.p = new Object();
        this.q = new Object();
        this.t = new ArrayList<>();
        this.v = 1;
        this.A = null;
        this.B = false;
        this.C = null;
        this.f8799g = new AtomicInteger(0);
        this.f8796d = (Context) s.a(context, (Object) "Context must not be null");
        this.m = (Looper) s.a(looper, (Object) "Looper must not be null");
        this.n = (i) s.a(iVar, (Object) "Supervisor must not be null");
        this.o = (com.google.android.gms.common.d) s.a(dVar, (Object) "API availability must not be null");
        this.f8797e = new g(looper);
        this.y = i2;
        this.w = aVar;
        this.x = bVar;
        this.z = str;
    }

    private final String t() {
        String str = this.z;
        return str == null ? this.f8796d.getClass().getName() : str;
    }

    public final Feature[] k() {
        zzc zzc = this.C;
        if (zzc == null) {
            return null;
        }
        return zzc.f8877b;
    }

    /* access modifiers changed from: private */
    public final void a(int i2, T t2) {
        boolean z2 = false;
        if ((i2 == 4) == (t2 != null)) {
            z2 = true;
        }
        s.b(z2);
        synchronized (this.p) {
            this.v = i2;
            this.s = t2;
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    if (!(this.u == null || this.l == null)) {
                        String str = this.l.f8783a;
                        String str2 = this.l.f8784b;
                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 70 + String.valueOf(str2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(str);
                        sb.append(" on ");
                        sb.append(str2);
                        i iVar = this.n;
                        String str3 = this.l.f8783a;
                        String str4 = this.l.f8784b;
                        int i3 = this.l.f8785c;
                        i iVar2 = this.u;
                        t();
                        iVar.a(str3, str4, i3, iVar2, this.l.f8786d);
                        this.f8799g.incrementAndGet();
                    }
                    this.u = new i(this.f8799g.get());
                    this.l = new aq("com.google.android.gms", a(), i.a());
                    if (!this.l.f8786d || e() >= 17895000) {
                        i iVar3 = this.n;
                        String str5 = this.l.f8783a;
                        String str6 = this.l.f8784b;
                        int i4 = this.l.f8785c;
                        i iVar4 = this.u;
                        t();
                        if (!iVar3.a(new i.a(str5, str6, i4, this.l.f8786d), iVar4)) {
                            String str7 = this.l.f8783a;
                            String str8 = this.l.f8784b;
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str7).length() + 34 + String.valueOf(str8).length());
                            sb2.append("unable to connect to service: ");
                            sb2.append(str7);
                            sb2.append(" on ");
                            sb2.append(str8);
                            a(16, this.f8799g.get());
                        }
                    } else {
                        String valueOf = String.valueOf(this.l.f8783a);
                        throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                    }
                } else if (i2 == 4) {
                    this.f8800i = System.currentTimeMillis();
                }
            } else if (this.u != null) {
                i iVar5 = this.n;
                String str9 = this.l.f8783a;
                String str10 = this.l.f8784b;
                int i5 = this.l.f8785c;
                i iVar6 = this.u;
                t();
                iVar5.a(str9, str10, i5, iVar6, this.l.f8786d);
                this.u = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean a(int i2, int i3, T t2) {
        synchronized (this.p) {
            if (this.v != i2) {
                return false;
            }
            a(i3, t2);
            return true;
        }
    }

    public final void m() {
        int a2 = this.o.a(this.f8796d, e());
        if (a2 != 0) {
            a(1, (IInterface) null);
            this.f8798f = (C0130c) s.a(new d(), (Object) "Connection progress callbacks cannot be null.");
            Handler handler = this.f8797e;
            handler.sendMessage(handler.obtainMessage(3, this.f8799g.get(), a2, (Object) null));
            return;
        }
        a((C0130c) new d());
    }

    public final void a(C0130c cVar) {
        this.f8798f = (C0130c) s.a(cVar, (Object) "Connection progress callbacks cannot be null.");
        a(2, (IInterface) null);
    }

    public final boolean g() {
        boolean z2;
        synchronized (this.p) {
            z2 = this.v == 4;
        }
        return z2;
    }

    public final boolean h() {
        boolean z2;
        synchronized (this.p) {
            if (this.v != 2) {
                if (this.v != 3) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    private final boolean u() {
        boolean z2;
        synchronized (this.p) {
            z2 = this.v == 3;
        }
        return z2;
    }

    public void f() {
        this.f8799g.incrementAndGet();
        synchronized (this.t) {
            int size = this.t.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.t.get(i2).d();
            }
            this.t.clear();
        }
        synchronized (this.q) {
            this.r = null;
        }
        a(1, (IInterface) null);
    }

    public Feature[] o() {
        return f8792a;
    }

    /* access modifiers changed from: protected */
    public Bundle p() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.f8797e;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new k(i2, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, int i3) {
        Handler handler = this.f8797e;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(i2)));
    }

    public final void q() {
        if (!g()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T r() throws DeadObjectException {
        T t2;
        synchronized (this.p) {
            if (this.v != 5) {
                q();
                s.a(this.s != null, (Object) "Client is connected but service is null");
                t2 = this.s;
            } else {
                throw new DeadObjectException();
            }
        }
        return t2;
    }

    public final void a(l lVar, Set<Scope> set) {
        Bundle p2 = p();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.y);
        getServiceRequest.f8739a = this.f8796d.getPackageName();
        getServiceRequest.f8742d = p2;
        if (set != null) {
            getServiceRequest.f8741c = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (i()) {
            getServiceRequest.f8743e = n() != null ? n() : new Account("<<default account>>", "com.google");
            if (lVar != null) {
                getServiceRequest.f8740b = lVar.asBinder();
            }
        }
        getServiceRequest.f8744f = f8792a;
        getServiceRequest.f8745g = o();
        try {
            synchronized (this.q) {
                if (this.r != null) {
                    this.r.a(new j(this, this.f8799g.get()), getServiceRequest);
                }
            }
        } catch (DeadObjectException unused) {
            Handler handler = this.f8797e;
            handler.sendMessage(handler.obtainMessage(6, this.f8799g.get(), 1));
        } catch (SecurityException e2) {
            throw e2;
        } catch (RemoteException | RuntimeException unused2) {
            a(8, (IBinder) null, (Bundle) null, this.f8799g.get());
        }
    }

    public final void a(e eVar) {
        eVar.a();
    }

    public Intent d() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    /* access modifiers changed from: protected */
    public Set<Scope> s() {
        return Collections.emptySet();
    }

    public final void a(String str, PrintWriter printWriter) {
        int i2;
        T t2;
        o oVar;
        synchronized (this.p) {
            i2 = this.v;
            t2 = this.s;
        }
        synchronized (this.q) {
            oVar = this.r;
        }
        printWriter.append(str).append("mConnectState=");
        if (i2 == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i2 == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i2 == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i2 == 4) {
            printWriter.print("CONNECTED");
        } else if (i2 != 5) {
            printWriter.print(H5Utils.NETWORK_TYPE_UNKNOWN);
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (t2 == null) {
            printWriter.append("null");
        } else {
            printWriter.append(b()).append("@").append(Integer.toHexString(System.identityHashCode(t2.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (oVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(oVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f8800i > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j2 = this.f8800i;
            String format = simpleDateFormat.format(new Date(j2));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j2);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.f8795c > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            int i3 = this.f8794b;
            if (i3 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i3 != 2) {
                printWriter.append(String.valueOf(i3));
            } else {
                printWriter.append("CAUSE_NETWORK_LOST");
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j3 = this.f8795c;
            String format2 = simpleDateFormat.format(new Date(j3));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j3);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.k > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(com.google.android.gms.common.api.c.getStatusCodeString(this.j));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j4 = this.k;
            String format3 = simpleDateFormat.format(new Date(j4));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j4);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    /* access modifiers changed from: private */
    public final boolean v() {
        if (this.B || TextUtils.isEmpty(b()) || TextUtils.isEmpty((CharSequence) null)) {
            return false;
        }
        try {
            Class.forName(b());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final String j() {
        aq aqVar;
        if (g() && (aqVar = this.l) != null) {
            return aqVar.f8784b;
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public int e() {
        return com.google.android.gms.common.d.f8658b;
    }

    /* access modifiers changed from: protected */
    public final void a(ConnectionResult connectionResult) {
        this.j = connectionResult.f8334b;
        this.k = System.currentTimeMillis();
    }

    static /* synthetic */ void a(c cVar) {
        int i2;
        if (cVar.u()) {
            i2 = 5;
            cVar.B = true;
        } else {
            i2 = 4;
        }
        Handler handler = cVar.f8797e;
        handler.sendMessage(handler.obtainMessage(i2, cVar.f8799g.get(), 16));
    }
}
