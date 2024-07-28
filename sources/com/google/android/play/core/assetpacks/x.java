package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.b.b;
import com.google.android.play.core.b.bh;
import com.google.android.play.core.c.c;
import java.util.ArrayList;
import java.util.concurrent.Executor;

final class x extends c<c> {

    /* renamed from: a  reason: collision with root package name */
    final bo f37253a;

    /* renamed from: b  reason: collision with root package name */
    final ay f37254b;

    /* renamed from: c  reason: collision with root package name */
    final bh<dk> f37255c;

    /* renamed from: f  reason: collision with root package name */
    private final ap f37256f;

    /* renamed from: g  reason: collision with root package name */
    private final ba f37257g;

    /* renamed from: h  reason: collision with root package name */
    private final bh<Executor> f37258h;

    /* renamed from: i  reason: collision with root package name */
    private final bh<Executor> f37259i;
    private final Handler j = new Handler(Looper.getMainLooper());

    x(Context context, bo boVar, ay ayVar, bh<dk> bhVar, ba baVar, ap apVar, bh<Executor> bhVar2, bh<Executor> bhVar3) {
        super(new b("AssetPackServiceListenerRegistry"), new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE"), context);
        this.f37253a = boVar;
        this.f37254b = ayVar;
        this.f37255c = bhVar;
        this.f37257g = baVar;
        this.f37256f = apVar;
        this.f37258h = bhVar2;
        this.f37259i = bhVar3;
    }

    /* access modifiers changed from: package-private */
    public final void a(c cVar) {
        this.j.post(new u(this, cVar));
    }

    public final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.size() != 1) {
                this.f37334d.b("Corrupt bundle received from broadcast.", new Object[0]);
                return;
            }
            c a2 = c.a(bundleExtra, stringArrayList.get(0), this.f37257g, z.f37268a);
            this.f37334d.a("ListenerRegistryBroadcastReceiver.onReceive: %s", a2);
            PendingIntent pendingIntent = (PendingIntent) bundleExtra.getParcelable("confirmation_intent");
            if (pendingIntent != null) {
                this.f37256f.f36990a = pendingIntent;
            }
            this.f37259i.a().execute(new v(this, bundleExtra, a2));
            this.f37258h.a().execute(new w(this, bundleExtra));
            return;
        }
        this.f37334d.b("Empty bundle received from broadcast.", new Object[0]);
    }
}
