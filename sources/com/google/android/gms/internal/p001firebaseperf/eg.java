package com.google.android.gms.internal.p001firebaseperf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-perf.eg  reason: invalid package */
public final class eg extends cj<String> implements ej, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final eg f9588b;

    /* renamed from: c  reason: collision with root package name */
    private static final ej f9589c = f9588b;

    /* renamed from: d  reason: collision with root package name */
    private final List<Object> f9590d;

    public eg() {
        this(10);
    }

    public eg(int i2) {
        this((ArrayList<Object>) new ArrayList(i2));
    }

    private eg(ArrayList<Object> arrayList) {
        this.f9590d = arrayList;
    }

    public final int size() {
        return this.f9590d.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i2, Collection<? extends String> collection) {
        c();
        if (collection instanceof ej) {
            collection = ((ej) collection).d();
        }
        boolean addAll = this.f9590d.addAll(i2, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        c();
        this.f9590d.clear();
        this.modCount++;
    }

    public final void a(co coVar) {
        c();
        this.f9590d.add(coVar);
        this.modCount++;
    }

    public final Object a(int i2) {
        return this.f9590d.get(i2);
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof co) {
            return ((co) obj).zzgm();
        }
        return dt.b((byte[]) obj);
    }

    public final List<?> d() {
        return Collections.unmodifiableList(this.f9590d);
    }

    public final ej e() {
        return a() ? new gh(this) : this;
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        c();
        return a(this.f9590d.set(i2, (String) obj));
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        Object remove = this.f9590d.remove(i2);
        this.modCount++;
        return a(remove);
    }

    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        c();
        this.f9590d.add(i2, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ dz d(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f9590d);
            return new eg((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        Object obj = this.f9590d.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof co) {
            co coVar = (co) obj;
            String zzgm = coVar.zzgm();
            if (coVar.zzgn()) {
                this.f9590d.set(i2, zzgm);
            }
            return zzgm;
        }
        byte[] bArr = (byte[]) obj;
        String b2 = dt.b(bArr);
        if (dt.a(bArr)) {
            this.f9590d.set(i2, b2);
        }
        return b2;
    }

    static {
        eg egVar = new eg();
        f9588b = egVar;
        egVar.f9521a = false;
    }
}
