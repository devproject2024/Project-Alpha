package com.google.android.gms.internal.firebase_ml;

import java.util.Arrays;

public final class du<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f9831a;

    /* renamed from: b  reason: collision with root package name */
    private final T f9832b;

    public du(String str, T t) {
        if (str != null) {
            this.f9831a = str;
            if (t != null) {
                this.f9832b = t;
                return;
            }
            throw new NullPointerException("Null options");
        }
        throw new NullPointerException("Null firebasePersistentKey");
    }

    public final String toString() {
        String str = this.f9831a;
        String valueOf = String.valueOf(this.f9832b);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 58 + String.valueOf(valueOf).length());
        sb.append("MlModelDriverInstanceKey{firebasePersistentKey=");
        sb.append(str);
        sb.append(", options=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof du) {
            du duVar = (du) obj;
            return this.f9831a.equals(duVar.f9831a) && this.f9832b.equals(duVar.f9832b);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9831a, this.f9832b});
    }
}
