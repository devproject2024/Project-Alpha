package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

public final class q extends UnsupportedOperationException {
    private final Feature zzbe;

    public q(Feature feature) {
        this.zzbe = feature;
    }

    public final String getMessage() {
        String valueOf = String.valueOf(this.zzbe);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
