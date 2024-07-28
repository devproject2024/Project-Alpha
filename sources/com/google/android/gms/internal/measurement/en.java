package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class en extends cg<String> implements em, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final en f10622b;

    /* renamed from: c  reason: collision with root package name */
    private static final em f10623c = f10622b;

    /* renamed from: d  reason: collision with root package name */
    private final List<Object> f10624d;

    public en() {
        this(10);
    }

    public en(int i2) {
        this((ArrayList<Object>) new ArrayList(i2));
    }

    private en(ArrayList<Object> arrayList) {
        this.f10624d = arrayList;
    }

    public final int size() {
        return this.f10624d.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i2, Collection<? extends String> collection) {
        r_();
        if (collection instanceof em) {
            collection = ((em) collection).q_();
        }
        boolean addAll = this.f10624d.addAll(i2, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        r_();
        this.f10624d.clear();
        this.modCount++;
    }

    public final void a(cm cmVar) {
        r_();
        this.f10624d.add(cmVar);
        this.modCount++;
    }

    public final Object b(int i2) {
        return this.f10624d.get(i2);
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof cm) {
            return ((cm) obj).zzb();
        }
        return dx.b((byte[]) obj);
    }

    public final List<?> q_() {
        return Collections.unmodifiableList(this.f10624d);
    }

    public final em c() {
        return a() ? new gs(this) : this;
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        r_();
        return a(this.f10624d.set(i2, (String) obj));
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
        r_();
        Object remove = this.f10624d.remove(i2);
        this.modCount++;
        return a(remove);
    }

    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        r_();
        this.f10624d.add(i2, (String) obj);
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

    public final /* synthetic */ ed a(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f10624d);
            return new en((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        Object obj = this.f10624d.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof cm) {
            cm cmVar = (cm) obj;
            String zzb = cmVar.zzb();
            if (cmVar.zzc()) {
                this.f10624d.set(i2, zzb);
            }
            return zzb;
        }
        byte[] bArr = (byte[]) obj;
        String b2 = dx.b(bArr);
        if (dx.a(bArr)) {
            this.f10624d.set(i2, b2);
        }
        return b2;
    }

    static {
        en enVar = new en();
        f10622b = enVar;
        enVar.f10522a = false;
    }
}
