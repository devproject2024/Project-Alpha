package com.google.android.gms.common;

import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.b.d;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.as;
import com.google.android.gms.common.internal.s;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class o extends ar {

    /* renamed from: a  reason: collision with root package name */
    private int f8885a;

    protected o(byte[] bArr) {
        s.b(bArr.length == 25);
        this.f8885a = Arrays.hashCode(bArr);
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] c();

    public int hashCode() {
        return this.f8885a;
    }

    public boolean equals(Object obj) {
        b a2;
        if (obj != null && (obj instanceof as)) {
            try {
                as asVar = (as) obj;
                if (asVar.b() != hashCode() || (a2 = asVar.a()) == null) {
                    return false;
                }
                return Arrays.equals(c(), (byte[]) d.a(a2));
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public final b a() {
        return d.a(c());
    }

    public final int b() {
        return hashCode();
    }

    protected static byte[] a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }
}
