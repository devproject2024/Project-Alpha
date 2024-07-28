package com.google.android.exoplayer2.d;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f31339a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<a, List<a>> f31340b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f31341c;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f31342d;

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, Integer> f31343e;

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, Integer> f31344f;

    /* renamed from: g  reason: collision with root package name */
    private static final Map<String, Integer> f31345g;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f31346h;

    /* renamed from: i  reason: collision with root package name */
    private static int f31347i = -1;

    interface c {
        int a();

        MediaCodecInfo a(int i2);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();
    }

    public static class b extends Exception {
        private b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f31341c = sparseIntArray;
        sparseIntArray.put(66, 1);
        f31341c.put(77, 2);
        f31341c.put(88, 4);
        f31341c.put(100, 8);
        f31341c.put(110, 16);
        f31341c.put(122, 32);
        f31341c.put(244, 64);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f31342d = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        f31342d.put(11, 4);
        f31342d.put(12, 8);
        f31342d.put(13, 16);
        f31342d.put(20, 32);
        f31342d.put(21, 64);
        f31342d.put(22, 128);
        SparseIntArray sparseIntArray3 = f31342d;
        Integer valueOf = Integer.valueOf(UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
        sparseIntArray3.put(30, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
        f31342d.put(31, 512);
        f31342d.put(32, TarConstants.EOF_BLOCK);
        f31342d.put(40, EmiUtil.EMI_PLAN_REQUEST_CODE);
        f31342d.put(41, 4096);
        f31342d.put(42, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        f31342d.put(50, 16384);
        f31342d.put(51, 32768);
        f31342d.put(52, 65536);
        HashMap hashMap = new HashMap();
        f31343e = hashMap;
        hashMap.put("L30", 1);
        f31343e.put("L60", 4);
        f31343e.put("L63", 16);
        f31343e.put("L90", 64);
        f31343e.put("L93", valueOf);
        f31343e.put("L120", Integer.valueOf(TarConstants.EOF_BLOCK));
        f31343e.put("L123", 4096);
        f31343e.put("L150", 16384);
        f31343e.put("L153", 65536);
        f31343e.put("L156", 262144);
        f31343e.put("L180", 1048576);
        f31343e.put("L183", 4194304);
        f31343e.put("L186", 16777216);
        f31343e.put("H30", 2);
        f31343e.put("H60", 8);
        f31343e.put("H63", 32);
        f31343e.put("H90", 128);
        f31343e.put("H93", 512);
        f31343e.put("H120", Integer.valueOf(EmiUtil.EMI_PLAN_REQUEST_CODE));
        f31343e.put("H123", Integer.valueOf(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE));
        f31343e.put("H150", 32768);
        f31343e.put("H153", 131072);
        f31343e.put("H156", 524288);
        f31343e.put("H180", 2097152);
        f31343e.put("H183", 8388608);
        f31343e.put("H186", 33554432);
        HashMap hashMap2 = new HashMap();
        f31344f = hashMap2;
        hashMap2.put("00", 1);
        f31344f.put(WebLogin.RESPONSE_CODE_SUCCESS, 2);
        f31344f.put("02", 4);
        f31344f.put("03", 8);
        f31344f.put("04", 16);
        f31344f.put("05", 32);
        f31344f.put("06", 64);
        f31344f.put("07", 128);
        f31344f.put("08", valueOf);
        f31344f.put("09", 512);
        HashMap hashMap3 = new HashMap();
        f31345g = hashMap3;
        hashMap3.put(WebLogin.RESPONSE_CODE_SUCCESS, 1);
        f31345g.put("02", 2);
        f31345g.put("03", 4);
        f31345g.put("04", 8);
        f31345g.put("05", 16);
        f31345g.put("06", 32);
        f31345g.put("07", 64);
        f31345g.put("08", 128);
        f31345g.put("09", valueOf);
        SparseIntArray sparseIntArray4 = new SparseIntArray();
        f31346h = sparseIntArray4;
        sparseIntArray4.put(1, 1);
        f31346h.put(2, 2);
        f31346h.put(3, 3);
        f31346h.put(4, 4);
        f31346h.put(5, 5);
        f31346h.put(6, 6);
        f31346h.put(17, 17);
        f31346h.put(20, 20);
        f31346h.put(23, 23);
        f31346h.put(29, 29);
        f31346h.put(39, 39);
        f31346h.put(42, 42);
    }

    public static a a() throws b {
        a b2 = b("audio/raw");
        if (b2 == null) {
            return null;
        }
        return new a(b2.f31326a, (String) null, (String) null, (MediaCodecInfo.CodecCapabilities) null, true, false, false);
    }

    private static a b(String str) throws b {
        List<a> a2 = a(str, false, false);
        if (a2.isEmpty()) {
            return null;
        }
        return a2.get(0);
    }

    public static synchronized List<a> a(String str, boolean z, boolean z2) throws b {
        synchronized (d.class) {
            a aVar = new a(str, z, z2);
            List<a> list = f31340b.get(aVar);
            if (list != null) {
                return list;
            }
            ArrayList<a> a2 = a(aVar, ae.f32499a >= 21 ? new e(z, z2) : new C0531d((byte) 0));
            if (z && a2.isEmpty() && 21 <= ae.f32499a && ae.f32499a <= 23) {
                a2 = a(aVar, (c) new C0531d((byte) 0));
                if (!a2.isEmpty()) {
                    StringBuilder sb = new StringBuilder("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(a2.get(0).f31326a);
                    l.c();
                }
            }
            if ("audio/raw".equals(str)) {
                Collections.sort(a2, new g((byte) 0));
            } else if (ae.f32499a < 21 && a2.size() > 1) {
                String str2 = a2.get(0).f31326a;
                if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                    Collections.sort(a2, new f((byte) 0));
                }
            }
            List<a> unmodifiableList = Collections.unmodifiableList(a2);
            f31340b.put(aVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static int b() throws b {
        int i2;
        if (f31347i == -1) {
            a b2 = b("video/avc");
            int i3 = 0;
            if (b2 != null) {
                MediaCodecInfo.CodecProfileLevel[] a2 = b2.a();
                int length = a2.length;
                int i4 = 0;
                while (i3 < length) {
                    int i5 = a2[i3].level;
                    if (i5 != 1 && i5 != 2) {
                        switch (i5) {
                            case 8:
                            case 16:
                            case 32:
                                i2 = 101376;
                                break;
                            case 64:
                                i2 = 202752;
                                break;
                            case 128:
                            case UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS /*256*/:
                                i2 = 414720;
                                break;
                            case 512:
                                i2 = 921600;
                                break;
                            case TarConstants.EOF_BLOCK:
                                i2 = 1310720;
                                break;
                            case EmiUtil.EMI_PLAN_REQUEST_CODE /*2048*/:
                            case 4096:
                                i2 = 2097152;
                                break;
                            case FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE /*8192*/:
                                i2 = 2228224;
                                break;
                            case 16384:
                                i2 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i2 = 9437184;
                                break;
                            default:
                                i2 = -1;
                                break;
                        }
                    } else {
                        i2 = 25344;
                    }
                    i4 = Math.max(i2, i4);
                    i3++;
                }
                i3 = Math.max(i4, ae.f32499a >= 21 ? 345600 : 172800);
            }
            f31347i = i3;
        }
        return f31347i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005c, code lost:
        if (r3.equals("avc1") != false) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> a(java.lang.String r10) {
        /*
            r0 = 0
            if (r10 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "\\."
            java.lang.String[] r1 = r10.split(r1)
            r2 = 0
            r3 = r1[r2]
            r4 = -1
            int r5 = r3.hashCode()
            r6 = 4
            r7 = 2
            r8 = 3
            r9 = 1
            switch(r5) {
                case 3006243: goto L_0x0056;
                case 3006244: goto L_0x004c;
                case 3095771: goto L_0x0042;
                case 3095823: goto L_0x0038;
                case 3199032: goto L_0x002e;
                case 3214780: goto L_0x0024;
                case 3356560: goto L_0x001a;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x005f
        L_0x001a:
            java.lang.String r2 = "mp4a"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x005f
            r2 = 6
            goto L_0x0060
        L_0x0024:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x005f
            r2 = 3
            goto L_0x0060
        L_0x002e:
            java.lang.String r2 = "hev1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x005f
            r2 = 2
            goto L_0x0060
        L_0x0038:
            java.lang.String r2 = "dvhe"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x005f
            r2 = 4
            goto L_0x0060
        L_0x0042:
            java.lang.String r2 = "dvh1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x005f
            r2 = 5
            goto L_0x0060
        L_0x004c:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x005f
            r2 = 1
            goto L_0x0060
        L_0x0056:
            java.lang.String r5 = "avc1"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r2 = -1
        L_0x0060:
            switch(r2) {
                case 0: goto L_0x013b;
                case 1: goto L_0x013b;
                case 2: goto L_0x00cc;
                case 3: goto L_0x00cc;
                case 4: goto L_0x0069;
                case 5: goto L_0x0069;
                case 6: goto L_0x0064;
                default: goto L_0x0063;
            }
        L_0x0063:
            return r0
        L_0x0064:
            android.util.Pair r10 = b(r10, r1)
            return r10
        L_0x0069:
            int r2 = r1.length
            java.lang.String r3 = "Ignoring malformed Dolby Vision codec string: "
            if (r2 >= r8) goto L_0x0079
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r3.concat(r10)
            com.google.android.exoplayer2.g.l.c()
            return r0
        L_0x0079:
            java.util.regex.Pattern r2 = f31339a
            r4 = r1[r9]
            java.util.regex.Matcher r2 = r2.matcher(r4)
            boolean r4 = r2.matches()
            if (r4 != 0) goto L_0x0092
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r3.concat(r10)
            com.google.android.exoplayer2.g.l.c()
            return r0
        L_0x0092:
            java.lang.String r10 = r2.group(r9)
            java.util.Map<java.lang.String, java.lang.Integer> r2 = f31344f
            java.lang.Object r2 = r2.get(r10)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 != 0) goto L_0x00ad
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r1 = "Unknown Dolby Vision profile string: "
            r1.concat(r10)
            com.google.android.exoplayer2.g.l.c()
            return r0
        L_0x00ad:
            r10 = r1[r7]
            java.util.Map<java.lang.String, java.lang.Integer> r1 = f31345g
            java.lang.Object r1 = r1.get(r10)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 != 0) goto L_0x00c6
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r1 = "Unknown Dolby Vision level string: "
            r1.concat(r10)
            com.google.android.exoplayer2.g.l.c()
            return r0
        L_0x00c6:
            android.util.Pair r10 = new android.util.Pair
            r10.<init>(r2, r1)
            return r10
        L_0x00cc:
            int r2 = r1.length
            java.lang.String r3 = "Ignoring malformed HEVC codec string: "
            if (r2 >= r6) goto L_0x00dc
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r3.concat(r10)
            com.google.android.exoplayer2.g.l.c()
            return r0
        L_0x00dc:
            java.util.regex.Pattern r2 = f31339a
            r4 = r1[r9]
            java.util.regex.Matcher r2 = r2.matcher(r4)
            boolean r4 = r2.matches()
            if (r4 != 0) goto L_0x00f5
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r3.concat(r10)
            com.google.android.exoplayer2.g.l.c()
            return r0
        L_0x00f5:
            java.lang.String r10 = r2.group(r9)
            java.lang.String r2 = "1"
            boolean r2 = r2.equals(r10)
            if (r2 == 0) goto L_0x0103
            r7 = 1
            goto L_0x010b
        L_0x0103:
            java.lang.String r2 = "2"
            boolean r2 = r2.equals(r10)
            if (r2 == 0) goto L_0x012e
        L_0x010b:
            r10 = r1[r8]
            java.util.Map<java.lang.String, java.lang.Integer> r1 = f31343e
            java.lang.Object r1 = r1.get(r10)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 != 0) goto L_0x0124
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r1 = "Unknown HEVC level string: "
            r1.concat(r10)
            com.google.android.exoplayer2.g.l.c()
            return r0
        L_0x0124:
            android.util.Pair r10 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            r10.<init>(r0, r1)
            return r10
        L_0x012e:
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r1 = "Unknown HEVC profile string: "
            r1.concat(r10)
            com.google.android.exoplayer2.g.l.c()
            return r0
        L_0x013b:
            android.util.Pair r10 = a((java.lang.String) r10, (java.lang.String[]) r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.d.d.a(java.lang.String):android.util.Pair");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e9 A[Catch:{ Exception -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00fc A[Catch:{ Exception -> 0x0120 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<com.google.android.exoplayer2.d.a> a(com.google.android.exoplayer2.d.d.a r20, com.google.android.exoplayer2.d.d.c r21) throws com.google.android.exoplayer2.d.d.b {
        /*
            r1 = r20
            r2 = r21
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0120 }
            r5.<init>()     // Catch:{ Exception -> 0x0120 }
            java.lang.String r12 = r1.f31348a     // Catch:{ Exception -> 0x0120 }
            int r13 = r21.a()     // Catch:{ Exception -> 0x0120 }
            boolean r14 = r21.b()     // Catch:{ Exception -> 0x0120 }
            r11 = 0
        L_0x0018:
            if (r11 >= r13) goto L_0x011f
            android.media.MediaCodecInfo r0 = r2.a(r11)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r10 = r0.getName()     // Catch:{ Exception -> 0x0120 }
            java.lang.String r9 = a(r0, r10, r14, r12)     // Catch:{ Exception -> 0x0120 }
            if (r9 == 0) goto L_0x0119
            android.media.MediaCodecInfo$CodecCapabilities r0 = r0.getCapabilitiesForType(r9)     // Catch:{ Exception -> 0x00d7 }
            boolean r6 = r2.a(r4, r9, r0)     // Catch:{ Exception -> 0x00d7 }
            boolean r7 = r2.a(r4, r0)     // Catch:{ Exception -> 0x00d7 }
            boolean r8 = r1.f31350c     // Catch:{ Exception -> 0x00d7 }
            if (r8 != 0) goto L_0x003a
            if (r7 != 0) goto L_0x0119
        L_0x003a:
            boolean r7 = r1.f31350c     // Catch:{ Exception -> 0x00d7 }
            if (r7 == 0) goto L_0x0042
            if (r6 != 0) goto L_0x0042
            goto L_0x0119
        L_0x0042:
            boolean r6 = r2.a(r3, r9, r0)     // Catch:{ Exception -> 0x00d7 }
            boolean r7 = r2.a(r3, r0)     // Catch:{ Exception -> 0x00d7 }
            boolean r8 = r1.f31349b     // Catch:{ Exception -> 0x00d7 }
            if (r8 != 0) goto L_0x0050
            if (r7 != 0) goto L_0x0119
        L_0x0050:
            boolean r7 = r1.f31349b     // Catch:{ Exception -> 0x00d7 }
            if (r7 == 0) goto L_0x0058
            if (r6 != 0) goto L_0x0058
            goto L_0x0119
        L_0x0058:
            int r7 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x00d7 }
            r8 = 22
            if (r7 > r8) goto L_0x0086
            java.lang.String r7 = "ODROID-XU3"
            java.lang.String r8 = com.google.android.exoplayer2.g.ae.f32502d     // Catch:{ Exception -> 0x00d7 }
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x00d7 }
            if (r7 != 0) goto L_0x0072
            java.lang.String r7 = "Nexus 10"
            java.lang.String r8 = com.google.android.exoplayer2.g.ae.f32502d     // Catch:{ Exception -> 0x00d7 }
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x00d7 }
            if (r7 == 0) goto L_0x0086
        L_0x0072:
            java.lang.String r7 = "OMX.Exynos.AVC.Decoder"
            boolean r7 = r7.equals(r10)     // Catch:{ Exception -> 0x00d7 }
            if (r7 != 0) goto L_0x0082
            java.lang.String r7 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r7 = r7.equals(r10)     // Catch:{ Exception -> 0x00d7 }
            if (r7 == 0) goto L_0x0086
        L_0x0082:
            r7 = 1
            r16 = 1
            goto L_0x0088
        L_0x0086:
            r16 = 0
        L_0x0088:
            if (r14 == 0) goto L_0x008e
            boolean r7 = r1.f31349b     // Catch:{ Exception -> 0x00d7 }
            if (r7 == r6) goto L_0x0094
        L_0x008e:
            if (r14 != 0) goto L_0x00ae
            boolean r7 = r1.f31349b     // Catch:{ Exception -> 0x00d7 }
            if (r7 != 0) goto L_0x00ae
        L_0x0094:
            r17 = 0
            r6 = r10
            r7 = r12
            r8 = r9
            r18 = r9
            r9 = r0
            r15 = r10
            r10 = r16
            r19 = r11
            r11 = r17
            com.google.android.exoplayer2.d.a r0 = com.google.android.exoplayer2.d.a.a(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00ac }
            r5.add(r0)     // Catch:{ Exception -> 0x00ac }
            goto L_0x011b
        L_0x00ac:
            r0 = move-exception
            goto L_0x00dd
        L_0x00ae:
            r18 = r9
            r15 = r10
            r19 = r11
            if (r14 != 0) goto L_0x011b
            if (r6 == 0) goto L_0x011b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ac }
            r6.<init>()     // Catch:{ Exception -> 0x00ac }
            r6.append(r15)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r7 = ".secure"
            r6.append(r7)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00ac }
            r11 = 1
            r7 = r12
            r8 = r18
            r9 = r0
            r10 = r16
            com.google.android.exoplayer2.d.a r0 = com.google.android.exoplayer2.d.a.a(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00ac }
            r5.add(r0)     // Catch:{ Exception -> 0x00ac }
            return r5
        L_0x00d7:
            r0 = move-exception
            r18 = r9
            r15 = r10
            r19 = r11
        L_0x00dd:
            int r6 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ Exception -> 0x0120 }
            r7 = 23
            if (r6 > r7) goto L_0x00fc
            boolean r6 = r5.isEmpty()     // Catch:{ Exception -> 0x0120 }
            if (r6 != 0) goto L_0x00fc
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0120 }
            java.lang.String r6 = "Skipping codec "
            r0.<init>(r6)     // Catch:{ Exception -> 0x0120 }
            r0.append(r15)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r6 = " (failed to query capabilities)"
            r0.append(r6)     // Catch:{ Exception -> 0x0120 }
            com.google.android.exoplayer2.g.l.d()     // Catch:{ Exception -> 0x0120 }
            goto L_0x011b
        L_0x00fc:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0120 }
            java.lang.String r2 = "Failed to query codec "
            r1.<init>(r2)     // Catch:{ Exception -> 0x0120 }
            r1.append(r15)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r2 = " ("
            r1.append(r2)     // Catch:{ Exception -> 0x0120 }
            r2 = r18
            r1.append(r2)     // Catch:{ Exception -> 0x0120 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ Exception -> 0x0120 }
            com.google.android.exoplayer2.g.l.d()     // Catch:{ Exception -> 0x0120 }
            throw r0     // Catch:{ Exception -> 0x0120 }
        L_0x0119:
            r19 = r11
        L_0x011b:
            int r11 = r19 + 1
            goto L_0x0018
        L_0x011f:
            return r5
        L_0x0120:
            r0 = move-exception
            com.google.android.exoplayer2.d.d$b r1 = new com.google.android.exoplayer2.d.d$b
            r2 = 0
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.d.d.a(com.google.android.exoplayer2.d.d$a, com.google.android.exoplayer2.d.d$c):java.util.ArrayList");
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        int i2;
        int i3;
        if (strArr.length < 2) {
            "Ignoring malformed AVC codec string: ".concat(String.valueOf(str));
            l.c();
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                int parseInt = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i2 = Integer.parseInt(strArr[1].substring(4), 16);
                i3 = parseInt;
            } else if (strArr.length >= 3) {
                i3 = Integer.parseInt(strArr[1]);
                i2 = Integer.parseInt(strArr[2]);
            } else {
                "Ignoring malformed AVC codec string: ".concat(String.valueOf(str));
                l.c();
                return null;
            }
            int i4 = f31341c.get(i3, -1);
            if (i4 == -1) {
                "Unknown AVC profile: ".concat(String.valueOf(i3));
                l.c();
                return null;
            }
            int i5 = f31342d.get(i2, -1);
            if (i5 != -1) {
                return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i5));
            }
            "Unknown AVC level: ".concat(String.valueOf(i2));
            l.c();
            return null;
        } catch (NumberFormatException unused) {
            "Ignoring malformed AVC codec string: ".concat(String.valueOf(str));
            l.c();
            return null;
        }
    }

    private static Pair<Integer, Integer> b(String str, String[] strArr) {
        int i2;
        if (strArr.length != 3) {
            "Ignoring malformed MP4A codec string: ".concat(String.valueOf(str));
            l.c();
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(o.a(Integer.parseInt(strArr[1], 16))) && (i2 = f31346h.get(Integer.parseInt(strArr[2]), -1)) != -1) {
                return new Pair<>(Integer.valueOf(i2), 0);
            }
        } catch (NumberFormatException unused) {
            "Ignoring malformed MP4A codec string: ".concat(String.valueOf(str));
            l.c();
        }
        return null;
    }

    static final class e implements c {

        /* renamed from: a  reason: collision with root package name */
        private final int f31351a;

        /* renamed from: b  reason: collision with root package name */
        private MediaCodecInfo[] f31352b;

        public final boolean b() {
            return true;
        }

        public e(boolean z, boolean z2) {
            this.f31351a = (z || z2) ? 1 : 0;
        }

        public final int a() {
            c();
            return this.f31352b.length;
        }

        public final MediaCodecInfo a(int i2) {
            c();
            return this.f31352b[i2];
        }

        public final boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        private void c() {
            if (this.f31352b == null) {
                this.f31352b = new MediaCodecList(this.f31351a).getCodecInfos();
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.d.d$d  reason: collision with other inner class name */
    static final class C0531d implements c {
        public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        public final boolean b() {
            return false;
        }

        private C0531d() {
        }

        /* synthetic */ C0531d(byte b2) {
            this();
        }

        public final int a() {
            return MediaCodecList.getCodecCount();
        }

        public final MediaCodecInfo a(int i2) {
            return MediaCodecList.getCodecInfoAt(i2);
        }

        public final boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f31348a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f31349b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f31350c;

        public a(String str, boolean z, boolean z2) {
            this.f31348a = str;
            this.f31349b = z;
            this.f31350c = z2;
        }

        public final int hashCode() {
            String str = this.f31348a;
            int i2 = 1231;
            int hashCode = ((((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f31349b ? 1231 : 1237)) * 31;
            if (!this.f31350c) {
                i2 = 1237;
            }
            return hashCode + i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == a.class) {
                a aVar = (a) obj;
                return TextUtils.equals(this.f31348a, aVar.f31348a) && this.f31349b == aVar.f31349b && this.f31350c == aVar.f31350c;
            }
        }
    }

    static final class g implements Comparator<a> {
        private g() {
        }

        /* synthetic */ g(byte b2) {
            this();
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return a((a) obj) - a((a) obj2);
        }

        private static int a(a aVar) {
            String str = aVar.f31326a;
            if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
                return -1;
            }
            return (ae.f32499a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : 1;
        }
    }

    static final class f implements Comparator<a> {
        private f() {
        }

        /* synthetic */ f(byte b2) {
            this();
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return a((a) obj) - a((a) obj2);
        }

        private static int a(a aVar) {
            return aVar.f31326a.startsWith("OMX.google") ? -1 : 0;
        }
    }

    private static String a(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (!(!mediaCodecInfo.isEncoder() && (z || !str.endsWith(".secure")) && ((ae.f32499a >= 21 || (!"CIPAACDecoder".equals(str) && !"CIPMP3Decoder".equals(str) && !"CIPVorbisDecoder".equals(str) && !"CIPAMRNBDecoder".equals(str) && !"AACDecoder".equals(str) && !"MP3Decoder".equals(str))) && ((ae.f32499a >= 18 || !"OMX.MTK.AUDIO.DECODER.AAC".equals(str) || (!"a70".equals(ae.f32500b) && (!"Xiaomi".equals(ae.f32501c) || !ae.f32500b.startsWith("HM")))) && ((ae.f32499a != 16 || !"OMX.qcom.audio.decoder.mp3".equals(str) || (!"dlxu".equals(ae.f32500b) && !"protou".equals(ae.f32500b) && !"ville".equals(ae.f32500b) && !"villeplus".equals(ae.f32500b) && !"villec2".equals(ae.f32500b) && !ae.f32500b.startsWith("gee") && !"C6602".equals(ae.f32500b) && !"C6603".equals(ae.f32500b) && !"C6606".equals(ae.f32500b) && !"C6616".equals(ae.f32500b) && !"L36h".equals(ae.f32500b) && !"SO-02E".equals(ae.f32500b))) && ((ae.f32499a != 16 || !"OMX.qcom.audio.decoder.aac".equals(str) || (!"C1504".equals(ae.f32500b) && !"C1505".equals(ae.f32500b) && !"C1604".equals(ae.f32500b) && !"C1605".equals(ae.f32500b))) && ((ae.f32499a >= 24 || ((!"OMX.SEC.aac.dec".equals(str) && !"OMX.Exynos.AAC.Decoder".equals(str)) || !"samsung".equals(ae.f32501c) || (!ae.f32500b.startsWith("zeroflte") && !ae.f32500b.startsWith("zerolte") && !ae.f32500b.startsWith("zenlte") && !"SC-05G".equals(ae.f32500b) && !"marinelteatt".equals(ae.f32500b) && !"404SC".equals(ae.f32500b) && !"SC-04G".equals(ae.f32500b) && !"SCV31".equals(ae.f32500b)))) && ((ae.f32499a > 19 || !"OMX.SEC.vp8.dec".equals(str) || !"samsung".equals(ae.f32501c) || (!ae.f32500b.startsWith("d2") && !ae.f32500b.startsWith("serrano") && !ae.f32500b.startsWith("jflte") && !ae.f32500b.startsWith("santos") && !ae.f32500b.startsWith("t0"))) && ((ae.f32499a > 19 || !ae.f32500b.startsWith("jflte") || !"OMX.qcom.video.decoder.vp8".equals(str)) && (!"audio/eac3-joc".equals(str2) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str))))))))))) {
            return null;
        }
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
        } else if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        } else {
            if (!str2.equals("audio/flac") || !"OMX.lge.flac.decoder".equals(str)) {
                return null;
            }
            return "audio/x-lg-flac";
        }
        return null;
    }
}
