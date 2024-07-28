package com.google.android.datatransport.runtime;

import android.util.Base64;
import com.google.android.datatransport.d;
import com.google.android.datatransport.runtime.c;

public abstract class l {

    public static abstract class a {
        public abstract a a(d dVar);

        public abstract a a(String str);

        public abstract a a(byte[] bArr);

        public abstract l a();
    }

    public abstract String a();

    public abstract byte[] b();

    public abstract d c();

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = a();
        objArr[1] = c();
        objArr[2] = b() == null ? "" : Base64.encodeToString(b(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }

    public static a d() {
        return new c.a().a(d.DEFAULT);
    }
}
