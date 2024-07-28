package com.google.android.gms.internal.clearcut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class bu extends u<String> implements bv, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final bu f9219b;

    /* renamed from: c  reason: collision with root package name */
    private static final bv f9220c = f9219b;

    /* renamed from: d  reason: collision with root package name */
    private final List<Object> f9221d;

    public bu() {
        this(10);
    }

    public bu(int i2) {
        this((ArrayList<Object>) new ArrayList(i2));
    }

    private bu(ArrayList<Object> arrayList) {
        this.f9221d = arrayList;
    }

    private static String a(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof ab ? ((ab) obj).zzz() : bh.b((byte[]) obj);
    }

    public final /* synthetic */ bm a(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f9221d);
            return new bu((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        c();
        this.f9221d.add(i2, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i2, Collection<? extends String> collection) {
        c();
        if (collection instanceof bv) {
            collection = ((bv) collection).d();
        }
        boolean addAll = this.f9221d.addAll(i2, collection);
        this.modCount++;
        return addAll;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final Object b(int i2) {
        return this.f9221d.get(i2);
    }

    public final void clear() {
        c();
        this.f9221d.clear();
        this.modCount++;
    }

    public final List<?> d() {
        return Collections.unmodifiableList(this.f9221d);
    }

    public final bv e() {
        return a() ? new dy(this) : this;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i2) {
        Object obj = this.f9221d.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ab) {
            ab abVar = (ab) obj;
            String zzz = abVar.zzz();
            if (abVar.zzaa()) {
                this.f9221d.set(i2, zzz);
            }
            return zzz;
        }
        byte[] bArr = (byte[]) obj;
        String b2 = bh.b(bArr);
        if (bh.a(bArr)) {
            this.f9221d.set(i2, b2);
        }
        return b2;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        Object remove = this.f9221d.remove(i2);
        this.modCount++;
        return a(remove);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        c();
        return a(this.f9221d.set(i2, (String) obj));
    }

    public final int size() {
        return this.f9221d.size();
    }

    static {
        bu buVar = new bu();
        f9219b = buVar;
        buVar.f9429a = false;
    }
}
