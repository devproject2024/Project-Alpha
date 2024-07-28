package com.google.gsonhtcfix.b;

import com.google.gsonhtcfix.c.a;
import com.google.gsonhtcfix.h;
import com.google.gsonhtcfix.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Type, h<?>> f39716a;

    public c(Map<Type, h<?>> map) {
        this.f39716a = map;
    }

    public final <T> h<T> a(a<T> aVar) {
        h<T> hVar;
        final Type type = aVar.getType();
        final Class<? super T> rawType = aVar.getRawType();
        final h hVar2 = this.f39716a.get(type);
        if (hVar2 != null) {
            return new h<T>() {
                public final T a() {
                    return hVar2.a();
                }
            };
        }
        final h hVar3 = this.f39716a.get(rawType);
        if (hVar3 != null) {
            return new h<T>() {
                public final T a() {
                    return hVar3.a();
                }
            };
        }
        h<T> a2 = a(rawType);
        if (a2 != null) {
            return a2;
        }
        if (Collection.class.isAssignableFrom(rawType)) {
            hVar = SortedSet.class.isAssignableFrom(rawType) ? new h<T>() {
                public final T a() {
                    return new TreeSet();
                }
            } : EnumSet.class.isAssignableFrom(rawType) ? new h<T>() {
                public final T a() {
                    Type type = type;
                    if (type instanceof ParameterizedType) {
                        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                        if (type2 instanceof Class) {
                            return EnumSet.noneOf((Class) type2);
                        }
                        throw new m("Invalid EnumSet type: " + type.toString());
                    }
                    throw new m("Invalid EnumSet type: " + type.toString());
                }
            } : Set.class.isAssignableFrom(rawType) ? new h<T>() {
                public final T a() {
                    return new LinkedHashSet();
                }
            } : Queue.class.isAssignableFrom(rawType) ? new h<T>() {
                public final T a() {
                    return new LinkedList();
                }
            } : new h<T>() {
                public final T a() {
                    return new ArrayList();
                }
            };
        } else if (Map.class.isAssignableFrom(rawType)) {
            hVar = SortedMap.class.isAssignableFrom(rawType) ? new h<T>() {
                public final T a() {
                    return new TreeMap();
                }
            } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new h<T>() {
                public final T a() {
                    return new g();
                }
            } : new h<T>() {
                public final T a() {
                    return new LinkedHashMap();
                }
            };
        } else {
            hVar = null;
        }
        return hVar != null ? hVar : new h<T>() {

            /* renamed from: d  reason: collision with root package name */
            private final k f39728d = k.a();

            public final T a() {
                try {
                    return this.f39728d.a(rawType);
                } catch (Exception e2) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Register an InstanceCreator with Gson for this type may fix this problem.", e2);
                }
            }
        };
    }

    private <T> h<T> a(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new h<T>() {
                public final T a() {
                    try {
                        return declaredConstructor.newInstance((Object[]) null);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    } catch (IllegalAccessException e4) {
                        throw new AssertionError(e4);
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final String toString() {
        return this.f39716a.toString();
    }
}
