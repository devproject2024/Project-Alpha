package org.npci.upi.security.pinactivitycomponent;

import android.os.Handler;
import android.os.Looper;
import java.util.TimerTask;

class af extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    long f72931a = (System.currentTimeMillis() - 45000);

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ an f72932b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f72933c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ ae f72934d;

    af(ae aeVar, an anVar, int i2) {
        this.f72934d = aeVar;
        this.f72932b = anVar;
        this.f72933c = i2;
    }

    public void run() {
        am a2 = this.f72932b.a(this.f72933c, this.f72931a - 2000);
        if (a2 != null) {
            new Handler(Looper.getMainLooper()).post(new ag(this, a2));
        }
        this.f72931a = System.currentTimeMillis();
    }
}
