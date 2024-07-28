package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.cm;
import com.google.android.gms.internal.vision.co;
import java.io.IOException;

public abstract class cm<MessageType extends cm<MessageType, BuilderType>, BuilderType extends co<MessageType, BuilderType>> implements ft {
    protected int zzro = 0;

    public final cz c() {
        try {
            dh zzaq = cz.zzaq(h());
            a(zzaq.f11036a);
            return zzaq.a();
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

    public final byte[] d() {
        try {
            byte[] bArr = new byte[h()];
            dr a2 = dr.a(bArr);
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
    public int e() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        throw new UnsupportedOperationException();
    }
}
