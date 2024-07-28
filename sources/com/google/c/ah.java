package com.google.c;

import com.google.c.ac;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class ah extends c<String> implements ai, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    public static final ai f37710b = f37711c;

    /* renamed from: c  reason: collision with root package name */
    private static final ah f37711c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Object> f37712d;

    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        c();
        this.f37712d.add(i2, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
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
        return a(this.f37712d.set(i2, (String) obj));
    }

    static {
        ah ahVar = new ah();
        f37711c = ahVar;
        ahVar.f37832a = false;
    }

    public ah() {
        this(10);
    }

    public ah(int i2) {
        this((ArrayList<Object>) new ArrayList(i2));
    }

    private ah(ArrayList<Object> arrayList) {
        this.f37712d = arrayList;
    }

    public final int size() {
        return this.f37712d.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i2, Collection<? extends String> collection) {
        c();
        if (collection instanceof ai) {
            collection = ((ai) collection).d();
        }
        boolean addAll = this.f37712d.addAll(i2, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        c();
        this.f37712d.clear();
        this.modCount++;
    }

    public final void a(j jVar) {
        c();
        this.f37712d.add(jVar);
        this.modCount++;
    }

    public final Object b(int i2) {
        return this.f37712d.get(i2);
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof j) {
            return ((j) obj).toStringUtf8();
        }
        return ac.b((byte[]) obj);
    }

    public final List<?> d() {
        return Collections.unmodifiableList(this.f37712d);
    }

    public final ai e() {
        return super.a() ? new bw(this) : this;
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        Object remove = this.f37712d.remove(i2);
        this.modCount++;
        return a(remove);
    }

    public final /* synthetic */ ac.i a(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f37712d);
            return new ah((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        Object obj = this.f37712d.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            String stringUtf8 = jVar.toStringUtf8();
            if (jVar.isValidUtf8()) {
                this.f37712d.set(i2, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String b2 = ac.b(bArr);
        if (ac.a(bArr)) {
            this.f37712d.set(i2, b2);
        }
        return b2;
    }
}
