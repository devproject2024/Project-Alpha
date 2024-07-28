package com.google.android.exoplayer2.e;

import com.google.android.exoplayer2.Format;

public interface h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f31594a = new h() {
        public final boolean a(Format format) {
            String str = format.f31069i;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.google.android.exoplayer2.e.f b(com.google.android.exoplayer2.Format r3) {
            /*
                r2 = this;
                java.lang.String r0 = r3.f31069i
                int r1 = r0.hashCode()
                switch(r1) {
                    case -1351681404: goto L_0x0074;
                    case -1248334819: goto L_0x0069;
                    case -1026075066: goto L_0x005f;
                    case -1004728940: goto L_0x0054;
                    case 691401887: goto L_0x004a;
                    case 822864842: goto L_0x003f;
                    case 930165504: goto L_0x0035;
                    case 1566015601: goto L_0x002b;
                    case 1566016562: goto L_0x0020;
                    case 1668750253: goto L_0x0016;
                    case 1693976202: goto L_0x000b;
                    default: goto L_0x0009;
                }
            L_0x0009:
                goto L_0x007f
            L_0x000b:
                java.lang.String r1 = "application/ttml+xml"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x007f
                r0 = 3
                goto L_0x0080
            L_0x0016:
                java.lang.String r1 = "application/x-subrip"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x007f
                r0 = 4
                goto L_0x0080
            L_0x0020:
                java.lang.String r1 = "application/cea-708"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x007f
                r0 = 8
                goto L_0x0080
            L_0x002b:
                java.lang.String r1 = "application/cea-608"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x007f
                r0 = 6
                goto L_0x0080
            L_0x0035:
                java.lang.String r1 = "application/x-mp4-cea-608"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x007f
                r0 = 7
                goto L_0x0080
            L_0x003f:
                java.lang.String r1 = "text/x-ssa"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x007f
                r0 = 1
                goto L_0x0080
            L_0x004a:
                java.lang.String r1 = "application/x-quicktime-tx3g"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x007f
                r0 = 5
                goto L_0x0080
            L_0x0054:
                java.lang.String r1 = "text/vtt"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x007f
                r0 = 0
                goto L_0x0080
            L_0x005f:
                java.lang.String r1 = "application/x-mp4-vtt"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x007f
                r0 = 2
                goto L_0x0080
            L_0x0069:
                java.lang.String r1 = "application/pgs"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x007f
                r0 = 10
                goto L_0x0080
            L_0x0074:
                java.lang.String r1 = "application/dvbsubs"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x007f
                r0 = 9
                goto L_0x0080
            L_0x007f:
                r0 = -1
            L_0x0080:
                switch(r0) {
                    case 0: goto L_0x00cd;
                    case 1: goto L_0x00c5;
                    case 2: goto L_0x00bf;
                    case 3: goto L_0x00b9;
                    case 4: goto L_0x00b3;
                    case 5: goto L_0x00ab;
                    case 6: goto L_0x00a1;
                    case 7: goto L_0x00a1;
                    case 8: goto L_0x0099;
                    case 9: goto L_0x0091;
                    case 10: goto L_0x008b;
                    default: goto L_0x0083;
                }
            L_0x0083:
                java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "Attempted to create decoder for unsupported format"
                r3.<init>(r0)
                throw r3
            L_0x008b:
                com.google.android.exoplayer2.e.c.a r3 = new com.google.android.exoplayer2.e.c.a
                r3.<init>()
                return r3
            L_0x0091:
                com.google.android.exoplayer2.e.b.a r0 = new com.google.android.exoplayer2.e.b.a
                java.util.List<byte[]> r3 = r3.k
                r0.<init>(r3)
                return r0
            L_0x0099:
                com.google.android.exoplayer2.e.a.c r0 = new com.google.android.exoplayer2.e.a.c
                int r3 = r3.B
                r0.<init>(r3)
                return r0
            L_0x00a1:
                com.google.android.exoplayer2.e.a.a r0 = new com.google.android.exoplayer2.e.a.a
                java.lang.String r1 = r3.f31069i
                int r3 = r3.B
                r0.<init>(r1, r3)
                return r0
            L_0x00ab:
                com.google.android.exoplayer2.e.g.a r0 = new com.google.android.exoplayer2.e.g.a
                java.util.List<byte[]> r3 = r3.k
                r0.<init>(r3)
                return r0
            L_0x00b3:
                com.google.android.exoplayer2.e.e.a r3 = new com.google.android.exoplayer2.e.e.a
                r3.<init>()
                return r3
            L_0x00b9:
                com.google.android.exoplayer2.e.f.a r3 = new com.google.android.exoplayer2.e.f.a
                r3.<init>()
                return r3
            L_0x00bf:
                com.google.android.exoplayer2.e.h.b r3 = new com.google.android.exoplayer2.e.h.b
                r3.<init>()
                return r3
            L_0x00c5:
                com.google.android.exoplayer2.e.d.a r0 = new com.google.android.exoplayer2.e.d.a
                java.util.List<byte[]> r3 = r3.k
                r0.<init>(r3)
                return r0
            L_0x00cd:
                com.google.android.exoplayer2.e.h.g r3 = new com.google.android.exoplayer2.e.h.g
                r3.<init>()
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.h.AnonymousClass1.b(com.google.android.exoplayer2.Format):com.google.android.exoplayer2.e.f");
        }
    };

    boolean a(Format format);

    f b(Format format);
}
