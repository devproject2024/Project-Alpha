package com.alibaba.a;

import com.alibaba.a.a.b;
import com.alibaba.a.b.i;
import com.alibaba.a.d.g;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class e extends a implements Serializable, Cloneable, InvocationHandler, Map<String, Object> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final long serialVersionUID = 1;
    private final Map<String, Object> map;

    public e() {
        this(16, false);
    }

    public e(Map<String, Object> map2) {
        this.map = map2;
    }

    public e(boolean z) {
        this(16, z);
    }

    public e(int i2) {
        this(i2, false);
    }

    public e(int i2, boolean z) {
        if (z) {
            this.map = new LinkedHashMap(i2);
        } else {
            this.map = new HashMap(i2);
        }
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public Object get(Object obj) {
        return this.map.get(obj);
    }

    public e getJSONObject(String str) {
        Object obj = this.map.get(str);
        if (obj instanceof e) {
            return (e) obj;
        }
        return (e) toJSON(obj);
    }

    public b getJSONArray(String str) {
        Object obj = this.map.get(str);
        if (obj instanceof b) {
            return (b) obj;
        }
        return (b) toJSON(obj);
    }

    public <T> T getObject(String str, Class<T> cls) {
        return g.a(this.map.get(str), cls);
    }

    public Boolean getBoolean(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return g.o(obj);
    }

    public byte[] getBytes(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return g.n(obj);
    }

    public boolean getBooleanValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return false;
        }
        return g.o(obj).booleanValue();
    }

    public Byte getByte(String str) {
        return g.b(get(str));
    }

    public byte getByteValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0;
        }
        return g.b(obj).byteValue();
    }

    public Short getShort(String str) {
        return g.d(get(str));
    }

    public short getShortValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0;
        }
        return g.d(obj).shortValue();
    }

    public Integer getInteger(String str) {
        return g.m(get(str));
    }

    public int getIntValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0;
        }
        return g.m(obj).intValue();
    }

    public Long getLong(String str) {
        return g.l(get(str));
    }

    public long getLongValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0;
        }
        return g.l(obj).longValue();
    }

    public Float getFloat(String str) {
        return g.g(get(str));
    }

    public float getFloatValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0.0f;
        }
        return g.g(obj).floatValue();
    }

    public Double getDouble(String str) {
        return g.h(get(str));
    }

    public double getDoubleValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0.0d;
        }
        return g.h(obj).doubleValue();
    }

    public BigDecimal getBigDecimal(String str) {
        return g.e(get(str));
    }

    public BigInteger getBigInteger(String str) {
        return g.f(get(str));
    }

    public String getString(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public Date getDate(String str) {
        return g.i(get(str));
    }

    public java.sql.Date getSqlDate(String str) {
        return g.j(get(str));
    }

    public Timestamp getTimestamp(String str) {
        return g.k(get(str));
    }

    public Object put(String str, Object obj) {
        return this.map.put(str, obj);
    }

    public void putAll(Map<? extends String, ? extends Object> map2) {
        this.map.putAll(map2);
    }

    public void clear() {
        this.map.clear();
    }

    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    public Collection<Object> values() {
        return this.map.values();
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    public Object clone() {
        return new e((Map<String, Object>) new HashMap(this.map));
    }

    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Class[] parameterTypes = method.getParameterTypes();
        String str = null;
        if (parameterTypes.length == 1) {
            if (method.getName().equals("equals")) {
                return Boolean.valueOf(equals(objArr[0]));
            }
            if (method.getReturnType() == Void.TYPE) {
                b bVar = (b) method.getAnnotation(b.class);
                String b2 = (bVar == null || bVar.b().length() == 0) ? null : bVar.b();
                if (b2 == null) {
                    String name = method.getName();
                    if (name.startsWith("set")) {
                        String substring = name.substring(3);
                        if (substring.length() != 0) {
                            b2 = Character.toLowerCase(substring.charAt(0)) + substring.substring(1);
                        } else {
                            throw new d("illegal setter");
                        }
                    } else {
                        throw new d("illegal setter");
                    }
                }
                this.map.put(b2, objArr[0]);
                return null;
            }
            throw new d("illegal setter");
        } else if (parameterTypes.length != 0) {
            throw new UnsupportedOperationException(method.toGenericString());
        } else if (method.getReturnType() != Void.TYPE) {
            b bVar2 = (b) method.getAnnotation(b.class);
            if (!(bVar2 == null || bVar2.b().length() == 0)) {
                str = bVar2.b();
            }
            if (str == null) {
                String name2 = method.getName();
                if (name2.startsWith("get")) {
                    String substring2 = name2.substring(3);
                    if (substring2.length() != 0) {
                        str = Character.toLowerCase(substring2.charAt(0)) + substring2.substring(1);
                    } else {
                        throw new d("illegal getter");
                    }
                } else if (name2.startsWith("is")) {
                    String substring3 = name2.substring(2);
                    if (substring3.length() != 0) {
                        str = Character.toLowerCase(substring3.charAt(0)) + substring3.substring(1);
                    } else {
                        throw new d("illegal getter");
                    }
                } else if (name2.startsWith("hashCode")) {
                    return Integer.valueOf(hashCode());
                } else {
                    if (name2.startsWith("toString")) {
                        return toString();
                    }
                    throw new d("illegal getter");
                }
            }
            return g.a(this.map.get(str), method.getGenericReturnType(), i.a());
        } else {
            throw new d("illegal getter");
        }
    }
}
