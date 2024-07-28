package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.s;

public final class h {

    public static final class a<R extends l> extends BasePendingResult<R> {

        /* renamed from: a  reason: collision with root package name */
        private final R f8383a;

        public a(R r) {
            super((e) null);
            this.f8383a = r;
        }

        public final R a(Status status) {
            return this.f8383a;
        }
    }

    public static g<Status> a(Status status, e eVar) {
        s.a(status, (Object) "Result must not be null");
        com.google.android.gms.common.api.internal.s sVar = new com.google.android.gms.common.api.internal.s(eVar);
        sVar.a(status);
        return sVar;
    }
}
