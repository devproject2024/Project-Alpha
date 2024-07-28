package net.one97.paytm.oauth.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.c;
import kotlin.g.b.k;

public final class h {
    public static final View a(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "receiver$0");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…layoutResId, this, false)");
        return inflate;
    }

    public static final void a(View view) {
        k.c(view, "receiver$0");
        view.setVisibility(0);
    }

    public static final void b(View view) {
        k.c(view, "receiver$0");
        view.setVisibility(8);
    }

    public static final void a(c cVar, View view, View view2) {
        k.c(cVar, "receiver$0");
        k.c(view, "view");
        k.c(view2, "parentView");
        cVar.a(view.getId(), 3, view2.getId(), 3);
        cVar.a(view.getId(), 6, view2.getId(), 6);
        cVar.a(view.getId(), 7, view2.getId(), 7);
        cVar.a(view.getId(), 4, view2.getId(), 4);
    }
}
