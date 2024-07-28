package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.common.internal.s;
import java.io.Closeable;
import java.io.IOException;

public class ei<TDetectionResult> implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    protected final di<TDetectionResult, en> f9863a;

    /* renamed from: b  reason: collision with root package name */
    protected final Cdo f9864b;

    protected ei(ds dsVar, di<TDetectionResult, en> diVar) {
        s.a(dsVar, (Object) "MlKitContext must not be null");
        s.a(dsVar.f9817b.h(), (Object) "Persistence key must not be null");
        this.f9863a = diVar;
        this.f9864b = Cdo.a(dsVar);
        Cdo doVar = this.f9864b;
        doVar.f9809a.a(diVar.a());
    }

    public void close() throws IOException {
        Cdo doVar = this.f9864b;
        doVar.f9809a.c(this.f9863a.a());
    }
}
