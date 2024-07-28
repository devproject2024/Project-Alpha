package com.squareup.b;

import com.squareup.b.j;
import java.util.Arrays;
import java.util.Comparator;

final class b<E extends j> {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<j> f16040a = new Comparator<j>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((j) obj).a() - ((j) obj2).a();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final Class<E> f16041b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f16042c;

    /* renamed from: d  reason: collision with root package name */
    private final E[] f16043d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f16044e;

    b(Class<E> cls) {
        this.f16041b = cls;
        this.f16043d = (j[]) cls.getEnumConstants();
        Arrays.sort(this.f16043d, f16040a);
        E[] eArr = this.f16043d;
        int length = eArr.length;
        if (eArr[0].a() == 1 && this.f16043d[length - 1].a() == length) {
            this.f16044e = true;
            this.f16042c = null;
            return;
        }
        this.f16044e = false;
        this.f16042c = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            this.f16042c[i2] = this.f16043d[i2].a();
        }
    }

    public static int a(E e2) {
        return e2.a();
    }

    public final E a(int i2) {
        try {
            return this.f16043d[this.f16044e ? i2 - 1 : Arrays.binarySearch(this.f16042c, i2)];
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("Unknown enum tag " + i2 + " for " + this.f16041b.getCanonicalName());
        }
    }
}
