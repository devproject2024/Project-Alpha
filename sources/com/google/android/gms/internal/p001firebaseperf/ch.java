package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.ch;
import com.google.android.gms.internal.p001firebaseperf.ci;

/* renamed from: com.google.android.gms.internal.firebase-perf.ch  reason: invalid package */
public abstract class ch<MessageType extends ci<MessageType, BuilderType>, BuilderType extends ch<MessageType, BuilderType>> implements fa {
    /* access modifiers changed from: protected */
    public abstract BuilderType a(MessageType messagetype);

    /* renamed from: g */
    public abstract BuilderType clone();

    public final /* synthetic */ fa a(ex exVar) {
        if (q().getClass().isInstance(exVar)) {
            return a((ci) exVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
