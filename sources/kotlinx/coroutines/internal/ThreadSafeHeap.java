package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.g.b.k;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private volatile int _size = 0;

    /* renamed from: a  reason: collision with root package name */
    private T[] f47999a;

    public final int getSize() {
        return this._size;
    }

    private final void setSize(int i2) {
        this._size = i2;
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final T firstImpl() {
        T[] tArr = this.f47999a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final T removeAtImpl(int i2) {
        boolean z = false;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getSize() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.f47999a;
        if (tArr == null) {
            k.a();
        }
        setSize(getSize() - 1);
        if (i2 < getSize()) {
            swap(i2, getSize());
            int i3 = (i2 - 1) / 2;
            if (i2 > 0) {
                T t = tArr[i2];
                if (t == null) {
                    k.a();
                }
                Comparable comparable = (Comparable) t;
                T t2 = tArr[i3];
                if (t2 == null) {
                    k.a();
                }
                if (comparable.compareTo(t2) < 0) {
                    swap(i2, i3);
                    siftUpFrom(i3);
                }
            }
            siftDownFrom(i2);
        }
        T t3 = tArr[getSize()];
        if (t3 == null) {
            k.a();
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (t3.getHeap() == this) {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        t3.setHeap((ThreadSafeHeap<?>) null);
        t3.setIndex(-1);
        tArr[getSize()] = null;
        return t3;
    }

    public final void addImpl(T t) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(t.getHeap() == null)) {
                throw new AssertionError();
            }
        }
        t.setHeap(this);
        ThreadSafeHeapNode[] realloc = realloc();
        int size = getSize();
        setSize(size + 1);
        realloc[size] = t;
        t.setIndex(size);
        siftUpFrom(size);
    }

    private final void siftUpFrom(int i2) {
        while (i2 > 0) {
            T[] tArr = this.f47999a;
            if (tArr == null) {
                k.a();
            }
            int i3 = (i2 - 1) / 2;
            T t = tArr[i3];
            if (t == null) {
                k.a();
            }
            Comparable comparable = (Comparable) t;
            T t2 = tArr[i2];
            if (t2 == null) {
                k.a();
            }
            if (comparable.compareTo(t2) > 0) {
                swap(i2, i3);
                i2 = i3;
            } else {
                return;
            }
        }
    }

    private final void siftDownFrom(int i2) {
        while (true) {
            int i3 = (i2 * 2) + 1;
            if (i3 < getSize()) {
                T[] tArr = this.f47999a;
                if (tArr == null) {
                    k.a();
                }
                int i4 = i3 + 1;
                if (i4 < getSize()) {
                    T t = tArr[i4];
                    if (t == null) {
                        k.a();
                    }
                    Comparable comparable = (Comparable) t;
                    T t2 = tArr[i3];
                    if (t2 == null) {
                        k.a();
                    }
                    if (comparable.compareTo(t2) < 0) {
                        i3 = i4;
                    }
                }
                T t3 = tArr[i2];
                if (t3 == null) {
                    k.a();
                }
                Comparable comparable2 = (Comparable) t3;
                T t4 = tArr[i3];
                if (t4 == null) {
                    k.a();
                }
                if (comparable2.compareTo(t4) > 0) {
                    swap(i2, i3);
                    i2 = i3;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final T[] realloc() {
        T[] tArr = this.f47999a;
        if (tArr == null) {
            T[] tArr2 = new ThreadSafeHeapNode[4];
            this.f47999a = tArr2;
            return tArr2;
        } else if (getSize() < tArr.length) {
            return tArr;
        } else {
            T[] copyOf = Arrays.copyOf(tArr, getSize() * 2);
            k.a((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
            T[] tArr3 = (ThreadSafeHeapNode[]) copyOf;
            this.f47999a = tArr3;
            return tArr3;
        }
    }

    private final void swap(int i2, int i3) {
        T[] tArr = this.f47999a;
        if (tArr == null) {
            k.a();
        }
        T t = tArr[i3];
        if (t == null) {
            k.a();
        }
        T t2 = tArr[i2];
        if (t2 == null) {
            k.a();
        }
        tArr[i2] = t;
        tArr[i3] = t2;
        t.setIndex(i2);
        t2.setIndex(i3);
    }

    public final T peek() {
        T firstImpl;
        synchronized (this) {
            firstImpl = firstImpl();
        }
        return firstImpl;
    }

    public final T removeFirstOrNull() {
        T removeAtImpl;
        synchronized (this) {
            removeAtImpl = getSize() > 0 ? removeAtImpl(0) : null;
        }
        return removeAtImpl;
    }

    public final boolean remove(T t) {
        boolean z;
        synchronized (this) {
            z = true;
            boolean z2 = false;
            if (t.getHeap() == null) {
                z = false;
            } else {
                int index = t.getIndex();
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (index >= 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
                removeAtImpl(index);
            }
        }
        return z;
    }
}
