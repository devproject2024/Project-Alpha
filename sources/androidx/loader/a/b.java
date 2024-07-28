package androidx.loader.a;

import android.os.Bundle;
import android.os.Looper;
import androidx.a.h;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.an;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.loader.a.a;
import androidx.loader.b.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    static boolean f3692a = false;

    /* renamed from: b  reason: collision with root package name */
    private final q f3693b;

    /* renamed from: c  reason: collision with root package name */
    private final c f3694c;

    public static class a<D> extends y<D> implements c.C0059c<D> {

        /* renamed from: a  reason: collision with root package name */
        final int f3695a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f3696b;

        /* renamed from: c  reason: collision with root package name */
        final androidx.loader.b.c<D> f3697c;

        /* renamed from: d  reason: collision with root package name */
        C0057b<D> f3698d;

        /* renamed from: e  reason: collision with root package name */
        private q f3699e;

        /* renamed from: f  reason: collision with root package name */
        private androidx.loader.b.c<D> f3700f;

        a(int i2, Bundle bundle, androidx.loader.b.c<D> cVar, androidx.loader.b.c<D> cVar2) {
            this.f3695a = i2;
            this.f3696b = bundle;
            this.f3697c = cVar;
            this.f3700f = cVar2;
            this.f3697c.registerListener(i2, this);
        }

        public final void onActive() {
            if (b.f3692a) {
                new StringBuilder("  Starting: ").append(this);
            }
            this.f3697c.startLoading();
        }

        public final void onInactive() {
            if (b.f3692a) {
                new StringBuilder("  Stopping: ").append(this);
            }
            this.f3697c.stopLoading();
        }

        /* access modifiers changed from: package-private */
        public final androidx.loader.b.c<D> a(q qVar, a.C0056a<D> aVar) {
            C0057b<D> bVar = new C0057b<>(this.f3697c, aVar);
            observe(qVar, bVar);
            C0057b<D> bVar2 = this.f3698d;
            if (bVar2 != null) {
                removeObserver(bVar2);
            }
            this.f3699e = qVar;
            this.f3698d = bVar;
            return this.f3697c;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            q qVar = this.f3699e;
            C0057b<D> bVar = this.f3698d;
            if (qVar != null && bVar != null) {
                super.removeObserver(bVar);
                observe(qVar, bVar);
            }
        }

        public final void removeObserver(z<? super D> zVar) {
            super.removeObserver(zVar);
            this.f3699e = null;
            this.f3698d = null;
        }

        /* access modifiers changed from: package-private */
        public final androidx.loader.b.c<D> a(boolean z) {
            if (b.f3692a) {
                new StringBuilder("  Destroying: ").append(this);
            }
            this.f3697c.cancelLoad();
            this.f3697c.abandon();
            C0057b<D> bVar = this.f3698d;
            if (bVar != null) {
                removeObserver(bVar);
                if (z) {
                    bVar.a();
                }
            }
            this.f3697c.unregisterListener(this);
            if ((bVar == null || bVar.f3701a) && !z) {
                return this.f3697c;
            }
            this.f3697c.reset();
            return this.f3700f;
        }

        public final void a(D d2) {
            if (b.f3692a) {
                new StringBuilder("onLoadComplete: ").append(this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d2);
                return;
            }
            boolean z = b.f3692a;
            postValue(d2);
        }

        public final void setValue(D d2) {
            super.setValue(d2);
            androidx.loader.b.c<D> cVar = this.f3700f;
            if (cVar != null) {
                cVar.reset();
                this.f3700f = null;
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f3695a);
            sb.append(" : ");
            androidx.core.g.a.a(this.f3697c, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: androidx.loader.a.b$b  reason: collision with other inner class name */
    static class C0057b<D> implements z<D> {

        /* renamed from: a  reason: collision with root package name */
        boolean f3701a = false;

        /* renamed from: b  reason: collision with root package name */
        private final androidx.loader.b.c<D> f3702b;

        /* renamed from: c  reason: collision with root package name */
        private final a.C0056a<D> f3703c;

        C0057b(androidx.loader.b.c<D> cVar, a.C0056a<D> aVar) {
            this.f3702b = cVar;
            this.f3703c = aVar;
        }

        public final void onChanged(D d2) {
            if (b.f3692a) {
                StringBuilder sb = new StringBuilder("  onLoadFinished in ");
                sb.append(this.f3702b);
                sb.append(": ");
                sb.append(this.f3702b.dataToString(d2));
            }
            this.f3703c.a(this.f3702b, d2);
            this.f3701a = true;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (this.f3701a) {
                if (b.f3692a) {
                    new StringBuilder("  Resetting: ").append(this.f3702b);
                }
                this.f3703c.a(this.f3702b);
            }
        }

        public final String toString() {
            return this.f3703c.toString();
        }
    }

    static class c extends ai {

        /* renamed from: c  reason: collision with root package name */
        private static final al.b f3704c = new al.b() {
            public final <T extends ai> T create(Class<T> cls) {
                return new c();
            }
        };

        /* renamed from: a  reason: collision with root package name */
        h<a> f3705a = new h<>();

        /* renamed from: b  reason: collision with root package name */
        boolean f3706b = false;

        c() {
        }

        static c a(an anVar) {
            return (c) new al(anVar, f3704c).a(c.class);
        }

        /* access modifiers changed from: package-private */
        public final <D> a<D> a(int i2) {
            return this.f3705a.a(i2, null);
        }

        public void onCleared() {
            super.onCleared();
            int b2 = this.f3705a.b();
            for (int i2 = 0; i2 < b2; i2++) {
                this.f3705a.c(i2).a(true);
            }
            h<a> hVar = this.f3705a;
            int i3 = hVar.f964d;
            Object[] objArr = hVar.f963c;
            for (int i4 = 0; i4 < i3; i4++) {
                objArr[i4] = null;
            }
            hVar.f964d = 0;
            hVar.f962b = false;
        }
    }

    b(q qVar, an anVar) {
        this.f3693b = qVar;
        this.f3694c = c.a(anVar);
    }

    /* JADX INFO: finally extract failed */
    private <D> androidx.loader.b.c<D> a(int i2, Bundle bundle, a.C0056a<D> aVar, androidx.loader.b.c<D> cVar) {
        try {
            this.f3694c.f3706b = true;
            androidx.loader.b.c<D> a2 = aVar.a(bundle);
            if (a2 != null) {
                if (a2.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(a2.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: ".concat(String.valueOf(a2)));
                    }
                }
                a aVar2 = new a(i2, bundle, a2, cVar);
                if (f3692a) {
                    new StringBuilder("  Created new loader ").append(aVar2);
                }
                this.f3694c.f3705a.b(i2, aVar2);
                this.f3694c.f3706b = false;
                return aVar2.a(this.f3693b, aVar);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f3694c.f3706b = false;
            throw th;
        }
    }

    public final <D> androidx.loader.b.c<D> a(int i2, Bundle bundle, a.C0056a<D> aVar) {
        if (this.f3694c.f3706b) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            a a2 = this.f3694c.a(i2);
            if (f3692a) {
                StringBuilder sb = new StringBuilder("initLoader in ");
                sb.append(this);
                sb.append(": args=");
                sb.append(bundle);
            }
            if (a2 == null) {
                return a(i2, bundle, aVar, (androidx.loader.b.c) null);
            }
            if (f3692a) {
                new StringBuilder("  Re-using existing loader ").append(a2);
            }
            return a2.a(this.f3693b, aVar);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    public final <D> androidx.loader.b.c<D> a(int i2, a.C0056a<D> aVar) {
        if (this.f3694c.f3706b) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f3692a) {
                StringBuilder sb = new StringBuilder("restartLoader in ");
                sb.append(this);
                sb.append(": args=");
                sb.append((Object) null);
            }
            a a2 = this.f3694c.a(i2);
            return a(i2, (Bundle) null, aVar, a2 != null ? a2.a(false) : null);
        } else {
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
    }

    public final void a(int i2) {
        if (this.f3694c.f3706b) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f3692a) {
                StringBuilder sb = new StringBuilder("destroyLoader in ");
                sb.append(this);
                sb.append(" of ");
                sb.append(i2);
            }
            a a2 = this.f3694c.a(i2);
            if (a2 != null) {
                a2.a(true);
                this.f3694c.f3705a.a(i2);
            }
        } else {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
    }

    public final <D> androidx.loader.b.c<D> b(int i2) {
        if (!this.f3694c.f3706b) {
            a a2 = this.f3694c.a(i2);
            if (a2 != null) {
                return a2.f3697c;
            }
            return null;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public final void a() {
        c cVar = this.f3694c;
        int b2 = cVar.f3705a.b();
        for (int i2 = 0; i2 < b2; i2++) {
            cVar.f3705a.c(i2).a();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.g.a.a(this.f3693b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Deprecated
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        c cVar = this.f3694c;
        if (cVar.f3705a.b() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < cVar.f3705a.b(); i2++) {
                a c2 = cVar.f3705a.c(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(cVar.f3705a.b(i2));
                printWriter.print(": ");
                printWriter.println(c2.toString());
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(c2.f3695a);
                printWriter.print(" mArgs=");
                printWriter.println(c2.f3696b);
                printWriter.print(str2);
                printWriter.print("mLoader=");
                printWriter.println(c2.f3697c);
                c2.f3697c.dump(str2 + "  ", fileDescriptor, printWriter, strArr);
                if (c2.f3698d != null) {
                    printWriter.print(str2);
                    printWriter.print("mCallbacks=");
                    printWriter.println(c2.f3698d);
                    C0057b<D> bVar = c2.f3698d;
                    printWriter.print(str2 + "  ");
                    printWriter.print("mDeliveredData=");
                    printWriter.println(bVar.f3701a);
                }
                printWriter.print(str2);
                printWriter.print("mData=");
                printWriter.println(c2.f3697c.dataToString(c2.getValue()));
                printWriter.print(str2);
                printWriter.print("mStarted=");
                printWriter.println(c2.hasActiveObservers());
            }
        }
    }
}
