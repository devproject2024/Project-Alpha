package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.moneytransfer.R;

public final class aj {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f53661a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f53662b;

    /* renamed from: c  reason: collision with root package name */
    public final View f53663c;

    /* renamed from: d  reason: collision with root package name */
    public final View f53664d;

    /* renamed from: e  reason: collision with root package name */
    public final View f53665e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f53666f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f53667g;

    private aj(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, View view, View view2, View view3, TextView textView2) {
        this.f53667g = constraintLayout;
        this.f53661a = constraintLayout2;
        this.f53662b = textView;
        this.f53663c = view;
        this.f53664d = view2;
        this.f53665e = view3;
        this.f53666f = textView2;
    }

    public static aj a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.container);
        if (constraintLayout != null) {
            TextView textView = (TextView) view.findViewById(R.id.createNewPin);
            if (textView != null) {
                View findViewById = view.findViewById(R.id.divider1);
                if (findViewById != null) {
                    View findViewById2 = view.findViewById(R.id.divider2);
                    if (findViewById2 != null) {
                        View findViewById3 = view.findViewById(R.id.divider3);
                        if (findViewById3 != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.needHelp);
                            if (textView2 != null) {
                                return new aj((ConstraintLayout) view, constraintLayout, textView, findViewById, findViewById2, findViewById3, textView2);
                            }
                            str = "needHelp";
                        } else {
                            str = "divider3";
                        }
                    } else {
                        str = "divider2";
                    }
                } else {
                    str = "divider1";
                }
            } else {
                str = "createNewPin";
            }
        } else {
            str = "container";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
