package com.google.firebase.appindexing.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;

public final class h extends g<t> {

    /* renamed from: a  reason: collision with root package name */
    static final a<Object> f38024a = new a<>("AppIndexing.API", k, j);
    private static final a.g<h> j = new a.g<>();
    private static final a.C0125a<h, Object> k = new g();

    public h(Context context, Looper looper, d dVar, e.b bVar, e.c cVar) {
        super(context, looper, 113, dVar, bVar, cVar);
    }

    public final String a() {
        return "com.google.android.gms.icing.APP_INDEXING_SERVICE";
    }

    public final String b() {
        return "com.google.firebase.appindexing.internal.IAppIndexingService";
    }

    public final int e() {
        return 12600000;
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.appindexing.internal.IAppIndexingService");
        if (queryLocalInterface instanceof t) {
            return (t) queryLocalInterface;
        }
        return new w(iBinder);
    }
}
