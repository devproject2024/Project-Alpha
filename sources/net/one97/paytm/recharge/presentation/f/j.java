package net.one97.paytm.recharge.presentation.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionHistory;

public final class j extends f {

    /* renamed from: a  reason: collision with root package name */
    private TextView f64889a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f64890b;

    /* renamed from: c  reason: collision with root package name */
    private View f64891c;

    /* renamed from: d  reason: collision with root package name */
    private View f64892d;

    /* renamed from: e  reason: collision with root package name */
    private int f64893e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(View view, int i2) {
        super(view);
        k.c(view, "itemView");
        this.f64893e = i2;
        View findViewById = view.findViewById(R.id.txt_payment_date);
        if (findViewById != null) {
            this.f64890b = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.txt_payment_msg);
            if (findViewById2 != null) {
                this.f64889a = (TextView) findViewById2;
                this.f64891c = view.findViewById(R.id.ic_payment_status_icon);
                this.f64892d = view.findViewById(R.id.view_line);
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public final <T> void a(T t) {
        View view;
        if (t != null && (t instanceof CJRAutomaticSubscriptionHistory)) {
            CJRAutomaticSubscriptionHistory cJRAutomaticSubscriptionHistory = (CJRAutomaticSubscriptionHistory) t;
            if (cJRAutomaticSubscriptionHistory.getPosition() == this.f64893e - 1 && (view = this.f64892d) != null) {
                view.setVisibility(8);
            }
            TextView textView = this.f64889a;
            if (textView != null) {
                View view2 = this.itemView;
                k.a((Object) view2, "itemView");
                Context context = view2.getContext();
                k.a((Object) context, "itemView.context");
                textView.setText(cJRAutomaticSubscriptionHistory.getPaymentText(context));
            }
            TextView textView2 = this.f64890b;
            if (textView2 != null) {
                textView2.setText(cJRAutomaticSubscriptionHistory.getDate());
            }
            View view3 = this.f64891c;
            Drawable background = view3 != null ? view3.getBackground() : null;
            if (background != null) {
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                Integer statusIconBackGround = cJRAutomaticSubscriptionHistory.getStatusIconBackGround();
                if (statusIconBackGround == null) {
                    k.a();
                }
                gradientDrawable.setColor(statusIconBackGround.intValue());
                return;
            }
            throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
    }
}
