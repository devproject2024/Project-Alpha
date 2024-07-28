package androidx.work.impl.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.impl.utils.b.a;
import androidx.work.l;

public abstract class c<T> extends d<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f5122d = l.a("BrdcstRcvrCnstrntTrckr");

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f5123e = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                c.this.a(intent);
            }
        }
    };

    public abstract IntentFilter a();

    public abstract void a(Intent intent);

    public c(Context context, a aVar) {
        super(context, aVar);
    }

    public final void c() {
        l.a();
        String.format("%s: registering receiver", new Object[]{getClass().getSimpleName()});
        this.f5127b.registerReceiver(this.f5123e, a());
    }

    public final void d() {
        l.a();
        String.format("%s: unregistering receiver", new Object[]{getClass().getSimpleName()});
        this.f5127b.unregisterReceiver(this.f5123e);
    }
}
