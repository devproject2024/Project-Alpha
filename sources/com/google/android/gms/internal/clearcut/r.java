package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.r;
import com.google.android.gms.internal.clearcut.s;
import java.io.IOException;

public abstract class r<MessageType extends r<MessageType, BuilderType>, BuilderType extends s<MessageType, BuilderType>> implements cm {
    private static boolean zzey = false;
    protected int zzex = 0;

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        throw new UnsupportedOperationException();
    }

    public final ab b() {
        try {
            ag zzk = ab.zzk(e());
            a(zzk.f9124a);
            return zzk.a();
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
}
