package org.npci.upi.security.pinactivitycomponent;

import android.view.View;

class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GetCredential f72998a;

    p(GetCredential getCredential) {
        this.f72998a = getCredential;
    }

    public void onClick(View view) {
        GetCredential getCredential = this.f72998a;
        getCredential.toggleTransactionDetails(!getCredential.isTransactionDetailsExpanded());
    }
}
