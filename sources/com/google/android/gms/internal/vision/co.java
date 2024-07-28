package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.cm;
import com.google.android.gms.internal.vision.co;
import java.io.IOException;

public abstract class co<MessageType extends cm<MessageType, BuilderType>, BuilderType extends co<MessageType, BuilderType>> implements fs {
    /* renamed from: a */
    public abstract BuilderType clone();

    /* access modifiers changed from: protected */
    public abstract BuilderType a(MessageType messagetype);

    public abstract BuilderType a(dl dlVar, du duVar) throws IOException;

    public BuilderType a(byte[] bArr, int i2, du duVar) throws eu {
        try {
            dl a2 = dl.a(bArr, i2);
            a(a2, duVar);
            a2.a(0);
            return this;
        } catch (eu e2) {
            throw e2;
        } catch (IOException e3) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + "byte array".length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e3);
        }
    }

    public final /* synthetic */ fs a(ft ftVar) {
        if (k().getClass().isInstance(ftVar)) {
            return a((cm) ftVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
