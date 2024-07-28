package com.google.firebase.crashlytics.a.j;

import com.google.android.datatransport.h;
import com.google.android.gms.tasks.f;
import com.google.firebase.crashlytics.a.c.o;

final /* synthetic */ class b implements h {

    /* renamed from: a  reason: collision with root package name */
    private final f f38648a;

    /* renamed from: b  reason: collision with root package name */
    private final o f38649b;

    private b(f fVar, o oVar) {
        this.f38648a = fVar;
        this.f38649b = oVar;
    }

    public static h a(f fVar, o oVar) {
        return new b(fVar, oVar);
    }

    public final void a(Exception exc) {
        a.a(this.f38648a, this.f38649b, exc);
    }
}
