package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class av<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzlp = new Object[0];

    av() {
    }

    public abstract boolean contains(@NullableDecl Object obj);

    /* renamed from: zzby */
    public abstract bk<E> iterator();

    /* access modifiers changed from: package-private */
    @NullableDecl
    public Object[] zzbz() {
        return null;
    }

    public final Object[] toArray() {
        return toArray(zzlp);
    }

    public final <T> T[] toArray(T[] tArr) {
        al.a(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzbz = zzbz();
            if (zzbz != null) {
                return Arrays.copyOfRange(zzbz, zzca(), zzcb(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int zzca() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzcb() {
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

    public ay<E> zzcc() {
        return isEmpty() ? ay.zzcd() : ay.zza(toArray());
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i2) {
        bk bkVar = (bk) iterator();
        while (bkVar.hasNext()) {
            objArr[i2] = bkVar.next();
            i2++;
        }
        return i2;
    }
}
