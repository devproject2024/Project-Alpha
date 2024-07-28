package com.google.android.exoplayer2.d;

import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.d.d;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.o;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f31326a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31327b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31328c;

    /* renamed from: d  reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f31329d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f31330e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f31331f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f31332g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f31333h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f31334i;

    public static a a(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new a(str, str2, str3, codecCapabilities, false, z, z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005f, code lost:
        if ((com.google.android.exoplayer2.g.ae.f32499a >= 21 && r4.isFeatureSupported("secure-playback")) != false) goto L_0x0063;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    a(java.lang.String r1, java.lang.String r2, java.lang.String r3, android.media.MediaCodecInfo.CodecCapabilities r4, boolean r5, boolean r6, boolean r7) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = com.google.android.exoplayer2.g.a.a(r1)
            java.lang.String r1 = (java.lang.String) r1
            r0.f31326a = r1
            r0.f31327b = r2
            r0.f31328c = r3
            r0.f31329d = r4
            r0.f31333h = r5
            r1 = 1
            r3 = 0
            if (r6 != 0) goto L_0x002e
            if (r4 == 0) goto L_0x002e
            int r5 = com.google.android.exoplayer2.g.ae.f32499a
            r6 = 19
            if (r5 < r6) goto L_0x0029
            java.lang.String r5 = "adaptive-playback"
            boolean r5 = r4.isFeatureSupported(r5)
            if (r5 == 0) goto L_0x0029
            r5 = 1
            goto L_0x002a
        L_0x0029:
            r5 = 0
        L_0x002a:
            if (r5 == 0) goto L_0x002e
            r5 = 1
            goto L_0x002f
        L_0x002e:
            r5 = 0
        L_0x002f:
            r0.f31330e = r5
            r5 = 21
            if (r4 == 0) goto L_0x0049
            int r6 = com.google.android.exoplayer2.g.ae.f32499a
            if (r6 < r5) goto L_0x0044
            java.lang.String r6 = "tunneled-playback"
            boolean r6 = r4.isFeatureSupported(r6)
            if (r6 == 0) goto L_0x0044
            r6 = 1
            goto L_0x0045
        L_0x0044:
            r6 = 0
        L_0x0045:
            if (r6 == 0) goto L_0x0049
            r6 = 1
            goto L_0x004a
        L_0x0049:
            r6 = 0
        L_0x004a:
            r0.f31331f = r6
            if (r7 != 0) goto L_0x0063
            if (r4 == 0) goto L_0x0062
            int r6 = com.google.android.exoplayer2.g.ae.f32499a
            if (r6 < r5) goto L_0x005e
            java.lang.String r5 = "secure-playback"
            boolean r4 = r4.isFeatureSupported(r5)
            if (r4 == 0) goto L_0x005e
            r4 = 1
            goto L_0x005f
        L_0x005e:
            r4 = 0
        L_0x005f:
            if (r4 == 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r1 = 0
        L_0x0063:
            r0.f31332g = r1
            boolean r1 = com.google.android.exoplayer2.g.o.b(r2)
            r0.f31334i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.d.a.<init>(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean):void");
    }

    public final String toString() {
        return this.f31326a;
    }

    public final MediaCodecInfo.CodecProfileLevel[] a() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f31329d;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.f31329d.profileLevels;
    }

    public final boolean a(Format format) throws d.b {
        boolean z = false;
        if (!b(format.f31066f)) {
            return false;
        }
        if (this.f31334i) {
            if (format.n <= 0 || format.o <= 0) {
                return true;
            }
            if (ae.f32499a >= 21) {
                return a(format.n, format.o, (double) format.p);
            }
            if (format.n * format.o <= d.b()) {
                z = true;
            }
            if (!z) {
                a("legacyFrameSize, " + format.n + "x" + format.o);
            }
            return z;
        } else if (ae.f32499a < 21 || ((format.w == -1 || a(format.w)) && (format.v == -1 || b(format.v)))) {
            return true;
        } else {
            return false;
        }
    }

    private boolean b(String str) {
        String f2;
        if (str == null || this.f31327b == null || (f2 = o.f(str)) == null) {
            return true;
        }
        if (!this.f31327b.equals(f2)) {
            a("codec.mime " + str + ", " + f2);
            return false;
        }
        Pair<Integer, Integer> a2 = d.a(str);
        if (a2 == null) {
            return true;
        }
        int intValue = ((Integer) a2.first).intValue();
        int intValue2 = ((Integer) a2.second).intValue();
        if (!this.f31334i && intValue != 42) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : a()) {
            if (codecProfileLevel.profile == intValue && codecProfileLevel.level >= intValue2) {
                return true;
            }
        }
        a("codec.profileLevel, " + str + ", " + f2);
        return false;
    }

    public final boolean b(Format format) {
        if (this.f31334i) {
            return this.f31330e;
        }
        Pair<Integer, Integer> a2 = d.a(format.f31066f);
        return a2 != null && ((Integer) a2.first).intValue() == 42;
    }

    public final boolean a(Format format, Format format2, boolean z) {
        if (this.f31334i) {
            return format.f31069i.equals(format2.f31069i) && format.q == format2.q && (this.f31330e || (format.n == format2.n && format.o == format2.o)) && ((!z && format2.u == null) || ae.a((Object) format.u, (Object) format2.u));
        }
        if ("audio/mp4a-latm".equals(this.f31327b) && format.f31069i.equals(format2.f31069i) && format.v == format2.v && format.w == format2.w) {
            Pair<Integer, Integer> a2 = d.a(format.f31066f);
            Pair<Integer, Integer> a3 = d.a(format2.f31066f);
            if (!(a2 == null || a3 == null)) {
                return ((Integer) a2.first).intValue() == 42 && ((Integer) a3.first).intValue() == 42;
            }
        }
    }

    public final boolean a(int i2, int i3, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f31329d;
        if (codecCapabilities == null) {
            a("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            a("sizeAndRate.vCaps");
            return false;
        } else if (a(videoCapabilities, i2, i3, d2)) {
            return true;
        } else {
            if (i2 >= i3 || !a(videoCapabilities, i3, i2, d2)) {
                a("sizeAndRate.support, " + i2 + "x" + i3 + "x" + d2);
                return false;
            }
            c("sizeAndRate.rotated, " + i2 + "x" + i3 + "x" + d2);
            return true;
        }
    }

    private boolean a(int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f31329d;
        if (codecCapabilities == null) {
            a("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            a("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i2)) {
            return true;
        } else {
            a("sampleRate.support, ".concat(String.valueOf(i2)));
            return false;
        }
    }

    private boolean b(int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f31329d;
        if (codecCapabilities == null) {
            a("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            a("channelCount.aCaps");
            return false;
        } else if (a(this.f31326a, this.f31327b, audioCapabilities.getMaxInputChannelCount()) >= i2) {
            return true;
        } else {
            a("channelCount.support, ".concat(String.valueOf(i2)));
            return false;
        }
    }

    public final void a(String str) {
        StringBuilder sb = new StringBuilder("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(this.f31326a);
        sb.append(", ");
        sb.append(this.f31327b);
        sb.append("] [");
        sb.append(ae.f32503e);
        sb.append("]");
        l.a();
    }

    private void c(String str) {
        StringBuilder sb = new StringBuilder("AssumedSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(this.f31326a);
        sb.append(", ");
        sb.append(this.f31327b);
        sb.append("] [");
        sb.append(ae.f32503e);
        sb.append("]");
        l.a();
    }

    private static int a(String str, String str2, int i2) {
        int i3;
        if (i2 > 1 || ((ae.f32499a >= 26 && i2 > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i2;
        }
        if ("audio/ac3".equals(str2)) {
            i3 = 6;
        } else {
            i3 = "audio/eac3".equals(str2) ? 16 : 30;
        }
        StringBuilder sb = new StringBuilder("AssumedMaxChannelAdjustment: ");
        sb.append(str);
        sb.append(", [");
        sb.append(i2);
        sb.append(" to ");
        sb.append(i3);
        sb.append("]");
        l.c();
        return i3;
    }

    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        if (d2 == -1.0d || d2 <= 0.0d) {
            return videoCapabilities.isSizeSupported(i2, i3);
        }
        return videoCapabilities.areSizeAndRateSupported(i2, i3, Math.floor(d2));
    }
}
