package io.reactivex.rxjava3.e.k;

import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.r;
import java.util.ArrayList;
import java.util.List;

public enum b implements h<Object, List<Object>>, r<List<Object>> {
    INSTANCE;

    public static <T> r<List<T>> asSupplier() {
        return INSTANCE;
    }

    public static <T, O> h<O, List<T>> asFunction() {
        return INSTANCE;
    }

    public final List<Object> get() {
        return new ArrayList();
    }

    public final List<Object> apply(Object obj) {
        return new ArrayList();
    }
}
