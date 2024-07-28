package com.google.a.a.c;

import com.google.a.a.b.a.a.a.a.c;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class v {
    private static ParameterizedType b(Type type, Class<?> cls) {
        Class<?> cls2;
        if (!(type instanceof Class) && !(type instanceof ParameterizedType)) {
            return null;
        }
        while (type != null && type != Object.class) {
            if (type instanceof Class) {
                cls2 = (Class) type;
            } else {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class<?> a2 = a(parameterizedType);
                if (a2 == cls) {
                    return parameterizedType;
                }
                if (cls.isInterface()) {
                    for (Type type2 : a2.getGenericInterfaces()) {
                        if (cls.isAssignableFrom(type2 instanceof Class ? (Class) type2 : a((ParameterizedType) type2))) {
                            type = type2;
                            break;
                        }
                    }
                }
                cls2 = a2;
            }
            type = cls2.getGenericSuperclass();
        }
        return null;
    }

    public static boolean a(Class<?> cls, Class<?> cls2) {
        return cls.isAssignableFrom(cls2) || cls2.isAssignableFrom(cls);
    }

    public static <T> T a(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e2) {
            throw a((Exception) e2, (Class<?>) cls);
        } catch (InstantiationException e3) {
            throw a((Exception) e3, (Class<?>) cls);
        }
    }

    private static IllegalArgumentException a(Exception exc, Class<?> cls) {
        StringBuilder sb = new StringBuilder("unable to create new instance of class ");
        sb.append(cls.getName());
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (cls.isArray()) {
            arrayList.add("because it is an array");
        } else if (cls.isPrimitive()) {
            arrayList.add("because it is primitive");
        } else if (cls == Void.class) {
            arrayList.add("because it is void");
        } else {
            if (Modifier.isInterface(cls.getModifiers())) {
                arrayList.add("because it is an interface");
            } else if (Modifier.isAbstract(cls.getModifiers())) {
                arrayList.add("because it is abstract");
            }
            if (cls.getEnclosingClass() != null && !Modifier.isStatic(cls.getModifiers())) {
                arrayList.add("because it is not static");
            }
            if (!Modifier.isPublic(cls.getModifiers())) {
                arrayList.add("possibly because it is not public");
            } else {
                try {
                    cls.getConstructor(new Class[0]);
                } catch (NoSuchMethodException unused) {
                    arrayList.add("because it has no accessible default constructor");
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (z) {
                sb.append(" and");
            } else {
                z = true;
            }
            sb.append(" ");
            sb.append(str);
        }
        return new IllegalArgumentException(sb.toString(), exc);
    }

    public static boolean a(Type type) {
        if (!(type instanceof GenericArrayType)) {
            return (type instanceof Class) && ((Class) type).isArray();
        }
        return true;
    }

    public static Type b(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    private static Class<?> a(ParameterizedType parameterizedType) {
        return (Class) parameterizedType.getRawType();
    }

    public static Type a(WildcardType wildcardType) {
        Type[] lowerBounds = wildcardType.getLowerBounds();
        if (lowerBounds.length != 0) {
            return lowerBounds[0];
        }
        return wildcardType.getUpperBounds()[0];
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.reflect.TypeVariable, java.lang.reflect.TypeVariable<?>, java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r5 = a(r5, (java.lang.reflect.TypeVariable<?>) (java.lang.reflect.TypeVariable) r6);
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type a(java.util.List<java.lang.reflect.Type> r5, java.lang.reflect.TypeVariable<?> r6) {
        /*
            java.lang.reflect.GenericDeclaration r0 = r6.getGenericDeclaration()
            boolean r1 = r0 instanceof java.lang.Class
            r2 = 0
            if (r1 == 0) goto L_0x004d
            r1 = r0
            java.lang.Class r1 = (java.lang.Class) r1
            int r3 = r5.size()
            r4 = r3
            r3 = r2
        L_0x0012:
            if (r3 != 0) goto L_0x0023
            int r4 = r4 + -1
            if (r4 < 0) goto L_0x0023
            java.lang.Object r3 = r5.get(r4)
            java.lang.reflect.Type r3 = (java.lang.reflect.Type) r3
            java.lang.reflect.ParameterizedType r3 = b(r3, r1)
            goto L_0x0012
        L_0x0023:
            if (r3 == 0) goto L_0x004d
            java.lang.reflect.TypeVariable[] r0 = r0.getTypeParameters()
            r1 = 0
        L_0x002a:
            int r2 = r0.length
            if (r1 >= r2) goto L_0x0038
            r2 = r0[r1]
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0038
            int r1 = r1 + 1
            goto L_0x002a
        L_0x0038:
            java.lang.reflect.Type[] r6 = r3.getActualTypeArguments()
            r6 = r6[r1]
            boolean r0 = r6 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto L_0x004c
            r0 = r6
            java.lang.reflect.TypeVariable r0 = (java.lang.reflect.TypeVariable) r0
            java.lang.reflect.Type r5 = a((java.util.List<java.lang.reflect.Type>) r5, (java.lang.reflect.TypeVariable<?>) r0)
            if (r5 == 0) goto L_0x004c
            return r5
        L_0x004c:
            return r6
        L_0x004d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.a.c.v.a(java.util.List, java.lang.reflect.TypeVariable):java.lang.reflect.Type");
    }

    public static Class<?> a(List<Type> list, Type type) {
        if (type instanceof TypeVariable) {
            type = a(list, (TypeVariable<?>) (TypeVariable) type);
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(a(list, b(type)), 0).getClass();
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return a((ParameterizedType) type);
        }
        c.a(type == null, "wildcard type is not supported: %s", type);
        return Object.class;
    }

    public static Type a(Type type, Class<?> cls) {
        Type type2 = b(type, cls).getActualTypeArguments()[0];
        if (type2 instanceof TypeVariable) {
            Type a2 = a((List<Type>) Arrays.asList(new Type[]{type}), (TypeVariable<?>) (TypeVariable) type2);
            if (a2 != null) {
                return a2;
            }
        }
        return type2;
    }

    public static <T> Iterable<T> a(final Object obj) {
        if (obj instanceof Iterable) {
            return (Iterable) obj;
        }
        Class<?> cls = obj.getClass();
        c.a(cls.isArray(), "not an array or Iterable: %s", cls);
        if (!cls.getComponentType().isPrimitive()) {
            return Arrays.asList((Object[]) obj);
        }
        return new Iterable<T>() {
            public final Iterator<T> iterator() {
                return new Iterator<T>() {

                    /* renamed from: a  reason: collision with root package name */
                    final int f7619a = Array.getLength(obj);

                    /* renamed from: b  reason: collision with root package name */
                    int f7620b = 0;

                    public final boolean hasNext() {
                        return this.f7620b < this.f7619a;
                    }

                    public final T next() {
                        if (hasNext()) {
                            Object obj = obj;
                            int i2 = this.f7620b;
                            this.f7620b = i2 + 1;
                            return Array.get(obj, i2);
                        }
                        throw new NoSuchElementException();
                    }

                    public final void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public static Object a(Collection<?> collection, Class<?> cls) {
        if (!cls.isPrimitive()) {
            return collection.toArray((Object[]) Array.newInstance(cls, collection.size()));
        }
        Object newInstance = Array.newInstance(cls, collection.size());
        int i2 = 0;
        for (Object obj : collection) {
            Array.set(newInstance, i2, obj);
            i2++;
        }
        return newInstance;
    }
}
