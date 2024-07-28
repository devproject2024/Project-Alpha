package com.google.android.gms.internal.firebase_ml;

import com.alipay.mobile.nebula.util.H5Utils;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.s;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class dj {

    /* renamed from: a  reason: collision with root package name */
    private static final j f9799a = new j("LibraryVersion", "");

    /* renamed from: b  reason: collision with root package name */
    private static dj f9800b = new dj();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f9801c = new ConcurrentHashMap<>();

    public static dj a() {
        return f9800b;
    }

    private dj() {
    }

    public final String a(String str) {
        s.a(str, (Object) "Please provide a valid libraryName");
        if (this.f9801c.containsKey(str)) {
            return this.f9801c.get(str);
        }
        Properties properties = new Properties();
        String str2 = null;
        try {
            InputStream resourceAsStream = dj.class.getResourceAsStream(String.format("/%s.properties", new Object[]{str}));
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                str2 = properties.getProperty("version", (String) null);
                j jVar = f9799a;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(str2).length());
                sb.append(str);
                sb.append(" version is ");
                sb.append(str2);
                jVar.b(sb.toString());
            } else {
                j jVar2 = f9799a;
                String valueOf = String.valueOf(str);
                jVar2.c(valueOf.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf) : new String("Failed to get app version for libraryName: "));
            }
        } catch (IOException unused) {
            j jVar3 = f9799a;
            String valueOf2 = String.valueOf(str);
            jVar3.d(valueOf2.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf2) : new String("Failed to get app version for libraryName: "));
        }
        if (str2 == null) {
            f9799a.a(".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            str2 = H5Utils.NETWORK_TYPE_UNKNOWN;
        }
        this.f9801c.put(str, str2);
        return str2;
    }
}
