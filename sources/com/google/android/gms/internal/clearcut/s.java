package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.r;
import com.google.android.gms.internal.clearcut.s;

public abstract class s<MessageType extends r<MessageType, BuilderType>, BuilderType extends s<MessageType, BuilderType>> implements cn {
    public final /* synthetic */ cn a(cm cmVar) {
        if (h().getClass().isInstance(cmVar)) {
            return a((r) cmVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    /* renamed from: a */
    public abstract BuilderType clone();

    /* access modifiers changed from: protected */
    public abstract BuilderType a(MessageType messagetype);
}
