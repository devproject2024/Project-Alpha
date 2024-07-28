package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.fa;
import com.google.android.gms.internal.firebase_ml.fb;

public abstract class fa<MessageType extends fb<MessageType, BuilderType>, BuilderType extends fa<MessageType, BuilderType>> implements hq {
    /* access modifiers changed from: protected */
    public abstract BuilderType a(MessageType messagetype);

    /* renamed from: c */
    public abstract BuilderType clone();

    public final /* synthetic */ hq a(hn hnVar) {
        if (k().getClass().isInstance(hnVar)) {
            return a((fb) hnVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
