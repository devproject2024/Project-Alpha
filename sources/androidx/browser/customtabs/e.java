package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.a.b;

public abstract class e implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    Context f1910a;

    public abstract void a(ComponentName componentName, c cVar);

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f1910a != null) {
            a(componentName, new c(b.a.a(iBinder), componentName, this.f1910a) {
            });
            return;
        }
        throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
    }
}
