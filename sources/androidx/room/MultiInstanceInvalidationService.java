package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import androidx.room.e;
import java.util.HashMap;

public class MultiInstanceInvalidationService extends Service {

    /* renamed from: a  reason: collision with root package name */
    int f4367a = 0;

    /* renamed from: b  reason: collision with root package name */
    final HashMap<Integer, String> f4368b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    final RemoteCallbackList<d> f4369c = new RemoteCallbackList<d>() {
        public final /* synthetic */ void onCallbackDied(IInterface iInterface, Object obj) {
            MultiInstanceInvalidationService.this.f4368b.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final e.a f4370d = new e.a() {
        public final int a(d dVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f4369c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i2 = multiInstanceInvalidationService.f4367a + 1;
                multiInstanceInvalidationService.f4367a = i2;
                if (MultiInstanceInvalidationService.this.f4369c.register(dVar, Integer.valueOf(i2))) {
                    MultiInstanceInvalidationService.this.f4368b.put(Integer.valueOf(i2), str);
                    return i2;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f4367a--;
                return 0;
            }
        }

        public final void a(d dVar, int i2) {
            synchronized (MultiInstanceInvalidationService.this.f4369c) {
                MultiInstanceInvalidationService.this.f4369c.unregister(dVar);
                MultiInstanceInvalidationService.this.f4368b.remove(Integer.valueOf(i2));
            }
        }

        public final void a(int i2, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f4369c) {
                String str = MultiInstanceInvalidationService.this.f4368b.get(Integer.valueOf(i2));
                if (str != null) {
                    int beginBroadcast = MultiInstanceInvalidationService.this.f4369c.beginBroadcast();
                    int i3 = 0;
                    while (i3 < beginBroadcast) {
                        try {
                            int intValue = ((Integer) MultiInstanceInvalidationService.this.f4369c.getBroadcastCookie(i3)).intValue();
                            String str2 = MultiInstanceInvalidationService.this.f4368b.get(Integer.valueOf(intValue));
                            if (i2 != intValue && str.equals(str2)) {
                                try {
                                    MultiInstanceInvalidationService.this.f4369c.getBroadcastItem(i3).a(strArr);
                                } catch (RemoteException unused) {
                                }
                            }
                            i3++;
                        } catch (Throwable th) {
                            MultiInstanceInvalidationService.this.f4369c.finishBroadcast();
                            throw th;
                        }
                    }
                    MultiInstanceInvalidationService.this.f4369c.finishBroadcast();
                }
            }
        }
    };

    public IBinder onBind(Intent intent) {
        return this.f4370d;
    }
}
