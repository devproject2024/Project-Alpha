package net.one97.paytm.passbook.main.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import kotlin.g.b.k;

public final class GenericCustomView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f57838a;

    public final View getMView() {
        View view = this.f57838a;
        if (view == null) {
            k.a("mView");
        }
        return view;
    }

    public final void setMView(View view) {
        k.c(view, "<set-?>");
        this.f57838a = view;
    }

    private final void setView(int i2) {
        View inflate = LayoutInflater.from(getContext()).inflate(i2, this, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…late(layout, this, false)");
        this.f57838a = inflate;
        removeAllViews();
        View view = this.f57838a;
        if (view == null) {
            k.a("mView");
        }
        addView(view);
    }
}
