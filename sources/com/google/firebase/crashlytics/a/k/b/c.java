package com.google.firebase.crashlytics.a.k.b;

import com.google.firebase.crashlytics.a.b;
import com.google.firebase.crashlytics.a.c.a;
import org.json.JSONObject;

public final class c extends a implements d {

    /* renamed from: b  reason: collision with root package name */
    private b f38689b;

    public c(String str, String str2, com.google.firebase.crashlytics.a.f.c cVar) {
        this(str, str2, cVar, com.google.firebase.crashlytics.a.f.a.GET, b.a());
    }

    private c(String str, String str2, com.google.firebase.crashlytics.a.f.c cVar, com.google.firebase.crashlytics.a.f.a aVar, b bVar) {
        super(str, str2, cVar, aVar);
        this.f38689b = bVar;
    }

    private JSONObject a(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception unused) {
            b bVar = this.f38689b;
            new StringBuilder("Failed to parse settings JSON from ").append(this.f38149a);
            bVar.a(3);
            b bVar2 = this.f38689b;
            "Settings response ".concat(String.valueOf(str));
            bVar2.a(3);
            return null;
        }
    }

    private static void a(com.google.firebase.crashlytics.a.f.b bVar, String str, String str2) {
        if (str2 != null) {
            bVar.a(str, str2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00cd A[Catch:{ IOException -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d5 A[Catch:{ IOException -> 0x00e7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject a(com.google.firebase.crashlytics.a.k.a.g r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 6
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ IOException -> 0x00e7 }
            r2.<init>()     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r3 = "build_version"
            java.lang.String r4 = r8.f38686h     // Catch:{ IOException -> 0x00e7 }
            r2.put(r3, r4)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r3 = "display_version"
            java.lang.String r4 = r8.f38685g     // Catch:{ IOException -> 0x00e7 }
            r2.put(r3, r4)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r3 = "source"
            int r4 = r8.f38687i     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ IOException -> 0x00e7 }
            r2.put(r3, r4)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r3 = r8.f38684f     // Catch:{ IOException -> 0x00e7 }
            boolean r4 = com.google.firebase.crashlytics.a.c.g.c((java.lang.String) r3)     // Catch:{ IOException -> 0x00e7 }
            if (r4 != 0) goto L_0x002e
            java.lang.String r4 = "instance"
            r2.put(r4, r3)     // Catch:{ IOException -> 0x00e7 }
        L_0x002e:
            com.google.firebase.crashlytics.a.f.b r3 = r7.a(r2)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r4 = "X-CRASHLYTICS-GOOGLE-APP-ID"
            java.lang.String r5 = r8.f38679a     // Catch:{ IOException -> 0x00e7 }
            a(r3, r4, r5)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r4 = "X-CRASHLYTICS-API-CLIENT-TYPE"
            java.lang.String r5 = "android"
            a(r3, r4, r5)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r4 = "X-CRASHLYTICS-API-CLIENT-VERSION"
            java.lang.String r5 = "17.1.0"
            a(r3, r4, r5)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r4 = "Accept"
            java.lang.String r5 = "application/json"
            a(r3, r4, r5)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r4 = "X-CRASHLYTICS-DEVICE-MODEL"
            java.lang.String r5 = r8.f38680b     // Catch:{ IOException -> 0x00e7 }
            a(r3, r4, r5)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r4 = "X-CRASHLYTICS-OS-BUILD-VERSION"
            java.lang.String r5 = r8.f38681c     // Catch:{ IOException -> 0x00e7 }
            a(r3, r4, r5)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r4 = "X-CRASHLYTICS-OS-DISPLAY-VERSION"
            java.lang.String r5 = r8.f38682d     // Catch:{ IOException -> 0x00e7 }
            a(r3, r4, r5)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r4 = "X-CRASHLYTICS-INSTALLATION-ID"
            com.google.firebase.crashlytics.a.c.w r8 = r8.f38683e     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r8 = r8.a()     // Catch:{ IOException -> 0x00e7 }
            a(r3, r4, r8)     // Catch:{ IOException -> 0x00e7 }
            com.google.firebase.crashlytics.a.b r8 = r7.f38689b     // Catch:{ IOException -> 0x00e7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r5 = "Requesting settings from "
            r4.<init>(r5)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r5 = r7.f38149a     // Catch:{ IOException -> 0x00e7 }
            r4.append(r5)     // Catch:{ IOException -> 0x00e7 }
            r4 = 3
            r8.a(r4)     // Catch:{ IOException -> 0x00e7 }
            com.google.firebase.crashlytics.a.b r8 = r7.f38689b     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r5 = "Settings query params were: "
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x00e7 }
            r5.concat(r2)     // Catch:{ IOException -> 0x00e7 }
            r8.a(r4)     // Catch:{ IOException -> 0x00e7 }
            com.google.firebase.crashlytics.a.f.d r8 = r3.a()     // Catch:{ IOException -> 0x00e7 }
            com.google.firebase.crashlytics.a.b r2 = r7.f38689b     // Catch:{ IOException -> 0x00e7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r5 = "Settings request ID: "
            r3.<init>(r5)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r5 = "X-REQUEST-ID"
            java.lang.String r5 = r8.a(r5)     // Catch:{ IOException -> 0x00e7 }
            r3.append(r5)     // Catch:{ IOException -> 0x00e7 }
            r2.a(r4)     // Catch:{ IOException -> 0x00e7 }
            int r2 = r8.f38580a     // Catch:{ IOException -> 0x00e7 }
            com.google.firebase.crashlytics.a.b r3 = r7.f38689b     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r5 = "Settings result was: "
            java.lang.String r6 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x00e7 }
            r5.concat(r6)     // Catch:{ IOException -> 0x00e7 }
            r3.a(r4)     // Catch:{ IOException -> 0x00e7 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 == r3) goto L_0x00ca
            r3 = 201(0xc9, float:2.82E-43)
            if (r2 == r3) goto L_0x00ca
            r3 = 202(0xca, float:2.83E-43)
            if (r2 == r3) goto L_0x00ca
            r3 = 203(0xcb, float:2.84E-43)
            if (r2 != r3) goto L_0x00c8
            goto L_0x00ca
        L_0x00c8:
            r2 = 0
            goto L_0x00cb
        L_0x00ca:
            r2 = 1
        L_0x00cb:
            if (r2 == 0) goto L_0x00d5
            java.lang.String r8 = r8.f38581b     // Catch:{ IOException -> 0x00e7 }
            org.json.JSONObject r8 = r7.a((java.lang.String) r8)     // Catch:{ IOException -> 0x00e7 }
            r0 = r8
            goto L_0x00ec
        L_0x00d5:
            com.google.firebase.crashlytics.a.b r8 = r7.f38689b     // Catch:{ IOException -> 0x00e7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r3 = "Failed to retrieve settings from "
            r2.<init>(r3)     // Catch:{ IOException -> 0x00e7 }
            java.lang.String r3 = r7.f38149a     // Catch:{ IOException -> 0x00e7 }
            r2.append(r3)     // Catch:{ IOException -> 0x00e7 }
            r8.a(r1)     // Catch:{ IOException -> 0x00e7 }
            goto L_0x00ec
        L_0x00e7:
            com.google.firebase.crashlytics.a.b r8 = r7.f38689b
            r8.a(r1)
        L_0x00ec:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.k.b.c.a(com.google.firebase.crashlytics.a.k.a.g):org.json.JSONObject");
    }
}
