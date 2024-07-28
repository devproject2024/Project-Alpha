package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import kotlin.d.b.a.e;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.t;
import kotlin.u;

public final class StackTraceRecoveryKt {
    private static final String baseContinuationImplClassName;
    private static final String stackTraceRecoveryClassName;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.internal.StackTraceRecoveryKt"
            java.lang.String r1 = "kotlin.d.b.a.a"
            kotlin.p$a r2 = kotlin.p.Companion     // Catch:{ all -> 0x0013 }
            java.lang.Class r2 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0013 }
            java.lang.String r2 = r2.getCanonicalName()     // Catch:{ all -> 0x0013 }
            java.lang.Object r2 = kotlin.p.m530constructorimpl(r2)     // Catch:{ all -> 0x0013 }
            goto L_0x001e
        L_0x0013:
            r2 = move-exception
            kotlin.p$a r3 = kotlin.p.Companion
            java.lang.Object r2 = kotlin.ResultKt.a((java.lang.Throwable) r2)
            java.lang.Object r2 = kotlin.p.m530constructorimpl(r2)
        L_0x001e:
            java.lang.Throwable r3 = kotlin.p.m533exceptionOrNullimpl(r2)
            if (r3 != 0) goto L_0x0025
            r1 = r2
        L_0x0025:
            java.lang.String r1 = (java.lang.String) r1
            baseContinuationImplClassName = r1
            kotlin.p$a r1 = kotlin.p.Companion     // Catch:{ all -> 0x0038 }
            java.lang.Class r1 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x0038 }
            java.lang.String r1 = r1.getCanonicalName()     // Catch:{ all -> 0x0038 }
            java.lang.Object r1 = kotlin.p.m530constructorimpl(r1)     // Catch:{ all -> 0x0038 }
            goto L_0x0043
        L_0x0038:
            r1 = move-exception
            kotlin.p$a r2 = kotlin.p.Companion
            java.lang.Object r1 = kotlin.ResultKt.a((java.lang.Throwable) r1)
            java.lang.Object r1 = kotlin.p.m530constructorimpl(r1)
        L_0x0043:
            java.lang.Throwable r2 = kotlin.p.m533exceptionOrNullimpl(r1)
            if (r2 != 0) goto L_0x004a
            r0 = r1
        L_0x004a:
            java.lang.String r0 = (java.lang.String) r0
            stackTraceRecoveryClassName = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.StackTraceRecoveryKt.<clinit>():void");
    }

    /* access modifiers changed from: private */
    public static final <E extends Throwable> E recoverFromStackFrame(E e2, e eVar) {
        o causeAndStacktrace = causeAndStacktrace(e2);
        E e3 = (Throwable) causeAndStacktrace.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) causeAndStacktrace.component2();
        Throwable tryCopyException = ExceptionsConstuctorKt.tryCopyException(e3);
        if (tryCopyException == null || (!k.a((Object) tryCopyException.getMessage(), (Object) e3.getMessage()))) {
            return e2;
        }
        ArrayDeque createStackTrace = createStackTrace(eVar);
        if (createStackTrace.isEmpty()) {
            return e2;
        }
        if (e3 != e2) {
            mergeRecoveredTraces(stackTraceElementArr, createStackTrace);
        }
        return createFinalException(e3, tryCopyException, createStackTrace);
    }

    private static final <E extends Throwable> E createFinalException(E e2, E e3, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(artificialFrame("Coroutine boundary"));
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int frameIndex = frameIndex(stackTrace, baseContinuationImplClassName);
        int i2 = 0;
        if (frameIndex == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array != null) {
                e3.setStackTrace((StackTraceElement[]) array);
                return e3;
            }
            throw new u("null cannot be cast to non-null type kotlin.Array<T>");
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[(arrayDeque.size() + frameIndex)];
        for (int i3 = 0; i3 < frameIndex; i3++) {
            stackTraceElementArr[i3] = stackTrace[i3];
        }
        for (StackTraceElement stackTraceElement : arrayDeque) {
            stackTraceElementArr[frameIndex + i2] = stackTraceElement;
            i2++;
        }
        e3.setStackTrace(stackTraceElementArr);
        return e3;
    }

    private static final <E extends Throwable> o<E, StackTraceElement[]> causeAndStacktrace(E e2) {
        boolean z;
        Throwable cause = e2.getCause();
        if (cause == null || !k.a((Object) cause.getClass(), (Object) e2.getClass())) {
            return t.a(e2, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int length = stackTrace.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (isArtificial(stackTrace[i2])) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            return t.a(cause, stackTrace);
        }
        return t.a(e2, new StackTraceElement[0]);
    }

    public static final <E extends Throwable> E unwrapImpl(E e2) {
        E cause = e2.getCause();
        if (cause != null) {
            boolean z = true;
            if (!(!k.a((Object) cause.getClass(), (Object) e2.getClass()))) {
                StackTraceElement[] stackTrace = e2.getStackTrace();
                int length = stackTrace.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    } else if (isArtificial(stackTrace[i2])) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    return cause;
                }
            }
        }
        return e2;
    }

    private static final ArrayDeque<StackTraceElement> createStackTrace(e eVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = eVar.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            if (!(eVar instanceof e)) {
                eVar = null;
            }
            if (eVar == null || (eVar = eVar.getCallerFrame()) == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = eVar.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
        return arrayDeque;
    }

    public static final StackTraceElement artificialFrame(String str) {
        return new StackTraceElement("\b\b\b(".concat(String.valueOf(str)), "\b", "\b", -1);
    }

    public static final boolean isArtificial(StackTraceElement stackTraceElement) {
        return p.b(stackTraceElement.getClassName(), "\b\b\b", false);
    }

    private static final boolean elementWiseEquals(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && k.a((Object) stackTraceElement.getMethodName(), (Object) stackTraceElement2.getMethodName()) && k.a((Object) stackTraceElement.getFileName(), (Object) stackTraceElement2.getFileName()) && k.a((Object) stackTraceElement.getClassName(), (Object) stackTraceElement2.getClassName());
    }

    private static final void mergeRecoveredTraces(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (isArtificial(stackTraceElementArr[i2])) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = i2 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 >= i3) {
            while (true) {
                if (elementWiseEquals(stackTraceElementArr[length2], arrayDeque.getLast())) {
                    arrayDeque.removeLast();
                }
                arrayDeque.addFirst(stackTraceElementArr[length2]);
                if (length2 != i3) {
                    length2--;
                } else {
                    return;
                }
            }
        }
    }

    private static final int frameIndex(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (k.a((Object) str, (Object) stackTraceElementArr[i2].getClassName())) {
                return i2;
            }
        }
        return -1;
    }
}
