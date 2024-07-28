package com.alibaba.a.d;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class c implements Comparable<c> {

    /* renamed from: a  reason: collision with root package name */
    public final String f6351a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f6352b;

    /* renamed from: c  reason: collision with root package name */
    public final Field f6353c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<?> f6354d;

    /* renamed from: e  reason: collision with root package name */
    public final Type f6355e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6356f;

    /* renamed from: g  reason: collision with root package name */
    private int f6357g;

    /* renamed from: h  reason: collision with root package name */
    private final Class<?> f6358h;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        c cVar = (c) obj;
        int i2 = this.f6357g;
        int i3 = cVar.f6357g;
        if (i2 < i3) {
            return -1;
        }
        if (i2 > i3) {
            return 1;
        }
        return this.f6351a.compareTo(cVar.f6351a);
    }

    public c(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i2) {
        this.f6357g = 0;
        this.f6356f = false;
        this.f6351a = str;
        this.f6358h = cls;
        this.f6354d = cls2;
        this.f6355e = type;
        this.f6352b = null;
        this.f6353c = field;
        this.f6357g = i2;
        if (field != null) {
            g.a((AccessibleObject) field);
        }
    }

    public c(String str, Method method, Field field, int i2) {
        this(str, method, field, (Class<?>) null, (Type) null, i2);
    }

    public c(String str, Method method, Class<?> cls, Type type) {
        this(str, method, (Field) null, cls, type, 0);
    }

    public c(String str, Method method, Field field, Class<?> cls, Type type, int i2) {
        Type type2;
        Class<?> cls2;
        Type a2;
        Type type3;
        this.f6357g = 0;
        this.f6356f = false;
        this.f6351a = str;
        this.f6352b = method;
        this.f6353c = field;
        this.f6357g = i2;
        if (method != null) {
            g.a((AccessibleObject) method);
        }
        if (field != null) {
            g.a((AccessibleObject) field);
        }
        if (method != null) {
            if (method.getParameterTypes().length == 1) {
                cls2 = method.getParameterTypes()[0];
                type3 = method.getGenericParameterTypes()[0];
            } else {
                cls2 = method.getReturnType();
                Type genericReturnType = method.getGenericReturnType();
                this.f6356f = true;
                type3 = genericReturnType;
            }
            this.f6358h = method.getDeclaringClass();
            type2 = type3;
        } else {
            cls2 = field.getType();
            type2 = field.getGenericType();
            this.f6358h = field.getDeclaringClass();
        }
        if (cls == null || cls2 != Object.class || !(type2 instanceof TypeVariable) || (a2 = a(cls, (TypeVariable) type2)) == null) {
            Type a3 = a(cls, type, type2);
            if (a3 != type2) {
                if (a3 instanceof ParameterizedType) {
                    cls2 = g.d(a3);
                } else if (a3 instanceof Class) {
                    cls2 = g.d(a3);
                }
            }
            this.f6355e = a3;
            this.f6354d = cls2;
            return;
        }
        this.f6354d = g.d(a2);
        this.f6355e = a2;
    }

    private static Type a(Class<?> cls, Type type, Type type2) {
        if (!(cls == null || type == null)) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type a2 = a(cls, type, genericComponentType);
                return genericComponentType != a2 ? Array.newInstance(g.d(a2), 0).getClass() : type2;
            } else if (!g.a(type)) {
                return type2;
            } else {
                if (type2 instanceof TypeVariable) {
                    ParameterizedType parameterizedType = (ParameterizedType) g.b(type);
                    Class<?> d2 = g.d((Type) parameterizedType);
                    TypeVariable typeVariable = (TypeVariable) type2;
                    for (int i2 = 0; i2 < d2.getTypeParameters().length; i2++) {
                        if (d2.getTypeParameters()[i2].getName().equals(typeVariable.getName())) {
                            return parameterizedType.getActualTypeArguments()[i2];
                        }
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                    Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                    boolean z = false;
                    for (int i3 = 0; i3 < actualTypeArguments.length; i3++) {
                        Type type3 = actualTypeArguments[i3];
                        if (type3 instanceof TypeVariable) {
                            TypeVariable typeVariable2 = (TypeVariable) type3;
                            if (type instanceof ParameterizedType) {
                                ParameterizedType parameterizedType3 = (ParameterizedType) type;
                                boolean z2 = z;
                                for (int i4 = 0; i4 < cls.getTypeParameters().length; i4++) {
                                    if (cls.getTypeParameters()[i4].getName().equals(typeVariable2.getName())) {
                                        actualTypeArguments[i3] = parameterizedType3.getActualTypeArguments()[i4];
                                        z2 = true;
                                    }
                                }
                                z = z2;
                            }
                        }
                    }
                    if (z) {
                        return new f(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                    }
                }
            }
        }
        return type2;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.reflect.TypeVariable, java.lang.reflect.TypeVariable<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Type a(java.lang.Class<?> r4, java.lang.reflect.TypeVariable<?> r5) {
        /*
            java.lang.reflect.GenericDeclaration r0 = r5.getGenericDeclaration()
        L_0x0004:
            java.lang.reflect.Type r4 = r4.getGenericSuperclass()
            r1 = 0
            if (r4 != 0) goto L_0x000c
            return r1
        L_0x000c:
            boolean r2 = r4 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x0030
            r2 = r4
            java.lang.reflect.ParameterizedType r2 = (java.lang.reflect.ParameterizedType) r2
            java.lang.reflect.Type r3 = r2.getRawType()
            if (r3 != r0) goto L_0x0030
            java.lang.reflect.TypeVariable[] r4 = r0.getTypeParameters()
            java.lang.reflect.Type[] r0 = r2.getActualTypeArguments()
            r2 = 0
        L_0x0022:
            int r3 = r4.length
            if (r2 >= r3) goto L_0x002f
            r3 = r4[r2]
            if (r3 != r5) goto L_0x002c
            r4 = r0[r2]
            return r4
        L_0x002c:
            int r2 = r2 + 1
            goto L_0x0022
        L_0x002f:
            return r1
        L_0x0030:
            java.lang.Class r2 = com.alibaba.a.d.g.d((java.lang.reflect.Type) r4)
            if (r4 != 0) goto L_0x0037
            return r1
        L_0x0037:
            r4 = r2
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.d.c.a(java.lang.Class, java.lang.reflect.TypeVariable):java.lang.reflect.Type");
    }

    public final String toString() {
        return this.f6351a;
    }

    public final <T extends Annotation> T a(Class<T> cls) {
        Field field;
        Method method = this.f6352b;
        T annotation = method != null ? method.getAnnotation(cls) : null;
        return (annotation != null || (field = this.f6353c) == null) ? annotation : field.getAnnotation(cls);
    }

    public final Object a(Object obj) throws IllegalAccessException, InvocationTargetException {
        Method method = this.f6352b;
        if (method != null) {
            return method.invoke(obj, new Object[0]);
        }
        return this.f6353c.get(obj);
    }
}
