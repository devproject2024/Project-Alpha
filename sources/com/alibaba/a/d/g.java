package com.alibaba.a.d;

import com.alibaba.a.a;
import com.alibaba.a.a.b;
import com.alibaba.a.a.c;
import com.alibaba.a.b.a.o;
import com.alibaba.a.b.f;
import com.alibaba.a.b.i;
import com.alibaba.a.c.bb;
import com.alibaba.a.d;
import com.alibaba.a.e;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6377a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f6378b = true;

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentMap<String, Class<?>> f6379c;

    public static final String a(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static final Byte b(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() != 0 && !"null".equals(str)) {
                return Byte.valueOf(Byte.parseByte(str));
            }
            return null;
        }
        throw new d("can not cast to byte, value : ".concat(String.valueOf(obj)));
    }

    public static final Character c(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new d("can not cast to byte, value : ".concat(String.valueOf(obj)));
        }
        throw new d("can not cast to byte, value : ".concat(String.valueOf(obj)));
    }

    public static final Short d(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() != 0 && !"null".equals(str)) {
                return Short.valueOf(Short.parseShort(str));
            }
            return null;
        }
        throw new d("can not cast to short, value : ".concat(String.valueOf(obj)));
    }

    public static final BigDecimal e(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0) {
            return null;
        }
        return new BigDecimal(obj2);
    }

    public static final BigInteger f(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0) {
            return null;
        }
        return new BigInteger(obj2);
    }

    public static final Float g(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() != 0 && !"null".equals(obj2)) {
                return Float.valueOf(Float.parseFloat(obj2));
            }
            return null;
        }
        throw new d("can not cast to float, value : ".concat(String.valueOf(obj)));
    }

    public static final Double h(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() != 0 && !"null".equals(obj2)) {
                return Double.valueOf(Double.parseDouble(obj2));
            }
            return null;
        }
        throw new d("can not cast to double, value : ".concat(String.valueOf(obj)));
    }

    public static final Date i(Object obj) {
        String str;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        long j = -1;
        if (obj instanceof Number) {
            j = ((Number) obj).longValue();
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.indexOf(45) != -1) {
                if (str2.length() == a.DEFFAULT_DATE_FORMAT.length()) {
                    str = a.DEFFAULT_DATE_FORMAT;
                } else if (str2.length() == 10) {
                    str = "yyyy-MM-dd";
                } else {
                    str = str2.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd HH:mm:ss.SSS";
                }
                try {
                    return new SimpleDateFormat(str).parse(str2);
                } catch (ParseException unused) {
                    throw new d("can not cast to Date, value : ".concat(String.valueOf(str2)));
                }
            } else if (str2.length() == 0) {
                return null;
            } else {
                j = Long.parseLong(str2);
            }
        }
        if (j >= 0) {
            return new Date(j);
        }
        throw new d("can not cast to Date, value : ".concat(String.valueOf(obj)));
    }

    public static final java.sql.Date j(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return new java.sql.Date(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof java.sql.Date) {
            return (java.sql.Date) obj;
        }
        if (obj instanceof Date) {
            return new java.sql.Date(((Date) obj).getTime());
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : 0;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            longValue = Long.parseLong(str);
        }
        if (longValue > 0) {
            return new java.sql.Date(longValue);
        }
        throw new d("can not cast to Date, value : ".concat(String.valueOf(obj)));
    }

    public static final Timestamp k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return new Timestamp(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof Timestamp) {
            return (Timestamp) obj;
        }
        if (obj instanceof Date) {
            return new Timestamp(((Date) obj).getTime());
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : 0;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            longValue = Long.parseLong(str);
        }
        if (longValue > 0) {
            return new Timestamp(longValue);
        }
        throw new d("can not cast to Date, value : ".concat(String.valueOf(obj)));
    }

    public static final Long l(Object obj) {
        Calendar calendar = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                f fVar = new f(str);
                if (fVar.b(false)) {
                    calendar = fVar.y();
                }
                fVar.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        throw new d("can not cast to long, value : ".concat(String.valueOf(obj)));
    }

    public static final Integer m(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() != 0 && !"null".equals(str)) {
                return Integer.valueOf(Integer.parseInt(str));
            }
            return null;
        }
        throw new d("can not cast to int, value : ".concat(String.valueOf(obj)));
    }

    public static final byte[] n(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return a.a((String) obj);
        }
        throw new d("can not cast to int, value : ".concat(String.valueOf(obj)));
    }

    public static final Boolean o(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            boolean z = true;
            if (((Number) obj).intValue() != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if ("true".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
            if ("1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("0".equals(str)) {
                return Boolean.FALSE;
            }
            if ("null".equals(str)) {
                return null;
            }
        }
        throw new d("can not cast to int, value : ".concat(String.valueOf(obj)));
    }

    public static final <T> T a(Object obj, Class<T> cls) {
        return a(obj, cls, i.a());
    }

    public static final <T> T a(Object obj, Class<T> cls, i iVar) {
        T t;
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        } else if (cls == obj.getClass()) {
            return obj;
        } else {
            if (!(obj instanceof Map)) {
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection<Object> collection = (Collection) obj;
                        int i2 = 0;
                        T newInstance = Array.newInstance(cls.getComponentType(), collection.size());
                        for (Object a2 : collection) {
                            Array.set(newInstance, i2, a(a2, cls.getComponentType(), iVar));
                            i2++;
                        }
                        return newInstance;
                    } else if (cls == byte[].class) {
                        return n(obj);
                    }
                }
                if (cls.isAssignableFrom(obj.getClass())) {
                    return obj;
                }
                if (cls == Boolean.TYPE || cls == Boolean.class) {
                    return o(obj);
                }
                if (cls == Byte.TYPE || cls == Byte.class) {
                    return b(obj);
                }
                if (cls == Short.TYPE || cls == Short.class) {
                    return d(obj);
                }
                if (cls == Integer.TYPE || cls == Integer.class) {
                    return m(obj);
                }
                if (cls == Long.TYPE || cls == Long.class) {
                    return l(obj);
                }
                if (cls == Float.TYPE || cls == Float.class) {
                    return g(obj);
                }
                if (cls == Double.TYPE || cls == Double.class) {
                    return h(obj);
                }
                if (cls == String.class) {
                    return a(obj);
                }
                if (cls == BigDecimal.class) {
                    return e(obj);
                }
                if (cls == BigInteger.class) {
                    return f(obj);
                }
                if (cls == Date.class) {
                    return i(obj);
                }
                if (cls == java.sql.Date.class) {
                    return j(obj);
                }
                if (cls == Timestamp.class) {
                    return k(obj);
                }
                if (cls.isEnum()) {
                    return b(obj, cls);
                }
                if (Calendar.class.isAssignableFrom(cls)) {
                    Date i3 = i(obj);
                    if (cls == Calendar.class) {
                        t = Calendar.getInstance();
                    } else {
                        try {
                            t = (Calendar) cls.newInstance();
                        } catch (Exception e2) {
                            throw new d("can not cast to : " + cls.getName(), e2);
                        }
                    }
                    t.setTime(i3);
                    return t;
                } else if ((obj instanceof String) && ((String) obj).length() == 0) {
                    return null;
                } else {
                    throw new d("can not cast to : " + cls.getName());
                }
            } else if (cls == Map.class) {
                return obj;
            } else {
                Map map = (Map) obj;
                if (cls != Object.class || map.containsKey(a.DEFAULT_TYPE_KEY)) {
                    return a((Map<String, Object>) map, cls, iVar);
                }
                return obj;
            }
        }
    }

    private static <T> T b(Object obj, Class<T> cls) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int intValue = ((Number) obj).intValue();
                for (T t : (Object[]) cls.getMethod("values", new Class[0]).invoke((Object) null, new Object[0])) {
                    T t2 = (Enum) t;
                    if (t2.ordinal() == intValue) {
                        return t2;
                    }
                }
            }
            throw new d("can not cast to : " + cls.getName());
        } catch (Exception e2) {
            throw new d("can not cast to : " + cls.getName(), e2);
        }
    }

    public static final <T> T a(Object obj, Type type, i iVar) {
        T t;
        while (obj != null) {
            if (type instanceof Class) {
                return a(obj, (Class) type, iVar);
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type rawType = parameterizedType.getRawType();
                if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
                    Type type2 = parameterizedType.getActualTypeArguments()[0];
                    if (obj instanceof Iterable) {
                        if (rawType == Set.class || rawType == HashSet.class) {
                            t = new HashSet();
                        } else if (rawType == TreeSet.class) {
                            t = new TreeSet();
                        } else {
                            t = new ArrayList();
                        }
                        for (Object a2 : (Iterable) obj) {
                            t.add(a(a2, type2, iVar));
                        }
                        return t;
                    }
                }
                if (rawType == Map.class || rawType == HashMap.class) {
                    Type type3 = parameterizedType.getActualTypeArguments()[0];
                    Type type4 = parameterizedType.getActualTypeArguments()[1];
                    if (obj instanceof Map) {
                        T hashMap = new HashMap();
                        for (Map.Entry entry : ((Map) obj).entrySet()) {
                            hashMap.put(a(entry.getKey(), type3, iVar), a(entry.getValue(), type4, iVar));
                        }
                        return hashMap;
                    }
                }
                if ((obj instanceof String) && ((String) obj).length() == 0) {
                    return null;
                }
                if (parameterizedType.getActualTypeArguments().length != 1 || !(parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
                    throw new d("can not cast to : ".concat(String.valueOf(parameterizedType)));
                }
                type = rawType;
            } else if ((obj instanceof String) && ((String) obj).length() == 0) {
                return null;
            } else {
                if (type instanceof TypeVariable) {
                    return obj;
                }
                throw new d("can not cast to : ".concat(String.valueOf(type)));
            }
        }
        return null;
    }

    private static <T> T a(Map<String, Object> map, Class<T> cls, i iVar) {
        e eVar;
        int i2 = 0;
        if (cls == StackTraceElement.class) {
            try {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    i2 = number.intValue();
                }
                return new StackTraceElement(str, str2, str3, i2);
            } catch (Exception e2) {
                throw new d(e2.getMessage(), e2);
            }
        } else {
            Object obj = map.get(a.DEFAULT_TYPE_KEY);
            if (obj instanceof String) {
                String str4 = (String) obj;
                Class<?> a2 = a(str4);
                if (a2 == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                } else if (!a2.equals(cls)) {
                    return a(map, a2, iVar);
                }
            }
            if (cls.isInterface()) {
                if (map instanceof e) {
                    eVar = (e) map;
                } else {
                    eVar = new e(map);
                }
                return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, eVar);
            }
            if (iVar == null) {
                iVar = i.a();
            }
            Map<String, o> a3 = iVar.a((Class<?>) cls);
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            T newInstance = declaredConstructor.newInstance(new Object[0]);
            for (Map.Entry next : a3.entrySet()) {
                String str5 = (String) next.getKey();
                o oVar = (o) next.getValue();
                if (map.containsKey(str5)) {
                    Object obj2 = map.get(str5);
                    Method a4 = oVar.a();
                    if (a4 != null) {
                        a4.invoke(newInstance, new Object[]{a(obj2, a4.getGenericParameterTypes()[0], iVar)});
                    } else {
                        Field b2 = oVar.b();
                        b2.set(newInstance, a(obj2, b2.getGenericType(), iVar));
                    }
                }
            }
            return newInstance;
        }
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f6379c = concurrentHashMap;
        concurrentHashMap.put("byte", Byte.TYPE);
        f6379c.put("short", Short.TYPE);
        f6379c.put("int", Integer.TYPE);
        f6379c.put("long", Long.TYPE);
        f6379c.put("float", Float.TYPE);
        f6379c.put("double", Double.TYPE);
        f6379c.put("boolean", Boolean.TYPE);
        f6379c.put("char", Character.TYPE);
        f6379c.put("[byte", byte[].class);
        f6379c.put("[short", short[].class);
        f6379c.put("[int", int[].class);
        f6379c.put("[long", long[].class);
        f6379c.put("[float", float[].class);
        f6379c.put("[double", double[].class);
        f6379c.put("[boolean", boolean[].class);
        f6379c.put("[char", char[].class);
        f6379c.put(HashMap.class.getName(), HashMap.class);
    }

    private static void a(String str, Class<?> cls) {
        if (str == null) {
            str = cls.getName();
        }
        f6379c.put(str, cls);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|16|(2:18|19)|20|21|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x005b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Class<?> a(java.lang.String r5) {
        /*
        L_0x0000:
            if (r5 == 0) goto L_0x0063
            int r0 = r5.length()
            if (r0 != 0) goto L_0x0009
            goto L_0x0063
        L_0x0009:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r0 = f6379c
            java.lang.Object r0 = r0.get(r5)
            java.lang.Class r0 = (java.lang.Class) r0
            if (r0 == 0) goto L_0x0014
            return r0
        L_0x0014:
            r1 = 0
            char r2 = r5.charAt(r1)
            r3 = 91
            r4 = 1
            if (r2 != r3) goto L_0x002f
            java.lang.String r5 = r5.substring(r4)
            java.lang.Class r5 = a((java.lang.String) r5)
            java.lang.Object r5 = java.lang.reflect.Array.newInstance(r5, r1)
            java.lang.Class r5 = r5.getClass()
            return r5
        L_0x002f:
            java.lang.String r1 = "L"
            boolean r1 = r5.startsWith(r1)
            if (r1 == 0) goto L_0x0049
            java.lang.String r1 = ";"
            boolean r1 = r5.endsWith(r1)
            if (r1 == 0) goto L_0x0049
            int r0 = r5.length()
            int r0 = r0 - r4
            java.lang.String r5 = r5.substring(r4, r0)
            goto L_0x0000
        L_0x0049:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x005b }
            java.lang.ClassLoader r1 = r1.getContextClassLoader()     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x005b
            java.lang.Class r0 = r1.loadClass(r5)     // Catch:{ all -> 0x005b }
            a((java.lang.String) r5, (java.lang.Class<?>) r0)     // Catch:{ all -> 0x005b }
            return r0
        L_0x005b:
            java.lang.Class r0 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0062 }
            a((java.lang.String) r5, (java.lang.Class<?>) r0)     // Catch:{ all -> 0x0062 }
        L_0x0062:
            return r0
        L_0x0063:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.d.g.a(java.lang.String):java.lang.Class");
    }

    public static List<c> a(Class<?> cls) {
        return a(cls, true);
    }

    public static List<c> a(Class<?> cls, boolean z) {
        String[] strArr;
        boolean z2;
        int i2;
        int i3;
        String str;
        b bVar;
        String str2;
        b bVar2;
        Class<?> cls2 = cls;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Method[] methods = cls.getMethods();
        int length = methods.length;
        int i4 = 0;
        while (true) {
            strArr = null;
            if (i4 >= length) {
                break;
            }
            Method method = methods[i4];
            String name = method.getName();
            if (!Modifier.isStatic(method.getModifiers()) && !method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 0 && method.getReturnType() != ClassLoader.class && (!method.getName().equals("getMetaClass") || !method.getReturnType().getName().equals("groovy.lang.MetaClass"))) {
                b bVar3 = (b) method.getAnnotation(b.class);
                if (bVar3 == null) {
                    bVar3 = a(cls2, method);
                }
                if (bVar3 == null) {
                    i3 = 0;
                } else if (bVar3.d()) {
                    i3 = bVar3.a();
                    bb.of(bVar3.f());
                    if (bVar3.b().length() != 0) {
                        String b2 = bVar3.b();
                        linkedHashMap.put(b2, new c(b2, method, (Field) null, i3));
                    }
                }
                if (name.startsWith("get")) {
                    if (name.length() >= 4 && !name.equals("getClass")) {
                        char charAt = name.charAt(3);
                        if (Character.isUpperCase(charAt)) {
                            if (f6377a) {
                                str2 = b(name.substring(3));
                            } else {
                                str2 = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                            }
                        } else if (charAt == '_') {
                            str2 = name.substring(4);
                        } else if (charAt == 'f') {
                            str2 = name.substring(3);
                        } else if (name.length() >= 5 && Character.isUpperCase(name.charAt(4))) {
                            str2 = b(name.substring(3));
                        }
                        if (!b(cls2, str2)) {
                            Field a2 = i.a(cls2, str2);
                            if (!(a2 == null || (bVar2 = (b) a2.getAnnotation(b.class)) == null)) {
                                if (bVar2.d()) {
                                    i3 = bVar2.a();
                                    bb.of(bVar2.f());
                                    if (bVar2.b().length() != 0) {
                                        str2 = bVar2.b();
                                    }
                                }
                            }
                            linkedHashMap.put(str2, new c(str2, method, a2, i3));
                        }
                    }
                }
                if (name.startsWith("is") && name.length() >= 3) {
                    char charAt2 = name.charAt(2);
                    if (Character.isUpperCase(charAt2)) {
                        if (f6377a) {
                            str = b(name.substring(2));
                        } else {
                            str = Character.toLowerCase(name.charAt(2)) + name.substring(3);
                        }
                    } else if (charAt2 == '_') {
                        str = name.substring(3);
                    } else if (charAt2 == 'f') {
                        str = name.substring(2);
                    }
                    Field a3 = i.a(cls2, str);
                    if (a3 == null) {
                        a3 = i.a(cls2, name);
                    }
                    if (!(a3 == null || (bVar = (b) a3.getAnnotation(b.class)) == null)) {
                        if (bVar.d()) {
                            i3 = bVar.a();
                            bb.of(bVar.f());
                            if (bVar.b().length() != 0) {
                                str = bVar.b();
                            }
                        }
                    }
                    linkedHashMap.put(str, new c(str, method, a3, i3));
                }
            }
            i4++;
        }
        for (Field field : cls.getFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                b bVar4 = (b) field.getAnnotation(b.class);
                String name2 = field.getName();
                if (bVar4 == null) {
                    i2 = 0;
                } else if (bVar4.d()) {
                    i2 = bVar4.a();
                    bb.of(bVar4.f());
                    if (bVar4.b().length() != 0) {
                        name2 = bVar4.b();
                    }
                }
                if (!linkedHashMap.containsKey(name2)) {
                    linkedHashMap.put(name2, new c(name2, (Method) null, field, i2));
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        c cVar = (c) cls2.getAnnotation(c.class);
        if (cVar != null && (strArr = cVar.a()) != null && strArr.length == linkedHashMap.size()) {
            int length2 = strArr.length;
            int i5 = 0;
            while (true) {
                if (i5 < length2) {
                    if (!linkedHashMap.containsKey(strArr[i5])) {
                        break;
                    }
                    i5++;
                } else {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            for (String str3 : strArr) {
                arrayList.add((c) linkedHashMap.get(str3));
            }
        } else {
            for (c add : linkedHashMap.values()) {
                arrayList.add(add);
            }
            if (z) {
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    public static b a(Class<?> cls, Method method) {
        boolean z;
        b bVar;
        for (Class methods : cls.getInterfaces()) {
            for (Method method2 : methods.getMethods()) {
                if (method2.getName().equals(method.getName()) && method2.getParameterTypes().length == method.getParameterTypes().length) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= method2.getParameterTypes().length) {
                            z = true;
                            break;
                        } else if (!method2.getParameterTypes()[i2].equals(method.getParameterTypes()[i2])) {
                            z = false;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (bVar = (b) method2.getAnnotation(b.class)) != null) {
                        return bVar;
                    }
                }
            }
        }
        return null;
    }

    private static boolean b(Class<?> cls, String str) {
        c cVar = (c) cls.getAnnotation(c.class);
        if (!(cVar == null || cVar.b() == null)) {
            for (String equalsIgnoreCase : cVar.b()) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return (cls.getSuperclass() == Object.class || cls.getSuperclass() == null || !b((Class<?>) cls.getSuperclass(), str)) ? false : true;
    }

    public static boolean a(Type type) {
        while (!(type instanceof ParameterizedType)) {
            if (!(type instanceof Class)) {
                return false;
            }
            type = ((Class) type).getGenericSuperclass();
        }
        return true;
    }

    public static Type b(Type type) {
        while (!(type instanceof ParameterizedType) && (type instanceof Class)) {
            type = ((Class) type).getGenericSuperclass();
        }
        return type;
    }

    public static Type c(Type type) {
        if (!(type instanceof GenericArrayType)) {
            return type;
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        if (genericComponentType == Byte.TYPE) {
            return byte[].class;
        }
        return genericComponentType == Character.TYPE ? char[].class : type;
    }

    public static Class<?> d(Type type) {
        while (type.getClass() != Class.class) {
            if (!(type instanceof ParameterizedType)) {
                return Object.class;
            }
            type = ((ParameterizedType) type).getRawType();
        }
        return (Class) type;
    }

    public static Field a(Class<?> cls, String str) {
        Class<? super Object> superclass;
        do {
            Class<? super Object> cls2 = cls;
            for (Field field : cls2.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            superclass = cls2.getSuperclass();
            if (superclass == null) {
                return null;
            }
            cls2 = superclass;
        } while (superclass != Object.class);
        return null;
    }

    public static int b(Class<?> cls) {
        c cVar = (c) cls.getAnnotation(c.class);
        if (cVar == null) {
            return 0;
        }
        return bb.of(cVar.c());
    }

    public static int c(Class<?> cls) {
        c cVar = (c) cls.getAnnotation(c.class);
        if (cVar == null) {
            return 0;
        }
        return com.alibaba.a.b.c.of(cVar.d());
    }

    public static String b(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static void a(AccessibleObject accessibleObject) {
        if (f6378b && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (AccessControlException unused) {
                f6378b = false;
            }
        }
    }
}
