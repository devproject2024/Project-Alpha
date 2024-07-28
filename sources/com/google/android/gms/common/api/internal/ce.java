package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.d.a;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.l;

public final class ce<A extends d.a<? extends l, a.b>> extends bo {

    /* renamed from: a  reason: collision with root package name */
    private final A f8509a;

    public ce(int i2, A a2) {
        super(i2);
        this.f8509a = a2;
    }

    public final void c(f.a<?> aVar) throws DeadObjectException {
        try {
            this.f8509a.b(aVar.f8593a);
        } catch (RuntimeException e2) {
            a(e2);
        }
    }

    public final void a(Status status) {
        this.f8509a.b(status);
    }

    public final void a(RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        this.f8509a.b(new Status(10, sb.toString()));
    }

    public final void a(cz czVar, boolean z) {
        A a2 = this.f8509a;
        czVar.f8566a.put(a2, Boolean.valueOf(z));
        a2.a((g.a) new y(czVar, a2));
    }
}
