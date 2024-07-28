package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;

public final class j extends ApiException {
    public j(Status status) {
        super(status);
    }

    public final void startResolutionForResult(Activity activity, int i2) throws IntentSender.SendIntentException {
        getStatus().a(activity, i2);
    }

    public final PendingIntent getResolution() {
        return getStatus().f8362i;
    }
}
