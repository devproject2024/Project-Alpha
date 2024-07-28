package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.ResultKt;
import kotlin.g.a;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.p;

public final class ExceptionsConstuctorKt {
    private static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private static final WeakHashMap<Class<? extends Throwable>, b<Throwable, Throwable>> exceptionCtors = new WeakHashMap<>();
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static final <E extends java.lang.Throwable> E tryCopyException(E r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.CopyableThrowable
            r1 = 0
            if (r0 == 0) goto L_0x0027
            kotlin.p$a r0 = kotlin.p.Companion     // Catch:{ all -> 0x0012 }
            kotlinx.coroutines.CopyableThrowable r9 = (kotlinx.coroutines.CopyableThrowable) r9     // Catch:{ all -> 0x0012 }
            java.lang.Throwable r9 = r9.createCopy()     // Catch:{ all -> 0x0012 }
            java.lang.Object r9 = kotlin.p.m530constructorimpl(r9)     // Catch:{ all -> 0x0012 }
            goto L_0x001d
        L_0x0012:
            r9 = move-exception
            kotlin.p$a r0 = kotlin.p.Companion
            java.lang.Object r9 = kotlin.ResultKt.a((java.lang.Throwable) r9)
            java.lang.Object r9 = kotlin.p.m530constructorimpl(r9)
        L_0x001d:
            boolean r0 = kotlin.p.m536isFailureimpl(r9)
            if (r0 == 0) goto L_0x0024
            r9 = r1
        L_0x0024:
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            return r9
        L_0x0027:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = cacheLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.g.a.b<java.lang.Throwable, java.lang.Throwable>> r2 = exceptionCtors     // Catch:{ all -> 0x014a }
            java.lang.Class r3 = r9.getClass()     // Catch:{ all -> 0x014a }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x014a }
            kotlin.g.a.b r2 = (kotlin.g.a.b) r2     // Catch:{ all -> 0x014a }
            r0.unlock()
            if (r2 == 0) goto L_0x0048
            java.lang.Object r9 = r2.invoke(r9)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            return r9
        L_0x0048:
            int r0 = throwableFields
            java.lang.Class r2 = r9.getClass()
            r3 = 0
            int r2 = fieldsCountOrDefault(r2, r3)
            if (r0 == r2) goto L_0x009f
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = cacheLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r0.readLock()
            int r4 = r0.getWriteHoldCount()
            if (r4 != 0) goto L_0x0066
            int r4 = r0.getReadHoldCount()
            goto L_0x0067
        L_0x0066:
            r4 = 0
        L_0x0067:
            r5 = 0
        L_0x0068:
            if (r5 >= r4) goto L_0x0070
            r2.unlock()
            int r5 = r5 + 1
            goto L_0x0068
        L_0x0070:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.g.a.b<java.lang.Throwable, java.lang.Throwable>> r5 = exceptionCtors     // Catch:{ all -> 0x0092 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ all -> 0x0092 }
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0092 }
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1 r6 = kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1.INSTANCE     // Catch:{ all -> 0x0092 }
            r5.put(r9, r6)     // Catch:{ all -> 0x0092 }
            kotlin.x r9 = kotlin.x.f47997a     // Catch:{ all -> 0x0092 }
        L_0x0086:
            if (r3 >= r4) goto L_0x008e
            r2.lock()
            int r3 = r3 + 1
            goto L_0x0086
        L_0x008e:
            r0.unlock()
            return r1
        L_0x0092:
            r9 = move-exception
        L_0x0093:
            if (r3 >= r4) goto L_0x009b
            r2.lock()
            int r3 = r3 + 1
            goto L_0x0093
        L_0x009b:
            r0.unlock()
            throw r9
        L_0x009f:
            java.lang.Class r0 = r9.getClass()
            java.lang.reflect.Constructor[] r0 = r0.getConstructors()
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1 r2 = new kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1
            r2.<init>()
            java.util.Comparator r2 = (java.util.Comparator) r2
            java.lang.String r4 = "$this$sortedWith"
            kotlin.g.b.k.d(r0, r4)
            java.lang.String r4 = "comparator"
            kotlin.g.b.k.d(r2, r4)
            java.lang.String r5 = "$this$sortedArrayWith"
            kotlin.g.b.k.d(r0, r5)
            kotlin.g.b.k.d(r2, r4)
            int r4 = r0.length
            if (r4 != 0) goto L_0x00c5
            r4 = 1
            goto L_0x00c6
        L_0x00c5:
            r4 = 0
        L_0x00c6:
            if (r4 == 0) goto L_0x00c9
            goto L_0x00d6
        L_0x00c9:
            int r4 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r4)
            java.lang.String r4 = "java.util.Arrays.copyOf(this, size)"
            kotlin.g.b.k.b(r0, r4)
            kotlin.a.f.a(r0, r2)
        L_0x00d6:
            java.util.List r0 = kotlin.a.f.a(r0)
            java.util.Iterator r0 = r0.iterator()
            r2 = r1
        L_0x00df:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x00f1
            java.lang.Object r2 = r0.next()
            java.lang.reflect.Constructor r2 = (java.lang.reflect.Constructor) r2
            kotlin.g.a.b r2 = createConstructor(r2)
            if (r2 == 0) goto L_0x00df
        L_0x00f1:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = cacheLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = r0.readLock()
            int r5 = r0.getWriteHoldCount()
            if (r5 != 0) goto L_0x0102
            int r5 = r0.getReadHoldCount()
            goto L_0x0103
        L_0x0102:
            r5 = 0
        L_0x0103:
            r6 = 0
        L_0x0104:
            if (r6 >= r5) goto L_0x010c
            r4.unlock()
            int r6 = r6 + 1
            goto L_0x0104
        L_0x010c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.g.a.b<java.lang.Throwable, java.lang.Throwable>> r6 = exceptionCtors     // Catch:{ all -> 0x013d }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ all -> 0x013d }
            java.lang.Class r7 = r9.getClass()     // Catch:{ all -> 0x013d }
            if (r2 != 0) goto L_0x0122
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1 r8 = kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1.INSTANCE     // Catch:{ all -> 0x013d }
            kotlin.g.a.b r8 = (kotlin.g.a.b) r8     // Catch:{ all -> 0x013d }
            goto L_0x0123
        L_0x0122:
            r8 = r2
        L_0x0123:
            r6.put(r7, r8)     // Catch:{ all -> 0x013d }
            kotlin.x r6 = kotlin.x.f47997a     // Catch:{ all -> 0x013d }
        L_0x0128:
            if (r3 >= r5) goto L_0x0130
            r4.lock()
            int r3 = r3 + 1
            goto L_0x0128
        L_0x0130:
            r0.unlock()
            if (r2 == 0) goto L_0x013c
            java.lang.Object r9 = r2.invoke(r9)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            return r9
        L_0x013c:
            return r1
        L_0x013d:
            r9 = move-exception
        L_0x013e:
            if (r3 >= r5) goto L_0x0146
            r4.lock()
            int r3 = r3 + 1
            goto L_0x013e
        L_0x0146:
            r0.unlock()
            throw r9
        L_0x014a:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ExceptionsConstuctorKt.tryCopyException(java.lang.Throwable):java.lang.Throwable");
    }

    private static final b<Throwable, Throwable> createConstructor(Constructor<?> constructor) {
        Class[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(constructor);
        }
        if (length == 1) {
            Class cls = parameterTypes[0];
            if (k.a((Object) cls, (Object) Throwable.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(constructor);
            }
            if (k.a((Object) cls, (Object) String.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3(constructor);
            }
            return null;
        } else if (length == 2 && k.a((Object) parameterTypes[0], (Object) String.class) && k.a((Object) parameterTypes[1], (Object) Throwable.class)) {
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(constructor);
        } else {
            return null;
        }
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int i2) {
        Integer num;
        a.a(cls);
        try {
            p.a aVar = p.Companion;
            num = p.m530constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, (Object) null)));
        } catch (Throwable th) {
            p.a aVar2 = p.Companion;
            num = p.m530constructorimpl(ResultKt.a(th));
        }
        Integer valueOf = Integer.valueOf(i2);
        if (p.m536isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    static /* synthetic */ int fieldsCount$default(Class cls, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return fieldsCount(cls, i2);
    }

    private static final int fieldsCount(Class<?> cls, int i2) {
        Class<? super Object> superclass;
        do {
            Field[] declaredFields = r5.getDeclaredFields();
            int length = declaredFields.length;
            int i3 = 0;
            Class<? super Object> cls2 = cls;
            for (int i4 = 0; i4 < length; i4++) {
                if (!Modifier.isStatic(declaredFields[i4].getModifiers())) {
                    i3++;
                }
            }
            i2 += i3;
            superclass = cls2.getSuperclass();
            cls2 = superclass;
        } while (superclass != null);
        return i2;
    }
}
