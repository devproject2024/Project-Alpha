package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.a;
import java.util.HashSet;

public final class d<T> implements a.b<T> {

    /* renamed from: a  reason: collision with root package name */
    b<T> f12625a;

    /* renamed from: b  reason: collision with root package name */
    private SparseArray<c> f12626b;

    /* renamed from: c  reason: collision with root package name */
    private int f12627c;

    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public d<T> f12628a = new d<>((byte) 0);

        public a(b<T> bVar) {
            this.f12628a.f12625a = bVar;
        }
    }

    public interface b<T> {
        e<T> create(T t);
    }

    public final void a() {
        for (int i2 = 0; i2 < this.f12626b.size(); i2++) {
            this.f12626b.valueAt(i2).f12629a.onDone();
        }
        this.f12626b.clear();
    }

    class c {

        /* renamed from: a  reason: collision with root package name */
        e<T> f12629a;

        /* renamed from: b  reason: collision with root package name */
        int f12630b;

        private c() {
            this.f12630b = 0;
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    private d() {
        this.f12626b = new SparseArray<>();
        this.f12627c = 3;
    }

    /* synthetic */ d(byte b2) {
        this();
    }

    public final void a(a.C0163a<T> aVar) {
        SparseArray<T> sparseArray = aVar.f12531a;
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            int keyAt = sparseArray.keyAt(i2);
            T valueAt = sparseArray.valueAt(i2);
            if (this.f12626b.get(keyAt) == null) {
                c cVar = new c((byte) 0);
                cVar.f12629a = this.f12625a.create(valueAt);
                cVar.f12629a.onNewItem(keyAt, valueAt);
                this.f12626b.append(keyAt, cVar);
            }
        }
        SparseArray<T> sparseArray2 = aVar.f12531a;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i3 = 0; i3 < this.f12626b.size(); i3++) {
            int keyAt2 = this.f12626b.keyAt(i3);
            if (sparseArray2.get(keyAt2) == null) {
                c valueAt2 = this.f12626b.valueAt(i3);
                valueAt2.f12630b++;
                if (valueAt2.f12630b >= this.f12627c) {
                    valueAt2.f12629a.onDone();
                    hashSet.add(Integer.valueOf(keyAt2));
                } else {
                    valueAt2.f12629a.onMissing(aVar);
                }
            }
        }
        for (Integer intValue : hashSet) {
            this.f12626b.delete(intValue.intValue());
        }
        SparseArray<T> sparseArray3 = aVar.f12531a;
        for (int i4 = 0; i4 < sparseArray3.size(); i4++) {
            int keyAt3 = sparseArray3.keyAt(i4);
            T valueAt3 = sparseArray3.valueAt(i4);
            c cVar2 = this.f12626b.get(keyAt3);
            cVar2.f12630b = 0;
            cVar2.f12629a.onUpdate(aVar, valueAt3);
        }
    }
}
