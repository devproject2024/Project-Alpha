package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final DataHolder f8680a;

    protected a(DataHolder dataHolder) {
        this.f8680a = dataHolder;
    }

    public final int b() {
        DataHolder dataHolder = this.f8680a;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.f8669e;
    }

    public final void close() {
        a();
    }

    public Iterator<T> iterator() {
        return new c(this);
    }

    public final void a() {
        DataHolder dataHolder = this.f8680a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
