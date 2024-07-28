package kotlin;

import kotlin.g.b.k;

public final class f implements Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    public static final f f47913a = new f();

    /* renamed from: b  reason: collision with root package name */
    public static final a f47914b = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private final int f47915c;

    /* renamed from: d  reason: collision with root package name */
    private final int f47916d = 1;

    /* renamed from: e  reason: collision with root package name */
    private final int f47917e = 4;

    /* renamed from: f  reason: collision with root package name */
    private final int f47918f = 0;

    private f() {
        boolean z = true;
        int i2 = this.f47916d;
        int i3 = this.f47917e;
        int i4 = this.f47918f;
        if ((i2 < 0 || 255 < i2 || i3 < 0 || 255 < i3 || i4 < 0 || 255 < i4) ? false : z) {
            this.f47915c = (i2 << 16) + (i3 << 8) + i4;
            return;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i2 + '.' + i3 + '.' + i4).toString());
    }

    public final /* synthetic */ int compareTo(Object obj) {
        f fVar = (f) obj;
        k.d(fVar, "other");
        return this.f47915c - fVar.f47915c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f47916d);
        sb.append('.');
        sb.append(this.f47917e);
        sb.append('.');
        sb.append(this.f47918f);
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            obj = null;
        }
        f fVar = (f) obj;
        if (fVar != null && this.f47915c == fVar.f47915c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f47915c;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
