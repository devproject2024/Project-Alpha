package a.a.a.a.a.c;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Collections;

public final class b {

    /* renamed from: f  reason: collision with root package name */
    private static b f713f = new b();

    /* renamed from: a  reason: collision with root package name */
    public Context f714a;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f715b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f716c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f717d;

    /* renamed from: e  reason: collision with root package name */
    public C0000b f718e;

    class a extends BroadcastReceiver {
        a() {
        }

        public final void onReceive(Context context, Intent intent) {
            b bVar;
            boolean z;
            KeyguardManager keyguardManager;
            if (intent != null) {
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    bVar = b.this;
                    z = true;
                } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction()) || ("android.intent.action.SCREEN_ON".equals(intent.getAction()) && (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) != null && !keyguardManager.inKeyguardRestrictedInputMode())) {
                    bVar = b.this;
                    z = false;
                } else {
                    return;
                }
                b.a(bVar, z);
            }
        }
    }

    /* renamed from: a.a.a.a.a.c.b$b  reason: collision with other inner class name */
    public interface C0000b {
        void a(boolean z);
    }

    private b() {
    }

    public static b a() {
        return f713f;
    }

    private void c() {
        boolean z = !this.f717d;
        for (T t : Collections.unmodifiableCollection(a.a().f711a)) {
            a.a.a.a.a.g.a aVar = t.f703c;
            if (aVar.f739a.get() != null) {
                String str = z ? "foregrounded" : "backgrounded";
                d.a();
                d.a(aVar.c(), "setState", str);
            }
        }
    }

    static /* synthetic */ void a(b bVar, boolean z) {
        if (bVar.f717d != z) {
            bVar.f717d = z;
            if (bVar.f716c) {
                bVar.c();
                C0000b bVar2 = bVar.f718e;
                if (bVar2 != null) {
                    bVar2.a(!bVar.f717d);
                }
            }
        }
    }

    public final void b() {
        this.f715b = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f714a.registerReceiver(this.f715b, intentFilter);
        this.f716c = true;
        c();
    }
}
