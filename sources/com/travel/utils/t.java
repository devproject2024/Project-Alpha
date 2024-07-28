package com.travel.utils;

import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;

public final class t {

    public static final class a extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f28554a;

        public a(o oVar) {
            this.f28554a = oVar;
        }

        public final void onClick(View view) {
            k.c(view, "view");
            CharSequence text = ((TextView) view).getText();
            if (text != null) {
                Selection.setSelection((Spannable) text, 0);
                view.invalidate();
                ((View.OnClickListener) this.f28554a.getSecond()).onClick(view);
                return;
            }
            throw new u("null cannot be cast to non-null type android.text.Spannable");
        }
    }

    public static final View a(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "$this$inflate");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…te(layoutId, this, false)");
        return inflate;
    }
}
