package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.w;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final w f45341a;

    /* renamed from: b  reason: collision with root package name */
    final z f45342b;

    /* renamed from: c  reason: collision with root package name */
    final WeakReference<T> f45343c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f45344d;

    /* renamed from: e  reason: collision with root package name */
    final int f45345e;

    /* renamed from: f  reason: collision with root package name */
    final int f45346f;

    /* renamed from: g  reason: collision with root package name */
    final int f45347g;

    /* renamed from: h  reason: collision with root package name */
    final Drawable f45348h;

    /* renamed from: i  reason: collision with root package name */
    final String f45349i;
    final Object j;
    boolean k;
    boolean l;

    /* access modifiers changed from: package-private */
    public abstract void a(Bitmap bitmap, w.d dVar);

    /* access modifiers changed from: package-private */
    public abstract void a(Exception exc);

    /* renamed from: com.squareup.picasso.a$a  reason: collision with other inner class name */
    static class C0762a<M> extends WeakReference<M> {

        /* renamed from: a  reason: collision with root package name */
        final a f45350a;

        C0762a(a aVar, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f45350a = aVar;
        }
    }

    a(w wVar, T t, z zVar, int i2, int i3, int i4, Drawable drawable, String str, Object obj, boolean z) {
        C0762a aVar;
        this.f45341a = wVar;
        this.f45342b = zVar;
        if (t == null) {
            aVar = null;
        } else {
            aVar = new C0762a(this, t, wVar.k);
        }
        this.f45343c = aVar;
        this.f45345e = i2;
        this.f45346f = i3;
        this.f45344d = z;
        this.f45347g = i4;
        this.f45348h = drawable;
        this.f45349i = str;
        this.j = obj == null ? this : obj;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.l = true;
    }

    /* access modifiers changed from: package-private */
    public T b() {
        WeakReference<T> weakReference = this.f45343c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
