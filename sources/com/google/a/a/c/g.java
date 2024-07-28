package com.google.a.a.c;

import com.google.a.a.b.a.a.a.a.c;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Boolean f7573a = Boolean.TRUE;

    /* renamed from: b  reason: collision with root package name */
    public static final String f7574b = new String();

    /* renamed from: c  reason: collision with root package name */
    public static final Character f7575c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final Byte f7576d = (byte) 0;

    /* renamed from: e  reason: collision with root package name */
    public static final Short f7577e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final Integer f7578f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final Float f7579g = Float.valueOf(0.0f);

    /* renamed from: h  reason: collision with root package name */
    public static final Long f7580h = 0L;

    /* renamed from: i  reason: collision with root package name */
    public static final Double f7581i = Double.valueOf(0.0d);
    public static final BigInteger j = new BigInteger("0");
    public static final BigDecimal k = new BigDecimal("0");
    public static final i l = new i(0);
    private static final ConcurrentHashMap<Class<?>, Object> m;

    static {
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = new ConcurrentHashMap<>();
        m = concurrentHashMap;
        concurrentHashMap.put(Boolean.class, f7573a);
        m.put(String.class, f7574b);
        m.put(Character.class, f7575c);
        m.put(Byte.class, f7576d);
        m.put(Short.class, f7577e);
        m.put(Integer.class, f7578f);
        m.put(Float.class, f7579g);
        m.put(Long.class, f7580h);
        m.put(Double.class, f7581i);
        m.put(BigInteger.class, j);
        m.put(BigDecimal.class, k);
        m.put(i.class, l);
    }

    public static boolean a(Object obj) {
        return obj != null && obj == m.get(obj.getClass());
    }

    public static Map<String, Object> b(Object obj) {
        if (obj == null || a(obj)) {
            return Collections.emptyMap();
        }
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return new h(obj, false);
    }

    public static <T> T c(T t) {
        T t2;
        if (t == null || a((Type) t.getClass())) {
            return t;
        }
        if (t instanceof k) {
            return ((k) t).clone();
        }
        Class<?> cls = t.getClass();
        if (cls.isArray()) {
            t2 = Array.newInstance(cls.getComponentType(), Array.getLength(t));
        } else if (t instanceof a) {
            t2 = ((a) t).clone();
        } else {
            t2 = v.a(cls);
        }
        a((Object) t, (Object) t2);
        return t2;
    }

    public static void a(Object obj, Object obj2) {
        Object a2;
        Class<?> cls = obj.getClass();
        boolean z = true;
        int i2 = 0;
        c.a(cls == obj2.getClass());
        if (cls.isArray()) {
            if (Array.getLength(obj) != Array.getLength(obj2)) {
                z = false;
            }
            c.a(z);
            for (Object c2 : v.a(obj)) {
                Array.set(obj2, i2, c(c2));
                i2++;
            }
        } else if (Collection.class.isAssignableFrom(cls)) {
            Collection<Object> collection = (Collection) obj;
            if (ArrayList.class.isAssignableFrom(cls)) {
                ((ArrayList) obj2).ensureCapacity(collection.size());
            }
            Collection collection2 = (Collection) obj2;
            for (Object c3 : collection) {
                collection2.add(c(c3));
            }
        } else {
            boolean isAssignableFrom = k.class.isAssignableFrom(cls);
            if (isAssignableFrom || !Map.class.isAssignableFrom(cls)) {
                f a3 = isAssignableFrom ? ((k) obj).k : f.a(cls);
                for (String a4 : a3.f7570c) {
                    j a5 = a3.a(a4);
                    if (!a5.a() && ((!isAssignableFrom || !a5.f7596a) && (a2 = a5.a(obj)) != null)) {
                        a5.a(obj2, c(a2));
                    }
                }
            } else if (a.class.isAssignableFrom(cls)) {
                a aVar = (a) obj2;
                a aVar2 = (a) obj;
                int size = aVar2.size();
                while (i2 < size) {
                    aVar.a(i2, c(aVar2.a(i2)));
                    i2++;
                }
            } else {
                Map map = (Map) obj2;
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    map.put(entry.getKey(), c(entry.getValue()));
                }
            }
        }
    }

    public static boolean a(Type type) {
        if (!(type instanceof Class)) {
            return false;
        }
        Class<Boolean> cls = (Class) type;
        if (cls.isPrimitive() || cls == Character.class || cls == String.class || cls == Integer.class || cls == Long.class || cls == Short.class || cls == Byte.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == i.class || cls == Boolean.class) {
            return true;
        }
        return false;
    }

    public static Object a(Type type, String str) {
        Class<BigDecimal> cls = type instanceof Class ? (Class) type : null;
        if (type == null || cls != null) {
            if (cls == Void.class) {
                return null;
            }
            if (str == null || cls == null || cls.isAssignableFrom(String.class)) {
                return str;
            }
            if (cls == Character.class || cls == Character.TYPE) {
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                throw new IllegalArgumentException("expected type Character/char but got ".concat(String.valueOf(cls)));
            } else if (cls == Boolean.class || cls == Boolean.TYPE) {
                return Boolean.valueOf(str);
            } else {
                if (cls == Byte.class || cls == Byte.TYPE) {
                    return Byte.valueOf(str);
                }
                if (cls == Short.class || cls == Short.TYPE) {
                    return Short.valueOf(str);
                }
                if (cls == Integer.class || cls == Integer.TYPE) {
                    return Integer.valueOf(str);
                }
                if (cls == Long.class || cls == Long.TYPE) {
                    return Long.valueOf(str);
                }
                if (cls == Float.class || cls == Float.TYPE) {
                    return Float.valueOf(str);
                }
                if (cls == Double.class || cls == Double.TYPE) {
                    return Double.valueOf(str);
                }
                if (cls == i.class) {
                    return i.parseRfc3339(str);
                }
                if (cls == BigInteger.class) {
                    return new BigInteger(str);
                }
                if (cls == BigDecimal.class) {
                    return new BigDecimal(str);
                }
                if (cls.isEnum()) {
                    j a2 = f.a((Class<?>) cls).a(str);
                    return Enum.valueOf(a2.f7597b.getDeclaringClass(), a2.f7597b.getName());
                }
            }
        }
        throw new IllegalArgumentException("expected primitive class, but got: ".concat(String.valueOf(type)));
    }

    public static Collection<Object> b(Type type) {
        if (type instanceof WildcardType) {
            type = v.a((WildcardType) type);
        }
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        }
        Class cls = type instanceof Class ? (Class) type : null;
        if (type == null || (type instanceof GenericArrayType) || (cls != null && (cls.isArray() || cls.isAssignableFrom(ArrayList.class)))) {
            return new ArrayList();
        }
        if (cls == null) {
            throw new IllegalArgumentException("unable to create new instance of type: ".concat(String.valueOf(type)));
        } else if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        } else {
            if (cls.isAssignableFrom(TreeSet.class)) {
                return new TreeSet();
            }
            return (Collection) v.a(cls);
        }
    }

    public static Type a(List<Type> list, Type type) {
        if (type instanceof WildcardType) {
            type = v.a((WildcardType) type);
        }
        while (type instanceof TypeVariable) {
            Type a2 = v.a(list, (TypeVariable<?>) (TypeVariable) type);
            if (a2 != null) {
                type = a2;
            }
            if (type instanceof TypeVariable) {
                type = ((TypeVariable) type).getBounds()[0];
            }
        }
        return type;
    }
}
