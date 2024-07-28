package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.fa;
import com.google.android.gms.internal.firebase_ml.fb;
import java.io.IOException;

public abstract class fb<MessageType extends fb<MessageType, BuilderType>, BuilderType extends fa<MessageType, BuilderType>> implements hn {
    protected int zzchd = 0;

    public final fh d() {
        try {
            fp zzcy = fh.zzcy(i());
            a(zzcy.f9882a);
            zzcy.f9882a.i();
            return new fr(zzcy.f9883b);
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public final byte[] e() {
        try {
            byte[] bArr = new byte[i()];
            ft a2 = ft.a(bArr);
            a(a2);
            a2.i();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    /* access modifiers changed from: package-private */
    public int f() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        throw new UnsupportedOperationException();
    }
}
