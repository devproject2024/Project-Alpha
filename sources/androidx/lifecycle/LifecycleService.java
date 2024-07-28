package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.lifecycle.k;

public class LifecycleService extends Service implements q {

    /* renamed from: a  reason: collision with root package name */
    private final af f3585a = new af(this);

    public void onCreate() {
        this.f3585a.a(k.a.ON_CREATE);
        super.onCreate();
    }

    public IBinder onBind(Intent intent) {
        this.f3585a.a(k.a.ON_START);
        return null;
    }

    public void onStart(Intent intent, int i2) {
        this.f3585a.a(k.a.ON_START);
        super.onStart(intent, i2);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return super.onStartCommand(intent, i2, i3);
    }

    public void onDestroy() {
        af afVar = this.f3585a;
        afVar.a(k.a.ON_STOP);
        afVar.a(k.a.ON_DESTROY);
        super.onDestroy();
    }

    public k getLifecycle() {
        return this.f3585a.f3627a;
    }
}
