package com.google.firebase.components;

import com.google.firebase.c.a;
import java.util.Set;

public interface e {
    <T> T a(Class<T> cls);

    <T> Set<T> b(Class<T> cls);

    <T> a<T> c(Class<T> cls);

    <T> a<Set<T>> d(Class<T> cls);
}
