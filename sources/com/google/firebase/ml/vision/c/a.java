package com.google.firebase.ml.vision.c;

import com.google.android.gms.common.internal.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f39134a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f39135b;

    /* renamed from: com.google.firebase.ml.vision.c.a$a  reason: collision with other inner class name */
    public static class C0653a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f39136a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public boolean f39137b = false;
    }

    private a(List<String> list, boolean z) {
        s.a(list, (Object) "Provided hinted languages can not be null");
        this.f39134a = list;
        this.f39135b = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f39134a.equals(aVar.f39134a) && this.f39135b == aVar.f39135b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f39134a, Boolean.valueOf(this.f39135b)});
    }

    public /* synthetic */ a(List list, boolean z, byte b2) {
        this(list, z);
    }
}
