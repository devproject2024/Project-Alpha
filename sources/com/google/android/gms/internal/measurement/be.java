package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.a.a;

public final class be {

    /* renamed from: a  reason: collision with root package name */
    private static final a<String, Uri> f10490a = new a<>();

    public static synchronized Uri a(String str) {
        Uri uri;
        synchronized (be.class) {
            uri = f10490a.get(str);
            if (uri == null) {
                String valueOf = String.valueOf(Uri.encode(str));
                uri = Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
                f10490a.put(str, uri);
            }
        }
        return uri;
    }
}
