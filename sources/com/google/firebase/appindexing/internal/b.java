package com.google.firebase.appindexing.internal;

import android.app.slice.SliceManager;
import android.content.Context;
import android.net.Uri;

final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private final SliceManager f38022a;

    public b(Context context) {
        this.f38022a = (SliceManager) context.getSystemService(SliceManager.class);
    }

    public final void a(String str, Uri uri) {
        this.f38022a.grantSlicePermission(str, uri);
    }
}
