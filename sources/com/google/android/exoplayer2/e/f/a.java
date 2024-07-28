package com.google.android.exoplayer2.e.f;

import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.af;
import com.google.android.exoplayer2.g.l;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class a extends com.google.android.exoplayer2.e.c {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f31539c = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f31540d = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f31541e = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f31542f = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f31543g = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f31544h = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: i  reason: collision with root package name */
    private static final b f31545i = new b(30.0f, 1, 1);
    private static final C0537a j = new C0537a(32, 15);
    private final XmlPullParserFactory k;

    public final /* bridge */ /* synthetic */ e a(byte[] bArr, int i2, boolean z) throws g {
        return a(bArr, i2);
    }

    public a() {
        super("TtmlDecoder");
        try {
            this.k = XmlPullParserFactory.newInstance();
            this.k.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    private e a(byte[] bArr, int i2) throws g {
        c cVar;
        C0537a aVar;
        b bVar;
        boolean z;
        try {
            XmlPullParser newPullParser = this.k.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new c());
            c cVar2 = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i2), (String) null);
            ArrayDeque arrayDeque = new ArrayDeque();
            int eventType = newPullParser.getEventType();
            b bVar2 = f31545i;
            C0537a aVar2 = j;
            e eVar = null;
            int i3 = 0;
            while (eventType != 1) {
                b bVar3 = (b) arrayDeque.peek();
                if (i3 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if (H5Param.TRANSPARENT.equals(name)) {
                            int i4 = 30;
                            String attributeValue = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
                            if (attributeValue != null) {
                                i4 = Integer.parseInt(attributeValue);
                            }
                            float f2 = 1.0f;
                            String attributeValue2 = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
                            if (attributeValue2 != null) {
                                String[] a2 = ae.a(attributeValue2, " ");
                                if (a2.length == 2) {
                                    z = true;
                                    f2 = ((float) Integer.parseInt(a2[0])) / ((float) Integer.parseInt(a2[1]));
                                } else {
                                    throw new g("frameRateMultiplier doesn't have 2 parts");
                                }
                            } else {
                                z = true;
                            }
                            int i5 = f31545i.f31549b;
                            String attributeValue3 = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
                            if (attributeValue3 != null) {
                                i5 = Integer.parseInt(attributeValue3);
                            }
                            int i6 = f31545i.f31550c;
                            String attributeValue4 = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
                            if (attributeValue4 != null) {
                                i6 = Integer.parseInt(attributeValue4);
                            }
                            bVar = new b(((float) i4) * f2, i5, i6);
                            aVar = a(newPullParser, j);
                            cVar = a(newPullParser);
                        } else {
                            z = true;
                            cVar = cVar2;
                            bVar = bVar2;
                            aVar = aVar2;
                        }
                        if (!name.equals(H5Param.TRANSPARENT)) {
                            if (!name.equals("head") && !name.equals("body") && !name.equals("div") && !name.equals("p") && !name.equals("span") && !name.equals("br") && !name.equals("style") && !name.equals("styling") && !name.equals(Item.KEY_LAYOUT) && !name.equals("region") && !name.equals("metadata") && !name.equals(H5ResourceHandlerUtil.IMAGE) && !name.equals("data")) {
                                if (!name.equals("information")) {
                                    z = false;
                                }
                            }
                        }
                        if (!z) {
                            new StringBuilder("Ignoring unsupported tag: ").append(newPullParser.getName());
                            l.b();
                        } else {
                            if ("head".equals(name)) {
                                a(newPullParser, hashMap, aVar, cVar, hashMap2, hashMap3);
                            } else {
                                try {
                                    b a3 = a(newPullParser, bVar3, hashMap2, bVar);
                                    arrayDeque.push(a3);
                                    if (bVar3 != null) {
                                        bVar3.a(a3);
                                    }
                                } catch (g e2) {
                                    l.a("Suppressing parser error", e2);
                                }
                            }
                            bVar2 = bVar;
                            aVar2 = aVar;
                            cVar2 = cVar;
                        }
                        i3++;
                        bVar2 = bVar;
                        aVar2 = aVar;
                        cVar2 = cVar;
                    } else if (eventType == 4) {
                        bVar3.a(new b((String) null, newPullParser.getText().replaceAll("\r\n", StringUtility.NEW_LINE).replaceAll(" *\n *", StringUtility.NEW_LINE).replaceAll(StringUtility.NEW_LINE, " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, (d) null, (String[]) null, "", (String) null));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals(H5Param.TRANSPARENT)) {
                            eVar = new e((b) arrayDeque.peek(), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i3++;
                } else if (eventType == 3) {
                    i3--;
                }
                newPullParser.next();
                eventType = newPullParser.getEventType();
            }
            return eVar;
        } catch (XmlPullParserException e3) {
            throw new g("Unable to decode source", e3);
        } catch (IOException e4) {
            throw new IllegalStateException("Unexpected error when reading input.", e4);
        }
    }

    private static C0537a a(XmlPullParser xmlPullParser, C0537a aVar) throws g {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = f31544h.matcher(attributeValue);
        if (!matcher.matches()) {
            "Ignoring malformed cell resolution: ".concat(String.valueOf(attributeValue));
            l.c();
            return aVar;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt != 0 && parseInt2 != 0) {
                return new C0537a(parseInt, parseInt2);
            }
            throw new g("Invalid cell resolution " + parseInt + " " + parseInt2);
        } catch (NumberFormatException unused) {
            "Ignoring malformed cell resolution: ".concat(String.valueOf(attributeValue));
            l.c();
            return aVar;
        }
    }

    private static c a(XmlPullParser xmlPullParser) {
        String c2 = af.c(xmlPullParser, "extent");
        if (c2 == null) {
            return null;
        }
        Matcher matcher = f31543g.matcher(c2);
        if (!matcher.matches()) {
            "Ignoring non-pixel tts extent: ".concat(String.valueOf(c2));
            l.c();
            return null;
        }
        try {
            return new c(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        } catch (NumberFormatException unused) {
            "Ignoring malformed tts extent: ".concat(String.valueOf(c2));
            l.c();
            return null;
        }
    }

    private static Map<String, d> a(XmlPullParser xmlPullParser, Map<String, d> map, C0537a aVar, c cVar, Map<String, c> map2, Map<String, String> map3) throws IOException, XmlPullParserException {
        String c2;
        do {
            xmlPullParser.next();
            if (af.b(xmlPullParser, "style")) {
                String c3 = af.c(xmlPullParser, "style");
                d a2 = a(xmlPullParser, new d());
                if (c3 != null) {
                    for (String str : a(c3)) {
                        a2.a(map.get(str));
                    }
                }
                if (a2.l != null) {
                    map.put(a2.l, a2);
                }
            } else if (af.b(xmlPullParser, "region")) {
                c a3 = a(xmlPullParser, aVar, cVar);
                if (a3 != null) {
                    map2.put(a3.f31562a, a3);
                }
            } else if (af.b(xmlPullParser, "metadata")) {
                do {
                    xmlPullParser.next();
                    if (af.b(xmlPullParser, H5ResourceHandlerUtil.IMAGE) && (c2 = af.c(xmlPullParser, "id")) != null) {
                        map3.put(c2, xmlPullParser.nextText());
                    }
                } while (!af.a(xmlPullParser, "metadata"));
            }
        } while (!af.a(xmlPullParser, "head"));
        return map;
    }

    private static c a(XmlPullParser xmlPullParser, C0537a aVar, c cVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        int i2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        c cVar2 = cVar;
        String c2 = af.c(xmlPullParser2, "id");
        if (c2 == null) {
            return null;
        }
        String c3 = af.c(xmlPullParser2, "origin");
        if (c3 != null) {
            Matcher matcher = f31542f.matcher(c3);
            Matcher matcher2 = f31543g.matcher(c3);
            if (matcher.matches()) {
                try {
                    float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                    f2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    f3 = parseFloat;
                } catch (NumberFormatException unused) {
                    "Ignoring region with malformed origin: ".concat(String.valueOf(c3));
                    l.c();
                    return null;
                }
            } else if (!matcher2.matches()) {
                "Ignoring region with unsupported origin: ".concat(String.valueOf(c3));
                l.c();
                return null;
            } else if (cVar2 == null) {
                "Ignoring region with missing tts:extent: ".concat(String.valueOf(c3));
                l.c();
                return null;
            } else {
                try {
                    int parseInt = Integer.parseInt(matcher2.group(1));
                    int parseInt2 = Integer.parseInt(matcher2.group(2));
                    f3 = ((float) parseInt) / ((float) cVar2.f31551a);
                    f2 = ((float) parseInt2) / ((float) cVar2.f31552b);
                } catch (NumberFormatException unused2) {
                    "Ignoring region with malformed origin: ".concat(String.valueOf(c3));
                    l.c();
                    return null;
                }
            }
            String c4 = af.c(xmlPullParser2, "extent");
            if (c4 != null) {
                Matcher matcher3 = f31542f.matcher(c4);
                Matcher matcher4 = f31543g.matcher(c4);
                if (matcher3.matches()) {
                    try {
                        f5 = Float.parseFloat(matcher3.group(1)) / 100.0f;
                        f4 = Float.parseFloat(matcher3.group(2)) / 100.0f;
                    } catch (NumberFormatException unused3) {
                        "Ignoring region with malformed extent: ".concat(String.valueOf(c3));
                        l.c();
                        return null;
                    }
                } else if (!matcher4.matches()) {
                    "Ignoring region with unsupported extent: ".concat(String.valueOf(c3));
                    l.c();
                    return null;
                } else if (cVar2 == null) {
                    "Ignoring region with missing tts:extent: ".concat(String.valueOf(c3));
                    l.c();
                    return null;
                } else {
                    try {
                        int parseInt3 = Integer.parseInt(matcher4.group(1));
                        int parseInt4 = Integer.parseInt(matcher4.group(2));
                        float f6 = ((float) parseInt3) / ((float) cVar2.f31551a);
                        f4 = ((float) parseInt4) / ((float) cVar2.f31552b);
                        f5 = f6;
                    } catch (NumberFormatException unused4) {
                        "Ignoring region with malformed extent: ".concat(String.valueOf(c3));
                        l.c();
                        return null;
                    }
                }
                String c5 = af.c(xmlPullParser2, "displayAlign");
                if (c5 != null) {
                    String d2 = ae.d(c5);
                    char c6 = 65535;
                    int hashCode = d2.hashCode();
                    if (hashCode != -1364013995) {
                        if (hashCode == 92734940 && d2.equals("after")) {
                            c6 = 1;
                        }
                    } else if (d2.equals("center")) {
                        c6 = 0;
                    }
                    if (c6 == 0) {
                        f2 += f4 / 2.0f;
                        i2 = 1;
                    } else if (c6 == 1) {
                        f2 += f4;
                        i2 = 2;
                    }
                    return new c(c2, f3, f2, 0, i2, f5, f4, 1, 1.0f / ((float) aVar.f31547b));
                }
                i2 = 0;
                return new c(c2, f3, f2, 0, i2, f5, f4, 1, 1.0f / ((float) aVar.f31547b));
            }
            l.c();
            return null;
        }
        l.c();
        return null;
    }

    private static String[] a(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : ae.a(trim, "\\s+");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.e.f.d a(org.xmlpull.v1.XmlPullParser r13, com.google.android.exoplayer2.e.f.d r14) {
        /*
            int r0 = r13.getAttributeCount()
            r1 = 0
            r2 = r14
            r14 = 0
        L_0x0007:
            if (r14 >= r0) goto L_0x02b9
            java.lang.String r3 = r13.getAttributeValue(r14)
            java.lang.String r4 = r13.getAttributeName(r14)
            int r5 = r4.hashCode()
            r6 = 4
            r7 = -1
            r8 = 3
            r9 = 2
            r10 = 1
            switch(r5) {
                case -1550943582: goto L_0x0071;
                case -1224696685: goto L_0x0067;
                case -1065511464: goto L_0x005c;
                case -879295043: goto L_0x0050;
                case -734428249: goto L_0x0046;
                case 3355: goto L_0x003c;
                case 94842723: goto L_0x0032;
                case 365601008: goto L_0x0028;
                case 1287124693: goto L_0x001e;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x007b
        L_0x001e:
            java.lang.String r5 = "backgroundColor"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x007b
            r4 = 1
            goto L_0x007c
        L_0x0028:
            java.lang.String r5 = "fontSize"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x007b
            r4 = 4
            goto L_0x007c
        L_0x0032:
            java.lang.String r5 = "color"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x007b
            r4 = 2
            goto L_0x007c
        L_0x003c:
            java.lang.String r5 = "id"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x007b
            r4 = 0
            goto L_0x007c
        L_0x0046:
            java.lang.String r5 = "fontWeight"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x007b
            r4 = 5
            goto L_0x007c
        L_0x0050:
            java.lang.String r5 = "textDecoration"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x007b
            r4 = 8
            goto L_0x007c
        L_0x005c:
            java.lang.String r5 = "textAlign"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x007b
            r4 = 7
            goto L_0x007c
        L_0x0067:
            java.lang.String r5 = "fontFamily"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x007b
            r4 = 3
            goto L_0x007c
        L_0x0071:
            java.lang.String r5 = "fontStyle"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x007b
            r4 = 6
            goto L_0x007c
        L_0x007b:
            r4 = -1
        L_0x007c:
            switch(r4) {
                case 0: goto L_0x02a2;
                case 1: goto L_0x0289;
                case 2: goto L_0x0270;
                case 3: goto L_0x0260;
                case 4: goto L_0x0191;
                case 5: goto L_0x017a;
                case 6: goto L_0x0163;
                case 7: goto L_0x00e7;
                case 8: goto L_0x0081;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x02b5
        L_0x0081:
            java.lang.String r3 = com.google.android.exoplayer2.g.ae.d((java.lang.String) r3)
            int r4 = r3.hashCode()
            switch(r4) {
                case -1461280213: goto L_0x00ac;
                case -1026963764: goto L_0x00a1;
                case 913457136: goto L_0x0097;
                case 1679736913: goto L_0x008d;
                default: goto L_0x008c;
            }
        L_0x008c:
            goto L_0x00b5
        L_0x008d:
            java.lang.String r4 = "linethrough"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00b5
            r7 = 0
            goto L_0x00b5
        L_0x0097:
            java.lang.String r4 = "nolinethrough"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00b5
            r7 = 1
            goto L_0x00b5
        L_0x00a1:
            java.lang.String r4 = "underline"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00b5
            r7 = 2
            goto L_0x00b5
        L_0x00ac:
            java.lang.String r4 = "nounderline"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00b5
            r7 = 3
        L_0x00b5:
            if (r7 == 0) goto L_0x00dd
            if (r7 == r10) goto L_0x00d3
            if (r7 == r9) goto L_0x00c9
            if (r7 == r8) goto L_0x00bf
            goto L_0x02b5
        L_0x00bf:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            com.google.android.exoplayer2.e.f.d r2 = r2.b((boolean) r1)
            goto L_0x02b5
        L_0x00c9:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            com.google.android.exoplayer2.e.f.d r2 = r2.b((boolean) r10)
            goto L_0x02b5
        L_0x00d3:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            com.google.android.exoplayer2.e.f.d r2 = r2.a((boolean) r1)
            goto L_0x02b5
        L_0x00dd:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            com.google.android.exoplayer2.e.f.d r2 = r2.a((boolean) r10)
            goto L_0x02b5
        L_0x00e7:
            java.lang.String r3 = com.google.android.exoplayer2.g.ae.d((java.lang.String) r3)
            int r4 = r3.hashCode()
            switch(r4) {
                case -1364013995: goto L_0x011c;
                case 100571: goto L_0x0112;
                case 3317767: goto L_0x0108;
                case 108511772: goto L_0x00fe;
                case 109757538: goto L_0x00f3;
                default: goto L_0x00f2;
            }
        L_0x00f2:
            goto L_0x0125
        L_0x00f3:
            java.lang.String r4 = "start"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0125
            r7 = 1
            goto L_0x0125
        L_0x00fe:
            java.lang.String r4 = "right"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0125
            r7 = 2
            goto L_0x0125
        L_0x0108:
            java.lang.String r4 = "left"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0125
            r7 = 0
            goto L_0x0125
        L_0x0112:
            java.lang.String r4 = "end"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0125
            r7 = 3
            goto L_0x0125
        L_0x011c:
            java.lang.String r4 = "center"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0125
            r7 = 4
        L_0x0125:
            if (r7 == 0) goto L_0x0159
            if (r7 == r10) goto L_0x014f
            if (r7 == r9) goto L_0x0145
            if (r7 == r8) goto L_0x013b
            if (r7 == r6) goto L_0x0131
            goto L_0x02b5
        L_0x0131:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_CENTER
            r2.n = r3
            goto L_0x02b5
        L_0x013b:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            r2.n = r3
            goto L_0x02b5
        L_0x0145:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            r2.n = r3
            goto L_0x02b5
        L_0x014f:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_NORMAL
            r2.n = r3
            goto L_0x02b5
        L_0x0159:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_NORMAL
            r2.n = r3
            goto L_0x02b5
        L_0x0163:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            java.lang.String r4 = "italic"
            boolean r3 = r4.equalsIgnoreCase(r3)
            com.google.android.exoplayer2.e.f.d r4 = r2.m
            if (r4 != 0) goto L_0x0172
            goto L_0x0173
        L_0x0172:
            r10 = 0
        L_0x0173:
            com.google.android.exoplayer2.g.a.b(r10)
            r2.f31579i = r3
            goto L_0x02b5
        L_0x017a:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            java.lang.String r4 = "bold"
            boolean r3 = r4.equalsIgnoreCase(r3)
            com.google.android.exoplayer2.e.f.d r4 = r2.m
            if (r4 != 0) goto L_0x0189
            goto L_0x018a
        L_0x0189:
            r10 = 0
        L_0x018a:
            com.google.android.exoplayer2.g.a.b(r10)
            r2.f31578h = r3
            goto L_0x02b5
        L_0x0191:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)     // Catch:{ g -> 0x0253 }
            java.lang.String r4 = "\\s+"
            java.lang.String[] r4 = com.google.android.exoplayer2.g.ae.a((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ g -> 0x0253 }
            int r5 = r4.length     // Catch:{ g -> 0x0253 }
            if (r5 != r10) goto L_0x01a5
            java.util.regex.Pattern r4 = f31541e     // Catch:{ g -> 0x0253 }
            java.util.regex.Matcher r4 = r4.matcher(r3)     // Catch:{ g -> 0x0253 }
            goto L_0x01b3
        L_0x01a5:
            int r5 = r4.length     // Catch:{ g -> 0x0253 }
            if (r5 != r9) goto L_0x0239
            java.util.regex.Pattern r5 = f31541e     // Catch:{ g -> 0x0253 }
            r4 = r4[r10]     // Catch:{ g -> 0x0253 }
            java.util.regex.Matcher r4 = r5.matcher(r4)     // Catch:{ g -> 0x0253 }
            com.google.android.exoplayer2.g.l.c()     // Catch:{ g -> 0x0253 }
        L_0x01b3:
            boolean r5 = r4.matches()     // Catch:{ g -> 0x0253 }
            java.lang.String r6 = "'."
            if (r5 == 0) goto L_0x0222
            java.lang.String r5 = r4.group(r8)     // Catch:{ g -> 0x0253 }
            int r11 = r5.hashCode()     // Catch:{ g -> 0x0253 }
            r12 = 37
            if (r11 == r12) goto L_0x01e4
            r12 = 3240(0xca8, float:4.54E-42)
            if (r11 == r12) goto L_0x01da
            r12 = 3592(0xe08, float:5.033E-42)
            if (r11 == r12) goto L_0x01d0
            goto L_0x01ed
        L_0x01d0:
            java.lang.String r11 = "px"
            boolean r11 = r5.equals(r11)     // Catch:{ g -> 0x0253 }
            if (r11 == 0) goto L_0x01ed
            r7 = 0
            goto L_0x01ed
        L_0x01da:
            java.lang.String r11 = "em"
            boolean r11 = r5.equals(r11)     // Catch:{ g -> 0x0253 }
            if (r11 == 0) goto L_0x01ed
            r7 = 1
            goto L_0x01ed
        L_0x01e4:
            java.lang.String r11 = "%"
            boolean r11 = r5.equals(r11)     // Catch:{ g -> 0x0253 }
            if (r11 == 0) goto L_0x01ed
            r7 = 2
        L_0x01ed:
            if (r7 == 0) goto L_0x0210
            if (r7 == r10) goto L_0x020d
            if (r7 != r9) goto L_0x01f6
            r2.j = r8     // Catch:{ g -> 0x0253 }
            goto L_0x0212
        L_0x01f6:
            com.google.android.exoplayer2.e.g r4 = new com.google.android.exoplayer2.e.g     // Catch:{ g -> 0x0253 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ g -> 0x0253 }
            java.lang.String r8 = "Invalid unit for fontSize: '"
            r7.<init>(r8)     // Catch:{ g -> 0x0253 }
            r7.append(r5)     // Catch:{ g -> 0x0253 }
            r7.append(r6)     // Catch:{ g -> 0x0253 }
            java.lang.String r5 = r7.toString()     // Catch:{ g -> 0x0253 }
            r4.<init>((java.lang.String) r5)     // Catch:{ g -> 0x0253 }
            throw r4     // Catch:{ g -> 0x0253 }
        L_0x020d:
            r2.j = r9     // Catch:{ g -> 0x0253 }
            goto L_0x0212
        L_0x0210:
            r2.j = r10     // Catch:{ g -> 0x0253 }
        L_0x0212:
            java.lang.String r4 = r4.group(r10)     // Catch:{ g -> 0x0253 }
            java.lang.Float r4 = java.lang.Float.valueOf(r4)     // Catch:{ g -> 0x0253 }
            float r4 = r4.floatValue()     // Catch:{ g -> 0x0253 }
            r2.k = r4     // Catch:{ g -> 0x0253 }
            goto L_0x02b5
        L_0x0222:
            com.google.android.exoplayer2.e.g r4 = new com.google.android.exoplayer2.e.g     // Catch:{ g -> 0x0253 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ g -> 0x0253 }
            java.lang.String r7 = "Invalid expression for fontSize: '"
            r5.<init>(r7)     // Catch:{ g -> 0x0253 }
            r5.append(r3)     // Catch:{ g -> 0x0253 }
            r5.append(r6)     // Catch:{ g -> 0x0253 }
            java.lang.String r5 = r5.toString()     // Catch:{ g -> 0x0253 }
            r4.<init>((java.lang.String) r5)     // Catch:{ g -> 0x0253 }
            throw r4     // Catch:{ g -> 0x0253 }
        L_0x0239:
            com.google.android.exoplayer2.e.g r5 = new com.google.android.exoplayer2.e.g     // Catch:{ g -> 0x0253 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ g -> 0x0253 }
            java.lang.String r7 = "Invalid number of entries for fontSize: "
            r6.<init>(r7)     // Catch:{ g -> 0x0253 }
            int r4 = r4.length     // Catch:{ g -> 0x0253 }
            r6.append(r4)     // Catch:{ g -> 0x0253 }
            java.lang.String r4 = "."
            r6.append(r4)     // Catch:{ g -> 0x0253 }
            java.lang.String r4 = r6.toString()     // Catch:{ g -> 0x0253 }
            r5.<init>((java.lang.String) r4)     // Catch:{ g -> 0x0253 }
            throw r5     // Catch:{ g -> 0x0253 }
        L_0x0253:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Failed parsing fontSize value: "
            r4.concat(r3)
            com.google.android.exoplayer2.g.l.c()
            goto L_0x02b5
        L_0x0260:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            com.google.android.exoplayer2.e.f.d r4 = r2.m
            if (r4 != 0) goto L_0x0269
            goto L_0x026a
        L_0x0269:
            r10 = 0
        L_0x026a:
            com.google.android.exoplayer2.g.a.b(r10)
            r2.f31571a = r3
            goto L_0x02b5
        L_0x0270:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            int r4 = com.google.android.exoplayer2.g.d.a(r3)     // Catch:{ IllegalArgumentException -> 0x027c }
            r2.a((int) r4)     // Catch:{ IllegalArgumentException -> 0x027c }
            goto L_0x02b5
        L_0x027c:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Failed parsing color value: "
            r4.concat(r3)
            com.google.android.exoplayer2.g.l.c()
            goto L_0x02b5
        L_0x0289:
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            int r4 = com.google.android.exoplayer2.g.d.a(r3)     // Catch:{ IllegalArgumentException -> 0x0295 }
            r2.b((int) r4)     // Catch:{ IllegalArgumentException -> 0x0295 }
            goto L_0x02b5
        L_0x0295:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Failed parsing background value: "
            r4.concat(r3)
            com.google.android.exoplayer2.g.l.c()
            goto L_0x02b5
        L_0x02a2:
            java.lang.String r4 = r13.getName()
            java.lang.String r5 = "style"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x02b5
            com.google.android.exoplayer2.e.f.d r2 = a((com.google.android.exoplayer2.e.f.d) r2)
            r2.l = r3
        L_0x02b5:
            int r14 = r14 + 1
            goto L_0x0007
        L_0x02b9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.f.a.a(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.e.f.d):com.google.android.exoplayer2.e.f.d");
    }

    private static d a(d dVar) {
        return dVar == null ? new d() : dVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.e.f.b a(org.xmlpull.v1.XmlPullParser r19, com.google.android.exoplayer2.e.f.b r20, java.util.Map<java.lang.String, com.google.android.exoplayer2.e.f.c> r21, com.google.android.exoplayer2.e.f.a.b r22) throws com.google.android.exoplayer2.e.g {
        /*
            r0 = r19
            r1 = r20
            r2 = r22
            int r3 = r19.getAttributeCount()
            r4 = 0
            com.google.android.exoplayer2.e.f.d r12 = a((org.xmlpull.v1.XmlPullParser) r0, (com.google.android.exoplayer2.e.f.d) r4)
            java.lang.String r8 = ""
            r16 = r4
            r17 = r16
            r15 = r8
            r4 = 0
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0026:
            if (r4 >= r3) goto L_0x00cb
            java.lang.String r5 = r0.getAttributeName(r4)
            java.lang.String r6 = r0.getAttributeValue(r4)
            int r18 = r5.hashCode()
            switch(r18) {
                case -934795532: goto L_0x006b;
                case 99841: goto L_0x0061;
                case 100571: goto L_0x0057;
                case 93616297: goto L_0x004d;
                case 109780401: goto L_0x0042;
                case 1292595405: goto L_0x0038;
                default: goto L_0x0037;
            }
        L_0x0037:
            goto L_0x0075
        L_0x0038:
            java.lang.String r7 = "backgroundImage"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0075
            r5 = 5
            goto L_0x0076
        L_0x0042:
            java.lang.String r7 = "style"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0075
            r5 = 3
            goto L_0x0076
        L_0x004d:
            java.lang.String r7 = "begin"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0075
            r5 = 0
            goto L_0x0076
        L_0x0057:
            java.lang.String r7 = "end"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0075
            r5 = 1
            goto L_0x0076
        L_0x0061:
            java.lang.String r7 = "dur"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0075
            r5 = 2
            goto L_0x0076
        L_0x006b:
            java.lang.String r7 = "region"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0075
            r5 = 4
            goto L_0x0076
        L_0x0075:
            r5 = -1
        L_0x0076:
            if (r5 == 0) goto L_0x00c0
            r7 = 1
            if (r5 == r7) goto L_0x00b8
            r7 = 2
            if (r5 == r7) goto L_0x00b0
            r7 = 3
            if (r5 == r7) goto L_0x00a4
            r7 = 4
            if (r5 == r7) goto L_0x009a
            r7 = 5
            if (r5 == r7) goto L_0x0088
            goto L_0x0097
        L_0x0088:
            java.lang.String r5 = "#"
            boolean r5 = r6.startsWith(r5)
            if (r5 == 0) goto L_0x0097
            r5 = 1
            java.lang.String r5 = r6.substring(r5)
            r16 = r5
        L_0x0097:
            r5 = r21
            goto L_0x00c7
        L_0x009a:
            r5 = r21
            boolean r7 = r5.containsKey(r6)
            if (r7 == 0) goto L_0x00c7
            r15 = r6
            goto L_0x00c7
        L_0x00a4:
            r5 = r21
            java.lang.String[] r6 = a((java.lang.String) r6)
            int r7 = r6.length
            if (r7 <= 0) goto L_0x00c7
            r17 = r6
            goto L_0x00c7
        L_0x00b0:
            r5 = r21
            long r6 = a((java.lang.String) r6, (com.google.android.exoplayer2.e.f.a.b) r2)
            r13 = r6
            goto L_0x00c7
        L_0x00b8:
            r5 = r21
            long r6 = a((java.lang.String) r6, (com.google.android.exoplayer2.e.f.a.b) r2)
            r10 = r6
            goto L_0x00c7
        L_0x00c0:
            r5 = r21
            long r6 = a((java.lang.String) r6, (com.google.android.exoplayer2.e.f.a.b) r2)
            r8 = r6
        L_0x00c7:
            int r4 = r4 + 1
            goto L_0x0026
        L_0x00cb:
            if (r1 == 0) goto L_0x00e7
            long r2 = r1.f31556d
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00ec
            int r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00df
            long r2 = r1.f31556d
            long r8 = r8 + r2
        L_0x00df:
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00ec
            long r2 = r1.f31556d
            long r10 = r10 + r2
            goto L_0x00ec
        L_0x00e7:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x00ec:
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0102
            int r2 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00f7
            long r13 = r13 + r8
            r10 = r13
            goto L_0x0102
        L_0x00f7:
            if (r1 == 0) goto L_0x0102
            long r2 = r1.f31557e
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0102
            long r1 = r1.f31557e
            r10 = r1
        L_0x0102:
            java.lang.String r6 = r19.getName()
            com.google.android.exoplayer2.e.f.b r0 = new com.google.android.exoplayer2.e.f.b
            r7 = 0
            r5 = r0
            r13 = r17
            r14 = r15
            r15 = r16
            r5.<init>(r6, r7, r8, r10, r12, r13, r14, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.f.a.a(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.e.f.b, java.util.Map, com.google.android.exoplayer2.e.f.a$b):com.google.android.exoplayer2.e.f.b");
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long a(java.lang.String r14, com.google.android.exoplayer2.e.f.a.b r15) throws com.google.android.exoplayer2.e.g {
        /*
            java.util.regex.Pattern r0 = f31539c
            java.util.regex.Matcher r0 = r0.matcher(r14)
            boolean r1 = r0.matches()
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            if (r1 == 0) goto L_0x0076
            java.lang.String r14 = r0.group(r8)
            long r8 = java.lang.Long.parseLong(r14)
            r10 = 3600(0xe10, double:1.7786E-320)
            long r8 = r8 * r10
            double r8 = (double) r8
            java.lang.String r14 = r0.group(r7)
            long r10 = java.lang.Long.parseLong(r14)
            r12 = 60
            long r10 = r10 * r12
            double r10 = (double) r10
            double r8 = r8 + r10
            java.lang.String r14 = r0.group(r6)
            long r6 = java.lang.Long.parseLong(r14)
            double r6 = (double) r6
            double r8 = r8 + r6
            java.lang.String r14 = r0.group(r5)
            r5 = 0
            if (r14 == 0) goto L_0x0048
            double r10 = java.lang.Double.parseDouble(r14)
            goto L_0x0049
        L_0x0048:
            r10 = r5
        L_0x0049:
            double r8 = r8 + r10
            java.lang.String r14 = r0.group(r4)
            if (r14 == 0) goto L_0x005a
            long r10 = java.lang.Long.parseLong(r14)
            float r14 = (float) r10
            float r1 = r15.f31548a
            float r14 = r14 / r1
            double r10 = (double) r14
            goto L_0x005b
        L_0x005a:
            r10 = r5
        L_0x005b:
            double r8 = r8 + r10
            r14 = 6
            java.lang.String r14 = r0.group(r14)
            if (r14 == 0) goto L_0x0071
            long r0 = java.lang.Long.parseLong(r14)
            double r0 = (double) r0
            int r14 = r15.f31549b
            double r4 = (double) r14
            double r0 = r0 / r4
            float r14 = r15.f31548a
            double r14 = (double) r14
            double r5 = r0 / r14
        L_0x0071:
            double r8 = r8 + r5
            double r8 = r8 * r2
            long r14 = (long) r8
            return r14
        L_0x0076:
            java.util.regex.Pattern r0 = f31540d
            java.util.regex.Matcher r0 = r0.matcher(r14)
            boolean r1 = r0.matches()
            if (r1 == 0) goto L_0x0114
            java.lang.String r14 = r0.group(r8)
            double r9 = java.lang.Double.parseDouble(r14)
            java.lang.String r14 = r0.group(r7)
            r0 = -1
            int r1 = r14.hashCode()
            r11 = 102(0x66, float:1.43E-43)
            if (r1 == r11) goto L_0x00df
            r11 = 104(0x68, float:1.46E-43)
            if (r1 == r11) goto L_0x00d5
            r11 = 109(0x6d, float:1.53E-43)
            if (r1 == r11) goto L_0x00cb
            r11 = 3494(0xda6, float:4.896E-42)
            if (r1 == r11) goto L_0x00c1
            r11 = 115(0x73, float:1.61E-43)
            if (r1 == r11) goto L_0x00b7
            r11 = 116(0x74, float:1.63E-43)
            if (r1 == r11) goto L_0x00ac
            goto L_0x00e9
        L_0x00ac:
            java.lang.String r1 = "t"
            boolean r14 = r14.equals(r1)
            if (r14 == 0) goto L_0x00e9
            r14 = 5
            goto L_0x00ea
        L_0x00b7:
            java.lang.String r1 = "s"
            boolean r14 = r14.equals(r1)
            if (r14 == 0) goto L_0x00e9
            r14 = 2
            goto L_0x00ea
        L_0x00c1:
            java.lang.String r1 = "ms"
            boolean r14 = r14.equals(r1)
            if (r14 == 0) goto L_0x00e9
            r14 = 3
            goto L_0x00ea
        L_0x00cb:
            java.lang.String r1 = "m"
            boolean r14 = r14.equals(r1)
            if (r14 == 0) goto L_0x00e9
            r14 = 1
            goto L_0x00ea
        L_0x00d5:
            java.lang.String r1 = "h"
            boolean r14 = r14.equals(r1)
            if (r14 == 0) goto L_0x00e9
            r14 = 0
            goto L_0x00ea
        L_0x00df:
            java.lang.String r1 = "f"
            boolean r14 = r14.equals(r1)
            if (r14 == 0) goto L_0x00e9
            r14 = 4
            goto L_0x00ea
        L_0x00e9:
            r14 = -1
        L_0x00ea:
            if (r14 == 0) goto L_0x0109
            if (r14 == r8) goto L_0x0106
            if (r14 == r7) goto L_0x0110
            if (r14 == r6) goto L_0x00ff
            if (r14 == r5) goto L_0x00fb
            if (r14 == r4) goto L_0x00f7
            goto L_0x0110
        L_0x00f7:
            int r14 = r15.f31550c
            double r14 = (double) r14
            goto L_0x0104
        L_0x00fb:
            float r14 = r15.f31548a
            double r14 = (double) r14
            goto L_0x0104
        L_0x00ff:
            r14 = 4652007308841189376(0x408f400000000000, double:1000.0)
        L_0x0104:
            double r9 = r9 / r14
            goto L_0x0110
        L_0x0106:
            r14 = 4633641066610819072(0x404e000000000000, double:60.0)
            goto L_0x010e
        L_0x0109:
            r14 = 4660134898793709568(0x40ac200000000000, double:3600.0)
        L_0x010e:
            double r9 = r9 * r14
        L_0x0110:
            double r9 = r9 * r2
            long r14 = (long) r9
            return r14
        L_0x0114:
            com.google.android.exoplayer2.e.g r15 = new com.google.android.exoplayer2.e.g
            java.lang.String r14 = java.lang.String.valueOf(r14)
            java.lang.String r0 = "Malformed time expression: "
            java.lang.String r14 = r0.concat(r14)
            r15.<init>((java.lang.String) r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.f.a.a(java.lang.String, com.google.android.exoplayer2.e.f.a$b):long");
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final float f31548a;

        /* renamed from: b  reason: collision with root package name */
        final int f31549b;

        /* renamed from: c  reason: collision with root package name */
        final int f31550c;

        b(float f2, int i2, int i3) {
            this.f31548a = f2;
            this.f31549b = i2;
            this.f31550c = i3;
        }
    }

    /* renamed from: com.google.android.exoplayer2.e.f.a$a  reason: collision with other inner class name */
    static final class C0537a {

        /* renamed from: a  reason: collision with root package name */
        final int f31546a;

        /* renamed from: b  reason: collision with root package name */
        final int f31547b;

        C0537a(int i2, int i3) {
            this.f31546a = i2;
            this.f31547b = i3;
        }
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        final int f31551a;

        /* renamed from: b  reason: collision with root package name */
        final int f31552b;

        c(int i2, int i3) {
            this.f31551a = i2;
            this.f31552b = i3;
        }
    }
}
