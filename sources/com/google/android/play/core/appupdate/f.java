package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.a.b;
import com.google.android.play.core.a.d;
import com.google.android.play.core.c.c;

public final class f extends c<b> {
    public f(Context context) {
        super(new com.google.android.play.core.b.b("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    public final void a(Context context, Intent intent) {
        Intent intent2 = intent;
        if (context.getPackageName().equals(intent2.getStringExtra("package.name"))) {
            this.f37334d.a("List of extras in received intent:", new Object[0]);
            for (String str : intent.getExtras().keySet()) {
                this.f37334d.a("Key: %s; value: %s", str, intent.getExtras().get(str));
            }
            com.google.android.play.core.b.b bVar = this.f37334d;
            bVar.a("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
            bVar.a("Key: %s; value: %s", "install.status", Integer.valueOf(intent2.getIntExtra("install.status", 0)));
            bVar.a("Key: %s; value: %s", "error.code", Integer.valueOf(intent2.getIntExtra("error.code", 0)));
            d dVar = new d(intent2.getIntExtra("install.status", 0), intent2.getLongExtra("bytes.downloaded", 0), intent2.getLongExtra("total.bytes.to.download", 0), intent2.getIntExtra("error.code", 0), intent2.getStringExtra("package.name"));
            this.f37334d.a("ListenerRegistryBroadcastReceiver.onReceive: %s", dVar);
            a(dVar);
            return;
        }
        this.f37334d.a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent2.getStringExtra("package.name"));
    }
}
