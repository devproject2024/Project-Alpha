package org.npci.upi.security.pinactivitycomponent;

import android.view.View;

class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GetCredential f72995a;

    m(GetCredential getCredential) {
        this.f72995a = getCredential;
    }

    public void onClick(View view) {
        this.f72995a.goBack();
    }
}
