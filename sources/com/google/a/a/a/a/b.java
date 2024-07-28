package com.google.a.a.a.a;

import com.google.a.a.a.s;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class b extends s {

    /* renamed from: a  reason: collision with root package name */
    private final HttpURLConnection f7463a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7464b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7465c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<String> f7466d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<String> f7467e = new ArrayList<>();

    b(HttpURLConnection httpURLConnection) throws IOException {
        this.f7463a = httpURLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        this.f7464b = responseCode == -1 ? 0 : responseCode;
        this.f7465c = httpURLConnection.getResponseMessage();
        ArrayList<String> arrayList = this.f7466d;
        ArrayList<String> arrayList2 = this.f7467e;
        for (Map.Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                for (String str2 : (List) entry.getValue()) {
                    if (str2 != null) {
                        arrayList.add(str);
                        arrayList2.add(str2);
                    }
                }
            }
        }
    }

    public final int e() {
        return this.f7464b;
    }

    public final InputStream a() throws IOException {
        try {
            return this.f7463a.getInputStream();
        } catch (IOException unused) {
            return this.f7463a.getErrorStream();
        }
    }

    public final String b() {
        return this.f7463a.getContentEncoding();
    }

    public final String c() {
        return this.f7463a.getHeaderField("Content-Type");
    }

    public final String f() {
        return this.f7465c;
    }

    public final String d() {
        String headerField = this.f7463a.getHeaderField(0);
        if (headerField == null || !headerField.startsWith("HTTP/1.")) {
            return null;
        }
        return headerField;
    }

    public final int g() {
        return this.f7466d.size();
    }

    public final String a(int i2) {
        return this.f7466d.get(i2);
    }

    public final String b(int i2) {
        return this.f7467e.get(i2);
    }

    public final void h() {
        this.f7463a.disconnect();
    }
}
