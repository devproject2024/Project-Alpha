package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.q;
import java.util.Arrays;

final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f8722a;

    public b(Uri uri) {
        this.f8722a = uri;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8722a});
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return q.a(((b) obj).f8722a, this.f8722a);
    }
}
