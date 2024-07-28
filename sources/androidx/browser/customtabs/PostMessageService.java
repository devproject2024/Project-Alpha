package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.a.a;
import android.support.a.c;

public class PostMessageService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private c.a f1871a = new c.a() {
        public final void a(a aVar, Bundle bundle) throws RemoteException {
            aVar.a(bundle);
        }

        public final void a(a aVar, String str, Bundle bundle) throws RemoteException {
            aVar.b(str, bundle);
        }
    };

    public IBinder onBind(Intent intent) {
        return this.f1871a;
    }
}
