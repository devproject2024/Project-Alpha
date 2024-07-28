package com.google.android.gms.internal.firebase_ml;

import java.util.Collections;
import java.util.List;

final class ha extends gy {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f9951a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private ha() {
        super((byte) 0);
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj, long j) {
        Object obj2;
        List list = (List) d.f(obj, j);
        if (list instanceof gz) {
            obj2 = ((gz) list).b();
        } else if (!f9951a.isAssignableFrom(list.getClass())) {
            if (!(list instanceof hy) || !(list instanceof gq)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                gq gqVar = (gq) list;
                if (gqVar.c()) {
                    gqVar.d();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        d.a(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.android.gms.internal.firebase_ml.gw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: com.google.android.gms.internal.firebase_ml.gw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: com.google.android.gms.internal.firebase_ml.gw} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E> void a(java.lang.Object r5, java.lang.Object r6, long r7) {
        /*
            r4 = this;
            java.util.List r6 = b(r6, r7)
            int r0 = r6.size()
            java.util.List r1 = b(r5, r7)
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0034
            boolean r2 = r1 instanceof com.google.android.gms.internal.firebase_ml.gz
            if (r2 == 0) goto L_0x001c
            com.google.android.gms.internal.firebase_ml.gw r1 = new com.google.android.gms.internal.firebase_ml.gw
            r1.<init>((int) r0)
            goto L_0x0030
        L_0x001c:
            boolean r2 = r1 instanceof com.google.android.gms.internal.firebase_ml.hy
            if (r2 == 0) goto L_0x002b
            boolean r2 = r1 instanceof com.google.android.gms.internal.firebase_ml.gq
            if (r2 == 0) goto L_0x002b
            com.google.android.gms.internal.firebase_ml.gq r1 = (com.google.android.gms.internal.firebase_ml.gq) r1
            com.google.android.gms.internal.firebase_ml.gq r1 = r1.d(r0)
            goto L_0x0030
        L_0x002b:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
        L_0x0030:
            com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r5, (long) r7, (java.lang.Object) r1)
            goto L_0x0087
        L_0x0034:
            java.lang.Class<?> r2 = f9951a
            java.lang.Class r3 = r1.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L_0x0052
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            r2.addAll(r1)
            com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r5, (long) r7, (java.lang.Object) r2)
        L_0x0050:
            r1 = r2
            goto L_0x0087
        L_0x0052:
            boolean r2 = r1 instanceof com.google.android.gms.internal.firebase_ml.c
            if (r2 == 0) goto L_0x0069
            com.google.android.gms.internal.firebase_ml.gw r2 = new com.google.android.gms.internal.firebase_ml.gw
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>((int) r3)
            com.google.android.gms.internal.firebase_ml.c r1 = (com.google.android.gms.internal.firebase_ml.c) r1
            r2.addAll(r1)
            com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r5, (long) r7, (java.lang.Object) r2)
            goto L_0x0050
        L_0x0069:
            boolean r2 = r1 instanceof com.google.android.gms.internal.firebase_ml.hy
            if (r2 == 0) goto L_0x0087
            boolean r2 = r1 instanceof com.google.android.gms.internal.firebase_ml.gq
            if (r2 == 0) goto L_0x0087
            r2 = r1
            com.google.android.gms.internal.firebase_ml.gq r2 = (com.google.android.gms.internal.firebase_ml.gq) r2
            boolean r3 = r2.c()
            if (r3 != 0) goto L_0x0087
            int r1 = r1.size()
            int r1 = r1 + r0
            com.google.android.gms.internal.firebase_ml.gq r0 = r2.d(r1)
            com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r5, (long) r7, (java.lang.Object) r0)
            r1 = r0
        L_0x0087:
            int r0 = r1.size()
            int r2 = r6.size()
            if (r0 <= 0) goto L_0x0096
            if (r2 <= 0) goto L_0x0096
            r1.addAll(r6)
        L_0x0096:
            if (r0 <= 0) goto L_0x0099
            r6 = r1
        L_0x0099:
            com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r5, (long) r7, (java.lang.Object) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.ha.a(java.lang.Object, java.lang.Object, long):void");
    }

    private static <E> List<E> b(Object obj, long j) {
        return (List) d.f(obj, j);
    }

    /* synthetic */ ha(byte b2) {
        this();
    }
}
