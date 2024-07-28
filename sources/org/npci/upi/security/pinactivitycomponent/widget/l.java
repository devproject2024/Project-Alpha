package org.npci.upi.security.pinactivitycomponent.widget;

import android.view.View;
import androidx.core.h.z;

class l extends z {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f73046a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FormItemView f73047b;

    l(FormItemView formItemView, boolean z) {
        this.f73047b = formItemView;
        this.f73046a = z;
    }

    public void onAnimationEnd(View view) {
        super.onAnimationEnd(view);
        view.setVisibility(this.f73046a ? 0 : 8);
    }
}
