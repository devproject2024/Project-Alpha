package org.npci.upi.security.pinactivitycomponent;

import android.view.KeyEvent;
import android.view.View;

class o implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GetCredential f72997a;

    o(GetCredential getCredential) {
        this.f72997a = getCredential;
    }

    public void a(View view, int i2) {
        this.f72997a.dispatchKeyEvent(new KeyEvent(0, i2));
        if (i2 == 66 && this.f72997a.currentFragment != null) {
            this.f72997a.currentFragment.a();
        }
    }
}
