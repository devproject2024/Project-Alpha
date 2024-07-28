package org.npci.upi.security.pinactivitycomponent.widget;

import android.view.MotionEvent;
import android.view.View;

class k implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FormItemView f73045a;

    k(FormItemView formItemView) {
        this.f73045a = formItemView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f73045a.f73033g == null || motionEvent.getAction() != 1) {
            return false;
        }
        this.f73045a.f73033g.a(this.f73045a.f73034h);
        return false;
    }
}
