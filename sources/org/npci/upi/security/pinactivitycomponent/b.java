package org.npci.upi.security.pinactivitycomponent;

import android.graphics.drawable.Drawable;
import android.view.View;
import org.npci.upi.security.pinactivitycomponent.widget.a;

class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f72962a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f72963b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f72964c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Drawable f72965d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Drawable f72966e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ a f72967f;

    b(a aVar, a aVar2, String str, String str2, Drawable drawable, Drawable drawable2) {
        this.f72967f = aVar;
        this.f72962a = aVar2;
        this.f72963b = str;
        this.f72964c = str2;
        this.f72965d = drawable;
        this.f72966e = drawable2;
    }

    public void onClick(View view) {
        boolean b2 = this.f72962a.b();
        this.f72962a.a(b2 ? this.f72963b : this.f72964c, b2 ? this.f72965d : this.f72966e, this, 0, true, true);
    }
}
