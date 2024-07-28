package com.google.android.gms.internal.p001firebaseperf;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.hl  reason: invalid package */
public abstract class hl<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzp = new Object[0];

    hl() {
    }

    public abstract boolean contains(@NullableDecl Object obj);

    /* renamed from: zzb */
    public abstract e<E> iterator();

    /* access modifiers changed from: package-private */
    public Object[] zzc() {
        return null;
    }

    public final Object[] toArray() {
        return toArray(zzp);
    }

    public final <T> T[] toArray(T[] tArr) {
        cc.a(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzc = zzc();
            if (zzc != null) {
                return Arrays.copyOfRange(zzc, zzd(), zze(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int zzd() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zze() {
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

    public hm<E> zzf() {
        return isEmpty() ? hm.zzg() : hm.zza(toArray());
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i2) {
        e eVar = (e) iterator();
        while (eVar.hasNext()) {
            objArr[i2] = eVar.next();
            i2++;
        }
        return i2;
    }
}
