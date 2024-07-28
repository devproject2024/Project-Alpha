package net.one97.paytm.wallet.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public final class d {

    /* renamed from: d  reason: collision with root package name */
    private static d f70360d;

    /* renamed from: a  reason: collision with root package name */
    public Context f70361a;

    /* renamed from: b  reason: collision with root package name */
    private IntentFilter f70362b;

    /* renamed from: c  reason: collision with root package name */
    private a f70363c;

    public static d a() {
        if (f70360d == null) {
            f70360d = new d();
        }
        return f70360d;
    }

    public final void a(Context context) {
        try {
            b();
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
        this.f70361a = context;
        this.f70362b = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        this.f70363c = new a();
        c();
    }

    private d() {
    }

    private void c() {
        a aVar = this.f70363c;
        if (aVar != null) {
            this.f70361a.registerReceiver(aVar, this.f70362b);
        }
    }

    public final void b() {
        a aVar;
        Context context = this.f70361a;
        if (!(context == null || (aVar = this.f70363c) == null)) {
            context.unregisterReceiver(aVar);
        }
        this.f70361a = null;
        this.f70363c = null;
    }

    class a extends BroadcastReceiver {
        a() {
        }

        public final void onReceive(Context context, Intent intent) {
            String stringExtra;
            String action = intent.getAction();
            if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(Item.KEY_REASON)) != null) {
                q.b("action:" + action + ",reason:" + stringExtra);
                try {
                    if (stringExtra.equals("homekey")) {
                        if (!WalletSharedPrefs.INSTANCE.issecLockShowing(d.this.f70361a)) {
                            WalletSharedPrefs.INSTANCE.setLockPatternSession(d.this.f70361a, false);
                            WalletSharedPrefs.INSTANCE.setIsAppFromBackground(d.this.f70361a, true);
                        }
                    } else if (stringExtra.equals("recentapps")) {
                        if (!WalletSharedPrefs.INSTANCE.issecLockShowing(d.this.f70361a)) {
                            WalletSharedPrefs.INSTANCE.setLockPatternSession(d.this.f70361a, false);
                        }
                        WalletSharedPrefs.INSTANCE.setIsAppFromBackground(d.this.f70361a, true);
                    }
                } catch (Exception e2) {
                    q.d(String.valueOf(e2));
                }
            }
        }
    }
}
