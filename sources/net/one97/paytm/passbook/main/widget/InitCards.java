package net.one97.paytm.passbook.main.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.b;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;

public final class InitCards extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f57839a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f57840b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f57841c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f57842d;

    public final View a(int i2) {
        if (this.f57842d == null) {
            this.f57842d = new HashMap();
        }
        View view = (View) this.f57842d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f57842d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View getMView() {
        View view = this.f57839a;
        if (view == null) {
            k.a("mView");
        }
        return view;
    }

    public final void setMView(View view) {
        k.c(view, "<set-?>");
        this.f57839a = view;
    }

    public final void setHeader(boolean z) {
        this.f57840b = z;
    }

    public final boolean getShouldHighlight() {
        return this.f57841c;
    }

    public final void setShouldHighlight(boolean z) {
        this.f57841c = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InitCards(Context context, int i2) {
        super(context, (AttributeSet) null);
        k.c(context, "context");
        setView(i2);
    }

    private final void setView(int i2) {
        View inflate = LayoutInflater.from(getContext()).inflate(i2, this, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…late(layout, this, false)");
        this.f57839a = inflate;
        removeAllViews();
        View view = this.f57839a;
        if (view == null) {
            k.a("mView");
        }
        addView(view);
    }

    public final void setCustomBackgroundColor(Integer num) {
        if (num != null) {
            num.intValue();
            View view = this.f57839a;
            if (view == null) {
                k.a("mView");
            }
            view.setBackgroundColor(b.c(getContext(), num.intValue()));
            return;
        }
        InitCards initCards = this;
        View view2 = initCards.f57839a;
        if (view2 == null) {
            k.a("mView");
        }
        view2.setBackgroundColor(b.c(initCards.getContext(), R.color.color_fafafa));
    }
}
