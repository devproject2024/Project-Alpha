package com.travel.bus.busticket.busfilter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import kotlin.g.b.k;

public final class d {
    public static final View a(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "$this$inflate");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…tRes, this, attachToRoot)");
        return inflate;
    }

    public static final void a(EditText editText) {
        k.c(editText, "$this$clearSearch");
        editText.setText("");
    }
}
