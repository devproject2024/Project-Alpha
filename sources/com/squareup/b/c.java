package com.squareup.b;

import com.squareup.b.c;
import java.util.Arrays;

public abstract class c<T extends c<?>> extends g {

    /* renamed from: a  reason: collision with root package name */
    transient e<T> f16045a;

    protected c() {
    }

    public final <E> T a(d<T, E> dVar, E e2) {
        e<T> eVar = this.f16045a;
        if (eVar == null) {
            this.f16045a = new e<>(dVar, e2);
        } else {
            int binarySearch = Arrays.binarySearch(eVar.f16053a, 0, eVar.f16054b, dVar);
            if (binarySearch >= 0) {
                eVar.f16053a[eVar.f16054b + binarySearch] = e2;
            } else {
                int i2 = -(binarySearch + 1);
                Object[] objArr = eVar.f16053a;
                if (eVar.f16053a.length < (eVar.f16054b + 1) * 2) {
                    objArr = new Object[(eVar.f16053a.length * 2)];
                    System.arraycopy(eVar.f16053a, 0, objArr, 0, i2);
                }
                if (i2 < eVar.f16054b) {
                    System.arraycopy(eVar.f16053a, eVar.f16054b + i2, objArr, eVar.f16054b + i2 + 2, eVar.f16054b - i2);
                    System.arraycopy(eVar.f16053a, i2, objArr, i2 + 1, eVar.f16054b);
                } else {
                    System.arraycopy(eVar.f16053a, eVar.f16054b, objArr, eVar.f16054b + 1, eVar.f16054b);
                }
                eVar.f16054b++;
                eVar.f16053a = objArr;
                eVar.f16053a[i2] = dVar;
                eVar.f16053a[eVar.f16054b + i2] = e2;
            }
        }
        return this;
    }
}
