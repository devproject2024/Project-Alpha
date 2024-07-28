package com.google.android.gms.phenotype;

import android.net.Uri;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.i.d;
import com.google.android.gms.internal.i.e;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a.g<e> f12413a = new a.g<>();

    /* renamed from: b  reason: collision with root package name */
    private static final a.C0125a<e, Object> f12414b = new j();
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private static final com.google.android.gms.common.api.a<Object> f12415c = new com.google.android.gms.common.api.a<>("Phenotype.API", f12414b, f12413a);
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    private static final k f12416d = new d();

    public static Uri a(String str) {
        String valueOf = String.valueOf(Uri.encode(str));
        return Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
    }
}
