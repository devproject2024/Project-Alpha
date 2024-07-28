package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.h;

public final class aa implements h {
    public final g<LocationSettingsResult> a(e eVar, LocationSettingsRequest locationSettingsRequest) {
        return eVar.a(new ab(eVar, locationSettingsRequest));
    }
}
