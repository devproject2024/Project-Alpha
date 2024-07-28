package kotlin.g.b;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Object[] f47929a = new Object[0];

    public static final Object[] a(Collection<?> collection) {
        k.d(collection, "collection");
        int size = collection.size();
        if (size == 0) {
            return f47929a;
        }
        Iterator<?> it2 = collection.iterator();
        if (!it2.hasNext()) {
            return f47929a;
        }
        Object[] objArr = new Object[size];
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            objArr[i2] = it2.next();
            if (i3 >= objArr.length) {
                if (!it2.hasNext()) {
                    return objArr;
                }
                int i4 = ((i3 * 3) + 1) >>> 1;
                if (i4 <= i3) {
                    if (i3 < 2147483645) {
                        i4 = 2147483645;
                    } else {
                        throw new OutOfMemoryError();
                    }
                }
                objArr = Arrays.copyOf(objArr, i4);
                k.b(objArr, "Arrays.copyOf(result, newSize)");
            } else if (!it2.hasNext()) {
                Object[] copyOf = Arrays.copyOf(objArr, i3);
                k.b(copyOf, "Arrays.copyOf(result, size)");
                return copyOf;
            }
            i2 = i3;
        }
    }

    public static final Object[] a(Collection<?> collection, Object[] objArr) {
        Object[] objArr2;
        k.d(collection, "collection");
        if (objArr != null) {
            int size = collection.size();
            int i2 = 0;
            if (size == 0) {
                if (objArr.length > 0) {
                    objArr[0] = null;
                }
                return objArr;
            }
            Iterator<?> it2 = collection.iterator();
            if (!it2.hasNext()) {
                if (objArr.length > 0) {
                    objArr[0] = null;
                }
                return objArr;
            }
            if (size <= objArr.length) {
                objArr2 = objArr;
            } else {
                Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                if (newInstance != null) {
                    objArr2 = (Object[]) newInstance;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                }
            }
            while (true) {
                int i3 = i2 + 1;
                objArr2[i2] = it2.next();
                if (i3 >= objArr2.length) {
                    if (!it2.hasNext()) {
                        return objArr2;
                    }
                    int i4 = ((i3 * 3) + 1) >>> 1;
                    if (i4 <= i3) {
                        if (i3 < 2147483645) {
                            i4 = 2147483645;
                        } else {
                            throw new OutOfMemoryError();
                        }
                    }
                    objArr2 = Arrays.copyOf(objArr2, i4);
                    k.b(objArr2, "Arrays.copyOf(result, newSize)");
                } else if (!it2.hasNext()) {
                    if (objArr2 == objArr) {
                        objArr[i3] = null;
                        return objArr;
                    }
                    Object[] copyOf = Arrays.copyOf(objArr2, i3);
                    k.b(copyOf, "Arrays.copyOf(result, size)");
                    return copyOf;
                }
                i2 = i3;
            }
        } else {
            throw new NullPointerException();
        }
    }
}
