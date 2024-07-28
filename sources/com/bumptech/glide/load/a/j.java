package com.bumptech.glide.load.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.g.c;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.e;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public final class j implements d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    static final b f6703a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final g f6704b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6705c;

    /* renamed from: d  reason: collision with root package name */
    private final b f6706d;

    /* renamed from: e  reason: collision with root package name */
    private HttpURLConnection f6707e;

    /* renamed from: f  reason: collision with root package name */
    private InputStream f6708f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f6709g;

    interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(g gVar, int i2) {
        this(gVar, i2, f6703a);
    }

    private j(g gVar, int i2, b bVar) {
        this.f6704b = gVar;
        this.f6705c = i2;
        this.f6706d = bVar;
    }

    public final void a(f fVar, d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long a2 = com.bumptech.glide.g.f.a();
        try {
            g gVar = this.f6704b;
            if (gVar.f7029f == null) {
                if (TextUtils.isEmpty(gVar.f7028e)) {
                    String str = gVar.f7027d;
                    if (TextUtils.isEmpty(str)) {
                        str = ((URL) com.bumptech.glide.g.j.a(gVar.f7026c, "Argument must not be null")).toString();
                    }
                    gVar.f7028e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
                }
                gVar.f7029f = new URL(gVar.f7028e);
            }
            aVar.a(a(gVar.f7029f, 0, (URL) null, this.f6704b.f7025b.a()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder("Finished http url fetcher fetch in ");
                sb.append(com.bumptech.glide.g.f.a(a2));
            }
        } catch (IOException e2) {
            Log.isLoggable("HttpUrlFetcher", 3);
            aVar.a((Exception) e2);
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder("Finished http url fetcher fetch in ");
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                new StringBuilder("Finished http url fetcher fetch in ").append(com.bumptech.glide.g.f.a(a2));
            }
            throw th;
        }
    }

    private InputStream a(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        while (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new e("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f6707e = this.f6706d.a(url);
            for (Map.Entry next : map.entrySet()) {
                this.f6707e.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            this.f6707e.setConnectTimeout(this.f6705c);
            this.f6707e.setReadTimeout(this.f6705c);
            boolean z = false;
            this.f6707e.setUseCaches(false);
            this.f6707e.setDoInput(true);
            this.f6707e.setInstanceFollowRedirects(false);
            this.f6707e.connect();
            this.f6708f = this.f6707e.getInputStream();
            if (this.f6709g) {
                return null;
            }
            int responseCode = this.f6707e.getResponseCode();
            int i3 = responseCode / 100;
            if (i3 == 2) {
                HttpURLConnection httpURLConnection = this.f6707e;
                if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                    this.f6708f = c.a(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
                } else {
                    if (Log.isLoggable("HttpUrlFetcher", 3)) {
                        new StringBuilder("Got non empty content encoding: ").append(httpURLConnection.getContentEncoding());
                    }
                    this.f6708f = httpURLConnection.getInputStream();
                }
                return this.f6708f;
            }
            if (i3 == 3) {
                z = true;
            }
            if (z) {
                String headerField = this.f6707e.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    b();
                    i2++;
                    url2 = url;
                    url = url3;
                } else {
                    throw new e("Received empty or null redirect url");
                }
            } else if (responseCode == -1) {
                throw new e(responseCode);
            } else {
                throw new e(this.f6707e.getResponseMessage(), responseCode);
            }
        }
        throw new e("Too many (> 5) redirects!");
    }

    public final void b() {
        InputStream inputStream = this.f6708f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f6707e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f6707e = null;
    }

    public final void c() {
        this.f6709g = true;
    }

    public final Class<InputStream> a() {
        return InputStream.class;
    }

    public final com.bumptech.glide.load.a d() {
        return com.bumptech.glide.load.a.REMOTE;
    }

    static class a implements b {
        a() {
        }

        public final HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        }
    }
}
