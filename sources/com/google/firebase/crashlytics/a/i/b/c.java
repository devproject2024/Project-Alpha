package com.google.firebase.crashlytics.a.i.b;

import com.google.firebase.crashlytics.a.c.a;
import com.google.firebase.crashlytics.a.c.z;
import com.google.firebase.crashlytics.a.f.b;
import com.google.firebase.crashlytics.a.f.d;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public final class c extends a implements b {

    /* renamed from: b  reason: collision with root package name */
    private final String f38636b;

    public c(String str, String str2, com.google.firebase.crashlytics.a.f.c cVar, String str3) {
        this(str, str2, cVar, com.google.firebase.crashlytics.a.f.a.POST, str3);
    }

    private c(String str, String str2, com.google.firebase.crashlytics.a.f.c cVar, com.google.firebase.crashlytics.a.f.a aVar, String str3) {
        super(str, str2, cVar, aVar);
        this.f38636b = str3;
    }

    public final boolean a(com.google.firebase.crashlytics.a.i.a.a aVar, boolean z) {
        if (z) {
            b a2 = a(a(a(), aVar), aVar.f38620c);
            com.google.firebase.crashlytics.a.b a3 = com.google.firebase.crashlytics.a.b.a();
            new StringBuilder("Sending report to: ").append(this.f38149a);
            a3.a(3);
            try {
                d a4 = a2.a();
                int i2 = a4.f38580a;
                com.google.firebase.crashlytics.a.b a5 = com.google.firebase.crashlytics.a.b.a();
                new StringBuilder("Create report request ID: ").append(a4.a("X-REQUEST-ID"));
                a5.a(3);
                com.google.firebase.crashlytics.a.b a6 = com.google.firebase.crashlytics.a.b.a();
                "Result was: ".concat(String.valueOf(i2));
                a6.a(3);
                return z.a(i2) == 0;
            } catch (IOException e2) {
                com.google.firebase.crashlytics.a.b.a().a(6);
                throw new RuntimeException(e2);
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }

    private b a(b bVar, com.google.firebase.crashlytics.a.i.a.a aVar) {
        b a2 = bVar.a("X-CRASHLYTICS-GOOGLE-APP-ID", aVar.f38619b).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f38636b);
        for (Map.Entry next : aVar.f38620c.f().entrySet()) {
            a2 = a2.a((String) next.getKey(), (String) next.getValue());
        }
        return a2;
    }

    private static b a(b bVar, com.google.firebase.crashlytics.a.i.a.c cVar) {
        b b2 = bVar.b("report[identifier]", cVar.c());
        if (cVar.e().length == 1) {
            com.google.firebase.crashlytics.a.b a2 = com.google.firebase.crashlytics.a.b.a();
            StringBuilder sb = new StringBuilder("Adding single file ");
            sb.append(cVar.b());
            sb.append(" to report ");
            sb.append(cVar.c());
            a2.a(3);
            return b2.a("report[file]", cVar.b(), "application/octet-stream", cVar.d());
        }
        int i2 = 0;
        for (File file : cVar.e()) {
            com.google.firebase.crashlytics.a.b a3 = com.google.firebase.crashlytics.a.b.a();
            StringBuilder sb2 = new StringBuilder("Adding file ");
            sb2.append(file.getName());
            sb2.append(" to report ");
            sb2.append(cVar.c());
            a3.a(3);
            b2 = b2.a("report[file" + i2 + "]", file.getName(), "application/octet-stream", file);
            i2++;
        }
        return b2;
    }
}
