package com.paytmmall.clpartifact.widgets.callback;

import android.app.Activity;
import android.content.Context;

public final class CustomActionHelper {
    public static final CustomActionHelper INSTANCE = new CustomActionHelper();

    private CustomActionHelper() {
    }

    public final Activity getHostActivity(Context context, CustomAction customAction) {
        ActivityListener activityListener;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (customAction == null || (activityListener = customAction.getActivityListener()) == null) {
            return null;
        }
        return activityListener.getHostActivity();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r2 = r3.getActivityListener();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.Context getContext(android.content.Context r2, com.paytmmall.clpartifact.widgets.callback.CustomAction r3) {
        /*
            r1 = this;
            boolean r0 = r2 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0005
            return r2
        L_0x0005:
            if (r3 == 0) goto L_0x0012
            com.paytmmall.clpartifact.widgets.callback.ActivityListener r2 = r3.getActivityListener()
            if (r2 == 0) goto L_0x0012
            android.app.Activity r2 = r2.getHostActivity()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            android.content.Context r2 = (android.content.Context) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.widgets.callback.CustomActionHelper.getContext(android.content.Context, com.paytmmall.clpartifact.widgets.callback.CustomAction):android.content.Context");
    }
}
