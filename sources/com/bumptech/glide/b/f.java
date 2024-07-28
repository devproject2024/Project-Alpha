package com.bumptech.glide.b;

import android.content.Context;
import android.util.Log;
import androidx.core.content.b;
import com.bumptech.glide.b.c;

public final class f implements d {
    public final c a(Context context, c.a aVar) {
        boolean z = b.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        Log.isLoggable("ConnectivityMonitor", 3);
        if (z) {
            return new e(context, aVar);
        }
        return new j();
    }
}
