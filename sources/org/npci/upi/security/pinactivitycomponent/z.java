package org.npci.upi.security.pinactivitycomponent;

import android.view.View;

class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Keypad f73051a;

    z(Keypad keypad) {
        this.f73051a = keypad;
    }

    public void onClick(View view) {
        if (this.f73051a.f72919e != null) {
            this.f73051a.f72919e.a(view, 67);
        }
    }
}
