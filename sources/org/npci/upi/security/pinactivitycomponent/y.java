package org.npci.upi.security.pinactivitycomponent;

import android.view.View;

class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f73049a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Keypad f73050b;

    y(Keypad keypad, int i2) {
        this.f73050b = keypad;
        this.f73049a = i2;
    }

    public void onClick(View view) {
        if (this.f73050b.f72919e != null) {
            this.f73050b.f72919e.a(view, this.f73049a + 7);
        }
    }
}
