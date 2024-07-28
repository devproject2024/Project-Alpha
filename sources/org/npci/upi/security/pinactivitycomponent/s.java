package org.npci.upi.security.pinactivitycomponent;

import android.view.MotionEvent;
import android.view.View;

class s implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GetCredential f73000a;

    s(GetCredential getCredential) {
        this.f73000a = getCredential;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 || !this.f73000a.isTransactionDetailsExpanded()) {
            return false;
        }
        this.f73000a.toggleTransactionDetails(false);
        return true;
    }
}
