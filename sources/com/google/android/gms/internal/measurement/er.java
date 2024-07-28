package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

final class er extends eo {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f10627a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private er() {
        super((byte) 0);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> a(Object obj, long j) {
        return a(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    public final void b(Object obj, long j) {
        Object obj2;
        List list = (List) gt.f(obj, j);
        if (list instanceof em) {
            obj2 = ((em) list).c();
        } else if (!f10627a.isAssignableFrom(list.getClass())) {
            if (!(list instanceof fs) || !(list instanceof ed)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                ed edVar = (ed) list;
                if (edVar.a()) {
                    edVar.b();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        gt.a(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.measurement.en} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.measurement.en} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.measurement.en} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <L> java.util.List<L> a(java.lang.Object r3, long r4, int r6) {
        /*
            java.util.List r0 = c(r3, r4)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002d
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.em
            if (r1 == 0) goto L_0x0014
            com.google.android.gms.internal.measurement.en r0 = new com.google.android.gms.internal.measurement.en
            r0.<init>((int) r6)
            goto L_0x0029
        L_0x0014:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.fs
            if (r1 == 0) goto L_0x0024
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.ed
            if (r1 == 0) goto L_0x0024
            com.google.android.gms.internal.measurement.ed r0 = (com.google.android.gms.internal.measurement.ed) r0
            com.google.android.gms.internal.measurement.ed r6 = r0.a(r6)
            r0 = r6
            goto L_0x0029
        L_0x0024:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x0029:
            com.google.android.gms.internal.measurement.gt.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
            goto L_0x007f
        L_0x002d:
            java.lang.Class<?> r1 = f10627a
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004b
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
            com.google.android.gms.internal.measurement.gt.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
        L_0x0049:
            r0 = r1
            goto L_0x007f
        L_0x004b:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.gs
            if (r1 == 0) goto L_0x0062
            com.google.android.gms.internal.measurement.en r1 = new com.google.android.gms.internal.measurement.en
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.android.gms.internal.measurement.gs r0 = (com.google.android.gms.internal.measurement.gs) r0
            r1.addAll(r0)
            com.google.android.gms.internal.measurement.gt.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
            goto L_0x0049
        L_0x0062:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.fs
            if (r1 == 0) goto L_0x007f
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.ed
            if (r1 == 0) goto L_0x007f
            r1 = r0
            com.google.android.gms.internal.measurement.ed r1 = (com.google.android.gms.internal.measurement.ed) r1
            boolean r2 = r1.a()
            if (r2 != 0) goto L_0x007f
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.gms.internal.measurement.ed r0 = r1.a(r0)
            com.google.android.gms.internal.measurement.gt.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.er.a(java.lang.Object, long, int):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final <E> void a(Object obj, Object obj2, long j) {
        List c2 = c(obj2, j);
        List a2 = a(obj, j, c2.size());
        int size = a2.size();
        int size2 = c2.size();
        if (size > 0 && size2 > 0) {
            a2.addAll(c2);
        }
        if (size > 0) {
            c2 = a2;
        }
        gt.a(obj, j, (Object) c2);
    }

    private static <E> List<E> c(Object obj, long j) {
        return (List) gt.f(obj, j);
    }

    /* synthetic */ er(byte b2) {
        this();
    }
}
