package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.a.g;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.gms.internal.e.d;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.h;
import com.google.firebase.iid.FirebaseIidMessengerCompat;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ak {

    /* renamed from: b  reason: collision with root package name */
    private static int f38805b;

    /* renamed from: c  reason: collision with root package name */
    private static PendingIntent f38806c;

    /* renamed from: a  reason: collision with root package name */
    final g<String, f<Bundle>> f38807a = new g<>();

    /* renamed from: d  reason: collision with root package name */
    private final Context f38808d;

    /* renamed from: e  reason: collision with root package name */
    private final af f38809e;

    /* renamed from: f  reason: collision with root package name */
    private final ScheduledExecutorService f38810f;

    /* renamed from: g  reason: collision with root package name */
    private Messenger f38811g;

    /* renamed from: h  reason: collision with root package name */
    private Messenger f38812h;

    /* renamed from: i  reason: collision with root package name */
    private FirebaseIidMessengerCompat f38813i;

    public ak(Context context, af afVar) {
        this.f38808d = context;
        this.f38809e = afVar;
        this.f38811g = new Messenger(new d(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                ak.a(ak.this, message);
            }
        });
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f38810f = scheduledThreadPoolExecutor;
    }

    private static synchronized void a(Context context, Intent intent) {
        synchronized (ak.class) {
            if (f38806c == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f38806c = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra(AppManagerUtil.EXTEND_PREFIX_DEFAULT, f38806c);
        }
    }

    private void a(Intent intent) {
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            String valueOf = String.valueOf(intent.getExtras());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
            sb.append("Unexpected response, no error or registration id ");
            sb.append(valueOf);
            return;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(stringExtra);
            if (valueOf2.length() != 0) {
                "Received InstanceID error ".concat(valueOf2);
            } else {
                new String("Received InstanceID error ");
            }
        }
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (split.length <= 2 || !"ID".equals(split[1])) {
                String valueOf3 = String.valueOf(stringExtra);
                if (valueOf3.length() != 0) {
                    "Unexpected structured response ".concat(valueOf3);
                } else {
                    new String("Unexpected structured response ");
                }
            } else {
                String str = split[2];
                String str2 = split[3];
                if (str2.startsWith(AppConstants.COLON)) {
                    str2 = str2.substring(1);
                }
                a(str, intent.putExtra("error", str2).getExtras());
            }
        } else {
            synchronized (this.f38807a) {
                for (int i2 = 0; i2 < this.f38807a.size(); i2++) {
                    a(this.f38807a.b(i2), intent.getExtras());
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r3, android.os.Bundle r4) {
        /*
            r2 = this;
            androidx.a.g<java.lang.String, com.google.android.gms.tasks.f<android.os.Bundle>> r0 = r2.f38807a
            monitor-enter(r0)
            androidx.a.g<java.lang.String, com.google.android.gms.tasks.f<android.os.Bundle>> r1 = r2.f38807a     // Catch:{ all -> 0x0029 }
            java.lang.Object r1 = r1.remove(r3)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.tasks.f r1 = (com.google.android.gms.tasks.f) r1     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0024
            java.lang.String r4 = "Missing callback for "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0029 }
            int r1 = r3.length()     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x001d
            r4.concat(r3)     // Catch:{ all -> 0x0029 }
            goto L_0x0022
        L_0x001d:
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x0029 }
            r3.<init>(r4)     // Catch:{ all -> 0x0029 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            return
        L_0x0024:
            r1.a(r4)     // Catch:{ all -> 0x0029 }
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            return
        L_0x0029:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.ak.a(java.lang.String, android.os.Bundle):void");
    }

    /* access modifiers changed from: package-private */
    public final Task<Bundle> a(Bundle bundle) {
        if (this.f38809e.e() >= 12000000) {
            return y.a(this.f38808d).a(bundle).a(g.a(), al.f38815a);
        }
        return e(bundle);
    }

    private Task<Bundle> e(Bundle bundle) {
        if (!this.f38809e.a()) {
            return h.a((Exception) new IOException("MISSING_INSTANCEID_SERVICE"));
        }
        return c(bundle).b(g.a(), new am(this, bundle));
    }

    static boolean b(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    private static synchronized String a() {
        String num;
        synchronized (ak.class) {
            int i2 = f38805b;
            f38805b = i2 + 1;
            num = Integer.toString(i2);
        }
        return num;
    }

    /* access modifiers changed from: package-private */
    public final Task<Bundle> c(Bundle bundle) {
        String a2 = a();
        f fVar = new f();
        synchronized (this.f38807a) {
            this.f38807a.put(a2, fVar);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.f38809e.b() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        a(this.f38808d, intent);
        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 5);
        sb.append("|ID|");
        sb.append(a2);
        sb.append("|");
        intent.putExtra("kid", sb.toString());
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 8);
            sb2.append("Sending ");
            sb2.append(valueOf);
        }
        intent.putExtra("google.messenger", this.f38811g);
        if (!(this.f38812h == null && this.f38813i == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                if (this.f38812h != null) {
                    this.f38812h.send(obtain);
                } else {
                    this.f38813i.a(obtain);
                }
            } catch (RemoteException unused) {
                Log.isLoggable("FirebaseInstanceId", 3);
            }
            fVar.f12478a.a(g.a(), new ao(this, a2, this.f38810f.schedule(new an(fVar), 30, TimeUnit.SECONDS)));
            return fVar.f12478a;
        }
        if (this.f38809e.b() == 2) {
            this.f38808d.sendBroadcast(intent);
        } else {
            this.f38808d.startService(intent);
        }
        fVar.f12478a.a(g.a(), new ao(this, a2, this.f38810f.schedule(new an(fVar), 30, TimeUnit.SECONDS)));
        return fVar.f12478a;
    }

    static final /* synthetic */ Task d(Bundle bundle) throws Exception {
        if (b(bundle)) {
            return h.a(null);
        }
        return h.a(bundle);
    }

    static final /* synthetic */ Bundle a(Task task) throws Exception {
        if (task.b()) {
            return (Bundle) task.d();
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(task.e());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
            sb.append("Error making request: ");
            sb.append(valueOf);
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    static /* synthetic */ void a(ak akVar, Message message) {
        if (message != null && (message.obj instanceof Intent)) {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(new FirebaseIidMessengerCompat.a());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof FirebaseIidMessengerCompat) {
                    akVar.f38813i = (FirebaseIidMessengerCompat) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    akVar.f38812h = (Messenger) parcelableExtra;
                }
            }
            Intent intent2 = (Intent) message.obj;
            String action = intent2.getAction();
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    akVar.a(intent2);
                    return;
                }
                Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    Bundle extras = intent2.getExtras();
                    extras.putString("registration_id", group2);
                    akVar.a(group, extras);
                } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(stringExtra);
                    if (valueOf.length() != 0) {
                        "Unexpected response string: ".concat(valueOf);
                    } else {
                        new String("Unexpected response string: ");
                    }
                }
            } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf2 = String.valueOf(action);
                if (valueOf2.length() != 0) {
                    "Unexpected response action: ".concat(valueOf2);
                } else {
                    new String("Unexpected response action: ");
                }
            }
        }
    }
}
