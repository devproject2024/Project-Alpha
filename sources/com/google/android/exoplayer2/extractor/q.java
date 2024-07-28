package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;
import java.util.Arrays;

public interface q {
    int a(h hVar, int i2, boolean z) throws IOException, InterruptedException;

    void a(long j, int i2, int i3, int i4, a aVar);

    void a(Format format);

    void a(r rVar, int i2);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f32296a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f32297b;

        /* renamed from: c  reason: collision with root package name */
        public final int f32298c;

        /* renamed from: d  reason: collision with root package name */
        public final int f32299d;

        public a(int i2, byte[] bArr, int i3, int i4) {
            this.f32296a = i2;
            this.f32297b = bArr;
            this.f32298c = i3;
            this.f32299d = i4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                a aVar = (a) obj;
                return this.f32296a == aVar.f32296a && this.f32298c == aVar.f32298c && this.f32299d == aVar.f32299d && Arrays.equals(this.f32297b, aVar.f32297b);
            }
        }

        public final int hashCode() {
            return (((((this.f32296a * 31) + Arrays.hashCode(this.f32297b)) * 31) + this.f32298c) * 31) + this.f32299d;
        }
    }
}
