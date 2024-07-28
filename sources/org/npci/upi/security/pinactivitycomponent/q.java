package org.npci.upi.security.pinactivitycomponent;

import android.view.MotionEvent;
import android.view.View;

class q implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GetCredential f72999a;

    q(GetCredential getCredential) {
        this.f72999a = getCredential;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() != R.id.transaction_details_scroller || motionEvent.getAction() != 1 || !this.f72999a.isTransactionDetailsExpanded()) {
            return false;
        }
        this.f72999a.toggleTransactionDetails(false);
        return true;
    }
}
