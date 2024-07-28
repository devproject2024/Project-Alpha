package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.f;

public abstract class t<A extends a.b, ResultT> {
    private final Feature[] zakh;
    private final boolean zako;

    @Deprecated
    public t() {
        this.zakh = null;
        this.zako = false;
    }

    /* access modifiers changed from: protected */
    public abstract void doExecute(A a2, f<ResultT> fVar) throws RemoteException;

    private t(Feature[] featureArr, boolean z) {
        this.zakh = featureArr;
        this.zako = z;
    }

    public final Feature[] zabr() {
        return this.zakh;
    }

    public boolean shouldAutoResolveMissingFeatures() {
        return this.zako;
    }

    public static class a<A extends a.b, ResultT> {

        /* renamed from: a  reason: collision with root package name */
        public p<A, f<ResultT>> f8629a;

        /* renamed from: b  reason: collision with root package name */
        public Feature[] f8630b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8631c;

        private a() {
            this.f8631c = true;
        }

        public final t<A, ResultT> a() {
            s.b(this.f8629a != null, "execute parameter required");
            return new bw(this, this.f8630b, this.f8631c);
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static <A extends a.b, ResultT> a<A, ResultT> builder() {
        return new a<>((byte) 0);
    }
}
