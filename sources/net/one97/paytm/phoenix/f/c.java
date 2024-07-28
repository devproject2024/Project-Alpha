package net.one97.paytm.phoenix.f;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

public final class c implements ThreadFactory {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int f59582a = 10;

    public final Thread newThread(final Runnable runnable) {
        return new Thread(new Runnable() {
            public final void run() {
                try {
                    Process.setThreadPriority(c.this.f59582a);
                } catch (Throwable unused) {
                }
                runnable.run();
            }
        });
    }
}
