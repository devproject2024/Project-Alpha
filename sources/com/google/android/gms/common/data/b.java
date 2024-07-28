package com.google.android.gms.common.data;

import com.google.android.gms.common.api.i;
import java.io.Closeable;

public interface b<T> extends i, Closeable, Iterable<T> {
    T a(int i2);

    int b();
}
