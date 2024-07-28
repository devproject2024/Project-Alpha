package net.one97.paytm.passbook.main.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.b;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;

public final class ExpandableBalanceCardView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f57834a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f57835b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f57836c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f57837d;

    public final View a(int i2) {
        if (this.f57837d == null) {
            this.f57837d = new HashMap();
        }
        View view = (View) this.f57837d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f57837d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View getMView() {
        View view = this.f57834a;
        if (view == null) {
            k.a("mView");
        }
        return view;
    }

    public final void setMView(View view) {
        k.c(view, "<set-?>");
        this.f57834a = view;
    }

    public final void setHeader(boolean z) {
        this.f57835b = z;
    }

    public final boolean getShouldHighlight() {
        return this.f57836c;
    }

    public final void setShouldHighlight(boolean z) {
        this.f57836c = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandableBalanceCardView(Context context) {
        super(context);
        k.c(context, "context");
        setView(R.layout.pass_balance_expendable_card_view);
    }

    private final void setView(int i2) {
        View inflate = LayoutInflater.from(getContext()).inflate(i2, this, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…late(layout, this, false)");
        this.f57834a = inflate;
        removeAllViews();
        View view = this.f57834a;
        if (view == null) {
            k.a("mView");
        }
        addView(view);
    }

    public final void setIcon(int i2) {
        View view = this.f57834a;
        if (view == null) {
            k.a("mView");
        }
        ((AppCompatImageView) view.findViewById(R.id.ivWalletIcon)).setImageResource(i2);
    }

    public final void setCustomBackgroundColor(Integer num) {
        if (num != null) {
            num.intValue();
            View view = this.f57834a;
            if (view == null) {
                k.a("mView");
            }
            view.setBackgroundColor(b.c(getContext(), num.intValue()));
            return;
        }
        ExpandableBalanceCardView expandableBalanceCardView = this;
        View view2 = expandableBalanceCardView.f57834a;
        if (view2 == null) {
            k.a("mView");
        }
        view2.setBackgroundColor(b.c(expandableBalanceCardView.getContext(), R.color.color_fafafa));
    }
}
