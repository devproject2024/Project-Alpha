package com.bumptech.glide.load.d.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import java.io.IOException;
import java.util.List;

public final class e implements k<Uri, Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7203a;

    public final /* bridge */ /* synthetic */ v a(Object obj, int i2, int i3, i iVar) throws IOException {
        return a((Uri) obj);
    }

    public final /* synthetic */ boolean a(Object obj, i iVar) throws IOException {
        return ((Uri) obj).getScheme().equals("android.resource");
    }

    public e(Context context) {
        this.f7203a = context.getApplicationContext();
    }

    public final v<Drawable> a(Uri uri) {
        Context a2 = a(uri, uri.getAuthority());
        return d.a(a.a(this.f7203a, a2, a(a2, uri)));
    }

    private Context a(Uri uri, String str) {
        if (str.equals(this.f7203a.getPackageName())) {
            return this.f7203a;
        }
        try {
            return this.f7203a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.f7203a.getPackageName())) {
                return this.f7203a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: ".concat(String.valueOf(uri)), e2);
        }
    }

    private static int a(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return b(context, uri);
        }
        if (pathSegments.size() == 1) {
            return b(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: ".concat(String.valueOf(uri)));
    }

    private static int b(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: ".concat(String.valueOf(uri)));
    }

    private static int b(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unrecognized Uri format: ".concat(String.valueOf(uri)), e2);
        }
    }
}
