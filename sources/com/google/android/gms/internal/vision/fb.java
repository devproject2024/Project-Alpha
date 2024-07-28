package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class fb extends cp<String> implements fa, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final fb f11126b;

    /* renamed from: c  reason: collision with root package name */
    private static final fa f11127c = f11126b;

    /* renamed from: d  reason: collision with root package name */
    private final List<Object> f11128d;

    public fb() {
        this(10);
    }

    public fb(int i2) {
        this((ArrayList<Object>) new ArrayList(i2));
    }

    private fb(ArrayList<Object> arrayList) {
        this.f11128d = arrayList;
    }

    public final int size() {
        return this.f11128d.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i2, Collection<? extends String> collection) {
        c();
        if (collection instanceof fa) {
            collection = ((fa) collection).u_();
        }
        boolean addAll = this.f11128d.addAll(i2, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        c();
        this.f11128d.clear();
        this.modCount++;
    }

    public final void a(cz czVar) {
        c();
        this.f11128d.add(czVar);
        this.modCount++;
    }

    public final Object b(int i2) {
        return this.f11128d.get(i2);
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof cz) {
            return ((cz) obj).zzer();
        }
        return ek.b((byte[]) obj);
    }

    public final List<?> u_() {
        return Collections.unmodifiableList(this.f11128d);
    }

    public final fa v_() {
        return a() ? new hf(this) : this;
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        c();
        return a(this.f11128d.set(i2, (String) obj));
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
        Object remove = this.f11128d.remove(i2);
        this.modCount++;
        return a(remove);
    }

    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        c();
        this.f11128d.add(i2, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ eq a(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f11128d);
            return new fb((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        Object obj = this.f11128d.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof cz) {
            cz czVar = (cz) obj;
            String zzer = czVar.zzer();
            if (czVar.zzes()) {
                this.f11128d.set(i2, zzer);
            }
            return zzer;
        }
        byte[] bArr = (byte[]) obj;
        String b2 = ek.b(bArr);
        if (ek.a(bArr)) {
            this.f11128d.set(i2, b2);
        }
        return b2;
    }

    static {
        fb fbVar = new fb();
        f11126b = fbVar;
        fbVar.f11013a = false;
    }
}
