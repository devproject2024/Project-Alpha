package androidx.core.app;

import androidx.core.app.JobIntentService;

public abstract class CjrSafeJobIntentService extends JobIntentService {
    /* access modifiers changed from: package-private */
    public final JobIntentService.e a() {
        try {
            return super.a();
        } catch (SecurityException unused) {
            return null;
        }
    }
}
