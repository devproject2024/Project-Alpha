package com.alibaba.a.d;

import com.alibaba.a.a.a;
import com.alibaba.a.c.bb;
import com.alibaba.a.d;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public Constructor<?> f6345a;

    /* renamed from: b  reason: collision with root package name */
    public Constructor<?> f6346b;

    /* renamed from: c  reason: collision with root package name */
    public Method f6347c;

    /* renamed from: d  reason: collision with root package name */
    public final List<c> f6348d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public final List<c> f6349e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f6350f = 0;

    private b(Class<?> cls) {
        this.f6350f = g.c(cls);
    }

    private boolean a(c cVar) {
        for (c next : this.f6348d) {
            if (next.f6351a.equals(cVar.f6351a) && (!next.f6356f || cVar.f6356f)) {
                return false;
            }
        }
        this.f6348d.add(cVar);
        this.f6349e.add(cVar);
        Collections.sort(this.f6349e);
        return true;
    }

    public static b a(Class<?> cls, Type type) {
        Constructor<?> constructor;
        String str;
        int i2;
        String str2;
        Method method;
        int i3;
        String str3;
        int i4;
        com.alibaba.a.a.b bVar;
        Constructor<?> constructor2;
        Method method2;
        com.alibaba.a.a.b bVar2;
        com.alibaba.a.a.b bVar3;
        Class<?> cls2 = cls;
        b bVar4 = new b(cls2);
        if (Modifier.isAbstract(cls.getModifiers())) {
            constructor = null;
        } else {
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            int length = declaredConstructors.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    constructor = null;
                    break;
                }
                constructor = declaredConstructors[i5];
                if (constructor.getParameterTypes().length == 0) {
                    break;
                }
                i5++;
            }
            if (constructor == null && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
                Constructor<?>[] declaredConstructors2 = cls.getDeclaredConstructors();
                int length2 = declaredConstructors2.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length2) {
                        break;
                    }
                    Constructor<?> constructor3 = declaredConstructors2[i6];
                    if (constructor3.getParameterTypes().length == 1 && constructor3.getParameterTypes()[0].equals(cls.getDeclaringClass())) {
                        constructor = constructor3;
                        break;
                    }
                    i6++;
                }
            }
        }
        if (constructor != null) {
            g.a((AccessibleObject) constructor);
            bVar4.f6345a = constructor;
        } else if (constructor == null && !cls.isInterface() && !Modifier.isAbstract(cls.getModifiers())) {
            Constructor<?>[] declaredConstructors3 = cls.getDeclaredConstructors();
            int length3 = declaredConstructors3.length;
            int i7 = 0;
            while (true) {
                if (i7 >= length3) {
                    constructor2 = null;
                    break;
                }
                Constructor<?> constructor4 = declaredConstructors3[i7];
                if (((a) constructor4.getAnnotation(a.class)) != null) {
                    constructor2 = constructor4;
                    break;
                }
                i7++;
            }
            if (constructor2 != null) {
                g.a((AccessibleObject) constructor2);
                bVar4.f6346b = constructor2;
                int i8 = 0;
                while (i8 < constructor2.getParameterTypes().length) {
                    Annotation[] annotationArr = constructor2.getParameterAnnotations()[i8];
                    int length4 = annotationArr.length;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= length4) {
                            bVar3 = null;
                            break;
                        }
                        Annotation annotation = annotationArr[i9];
                        if (annotation instanceof com.alibaba.a.a.b) {
                            bVar3 = (com.alibaba.a.a.b) annotation;
                            break;
                        }
                        i9++;
                    }
                    if (bVar3 != null) {
                        Class cls3 = constructor2.getParameterTypes()[i8];
                        Type type2 = constructor2.getGenericParameterTypes()[i8];
                        Field a2 = g.a(cls2, bVar3.b());
                        int a3 = bVar3.a();
                        bb.of(bVar3.f());
                        bVar4.a(new c(bVar3.b(), cls, (Class<?>) cls3, type2, a2, a3));
                        i8++;
                    } else {
                        throw new d("illegal json creator");
                    }
                }
                return bVar4;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            int length5 = declaredMethods.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length5) {
                    method2 = null;
                    break;
                }
                Method method3 = declaredMethods[i10];
                if (Modifier.isStatic(method3.getModifiers()) && cls2.isAssignableFrom(method3.getReturnType()) && ((a) method3.getAnnotation(a.class)) != null) {
                    method2 = method3;
                    break;
                }
                i10++;
            }
            if (method2 != null) {
                g.a((AccessibleObject) method2);
                bVar4.f6347c = method2;
                int i11 = 0;
                while (i11 < method2.getParameterTypes().length) {
                    Annotation[] annotationArr2 = method2.getParameterAnnotations()[i11];
                    int length6 = annotationArr2.length;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= length6) {
                            bVar2 = null;
                            break;
                        }
                        Annotation annotation2 = annotationArr2[i12];
                        if (annotation2 instanceof com.alibaba.a.a.b) {
                            bVar2 = (com.alibaba.a.a.b) annotation2;
                            break;
                        }
                        i12++;
                    }
                    if (bVar2 != null) {
                        Class cls4 = method2.getParameterTypes()[i11];
                        Type type3 = method2.getGenericParameterTypes()[i11];
                        Field a4 = g.a(cls2, bVar2.b());
                        int a5 = bVar2.a();
                        bb.of(bVar2.f());
                        bVar4.a(new c(bVar2.b(), cls, (Class<?>) cls4, type3, a4, a5));
                        i11++;
                    } else {
                        throw new d("illegal json creator");
                    }
                }
                return bVar4;
            }
            throw new d("default constructor not found. ".concat(String.valueOf(cls)));
        }
        for (Method method4 : cls.getMethods()) {
            String name = method4.getName();
            if (name.length() >= 4 && !Modifier.isStatic(method4.getModifiers()) && ((method4.getReturnType().equals(Void.TYPE) || method4.getReturnType().equals(cls2)) && method4.getParameterTypes().length == 1)) {
                com.alibaba.a.a.b bVar5 = (com.alibaba.a.a.b) method4.getAnnotation(com.alibaba.a.a.b.class);
                if (bVar5 == null) {
                    bVar5 = g.a(cls2, method4);
                }
                if (bVar5 == null) {
                    method = method4;
                    i3 = 0;
                } else if (bVar5.e()) {
                    i3 = bVar5.a();
                    bb.of(bVar5.f());
                    if (bVar5.b().length() != 0) {
                        bVar4.a(new c(bVar5.b(), method4, (Field) null, cls, type, i3));
                        g.a((AccessibleObject) method4);
                    } else {
                        method = method4;
                    }
                }
                if (name.startsWith("set")) {
                    char charAt = name.charAt(3);
                    if (Character.isUpperCase(charAt)) {
                        if (g.f6377a) {
                            str3 = g.b(name.substring(3));
                        } else {
                            str3 = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                        }
                    } else if (charAt == '_') {
                        str3 = name.substring(4);
                    } else if (charAt == 'f') {
                        str3 = name.substring(3);
                    } else if (name.length() >= 5 && Character.isUpperCase(name.charAt(4))) {
                        str3 = g.b(name.substring(3));
                    }
                    String str4 = str3;
                    Field a6 = g.a(cls2, str4);
                    if (a6 == null && method.getParameterTypes()[0] == Boolean.TYPE) {
                        a6 = g.a(cls2, "is" + Character.toUpperCase(str4.charAt(0)) + str4.substring(1));
                    }
                    Field field = a6;
                    if (field == null || (bVar = (com.alibaba.a.a.b) field.getAnnotation(com.alibaba.a.a.b.class)) == null) {
                        i4 = i3;
                    } else {
                        i4 = bVar.a();
                        bb.of(bVar.f());
                        if (bVar.b().length() != 0) {
                            bVar4.a(new c(bVar.b(), method, field, cls, type, i4));
                        }
                    }
                    bVar4.a(new c(str4, method, (Field) null, cls, type, i4));
                    g.a((AccessibleObject) method);
                }
            }
        }
        for (Field field2 : cls.getFields()) {
            if (!Modifier.isStatic(field2.getModifiers())) {
                boolean z = false;
                for (c cVar : bVar4.f6348d) {
                    if (cVar.f6351a.equals(field2.getName())) {
                        z = true;
                    }
                }
                if (!z) {
                    String name2 = field2.getName();
                    com.alibaba.a.a.b bVar6 = (com.alibaba.a.a.b) field2.getAnnotation(com.alibaba.a.a.b.class);
                    if (bVar6 != null) {
                        int a7 = bVar6.a();
                        bb.of(bVar6.f());
                        if (bVar6.b().length() != 0) {
                            name2 = bVar6.b();
                        }
                        str2 = name2;
                        i2 = a7;
                    } else {
                        str2 = name2;
                        i2 = 0;
                    }
                    c cVar2 = r0;
                    c cVar3 = new c(str2, (Method) null, field2, cls, type, i2);
                    bVar4.a(cVar2);
                }
            }
        }
        for (Method method5 : cls.getMethods()) {
            String name3 = method5.getName();
            if (name3.length() < 4 || Modifier.isStatic(method5.getModifiers()) || !name3.startsWith("get") || !Character.isUpperCase(name3.charAt(3)) || method5.getParameterTypes().length != 0 || (!Collection.class.isAssignableFrom(method5.getReturnType()) && !Map.class.isAssignableFrom(method5.getReturnType()))) {
                Type type4 = type;
            } else {
                com.alibaba.a.a.b bVar7 = (com.alibaba.a.a.b) method5.getAnnotation(com.alibaba.a.a.b.class);
                if (bVar7 == null || bVar7.b().length() <= 0) {
                    str = Character.toLowerCase(name3.charAt(3)) + name3.substring(4);
                } else {
                    str = bVar7.b();
                }
                bVar4.a(new c(str, method5, cls2, type));
                g.a((AccessibleObject) method5);
            }
        }
        return bVar4;
    }
}
