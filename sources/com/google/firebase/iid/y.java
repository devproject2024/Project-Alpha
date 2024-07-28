package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.f;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;

public final class y {

    /* renamed from: c  reason: collision with root package name */
    private static y f38895c;

    /* renamed from: a  reason: collision with root package name */
    final Context f38896a;

    /* renamed from: b  reason: collision with root package name */
    final ScheduledExecutorService f38897b;

    /* renamed from: d  reason: collision with root package name */
    private a f38898d = new a(this, (byte) 0);

    /* renamed from: e  reason: collision with root package name */
    private int f38899e = 1;

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final Messenger f38906a;

        /* renamed from: b  reason: collision with root package name */
        final FirebaseIidMessengerCompat f38907b;

        b(IBinder iBinder) throws RemoteException {
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if ("android.os.IMessenger".equals(interfaceDescriptor)) {
                this.f38906a = new Messenger(iBinder);
                this.f38907b = null;
            } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
                this.f38907b = new FirebaseIidMessengerCompat(iBinder);
                this.f38906a = null;
            } else {
                String valueOf = String.valueOf(interfaceDescriptor);
                if (valueOf.length() != 0) {
                    "Invalid interface descriptor: ".concat(valueOf);
                } else {
                    new String("Invalid interface descriptor: ");
                }
                throw new RemoteException();
            }
        }
    }

    public static synchronized y a(Context context) {
        y yVar;
        synchronized (y.class) {
            if (f38895c == null) {
                com.google.android.gms.internal.e.b a2 = com.google.android.gms.internal.e.a.a();
                com.google.android.gms.common.util.a.b bVar = new com.google.android.gms.common.util.a.b("MessengerIpcClient");
                int i2 = com.google.android.gms.internal.e.e.f9461a;
                f38895c = new y(context, a2.a(bVar));
            }
            yVar = f38895c;
        }
        return yVar;
    }

    public static class d extends Exception {
        private final int errorCode;

        public d(int i2, String str) {
            super(str);
            this.errorCode = i2;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }

    static class e extends c<Bundle> {
        e(int i2, Bundle bundle) {
            super(i2, bundle);
        }

        /* access modifiers changed from: package-private */
        public final void a(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle("data");
            if (bundle2 == null) {
                bundle2 = Bundle.EMPTY;
            }
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String valueOf = String.valueOf(this);
                String valueOf2 = String.valueOf(bundle2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length());
                sb.append("Finishing ");
                sb.append(valueOf);
                sb.append(" with ");
                sb.append(valueOf2);
            }
            this.f38909b.a(bundle2);
        }
    }

    class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        int f38900a;

        /* renamed from: b  reason: collision with root package name */
        final Messenger f38901b;

        /* renamed from: c  reason: collision with root package name */
        b f38902c;

        /* renamed from: d  reason: collision with root package name */
        final Queue<c<?>> f38903d;

        /* renamed from: e  reason: collision with root package name */
        final SparseArray<c<?>> f38904e;

        private a() {
            this.f38900a = 0;
            this.f38901b = new Messenger(new com.google.android.gms.internal.e.d(Looper.getMainLooper(), new z(this)));
            this.f38903d = new ArrayDeque();
            this.f38904e = new SparseArray<>();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0087, code lost:
            return true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized boolean a(com.google.firebase.iid.y.c<?> r6) {
            /*
                r5 = this;
                monitor-enter(r5)
                int r0 = r5.f38900a     // Catch:{ all -> 0x0088 }
                r1 = 2
                r2 = 0
                r3 = 1
                if (r0 == 0) goto L_0x0041
                if (r0 == r3) goto L_0x003a
                if (r0 == r1) goto L_0x0030
                r6 = 3
                if (r0 == r6) goto L_0x002e
                r6 = 4
                if (r0 != r6) goto L_0x0013
                goto L_0x002e
            L_0x0013:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0088 }
                int r0 = r5.f38900a     // Catch:{ all -> 0x0088 }
                r1 = 26
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
                r2.<init>(r1)     // Catch:{ all -> 0x0088 }
                java.lang.String r1 = "Unknown state: "
                r2.append(r1)     // Catch:{ all -> 0x0088 }
                r2.append(r0)     // Catch:{ all -> 0x0088 }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0088 }
                r6.<init>(r0)     // Catch:{ all -> 0x0088 }
                throw r6     // Catch:{ all -> 0x0088 }
            L_0x002e:
                monitor-exit(r5)
                return r2
            L_0x0030:
                java.util.Queue<com.google.firebase.iid.y$c<?>> r0 = r5.f38903d     // Catch:{ all -> 0x0088 }
                r0.add(r6)     // Catch:{ all -> 0x0088 }
                r5.a()     // Catch:{ all -> 0x0088 }
                monitor-exit(r5)
                return r3
            L_0x003a:
                java.util.Queue<com.google.firebase.iid.y$c<?>> r0 = r5.f38903d     // Catch:{ all -> 0x0088 }
                r0.add(r6)     // Catch:{ all -> 0x0088 }
                monitor-exit(r5)
                return r3
            L_0x0041:
                java.util.Queue<com.google.firebase.iid.y$c<?>> r0 = r5.f38903d     // Catch:{ all -> 0x0088 }
                r0.add(r6)     // Catch:{ all -> 0x0088 }
                int r6 = r5.f38900a     // Catch:{ all -> 0x0088 }
                if (r6 != 0) goto L_0x004c
                r6 = 1
                goto L_0x004d
            L_0x004c:
                r6 = 0
            L_0x004d:
                com.google.android.gms.common.internal.s.a((boolean) r6)     // Catch:{ all -> 0x0088 }
                java.lang.String r6 = "MessengerIpcClient"
                android.util.Log.isLoggable(r6, r1)     // Catch:{ all -> 0x0088 }
                r5.f38900a = r3     // Catch:{ all -> 0x0088 }
                android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x0088 }
                java.lang.String r0 = "com.google.android.c2dm.intent.REGISTER"
                r6.<init>(r0)     // Catch:{ all -> 0x0088 }
                java.lang.String r0 = "com.google.android.gms"
                r6.setPackage(r0)     // Catch:{ all -> 0x0088 }
                com.google.android.gms.common.stats.a.a()     // Catch:{ all -> 0x0088 }
                com.google.firebase.iid.y r0 = com.google.firebase.iid.y.this     // Catch:{ all -> 0x0088 }
                android.content.Context r0 = r0.f38896a     // Catch:{ all -> 0x0088 }
                boolean r6 = com.google.android.gms.common.stats.a.b(r0, r6, r5, r3)     // Catch:{ all -> 0x0088 }
                if (r6 != 0) goto L_0x0076
                java.lang.String r6 = "Unable to bind to service"
                r5.a(r2, r6)     // Catch:{ all -> 0x0088 }
                goto L_0x0086
            L_0x0076:
                com.google.firebase.iid.y r6 = com.google.firebase.iid.y.this     // Catch:{ all -> 0x0088 }
                java.util.concurrent.ScheduledExecutorService r6 = r6.f38897b     // Catch:{ all -> 0x0088 }
                com.google.firebase.iid.aa r0 = new com.google.firebase.iid.aa     // Catch:{ all -> 0x0088 }
                r0.<init>(r5)     // Catch:{ all -> 0x0088 }
                r1 = 30
                java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0088 }
                r6.schedule(r0, r1, r4)     // Catch:{ all -> 0x0088 }
            L_0x0086:
                monitor-exit(r5)
                return r3
            L_0x0088:
                r6 = move-exception
                monitor-exit(r5)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.y.a.a(com.google.firebase.iid.y$c):boolean");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
            r5 = r5.getData();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004c, code lost:
            if (r5.getBoolean("unsupported", false) == false) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
            r1.a(new com.google.firebase.iid.y.d(4, "Not supported by GmsCore"));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x005a, code lost:
            r1.a(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
            return true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(android.os.Message r5) {
            /*
                r4 = this;
                int r0 = r5.arg1
                java.lang.String r1 = "MessengerIpcClient"
                r2 = 3
                boolean r1 = android.util.Log.isLoggable(r1, r2)
                if (r1 == 0) goto L_0x001a
                r1 = 41
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                java.lang.String r1 = "Received response to request: "
                r2.append(r1)
                r2.append(r0)
            L_0x001a:
                monitor-enter(r4)
                android.util.SparseArray<com.google.firebase.iid.y$c<?>> r1 = r4.f38904e     // Catch:{ all -> 0x005e }
                java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x005e }
                com.google.firebase.iid.y$c r1 = (com.google.firebase.iid.y.c) r1     // Catch:{ all -> 0x005e }
                r2 = 1
                if (r1 != 0) goto L_0x0037
                r5 = 50
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
                r1.<init>(r5)     // Catch:{ all -> 0x005e }
                java.lang.String r5 = "Received response for unknown request: "
                r1.append(r5)     // Catch:{ all -> 0x005e }
                r1.append(r0)     // Catch:{ all -> 0x005e }
                monitor-exit(r4)     // Catch:{ all -> 0x005e }
                return r2
            L_0x0037:
                android.util.SparseArray<com.google.firebase.iid.y$c<?>> r3 = r4.f38904e     // Catch:{ all -> 0x005e }
                r3.remove(r0)     // Catch:{ all -> 0x005e }
                r4.b()     // Catch:{ all -> 0x005e }
                monitor-exit(r4)     // Catch:{ all -> 0x005e }
                android.os.Bundle r5 = r5.getData()
                r0 = 0
                java.lang.String r3 = "unsupported"
                boolean r0 = r5.getBoolean(r3, r0)
                if (r0 == 0) goto L_0x005a
                com.google.firebase.iid.y$d r5 = new com.google.firebase.iid.y$d
                r0 = 4
                java.lang.String r3 = "Not supported by GmsCore"
                r5.<init>(r0, r3)
                r1.a((com.google.firebase.iid.y.d) r5)
                goto L_0x005d
            L_0x005a:
                r1.a((android.os.Bundle) r5)
            L_0x005d:
                return r2
            L_0x005e:
                r5 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x005e }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.y.a.a(android.os.Message):boolean");
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.isLoggable("MessengerIpcClient", 2);
            y.this.f38897b.execute(new ab(this, iBinder));
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            y.this.f38897b.execute(new ac(this));
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            Log.isLoggable("MessengerIpcClient", 2);
            y.this.f38897b.execute(new ad(this));
        }

        /* access modifiers changed from: package-private */
        public final synchronized void a(int i2, String str) {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "Disconnected: ".concat(valueOf);
                } else {
                    new String("Disconnected: ");
                }
            }
            int i3 = this.f38900a;
            if (i3 == 0) {
                throw new IllegalStateException();
            } else if (i3 == 1 || i3 == 2) {
                Log.isLoggable("MessengerIpcClient", 2);
                this.f38900a = 4;
                com.google.android.gms.common.stats.a.a();
                com.google.android.gms.common.stats.a.a(y.this.f38896a, this);
                a(new d(i2, str));
            } else if (i3 == 3) {
                this.f38900a = 4;
            } else if (i3 != 4) {
                int i4 = this.f38900a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i4);
                throw new IllegalStateException(sb.toString());
            }
        }

        private void a(d dVar) {
            for (c a2 : this.f38903d) {
                a2.a(dVar);
            }
            this.f38903d.clear();
            for (int i2 = 0; i2 < this.f38904e.size(); i2++) {
                this.f38904e.valueAt(i2).a(dVar);
            }
            this.f38904e.clear();
        }

        /* access modifiers changed from: package-private */
        public final synchronized void b() {
            if (this.f38900a == 2 && this.f38903d.isEmpty() && this.f38904e.size() == 0) {
                Log.isLoggable("MessengerIpcClient", 2);
                this.f38900a = 3;
                com.google.android.gms.common.stats.a.a();
                com.google.android.gms.common.stats.a.a(y.this.f38896a, this);
            }
        }

        /* access modifiers changed from: package-private */
        public final synchronized void c() {
            if (this.f38900a == 1) {
                a(1, "Timed out while binding");
            }
        }

        /* access modifiers changed from: package-private */
        public final synchronized void a(int i2) {
            c cVar = this.f38904e.get(i2);
            if (cVar != null) {
                StringBuilder sb = new StringBuilder(31);
                sb.append("Timing out request: ");
                sb.append(i2);
                this.f38904e.remove(i2);
                cVar.a(new d(3, "Timed out waiting for response"));
                b();
            }
        }

        /* synthetic */ a(y yVar, byte b2) {
            this();
        }
    }

    private y(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f38897b = scheduledExecutorService;
        this.f38896a = context.getApplicationContext();
    }

    public final Task<Bundle> a(Bundle bundle) {
        return a(new e(a(), bundle));
    }

    private synchronized <T> Task<T> a(c<T> cVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(cVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
        }
        if (!this.f38898d.a((c<?>) cVar)) {
            this.f38898d = new a(this, (byte) 0);
            this.f38898d.a((c<?>) cVar);
        }
        return cVar.f38909b.f12478a;
    }

    static abstract class c<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f38908a;

        /* renamed from: b  reason: collision with root package name */
        final f<T> f38909b = new f<>();

        /* renamed from: c  reason: collision with root package name */
        final int f38910c;

        /* renamed from: d  reason: collision with root package name */
        final Bundle f38911d;

        c(int i2, Bundle bundle) {
            this.f38908a = i2;
            this.f38910c = 1;
            this.f38911d = bundle;
        }

        /* access modifiers changed from: package-private */
        public abstract void a(Bundle bundle);

        /* access modifiers changed from: package-private */
        public final void a(d dVar) {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String valueOf = String.valueOf(this);
                String valueOf2 = String.valueOf(dVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length());
                sb.append("Failing ");
                sb.append(valueOf);
                sb.append(" with ");
                sb.append(valueOf2);
            }
            this.f38909b.a((Exception) dVar);
        }

        public String toString() {
            int i2 = this.f38910c;
            int i3 = this.f38908a;
            StringBuilder sb = new StringBuilder(55);
            sb.append("Request { what=");
            sb.append(i2);
            sb.append(" id=");
            sb.append(i3);
            sb.append(" oneWay=false}");
            return sb.toString();
        }
    }

    private synchronized int a() {
        int i2;
        i2 = this.f38899e;
        this.f38899e = i2 + 1;
        return i2;
    }
}
