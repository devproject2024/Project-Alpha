package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.a;
import com.google.android.gms.location.f;

public final class aj implements a {
    public final Location a(e eVar) {
        try {
            return f.a(eVar).t();
        } catch (Exception unused) {
            return null;
        }
    }

    public final g<Status> a(e eVar, LocationRequest locationRequest, com.google.android.gms.location.e eVar2) {
        s.a(Looper.myLooper(), (Object) "Calling thread must be a prepared Looper thread.");
        return eVar.b(new ak(eVar, locationRequest, eVar2));
    }

    public final g<Status> a(e eVar, com.google.android.gms.location.e eVar2) {
        return eVar.b(new al(eVar, eVar2));
    }
}
