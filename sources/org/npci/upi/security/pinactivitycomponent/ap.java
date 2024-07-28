package org.npci.upi.security.pinactivitycomponent;

import android.graphics.drawable.Drawable;
import android.view.View;
import org.npci.upi.security.pinactivitycomponent.widget.a;

class ap implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f72951a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f72952b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f72953c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Drawable f72954d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Drawable f72955e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ ao f72956f;

    ap(ao aoVar, a aVar, String str, String str2, Drawable drawable, Drawable drawable2) {
        this.f72956f = aoVar;
        this.f72951a = aVar;
        this.f72952b = str;
        this.f72953c = str2;
        this.f72954d = drawable;
        this.f72955e = drawable2;
    }

    public void onClick(View view) {
        boolean b2 = this.f72951a.b();
        this.f72951a.a(b2 ? this.f72952b : this.f72953c, b2 ? this.f72954d : this.f72955e, this, 0, true, true);
    }
}
