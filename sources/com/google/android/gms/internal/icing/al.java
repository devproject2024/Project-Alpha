package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.al;
import com.google.android.gms.internal.icing.an;
import java.io.IOException;

public abstract class al<MessageType extends al<MessageType, BuilderType>, BuilderType extends an<MessageType, BuilderType>> implements dd {
    private static boolean zzfq = false;
    protected int zzfp = 0;

    public final at a() {
        try {
            bb zzm = at.zzm(d());
            a(zzm.f10065a);
            if (zzm.f10065a.h() == 0) {
                return new bd(zzm.f10066b);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
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

    /* access modifiers changed from: package-private */
    public int b() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        throw new UnsupportedOperationException();
    }
}
