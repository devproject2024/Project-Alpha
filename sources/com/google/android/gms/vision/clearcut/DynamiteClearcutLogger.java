package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.vision.bt;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DynamiteClearcutLogger {
    private static final ThreadPoolExecutor zzbo = new ThreadPoolExecutor(1, 2, 2, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new ThreadPoolExecutor.DiscardPolicy());
    private b zzbp = new b();
    /* access modifiers changed from: private */
    public VisionClearcutLogger zzbq;

    public DynamiteClearcutLogger(Context context) {
        this.zzbq = new VisionClearcutLogger(context);
    }

    public final void zza(int i2, bt.o oVar) {
        if (i2 != 3 || this.zzbp.a()) {
            zzbo.execute(new a(this, i2, oVar));
            return;
        }
        Object[] objArr = new Object[0];
        if (Log.isLoggable("Vision", 2)) {
            String.format("Skipping image analysis log due to rate limiting", objArr);
        }
    }
}
