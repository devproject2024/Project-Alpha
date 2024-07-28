package com.google.android.gms.internal.firebase_ml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class gw extends fe<String> implements gz, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final gw f9942b;

    /* renamed from: c  reason: collision with root package name */
    private static final gz f9943c = f9942b;

    /* renamed from: d  reason: collision with root package name */
    private final List<Object> f9944d;

    public gw() {
        this(10);
    }

    public gw(int i2) {
        this((ArrayList<Object>) new ArrayList(i2));
    }

    private gw(ArrayList<Object> arrayList) {
        this.f9944d = arrayList;
    }

    public final int size() {
        return this.f9944d.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i2, Collection<? extends String> collection) {
        e();
        if (collection instanceof gz) {
            collection = ((gz) collection).a();
        }
        boolean addAll = this.f9944d.addAll(i2, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        e();
        this.f9944d.clear();
        this.modCount++;
    }

    public final void a(fh fhVar) {
        e();
        this.f9944d.add(fhVar);
        this.modCount++;
    }

    public final Object a(int i2) {
        return this.f9944d.get(i2);
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof fh) {
            return ((fh) obj).zztp();
        }
        return gk.b((byte[]) obj);
    }

    public final List<?> a() {
        return Collections.unmodifiableList(this.f9944d);
    }

    public final gz b() {
        return c() ? new c(this) : this;
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        e();
        return a(this.f9944d.set(i2, (String) obj));
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
        e();
        Object remove = this.f9944d.remove(i2);
        this.modCount++;
        return a(remove);
    }

    public final /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        e();
        this.f9944d.add(i2, (String) obj);
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

    public final /* synthetic */ gq d(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f9944d);
            return new gw((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        Object obj = this.f9944d.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof fh) {
            fh fhVar = (fh) obj;
            String zztp = fhVar.zztp();
            if (fhVar.zztq()) {
                this.f9944d.set(i2, zztp);
            }
            return zztp;
        }
        byte[] bArr = (byte[]) obj;
        String b2 = gk.b(bArr);
        if (gk.a(bArr)) {
            this.f9944d.set(i2, b2);
        }
        return b2;
    }

    static {
        gw gwVar = new gw();
        f9942b = gwVar;
        gwVar.f9878a = false;
    }
}
