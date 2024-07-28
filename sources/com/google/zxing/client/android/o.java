package com.google.zxing.client.android;

import android.net.Uri;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final CharSequence f40264a = "{CODE}";

    /* renamed from: b  reason: collision with root package name */
    private static final CharSequence f40265b = "{RAWCODE}";

    /* renamed from: c  reason: collision with root package name */
    private static final CharSequence f40266c = "{META}";

    /* renamed from: d  reason: collision with root package name */
    private static final CharSequence f40267d = "{FORMAT}";

    /* renamed from: e  reason: collision with root package name */
    private static final CharSequence f40268e = "{TYPE}";

    /* renamed from: f  reason: collision with root package name */
    private final String f40269f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f40270g;

    public o(Uri uri) {
        this.f40269f = uri.getQueryParameter("ret");
        this.f40270g = uri.getQueryParameter("raw") != null;
    }
}
