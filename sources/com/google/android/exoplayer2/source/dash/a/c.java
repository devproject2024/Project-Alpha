package com.google.android.exoplayer2.source.dash.a;

import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.f.z;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.af;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.o;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.dash.a.j;
import com.google.android.exoplayer2.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class c extends DefaultHandler implements z.a<b> {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f32914a = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f32915b = Pattern.compile("CC([1-4])=.*");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f32916c = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: d  reason: collision with root package name */
    private final XmlPullParserFactory f32917d;

    public c() {
        try {
            this.f32917d = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0191 A[Catch:{ XmlPullParserException -> 0x01c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01ab A[Catch:{ XmlPullParserException -> 0x01c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b3 A[Catch:{ XmlPullParserException -> 0x01c2 }, LOOP:0: B:26:0x0090->B:75:0x01b3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0171 A[SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.a.b a(android.net.Uri r35, java.io.InputStream r36) throws java.io.IOException {
        /*
            r34 = this;
            java.lang.String r0 = "MPD"
            r1 = r34
            org.xmlpull.v1.XmlPullParserFactory r2 = r1.f32917d     // Catch:{ XmlPullParserException -> 0x01c2 }
            org.xmlpull.v1.XmlPullParser r2 = r2.newPullParser()     // Catch:{ XmlPullParserException -> 0x01c2 }
            r3 = 0
            r4 = r36
            r2.setInput(r4, r3)     // Catch:{ XmlPullParserException -> 0x01c2 }
            int r4 = r2.next()     // Catch:{ XmlPullParserException -> 0x01c2 }
            r5 = 2
            if (r4 != r5) goto L_0x01ba
            java.lang.String r4 = r2.getName()     // Catch:{ XmlPullParserException -> 0x01c2 }
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x01c2 }
            if (r4 == 0) goto L_0x01ba
            java.lang.String r4 = r35.toString()     // Catch:{ XmlPullParserException -> 0x01c2 }
            java.lang.String r5 = "availabilityStartTime"
            long r7 = b((org.xmlpull.v1.XmlPullParser) r2, (java.lang.String) r5)     // Catch:{ XmlPullParserException -> 0x01c2 }
            java.lang.String r5 = "mediaPresentationDuration"
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r5 = b((org.xmlpull.v1.XmlPullParser) r2, (java.lang.String) r5, (long) r9)     // Catch:{ XmlPullParserException -> 0x01c2 }
            java.lang.String r11 = "minBufferTime"
            long r11 = b((org.xmlpull.v1.XmlPullParser) r2, (java.lang.String) r11, (long) r9)     // Catch:{ XmlPullParserException -> 0x01c2 }
            java.lang.String r13 = "type"
            java.lang.String r13 = r2.getAttributeValue(r3, r13)     // Catch:{ XmlPullParserException -> 0x01c2 }
            r15 = 0
            if (r13 == 0) goto L_0x0050
            java.lang.String r14 = "dynamic"
            boolean r13 = r14.equals(r13)     // Catch:{ XmlPullParserException -> 0x01c2 }
            if (r13 == 0) goto L_0x0050
            r13 = 1
            goto L_0x0051
        L_0x0050:
            r13 = 0
        L_0x0051:
            if (r13 == 0) goto L_0x005a
            java.lang.String r14 = "minimumUpdatePeriod"
            long r16 = b((org.xmlpull.v1.XmlPullParser) r2, (java.lang.String) r14, (long) r9)     // Catch:{ XmlPullParserException -> 0x01c2 }
            goto L_0x005c
        L_0x005a:
            r16 = r9
        L_0x005c:
            if (r13 == 0) goto L_0x0066
            java.lang.String r14 = "timeShiftBufferDepth"
            long r18 = b((org.xmlpull.v1.XmlPullParser) r2, (java.lang.String) r14, (long) r9)     // Catch:{ XmlPullParserException -> 0x01c2 }
            goto L_0x0068
        L_0x0066:
            r18 = r9
        L_0x0068:
            if (r13 == 0) goto L_0x0072
            java.lang.String r14 = "suggestedPresentationDelay"
            long r20 = b((org.xmlpull.v1.XmlPullParser) r2, (java.lang.String) r14, (long) r9)     // Catch:{ XmlPullParserException -> 0x01c2 }
            goto L_0x0074
        L_0x0072:
            r20 = r9
        L_0x0074:
            java.lang.String r14 = "publishTime"
            long r22 = b((org.xmlpull.v1.XmlPullParser) r2, (java.lang.String) r14)     // Catch:{ XmlPullParserException -> 0x01c2 }
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ XmlPullParserException -> 0x01c2 }
            r14.<init>()     // Catch:{ XmlPullParserException -> 0x01c2 }
            if (r13 == 0) goto L_0x0084
            r24 = r9
            goto L_0x0086
        L_0x0084:
            r24 = 0
        L_0x0086:
            r27 = r3
            r28 = r27
            r29 = r28
            r9 = r24
            r24 = 0
        L_0x0090:
            r2.next()     // Catch:{ XmlPullParserException -> 0x01c2 }
            java.lang.String r3 = "BaseURL"
            boolean r3 = com.google.android.exoplayer2.g.af.b(r2, r3)     // Catch:{ XmlPullParserException -> 0x01c2 }
            if (r3 == 0) goto L_0x00af
            if (r15 != 0) goto L_0x00a7
            java.lang.String r3 = c(r2, r4)     // Catch:{ XmlPullParserException -> 0x01c2 }
            r4 = r3
            r32 = r11
            r15 = 1
            goto L_0x016b
        L_0x00a7:
            r30 = r9
            r32 = r11
            r36 = r15
            goto L_0x0167
        L_0x00af:
            java.lang.String r3 = "ProgramInformation"
            boolean r3 = com.google.android.exoplayer2.g.af.b(r2, r3)     // Catch:{ XmlPullParserException -> 0x01c2 }
            if (r3 == 0) goto L_0x00c1
            com.google.android.exoplayer2.source.dash.a.g r3 = f((org.xmlpull.v1.XmlPullParser) r2)     // Catch:{ XmlPullParserException -> 0x01c2 }
            r28 = r3
        L_0x00bd:
            r32 = r11
            goto L_0x016b
        L_0x00c1:
            java.lang.String r3 = "UTCTiming"
            boolean r3 = com.google.android.exoplayer2.g.af.b(r2, r3)     // Catch:{ XmlPullParserException -> 0x01c2 }
            if (r3 == 0) goto L_0x00e3
            java.lang.String r3 = "schemeIdUri"
            r1 = 0
            java.lang.String r3 = r2.getAttributeValue(r1, r3)     // Catch:{ XmlPullParserException -> 0x01c2 }
            r36 = r15
            java.lang.String r15 = "value"
            java.lang.String r15 = r2.getAttributeValue(r1, r15)     // Catch:{ XmlPullParserException -> 0x01c2 }
            com.google.android.exoplayer2.source.dash.a.m r1 = new com.google.android.exoplayer2.source.dash.a.m     // Catch:{ XmlPullParserException -> 0x01c2 }
            r1.<init>(r3, r15)     // Catch:{ XmlPullParserException -> 0x01c2 }
            r15 = r36
            r27 = r1
            goto L_0x00bd
        L_0x00e3:
            r36 = r15
            java.lang.String r1 = "Location"
            boolean r1 = com.google.android.exoplayer2.g.af.b(r2, r1)     // Catch:{ XmlPullParserException -> 0x01c2 }
            if (r1 == 0) goto L_0x00fa
            java.lang.String r1 = r2.nextText()     // Catch:{ XmlPullParserException -> 0x01c2 }
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ XmlPullParserException -> 0x01c2 }
            r15 = r36
            r29 = r1
            goto L_0x00bd
        L_0x00fa:
            java.lang.String r1 = "Period"
            boolean r1 = com.google.android.exoplayer2.g.af.b(r2, r1)     // Catch:{ XmlPullParserException -> 0x01c2 }
            if (r1 == 0) goto L_0x0160
            if (r24 != 0) goto L_0x0160
            android.util.Pair r1 = a((org.xmlpull.v1.XmlPullParser) r2, (java.lang.String) r4, (long) r9)     // Catch:{ XmlPullParserException -> 0x01c2 }
            java.lang.Object r3 = r1.first     // Catch:{ XmlPullParserException -> 0x01c2 }
            com.google.android.exoplayer2.source.dash.a.f r3 = (com.google.android.exoplayer2.source.dash.a.f) r3     // Catch:{ XmlPullParserException -> 0x01c2 }
            r30 = r9
            long r9 = r3.f32934b     // Catch:{ XmlPullParserException -> 0x01c2 }
            r25 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r15 = (r9 > r25 ? 1 : (r9 == r25 ? 0 : -1))
            if (r15 != 0) goto L_0x013c
            if (r13 == 0) goto L_0x0124
            r15 = r36
            r32 = r11
            r9 = r30
            r24 = 1
            goto L_0x016b
        L_0x0124:
            com.google.android.exoplayer2.v r0 = new com.google.android.exoplayer2.v     // Catch:{ XmlPullParserException -> 0x01c2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x01c2 }
            java.lang.String r2 = "Unable to determine start of period "
            r1.<init>(r2)     // Catch:{ XmlPullParserException -> 0x01c2 }
            int r2 = r14.size()     // Catch:{ XmlPullParserException -> 0x01c2 }
            r1.append(r2)     // Catch:{ XmlPullParserException -> 0x01c2 }
            java.lang.String r1 = r1.toString()     // Catch:{ XmlPullParserException -> 0x01c2 }
            r0.<init>((java.lang.String) r1)     // Catch:{ XmlPullParserException -> 0x01c2 }
            throw r0     // Catch:{ XmlPullParserException -> 0x01c2 }
        L_0x013c:
            java.lang.Object r1 = r1.second     // Catch:{ XmlPullParserException -> 0x01c2 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ XmlPullParserException -> 0x01c2 }
            long r9 = r1.longValue()     // Catch:{ XmlPullParserException -> 0x01c2 }
            r25 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r9 > r25 ? 1 : (r9 == r25 ? 0 : -1))
            if (r1 != 0) goto L_0x0155
            r32 = r11
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x015a
        L_0x0155:
            r32 = r11
            long r11 = r3.f32934b     // Catch:{ XmlPullParserException -> 0x01c2 }
            long r9 = r9 + r11
        L_0x015a:
            r14.add(r3)     // Catch:{ XmlPullParserException -> 0x01c2 }
            r15 = r36
            goto L_0x016b
        L_0x0160:
            r30 = r9
            r32 = r11
            h(r2)     // Catch:{ XmlPullParserException -> 0x01c2 }
        L_0x0167:
            r15 = r36
            r9 = r30
        L_0x016b:
            boolean r1 = com.google.android.exoplayer2.g.af.a(r2, r0)     // Catch:{ XmlPullParserException -> 0x01c2 }
            if (r1 == 0) goto L_0x01b3
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x018a
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x017f
            goto L_0x018b
        L_0x017f:
            if (r13 == 0) goto L_0x0182
            goto L_0x018a
        L_0x0182:
            com.google.android.exoplayer2.v r0 = new com.google.android.exoplayer2.v     // Catch:{ XmlPullParserException -> 0x01c2 }
            java.lang.String r1 = "Unable to determine duration of static manifest."
            r0.<init>((java.lang.String) r1)     // Catch:{ XmlPullParserException -> 0x01c2 }
            throw r0     // Catch:{ XmlPullParserException -> 0x01c2 }
        L_0x018a:
            r9 = r5
        L_0x018b:
            boolean r0 = r14.isEmpty()     // Catch:{ XmlPullParserException -> 0x01c2 }
            if (r0 != 0) goto L_0x01ab
            com.google.android.exoplayer2.source.dash.a.b r0 = new com.google.android.exoplayer2.source.dash.a.b     // Catch:{ XmlPullParserException -> 0x01c2 }
            r6 = r0
            r11 = r32
            r1 = r14
            r14 = r16
            r16 = r18
            r18 = r20
            r20 = r22
            r22 = r28
            r23 = r27
            r24 = r29
            r25 = r1
            r6.<init>(r7, r9, r11, r13, r14, r16, r18, r20, r22, r23, r24, r25)     // Catch:{ XmlPullParserException -> 0x01c2 }
            return r0
        L_0x01ab:
            com.google.android.exoplayer2.v r0 = new com.google.android.exoplayer2.v     // Catch:{ XmlPullParserException -> 0x01c2 }
            java.lang.String r1 = "No periods found."
            r0.<init>((java.lang.String) r1)     // Catch:{ XmlPullParserException -> 0x01c2 }
            throw r0     // Catch:{ XmlPullParserException -> 0x01c2 }
        L_0x01b3:
            r3 = 0
            r1 = r34
            r11 = r32
            goto L_0x0090
        L_0x01ba:
            com.google.android.exoplayer2.v r0 = new com.google.android.exoplayer2.v     // Catch:{ XmlPullParserException -> 0x01c2 }
            java.lang.String r1 = "inputStream does not contain a valid media presentation description"
            r0.<init>((java.lang.String) r1)     // Catch:{ XmlPullParserException -> 0x01c2 }
            throw r0     // Catch:{ XmlPullParserException -> 0x01c2 }
        L_0x01c2:
            r0 = move-exception
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            r1.<init>((java.lang.Throwable) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.a.c.a(android.net.Uri, java.io.InputStream):com.google.android.exoplayer2.source.dash.a.b");
    }

    private static Pair<f, Long> a(XmlPullParser xmlPullParser, String str, long j) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "id");
        long b2 = b(xmlPullParser, "start", j);
        long b3 = b(xmlPullParser, AppConstants.DURATION, -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        j jVar = null;
        do {
            xmlPullParser.next();
            if (af.b(xmlPullParser, "BaseURL")) {
                if (!z) {
                    str = c(xmlPullParser, str);
                    z = true;
                }
            } else if (af.b(xmlPullParser, "AdaptationSet")) {
                arrayList.add(a(xmlPullParser, str, jVar));
            } else if (af.b(xmlPullParser, "EventStream")) {
                arrayList2.add(c(xmlPullParser));
            } else if (af.b(xmlPullParser, "SegmentBase")) {
                jVar = a(xmlPullParser, (j.e) null);
            } else if (af.b(xmlPullParser, "SegmentList")) {
                jVar = a(xmlPullParser, (j.b) null);
            } else if (af.b(xmlPullParser, "SegmentTemplate")) {
                jVar = a(xmlPullParser, (j.c) null, (List<d>) Collections.emptyList());
            } else {
                h(xmlPullParser);
            }
        } while (!af.a(xmlPullParser, "Period"));
        return Pair.create(new f(attributeValue, b2, arrayList, arrayList2), Long.valueOf(b3));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v5, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r17v3, types: [com.google.android.exoplayer2.source.dash.a.i$a] */
    /* JADX WARNING: type inference failed for: r17v4, types: [com.google.android.exoplayer2.source.dash.a.i$b] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02c1 A[LOOP:0: B:1:0x006b->B:92:0x02c1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0233 A[EDGE_INSN: B:93:0x0233->B:71:0x0233 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.source.dash.a.a a(org.xmlpull.v1.XmlPullParser r40, java.lang.String r41, com.google.android.exoplayer2.source.dash.a.j r42) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r15 = r40
            r14 = -1
            java.lang.String r0 = "id"
            int r16 = a((org.xmlpull.v1.XmlPullParser) r15, (java.lang.String) r0, (int) r14)
            int r0 = a((org.xmlpull.v1.XmlPullParser) r40)
            r13 = 0
            java.lang.String r1 = "mimeType"
            java.lang.String r17 = r15.getAttributeValue(r13, r1)
            java.lang.String r1 = "codecs"
            java.lang.String r18 = r15.getAttributeValue(r13, r1)
            java.lang.String r1 = "width"
            int r19 = a((org.xmlpull.v1.XmlPullParser) r15, (java.lang.String) r1, (int) r14)
            java.lang.String r1 = "height"
            int r20 = a((org.xmlpull.v1.XmlPullParser) r15, (java.lang.String) r1, (int) r14)
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r21 = a((org.xmlpull.v1.XmlPullParser) r15, (float) r1)
            java.lang.String r1 = "audioSamplingRate"
            int r22 = a((org.xmlpull.v1.XmlPullParser) r15, (java.lang.String) r1, (int) r14)
            java.lang.String r12 = "lang"
            java.lang.String r1 = r15.getAttributeValue(r13, r12)
            java.lang.String r2 = "label"
            java.lang.String r23 = r15.getAttributeValue(r13, r2)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r24 = 0
            r5 = r41
            r27 = r42
            r3 = r0
            r4 = r1
            r28 = r13
            r25 = 0
            r26 = -1
        L_0x006b:
            r40.next()
            java.lang.String r0 = "BaseURL"
            boolean r0 = com.google.android.exoplayer2.g.af.b(r15, r0)
            r29 = 1
            if (r0 == 0) goto L_0x00ab
            if (r25 != 0) goto L_0x0095
            java.lang.String r0 = c(r15, r5)
            r5 = r0
            r30 = r4
            r2 = r6
            r6 = r7
            r33 = r8
            r34 = r9
            r4 = r10
            r36 = r11
            r37 = r12
            r38 = r13
            r1 = r15
            r25 = 1
        L_0x0091:
            r39 = -1
            goto L_0x022b
        L_0x0095:
            r30 = r4
            r31 = r5
            r2 = r6
            r6 = r7
            r33 = r8
            r34 = r9
            r4 = r10
            r36 = r11
            r37 = r12
            r38 = r13
            r1 = r15
            r39 = -1
            goto L_0x0229
        L_0x00ab:
            java.lang.String r0 = "ContentProtection"
            boolean r0 = com.google.android.exoplayer2.g.af.b(r15, r0)
            if (r0 == 0) goto L_0x00db
            android.util.Pair r0 = b((org.xmlpull.v1.XmlPullParser) r40)
            java.lang.Object r1 = r0.first
            if (r1 == 0) goto L_0x00c1
            java.lang.Object r1 = r0.first
            r28 = r1
            java.lang.String r28 = (java.lang.String) r28
        L_0x00c1:
            java.lang.Object r1 = r0.second
            if (r1 == 0) goto L_0x00ca
            java.lang.Object r0 = r0.second
            r11.add(r0)
        L_0x00ca:
            r30 = r4
            r2 = r6
            r6 = r7
            r33 = r8
            r34 = r9
            r4 = r10
            r36 = r11
            r37 = r12
            r38 = r13
            r1 = r15
            goto L_0x0091
        L_0x00db:
            java.lang.String r0 = "ContentComponent"
            boolean r0 = com.google.android.exoplayer2.g.af.b(r15, r0)
            if (r0 == 0) goto L_0x00ff
            java.lang.String r0 = r15.getAttributeValue(r13, r12)
            if (r4 != 0) goto L_0x00eb
            r4 = r0
            goto L_0x00f5
        L_0x00eb:
            if (r0 != 0) goto L_0x00ee
            goto L_0x00f5
        L_0x00ee:
            boolean r0 = r4.equals(r0)
            com.google.android.exoplayer2.g.a.b(r0)
        L_0x00f5:
            int r0 = a((org.xmlpull.v1.XmlPullParser) r40)
            int r0 = a((int) r3, (int) r0)
            r3 = r0
            goto L_0x00ca
        L_0x00ff:
            java.lang.String r0 = "Role"
            boolean r1 = com.google.android.exoplayer2.g.af.b(r15, r0)
            if (r1 == 0) goto L_0x010f
            com.google.android.exoplayer2.source.dash.a.d r0 = a((org.xmlpull.v1.XmlPullParser) r15, (java.lang.String) r0)
            r8.add(r0)
            goto L_0x0095
        L_0x010f:
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = com.google.android.exoplayer2.g.af.b(r15, r0)
            if (r0 == 0) goto L_0x011c
            int r26 = g(r40)
            goto L_0x00ca
        L_0x011c:
            java.lang.String r0 = "Accessibility"
            boolean r1 = com.google.android.exoplayer2.g.af.b(r15, r0)
            if (r1 == 0) goto L_0x012d
            com.google.android.exoplayer2.source.dash.a.d r0 = a((org.xmlpull.v1.XmlPullParser) r15, (java.lang.String) r0)
            r9.add(r0)
            goto L_0x0095
        L_0x012d:
            java.lang.String r0 = "SupplementalProperty"
            boolean r1 = com.google.android.exoplayer2.g.af.b(r15, r0)
            if (r1 == 0) goto L_0x013e
            com.google.android.exoplayer2.source.dash.a.d r0 = a((org.xmlpull.v1.XmlPullParser) r15, (java.lang.String) r0)
            r7.add(r0)
            goto L_0x0095
        L_0x013e:
            java.lang.String r0 = "Representation"
            boolean r0 = com.google.android.exoplayer2.g.af.b(r15, r0)
            if (r0 == 0) goto L_0x01b5
            r0 = r40
            r1 = r5
            r2 = r23
            r15 = r3
            r3 = r17
            r30 = r4
            r4 = r18
            r31 = r5
            r5 = r19
            r32 = r6
            r6 = r20
            r41 = r7
            r7 = r21
            r33 = r8
            r8 = r26
            r34 = r9
            r9 = r22
            r35 = r10
            r10 = r30
            r36 = r11
            r11 = r33
            r37 = r12
            r12 = r34
            r38 = r13
            r13 = r41
            r39 = -1
            r14 = r27
            com.google.android.exoplayer2.source.dash.a.c$a r0 = a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            com.google.android.exoplayer2.Format r1 = r0.f32918a
            java.lang.String r1 = r1.f31069i
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x01a0
            boolean r2 = com.google.android.exoplayer2.g.o.b(r1)
            if (r2 == 0) goto L_0x0190
            r14 = 2
            goto L_0x01a1
        L_0x0190:
            boolean r2 = com.google.android.exoplayer2.g.o.a((java.lang.String) r1)
            if (r2 == 0) goto L_0x0198
            r14 = 1
            goto L_0x01a1
        L_0x0198:
            boolean r1 = b((java.lang.String) r1)
            if (r1 == 0) goto L_0x01a0
            r14 = 3
            goto L_0x01a1
        L_0x01a0:
            r14 = -1
        L_0x01a1:
            int r1 = a((int) r15, (int) r14)
            r2 = r32
            r2.add(r0)
            r6 = r41
            r3 = r1
            r5 = r31
            r4 = r35
            r1 = r40
            goto L_0x022b
        L_0x01b5:
            r15 = r3
            r30 = r4
            r31 = r5
            r2 = r6
            r41 = r7
            r33 = r8
            r34 = r9
            r35 = r10
            r36 = r11
            r37 = r12
            r38 = r13
            r39 = -1
            java.lang.String r0 = "SegmentBase"
            r1 = r40
            boolean r0 = com.google.android.exoplayer2.g.af.b(r1, r0)
            if (r0 == 0) goto L_0x01e6
            r0 = r27
            com.google.android.exoplayer2.source.dash.a.j$e r0 = (com.google.android.exoplayer2.source.dash.a.j.e) r0
            com.google.android.exoplayer2.source.dash.a.j$e r0 = a((org.xmlpull.v1.XmlPullParser) r1, (com.google.android.exoplayer2.source.dash.a.j.e) r0)
        L_0x01dd:
            r6 = r41
        L_0x01df:
            r27 = r0
            r5 = r31
            r4 = r35
            goto L_0x022b
        L_0x01e6:
            java.lang.String r0 = "SegmentList"
            boolean r0 = com.google.android.exoplayer2.g.af.b(r1, r0)
            if (r0 == 0) goto L_0x01f7
            r0 = r27
            com.google.android.exoplayer2.source.dash.a.j$b r0 = (com.google.android.exoplayer2.source.dash.a.j.b) r0
            com.google.android.exoplayer2.source.dash.a.j$b r0 = a((org.xmlpull.v1.XmlPullParser) r1, (com.google.android.exoplayer2.source.dash.a.j.b) r0)
            goto L_0x01dd
        L_0x01f7:
            java.lang.String r0 = "SegmentTemplate"
            boolean r0 = com.google.android.exoplayer2.g.af.b(r1, r0)
            if (r0 == 0) goto L_0x020a
            r0 = r27
            com.google.android.exoplayer2.source.dash.a.j$c r0 = (com.google.android.exoplayer2.source.dash.a.j.c) r0
            r6 = r41
            com.google.android.exoplayer2.source.dash.a.j$c r0 = a((org.xmlpull.v1.XmlPullParser) r1, (com.google.android.exoplayer2.source.dash.a.j.c) r0, (java.util.List<com.google.android.exoplayer2.source.dash.a.d>) r6)
            goto L_0x01df
        L_0x020a:
            r6 = r41
            java.lang.String r0 = "InbandEventStream"
            boolean r4 = com.google.android.exoplayer2.g.af.b(r1, r0)
            if (r4 == 0) goto L_0x021e
            com.google.android.exoplayer2.source.dash.a.d r0 = a((org.xmlpull.v1.XmlPullParser) r1, (java.lang.String) r0)
            r4 = r35
            r4.add(r0)
            goto L_0x0229
        L_0x021e:
            r4 = r35
            boolean r0 = com.google.android.exoplayer2.g.af.b(r40)
            if (r0 == 0) goto L_0x0229
            h(r40)
        L_0x0229:
            r5 = r31
        L_0x022b:
            java.lang.String r0 = "AdaptationSet"
            boolean r0 = com.google.android.exoplayer2.g.af.a(r1, r0)
            if (r0 == 0) goto L_0x02c1
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r2.size()
            r0.<init>(r1)
            r1 = 0
        L_0x023d:
            int r5 = r2.size()
            if (r1 >= r5) goto L_0x02b5
            java.lang.Object r5 = r2.get(r1)
            com.google.android.exoplayer2.source.dash.a.c$a r5 = (com.google.android.exoplayer2.source.dash.a.c.a) r5
            com.google.android.exoplayer2.Format r7 = r5.f32918a
            java.lang.String r8 = r5.f32921d
            if (r8 == 0) goto L_0x0252
            java.lang.String r8 = r5.f32921d
            goto L_0x0254
        L_0x0252:
            r8 = r28
        L_0x0254:
            java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData$SchemeData> r9 = r5.f32922e
            r10 = r36
            r9.addAll(r10)
            boolean r11 = r9.isEmpty()
            if (r11 != 0) goto L_0x026d
            a((java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData>) r9)
            com.google.android.exoplayer2.drm.DrmInitData r11 = new com.google.android.exoplayer2.drm.DrmInitData
            r11.<init>((java.lang.String) r8, (java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData>) r9)
            com.google.android.exoplayer2.Format r7 = r7.a((com.google.android.exoplayer2.drm.DrmInitData) r11)
        L_0x026d:
            r20 = r7
            java.util.ArrayList<com.google.android.exoplayer2.source.dash.a.d> r7 = r5.f32923f
            r7.addAll(r4)
            long r8 = r5.f32924g
            java.lang.String r11 = r5.f32919b
            com.google.android.exoplayer2.source.dash.a.j r5 = r5.f32920c
            boolean r12 = r5 instanceof com.google.android.exoplayer2.source.dash.a.j.e
            if (r12 == 0) goto L_0x0290
            com.google.android.exoplayer2.source.dash.a.i$b r12 = new com.google.android.exoplayer2.source.dash.a.i$b
            r22 = r5
            com.google.android.exoplayer2.source.dash.a.j$e r22 = (com.google.android.exoplayer2.source.dash.a.j.e) r22
            r17 = r12
            r18 = r8
            r21 = r11
            r23 = r7
            r17.<init>(r18, r20, r21, r22, r23)
            goto L_0x02a5
        L_0x0290:
            boolean r12 = r5 instanceof com.google.android.exoplayer2.source.dash.a.j.a
            if (r12 == 0) goto L_0x02ad
            com.google.android.exoplayer2.source.dash.a.i$a r12 = new com.google.android.exoplayer2.source.dash.a.i$a
            r22 = r5
            com.google.android.exoplayer2.source.dash.a.j$a r22 = (com.google.android.exoplayer2.source.dash.a.j.a) r22
            r17 = r12
            r18 = r8
            r21 = r11
            r23 = r7
            r17.<init>(r18, r20, r21, r22, r23)
        L_0x02a5:
            r0.add(r12)
            int r1 = r1 + 1
            r36 = r10
            goto L_0x023d
        L_0x02ad:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "segmentBase must be of type SingleSegmentBase or MultiSegmentBase"
            r0.<init>(r1)
            throw r0
        L_0x02b5:
            com.google.android.exoplayer2.source.dash.a.a r7 = new com.google.android.exoplayer2.source.dash.a.a
            r1 = r7
            r2 = r16
            r4 = r0
            r5 = r34
            r1.<init>(r2, r3, r4, r5, r6)
            return r7
        L_0x02c1:
            r15 = r1
            r10 = r4
            r7 = r6
            r4 = r30
            r8 = r33
            r9 = r34
            r11 = r36
            r12 = r37
            r13 = r38
            r14 = -1
            r6 = r2
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.a.c.a(org.xmlpull.v1.XmlPullParser, java.lang.String, com.google.android.exoplayer2.source.dash.a.j):com.google.android.exoplayer2.source.dash.a.a");
    }

    private static int a(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if (H5ResourceHandlerUtil.AUDIO.equals(attributeValue)) {
            return 1;
        }
        if (H5ResourceHandlerUtil.VIDEO.equals(attributeValue)) {
            return 2;
        }
        return CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX.equals(attributeValue) ? 3 : -1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0170 A[LOOP:2: B:42:0x00bb->B:87:0x0170, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x015e A[EDGE_INSN: B:91:0x015e->B:82:0x015e ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> b(org.xmlpull.v1.XmlPullParser r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = 0
            java.lang.String r1 = "schemeIdUri"
            java.lang.String r1 = r15.getAttributeValue(r0, r1)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x00b6
            java.lang.String r1 = com.google.android.exoplayer2.g.ae.d((java.lang.String) r1)
            r4 = -1
            int r5 = r1.hashCode()
            r6 = 489446379(0x1d2c5beb, float:2.281153E-21)
            r7 = 2
            if (r5 == r6) goto L_0x003b
            r6 = 755418770(0x2d06c692, float:7.66111E-12)
            if (r5 == r6) goto L_0x0030
            r6 = 1812765994(0x6c0c9d2a, float:6.799672E26)
            if (r5 == r6) goto L_0x0025
            goto L_0x0045
        L_0x0025:
            java.lang.String r5 = "urn:mpeg:dash:mp4protection:2011"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0045
            r4 = 0
            goto L_0x0045
        L_0x0030:
            java.lang.String r5 = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0045
            r4 = 2
            goto L_0x0045
        L_0x003b:
            java.lang.String r5 = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0045
            r4 = 1
        L_0x0045:
            if (r4 == 0) goto L_0x0055
            if (r4 == r2) goto L_0x0050
            if (r4 == r7) goto L_0x004d
            goto L_0x00b6
        L_0x004d:
            java.util.UUID r1 = com.google.android.exoplayer2.c.f31287d
            goto L_0x0052
        L_0x0050:
            java.util.UUID r1 = com.google.android.exoplayer2.c.f31288e
        L_0x0052:
            r4 = r0
            goto L_0x00b8
        L_0x0055:
            java.lang.String r1 = "value"
            java.lang.String r1 = r15.getAttributeValue(r0, r1)
            int r4 = r15.getAttributeCount()
            r5 = 0
        L_0x0061:
            if (r5 >= r4) goto L_0x007b
            java.lang.String r6 = r15.getAttributeName(r5)
            java.lang.String r6 = com.google.android.exoplayer2.g.af.a((java.lang.String) r6)
            java.lang.String r7 = "default_KID"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0078
            java.lang.String r4 = r15.getAttributeValue(r5)
            goto L_0x007c
        L_0x0078:
            int r5 = r5 + 1
            goto L_0x0061
        L_0x007b:
            r4 = r0
        L_0x007c:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x00b0
            java.lang.String r5 = "00000000-0000-0000-0000-000000000000"
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x00b0
            java.lang.String r5 = "\\s+"
            java.lang.String[] r4 = r4.split(r5)
            int r5 = r4.length
            java.util.UUID[] r5 = new java.util.UUID[r5]
            r6 = 0
        L_0x0094:
            int r7 = r4.length
            if (r6 >= r7) goto L_0x00a2
            r7 = r4[r6]
            java.util.UUID r7 = java.util.UUID.fromString(r7)
            r5[r6] = r7
            int r6 = r6 + 1
            goto L_0x0094
        L_0x00a2:
            java.util.UUID r4 = com.google.android.exoplayer2.c.f31285b
            byte[] r4 = com.google.android.exoplayer2.extractor.mp4.h.a(r4, r5, r0)
            java.util.UUID r5 = com.google.android.exoplayer2.c.f31285b
            r6 = r0
            r7 = 0
            r14 = r5
            r5 = r1
            r1 = r14
            goto L_0x00bb
        L_0x00b0:
            r4 = r0
            r6 = r4
            r5 = r1
            r7 = 0
            r1 = r6
            goto L_0x00bb
        L_0x00b6:
            r1 = r0
            r4 = r1
        L_0x00b8:
            r5 = r4
            r6 = r5
            r7 = 0
        L_0x00bb:
            r15.next()
            java.lang.String r8 = "ms:laurl"
            boolean r8 = com.google.android.exoplayer2.g.af.b(r15, r8)
            if (r8 == 0) goto L_0x00d2
            java.lang.String r6 = "licenseUrl"
            java.lang.String r6 = r15.getAttributeValue(r0, r6)
        L_0x00cc:
            r9 = r1
            r12 = r4
        L_0x00ce:
            r10 = r6
            r13 = r7
            goto L_0x0156
        L_0x00d2:
            java.lang.String r8 = "widevine:license"
            boolean r8 = com.google.android.exoplayer2.g.af.b(r15, r8)
            if (r8 == 0) goto L_0x00ef
            java.lang.String r7 = "robustness_level"
            java.lang.String r7 = r15.getAttributeValue(r0, r7)
            if (r7 == 0) goto L_0x00ed
            java.lang.String r8 = "HW"
            boolean r7 = r7.startsWith(r8)
            if (r7 == 0) goto L_0x00ed
            r7 = 1
            goto L_0x00cc
        L_0x00ed:
            r7 = 0
            goto L_0x00cc
        L_0x00ef:
            r8 = 4
            if (r4 != 0) goto L_0x0129
            boolean r9 = com.google.android.exoplayer2.g.af.b(r15)
            if (r9 == 0) goto L_0x010a
            java.lang.String r9 = r15.getName()
            java.lang.String r9 = com.google.android.exoplayer2.g.af.a((java.lang.String) r9)
            java.lang.String r10 = "pssh"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x010a
            r9 = 1
            goto L_0x010b
        L_0x010a:
            r9 = 0
        L_0x010b:
            if (r9 == 0) goto L_0x0129
            int r9 = r15.next()
            if (r9 != r8) goto L_0x0129
            java.lang.String r1 = r15.getText()
            byte[] r1 = android.util.Base64.decode(r1, r3)
            java.util.UUID r4 = com.google.android.exoplayer2.extractor.mp4.h.a(r1)
            if (r4 != 0) goto L_0x0126
            com.google.android.exoplayer2.g.l.c()
            r12 = r0
            goto L_0x0127
        L_0x0126:
            r12 = r1
        L_0x0127:
            r9 = r4
            goto L_0x00ce
        L_0x0129:
            if (r4 != 0) goto L_0x0151
            java.util.UUID r9 = com.google.android.exoplayer2.c.f31288e
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x0151
            java.lang.String r9 = "mspr:pro"
            boolean r9 = com.google.android.exoplayer2.g.af.b(r15, r9)
            if (r9 == 0) goto L_0x0151
            int r9 = r15.next()
            if (r9 != r8) goto L_0x0151
            java.util.UUID r4 = com.google.android.exoplayer2.c.f31288e
            java.lang.String r8 = r15.getText()
            byte[] r8 = android.util.Base64.decode(r8, r3)
            byte[] r4 = com.google.android.exoplayer2.extractor.mp4.h.a(r4, r0, r8)
            goto L_0x00cc
        L_0x0151:
            h(r15)
            goto L_0x00cc
        L_0x0156:
            java.lang.String r1 = "ContentProtection"
            boolean r1 = com.google.android.exoplayer2.g.af.a(r15, r1)
            if (r1 == 0) goto L_0x0170
            if (r9 == 0) goto L_0x016a
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r15 = new com.google.android.exoplayer2.drm.DrmInitData$SchemeData
            java.lang.String r11 = "video/mp4"
            r8 = r15
            r8.<init>(r9, r10, r11, r12, r13)
            goto L_0x016b
        L_0x016a:
            r15 = r0
        L_0x016b:
            android.util.Pair r15 = android.util.Pair.create(r5, r15)
            return r15
        L_0x0170:
            r1 = r9
            r6 = r10
            r4 = r12
            r7 = r13
            goto L_0x00bb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.a.c.b(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x021a A[LOOP:0: B:1:0x0057->B:95:0x021a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0100 A[EDGE_INSN: B:96:0x0100->B:36:0x0100 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.source.dash.a.c.a a(org.xmlpull.v1.XmlPullParser r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, int r28, int r29, float r30, int r31, int r32, java.lang.String r33, java.util.List<com.google.android.exoplayer2.source.dash.a.d> r34, java.util.List<com.google.android.exoplayer2.source.dash.a.d> r35, java.util.List<com.google.android.exoplayer2.source.dash.a.d> r36, com.google.android.exoplayer2.source.dash.a.j r37) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = r23
            r1 = 0
            java.lang.String r2 = "id"
            java.lang.String r3 = r0.getAttributeValue(r1, r2)
            r2 = -1
            java.lang.String r4 = "bandwidth"
            int r9 = a((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r4, (int) r2)
            java.lang.String r4 = "mimeType"
            r5 = r26
            java.lang.String r5 = b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r4, (java.lang.String) r5)
            java.lang.String r4 = "codecs"
            r6 = r27
            java.lang.String r7 = b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r4, (java.lang.String) r6)
            java.lang.String r4 = "width"
            r6 = r28
            int r10 = a((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r4, (int) r6)
            java.lang.String r4 = "height"
            r6 = r29
            int r11 = a((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r4, (int) r6)
            r4 = r30
            float r12 = a((org.xmlpull.v1.XmlPullParser) r0, (float) r4)
            java.lang.String r4 = "audioSamplingRate"
            r6 = r32
            int r13 = a((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r4, (int) r6)
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r6 = 0
            r8 = r24
            r17 = r31
            r16 = r37
            r18 = r1
        L_0x0057:
            r23.next()
            java.lang.String r1 = "BaseURL"
            boolean r1 = com.google.android.exoplayer2.g.af.b(r0, r1)
            if (r1 == 0) goto L_0x006b
            if (r6 != 0) goto L_0x00f7
            java.lang.String r1 = c(r0, r8)
            r6 = 1
            goto L_0x00f8
        L_0x006b:
            java.lang.String r1 = "AudioChannelConfiguration"
            boolean r1 = com.google.android.exoplayer2.g.af.b(r0, r1)
            if (r1 == 0) goto L_0x007b
            int r1 = g(r23)
            r17 = r1
            goto L_0x00f7
        L_0x007b:
            java.lang.String r1 = "SegmentBase"
            boolean r1 = com.google.android.exoplayer2.g.af.b(r0, r1)
            if (r1 == 0) goto L_0x008e
            r1 = r16
            com.google.android.exoplayer2.source.dash.a.j$e r1 = (com.google.android.exoplayer2.source.dash.a.j.e) r1
            com.google.android.exoplayer2.source.dash.a.j$e r1 = a((org.xmlpull.v1.XmlPullParser) r0, (com.google.android.exoplayer2.source.dash.a.j.e) r1)
        L_0x008b:
            r16 = r1
            goto L_0x00f7
        L_0x008e:
            java.lang.String r1 = "SegmentList"
            boolean r1 = com.google.android.exoplayer2.g.af.b(r0, r1)
            if (r1 == 0) goto L_0x009f
            r1 = r16
            com.google.android.exoplayer2.source.dash.a.j$b r1 = (com.google.android.exoplayer2.source.dash.a.j.b) r1
            com.google.android.exoplayer2.source.dash.a.j$b r1 = a((org.xmlpull.v1.XmlPullParser) r0, (com.google.android.exoplayer2.source.dash.a.j.b) r1)
            goto L_0x008b
        L_0x009f:
            java.lang.String r1 = "SegmentTemplate"
            boolean r1 = com.google.android.exoplayer2.g.af.b(r0, r1)
            if (r1 == 0) goto L_0x00b2
            r1 = r16
            com.google.android.exoplayer2.source.dash.a.j$c r1 = (com.google.android.exoplayer2.source.dash.a.j.c) r1
            r2 = r36
            com.google.android.exoplayer2.source.dash.a.j$c r1 = a((org.xmlpull.v1.XmlPullParser) r0, (com.google.android.exoplayer2.source.dash.a.j.c) r1, (java.util.List<com.google.android.exoplayer2.source.dash.a.d>) r2)
            goto L_0x008b
        L_0x00b2:
            r2 = r36
            java.lang.String r1 = "ContentProtection"
            boolean r1 = com.google.android.exoplayer2.g.af.b(r0, r1)
            if (r1 == 0) goto L_0x00d4
            android.util.Pair r1 = b((org.xmlpull.v1.XmlPullParser) r23)
            java.lang.Object r2 = r1.first
            if (r2 == 0) goto L_0x00ca
            java.lang.Object r2 = r1.first
            r18 = r2
            java.lang.String r18 = (java.lang.String) r18
        L_0x00ca:
            java.lang.Object r2 = r1.second
            if (r2 == 0) goto L_0x00f7
            java.lang.Object r1 = r1.second
            r15.add(r1)
            goto L_0x00f7
        L_0x00d4:
            java.lang.String r1 = "InbandEventStream"
            boolean r2 = com.google.android.exoplayer2.g.af.b(r0, r1)
            if (r2 == 0) goto L_0x00e4
            com.google.android.exoplayer2.source.dash.a.d r1 = a((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r1)
            r14.add(r1)
            goto L_0x00f7
        L_0x00e4:
            java.lang.String r1 = "SupplementalProperty"
            boolean r2 = com.google.android.exoplayer2.g.af.b(r0, r1)
            if (r2 == 0) goto L_0x00f4
            com.google.android.exoplayer2.source.dash.a.d r1 = a((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r1)
            r4.add(r1)
            goto L_0x00f7
        L_0x00f4:
            h(r23)
        L_0x00f7:
            r1 = r8
        L_0x00f8:
            java.lang.String r2 = "Representation"
            boolean r2 = com.google.android.exoplayer2.g.af.a(r0, r2)
            if (r2 == 0) goto L_0x021a
            boolean r0 = com.google.android.exoplayer2.g.o.a((java.lang.String) r5)
            java.lang.String r2 = "application/cea-608"
            java.lang.String r6 = "application/cea-708"
            if (r0 == 0) goto L_0x010f
            java.lang.String r0 = com.google.android.exoplayer2.g.o.e(r7)
            goto L_0x016b
        L_0x010f:
            boolean r0 = com.google.android.exoplayer2.g.o.b(r5)
            if (r0 == 0) goto L_0x011a
            java.lang.String r0 = com.google.android.exoplayer2.g.o.d(r7)
            goto L_0x016b
        L_0x011a:
            boolean r0 = b((java.lang.String) r5)
            if (r0 == 0) goto L_0x0122
            r0 = r5
            goto L_0x016b
        L_0x0122:
            java.lang.String r0 = "application/mp4"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0144
            if (r7 == 0) goto L_0x016a
            java.lang.String r0 = "stpp"
            boolean r0 = r7.startsWith(r0)
            if (r0 == 0) goto L_0x0138
            java.lang.String r0 = "application/ttml+xml"
            goto L_0x016b
        L_0x0138:
            java.lang.String r0 = "wvtt"
            boolean r0 = r7.startsWith(r0)
            if (r0 == 0) goto L_0x016a
            java.lang.String r0 = "application/x-mp4-vtt"
            goto L_0x016b
        L_0x0144:
            java.lang.String r0 = "application/x-rawcc"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x016a
            if (r7 == 0) goto L_0x016a
            java.lang.String r0 = "cea708"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L_0x0158
            r0 = r6
            goto L_0x016b
        L_0x0158:
            java.lang.String r0 = "eia608"
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto L_0x0168
            java.lang.String r0 = "cea608"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L_0x016a
        L_0x0168:
            r0 = r2
            goto L_0x016b
        L_0x016a:
            r0 = 0
        L_0x016b:
            int r19 = a((java.util.List<com.google.android.exoplayer2.source.dash.a.d>) r34)
            int r8 = b((java.util.List<com.google.android.exoplayer2.source.dash.a.d>) r34)
            int r20 = c((java.util.List<com.google.android.exoplayer2.source.dash.a.d>) r35)
            r20 = r8 | r20
            if (r0 == 0) goto L_0x01ea
            java.lang.String r8 = "audio/eac3"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0187
            java.lang.String r0 = f((java.util.List<com.google.android.exoplayer2.source.dash.a.d>) r4)
        L_0x0187:
            boolean r4 = com.google.android.exoplayer2.g.o.b(r0)
            if (r4 == 0) goto L_0x01a0
            r8 = 0
            r13 = 0
            r4 = r25
            r6 = r0
            r21 = r14
            r14 = r19
            r22 = r15
            r15 = r20
            com.google.android.exoplayer2.Format r0 = com.google.android.exoplayer2.Format.a((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (com.google.android.exoplayer2.metadata.Metadata) r8, (int) r9, (int) r10, (int) r11, (float) r12, (java.util.List<byte[]>) r13, (int) r14, (int) r15)
            goto L_0x01fc
        L_0x01a0:
            r21 = r14
            r22 = r15
            boolean r4 = com.google.android.exoplayer2.g.o.a((java.lang.String) r0)
            if (r4 == 0) goto L_0x01bd
            r8 = 0
            r12 = 0
            r4 = r25
            r6 = r0
            r10 = r17
            r11 = r13
            r13 = r19
            r14 = r20
            r15 = r33
            com.google.android.exoplayer2.Format r0 = com.google.android.exoplayer2.Format.a((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (com.google.android.exoplayer2.metadata.Metadata) r8, (int) r9, (int) r10, (int) r11, (java.util.List<byte[]>) r12, (int) r13, (int) r14, (java.lang.String) r15)
            goto L_0x01fc
        L_0x01bd:
            boolean r4 = b((java.lang.String) r0)
            if (r4 == 0) goto L_0x01ee
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x01cf
            int r2 = d((java.util.List<com.google.android.exoplayer2.source.dash.a.d>) r35)
        L_0x01cd:
            r12 = r2
            goto L_0x01db
        L_0x01cf:
            boolean r2 = r6.equals(r0)
            if (r2 == 0) goto L_0x01da
            int r2 = e((java.util.List<com.google.android.exoplayer2.source.dash.a.d>) r35)
            goto L_0x01cd
        L_0x01da:
            r12 = -1
        L_0x01db:
            r4 = r25
            r6 = r0
            r8 = r9
            r9 = r19
            r10 = r20
            r11 = r33
            com.google.android.exoplayer2.Format r0 = com.google.android.exoplayer2.Format.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            goto L_0x01fc
        L_0x01ea:
            r21 = r14
            r22 = r15
        L_0x01ee:
            r6 = r0
            r4 = r25
            r8 = r9
            r9 = r19
            r10 = r20
            r11 = r33
            com.google.android.exoplayer2.Format r0 = com.google.android.exoplayer2.Format.a((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (int) r8, (int) r9, (int) r10, (java.lang.String) r11)
        L_0x01fc:
            if (r16 == 0) goto L_0x0201
            r2 = r16
            goto L_0x0206
        L_0x0201:
            com.google.android.exoplayer2.source.dash.a.j$e r2 = new com.google.android.exoplayer2.source.dash.a.j$e
            r2.<init>()
        L_0x0206:
            com.google.android.exoplayer2.source.dash.a.c$a r3 = new com.google.android.exoplayer2.source.dash.a.c$a
            r23 = r3
            r24 = r0
            r25 = r1
            r26 = r2
            r27 = r18
            r28 = r22
            r29 = r21
            r23.<init>(r24, r25, r26, r27, r28, r29)
            return r3
        L_0x021a:
            r8 = r1
            r1 = 0
            r2 = -1
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.a.c.a(org.xmlpull.v1.XmlPullParser, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, java.util.List, java.util.List, java.util.List, com.google.android.exoplayer2.source.dash.a.j):com.google.android.exoplayer2.source.dash.a.c$a");
    }

    private static j.e a(XmlPullParser xmlPullParser, j.e eVar) throws XmlPullParserException, IOException {
        long j;
        long j2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        j.e eVar2 = eVar;
        long c2 = c(xmlPullParser2, "timescale", eVar2 != null ? eVar2.f32957b : 1);
        long j3 = 0;
        long c3 = c(xmlPullParser2, "presentationTimeOffset", eVar2 != null ? eVar2.f32958c : 0);
        long j4 = eVar2 != null ? eVar2.f32968d : 0;
        if (eVar2 != null) {
            j3 = eVar2.f32969e;
        }
        h hVar = null;
        String attributeValue = xmlPullParser2.getAttributeValue((String) null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            long parseLong = Long.parseLong(split[0]);
            j = (Long.parseLong(split[1]) - parseLong) + 1;
            j2 = parseLong;
        } else {
            j = j3;
            j2 = j4;
        }
        if (eVar2 != null) {
            hVar = eVar2.f32956a;
        }
        do {
            xmlPullParser.next();
            if (af.b(xmlPullParser2, "Initialization")) {
                hVar = e(xmlPullParser);
            } else {
                h(xmlPullParser);
            }
        } while (!af.a(xmlPullParser2, "SegmentBase"));
        return new j.e(hVar, c2, c3, j2, j);
    }

    private static j.b a(XmlPullParser xmlPullParser, j.b bVar) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        j.b bVar2 = bVar;
        long j = 1;
        long c2 = c(xmlPullParser2, "timescale", bVar2 != null ? bVar2.f32957b : 1);
        long c3 = c(xmlPullParser2, "presentationTimeOffset", bVar2 != null ? bVar2.f32958c : 0);
        long c4 = c(xmlPullParser2, AppConstants.DURATION, bVar2 != null ? bVar2.f32960e : -9223372036854775807L);
        if (bVar2 != null) {
            j = bVar2.f32959d;
        }
        long c5 = c(xmlPullParser2, "startNumber", j);
        List list = null;
        h hVar = null;
        List<j.d> list2 = null;
        do {
            xmlPullParser.next();
            if (af.b(xmlPullParser2, "Initialization")) {
                hVar = e(xmlPullParser);
            } else if (af.b(xmlPullParser2, "SegmentTimeline")) {
                list2 = d(xmlPullParser);
            } else if (af.b(xmlPullParser2, "SegmentURL")) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(a(xmlPullParser2, "media", "mediaRange"));
            } else {
                h(xmlPullParser);
            }
        } while (!af.a(xmlPullParser2, "SegmentList"));
        if (bVar2 != null) {
            if (hVar == null) {
                hVar = bVar2.f32956a;
            }
            if (list2 == null) {
                list2 = bVar2.f32961f;
            }
            if (list == null) {
                list = bVar2.f32962g;
            }
        }
        return new j.b(hVar, c2, c3, c5, c4, list2, list);
    }

    private static j.c a(XmlPullParser xmlPullParser, j.c cVar, List<d> list) throws XmlPullParserException, IOException {
        long j;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        j.c cVar2 = cVar;
        long j2 = 1;
        long c2 = c(xmlPullParser2, "timescale", cVar2 != null ? cVar2.f32957b : 1);
        long c3 = c(xmlPullParser2, "presentationTimeOffset", cVar2 != null ? cVar2.f32958c : 0);
        long c4 = c(xmlPullParser2, AppConstants.DURATION, cVar2 != null ? cVar2.f32960e : -9223372036854775807L);
        if (cVar2 != null) {
            j2 = cVar2.f32959d;
        }
        long c5 = c(xmlPullParser2, "startNumber", j2);
        int i2 = 0;
        while (true) {
            if (i2 >= list.size()) {
                j = -1;
                break;
            }
            d dVar = list.get(i2);
            if ("http://dashif.org/guidelines/last-segment-number".equalsIgnoreCase(dVar.f32925a)) {
                j = Long.parseLong(dVar.f32926b);
                break;
            }
            i2++;
        }
        long j3 = j;
        h hVar = null;
        l a2 = a(xmlPullParser2, "media", cVar2 != null ? cVar2.f32964h : null);
        l a3 = a(xmlPullParser2, "initialization", cVar2 != null ? cVar2.f32963g : null);
        List<j.d> list2 = null;
        do {
            xmlPullParser.next();
            if (af.b(xmlPullParser2, "Initialization")) {
                hVar = e(xmlPullParser);
            } else if (af.b(xmlPullParser2, "SegmentTimeline")) {
                list2 = d(xmlPullParser);
            } else {
                h(xmlPullParser);
            }
        } while (!af.a(xmlPullParser2, "SegmentTemplate"));
        if (cVar2 != null) {
            if (hVar == null) {
                hVar = cVar2.f32956a;
            }
            if (list2 == null) {
                list2 = cVar2.f32961f;
            }
        }
        return new j.c(hVar, c2, c3, c5, j3, c4, list2, a3, a2);
    }

    private static e c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String b2 = b(xmlPullParser2, "schemeIdUri", "");
        String b3 = b(xmlPullParser2, "value", "");
        long c2 = c(xmlPullParser2, "timescale", 1);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(512);
        while (true) {
            xmlPullParser.next();
            if (af.b(xmlPullParser2, "Event")) {
                long c3 = c(xmlPullParser2, "id", 0);
                long c4 = c(xmlPullParser2, AppConstants.DURATION, -9223372036854775807L);
                long c5 = c(xmlPullParser2, "presentationTime", 0);
                long j = c2;
                long b4 = ae.b(c4, 1000, j);
                long b5 = ae.b(c5, 1000000, j);
                String b6 = b(xmlPullParser2, "messageData", (String) null);
                byte[] a2 = a(xmlPullParser2, byteArrayOutputStream2);
                Long valueOf = Long.valueOf(b5);
                if (b6 == null) {
                    bArr = a2;
                } else {
                    bArr = ae.c(b6);
                }
                long j2 = b4;
                byteArrayOutputStream = byteArrayOutputStream2;
                EventMessage eventMessage = r3;
                EventMessage eventMessage2 = new EventMessage(b2, b3, j2, c3, bArr);
                arrayList.add(Pair.create(valueOf, eventMessage));
            } else {
                byteArrayOutputStream = byteArrayOutputStream2;
                h(xmlPullParser);
            }
            if (af.a(xmlPullParser2, "EventStream")) {
                break;
            }
            byteArrayOutputStream2 = byteArrayOutputStream;
        }
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Pair pair = (Pair) arrayList.get(i2);
            jArr[i2] = ((Long) pair.first).longValue();
            eventMessageArr[i2] = (EventMessage) pair.second;
        }
        return new e(b2, b3, c2, jArr, eventMessageArr);
    }

    private static byte[] a(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8);
        xmlPullParser.nextToken();
        while (!af.a(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument((String) null, Boolean.FALSE);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i2), xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeValue(i2));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        newSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private static List<j.d> d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long j = 0;
        do {
            xmlPullParser.next();
            if (af.b(xmlPullParser, "S")) {
                j = c(xmlPullParser, "t", j);
                long c2 = c(xmlPullParser, "d", -9223372036854775807L);
                int a2 = a(xmlPullParser, "r", 0) + 1;
                for (int i2 = 0; i2 < a2; i2++) {
                    arrayList.add(a(j, c2));
                    j += c2;
                }
            } else {
                h(xmlPullParser);
            }
        } while (!af.a(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }

    private static j.d a(long j, long j2) {
        return new j.d(j, j2);
    }

    private static l a(XmlPullParser xmlPullParser, String str, l lVar) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue != null ? l.a(attributeValue) : lVar;
    }

    private static h e(XmlPullParser xmlPullParser) {
        return a(xmlPullParser, "sourceURL", "range");
    }

    private static h a(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, str2);
        long j2 = -1;
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j = Long.parseLong(split[0]);
            if (split.length == 2) {
                j2 = (Long.parseLong(split[1]) - j) + 1;
            }
        } else {
            j = 0;
        }
        return a(attributeValue, j, j2);
    }

    private static h a(String str, long j, long j2) {
        return new h(str, j, j2);
    }

    private static g f(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String str = null;
        String b2 = b(xmlPullParser, "moreInformationURL", (String) null);
        String b3 = b(xmlPullParser, "lang", (String) null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (af.b(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (af.b(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (af.b(xmlPullParser, "Copyright")) {
                str3 = xmlPullParser.nextText();
            } else {
                h(xmlPullParser);
            }
            String str4 = str3;
            if (af.a(xmlPullParser, "ProgramInformation")) {
                return new g(str, str2, str4, b2, b3);
            }
            str3 = str4;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int g(org.xmlpull.v1.XmlPullParser r7) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = 0
            java.lang.String r1 = "schemeIdUri"
            java.lang.String r1 = b((org.xmlpull.v1.XmlPullParser) r7, (java.lang.String) r1, (java.lang.String) r0)
            java.lang.String r2 = "urn:mpeg:dash:23003:3:audio_channel_configuration:2011"
            boolean r2 = r2.equals(r1)
            java.lang.String r3 = "value"
            r4 = 2
            r5 = 1
            r6 = -1
            if (r2 == 0) goto L_0x001b
            int r4 = a((org.xmlpull.v1.XmlPullParser) r7, (java.lang.String) r3, (int) r6)
            goto L_0x0071
        L_0x001b:
            java.lang.String r2 = "tag:dolby.com,2014:dash:audio_channel_configuration:2011"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0070
            java.lang.String r0 = r7.getAttributeValue(r0, r3)
            java.lang.String r0 = com.google.android.exoplayer2.g.ae.d((java.lang.String) r0)
            if (r0 == 0) goto L_0x0070
            int r1 = r0.hashCode()
            r2 = 3
            switch(r1) {
                case 1596796: goto L_0x0055;
                case 2937391: goto L_0x004b;
                case 3094035: goto L_0x0041;
                case 3133436: goto L_0x0037;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x005f
        L_0x0037:
            java.lang.String r1 = "fa01"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005f
            r0 = 3
            goto L_0x0060
        L_0x0041:
            java.lang.String r1 = "f801"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005f
            r0 = 2
            goto L_0x0060
        L_0x004b:
            java.lang.String r1 = "a000"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005f
            r0 = 1
            goto L_0x0060
        L_0x0055:
            java.lang.String r1 = "4000"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005f
            r0 = 0
            goto L_0x0060
        L_0x005f:
            r0 = -1
        L_0x0060:
            if (r0 == 0) goto L_0x006e
            if (r0 == r5) goto L_0x0071
            if (r0 == r4) goto L_0x006c
            if (r0 == r2) goto L_0x0069
            goto L_0x0070
        L_0x0069:
            r4 = 8
            goto L_0x0071
        L_0x006c:
            r4 = 6
            goto L_0x0071
        L_0x006e:
            r4 = 1
            goto L_0x0071
        L_0x0070:
            r4 = -1
        L_0x0071:
            r7.next()
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = com.google.android.exoplayer2.g.af.a(r7, r0)
            if (r0 == 0) goto L_0x0071
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.a.c.g(org.xmlpull.v1.XmlPullParser):int");
    }

    private static int a(List<d> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar = list.get(i2);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(dVar.f32925a) && "main".equals(dVar.f32926b)) {
                return 1;
            }
        }
        return 0;
    }

    private static int b(List<d> list) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            d dVar = list.get(i3);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(dVar.f32925a)) {
                i2 |= a(dVar.f32926b);
            }
        }
        return i2;
    }

    private static int c(List<d> list) {
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            d dVar = list.get(i4);
            if ("urn:mpeg:dash:role:2011".equalsIgnoreCase(dVar.f32925a)) {
                i2 = a(dVar.f32926b);
            } else if (!"urn:tva:metadata:cs:AudioPurposeCS:2007".equalsIgnoreCase(dVar.f32925a)) {
            } else {
                String str = dVar.f32926b;
                if (str != null) {
                    char c2 = 65535;
                    switch (str.hashCode()) {
                        case 49:
                            if (str.equals("1")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 50:
                            if (str.equals("2")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 51:
                            if (str.equals("3")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 52:
                            if (str.equals("4")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 54:
                            if (str.equals("6")) {
                                c2 = 4;
                                break;
                            }
                            break;
                    }
                    if (c2 == 0) {
                        i2 = 512;
                    } else if (c2 == 1) {
                        i2 = EmiUtil.EMI_PLAN_REQUEST_CODE;
                    } else if (c2 == 2) {
                        i2 = 4;
                    } else if (c2 == 3) {
                        i2 = 8;
                    } else if (c2 == 4) {
                        i2 = 1;
                    }
                }
                i2 = 0;
            }
            i3 |= i2;
        }
        return i3;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.String r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = -1
            int r2 = r7.hashCode()
            r3 = 8
            r4 = 4
            r5 = 2
            r6 = 1
            switch(r2) {
                case -2060497896: goto L_0x007d;
                case -1724546052: goto L_0x0072;
                case -1580883024: goto L_0x0067;
                case -1408024454: goto L_0x005d;
                case 99825: goto L_0x0053;
                case 3343801: goto L_0x0049;
                case 3530173: goto L_0x003d;
                case 552573414: goto L_0x0033;
                case 899152809: goto L_0x0029;
                case 1629013393: goto L_0x001f;
                case 1855372047: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0088
        L_0x0013:
            java.lang.String r2 = "supplementary"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0088
            r7 = 2
            goto L_0x0089
        L_0x001f:
            java.lang.String r2 = "emergency"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0088
            r7 = 5
            goto L_0x0089
        L_0x0029:
            java.lang.String r2 = "commentary"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0088
            r7 = 3
            goto L_0x0089
        L_0x0033:
            java.lang.String r2 = "caption"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0088
            r7 = 6
            goto L_0x0089
        L_0x003d:
            java.lang.String r2 = "sign"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0088
            r7 = 8
            goto L_0x0089
        L_0x0049:
            java.lang.String r2 = "main"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0088
            r7 = 0
            goto L_0x0089
        L_0x0053:
            java.lang.String r2 = "dub"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0088
            r7 = 4
            goto L_0x0089
        L_0x005d:
            java.lang.String r2 = "alternate"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0088
            r7 = 1
            goto L_0x0089
        L_0x0067:
            java.lang.String r2 = "enhanced-audio-intelligibility"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0088
            r7 = 10
            goto L_0x0089
        L_0x0072:
            java.lang.String r2 = "description"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0088
            r7 = 9
            goto L_0x0089
        L_0x007d:
            java.lang.String r2 = "subtitle"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0088
            r7 = 7
            goto L_0x0089
        L_0x0088:
            r7 = -1
        L_0x0089:
            switch(r7) {
                case 0: goto L_0x00a5;
                case 1: goto L_0x00a4;
                case 2: goto L_0x00a3;
                case 3: goto L_0x00a2;
                case 4: goto L_0x009f;
                case 5: goto L_0x009c;
                case 6: goto L_0x0099;
                case 7: goto L_0x0096;
                case 8: goto L_0x0093;
                case 9: goto L_0x0090;
                case 10: goto L_0x008d;
                default: goto L_0x008c;
            }
        L_0x008c:
            return r0
        L_0x008d:
            r7 = 2048(0x800, float:2.87E-42)
            return r7
        L_0x0090:
            r7 = 512(0x200, float:7.175E-43)
            return r7
        L_0x0093:
            r7 = 256(0x100, float:3.59E-43)
            return r7
        L_0x0096:
            r7 = 128(0x80, float:1.794E-43)
            return r7
        L_0x0099:
            r7 = 64
            return r7
        L_0x009c:
            r7 = 32
            return r7
        L_0x009f:
            r7 = 16
            return r7
        L_0x00a2:
            return r3
        L_0x00a3:
            return r4
        L_0x00a4:
            return r5
        L_0x00a5:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.a.c.a(java.lang.String):int");
    }

    private static void h(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (af.b(xmlPullParser)) {
            int i2 = 1;
            while (i2 != 0) {
                xmlPullParser.next();
                if (af.b(xmlPullParser)) {
                    i2++;
                } else if (af.a(xmlPullParser)) {
                    i2--;
                }
            }
        }
    }

    private static void a(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.a()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    DrmInitData.SchemeData schemeData2 = arrayList.get(i2);
                    if (schemeData2.a() && !schemeData.a() && schemeData2.a(schemeData.f31357a)) {
                        arrayList.remove(size);
                        break;
                    }
                    i2++;
                }
            }
        }
    }

    private static boolean b(String str) {
        return o.c(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/cea-708".equals(str) || "application/cea-608".equals(str);
    }

    private static int a(int i2, int i3) {
        if (i2 == -1) {
            return i3;
        }
        if (i3 == -1) {
            return i2;
        }
        com.google.android.exoplayer2.g.a.b(i2 == i3);
        return i2;
    }

    private static d a(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String b2 = b(xmlPullParser, "schemeIdUri", "");
        String b3 = b(xmlPullParser, "value", (String) null);
        String b4 = b(xmlPullParser, "id", (String) null);
        do {
            xmlPullParser.next();
        } while (!af.a(xmlPullParser, str));
        return new d(b2, b3, b4);
    }

    private static int d(List<d> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar = list.get(i2);
            if ("urn:scte:dash:cc:cea-608:2015".equals(dVar.f32925a) && dVar.f32926b != null) {
                Matcher matcher = f32915b.matcher(dVar.f32926b);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                new StringBuilder("Unable to parse CEA-608 channel number from: ").append(dVar.f32926b);
                l.c();
            }
        }
        return -1;
    }

    private static int e(List<d> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar = list.get(i2);
            if ("urn:scte:dash:cc:cea-708:2015".equals(dVar.f32925a) && dVar.f32926b != null) {
                Matcher matcher = f32916c.matcher(dVar.f32926b);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                new StringBuilder("Unable to parse CEA-708 service block number from: ").append(dVar.f32926b);
                l.c();
            }
        }
        return -1;
    }

    private static String f(List<d> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar = list.get(i2);
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(dVar.f32925a) && "ec+3".equals(dVar.f32926b)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    private static float a(XmlPullParser xmlPullParser, float f2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "frameRate");
        if (attributeValue == null) {
            return f2;
        }
        Matcher matcher = f32914a.matcher(attributeValue);
        if (!matcher.matches()) {
            return f2;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        String group = matcher.group(2);
        return !TextUtils.isEmpty(group) ? ((float) parseInt) / ((float) Integer.parseInt(group)) : (float) parseInt;
    }

    private static long b(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j;
        }
        return ae.f(attributeValue);
    }

    private static long b(XmlPullParser xmlPullParser, String str) throws v {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return -9223372036854775807L;
        }
        return ae.g(attributeValue);
    }

    private static String c(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        xmlPullParser.next();
        return ad.b(str, xmlPullParser.getText());
    }

    private static int a(XmlPullParser xmlPullParser, String str, int i2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return i2;
        }
        return Integer.parseInt(attributeValue);
    }

    private static long c(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j;
        }
        return Long.parseLong(attributeValue);
    }

    private static String b(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    protected static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Format f32918a;

        /* renamed from: b  reason: collision with root package name */
        public final String f32919b;

        /* renamed from: c  reason: collision with root package name */
        public final j f32920c;

        /* renamed from: d  reason: collision with root package name */
        public final String f32921d;

        /* renamed from: e  reason: collision with root package name */
        public final ArrayList<DrmInitData.SchemeData> f32922e;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayList<d> f32923f;

        /* renamed from: g  reason: collision with root package name */
        public final long f32924g = -1;

        public a(Format format, String str, j jVar, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<d> arrayList2) {
            this.f32918a = format;
            this.f32919b = str;
            this.f32920c = jVar;
            this.f32921d = str2;
            this.f32922e = arrayList;
            this.f32923f = arrayList2;
        }
    }
}
