package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.impl.utils.k;
import androidx.work.l;

public class SystemAlarmService extends LifecycleService implements e.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5247a = l.a("SystemAlarmService");

    /* renamed from: b  reason: collision with root package name */
    private e f5248b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5249c;

    public void onCreate() {
        super.onCreate();
        b();
        this.f5249c = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f5249c = true;
        this.f5248b.a();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (this.f5249c) {
            l.a();
            this.f5248b.a();
            b();
            this.f5249c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f5248b.a(intent, i3);
        return 3;
    }

    public final void a() {
        this.f5249c = true;
        l.a();
        k.a();
        stopSelf();
    }

    private void b() {
        this.f5248b = new e(this);
        this.f5248b.a((e.b) this);
    }
}
