package com.google.firebase.crashlytics.a.e.a;

import android.util.Base64;
import android.util.JsonReader;
import com.google.firebase.crashlytics.a.e.v;
import com.google.firebase.crashlytics.a.e.w;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.io.IOException;
import java.util.ArrayList;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final com.google.firebase.encoders.a f38379a;

    /* renamed from: com.google.firebase.crashlytics.a.e.a.a$a  reason: collision with other inner class name */
    interface C0632a<T> {
        T a(JsonReader jsonReader) throws IOException;
    }

    static {
        com.google.firebase.encoders.b.a a2 = new com.google.firebase.encoders.b.a().a(com.google.firebase.crashlytics.a.e.a.f38378a);
        a2.f38738a = true;
        f38379a = a2.a();
    }

    public static String a(v vVar) {
        return f38379a.a(vVar);
    }

    public static String a(v.d.C0634d dVar) {
        return f38379a.a(dVar);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.firebase.crashlytics.a.e.v a(java.lang.String r2) throws java.io.IOException {
        /*
            android.util.JsonReader r0 = new android.util.JsonReader     // Catch:{ IllegalStateException -> 0x0017 }
            java.io.StringReader r1 = new java.io.StringReader     // Catch:{ IllegalStateException -> 0x0017 }
            r1.<init>(r2)     // Catch:{ IllegalStateException -> 0x0017 }
            r0.<init>(r1)     // Catch:{ IllegalStateException -> 0x0017 }
            com.google.firebase.crashlytics.a.e.v r2 = h(r0)     // Catch:{ all -> 0x0012 }
            r0.close()     // Catch:{ IllegalStateException -> 0x0017 }
            return r2
        L_0x0012:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0016 }
        L_0x0016:
            throw r2     // Catch:{ IllegalStateException -> 0x0017 }
        L_0x0017:
            r2 = move-exception
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.e.a.a.a(java.lang.String):com.google.firebase.crashlytics.a.e.v");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.firebase.crashlytics.a.e.v.d.C0634d b(java.lang.String r2) throws java.io.IOException {
        /*
            android.util.JsonReader r0 = new android.util.JsonReader     // Catch:{ IllegalStateException -> 0x0017 }
            java.io.StringReader r1 = new java.io.StringReader     // Catch:{ IllegalStateException -> 0x0017 }
            r1.<init>(r2)     // Catch:{ IllegalStateException -> 0x0017 }
            r0.<init>(r1)     // Catch:{ IllegalStateException -> 0x0017 }
            com.google.firebase.crashlytics.a.e.v$d$d r2 = n(r0)     // Catch:{ all -> 0x0012 }
            r0.close()     // Catch:{ IllegalStateException -> 0x0017 }
            return r2
        L_0x0012:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0016 }
        L_0x0016:
            throw r2     // Catch:{ IllegalStateException -> 0x0017 }
        L_0x0017:
            r2 = move-exception
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.e.a.a.b(java.lang.String):com.google.firebase.crashlytics.a.e.v$d$d");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.firebase.crashlytics.a.e.v h(android.util.JsonReader r14) throws java.io.IOException {
        /*
            com.google.firebase.crashlytics.a.e.v$a r0 = com.google.firebase.crashlytics.a.e.v.j()
            r14.beginObject()
        L_0x0007:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x01d3
            java.lang.String r1 = r14.nextName()
            int r2 = r1.hashCode()
            r3 = 6
            r4 = 5
            r5 = 3
            r6 = 1
            r7 = 4
            r8 = 0
            r9 = 7
            r10 = -1
            r11 = 2
            switch(r2) {
                case -2118372775: goto L_0x0068;
                case -1962630338: goto L_0x005e;
                case -911706486: goto L_0x0054;
                case 344431858: goto L_0x004a;
                case 719853845: goto L_0x0040;
                case 1874684019: goto L_0x0036;
                case 1975623094: goto L_0x002c;
                case 1984987798: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x0072
        L_0x0022:
            java.lang.String r2 = "session"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0072
            r1 = 6
            goto L_0x0073
        L_0x002c:
            java.lang.String r2 = "displayVersion"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0072
            r1 = 5
            goto L_0x0073
        L_0x0036:
            java.lang.String r2 = "platform"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0072
            r1 = 2
            goto L_0x0073
        L_0x0040:
            java.lang.String r2 = "installationUuid"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0072
            r1 = 3
            goto L_0x0073
        L_0x004a:
            java.lang.String r2 = "gmpAppId"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0072
            r1 = 1
            goto L_0x0073
        L_0x0054:
            java.lang.String r2 = "buildVersion"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0072
            r1 = 4
            goto L_0x0073
        L_0x005e:
            java.lang.String r2 = "sdkVersion"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0072
            r1 = 0
            goto L_0x0073
        L_0x0068:
            java.lang.String r2 = "ndkPayload"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0072
            r1 = 7
            goto L_0x0073
        L_0x0072:
            r1 = -1
        L_0x0073:
            switch(r1) {
                case 0: goto L_0x01ca;
                case 1: goto L_0x01c1;
                case 2: goto L_0x01b8;
                case 3: goto L_0x01af;
                case 4: goto L_0x01a6;
                case 5: goto L_0x019d;
                case 6: goto L_0x0082;
                case 7: goto L_0x007a;
                default: goto L_0x0076;
            }
        L_0x0076:
            r14.skipValue()
            goto L_0x0007
        L_0x007a:
            com.google.firebase.crashlytics.a.e.v$c r1 = i(r14)
            r0.a((com.google.firebase.crashlytics.a.e.v.c) r1)
            goto L_0x0007
        L_0x0082:
            com.google.firebase.crashlytics.a.e.v$d$b r1 = com.google.firebase.crashlytics.a.e.v.d.m()
            r14.beginObject()
        L_0x0089:
            boolean r2 = r14.hasNext()
            if (r2 == 0) goto L_0x0191
            java.lang.String r2 = r14.nextName()
            int r12 = r2.hashCode()
            switch(r12) {
                case -2128794476: goto L_0x0105;
                case -1618432855: goto L_0x00fb;
                case -1606742899: goto L_0x00f1;
                case -1335157162: goto L_0x00e6;
                case -1291329255: goto L_0x00db;
                case 3556: goto L_0x00d1;
                case 96801: goto L_0x00c7;
                case 3599307: goto L_0x00bc;
                case 286956243: goto L_0x00b2;
                case 1025385094: goto L_0x00a8;
                case 2047016109: goto L_0x009c;
                default: goto L_0x009a;
            }
        L_0x009a:
            goto L_0x0110
        L_0x009c:
            java.lang.String r12 = "generatorType"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0110
            r2 = 10
            goto L_0x0111
        L_0x00a8:
            java.lang.String r12 = "crashed"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0110
            r2 = 4
            goto L_0x0111
        L_0x00b2:
            java.lang.String r12 = "generator"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0110
            r2 = 0
            goto L_0x0111
        L_0x00bc:
            java.lang.String r12 = "user"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0110
            r2 = 5
            goto L_0x0111
        L_0x00c7:
            java.lang.String r12 = "app"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0110
            r2 = 6
            goto L_0x0111
        L_0x00d1:
            java.lang.String r12 = "os"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0110
            r2 = 7
            goto L_0x0111
        L_0x00db:
            java.lang.String r12 = "events"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0110
            r2 = 9
            goto L_0x0111
        L_0x00e6:
            java.lang.String r12 = "device"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0110
            r2 = 8
            goto L_0x0111
        L_0x00f1:
            java.lang.String r12 = "endedAt"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0110
            r2 = 3
            goto L_0x0111
        L_0x00fb:
            java.lang.String r12 = "identifier"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0110
            r2 = 1
            goto L_0x0111
        L_0x0105:
            java.lang.String r12 = "startedAt"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0110
            r2 = 2
            goto L_0x0111
        L_0x0110:
            r2 = -1
        L_0x0111:
            switch(r2) {
                case 0: goto L_0x0188;
                case 1: goto L_0x0172;
                case 2: goto L_0x0169;
                case 3: goto L_0x015c;
                case 4: goto L_0x0153;
                case 5: goto L_0x014a;
                case 6: goto L_0x0141;
                case 7: goto L_0x0138;
                case 8: goto L_0x012f;
                case 9: goto L_0x0122;
                case 10: goto L_0x0119;
                default: goto L_0x0114;
            }
        L_0x0114:
            r14.skipValue()
            goto L_0x0089
        L_0x0119:
            int r2 = r14.nextInt()
            r1.a((int) r2)
            goto L_0x0089
        L_0x0122:
            com.google.firebase.crashlytics.a.e.a.a$a r2 = com.google.firebase.crashlytics.a.e.a.b.a()
            com.google.firebase.crashlytics.a.e.w r2 = a(r14, r2)
            r1.a((com.google.firebase.crashlytics.a.e.w<com.google.firebase.crashlytics.a.e.v.d.C0634d>) r2)
            goto L_0x0089
        L_0x012f:
            com.google.firebase.crashlytics.a.e.v$d$c r2 = m(r14)
            r1.a((com.google.firebase.crashlytics.a.e.v.d.c) r2)
            goto L_0x0089
        L_0x0138:
            com.google.firebase.crashlytics.a.e.v$d$e r2 = l(r14)
            r1.a((com.google.firebase.crashlytics.a.e.v.d.e) r2)
            goto L_0x0089
        L_0x0141:
            com.google.firebase.crashlytics.a.e.v$d$a r2 = k(r14)
            r1.a((com.google.firebase.crashlytics.a.e.v.d.a) r2)
            goto L_0x0089
        L_0x014a:
            com.google.firebase.crashlytics.a.e.v$d$f r2 = j(r14)
            r1.a((com.google.firebase.crashlytics.a.e.v.d.f) r2)
            goto L_0x0089
        L_0x0153:
            boolean r2 = r14.nextBoolean()
            r1.a((boolean) r2)
            goto L_0x0089
        L_0x015c:
            long r12 = r14.nextLong()
            java.lang.Long r2 = java.lang.Long.valueOf(r12)
            r1.a((java.lang.Long) r2)
            goto L_0x0089
        L_0x0169:
            long r12 = r14.nextLong()
            r1.a((long) r12)
            goto L_0x0089
        L_0x0172:
            java.lang.String r2 = r14.nextString()
            byte[] r2 = android.util.Base64.decode(r2, r11)
            java.lang.String r12 = new java.lang.String
            java.nio.charset.Charset r13 = com.google.firebase.crashlytics.a.e.v.f38572a
            r12.<init>(r2, r13)
            r1.b(r12)
            goto L_0x0089
        L_0x0188:
            java.lang.String r2 = r14.nextString()
            r1.a((java.lang.String) r2)
            goto L_0x0089
        L_0x0191:
            r14.endObject()
            com.google.firebase.crashlytics.a.e.v$d r1 = r1.a()
            r0.a((com.google.firebase.crashlytics.a.e.v.d) r1)
            goto L_0x0007
        L_0x019d:
            java.lang.String r1 = r14.nextString()
            r0.e(r1)
            goto L_0x0007
        L_0x01a6:
            java.lang.String r1 = r14.nextString()
            r0.d(r1)
            goto L_0x0007
        L_0x01af:
            java.lang.String r1 = r14.nextString()
            r0.c(r1)
            goto L_0x0007
        L_0x01b8:
            int r1 = r14.nextInt()
            r0.a((int) r1)
            goto L_0x0007
        L_0x01c1:
            java.lang.String r1 = r14.nextString()
            r0.b(r1)
            goto L_0x0007
        L_0x01ca:
            java.lang.String r1 = r14.nextString()
            r0.a((java.lang.String) r1)
            goto L_0x0007
        L_0x01d3:
            r14.endObject()
            com.google.firebase.crashlytics.a.e.v r14 = r0.a()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.e.a.a.h(android.util.JsonReader):com.google.firebase.crashlytics.a.e.v");
    }

    private static v.c i(JsonReader jsonReader) throws IOException {
        v.c.a c2 = v.c.c();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c3 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 97434231) {
                if (hashCode == 106008351 && nextName.equals("orgId")) {
                    c3 = 1;
                }
            } else if (nextName.equals("files")) {
                c3 = 0;
            }
            if (c3 == 0) {
                c2.a((w<v.c.b>) a(jsonReader, c.a()));
            } else if (c3 != 1) {
                jsonReader.skipValue();
            } else {
                c2.a(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return c2.a();
    }

    private static v.d.f j(JsonReader jsonReader) throws IOException {
        v.d.f.a b2 = v.d.f.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            if (nextName.hashCode() == -1618432855 && nextName.equals("identifier")) {
                c2 = 0;
            }
            if (c2 != 0) {
                jsonReader.skipValue();
            } else {
                b2.a(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return b2.a();
    }

    private static v.d.a k(JsonReader jsonReader) throws IOException {
        v.d.a.C0633a f2 = v.d.a.f();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                f2.a(jsonReader.nextString());
            } else if (c2 == 1) {
                f2.b(jsonReader.nextString());
            } else if (c2 == 2) {
                f2.c(jsonReader.nextString());
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                f2.d(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return f2.a();
    }

    private static v.d.e l(JsonReader jsonReader) throws IOException {
        v.d.e.a e2 = v.d.e.e();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -293026577:
                    if (nextName.equals("jailbroken")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                e2.a(jsonReader.nextInt());
            } else if (c2 == 1) {
                e2.a(jsonReader.nextString());
            } else if (c2 == 2) {
                e2.b(jsonReader.nextString());
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                e2.a(jsonReader.nextBoolean());
            }
        }
        jsonReader.endObject();
        return e2.a();
    }

    private static v.d.c m(JsonReader jsonReader) throws IOException {
        v.d.c.a j = v.d.c.j();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1981332476:
                    if (nextName.equals("simulator")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1969347631:
                    if (nextName.equals("manufacturer")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 112670:
                    if (nextName.equals("ram")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 81784169:
                    if (nextName.equals("diskSpace")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 94848180:
                    if (nextName.equals("cores")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 104069929:
                    if (nextName.equals("model")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 109757585:
                    if (nextName.equals("state")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 2078953423:
                    if (nextName.equals("modelClass")) {
                        c2 = 8;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    j.a(jsonReader.nextInt());
                    break;
                case 1:
                    j.a(jsonReader.nextString());
                    break;
                case 2:
                    j.b(jsonReader.nextInt());
                    break;
                case 3:
                    j.a(jsonReader.nextLong());
                    break;
                case 4:
                    j.b(jsonReader.nextLong());
                    break;
                case 5:
                    j.a(jsonReader.nextBoolean());
                    break;
                case 6:
                    j.c(jsonReader.nextInt());
                    break;
                case 7:
                    j.b(jsonReader.nextString());
                    break;
                case 8:
                    j.c(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return j.a();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0260  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.firebase.crashlytics.a.e.v.d.C0634d n(android.util.JsonReader r12) throws java.io.IOException {
        /*
            com.google.firebase.crashlytics.a.e.v$d$d$b r0 = com.google.firebase.crashlytics.a.e.v.d.C0634d.g()
            r12.beginObject()
        L_0x0007:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x02ca
            java.lang.String r1 = r12.nextName()
            int r2 = r1.hashCode()
            r3 = 4
            r4 = 0
            r5 = -1
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r2) {
                case -1335157162: goto L_0x0049;
                case 96801: goto L_0x003f;
                case 107332: goto L_0x0035;
                case 3575610: goto L_0x002a;
                case 55126294: goto L_0x001f;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0053
        L_0x001f:
            java.lang.String r2 = "timestamp"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0053
            r1 = 0
            goto L_0x0054
        L_0x002a:
            java.lang.String r2 = "type"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0053
            r1 = 1
            goto L_0x0054
        L_0x0035:
            java.lang.String r2 = "log"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0053
            r1 = 4
            goto L_0x0054
        L_0x003f:
            java.lang.String r2 = "app"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0053
            r1 = 2
            goto L_0x0054
        L_0x0049:
            java.lang.String r2 = "device"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0053
            r1 = 3
            goto L_0x0054
        L_0x0053:
            r1 = -1
        L_0x0054:
            if (r1 == 0) goto L_0x02c1
            if (r1 == r8) goto L_0x02b8
            if (r1 == r7) goto L_0x014b
            if (r1 == r6) goto L_0x00a2
            if (r1 == r3) goto L_0x0062
            r12.skipValue()
            goto L_0x0007
        L_0x0062:
            com.google.firebase.crashlytics.a.e.v$d$d$d$a r1 = com.google.firebase.crashlytics.a.e.v.d.C0634d.C0645d.b()
            r12.beginObject()
        L_0x0069:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x0096
            java.lang.String r2 = r12.nextName()
            int r3 = r2.hashCode()
            r6 = 951530617(0x38b73479, float:8.735894E-5)
            if (r3 == r6) goto L_0x007d
            goto L_0x0087
        L_0x007d:
            java.lang.String r3 = "content"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0087
            r2 = 0
            goto L_0x0088
        L_0x0087:
            r2 = -1
        L_0x0088:
            if (r2 == 0) goto L_0x008e
            r12.skipValue()
            goto L_0x0069
        L_0x008e:
            java.lang.String r2 = r12.nextString()
            r1.a(r2)
            goto L_0x0069
        L_0x0096:
            r12.endObject()
            com.google.firebase.crashlytics.a.e.v$d$d$d r1 = r1.a()
            r0.a((com.google.firebase.crashlytics.a.e.v.d.C0634d.C0645d) r1)
            goto L_0x0007
        L_0x00a2:
            com.google.firebase.crashlytics.a.e.v$d$d$c$a r1 = com.google.firebase.crashlytics.a.e.v.d.C0634d.c.g()
            r12.beginObject()
        L_0x00a9:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x013f
            java.lang.String r2 = r12.nextName()
            int r9 = r2.hashCode()
            r10 = 5
            switch(r9) {
                case -1708606089: goto L_0x00ee;
                case -1455558134: goto L_0x00e4;
                case -1439500848: goto L_0x00da;
                case 279795450: goto L_0x00d0;
                case 976541947: goto L_0x00c6;
                case 1516795582: goto L_0x00bc;
                default: goto L_0x00bb;
            }
        L_0x00bb:
            goto L_0x00f8
        L_0x00bc:
            java.lang.String r9 = "proximityOn"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x00f8
            r2 = 3
            goto L_0x00f9
        L_0x00c6:
            java.lang.String r9 = "ramUsed"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x00f8
            r2 = 5
            goto L_0x00f9
        L_0x00d0:
            java.lang.String r9 = "diskUsed"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x00f8
            r2 = 2
            goto L_0x00f9
        L_0x00da:
            java.lang.String r9 = "orientation"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x00f8
            r2 = 4
            goto L_0x00f9
        L_0x00e4:
            java.lang.String r9 = "batteryVelocity"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x00f8
            r2 = 1
            goto L_0x00f9
        L_0x00ee:
            java.lang.String r9 = "batteryLevel"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x00f8
            r2 = 0
            goto L_0x00f9
        L_0x00f8:
            r2 = -1
        L_0x00f9:
            if (r2 == 0) goto L_0x0132
            if (r2 == r8) goto L_0x0129
            if (r2 == r7) goto L_0x0121
            if (r2 == r6) goto L_0x0119
            if (r2 == r3) goto L_0x0111
            if (r2 == r10) goto L_0x0109
            r12.skipValue()
            goto L_0x00a9
        L_0x0109:
            long r9 = r12.nextLong()
            r1.a((long) r9)
            goto L_0x00a9
        L_0x0111:
            int r2 = r12.nextInt()
            r1.b((int) r2)
            goto L_0x00a9
        L_0x0119:
            boolean r2 = r12.nextBoolean()
            r1.a((boolean) r2)
            goto L_0x00a9
        L_0x0121:
            long r9 = r12.nextLong()
            r1.b((long) r9)
            goto L_0x00a9
        L_0x0129:
            int r2 = r12.nextInt()
            r1.a((int) r2)
            goto L_0x00a9
        L_0x0132:
            double r9 = r12.nextDouble()
            java.lang.Double r2 = java.lang.Double.valueOf(r9)
            r1.a((java.lang.Double) r2)
            goto L_0x00a9
        L_0x013f:
            r12.endObject()
            com.google.firebase.crashlytics.a.e.v$d$d$c r1 = r1.a()
            r0.a((com.google.firebase.crashlytics.a.e.v.d.C0634d.c) r1)
            goto L_0x0007
        L_0x014b:
            com.google.firebase.crashlytics.a.e.v$d$d$a$a r1 = com.google.firebase.crashlytics.a.e.v.d.C0634d.a.f()
            r12.beginObject()
        L_0x0152:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x02ac
            java.lang.String r2 = r12.nextName()
            int r3 = r2.hashCode()
            switch(r3) {
                case -1332194002: goto L_0x0183;
                case -1090974952: goto L_0x0179;
                case 555169704: goto L_0x016f;
                case 928737948: goto L_0x0164;
                default: goto L_0x0163;
            }
        L_0x0163:
            goto L_0x018d
        L_0x0164:
            java.lang.String r3 = "uiOrientation"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x018d
            r2 = 1
            goto L_0x018e
        L_0x016f:
            java.lang.String r3 = "customAttributes"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x018d
            r2 = 3
            goto L_0x018e
        L_0x0179:
            java.lang.String r3 = "execution"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x018d
            r2 = 2
            goto L_0x018e
        L_0x0183:
            java.lang.String r3 = "background"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x018d
            r2 = 0
            goto L_0x018e
        L_0x018d:
            r2 = -1
        L_0x018e:
            if (r2 == 0) goto L_0x029f
            if (r2 == r8) goto L_0x0296
            if (r2 == r7) goto L_0x01a6
            if (r2 == r6) goto L_0x019a
            r12.skipValue()
            goto L_0x0152
        L_0x019a:
            com.google.firebase.crashlytics.a.e.a.a$a r2 = com.google.firebase.crashlytics.a.e.a.d.a()
            com.google.firebase.crashlytics.a.e.w r2 = a(r12, r2)
            r1.a((com.google.firebase.crashlytics.a.e.w<com.google.firebase.crashlytics.a.e.v.b>) r2)
            goto L_0x0152
        L_0x01a6:
            com.google.firebase.crashlytics.a.e.v$d$d$a$b$b r2 = com.google.firebase.crashlytics.a.e.v.d.C0634d.a.b.e()
            r12.beginObject()
        L_0x01ad:
            boolean r3 = r12.hasNext()
            if (r3 == 0) goto L_0x028a
            java.lang.String r3 = r12.nextName()
            int r9 = r3.hashCode()
            switch(r9) {
                case -1337936983: goto L_0x01de;
                case -902467928: goto L_0x01d3;
                case 937615455: goto L_0x01c9;
                case 1481625679: goto L_0x01bf;
                default: goto L_0x01be;
            }
        L_0x01be:
            goto L_0x01e9
        L_0x01bf:
            java.lang.String r9 = "exception"
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x01e9
            r3 = 1
            goto L_0x01ea
        L_0x01c9:
            java.lang.String r9 = "binaries"
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x01e9
            r3 = 3
            goto L_0x01ea
        L_0x01d3:
            java.lang.String r9 = "signal"
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x01e9
            r3 = 2
            goto L_0x01ea
        L_0x01de:
            java.lang.String r9 = "threads"
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x01e9
            r3 = 0
            goto L_0x01ea
        L_0x01e9:
            r3 = -1
        L_0x01ea:
            if (r3 == 0) goto L_0x027d
            if (r3 == r8) goto L_0x0274
            if (r3 == r7) goto L_0x0202
            if (r3 == r6) goto L_0x01f6
            r12.skipValue()
            goto L_0x01ad
        L_0x01f6:
            com.google.firebase.crashlytics.a.e.a.a$a r3 = com.google.firebase.crashlytics.a.e.a.f.a()
            com.google.firebase.crashlytics.a.e.w r3 = a(r12, r3)
            r2.b(r3)
            goto L_0x01ad
        L_0x0202:
            com.google.firebase.crashlytics.a.e.v$d$d$a$b$d$a r3 = com.google.firebase.crashlytics.a.e.v.d.C0634d.a.b.C0640d.d()
            r12.beginObject()
        L_0x0209:
            boolean r9 = r12.hasNext()
            if (r9 == 0) goto L_0x0268
            java.lang.String r9 = r12.nextName()
            int r10 = r9.hashCode()
            r11 = -1147692044(0xffffffffbb979bf4, float:-0.0046267454)
            if (r10 == r11) goto L_0x023b
            r11 = 3059181(0x2eaded, float:4.286826E-39)
            if (r10 == r11) goto L_0x0231
            r11 = 3373707(0x337a8b, float:4.72757E-39)
            if (r10 == r11) goto L_0x0227
            goto L_0x0245
        L_0x0227:
            java.lang.String r10 = "name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0245
            r9 = 0
            goto L_0x0246
        L_0x0231:
            java.lang.String r10 = "code"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0245
            r9 = 1
            goto L_0x0246
        L_0x023b:
            java.lang.String r10 = "address"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0245
            r9 = 2
            goto L_0x0246
        L_0x0245:
            r9 = -1
        L_0x0246:
            if (r9 == 0) goto L_0x0260
            if (r9 == r8) goto L_0x0258
            if (r9 == r7) goto L_0x0250
            r12.skipValue()
            goto L_0x0209
        L_0x0250:
            long r9 = r12.nextLong()
            r3.a((long) r9)
            goto L_0x0209
        L_0x0258:
            java.lang.String r9 = r12.nextString()
            r3.b(r9)
            goto L_0x0209
        L_0x0260:
            java.lang.String r9 = r12.nextString()
            r3.a((java.lang.String) r9)
            goto L_0x0209
        L_0x0268:
            r12.endObject()
            com.google.firebase.crashlytics.a.e.v$d$d$a$b$d r3 = r3.a()
            r2.a((com.google.firebase.crashlytics.a.e.v.d.C0634d.a.b.C0640d) r3)
            goto L_0x01ad
        L_0x0274:
            com.google.firebase.crashlytics.a.e.v$d$d$a$b$c r3 = o(r12)
            r2.a((com.google.firebase.crashlytics.a.e.v.d.C0634d.a.b.c) r3)
            goto L_0x01ad
        L_0x027d:
            com.google.firebase.crashlytics.a.e.a.a$a r3 = com.google.firebase.crashlytics.a.e.a.e.a()
            com.google.firebase.crashlytics.a.e.w r3 = a(r12, r3)
            r2.a((com.google.firebase.crashlytics.a.e.w<com.google.firebase.crashlytics.a.e.v.d.C0634d.a.b.e>) r3)
            goto L_0x01ad
        L_0x028a:
            r12.endObject()
            com.google.firebase.crashlytics.a.e.v$d$d$a$b r2 = r2.a()
            r1.a((com.google.firebase.crashlytics.a.e.v.d.C0634d.a.b) r2)
            goto L_0x0152
        L_0x0296:
            int r2 = r12.nextInt()
            r1.a((int) r2)
            goto L_0x0152
        L_0x029f:
            boolean r2 = r12.nextBoolean()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r1.a((java.lang.Boolean) r2)
            goto L_0x0152
        L_0x02ac:
            r12.endObject()
            com.google.firebase.crashlytics.a.e.v$d$d$a r1 = r1.a()
            r0.a((com.google.firebase.crashlytics.a.e.v.d.C0634d.a) r1)
            goto L_0x0007
        L_0x02b8:
            java.lang.String r1 = r12.nextString()
            r0.a((java.lang.String) r1)
            goto L_0x0007
        L_0x02c1:
            long r1 = r12.nextLong()
            r0.a((long) r1)
            goto L_0x0007
        L_0x02ca:
            r12.endObject()
            com.google.firebase.crashlytics.a.e.v$d$d r12 = r0.a()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.e.a.a.n(android.util.JsonReader):com.google.firebase.crashlytics.a.e.v$d$d");
    }

    private static v.d.C0634d.a.b.c o(JsonReader jsonReader) throws IOException {
        v.d.C0634d.a.b.c.C0639a f2 = v.d.C0634d.a.b.c.f();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -934964668:
                    if (nextName.equals(Item.KEY_REASON)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 91997906:
                    if (nextName.equals("causedBy")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 581754413:
                    if (nextName.equals("overflowCount")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                f2.a(o(jsonReader));
            } else if (c2 == 1) {
                f2.a((w<v.d.C0634d.a.b.e.C0643b>) a(jsonReader, g.a()));
            } else if (c2 == 2) {
                f2.a(jsonReader.nextInt());
            } else if (c2 == 3) {
                f2.a(jsonReader.nextString());
            } else if (c2 != 4) {
                jsonReader.skipValue();
            } else {
                f2.b(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return f2.a();
    }

    /* access modifiers changed from: private */
    public static v.d.C0634d.a.b.e.C0643b p(JsonReader jsonReader) throws IOException {
        v.d.C0634d.a.b.e.C0643b.C0644a f2 = v.d.C0634d.a.b.e.C0643b.f();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1019779949:
                    if (nextName.equals("offset")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -887523944:
                    if (nextName.equals("symbol")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3571:
                    if (nextName.equals("pc")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3143036:
                    if (nextName.equals(CommunityPostActivity.TYPE_FILE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                f2.a(jsonReader.nextInt());
            } else if (c2 == 1) {
                f2.b(jsonReader.nextString());
            } else if (c2 == 2) {
                f2.b(jsonReader.nextLong());
            } else if (c2 == 3) {
                f2.a(jsonReader.nextLong());
            } else if (c2 != 4) {
                jsonReader.skipValue();
            } else {
                f2.a(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return f2.a();
    }

    private static <T> w<T> a(JsonReader jsonReader, C0632a<T> aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(aVar.a(jsonReader));
        }
        jsonReader.endArray();
        return w.a(arrayList);
    }

    static /* synthetic */ v.c.b b(JsonReader jsonReader) {
        v.c.b.a c2 = v.c.b.c();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c3 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -734768633) {
                if (hashCode == -567321830 && nextName.equals("contents")) {
                    c3 = 1;
                }
            } else if (nextName.equals("filename")) {
                c3 = 0;
            }
            if (c3 == 0) {
                c2.a(jsonReader.nextString());
            } else if (c3 != 1) {
                jsonReader.skipValue();
            } else {
                c2.a(Base64.decode(jsonReader.nextString(), 2));
            }
        }
        jsonReader.endObject();
        return c2.a();
    }

    static /* synthetic */ v.b c(JsonReader jsonReader) {
        v.b.a c2 = v.b.c();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c3 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 106079) {
                if (hashCode == 111972721 && nextName.equals("value")) {
                    c3 = 1;
                }
            } else if (nextName.equals("key")) {
                c3 = 0;
            }
            if (c3 == 0) {
                c2.a(jsonReader.nextString());
            } else if (c3 != 1) {
                jsonReader.skipValue();
            } else {
                c2.b(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return c2.a();
    }

    static /* synthetic */ v.d.C0634d.a.b.e d(JsonReader jsonReader) {
        v.d.C0634d.a.b.e.C0642a d2 = v.d.C0634d.a.b.e.d();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -1266514778) {
                if (hashCode != 3373707) {
                    if (hashCode == 2125650548 && nextName.equals("importance")) {
                        c2 = 0;
                    }
                } else if (nextName.equals("name")) {
                    c2 = 1;
                }
            } else if (nextName.equals("frames")) {
                c2 = 2;
            }
            if (c2 == 0) {
                d2.a(jsonReader.nextInt());
            } else if (c2 == 1) {
                d2.a(jsonReader.nextString());
            } else if (c2 != 2) {
                jsonReader.skipValue();
            } else {
                d2.a((w<v.d.C0634d.a.b.e.C0643b>) a(jsonReader, h.a()));
            }
        }
        jsonReader.endObject();
        return d2.a();
    }

    static /* synthetic */ v.d.C0634d.a.b.C0636a e(JsonReader jsonReader) {
        v.d.C0634d.a.b.C0636a.C0637a e2 = v.d.C0634d.a.b.C0636a.e();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 3373707:
                    if (nextName.equals("name")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3601339:
                    if (nextName.equals("uuid")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1153765347:
                    if (nextName.equals("baseAddress")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                e2.a(jsonReader.nextString());
            } else if (c2 == 1) {
                e2.a(jsonReader.nextLong());
            } else if (c2 == 2) {
                e2.b(jsonReader.nextLong());
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                e2.b(new String(Base64.decode(jsonReader.nextString(), 2), v.f38572a));
            }
        }
        jsonReader.endObject();
        return e2.a();
    }
}
