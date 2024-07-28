package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.a;
import android.util.Log;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2754a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static String f2755b;

    /* renamed from: c  reason: collision with root package name */
    private static Set<String> f2756c = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private static final Object f2757f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static d f2758g;

    /* renamed from: d  reason: collision with root package name */
    private final Context f2759d;

    /* renamed from: e  reason: collision with root package name */
    private final NotificationManager f2760e = ((NotificationManager) this.f2759d.getSystemService("notification"));

    interface e {
        void a(android.support.v4.app.a aVar) throws RemoteException;
    }

    public static k a(Context context) {
        return new k(context);
    }

    private k(Context context) {
        this.f2759d = context;
    }

    public final boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f2760e.areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) this.f2759d.getSystemService("appops");
            ApplicationInfo applicationInfo = this.f2759d.getApplicationInfo();
            String packageName = this.f2759d.getApplicationContext().getPackageName();
            int i2 = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                if (((Integer) cls.getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName})).intValue() == 0) {
                    return true;
                }
                return false;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            }
        }
        return true;
    }

    public final void a(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2760e.createNotificationChannel(notificationChannel);
        }
    }

    public final NotificationChannel a(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f2760e.getNotificationChannel(str);
        }
        return null;
    }

    public static Set<String> b(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f2754a) {
            if (string != null) {
                if (!string.equals(f2755b)) {
                    String[] split = string.split(AppConstants.COLON, -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    f2756c = hashSet;
                    f2755b = string;
                }
            }
            set = f2756c;
        }
        return set;
    }

    private void a(e eVar) {
        synchronized (f2757f) {
            if (f2758g == null) {
                f2758g = new d(this.f2759d.getApplicationContext());
            }
            f2758g.a(eVar);
        }
    }

    static class d implements ServiceConnection, Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final Context f2771a;

        /* renamed from: b  reason: collision with root package name */
        private final HandlerThread f2772b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f2773c;

        /* renamed from: d  reason: collision with root package name */
        private final Map<ComponentName, a> f2774d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private Set<String> f2775e = new HashSet();

        d(Context context) {
            this.f2771a = context;
            this.f2772b = new HandlerThread("NotificationManagerCompat");
            this.f2772b.start();
            this.f2773c = new Handler(this.f2772b.getLooper(), this);
        }

        public final void a(e eVar) {
            this.f2773c.obtainMessage(0, eVar).sendToTarget();
        }

        public final boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                e eVar = (e) message.obj;
                Set<String> b2 = k.b(this.f2771a);
                if (!b2.equals(this.f2775e)) {
                    this.f2775e = b2;
                    List<ResolveInfo> queryIntentServices = this.f2771a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                    HashSet<ComponentName> hashSet = new HashSet<>();
                    for (ResolveInfo next : queryIntentServices) {
                        if (b2.contains(next.serviceInfo.packageName)) {
                            ComponentName componentName = new ComponentName(next.serviceInfo.packageName, next.serviceInfo.name);
                            if (next.serviceInfo.permission != null) {
                                StringBuilder sb = new StringBuilder("Permission present on component ");
                                sb.append(componentName);
                                sb.append(", not adding listener record.");
                            } else {
                                hashSet.add(componentName);
                            }
                        }
                    }
                    for (ComponentName componentName2 : hashSet) {
                        if (!this.f2774d.containsKey(componentName2)) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                new StringBuilder("Adding listener record for ").append(componentName2);
                            }
                            this.f2774d.put(componentName2, new a(componentName2));
                        }
                    }
                    Iterator<Map.Entry<ComponentName, a>> it2 = this.f2774d.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry next2 = it2.next();
                        if (!hashSet.contains(next2.getKey())) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                new StringBuilder("Removing listener record for ").append(next2.getKey());
                            }
                            a((a) next2.getValue());
                            it2.remove();
                        }
                    }
                }
                for (a next3 : this.f2774d.values()) {
                    next3.f2779d.add(eVar);
                    c(next3);
                }
                return true;
            } else if (i2 == 1) {
                c cVar = (c) message.obj;
                ComponentName componentName3 = cVar.f2769a;
                IBinder iBinder = cVar.f2770b;
                a aVar = this.f2774d.get(componentName3);
                if (aVar != null) {
                    aVar.f2778c = a.C0009a.a(iBinder);
                    aVar.f2780e = 0;
                    c(aVar);
                }
                return true;
            } else if (i2 == 2) {
                a aVar2 = this.f2774d.get((ComponentName) message.obj);
                if (aVar2 != null) {
                    a(aVar2);
                }
                return true;
            } else if (i2 != 3) {
                return false;
            } else {
                a aVar3 = this.f2774d.get((ComponentName) message.obj);
                if (aVar3 != null) {
                    c(aVar3);
                }
                return true;
            }
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Connected to service ").append(componentName);
            }
            this.f2773c.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Disconnected from service ").append(componentName);
            }
            this.f2773c.obtainMessage(2, componentName).sendToTarget();
        }

        private void a(a aVar) {
            if (aVar.f2777b) {
                this.f2771a.unbindService(this);
                aVar.f2777b = false;
            }
            aVar.f2778c = null;
        }

        private void b(a aVar) {
            if (!this.f2773c.hasMessages(3, aVar.f2776a)) {
                aVar.f2780e++;
                if (aVar.f2780e > 6) {
                    StringBuilder sb = new StringBuilder("Giving up on delivering ");
                    sb.append(aVar.f2779d.size());
                    sb.append(" tasks to ");
                    sb.append(aVar.f2776a);
                    sb.append(" after ");
                    sb.append(aVar.f2780e);
                    sb.append(" retries");
                    aVar.f2779d.clear();
                    return;
                }
                int i2 = (1 << (aVar.f2780e - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    StringBuilder sb2 = new StringBuilder("Scheduling retry for ");
                    sb2.append(i2);
                    sb2.append(" ms");
                }
                this.f2773c.sendMessageDelayed(this.f2773c.obtainMessage(3, aVar.f2776a), (long) i2);
            }
        }

        private void c(a aVar) {
            boolean z;
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder sb = new StringBuilder("Processing component ");
                sb.append(aVar.f2776a);
                sb.append(", ");
                sb.append(aVar.f2779d.size());
                sb.append(" queued tasks");
            }
            if (!aVar.f2779d.isEmpty()) {
                if (aVar.f2777b) {
                    z = true;
                } else {
                    aVar.f2777b = this.f2771a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f2776a), this, 33);
                    if (aVar.f2777b) {
                        aVar.f2780e = 0;
                    } else {
                        new StringBuilder("Unable to bind to listener ").append(aVar.f2776a);
                        this.f2771a.unbindService(this);
                    }
                    z = aVar.f2777b;
                }
                if (!z || aVar.f2778c == null) {
                    b(aVar);
                    return;
                }
                while (true) {
                    e peek = aVar.f2779d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            new StringBuilder("Sending task ").append(peek);
                        }
                        peek.a(aVar.f2778c);
                        aVar.f2779d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            new StringBuilder("Remote service has died: ").append(aVar.f2776a);
                        }
                    } catch (RemoteException unused2) {
                        new StringBuilder("RemoteException communicating with ").append(aVar.f2776a);
                    }
                }
                if (!aVar.f2779d.isEmpty()) {
                    b(aVar);
                }
            }
        }

        static class a {

            /* renamed from: a  reason: collision with root package name */
            final ComponentName f2776a;

            /* renamed from: b  reason: collision with root package name */
            boolean f2777b = false;

            /* renamed from: c  reason: collision with root package name */
            android.support.v4.app.a f2778c;

            /* renamed from: d  reason: collision with root package name */
            ArrayDeque<e> f2779d = new ArrayDeque<>();

            /* renamed from: e  reason: collision with root package name */
            int f2780e = 0;

            a(ComponentName componentName) {
                this.f2776a = componentName;
            }
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f2769a;

        /* renamed from: b  reason: collision with root package name */
        final IBinder f2770b;

        c(ComponentName componentName, IBinder iBinder) {
            this.f2769a = componentName;
            this.f2770b = iBinder;
        }
    }

    static class b implements e {

        /* renamed from: a  reason: collision with root package name */
        final String f2765a;

        /* renamed from: b  reason: collision with root package name */
        final int f2766b;

        /* renamed from: c  reason: collision with root package name */
        final String f2767c = null;

        /* renamed from: d  reason: collision with root package name */
        final Notification f2768d;

        b(String str, int i2, Notification notification) {
            this.f2765a = str;
            this.f2766b = i2;
            this.f2768d = notification;
        }

        public final void a(android.support.v4.app.a aVar) throws RemoteException {
            aVar.a(this.f2765a, this.f2766b, this.f2767c, this.f2768d);
        }

        public final String toString() {
            return "NotifyTask[" + "packageName:" + this.f2765a + ", id:" + this.f2766b + ", tag:" + this.f2767c + "]";
        }
    }

    static class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final String f2761a;

        /* renamed from: b  reason: collision with root package name */
        final int f2762b;

        /* renamed from: c  reason: collision with root package name */
        final String f2763c = null;

        /* renamed from: d  reason: collision with root package name */
        final boolean f2764d = false;

        a(String str, int i2) {
            this.f2761a = str;
            this.f2762b = i2;
        }

        public final void a(android.support.v4.app.a aVar) throws RemoteException {
            if (this.f2764d) {
                aVar.a(this.f2761a);
            } else {
                aVar.a(this.f2761a, this.f2762b, this.f2763c);
            }
        }

        public final String toString() {
            return "CancelTask[" + "packageName:" + this.f2761a + ", id:" + this.f2762b + ", tag:" + this.f2763c + ", all:" + this.f2764d + "]";
        }
    }

    public final void a(int i2) {
        this.f2760e.cancel((String) null, i2);
        if (Build.VERSION.SDK_INT <= 19) {
            a((e) new a(this.f2759d.getPackageName(), i2));
        }
    }

    public final void a(int i2, Notification notification) {
        Bundle a2 = h.a(notification);
        if (a2 != null && a2.getBoolean("android.support.useSideChannel")) {
            a((e) new b(this.f2759d.getPackageName(), i2, notification));
            this.f2760e.cancel((String) null, i2);
            return;
        }
        this.f2760e.notify((String) null, i2, notification);
    }
}
