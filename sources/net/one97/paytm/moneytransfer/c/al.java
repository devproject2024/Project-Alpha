package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.TextView;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.tooltip.TooltipView;

public final class al {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f53677a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f53678b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f53679c;

    /* renamed from: d  reason: collision with root package name */
    public final TooltipView f53680d;

    /* renamed from: e  reason: collision with root package name */
    private final TooltipView f53681e;

    private al(TooltipView tooltipView, TextView textView, TextView textView2, TextView textView3, TooltipView tooltipView2) {
        this.f53681e = tooltipView;
        this.f53677a = textView;
        this.f53678b = textView2;
        this.f53679c = textView3;
        this.f53680d = tooltipView2;
    }

    public static al a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.ctaLink);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.heading);
            if (textView2 != null) {
                TextView textView3 = (TextView) view.findViewById(R.id.message);
                if (textView3 != null) {
                    TooltipView tooltipView = (TooltipView) view.findViewById(R.id.root);
                    if (tooltipView != null) {
                        return new al((TooltipView) view, textView, textView2, textView3, tooltipView);
                    }
                    str = "root";
                } else {
                    str = "message";
                }
            } else {
                str = "heading";
            }
        } else {
            str = "ctaLink";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
