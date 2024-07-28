package com.google.android.gms.internal.firebase_ml;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase_ml.if  reason: invalid class name */
final class Cif extends fi {

    /* renamed from: a  reason: collision with root package name */
    private final ih f9989a = new ih(this.f9991c, (byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private fm f9990b = b();

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ ic f9991c;

    Cif(ic icVar) {
        this.f9991c = icVar;
    }

    private final fm b() {
        if (this.f9989a.hasNext()) {
            return (fm) ((fo) this.f9989a.next()).iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.f9990b != null;
    }

    public final byte a() {
        fm fmVar = this.f9990b;
        if (fmVar != null) {
            byte a2 = fmVar.a();
            if (!this.f9990b.hasNext()) {
                this.f9990b = b();
            }
            return a2;
        }
        throw new NoSuchElementException();
    }
}
