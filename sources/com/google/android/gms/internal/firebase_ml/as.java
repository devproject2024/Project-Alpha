package com.google.android.gms.internal.firebase_ml;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class as<E> extends at<E> implements List<E>, RandomAccess {
    private static final ax<Object> zzalp = new av(aw.zzalt, 0);

    public static <E> as<E> zzji() {
        return aw.zzalt;
    }

    public final as<E> zzjk() {
        return this;
    }

    public static <E> as<E> zzl(E e2) {
        Object[] objArr = {e2};
        int i2 = 0;
        while (i2 <= 0) {
            if (objArr[0] != null) {
                i2++;
            } else {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index 0");
                throw new NullPointerException(sb.toString());
            }
        }
        return new aw(objArr, 1);
    }

    public static <E> as<E> zza(E e2, E e3, E e4) {
        int i2 = 0;
        Object[] objArr = {e2, e3, e4};
        while (i2 < 3) {
            if (objArr[i2] != null) {
                i2++;
            } else {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i2);
                throw new NullPointerException(sb.toString());
            }
        }
        return new aw(objArr, 3);
    }

    public static <E> as<E> zza(E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        int i2 = 0;
        Object[] objArr = {e2, e3, e4, e5, e6, e7, e8};
        while (i2 < 7) {
            if (objArr[i2] != null) {
                i2++;
            } else {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i2);
                throw new NullPointerException(sb.toString());
            }
        }
        return new aw(objArr, 7);
    }

    public static <E> as<E> zzb(Collection<? extends E> collection) {
        if (collection instanceof at) {
            as<E> zzjk = ((at) collection).zzjk();
            if (!zzjk.zzjo()) {
                return zzjk;
            }
            Object[] array = zzjk.toArray();
            int length = array.length;
            if (length == 0) {
                return aw.zzalt;
            }
            return new aw(array, length);
        }
        Object[] array2 = collection.toArray();
        int length2 = array2.length;
        int i2 = 0;
        while (i2 < length2) {
            if (array2[i2] != null) {
                i2++;
            } else {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i2);
                throw new NullPointerException(sb.toString());
            }
        }
        int length3 = array2.length;
        if (length3 == 0) {
            return aw.zzalt;
        }
        return new aw(array2, length3);
    }

    static <E> as<E> zza(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return aw.zzalt;
        }
        return new aw(objArr, length);
    }

    as() {
    }

    public final ay<E> zzjj() {
        return (ax) listIterator();
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

    /* renamed from: zzd */
    public as<E> subList(int i2, int i3) {
        ap.a(i2, i3, size());
        int i4 = i3 - i2;
        if (i4 == size()) {
            return this;
        }
        if (i4 == 0) {
            return aw.zzalt;
        }
        return new au(this, i2, i4);
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
            objArr[i3] = get(i3);
        }
        return size;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == ap.a(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i2 = 0;
                    while (i2 < size) {
                        if (an.a(get(i2), list.get(i2))) {
                            i2++;
                        }
                    }
                    return true;
                }
                as asVar = this;
                int size2 = asVar.size();
                Iterator it2 = list.iterator();
                int i3 = 0;
                while (true) {
                    if (i3 < size2) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object obj2 = asVar.get(i3);
                        i3++;
                        if (!an.a(obj2, it2.next())) {
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
        ap.b(i2, size());
        if (isEmpty()) {
            return zzalp;
        }
        return new av(this, i2);
    }

    public /* synthetic */ ListIterator listIterator() {
        return (ax) listIterator(0);
    }
}
