package com.bumptech.glide.load.b;

import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.i;
import java.io.File;

final class e<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final d<DataType> f6838a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f6839b;

    /* renamed from: c  reason: collision with root package name */
    private final i f6840c;

    e(d<DataType> dVar, DataType datatype, i iVar) {
        this.f6838a = dVar;
        this.f6839b = datatype;
        this.f6840c = iVar;
    }

    public final boolean a(File file) {
        return this.f6838a.a(this.f6839b, file, this.f6840c);
    }
}
