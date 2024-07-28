package kotlinx.coroutines.internal;

import kotlin.a.f;
import kotlin.u;

public class ArrayQueue<T> {
    private Object[] elements = new Object[16];
    private int head;
    private int tail;

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final void addLast(T t) {
        Object[] objArr = this.elements;
        int i2 = this.tail;
        objArr[i2] = t;
        this.tail = (objArr.length - 1) & (i2 + 1);
        if (this.tail == this.head) {
            ensureCapacity();
        }
    }

    public final T removeFirstOrNull() {
        int i2 = this.head;
        if (i2 == this.tail) {
            return null;
        }
        T[] tArr = this.elements;
        T t = tArr[i2];
        tArr[i2] = null;
        this.head = (i2 + 1) & (tArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new u("null cannot be cast to non-null type T");
    }

    private final void ensureCapacity() {
        Object[] objArr = this.elements;
        int length = objArr.length;
        Object[] objArr2 = new Object[(length << 1)];
        f.a(objArr, objArr2, 0, this.head, 0, 10);
        Object[] objArr3 = this.elements;
        int length2 = objArr3.length;
        int i2 = this.head;
        f.a(objArr3, objArr2, length2 - i2, 0, i2, 4);
        this.elements = objArr2;
        this.head = 0;
        this.tail = length;
    }
}
