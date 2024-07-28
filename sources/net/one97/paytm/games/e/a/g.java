package net.one97.paytm.games.e.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.g.b.k;

public final class g {
    public static final void a(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public static final void b(View view) {
        if (view != null) {
            view.setVisibility(4);
        }
    }

    public static final void c(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public static final View a(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "$this$inflate");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…utId, this, attachToRoot)");
        return inflate;
    }
}
