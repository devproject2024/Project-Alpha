package com.google.gson.internal;

import com.google.gson.b.a;
import com.google.gson.h;
import com.google.gson.internal.a.b;
import com.google.gson.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Type, h<?>> f39585a;

    /* renamed from: b  reason: collision with root package name */
    private final b f39586b = b.a();

    public c(Map<Type, h<?>> map) {
        this.f39585a = map;
    }

    public final <T> h<T> a(a<T> aVar) {
        h<T> hVar;
        final Type type = aVar.getType();
        final Class<? super T> rawType = aVar.getRawType();
        final h hVar2 = this.f39585a.get(type);
        if (hVar2 != null) {
            return new h<T>() {
                public final T a() {
                    return hVar2.a();
                }
            };
        }
        final h hVar3 = this.f39585a.get(rawType);
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
                    return new ArrayDeque();
                }
            } : new h<T>() {
                public final T a() {
                    return new ArrayList();
                }
            };
        } else if (!Map.class.isAssignableFrom(rawType)) {
            hVar = null;
        } else if (ConcurrentNavigableMap.class.isAssignableFrom(rawType)) {
            hVar = new h<T>() {
                public final T a() {
                    return new ConcurrentSkipListMap();
                }
            };
        } else if (ConcurrentMap.class.isAssignableFrom(rawType)) {
            hVar = new h<T>() {
                public final T a() {
                    return new ConcurrentHashMap();
                }
            };
        } else {
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
        }
        return hVar != null ? hVar : new h<T>() {

            /* renamed from: d  reason: collision with root package name */
            private final l f39603d = l.a();

            public final T a() {
                try {
                    return this.f39603d.a(rawType);
                } catch (Exception e2) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
                }
            }
        };
    }

    private <T> h<T> a(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f39586b.a(declaredConstructor);
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
        return this.f39585a.toString();
    }
}
