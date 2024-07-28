package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.f.g;
import com.google.android.gms.internal.f.h;
import com.google.android.gms.internal.f.j;
import com.google.android.gms.tasks.Task;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

final class k implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    final URL f39015a;

    /* renamed from: b  reason: collision with root package name */
    Task<Bitmap> f39016b;

    /* renamed from: c  reason: collision with root package name */
    private volatile InputStream f39017c;

    public static k a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new k(new URL(str));
        } catch (MalformedURLException unused) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Not downloading image, bad URL: ".concat(valueOf);
            } else {
                new String("Not downloading image, bad URL: ");
            }
            return null;
        }
    }

    private k(URL url) {
        this.f39015a = url;
    }

    /* access modifiers changed from: package-private */
    public final byte[] a() throws IOException {
        URLConnection openConnection = this.f39015a.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                this.f39017c = inputStream;
                byte[] a2 = g.a(g.b(inputStream));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable("FirebaseMessaging", 2)) {
                    int length = a2.length;
                    String valueOf = String.valueOf(this.f39015a);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("Downloaded ");
                    sb.append(length);
                    sb.append(" bytes from ");
                    sb.append(valueOf);
                }
                if (a2.length <= 1048576) {
                    return a2;
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                j.a(th, th);
            }
        } else {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        throw th;
    }

    public final void close() {
        try {
            h.a(this.f39017c);
        } catch (NullPointerException unused) {
        }
    }
}
