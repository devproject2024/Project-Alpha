package com.google.android.gms.internal.firebase_ml;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class at<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzalq = new Object[0];

    at() {
    }

    /* renamed from: zzjj */
    public abstract ay<E> iterator();

    /* access modifiers changed from: package-private */
    @NullableDecl
    public Object[] zzjl() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean zzjo();

    public final Object[] toArray() {
        return toArray(zzalq);
    }

    public final <T> T[] toArray(T[] tArr) {
        ap.a(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzjl = zzjl();
            if (zzjl != null) {
                return Arrays.copyOfRange(zzjl, zzjm(), zzjn(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int zzjm() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzjn() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public as<E> zzjk() {
        return isEmpty() ? as.zzji() : as.zza(toArray());
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i2) {
        ay ayVar = (ay) iterator();
        while (ayVar.hasNext()) {
            objArr[i2] = ayVar.next();
            i2++;
        }
        return i2;
    }
}
