package net.one97.paytm.upi.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.upi.R;

public final class aa {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f66725a;

    /* renamed from: b  reason: collision with root package name */
    public final CardView f66726b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f66727c;

    private aa(ConstraintLayout constraintLayout, TextView textView, CardView cardView) {
        this.f66727c = constraintLayout;
        this.f66725a = textView;
        this.f66726b = cardView;
    }

    public final ConstraintLayout a() {
        return this.f66727c;
    }

    public static aa a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.payment_day_mandate_item_view, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.dayNumber);
        if (textView != null) {
            CardView cardView = (CardView) inflate.findViewById(R.id.paymentDayCard);
            if (cardView != null) {
                return new aa((ConstraintLayout) inflate, textView, cardView);
            }
            str = "paymentDayCard";
        } else {
            str = "dayNumber";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
