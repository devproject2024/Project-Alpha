package com.google.android.gms.common.server.response;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
    public Object b() {
        return null;
    }

    public boolean c() {
        return false;
    }

    public final int describeContents() {
        return 0;
    }

    public int hashCode() {
        int i2 = 0;
        for (FastJsonResponse.Field next : a().values()) {
            if (a(next)) {
                i2 = (i2 * 31) + b(next).hashCode();
            }
        }
        return i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastJsonResponse fastJsonResponse = (FastJsonResponse) obj;
        for (FastJsonResponse.Field next : a().values()) {
            if (a(next)) {
                if (!fastJsonResponse.a(next) || !b(next).equals(fastJsonResponse.b(next))) {
                    return false;
                }
            } else if (fastJsonResponse.a(next)) {
                return false;
            }
        }
        return true;
    }
}
