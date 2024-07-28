package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.b;

public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f12529a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private b<T> f12530b;

    /* renamed from: com.google.android.gms.vision.a$a  reason: collision with other inner class name */
    public static class C0163a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final SparseArray<T> f12531a;

        /* renamed from: b  reason: collision with root package name */
        private final b.C0164b f12532b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f12533c;

        public C0163a(SparseArray<T> sparseArray, b.C0164b bVar, boolean z) {
            this.f12531a = sparseArray;
            this.f12532b = bVar;
            this.f12533c = z;
        }
    }

    public interface b<T> {
        void a();

        void a(C0163a<T> aVar);
    }

    public abstract SparseArray<T> a(b bVar);

    public boolean b() {
        return true;
    }

    public void a() {
        synchronized (this.f12529a) {
            if (this.f12530b != null) {
                this.f12530b.a();
                this.f12530b = null;
            }
        }
    }

    public final void b(b bVar) {
        b.C0164b bVar2 = new b.C0164b(bVar.f12542a);
        if (bVar2.f12550e % 2 != 0) {
            int i2 = bVar2.f12546a;
            bVar2.f12546a = bVar2.f12547b;
            bVar2.f12547b = i2;
        }
        bVar2.f12550e = 0;
        C0163a aVar = new C0163a(a(bVar), bVar2, b());
        synchronized (this.f12529a) {
            if (this.f12530b != null) {
                this.f12530b.a(aVar);
            } else {
                throw new IllegalStateException("Detector processor must first be set with setProcessor in order to receive detection results.");
            }
        }
    }

    public final void a(b<T> bVar) {
        synchronized (this.f12529a) {
            if (this.f12530b != null) {
                this.f12530b.a();
            }
            this.f12530b = bVar;
        }
    }
}
