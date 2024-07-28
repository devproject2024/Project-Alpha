package com.google.android.gms.internal.firebase_ml;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class am {

    /* renamed from: a  reason: collision with root package name */
    private final String f9745a;

    /* renamed from: b  reason: collision with root package name */
    private final ao f9746b;

    /* renamed from: c  reason: collision with root package name */
    private ao f9747c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9748d;

    private am(String str) {
        this.f9746b = new ao((byte) 0);
        this.f9747c = this.f9746b;
        this.f9748d = false;
        this.f9745a = (String) ap.a(str);
    }

    public final am a(String str, int i2) {
        return a(str, (Object) String.valueOf(i2));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f9745a);
        sb.append('{');
        ao aoVar = this.f9746b.f9751c;
        String str = "";
        while (aoVar != null) {
            Object obj = aoVar.f9750b;
            sb.append(str);
            if (aoVar.f9749a != null) {
                sb.append(aoVar.f9749a);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            aoVar = aoVar.f9751c;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final am a(String str, @NullableDecl Object obj) {
        ao aoVar = new ao((byte) 0);
        this.f9747c.f9751c = aoVar;
        this.f9747c = aoVar;
        aoVar.f9750b = obj;
        aoVar.f9749a = (String) ap.a(str);
        return this;
    }

    public /* synthetic */ am(String str, byte b2) {
        this(str);
    }
}
