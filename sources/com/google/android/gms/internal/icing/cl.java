package com.google.android.gms.internal.icing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class cl extends ap<String> implements co, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final cl f10129b;

    /* renamed from: c  reason: collision with root package name */
    private static final co f10130c = f10129b;

    /* renamed from: d  reason: collision with root package name */
    private final List<Object> f10131d;

    public cl() {
        this(10);
    }

    public cl(int i2) {
        this((ArrayList<Object>) new ArrayList(i2));
    }

    private cl(ArrayList<Object> arrayList) {
        this.f10131d = arrayList;
    }

    public final int size() {
        return this.f10131d.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i2, Collection<? extends String> collection) {
        c();
        if (collection instanceof co) {
            collection = ((co) collection).d();
        }
        boolean addAll = this.f10131d.addAll(i2, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        c();
        this.f10131d.clear();
        this.modCount++;
    }

    public final Object b(int i2) {
        return this.f10131d.get(i2);
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof at) {
            return ((at) obj).zzak();
        }
        return bx.b((byte[]) obj);
    }

    public final List<?> d() {
        return Collections.unmodifiableList(this.f10131d);
    }

    public final co e() {
        return a() ? new en(this) : this;
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        c();
        return a(this.f10131d.set(i2, (String) obj));
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
        Object remove = this.f10131d.remove(i2);
        this.modCount++;
        return a(remove);
    }

    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        c();
        this.f10131d.add(i2, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ ce a(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f10131d);
            return new cl((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        Object obj = this.f10131d.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof at) {
            at atVar = (at) obj;
            String zzak = atVar.zzak();
            if (atVar.zzal()) {
                this.f10131d.set(i2, zzak);
            }
            return zzak;
        }
        byte[] bArr = (byte[]) obj;
        String b2 = bx.b(bArr);
        if (bx.a(bArr)) {
            this.f10131d.set(i2, b2);
        }
        return b2;
    }

    static {
        cl clVar = new cl();
        f10129b = clVar;
        clVar.f10058a = false;
    }
}
