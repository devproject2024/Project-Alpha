package com.google.android.exoplayer2.source.hls.a;

import android.net.Uri;
import android.util.Base64;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.h;
import com.google.android.exoplayer2.f.z;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.hls.a.d;
import com.google.android.exoplayer2.source.hls.a.e;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.v;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class g implements z.a<f> {
    private static final Pattern A = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern B = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern C = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern D = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern E = b("AUTOSELECT");
    private static final Pattern F = b("DEFAULT");
    private static final Pattern G = b("FORCED");
    private static final Pattern H = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern I = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern J = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f33131a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f33132b = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f33133c = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f33134d = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f33135e = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f33136f = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f33137g = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f33138h = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f33139i = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern j = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    private static final Pattern k = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern l = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern m = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern n = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern o = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern p = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern q = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern r = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern s = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern t = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern u = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern v = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern w = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern x = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern y = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern z = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private final d K;

    public g() {
        this(d.f33094a);
    }

    public g(d dVar) {
        this.K = dVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public f a(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (a(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (!trim.startsWith("#EXT-X-STREAM-INF")) {
                                if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                    break;
                                } else if (trim.equals("#EXT-X-ENDLIST")) {
                                    break;
                                } else {
                                    arrayDeque.add(trim);
                                }
                            } else {
                                arrayDeque.add(trim);
                                d a2 = a(new a(arrayDeque, bufferedReader), uri.toString());
                                ae.a((Closeable) bufferedReader);
                                return a2;
                            }
                        }
                    } else {
                        ae.a((Closeable) bufferedReader);
                        throw new v("Failed to parse the playlist, could not identify any tags.");
                    }
                }
                arrayDeque.add(trim);
                return a(this.K, new a(arrayDeque, bufferedReader), uri.toString());
            }
            throw new y("Input does not start with the #EXTM3U header.", uri);
        } finally {
            ae.a((Closeable) bufferedReader);
        }
    }

    private static boolean a(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int a2 = a(bufferedReader, true, read);
        for (int i2 = 0; i2 < 7; i2++) {
            if (a2 != "#EXTM3U".charAt(i2)) {
                return false;
            }
            a2 = bufferedReader.read();
        }
        return ae.a(a(bufferedReader, false, a2));
    }

    private static int a(BufferedReader bufferedReader, boolean z2, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !ae.a(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.source.hls.a.d a(com.google.android.exoplayer2.source.hls.a.g.a r39, java.lang.String r40) throws java.io.IOException {
        /*
            r1 = r40
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r13 = 0
            r14 = 0
        L_0x0036:
            boolean r15 = r39.a()
            r16 = -1082130432(0xffffffffbf800000, float:-1.0)
            r17 = -1
            if (r15 == 0) goto L_0x01bd
            java.lang.String r15 = r39.b()
            java.lang.String r10 = "#EXT"
            boolean r10 = r15.startsWith(r10)
            if (r10 == 0) goto L_0x004f
            r8.add(r15)
        L_0x004f:
            java.lang.String r10 = "#EXT-X-DEFINE"
            boolean r10 = r15.startsWith(r10)
            if (r10 == 0) goto L_0x0070
            java.util.regex.Pattern r10 = A
            java.lang.String r10 = a((java.lang.String) r15, (java.util.regex.Pattern) r10, (java.util.Map<java.lang.String, java.lang.String>) r11)
            java.util.regex.Pattern r9 = H
            java.lang.String r9 = a((java.lang.String) r15, (java.util.regex.Pattern) r9, (java.util.Map<java.lang.String, java.lang.String>) r11)
            r11.put(r10, r9)
        L_0x0066:
            r20 = r7
            r21 = r8
            r38 = r12
            r19 = r14
            goto L_0x01b3
        L_0x0070:
            java.lang.String r9 = "#EXT-X-INDEPENDENT-SEGMENTS"
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L_0x007a
            r14 = 1
            goto L_0x0036
        L_0x007a:
            java.lang.String r9 = "#EXT-X-MEDIA"
            boolean r9 = r15.startsWith(r9)
            if (r9 == 0) goto L_0x0086
            r3.add(r15)
            goto L_0x0066
        L_0x0086:
            java.lang.String r9 = "#EXT-X-SESSION-KEY"
            boolean r9 = r15.startsWith(r9)
            if (r9 == 0) goto L_0x00c0
            java.util.regex.Pattern r9 = u
            java.lang.String r10 = "identity"
            java.lang.String r9 = a(r15, r9, r10, r11)
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r9 = a((java.lang.String) r15, (java.lang.String) r9, (java.util.Map<java.lang.String, java.lang.String>) r11)
            if (r9 == 0) goto L_0x00ba
            java.util.regex.Pattern r10 = t
            java.lang.String r10 = a((java.lang.String) r15, (java.util.regex.Pattern) r10, (java.util.Map<java.lang.String, java.lang.String>) r11)
            java.lang.String r10 = a((java.lang.String) r10)
            com.google.android.exoplayer2.drm.DrmInitData r15 = new com.google.android.exoplayer2.drm.DrmInitData
            r20 = r7
            r19 = r14
            r14 = 1
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r7 = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[r14]
            r14 = 0
            r7[r14] = r9
            r15.<init>((java.lang.String) r10, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r7)
            r12.add(r15)
            goto L_0x01af
        L_0x00ba:
            r20 = r7
            r19 = r14
            goto L_0x01af
        L_0x00c0:
            r20 = r7
            r19 = r14
            java.lang.String r7 = "#EXT-X-STREAM-INF"
            boolean r7 = r15.startsWith(r7)
            if (r7 == 0) goto L_0x01af
            java.lang.String r7 = "CLOSED-CAPTIONS=NONE"
            boolean r7 = r15.contains(r7)
            r13 = r13 | r7
            java.util.regex.Pattern r7 = f33136f
            int r7 = a((java.lang.String) r15, (java.util.regex.Pattern) r7)
            java.util.regex.Pattern r9 = f33131a
            r10 = 0
            java.lang.String r9 = a(r15, r9, r10, r11)
            if (r9 == 0) goto L_0x00e6
            int r7 = java.lang.Integer.parseInt(r9)
        L_0x00e6:
            java.util.regex.Pattern r9 = f33138h
            java.lang.String r25 = a(r15, r9, r10, r11)
            java.util.regex.Pattern r9 = f33139i
            java.lang.String r9 = a(r15, r9, r10, r11)
            if (r9 == 0) goto L_0x0117
            java.lang.String r10 = "x"
            java.lang.String[] r9 = r9.split(r10)
            r10 = 0
            r14 = r9[r10]
            int r10 = java.lang.Integer.parseInt(r14)
            r14 = 1
            r9 = r9[r14]
            int r9 = java.lang.Integer.parseInt(r9)
            if (r10 <= 0) goto L_0x0111
            if (r9 > 0) goto L_0x010e
            goto L_0x0111
        L_0x010e:
            r17 = r9
            goto L_0x0112
        L_0x0111:
            r10 = -1
        L_0x0112:
            r28 = r10
            r29 = r17
            goto L_0x011b
        L_0x0117:
            r28 = -1
            r29 = -1
        L_0x011b:
            java.util.regex.Pattern r9 = j
            r10 = 0
            java.lang.String r9 = a(r15, r9, r10, r11)
            if (r9 == 0) goto L_0x012b
            float r16 = java.lang.Float.parseFloat(r9)
            r30 = r16
            goto L_0x012d
        L_0x012b:
            r30 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x012d:
            java.util.regex.Pattern r9 = f33132b
            java.lang.String r9 = a(r15, r9, r10, r11)
            java.util.regex.Pattern r14 = f33133c
            java.lang.String r14 = a(r15, r14, r10, r11)
            r18 = r13
            java.util.regex.Pattern r13 = f33134d
            java.lang.String r13 = a(r15, r13, r10, r11)
            r38 = r12
            java.util.regex.Pattern r12 = f33135e
            java.lang.String r10 = a(r15, r12, r10, r11)
            java.lang.String r12 = r39.b()
            java.lang.String r12 = a((java.lang.String) r12, (java.util.Map<java.lang.String, java.lang.String>) r11)
            android.net.Uri r12 = com.google.android.exoplayer2.g.ad.a(r1, r12)
            int r15 = r2.size()
            java.lang.String r21 = java.lang.Integer.toString(r15)
            r22 = 0
            r24 = 0
            r26 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            java.lang.String r23 = "application/x-mpegURL"
            r27 = r7
            com.google.android.exoplayer2.Format r33 = com.google.android.exoplayer2.Format.a((java.lang.String) r21, (java.lang.String) r22, (java.lang.String) r23, (java.lang.String) r24, (java.lang.String) r25, (com.google.android.exoplayer2.metadata.Metadata) r26, (int) r27, (int) r28, (int) r29, (float) r30, (java.util.List<byte[]>) r31, (int) r32, (int) r33)
            com.google.android.exoplayer2.source.hls.a.d$b r15 = new com.google.android.exoplayer2.source.hls.a.d$b
            r31 = r15
            r32 = r12
            r34 = r9
            r35 = r14
            r36 = r13
            r37 = r10
            r31.<init>(r32, r33, r34, r35, r36, r37)
            r2.add(r15)
            java.lang.Object r15 = r0.get(r12)
            java.util.ArrayList r15 = (java.util.ArrayList) r15
            if (r15 != 0) goto L_0x0195
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r0.put(r12, r15)
        L_0x0195:
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo r12 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo
            r21 = r8
            long r7 = (long) r7
            r31 = r12
            r32 = r7
            r34 = r9
            r35 = r14
            r36 = r13
            r37 = r10
            r31.<init>(r32, r34, r35, r36, r37)
            r15.add(r12)
            r13 = r18
            goto L_0x01b3
        L_0x01af:
            r21 = r8
            r38 = r12
        L_0x01b3:
            r14 = r19
            r7 = r20
            r8 = r21
            r12 = r38
            goto L_0x0036
        L_0x01bd:
            r20 = r7
            r21 = r8
            r38 = r12
            r19 = r14
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.HashSet r8 = new java.util.HashSet
            r8.<init>()
            r9 = 0
        L_0x01d0:
            int r10 = r2.size()
            if (r9 >= r10) goto L_0x023d
            java.lang.Object r10 = r2.get(r9)
            com.google.android.exoplayer2.source.hls.a.d$b r10 = (com.google.android.exoplayer2.source.hls.a.d.b) r10
            android.net.Uri r12 = r10.f33107a
            boolean r12 = r8.add(r12)
            if (r12 == 0) goto L_0x0232
            com.google.android.exoplayer2.Format r12 = r10.f33108b
            com.google.android.exoplayer2.metadata.Metadata r12 = r12.f31067g
            if (r12 != 0) goto L_0x01ec
            r12 = 1
            goto L_0x01ed
        L_0x01ec:
            r12 = 0
        L_0x01ed:
            com.google.android.exoplayer2.g.a.b(r12)
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry r12 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry
            android.net.Uri r14 = r10.f33107a
            java.lang.Object r14 = r0.get(r14)
            java.util.List r14 = (java.util.List) r14
            r15 = 0
            r12.<init>(r15, r15, r14)
            com.google.android.exoplayer2.Format r14 = r10.f33108b
            com.google.android.exoplayer2.metadata.Metadata r15 = new com.google.android.exoplayer2.metadata.Metadata
            r22 = r0
            r39 = r8
            r0 = 1
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r8 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r0]
            r0 = 0
            r8[r0] = r12
            r15.<init>((com.google.android.exoplayer2.metadata.Metadata.Entry[]) r8)
            com.google.android.exoplayer2.Format r25 = r14.a((com.google.android.exoplayer2.metadata.Metadata) r15)
            com.google.android.exoplayer2.source.hls.a.d$b r0 = new com.google.android.exoplayer2.source.hls.a.d$b
            android.net.Uri r8 = r10.f33107a
            java.lang.String r12 = r10.f33109c
            java.lang.String r14 = r10.f33110d
            java.lang.String r15 = r10.f33111e
            java.lang.String r10 = r10.f33112f
            r23 = r0
            r24 = r8
            r26 = r12
            r27 = r14
            r28 = r15
            r29 = r10
            r23.<init>(r24, r25, r26, r27, r28, r29)
            r7.add(r0)
            goto L_0x0236
        L_0x0232:
            r22 = r0
            r39 = r8
        L_0x0236:
            int r9 = r9 + 1
            r8 = r39
            r0 = r22
            goto L_0x01d0
        L_0x023d:
            r0 = 0
            r8 = 0
            r9 = 0
        L_0x0240:
            int r10 = r3.size()
            if (r0 >= r10) goto L_0x0468
            java.lang.Object r10 = r3.get(r0)
            java.lang.String r10 = (java.lang.String) r10
            java.util.regex.Pattern r12 = B
            java.lang.String r12 = a((java.lang.String) r10, (java.util.regex.Pattern) r12, (java.util.Map<java.lang.String, java.lang.String>) r11)
            java.util.regex.Pattern r14 = A
            java.lang.String r14 = a((java.lang.String) r10, (java.util.regex.Pattern) r14, (java.util.Map<java.lang.String, java.lang.String>) r11)
            java.util.regex.Pattern r15 = w
            r35 = r3
            r3 = 0
            java.lang.String r15 = a(r10, r15, r3, r11)
            if (r15 != 0) goto L_0x0265
            r15 = r3
            goto L_0x0269
        L_0x0265:
            android.net.Uri r15 = com.google.android.exoplayer2.g.ad.a(r1, r15)
        L_0x0269:
            java.util.regex.Pattern r1 = z
            java.lang.String r34 = a(r10, r1, r3, r11)
            java.util.regex.Pattern r1 = F
            boolean r1 = c(r10, r1)
            java.util.regex.Pattern r3 = G
            boolean r3 = c(r10, r3)
            if (r3 == 0) goto L_0x027f
            r1 = r1 | 2
        L_0x027f:
            java.util.regex.Pattern r3 = E
            boolean r3 = c(r10, r3)
            if (r3 == 0) goto L_0x0289
            r1 = r1 | 4
        L_0x0289:
            r33 = r1
            java.util.regex.Pattern r1 = C
            r3 = 0
            java.lang.String r1 = a(r10, r1, r3, r11)
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L_0x029c
            r39 = r8
            r1 = 0
            goto L_0x02d2
        L_0x029c:
            java.lang.String r3 = ","
            java.lang.String[] r1 = com.google.android.exoplayer2.g.ae.a((java.lang.String) r1, (java.lang.String) r3)
            java.lang.String r3 = "public.accessibility.describes-video"
            boolean r3 = com.google.android.exoplayer2.g.ae.a((java.lang.Object[]) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x02af
            r3 = 512(0x200, float:7.175E-43)
            r39 = r8
            goto L_0x02b2
        L_0x02af:
            r39 = r8
            r3 = 0
        L_0x02b2:
            java.lang.String r8 = "public.accessibility.transcribes-spoken-dialog"
            boolean r8 = com.google.android.exoplayer2.g.ae.a((java.lang.Object[]) r1, (java.lang.Object) r8)
            if (r8 == 0) goto L_0x02bc
            r3 = r3 | 4096(0x1000, float:5.74E-42)
        L_0x02bc:
            java.lang.String r8 = "public.accessibility.describes-music-and-sound"
            boolean r8 = com.google.android.exoplayer2.g.ae.a((java.lang.Object[]) r1, (java.lang.Object) r8)
            if (r8 == 0) goto L_0x02c6
            r3 = r3 | 1024(0x400, float:1.435E-42)
        L_0x02c6:
            java.lang.String r8 = "public.easy-to-read"
            boolean r1 = com.google.android.exoplayer2.g.ae.a((java.lang.Object[]) r1, (java.lang.Object) r8)
            if (r1 == 0) goto L_0x02d1
            r1 = r3 | 8192(0x2000, float:1.14794E-41)
            goto L_0x02d2
        L_0x02d1:
            r1 = r3
        L_0x02d2:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            java.lang.String r8 = ":"
            r3.append(r8)
            r3.append(r14)
            java.lang.String r22 = r3.toString()
            com.google.android.exoplayer2.metadata.Metadata r3 = new com.google.android.exoplayer2.metadata.Metadata
            r36 = r7
            r8 = 1
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r7 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r8]
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry r8 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry
            r37 = r13
            java.util.List r13 = java.util.Collections.emptyList()
            r8.<init>(r12, r14, r13)
            r13 = 0
            r7[r13] = r8
            r3.<init>((com.google.android.exoplayer2.metadata.Metadata.Entry[]) r7)
            java.util.regex.Pattern r7 = y
            java.lang.String r7 = a((java.lang.String) r10, (java.util.regex.Pattern) r7, (java.util.Map<java.lang.String, java.lang.String>) r11)
            int r8 = r7.hashCode()
            r13 = 2
            switch(r8) {
                case -959297733: goto L_0x032b;
                case -333210994: goto L_0x0321;
                case 62628790: goto L_0x0317;
                case 81665115: goto L_0x030d;
                default: goto L_0x030c;
            }
        L_0x030c:
            goto L_0x0335
        L_0x030d:
            java.lang.String r8 = "VIDEO"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0335
            r7 = 0
            goto L_0x0336
        L_0x0317:
            java.lang.String r8 = "AUDIO"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0335
            r7 = 1
            goto L_0x0336
        L_0x0321:
            java.lang.String r8 = "CLOSED-CAPTIONS"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0335
            r7 = 3
            goto L_0x0336
        L_0x032b:
            java.lang.String r8 = "SUBTITLES"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0335
            r7 = 2
            goto L_0x0336
        L_0x0335:
            r7 = -1
        L_0x0336:
            if (r7 == 0) goto L_0x040a
            r8 = 1
            if (r7 == r8) goto L_0x03a9
            if (r7 == r13) goto L_0x0388
            r8 = 3
            if (r7 == r8) goto L_0x0342
            goto L_0x045a
        L_0x0342:
            java.util.regex.Pattern r3 = D
            java.lang.String r3 = a((java.lang.String) r10, (java.util.regex.Pattern) r3, (java.util.Map<java.lang.String, java.lang.String>) r11)
            java.lang.String r7 = "CC"
            boolean r7 = r3.startsWith(r7)
            if (r7 == 0) goto L_0x035b
            java.lang.String r3 = r3.substring(r13)
            int r3 = java.lang.Integer.parseInt(r3)
            java.lang.String r7 = "application/cea-608"
            goto L_0x0366
        L_0x035b:
            r7 = 7
            java.lang.String r3 = r3.substring(r7)
            int r3 = java.lang.Integer.parseInt(r3)
            java.lang.String r7 = "application/cea-708"
        L_0x0366:
            r31 = r3
            r25 = r7
            if (r9 != 0) goto L_0x0371
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x0371:
            r24 = 0
            r26 = 0
            r27 = -1
            r23 = r14
            r28 = r33
            r29 = r1
            r30 = r34
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            r9.add(r1)
            goto L_0x045a
        L_0x0388:
            r26 = -1
            java.lang.String r24 = "application/x-mpegURL"
            java.lang.String r25 = "text/vtt"
            r23 = r14
            r27 = r33
            r28 = r1
            r29 = r34
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r22, (java.lang.String) r23, (java.lang.String) r24, (java.lang.String) r25, (int) r26, (int) r27, (int) r28, (java.lang.String) r29)
            com.google.android.exoplayer2.Format r1 = r1.a((com.google.android.exoplayer2.metadata.Metadata) r3)
            com.google.android.exoplayer2.source.hls.a.d$a r3 = new com.google.android.exoplayer2.source.hls.a.d$a
            r3.<init>(r15, r1, r12, r14)
            r6.add(r3)
            goto L_0x045a
        L_0x03a9:
            com.google.android.exoplayer2.source.hls.a.d$b r7 = a((java.util.ArrayList<com.google.android.exoplayer2.source.hls.a.d.b>) r2, (java.lang.String) r12)
            if (r7 == 0) goto L_0x03bb
            com.google.android.exoplayer2.Format r7 = r7.f33108b
            java.lang.String r7 = r7.f31066f
            r8 = 1
            java.lang.String r7 = com.google.android.exoplayer2.g.ae.a((java.lang.String) r7, (int) r8)
            r26 = r7
            goto L_0x03be
        L_0x03bb:
            r8 = 1
            r26 = 0
        L_0x03be:
            if (r26 == 0) goto L_0x03c7
            java.lang.String r7 = com.google.android.exoplayer2.g.o.f(r26)
            r25 = r7
            goto L_0x03c9
        L_0x03c7:
            r25 = 0
        L_0x03c9:
            java.util.regex.Pattern r7 = f33137g
            r13 = 0
            java.lang.String r7 = a(r10, r7, r13, r11)
            if (r7 == 0) goto L_0x03e2
            java.lang.String r10 = "/"
            java.lang.String[] r7 = com.google.android.exoplayer2.g.ae.b((java.lang.String) r7, (java.lang.String) r10)
            r10 = 0
            r7 = r7[r10]
            int r7 = java.lang.Integer.parseInt(r7)
            r29 = r7
            goto L_0x03e5
        L_0x03e2:
            r10 = 0
            r29 = -1
        L_0x03e5:
            r27 = 0
            r28 = -1
            r30 = -1
            r31 = 0
            java.lang.String r24 = "application/x-mpegURL"
            r23 = r14
            r32 = r33
            r33 = r1
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r22, (java.lang.String) r23, (java.lang.String) r24, (java.lang.String) r25, (java.lang.String) r26, (com.google.android.exoplayer2.metadata.Metadata) r27, (int) r28, (int) r29, (int) r30, (java.util.List<byte[]>) r31, (int) r32, (int) r33, (java.lang.String) r34)
            if (r15 != 0) goto L_0x03fd
            r8 = r1
            goto L_0x045c
        L_0x03fd:
            com.google.android.exoplayer2.source.hls.a.d$a r7 = new com.google.android.exoplayer2.source.hls.a.d$a
            com.google.android.exoplayer2.Format r1 = r1.a((com.google.android.exoplayer2.metadata.Metadata) r3)
            r7.<init>(r15, r1, r12, r14)
            r5.add(r7)
            goto L_0x045a
        L_0x040a:
            r8 = 1
            r10 = 0
            com.google.android.exoplayer2.source.hls.a.d$b r7 = b((java.util.ArrayList<com.google.android.exoplayer2.source.hls.a.d.b>) r2, (java.lang.String) r12)
            if (r7 == 0) goto L_0x0429
            com.google.android.exoplayer2.Format r7 = r7.f33108b
            java.lang.String r8 = r7.f31066f
            java.lang.String r8 = com.google.android.exoplayer2.g.ae.a((java.lang.String) r8, (int) r13)
            int r13 = r7.n
            int r10 = r7.o
            float r7 = r7.p
            r31 = r7
            r26 = r8
            r30 = r10
            r29 = r13
            goto L_0x0431
        L_0x0429:
            r26 = 0
            r29 = -1
            r30 = -1
            r31 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0431:
            if (r26 == 0) goto L_0x043a
            java.lang.String r10 = com.google.android.exoplayer2.g.o.f(r26)
            r25 = r10
            goto L_0x043c
        L_0x043a:
            r25 = 0
        L_0x043c:
            r27 = 0
            r28 = -1
            r32 = 0
            java.lang.String r24 = "application/x-mpegURL"
            r23 = r14
            r34 = r1
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r22, (java.lang.String) r23, (java.lang.String) r24, (java.lang.String) r25, (java.lang.String) r26, (com.google.android.exoplayer2.metadata.Metadata) r27, (int) r28, (int) r29, (int) r30, (float) r31, (java.util.List<byte[]>) r32, (int) r33, (int) r34)
            com.google.android.exoplayer2.Format r1 = r1.a((com.google.android.exoplayer2.metadata.Metadata) r3)
            if (r15 == 0) goto L_0x045a
            com.google.android.exoplayer2.source.hls.a.d$a r3 = new com.google.android.exoplayer2.source.hls.a.d$a
            r3.<init>(r15, r1, r12, r14)
            r4.add(r3)
        L_0x045a:
            r8 = r39
        L_0x045c:
            int r0 = r0 + 1
            r1 = r40
            r3 = r35
            r7 = r36
            r13 = r37
            goto L_0x0240
        L_0x0468:
            r36 = r7
            r39 = r8
            r37 = r13
            if (r37 == 0) goto L_0x0475
            java.util.List r0 = java.util.Collections.emptyList()
            r9 = r0
        L_0x0475:
            com.google.android.exoplayer2.source.hls.a.d r13 = new com.google.android.exoplayer2.source.hls.a.d
            r0 = r13
            r1 = r40
            r2 = r21
            r3 = r36
            r7 = r20
            r8 = r39
            r10 = r19
            r12 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.a.g.a(com.google.android.exoplayer2.source.hls.a.g$a, java.lang.String):com.google.android.exoplayer2.source.hls.a.d");
    }

    private static d.b a(ArrayList<d.b> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.b bVar = arrayList.get(i2);
            if (str.equals(bVar.f33110d)) {
                return bVar;
            }
        }
        return null;
    }

    private static d.b b(ArrayList<d.b> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.b bVar = arrayList.get(i2);
            if (str.equals(bVar.f33109c)) {
                return bVar;
            }
        }
        return null;
    }

    private static e a(d dVar, a aVar, String str) throws IOException {
        boolean z2;
        String str2;
        TreeMap treeMap;
        DrmInitData drmInitData;
        DrmInitData drmInitData2;
        long j2;
        long j3;
        d dVar2 = dVar;
        boolean z3 = dVar2.p;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        TreeMap treeMap2 = new TreeMap();
        String str3 = "";
        String str4 = null;
        boolean z4 = z3;
        long j4 = -9223372036854775807L;
        long j5 = -9223372036854775807L;
        String str5 = str3;
        String str6 = null;
        String str7 = null;
        DrmInitData drmInitData3 = null;
        DrmInitData drmInitData4 = null;
        String str8 = null;
        e.a aVar2 = null;
        boolean z5 = false;
        int i2 = 0;
        int i3 = 0;
        long j6 = 0;
        int i4 = 0;
        long j7 = 0;
        int i5 = 1;
        boolean z6 = false;
        long j8 = 0;
        long j9 = 0;
        boolean z7 = false;
        long j10 = -1;
        long j11 = 0;
        long j12 = 0;
        while (aVar.a()) {
            String b2 = aVar.b();
            if (b2.startsWith("#EXT")) {
                arrayList2.add(b2);
            }
            if (b2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String a2 = a(b2, m, (Map<String, String>) hashMap);
                if ("VOD".equals(a2)) {
                    i2 = 1;
                } else if ("EVENT".equals(a2)) {
                    i2 = 2;
                }
            } else if (b2.startsWith("#EXT-X-START")) {
                j4 = (long) (b(b2, q) * 1000000.0d);
            } else if (b2.startsWith("#EXT-X-MAP")) {
                String a3 = a(b2, w, (Map<String, String>) hashMap);
                String a4 = a(b2, s, str4, hashMap);
                if (a4 != null) {
                    String[] split = a4.split("@");
                    long parseLong = Long.parseLong(split[0]);
                    if (split.length > 1) {
                        j8 = Long.parseLong(split[1]);
                    }
                    j2 = parseLong;
                    j3 = j8;
                } else {
                    j3 = j8;
                    j2 = j10;
                }
                if (str6 == null || str8 != null) {
                    aVar2 = new e.a(a3, j3, j2, str6, str8);
                    j8 = 0;
                    j10 = -1;
                } else {
                    throw new v("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.");
                }
            } else if (b2.startsWith("#EXT-X-TARGETDURATION")) {
                j5 = 1000000 * ((long) a(b2, k));
            } else if (b2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                j9 = Long.parseLong(a(b2, n, (Map<String, String>) Collections.emptyMap()));
                j7 = j9;
            } else if (b2.startsWith("#EXT-X-VERSION")) {
                i5 = a(b2, l);
            } else {
                if (b2.startsWith("#EXT-X-DEFINE")) {
                    String a5 = a(b2, I, str4, hashMap);
                    if (a5 != null) {
                        String str9 = dVar2.j.get(a5);
                        if (str9 != null) {
                            hashMap.put(a5, str9);
                        }
                    } else {
                        hashMap.put(a(b2, A, (Map<String, String>) hashMap), a(b2, H, (Map<String, String>) hashMap));
                    }
                } else if (b2.startsWith("#EXTINF")) {
                    str5 = a(b2, p, str3, hashMap);
                    j12 = (long) (b(b2, o) * 1000000.0d);
                } else if (b2.startsWith("#EXT-X-KEY")) {
                    String a6 = a(b2, t, (Map<String, String>) hashMap);
                    String a7 = a(b2, u, "identity", hashMap);
                    if (SDKConstants.NATIVE_SDK_NONE.equals(a6)) {
                        treeMap2.clear();
                        str6 = str4;
                        drmInitData4 = str6;
                        str8 = drmInitData4;
                    } else {
                        str8 = a(b2, x, str4, hashMap);
                        if (!"identity".equals(a7)) {
                            if (str7 == null) {
                                str7 = a(a6);
                            }
                            DrmInitData.SchemeData a8 = a(b2, a7, (Map<String, String>) hashMap);
                            if (a8 != null) {
                                treeMap2.put(a7, a8);
                                drmInitData4 = str4;
                            }
                        } else if ("AES-128".equals(a6)) {
                            str6 = a(b2, w, (Map<String, String>) hashMap);
                        }
                        str6 = str4;
                    }
                } else if (b2.startsWith("#EXT-X-BYTERANGE")) {
                    String[] split2 = a(b2, r, (Map<String, String>) hashMap).split("@");
                    j10 = Long.parseLong(split2[0]);
                    if (split2.length > 1) {
                        j8 = Long.parseLong(split2[1]);
                    }
                } else if (b2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                    i4 = Integer.parseInt(b2.substring(b2.indexOf(58) + 1));
                    z5 = true;
                } else if (b2.equals("#EXT-X-DISCONTINUITY")) {
                    i3++;
                } else if (b2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                    if (j6 == 0) {
                        j6 = c.b(ae.g(b2.substring(b2.indexOf(58) + 1))) - j11;
                    }
                } else if (b2.equals("#EXT-X-GAP")) {
                    z7 = true;
                } else if (b2.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                    z4 = true;
                } else if (b2.equals("#EXT-X-ENDLIST")) {
                    z6 = true;
                } else if (!b2.startsWith("#")) {
                    String hexString = str6 == null ? str4 : str8 != null ? str8 : Long.toHexString(j9);
                    long j13 = j9 + 1;
                    int i6 = (j10 > -1 ? 1 : (j10 == -1 ? 0 : -1));
                    long j14 = i6 == 0 ? 0 : j8;
                    if (drmInitData4 != null || treeMap2.isEmpty()) {
                        z2 = z5;
                        treeMap = treeMap2;
                        str2 = str3;
                        drmInitData = drmInitData4;
                    } else {
                        DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap2.values().toArray(new DrmInitData.SchemeData[0]);
                        DrmInitData drmInitData5 = new DrmInitData(str7, schemeDataArr);
                        if (drmInitData3 == null) {
                            DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
                            treeMap = treeMap2;
                            str2 = str3;
                            int i7 = 0;
                            while (i7 < schemeDataArr.length) {
                                DrmInitData.SchemeData schemeData = schemeDataArr[i7];
                                schemeDataArr2[i7] = new DrmInitData.SchemeData(schemeData.f31357a, schemeData.f31358b, schemeData.f31359c, (byte[]) null, schemeData.f31361e);
                                i7++;
                                schemeDataArr = schemeDataArr;
                                drmInitData5 = drmInitData5;
                                z5 = z5;
                            }
                            z2 = z5;
                            drmInitData2 = drmInitData5;
                            drmInitData3 = new DrmInitData(str7, schemeDataArr2);
                        } else {
                            z2 = z5;
                            treeMap = treeMap2;
                            str2 = str3;
                            drmInitData2 = drmInitData5;
                        }
                        drmInitData = drmInitData2;
                    }
                    arrayList.add(new e.a(a(b2, (Map<String, String>) hashMap), aVar2, str5, j12, i3, j11, drmInitData, str6, hexString, j14, j10, z7));
                    j11 += j12;
                    if (i6 != 0) {
                        j14 += j10;
                    }
                    j8 = j14;
                    str4 = null;
                    drmInitData4 = drmInitData;
                    j10 = -1;
                    j9 = j13;
                    treeMap2 = treeMap;
                    str3 = str2;
                    str5 = str3;
                    z5 = z2;
                    z7 = false;
                    j12 = 0;
                    dVar2 = dVar;
                }
                str4 = null;
                dVar2 = dVar;
                treeMap2 = treeMap2;
                str3 = str3;
                z5 = z5;
            }
        }
        return new e(i2, str, arrayList2, j4, j6, z5, i4, j7, i5, j5, z4, z6, j6 != 0, drmInitData3, arrayList);
    }

    private static DrmInitData.SchemeData a(String str, String str2, Map<String, String> map) throws v {
        String a2 = a(str, v, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String a3 = a(str, w, map);
            return new DrmInitData.SchemeData(c.f31287d, "video/mp4", Base64.decode(a3.substring(a3.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(c.f31287d, "hls", ae.c(str));
        } else {
            if (!"com.microsoft.playready".equals(str2) || !"1".equals(a2)) {
                return null;
            }
            String a4 = a(str, w, map);
            return new DrmInitData.SchemeData(c.f31288e, "video/mp4", h.a(c.f31288e, (UUID[]) null, Base64.decode(a4.substring(a4.indexOf(44)), 0)));
        }
    }

    private static String a(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    private static int a(String str, Pattern pattern) throws v {
        return Integer.parseInt(a(str, pattern, (Map<String, String>) Collections.emptyMap()));
    }

    private static double b(String str, Pattern pattern) throws v {
        return Double.parseDouble(a(str, pattern, (Map<String, String>) Collections.emptyMap()));
    }

    private static String a(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
        }
        return (map.isEmpty() || str2 == null) ? str2 : a(str2, map);
    }

    private static String a(String str, Map<String, String> map) {
        Matcher matcher = J.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static boolean c(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1).equals(H5Param.DEFAULT_LONG_PRESSO_LOGIN);
        }
        return false;
    }

    private static Pattern b(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final BufferedReader f33140a;

        /* renamed from: b  reason: collision with root package name */
        private final Queue<String> f33141b;

        /* renamed from: c  reason: collision with root package name */
        private String f33142c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.f33141b = queue;
            this.f33140a = bufferedReader;
        }

        public final boolean a() throws IOException {
            if (this.f33142c != null) {
                return true;
            }
            if (!this.f33141b.isEmpty()) {
                this.f33142c = this.f33141b.poll();
                return true;
            }
            do {
                String readLine = this.f33140a.readLine();
                this.f33142c = readLine;
                if (readLine == null) {
                    return false;
                }
                this.f33142c = this.f33142c.trim();
            } while (this.f33142c.isEmpty());
            return true;
        }

        public final String b() throws IOException {
            if (!a()) {
                return null;
            }
            String str = this.f33142c;
            this.f33142c = null;
            return str;
        }
    }

    private static String a(String str, Pattern pattern, Map<String, String> map) throws v {
        String a2 = a(str, pattern, (String) null, map);
        if (a2 != null) {
            return a2;
        }
        throw new v("Couldn't match " + pattern.pattern() + " in " + str);
    }
}
