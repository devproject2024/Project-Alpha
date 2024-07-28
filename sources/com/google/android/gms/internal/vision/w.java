package com.google.android.gms.internal.vision;

import android.net.Uri;
import androidx.a.a;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static final a<String, Uri> f11270a = new a<>();

    public static synchronized Uri a(String str) {
        Uri uri;
        synchronized (w.class) {
            uri = f11270a.get(str);
            if (uri == null) {
                String valueOf = String.valueOf(Uri.encode(str));
                uri = Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
                f11270a.put(str, uri);
            }
        }
        return uri;
    }
}
