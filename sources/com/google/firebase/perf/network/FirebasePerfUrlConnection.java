package com.google.firebase.perf.network;

import com.google.android.gms.internal.p001firebaseperf.ai;
import com.google.android.gms.internal.p001firebaseperf.t;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import com.google.firebase.perf.internal.g;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class FirebasePerfUrlConnection {
    private FirebasePerfUrlConnection() {
    }

    public static InputStream openStream(URL url) throws IOException {
        return a(new ai(url), g.a(), new zzbg());
    }

    public static Object getContent(URL url) throws IOException {
        return b(new ai(url), g.a(), new zzbg());
    }

    public static Object getContent(URL url, Class[] clsArr) throws IOException {
        return a(new ai(url), clsArr, g.a(), new zzbg());
    }

    public static Object instrument(Object obj) throws IOException {
        if (obj instanceof HttpsURLConnection) {
            return new c((HttpsURLConnection) obj, new zzbg(), t.a(g.a()));
        }
        return obj instanceof HttpURLConnection ? new d((HttpURLConnection) obj, new zzbg(), t.a(g.a())) : obj;
    }

    private static InputStream a(ai aiVar, g gVar, zzbg zzbg) throws IOException {
        zzbg.a();
        long j = zzbg.f9736a;
        t a2 = t.a(gVar);
        try {
            URLConnection openConnection = aiVar.f9494a.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new c((HttpsURLConnection) openConnection, zzbg, a2).getInputStream();
            }
            if (openConnection instanceof HttpURLConnection) {
                return new d((HttpURLConnection) openConnection, zzbg, a2).getInputStream();
            }
            return openConnection.getInputStream();
        } catch (IOException e2) {
            a2.b(j);
            a2.d(zzbg.b());
            a2.a(aiVar.toString());
            g.a(a2);
            throw e2;
        }
    }

    private static Object b(ai aiVar, g gVar, zzbg zzbg) throws IOException {
        zzbg.a();
        long j = zzbg.f9736a;
        t a2 = t.a(gVar);
        try {
            URLConnection openConnection = aiVar.f9494a.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new c((HttpsURLConnection) openConnection, zzbg, a2).getContent();
            }
            if (openConnection instanceof HttpURLConnection) {
                return new d((HttpURLConnection) openConnection, zzbg, a2).getContent();
            }
            return openConnection.getContent();
        } catch (IOException e2) {
            a2.b(j);
            a2.d(zzbg.b());
            a2.a(aiVar.toString());
            g.a(a2);
            throw e2;
        }
    }

    private static Object a(ai aiVar, Class[] clsArr, g gVar, zzbg zzbg) throws IOException {
        zzbg.a();
        long j = zzbg.f9736a;
        t a2 = t.a(gVar);
        try {
            URLConnection openConnection = aiVar.f9494a.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new c((HttpsURLConnection) openConnection, zzbg, a2).getContent(clsArr);
            }
            if (openConnection instanceof HttpURLConnection) {
                return new d((HttpURLConnection) openConnection, zzbg, a2).getContent(clsArr);
            }
            return openConnection.getContent(clsArr);
        } catch (IOException e2) {
            a2.b(j);
            a2.d(zzbg.b());
            a2.a(aiVar.toString());
            g.a(a2);
            throw e2;
        }
    }
}
