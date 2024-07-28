package com.google.firebase.ml.vision.f;

import com.google.android.gms.common.internal.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f39157a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39158b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f39159c;

    /* renamed from: com.google.firebase.ml.vision.f.a$a  reason: collision with other inner class name */
    public static class C0656a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f39160a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public int f39161b = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f39162c = false;
    }

    private a(List<String> list, int i2, boolean z) {
        s.a(list, (Object) "Provided hinted languages can not be null");
        this.f39157a = list;
        this.f39158b = i2;
        this.f39159c = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f39157a.equals(aVar.f39157a) && this.f39158b == aVar.f39158b && this.f39159c == aVar.f39159c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f39157a, Integer.valueOf(this.f39158b), Boolean.valueOf(this.f39159c)});
    }

    public /* synthetic */ a(List list, int i2, boolean z, byte b2) {
        this(list, i2, z);
    }
}
