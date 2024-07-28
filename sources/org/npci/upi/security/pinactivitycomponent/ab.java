package org.npci.upi.security.pinactivitycomponent;

import android.view.View;

class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Keypad f72921a;

    ab(Keypad keypad) {
        this.f72921a = keypad;
    }

    public void onClick(View view) {
        if (this.f72921a.f72919e != null) {
            this.f72921a.f72919e.a(view, 66);
        }
    }
}
