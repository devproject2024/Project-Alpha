package com.paytm.android.chat.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.paytm.android.chat.R;
import com.paytm.android.chat.base.BaseActivity;
import com.paytm.android.chat.contact.f;
import com.paytm.android.chat.fragment.h;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import kotlin.g.b.k;

public final class PaytmChatMainActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private final FinishBrocastReceiver f41704a = new FinishBrocastReceiver();

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_paytm_main);
        q a2 = getSupportFragmentManager().a();
        k.a((Object) a2, "supportFragmentManager.beginTransaction()");
        a2.a(R.id.fl_main_container, (Fragment) new h());
        a2.c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.paytm.android.chat.finish");
        registerReceiver(this.f41704a, intentFilter);
    }

    public final void onResume() {
        super.onResume();
        f.a((Context) this).b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        r0 = r0.getChildFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onKeyDown(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            r0 = 4
            if (r4 != r0) goto L_0x0047
            if (r5 == 0) goto L_0x0047
            int r0 = r5.getRepeatCount()
            if (r0 != 0) goto L_0x0047
            androidx.fragment.app.j r0 = r3.getSupportFragmentManager()
            int r1 = com.paytm.android.chat.R.id.fl_main_container
            androidx.fragment.app.Fragment r0 = r0.c((int) r1)
            r1 = 0
            if (r0 == 0) goto L_0x0025
            androidx.fragment.app.j r0 = r0.getChildFragmentManager()
            if (r0 == 0) goto L_0x0025
            int r2 = com.paytm.android.chat.R.id.fl_container
            androidx.fragment.app.Fragment r0 = r0.c((int) r2)
            goto L_0x0026
        L_0x0025:
            r0 = r1
        L_0x0026:
            boolean r2 = r0 instanceof com.paytm.android.chat.fragment.c
            if (r2 != 0) goto L_0x002b
            r0 = r1
        L_0x002b:
            com.paytm.android.chat.fragment.c r0 = (com.paytm.android.chat.fragment.c) r0
            if (r0 == 0) goto L_0x0042
            boolean r1 = r0.isVisible()
            if (r1 == 0) goto L_0x0042
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x003d
            r4 = 0
            return r4
        L_0x003d:
            boolean r4 = super.onKeyDown(r4, r5)
            return r4
        L_0x0042:
            boolean r4 = super.onKeyDown(r4, r5)
            return r4
        L_0x0047:
            boolean r4 = super.onKeyDown(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.activity.PaytmChatMainActivity.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    public final void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f41704a);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 3) {
            SharedPreferencesUtil.updateUserData(this);
            q a2 = getSupportFragmentManager().a();
            k.a((Object) a2, "supportFragmentManager.beginTransaction()");
            a2.b(R.id.fl_main_container, new h());
            a2.c();
        }
    }

    public final class FinishBrocastReceiver extends BroadcastReceiver {
        public FinishBrocastReceiver() {
        }

        public final void onReceive(Context context, Intent intent) {
            PaytmChatMainActivity.this.finish();
        }
    }
}
