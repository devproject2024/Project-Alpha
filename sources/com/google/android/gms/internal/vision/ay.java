package com.google.android.gms.internal.vision;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ay<E> extends av<E> implements List<E>, RandomAccess {
    private static final bj<Object> zzlr = new ax(bb.zzlx, 0);

    public static <E> ay<E> zzcd() {
        return bb.zzlx;
    }

    public final ay<E> zzcc() {
        return this;
    }

    static <E> ay<E> zza(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return bb.zzlx;
        }
        return new bb(objArr, length);
    }

    ay() {
    }

    public final bk<E> zzby() {
        return (bj) listIterator();
    }

    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        int i2 = 0;
        if (obj == null) {
            while (i2 < size) {
                if (get(i2) == null) {
                    return i2;
                }
                i2++;
            }
        } else {
            while (i2 < size) {
                if (obj.equals(get(i2))) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj == null) {
            for (int size = size() - 1; size >= 0; size--) {
                if (get(size) == null) {
                    return size;
                }
            }
        } else {
            for (int size2 = size() - 1; size2 >= 0; size2--) {
                if (obj.equals(get(size2))) {
                    return size2;
                }
            }
        }
        return -1;
    }

    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    /* renamed from: zze */
    public ay<E> subList(int i2, int i3) {
        al.a(i2, i3, size());
        int i4 = i3 - i2;
        if (i4 == size()) {
            return this;
        }
        if (i4 == 0) {
            return bb.zzlx;
        }
        return new ba(this, i2, i4);
    }

    @Deprecated
    public final boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E remove(int i2) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i2 + i3] = get(i3);
        }
        return i2 + size;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == al.a(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i2 = 0;
                    while (i2 < size) {
                        if (aj.a(get(i2), list.get(i2))) {
                            i2++;
                        }
                    }
                    return true;
                }
                ay ayVar = this;
                int size2 = ayVar.size();
                Iterator it2 = list.iterator();
                int i3 = 0;
                while (true) {
                    if (i3 < size2) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object obj2 = ayVar.get(i3);
                        i3++;
                        if (!aj.a(obj2, it2.next())) {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = ~(~((i2 * 31) + get(i3).hashCode()));
        }
        return i2;
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public /* synthetic */ ListIterator listIterator(int i2) {
        al.b(i2, size());
        if (isEmpty()) {
            return zzlr;
        }
        return new ax(this, i2);
    }

    public /* synthetic */ ListIterator listIterator() {
        return (bj) listIterator(0);
    }
}
