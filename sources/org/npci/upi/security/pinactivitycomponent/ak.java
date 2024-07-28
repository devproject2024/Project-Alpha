package org.npci.upi.security.pinactivitycomponent;

import android.os.Bundle;
import android.view.View;
import org.npci.upi.security.pinactivitycomponent.widget.FormItemView;

class ak implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FormItemView f72940a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ aj f72941b;

    ak(aj ajVar, FormItemView formItemView) {
        this.f72941b = ajVar;
        this.f72940a = formItemView;
    }

    public void onClick(View view) {
        this.f72941b.f72939a.a(this.f72940a);
        Bundle bundle = new Bundle();
        bundle.putString("action", "TRIGGER_OTP");
        ((GetCredential) this.f72941b.f72939a.p).getCLContext().d().send(2, bundle);
    }
}
