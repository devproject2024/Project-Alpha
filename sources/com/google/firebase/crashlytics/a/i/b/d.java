package com.google.firebase.crashlytics.a.i.b;

import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.firebase.crashlytics.a.c.a;
import com.google.firebase.crashlytics.a.c.z;
import com.google.firebase.crashlytics.a.f.b;
import com.google.firebase.crashlytics.a.f.c;
import com.sendbird.android.constant.StringSet;
import java.io.File;
import java.io.IOException;

public final class d extends a implements b {

    /* renamed from: b  reason: collision with root package name */
    private final String f38641b;

    public d(String str, String str2, c cVar, String str3) {
        super(str, str2, cVar, com.google.firebase.crashlytics.a.f.a.POST);
        this.f38641b = str3;
    }

    public final boolean a(com.google.firebase.crashlytics.a.i.a.a aVar, boolean z) {
        if (z) {
            b a2 = a();
            a2.a("User-Agent", "Crashlytics Android SDK/17.1.0").a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f38641b).a("X-CRASHLYTICS-GOOGLE-APP-ID", aVar.f38619b);
            b a3 = a(a2, aVar.f38618a, aVar.f38620c);
            com.google.firebase.crashlytics.a.b a4 = com.google.firebase.crashlytics.a.b.a();
            new StringBuilder("Sending report to: ").append(this.f38149a);
            a4.a(3);
            try {
                int i2 = a3.a().f38580a;
                com.google.firebase.crashlytics.a.b a5 = com.google.firebase.crashlytics.a.b.a();
                "Result was: ".concat(String.valueOf(i2));
                a5.a(3);
                return z.a(i2) == 0;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }

    private static b a(b bVar, String str, com.google.firebase.crashlytics.a.i.a.c cVar) {
        if (str != null) {
            bVar.b("org_id", str);
        }
        bVar.b("report_id", cVar.c());
        for (File file : cVar.e()) {
            if (file.getName().equals("minidump")) {
                bVar.a("minidump_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("metadata")) {
                bVar.a("crash_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("binaryImages")) {
                bVar.a("binary_images_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("session")) {
                bVar.a("session_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals(AppManagerUtil.EXTEND_PREFIX_DEFAULT)) {
                bVar.a("app_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals(AppConstants.TAG_DEVICE)) {
                bVar.a("device_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("os")) {
                bVar.a("os_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals(StringSet.user)) {
                bVar.a("user_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("logs")) {
                bVar.a("logs_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("keys")) {
                bVar.a("keys_file", file.getName(), "application/octet-stream", file);
            }
        }
        return bVar;
    }
}
