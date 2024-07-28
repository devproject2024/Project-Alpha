package com.google.android.exoplayer2.b;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.google.android.exoplayer2.g.ae;

final class j {

    /* renamed from: a  reason: collision with root package name */
    final a f31190a;

    /* renamed from: b  reason: collision with root package name */
    int f31191b;

    /* renamed from: c  reason: collision with root package name */
    long f31192c;

    /* renamed from: d  reason: collision with root package name */
    long f31193d;

    /* renamed from: e  reason: collision with root package name */
    long f31194e;

    /* renamed from: f  reason: collision with root package name */
    long f31195f;

    public j(AudioTrack audioTrack) {
        if (ae.f32499a >= 19) {
            this.f31190a = new a(audioTrack);
            a();
            return;
        }
        this.f31190a = null;
        a(3);
    }

    public final void a() {
        if (this.f31190a != null) {
            a(0);
        }
    }

    public final long b() {
        a aVar = this.f31190a;
        if (aVar != null) {
            return aVar.a();
        }
        return -9223372036854775807L;
    }

    public final long c() {
        a aVar = this.f31190a;
        if (aVar != null) {
            return aVar.f31200e;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.f31191b = i2;
        if (i2 == 0) {
            this.f31194e = 0;
            this.f31195f = -1;
            this.f31192c = System.nanoTime() / 1000;
            this.f31193d = 5000;
        } else if (i2 == 1) {
            this.f31193d = 5000;
        } else if (i2 == 2 || i2 == 3) {
            this.f31193d = 10000000;
        } else if (i2 == 4) {
            this.f31193d = 500000;
        } else {
            throw new IllegalStateException();
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final AudioTrack f31196a;

        /* renamed from: b  reason: collision with root package name */
        final AudioTimestamp f31197b = new AudioTimestamp();

        /* renamed from: c  reason: collision with root package name */
        long f31198c;

        /* renamed from: d  reason: collision with root package name */
        long f31199d;

        /* renamed from: e  reason: collision with root package name */
        long f31200e;

        public a(AudioTrack audioTrack) {
            this.f31196a = audioTrack;
        }

        public final long a() {
            return this.f31197b.nanoTime / 1000;
        }
    }
}
