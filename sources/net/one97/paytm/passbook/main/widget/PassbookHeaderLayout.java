package net.one97.paytm.passbook.main.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.b;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;

public final class PassbookHeaderLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f57848a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f57849b;

    public final View getMView() {
        View view = this.f57848a;
        if (view == null) {
            k.a("mView");
        }
        return view;
    }

    public final void setMView(View view) {
        k.c(view, "<set-?>");
        this.f57848a = view;
    }

    public final void setHeader(boolean z) {
        this.f57849b = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassbookHeaderLayout(Context context, int i2) {
        super(context, (AttributeSet) null);
        k.c(context, "context");
        setView(i2);
    }

    private final void setView(int i2) {
        View inflate = LayoutInflater.from(getContext()).inflate(i2, this, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…late(layout, this, false)");
        this.f57848a = inflate;
        removeAllViews();
        View view = this.f57848a;
        if (view == null) {
            k.a("mView");
        }
        addView(view);
    }

    public final void setCustomBackgroundColor(Integer num) {
        if (num != null) {
            num.intValue();
            View view = this.f57848a;
            if (view == null) {
                k.a("mView");
            }
            view.setBackgroundColor(b.c(getContext(), num.intValue()));
            return;
        }
        PassbookHeaderLayout passbookHeaderLayout = this;
        View view2 = passbookHeaderLayout.f57848a;
        if (view2 == null) {
            k.a("mView");
        }
        view2.setBackgroundColor(b.c(passbookHeaderLayout.getContext(), R.color.color_fafafa));
    }
}
