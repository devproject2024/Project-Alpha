package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import androidx.core.content.b;
import org.npci.upi.security.pinactivitycomponent.widget.FormItemView;

class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ae f72939a;

    aj(ae aeVar) {
        this.f72939a = aeVar;
    }

    public void run() {
        if (this.f72939a.f72928g != -1 && (this.f72939a.f72927f.get(this.f72939a.f72928g) instanceof FormItemView)) {
            FormItemView formItemView = (FormItemView) this.f72939a.f72927f.get(this.f72939a.f72928g);
            formItemView.a(false);
            formItemView.a(this.f72939a.getString(R.string.action_resend), b.a((Context) this.f72939a.getActivity(), R.drawable.ic_action_reload), new ak(this, formItemView), 0, true, true);
        }
    }
}
