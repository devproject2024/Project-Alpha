package a.a.a.a.a.b;

import a.a.a.a.a.e.c;
import java.net.URL;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f698a;

    /* renamed from: b  reason: collision with root package name */
    public final URL f699b;

    /* renamed from: c  reason: collision with root package name */
    public final String f700c;

    private h(String str, URL url, String str2) {
        this.f698a = str;
        this.f699b = url;
        this.f700c = str2;
    }

    public static h a(String str, URL url, String str2) {
        c.a(str, "VendorKey is null or empty");
        c.a((Object) url, "ResourceURL is null");
        c.a(str2, "VerificationParameters is null or empty");
        return new h(str, url, str2);
    }
}
