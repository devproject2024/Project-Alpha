package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.ce;
import com.google.android.gms.internal.measurement.cf;
import java.io.IOException;

public abstract class cf<MessageType extends ce<MessageType, BuilderType>, BuilderType extends cf<MessageType, BuilderType>> implements fe {
    /* access modifiers changed from: protected */
    public abstract BuilderType a(MessageType messagetype);

    public abstract BuilderType a(cz czVar, dh dhVar) throws IOException;

    /* renamed from: s */
    public abstract BuilderType clone();

    public BuilderType a(byte[] bArr, int i2) throws eg {
        try {
            cz a2 = cz.a(bArr, i2);
            a(a2, dh.a());
            a2.a(0);
            return this;
        } catch (eg e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException(a("byte array"), e3);
        }
    }

    public BuilderType a(byte[] bArr, int i2, dh dhVar) throws eg {
        try {
            cz a2 = cz.a(bArr, i2);
            a(a2, dhVar);
            a2.a(0);
            return this;
        } catch (eg e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException(a("byte array"), e3);
        }
    }

    private final String a(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + String.valueOf(str).length());
        sb.append("Reading ");
        sb.append(name);
        sb.append(" from a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    public final /* synthetic */ fe a(ff ffVar) {
        if (q().getClass().isInstance(ffVar)) {
            return a((ce) ffVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public final /* synthetic */ fe a(byte[] bArr, dh dhVar) throws eg {
        return a(bArr, bArr.length, dhVar);
    }

    public final /* synthetic */ fe a(byte[] bArr) throws eg {
        return a(bArr, bArr.length);
    }
}
