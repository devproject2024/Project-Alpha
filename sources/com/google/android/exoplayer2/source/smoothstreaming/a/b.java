package com.google.android.exoplayer2.source.smoothstreaming.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.h;
import com.google.android.exoplayer2.extractor.mp4.k;
import com.google.android.exoplayer2.f.z;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.smoothstreaming.a.a;
import com.google.android.exoplayer2.v;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class b implements z.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final XmlPullParserFactory f33350a;

    public b() {
        try {
            this.f33350a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public a a(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.f33350a.newPullParser();
            newPullParser.setInput(inputStream, (String) null);
            return (a) new e(uri.toString()).a(newPullParser);
        } catch (XmlPullParserException e2) {
            throw new v((Throwable) e2);
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a.b$b  reason: collision with other inner class name */
    public static class C0552b extends v {
        public C0552b(String str) {
            super("Missing required field: ".concat(String.valueOf(str)));
        }
    }

    static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f33353a;

        /* renamed from: b  reason: collision with root package name */
        private final String f33354b;

        /* renamed from: c  reason: collision with root package name */
        private final a f33355c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Pair<String, Object>> f33356d = new LinkedList();

        /* access modifiers changed from: protected */
        public abstract Object a();

        /* access modifiers changed from: protected */
        public void a(Object obj) {
        }

        /* access modifiers changed from: protected */
        public void b(XmlPullParser xmlPullParser) throws v {
        }

        /* access modifiers changed from: protected */
        public boolean b(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        public void c(XmlPullParser xmlPullParser) {
        }

        /* access modifiers changed from: protected */
        public void d(XmlPullParser xmlPullParser) {
        }

        public a(a aVar, String str, String str2) {
            this.f33355c = aVar;
            this.f33353a = str;
            this.f33354b = str2;
        }

        public final Object a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            boolean z = false;
            int i2 = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                a aVar = null;
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.f33354b.equals(name)) {
                        b(xmlPullParser);
                        z = true;
                    } else if (z) {
                        if (i2 > 0) {
                            i2++;
                        } else if (b(name)) {
                            b(xmlPullParser);
                        } else {
                            String str = this.f33353a;
                            if ("QualityLevel".equals(name)) {
                                aVar = new d(this, str);
                            } else if ("Protection".equals(name)) {
                                aVar = new c(this, str);
                            } else if ("StreamIndex".equals(name)) {
                                aVar = new f(this, str);
                            }
                            if (aVar == null) {
                                i2 = 1;
                            } else {
                                a(aVar.a(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z && i2 == 0) {
                        c(xmlPullParser);
                    }
                } else if (!z) {
                    continue;
                } else if (i2 > 0) {
                    i2--;
                } else {
                    String name2 = xmlPullParser.getName();
                    d(xmlPullParser);
                    if (!b(name2)) {
                        return a();
                    }
                }
                xmlPullParser.next();
            }
        }

        /* access modifiers changed from: protected */
        public final void a(String str, Object obj) {
            this.f33356d.add(Pair.create(str, obj));
        }

        /* access modifiers changed from: protected */
        public final Object a(String str) {
            a aVar = this;
            do {
                for (int i2 = 0; i2 < aVar.f33356d.size(); i2++) {
                    Pair pair = aVar.f33356d.get(i2);
                    if (((String) pair.first).equals(str)) {
                        return pair.second;
                    }
                }
                aVar = aVar.f33355c;
            } while (aVar != null);
            return null;
        }

        protected static String a(XmlPullParser xmlPullParser, String str) throws C0552b {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new C0552b(str);
        }

        protected static int b(XmlPullParser xmlPullParser, String str) throws v {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue == null) {
                return -1;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e2) {
                throw new v((Throwable) e2);
            }
        }

        protected static int c(XmlPullParser xmlPullParser, String str) throws v {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e2) {
                    throw new v((Throwable) e2);
                }
            } else {
                throw new C0552b(str);
            }
        }

        protected static long a(XmlPullParser xmlPullParser, String str, long j) throws v {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue == null) {
                return j;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e2) {
                throw new v((Throwable) e2);
            }
        }

        protected static long d(XmlPullParser xmlPullParser, String str) throws v {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                } catch (NumberFormatException e2) {
                    throw new v((Throwable) e2);
                }
            } else {
                throw new C0552b(str);
            }
        }
    }

    static class e extends a {

        /* renamed from: a  reason: collision with root package name */
        private final List<a.b> f33361a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        private int f33362b;

        /* renamed from: c  reason: collision with root package name */
        private int f33363c;

        /* renamed from: d  reason: collision with root package name */
        private long f33364d;

        /* renamed from: e  reason: collision with root package name */
        private long f33365e;

        /* renamed from: f  reason: collision with root package name */
        private long f33366f;

        /* renamed from: g  reason: collision with root package name */
        private int f33367g = -1;

        /* renamed from: h  reason: collision with root package name */
        private boolean f33368h;

        /* renamed from: i  reason: collision with root package name */
        private a.C0551a f33369i = null;

        public e(String str) {
            super((a) null, str, "SmoothStreamingMedia");
        }

        public final void b(XmlPullParser xmlPullParser) throws v {
            boolean z;
            this.f33362b = c(xmlPullParser, "MajorVersion");
            this.f33363c = c(xmlPullParser, "MinorVersion");
            this.f33364d = a(xmlPullParser, "TimeScale", 10000000);
            this.f33365e = d(xmlPullParser, "Duration");
            this.f33366f = a(xmlPullParser, "DVRWindowLength", 0);
            this.f33367g = b(xmlPullParser, "LookaheadCount");
            String attributeValue = xmlPullParser.getAttributeValue((String) null, "IsLive");
            if (attributeValue != null) {
                z = Boolean.parseBoolean(attributeValue);
            } else {
                z = false;
            }
            this.f33368h = z;
            a("TimeScale", (Object) Long.valueOf(this.f33364d));
        }

        public final void a(Object obj) {
            if (obj instanceof a.b) {
                this.f33361a.add((a.b) obj);
            } else if (obj instanceof a.C0551a) {
                com.google.android.exoplayer2.g.a.b(this.f33369i == null);
                this.f33369i = (a.C0551a) obj;
            }
        }

        public final Object a() {
            a.b[] bVarArr = new a.b[this.f33361a.size()];
            this.f33361a.toArray(bVarArr);
            a.C0551a aVar = this.f33369i;
            if (aVar != null) {
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(aVar.f33338a, "video/mp4", this.f33369i.f33339b));
                for (a.b bVar : bVarArr) {
                    int i2 = bVar.f33341a;
                    if (i2 == 2 || i2 == 1) {
                        Format[] formatArr = bVar.j;
                        for (int i3 = 0; i3 < formatArr.length; i3++) {
                            formatArr[i3] = formatArr[i3].a(drmInitData);
                        }
                    }
                }
            }
            return new a(this.f33362b, this.f33363c, this.f33364d, this.f33365e, this.f33366f, this.f33367g, this.f33368h, this.f33369i, bVarArr);
        }
    }

    static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f33357a;

        /* renamed from: b  reason: collision with root package name */
        private UUID f33358b;

        /* renamed from: c  reason: collision with root package name */
        private byte[] f33359c;

        public c(a aVar, String str) {
            super(aVar, str, "Protection");
        }

        public final boolean b(String str) {
            return "ProtectionHeader".equals(str);
        }

        public final void b(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f33357a = true;
                String attributeValue = xmlPullParser.getAttributeValue((String) null, "SystemID");
                if (attributeValue.charAt(0) == '{' && attributeValue.charAt(attributeValue.length() - 1) == '}') {
                    attributeValue = attributeValue.substring(1, attributeValue.length() - 1);
                }
                this.f33358b = UUID.fromString(attributeValue);
            }
        }

        public final void c(XmlPullParser xmlPullParser) {
            if (this.f33357a) {
                this.f33359c = Base64.decode(xmlPullParser.getText(), 0);
            }
        }

        public final void d(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f33357a = false;
            }
        }

        public final Object a() {
            UUID uuid = this.f33358b;
            return new a.C0551a(uuid, h.a(uuid, this.f33359c), new k[]{new k(true, (String) null, 8, a(this.f33359c), 0, 0, (byte[]) null)});
        }

        private static byte[] a(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < bArr.length; i2 += 2) {
                sb.append((char) bArr[i2]);
            }
            String sb2 = sb.toString();
            byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
            a(decode, 0, 3);
            a(decode, 1, 2);
            a(decode, 4, 5);
            a(decode, 6, 7);
            return decode;
        }

        private static void a(byte[] bArr, int i2, int i3) {
            byte b2 = bArr[i2];
            bArr[i2] = bArr[i3];
            bArr[i3] = b2;
        }
    }

    static class f extends a {

        /* renamed from: a  reason: collision with root package name */
        private final String f33370a;

        /* renamed from: b  reason: collision with root package name */
        private final List<Format> f33371b = new LinkedList();

        /* renamed from: c  reason: collision with root package name */
        private int f33372c;

        /* renamed from: d  reason: collision with root package name */
        private String f33373d;

        /* renamed from: e  reason: collision with root package name */
        private long f33374e;

        /* renamed from: f  reason: collision with root package name */
        private String f33375f;

        /* renamed from: g  reason: collision with root package name */
        private String f33376g;

        /* renamed from: h  reason: collision with root package name */
        private int f33377h;

        /* renamed from: i  reason: collision with root package name */
        private int f33378i;
        private int j;
        private int k;
        private String l;
        private ArrayList<Long> m;
        private long n;

        public f(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            this.f33370a = str;
        }

        public final boolean b(String str) {
            return "c".equals(str);
        }

        public final void b(XmlPullParser xmlPullParser) throws v {
            int i2 = 1;
            if ("c".equals(xmlPullParser.getName())) {
                int size = this.m.size();
                long a2 = a(xmlPullParser, "t", -9223372036854775807L);
                if (a2 == -9223372036854775807L) {
                    if (size == 0) {
                        a2 = 0;
                    } else if (this.n != -1) {
                        a2 = this.n + this.m.get(size - 1).longValue();
                    } else {
                        throw new v("Unable to infer start time");
                    }
                }
                this.m.add(Long.valueOf(a2));
                this.n = a(xmlPullParser, "d", -9223372036854775807L);
                long a3 = a(xmlPullParser, "r", 1);
                if (a3 <= 1 || this.n != -9223372036854775807L) {
                    while (true) {
                        long j2 = (long) i2;
                        if (j2 < a3) {
                            this.m.add(Long.valueOf((this.n * j2) + a2));
                            i2++;
                        } else {
                            return;
                        }
                    }
                } else {
                    throw new v("Repeated chunk with unspecified duration");
                }
            } else {
                String attributeValue = xmlPullParser.getAttributeValue((String) null, AppManagerUtil.EXTEND_TYPE);
                if (attributeValue != null) {
                    if (!H5ResourceHandlerUtil.AUDIO.equalsIgnoreCase(attributeValue)) {
                        if (H5ResourceHandlerUtil.VIDEO.equalsIgnoreCase(attributeValue)) {
                            i2 = 2;
                        } else if (CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX.equalsIgnoreCase(attributeValue)) {
                            i2 = 3;
                        } else {
                            throw new v("Invalid key value[" + attributeValue + "]");
                        }
                    }
                    this.f33372c = i2;
                    a(AppManagerUtil.EXTEND_TYPE, (Object) Integer.valueOf(this.f33372c));
                    if (this.f33372c == 3) {
                        this.f33373d = a(xmlPullParser, "Subtype");
                    } else {
                        this.f33373d = xmlPullParser.getAttributeValue((String) null, "Subtype");
                    }
                    a("Subtype", (Object) this.f33373d);
                    this.f33375f = xmlPullParser.getAttributeValue((String) null, "Name");
                    this.f33376g = a(xmlPullParser, "Url");
                    this.f33377h = b(xmlPullParser, "MaxWidth");
                    this.f33378i = b(xmlPullParser, "MaxHeight");
                    this.j = b(xmlPullParser, "DisplayWidth");
                    this.k = b(xmlPullParser, "DisplayHeight");
                    this.l = xmlPullParser.getAttributeValue((String) null, "Language");
                    a("Language", (Object) this.l);
                    this.f33374e = (long) b(xmlPullParser, "TimeScale");
                    if (this.f33374e == -1) {
                        this.f33374e = ((Long) a("TimeScale")).longValue();
                    }
                    this.m = new ArrayList<>();
                    return;
                }
                throw new C0552b(AppManagerUtil.EXTEND_TYPE);
            }
        }

        public final void a(Object obj) {
            if (obj instanceof Format) {
                this.f33371b.add((Format) obj);
            }
        }

        public final Object a() {
            Format[] formatArr = new Format[this.f33371b.size()];
            this.f33371b.toArray(formatArr);
            a.b bVar = r2;
            a.b bVar2 = new a.b(this.f33370a, this.f33376g, this.f33372c, this.f33373d, this.f33374e, this.f33375f, this.f33377h, this.f33378i, this.j, this.k, this.l, formatArr, this.m, this.n);
            return bVar;
        }
    }

    static class d extends a {

        /* renamed from: a  reason: collision with root package name */
        private Format f33360a;

        public d(a aVar, String str) {
            super(aVar, str, "QualityLevel");
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x00f1  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0118  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(org.xmlpull.v1.XmlPullParser r19) throws com.google.android.exoplayer2.v {
            /*
                r18 = this;
                r0 = r18
                r1 = r19
                java.lang.String r2 = "Type"
                java.lang.Object r2 = r0.a((java.lang.String) r2)
                java.lang.Integer r2 = (java.lang.Integer) r2
                int r2 = r2.intValue()
                r3 = 0
                java.lang.String r4 = "Index"
                java.lang.String r5 = r1.getAttributeValue(r3, r4)
                java.lang.String r4 = "Name"
                java.lang.Object r4 = r0.a((java.lang.String) r4)
                r6 = r4
                java.lang.String r6 = (java.lang.String) r6
                java.lang.String r4 = "Bitrate"
                int r4 = c(r1, r4)
                java.lang.String r7 = "FourCC"
                java.lang.String r7 = a((org.xmlpull.v1.XmlPullParser) r1, (java.lang.String) r7)
                java.lang.String r8 = "H264"
                boolean r8 = r7.equalsIgnoreCase(r8)
                java.lang.String r9 = "audio/mp4a-latm"
                if (r8 != 0) goto L_0x00e8
                java.lang.String r8 = "X264"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 != 0) goto L_0x00e8
                java.lang.String r8 = "AVC1"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 != 0) goto L_0x00e8
                java.lang.String r8 = "DAVC"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 == 0) goto L_0x0050
                goto L_0x00e8
            L_0x0050:
                java.lang.String r8 = "AAC"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 != 0) goto L_0x00e6
                java.lang.String r8 = "AACL"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 != 0) goto L_0x00e6
                java.lang.String r8 = "AACH"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 != 0) goto L_0x00e6
                java.lang.String r8 = "AACP"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 == 0) goto L_0x0072
                goto L_0x00e6
            L_0x0072:
                java.lang.String r8 = "TTML"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 != 0) goto L_0x00e3
                java.lang.String r8 = "DFXP"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 == 0) goto L_0x0084
                goto L_0x00e3
            L_0x0084:
                java.lang.String r8 = "ac-3"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 != 0) goto L_0x00e0
                java.lang.String r8 = "dac3"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 == 0) goto L_0x0095
                goto L_0x00e0
            L_0x0095:
                java.lang.String r8 = "ec-3"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 != 0) goto L_0x00dd
                java.lang.String r8 = "dec3"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 == 0) goto L_0x00a6
                goto L_0x00dd
            L_0x00a6:
                java.lang.String r8 = "dtsc"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 == 0) goto L_0x00b1
                java.lang.String r7 = "audio/vnd.dts"
                goto L_0x00eb
            L_0x00b1:
                java.lang.String r8 = "dtsh"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 != 0) goto L_0x00da
                java.lang.String r8 = "dtsl"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 == 0) goto L_0x00c2
                goto L_0x00da
            L_0x00c2:
                java.lang.String r8 = "dtse"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 == 0) goto L_0x00cd
                java.lang.String r7 = "audio/vnd.dts.hd;profile=lbr"
                goto L_0x00eb
            L_0x00cd:
                java.lang.String r8 = "opus"
                boolean r7 = r7.equalsIgnoreCase(r8)
                if (r7 == 0) goto L_0x00d8
                java.lang.String r7 = "audio/opus"
                goto L_0x00eb
            L_0x00d8:
                r8 = r3
                goto L_0x00ec
            L_0x00da:
                java.lang.String r7 = "audio/vnd.dts.hd"
                goto L_0x00eb
            L_0x00dd:
                java.lang.String r7 = "audio/eac3"
                goto L_0x00eb
            L_0x00e0:
                java.lang.String r7 = "audio/ac3"
                goto L_0x00eb
            L_0x00e3:
                java.lang.String r7 = "application/ttml+xml"
                goto L_0x00eb
            L_0x00e6:
                r8 = r9
                goto L_0x00ec
            L_0x00e8:
                java.lang.String r7 = "video/avc"
            L_0x00eb:
                r8 = r7
            L_0x00ec:
                r7 = 2
                java.lang.String r10 = "CodecPrivateData"
                if (r2 != r7) goto L_0x0118
                java.lang.String r2 = "MaxWidth"
                int r12 = c(r1, r2)
                java.lang.String r2 = "MaxHeight"
                int r13 = c(r1, r2)
                java.lang.String r1 = r1.getAttributeValue(r3, r10)
                java.util.List r15 = c(r1)
                r9 = 0
                r10 = 0
                r14 = -1082130432(0xffffffffbf800000, float:-1.0)
                r16 = 0
                r17 = 0
                java.lang.String r7 = "video/mp4"
                r11 = r4
                com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (com.google.android.exoplayer2.metadata.Metadata) r10, (int) r11, (int) r12, (int) r13, (float) r14, (java.util.List<byte[]>) r15, (int) r16, (int) r17)
                r0.f33360a = r1
                return
            L_0x0118:
                java.lang.String r7 = "Language"
                r11 = 1
                if (r2 != r11) goto L_0x0160
                if (r8 != 0) goto L_0x0120
                r8 = r9
            L_0x0120:
                java.lang.String r2 = "Channels"
                int r12 = c(r1, r2)
                java.lang.String r2 = "SamplingRate"
                int r13 = c(r1, r2)
                java.lang.String r1 = r1.getAttributeValue(r3, r10)
                java.util.List r1 = c(r1)
                boolean r2 = r1.isEmpty()
                if (r2 == 0) goto L_0x0148
                boolean r2 = r9.equals(r8)
                if (r2 == 0) goto L_0x0148
                byte[] r1 = com.google.android.exoplayer2.g.c.a((int) r13, (int) r12)
                java.util.List r1 = java.util.Collections.singletonList(r1)
            L_0x0148:
                r14 = r1
                java.lang.Object r1 = r0.a((java.lang.String) r7)
                r17 = r1
                java.lang.String r17 = (java.lang.String) r17
                r9 = 0
                r10 = 0
                r15 = 0
                r16 = 0
                java.lang.String r7 = "audio/mp4"
                r11 = r4
                com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (com.google.android.exoplayer2.metadata.Metadata) r10, (int) r11, (int) r12, (int) r13, (java.util.List<byte[]>) r14, (int) r15, (int) r16, (java.lang.String) r17)
                r0.f33360a = r1
                return
            L_0x0160:
                r1 = 3
                if (r2 != r1) goto L_0x01b0
                java.lang.String r1 = "Subtype"
                java.lang.Object r1 = r0.a((java.lang.String) r1)
                java.lang.String r1 = (java.lang.String) r1
                r2 = -1
                int r3 = r1.hashCode()
                r9 = 2061026(0x1f72e2, float:2.888113E-39)
                r10 = 0
                if (r3 == r9) goto L_0x0186
                r9 = 2094737(0x1ff691, float:2.935352E-39)
                if (r3 == r9) goto L_0x017c
                goto L_0x018f
            L_0x017c:
                java.lang.String r3 = "DESC"
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L_0x018f
                r2 = 1
                goto L_0x018f
            L_0x0186:
                java.lang.String r3 = "CAPT"
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L_0x018f
                r2 = 0
            L_0x018f:
                if (r2 == 0) goto L_0x019a
                if (r2 == r11) goto L_0x0195
                r11 = 0
                goto L_0x019e
            L_0x0195:
                r1 = 1024(0x400, float:1.435E-42)
                r11 = 1024(0x400, float:1.435E-42)
                goto L_0x019e
            L_0x019a:
                r1 = 64
                r11 = 64
            L_0x019e:
                java.lang.Object r1 = r0.a((java.lang.String) r7)
                r12 = r1
                java.lang.String r12 = (java.lang.String) r12
                r10 = 0
                java.lang.String r7 = "application/mp4"
                r9 = r4
                com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (int) r9, (int) r10, (int) r11, (java.lang.String) r12)
                r0.f33360a = r1
                return
            L_0x01b0:
                r9 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                java.lang.String r7 = "application/mp4"
                r10 = r4
                com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (int) r10, (int) r11, (int) r12, (java.lang.String) r13)
                r0.f33360a = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.smoothstreaming.a.b.d.b(org.xmlpull.v1.XmlPullParser):void");
        }

        public final Object a() {
            return this.f33360a;
        }

        private static List<byte[]> c(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] i2 = ae.i(str);
                byte[][] b2 = com.google.android.exoplayer2.g.c.b(i2);
                if (b2 == null) {
                    arrayList.add(i2);
                } else {
                    Collections.addAll(arrayList, b2);
                }
            }
            return arrayList;
        }
    }
}
