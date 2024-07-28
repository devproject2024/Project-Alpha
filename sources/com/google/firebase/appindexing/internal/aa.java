package com.google.firebase.appindexing.internal;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;

final class aa extends a {

    /* renamed from: a  reason: collision with root package name */
    private final ContentResolver f38020a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f38021b;

    public aa(Context context) {
        this.f38021b = context;
        this.f38020a = context.getContentResolver();
    }

    public final void a(String str, Uri uri) {
        ContentProviderClient acquireUnstableContentProviderClient = this.f38020a.acquireUnstableContentProviderClient(uri);
        try {
            Bundle bundle = new Bundle();
            bundle.putParcelable("slice_uri", uri);
            bundle.putString("provider_pkg", this.f38021b.getPackageName());
            bundle.putString("pkg", str);
            acquireUnstableContentProviderClient.call("grant_perms", (String) null, bundle);
        } catch (RemoteException unused) {
        } finally {
            acquireUnstableContentProviderClient.release();
        }
    }
}
