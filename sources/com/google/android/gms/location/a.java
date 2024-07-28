package com.google.android.gms.location;

import android.location.Location;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;

@Deprecated
public interface a {
    Location a(e eVar);

    g<Status> a(e eVar, LocationRequest locationRequest, e eVar2);

    g<Status> a(e eVar, e eVar2);
}
