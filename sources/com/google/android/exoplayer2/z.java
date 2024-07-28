package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.e.k;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.video.e;
import com.google.android.exoplayer2.video.g;

public interface z {

    public interface a {

        /* renamed from: com.google.android.exoplayer2.z$a$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$a(a aVar) {
            }

            public static void $default$a(a aVar, int i2) {
            }

            public static void $default$a(a aVar, ah ahVar) {
            }

            public static void $default$a(a aVar, i iVar) {
            }

            public static void $default$a(a aVar, boolean z) {
            }

            public static void $default$b(a aVar) {
            }

            public static void $default$b(a aVar, boolean z) {
            }

            public static void $default$c(a aVar) {
            }

            public static void $default$d(a aVar) {
            }

            public static void $default$e(a aVar) {
            }

            public static void $default$f(a aVar) {
            }
        }

        void a();

        void a(int i2);

        void a(ah ahVar);

        void a(i iVar);

        void a(boolean z);

        void b();

        void b(boolean z);

        void c();

        void d();

        void e();

        void f();
    }

    public interface b {
        void a(k kVar);

        void b(k kVar);
    }

    public interface c {
        void a(Surface surface);

        void a(SurfaceView surfaceView);

        void a(TextureView textureView);

        void a(com.google.android.exoplayer2.video.a.a aVar);

        void a(e eVar);

        void a(g gVar);

        void b(Surface surface);

        void b(SurfaceView surfaceView);

        void b(TextureView textureView);

        void b(com.google.android.exoplayer2.video.a.a aVar);

        void b(e eVar);

        void b(g gVar);
    }

    long A();

    TrackGroupArray B();

    com.google.android.exoplayer2.trackselection.g C();

    ah D();

    void a(int i2);

    void a(int i2, long j);

    void a(a aVar);

    void a(boolean z);

    int b(int i2);

    void b(a aVar);

    void b(boolean z);

    boolean b();

    boolean c();

    int d();

    int e();

    boolean f();

    c h();

    b i();

    Looper j();

    int k();

    int l();

    i m();

    boolean n();

    int o();

    boolean p();

    x q();

    int s();

    long t();

    long u();

    long v();

    boolean w();

    int x();

    int y();

    long z();
}
