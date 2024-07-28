package net.one97.paytm.moneytransfer.c;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import net.one97.paytm.moneytransfer.R;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final View f53734a;

    /* renamed from: b  reason: collision with root package name */
    public final View f53735b;

    /* renamed from: c  reason: collision with root package name */
    public final View f53736c;

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f53737d;

    private e(ConstraintLayout constraintLayout, View view, View view2, View view3) {
        this.f53737d = constraintLayout;
        this.f53734a = view;
        this.f53735b = view2;
        this.f53736c = view3;
    }

    public static e a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.circle);
        if (findViewById != null) {
            View findViewById2 = view.findViewById(R.id.view_1);
            if (findViewById2 != null) {
                View findViewById3 = view.findViewById(R.id.view_2);
                if (findViewById3 != null) {
                    return new e((ConstraintLayout) view, findViewById, findViewById2, findViewById3);
                }
                str = "view2";
            } else {
                str = "view1";
            }
        } else {
            str = "circle";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
