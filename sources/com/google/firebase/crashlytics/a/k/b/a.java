package com.google.firebase.crashlytics.a.k.b;

import com.google.firebase.crashlytics.a.c.g;
import com.google.firebase.crashlytics.a.c.z;
import com.google.firebase.crashlytics.a.f.b;
import com.google.firebase.crashlytics.a.f.c;
import com.google.firebase.crashlytics.a.f.d;
import java.io.IOException;

abstract class a extends com.google.firebase.crashlytics.a.c.a {

    /* renamed from: b  reason: collision with root package name */
    private final String f38688b;

    public a(String str, String str2, c cVar, com.google.firebase.crashlytics.a.f.a aVar, String str3) {
        super(str, str2, cVar, aVar);
        this.f38688b = str3;
    }

    public boolean a(com.google.firebase.crashlytics.a.k.a.a aVar, boolean z) {
        if (z) {
            b b2 = a().a("X-CRASHLYTICS-ORG-ID", aVar.f38652a).a("X-CRASHLYTICS-GOOGLE-APP-ID", aVar.f38653b).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f38688b).b("org_id", aVar.f38652a).b("app[identifier]", aVar.f38654c).b("app[name]", aVar.f38658g).b("app[display_version]", aVar.f38655d).b("app[build_version]", aVar.f38656e).b("app[source]", Integer.toString(aVar.f38659h)).b("app[minimum_sdk_version]", aVar.f38660i).b("app[built_sdk_version]", aVar.j);
            if (!g.c(aVar.f38657f)) {
                b2.b("app[instance_identifier]", aVar.f38657f);
            }
            com.google.firebase.crashlytics.a.b a2 = com.google.firebase.crashlytics.a.b.a();
            new StringBuilder("Sending app info to ").append(this.f38149a);
            a2.a(3);
            try {
                d a3 = b2.a();
                int i2 = a3.f38580a;
                String str = "POST".equalsIgnoreCase(b2.f38575a.name()) ? "Create" : "Update";
                com.google.firebase.crashlytics.a.b a4 = com.google.firebase.crashlytics.a.b.a();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" app request ID: ");
                sb.append(a3.a("X-REQUEST-ID"));
                a4.a(3);
                com.google.firebase.crashlytics.a.b a5 = com.google.firebase.crashlytics.a.b.a();
                "Result was ".concat(String.valueOf(i2));
                a5.a(3);
                return z.a(i2) == 0;
            } catch (IOException e2) {
                com.google.firebase.crashlytics.a.b.a().a(6);
                throw new RuntimeException(e2);
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }
}
