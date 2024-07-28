package com.google.android.gms.internal.location;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;

public class af extends g<i> {

    /* renamed from: a  reason: collision with root package name */
    private final String f10378a;
    protected final z<i> j = new ag(this);

    public af(Context context, Looper looper, e.b bVar, e.c cVar, String str, d dVar) {
        super(context, looper, 23, dVar, bVar, cVar);
        this.f10378a = str;
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof i ? (i) queryLocalInterface : new j(iBinder);
    }

    public final String a() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    public final String b() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public final int e() {
        return 11925000;
    }

    public final Bundle p() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f10378a);
        return bundle;
    }
}
