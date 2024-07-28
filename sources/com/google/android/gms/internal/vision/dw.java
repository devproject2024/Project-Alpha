package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.eb;
import java.io.IOException;
import java.util.Map;

abstract class dw<T extends eb<T>> {
    dw() {
    }

    /* access modifiers changed from: package-private */
    public abstract int a(Map.Entry<?, ?> entry);

    /* access modifiers changed from: package-private */
    public abstract dz<T> a(Object obj);

    /* access modifiers changed from: package-private */
    public abstract Object a(du duVar, ft ftVar, int i2);

    /* access modifiers changed from: package-private */
    public abstract <UT, UB> UB a(gj gjVar, Object obj, du duVar, dz<T> dzVar, UB ub, ha<UT, UB> haVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(cz czVar, Object obj, du duVar, dz<T> dzVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(gj gjVar, Object obj, du duVar, dz<T> dzVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(hx hxVar, Map.Entry<?, ?> entry) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract boolean a(ft ftVar);

    /* access modifiers changed from: package-private */
    public abstract dz<T> b(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void c(Object obj);
}
