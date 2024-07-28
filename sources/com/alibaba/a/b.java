package com.alibaba.a;

import com.alibaba.a.d.g;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class b extends a implements Serializable, Cloneable, List<Object>, RandomAccess {
    private static final long serialVersionUID = 1;
    protected transient Type componentType;
    private final List<Object> list;
    protected transient Object relatedArray;

    public b() {
        this.list = new ArrayList(10);
    }

    public b(List<Object> list2) {
        this.list = list2;
    }

    public b(int i2) {
        this.list = new ArrayList(i2);
    }

    public Object getRelatedArray() {
        return this.relatedArray;
    }

    public void setRelatedArray(Object obj) {
        this.relatedArray = obj;
    }

    public Type getComponentType() {
        return this.componentType;
    }

    public void setComponentType(Type type) {
        this.componentType = type;
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    public Iterator<Object> iterator() {
        return this.list.iterator();
    }

    public Object[] toArray() {
        return this.list.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.list.toArray(tArr);
    }

    public boolean add(Object obj) {
        return this.list.add(obj);
    }

    public boolean remove(Object obj) {
        return this.list.remove(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    public boolean addAll(Collection<? extends Object> collection) {
        return this.list.addAll(collection);
    }

    public boolean addAll(int i2, Collection<? extends Object> collection) {
        return this.list.addAll(i2, collection);
    }

    public boolean removeAll(Collection<?> collection) {
        return this.list.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.list.retainAll(collection);
    }

    public void clear() {
        this.list.clear();
    }

    public Object set(int i2, Object obj) {
        return this.list.set(i2, obj);
    }

    public void add(int i2, Object obj) {
        this.list.add(i2, obj);
    }

    public Object remove(int i2) {
        return this.list.remove(i2);
    }

    public int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    public int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    public ListIterator<Object> listIterator() {
        return this.list.listIterator();
    }

    public ListIterator<Object> listIterator(int i2) {
        return this.list.listIterator(i2);
    }

    public List<Object> subList(int i2, int i3) {
        return this.list.subList(i2, i3);
    }

    public Object get(int i2) {
        return this.list.get(i2);
    }

    public e getJSONObject(int i2) {
        Object obj = this.list.get(i2);
        if (obj instanceof e) {
            return (e) obj;
        }
        return (e) toJSON(obj);
    }

    public b getJSONArray(int i2) {
        Object obj = this.list.get(i2);
        if (obj instanceof b) {
            return (b) obj;
        }
        return (b) toJSON(obj);
    }

    public <T> T getObject(int i2, Class<T> cls) {
        return g.a(this.list.get(i2), cls);
    }

    public Boolean getBoolean(int i2) {
        Object obj = get(i2);
        if (obj == null) {
            return null;
        }
        return g.o(obj);
    }

    public boolean getBooleanValue(int i2) {
        Object obj = get(i2);
        if (obj == null) {
            return false;
        }
        return g.o(obj).booleanValue();
    }

    public Byte getByte(int i2) {
        return g.b(get(i2));
    }

    public byte getByteValue(int i2) {
        Object obj = get(i2);
        if (obj == null) {
            return 0;
        }
        return g.b(obj).byteValue();
    }

    public Short getShort(int i2) {
        return g.d(get(i2));
    }

    public short getShortValue(int i2) {
        Object obj = get(i2);
        if (obj == null) {
            return 0;
        }
        return g.d(obj).shortValue();
    }

    public Integer getInteger(int i2) {
        return g.m(get(i2));
    }

    public int getIntValue(int i2) {
        Object obj = get(i2);
        if (obj == null) {
            return 0;
        }
        return g.m(obj).intValue();
    }

    public Long getLong(int i2) {
        return g.l(get(i2));
    }

    public long getLongValue(int i2) {
        Object obj = get(i2);
        if (obj == null) {
            return 0;
        }
        return g.l(obj).longValue();
    }

    public Float getFloat(int i2) {
        return g.g(get(i2));
    }

    public float getFloatValue(int i2) {
        Object obj = get(i2);
        if (obj == null) {
            return 0.0f;
        }
        return g.g(obj).floatValue();
    }

    public Double getDouble(int i2) {
        return g.h(get(i2));
    }

    public double getDoubleValue(int i2) {
        Object obj = get(i2);
        if (obj == null) {
            return 0.0d;
        }
        return g.h(obj).doubleValue();
    }

    public BigDecimal getBigDecimal(int i2) {
        return g.e(get(i2));
    }

    public BigInteger getBigInteger(int i2) {
        return g.f(get(i2));
    }

    public String getString(int i2) {
        return g.a(get(i2));
    }

    public Date getDate(int i2) {
        return g.i(get(i2));
    }

    public java.sql.Date getSqlDate(int i2) {
        return g.j(get(i2));
    }

    public Timestamp getTimestamp(int i2) {
        return g.k(get(i2));
    }

    public Object clone() {
        return new b((List<Object>) new ArrayList(this.list));
    }

    public boolean equals(Object obj) {
        return this.list.equals(obj);
    }

    public int hashCode() {
        return this.list.hashCode();
    }
}
