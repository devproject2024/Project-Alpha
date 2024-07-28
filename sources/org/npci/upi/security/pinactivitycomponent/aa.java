package org.npci.upi.security.pinactivitycomponent;

import android.view.View;

class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Keypad f72920a;

    aa(Keypad keypad) {
        this.f72920a = keypad;
    }

    public void onClick(View view) {
        if (this.f72920a.f72919e != null) {
            this.f72920a.f72919e.a(view, 7);
        }
    }
}
