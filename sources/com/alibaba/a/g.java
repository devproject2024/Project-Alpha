package com.alibaba.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class g<T> {
    public static final Type LIST_STRING = new g<List<String>>() {
    }.getType();
    private final Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    protected g() {
    }

    public Type getType() {
        return this.type;
    }
}
