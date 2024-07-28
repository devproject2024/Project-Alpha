package com.bumptech.glide.load.c;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import java.io.File;
import java.io.InputStream;

public final class u<Data> implements n<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f7085a;

    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    public final /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        Uri uri;
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            uri = null;
        } else if (str.charAt(0) == '/') {
            uri = a(str);
        } else {
            Uri parse = Uri.parse(str);
            if (parse.getScheme() == null) {
                uri = a(str);
            } else {
                uri = parse;
            }
        }
        if (uri == null || !this.f7085a.a(uri)) {
            return null;
        }
        return this.f7085a.a(uri, i2, i3, iVar);
    }

    public u(n<Uri, Data> nVar) {
        this.f7085a = nVar;
    }

    private static Uri a(String str) {
        return Uri.fromFile(new File(str));
    }

    public static class c implements o<String, InputStream> {
        public final n<String, InputStream> a(r rVar) {
            return new u(rVar.a(Uri.class, InputStream.class));
        }
    }

    public static class b implements o<String, ParcelFileDescriptor> {
        public final n<String, ParcelFileDescriptor> a(r rVar) {
            return new u(rVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static final class a implements o<String, AssetFileDescriptor> {
        public final n<String, AssetFileDescriptor> a(r rVar) {
            return new u(rVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }
}
