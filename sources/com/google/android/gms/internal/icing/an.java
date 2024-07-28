package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.al;
import com.google.android.gms.internal.icing.an;

public abstract class an<MessageType extends al<MessageType, BuilderType>, BuilderType extends an<MessageType, BuilderType>> implements dc {
    /* renamed from: a */
    public abstract BuilderType clone();

    /* access modifiers changed from: protected */
    public abstract BuilderType a(MessageType messagetype);

    public final /* synthetic */ dc a(dd ddVar) {
        if (f().getClass().isInstance(ddVar)) {
            return a((al) ddVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
