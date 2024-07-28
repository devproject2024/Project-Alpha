package com.google.android.exoplayer2.g;

import android.text.TextUtils;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import java.util.ArrayList;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayList<a> f32542a = new ArrayList<>();

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f32543a;

        /* renamed from: b  reason: collision with root package name */
        public final String f32544b;

        /* renamed from: c  reason: collision with root package name */
        public final int f32545c;
    }

    public static String a(int i2) {
        if (i2 == 32) {
            return "video/mp4v-es";
        }
        if (i2 == 33) {
            return "video/avc";
        }
        if (i2 == 35) {
            return "video/hevc";
        }
        if (i2 == 64) {
            return "audio/mp4a-latm";
        }
        if (i2 == 163) {
            return "video/wvc1";
        }
        if (i2 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i2 == 165) {
            return "audio/ac3";
        }
        if (i2 == 166) {
            return "audio/eac3";
        }
        switch (i2) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i2) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static boolean a(String str) {
        return H5ResourceHandlerUtil.AUDIO.equals(j(str));
    }

    public static boolean b(String str) {
        return H5ResourceHandlerUtil.VIDEO.equals(j(str));
    }

    public static boolean c(String str) {
        return CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX.equals(j(str));
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        for (String f2 : ae.j(str)) {
            String f3 = f(f2);
            if (f3 != null && b(f3)) {
                return f3;
            }
        }
        return null;
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        for (String f2 : ae.j(str)) {
            String f3 = f(f2);
            if (f3 != null && a(f3)) {
                return f3;
            }
        }
        return null;
    }

    public static String f(String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        String d2 = ae.d(str.trim());
        if (d2.startsWith("avc1") || d2.startsWith("avc3")) {
            return "video/avc";
        }
        if (d2.startsWith("hev1") || d2.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (d2.startsWith("dvav") || d2.startsWith("dva1") || d2.startsWith("dvhe") || d2.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (d2.startsWith("av01")) {
            return "video/av01";
        }
        if (d2.startsWith("vp9") || d2.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (d2.startsWith("vp8") || d2.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (d2.startsWith("mp4a")) {
            if (d2.startsWith("mp4a.")) {
                String substring = d2.substring(5);
                if (substring.length() >= 2) {
                    try {
                        str2 = a(Integer.parseInt(ae.e(substring.substring(0, 2)), 16));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return str2 == null ? "audio/mp4a-latm" : str2;
        } else if (d2.startsWith("ac-3") || d2.startsWith("dac3")) {
            return "audio/ac3";
        } else {
            if (d2.startsWith("ec-3") || d2.startsWith("dec3")) {
                return "audio/eac3";
            }
            if (d2.startsWith("ec+3")) {
                return "audio/eac3-joc";
            }
            if (d2.startsWith("ac-4") || d2.startsWith("dac4")) {
                return "audio/ac4";
            }
            if (d2.startsWith("dtsc") || d2.startsWith("dtse")) {
                return "audio/vnd.dts";
            }
            if (d2.startsWith("dtsh") || d2.startsWith("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (d2.startsWith("opus")) {
                return "audio/opus";
            }
            if (d2.startsWith("vorbis")) {
                return "audio/vorbis";
            }
            if (d2.startsWith("flac")) {
                return "audio/flac";
            }
            int size = f32542a.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = f32542a.get(i2);
                if (d2.startsWith(aVar.f32544b)) {
                    return aVar.f32543a;
                }
            }
            return null;
        }
    }

    public static int g(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (a(str)) {
            return 1;
        }
        if (b(str)) {
            return 2;
        }
        if (c(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 4;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 5;
        }
        int size = f32542a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = f32542a.get(i2);
            if (str.equals(aVar.f32543a)) {
                return aVar.f32545c;
            }
        }
        return -1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int h(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = 6
            r2 = 5
            r3 = 0
            switch(r0) {
                case -2123537834: goto L_0x0047;
                case -1095064472: goto L_0x003d;
                case 187078296: goto L_0x0033;
                case 187078297: goto L_0x0029;
                case 1504578661: goto L_0x001f;
                case 1505942594: goto L_0x0015;
                case 1556697186: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0051
        L_0x000b:
            java.lang.String r0 = "audio/true-hd"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0051
            r4 = 6
            goto L_0x0052
        L_0x0015:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0051
            r4 = 5
            goto L_0x0052
        L_0x001f:
            java.lang.String r0 = "audio/eac3"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0051
            r4 = 1
            goto L_0x0052
        L_0x0029:
            java.lang.String r0 = "audio/ac4"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0051
            r4 = 3
            goto L_0x0052
        L_0x0033:
            java.lang.String r0 = "audio/ac3"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0051
            r4 = 0
            goto L_0x0052
        L_0x003d:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0051
            r4 = 4
            goto L_0x0052
        L_0x0047:
            java.lang.String r0 = "audio/eac3-joc"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0051
            r4 = 2
            goto L_0x0052
        L_0x0051:
            r4 = -1
        L_0x0052:
            switch(r4) {
                case 0: goto L_0x0065;
                case 1: goto L_0x0064;
                case 2: goto L_0x0061;
                case 3: goto L_0x005e;
                case 4: goto L_0x005c;
                case 5: goto L_0x0059;
                case 6: goto L_0x0056;
                default: goto L_0x0055;
            }
        L_0x0055:
            return r3
        L_0x0056:
            r4 = 14
            return r4
        L_0x0059:
            r4 = 8
            return r4
        L_0x005c:
            r4 = 7
            return r4
        L_0x005e:
            r4 = 17
            return r4
        L_0x0061:
            r4 = 18
            return r4
        L_0x0064:
            return r1
        L_0x0065:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.o.h(java.lang.String):int");
    }

    public static int i(String str) {
        return g(f(str));
    }

    private static String j(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }
}
