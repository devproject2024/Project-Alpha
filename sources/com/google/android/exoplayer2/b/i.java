package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.x;
import java.nio.ByteBuffer;

public interface i {

    public interface c {
        void a();

        void a(int i2);

        void a(int i2, long j, long j2);
    }

    long a(boolean z);

    x a(x xVar);

    void a();

    void a(float f2);

    void a(int i2);

    void a(int i2, int i3, int i4, int[] iArr, int i5, int i6) throws a;

    void a(c cVar);

    void a(c cVar);

    void a(l lVar);

    boolean a(int i2, int i3);

    boolean a(ByteBuffer byteBuffer, long j) throws b, d;

    void b();

    void c() throws d;

    boolean d();

    boolean e();

    x f();

    void g();

    void h();

    void i();

    void j();

    public static final class a extends Exception {
        public a(Throwable th) {
            super(th);
        }

        public a(String str) {
            super(str);
        }
    }

    public static final class b extends Exception {
        public final int audioTrackState;

        public b(int i2, int i3, int i4, int i5) {
            super("AudioTrack init failed: " + i2 + ", Config(" + i3 + ", " + i4 + ", " + i5 + ")");
            this.audioTrackState = i2;
        }
    }

    public static final class d extends Exception {
        public final int errorCode;

        public d(int i2) {
            super("AudioTrack write failed: ".concat(String.valueOf(i2)));
            this.errorCode = i2;
        }
    }
}
