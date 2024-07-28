package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.view.KeyEvent;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            new StringBuilder("Ignore unsupported intent: ").append(intent);
            return;
        }
        ComponentName a2 = a(context, "android.intent.action.MEDIA_BUTTON");
        if (a2 != null) {
            intent.setComponent(a2);
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        } else {
            ComponentName a3 = a(context, "android.media.browse.MediaBrowserService");
            if (a3 != null) {
                BroadcastReceiver.PendingResult goAsync = goAsync();
                Context applicationContext = context.getApplicationContext();
                a aVar = new a(applicationContext, intent, goAsync);
                MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, a3, aVar);
                aVar.f3842c = mediaBrowserCompat;
                mediaBrowserCompat.f788b.c();
                return;
            }
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
    }

    static class a extends MediaBrowserCompat.b {

        /* renamed from: c  reason: collision with root package name */
        MediaBrowserCompat f3842c;

        /* renamed from: d  reason: collision with root package name */
        private final Context f3843d;

        /* renamed from: e  reason: collision with root package name */
        private final Intent f3844e;

        /* renamed from: f  reason: collision with root package name */
        private final BroadcastReceiver.PendingResult f3845f;

        a(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f3843d = context;
            this.f3844e = intent;
            this.f3845f = pendingResult;
        }

        public final void a() {
            try {
                MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(this.f3843d, this.f3842c.f788b.e());
                KeyEvent keyEvent = (KeyEvent) this.f3844e.getParcelableExtra("android.intent.extra.KEY_EVENT");
                if (keyEvent != null) {
                    mediaControllerCompat.f860a.a(keyEvent);
                    d();
                    return;
                }
                throw new IllegalArgumentException("KeyEvent may not be null");
            } catch (RemoteException unused) {
            }
        }

        public final void b() {
            d();
        }

        public final void c() {
            d();
        }

        private void d() {
            this.f3842c.a();
            this.f3845f.finish();
        }
    }

    private static ComponentName a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
        }
    }
}
