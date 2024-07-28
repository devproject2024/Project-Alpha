package com.google.android.youtube.player.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.youtube.player.internal.p;
import com.google.android.youtube.player.internal.t;
import com.google.android.youtube.player.internal.v;

public final class r extends t<p> implements e {

    /* renamed from: f  reason: collision with root package name */
    private final String f37585f;

    /* renamed from: g  reason: collision with root package name */
    private final String f37586g;

    /* renamed from: h  reason: collision with root package name */
    private final String f37587h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f37588i;

    public r(Context context, String str, String str2, String str3, v.a aVar, v.b bVar) {
        super(context, aVar, bVar);
        this.f37585f = (String) c.a(str);
        this.f37586g = c.a(str2, (Object) "callingPackage cannot be null or empty");
        this.f37587h = c.a(str3, (Object) "callingAppVersion cannot be null or empty");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface a(IBinder iBinder) {
        return p.a.a(iBinder);
    }

    /* access modifiers changed from: protected */
    public final void a(l lVar, t.d dVar) throws RemoteException {
        lVar.a(dVar, 1202, this.f37586g, this.f37587h, this.f37585f, (Bundle) null);
    }

    public final void a(boolean z) {
        if (f()) {
            try {
                ((p) l()).a(z);
            } catch (RemoteException unused) {
            }
            this.f37588i = true;
        }
    }

    /* access modifiers changed from: protected */
    public final String b() {
        return "com.google.android.youtube.player.internal.IYouTubeService";
    }

    /* access modifiers changed from: protected */
    public final String c() {
        return "com.google.android.youtube.api.service.START";
    }

    public final void d() {
        if (!this.f37588i) {
            a(true);
        }
        super.d();
    }

    public final IBinder a() {
        k();
        if (!this.f37588i) {
            try {
                return ((p) l()).a();
            } catch (RemoteException e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            throw new IllegalStateException("Connection client has been released");
        }
    }
}
