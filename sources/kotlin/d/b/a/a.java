package kotlin.d.b.a;

import java.io.Serializable;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.x;

public abstract class a implements Serializable, e, d<Object> {
    private final d<Object> completion;

    /* access modifiers changed from: protected */
    public abstract Object invokeSuspend(Object obj);

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
    }

    public a(d<Object> dVar) {
        this.completion = dVar;
    }

    public final d<Object> getCompletion() {
        return this.completion;
    }

    public final void resumeWith(Object obj) {
        d dVar = this;
        while (true) {
            a aVar = (a) dVar;
            k.d(aVar, "frame");
            d dVar2 = aVar.completion;
            k.a((Object) dVar2);
            try {
                Object invokeSuspend = aVar.invokeSuspend(obj);
                if (invokeSuspend != kotlin.d.a.a.COROUTINE_SUSPENDED) {
                    obj = p.m530constructorimpl(invokeSuspend);
                    aVar.releaseIntercepted();
                    if (dVar2 instanceof a) {
                        dVar = dVar2;
                    } else {
                        dVar2.resumeWith(obj);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                obj = p.m530constructorimpl(ResultKt.a(th));
            }
        }
    }

    public d<x> create(d<?> dVar) {
        k.d(dVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public d<x> create(Object obj, d<?> dVar) {
        k.d(dVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Serializable stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public e getCallerFrame() {
        d<Object> dVar = this.completion;
        if (!(dVar instanceof e)) {
            dVar = null;
        }
        return (e) dVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.StackTraceElement getStackTraceElement() {
        /*
            r8 = this;
            java.lang.String r0 = "$this$getStackTraceElementImpl"
            kotlin.g.b.k.d(r8, r0)
            java.lang.Class r0 = r8.getClass()
            java.lang.Class<kotlin.d.b.a.f> r1 = kotlin.d.b.a.f.class
            java.lang.annotation.Annotation r0 = r0.getAnnotation(r1)
            kotlin.d.b.a.f r0 = (kotlin.d.b.a.f) r0
            r1 = 0
            if (r0 != 0) goto L_0x0015
            return r1
        L_0x0015:
            int r2 = r0.a()
            r3 = 1
            if (r2 > r3) goto L_0x009e
            int r2 = kotlin.d.b.a.g.a(r8)
            if (r2 >= 0) goto L_0x0024
            r2 = -1
            goto L_0x002a
        L_0x0024:
            int[] r3 = r0.c()
            r2 = r3[r2]
        L_0x002a:
            kotlin.d.b.a.h r3 = kotlin.d.b.a.h.f47900c
            java.lang.String r3 = "continuation"
            kotlin.g.b.k.d(r8, r3)
            kotlin.d.b.a.h$a r3 = kotlin.d.b.a.h.f47899b
            if (r3 != 0) goto L_0x0039
            kotlin.d.b.a.h$a r3 = kotlin.d.b.a.h.a(r8)
        L_0x0039:
            kotlin.d.b.a.h$a r4 = kotlin.d.b.a.h.f47898a
            if (r3 != r4) goto L_0x003e
            goto L_0x0071
        L_0x003e:
            java.lang.reflect.Method r4 = r3.f47901a
            if (r4 == 0) goto L_0x0071
            java.lang.Class r5 = r8.getClass()
            r6 = 0
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.Object r4 = r4.invoke(r5, r7)
            if (r4 != 0) goto L_0x0050
            goto L_0x0071
        L_0x0050:
            java.lang.reflect.Method r5 = r3.f47902b
            if (r5 == 0) goto L_0x0071
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.Object r4 = r5.invoke(r4, r7)
            if (r4 != 0) goto L_0x005d
            goto L_0x0071
        L_0x005d:
            java.lang.reflect.Method r3 = r3.f47903c
            if (r3 == 0) goto L_0x0068
            java.lang.Object[] r5 = new java.lang.Object[r6]
            java.lang.Object r3 = r3.invoke(r4, r5)
            goto L_0x0069
        L_0x0068:
            r3 = r1
        L_0x0069:
            boolean r4 = r3 instanceof java.lang.String
            if (r4 != 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r1 = r3
        L_0x006f:
            java.lang.String r1 = (java.lang.String) r1
        L_0x0071:
            if (r1 != 0) goto L_0x0078
            java.lang.String r1 = r0.e()
            goto L_0x0090
        L_0x0078:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r1 = 47
            r3.append(r1)
            java.lang.String r1 = r0.e()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
        L_0x0090:
            java.lang.StackTraceElement r3 = new java.lang.StackTraceElement
            java.lang.String r4 = r0.d()
            java.lang.String r0 = r0.b()
            r3.<init>(r1, r4, r0, r2)
            return r3
        L_0x009e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Debug metadata version mismatch. Expected: 1, got "
            r0.<init>(r1)
            r0.append(r2)
            java.lang.String r1 = ". Please update the Kotlin standard library."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.d.b.a.a.getStackTraceElement():java.lang.StackTraceElement");
    }
}
