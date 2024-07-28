package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.a.a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.internal.s;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final a f8260a = new a("RevokeAccessOperation");

    /* renamed from: b  reason: collision with root package name */
    private final String f8261b;

    /* renamed from: c  reason: collision with root package name */
    private final s f8262c = new s((e) null);

    private d(String str) {
        this.f8261b = com.google.android.gms.common.internal.s.a(str);
    }

    public final void run() {
        Status status = Status.f8356c;
        try {
            String valueOf = String.valueOf(this.f8261b);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(valueOf.length() != 0 ? "https://accounts.google.com/o/oauth2/revoke?token=".concat(valueOf) : new String("https://accounts.google.com/o/oauth2/revoke?token=")).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f8354a;
            } else {
                f8260a.b("Unable to revoke access!", new Object[0]);
            }
            a aVar = f8260a;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            aVar.a(sb.toString(), new Object[0]);
        } catch (IOException e2) {
            a aVar2 = f8260a;
            String valueOf2 = String.valueOf(e2.toString());
            aVar2.b(valueOf2.length() != 0 ? "IOException when revoking access: ".concat(valueOf2) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e3) {
            a aVar3 = f8260a;
            String valueOf3 = String.valueOf(e3.toString());
            aVar3.b(valueOf3.length() != 0 ? "Exception when revoking access: ".concat(valueOf3) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.f8262c.a(status);
    }

    public static g<Status> a(String str) {
        if (str == null) {
            Status status = new Status(4);
            com.google.android.gms.common.internal.s.a(status, (Object) "Result must not be null");
            com.google.android.gms.common.internal.s.b(!status.a().c(), "Status code must not be SUCCESS");
            h.a aVar = new h.a(status);
            aVar.a(status);
            return aVar;
        }
        d dVar = new d(str);
        new Thread(dVar).start();
        return dVar.f8262c;
    }
}
